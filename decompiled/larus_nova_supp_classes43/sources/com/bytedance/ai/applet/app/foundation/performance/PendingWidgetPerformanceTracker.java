package com.bytedance.ai.applet.app.foundation.performance;

import android.os.Handler;
import android.os.Looper;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PendingWidgetPerformanceTracker {
    public final long a;
    public final String b;
    public String c;
    public final String d;
    public final String e;
    public final com.bytedance.ai.applet.base.log.d f;
    public final Handler g;
    public State h;
    public String i;
    public Long j;
    public Long k;
    public Long l;
    public Long m;
    public Long n;
    public boolean o;
    public final t p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/performance/PendingWidgetPerformanceTracker$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "COMPLETED", "FAILED", "TIMED_OUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COMPLETED = null;
        public static final State FAILED = null;
        public static final State PENDING = null;
        public static final State TIMED_OUT = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("PENDING", 0);
            PENDING = r0;
            State r1 = new State("COMPLETED", 1);
            COMPLETED = r1;
            State r10 = new State("FAILED", 2);
            FAILED = r10;
            State r11 = new State("TIMED_OUT", 3);
            TIMED_OUT = r11;
            State[] r12 = {r0, r1, r10, r11};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    public static final class b implements k5.j {
        public final /* synthetic */ Map<String, Object> a;

        public b(Map<String, ? extends Object> r1) {
            this.a = r1;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.h(this.a);
        }
    }

    static {
    }

    public PendingWidgetPerformanceTracker() {
        this(null, null, null, 31);
    }

    public final s a() {
        if (this.h == State.PENDING) goto L5;
        return null;
    L5:
        Long r0 = this.j;
        if (r0 == null) goto L12;
        long r10 = r0.longValue();
        Long r1 = b(this.k, this.l);
        if (r1 == null) goto L12;
        long r11 = r1.longValue();
        Long r12 = b(this.m, this.n);
        if (r12 == null) goto L12;
        s r13 = new s(this.o, r10, r11, r12.longValue());
    L13:
        if (r13 != null) goto L16;
        c(AppletPerformanceErrorCode.INTERRUPTED, "incomplete timing at stage=" + this.i);
        return null;
    L16:
        this.h = State.COMPLETED;
        this.g.removeCallbacks(this.p);
        return r13;
    L12:
        r13 = null;
        goto L13
    }

    public final void d() {
        if (this.h == State.PENDING) goto L5;
        return;
    L5:
        if (this.j != null) goto L10;
        this.j = Long.valueOf(System.currentTimeMillis());
        this.i = "binding";
        return;
    }

    public final void e() {
        Long r0 = this.m;
        if (r0 == null) goto L11;
        long r1 = r0.longValue();
        if (this.h == State.PENDING) goto L7;
        return;
    L7:
        if (this.n != null) goto L13;
        this.n = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis(), r1));
        this.i = "manifestResourceLoaded";
        return;
    L13:
        return;
    }

    public final void f() {
        if (this.h == State.PENDING) goto L5;
        return;
    L5:
        if (this.m != null) goto L10;
        this.m = Long.valueOf(System.currentTimeMillis());
        this.i = "loadingManifestResource";
        return;
    }

    public final void g() {
        Long r0 = this.k;
        if (r0 == null) goto L11;
        long r1 = r0.longValue();
        if (this.h == State.PENDING) goto L7;
        return;
    L7:
        if (this.l != null) goto L13;
        this.l = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis(), r1));
        this.i = "widgetResourceLoaded";
        return;
    L13:
        return;
    }

    public final void h() {
        if (this.h == State.PENDING) goto L5;
        return;
    L5:
        if (this.k != null) goto L10;
        this.k = Long.valueOf(System.currentTimeMillis());
        this.i = "loadingWidgetResource";
        return;
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_NAME);
        if (this.h == State.PENDING) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r10)) == false) goto L9;
        this.c = r10;
        return;
    }

    public static Long b(Long r10, Long r11) {
        if (r10 == null) goto L5;
        if (r11 == null) goto L5;
        return Long.valueOf(r11.longValue() - r10.longValue());
    L5:
        return null;
    }

    public final boolean c(AppletPerformanceErrorCode r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "errorCode");
        if (this.h == State.PENDING) goto L6;
        return false;
    L6:
        this.h = State.FAILED;
        this.g.removeCallbacks(this.p);
        if (r11 != null) goto L9;
    L13:
        r11 = "failed at stage=" + this.i;
    L14:
        com.bytedance.ai.applet.base.log.d r12 = this.f;
        String r13 = "failed at stage=" + this.i + ": errorCode=" + r10 + ", errorMessage=" + r11;
        AtomicInteger r14 = com.bytedance.ai.applet.base.log.d.d;
        r12.a(r13, null);
        i(r10, r11);
        return true;
    L9:
        if ((!StringsKt.isBlank(r11)) == true) goto L12;
        r11 = null;
    L12:
        if (r11 != null) goto L14;
        goto L13
    }

    public final void i(AppletPerformanceErrorCode r28, String r29) {
        long r1 = System.currentTimeMillis();
        Long r10 = this.j;
        if (r10 == null) goto L5;
        long r11 = r10.longValue();
    L6:
        j r12 = new j(this.b, this.c, 0, r11, r1 - r11, r28, r29, b(this.m, this.n), b(this.k, this.l), null, null, null, null, false, null, this.d, this.e, this.o);
        Map<String, Object> r13 = r12.c();
        AtomicBoolean r14 = com.bytedance.ai.monitor.b.a;
        com.bytedance.ai.monitor.b.d(r12.s, new b(r13));
        return;
    L5:
        r11 = r1;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.bytedance.ai.applet.app.foundation.performance.t, java.lang.Runnable] */
    public PendingWidgetPerformanceTracker(String r10, String r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        long r14 = 15000;
    L7:
        if ((r13 & 2) == 0) goto L10;
        r10 = "";
    L10:
        if ((r13 & 4) == 0) goto L12;
        String r0 = "";
    L14:
        if ((r13 & 8) == 0) goto L17;
        r11 = "";
    L17:
        if ((r13 & 16) == 0) goto L19;
        r12 = "";
    L19:
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r0, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r12, "widgetInstanceId");
        this.a = r14;
        this.b = r10;
        this.c = r0;
        this.d = r11;
        this.e = r12;
        if (r14 <= 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L27;
        this.f = new com.bytedance.ai.applet.base.log.d("PendingWidgetPerformanceTracker", null);
        Handler r16 = new Handler(Looper.getMainLooper());
        this.g = r16;
        this.h = State.PENDING;
        this.i = "created";
        ?? r17 = new t(this);
        this.p = r17;
        r16.postDelayed(r17, r14);
        return;
    L27:
        throw new IllegalArgumentException("timeoutMillis must be greater than 0".toString());
    L22:
        r15 = false;
        goto L23
    L12:
        r0 = null;
        goto L14
    L5:
        r14 = 0;
        goto L7
    }
}
