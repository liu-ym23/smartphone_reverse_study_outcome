package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g extends MediaBrowser.ConnectionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f374a;

    public g(c r5) {
        this.f374a = r5;
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() {
        boolean r5 = false;
        d r10 = (d) this.f374a.f367a;
        b r11 = r10.mConnectionCallbackInternal;
        if (r11 == null) goto L24;
        e r12 = (e) r11;
        MediaBrowser r13 = r12.f369b;
        Bundle r14 = r13.getExtras();
        if (r14 == null) goto L24;
        r14.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
        IBinder r15 = BundleCompat.getBinder(r14, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
        if (r15 == null) goto L13;
        s6.c r16 = new s6.c(1, r5);
        r16.f21828b = new Messenger(r15);
        r16.f21829c = r12.f370c;
        r12.f = r16;
        a r17 = r12.d;
        Messenger r18 = new Messenger(r17);
        r12.g = r18;
        r17.getClass();
        r17.f366c = new WeakReference(r18);
        s6.c r19 = r12.f;     // Catch: RemoteException -> L12
        Context r20 = r12.f368a;     // Catch: RemoteException -> L12
        Messenger r21 = r12.g;     // Catch: RemoteException -> L12
        r19.getClass();     // Catch: RemoteException -> L12
        Bundle r22 = new Bundle();     // Catch: RemoteException -> L12
        r22.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r20.getPackageName());     // Catch: RemoteException -> L12
        r22.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, (Bundle) r19.f21829c);     // Catch: RemoteException -> L12
        r19.C(6, r22, r21);     // Catch: RemoteException -> L12
    L12:
        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
    L13:
        IBinder r23 = BundleCompat.getBinder(r14, MediaBrowserProtocol.EXTRA_SESSION_BINDER);
        int r24 = android.support.v4.media.session.b.f395a;
        if (r23 != null) goto L16;
        android.support.v4.media.session.c r25 = null;
    L22:
        if (r25 == null) goto L24;
        r12.f371h = MediaSessionCompat$Token.c(r13.getSessionToken(), r25);
        goto L24
    L16:
        IInterface r26 = r23.queryLocalInterface("android.support.v4.media.session.IMediaSession");
        if (r26 != null) goto L19;
    L21:
        android.support.v4.media.session.a r27 = new android.support.v4.media.session.a();
        r27.f394a = r23;
        r25 = r27;
        goto L22
    L19:
        if ((r26 instanceof android.support.v4.media.session.c) == false) goto L21;
        r25 = (android.support.v4.media.session.c) r26;
    L24:
        r10.onConnected();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        d r5 = (d) this.f374a.f367a;
        b r10 = r5.mConnectionCallbackInternal;
        r5.onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        d r5 = (d) this.f374a.f367a;
        b r10 = r5.mConnectionCallbackInternal;
        if (r10 == null) goto L5;
        e r11 = (e) r10;
        r11.f = null;
        r11.g = null;
        r11.f371h = null;
        a r12 = r11.d;
        r12.getClass();
        r12.f366c = new WeakReference(null);
    L5:
        r5.onConnectionSuspended();
    }
}
