package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager r3, Executor r4, ProfileInstaller.DiagnosticsCallback r5, String r6, String r7, String r8, File r9) {
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        ProfileInstaller.DiagnosticsCallback r11 = (ProfileInstaller.DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r5, ProfileInstaller.DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = r3;
        this.mExecutor = r10;
        this.mDiagnostics = r11;
        this.mApkName = r6;
        this.mProfileSourceLocation = r7;
        this.mProfileMetaSourceLocation = r8;
        this.mCurProfile = r9;
        this.mDesiredVersion = desiredVersion();
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] r4, byte[] r5) {
        InputStream r1 = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
        if (r1 != null) goto L29;
        if (r1 == null) goto L26;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L26:
        return null;
    L29:
        this.mProfile = ProfileTranscoder.readMeta(r1, ProfileTranscoder.readHeader(r1, ProfileTranscoder.MAGIC_PROFM), r5, r4);     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L8:
        return this;
    L9:
        th = move-exception;
        if (r1 != null) goto L27;
    L15:
        throw th;     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L27:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L23:
        e = e;
        ProfileInstaller.DiagnosticsCallback r3 = this.mDiagnostics;
        int r6 = 9;
    L25:
        r3.onResultReceived(r6, e);
    L21:
        e = e;
        r3 = this.mDiagnostics;
        r6 = 7;
    L19:
        e = e;
        this.mProfile = null;
        r3 = this.mDiagnostics;
        r6 = 8;
        goto L25
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    private static byte[] desiredVersion() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L20:
        return null;
    L5:
        if (Build.VERSION.SDK_INT > 33) goto L20;
        switch(Build.VERSION.SDK_INT) {
            case 24: goto L19;
            case 25: goto L19;
            case 26: goto L17;
            case 27: goto L15;
            case 28: goto L13;
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L11;
            case 32: goto L11;
            case 33: goto L11;
            default: goto L9;
        };
    L9:
        return null;
    L11:
        return ProfileVersion.V015_S;
    L13:
        return ProfileVersion.V010_P;
    L15:
        return ProfileVersion.V009_O_MR1;
    L17:
        return ProfileVersion.V005_O;
    L19:
        return ProfileVersion.V001_N;
    }

    private InputStream getProfileInputStream(AssetManager r2) {
    L12:
        return openStreamFromAssets(r2, this.mProfileSourceLocation);
    L6:
        e = e;
        ProfileInstaller.DiagnosticsCallback r1 = this.mDiagnostics;
        int r0 = 6;
    L8:
        r1.onResultReceived(r0, e);
        return null;
    L4:
        e = e;
        r1 = this.mDiagnostics;
        r0 = 7;
        goto L8
    }

    private InputStream openStreamFromAssets(AssetManager r2, String r3) {
        return r2.openFd(r3).createInputStream();
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r4.contains("compressed") == false) goto L15;
        this.mDiagnostics.onDiagnosticReceived(5, null);
        return null;
    L15:
        return null;
    }

    private DexProfileData[] readProfileInternal(InputStream r5) {
        DexProfileData[] r1 = ProfileTranscoder.readProfile(r5, ProfileTranscoder.readHeader(r5, ProfileTranscoder.MAGIC_PROF), this.mApkName);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L14
        r5.close();     // Catch: IOException -> L6
        return r1;
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        return r1;
    L8:
        th = move-exception;
        r5.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L14:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L30:
    L20:
        return null;
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L20
    }

    private static boolean requiresMetadata() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L14:
        return false;
    L5:
        if (Build.VERSION.SDK_INT > 33) goto L14;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 24) goto L10;
    L13:
        return true;
    L10:
        if (r0 == 25) goto L13;
        switch(r0) {
            case 31: goto L13;
            case 32: goto L13;
            case 33: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    }

    private void result(final int r3, final Object r4) {
        this.mExecutor.execute(new $$Lambda$DeviceProfileWriter$ERhlvXCSfTRqn5iULYjONtnw(this, r3, r4));
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion != null) goto L8;
        int r0 = 3;
        Integer r2 = Integer.valueOf(Build.VERSION.SDK_INT);
    L5:
        result(r0, r2);
        return false;
    L8:
        if (this.mCurProfile.canWrite() == true) goto L10;
        r0 = 4;
        r2 = null;
        goto L5
    L10:
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    public /* synthetic */ void lambda$result$0$DeviceProfileWriter(int r1, Object r2) {
        this.mDiagnostics.onResultReceived(r1, r2);
    }

    public DeviceProfileWriter read() {
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) goto L5;
        return this;
    L5:
        InputStream r0 = getProfileInputStream(this.mAssetManager);
        if (r0 == null) goto L8;
        this.mProfile = readProfileInternal(r0);
    L8:
        DexProfileData[] r1 = this.mProfile;
        if (r1 != null) goto L11;
    L15:
        return this;
    L11:
        if (requiresMetadata() == false) goto L15;
        DeviceProfileWriter r2 = addMetadata(r1, this.mDesiredVersion);
        if (r2 == null) goto L15;
        return r2;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        DexProfileData[] r0 = this.mProfile;
        byte[] r1 = this.mDesiredVersion;
        if (r0 == null) goto L28;
        if (r1 == null) goto L28;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L22 IOException -> L24
        ProfileTranscoder.writeHeader(r3, r1);     // Catch: Throwable -> L16
        if (ProfileTranscoder.transcodeAndWriteBody(r3, r1, r0) == true) goto L13;
        this.mDiagnostics.onResultReceived(5, null);     // Catch: Throwable -> L16
        this.mProfile = null;     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
        return this;
    L13:
        this.mTranscodedProfile = r3.toByteArray();     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
    L27:
        this.mProfile = null;
    L16:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IllegalStateException -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L22 IOException -> L24
    L24:
        e = e;
        ProfileInstaller.DiagnosticsCallback r2 = this.mDiagnostics;
        int r4 = 7;
    L26:
        r2.onResultReceived(r4, e);
    L22:
        e = e;
        r2 = this.mDiagnostics;
        r4 = 8;
    L28:
        return this;
    }

    public boolean write() {
        byte[] r0 = this.mTranscodedProfile;
        if (r0 != null) goto L5;
        return false;
    L5:
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayInputStream r3 = new ByteArrayInputStream(r0);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        FileOutputStream r1 = new FileOutputStream(this.mCurProfile);     // Catch: Throwable -> L19
        Encoding.writeAll(r3, r1);     // Catch: Throwable -> L13
        result(1, null);     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L19
        r3.close();     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return true;
    L13:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L22
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
