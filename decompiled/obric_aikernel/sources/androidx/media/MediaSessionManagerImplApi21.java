package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context r10) {
        super(r10);
        this.mContext = r10;
    }

    private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl r10) {
        if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", r10.getPid(), r10.getUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl r10) {
        if (hasMediaControlPermission(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isTrustedForMediaControl(r10) == true) goto L8;
        return false;
    }
}
