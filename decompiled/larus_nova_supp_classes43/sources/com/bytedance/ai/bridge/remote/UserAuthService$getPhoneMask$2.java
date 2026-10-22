package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.PhoneMaskRequest;
import com.bytedance.ai.bridge.remote.model.PhoneMaskResponse;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$getPhoneMask$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$getPhoneMask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $versionTag;
    int label;

    public UserAuthService$getPhoneMask$2(String r1, Continuation<? super UserAuthService$getPhoneMask$2> r10) {
        this.$versionTag = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$getPhoneMask$2(this.$versionTag, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<String>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r10);
        SsResponse r11 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).getPhoneMask(new PhoneMaskRequest(this.$versionTag)).execute();     // Catch: Throwable -> L18
        if (r11.isSuccessful() == true) goto L8;
    L16:
        String r12 = "Http Error: " + r11.code();     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "getPhoneMask: Http Error: " + r12);     // Catch: Throwable -> L18
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        Object r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r12)));     // Catch: Throwable -> L18
    L30:
    L27:
        return Result.box-impl(r13);
    L8:
        if (r11.body() == null) goto L16;
        PhoneMaskResponse r14 = (PhoneMaskResponse) r11.body();     // Catch: Throwable -> L18
        if (r14.getErrCode() != 0) goto L15;
        String r15 = r14.getPhoneMask();     // Catch: Throwable -> L18
        if (r15 != null) goto L14;
        r15 = "";
    L14:
        r13 = Result.constructor-impl(r15);     // Catch: Throwable -> L18
        goto L30
    L15:
        String r16 = "Biz Error: " + r14.getErrMsg() + " (" + r14.getErrCode() + ')';     // Catch: Throwable -> L18
        g.a.e("UserAuthService", "getPhoneMask: Biz Error: " + r16);     // Catch: Throwable -> L18
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L18
        r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r16)));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        String r18 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "getPhoneMask CRASH: " + th.getMessage() + '\n' + r18);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L22;
        Exception r19 = th;
    L23:
        if (r19 != null) goto L25;
        r19 = new Exception(th);
    L25:
        r13 = Result.constructor-impl(ResultKt.createFailure(r19));
        goto L27
    L22:
        r19 = null;
        goto L23
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
