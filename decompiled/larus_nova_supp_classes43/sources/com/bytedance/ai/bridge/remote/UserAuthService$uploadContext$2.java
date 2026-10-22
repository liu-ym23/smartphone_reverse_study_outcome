package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.UploadModelContextRequest;
import com.bytedance.ai.bridge.remote.model.UploadModelContextResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/UploadModelContextResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$uploadContext$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$uploadContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends UploadModelContextResponse>>, Object> {
    final /* synthetic */ UploadModelContextRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    public UserAuthService$uploadContext$2(UploadModelContextRequest r1, Continuation<? super UserAuthService$uploadContext$2> r10) {
        this.$request = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        UserAuthService$uploadContext$2 r0 = new UserAuthService$uploadContext$2(this.$request, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<UploadModelContextResponse>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        SsResponse r12 = UserAuthService.e.uploadModelContext(this.$request).execute();     // Catch: Throwable -> L28
        if (r12.isSuccessful() == true) goto L10;
        RemoteApiException.Http r1 = new RemoteApiException.Http(r12.code());     // Catch: Throwable -> L28
        g.a.e("UserAuthService", "uploadContext: " + r1.getMessage());     // Catch: Throwable -> L28
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L28
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r1)));
    L10:
        UploadModelContextResponse r14 = (UploadModelContextResponse) r12.body();     // Catch: Throwable -> L28
        if (r14 != null) goto L15;
        RemoteApiException.InvalidResponse r15 = new RemoteApiException.InvalidResponse("upload context response body is null");     // Catch: Throwable -> L28
        g.a.e("UserAuthService", "uploadContext: " + r15.getMessage());     // Catch: Throwable -> L28
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r15)));
    L15:
        if (r14.getErrCode() == null) goto L26;
        Integer r17 = r14.getErrCode();     // Catch: Throwable -> L28
        if (r17 != null) goto L20;
    L22:
        Integer r18 = r14.getErrCode();     // Catch: Throwable -> L28
        String r19 = r14.getErrMsg();     // Catch: Throwable -> L28
        if (r19 != null) goto L25;
        r19 = "upload context failed";
    L25:
        RemoteApiException.Business r20 = new RemoteApiException.Business(r18, r19);     // Catch: Throwable -> L28
        g.a.e("UserAuthService", "uploadContext: business error, code=" + r20.getCode());     // Catch: Throwable -> L28
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L28
        Object r22 = Result.constructor-impl(ResultKt.createFailure(r20));     // Catch: Throwable -> L28
    L31:
        return Result.box-impl(r22);
    L20:
        if (r17.intValue() != 0) goto L22;
    L26:
        r22 = Result.constructor-impl(r14);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        RemoteApiException r23 = UserAuthService.b(th);
        String r24 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "uploadContext CRASH: " + th.getMessage() + '\n' + r24);
        Result.Companion r25 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(r23));
        goto L31
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
