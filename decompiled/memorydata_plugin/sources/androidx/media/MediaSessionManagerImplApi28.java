package androidx.media;

import android.content.Context;
import androidx.core.util.ObjectsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r1) {
            this.mObject = r1;
        }

        RemoteUserInfoImplApi28(String r2, int r3, int r4) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, RemoteUserInfoImplApi28.class) == true) goto L10;
            return false;
        L10:
            RemoteUserInfoImplApi28 r4 = (RemoteUserInfoImplApi28) ZeusTransformUtils.preCheckCast(r3, RemoteUserInfoImplApi28.class, "com.obric.memorydata.plugin");
            return this.mObject.equals(r4.mObject);
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mObject});
        }
    }

    MediaSessionManagerImplApi28(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mObject = (android.media.session.MediaSessionManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("media_session"), android.media.session.MediaSessionManager.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r3) {
        MediaSessionManager.RemoteUserInfoImpl r4 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r3, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RemoteUserInfoImplApi28.class) == true) goto L5;
        return false;
    L5:
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) ZeusTransformUtils.preCheckCast(r4, RemoteUserInfoImplApi28.class, "com.obric.memorydata.plugin")).mObject);
    }
}
