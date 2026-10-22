package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusRequest;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusResponse;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.ai.bridge.remote.model.PrivacyCard;
import com.bytedance.ai.bridge.remote.model.PrivacyData;
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
import p4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/CheckPrivacyOrLoginStatusResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$checkPrivacyOrLoginStatus$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$checkPrivacyOrLoginStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends i>>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ CheckType $checkType;
    final /* synthetic */ String $versionTag;
    int label;

    public UserAuthService$checkPrivacyOrLoginStatus$2(String r1, String r10, CheckType r11, Continuation<? super UserAuthService$checkPrivacyOrLoginStatus$2> r12) {
        this.$appKey = r1;
        this.$versionTag = r10;
        this.$checkType = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$checkPrivacyOrLoginStatus$2(this.$appKey, this.$versionTag, this.$checkType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<i>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r10);
        Exception r11 = null;
        SsResponse r12 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).checkPrivacyOrLoginStatus(new CheckPrivacyOrLoginStatusRequest(this.$appKey, this.$versionTag, this.$checkType)).execute();     // Catch: Throwable -> L32
        if (r12.isSuccessful() == true) goto L8;
    L30:
        String r1 = "Http Error: " + r12.code();     // Catch: Throwable -> L32
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus: Http Error: " + r1);     // Catch: Throwable -> L32
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L32
        Object r14 = Result.constructor-impl(ResultKt.createFailure(new Exception(r1)));     // Catch: Throwable -> L32
    L40:
        return Result.box-impl(r14);
    L8:
        if (r12.body() == null) goto L30;
        CheckPrivacyOrLoginStatusResponse r15 = (CheckPrivacyOrLoginStatusResponse) r12.body();     // Catch: Throwable -> L32
        if (r15.getErrCode() == null) goto L18;
        Integer r16 = r15.getErrCode();     // Catch: Throwable -> L32
        if (r16 != null) goto L15;
    L17:
        String r17 = "Biz Error: " + r15.getErrMsg() + " (" + r15.getErrCode() + ')';     // Catch: Throwable -> L32
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus: Biz Error: " + r17);     // Catch: Throwable -> L32
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L32
        r14 = Result.constructor-impl(ResultKt.createFailure(new Exception(r17)));     // Catch: Throwable -> L32
        goto L40
    L15:
        if (r16.intValue() != 0) goto L17;
    L18:
        PrivacyData r19 = r15.getData();     // Catch: Throwable -> L32
        boolean r20 = false;
        if (r19 == null) goto L21;
        boolean r21 = r19.getPrivacyAgreed();     // Catch: Throwable -> L32
    L22:
        PrivacyData r22 = r15.getData();     // Catch: Throwable -> L32
        if (r22 == null) goto L25;
        PrivacyCard r23 = r22.getPrivacyCard();     // Catch: Throwable -> L32
    L26:
        Boolean r24 = r15.getAlreadyLogin();     // Catch: Throwable -> L32
        if (r24 == null) goto L29;
        r20 = r24.booleanValue();     // Catch: Throwable -> L32
    L29:
        r14 = Result.constructor-impl(new i(r21, r23, r20));     // Catch: Throwable -> L32
        goto L40
    L25:
        r23 = null;
        goto L26
    L21:
        r21 = false;
    L32:
        th = move-exception;
        String r25 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus CRASH: " + th.getMessage() + '\n' + r25);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L36;
        r11 = th;
    L36:
        if (r11 != null) goto L38;
        r11 = new Exception(th);
    L38:
        r14 = Result.constructor-impl(ResultKt.createFailure(r11));
        goto L40
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
