package com.bytedance.ai.bridge.remote;

import android.util.Log;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import p4.m;
import p4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/GetAwemeCommonLoginInfoResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$getAwemeCommonLoginInfo$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$getAwemeCommonLoginInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends n>>, Object> {
    final /* synthetic */ String $appKey;
    int label;

    public UserAuthService$getAwemeCommonLoginInfo$2(String r1, Continuation<? super UserAuthService$getAwemeCommonLoginInfo$2> r10) {
        this.$appKey = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$getAwemeCommonLoginInfo$2(this.$appKey, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<n>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r10);
        if (StringsKt.isBlank(this.$appKey) == false) goto L34;
        Result.Companion r11 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: app_key is empty (1001)"))));
    L34:
        SsResponse r12 = UserAuthService.d.getAwemeCommonLoginInfo(new m(this.$appKey)).execute();     // Catch: Throwable -> L18
        if (r12.isSuccessful() == true) goto L11;
    L16:
        String r13 = "Http Error: " + r12.code();     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "getAwemeCommonLoginInfo: Http Error: " + r13);     // Catch: Throwable -> L18
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Object r14 = Result.constructor-impl(ResultKt.createFailure(new Exception(r13)));     // Catch: Throwable -> L18
    L33:
    L29:
        return Result.box-impl(r14);
    L11:
        if (r12.body() == null) goto L16;
        n r15 = (n) r12.body();     // Catch: Throwable -> L18
        if (r15.d() == false) goto L15;
        r14 = Result.constructor-impl(r15);     // Catch: Throwable -> L18
        goto L33
    L15:
        String r16 = "Biz Error: " + r15.b() + " (" + r15.a() + ')';     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "getAwemeCommonLoginInfo: Biz Error: " + r16);     // Catch: Throwable -> L18
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L18
        r14 = Result.constructor-impl(ResultKt.createFailure(new Exception(r16)));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L30;
        String r18 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "getAwemeCommonLoginInfo CRASH: " + th.getMessage() + '\n' + r18);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L24;
        Exception r19 = th;
    L25:
        if (r19 != null) goto L27;
        r19 = new Exception(th);
    L27:
        r14 = Result.constructor-impl(ResultKt.createFailure(r19));
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
