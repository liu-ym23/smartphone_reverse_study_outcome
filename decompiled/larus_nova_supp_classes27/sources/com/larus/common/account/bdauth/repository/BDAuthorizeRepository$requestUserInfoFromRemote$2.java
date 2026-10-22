package com.larus.common.account.bdauth.repository;

import com.larus.account.base.api.IAccountService;
import com.larus.common.account.bdauth.api.AuthorizeApi;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.service.AccountService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/account/base/model/profile/UserInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository$requestUserInfoFromRemote$2", f = "BDAuthorizeRepository.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
final class BDAuthorizeRepository$requestUserInfoFromRemote$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super r38.b>, Object> {
    int label;

    public BDAuthorizeRepository$requestUserInfoFromRemote$2(Continuation<? super BDAuthorizeRepository$requestUserInfoFromRemote$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BDAuthorizeRepository$requestUserInfoFromRemote$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super r38.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        r38.b r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        dm9.a.b r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L20;
        dm9.a.b r16 = r15;
        if (r16.a.isSuccess() == false) goto L20;
        t38.c r17 = (t38.c) r16.a.getData();
        if (r17 == null) goto L18;
        r3 = r17.a();
    L18:
        if (r3 == null) goto L20;
        IAccountService.Companion r18 = IAccountService.a;
        r18.l(r3);
        r18.o(AccountService.a.getUserId(), r3.c(), "bdauth_request_user_info");
        r18.m();
    L20:
        return r3;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        AuthorizeApi.a r110 = AuthorizeApi.a;
        BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1 r6 = new BDAuthorizeRepository$requestUserInfoFromRemote$2$result$1(null);
        this.label = 1;
        r110.getClass();
        FlowHttpConnection r111 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Basic", AuthorizeApi.class, r6, true, null, null, null, this, BaiduNaviStatus.NO_PERMISSION);
        if (r14 != r0) goto L11;
        return r0;
    }
}
