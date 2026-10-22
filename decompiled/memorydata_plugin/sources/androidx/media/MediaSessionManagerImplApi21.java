package androidx.media;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    private boolean hasMediaControlPermission(MediaSessionManager.RemoteUserInfoImpl r3) {
        MediaSessionManager.RemoteUserInfoImpl r4 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r3, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).checkPermission("android.permission.MEDIA_CONTENT_CONTROL", r4.getPid(), r4.getUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r3) {
        MediaSessionManager.RemoteUserInfoImpl r4 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r3, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        if (hasMediaControlPermission(r4) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isTrustedForMediaControl(r4) == true) goto L8;
        return false;
    }
}
