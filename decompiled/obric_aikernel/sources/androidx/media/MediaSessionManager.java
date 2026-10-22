package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = false;
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = null;
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r10);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r10) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r10);
        }

        public RemoteUserInfo(@NonNull String r10, int r11, int r12) {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            RemoteUserInfoImpl r13 = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r10, r11, r12);
        L6:
            this.mImpl = r13;
            return;
        L5:
            r13 = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(r10, r11, r12);
            goto L6
        }

        public boolean equals(@Nullable Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof RemoteUserInfo) == true) goto L10;
            return false;
        L10:
            return this.mImpl.equals(((RemoteUserInfo) r10).mImpl);
        }

        @NonNull
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

    private MediaSessionManager(Context r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        MediaSessionManagerImpl r12 = new MediaSessionManagerImplApi28(r10);
    L5:
        this.mImpl = r12;
        return;
    L7:
        if (r11 < 21) goto L9;
        r12 = new MediaSessionManagerImplApi21(r10);
        goto L5
    L9:
        r12 = new MediaSessionManagerImplBase(r10);
        goto L5
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context r10) {
        MediaSessionManager r11 = sSessionManager;
        if (r11 != null) goto L14;
        Object r12 = sLock;
        monitor-enter(r12);
        r11 = sSessionManager;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        sSessionManager = new MediaSessionManager(r10.getApplicationContext());     // Catch: Throwable -> L11
        r11 = sSessionManager;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r11;
    }

    Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo r10) {
        if (r10 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r10.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
