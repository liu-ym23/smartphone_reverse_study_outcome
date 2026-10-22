package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    public MediaSessionManagerImplApi21(Context r5) {
        super(r5);
        this.mContext = r5;
    }

    private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl r5) {
        if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", r5.getPid(), r5.getUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl r5) {
        if (hasMediaControlPermission(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isTrustedForMediaControl(r5) == true) goto L8;
        return false;
    }
}
