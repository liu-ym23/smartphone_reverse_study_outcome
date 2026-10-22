package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusRequest;
import com.bytedance.ai.bridge.remote.model.CheckPrivacyOrLoginStatusResponse;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.ai.bridge.remote.model.PrivacyData;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$checkPrivacy$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$checkPrivacy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $versionTag;
    int label;

    public UserAuthService$checkPrivacy$2(String r1, String r10, Continuation<? super UserAuthService$checkPrivacy$2> r11) {
        this.$appKey = r1;
        this.$versionTag = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$checkPrivacy$2(this.$appKey, this.$versionTag, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r10);
        SsResponse r11 = ((UserAuthApi) UserAuthService.b.create(UserAuthApi.class)).checkPrivacyOrLoginStatus(new CheckPrivacyOrLoginStatusRequest(this.$appKey, this.$versionTag, CheckType.CHECK_TYPE_PRIVACY)).execute();     // Catch: Throwable -> L28
        if (r11.isSuccessful() == true) goto L8;
    L26:
        String r12 = "Http Error: " + r11.code();     // Catch: Throwable -> L28
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus: Http Error: " + r12);     // Catch: Throwable -> L28
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
        Object r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r12)));     // Catch: Throwable -> L28
    L37:
        return Result.box-impl(r13);
    L8:
        if (r11.body() == null) goto L26;
        CheckPrivacyOrLoginStatusResponse r14 = (CheckPrivacyOrLoginStatusResponse) r11.body();     // Catch: Throwable -> L28
        if (r14.getErrCode() == null) goto L18;
        Integer r15 = r14.getErrCode();     // Catch: Throwable -> L28
        if (r15 != null) goto L15;
    L17:
        String r16 = "Biz Error: " + r14.getErrMsg() + " (" + r14.getErrCode() + ')';     // Catch: Throwable -> L28
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus: Biz Error: " + r16);     // Catch: Throwable -> L28
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L28
        r13 = Result.constructor-impl(ResultKt.createFailure(new Exception(r16)));     // Catch: Throwable -> L28
        goto L37
    L15:
        if (r15.intValue() != 0) goto L17;
    L18:
        PrivacyData r18 = r14.getData();     // Catch: Throwable -> L28
        boolean r19 = false;
        if (r18 == null) goto L21;
        boolean r20 = r18.getPrivacyAgreed();     // Catch: Throwable -> L28
    L22:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L28
        if (r20 == false) goto L25;
        r19 = true;
    L25:
        r13 = Result.constructor-impl(Boxing.boxBoolean(r19));     // Catch: Throwable -> L28
        goto L37
    L21:
        r20 = false;
    L28:
        th = move-exception;
        String r22 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "checkPrivacyOrLoginStatus CRASH: " + th.getMessage() + '\n' + r22);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L32;
        Exception r23 = th;
    L33:
        if (r23 != null) goto L35;
        r23 = new Exception(th);
    L35:
        r13 = Result.constructor-impl(ResultKt.createFailure(r23));
        goto L37
    L32:
        r23 = null;
        goto L33
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
