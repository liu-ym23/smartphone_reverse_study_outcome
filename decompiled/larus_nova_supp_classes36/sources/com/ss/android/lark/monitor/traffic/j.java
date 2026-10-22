package com.ss.android.lark.monitor.traffic;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends com.ss.android.lark.monitor.a {
    public com.ss.android.lark.monitor.i a;
    public long b;
    public volatile boolean c;
    public List<c> d;
    public n e;
    public i f;
    public d g;
    public b h;
    public m i;
    public g j;
    public RustSdkTrafficHandler k;
    public int l;

    public final void d() {
        k r1 = new k();
        r1.K = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
        Iterator r2 = ((ArrayList) this.d).iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        ((c) r2.next()).a(r1);
        goto L4
    L7:
        if (((((((r1.a + r1.f) + r1.k) + r1.p) + r1.u) + r1.z) + r1.E) > 0.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return;
    L12:
        r1.J = (System.currentTimeMillis() - this.b) / 1000.0f;
        JSONObject r4 = r1.a();     // Catch: Exception -> L26
        if (r4 != null) goto L16;
        return;
    L16:
        isb.a.c("app_network_cost", r4);     // Catch: Exception -> L26
        Log.i("TrafficMonitor", "network consumption reportResult:" + r4);     // Catch: Exception -> L26
        int r5 = this.l;     // Catch: Exception -> L26
        if (r5 == 0) goto L19;
        if (r5 == 1) goto L19;
    L20:
        float r6 = r1.b;     // Catch: Exception -> L26
        if (r6 > 400000.0f) goto L23;
        return;
    L23:
        if ((r6 / r1.J) <= 165.0f) goto L33;
        Log.e("App Mobile TrafficException", new Throwable("foreground/background cost " + (r1.b / 1024.0f) + " M mobile traffic, time interval is(s) " + r1.J), true);     // Catch: Exception -> L26
        return;
    L33:
        return;
    L19:
        this.h.c();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.i("TrafficMonitor", "[onTriggerTrafficMetrics]" + e);
        return;
    L9:
        r3 = false;
        goto L10
    }

    public j(com.ss.android.lark.monitor.i r3) {
        this.c = false;
        this.a = r3;
        this.d = new ArrayList();
        this.e = new n();
        this.g = new d();
        this.h = new b();
        this.i = new m();
        this.j = new g();
        this.k = new RustSdkTrafficHandler();
        List<c> r0 = this.d;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new f(r3));
        List<c> r4 = this.d;
        ArrayList r5 = (ArrayList) r4;
        r5.add(this.k);
        List<c> r6 = this.d;
        ArrayList r7 = (ArrayList) r6;
        r7.add(this.e);
        List<c> r8 = this.d;
        ArrayList r9 = (ArrayList) r8;
        r9.add(this.g);
        List<c> r10 = this.d;
        ArrayList r11 = (ArrayList) r10;
        r11.add(this.h);
        List<c> r12 = this.d;
        ArrayList r13 = (ArrayList) r12;
        r13.add(this.i);
        List<c> r14 = this.d;
        ArrayList r15 = (ArrayList) r14;
        r15.add(this.j);
        this.c = true;
        this.b = System.currentTimeMillis();
        if (this.a.d == false) goto L6;
        i r16 = new i();
        this.f = r16;
        Log.d("Verify", "start get app current traffic statistics ");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r16));
        this.a.b.b();
        return;
    }

    @Override // com.ss.android.lark.monitor.a
    public final void a(y r2, int r3) {
        if (this.c == true) goto L5;
        return;
    L5:
        this.l = r3;
        if (this.a.d == false) goto L8;
        i r4 = this.f;
        r4.getClass();
        Log.d("Verify", "start get app current traffic statistics ");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r4));
    L8:
        monitor-enter(this);
        Iterator r5 = ((ArrayList) this.d).iterator();     // Catch: Throwable -> L20
    L11:
        if (r5.hasNext() == false) goto L13;
        ((c) r5.next()).b();     // Catch: Throwable -> L20
        goto L11
    L13:
        d();     // Catch: Throwable -> L20
        Iterator r6 = ((ArrayList) this.d).iterator();     // Catch: Throwable -> L20
    L15:
        if (r6.hasNext() == false) goto L17;
        ((c) r6.next()).reset();     // Catch: Throwable -> L20
        goto L15
    L17:
        this.b = System.currentTimeMillis();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void c(long r6, String r8) {
        m r0 = this.i;
        if (r0 == null) goto L25;
        com.ss.android.lark.monitor.i r1 = this.a;
        if (r1 == null) goto L30;
        String r2 = r1.e;
        r0.getClass();
        StringBuilder r3 = new StringBuilder();
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        r3.append(r8);
        r3.append(" cost(Kb) ");
        r3.append(r6 / 1024);
        Log.i("VideoPlayTraffic", r3.toString());
        if (isb.a.b() == true) goto L18;
        monitor-enter(r0);
        r0.b.mobileBytesRx += r6;     // Catch: Throwable -> L15
        r0.b.mobileBytesTx += 0;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        monitor-enter(r0);
        r0.b.wifiBytesRx += r6;     // Catch: Throwable -> L22
        r0.b.wifiBytesTx += 0;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L30:
        return;
    }

    public final void b(String r5, long r6, long r8) {
        b r0 = this.h;
        if (r0 == null) goto L19;
        String r1 = this.a.e;
        r0.getClass();
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (r0.b.containsKey(r5) == false) goto L9;
        TrafficMetrics r2 = r0.b.get(r5);     // Catch: Throwable -> L16
    L10:
        r2.from = r5;     // Catch: Throwable -> L16
        if (isb.a.b() == true) goto L13;
        r2.mobileBytesRx += r6;     // Catch: Throwable -> L16
        r2.mobileBytesTx += r8;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        r2.wifiBytesRx += r6;     // Catch: Throwable -> L16
        r2.wifiBytesTx += r8;     // Catch: Throwable -> L16
        goto L14
    L9:
        r2 = new TrafficMetrics();     // Catch: Throwable -> L16
        r0.b.put(r5, r2);     // Catch: Throwable -> L16
        goto L10
    }
}
