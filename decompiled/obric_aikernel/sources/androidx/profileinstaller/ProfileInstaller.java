package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = null;

    @NonNull
    static final DiagnosticsCallback LOG_DIAGNOSTICS = null;
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int r10, @Nullable Object r11);

        void onResultReceived(int r10, @Nullable Object r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ResultCode {
    }

    static {
        EMPTY_DIAGNOSTICS = new AnonymousClass1();
        LOG_DIAGNOSTICS = new AnonymousClass2();
    }

    private ProfileInstaller() {
    }

    public static /* synthetic */ void a(DiagnosticsCallback r10, int r11, Object r12) {
        lambda$diagnostic$1(r10, r11, r12);
    }

    public static /* synthetic */ void b(DiagnosticsCallback r10, int r11, Object r12) {
        lambda$result$0(r10, r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean deleteProfileWrittenFor(@NonNull File r10) {
        return new File(r10, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    @WorkerThread
    static void deleteSkipFile(@NonNull Context r10, @NonNull Executor r11, @NonNull DiagnosticsCallback r12) {
        deleteProfileWrittenFor(r10.getFilesDir());
        result(r11, r12, 11, null);
    }

    static void diagnostic(@NonNull Executor r10, @NonNull final DiagnosticsCallback r11, final int r12, @Nullable final Object r13) {
        r10.execute(new c(r11, r12, r13));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo r10, File r11, DiagnosticsCallback r12) {
        File r13 = new File(r11, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean r14 = false;
        if (r13.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r15 = new DataInputStream(new FileInputStream(r13));     // Catch: IOException -> L20
        long r16 = r15.readLong();     // Catch: Throwable -> L14
        r15.close();     // Catch: IOException -> L20
        if (r16 != r10.lastUpdateTime) goto L11;
        r14 = true;
    L11:
        if (r14 == false) goto L13;
        r12.onResultReceived(2, null);
    L13:
        return r14;
    L14:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    private static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback r10, int r11, Object r12) {
        r10.onDiagnosticReceived(r11, r12);
    }

    private static /* synthetic */ void lambda$result$0(DiagnosticsCallback r10, int r11, Object r12) {
        r10.onResultReceived(r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static void noteProfileWrittenFor(@NonNull PackageInfo r10, @NonNull File r11) {
        DataOutputStream r12 = new DataOutputStream(new FileOutputStream(new File(r11, PROFILE_INSTALLER_SKIP_FILE_NAME)));     // Catch: IOException -> L14
        r12.writeLong(r10.lastUpdateTime);     // Catch: Throwable -> L7
        r12.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    static void result(@NonNull Executor r10, @NonNull final DiagnosticsCallback r11, final int r12, @Nullable final Object r13) {
        r10.execute(new d(r11, r12, r13));
    }

    private static boolean transcodeAndWrite(@NonNull AssetManager r11, @NonNull String r12, @NonNull PackageInfo r13, @NonNull File r14, @NonNull String r15, @NonNull Executor r16, @NonNull DiagnosticsCallback r17) {
        if (Build.VERSION.SDK_INT >= 19) goto L6;
        result(r16, r17, 3, null);
        return false;
    L6:
        DeviceProfileWriter r10 = new DeviceProfileWriter(r11, r16, r17, r15, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, r12), PROFILE_FILE));
        if (r10.deviceAllowsProfileInstallerAotWrites() == true) goto L9;
        return false;
    L9:
        boolean r18 = r10.read().transcodeIfNeeded().write();
        if (r18 == false) goto L12;
        noteProfileWrittenFor(r13, r14);
    L12:
        return r18;
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context r10) {
        writeProfile(r10, b.f393c, EMPTY_DIAGNOSTICS);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context r10, @NonNull Executor r11, @NonNull DiagnosticsCallback r12) {
        writeProfile(r10, r11, r12, false);
    }

    @WorkerThread
    static void writeProfile(@NonNull Context r10, @NonNull Executor r11, @NonNull DiagnosticsCallback r12, boolean r13) {
        Context r14 = r10.getApplicationContext();
        String r15 = r14.getPackageName();
        ApplicationInfo r16 = r14.getApplicationInfo();
        AssetManager r17 = r14.getAssets();
        String r18 = new File(r16.sourceDir).getName();
        boolean r19 = false;
        PackageInfo r20 = r10.getPackageManager().getPackageInfo(r15, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r21 = r10.getFilesDir();
        if (r13 == false) goto L7;
    L11:
        Log.d(TAG, "Installing profile for " + r10.getPackageName());
        if (transcodeAndWrite(r17, r15, r20, r21, r18, r11, r12) == true) goto L13;
    L10:
        ProfileVerifier.writeProfileVerification(r10, r19);
        return;
    L13:
        if (r13 == false) goto L10;
        r19 = true;
        goto L10
    L7:
        if (hasAlreadyWrittenProfileForThisInstall(r20, r21, r12) == false) goto L11;
        Log.d(TAG, "Skipping profile installation for " + r10.getPackageName());
    L16:
        e = move-exception;
        r12.onResultReceived(7, e);
        ProfileVerifier.writeProfileVerification(r10, false);
    }

    @WorkerThread
    static void writeSkipFile(@NonNull Context r10, @NonNull Executor r11, @NonNull DiagnosticsCallback r12) {
        String r13 = r10.getApplicationContext().getPackageName();
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r13, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        noteProfileWrittenFor(r14, r10.getFilesDir());
        result(r11, r12, 10, null);
        return;
    L6:
        e = move-exception;
        result(r11, r12, 7, e);
    }
}
