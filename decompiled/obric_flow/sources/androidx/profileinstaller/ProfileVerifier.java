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
import com.google.common.util.concurrent.w0;
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
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static PackageInfo getPackageInfo(PackageManager r5, Context r10) throws PackageManager.NameNotFoundException {
            return r5.getPackageInfo(r10.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        public Cache(int r5, int r10, long r11, long r12) {
            this.mSchema = r5;
            this.mResultCode = r10;
            this.mPackageLastUpdateTime = r11;
            this.mInstalledCurrentProfileSize = r12;
        }

        public static Cache readFromFile(@NonNull File r10) throws IOException {
            DataInputStream r5 = new DataInputStream(new FileInputStream(r10));
            Cache r11 = new Cache(r5.readInt(), r5.readInt(), r5.readLong(), r5.readLong());     // Catch: Throwable -> L6
            r5.close();
            return r11;
        L6:
            th = move-exception;
            r5.close();     // Catch: Throwable -> L9
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

        public void writeOnFile(@NonNull File r5) throws IOException {
            r5.delete();
            DataOutputStream r10 = new DataOutputStream(new FileOutputStream(r5));
            r10.writeInt(this.mSchema);     // Catch: Throwable -> L6
            r10.writeInt(this.mResultCode);     // Catch: Throwable -> L6
            r10.writeLong(this.mPackageLastUpdateTime);     // Catch: Throwable -> L6
            r10.writeLong(this.mInstalledCurrentProfileSize);     // Catch: Throwable -> L6
            r10.close();
            return;
        L6:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L9
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

        public CompilationStatus(int r5, boolean r10, boolean r11) {
            this.mResultCode = r5;
            this.mHasCurrentProfile = r11;
            this.mHasReferenceProfile = r10;
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
    public static w0 getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context r5) throws PackageManager.NameNotFoundException {
        PackageManager r10 = r5.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getPackageInfo(r10, r5).lastUpdateTime;
    L7:
        return r10.getPackageInfo(r5.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int r5, boolean r10, boolean r11) {
        CompilationStatus r12 = new CompilationStatus(r5, r10, r11);
        sCompilationStatus = r12;
        sFuture.set(r12);
        return sCompilationStatus;
    }

    @NonNull
    @WorkerThread
    public static CompilationStatus writeProfileVerification(@NonNull Context r5) {
        return writeProfileVerification(r5, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @WorkerThread
    public static CompilationStatus writeProfileVerification(@NonNull Context r18, boolean r19) {
        if (r19 == true) goto L6;
        CompilationStatus r5 = sCompilationStatus;
        if (r5 == null) goto L6;
        return r5;
    L6:
        Object r10 = SYNC_OBJ;
        monitor-enter(r10);
        if (r19 == false) goto L77;
    L15:
        File r11 = new File(new File(REF_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L13
        long r12 = r11.length();     // Catch: Throwable -> L13
        int r13 = 0;
        if (r11.exists() == true) goto L18;
    L20:
        boolean r14 = false;
    L21:
        File r15 = new File(new File(CUR_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L13
        long r16 = r15.length();     // Catch: Throwable -> L13
        if (r15.exists() == true) goto L24;
    L26:
        boolean r17 = false;
    L80:
        long r110 = getPackageLastUpdateTime(r18);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L70
        File r20 = new File(r18.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L13
        if (r20.exists() == true) goto L75;
        Cache r21 = null;
    L38:
        if (r21 != null) goto L40;
    L45:
        if (r14 == false) goto L47;
        r13 = 1;
    L49:
        if (r19 == false) goto L53;
        if (r17 == false) goto L53;
        if (r13 == 1) goto L53;
        r13 = 2;
    L53:
        if (r21 != null) goto L55;
    L60:
        Cache r22 = new Cache(1, r13, r110, r16);     // Catch: Throwable -> L13
        if (r21 != null) goto L63;
    L78:
        r22.writeOnFile(r20);     // Catch: Throwable -> L13 IOException -> L66
    L67:
        CompilationStatus r23 = setCompilationStatus(r13, r14, r17);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r23;
    L66:
        r13 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L67
    L63:
        if (r21.equals(r22) == true) goto L67;
    L55:
        if (r21.mResultCode != 2) goto L60;
        if (r13 != 1) goto L60;
        if (r12 >= r21.mInstalledCurrentProfileSize) goto L60;
        r13 = 3;
        goto L60
    L47:
        if (r17 == false) goto L49;
        r13 = 2;
        goto L49
    L40:
        if (r21.mPackageLastUpdateTime != r110) goto L45;
        int r111 = r21.mResultCode;     // Catch: Throwable -> L13
        if (r111 == 2) goto L45;
        r13 = r111;
        goto L49
    L75:
        r21 = Cache.readFromFile(r20);     // Catch: Throwable -> L13 IOException -> L32
    L35:
        return setCompilationStatus(131072, r14, r17);
    L13:
        th = move-exception;
        throw th;
    L72:
        return setCompilationStatus(65536, r14, r17);
    L24:
        if (r16 <= 0) goto L26;
        r17 = true;
        goto L80
    L18:
        if (r12 <= 0) goto L20;
        r14 = true;
        goto L21
    L77:
        CompilationStatus r24 = sCompilationStatus;     // Catch: Throwable -> L13
        if (r24 == null) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r24;
    }
}
