package com.larus.business.arc.api;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ArcCallLifecycle {
    public final o a;
    public final Object b;
    public final buc.a c;
    public final buc.a d;
    public Long e;
    public long f;
    public final long[] g;
    public final long[] h;
    public final String i;
    public final String j;
    public ArcStage k;
    public ArcFrameworkFailure l;
    public final String m;
    public g n;
    public LifecycleState o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/arc/api/ArcCallLifecycle$LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "FINISHED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState ACTIVE = null;
        public static final LifecycleState FINISHED = null;
        public static final /* synthetic */ LifecycleState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return b;
        }

        static {
            LifecycleState r0 = new LifecycleState("ACTIVE", 0);
            ACTIVE = r0;
            LifecycleState r1 = new LifecycleState("FINISHED", 1);
            FINISHED = r1;
            LifecycleState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) a.clone();
        }

        public static LifecycleState valueOf(String r1) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r1);
        }

        public LifecycleState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ArcStage.values().length];
            r0[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public ArcCallLifecycle() {
        this(0);
    }

    public final void c() {
        Object r0 = this.b;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L28;
        ArcStage r1 = this.k;     // Catch: Throwable -> L30
        if (r1 != null) goto L10;
        int r2 = -1;
    L11:
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L15;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L15:
        if (r2 != 2) goto L17;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_CANCELLED);     // Catch: Throwable -> L30
        goto L28
    L17:
        if (r2 != 3) goto L20;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L24:
        if (this.g[ArcStage.EXECUTE.ordinal()] < 0) goto L26;
        ArcFrameworkFailure r3 = ArcFrameworkFailure.EXECUTE_CANCELLED;     // Catch: Throwable -> L30
    L27:
        n(r3);     // Catch: Throwable -> L30
        goto L28
    L26:
        r3 = ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;     // Catch: Throwable -> L30
        goto L27
    L10:
        r2 = b.a[r1.ordinal()];     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final long d() {
        ((d) this.a).getClass();     // Catch: Throwable -> L4
        Long r0 = Long.valueOf(Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(e.a)));     // Catch: Throwable -> L4
    L5:
        if (r0 == null) goto L13;
        long r1 = r0.longValue();
        Long r2 = this.e;
        if (r2 == null) goto L9;
        long r3 = r2.longValue();
    L10:
        long r4 = RangesKt.coerceAtLeast(r1 - r3, this.f);
        this.f = r4;
        return r4;
    L9:
        this.e = Long.valueOf(r1);
        r3 = r1;
        goto L10
    L13:
        return this.f;
    L4:
        k();
        r0 = null;
        goto L5
    }

    public final void e() {
        Object r0 = this.b;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L28;
        ArcStage r1 = this.k;     // Catch: Throwable -> L30
        if (r1 != null) goto L10;
        int r2 = -1;
    L11:
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L15;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L15:
        if (r2 != 2) goto L17;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L17:
        if (r2 != 3) goto L20;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L24:
        if (this.g[ArcStage.EXECUTE.ordinal()] < 0) goto L26;
        ArcFrameworkFailure r3 = ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;     // Catch: Throwable -> L30
    L27:
        n(r3);     // Catch: Throwable -> L30
        goto L28
    L26:
        r3 = ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;     // Catch: Throwable -> L30
        goto L27
    L10:
        r2 = b.a[r1.ordinal()];     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final void f() {
        Object r0 = this.b;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L27;
        ArcStage r1 = this.k;     // Catch: Throwable -> L30
        if (r1 != null) goto L9;
        int r2 = -1;
    L10:
        if (r2 == (-1)) goto L23;
        if (r2 != 1) goto L14;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_RUNTIME_EMPTY_RESULT);     // Catch: Throwable -> L30
        goto L27
    L14:
        if (r2 != 2) goto L16;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L27
    L16:
        if (r2 != 3) goto L19;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L27
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L23:
        if (this.g[ArcStage.EXECUTE.ordinal()] < 0) goto L25;
        ArcFrameworkFailure r3 = ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;     // Catch: Throwable -> L30
    L26:
        n(r3);     // Catch: Throwable -> L30
        goto L27
    L25:
        r3 = ArcFrameworkFailure.PREPARE_RUNTIME_EMPTY_RESULT;     // Catch: Throwable -> L30
        goto L26
    L9:
        r2 = b.a[r1.ordinal()];     // Catch: Throwable -> L30
    L27:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r0);
    }

    public final g i() {
        Object r3 = this.b;     // Catch: Throwable -> L31
        monitor-enter(r3);     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L6:
        if (this.c.c() == false) goto L8;
        this.o = LifecycleState.FINISHED;     // Catch: Throwable -> L28
    L16:
        g r0 = null;
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L31
        return r0;
    L8:
        r0 = this.n;     // Catch: Throwable -> L28
        if (r0 != null) goto L26;
        ArcStage r1 = this.k;     // Catch: Throwable -> L28
        if (r1 == null) goto L14;
        n(e.a(r1));     // Catch: Throwable -> L28
    L14:
        long r4 = d();     // Catch: Throwable -> L28
        if (this.c.c() == true) goto L16;
        String r2 = this.i;     // Catch: Throwable -> L28
        String r6 = this.j;     // Catch: Throwable -> L28
        if (this.g[ArcStage.EXECUTE.ordinal()] < 0) goto L20;
        ArcBizStatus r8 = ArcBizStatus.UNKNOWN;     // Catch: Throwable -> L28
    L21:
        j r7 = new j(r8, this.l, this.m);     // Catch: Throwable -> L28
        ArcStage[] r9 = ArcStage.values();     // Catch: Throwable -> L28
        ArrayList r10 = new ArrayList(r9.length);     // Catch: Throwable -> L28
        int r11 = r9.length;     // Catch: Throwable -> L28
        int r12 = 0;
    L22:
        if (r12 >= r11) goto L24;
        ArcStage r13 = r9[r12];     // Catch: Throwable -> L28
        r10.add(new y(r13, this.g[r13.ordinal()], this.h[r13.ordinal()]));     // Catch: Throwable -> L28
        r12 = r12 + 1;     // Catch: Throwable -> L28
        goto L22
    L24:
        g r5 = new g(r2, r6, r7, new l(r4, r10));     // Catch: Throwable -> L28
        this.n = r5;     // Catch: Throwable -> L28
        this.o = LifecycleState.FINISHED;     // Catch: Throwable -> L28
        r0 = r5;
        goto L26
    L20:
        r8 = ArcBizStatus.NOT_STARTED;     // Catch: Throwable -> L28
    L31:
        k();
        return null;
    }

    public final void k() {
        this.c.d(true);     // Catch: Throwable -> L4
        return;
    }

    public final boolean l() {
        if (this.o != LifecycleState.FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (this.c.c() == true) goto L8;
        return false;
    }

    public ArcCallLifecycle(int r6) {
        d r7 = e.b;
        Intrinsics.checkNotNullParameter(r7, "clock");
        this.a = r7;
        this.b = new Object();
        int r0 = 0;
        this.c = buc.b.a(false);
        this.d = buc.b.a(false);
        r7.getClass();     // Catch: Throwable -> L5
        Long r8 = Long.valueOf(Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(e.a)));     // Catch: Throwable -> L5
    L6:
        this.e = r8;
        int r9 = ArcStage.values().length;
        long[] r1 = new long[r9];
        int r2 = 0;
    L8:
        if (r2 >= r9) goto L10;
        r1[r2] = -1;
        r2 = r2 + 1;
        goto L8
    L10:
        this.g = r1;
        int r10 = ArcStage.values().length;
        long[] r3 = new long[r10];
    L11:
        if (r0 >= r10) goto L13;
        r3[r0] = -1;
        r0 = r0 + 1;
        goto L11
    L13:
        this.h = r3;
        this.i = "unknown";
        this.j = "unknown";
        this.l = ArcFrameworkFailure.NONE;
        this.m = TriggerSendLoading.NO_LOADING;
        this.o = LifecycleState.ACTIVE;
        return;
    L5:
        k();
        r8 = null;
        goto L6
    }

    public final boolean a(ArcStage r6) {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r2 = false;
        if (l() == false) goto L8;
    L12:
        monitor-exit(r0);
        return r2;
    L8:
        if (b(r6) == true) goto L10;
        n(e.a(r6));     // Catch: Throwable -> L14
        goto L12
    L10:
        this.g[r6.ordinal()] = d();     // Catch: Throwable -> L14
        this.k = r6;     // Catch: Throwable -> L14
        r2 = true;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean b(ArcStage r10) {
        if (this.k == null) goto L5;
        return false;
    L5:
        if (this.g[r10.ordinal()] >= 0) goto L45;
        int r11 = b.a[r10.ordinal()];
        if (r11 != 1) goto L10;
        long[] r12 = this.g;
        int r2 = r12.length;
        int r3 = 0;
    L28:
        if (r3 >= r2) goto L36;
        if (r12[r3] >= 0) goto L32;
        boolean r6 = true;
    L33:
        if (r6 == false) goto L46;
        r3 = r3 + 1;
        goto L28
    L46:
        return false;
    L32:
        r6 = false;
    L36:
        return true;
    L10:
        if (r11 == 2) goto L23;
        if (r11 != 3) goto L21;
        if (this.h[ArcStage.PREPARE.ordinal()] < 0) goto L41;
        long[] r13 = this.h;
        ArcStage r4 = ArcStage.EXECUTE;
        if (r13[r4.ordinal()] >= 0) goto L36;
        if (this.g[r4.ordinal()] < 0) goto L36;
        return false;
    L41:
        return false;
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (this.h[ArcStage.PREPARE.ordinal()] >= 0) goto L25;
        return false;
    L25:
        if (this.g[ArcStage.FINALIZE.ordinal()] < 0) goto L36;
        return false;
    L45:
        return false;
    }

    public final void g(ArcFrameworkFailure r4) {
        Intrinsics.checkNotNullParameter(r4, "failure");
        ArcStage r0 = ArcStage.PREPARE;
        Object r1 = this.b;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (l() == false) goto L8;
    L14:
        monitor-exit(r1);
        return;
    L8:
        if (r4 != ArcFrameworkFailure.NONE) goto L10;
    L13:
        n(e.a(r0));     // Catch: Throwable -> L16
        goto L14
    L10:
        if (r4.getStage() != r0) goto L13;
        h(r0, r4);     // Catch: Throwable -> L16
        goto L14
    }

    public final boolean j(ArcStage r8) {
        if (this.k == r8) goto L5;
    L11:
        n(e.a(r8));
        return false;
    L5:
        if (this.g[r8.ordinal()] < 0) goto L11;
        if (this.h[r8.ordinal()] >= 0) goto L11;
        this.h[r8.ordinal()] = RangesKt.coerceAtLeast(d(), this.g[r8.ordinal()]);
        this.k = null;
        return true;
    }

    public final void m(ArcFrameworkFailure r4) {
        Intrinsics.checkNotNullParameter(r4, "failure");
        Object r0 = this.b;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (l() == false) goto L7;
    L12:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L7:
        if (r4 != ArcFrameworkFailure.NONE) goto L9;
    L11:
        n(r4);     // Catch: Throwable -> L15
        goto L12
    L9:
        if (r4.getStage() == ArcStage.FINALIZE) goto L11;
        n(ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L15
        goto L12
    }

    public final void n(ArcFrameworkFailure r3) {
        ArcFrameworkFailure r0 = this.l;
        ArcFrameworkFailure r1 = ArcFrameworkFailure.NONE;
        if (r0 != r1) goto L7;
        if (r3 == r1) goto L8;
        this.l = r3;
        return;
    L8:
        return;
    }

    public final boolean h(ArcStage r7, ArcFrameworkFailure r8) {
        if (this.k == r7) goto L5;
    L11:
        n(e.a(r7));
        return false;
    L5:
        if (this.g[r7.ordinal()] < 0) goto L11;
        if (this.h[r7.ordinal()] >= 0) goto L11;
        n(r8);
        this.h[r7.ordinal()] = RangesKt.coerceAtLeast(d(), this.g[r7.ordinal()]);
        this.k = null;
        return true;
    }
}
