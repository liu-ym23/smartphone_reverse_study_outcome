package com.larus.reach.impl;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ns9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$sendRequest$2", f = "ReachActionExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$sendRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $click;
    final /* synthetic */ Context $context;
    final /* synthetic */ ns9.t $request;
    final /* synthetic */ dm9.a<ReachActionResponse> $result;
    int label;
    final /* synthetic */ a this$0;

    public ReachActionExecutor$sendRequest$2(a r1, Context r2, ns9.t r3, e r4, dm9.a<ReachActionResponse> r5, Continuation<? super ReachActionExecutor$sendRequest$2> r6) {
        this.this$0 = r1;
        this.$context = r2;
        this.$request = r3;
        this.$click = r4;
        this.$result = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ReachActionExecutor$sendRequest$2(this.this$0, this.$context, this.$request, this.$click, this.$result, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r9);
        a r10 = this.this$0;
        Context r0 = this.$context;
        ns9.t r1 = this.$request;
        e r2 = this.$click;
        dm9.a.b r3 = this.$result;
        int r4 = a.b;
        r10.getClass();
        if ((r3 instanceof dm9.a.b) == false) goto L25;
        ReachActionResponse r11 = (ReachActionResponse) r3.a.getData();
        if (r11 != null) goto L9;
        t19.s.a.getClass();
        t19.s.s(r0, 2131907052);
        b.c(r1, r2, false, "system_error");
        FLogger.a.w("ReachAction", "reach action returned empty data, reachUniqueId=" + r1.a.h);
    L28:
        return Unit.INSTANCE;
    L9:
        String r5 = r11.getShowMessage();
        if (r5 != null) goto L12;
    L20:
        Boolean r6 = r11.isSuccess();
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == true) goto L23;
        FLogger.a.w("ReachAction", "reach action failed, reachUniqueId=" + r1.a.h + ", reason=" + r11.getFailReason());
    L23:
        ConcurrentHashMap<String, Long> r8 = b.a;
        b.c(r1, r2, Intrinsics.areEqual(r11.isSuccess(), r7), r11.getFailReason());
        goto L28
    L12:
        if ((!StringsKt.isBlank(r5)) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L20;
        if (Intrinsics.areEqual(r11.isSuccess(), Boolean.TRUE) == false) goto L19;
        t19.s.a.getClass();
        t19.s.p(r0, r5);
        goto L20
    L19:
        t19.s.a.getClass();
        t19.s.t(r0, r5);
        goto L20
    L25:
        if ((r3 instanceof dm9.a.a) == false) goto L30;
        t19.s.a.getClass();
        t19.s.s(r0, 2131907052);
        b.c(r1, r2, false, "system_error");
        FLogger.a.w("ReachAction", "reach action request failed, reachUniqueId=" + r1.a.h);
        goto L28
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
