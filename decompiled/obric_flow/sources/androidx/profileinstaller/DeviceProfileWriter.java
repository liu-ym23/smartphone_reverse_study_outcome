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
    public DeviceProfileWriter(@NonNull AssetManager r5, @NonNull Executor r10, @NonNull ProfileInstaller.DiagnosticsCallback r11, @NonNull String r12, @NonNull String r13, @NonNull String r14, @NonNull File r15) {
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = r5;
        this.mExecutor = r10;
        this.mDiagnostics = r11;
        this.mApkName = r12;
        this.mProfileSourceLocation = r13;
        this.mProfileMetaSourceLocation = r14;
        this.mCurProfile = r15;
        this.mDesiredVersion = desiredVersion();
    }

    public static /* synthetic */ void a(DeviceProfileWriter r5, int r10, Object r11) {
        r5.lambda$result$0(r10, r11);
    }

    @Nullable
    private DeviceProfileWriter addMetadata(DexProfileData[] r5, byte[] r10) {
        InputStream r11 = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
        if (r11 != null) goto L27;
        if (r11 == null) goto L26;
        r11.close();     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L26:
        return null;
    L27:
        this.mProfile = ProfileTranscoder.readMeta(r11, ProfileTranscoder.readHeader(r11, ProfileTranscoder.MAGIC_PROFM), r10, r5);     // Catch: Throwable -> L14
        r11.close();     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
        return this;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L12:
        e = move-exception;
        this.mDiagnostics.onResultReceived(9, e);
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L8:
        e = move-exception;
        this.mProfile = null;
        this.mDiagnostics.onResultReceived(8, e);
        goto L26
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    @Nullable
    private static byte[] desiredVersion() {
        int r5 = Build.VERSION.SDK_INT;
        if (r5 <= 33) goto L5;
        return null;
    L5:
        switch(r5) {
            case 31: goto L8;
            case 32: goto L8;
            case 33: goto L8;
            default: goto L6;
        };
    L6:
        return null;
    L8:
        return ProfileVersion.V015_S;
    }

    @Nullable
    private InputStream getProfileInputStream(AssetManager r5) {
    L14:
        return openStreamFromAssets(r5, this.mProfileSourceLocation);
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(6, e);
    L10:
        return null;
    L4:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L10
    }

    private /* synthetic */ void lambda$result$0(int r5, Object r10) {
        this.mDiagnostics.onResultReceived(r5, r10);
    }

    @Nullable
    private InputStream openStreamFromAssets(AssetManager r5, String r10) throws IOException {
        return r5.openFd(r10).createInputStream();
    L4:
        e = move-exception;
        String r11 = e.getMessage();
        if (r11 == null) goto L11;
        if (r11.contains("compressed") == false) goto L11;
        this.mDiagnostics.onDiagnosticReceived(5, null);
    L11:
        return null;
    }

    @Nullable
    private DexProfileData[] readProfileInternal(InputStream r5) {
        DexProfileData[] r10 = ProfileTranscoder.readProfile(r5, ProfileTranscoder.readHeader(r5, ProfileTranscoder.MAGIC_PROF), this.mApkName);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L12
        r5.close();     // Catch: IOException -> L6
        return r10;
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        return r10;
    L17:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L21:
        return null;
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L17
    L12:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L17
    L8:
        th = move-exception;
        r5.close();     // Catch: IOException -> L25
    L27:
        throw th;
    L25:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L27
    }

    private static boolean requiresMetadata() {
        int r5 = Build.VERSION.SDK_INT;
        if (r5 <= 33) goto L5;
        return false;
    L5:
        switch(r5) {
            case 31: goto L7;
            case 32: goto L7;
            case 33: goto L7;
            default: goto L6;
        };
    L6:
        return false;
    L7:
        return true;
    }

    private void result(int r5, @Nullable Object r10) {
        this.mExecutor.execute(new a(this, r5, r10, 0));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion != null) goto L7;
        result(3, Integer.valueOf(Build.VERSION.SDK_INT));
        return false;
    L7:
        if (this.mCurProfile.canWrite() == true) goto L10;
        result(4, null);
        return false;
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
        InputStream r5 = getProfileInputStream(this.mAssetManager);
        if (r5 == null) goto L8;
        this.mProfile = readProfileInternal(r5);
    L8:
        DexProfileData[] r10 = this.mProfile;
        if (r10 != null) goto L11;
    L15:
        return this;
    L11:
        if (requiresMetadata() == false) goto L15;
        DeviceProfileWriter r11 = addMetadata(r10, this.mDesiredVersion);
        if (r11 == null) goto L15;
        return r11;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        DexProfileData[] r5 = this.mProfile;
        byte[] r10 = this.mDesiredVersion;
        if (r5 == null) goto L30;
        if (r10 == null) goto L30;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L13 IOException -> L15
        ProfileTranscoder.writeHeader(r11, r10);     // Catch: Throwable -> L17
        if (ProfileTranscoder.transcodeAndWriteBody(r11, r10, r5) == true) goto L19;
        this.mDiagnostics.onResultReceived(5, null);     // Catch: Throwable -> L17
        this.mProfile = null;     // Catch: Throwable -> L17
        r11.close();     // Catch: IllegalStateException -> L13 IOException -> L15
        return this;
    L19:
        this.mTranscodedProfile = r11.toByteArray();     // Catch: Throwable -> L17
        r11.close();     // Catch: IllegalStateException -> L13 IOException -> L15
    L29:
        this.mProfile = null;
    L17:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IllegalStateException -> L13 IOException -> L15
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L13 IOException -> L15
    L15:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L13:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);
    L30:
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        byte[] r5 = this.mTranscodedProfile;
        if (r5 != null) goto L5;
        return false;
    L5:
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayInputStream r10 = new ByteArrayInputStream(r5);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        FileOutputStream r11 = new FileOutputStream(this.mCurProfile);     // Catch: Throwable -> L19
        Encoding.writeAll(r10, r11);     // Catch: Throwable -> L21
        result(1, null);     // Catch: Throwable -> L21
        r11.close();     // Catch: Throwable -> L19
        r10.close();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return true;
    L21:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L19
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L13:
        th = move-exception;
        this.mTranscodedProfile = null;
        this.mProfile = null;
        throw th;
    L17:
        e = move-exception;
        result(6, e);     // Catch: Throwable -> L13
    L34:
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return false;
    L15:
        e = move-exception;
        result(7, e);     // Catch: Throwable -> L13
        goto L34
    }
}
