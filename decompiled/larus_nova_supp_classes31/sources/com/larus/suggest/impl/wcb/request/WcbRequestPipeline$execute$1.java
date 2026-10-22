package com.larus.suggest.impl.wcb.request;

import android.os.SystemClock;
import com.larus.platform.service.AccountService;
import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.suggest.impl.wcb.policy.b0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbRequestPipeline$execute$1", f = "WcbRequestPipeline.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class WcbRequestPipeline$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $executionId;
    final /* synthetic */ c $request;
    int label;
    final /* synthetic */ WcbRequestPipeline this$0;

    public WcbRequestPipeline$execute$1(WcbRequestPipeline r1, c r2, long r3, Continuation<? super WcbRequestPipeline$execute$1> r5) {
        this.this$0 = r1;
        this.$request = r2;
        this.$executionId = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new WcbRequestPipeline$execute$1(this.this$0, this.$request, this.$executionId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        WcbRequestPipeline r3 = this.this$0;
        c r13 = this.$request;
        long r14 = this.$executionId;
        this.label = 1;
        r3.getClass();
        FLogger r4 = FLogger.a;
        r4.i("WcbLog", "[pipeline] start execute, executionId=" + r14 + ", requestScene=" + r13.f + ", scene=" + r13.a.getKey() + ", trigger=" + r13.b + ", reqSrc=" + r13.d + ", conv_id=" + r3.b);
        f r10 = new f(AccountService.a.getUserId(), r3.b, r3.a.e(), r3.a.b(), r14, r13);
        if (r3.e(r10) == true) goto L11;
        Unit r0 = Unit.INSTANCE;
    L17:
        Object r5 = r0;
    L23:
        if (r5 != r16) goto L26;
        return r1;
    L11:
        String r6 = r13.a.b().a(r10, r3.a);
        if (r6 == null) goto L14;
        r4.w("WcbLog", "intercept next pulse request, executionId=" + r14 + ", reason=" + r6);
        r0 = Unit.INSTANCE;
        goto L17
    L14:
        String r7 = r10.b;
        c r8 = r10.f;
        jx9.a r11 = new jx9.a(r7, r8.f, r8.c, r8.d, SystemClock.elapsedRealtime());
        r11.h = r13.a.h().e(r10);
        b0 r9 = r13.a.f();
        b r12 = b.a;
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        a0 r15 = r9.a(r10, b.c.containsKey(b.c(r10)));
        r4.d("WcbLog", "[pipeline] request execution decision, executionId=" + r14 + ", decision=" + r15.getClass().getName());
        if ((r15 instanceof a0.d) == false) goto L18;
        r4.w("WcbLog", "[pipeline] decision intercept next pulse request, reason=" + ((a0.d) r15).a + ", exec=" + r10.e);
        r0 = Unit.INSTANCE;
        goto L17
    L18:
        r5 = r3.b(r10, r11, r15, this);
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r5 = Unit.INSTANCE;
        goto L23
    }
}
