package com.ss.android.lark.passport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.dpop.DPOPServiceSdk;
import com.ss.android.lark.passport.signinsdk_api.account.ResponseUser;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.OnlineOfflineService$Companion$fetchUser$3", f = "OnlineOfflineService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OnlineOfflineService$Companion$fetchUser$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends User>>, Object> {
    final /* synthetic */ String $domain;
    final /* synthetic */ Ref.ObjectRef<Integer> $httpCode;
    final /* synthetic */ Ref.ObjectRef<String> $logId;
    final /* synthetic */ String $path;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    public OnlineOfflineService$Companion$fetchUser$3(String r1, String r2, String r3, Ref.ObjectRef<String> r4, Ref.ObjectRef<Integer> r5, Continuation<? super OnlineOfflineService$Companion$fetchUser$3> r6) {
        this.$domain = r1;
        this.$path = r2;
        this.$token = r3;
        this.$logId = r4;
        this.$httpCode = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        OnlineOfflineService$Companion$fetchUser$3 r7 = new OnlineOfflineService$Companion$fetchUser$3(this.$domain, this.$path, this.$token, this.$logId, this.$httpCode, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends User>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        String r13 = this.$domain;
        String r1 = this.$path;
        String r2 = this.$token;
        Ref.ObjectRef<String> r3 = this.$logId;
        Ref.ObjectRef<Integer> r4 = this.$httpCode;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        OkHttpClient r6 = new OkHttpClient.Builder().build();     // Catch: Throwable -> L16
        Request.Builder r7 = new Request.Builder();     // Catch: Throwable -> L16
        String r14 = r13 + r1;     // Catch: Throwable -> L16
        r7.url(r14);     // Catch: Throwable -> L16
        r7.header("X-App-Id", "12");     // Catch: Throwable -> L16
        r7.header("X-Api-Version", "1.0.30");     // Catch: Throwable -> L16
        r7.header("X-Device-Info", "platform=websdk");     // Catch: Throwable -> L16
        r7.header("Authorization", r2);     // Catch: Throwable -> L16
        String r9 = null;
        if (StringsKt.startsWith$default(r2, "DPoP ", false, 2, null) == false) goto L8;
        r7.header("DPoP", new String(DPOPServiceSdk.getDPOPToken(r14, "GET"), Charsets.UTF_8));     // Catch: Throwable -> L16
    L8:
        Response r15 = r6.newCall(r7.build()).execute();     // Catch: Throwable -> L16
        ResponseBody r8 = r15.body();     // Catch: Throwable -> L16
        if (r8 == null) goto L11;
        r9 = r8.string();     // Catch: Throwable -> L16
    L11:
        r3.element = r15.header("x-tt-logid");     // Catch: Throwable -> L16
        r4.element = Boxing.boxInt(r15.code());     // Catch: Throwable -> L16
        Log.i("OnlineOfflineService", "fetchUser(" + r15.code() + "): " + r9);     // Catch: Throwable -> L16
        JSONObject r16 = JSON.parseObject(r9).getJSONObject("data");     // Catch: Throwable -> L16
        User r0 = (User) r16.getObject("user", User.class);     // Catch: Throwable -> L16
        if (r0 == null) goto L15;
        r0.mergeWithResponseUser((ResponseUser) r16.toJavaObject(ResponseUser.class));     // Catch: Throwable -> L16
        Object r17 = Result.constructor-impl(r0);     // Catch: Throwable -> L16
    L19:
        return Result.box-impl(r17);
    L15:
        throw new IllegalStateException("fetchUser missing user");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
