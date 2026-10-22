package com.bytedance.applog.e;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.applog.EventType;
import com.bytedance.applog.i;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.exception.ExceptionScene;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.h;
import com.bytedance.applog.util.l;
import com.bytedance.applog.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e extends a {
    private static final List<String> f = null;
    private final long[] g;
    private final ConcurrentHashMap<String, com.bytedance.applog.q.b> h;
    private final com.bytedance.applog.priority.b i;
    private final String j;
    private long k;
    private int l;

    static {
        f = Collections.singletonList("Sender");
    }

    e(c r4) {
        super(r4);
        this.g = new long[]{10000};
        this.h = new ConcurrentHashMap();
        this.k = 0;
        this.l = 0;
        this.i = null;
        this.j = "Sender";
    }

    e(c r6, com.bytedance.applog.priority.b r7) {
        super(r6);
        long[] r8 = {10000};
        this.g = r8;
        this.h = new ConcurrentHashMap();
        this.k = 0;
        this.l = 0;
        this.i = r7;
        this.j = "Sender_p_" + r7.a();
        long r3 = r7.c();
        if (r3 >= 10000) goto L6;
        r8[0] = r3;
        return;
    }

    private c.b a(com.bytedance.applog.k.b r30, String[] r31, List<h> r32, int r33, Map<String, String> r34, long r35) {
        String r3 = "com.obric.memorydata.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin");
        c.b r5 = new c.b();
        Iterator r6 = r2.iterator();
        char r7 = 0;
        int r8 = 0;
    L4:
        if (r6.hasNext() == false) goto L87;
        h r9 = (h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, r3);
        j r11 = b().aA();
        List<String> r12 = f;
        Object[] r13 = new Object[1];
        r13[r7] = this.j;
        r11.b(r12, "{} work start send pack...", r13);
        com.bytedance.applog.b.a r14 = this.f1568a.r();
        if (r14.e() == false) goto L22;
        List<EventType> r15 = r14.f();
        if (r15.contains(EventType.Launch) == true) goto L10;
    L12:
        char r16 = 1;
    L14:
        if (r15.contains(EventType.Terminate) == true) goto L16;
    L18:
        if (r16 == 0) goto L22;
        b().ab().a(StatsCountKeys.COLD_START_BLOCK_REQUEST_COUNT);
    L20:
        String r25 = r3;
        Map<? extends String, ? extends String> r24 = r4;
        Iterator r28 = r6;
    L85:
        r4 = r24;
        r3 = r25;
        r6 = r28;
        r7 = 0;
        goto L4
    L16:
        if (r9.y() == false) goto L18;
        r16 = r7;
        goto L18
    L10:
        if (r9.x() == false) goto L12;
        r16 = r7;
    L22:
        if (c(r35) == true) goto L23;
        HashMap r17 = new HashMap();
        if (r4 != null) goto L27;
    L29:
        Map<String, String> r18 = this.f1568a.i().g();
        if (r18 == null) goto L35;
        if (r18.isEmpty() == true) goto L35;
        r17.putAll(r18);
    L35:
        if (r9.v != null) goto L37;
    L84:
        r25 = r3;
        r24 = r4;
        r28 = r6;
        r5.f1580a.add(r9);
        b().aA().c(r12, "{} send empty pack: {}", new Object[]{this.j, r9});
        goto L85
    L37:
        if (r9.v.length == 0) goto L84;
        com.bytedance.applog.q.a r19 = a(r30);
        if (r19 == null) goto L45;
        if (r19.a(r33) == false) goto L45;
        b().ab().a(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT);
        b().aA().c(r12, "{} backoff request as ratio not allowed to send: {}", new Object[]{this.j, r9});
    L45:
        if (b().J() == true) goto L47;
    L49:
        r24 = r4;
        b().aA().b(r12, "{} send pack start: {}", new Object[]{this.j, r9});
        if (b().ab().d() == false) goto L55;
        Iterator<com.bytedance.applog.monitor.v3.h> r10 = r9.w().iterator();
    L53:
        if (r10.hasNext() == false) goto L55;
        com.bytedance.applog.monitor.b.a(b().ab(), EventStage.POST_START, (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.applog.monitor.v3.h.class, r3));
    L55:
        int r20 = r31.length;
        r25 = r3;
        int r110 = 0;
        int r111 = 0;
        boolean r112 = false;
    L56:
        if (r110 >= r20) goto L71;
        String r113 = r31[r110];
        if (com.bytedance.applog.b.e.f1531a == false) goto L60;
        boolean r114 = a(r113, r9);
    L61:
        boolean r26 = r114;
        if (r26 == true) goto L64;
        b().ab().a(StatsCountKeys.CONGESTION_BLOCK_REQUEST_COUNT);
        int r27 = r20;
        r28 = r6;
        b().aA().c(f, "{} CongestionController not allowed uri:{} to send pack: {}", new Object[]{this.j, r113, r9});
    L70:
        r110 = r110 + 1;
        r31 = r31;
        r112 = r26;
        r20 = r27;
        r6 = r28;
        goto L56
    L64:
        r27 = r20;
        r28 = r6;
        b().aA().b(f, "{} send pack:{} to uri: {}", new Object[]{this.j, r9, r113});
        r111 = b().aw().a(new String[]{r113}, r9.v, this.f1568a, r9.u(), r9.H, r9.I, r17, true);
        if (com.bytedance.applog.m.a.a(r111) == false) goto L68;
        c(r113).c();
        goto L70
    L68:
        if (r111 != 200) goto L70;
        c(r113).d();
        r112 = r26;
    L72:
        r9.x = r111;
        b().aA().b(f, "{} send pack end: {}, resp code: {}", new Object[]{this.j, r9, Integer.valueOf(r111)});
        if (com.bytedance.applog.m.a.a(r111) == true) goto L74;
        if (r111 != 200) goto L78;
        a(r9, true);
        a(b(), r9, true);
        this.l++;
        r8 = r8 + 1;
        goto L85
    L78:
        a(r9, false);
        a(b(), r9, false);
        com.bytedance.applog.priority.b r1 = this.i;
        if (r1 == null) goto L81;
        r1.a(r111);
    L81:
        b().ab().a(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
        if (r112 == true) goto L85;
        r5.c = true;
        goto L85
    L74:
        a(r9, false);
        a(b(), r9, false);
        b().ab().a(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
        goto L87
    L60:
        r114 = a(r113);
        goto L61
    L71:
        r28 = r6;
        goto L72
    L47:
        if (r9.a(this.f1568a.b()) == false) goto L49;
        b().ab().a(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT);
        b().aA().c(r12, "{} adjust terminate not allowed to send: {}", new Object[]{this.j, r9});
        goto L20
    L27:
        if (r4.isEmpty() == true) goto L29;
        r17.putAll(r4);
        goto L29
    L23:
        j r21 = b().aA();
        Object[] r22 = new Object[1];
        r22[r7] = this.j;
        r21.b(r12, "{} work is timeout, break send pack", r22);
    L87:
        if (com.bytedance.applog.b.e.h == true) goto L89;
    L91:
        return r5;
    L89:
        if (r2.size() == r8) goto L91;
        b().aA().b(f, "{} send pack not all success, multi query pack abort.", new Object[]{this.j});
        r5.c = true;
        goto L91
    }

    private com.bytedance.applog.q.a a(com.bytedance.applog.k.b r1) {
        com.bytedance.applog.priority.b r0 = this.i;
        if (r0 == null) goto L7;
        return r0.d();
    L7:
        return r1.A();
    }

    private List<h> a(com.bytedance.applog.n.b r11, int r12) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList<h> r13 = r11.a(r12, this.i);
        com.bytedance.applog.isolate.b r14 = b().U();
        if (b().T() == null) goto L6;
        if (r14 == null) goto L6;
        r14.a();
    L6:
        Iterator<h> r15 = r13.iterator();
    L7:
        int r4 = 1;
        if (r15.hasNext() == false) goto L25;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r15.next(), h.class, "com.obric.memorydata.plugin");
        if (b().T() == null) goto L18;
        if (r14 == null) goto L18;
        DataIsolateKey r6 = r3.A();
        if (r6 == null) goto L18;
        if (r14.a(r6, r3.B()) == true) goto L18;
        b().aA().b(f, "Pack:{} is not allowed send by isolate rule [{}, {}]", new Object[]{r3, r6, r3.B()});
        b().ab().a("disable_report_by_isolate:" + r6);
    L18:
        if (r3.x() == true) goto L19;
        if (r3.y() == true) goto L22;
        r0.add(r3);
        goto L7
    L22:
        r2.add(r3);
        goto L7
    L19:
        r1.add(r3);
        goto L7
    L25:
        if (b().T() == null) goto L29;
        if (r14 == null) goto L29;
        r14.b();
    L29:
        if (r2.isEmpty() == true) goto L32;
        r1.addAll(r2);
    L32:
        if (r1.isEmpty() == false) goto L34;
    L39:
        return r0;
    L34:
        if (this.l <= 0) goto L36;
    L37:
        r4 = 0;
    L38:
        r0.addAll(r4, r1);
        goto L39
    L36:
        if (r0.isEmpty() == false) goto L38;
        goto L37
    }

    public static void a(com.bytedance.applog.b r4, h r5, boolean r6) {
        if (r4.ab().d() == false) goto L12;
        Iterator<com.bytedance.applog.monitor.v3.h> r0 = r5.w().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        com.bytedance.applog.monitor.v3.h r1 = (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.monitor.v3.e r2 = r4.ab();
        if (r6 == false) goto L10;
        EventStage r3 = EventStage.REPORT_END;
    L11:
        com.bytedance.applog.monitor.b.a(r2, r3, r1);
        goto L6
    L10:
        r3 = EventStage.POST_FAILED;
    L12:
        r5.a(r4.ab(), r6);
        if (p.a() == true) goto L19;
        a(r4.b(), r5.v(), r6);
        return;
    }

    private void a(h r3, boolean r4) {
        com.bytedance.applog.n.b r2 = this.f1568a.d();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (r4 == false) goto L5;
        r0.add(r3);
    L6:
        r2.setResult(r0, r1);
        return;
    L5:
        r1.add(r3);
        goto L6
    }

    public static void a(final String r2, Set<Long> r3, final boolean r4) {
        final Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return;
    L8:
        if (p.a() == false) goto L10;
        return;
    L10:
        p.a("event_upload_eid", new AnonymousClass1(r2, r5, r4));
    }

    private boolean a(int r13, long r14) {
        com.bytedance.applog.n.b r0 = this.f1568a.d();
        int r1 = b().aE();
        if (r13 != 4) goto L5;
        r1 = 8;
    L9:
        List<h> r5 = a(r0, r1);
        if (r5.size() < r1) goto L12;
        boolean r2 = true;
    L14:
        if (r5.isEmpty() == true) goto L30;
        com.bytedance.applog.k.b r3 = this.f1568a.m();
        String[] r4 = b().av().a(this.f1568a, false, this.i);
        if (b().S() == false) goto L23;
        com.bytedance.applog.isolate.b r6 = b().U();
        HashMap r7 = new HashMap();
        if (r6 == null) goto L22;
        Map<String, String> r8 = r6.c();
        if (r8 == null) goto L22;
        r7.putAll(r8);
    L22:
        c.b r12 = a(r3, r4, r5, r13, r7, r14);
    L24:
        if (r2 == false) goto L29;
        if (r12.c == true) goto L29;
        return true;
    L29:
        return false;
    L23:
        r12 = a(r3, r4, r5, r13, null, r14);
        goto L24
    L30:
        return false;
    L12:
        r2 = false;
        goto L14
    L5:
        if (r13 != 12) goto L9;
        r1 = 16;
        goto L9
    }

    private boolean a(String r2) {
        if (o.b(r2) == false) goto L7;
        return false;
    L7:
        return c(r2).b();
    }

    private boolean a(String r2, h r3) {
        if (o.b(r2) == false) goto L7;
        return false;
    L7:
        return c(r2).a(r3);
    }

    private String b(String r1) {
        if (o.b(r1) == true) goto L9;
        return Uri.parse(r1).getHost();
    L10:
        return r1;
    L9:
        return r1;
    }

    private com.bytedance.applog.q.b c(String r6) {
        String r7 = b(r6);
        if (this.h.containsKey(r7) == true) goto L5;
        this.h.put(r7, new com.bytedance.applog.q.b(this.j + ParameterizedMessage.ERROR_MSG_SEPARATOR + r7, this.f1568a.m(), this.i));
    L5:
        com.bytedance.applog.q.b r0 = (com.bytedance.applog.q.b) ZeusTransformUtils.preCheckCast(this.h.get(r7), com.bytedance.applog.q.b.class, "com.obric.memorydata.plugin");
        b().aA().a(f, "{} congestion for host:{} is {}", new Object[]{this.j, r7, r0});
        return r0;
    }

    private boolean c(long r5) {
        if (this.k > 0) goto L6;
        return false;
    L6:
        if ((System.currentTimeMillis() - r5) < this.k) goto L9;
        return true;
    L9:
        return false;
    }

    void a(com.bytedance.applog.priority.b r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3 != this.i) goto L11;
        Iterator<com.bytedance.applog.q.b> r2 = this.h.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        ((com.bytedance.applog.q.b) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.q.b.class, "com.obric.memorydata.plugin")).a(r4);
        goto L7
    L12:
        return;
    }

    public void b(long r1) {
        this.k = r1;
    }

    @Override // com.bytedance.applog.e.a
    public synchronized boolean b(int r12) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L57
        f r2 = this.f1568a.b();     // Catch: Throwable -> L57
        j r3 = b().aA();     // Catch: Throwable -> L57
        List<String> r4 = f;     // Catch: Throwable -> L57
        Object[] r6 = new Object[4];     // Catch: Throwable -> L57
        boolean r8 = false;
        int r9 = 0;
        r6[0] = this.j;     // Catch: Throwable -> L57
        r6[1] = Long.valueOf(r0);     // Catch: Throwable -> L57
        if (r2 == null) goto L6;
        String r10 = r2.c();     // Catch: Throwable -> L57
    L7:
        r6[2] = r10;     // Catch: Throwable -> L57
        r6[3] = Integer.valueOf(r12);     // Catch: Throwable -> L57
        r3.b(r4, "{} start doWork curTs={}, curSid={}, requestFrom={}", r6);     // Catch: Throwable -> L57
        if (b().H() == false) goto L15;
        if (b().I() == true) goto L15;
        com.bytedance.applog.monitor.exception.b.a().a(ExceptionScene.DataUpload);     // Catch: Throwable -> L57
        b().aA().c(r4, "{} not send events in tourist mode", new Object[]{this.j});     // Catch: Throwable -> L57
        monitor-exit(this);
        return true;
    L15:
        if (this.f1568a.r().c() == false) goto L20;
        b().ab().a(StatsCountKeys.COLD_START_BLOCK_REQUEST_COUNT);     // Catch: Throwable -> L57
        b().aA().b(r4, "{} shouldBlockReporting, will not do send.", new Object[]{this.j});     // Catch: Throwable -> L57
        monitor-exit(this);
        return false;
    L20:
        if (r2 != null) goto L22;
    L25:
        com.bytedance.applog.n.b r5 = this.f1568a.d();     // Catch: Throwable -> L57
        com.bytedance.applog.k.c r7 = this.f1568a.h();     // Catch: Throwable -> L57
        if (r7.e() == false) goto L53;
        JSONObject r11 = l.a(r7.a());     // Catch: Throwable -> L57
        i r13 = b().z();     // Catch: Throwable -> L57
        if (r13 != null) goto L60;
    L33:
        com.bytedance.applog.priority.b r14 = this.i;     // Catch: Throwable -> L57
        if (r14 != null) goto L36;
    L39:
        r5.a(r11, this.i, r12, b().aL());     // Catch: Throwable -> L57
    L41:
        if (c(r0) == false) goto L43;
        b().aA().b(f, "{} work is timeout, will not do send.", new Object[]{this.j});     // Catch: Throwable -> L57
    L52:
        r8 = true;
    L54:
        this.f1568a.r().b();     // Catch: Throwable -> L57
        monitor-exit(this);
        return r8;
    L43:
        if (com.bytedance.applog.b.e.f == true) goto L45;
        a(r12, r0);     // Catch: Throwable -> L57
    L45:
        if (r9 >= com.bytedance.applog.b.e.g) goto L52;
        if (a(r12, r0) == false) goto L52;
        r9 = r9 + 1;     // Catch: Throwable -> L57
        goto L45
    L36:
        if (r14.e() == true) goto L39;
        r5.a(r11, this.i, r12);     // Catch: Throwable -> L57
        goto L41
    L60:
        r13.a(r11);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        b().ab().a(StatsCountKeys.PACK_ERROR_COUNT);     // Catch: Throwable -> L57
        b().aA().a(f, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L57
        this.f1568a.a().ab().a("Sender IHeaderCustomTimelyCallback updateHeader failed", th);     // Catch: Throwable -> L57
        goto L33
    L53:
        this.f1568a.a().ab().a("Sender failed due to invalid did", null);     // Catch: Throwable -> L57
        com.bytedance.applog.monitor.exception.b.a().b(ExceptionScene.DataUpload);     // Catch: Throwable -> L57
        goto L54
    L22:
        Bundle r15 = r2.a(r0, 50000);     // Catch: Throwable -> L57
        if (r15 == null) goto L25;
        b().a("play_session", r15);     // Catch: Throwable -> L57
        this.f1568a.a(null, false);     // Catch: Throwable -> L57
        goto L25
    L6:
        r10 = "null";
    L57:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.e.a
    public boolean d() {
        return !this.f1569b;
    }

    @Override // com.bytedance.applog.e.a
    public long e() {
        if (this.i == null) goto L14;
        com.bytedance.applog.priority.a r0 = this.f1568a.m().z();
        if (r0 == null) goto L12;
        if (r0.f() == false) goto L12;
        long r1 = this.f1568a.m().u();
        if (r1 > this.i.c()) goto L12;
        return r1;
    L12:
        return this.i.c();
    L14:
        return this.f1568a.m().u();
    }

    @Override // com.bytedance.applog.e.a
    public long[] f() {
        return this.g;
    }

    @Override // com.bytedance.applog.e.a
    public String g() {
        return this.j;
    }
}
