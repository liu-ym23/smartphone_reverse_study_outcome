package com.larus.platform.audit;

import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.platform.audit.BehaviorAuditApi$report$1", f = "BehaviorAuditApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BehaviorAuditApi$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $event;
    private /* synthetic */ Object L$0;
    int label;

    public BehaviorAuditApi$report$1(a r1, Continuation<? super BehaviorAuditApi$report$1> r2) {
        this.$event = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BehaviorAuditApi$report$1 r0 = new BehaviorAuditApi$report$1(this.$event, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        String r14 = this.$event.c;
        if (r14 != null) goto L23;
        AccountService r15 = AccountService.a;
        String r0 = r15.getSecUserId();
        boolean r2 = true;
        if (r0.length() <= 0) goto L9;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        if (r0 != null) goto L22;
        r14 = r15.getUserId();
        if (r14.length() > 0) goto L19;
        r2 = false;
    L19:
        if (r2 == true) goto L23;
        String r8 = null;
    L24:
        a r16 = this.$event;
        if (r16.c != null) goto L35;
        BehaviorAuditOperation r6 = r16.a;
        b r7 = r16.b;
        String r9 = r16.d;
        Map<String, Object> r10 = r16.e;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r6, "operation");
        Intrinsics.checkNotNullParameter(r10, "extras");
        r16 = new a(r6, r7, r8, r9, r10);
    L35:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L29
        FlowBehaviorAuditServiceDelegate.a.a(r16);     // Catch: Throwable -> L29
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L32:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L22:
        r8 = r0;
        goto L24
    L9:
        r1 = false;
    L23:
        r8 = r14;
        goto L24
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
