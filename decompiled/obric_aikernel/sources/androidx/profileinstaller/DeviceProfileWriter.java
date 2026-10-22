package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceProfileWriter {

    @NonNull
    private final String mApkName;

    @NonNull
    private final AssetManager mAssetManager;

    @NonNull
    private final File mCurProfile;

    @Nullable
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile;

    @NonNull
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;

    @NonNull
    private final Executor mExecutor;

    @Nullable
    private DexProfileData[] mProfile;

    @NonNull
    private final String mProfileMetaSourceLocation;

    @NonNull
    private final String mProfileSourceLocation;

    @Nullable
    private byte[] mTranscodedProfile;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager r10, @NonNull Executor r11, @NonNull ProfileInstaller.DiagnosticsCallback r12, @NonNull String r13, @NonNull String r14, @NonNull String r15, @NonNull File r16) {
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = r10;
        this.mExecutor = r11;
        this.mDiagnostics = r12;
        this.mApkName = r13;
        this.mProfileSourceLocation = r14;
        this.mProfileMetaSourceLocation = r15;
        this.mCurProfile = r16;
        this.mDesiredVersion = desiredVersion();
    }

    public static /* synthetic */ void a(DeviceProfileWriter r10, int r11, Object r12) {
        r10.lambda$result$0(r11, r12);
    }

    @Nullable
    private DeviceProfileWriter addMetadata(DexProfileData[] r10, byte[] r11) {
        InputStream r12 = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
        if (r12 != null) goto L27;
        if (r12 == null) goto L24;
        r12.close();     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L24:
        return null;
    L27:
        this.mProfile = ProfileTranscoder.readMeta(r12, ProfileTranscoder.readHeader(r12, ProfileTranscoder.MAGIC_PROFM), r11, r10);     // Catch: Throwable -> L8
        r12.close();     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
        return this;
    L8:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L21:
        e = e;
        ProfileInstaller.DiagnosticsCallback r13 = this.mDiagnostics;
        int r14 = 9;
    L23:
        r13.onResultReceived(r14, e);
    L19:
        e = e;
        r13 = this.mDiagnostics;
        r14 = 7;
    L17:
        e = e;
        this.mProfile = null;
        r13 = this.mDiagnostics;
        r14 = 8;
        goto L23
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    @Nullable
    private static byte[] desiredVersion() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 24) goto L5;
    L19:
        return null;
    L5:
        if (r10 > 33) goto L19;
        switch(r10) {
            case 24: goto L18;
            case 25: goto L18;
            case 26: goto L16;
            case 27: goto L14;
            case 28: goto L12;
            case 29: goto L12;
            case 30: goto L12;
            case 31: goto L10;
            case 32: goto L10;
            case 33: goto L10;
            default: goto L8;
        };
    L8:
        return null;
    L10:
        return ProfileVersion.V015_S;
    L12:
        return ProfileVersion.V010_P;
    L14:
        return ProfileVersion.V009_O_MR1;
    L16:
        return ProfileVersion.V005_O;
    L18:
        return ProfileVersion.V001_N;
    }

    @Nullable
    private InputStream getProfileInputStream(AssetManager r10) {
    L12:
        return openStreamFromAssets(r10, this.mProfileSourceLocation);
    L6:
        e = e;
        ProfileInstaller.DiagnosticsCallback r11 = this.mDiagnostics;
        int r12 = 6;
    L8:
        r11.onResultReceived(r12, e);
        return null;
    L4:
        e = e;
        r11 = this.mDiagnostics;
        r12 = 7;
        goto L8
    }

    private /* synthetic */ void lambda$result$0(int r10, Object r11) {
        this.mDiagnostics.onResultReceived(r10, r11);
    }

    @Nullable
    private InputStream openStreamFromAssets(AssetManager r10, String r11) {
        return r10.openFd(r11).createInputStream();
    L5:
        e = move-exception;
        String r12 = e.getMessage();
        if (r12 != null) goto L9;
        return null;
    L9:
        if (r12.contains("compressed") == false) goto L15;
        this.mDiagnostics.onDiagnosticReceived(5, null);
        return null;
    L15:
        return null;
    }

    @Nullable
    private DexProfileData[] readProfileInternal(InputStream r10) {
        DexProfileData[] r11 = ProfileTranscoder.readProfile(r10, ProfileTranscoder.readHeader(r10, ProfileTranscoder.MAGIC_PROF), this.mApkName);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L14
        r10.close();     // Catch: IOException -> L6
        return r11;
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        return r11;
    L8:
        th = move-exception;
        r10.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L14:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);     // Catch: Throwable -> L8
        r10.close();     // Catch: IOException -> L18
    L30:
    L20:
        return null;
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);     // Catch: Throwable -> L8
        r10.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L20
    }

    private static boolean requiresMetadata() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 24) goto L5;
    L14:
        return false;
    L5:
        if (r10 > 33) goto L14;
        if (r10 != 24) goto L10;
    L13:
        return true;
    L10:
        if (r10 == 25) goto L13;
        switch(r10) {
            case 31: goto L13;
            case 32: goto L13;
            case 33: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    }

    private void result(final int r10, @Nullable final Object r11) {
        this.mExecutor.execute(new a(this, r10, r11));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion != null) goto L8;
        int r10 = 3;
        Integer r11 = Integer.valueOf(Build.VERSION.SDK_INT);
    L5:
        result(r10, r11);
        return false;
    L8:
        if (this.mCurProfile.canWrite() == true) goto L10;
        r10 = 4;
        r11 = null;
        goto L5
    L10:
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter read() {
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) goto L5;
        return this;
    L5:
        InputStream r10 = getProfileInputStream(this.mAssetManager);
        if (r10 == null) goto L8;
        this.mProfile = readProfileInternal(r10);
    L8:
        DexProfileData[] r11 = this.mProfile;
        if (r11 != null) goto L11;
    L15:
        return this;
    L11:
        if (requiresMetadata() == false) goto L15;
        DeviceProfileWriter r12 = addMetadata(r11, this.mDesiredVersion);
        if (r12 == null) goto L15;
        return r12;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        DexProfileData[] r10 = this.mProfile;
        byte[] r11 = this.mDesiredVersion;
        if (r10 == null) goto L28;
        if (r11 == null) goto L28;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L22 IOException -> L24
        ProfileTranscoder.writeHeader(r12, r11);     // Catch: Throwable -> L16
        if (ProfileTranscoder.transcodeAndWriteBody(r12, r11, r10) == true) goto L13;
        this.mDiagnostics.onResultReceived(5, null);     // Catch: Throwable -> L16
        this.mProfile = null;     // Catch: Throwable -> L16
        r12.close();     // Catch: IllegalStateException -> L22 IOException -> L24
        return this;
    L13:
        this.mTranscodedProfile = r12.toByteArray();     // Catch: Throwable -> L16
        r12.close();     // Catch: IllegalStateException -> L22 IOException -> L24
    L27:
        this.mProfile = null;
    L16:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IllegalStateException -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L22 IOException -> L24
    L24:
        e = e;
        ProfileInstaller.DiagnosticsCallback r13 = this.mDiagnostics;
        int r14 = 7;
    L26:
        r13.onResultReceived(r14, e);
    L22:
        e = e;
        r13 = this.mDiagnostics;
        r14 = 8;
    L28:
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        byte[] r10 = this.mTranscodedProfile;
        if (r10 != null) goto L5;
        return false;
    L5:
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        FileOutputStream r12 = new FileOutputStream(this.mCurProfile);     // Catch: Throwable -> L19
        Encoding.writeAll(r11, r12);     // Catch: Throwable -> L13
        result(1, null);     // Catch: Throwable -> L13
        r12.close();     // Catch: Throwable -> L19
        r11.close();     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return true;
    L13:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L25:
        th = move-exception;
        this.mTranscodedProfile = null;
        this.mProfile = null;
        throw th;
    L30:
        e = move-exception;
        result(6, e);     // Catch: Throwable -> L25
    L32:
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return false;
    L27:
        e = move-exception;
        result(7, e);     // Catch: Throwable -> L25
        goto L32
    }
}
