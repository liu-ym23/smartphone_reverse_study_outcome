package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture = null;

    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager r2, Context r3) {
            return r2.getPackageInfo(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int r1, int r2, long r3, long r5) {
            this.mSchema = r1;
            this.mResultCode = r2;
            this.mPackageLastUpdateTime = r3;
            this.mInstalledCurrentProfileSize = r5;
        }

        static Cache readFromFile(File r9) {
            DataInputStream r0 = new DataInputStream(new FileInputStream(r9));
            Cache r10 = new Cache(r0.readInt(), r0.readInt(), r0.readLong(), r0.readLong());     // Catch: Throwable -> L6
            r0.close();
            return r10;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L21:
            return false;
        L8:
            if (ZeusTransformUtils.instanceOf(r8, Cache.class) == false) goto L21;
            Cache r9 = (Cache) ZeusTransformUtils.preCheckCast(r8, Cache.class, "com.obric.memorydata.plugin");
            if (this.mResultCode != r9.mResultCode) goto L20;
            if (this.mPackageLastUpdateTime != r9.mPackageLastUpdateTime) goto L20;
            if (this.mSchema != r9.mSchema) goto L20;
            if (this.mInstalledCurrentProfileSize != r9.mInstalledCurrentProfileSize) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        void writeOnFile(File r4) {
            r4.delete();
            DataOutputStream r0 = new DataOutputStream(new FileOutputStream(r4));
            r0.writeInt(this.mSchema);     // Catch: Throwable -> L6
            r0.writeInt(this.mResultCode);     // Catch: Throwable -> L6
            r0.writeLong(this.mPackageLastUpdateTime);     // Catch: Throwable -> L6
            r0.writeLong(this.mInstalledCurrentProfileSize);     // Catch: Throwable -> L6
            r0.close();
            return;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int r1, boolean r2, boolean r3) {
            this.mResultCode = r1;
            this.mHasCurrentProfile = r3;
            this.mHasReferenceProfile = r2;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }
    }

    static {
        sFuture = ResolvableFuture.create();
        SYNC_OBJ = new Object();
        sCompilationStatus = null;
    }

    private ProfileVerifier() {
    }

    public static l<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        PackageInfo r5 = Api33Impl.getPackageInfo(r0, r4);
    L6:
        return r5.lastUpdateTime;
    L7:
        r5 = r0.getPackageInfo(r4.getPackageName(), 0);
        goto L6
    }

    private static CompilationStatus setCompilationStatus(int r1, boolean r2, boolean r3) {
        CompilationStatus r0 = new CompilationStatus(r1, r2, r3);
        sCompilationStatus = r0;
        sFuture.set(r0);
        return sCompilationStatus;
    }

    public static CompilationStatus writeProfileVerification(Context r2) {
        return writeProfileVerification((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false);
    }

    static CompilationStatus writeProfileVerification(Context r19, boolean r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        if (r20 == true) goto L7;
        CompilationStatus r1 = sCompilationStatus;
        if (r1 == null) goto L7;
        return r1;
    L7:
        Object r2 = SYNC_OBJ;
        monitor-enter(r2);
        if (r20 == false) goto L82;
    L14:
        int r4 = 0;
        if (Build.VERSION.SDK_INT >= 28) goto L17;
    L76:
        CompilationStatus r3 = setCompilationStatus(262144, false, false);     // Catch: Throwable -> L79
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r3;
    L17:
        if (Build.VERSION.SDK_INT == 30) goto L76;
        File r5 = new File(new File(REF_PROFILES_BASE_DIR, r0.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L79
        long r6 = r5.length();     // Catch: Throwable -> L79
        if (r5.exists() == true) goto L22;
    L24:
        boolean r7 = false;
    L25:
        File r9 = new File(new File(CUR_PROFILES_BASE_DIR, r0.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L79
        long r17 = r9.length();     // Catch: Throwable -> L79
        if (r9.exists() == true) goto L28;
    L30:
        boolean r8 = false;
    L83:
        long r15 = getPackageLastUpdateTime(r0);     // Catch: PackageManager.NameNotFoundException -> L73 Throwable -> L79
        File r10 = new File(r0.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L79
        Cache r11 = null;
        if (r10.exists() == false) goto L41;
        r11 = Cache.readFromFile(r10);     // Catch: IOException -> L36 Throwable -> L79
    L39:
        return setCompilationStatus(131072, r7, r8);
    L41:
        if (r11 != null) goto L43;
    L48:
        if (r7 == false) goto L50;
        r4 = 1;
    L52:
        if (r20 == false) goto L56;
        if (r8 == false) goto L56;
        if (r4 == 1) goto L56;
        r4 = 2;
    L56:
        if (r11 != null) goto L58;
    L63:
        Cache r12 = new Cache(1, r4, r15, r17);     // Catch: Throwable -> L79
        if (r11 != null) goto L66;
    L87:
        r12.writeOnFile(r10);     // Catch: IOException -> L69 Throwable -> L79
    L70:
        CompilationStatus r13 = setCompilationStatus(r4, r7, r8);     // Catch: Throwable -> L79
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r13;
    L69:
        r4 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L70
    L66:
        if (r11.equals(r12) == true) goto L70;
    L58:
        if (r11.mResultCode != 2) goto L63;
        if (r4 != 1) goto L63;
        if (r6 >= r11.mInstalledCurrentProfileSize) goto L63;
        r4 = 3;
        goto L63
    L50:
        if (r8 == false) goto L52;
        r4 = 2;
        goto L52
    L43:
        if (r11.mPackageLastUpdateTime != r15) goto L48;
        if (r11.mResultCode == 2) goto L48;
        r4 = r11.mResultCode;     // Catch: Throwable -> L79
        goto L52
    L79:
        th = move-exception;
        throw th;
    L75:
        return setCompilationStatus(65536, r7, r8);
    L28:
        if (r17 <= 0) goto L30;
        r8 = true;
        goto L83
    L22:
        if (r6 <= 0) goto L24;
        r7 = true;
        goto L25
    L82:
        CompilationStatus r14 = sCompilationStatus;     // Catch: Throwable -> L79
        if (r14 == null) goto L14;
        monitor-exit(r2);     // Catch: Throwable -> L79
        return r14;
    }
}
