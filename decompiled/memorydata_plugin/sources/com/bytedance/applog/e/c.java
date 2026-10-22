package com.bytedance.applog.e;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.EventType;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.filter.h;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.exception.ExceptionType;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.g;
import com.bytedance.applog.n.i;
import com.bytedance.applog.n.j;
import com.bytedance.applog.o;
import com.bytedance.applog.p;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.applog.util.l;
import com.bytedance.applog.util.n;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.OnResetListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements Handler.Callback, Comparator<com.bytedance.applog.n.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f1570a;
    private static final List<String> c = null;
    private final com.bytedance.applog.collector.c A;
    private final com.bytedance.applog.b.a B;
    private final com.bytedance.applog.g.b C;
    private final com.bytedance.applog.k.a D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f1571b;
    private final com.bytedance.applog.c.e d;
    private final Looper e;
    private final com.bytedance.applog.b f;
    private final com.bytedance.applog.k.b g;
    private com.bytedance.applog.e.b h;
    private final ArrayList<com.bytedance.applog.n.a> i;
    private volatile com.bytedance.applog.n.b j;
    private final com.bytedance.applog.k.c k;
    private volatile Handler l;
    private List<com.bytedance.applog.e.a> m;
    private final f n;
    private p o;
    private final Handler p;
    private long q;
    private volatile boolean r;
    private final ArrayList<com.bytedance.applog.e.a> s;
    private volatile long t;
    private volatile com.bytedance.applog.filter.a u;
    private volatile o.a v;
    private volatile h w;
    private final com.bytedance.applog.filter.d x;
    private volatile com.bytedance.applog.p.c y;
    private volatile int z;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        OnResetListener f1579b;
        long c;
        CountDownLatch d;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<com.bytedance.applog.n.h> f1580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<com.bytedance.applog.n.h> f1581b;
        public boolean c;

        public b() {
            this.f1580a = new ArrayList();
            this.f1581b = new ArrayList();
            this.c = false;
        }
    }

    static {
        c = Collections.singletonList("Engine");
        f1570a = 10000;
    }

    public c(com.bytedance.applog.b r3, com.bytedance.applog.k.b r4, com.bytedance.applog.k.c r5, com.bytedance.applog.c.e r6, com.bytedance.applog.c r7, com.bytedance.applog.k.a r8, com.bytedance.applog.b.a r9) {
        com.bytedance.applog.c.e r10 = (com.bytedance.applog.c.e) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.applog.c.e.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.c r11 = (com.bytedance.applog.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.applog.c.class, "com.obric.memorydata.plugin");
        this.i = new ArrayList(32);
        this.s = new ArrayList(4);
        this.z = 0;
        this.f = r3;
        this.g = r4;
        r4.a(this);
        this.k = r5;
        this.D = r8;
        this.n = new f(this);
        this.d = r10;
        this.x = new com.bytedance.applog.filter.d(r3);
        this.B = r9;
        String r12 = a().b();
        HandlerThread r13 = new HandlerThread("bd_tracker_w:" + r12);
        r13.start();
        Handler r14 = new Handler(r13.getLooper(), this);
        this.p = r14;
        HandlerThread r15 = new HandlerThread("bd_tracker_n:" + r12);
        r15.start();
        Looper r16 = r15.getLooper();
        this.e = r16;
        r10.a(r4, i().b(), r16, r11);
        if (r3.ag() == false) goto L5;
        com.bytedance.applog.g.c r17 = new com.bytedance.applog.g.c(r3, r16, f.b());
    L6:
        this.C = r17;
        this.A = new com.bytedance.applog.collector.c(r3, r16);
        if (r3.aK() <= 0) goto L10;
        this.w = h.a(this, com.bytedance.applog.a.a(r3, "sampling_list"));
    L10:
        if (r4.b() == false) goto L12;
        this.r = true;
        r14.sendEmptyMessage(1);
        r14.sendEmptyMessageDelayed(2, 200);
    L12:
        r14.sendEmptyMessage(25);
        r14.sendEmptyMessage(10);
        if (r4.c().K() == null) goto L18;
        if (r4.q() == true) goto L18;
        this.v = r4.c().K();
    L18:
        if (a().aC() == true) goto L20;
        return;
    L20:
        if (com.bytedance.applog.a.a(a()) == false) goto L24;
        r14.sendEmptyMessageDelayed(24, 10000);
        return;
    L24:
        return;
    L5:
        r17 = null;
        goto L6
    }

    static /* synthetic */ int a(c r0) {
        return r0.z;
    }

    static /* synthetic */ int a(c r0, int r1) {
        r0.z = r1;
        return r1;
    }

    private void a(com.bytedance.applog.e.a r3, int r4) {
        if (this.l == null) goto L12;
        if (r3 == null) goto L13;
        r3.h();
        if (Looper.myLooper() == this.l.getLooper()) goto L8;
        this.l.removeMessages(6);
        Message r5 = this.l.obtainMessage(6);
        r5.arg1 = r4;
        this.l.sendMessage(r5);
        return;
    L8:
        if (r3.a() == true) goto L14;
        r3.a(r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    static /* synthetic */ void a(c r2, List r3, com.bytedance.applog.priority.b r4, String[] r5) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static /* synthetic */ void a(c r0, JSONObject r1) {
        r0.a(r1);
    }

    private void a(com.bytedance.applog.n.a r3, Iterator<com.bytedance.applog.n.a> r4, com.bytedance.applog.filter.e r5, MonitorKey r6, EventStage r7, String r8, String r9) {
        Iterator r10 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.filter.e r11 = (com.bytedance.applog.filter.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.applog.filter.e.class, "com.obric.memorydata.plugin");
        if (r11.a(r6, r8, r9) == false) goto L13;
        r10.remove();
        if (r3.s <= 0) goto L7;
        com.bytedance.applog.monitor.b.a(a().ab(), r7, r3);
    L7:
        a().ab().a(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
        if (ZeusTransformUtils.instanceOf(r11, h.class) == false) goto L10;
        a().ab().a(StatsCountKeys.SAMPLING_DROP_EVENT_COUNT);
        com.bytedance.applog.monitor.exception.b r12 = com.bytedance.applog.monitor.exception.b.a();
        ExceptionType r13 = ExceptionType.InterruptionSampling;
    L11:
        r12.a(r13, r3.o());
        a().aA().b(c, "event:{} is match filter:{} drop!", new Object[]{r8, r11});
        return;
    L10:
        r12 = com.bytedance.applog.monitor.exception.b.a();
        r13 = ExceptionType.InterruptionEventList;
        goto L11
    }

    private void a(com.bytedance.applog.n.e r5, ArrayList<com.bytedance.applog.n.a> r6) {
        if (this.g.F() != null) goto L5;
        return;
    L5:
        if (this.g.F().g() == false) goto L11;
        com.bytedance.applog.h.a r0 = this.g.F();
        String r1 = r5.u();
        if (r0.d(r1) == false) goto L12;
        a().aA().b(4, "Event: {} is match forward...", new Object[]{r1});
        r6.add(com.bytedance.applog.n.f.a(r5));
        return;
    L12:
        return;
    }

    private void a(i r3) {
        if (a().R() == true) goto L5;
        return;
    L5:
        com.bytedance.applog.p.c r2 = l();
        if (r3.t() == false) goto L8;
        r2.a(r3.f1725b, r3.d);
        return;
    L8:
        r2.b(r3.f1725b, r3.d);
    }

    private void a(String r11, i r12) {
        a(this.m, 10);
        if (r12 != null) goto L7;
        r12 = a().ax();
        if (r12 == null) goto L7;
        r12 = (i) ZeusTransformUtils.preCheckCast(r12.n(), i.class, "com.obric.memorydata.plugin");
    L7:
        ArrayList<com.bytedance.applog.n.a> r2 = new ArrayList();
        long r3 = System.currentTimeMillis();
        if (r12 == null) goto L14;
        long r5 = r3 - r12.f1725b;
        r12.a(r3);
        if (r5 >= 0) goto L13;
        r5 = 0;
    L13:
        r12.v = r5;
        r12.z = this.n.d();
        this.n.b(r12);
        r2.add(r12);
    L14:
        b(r11);
        if (r12 == null) goto L21;
        i r13 = (i) ZeusTransformUtils.preCheckCast(r12.n(), i.class, "com.obric.memorydata.plugin");
        r13.a(r3 + 1);
        r13.v = -1;
        g r14 = this.n.a(r13, r2, true);
        if (r14 == null) goto L19;
        r14.y = this.n.d();
    L19:
        this.n.b(r13);
        r2.add(r13);
    L21:
        if (r2.isEmpty() == true) goto L23;
        d().a(r2);
    L23:
        a(this.m, 10);
    }

    private void a(ArrayList<com.bytedance.applog.n.a> r22) {
        Iterator<com.bytedance.applog.n.a> r1 = r22.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        com.bytedance.applog.n.a r2 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r2.s <= 0) goto L8;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.DB_SAVE_START, r2);
    L8:
        com.bytedance.applog.monitor.b.a(r2);
        goto L4
    L9:
        Collections.sort(r22, this);
        ArrayList<com.bytedance.applog.n.a> r3 = new ArrayList(r22.size());
        com.bytedance.applog.priority.a r4 = this.g.z();
        Iterator<com.bytedance.applog.n.a> r5 = r22.iterator();
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
    L11:
        if (r5.hasNext() == false) goto L46;
        com.bytedance.applog.n.a r11 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        boolean r13 = this.n.a(r11, r3);
        boolean r14 = f.a(r11);
        if (r13 == false) goto L17;
        if (r14 == false) goto L17;
        r9 = true;
    L17:
        if (ZeusTransformUtils.instanceOf(r11, i.class) == false) goto L30;
        if (a().R() == false) goto L22;
        this.p.obtainMessage(23, r11).sendToTarget();
    L22:
        if (a().L() == true) goto L24;
    L28:
        r8 = r14;
        r7 = true;
    L42:
        if (r11.s <= 0) goto L11;
        if (com.bytedance.applog.monitor.b.b(a().ab(), r11) == true) goto L11;
        r11.s = 0;
        goto L11
    L24:
        if (a().aS() == null) goto L28;
        if (a().aS().a(EventType.Terminate.value()) == false) goto L28;
        a().aS().a(r11.d, ((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.memorydata.plugin")).x, ((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.memorydata.plugin")).v, ((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.memorydata.plugin")).A);
        r3.remove(r11);
        goto L28
    L30:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.e.class) == false) goto L34;
        com.bytedance.applog.n.e r6 = (com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r11, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin");
        r6.a(r4);
        a(r6, r3);
    L32:
        a().ab().a(StatsCountKeys.ACCEPT_EVENT_COUNT);
        goto L42
    L34:
        if (ZeusTransformUtils.instanceOf(r11, f.a.class) == false) goto L37;
        r10 = true;
        goto L42
    L37:
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.c.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r11, com.bytedance.applog.n.d.class) == false) goto L42;
    L46:
        c(r3);
        b(r3);
        Iterator<com.bytedance.applog.n.a> r12 = r3.iterator();
    L48:
        if (r12.hasNext() == false) goto L53;
        com.bytedance.applog.n.a r15 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r12.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r15.s <= 0) goto L48;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.HANDLE_REALTIME_START, r15);
        goto L48
    L53:
        if (a().L() == true) goto L55;
    L68:
        b(r3);
        if (a().al() == false) goto L79;
        Iterator<com.bytedance.applog.n.a> r16 = r22.iterator();
    L72:
        if (r16.hasNext() == false) goto L78;
        com.bytedance.applog.n.a r17 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r16.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, com.bytedance.applog.n.e.class) == false) goto L79;
        if (a().am().contains(r17.o()) == false) goto L72;
    L78:
        boolean r18 = false;
    L80:
        d().a(r3, r18);
        if (r7 == false) goto L87;
        if (r8 == false) goto L85;
        this.p.removeMessages(7);
        goto L87
    L85:
        this.p.sendEmptyMessageDelayed(7, e());
    L87:
        if (com.bytedance.applog.b.e.j == false) goto L91;
        this.B.a(r3);
        if (this.B.a() == false) goto L91;
        a().aA().d(c, "immediateReportOnCountOrSizeMatched true", new Object[0]);
        this.B.b();
        a().ab().a(StatsCountKeys.REPORT_ON_COUNT_OR_SIZE_REACHED);
        boolean r19 = true;
    L92:
        if (r9 == true) goto L99;
        if (r10 == true) goto L99;
        if (r19 == true) goto L99;
        if (this.l == null) goto L138;
        this.l.removeMessages(6);
        Message r20 = this.l.obtainMessage(6);
        r20.arg1 = 2;
        this.l.sendMessage(r20);
        return;
    L138:
        return;
    L99:
        if (r9 == false) goto L101;
        int r110 = 1;
    L104:
        a(this.m, r110);
        List<com.bytedance.applog.e.a> r21 = this.m;
        if (r21 != null) goto L107;
        return;
    L107:
        if (r21.isEmpty() == false) goto L109;
        return;
    L109:
        if ((this.z & 2) != 0) goto L142;
        a().aA().d(c, "bdinstall lost header callback", new Object[0]);
        Bundle r23 = new Bundle();
        r23.putInt("engine_state", this.z);
        this.f.a("bdinstall_lost_callback", r23);
        return;
    L142:
        return;
    L101:
        if (r10 == false) goto L103;
        r110 = 3;
        goto L104
    L103:
        r110 = 13;
    L91:
        r19 = false;
    L79:
        r18 = true;
        goto L80
    L55:
        if (a().aS() == null) goto L68;
        Iterator<com.bytedance.applog.n.a> r24 = r3.iterator();
    L58:
        if (r24.hasNext() == false) goto L68;
        final com.bytedance.applog.n.a r25 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r24.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r25, j.class) == true) goto L58;
        if (ZeusTransformUtils.instanceOf(r25, g.class) == true) goto L58;
        EventType r111 = com.bytedance.applog.util.o.a(r25);
        PriorityWrapper r112 = a().aS();
        int r113 = r111.value();
        String r114 = r25.i();
        r25.getClass();
        boolean r115 = r112.a(r113, r114, new $$Lambda$pFtNw0AAl2Uen1ABE3Ghj__1Ro(r25));
        if (r115 == false) goto L67;
        r24.remove();
    L67:
        a().aA().b(4, "event: {} is saved: {} into priority core.", new Object[]{r25.toString(), Boolean.valueOf(r115)});
        goto L58
    }

    private void a(ArrayList<com.bytedance.applog.n.a> r11, com.bytedance.applog.filter.e r12, EventStage r13) {
        com.bytedance.applog.filter.e r14 = (com.bytedance.applog.filter.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.applog.filter.e.class, "com.obric.memorydata.plugin");
        if (r14.a() == false) goto L5;
        return;
    L5:
        Iterator<com.bytedance.applog.n.a> r15 = r11.iterator();
    L7:
        if (r15.hasNext() == false) goto L18;
        com.bytedance.applog.n.a r3 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r15.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.n.e.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.n.c.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.applog.n.d.class) == false) goto L7;
        com.bytedance.applog.n.d r0 = (com.bytedance.applog.n.d) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.n.d.class, "com.obric.memorydata.plugin");
        MonitorKey r6 = MonitorKey.log_data;
        String r9 = r0.p();
        String r8 = "log_data";
    L11:
        a(r3, r15, r14, r6, r13, r8, r9);
        goto L7
    L14:
        com.bytedance.applog.n.c r1 = (com.bytedance.applog.n.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.n.c.class, "com.obric.memorydata.plugin");
        r6 = MonitorKey.event;
        r8 = r1.w;
        r9 = r1.y;
        goto L11
    L10:
        com.bytedance.applog.n.e r2 = (com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin");
        r8 = r2.u();
        r9 = r2.p();
        r6 = MonitorKey.event_v3;
        goto L11
    }

    private void a(List<com.bytedance.applog.n.a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        if (a().at().a(2) == false) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L21;
        com.bytedance.applog.n.a r0 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.c.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.e.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.d.class) == false) goto L7;
        com.bytedance.applog.n.d r1 = (com.bytedance.applog.n.d) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        a().at().b(2, r1.t(), r1.p());     // Catch: Throwable -> L19
        goto L7
    L14:
        com.bytedance.applog.n.e r2 = (com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        a().at().a(2, r2.u(), r2.p());     // Catch: Throwable -> L19
        goto L7
    L11:
        com.bytedance.applog.n.c r3 = (com.bytedance.applog.n.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        a().at().a(2, r3.v, r3.w, r3.x, r3.z, r3.A, r3.y);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        a().aA().a(4, "notify event observer before process failed", th, new Object[0]);
        a().ab().a("notify event observer before process failed", th);
        goto L7
    }

    private void a(List<? extends com.bytedance.applog.e.a> r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L12;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L13;
        a((com.bytedance.applog.e.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.e.a.class, "com.obric.memorydata.plugin"), r5);
        goto L8
    L13:
        return;
    }

    private void a(List<com.bytedance.applog.n.a> r3, com.bytedance.applog.priority.b r4, String[] r5) {
        a(r5, r4, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), i().g());
    }

    private void a(JSONObject r2) {
        this.k.b(r2);
        if ((this.z & 8) != 0) goto L6;
        this.p.removeMessages(2);
        this.p.sendEmptyMessage(2);
        return;
    }

    private void a(boolean r4, int r5, long r6, OnResetListener r8) {
        OnResetListener r9 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r8, OnResetListener.class, "com.obric.memorydata.plugin");
        CountDownLatch r0 = new CountDownLatch(1);
        Message r7 = this.p.obtainMessage(r5);
        a r1 = new a(null);
        r1.f1578a = r4;
        r1.f1579b = r9;
        r1.c = r6;
        r1.d = r0;
        r7.obj = r1;
        this.p.sendMessage(r7);
        r0.await();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        a().aA().a(c, "clearOrResetWhenSwitchChildMode interrupted", e, new Object[0]);
    }

    private void a(String[] r3, com.bytedance.applog.priority.b r4, List<com.bytedance.applog.n.a> r5, Map<String, String> r6) {
        List<com.bytedance.applog.n.a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (b(r3, r4, r7, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin")) == true) goto L11;
        Iterator<com.bytedance.applog.n.a> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        com.bytedance.applog.n.a r9 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r9.s <= 0) goto L6;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.REALTIME_SEND_FAILED, r9);
        goto L6
    L10:
        this.p.obtainMessage(8, r7).sendToTarget();
        return;
    L11:
        Iterator<com.bytedance.applog.n.a> r10 = r7.iterator();
    L13:
        if (r10.hasNext() == false) goto L17;
        com.bytedance.applog.n.a r11 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r11.s <= 0) goto L13;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.REPORT_END, r11);
        goto L13
    L17:
        a().ab().a(StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT, r7.size());
        d().a(r7);
    }

    static /* synthetic */ com.bytedance.applog.b b(c r0) {
        return r0.f;
    }

    private void b(long r9, OnResetListener r11) {
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r11, OnResetListener.class, "com.obric.memorydata.plugin");
        Env r12 = i().b();
        Env r4 = new Env(r12.getConfig(), r12.isI18n(), r12.isBoe(), r12.isChildMode());
        this.d.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r9, r7);
    }

    private void b(String r4) {
        this.d.a((Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r4);
    }

    private void b(ArrayList<com.bytedance.applog.n.a> r4) {
        if (com.bytedance.applog.util.g.a(this.f.b()) == false) goto L13;
        Iterator<com.bytedance.applog.n.a> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L21;
        com.bytedance.applog.n.a r0 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.f.class) == true) goto L6;
        String r1 = com.bytedance.applog.util.g.getType(r0);
        if (r1 == null) goto L6;
        JSONArray r2 = new JSONArray();
        r2.put(r0.m());
        com.bytedance.applog.util.g.a(this.f.b(), r1, r2);
        goto L6
    L21:
        return;
    }

    private void b(List<com.bytedance.applog.n.a> r8) {
        List<com.bytedance.applog.n.a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (com.bytedance.applog.b.e.i == true) goto L10;
        if ((System.currentTimeMillis() - this.q) >= 60000) goto L10;
        r2 = false;
    L10:
        if (this.k.i() == false) goto L23;
        if (r2 == false) goto L23;
        final ArrayList<com.bytedance.applog.n.a> r10 = this.g.a(r9);
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.isEmpty() == true) goto L40;
        Iterator<com.bytedance.applog.n.a> r0 = r10.iterator();
    L18:
        if (r0.hasNext() == false) goto L22;
        com.bytedance.applog.n.a r3 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r3.s <= 0) goto L18;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.REALTIME_SEND_START, r3);
        goto L18
    L22:
        com.bytedance.applog.p.e.a().b(new AnonymousClass4(this, r10));
        a().ab().a(StatsCountKeys.REALTIME_EVENT_COUNT, r10.size());
        return;
    L40:
        return;
    L23:
        Iterator<com.bytedance.applog.n.a> r7 = r9.iterator();
    L25:
        if (r7.hasNext() == false) goto L42;
        com.bytedance.applog.n.a r11 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r7.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r11.q() != 0) goto L25;
        r11.a(-1);
        goto L25
    }

    private void b(boolean r9, long r10, OnResetListener r12) {
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r12, OnResetListener.class, "com.obric.memorydata.plugin");
        Env r13 = i().b();
        Env r4 = new Env(r13.getConfig(), r13.isI18n(), r13.isBoe(), r9);
        this.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r10, r7);
    }

    private boolean b(String[] r12, com.bytedance.applog.priority.b r13, List<com.bytedance.applog.n.a> r14, Map<String, String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        JSONObject r17 = l.a(this.k.a());
        if (r12.length <= 0) goto L42;
        com.bytedance.applog.i r0 = a().z();
        if (r0 != null) goto L45;
    L10:
        com.bytedance.applog.n.h r18 = com.bytedance.applog.n.h.a(this.f, r16, r17, r13);
        if (com.bytedance.applog.b.e.i == true) goto L21;
        com.bytedance.applog.q.a r1 = null;
        if (r13 == null) goto L15;
        r1 = r13.d();
    L15:
        if (r1 == null) goto L21;
        if (r1.a(8) == false) goto L21;
        a().ab().a(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT);
        return false;
    L21:
        if (r18.v != null) goto L23;
    L41:
        return false;
    L23:
        if (r18.v.length <= 0) goto L41;
        int r19 = a().aw().a(r12, r18.v, this, r18.u(), r18.H, r18.I, r7, true);
        r18.x = r19;
        if (r19 != 200) goto L28;
        this.q = 0;
        boolean r110 = true;
    L34:
        com.bytedance.applog.monitor.v3.e r111 = a().ab();
        if (r110 == false) goto L37;
        StatsCountKeys r2 = StatsCountKeys.REPORT_REALTIME_EVENTS_SUCCESS_COUNT;
    L38:
        r111.a(r2, r16.size());
        if (com.bytedance.applog.log.p.a() == true) goto L43;
        e.a(a().b(), r18.v(), r110);
    L43:
        a().aA().b(c, "sendRealTime: {}", new Object[]{Boolean.valueOf(r110)});
        return r110;
    L37:
        r2 = StatsCountKeys.REPORT_REALTIME_EVENTS_FAILED_COUNT;
        goto L38
    L28:
        if (com.bytedance.applog.m.a.a(r19) == false) goto L30;
        this.q = System.currentTimeMillis();
    L30:
        if (r13 == null) goto L32;
        r13.a(r19);
    L32:
        r110 = false;
        goto L34
    L45:
        r0.a(r17);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        a().ab().a(StatsCountKeys.PACK_ERROR_COUNT);
        a().aA().a(c, "header custom callback updateHeader error", th, new Object[0]);
        a().ab().a("Realtime send IHeaderCustomTimelyCallback updateHeader failed", th);
        goto L10
    L42:
        r110 = false;
        goto L43
    }

    static /* synthetic */ com.bytedance.applog.k.b c(c r0) {
        return r0.g;
    }

    private void c(ArrayList<com.bytedance.applog.n.a> r3) {
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        a(r3, this.x, EventStage.FILTER_CUSTOM_BLOCKED);
        com.bytedance.applog.filter.a r0 = a().C();
        if (r0 == null) goto L9;
        a(r3, r0, EventStage.FILTER_EVENT_BLOCKED);
    L9:
        if (m().c().J() == false) goto L14;
        if (this.u == null) goto L14;
        a(r3, this.u, EventStage.FILTER_EVENT_BLOCKED);
    L14:
        if (this.w != null) goto L16;
    L18:
        this.g.a(r3);
        return;
    L16:
        if (a().aK() <= 0) goto L18;
        a(r3, this.w, EventStage.FILTER_SAMPLING_DROPPED);
        goto L18
    }

    private void c(List<com.bytedance.applog.n.a> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (a().aU() == false) goto L12;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        com.bytedance.applog.n.a r0 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.e.class) == false) goto L6;
        String r2 = a().aV().a(((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u(), r0.p());
        if (TextUtils.isEmpty(r2) == true) goto L6;
        ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).c(r2);
        goto L6
    L20:
        return;
    }

    private void d(List<com.bytedance.applog.n.a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        if (a().aQ() == true) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L34;
        com.bytedance.applog.n.a r0 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.applog.n.e.class) == false) goto L7;
        String r2 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).u();
        if (this.g.b(r2) == false) goto L7;
        String r3 = ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).p();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        JSONObject r7 = new JSONObject(r3);     // Catch: Throwable -> L32
        Iterator<String> r4 = r7.keys();     // Catch: Throwable -> L32
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L32
    L19:
        if (r4.hasNext() == false) goto L24;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (this.g.a(r2, r9) == true) goto L19;
        r8.add(r9);     // Catch: Throwable -> L32
        goto L19
    L24:
        if (r8.isEmpty() == true) goto L7;
        Iterator r5 = r8.iterator();     // Catch: Throwable -> L32
    L28:
        if (r5.hasNext() == false) goto L30;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        r7.remove(r10);     // Catch: Throwable -> L32
        a().aA().b(c, "event v3:{}, param:{} has been removed for server control", new Object[]{r2, r10});     // Catch: Throwable -> L32
        goto L28
    L30:
        a().ab().a(StatsCountKeys.REMOVE_EVENT_PARAM_COUNT, r8.size());     // Catch: Throwable -> L32
        ((com.bytedance.applog.n.e) ZeusTransformUtils.preCheckCast(r0, com.bytedance.applog.n.e.class, "com.obric.memorydata.plugin")).c(r7.toString());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        a().aA().b(c, "parse event v3:{} params to json failed ", new Object[]{r2, th});
        goto L7
    }

    private void d(boolean r4) {
        if (a().R() == true) goto L6;
        a().aA().a(c, "[Task] Background session task is not enabled, isResume = {} will not work!", new Object[]{Boolean.valueOf(r4)});
        return;
    L6:
        com.bytedance.applog.p.c r3 = l();
        if (r4 == false) goto L9;
        r3.a();
        return;
    L9:
        r3.b();
    }

    private void e(boolean r5) {
        Env r0 = i().b();
        Env r1 = new Env(r0.getConfig(), r0.isI18n(), r0.isBoe(), r5);
        this.d.b(r1);
        d().g();
        ArrayList<com.bytedance.applog.n.a> r6 = new ArrayList();
        i r2 = a().ax();
        if (r2 == null) goto L5;
        r2 = (i) ZeusTransformUtils.preCheckCast(r2.n(), i.class, "com.obric.memorydata.plugin");
    L5:
        if (r2 == null) goto L7;
        r2.a(System.currentTimeMillis());
        r2.v = -1;
        this.n.a(r2, r6, true);
        this.n.b(r2);
        r6.add(r2);
    L9:
        if (r6.isEmpty() == true) goto L12;
        d().a(r6);
        return;
    L12:
        return;
    L7:
        this.n.a(null, r6, false);
        goto L9
    }

    static /* synthetic */ List t() {
        return c;
    }

    private List<com.bytedance.applog.e.a> u() {
        ArrayList r0 = new ArrayList();
        com.bytedance.applog.priority.a r1 = this.g.z();
        if (r1 != null) goto L5;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L18;
        r0.add(new e(this));
    L18:
        com.bytedance.applog.h.a r3 = this.g.F();
        if (r3 != null) goto L21;
    L23:
        return r0;
    L21:
        if (r3.g() == false) goto L23;
        r0.add(new d(this, r3));
        goto L23
    L5:
        if (r1.d() == false) goto L15;
        Iterator<com.bytedance.applog.priority.b> r4 = r1.e().values().iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        com.bytedance.applog.priority.b r5 = (com.bytedance.applog.priority.b) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.priority.b.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        if (r5.a() == 0) goto L8;
        r0.add(new e(this, r5));
        goto L8
    L14:
        r2 = true;
        goto L16
    }

    private void v() {
        if (this.k.g() == this.k.b()) goto L5;
    L13:
        com.bytedance.applog.e.b r0 = this.h;
        if (r0 == null) goto L17;
        r0.h();
    L17:
        if (m().c().J() == true) goto L19;
        return;
    L19:
        if (a().ba() == false) goto L21;
        com.bytedance.applog.filter.a.a(a());
        a(null);
        return;
    L21:
        com.bytedance.applog.filter.a r1 = com.bytedance.applog.filter.a.a(a(), com.bytedance.applog.a.a(a(), "sp_filter_name"), null);
    L22:
        a(r1);
        return;
    L5:
        if (TextUtils.equals(this.g.n(), this.g.m()) == false) goto L13;
        if (m().c().J() == true) goto L10;
        return;
    L10:
        if (a().ba() == false) goto L12;
        r1 = com.bytedance.applog.filter.a.b(a());
        goto L22
    L12:
        r1 = com.bytedance.applog.filter.a.a(a(), com.bytedance.applog.a.a(a(), "sp_filter_name"));
        goto L22
    }

    private void w() {
        if (a().aS() == null) goto L6;
        a().aS().a();
        return;
    }

    private void x() {
        Env r0 = i().b();
        Env r1 = new Env(r0.getConfig(), r0.isI18n(), r0.isBoe(), r0.isChildMode());
        this.d.c(r1);
    }

    private void y() {
        if (a().aO() == true) goto L5;
    L9:
        a().ab().a(new com.bytedance.applog.monitor.v3.d.a().a());
        return;
    L5:
        if (a().ab().c() == false) goto L9;
        if (TextUtils.isEmpty(i().f()) == true) goto L9;
        a().ab().a(StatsCountKeys.PILED_UP_EVENT_COUNT, d().a());
        a().ab().a(StatsCountKeys.PILED_UP_LAUNCH_COUNT, d().b());
        a().ab().a(StatsCountKeys.PILED_UP_TERMINATE_COUNT, d().c());
        a().ab().a(StatsCountKeys.PILED_UP_PACK_COUNT, d().d());
        a().ab().a(StatsCountKeys.PILED_UP_DB_SIZE_KB, d().e());
        a().ab().a(new com.bytedance.applog.monitor.v3.d.a().a(new com.bytedance.applog.monitor.v3.c.a().a(m().l()).b(m().m()).d(m().c().r()).c(m().v()).a(m().c().w()).e("5.7.15").a(m().c().O()).f(Cdid.getMainInstanceCdid((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"))).e(!com.bytedance.applog.log.p.a()).c(m().c().D()).d(m().c().J()).b(m().c().u()).a()).a(com.bytedance.applog.d.a.b()).a(m().u()).a(a().v()).a(i().f()).a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(new AnonymousClass5(this)).a());
    }

    public int a(com.bytedance.applog.n.a r3, com.bytedance.applog.n.a r4) {
        long r2 = r3.f1725b - r4.f1725b;
        if (r2 >= 0) goto L6;
        return -1;
    L6:
        if (r2 <= 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    public com.bytedance.applog.b a() {
        return this.f;
    }

    public void a(int r2) {
        a(this.h, r2);
    }

    public void a(long r16) {
        if (this.m != null) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis();
        Iterator<com.bytedance.applog.e.a> r4 = this.m.iterator();
        long r5 = r16;
    L7:
        if (r4.hasNext() == false) goto L22;
        com.bytedance.applog.e.a r0 = (com.bytedance.applog.e.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.e.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L7;
        e r7 = (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
        if (r5 <= 0) goto L23;
        r7.b(r5);
    L23:
        r7.b(12);     // Catch: Throwable -> L16
    L18:
        r7.b(0);
        if (r16 <= 0) goto L7;
        r5 = r16 - (System.currentTimeMillis() - r2);
        if (r5 > 0) goto L7;
        return;
    L16:
        th = move-exception;
        a().aA().d(c, "force report by sender:{} failed", new Object[]{r7.g(), th});
        goto L18
    }

    public void a(long r7, OnResetListener r9) {
        a(false, 20, r7, (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r9, OnResetListener.class, "com.obric.memorydata.plugin"));
    }

    public void a(com.bytedance.applog.filter.a r1) {
        this.u = r1;
    }

    public void a(h r1) {
        this.w = r1;
    }

    public void a(com.bytedance.applog.n.a r7) {
        if (r7.f1725b != 0) goto L5;
        a().aA().d(c, "receive zero ts", new Object[0]);
    L5:
        ArrayList<com.bytedance.applog.n.a> r0 = this.i;
        monitor-enter(r0);
        int r1 = this.i.size();     // Catch: Throwable -> L38
        this.i.add(r7);     // Catch: Throwable -> L38
        monitor-exit(r0);     // Catch: Throwable -> L38
        if (r7.s <= 0) goto L12;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.DATA_LIST_ADDED, r7);
    L12:
        boolean r2 = ZeusTransformUtils.instanceOf(r7, i.class);
        if (a().aa() == false) goto L24;
        if (r2 == false) goto L16;
    L21:
        this.p.removeMessages(4);
    L22:
        this.p.sendEmptyMessage(4);
    L33:
        if (r7.s <= 0) goto L35;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.PRE_PROCESS_END, r7);
    L35:
        if (r2 == false) goto L43;
        this.A.a((i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.memorydata.plugin"));
        return;
    L43:
        return;
    L16:
        if (((r1 + 1) % a().ap()) == 0) goto L21;
        if (this.p.hasMessages(4) == true) goto L33;
        Handler r3 = this.p;
        long r4 = a().aq();
    L31:
        r3.sendEmptyMessageDelayed(4, r4);
        goto L33
    L24:
        if ((r1 % 5) == 0) goto L26;
        if (r2 == false) goto L33;
    L26:
        this.p.removeMessages(4);
        if (r1 != 0) goto L22;
        if (r2 == true) goto L22;
        r3 = this.p;
        r4 = 200;
    L38:
        th = move-exception;
        throw th;
    }

    public void a(p r1) {
        this.o = r1;
        this.d.a(r1.b());
    }

    public void a(com.bytedance.applog.priority.b r4, int r5) {
        List<com.bytedance.applog.e.a> r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L18;
        Iterator<com.bytedance.applog.e.a> r3 = this.m.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        com.bytedance.applog.e.a r1 = (com.bytedance.applog.e.a) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.e.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L8;
        ((e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L8
    L19:
        return;
    }

    public void a(String r3) {
        String r0 = this.k.d();
        if (TextUtils.isEmpty(r3) == false) goto L7;
        if (TextUtils.isEmpty(r0) == true) goto L7;
    L10:
        b(r3);
    L11:
        this.k.b(r3);
        return;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (TextUtils.equals(r3, r0) == true) goto L11;
        goto L10
    }

    public void a(String r5, String r6) {
        this.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r6);
        a(0);
    }

    public void a(boolean r2) {
        this.p.obtainMessage(26, Boolean.valueOf(r2)).sendToTarget();
    }

    public void a(boolean r7, long r8, OnResetListener r10) {
        a(r7, 19, r8, (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r10, OnResetListener.class, "com.obric.memorydata.plugin"));
    }

    public void a(String[] r3) {
        this.p.removeMessages(4);
        this.p.obtainMessage(4, r3).sendToTarget();
    }

    public void a(String[] r11, boolean r12) {
        ArrayList<com.bytedance.applog.n.a> r0 = this.i;
        monitor-enter(r0);
        ArrayList<com.bytedance.applog.n.a> r1 = (ArrayList) ZeusTransformUtils.preCheckCast(this.i.clone(), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L84
        this.i.clear();     // Catch: Throwable -> L84
        monitor-exit(r0);     // Catch: Throwable -> L84
        Iterator<com.bytedance.applog.n.a> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.applog.n.a r3 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r3.s <= 0) goto L8;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.PROCESS_START, r3);
        goto L8
    L13:
        if (r11 == null) goto L28;
        r1.ensureCapacity(r1.size() + r11.length);
        int r4 = r11.length;
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L28;
        com.bytedance.applog.n.a r6 = com.bytedance.applog.n.a.b(r11[r5]);
        if (r6 == null) goto L27;
        if (com.bytedance.applog.util.o.a(r6.b()) == true) goto L22;
    L24:
        r1.add(r6);
        if (r6.s <= 0) goto L27;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.PROCESS_START, r6);
        goto L27
    L22:
        if (com.bytedance.applog.util.o.a(a().b(), r6.b()) == true) goto L24;
    L27:
        r5 = r5 + 1;
    L28:
        a(r1);
        if (this.f.H() == true) goto L31;
    L39:
        c(r1);
        d(r1);
        Iterator<com.bytedance.applog.n.a> r13 = r1.iterator();
    L41:
        if (r13.hasNext() == false) goto L46;
        com.bytedance.applog.n.a r7 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r7.s <= 0) goto L41;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.PROCESS_END, r7);
        goto L41
    L46:
        if (r1.isEmpty() == false) goto L48;
    L65:
        if (r12 == true) goto L67;
        return;
    L67:
        if (this.g.q() == true) goto L69;
        return;
    L69:
        if (this.g.i() == false) goto L114;
        long r14 = System.currentTimeMillis();
        if (a().aZ() == true) goto L73;
    L76:
        boolean r8 = true;
    L77:
        if (r8 == false) goto L79;
        this.t = r14;
        a(this.m, 4);
        a().aA().a(c, "flush work...", new Object[0]);
    L81:
        if (a().aS() == null) goto L115;
        a().aS().b();
        return;
    L115:
        return;
    L79:
        a().aA().c(c, "flush disallowed by threshold:{} limit!", new Object[]{Long.valueOf(f1570a)});
        goto L81
    L73:
        if (Math.abs(r14 - this.t) >= f1570a) goto L76;
        r8 = false;
        goto L77
    L114:
        return;
    L48:
        if (this.g.q() == false) goto L50;
        a(r1);
        goto L65
    L50:
        Intent r15 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Collector.class);
        int r9 = r1.size();
        String[] r10 = new String[r9];
        int r16 = 0;
        int r17 = 0;
    L51:
        if (r16 >= r9) goto L54;
        r10[r16] = ((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r1.get(r16), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin")).k().toString();
        r17 = r17 + r10[r16].length();
        r16 = r16 + 1;
        goto L51
    L54:
        if (r17 >= 307200) goto L56;
    L62:
        boolean r18 = true;
    L63:
        if (r18 == false) goto L65;
        r15.putExtra("K_DATA", r10);
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).sendBroadcast(r15);
        goto L65
    L56:
        if (this.v == null) goto L62;
        r18 = this.v.a(r10);     // Catch: Throwable -> L59
    L61:
        a().aA().d(c, "IPC over 300k", new Object[0]);
    L59:
        th = move-exception;
        a().aA().c(c, "check ipc data", new Object[]{th});
        r18 = true;
        goto L61
    L31:
        if (this.f.I() == true) goto L39;
        a().aA().a(c, "not process events in tourist mode.", new Object[0]);
        Iterator<com.bytedance.applog.n.a> r19 = r1.iterator();
    L34:
        if (r19.hasNext() == false) goto L38;
        com.bytedance.applog.n.a r110 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r19.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r110.s <= 0) goto L34;
        com.bytedance.applog.monitor.b.a(a().ab(), EventStage.TOURIST_BREAK, r110);
        goto L34
    L38:
        return;
    L84:
        th = move-exception;
        throw th;
    }

    public boolean a(String r2, JSONObject r3) {
        if (this.w != null) goto L5;
        return false;
    L5:
        if (a().aK() != 0) goto L8;
        return false;
    L8:
        return this.w.a(r2, r3);
    }

    public f b() {
        return this.n;
    }

    public void b(boolean r2) {
        this.p.obtainMessage(27, Boolean.valueOf(r2)).sendToTarget();
    }

    public String c() {
        return this.n.c();
    }

    public void c(boolean r7) {
        a(r7, 18, 0, null);
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(com.bytedance.applog.n.a r3, com.bytedance.applog.n.a r4) {
        return a((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin"), (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r4, com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin"));
    }

    public com.bytedance.applog.n.b d() {
        if (this.j != null) goto L15;
        monitor-enter(this);
        com.bytedance.applog.n.b r0 = this.j;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new com.bytedance.applog.n.b(this, m().c().E());     // Catch: Throwable -> L11
    L8:
        this.j = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.j;
    }

    public long e() {
        if (a().aD() == false) goto L6;
        return 500;
    L6:
        return m().t();
    }

    public void f() {
        Handler r2 = this.p;
        if (r2 == null) goto L6;
        r2.obtainMessage(22, true).sendToTarget();
        return;
    }

    public void g() {
        Handler r2 = this.p;
        if (r2 == null) goto L6;
        r2.obtainMessage(22, false).sendToTarget();
        return;
    }

    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public com.bytedance.applog.k.c h() {
        return this.k;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r11) {
        if (r11.what == 1) goto L6;
        BlockHelper.tryBlock();
    L6:
        switch(r11.what) {
            case 1: goto L108;
            case 2: goto L90;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L7;
            case 6: goto L61;
            case 7: goto L53;
            case 8: goto L46;
            case 9: goto L7;
            case 10: goto L38;
            case 11: goto L7;
            case 12: goto L37;
            case 13: goto L7;
            case 14: goto L36;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L35;
            case 18: goto L32;
            case 19: goto L29;
            case 20: goto L26;
            case 21: goto L23;
            case 22: goto L21;
            case 23: goto L18;
            case 24: goto L16;
            case 25: goto L15;
            case 26: goto L13;
            case 27: goto L10;
            case 28: goto L8;
            default: goto L7;
        };
    L7:
        a().aA().c(c, "Not support message type", new Object[0]);
    L112:
        return true;
    L8:
        w();
        goto L112
    L15:
        y();
        goto L112
    L16:
        com.bytedance.applog.a.b.a(a(), d());
        com.bytedance.applog.a.b.b(a(), d());
        com.bytedance.applog.a.b.c(a(), d());
        goto L112
    L23:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r11.obj, a.class, "com.obric.memorydata.plugin");
        x();
        if (r12.d == null) goto L112;
    L34:
        r12.d.countDown();
        goto L112
    L26:
        r12 = (a) ZeusTransformUtils.preCheckCast(r11.obj, a.class, "com.obric.memorydata.plugin");
        b(r12.c, r12.f1579b);
        if (r12.d == null) goto L112;
    L29:
        r12 = (a) ZeusTransformUtils.preCheckCast(r11.obj, a.class, "com.obric.memorydata.plugin");
        b(r12.f1578a, r12.c, r12.f1579b);
        if (r12.d == null) goto L112;
    L32:
        r12 = (a) ZeusTransformUtils.preCheckCast(r11.obj, a.class, "com.obric.memorydata.plugin");
        e(r12.f1578a);
        if (r12.d == null) goto L112;
    L35:
        a().aA().a(c, "Start to update sender workers...", new Object[0]);
        this.s.removeAll(this.m);
        List<com.bytedance.applog.e.a> r13 = u();
        this.m = r13;
        this.s.addAll(0, r13);
        goto L112
    L36:
        a(null, true);
        goto L112
    L37:
        Object[] r14 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r11.obj, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        a((String) ZeusTransformUtils.preCheckCast(r14[0], String.class, "com.obric.memorydata.plugin"), (i) ZeusTransformUtils.preCheckCast(r14[1], i.class, "com.obric.memorydata.plugin"));
        goto L112
    L38:
        ArrayList<com.bytedance.applog.n.a> r0 = this.i;
        monitor-enter(r0);
        int r15 = this.D.a(this.i);     // Catch: Throwable -> L43
        monitor-exit(r0);     // Catch: Throwable -> L43
        a().aA().b(c, "dump cache data count: {}", new Object[]{Integer.valueOf(r15)});
        a(this.D.a(), false);
    L43:
        th = move-exception;
        throw th;
    L46:
        ArrayList<com.bytedance.applog.n.a> r16 = (ArrayList) ZeusTransformUtils.preCheckCast(r11.obj, ArrayList.class, "com.obric.memorydata.plugin");
        Iterator<com.bytedance.applog.n.a> r1 = r16.iterator();
    L48:
        if (r1.hasNext() == false) goto L52;
        com.bytedance.applog.n.a r2 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (r2.q() != 0) goto L48;
        r2.a(-1);
        goto L48
    L52:
        d().a(r16);
        goto L112
    L53:
        a().aA().b(c, "Terminate created", new Object[0]);
        ArrayList<com.bytedance.applog.n.a> r3 = this.i;
        monitor-enter(r3);
        this.i.add(f.k());     // Catch: Throwable -> L58
        monitor-exit(r3);     // Catch: Throwable -> L58
        a(null, false);
    L58:
        th = move-exception;
        throw th;
    L61:
        this.l.removeMessages(6);
        a().aA().b(c, "start to check worker to do...", new Object[0]);
        long r6 = this.g.u();
        if (this.g.c().A() == true) goto L64;
    L65:
        long r7 = Long.MAX_VALUE;
        Iterator<com.bytedance.applog.e.a> r4 = this.s.iterator();
    L67:
        if (r4.hasNext() == false) goto L73;
        com.bytedance.applog.e.a r5 = (com.bytedance.applog.e.a) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.applog.e.a.class, "com.obric.memorydata.plugin");
        if (r5.a() == true) goto L67;
        long r8 = r5.a(r11.arg1);
        if (r8 >= r7) goto L67;
        r7 = r8;
        goto L67
    L73:
        r6 = r7 - System.currentTimeMillis();
    L74:
        Message r17 = this.l.obtainMessage(6);
        r17.arg1 = 2;
        long r9 = Math.max(r6, 100);
        this.l.sendMessageDelayed(r17, r9);
        a().aA().b(c, "post check worker task with delay: {}ms.", new Object[]{Long.valueOf(r9)});
        goto L112
    L64:
        if (this.n.g() == false) goto L74;
    L75:
        a((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r11.obj, String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin"), false);
        goto L112
    L76:
        this.z |= 16;
        com.bytedance.applog.log.j r18 = a().aA();
        List<String> r10 = c;
        r18.a(r10, "start to build workers...", new Object[0]);
        if (a().aa() == false) goto L79;
        com.bytedance.applog.f.a.a().a(new AnonymousClass2(this));
    L79:
        this.g.a();
        if (TextUtils.isEmpty(i().e()) == true) goto L82;
        com.bytedance.applog.e.b r19 = new com.bytedance.applog.e.b(this);
        this.h = r19;
        this.s.add(r19);
    L82:
        List<com.bytedance.applog.e.a> r110 = u();
        this.m = r110;
        this.s.addAll(r110);
        a().aA().a(r10, "{} workers prepared", new Object[]{Integer.valueOf(this.s.size())});
        v();
        if (m().c() != null) goto L85;
    L87:
        this.l.removeMessages(6);
        this.l.sendEmptyMessage(6);
        if (com.bytedance.applog.log.p.a() == true) goto L112;
        com.bytedance.applog.log.p.a("start_end", new AnonymousClass3(this));
        goto L112
    L85:
        if (m().c().O() == false) goto L87;
        a().aV().a(true);
        goto L87
    L90:
        com.bytedance.applog.log.j r111 = a().aA();
        List<String> r20 = c;
        r111.a(r20, "start to check header ready...", new Object[0]);
        if (this.g.q() == true) goto L93;
        a().aA().c(r20, "workers will not start for current is not the main process!", new Object[0]);
        goto L112
    L93:
        if (this.k.i() == false) goto L101;
        this.z |= 8;
        this.l = new Handler(this.e, this);
        this.l.sendEmptyMessage(3);
        if (a().aT() == false) goto L98;
        w();
    L98:
        if (this.i.size() <= 0) goto L100;
        this.p.removeMessages(4);
        this.p.sendEmptyMessageDelayed(4, 1000);
    L100:
        a().aA().a(r20, "net handler start work", new Object[0]);
        goto L112
    L101:
        this.p.removeMessages(2);
        JSONObject r112 = new JSONObject();
        if (this.d.a(r112) == true) goto L104;
    L106:
        this.p.sendEmptyMessageDelayed(2, 1000);
        a().aA().a(r20, "header not ready, will check gain after 1s...", new Object[0]);
        goto L112
    L104:
        if (this.k.a(r112) == false) goto L106;
        this.k.b(r112);
        this.p.sendEmptyMessage(2);
        a().aA().a(r20, "net handler start work by get", new Object[0]);
        goto L112
    L108:
        this.z |= 1;
        com.bytedance.applog.log.j r113 = a().aA();
        List<String> r21 = c;
        r113.a(r21, "start bdinstall...", new Object[0]);
        if (this.g.q() == false) goto L111;
        a().aA().a(r21, "start add observers to bdinstall...", new Object[0]);
        this.d.m();
        this.d.a(new AnonymousClass1(this));
    L111:
        a().aA().a(r21, "start bdinstall service begin", new Object[0]);
        this.d.a();
        a().aA().a(r21, "start bdinstall service end", new Object[0]);
        goto L112
    L10:
        if (ZeusTransformUtils.instanceOf(r11.obj, Boolean.class) == false) goto L112;
        d().b(((Boolean) ZeusTransformUtils.preCheckCast(r11.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L112
    L13:
        if (ZeusTransformUtils.instanceOf(r11.obj, Boolean.class) == false) goto L112;
        d().a(((Boolean) ZeusTransformUtils.preCheckCast(r11.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L112
    L18:
        if (ZeusTransformUtils.instanceOf(r11.obj, i.class) == false) goto L112;
        a((i) ZeusTransformUtils.preCheckCast(r11.obj, i.class, "com.obric.memorydata.plugin"));
        goto L112
    L21:
        if (ZeusTransformUtils.instanceOf(r11.obj, Boolean.class) == false) goto L112;
        d(((Boolean) ZeusTransformUtils.preCheckCast(r11.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L112
    }

    public p i() {
        if (this.o != null) goto L8;
        p r0 = m().c().l();
        this.o = r0;
        if (r0 != null) goto L8;
        this.o = n.a(0);
    L8:
        return this.o;
    }

    public void j() {
        if (this.r == true) goto L6;
        this.r = true;
        this.p.sendEmptyMessage(1);
        this.p.sendEmptyMessageDelayed(2, 200);
        return;
    }

    public void k() {
        Handler r0 = this.p;
        if (r0 == null) goto L6;
        r0.removeMessages(28);
        this.p.sendEmptyMessage(28);
        return;
    }

    public com.bytedance.applog.p.c l() {
        if (this.y != null) goto L15;
        monitor-enter(this);
        com.bytedance.applog.p.c r0 = this.y;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        r0 = new com.bytedance.applog.p.c(a(), d(), this.k);     // Catch: Throwable -> L11
    L8:
        this.y = r0;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.y;
    }

    public com.bytedance.applog.k.b m() {
        return this.g;
    }

    public void n() {
        this.p.removeMessages(14);
        this.p.sendEmptyMessage(14);
    }

    public h o() {
        return this.w;
    }

    public void p() {
        if (this.l == null) goto L6;
        this.l.sendEmptyMessage(17);
        return;
    }

    public void q() {
        a(false, 21, 0, null);
    }

    public com.bytedance.applog.b.a r() {
        return this.B;
    }

    public com.bytedance.applog.g.b s() {
        return this.C;
    }
}
