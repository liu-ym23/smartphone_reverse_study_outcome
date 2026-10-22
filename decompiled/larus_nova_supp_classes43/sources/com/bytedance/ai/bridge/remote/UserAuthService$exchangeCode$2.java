package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.ExchangeCodeRequest;
import com.bytedance.ai.bridge.remote.model.ExchangeCodeResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$exchangeCode$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$exchangeCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $code;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $versionTag;
    private /* synthetic */ Object L$0;
    int label;

    public UserAuthService$exchangeCode$2(String r1, String r10, String r11, String r12, Continuation<? super UserAuthService$exchangeCode$2> r13) {
        this.$versionTag = r1;
        this.$appKey = r10;
        this.$code = r11;
        this.$deviceId = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        UserAuthService$exchangeCode$2 r12 = new UserAuthService$exchangeCode$2(this.$versionTag, this.$appKey, this.$code, this.$deviceId, r11);
        r12.L$0 = r10;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
    L32:
        th = move-exception;
        RemoteApiException r1 = UserAuthService.b(th);
        String r12 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "exchangeCode CRASH: " + th.getMessage() + '\n' + r12);
        Result.Companion r13 = Result.Companion;
        Object r14 = Result.constructor-impl(ResultKt.createFailure(r1));
    L35:
        return Result.box-impl(r14);
    L6:
        if (this.$versionTag.length() != 0) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L11;
    L14:
        String r16 = null;
    L15:
        SsResponse r17 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).exchangeCode(new ExchangeCodeRequest(this.$appKey, this.$code, this.$deviceId, r16)).execute();     // Catch: Throwable -> L32
        if (r17.isSuccessful() == true) goto L20;
        RemoteApiException.Http r18 = new RemoteApiException.Http(r17.code());     // Catch: Throwable -> L32
        g.a.e("UserAuthService", "exchangeCode: " + r18.getMessage());     // Catch: Throwable -> L32
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L32
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r18)));
    L20:
        ExchangeCodeResponse r20 = (ExchangeCodeResponse) r17.body();     // Catch: Throwable -> L32
        if (r20 != null) goto L25;
        RemoteApiException.InvalidResponse r21 = new RemoteApiException.InvalidResponse("exchange code response body is null");     // Catch: Throwable -> L32
        g.a.e("UserAuthService", "exchangeCode: " + r21.getMessage());     // Catch: Throwable -> L32
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L32
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r21)));
    L25:
        if (r20.getErrCode() != 0) goto L27;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L32
        r14 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L32
        goto L35
    L27:
        Integer r24 = Boxing.boxInt(r20.getErrCode());     // Catch: Throwable -> L32
        String r25 = r20.getErrMsg();     // Catch: Throwable -> L32
        if (r25 != null) goto L30;
        r25 = "exchange code failed";
    L30:
        RemoteApiException.Business r26 = new RemoteApiException.Business(r24, r25);     // Catch: Throwable -> L32
        g.a.e("UserAuthService", "exchangeCode: business error, code=" + r26.getCode());     // Catch: Throwable -> L32
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L32
        r14 = Result.constructor-impl(ResultKt.createFailure(r26));     // Catch: Throwable -> L32
        goto L35
    L11:
        if (StringsKt.isBlank(this.$versionTag) == true) goto L14;
        r16 = this.$versionTag;     // Catch: Throwable -> L32
        goto L15
    L8:
        r15 = false;
        goto L9
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
