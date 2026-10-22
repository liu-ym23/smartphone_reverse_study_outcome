package com.bytedance.applog.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.EventType;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.g;
import com.bytedance.applog.n.i;
import com.bytedance.applog.n.j;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static volatile boolean e;
    private static final List<String> f = null;
    private static final String v = null;
    private static final AtomicInteger w = null;
    private static a x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f1586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f1587b;
    public volatile int c;
    public volatile int d;
    private volatile long g;
    private final c h;
    private i i;
    private i j;
    private String k;
    private final AtomicLong l;
    private volatile long m;
    private int n;
    private long o;
    private volatile boolean p;
    private long q;
    private int r;
    private String s;
    private volatile String t;
    private volatile long u;

    static class a extends j {
        a() {
        }
    }

    static {
        f = Collections.singletonList("Session");
        v = UUID.randomUUID().toString();
        w = new AtomicInteger(0);
        e = true;
    }

    f(c r4) {
        this.f1586a = 0;
        this.f1587b = 0;
        this.c = 0;
        this.d = 0;
        this.l = new AtomicLong(1000);
        this.o = -1;
        this.h = r4;
        this.u = r4.m().y();
    }

    public static String a() {
        if (e == false) goto L6;
        String r0 = v + "#" + w.getAndIncrement();
        q.a().c("Session:genSessionId#: {}", new Object[]{r0});
        return r0;
    L6:
        String r1 = UUID.randomUUID().toString();
        q.a().c("Session:genSessionId: {}", new Object[]{r1});
        return r1;
    }

    static boolean a(com.bytedance.applog.n.a r2) {
        if (ZeusTransformUtils.instanceOf(r2, i.class) == true) goto L5;
        return false;
    L5:
        return ((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin")).t();
    }

    public static String b() {
        return v;
    }

    static a k() {
        if (x != null) goto L5;
        x = new a();
    L5:
        x.a(0);
        return x;
    }

    synchronized Bundle a(long r6, long r8) {
        monitor-enter(this);
        Bundle r0 = null;
        long r1 = this.m;     // Catch: Throwable -> L15
        if (this.h.m().g() == true) goto L7;
    L13:
        monitor-exit(this);
        return r0;
    L7:
        if (g() == false) goto L13;
        if (r1 <= 0) goto L13;
        long r2 = r6 - r1;     // Catch: Throwable -> L15
        if (r2 <= r8) goto L13;
        r0 = new Bundle();     // Catch: Throwable -> L15
        r0.putInt("session_no", this.r);     // Catch: Throwable -> L15
        int r9 = this.n + 1;     // Catch: Throwable -> L15
        this.n = r9;     // Catch: Throwable -> L15
        r0.putInt("send_times", r9);     // Catch: Throwable -> L15
        r0.putLong("current_duration", r2 / 1000);     // Catch: Throwable -> L15
        r0.putString("session_start_time", com.bytedance.applog.n.a.b(this.o));     // Catch: Throwable -> L15
        this.m = r6;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    synchronized g a(com.bytedance.applog.n.a r13, ArrayList<com.bytedance.applog.n.a> r14, boolean r15) {
        monitor-enter(this);
        if (r13 != null) goto L63;
        long r4 = 0;
    L10:
        this.k = a();     // Catch: Throwable -> L60
        if (r15 == false) goto L17;
        this.u = r4;     // Catch: Throwable -> L60
        this.h.m().a(this.u);     // Catch: Throwable -> L60
        if (this.h.f1571b == true) goto L17;
        if (TextUtils.isEmpty(this.t) == false) goto L17;
        this.t = this.k;     // Catch: Throwable -> L60
    L17:
        this.l.set(10000);     // Catch: Throwable -> L60
        this.o = r4;     // Catch: Throwable -> L60
        this.p = r15;     // Catch: Throwable -> L60
        this.q = 0;     // Catch: Throwable -> L60
        this.m = 0;     // Catch: Throwable -> L60
        boolean r3 = true;
        if (r15 == false) goto L27;
        Calendar r16 = Calendar.getInstance();     // Catch: Throwable -> L60
        String r17 = "" + r16.get(1) + r16.get(2) + r16.get(5);     // Catch: Throwable -> L60
        com.bytedance.applog.k.b r6 = this.h.m();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(this.s) == false) goto L23;
        this.s = r6.d();     // Catch: Throwable -> L60
        this.r = r6.e();     // Catch: Throwable -> L60
    L23:
        if (r17.equals(this.s) == true) goto L25;
        this.s = r17;     // Catch: Throwable -> L60
        this.r = 1;     // Catch: Throwable -> L60
    L26:
        r6.a(r17, this.r);     // Catch: Throwable -> L60
        this.n = 0;     // Catch: Throwable -> L60
        this.m = r4;     // Catch: Throwable -> L60
        goto L27
    L25:
        this.r++;     // Catch: Throwable -> L60
    L27:
        g r18 = null;
        if (r4 == (-1)) goto L51;
        r18 = new g();     // Catch: Throwable -> L60
        r18.a(this.h.a().b());     // Catch: Throwable -> L60
        r18.d = this.k;     // Catch: Throwable -> L60
        if (this.p == false) goto L33;
        r3 = false;
    L33:
        r18.x = r3;     // Catch: Throwable -> L60
        r18.c = h();     // Catch: Throwable -> L60
        r18.a(this.o);     // Catch: Throwable -> L60
        r18.w = this.h.h().c();     // Catch: Throwable -> L60
        r18.v = this.h.h().b();     // Catch: Throwable -> L60
        a(r18, e());     // Catch: Throwable -> L60
        r18.g = this.h.a().p();     // Catch: Throwable -> L60
        r18.s = com.bytedance.applog.monitor.b.c(this.h.a().ab(), r18);     // Catch: Throwable -> L60
        if (ZeusTransformUtils.instanceOf(r13, i.class) == false) goto L37;
        r18.z = ((i) ZeusTransformUtils.preCheckCast(r13, i.class, "com.obric.memorydata.plugin")).A;     // Catch: Throwable -> L60
    L37:
        if (this.h.a().L() == true) goto L39;
    L43:
        r14.add(r18);     // Catch: Throwable -> L60
        if (r18.s <= 0) goto L46;
        com.bytedance.applog.monitor.b.a(this.h.a().ab(), EventStage.COLLECTED, r18);     // Catch: Throwable -> L60
    L46:
        this.h.a().ab().a(StatsCountKeys.COLLECT_LAUNCH_COUNT);     // Catch: Throwable -> L60
        if (this.p == false) goto L49;
        this.h.a().ab().a(StatsCountKeys.COLLECT_FRONT_LAUNCH_COUNT);     // Catch: Throwable -> L60
    L49:
        this.h.a().au().a(r18.d, r18.f1725b, r18.x);     // Catch: Throwable -> L60
        goto L51
    L39:
        if (this.h.a().aS() == null) goto L43;
        if (this.h.a().aS().a(EventType.Launch.value()) == false) goto L43;
        this.h.a().aS().a(this.k, this.p, r18.f1725b, r18.z);     // Catch: Throwable -> L60
        r18.A = false;     // Catch: Throwable -> L60
        this.h.a().ab().a("priority_launch_sent");     // Catch: Throwable -> L60
    L51:
        if (this.h.a().N() > 0) goto L53;
        this.h.a().b(6);     // Catch: Throwable -> L60
    L53:
        com.bytedance.applog.log.j r19 = this.h.a().aA();     // Catch: Throwable -> L60
        List<String> r110 = f;     // Catch: Throwable -> L60
        StringBuilder r0 = new StringBuilder().append("startSession, ");     // Catch: Throwable -> L60
        if (this.p == false) goto L56;
        String r1 = "fg";
    L57:
        r19.a(r110, r0.append(r1).append(", ").append(this.k).append(", ").append(r4).toString(), new Object[0]);     // Catch: Throwable -> L60
        monitor-exit(this);
        return r18;
    L60:
        th = move-exception;
        throw th;
    L56:
        r1 = "bg";
        goto L57
    L63:
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L8;
        r4 = -1;
        goto L10
    L8:
        r4 = r13.f1725b;     // Catch: Throwable -> L60
        goto L10
    }

    public void a(long r1) {
        this.g = r1;
    }

    public void a(com.bytedance.applog.n.a r7, long r8) {
        IBDAccountCallback r0 = this.h.a().G();
        if (this.h.a().F() == false) goto L11;
        if (r0 == null) goto L11;
        Pair<Integer, Long> r9 = r0.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        r7.e = ((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.memorydata.plugin")).longValue();
        r7.k = 1;
        r7.l = 1;
        r7.j = ((Integer) ZeusTransformUtils.preCheckCast(r9.first, Integer.class, "com.obric.memorydata.plugin")).intValue();
        r7.f = ((Long) ZeusTransformUtils.preCheckCast(r9.second, Long.class, "com.obric.memorydata.plugin")).longValue();
    L12:
        r7.h = this.h.a().e(String.valueOf(r7.e));
        return;
    L9:
        if (this.c != 0) goto L12;
        r7.f = this.f1586a;
        r7.j = this.f1587b;
        r7.k = this.c;
        r7.l = this.d;
    L11:
        r7.e = r8;
        goto L12
    }

    public boolean a(com.bytedance.applog.n.a r14, ArrayList<com.bytedance.applog.n.a> r15) {
        boolean r0 = ZeusTransformUtils.instanceOf(r14, i.class);
        boolean r1 = a(r14);
        boolean r5 = false;
        if (this.o != (-1)) goto L7;
        this.h.a().aA().b(f, "session process start session 1, data={}, isResume=" + r1, new Object[]{r14});
        r1 = a(r14);
    L5:
        a(r14, r15, r1);
    L18:
        r5 = true;
    L19:
        if (r0 == false) goto L44;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r14, i.class, "com.obric.memorydata.plugin");
        if (r2.t() == false) goto L35;
        this.q = 0;
        r15.add(r14);
        if (TextUtils.isEmpty(r2.w) == true) goto L25;
    L46:
        b(r14);
        return r5;
    L25:
        if (this.j == null) goto L31;
        if (((r2.f1725b - this.j.f1725b) - this.j.v) >= 500) goto L31;
        i r16 = this.j;
    L29:
        r2.w = r16.x;
    L31:
        if (this.i == null) goto L46;
        if (((r2.f1725b - this.i.f1725b) - this.i.v) >= 500) goto L46;
        r16 = this.i;
        goto L29
    L35:
        Bundle r3 = a(r14.f1725b, 0);
        if (this.h.a() == null) goto L39;
        if (r3 == null) goto L39;
        this.h.a().a("play_session", r3);
    L39:
        this.q = r2.f1725b;
        r15.add(r14);
        if (r2.u() == false) goto L42;
        this.i = r2;
        goto L46
    L42:
        this.j = r2;
        this.i = null;
        goto L46
    L44:
        if (ZeusTransformUtils.instanceOf(r14, a.class) == true) goto L46;
        r15.add(r14);
        goto L46
    L7:
        if (this.p == true) goto L11;
        if (r1 == false) goto L11;
        this.h.a().aA().b(f, "session process start session 2, data={}", new Object[]{r14});
        a(r14, r15, true);
    L11:
        if (this.q == 0) goto L16;
        if (r14.f1725b <= (this.q + this.h.e())) goto L16;
        this.h.a().aA().b(f, "session process start session 3, data={}, isResume=" + r1, new Object[]{r14});
    L16:
        if (this.o <= (r14.f1725b + 7200000)) goto L19;
        this.h.a().aA().b(f, "session process start session 4, data={}, isResume=" + r1, new Object[]{r14});
        goto L5
    }

    public void b(com.bytedance.applog.n.a r3) {
        if (r3 == null) goto L5;
        a(r3, e());
        r3.a(this.h.a().b());
        r3.g = this.h.a().p();
        r3.d = this.k;
        r3.c = h();
        r3.i = NetworkUtils.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.h.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getValue();
        return;
    }

    public String c() {
        return this.k;
    }

    public String d() {
        return this.t;
    }

    public long e() {
        return this.g;
    }

    public boolean f() {
        return this.p;
    }

    boolean g() {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.q != 0) goto L7;
        return true;
    }

    public long h() {
        return this.l.incrementAndGet();
    }

    public long i() {
        return this.u;
    }

    public boolean j() {
        if (this.c != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
