package com.larus.common.account.bdauth.repository;

import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.login.api.LoginService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.bdauth.repository.BDAuthorizeRepository$createDefaultUserInfo$2", f = "BDAuthorizeRepository.kt", i = {}, l = {505}, m = "invokeSuspend", n = {}, s = {})
final class BDAuthorizeRepository$createDefaultUserInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BDAuthorizeRepository$createDefaultUserInfo$2(Continuation<? super BDAuthorizeRepository$createDefaultUserInfo$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BDAuthorizeRepository$createDefaultUserInfo$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L14:
        y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof y) == false) goto L22;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("createDefaultUserInfo success result=");
        com.larus.common.account.bdauth.model.c r5 = (com.larus.common.account.bdauth.model.c) ((com.larus.network.http.a) r2).b;
        if (r5 == null) goto L19;
        String r6 = r5.a();
    L20:
        r4.append(r6);
        r3.i("BDAuthorizeRepository", r4.toString());
        IAccountService.a.m();
        LoginService.a.E(Boolean.TRUE);
        goto L22
    L19:
        r6 = null;
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        FLogger r7 = FLogger.a;
        r7.i("BDAuthorizeRepository", "createDefaultUserInfo");
        if (IAccountService.a.p() == false) goto L11;
        r7.i("BDAuthorizeRepository", "createDefaultUserInfo hasRegister");
    L11:
        JSONObject r8 = new JSONObject();
        r8.put("entity_id", ILoginService.a.getAccountInfo().c);
        r8.put("nickname", "");
        r8.put("user_name", "");
        r8.put("avatar_url", "");
        r8.put("is_register", false);
        Unit r9 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", com.larus.common.account.bdauth.model.c.class, "/alice/profile/update_profile", r8, null, null, true, null, null, null, this, 944);
        if (r1 != r13) goto L14;
        return r13;
    }
}
