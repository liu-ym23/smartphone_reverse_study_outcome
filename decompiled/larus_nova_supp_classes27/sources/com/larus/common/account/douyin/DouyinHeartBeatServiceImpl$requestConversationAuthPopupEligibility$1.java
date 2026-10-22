package com.larus.common.account.douyin;

import com.larus.account.base.api.ConversationAuthUpdateScene;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n38.d $callback;
    final /* synthetic */ IThirdPartyPlatformLoginProvider $douyinLogin;
    final /* synthetic */ ConversationAuthUpdateScene $updateScene;
    int label;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1(IThirdPartyPlatformLoginProvider r1, n38.d r2, DouyinHeartBeatServiceImpl r3, ConversationAuthUpdateScene r4, Continuation<? super DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1> r5) {
        this.$douyinLogin = r1;
        this.$callback = r2;
        this.this$0 = r3;
        this.$updateScene = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DouyinHeartBeatServiceImpl$requestConversationAuthPopupEligibility$1(this.$douyinLogin, this.$callback, this.this$0, this.$updateScene, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        IThirdPartyPlatformLoginProvider r7 = this.$douyinLogin;
        GetOauthTokenTriggerScene r0 = GetOauthTokenTriggerScene.Request;
        final n38.d r2 = this.$callback;
        final DouyinHeartBeatServiceImpl r3 = this.this$0;
        final ConversationAuthUpdateScene r4 = this.$updateScene;
        r7.k(false, r0, new AnonymousClass1(r2, r3, r4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
