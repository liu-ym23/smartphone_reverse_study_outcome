package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements k, i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f18786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.l f18787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f18788c;

    public e(f r5) {
        this.f18788c = r5;
        this.f18786a = g.f18808p;
    }

    public static final void b(e r5) {
        kotlinx.coroutines.l r10 = r5.f18787b;
        Intrinsics.checkNotNull(r10);
        r5.f18787b = null;
        r5.f18786a = g.f18804l;
        Throwable r11 = r5.f18788c.u();
        if (r11 != null) goto L5;
        Result.Companion r12 = Result.Companion;
        r10.resumeWith(Result.m124constructorimpl(Boolean.FALSE));
        return;
    L5:
        Result.Companion r13 = Result.Companion;
        r10.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r11)));
    }

    @Override // kotlinx.coroutines.i2
    public final void a(kotlinx.coroutines.internal.s r5, int r10) {
        kotlinx.coroutines.l r11 = this.f18787b;
        if (r11 == null) goto L6;
        r11.a(r5, r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(Continuation r18) {
        boolean r10 = false;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object r5 = this.f18786a;
        if (r5 != g.f18808p) goto L5;
    L7:
        AtomicReferenceFieldUpdater r13 = f.f18790i;
        f r14 = this.f18788c;
        o r15 = (o) r13.get(r14);
    L9:
        if (r14.A() == true) goto L10;
        long r16 = f.e.getAndIncrement(r14);
        int r17 = g.f18798b;
        long r19 = r16 / ((long) r17);
        int r20 = (int) (r16 % ((long) r17));
        if (r15.f18950c == r19) goto L21;
        o r21 = r14.t(r19, r15);
        if (r21 == null) goto L9;
        o r22 = r21;
    L22:
        Object r23 = r14.M(r22, r20, r16, null);
        g8.g r24 = g.f18805m;
        if (r23 == r24) goto L86;
        g8.g r110 = g.f18807o;
        if (r23 != r110) goto L31;
        if (r16 >= r14.x()) goto L29;
        r22.a();
    L29:
        r15 = r22;
        goto L9
    L31:
        if (r23 != g.f18806n) goto L82;
        f r111 = this.f18788c;
        kotlinx.coroutines.l r112 = j0.h(IntrinsicsKt.intercepted(r18));
        this.f18787b = r112;     // Catch: Throwable -> L42
        kotlinx.coroutines.internal.s r113 = r22;
        Object r25 = r111.M(r22, r20, r16, this);     // Catch: Throwable -> L42
        if (r25 != r24) goto L37;
        a(r113, r20);     // Catch: Throwable -> L42
    L76:
        Object r26 = r112.v();
        if (r26 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        DebugProbesKt.probeCoroutineSuspended(r18);
    L79:
        return r26;
    L37:
        Function3 r27 = null;
        Function1 r114 = r111.f18795b;
        if (r25 == r110) goto L40;
        r113.a();     // Catch: Throwable -> L42
        this.f18786a = r25;     // Catch: Throwable -> L42
        this.f18787b = null;     // Catch: Throwable -> L42
        Object r28 = Boxing.boxBoolean(true);     // Catch: Throwable -> L42
        if (r114 != null) goto L74;
    L69:
        r112.k(r28, r27);     // Catch: Throwable -> L42
        goto L76
    L74:
        r27 = new c(r11 == true ? 1 : 0, r114, r25);     // Catch: Throwable -> L42
        goto L69
    L40:
        if (r16 >= r111.x()) goto L44;
        r113.a();     // Catch: Throwable -> L42
    L44:
        o r29 = (o) f.f18790i.get(r111);     // Catch: Throwable -> L42
    L46:
        if (r111.A() == true) goto L47;
        long r115 = f.e.getAndIncrement(r111);     // Catch: Throwable -> L42
        long r30 = g.f18798b;     // Catch: Throwable -> L42
        long r31 = r115 / r30;     // Catch: Throwable -> L42
        int r116 = (int) (r115 % r30);     // Catch: Throwable -> L42
        if (r29.f18950c == r31) goto L54;
        o r32 = r111.t(r31, r29);     // Catch: Throwable -> L42
        if (r32 == null) goto L46;
        o r117 = r32;
    L55:
        Object r33 = r111.M(r117, r116, r115, this);     // Catch: Throwable -> L42
        if (r33 == g.f18805m) goto L57;
        if (r33 != g.f18807o) goto L65;
        if (r115 >= r111.x()) goto L63;
        r117.a();     // Catch: Throwable -> L42
    L63:
        r29 = r117;
        goto L46
    L65:
        if (r33 == g.f18806n) goto L71;
        r117.a();     // Catch: Throwable -> L42
        this.f18786a = r33;     // Catch: Throwable -> L42
        this.f18787b = null;     // Catch: Throwable -> L42
        r28 = Boxing.boxBoolean(true);     // Catch: Throwable -> L42
        if (r114 == null) goto L69;
        r27 = new c(r12 == true ? 1 : 0, r114, r33);     // Catch: Throwable -> L42
        goto L69
    L71:
        throw new IllegalStateException("unexpected");     // Catch: Throwable -> L42
    L57:
        a(r117, r116);     // Catch: Throwable -> L42
        goto L76
    L54:
        r117 = r29;
        goto L55
    L47:
        b(this);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r112.D();
        throw th;
    L82:
        r22.a();
        this.f18786a = r23;
    L6:
        r10 = true;
    L84:
        return Boxing.boxBoolean(r10);
    L86:
        throw new IllegalStateException("unreachable");
    L21:
        r22 = r15;
        goto L22
    L10:
        this.f18786a = g.f18804l;
        Throwable r34 = r14.u();
        if (r34 == null) goto L84;
        int r35 = kotlinx.coroutines.internal.t.f18951a;
        throw r34;
    L5:
        if (r5 == g.f18804l) goto L7;
        goto L6
    }

    public final Object d() {
        Object r5 = this.f18786a;
        g8.g r10 = g.f18808p;
        if (r5 == r10) goto L10;
        this.f18786a = r10;
        if (r5 == g.f18804l) goto L7;
        return r5;
    L7:
        Throwable r11 = this.f18788c.v();
        int r12 = kotlinx.coroutines.internal.t.f18951a;
        throw r11;
    L10:
        throw new IllegalStateException("`hasNext()` has not been invoked");
    }
}
