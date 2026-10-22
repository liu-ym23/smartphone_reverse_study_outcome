package androidx.media;

import android.content.Context;
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

    public interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r5);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        public RemoteUserInfo(@NonNull String r5, int r10, int r11) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r5, r10, r11);
        }

        public boolean equals(@Nullable Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RemoteUserInfo) == true) goto L10;
            return false;
        L10:
            return this.mImpl.equals(((RemoteUserInfo) r5).mImpl);
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

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r5) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r5);
        }
    }

    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sLock = new Object();
    }

    private MediaSessionManager(Context r5) {
        this.mImpl = new MediaSessionManagerImplApi28(r5);
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context r5) {
        MediaSessionManager r10 = sSessionManager;
        if (r10 != null) goto L15;
        Object r11 = sLock;
        monitor-enter(r11);
        r10 = sSessionManager;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        sSessionManager = new MediaSessionManager(r5.getApplicationContext());     // Catch: Throwable -> L9
        r10 = sSessionManager;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        return r10;
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo r5) {
        if (r5 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r5.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
