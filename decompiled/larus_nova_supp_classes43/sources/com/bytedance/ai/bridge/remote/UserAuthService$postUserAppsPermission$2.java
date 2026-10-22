package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.PostUserAppsPermissionRequest;
import com.bytedance.ai.bridge.remote.model.PostUserAppsPermissionResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import java.util.List;
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
import p4.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$postUserAppsPermission$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$postUserAppsPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ Integer $grantStatus;
    final /* synthetic */ String $scopeName;
    final /* synthetic */ List<String> $usingScopeInfos;
    int label;

    public UserAuthService$postUserAppsPermission$2(String r1, Integer r10, String r11, List<String> r12, Continuation<? super UserAuthService$postUserAppsPermission$2> r13) {
        this.$scopeName = r1;
        this.$grantStatus = r10;
        this.$appletId = r11;
        this.$usingScopeInfos = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$postUserAppsPermission$2(this.$scopeName, this.$grantStatus, this.$appletId, this.$usingScopeInfos, r11);
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
        Exception r11 = null;
        String r12 = this.$scopeName;     // Catch: Throwable -> L27
        if (r12 == null) goto L10;
        Integer r13 = this.$grantStatus;     // Catch: Throwable -> L27
        if (r13 == null) goto L10;
        q r14 = new q(r12, r13);     // Catch: Throwable -> L27
    L11:
        SsResponse r15 = ((UserAuthApi) UserAuthService.c.create(UserAuthApi.class)).postUserAppsPermission(new PostUserAppsPermissionRequest(this.$appletId, r14, this.$usingScopeInfos)).execute();     // Catch: Throwable -> L27
        if (r15.isSuccessful() == true) goto L14;
    L25:
        String r1 = "Http Error: " + r15.code();     // Catch: Throwable -> L27
        g.a.e("UserAuthService", "postUserAppsPermission: Http Error: " + r1);     // Catch: Throwable -> L27
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L27
        Object r17 = Result.constructor-impl(ResultKt.createFailure(new Exception(r1)));     // Catch: Throwable -> L27
    L35:
        return Result.box-impl(r17);
    L14:
        if (r15.body() == null) goto L25;
        PostUserAppsPermissionResponse r18 = (PostUserAppsPermissionResponse) r15.body();     // Catch: Throwable -> L27
        if (r18.getErrCode() == null) goto L24;
        Integer r19 = r18.getErrCode();     // Catch: Throwable -> L27
        if (r19 != null) goto L21;
    L23:
        String r20 = "Biz Error: " + r18.getErrMsg() + " (" + r18.getErrCode() + ')';     // Catch: Throwable -> L27
        g.a.e("UserAuthService", "postUserAppsPermission: Biz Error: " + r20);     // Catch: Throwable -> L27
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L27
        r17 = Result.constructor-impl(ResultKt.createFailure(new Exception(r20)));     // Catch: Throwable -> L27
        goto L35
    L21:
        if (r19.intValue() != 0) goto L23;
    L24:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L27
        r17 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L27
    L10:
        r14 = null;
    L27:
        th = move-exception;
        String r23 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "postUserAppsPermission CRASH: " + th.getMessage() + '\n' + r23);
        Result.Companion r0 = Result.Companion;
        if ((th instanceof Exception) == false) goto L31;
        r11 = th;
    L31:
        if (r11 != null) goto L33;
        r11 = new Exception(th);
    L33:
        r17 = Result.constructor-impl(ResultKt.createFailure(r11));
        goto L35
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
