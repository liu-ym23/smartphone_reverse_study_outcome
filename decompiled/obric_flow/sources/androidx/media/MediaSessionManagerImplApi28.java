package androidx.media;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    public static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        public RemoteUserInfoImplApi28(String r5, int r10, int r11) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RemoteUserInfoImplApi28) == true) goto L10;
            return false;
        L10:
            return this.mObject.equals(((RemoteUserInfoImplApi28) r5).mObject);
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

        public RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r5) {
            this.mObject = r5;
        }
    }

    public MediaSessionManagerImplApi28(Context r5) {
        super(r5);
        this.mObject = (android.media.session.MediaSessionManager) r5.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r5) {
        if ((r5 instanceof RemoteUserInfoImplApi28) == true) goto L5;
        return false;
    L5:
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) r5).mObject);
    }
}
