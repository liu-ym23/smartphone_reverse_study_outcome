package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public class i2 extends kotlinx.coroutines.flow.internal.a implements c2, g, kotlinx.coroutines.flow.internal.r {
    public final int e;
    public final int f;
    public final BufferOverflow g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object[] f18854h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18855i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f18856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18858l;

    public i2(int r5, int r10, BufferOverflow r11) {
        this.e = r5;
        this.f = r10;
        this.g = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, kotlinx.coroutines.flow.h] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, kotlinx.coroutines.flow.i2] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.h] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, kotlinx.coroutines.flow.j2] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.flow.j2] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c7 -> B:16:0x003e). Please report as a decompilation issue!!! */
    public static Object k(i2 r10, h r11, Continuation r12) {
        if ((r12 instanceof SharedFlowImpl$collect$1) == false) goto L7;
        SharedFlowImpl$collect$1 r5 = (SharedFlowImpl$collect$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 != 0) goto L11;
        ResultKt.throwOnFailure(r14);
        j2 r17 = (j2) r10.c();
        ?? r18 = r11;
        r11 = r17;
        i2 r19 = r10;
    L54:
        Job r20 = (Job) r5.getContext().get(Job.Key);     // Catch: Throwable -> L46
        ?? r21 = r19;
        ?? r22 = r11;
        ?? r110 = r18;
    L31:
        ?? r23 = r21;
        Job r24 = r20;
        ?? r25 = r110;
        r11 = r22;
    L32:
        Object r111 = r23.s(r11);     // Catch: Throwable -> L17
        if (r111 != i.f18851a) goto L37;
        r5.L$0 = r23;     // Catch: Throwable -> L17
        r5.L$1 = r25;     // Catch: Throwable -> L17
        r5.L$2 = r11;     // Catch: Throwable -> L17
        r5.L$3 = r24;     // Catch: Throwable -> L17
        r5.label = 2;     // Catch: Throwable -> L17
        if (r23.i(r11, r5) != r15) goto L32;
        return r15;
    L37:
        if (r24 != null) goto L39;
    L43:
        r5.L$0 = r23;     // Catch: Throwable -> L17
        r5.L$1 = r25;     // Catch: Throwable -> L17
        r5.L$2 = r11;     // Catch: Throwable -> L17
        r5.L$3 = r24;     // Catch: Throwable -> L17
        r5.label = 3;     // Catch: Throwable -> L17
        Object r112 = r25.emit(r111, r5);     // Catch: Throwable -> L17
        ?? r26 = r25;
        ?? r27 = r23;
        ?? r28 = r11;
        if (r112 == r15) goto L45;
    L16:
        r110 = r26;
        r20 = r24;
        r21 = r27;
        r22 = r28;
        goto L31
    L45:
        return r15;
    L39:
        if (r24.isActive() == true) goto L43;
        throw r24.getCancellationException();     // Catch: Throwable -> L17
    L46:
        th = move-exception;
        r23 = r19;
        th = th;
    L48:
        r23.g(r11);
        throw th;
    L11:
        if (r16 == 1) goto L24;
        if (r16 == 2) goto L21;
        if (r16 != 3) goto L20;
        r24 = (Job) r5.L$3;
        j2 r29 = (j2) r5.L$2;
        h r30 = (h) r5.L$1;
        i2 r31 = (i2) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
        r26 = r30;
        r27 = r31;
        r28 = r29;
        goto L16
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r24 = (Job) r5.L$3;
        j2 r32 = (j2) r5.L$2;
        h r33 = (h) r5.L$1;
        i2 r34 = (i2) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L17
        r25 = r33;
        r23 = r34;
        r11 = r32;
        goto L32
    L24:
        r11 = (j2) r5.L$2;
        h r35 = (h) r5.L$1;
        i2 r36 = (i2) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L27
        r18 = r35;
        r19 = r36;
        r11 = r11;
    L27:
        th = th;
        r23 = r36;
    L17:
        th = th;
    L7:
        r5 = new SharedFlowImpl$collect$1(r10, r12);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.c2
    public final boolean a(Object r10) {
        Continuation[] r5 = kotlinx.coroutines.flow.internal.b.f18862a;
        monitor-enter(this);
        int r11 = 0;
        if (q(r10) == false) goto L10;
        r5 = n(r5);     // Catch: Throwable -> L8
        boolean r12 = true;
    L11:
        monitor-exit(this);
        int r13 = r5.length;
    L13:
        if (r11 >= r13) goto L18;
        Continuation r14 = r5[r11];
        if (r14 == null) goto L17;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L17:
        r11 = r11 + 1;
        goto L13
    L18:
        return r12;
    L10:
        r12 = false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.r
    public final g b(CoroutineContext r5, int r10, BufferOverflow r11) {
        if (r10 == 0) goto L6;
        if (r10 == (-3)) goto L6;
    L9:
        return new kotlinx.coroutines.flow.internal.g(this, r5, r10, r11);
    L6:
        if (r11 != BufferOverflow.SUSPEND) goto L9;
        return this;
    }

    @Override // kotlinx.coroutines.flow.g
    public final Object collect(h r5, Continuation r10) {
        return k(this, r5, r10);
    }

    @Override // kotlinx.coroutines.flow.c2
    public final void d() {
        monitor-enter(this);
        t(o() + ((long) this.f18857k), this.f18856j, o() + ((long) this.f18857k), (o() + ((long) this.f18857k)) + ((long) this.f18858l));     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c e() {
        j2 r5 = new j2();
        r5.f18891a = -1;
        return r5;
    }

    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r11, Continuation r12) {
        if (a(r11) == true) goto L43;
        kotlinx.coroutines.l r10 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r12));
        r10.w();
        Continuation[] r13 = kotlinx.coroutines.flow.internal.b.f18862a;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (q(r11) == false) goto L12;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L10
        r10.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L10
        Continuation[] r15 = n(r13);     // Catch: Throwable -> L10
        g2 r5 = null;
    L16:
        monitor-exit(this);
        if (r5 == null) goto L19;
        r10.z(new kotlinx.coroutines.h(r5, 2));
    L19:
        int r16 = r15.length;
        int r17 = 0;
    L20:
        if (r17 >= r16) goto L25;
        Continuation r18 = r15[r17];
        if (r18 == null) goto L24;
        Result.Companion r19 = Result.Companion;
        r18.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L24:
        r17 = r17 + 1;
        goto L20
    L25:
        Object r110 = r10.v();
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L29:
        if (r110 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        r110 = Unit.INSTANCE;
    L33:
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        return r110;
    L36:
        return Unit.INSTANCE;
    L12:
        g2 r20 = new g2(this, ((long) (this.f18857k + this.f18858l)) + o(), r11, r10);     // Catch: Throwable -> L10
        m(r20);     // Catch: Throwable -> L10
        this.f18858l++;     // Catch: Throwable -> L10
        if (this.f != 0) goto L15;
        r13 = n(r13);     // Catch: Throwable -> L10
    L15:
        r15 = r13;
        r5 = r20;
        goto L16
    L43:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public final kotlinx.coroutines.flow.internal.c[] f() {
        return new j2[2];
    }

    public final Object i(j2 r10, Continuation r11) {
        kotlinx.coroutines.l r5 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r11));
        r5.w();
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r(r10) >= 0) goto L7;
        r10.f18892b = r5;     // Catch: Throwable -> L18
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r13 = r5.v();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L14:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r13;
    L17:
        return Unit.INSTANCE;
    L7:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        r5.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L18
        goto L8
    }

    public final void j() {
        if (this.f == 0) goto L5;
    L7:
        Object[] r5 = this.f18854h;
        Intrinsics.checkNotNull(r5);
    L9:
        if (this.f18858l <= 0) goto L13;
        if (i.c(r5, (o() + ((long) (this.f18857k + this.f18858l))) - 1) != i.f18851a) goto L16;
        this.f18858l--;
        i.d(r5, o() + ((long) (this.f18857k + this.f18858l)), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.f18858l > 1) goto L7;
    }

    public final void l() {
        Object[] r5 = this.f18854h;
        Intrinsics.checkNotNull(r5);
        i.d(r5, o(), null);
        this.f18857k--;
        long r10 = o() + 1;
        if (this.f18855i >= r10) goto L6;
        this.f18855i = r10;
    L6:
        if (this.f18856j < r10) goto L8;
        return;
    L8:
        if (this.f18860b == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r11 = this.f18859a;
        if (r11 == null) goto L21;
        int r12 = r11.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L21;
        kotlinx.coroutines.flow.internal.c r14 = r11[r13];
        if (r14 == null) goto L20;
        j2 r15 = (j2) r14;
        long r16 = r15.f18891a;
        if (r16 < 0) goto L20;
        if (r16 >= r10) goto L20;
        r15.f18891a = r10;
    L20:
        r13 = r13 + 1;
    L21:
        this.f18856j = r10;
    }

    public final void m(Object r10) {
        int r5 = this.f18857k + this.f18858l;
        Object[] r11 = this.f18854h;
        if (r11 != null) goto L6;
        r11 = p(0, 2, null);
    L8:
        i.d(r11, o() + ((long) r5), r10);
        return;
    L6:
        if (r5 < r11.length) goto L8;
        r11 = p(r5, r11.length * 2, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final Continuation[] n(Continuation[] r11) {
        int r5 = r11.length;
        if (this.f18860b == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r10 = this.f18859a;
        if (r10 == null) goto L21;
        int r12 = r10.length;
        int r13 = 0;
        r11 = r11;
    L7:
        if (r13 >= r12) goto L21;
        kotlinx.coroutines.flow.internal.c r14 = r10[r13];
        if (r14 == null) goto L19;
        j2 r15 = (j2) r14;
        kotlinx.coroutines.l r16 = r15.f18892b;
        if (r16 == null) goto L19;
        if (r(r15) < 0) goto L19;
        int r17 = r11.length;
        r11 = r11;
        if (r5 < r17) goto L18;
        r11 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
    L18:
        ((Continuation[]) r11)[r5] = r16;
        r15.f18892b = null;
        r5 = r5 + 1;
    L19:
        r13 = r13 + 1;
        r11 = r11;
    L21:
        return (Continuation[]) r11;
    }

    public final long o() {
        return Math.min(this.f18856j, this.f18855i);
    }

    public final Object[] p(int r10, int r11, Object[] r12) {
        if (r11 <= 0) goto L11;
        Object[] r13 = new Object[r11];
        this.f18854h = r13;
        if (r12 != null) goto L6;
        return r13;
    L6:
        long r5 = o();
        int r14 = 0;
    L7:
        if (r14 >= r10) goto L9;
        long r15 = ((long) r14) + r5;
        i.d(r13, r15, r12[((int) r15) & (r12.length - 1)]);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L11:
        throw new IllegalStateException("Buffer size overflow");
    }

    public final boolean q(Object r13) {
        int r5 = this.f18860b;
        int r10 = this.e;
        if (r5 != 0) goto L11;
        if (r10 == 0) goto L10;
        m(r13);
        int r11 = this.f18857k + 1;
        this.f18857k = r11;
        if (r11 <= r10) goto L9;
        l();
    L9:
        this.f18856j = o() + ((long) this.f18857k);
    L10:
        return true;
    L11:
        int r12 = this.f18857k;
        int r14 = this.f;
        if (r12 >= r14) goto L14;
    L27:
        m(r13);
        int r15 = this.f18857k + 1;
        this.f18857k = r15;
        if (r15 <= r14) goto L30;
        l();
    L30:
        long r16 = o() + ((long) this.f18857k);
        long r17 = this.f18855i;
        if (((int) (r16 - r17)) <= r10) goto L33;
        t(1 + r17, this.f18856j, o() + ((long) this.f18857k), (o() + ((long) this.f18857k)) + ((long) this.f18858l));
    L33:
        return true;
    L14:
        if (this.f18856j > this.f18855i) goto L27;
        int r18 = h2.f18850a[this.g.ordinal()];
        if (r18 != 1) goto L18;
        return false;
    L18:
        if (r18 != 2) goto L20;
        return true;
    L20:
        if (r18 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    }

    public final long r(j2 r10) {
        long r5 = r10.f18891a;
        if (r5 >= (o() + ((long) this.f18857k))) goto L6;
        return r5;
    L6:
        if (this.f <= 0) goto L9;
        return -1;
    L9:
        if (r5 <= o()) goto L12;
        return -1;
    L12:
        if (this.f18858l != 0) goto L14;
        return -1;
    L14:
        return r5;
    }

    public final Object s(j2 r10) {
        Continuation[] r5 = kotlinx.coroutines.flow.internal.b.f18862a;
        monitor-enter(this);
        long r11 = r(r10);     // Catch: Throwable -> L7
        if (r11 >= 0) goto L9;
        Object r12 = i.f18851a;     // Catch: Throwable -> L7
    L14:
        monitor-exit(this);
        int r13 = r5.length;
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L21;
        Continuation r15 = r5[r14];
        if (r15 == null) goto L20;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L20:
        r14 = r14 + 1;
        goto L16
    L21:
        return r12;
    L9:
        long r17 = r10.f18891a;     // Catch: Throwable -> L7
        Object[] r18 = this.f18854h;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L7
        Object r19 = i.c(r18, r11);     // Catch: Throwable -> L7
        if ((r19 instanceof g2) == false) goto L12;
        r19 = ((g2) r19).f18849c;     // Catch: Throwable -> L7
    L12:
        r10.f18891a = r11 + 1;     // Catch: Throwable -> L7
        Object r20 = r19;
        r5 = u(r17);     // Catch: Throwable -> L7
        r12 = r20;
    L7:
        th = move-exception;
        throw th;
    }

    public final void t(long r10, long r11, long r12, long r13) {
        long r5 = Math.min(r11, r10);
        long r14 = o();
    L4:
        if (r14 >= r5) goto L6;
        Object[] r15 = this.f18854h;
        Intrinsics.checkNotNull(r15);
        i.d(r15, r14, null);
        r14 = r14 + 1;
        goto L4
    L6:
        this.f18855i = r10;
        this.f18856j = r11;
        this.f18857k = (int) (r12 - r5);
        this.f18858l = (int) (r13 - r12);
    }

    public final Continuation[] u(long r23) {
        long r5 = this.f18856j;
        Continuation[] r10 = kotlinx.coroutines.flow.internal.b.f18862a;
        if (r23 <= r5) goto L5;
        return r10;
    L5:
        long r11 = o();
        long r12 = ((long) this.f18857k) + r11;
        int r13 = this.f;
        if (r13 != 0) goto L11;
        if (this.f18858l <= 0) goto L11;
        r12 = r12 + 1;
    L11:
        if (this.f18860b == 0) goto L25;
        kotlinx.coroutines.flow.internal.c[] r14 = this.f18859a;
        if (r14 == null) goto L25;
        int r15 = r14.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L25;
        kotlinx.coroutines.flow.internal.c r17 = r14[r16];
        if (r17 == null) goto L23;
        long r18 = ((j2) r17).f18891a;
        if (r18 < 0) goto L23;
        if (r18 >= r12) goto L23;
        r12 = r18;
    L23:
        r16 = r16 + 1;
    L25:
        if (r12 > this.f18856j) goto L27;
        return r10;
    L27:
        long r19 = o() + ((long) this.f18857k);
        if (this.f18860b <= 0) goto L30;
        int r20 = (int) (r19 - r12);
        int r21 = Math.min(this.f18858l, r13 - r20);
    L31:
        long r110 = ((long) this.f18858l) + r19;
        g8.g r111 = i.f18851a;
        if (r21 <= 0) goto L45;
        r10 = new Continuation[r21];
        Object[] r112 = this.f18854h;
        Intrinsics.checkNotNull(r112);
        long r113 = r12;
        long r22 = r19;
        long r24 = r22;
        int r114 = 0;
    L35:
        if (r24 >= r110) goto L44;
        Object r115 = i.c(r112, r24);
        long r116 = r110;
        if (r115 == r111) goto L42;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        g2 r117 = (g2) r115;
        int r118 = r114 + 1;
        r10[r114] = r117.d;
        i.d(r112, r24, r111);
        i.d(r112, r22, r117.f18849c);
        long r25 = 1;
        r19 = r22 + 1;
        if (r118 >= r21) goto L41;
        r22 = r19;
        r114 = r118;
    L43:
        r24 = r24 + r25;
        r110 = r116;
    L41:
        Continuation[] r119 = r10;
    L46:
        int r26 = (int) (r19 - r11);
        if (this.f18860b != 0) goto L49;
        long r27 = r19;
    L50:
        long r28 = Math.max(this.f18855i, r19 - ((long) Math.min(this.e, r26)));
        if (r13 == 0) goto L53;
    L57:
        t(r28, r27, r19, r116);
        j();
        if (r119.length != 0) goto L61;
        return r119;
    L61:
        return n(r119);
    L53:
        if (r28 >= r116) goto L57;
        Object[] r29 = this.f18854h;
        Intrinsics.checkNotNull(r29);
        if (Intrinsics.areEqual(i.c(r29, r28), r111) == false) goto L57;
        r19 = r19 + 1;
        r28 = r28 + 1;
        goto L57
    L49:
        r27 = r113;
        goto L50
    L42:
        r25 = 1;
        goto L43
    L44:
        r116 = r110;
        r119 = r10;
        r19 = r22;
        goto L46
    L45:
        r113 = r12;
        r116 = r110;
        goto L41
    L30:
        r21 = this.f18858l;
        goto L31
    }
}
