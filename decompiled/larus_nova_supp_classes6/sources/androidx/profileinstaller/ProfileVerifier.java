package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture = null;

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static PackageInfo getPackageInfo(PackageManager r2, Context r3) throws PackageManager.NameNotFoundException {
            return r2.getPackageInfo(r3.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    public static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        public static Cache readFromFile(File r9) throws IOException {
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
            if ((r8 instanceof Cache) == false) goto L21;
            Cache r9 = (Cache) r8;
            if (this.mResultCode == r9.mResultCode) goto L13;
        L19:
            return false;
        L13:
            if (this.mPackageLastUpdateTime != r9.mPackageLastUpdateTime) goto L19;
            if (this.mSchema != r9.mSchema) goto L19;
            if (this.mInstalledCurrentProfileSize != r9.mInstalledCurrentProfileSize) goto L19;
            return true;
        }

        public void writeOnFile(File r4) throws IOException {
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

        public Cache(int r1, int r2, long r3, long r5) {
            this.mSchema = r1;
            this.mResultCode = r2;
            this.mPackageLastUpdateTime = r3;
            this.mInstalledCurrentProfileSize = r5;
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 327680;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        public boolean appApkHasEmbeddedProfile() {
            return this.mHasEmbeddedProfile;
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

        public CompilationStatus(int r1, boolean r2, boolean r3, boolean r4) {
            this.mResultCode = r1;
            this.mHasCurrentProfile = r3;
            this.mHasReferenceProfile = r2;
            this.mHasEmbeddedProfile = r4;
        }
    }

    static {
        sFuture = ResolvableFuture.create();
        SYNC_OBJ = new Object();
        sCompilationStatus = null;
    }

    private ProfileVerifier() {
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context r3) throws PackageManager.NameNotFoundException {
        PackageManager r0 = r3.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getPackageInfo(r0, r3).lastUpdateTime;
    L7:
        return r0.getPackageInfo(r3.getPackageName(), 0).lastUpdateTime;
    }

    public static CompilationStatus writeProfileVerification(Context r1) {
        return writeProfileVerification(r1, false);
    }

    public static CompilationStatus writeProfileVerification(Context r19, boolean r20) {
        if (r20 == true) goto L6;
        CompilationStatus r0 = sCompilationStatus;
        if (r0 == null) goto L6;
        return r0;
    L6:
        Object r1 = SYNC_OBJ;
        monitor-enter(r1);
        if (r20 == false) goto L111;
    L13:
        int r5 = 0;
        AssetFileDescriptor r6 = r19.getAssets().openFd("dexopt/baseline.prof");     // Catch: Throwable -> L31 IOException -> L33
        if (r6.getLength() <= 0) goto L19;
        boolean r2 = true;
    L20:
        r6.close();     // Catch: Throwable -> L31 IOException -> L33
    L34:
        int r7 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        if (r7 >= 28) goto L37;
    L99:
        CompilationStatus r3 = setCompilationStatus(CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION, false, false, r2);     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r3;
    L37:
        if (r7 == 30) goto L99;
        File r8 = new File(new File(REF_PROFILES_BASE_DIR, r19.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L31
        long r9 = r8.length();     // Catch: Throwable -> L31
        if (r8.exists() == true) goto L42;
    L44:
        boolean r10 = false;
    L45:
        File r11 = new File(new File(CUR_PROFILES_BASE_DIR, r19.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L31
        long r17 = r11.length();     // Catch: Throwable -> L31
        if (r11.exists() == true) goto L48;
    L50:
        boolean r4 = false;
    L104:
        long r15 = getPackageLastUpdateTime(r19);     // Catch: Throwable -> L31 PackageManager.NameNotFoundException -> L96
        File r12 = new File(r19.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L31
        if (r12.exists() == true) goto L109;
        Cache r13 = null;
    L62:
        if (r13 != null) goto L64;
    L69:
        if (r2 == true) goto L71;
        r5 = CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED;
    L75:
        if (r20 == false) goto L79;
        if (r4 == false) goto L79;
        if (r5 == 1) goto L79;
        r5 = 2;
    L79:
        if (r13 != null) goto L81;
    L86:
        Cache r14 = new Cache(1, r5, r15, r17);     // Catch: Throwable -> L31
        if (r13 != null) goto L89;
    L112:
        r14.writeOnFile(r12);     // Catch: Throwable -> L31 IOException -> L92
    L93:
        CompilationStatus r16 = setCompilationStatus(r5, r10, r4, r2);     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r16;
    L92:
        r5 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L93
    L89:
        if (r13.equals(r14) == true) goto L93;
    L81:
        if (r13.mResultCode != 2) goto L86;
        if (r5 != 1) goto L86;
        if (r9 >= r13.mInstalledCurrentProfileSize) goto L86;
        r5 = 3;
        goto L86
    L71:
        if (r10 == false) goto L73;
        r5 = 1;
        goto L75
    L73:
        if (r4 == false) goto L75;
        r5 = 2;
        goto L75
    L64:
        if (r13.mPackageLastUpdateTime != r15) goto L69;
        int r18 = r13.mResultCode;     // Catch: Throwable -> L31
        if (r18 == 2) goto L69;
        r5 = r18;
        goto L75
    L109:
        r13 = Cache.readFromFile(r12);     // Catch: Throwable -> L31 IOException -> L56
    L59:
        return setCompilationStatus(CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ, r10, r4, r2);
    L31:
        th = move-exception;
        throw th;
    L98:
        return setCompilationStatus(CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST, r10, r4, r2);
    L48:
        if (r17 <= 0) goto L50;
        r4 = true;
        goto L104
    L42:
        if (r9 <= 0) goto L44;
        r10 = true;
        goto L45
    L19:
        r2 = false;
    L22:
        th = move-exception;
        if (r6 == null) goto L116;
        r6.close();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31 IOException -> L33
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L116:
        throw th;     // Catch: Throwable -> L31 IOException -> L33
    L33:
        r2 = false;
        goto L34
    L111:
        CompilationStatus r21 = sCompilationStatus;     // Catch: Throwable -> L31
        if (r21 == null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r21;
    }

    private static CompilationStatus setCompilationStatus(int r1, boolean r2, boolean r3, boolean r4) {
        CompilationStatus r0 = new CompilationStatus(r1, r2, r3, r4);
        sCompilationStatus = r0;
        sFuture.set(r0);
        return sCompilationStatus;
    }
}
