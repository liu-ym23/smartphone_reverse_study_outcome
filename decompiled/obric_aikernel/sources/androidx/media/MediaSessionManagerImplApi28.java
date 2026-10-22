package androidx.media;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r10) {
            this.mObject = r10;
        }

        RemoteUserInfoImplApi28(String r10, int r11, int r12) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(r10, r11, r12);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof RemoteUserInfoImplApi28) == true) goto L10;
            return false;
        L10:
            return this.mObject.equals(((RemoteUserInfoImplApi28) r10).mObject);
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

    MediaSessionManagerImplApi28(Context r10) {
        super(r10);
        this.mObject = (android.media.session.MediaSessionManager) r10.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r10) {
        if ((r10 instanceof RemoteUserInfoImplApi28) == true) goto L5;
        return false;
    L5:
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) r10).mObject);
    }
}
