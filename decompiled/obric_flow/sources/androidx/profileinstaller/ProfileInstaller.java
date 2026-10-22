package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
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
        void onDiagnosticReceived(int r5, @Nullable Object r10);

        void onResultReceived(int r5, @Nullable Object r10);
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

    public static /* synthetic */ void a(DiagnosticsCallback r5, int r10, Object r11) {
        lambda$result$0(r5, r10, r11);
    }

    public static /* synthetic */ void b(DiagnosticsCallback r5, int r10, Object r11) {
        lambda$diagnostic$1(r5, r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean deleteProfileWrittenFor(@NonNull File r5) {
        return new File(r5, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    @WorkerThread
    public static void deleteSkipFile(@NonNull Context r5, @NonNull Executor r10, @NonNull DiagnosticsCallback r11) {
        deleteProfileWrittenFor(r5.getFilesDir());
        result(r10, r11, 11, null);
    }

    public static void diagnostic(@NonNull Executor r5, @NonNull DiagnosticsCallback r10, int r11, @Nullable Object r12) {
        r5.execute(new b(r10, r11, r12, 1));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo r5, File r10, DiagnosticsCallback r11) {
        File r12 = new File(r10, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean r13 = false;
        if (r12.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r14 = new DataInputStream(new FileInputStream(r12));     // Catch: IOException -> L20
        long r15 = r14.readLong();     // Catch: Throwable -> L14
        r14.close();     // Catch: IOException -> L20
        if (r15 != r5.lastUpdateTime) goto L11;
        r13 = true;
    L11:
        if (r13 == false) goto L13;
        r11.onResultReceived(2, null);
    L13:
        return r13;
    L14:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    private static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback r5, int r10, Object r11) {
        r5.onDiagnosticReceived(r10, r11);
    }

    private static /* synthetic */ void lambda$result$0(DiagnosticsCallback r5, int r10, Object r11) {
        r5.onResultReceived(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void noteProfileWrittenFor(@NonNull PackageInfo r5, @NonNull File r10) {
        DataOutputStream r11 = new DataOutputStream(new FileOutputStream(new File(r10, PROFILE_INSTALLER_SKIP_FILE_NAME)));     // Catch: IOException -> L14
        r11.writeLong(r5.lastUpdateTime);     // Catch: Throwable -> L7
        r11.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    public static void result(@NonNull Executor r5, @NonNull DiagnosticsCallback r10, int r11, @Nullable Object r12) {
        r5.execute(new b(r10, r11, r12, 0));
    }

    private static boolean transcodeAndWrite(@NonNull AssetManager r10, @NonNull String r11, @NonNull PackageInfo r12, @NonNull File r13, @NonNull String r14, @NonNull Executor r15, @NonNull DiagnosticsCallback r16) {
        DeviceProfileWriter r17 = new DeviceProfileWriter(r10, r15, r16, r14, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, r11), PROFILE_FILE));
        if (r17.deviceAllowsProfileInstallerAotWrites() == true) goto L6;
        return false;
    L6:
        boolean r18 = r17.read().transcodeIfNeeded().write();
        if (r18 == false) goto L9;
        noteProfileWrittenFor(r12, r13);
    L9:
        return r18;
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context r5) {
        writeProfile(r5, new androidx.arch.core.executor.a(2), EMPTY_DIAGNOSTICS);
    }

    @WorkerThread
    public static void writeSkipFile(@NonNull Context r5, @NonNull Executor r10, @NonNull DiagnosticsCallback r11) {
        String r12 = r5.getApplicationContext().getPackageName();
        PackageInfo r13 = r5.getPackageManager().getPackageInfo(r12, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        noteProfileWrittenFor(r13, r5.getFilesDir());
        result(r10, r11, 10, null);
        return;
    L6:
        e = move-exception;
        result(r10, r11, 7, e);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context r5, @NonNull Executor r10, @NonNull DiagnosticsCallback r11) {
        writeProfile(r5, r10, r11, false);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context r10, @NonNull Executor r11, @NonNull DiagnosticsCallback r12, boolean r13) {
        Context r5 = r10.getApplicationContext();
        String r14 = r5.getPackageName();
        ApplicationInfo r15 = r5.getApplicationInfo();
        AssetManager r16 = r5.getAssets();
        String r17 = new File(r15.sourceDir).getName();
        boolean r18 = false;
        PackageInfo r19 = r10.getPackageManager().getPackageInfo(r14, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r20 = r10.getFilesDir();
        if (r13 == false) goto L7;
    L10:
        Log.d(TAG, "Installing profile for " + r10.getPackageName());
        if (transcodeAndWrite(r16, r14, r19, r20, r17, r11, r12) == false) goto L14;
        if (r13 == false) goto L14;
        r18 = true;
    L14:
        ProfileVerifier.writeProfileVerification(r10, r18);
        return;
    L7:
        if (hasAlreadyWrittenProfileForThisInstall(r19, r20, r12) == false) goto L10;
        Log.d(TAG, "Skipping profile installation for " + r10.getPackageName());
        ProfileVerifier.writeProfileVerification(r10, false);
        return;
    L16:
        e = move-exception;
        r12.onResultReceived(7, e);
        ProfileVerifier.writeProfileVerification(r10, false);
    }
}
