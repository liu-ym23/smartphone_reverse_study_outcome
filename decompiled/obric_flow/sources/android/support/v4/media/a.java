package android.support.v4.media;

import android.graphics.SurfaceTexture;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f366c;

    public a(Looper r5, FirstFrameAwareSurfaceTexture r10, SurfaceTexture.OnFrameAvailableListener r11) {
        this.f364a = 1;
        super(r5);
        this.f365b = new WeakReference(r10);
        this.f366c = new WeakReference(r11);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r10) {
        switch(this.f364a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        FirstFrameAwareSurfaceTexture r11 = (FirstFrameAwareSurfaceTexture) this.f365b.get();
        if (r11 == null) goto L46;
        SurfaceTexture.OnFrameAvailableListener r12 = (SurfaceTexture.OnFrameAvailableListener) this.f366c.get();
        if (r12 == null) goto L45;
        r12.onFrameAvailable(r11);
        return;
    L45:
        return;
    L46:
        return;
    L11:
        WeakReference r5 = this.f366c;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.get() == null) goto L48;
        WeakReference r13 = this.f365b;
        if (r13.get() == null) goto L55;
        Bundle r14 = r10.getData();
        android.support.v4.media.session.f.a(r14);
        e r15 = (e) r13.get();
        Messenger r16 = (Messenger) this.f366c.get();
        int r17 = r10.what;     // Catch: BadParcelableException -> L40
        if (r17 != 1) goto L23;
        android.support.v4.media.session.f.a(r14.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));     // Catch: BadParcelableException -> L40
        r14.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);     // Catch: BadParcelableException -> L40
        MediaSessionCompat$Token r18 = (MediaSessionCompat$Token) r14.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN);     // Catch: BadParcelableException -> L40
        r15.getClass();     // Catch: BadParcelableException -> L40
        return;
    L23:
        if (r17 != 2) goto L25;
        r15.getClass();     // Catch: BadParcelableException -> L40
        return;
    L25:
        if (r17 == 3) goto L27;
        Log.w("MediaBrowserCompat", "Unhandled message: " + r10 + "\n  Client version: 1\n  Service version: " + r10.arg1);     // Catch: BadParcelableException -> L40
        return;
    L27:
        android.support.v4.media.session.f.a(r14.getBundle(MediaBrowserProtocol.DATA_OPTIONS));     // Catch: BadParcelableException -> L40
        android.support.v4.media.session.f.a(r14.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS));     // Catch: BadParcelableException -> L40
        String r19 = r14.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);     // Catch: BadParcelableException -> L40
        r14.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST);     // Catch: BadParcelableException -> L40
        if (r15.g == r16) goto L31;
        return;
    L31:
        if (r15.e.get(r19) != 0) goto L36;
        if (f.f372b == false) goto L51;
        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r19);     // Catch: BadParcelableException -> L40
        return;
    L51:
        return;
    L36:
        throw new ClassCastException();     // Catch: BadParcelableException -> L40
    L40:
        Log.e("MediaBrowserCompat", "Could not unparcel the data.");
        if (r10.what != 1) goto L54;
        r15.getClass();
        return;
    L54:
        return;
    L55:
        return;
    }

    public a(e r5) {
        this.f364a = 0;
        this.f365b = new WeakReference(r5);
    }
}
