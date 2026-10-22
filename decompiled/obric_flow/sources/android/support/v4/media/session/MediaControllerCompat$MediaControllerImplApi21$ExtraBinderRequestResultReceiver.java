package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f375a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r5, Bundle r10) {
        e r11 = (e) this.f375a.get();
        if (r11 == null) goto L23;
        if (r10 == null) goto L26;
        Object r12 = r11.f398b;
        monitor-enter(r12);
        MediaSessionCompat$Token r13 = r11.e;     // Catch: Throwable -> L20
        IBinder r14 = BundleCompat.getBinder(r10, "android.support.v4.media.session.EXTRA_BINDER");     // Catch: Throwable -> L20
        int r15 = b.f395a;     // Catch: Throwable -> L20
        if (r14 != null) goto L11;
        c r16 = null;
    L17:
        r13.f380b = r16;     // Catch: Throwable -> L20
        MediaSessionCompat$Token r17 = r11.e;     // Catch: Throwable -> L20
        r10.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");     // Catch: Throwable -> L20
        r17.getClass();     // Catch: Throwable -> L20
        r11.a();     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        return;
    L11:
        IInterface r18 = r14.queryLocalInterface("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L20
        if (r18 != null) goto L14;
    L16:
        a r19 = new a();     // Catch: Throwable -> L20
        r19.f394a = r14;     // Catch: Throwable -> L20
        r16 = r19;
        goto L17
    L14:
        if ((r18 instanceof c) == false) goto L16;
        r16 = (c) r18;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L26:
        return;
    }
}
