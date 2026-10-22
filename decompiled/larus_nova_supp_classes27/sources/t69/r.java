package t69;

import b49.e;
import b49.f;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import yj4.a;
import yj4.b;
import yj4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r implements i {
    public r() {
    }

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void e() {
    }

    public final /* synthetic */ void i(String r1, long r2, int r4) {
    }

    public final void b(int r4) {
        FLogger.a.i("FlowDoraWifiStateManager", "onGlassOpenStateChange: state=" + r4);
        FlowDoraGlassOpenState.Companion.getClass();
        FlowDoraGlassOpenState r5 = FlowDoraGlassOpenState.a.a(r4);
        Iterator<h49.i> r0 = s.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        r0.next().a(r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.a.e("FlowDoraWifiStateManager", "onGlassOpenStateChange: ", th);
        throw th;
    }

    public final void d(b r5) {
        FLogger.a.i("FlowDoraWifiStateManager", "onAlbumThumbnailData: data =" + r5);
        Iterator<h49.i> r0 = s.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        h49.i r1 = r0.next();
        byte[] r3 = r5.b;
        if (r3 != null) goto L8;
        r3 = new byte[0];
    L8:
        r1.d(new f(r3));
        goto L4
    }

    public final void f(int r4) {
        FLogger.a.i("FlowDoraWifiStateManager", "onVideoEvent: event=" + r4);
        FlowDoraGlassOpenState.Companion.getClass();
        FlowDoraGlassOpenState r5 = FlowDoraGlassOpenState.a.a(r4);
        Iterator<h49.i> r0 = s.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().e(r5);
        goto L4
    }

    public final void g(a r8) {
        FLogger.a.i("FlowDoraWifiStateManager", "onAlbumStateChanged: state=" + r8);
        Iterator<T> r0 = s.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        h49.i r1 = (h49.i) r0.next();
        Integer r3 = null;
        if (r8 == null) goto L8;
        Integer r4 = Integer.valueOf(r8.a);
    L9:
        if (r8 == null) goto L11;
        Integer r5 = Integer.valueOf(r8.b);
    L12:
        if (r8 == null) goto L14;
        Integer r6 = Integer.valueOf(r8.c);
    L15:
        if (r8 == null) goto L17;
        r3 = Integer.valueOf(r8.d);
    L17:
        r1.b(new e(r4, r5, r6, r3));
        goto L4
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final void h(int r4) {
        FLogger.a.i("FlowDoraWifiStateManager", "onAlbumSilentTrans: state=" + r4);
        Iterator<h49.i> r5 = s.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        r5.next().c();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.a.e("FlowDoraWifiStateManager", "onAlbumSilentTrans: ", th);
        throw th;
    }
}
