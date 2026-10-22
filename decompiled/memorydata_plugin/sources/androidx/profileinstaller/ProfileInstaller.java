package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int r1, Object r2);

        void onResultReceived(int r1, Object r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    static {
        EMPTY_DIAGNOSTICS = new AnonymousClass1();
        LOG_DIAGNOSTICS = new AnonymousClass2();
    }

    private ProfileInstaller() {
    }

    static boolean deleteProfileWrittenFor(File r2) {
        return new File(r2, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    static void deleteSkipFile(Context r2, Executor r3, DiagnosticsCallback r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        DiagnosticsCallback r7 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r4, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        deleteProfileWrittenFor(r5.getFilesDir());
        result(r6, r7, 11, null);
    }

    static void diagnostic(Executor r2, DiagnosticsCallback r3, final int r4, final Object r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        final DiagnosticsCallback r7 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r3, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        r6.execute(new $$Lambda$ProfileInstaller$iHnuUYEYFyPsnqaxqpFGpzQNiIg(r7, r4, r5));
    }

    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo r4, File r5, DiagnosticsCallback r6) {
        DiagnosticsCallback r7 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r6, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        File r0 = new File(r5, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean r1 = false;
        if (r0.exists() == true) goto L21;
        return false;
    L21:
        DataInputStream r8 = new DataInputStream(new FileInputStream(r0));     // Catch: IOException -> L20
        long r2 = r8.readLong();     // Catch: Throwable -> L14
        r8.close();     // Catch: IOException -> L20
        if (r2 != r4.lastUpdateTime) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        r7.onResultReceived(2, null);
    L13:
        return r1;
    L14:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IOException -> L20
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        return false;
    }

    static /* synthetic */ void lambda$diagnostic$1(DiagnosticsCallback r2, int r3, Object r4) {
        ((DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r2, DiagnosticsCallback.class, "com.obric.memorydata.plugin")).onDiagnosticReceived(r3, r4);
    }

    static /* synthetic */ void lambda$result$0(DiagnosticsCallback r2, int r3, Object r4) {
        ((DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r2, DiagnosticsCallback.class, "com.obric.memorydata.plugin")).onResultReceived(r3, r4);
    }

    static void noteProfileWrittenFor(PackageInfo r2, File r3) {
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

    static void result(Executor r2, DiagnosticsCallback r3, final int r4, final Object r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        final DiagnosticsCallback r7 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r3, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        r6.execute(new $$Lambda$ProfileInstaller$lAFgOixnKjpoenploWSedI8N01U(r7, r4, r5));
    }

    private static boolean transcodeAndWrite(AssetManager r10, String r11, PackageInfo r12, File r13, String r14, Executor r15, DiagnosticsCallback r16) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r15, Executor.class, "com.obric.memorydata.plugin");
        DiagnosticsCallback r5 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r16, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L6;
        result(r4, r5, 3, null);
        return false;
    L6:
        DeviceProfileWriter r0 = new DeviceProfileWriter(r10, r4, r5, r14, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, r11), PROFILE_FILE));
        if (r0.deviceAllowsProfileInstallerAotWrites() == true) goto L9;
        return false;
    L9:
        boolean r1 = r0.read().transcodeIfNeeded().write();
        if (r1 == false) goto L12;
        noteProfileWrittenFor(r12, r13);
    L12:
        return r1;
    }

    public static void writeProfile(Context r2) {
        writeProfile((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, EMPTY_DIAGNOSTICS);
    }

    public static void writeProfile(Context r2, Executor r3, DiagnosticsCallback r4) {
        writeProfile((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"), (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r4, DiagnosticsCallback.class, "com.obric.memorydata.plugin"), false);
    }

    static void writeProfile(Context r9, Executor r10, DiagnosticsCallback r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        DiagnosticsCallback r8 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r11, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        String r3 = r14.getPackageName();
        ApplicationInfo r15 = r14.getApplicationInfo();
        AssetManager r2 = r14.getAssets();
        String r6 = new File(r15.sourceDir).getName();
        boolean r16 = false;
        PackageInfo r4 = r13.getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        File r5 = r13.getFilesDir();
        if (r12 == false) goto L7;
    L11:
        Log.d(TAG, "Installing profile for " + r13.getPackageName());
        if (transcodeAndWrite(r2, r3, r4, r5, r6, r7, r8) == true) goto L13;
    L10:
        ProfileVerifier.writeProfileVerification(r13, r16);
        return;
    L13:
        if (r12 == false) goto L10;
        r16 = true;
        goto L10
    L7:
        if (hasAlreadyWrittenProfileForThisInstall(r4, r5, r8) == false) goto L11;
        Log.d(TAG, "Skipping profile installation for " + r13.getPackageName());
    L16:
        e = move-exception;
        r8.onResultReceived(7, e);
        ProfileVerifier.writeProfileVerification(r13, false);
    }

    static void writeSkipFile(Context r3, Executor r4, DiagnosticsCallback r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        DiagnosticsCallback r8 = (DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r5, DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        PackageInfo r1 = r6.getPackageManager().getPackageInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        noteProfileWrittenFor(r1, r6.getFilesDir());
        result(r7, r8, 10, null);
        return;
    L6:
        e = move-exception;
        result(r7, r8, 7, e);
    }
}
