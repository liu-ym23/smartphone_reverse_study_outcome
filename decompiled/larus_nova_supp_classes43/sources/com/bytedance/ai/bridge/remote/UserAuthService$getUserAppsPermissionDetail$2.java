package com.bytedance.ai.bridge.remote;

import android.util.Log;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.AppletPermissionQuery;
import com.bytedance.ai.bridge.remote.model.GetUserAppsPermissionDetailRequest;
import com.bytedance.ai.bridge.remote.model.GetUserAppsPermissionDetailResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$getUserAppsPermissionDetail$2", f = "UserAuthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$getUserAppsPermissionDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends AppletPermissionDetail>>>, Object> {
    final /* synthetic */ List<String> $appletIds;
    final /* synthetic */ String $language;
    final /* synthetic */ List<String> $scopes;
    int label;

    public UserAuthService$getUserAppsPermissionDetail$2(List<String> r1, String r10, List<String> r11, Continuation<? super UserAuthService$getUserAppsPermissionDetail$2> r12) {
        this.$appletIds = r1;
        this.$language = r10;
        this.$scopes = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$getUserAppsPermissionDetail$2(this.$appletIds, this.$language, this.$scopes, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<AppletPermissionDetail>>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r10);
        if (this.$appletIds.isEmpty() == false) goto L38;
        Result.Companion r11 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: applet_ids is empty (1001)"))));
    L38:
        List<String> r1 = this.$appletIds;     // Catch: Throwable -> L26
        List<String> r12 = this.$scopes;     // Catch: Throwable -> L26
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L26
        Iterator<T> r14 = r1.iterator();     // Catch: Throwable -> L26
    L11:
        if (r14.hasNext() == false) goto L13;
        r13.add(new AppletPermissionQuery((String) r14.next(), r12));     // Catch: Throwable -> L26
        goto L11
    L13:
        SsResponse r15 = ((UserAuthApi) UserAuthService.c.create(UserAuthApi.class)).getUserAppsPermissionDetail(new GetUserAppsPermissionDetailRequest(r13, this.$language)).execute();     // Catch: Throwable -> L26
        if (r15.isSuccessful() == true) goto L16;
    L24:
        String r16 = "Http Error: " + r15.code();     // Catch: Throwable -> L26
        g.a.e("UserAuthService", "getUserAppsPermissionDetail: Http Error: " + r16);     // Catch: Throwable -> L26
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L26
        Object r18 = Result.constructor-impl(ResultKt.createFailure(new Exception(r16)));     // Catch: Throwable -> L26
    L35:
        return Result.box-impl(r18);
    L16:
        if (r15.body() == null) goto L24;
        GetUserAppsPermissionDetailResponse r19 = (GetUserAppsPermissionDetailResponse) r15.body();     // Catch: Throwable -> L26
        if (r19.getErrCode() != 0) goto L23;
        List<AppletPermissionDetail> r20 = r19.getAppletsScopeManageInfo();     // Catch: Throwable -> L26
        if (r20 != null) goto L22;
        r20 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
    L22:
        r18 = Result.constructor-impl(r20);     // Catch: Throwable -> L26
        goto L35
    L23:
        String r21 = "Biz Error: " + r19.getErrMsg() + " (" + r19.getErrCode() + ')';     // Catch: Throwable -> L26
        g.a.e("UserAuthService", "getUserAppsPermissionDetail: Biz Error: " + r21);     // Catch: Throwable -> L26
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L26
        r18 = Result.constructor-impl(ResultKt.createFailure(new Exception(r21)));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        String r23 = Log.getStackTraceString(th);
        g.a.e("UserAuthService", "getUserAppsPermissionDetail CRASH: " + th.getMessage() + '\n' + r23);
        Result.Companion r24 = Result.Companion;
        if ((th instanceof Exception) == false) goto L30;
        Exception r25 = th;
    L31:
        if (r25 != null) goto L33;
        r25 = new Exception(th);
    L33:
        r18 = Result.constructor-impl(ResultKt.createFailure(r25));
        goto L35
    L30:
        r25 = null;
        goto L31
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
