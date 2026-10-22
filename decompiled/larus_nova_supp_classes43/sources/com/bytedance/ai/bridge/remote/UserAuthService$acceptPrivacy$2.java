package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.PrivacyAcceptRequest;
import com.bytedance.ai.bridge.remote.model.PrivacyAcceptResponse;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$acceptPrivacy$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$acceptPrivacy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $deviceId;
    int label;

    public UserAuthService$acceptPrivacy$2(String r1, String r10, Continuation<? super UserAuthService$acceptPrivacy$2> r11) {
        this.$appKey = r1;
        this.$deviceId = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$acceptPrivacy$2(this.$appKey, this.$deviceId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        SsResponse r11 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).acceptPrivacy(new PrivacyAcceptRequest(this.$appKey, "requestId", this.$deviceId)).execute();     // Catch: Throwable -> L15
        if (r11.isSuccessful() == true) goto L8;
    L13:
        String r12 = "Http Error: " + r11.code();     // Catch: Throwable -> L15
        g.a.e("UserAuthService", "acceptPrivacy: Http Error: " + r12);     // Catch: Throwable -> L15
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        Object r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r12)));     // Catch: Throwable -> L15
    L27:
    L24:
        return Result.box-impl(r13);
    L8:
        if (r11.body() == null) goto L13;
        PrivacyAcceptResponse r14 = (PrivacyAcceptResponse) r11.body();     // Catch: Throwable -> L15
        if (r14.getErrCode() != 0) goto L12;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        r13 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L15
        goto L27
    L12:
        String r16 = "Biz Error: " + r14.getErrMsg() + " (" + r14.getErrCode() + ')';     // Catch: Throwable -> L15
        g.a.e("UserAuthService", "acceptPrivacy: Biz Error: " + r16);     // Catch: Throwable -> L15
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r16)));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        String r18 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "acceptPrivacy CRASH: " + th.getMessage() + '\n' + r18);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L19;
        Exception r19 = th;
    L20:
        if (r19 != null) goto L22;
        r19 = new Exception(th);
    L22:
        r13 = Result.constructor-impl(ResultKt.createFailure(r19));
        goto L24
    L19:
        r19 = null;
        goto L20
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
