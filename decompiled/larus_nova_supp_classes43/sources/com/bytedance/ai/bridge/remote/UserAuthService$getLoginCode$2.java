package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.LoginCodeResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$getLoginCode$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$getLoginCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $aid;
    final /* synthetic */ String $clientKey;
    final /* synthetic */ String $exchangeType;
    final /* synthetic */ String $scope;
    final /* synthetic */ String $source;
    private /* synthetic */ Object L$0;
    int label;

    public UserAuthService$getLoginCode$2(String r1, String r10, String r11, String r12, String r13, Continuation<? super UserAuthService$getLoginCode$2> r14) {
        this.$clientKey = r1;
        this.$aid = r10;
        this.$scope = r11;
        this.$source = r12;
        this.$exchangeType = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        UserAuthService$getLoginCode$2 r12 = new UserAuthService$getLoginCode$2(this.$clientKey, this.$aid, this.$scope, this.$source, this.$exchangeType, r11);
        r12.L$0 = r10;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<String>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        SsResponse r12 = ((UserAuthApi) UserAuthService.c.create(UserAuthApi.class)).getLoginCode(this.$clientKey, this.$aid, this.$scope, this.$source, this.$exchangeType).execute();     // Catch: Throwable -> L38
        if (r12.isSuccessful() == true) goto L10;
        RemoteApiException.Http r1 = new RemoteApiException.Http(r12.code());     // Catch: Throwable -> L38
        g.a.e("UserAuthService", "getLoginCode: " + r1.getMessage());     // Catch: Throwable -> L38
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r1)));
    L10:
        LoginCodeResponse r14 = (LoginCodeResponse) r12.body();     // Catch: Throwable -> L38
        if (r14 != null) goto L14;
        RemoteApiException.InvalidResponse r15 = new RemoteApiException.InvalidResponse("login response body is null");     // Catch: Throwable -> L38
        g.a.e("UserAuthService", "getLoginCode: " + r15.getMessage());     // Catch: Throwable -> L38
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L38
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r15)));
    L14:
        LoginCodeResponse.Data r17 = r14.getData();     // Catch: Throwable -> L38
        Integer r18 = null;
        String r19 = null;
        if (Intrinsics.areEqual(r14.getMessage(), "success") == false) goto L28;
        if (r17 == null) goto L18;
        r19 = r17.getCode();     // Catch: Throwable -> L38
    L18:
        if (r19 != null) goto L20;
    L23:
        boolean r20 = true;
    L24:
        if (r20 == true) goto L26;
        Object r21 = Result.constructor-impl(r19);     // Catch: Throwable -> L38
    L41:
        return Result.box-impl(r21);
    L26:
        RemoteApiException.InvalidResponse r22 = new RemoteApiException.InvalidResponse("login code is missing");     // Catch: Throwable -> L38
        g.a.e("UserAuthService", "getLoginCode: " + r22.getMessage());     // Catch: Throwable -> L38
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L38
        r21 = Result.constructor-impl(ResultKt.createFailure(r22));     // Catch: Throwable -> L38
        goto L41
    L20:
        if (r19.length() == 0) goto L23;
        r20 = false;
        goto L24
    L28:
        if (r17 == null) goto L30;
        r18 = r17.getErrorCode();     // Catch: Throwable -> L38
    L30:
        if (r17 == null) goto L33;
        String r24 = r17.getDescription();     // Catch: Throwable -> L38
        if (r24 == null) goto L33;
    L36:
        RemoteApiException.Business r25 = new RemoteApiException.Business(r18, r24);     // Catch: Throwable -> L38
        g.a.e("UserAuthService", "getLoginCode: business error, code=" + r25.getCode());     // Catch: Throwable -> L38
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L38
        r21 = Result.constructor-impl(ResultKt.createFailure(r25));     // Catch: Throwable -> L38
    L33:
        r24 = r14.getMessage();     // Catch: Throwable -> L38
        if (r24 != null) goto L36;
        r24 = "login failed";
    L38:
        th = move-exception;
        RemoteApiException r27 = UserAuthService.b(th);
        String r28 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "getLoginCode CRASH: " + th.getMessage() + '\n' + r28);
        Result.Companion r29 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(r27));
        goto L41
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
