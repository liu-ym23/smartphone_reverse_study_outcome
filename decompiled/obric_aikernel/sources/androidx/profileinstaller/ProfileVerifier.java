package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
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

    @Nullable
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture = null;

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static PackageInfo getPackageInfo(PackageManager r10, Context r11) {
            return r10.getPackageInfo(r11.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int r10, int r11, long r12, long r13) {
            this.mSchema = r10;
            this.mResultCode = r11;
            this.mPackageLastUpdateTime = r12;
            this.mInstalledCurrentProfileSize = r13;
        }

        static Cache readFromFile(@NonNull File r10) {
            DataInputStream r11 = new DataInputStream(new FileInputStream(r10));
            Cache r12 = new Cache(r11.readInt(), r11.readInt(), r11.readLong(), r11.readLong());     // Catch: Throwable -> L6
            r11.close();
            return r12;
        L6:
            th = move-exception;
            r11.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L21:
            return false;
        L8:
            if ((r10 instanceof Cache) == false) goto L21;
            Cache r11 = (Cache) r10;
            if (this.mResultCode != r11.mResultCode) goto L20;
            if (this.mPackageLastUpdateTime != r11.mPackageLastUpdateTime) goto L20;
            if (this.mSchema != r11.mSchema) goto L20;
            if (this.mInstalledCurrentProfileSize != r11.mInstalledCurrentProfileSize) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        void writeOnFile(@NonNull File r10) {
            r10.delete();
            DataOutputStream r11 = new DataOutputStream(new FileOutputStream(r10));
            r11.writeInt(this.mSchema);     // Catch: Throwable -> L6
            r11.writeInt(this.mResultCode);     // Catch: Throwable -> L6
            r11.writeLong(this.mPackageLastUpdateTime);     // Catch: Throwable -> L6
            r11.writeLong(this.mInstalledCurrentProfileSize);     // Catch: Throwable -> L6
            r11.close();
            return;
        L6:
            th = move-exception;
            r11.close();     // Catch: Throwable -> L9
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
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface ResultCode {
        }

        CompilationStatus(int r10, boolean r11, boolean r12) {
            this.mResultCode = r10;
            this.mHasCurrentProfile = r12;
            this.mHasReferenceProfile = r11;
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

    @NonNull
    public static c6.a<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context r10) {
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        PackageInfo r12 = Api33Impl.getPackageInfo(r11, r10);
    L6:
        return r12.lastUpdateTime;
    L7:
        r12 = r11.getPackageInfo(r10.getPackageName(), 0);
        goto L6
    }

    private static CompilationStatus setCompilationStatus(int r10, boolean r11, boolean r12) {
        CompilationStatus r13 = new CompilationStatus(r10, r11, r12);
        sCompilationStatus = r13;
        sFuture.set(r13);
        return sCompilationStatus;
    }

    @NonNull
    @WorkerThread
    public static CompilationStatus writeProfileVerification(@NonNull Context r10) {
        return writeProfileVerification(r10, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    static CompilationStatus writeProfileVerification(@NonNull Context r18, boolean r19) {
        if (r19 == true) goto L6;
        CompilationStatus r10 = sCompilationStatus;
        if (r10 == null) goto L6;
        return r10;
    L6:
        Object r11 = SYNC_OBJ;
        monitor-enter(r11);
        if (r19 == false) goto L81;
    L13:
        int r12 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L78
        int r13 = 0;
        if (r12 >= 28) goto L16;
    L75:
        CompilationStatus r14 = setCompilationStatus(262144, false, false);     // Catch: Throwable -> L78
        monitor-exit(r11);     // Catch: Throwable -> L78
        return r14;
    L16:
        if (r12 == 30) goto L75;
        File r15 = new File(new File(REF_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L78
        long r16 = r15.length();     // Catch: Throwable -> L78
        if (r15.exists() == true) goto L21;
    L23:
        boolean r17 = false;
    L24:
        File r20 = new File(new File(CUR_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L78
        long r110 = r20.length();     // Catch: Throwable -> L78
        if (r20.exists() == true) goto L27;
    L29:
        boolean r21 = false;
    L84:
        long r111 = getPackageLastUpdateTime(r18);     // Catch: PackageManager.NameNotFoundException -> L72 Throwable -> L78
        File r22 = new File(r18.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L78
        Cache r23 = null;
        if (r22.exists() == false) goto L40;
        r23 = Cache.readFromFile(r22);     // Catch: IOException -> L35 Throwable -> L78
    L38:
        return setCompilationStatus(131072, r17, r21);
    L40:
        if (r23 != null) goto L42;
    L47:
        if (r17 == false) goto L49;
        r13 = 1;
    L51:
        if (r19 == false) goto L55;
        if (r21 == false) goto L55;
        if (r13 == 1) goto L55;
        r13 = 2;
    L55:
        if (r23 != null) goto L57;
    L62:
        Cache r24 = new Cache(1, r13, r111, r110);     // Catch: Throwable -> L78
        if (r23 != null) goto L65;
    L86:
        r24.writeOnFile(r22);     // Catch: IOException -> L68 Throwable -> L78
    L69:
        CompilationStatus r25 = setCompilationStatus(r13, r17, r21);     // Catch: Throwable -> L78
        monitor-exit(r11);     // Catch: Throwable -> L78
        return r25;
    L68:
        r13 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L69
    L65:
        if (r23.equals(r24) == true) goto L69;
    L57:
        if (r23.mResultCode != 2) goto L62;
        if (r13 != 1) goto L62;
        if (r16 >= r23.mInstalledCurrentProfileSize) goto L62;
        r13 = 3;
        goto L62
    L49:
        if (r21 == false) goto L51;
        r13 = 2;
        goto L51
    L42:
        if (r23.mPackageLastUpdateTime != r111) goto L47;
        int r112 = r23.mResultCode;     // Catch: Throwable -> L78
        if (r112 == 2) goto L47;
        r13 = r112;
        goto L51
    L78:
        th = move-exception;
        throw th;
    L74:
        return setCompilationStatus(65536, r17, r21);
    L27:
        if (r110 <= 0) goto L29;
        r21 = true;
        goto L84
    L21:
        if (r16 <= 0) goto L23;
        r17 = true;
        goto L24
    L81:
        CompilationStatus r26 = sCompilationStatus;     // Catch: Throwable -> L78
        if (r26 == null) goto L13;
        monitor-exit(r11);     // Catch: Throwable -> L78
        return r26;
    }
}
