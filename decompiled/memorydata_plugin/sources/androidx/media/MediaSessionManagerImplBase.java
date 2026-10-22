package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

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

        RemoteUserInfoImplBase(String r1, int r2, int r3) {
            this.mPackageName = r1;
            this.mPid = r2;
            this.mUid = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, RemoteUserInfoImplBase.class) == true) goto L8;
            return false;
        L8:
            RemoteUserInfoImplBase r6 = (RemoteUserInfoImplBase) ZeusTransformUtils.preCheckCast(r5, RemoteUserInfoImplBase.class, "com.obric.memorydata.plugin");
            if (TextUtils.equals(this.mPackageName, r6.mPackageName) == false) goto L16;
            if (this.mPid != r6.mPid) goto L16;
            if (this.mUid != r6.mUid) goto L16;
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

    MediaSessionManagerImplBase(Context r3) {
        Context r4 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r4;
        this.mContentResolver = r4.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl r4, String r5) {
        MediaSessionManager.RemoteUserInfoImpl r6 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r4, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        int r0 = r6.getPid();
        Context r3 = this.mContext;
        if (r0 >= 0) goto L10;
        if (r3.getPackageManager().checkPermission(r5, r6.getPackageName()) != 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r3.checkPermission(r5, r6.getPid(), r6.getUid()) != 0) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        return this.mContext;
    }

    boolean isEnabledNotificationListener(MediaSessionManager.RemoteUserInfoImpl r5) {
        MediaSessionManager.RemoteUserInfoImpl r6 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r5, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        String r4 = Settings.Secure.getString(this.mContentResolver, ENABLED_NOTIFICATION_LISTENERS);
        if (r4 == null) goto L14;
        String[] r7 = r4.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int r1 = 0;
    L6:
        if (r1 >= r7.length) goto L14;
        ComponentName r2 = ComponentName.unflattenFromString(r7[r1]);
        if (r2 == null) goto L13;
        if (r2.getPackageName().equals(r6.getPackageName()) == false) goto L13;
        return true;
    L13:
        r1 = r1 + 1;
    L14:
        return false;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r5) {
        MediaSessionManager.RemoteUserInfoImpl r6 = (MediaSessionManager.RemoteUserInfoImpl) ZeusTransformUtils.wrapperContextForParams(r5, MediaSessionManager.RemoteUserInfoImpl.class, "com.obric.memorydata.plugin");
        if (this.mContext.getPackageManager().getApplicationInfo(r6.getPackageName(), 0).uid == r6.getUid()) goto L11;
        if (DEBUG == false) goto L9;
        Log.d(TAG, "Package name " + r6.getPackageName() + " doesn't match with the uid " + r6.getUid());
    L9:
        return false;
    L11:
        if (isPermissionGranted(r6, PERMISSION_STATUS_BAR_SERVICE) == false) goto L13;
    L18:
        return true;
    L13:
        if (isPermissionGranted(r6, PERMISSION_MEDIA_CONTENT_CONTROL) == true) goto L18;
        if (r6.getUid() == 1000) goto L18;
        if (isEnabledNotificationListener(r6) == true) goto L18;
        return false;
    L21:
        if (DEBUG == false) goto L23;
        Log.d(TAG, "Package " + r6.getPackageName() + " doesn't exist");
    L23:
        return false;
    }
}
