package com.obric.assistant.authenticationsession;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.QueryAuthenticationServiceImpl$rememberMsgAsAuthorized$1", f = "QueryAuthenticationServiceImpl.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class QueryAuthenticationServiceImpl$rememberMsgAsAuthorized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMsgId;
    int label;
    final /* synthetic */ QueryAuthenticationServiceImpl this$0;

    public QueryAuthenticationServiceImpl$rememberMsgAsAuthorized$1(QueryAuthenticationServiceImpl r1, String r2, Continuation<? super QueryAuthenticationServiceImpl$rememberMsgAsAuthorized$1> r3) {
        this.this$0 = r1;
        this.$localMsgId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new QueryAuthenticationServiceImpl$rememberMsgAsAuthorized$1(this.this$0, this.$localMsgId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        FLogger.a.i("QueryAuthenticationServiceImpl", "cache expired " + this.$localMsgId);
        QueryAuthenticationServiceImpl r7 = this.this$0;
        String r2 = this.$localMsgId;
        int r3 = QueryAuthenticationServiceImpl.i;
        r7.f(r2, false, true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        QueryAuthenticationServiceImpl r8 = this.this$0;
        int r4 = QueryAuthenticationServiceImpl.i;
        long r5 = ((Number) r8.g.getValue()).longValue();
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L11;
        return r0;
    }
}
