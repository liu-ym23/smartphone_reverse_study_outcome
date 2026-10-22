package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = null;
    static final DiagnosticsCallback LOG_DIAGNOSTICS = null;
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
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

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int r1, Object r2);

        void onResultReceived(int r1, Object r2);
    }

    private ProfileInstaller() {
    }

    public static /* synthetic */ void a(DiagnosticsCallback r0, int r1, Object r2) {
        lambda$diagnostic$1(r0, r1, r2);
    }

    public static /* synthetic */ void b(DiagnosticsCallback r0, int r1, Object r2) {
        lambda$result$0(r0, r1, r2);
    }

    static {
        EMPTY_DIAGNOSTICS = new AnonymousClass1();
        LOG_DIAGNOSTICS = new AnonymousClass2();
    }

    public static boolean deleteProfileWrittenFor(File r2) {
        return new File(r2, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    public static void writeProfile(Context r2) {
        writeProfile(r2, new b(), EMPTY_DIAGNOSTICS);
    }

    public static void noteProfileWrittenFor(PackageInfo r2, File r3) {
        DataOutputStream r4 = new DataOutputStream(new FileOutputStream(new File(r3, PROFILE_INSTALLER_SKIP_FILE_NAME)));     // Catch: IOException -> L14
        r4.writeLong(r2.lastUpdateTime);     // Catch: Throwable -> L7
        r4.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    public static void deleteSkipFile(Context r1, Executor r2, DiagnosticsCallback r3) {
        deleteProfileWrittenFor(r1.getFilesDir());
        result(r2, r3, 11, null);
    }

    public static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo r4, File r5, DiagnosticsCallback r6) {
        File r0 = new File(r5, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean r1 = false;
        if (r0.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r7 = new DataInputStream(new FileInputStream(r0));     // Catch: IOException -> L20
        long r2 = r7.readLong();     // Catch: Throwable -> L14
        r7.close();     // Catch: IOException -> L20
        if (r2 != r4.lastUpdateTime) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        r6.onResultReceived(2, null);
    L13:
        return r1;
    L14:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    private static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback r0, int r1, Object r2) {
        r0.onDiagnosticReceived(r1, r2);
    }

    private static /* synthetic */ void lambda$result$0(DiagnosticsCallback r0, int r1, Object r2) {
        r0.onResultReceived(r1, r2);
    }

    public static void writeProfile(Context r1, Executor r2, DiagnosticsCallback r3) {
        writeProfile(r1, r2, r3, false);
    }

    public static void writeSkipFile(Context r3, Executor r4, DiagnosticsCallback r5) {
        String r0 = r3.getApplicationContext().getPackageName();
        PackageInfo r1 = r3.getPackageManager().getPackageInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        noteProfileWrittenFor(r1, r3.getFilesDir());
        result(r4, r5, 10, null);
        return;
    L6:
        e = move-exception;
        result(r4, r5, 7, e);
    }

    public static void diagnostic(Executor r1, DiagnosticsCallback r2, int r3, Object r4) {
        r1.execute(new d(r2, r3, r4));
    }

    public static void result(Executor r1, final DiagnosticsCallback r2, final int r3, final Object r4) {
        r1.execute(new c(r2, r3, r4));
    }

    public static void writeProfile(Context r9, Executor r10, DiagnosticsCallback r11, boolean r12) {
        Context r0 = r9.getApplicationContext();
        String r2 = r0.getPackageName();
        ApplicationInfo r1 = r0.getApplicationInfo();
        AssetManager r3 = r0.getAssets();
        String r5 = new File(r1.sourceDir).getName();
        boolean r8 = false;
        PackageInfo r4 = r9.getPackageManager().getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r6 = r9.getFilesDir();
        if (r12 == false) goto L7;
    L10:
        r9.getPackageName();
        if (transcodeAndWrite(r3, r2, r4, r6, r5, r10, r11) == false) goto L14;
        if (r12 == false) goto L14;
        r8 = true;
    L14:
        ProfileVerifier.writeProfileVerification(r9, r8);
        return;
    L7:
        if (hasAlreadyWrittenProfileForThisInstall(r4, r6, r11) == false) goto L10;
        r9.getPackageName();
        ProfileVerifier.writeProfileVerification(r9, false);
        return;
    L16:
        e = move-exception;
        r11.onResultReceived(7, e);
        ProfileVerifier.writeProfileVerification(r9, false);
    }

    private static boolean transcodeAndWrite(AssetManager r8, String r9, PackageInfo r10, File r11, String r12, Executor r13, DiagnosticsCallback r14) {
        DeviceProfileWriter r15 = new DeviceProfileWriter(r8, r13, r14, r12, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, r9), PROFILE_FILE));
        if (r15.deviceAllowsProfileInstallerAotWrites() == true) goto L6;
        return false;
    L6:
        boolean r16 = r15.read().transcodeIfNeeded().write();
        if (r16 == false) goto L9;
        noteProfileWrittenFor(r10, r11);
    L9:
        return r16;
    }
}
