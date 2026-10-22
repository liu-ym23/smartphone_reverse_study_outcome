package com.larus.contextwindow.impl.membership;

import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class MembershipQuotaRepository implements l {
    public static final Lazy<MembershipQuotaRepository> k = null;
    public final CoroutineScope a;
    public final Function0<d> b;
    public final Function1<Continuation<? super e>, Object> c;
    public final Object d;
    public final StateFlowImpl e;
    public final b1 f;
    public long g;
    public String h;
    public String i;
    public a j;

    public static final class a {
        public final String a;
        public final long b;
        public final Deferred<e> c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ActiveRequest(accountId=" + this.a + ", generation=" + this.b + ", deferred=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, long r3, Deferred<? extends e> r5) {
            Intrinsics.checkNotNullParameter(r2, "accountId");
            Intrinsics.checkNotNullParameter(r5, "deferred");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public static final class b {
        public static MembershipQuotaRepository a() {
            return (MembershipQuotaRepository) MembershipQuotaRepository.k.getValue();
        }
    }

    static {
        k = LazyKt.lazy(new g());
    }

    public final void b() {
        Object r0 = this.d;
        monitor-enter(r0);
        c();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.g++;
        this.h = null;
        this.i = null;
        a r1 = this.j;
        if (r1 == null) goto L7;
        Deferred<e> r2 = r1.c;
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        this.j = null;
        this.e.setValue(new h(null, 3));
    }

    public final void d() {
        BuildersKt.launch$default(this.a, null, null, new MembershipQuotaRepository$prefetchIfNeeded$1(this, null), 3, null);
    }

    @Override // com.larus.contextwindow.impl.membership.l
    public final b1 getState() {
        Object r0 = this.d;
        monitor-enter(r0);
        Object r1 = this.b.invoke();     // Catch: Throwable -> L19
        String r3 = null;
        if ((r1 instanceof d.a) == false) goto L7;
        d.a r2 = (d.a) r1;     // Catch: Throwable -> L19
    L8:
        if (r2 == null) goto L10;
        r3 = r2.a;     // Catch: Throwable -> L19
    L10:
        String r4 = this.h;     // Catch: Throwable -> L19
        if (r4 != null) goto L13;
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return this.f;
    L13:
        if (Intrinsics.areEqual(r4, r3) == true) goto L15;
        c();     // Catch: Throwable -> L19
        goto L15
    L7:
        r2 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.contextwindow.impl.membership.l
    public final Object a(Continuation<? super Unit> r2) {
        Object r3 = e(true, r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final Object e(boolean r18, Continuation<? super Unit> r110) {
        if ((r110 instanceof MembershipQuotaRepository$requestMembershipQuota$1) == false) goto L7;
        MembershipQuotaRepository$requestMembershipQuota$1 r2 = (MembershipQuotaRepository$requestMembershipQuota$1) r110;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        a r6 = (a) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: CancellationException -> L14
    L61:
        e r1 = (e) r0;     // Catch: CancellationException -> L14
        Object r7 = this.d;
        monitor-enter(r7);
    L102:
        th = move-exception;
        throw th;
    L65:
        if (this.j == r6) goto L69;
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r7);
        return r8;
    L69:
        this.j = null;     // Catch: Throwable -> L102
        Object r9 = this.b.invoke();     // Catch: Throwable -> L102
        if ((r9 instanceof d.a) == false) goto L72;
        d.a r10 = (d.a) r9;     // Catch: Throwable -> L102
    L74:
        if (r6.b == this.g) goto L76;
    L99:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r7);
        return r11;
    L76:
        if (Intrinsics.areEqual(this.h, r6.a) == false) goto L99;
        if (r10 == null) goto L79;
        String r12 = r10.a;     // Catch: Throwable -> L102
    L81:
        if (Intrinsics.areEqual(r12, r6.a) == false) goto L99;
        StateFlowImpl r13 = this.e;     // Catch: Throwable -> L102
        if ((r1 instanceof e.b) == false) goto L90;
        Set<Integer> r14 = c.a;     // Catch: Throwable -> L102
        if (c.a(((e.b) r1).a).a.isEmpty() == false) goto L88;
        h r15 = new h(null, 3);     // Catch: Throwable -> L102
    L93:
        r13.setValue(r15);     // Catch: Throwable -> L102
        monitor-exit(r7);
        return Unit.INSTANCE;
    L88:
        h r16 = new h(((e.b) r1).a, 2);     // Catch: Throwable -> L102
    L92:
        r15 = r16;
        goto L93
    L90:
        if (Intrinsics.areEqual(r1, e.a.a) == false) goto L98;
        r16 = new h(((h) this.e.getValue()).a, false);     // Catch: Throwable -> L102
        goto L92
    L98:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L102
    L79:
        r12 = null;
        goto L81
    L72:
        r10 = null;
        goto L74
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        d r17 = (d) this.b.invoke();
        if ((r17 instanceof d.b) == false) goto L22;
        b();
        return Unit.INSTANCE;
    L22:
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.larus.contextwindow.impl.membership.MembershipQuotaEligibility.Eligible");
        String r20 = ((d.a) r17).a;
        Object r21 = this.d;
        monitor-enter(r21);
    L106:
        th = move-exception;
        throw th;
    L25:
        if (Intrinsics.areEqual(this.h, r20) == true) goto L27;
        c();     // Catch: Throwable -> L106
        this.h = r20;     // Catch: Throwable -> L106
    L27:
        if (r18 == false) goto L29;
    L36:
        if (r18 == true) goto L38;
        this.i = r20;     // Catch: Throwable -> L106
    L38:
        a r22 = this.j;     // Catch: Throwable -> L106
        if (r22 != null) goto L41;
    L48:
        r22 = null;
    L49:
        if (r22 != null) goto L51;
        r22 = new a(r20, this.g, BuildersKt.async$default(this.a, null, CoroutineStart.LAZY, new MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1(this, null), 1, null));     // Catch: Throwable -> L106
        this.j = r22;     // Catch: Throwable -> L106
    L51:
        StateFlowImpl r23 = this.e;     // Catch: Throwable -> L106
        r23.setValue(new h(((h) r23.getValue()).a, true));     // Catch: Throwable -> L106
    L52:
        monitor-exit(r21);
        if (r22 == null) goto L55;
        r22.c.start();
        Deferred<e> r24 = r22.c;     // Catch: CancellationException -> L14
        r2.L$0 = r22;     // Catch: CancellationException -> L14
        r2.label = 1;     // Catch: CancellationException -> L14
        r0 = r24.await(r2);     // Catch: CancellationException -> L14
        if (r0 != r4) goto L60;
        return r4;
    L60:
        r6 = r22;
        goto L61
    L55:
        return Unit.INSTANCE;
    L41:
        if (Intrinsics.areEqual(r22.a, r20) == true) goto L43;
    L45:
        boolean r25 = false;
    L46:
        if (r25 == false) goto L48;
    L43:
        if (r22.b != this.g) goto L45;
        r25 = true;
        goto L46
    L29:
        if (Intrinsics.areEqual(this.i, r20) == false) goto L31;
    L35:
        r22 = null;
        goto L52
    L31:
        if (((h) this.e.getValue()).a == null) goto L33;
        boolean r26 = true;
    L34:
        if (r26 == false) goto L36;
    L33:
        r26 = false;
    L14:
        e = move-exception;
        throw e;
    L7:
        r2 = new MembershipQuotaRepository$requestMembershipQuota$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MembershipQuotaRepository(CoroutineScope r2, Function0<? extends d> r3, Function1<? super Continuation<? super e>, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "eligibilityProvider");
        Intrinsics.checkNotNullParameter(r4, "fetcher");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Object();
        StateFlowImpl r5 = j1.a(new h(null, 3));
        this.e = r5;
        this.f = kotlinx.coroutines.flow.e.b(r5);
    }
}
