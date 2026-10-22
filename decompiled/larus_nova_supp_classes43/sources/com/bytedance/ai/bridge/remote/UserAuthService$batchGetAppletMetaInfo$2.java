package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.BatchGetAppMetaRequest;
import com.bytedance.ai.bridge.remote.model.BatchGetAppMetaResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/BatchAppletMetaInfoResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$batchGetAppletMetaInfo$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$batchGetAppletMetaInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends p4.b>>, Object> {
    final /* synthetic */ List<String> $appKeys;
    int label;

    public UserAuthService$batchGetAppletMetaInfo$2(List<String> r1, Continuation<? super UserAuthService$batchGetAppletMetaInfo$2> r10) {
        this.$appKeys = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$batchGetAppletMetaInfo$2(this.$appKeys, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<p4.b>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r10);
        if (this.$appKeys.isEmpty() == false) goto L9;
        Result.Companion r11 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: app_keys is empty (1001)"))));
    L9:
        if (this.$appKeys.size() <= 50) goto L38;
        Result.Companion r12 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: app_keys size exceeds 50 (1001)"))));
    L38:
        SsResponse r13 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).batchGetAppletAppMeta(new BatchGetAppMetaRequest(this.$appKeys)).execute();     // Catch: Throwable -> L26
        if (r13.isSuccessful() == true) goto L15;
    L24:
        String r14 = "Http Error: " + r13.code();     // Catch: Throwable -> L26
        g.a.e("UserAuthService", "batchGetAppletMetaInfo: Http Error: " + r14);     // Catch: Throwable -> L26
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        Object r15 = Result.constructor-impl(ResultKt.createFailure(new Exception(r14)));     // Catch: Throwable -> L26
    L35:
        return Result.box-impl(r15);
    L15:
        if (r13.body() == null) goto L24;
        BatchGetAppMetaResponse r16 = (BatchGetAppMetaResponse) r13.body();     // Catch: Throwable -> L26
        if (r16.getCode() != 0) goto L23;
        BatchGetAppMetaResponse.Data r17 = r16.getData();     // Catch: Throwable -> L26
        if (r17 != null) goto L22;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L26
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: data is null (0)"))));
    L22:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L26
        r15 = Result.constructor-impl(new p4.b(r17.getItems(), r17.getFailedKeys()));     // Catch: Throwable -> L26
        goto L35
    L23:
        String r20 = "Biz Error: " + r16.getMessage() + " (" + r16.getCode() + ')';     // Catch: Throwable -> L26
        g.a.e("UserAuthService", "batchGetAppletMetaInfo: Biz Error: " + r20);     // Catch: Throwable -> L26
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L26
        r15 = Result.constructor-impl(ResultKt.createFailure(new Exception(r20)));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        String r22 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "batchGetAppletMetaInfo CRASH: " + th.getMessage() + '\n' + r22);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L30;
        Exception r23 = th;
    L31:
        if (r23 != null) goto L33;
        r23 = new Exception(th);
    L33:
        r15 = Result.constructor-impl(ResultKt.createFailure(r23));
        goto L35
    L30:
        r23 = null;
        goto L31
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
