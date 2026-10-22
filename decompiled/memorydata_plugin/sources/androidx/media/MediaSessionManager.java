package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = false;
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = null;
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r1);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r2) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r2);
        }

        public RemoteUserInfo(String r3, int r4, int r5) {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            RemoteUserInfoImpl r0 = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r3, r4, r5);
        L6:
            this.mImpl = r0;
            return;
        L5:
            r0 = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(r3, r4, r5);
            goto L6
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, RemoteUserInfo.class) == true) goto L11;
            return false;
        L11:
            return this.mImpl.equals(((RemoteUserInfo) ZeusTransformUtils.preCheckCast(r3, RemoteUserInfo.class, "com.obric.memorydata.plugin")).mImpl);
        }

        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }
    }

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sLock = new Object();
    }

    private MediaSessionManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        MediaSessionManagerImpl r0 = new MediaSessionManagerImplApi28(r4);
    L5:
        this.mImpl = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        r0 = new MediaSessionManagerImplApi21(r4);
        goto L5
    L9:
        r0 = new MediaSessionManagerImplBase(r4);
        goto L5
    }

    public static MediaSessionManager getSessionManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        MediaSessionManager r0 = sSessionManager;
        if (r0 != null) goto L14;
        Object r1 = sLock;
        monitor-enter(r1);
        r0 = sSessionManager;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        sSessionManager = new MediaSessionManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        r0 = sSessionManager;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mImpl.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo r1) {
        if (r1 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r1.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
