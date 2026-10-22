package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/FetchDomainPolicyResponse$Data;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$fetchDomainPolicy$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$fetchDomainPolicy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FetchDomainPolicyResponse.Data>>, Object> {
    final /* synthetic */ String $appKey;
    int label;

    public UserAuthService$fetchDomainPolicy$2(String r1, Continuation<? super UserAuthService$fetchDomainPolicy$2> r10) {
        this.$appKey = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$fetchDomainPolicy$2(this.$appKey, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<FetchDomainPolicyResponse.Data>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r10);
        SsResponse r11 = UserAuthService.f.fetchDomainPolicy(this.$appKey).execute();     // Catch: Throwable -> L18
        if (r11.isSuccessful() == true) goto L9;
    L16:
        String r12 = "Http Error: " + r11.code();     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "fetchDomainPolicy: " + r12);     // Catch: Throwable -> L18
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Object r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r12)));     // Catch: Throwable -> L18
    L33:
    L29:
        return Result.box-impl(r13);
    L9:
        if (r11.body() == null) goto L16;
        FetchDomainPolicyResponse r14 = (FetchDomainPolicyResponse) r11.body();     // Catch: Throwable -> L18
        if (r14.getCode() == 0) goto L13;
    L15:
        String r15 = "Biz Error: " + r14.getMessage() + " (" + r14.getCode() + "), logId: " + r14.getLogId();     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "fetchDomainPolicy: " + r15);     // Catch: Throwable -> L18
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L18
        r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r15)));     // Catch: Throwable -> L18
        goto L33
    L13:
        if (r14.getData() == null) goto L15;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L18
        r13 = Result.constructor-impl(r14.getData());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L30;
        String r18 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "fetchDomainPolicy CRASH: " + th.getMessage() + '\n' + r18);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L24;
        Exception r19 = th;
    L25:
        if (r19 != null) goto L27;
        r19 = new Exception(th);
    L27:
        r13 = Result.constructor-impl(ResultKt.createFailure(r19));
        goto L29
    L24:
        r19 = null;
        goto L25
    L30:
        throw th;
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
