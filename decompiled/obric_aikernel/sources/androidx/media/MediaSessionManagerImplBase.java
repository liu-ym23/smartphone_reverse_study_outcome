package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean DEBUG = false;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    ContentResolver mContentResolver;
    Context mContext;

    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        private String mPackageName;
        private int mPid;
        private int mUid;

        RemoteUserInfoImplBase(String r10, int r11, int r12) {
            this.mPackageName = r10;
            this.mPid = r11;
            this.mUid = r12;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof RemoteUserInfoImplBase) == true) goto L8;
            return false;
        L8:
            RemoteUserInfoImplBase r11 = (RemoteUserInfoImplBase) r10;
            if (TextUtils.equals(this.mPackageName, r11.mPackageName) == false) goto L16;
            if (this.mPid != r11.mPid) goto L16;
            if (this.mUid != r11.mUid) goto L16;
            return true;
        L16:
            return false;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mPackageName;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mPid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mUid;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mPid), Integer.valueOf(this.mUid)});
        }
    }

    static {
        DEBUG = MediaSessionManager.DEBUG;
    }

    MediaSessionManagerImplBase(Context r10) {
        this.mContext = r10;
        this.mContentResolver = r10.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl r10, String r11) {
        int r12 = r10.getPid();
        Context r13 = this.mContext;
        if (r12 >= 0) goto L10;
        if (r13.getPackageManager().checkPermission(r11, r10.getPackageName()) != 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r13.checkPermission(r11, r10.getPid(), r10.getUid()) != 0) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        return this.mContext;
    }

    boolean isEnabledNotificationListener(@NonNull MediaSessionManager.RemoteUserInfoImpl r10) {
        String r11 = Settings.Secure.getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (r11 == null) goto L14;
        String[] r12 = r11.split(":");
        int r13 = 0;
    L6:
        if (r13 >= r12.length) goto L14;
        ComponentName r14 = ComponentName.unflattenFromString(r12[r13]);
        if (r14 == null) goto L13;
        if (r14.getPackageName().equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        r13 = r13 + 1;
    L14:
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl r10) {
        if (this.mContext.getPackageManager().getApplicationInfo(r10.getPackageName(), 0).uid == r10.getUid()) goto L11;
        if (DEBUG == false) goto L9;
        Log.d(TAG, "Package name " + r10.getPackageName() + " doesn't match with the uid " + r10.getUid());
    L9:
        return false;
    L11:
        if (isPermissionGranted(r10, PERMISSION_STATUS_BAR_SERVICE) == false) goto L13;
    L18:
        return true;
    L13:
        if (isPermissionGranted(r10, PERMISSION_MEDIA_CONTENT_CONTROL) == true) goto L18;
        if (r10.getUid() == 1000) goto L18;
        if (isEnabledNotificationListener(r10) == true) goto L18;
        return false;
    L21:
        if (DEBUG == false) goto L23;
        Log.d(TAG, "Package " + r10.getPackageName() + " doesn't exist");
    L23:
        return false;
    }
}
