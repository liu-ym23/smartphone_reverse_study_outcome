package com.larus.suggest.impl.wcb.request;

import com.larus.platform.service.AccountService;
import com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator;
import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.suggest.impl.wcb.render.k;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.render.r;
import com.larus.utils.logger.FLogger;
import hx9.l;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbRequestPipeline {
    public final l a;
    public final String b;
    public final r c;
    public final CoroutineScope d;
    public final WcbRequestExecutionRunner e;
    public final WcbResponseConsumer f;
    public long g;
    public q h;

    public final long d() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[pipeline] transaction.invalidate chat=");
        r1.append(this.a.b());
        r1.append(" exec=");
        r1.append(this.g);
        r1.append(" hasTransaction=");
        if (this.h == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("WcbLog", r1.toString());
        this.g++;
        q r3 = this.h;
        if (r3 == null) goto L9;
        r3.cancel();
    L9:
        this.h = null;
        return this.g;
    L5:
        r2 = false;
        goto L6
    }

    public final void a(c r12) {
        Intrinsics.checkNotNullParameter(r12, "request");
        if (r12.b != WcbRequestTrigger.FOREGROUND) goto L13;
        q r0 = this.h;
        if (r0 == null) goto L9;
        boolean r1 = true;
        if (r0.isActive() != true) goto L9;
    L10:
        if (r1 == false) goto L13;
        this.a.x4();
        return;
    L9:
        r1 = false;
    L13:
        long r3 = d();
        BuildersKt.launch$default(this.d, null, null, new WcbRequestPipeline$execute$1(this, r12, r3, null), 3, null);
    }

    public final boolean e(f r6) {
        if (r6.e == this.g) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r6.a, AccountService.a.getUserId()) == false) goto L7;
        return true;
    }

    public final Object c(q r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof WcbRequestPipeline$finishRenderTransaction$1) == false) goto L7;
        WcbRequestPipeline$finishRenderTransaction$1 r0 = (WcbRequestPipeline$finishRenderTransaction$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (q) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L25
    L20:
        if (this.h != r7) goto L24;
        this.h = null;
    L24:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("WcbLog", "[pipeline] transaction.finish isActive=" + r7.isActive() + ", transaction=" + r7);
        r0.L$0 = r7;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        if (r7.b(r0) != r2) goto L20;
        return r2;
    L25:
        th = move-exception;
        if (this.h != r7) goto L29;
        this.h = null;
    L29:
        throw th;
    L7:
        r0 = new WcbRequestPipeline$finishRenderTransaction$1(this, r8);
        goto L8
    }

    public final Object b(f r22, jx9.a r23, a0 r24, Continuation<? super Unit> r25) {
        if ((r25 instanceof WcbRequestPipeline$executeDecision$1) == false) goto L7;
        WcbRequestPipeline$executeDecision$1 r2 = (WcbRequestPipeline$executeDecision$1) r25;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        WcbRequestPipeline$executeDecision$1 r9 = r2;
        Object r1 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r9.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L14;
        Throwable r0 = (Throwable) r9.L$0;
        ResultKt.throwOnFailure(r1);
        throw r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
    L39:
        return Unit.INSTANCE;
    L17:
        q r5 = (q) r9.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L20
    L35:
        r9.L$0 = null;
        r9.label = 2;
        if (c(r5, r9) != r10) goto L39;
        return r10;
    L20:
        th = th;
    L45:
        r9.L$0 = th;
        r9.label = 3;
        if (c(r5, r9) != r10) goto L55;
        return r10;
    L55:
        throw th;
    L22:
        ResultKt.throwOnFailure(r1);
        if (e(r22) == true) goto L25;
        q r7 = null;
    L26:
        if (r7 != null) goto L53;
        FLogger.a.w("WcbLog", "[pipeline] transaction is null, exec=" + r22.e);
        return Unit.INSTANCE;
    L53:
        Ref.ObjectRef r6 = new Ref.ObjectRef();     // Catch: Throwable -> L42
        WcbRequestExecutionRunner r8 = this.e;     // Catch: Throwable -> L42
        long r11 = r23.e;     // Catch: Throwable -> L42
        q r12 = r7;
        WcbRequestPipeline$executeDecision$2 r16 = new WcbRequestPipeline$executeDecision$2(r6, this, r22, r23, r7, null);     // Catch: Throwable -> L40
        r9.L$0 = r12;     // Catch: Throwable -> L40
        r9.label = 1;     // Catch: Throwable -> L40
        if (r8.a(r22, r24, r11, r16, r9) != r10) goto L34;
        return r10;
    L34:
        r5 = r12;
    L40:
        th = th;
    L44:
        r5 = r12;
    L42:
        th = th;
        r12 = r7;
        goto L44
    L25:
        FLogger.a.i("WcbLog", "[pipeline] transaction.begin chat=" + r22.d + " exec=" + r22.e + " decision=" + r24.getClass().getSimpleName());
        q r13 = this.c.a(new k(r22, r23, r24));
        this.h = r13;
        r7 = r13;
    L7:
        r2 = new WcbRequestPipeline$executeDecision$1(this, r25);
        goto L8
    }

    public WcbRequestPipeline(hx9.a r2, String r3, WcbLoadingRenderDecorator r4, kx9.a r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "initializedConversationId");
        Intrinsics.checkNotNullParameter(r4, "renderer");
        Intrinsics.checkNotNullParameter(r5, "monitor");
        Intrinsics.checkNotNullParameter(r6, "inputStateTracker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.e = new WcbRequestExecutionRunner(r6);
        this.f = new WcbResponseConsumer(r2, r5, r6);
    }
}
