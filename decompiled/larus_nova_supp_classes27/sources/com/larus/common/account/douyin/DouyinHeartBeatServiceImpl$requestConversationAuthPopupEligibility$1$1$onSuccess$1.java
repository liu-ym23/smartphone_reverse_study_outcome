package com.larus.common.account.douyin;

import com.larus.account.base.api.ConversationAuthUpdateScene;
import com.larus.network.http.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import n38.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1$1$onSuccess$1", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
public final class DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n38.d $callback;
    final /* synthetic */ e $douYinTokenResult;
    final /* synthetic */ ConversationAuthUpdateScene $updateScene;
    int label;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1$1$onSuccess$1(DouyinHeartBeatServiceImpl r1, e r2, ConversationAuthUpdateScene r3, n38.d r4, Continuation<? super DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1$1$onSuccess$1> r5) {
        this.this$0 = r1;
        this.$douYinTokenResult = r2;
        this.$updateScene = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1$1$onSuccess$1(this.this$0, this.$douYinTokenResult, this.$updateScene, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        y r8 = (com.larus.network.http.a) r7;
        n38.d r3 = this.$callback;
        boolean r4 = r8 instanceof y;
        if (r4 == false) goto L21;
        DouyinHeartBeatServiceImpl$a r9 = (DouyinHeartBeatServiceImpl$a) ((com.larus.network.http.a) r8).b;
        if (r9 != null) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L21;
        r2 = true;
        goto L21
    L16:
        if (r9.a() != true) goto L18;
        r10 = true;
    L21:
        r3.onResult(r4, r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DouyinHeartBeatServiceImpl r11 = this.this$0;
        e r5 = this.$douYinTokenResult;
        ConversationAuthUpdateScene r6 = this.$updateScene;
        this.label = 1;
        int r12 = DouyinHeartBeatServiceImpl.d;
        r7 = r11.h(r5, false, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
