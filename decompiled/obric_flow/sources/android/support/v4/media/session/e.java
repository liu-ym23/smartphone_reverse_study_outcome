package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaController f397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f399c;
    public final HashMap d;
    public final MediaSessionCompat$Token e;

    public e(Context r5, MediaSessionCompat$Token r10) {
        this.f398b = new Object();
        this.f399c = new ArrayList();
        this.d = new HashMap();
        this.e = r10;
        MediaController r11 = new MediaController(r5, (MediaSession.Token) r10.f379a);
        this.f397a = r11;
        if (r10.f380b != null) goto L6;
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver r12 = new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(null);
        r12.f375a = new WeakReference(this);
        r11.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, r12);
        return;
    }

    public final void a() {
        if (this.e.f380b != null) goto L5;
        return;
    L5:
        ArrayList r5 = this.f399c;
        Iterator r10 = r5.iterator();
        if (r10.hasNext() == true) goto L10;
        r5.clear();
        return;
    L10:
        if (r10.next() != null) goto L14;
        d r11 = new d();
        this.d.put(null, r11);
        throw null;
    L14:
        throw new ClassCastException();
    }
}
