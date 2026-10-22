package fm;

import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.tasm.behavior.ui.utils.n;
import im.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements dm.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.animax.player.b f16927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f16928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16929c;
    public final ConcurrentHashMap d;
    public long e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f16930h;

    public c(com.lynx.animax.player.b r5) {
        this.f16929c = false;
        this.d = new ConcurrentHashMap();
        this.f16927a = r5;
        long r10 = System.currentTimeMillis();
        this.f16930h = r10;
        this.e = r10;
    }

    @Override // dm.c
    public final void a(n r5) {
    }

    @Override // dm.c
    public final void b(n r5) {
    }

    @Override // dm.c
    public final void c(n r5) {
    }

    @Override // dm.c
    public final void d(n r5) {
    }

    @Override // dm.c
    public final void e(n r5) {
    }

    @Override // dm.c
    public final void f(n r5) {
    }

    @Override // dm.c
    public final void g(dm.b r5) {
    }

    @Override // dm.c
    public final void h(n r5) {
        n(false);
    }

    @Override // dm.c
    public final void i(dm.a r5) {
    }

    @Override // dm.c
    public final void j(n r5) {
    }

    @Override // dm.c
    public final void k(dm.b r5) {
    }

    @Override // dm.c
    public final void l(dm.a r5) {
        IAnimaXMonitorService r10 = (IAnimaXMonitorService) this.f16927a.c(IAnimaXMonitorService.class);
        if (r10 == null) goto L6;
        r10.reportError(r5);
        return;
    }

    public final void m(String r10) {
        IAnimaXMonitorService r5 = (IAnimaXMonitorService) this.f16927a.c(IAnimaXMonitorService.class);
        WeakReference r11 = this.f16928b;
        if (r11 == null) goto L5;
        f r12 = (f) r11.get();
    L6:
        if (r12 == null) goto L14;
        if (r5 == null) goto L15;
        HashMap r13 = new HashMap(this.d);
        int r14 = this.f;
        if (r14 <= 0) goto L12;
        r13.put("play_count", Integer.valueOf(r14));
        this.f = 0;
        this.g = 0;
    L12:
        r12.a(new AnimaXMetricsCallback(r5, r10, r13));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void n(boolean r10) {
        this.f++;
        if (r10 == false) goto L5;
        this.g++;
    L5:
        long r5 = System.currentTimeMillis();
        if (this.f16929c == true) goto L8;
    L13:
        m("onPlay");
        this.f16929c = true;
        this.e = r5;
        return;
    L8:
        if (this.g >= 5) goto L13;
        if ((r5 - this.e) >= 300000) goto L13;
    }
}
