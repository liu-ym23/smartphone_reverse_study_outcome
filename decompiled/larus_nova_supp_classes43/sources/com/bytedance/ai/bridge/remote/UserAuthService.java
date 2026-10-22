package com.bytedance.ai.bridge.remote;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.ai.bridge.remote.model.FetchDomainPolicyResponse;
import com.bytedance.ai.bridge.remote.model.UploadModelContextRequest;
import com.bytedance.ai.bridge.remote.model.UploadModelContextResponse;
import com.bytedance.ai.utils.g;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import p4.i;
import p4.n;
import p4.o;
import p4.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UserAuthService {
    public static final UserAuthService a = null;
    public static final Retrofit b = null;
    public static final Retrofit c = null;
    public static final UserAuthApi d = null;
    public static final UserAuthApi e = null;
    public static final UserAuthApi f = null;

    public UserAuthService() {
    }

    static {
        a = new UserAuthService();
        Retrofit r0 = RetrofitUtils.getSsRetrofit("https://mini-program.doubao.com");
        b = r0;
        Retrofit r1 = RetrofitUtils.getSsRetrofit("https://api-normal.doubao.com");
        c = r1;
        d = (UserAuthApi) r0.create(UserAuthApi.class);
        e = (UserAuthApi) r1.create(UserAuthApi.class);
        f = (UserAuthApi) RetrofitUtils.getSsRetrofit("https://hello.doubao-dev.com").create(UserAuthApi.class);
    }

    public static final RemoteApiException b(Throwable r1) {
        if ((r1 instanceof RemoteApiException) == false) goto L6;
        return (RemoteApiException) r1;
    L6:
        if ((r1 instanceof IOException) == false) goto L8;
    L14:
        RemoteApiException r0 = new RemoteApiException.Network(r1);
    L16:
        return r0;
    L8:
        if ((r1 instanceof NetworkNotAvailabeException) == true) goto L14;
        String r10 = r1.getMessage();
        if (r10 != null) goto L13;
        r10 = "invalid response";
    L13:
        r0 = new RemoteApiException.InvalidResponse(r10);
        goto L16
    }

    public static p l(String r10) {
        Intrinsics.checkNotNullParameter(r10, "cardId");
        SsResponse r11 = d.getMessageInfoByCardId(new o(r10)).execute();     // Catch: Exception -> L13
        if (r11.isSuccessful() == true) goto L6;
    L11:
        g.a.e("UserAuthService", "getMessageInfoByCardId: Http Error, code = " + r11.code());     // Catch: Exception -> L13
    L17:
        return null;
    L6:
        if (r11.body() == null) goto L11;
        p r12 = (p) r11.body();     // Catch: Exception -> L13
        if (r12.d() == false) goto L10;
        return r12;
    L10:
        g.a.e("UserAuthService", "getMessageInfoByCardId: Server Error: " + r12);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        g.a.e("UserAuthService", "getMessageInfoByCardId ERROR: " + e.getMessage(), e);
        return null;
    }

    public final Object c(List<String> r10, Continuation<? super Result<p4.b>> r11) {
        if ((r11 instanceof UserAuthService$batchGetAppletMetaInfo$1) == false) goto L7;
        UserAuthService$batchGetAppletMetaInfo$1 r0 = (UserAuthService$batchGetAppletMetaInfo$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$batchGetAppletMetaInfo$2 r16 = new UserAuthService$batchGetAppletMetaInfo$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$batchGetAppletMetaInfo$1(this, r11);
        goto L8
    }

    public final Object g(String r10, Continuation<? super Result<FetchDomainPolicyResponse.Data>> r11) {
        if ((r11 instanceof UserAuthService$fetchDomainPolicy$1) == false) goto L7;
        UserAuthService$fetchDomainPolicy$1 r0 = (UserAuthService$fetchDomainPolicy$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$fetchDomainPolicy$2 r16 = new UserAuthService$fetchDomainPolicy$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$fetchDomainPolicy$1(this, r11);
        goto L8
    }

    public final Object h(String r10, Continuation<? super Result<AppMeta>> r11) {
        if ((r11 instanceof UserAuthService$getAppletMetaInfo$1) == false) goto L7;
        UserAuthService$getAppletMetaInfo$1 r0 = (UserAuthService$getAppletMetaInfo$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$getAppletMetaInfo$2 r16 = new UserAuthService$getAppletMetaInfo$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$getAppletMetaInfo$1(this, r11);
        goto L8
    }

    public final Object i(String r10, Continuation<? super Result<n>> r11) {
        if ((r11 instanceof UserAuthService$getAwemeCommonLoginInfo$1) == false) goto L7;
        UserAuthService$getAwemeCommonLoginInfo$1 r0 = (UserAuthService$getAwemeCommonLoginInfo$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$getAwemeCommonLoginInfo$2 r16 = new UserAuthService$getAwemeCommonLoginInfo$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$getAwemeCommonLoginInfo$1(this, r11);
        goto L8
    }

    public final Object m(String r10, Continuation<? super Result<String>> r11) {
        if ((r11 instanceof UserAuthService$getPhoneCode$1) == false) goto L7;
        UserAuthService$getPhoneCode$1 r0 = (UserAuthService$getPhoneCode$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$getPhoneCode$2 r16 = new UserAuthService$getPhoneCode$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$getPhoneCode$1(this, r11);
        goto L8
    }

    public final Object n(String r10, Continuation<? super Result<String>> r11) {
        if ((r11 instanceof UserAuthService$getPhoneMask$1) == false) goto L7;
        UserAuthService$getPhoneMask$1 r0 = (UserAuthService$getPhoneMask$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$getPhoneMask$2 r16 = new UserAuthService$getPhoneMask$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$getPhoneMask$1(this, r11);
        goto L8
    }

    public final Object s(UploadModelContextRequest r10, Continuation<? super Result<UploadModelContextResponse>> r11) {
        if ((r11 instanceof UserAuthService$uploadContext$1) == false) goto L7;
        UserAuthService$uploadContext$1 r0 = (UserAuthService$uploadContext$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        UserAuthService$uploadContext$2 r16 = new UserAuthService$uploadContext$2(r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r15, r16, r0);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new UserAuthService$uploadContext$1(this, r11);
        goto L8
    }

    public static /* synthetic */ Object p(List r10, List r11, Continuation r12) {
        return a.o(r10, "zh_CN", r11, r12);
    }

    public final Object a(String r10, String r11, Continuation<? super Result<Boolean>> r12) {
        if ((r12 instanceof UserAuthService$acceptPrivacy$1) == false) goto L7;
        UserAuthService$acceptPrivacy$1 r0 = (UserAuthService$acceptPrivacy$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((Result) r13).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        UserAuthService$acceptPrivacy$2 r17 = new UserAuthService$acceptPrivacy$2(r10, r11, null);
        r0.label = 1;
        r13 = BuildersKt.withContext(r16, r17, r0);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r0 = new UserAuthService$acceptPrivacy$1(this, r12);
        goto L8
    }

    public final Object d(String r10, String r11, Continuation<? super Result<Boolean>> r12) {
        if ((r12 instanceof UserAuthService$checkPrivacy$1) == false) goto L7;
        UserAuthService$checkPrivacy$1 r0 = (UserAuthService$checkPrivacy$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((Result) r13).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        UserAuthService$checkPrivacy$2 r17 = new UserAuthService$checkPrivacy$2(r10, r11, null);
        r0.label = 1;
        r13 = BuildersKt.withContext(r16, r17, r0);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r0 = new UserAuthService$checkPrivacy$1(this, r12);
        goto L8
    }

    public static /* synthetic */ Object r(String r10, String r11, Integer r12, Continuation r13) {
        return a.q(r10, r11, r12, null, r13);
    }

    public final Object e(String r10, String r11, CheckType r12, Continuation<? super Result<i>> r13) {
        if ((r13 instanceof UserAuthService$checkPrivacyOrLoginStatus$1) == false) goto L7;
        UserAuthService$checkPrivacyOrLoginStatus$1 r0 = (UserAuthService$checkPrivacyOrLoginStatus$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L18:
        return ((Result) r14).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        CoroutineDispatcher r17 = Dispatchers.getIO();
        UserAuthService$checkPrivacyOrLoginStatus$2 r18 = new UserAuthService$checkPrivacyOrLoginStatus$2(r10, r11, r12, null);
        r0.label = 1;
        r14 = BuildersKt.withContext(r17, r18, r0);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r0 = new UserAuthService$checkPrivacyOrLoginStatus$1(this, r13);
        goto L8
    }

    public final Object o(List<String> r10, String r11, List<String> r12, Continuation<? super Result<? extends List<AppletPermissionDetail>>> r13) {
        if ((r13 instanceof UserAuthService$getUserAppsPermissionDetail$1) == false) goto L7;
        UserAuthService$getUserAppsPermissionDetail$1 r0 = (UserAuthService$getUserAppsPermissionDetail$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L18:
        return ((Result) r14).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        CoroutineDispatcher r17 = Dispatchers.getIO();
        UserAuthService$getUserAppsPermissionDetail$2 r18 = new UserAuthService$getUserAppsPermissionDetail$2(r10, r11, r12, null);
        r0.label = 1;
        r14 = BuildersKt.withContext(r17, r18, r0);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r0 = new UserAuthService$getUserAppsPermissionDetail$1(this, r13);
        goto L8
    }

    public static /* synthetic */ Object k(String r10, String r11, String r12, Continuation r13, int r14) {
        UserAuthService r0 = a;
        if ((r14 & 2) == 0) goto L5;
        r11 = "user_info";
    L5:
        String r15 = r11;
        if ((r14 & 4) == 0) goto L8;
        String r16 = "482431";
    L10:
        if ((r14 & 8) == 0) goto L12;
        String r17 = "jsb";
    L14:
        if ((r14 & 16) == 0) goto L16;
        String r18 = null;
    L18:
        return r0.j(r10, r15, r16, r17, r18, r13);
    L16:
        r18 = r12;
        goto L18
    L12:
        r17 = null;
        goto L14
    L8:
        r16 = null;
        goto L10
    }

    public final Object f(String r11, String r12, String r13, String r14, Continuation<? super Result<Boolean>> r15) {
        if ((r15 instanceof UserAuthService$exchangeCode$1) == false) goto L7;
        UserAuthService$exchangeCode$1 r0 = (UserAuthService$exchangeCode$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r0.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L18:
        return ((Result) r16).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        UserAuthService$exchangeCode$2 r19 = new UserAuthService$exchangeCode$2(r13, r11, r12, r14, null);
        r0.label = 1;
        r16 = BuildersKt.withContext(r18, r19, r0);
        if (r16 != r10) goto L18;
        return r10;
    L7:
        r0 = new UserAuthService$exchangeCode$1(this, r15);
        goto L8
    }

    public final Object q(String r11, String r12, Integer r13, List<String> r14, Continuation<? super Result<Boolean>> r15) {
        if ((r15 instanceof UserAuthService$postUserAppsPermission$1) == false) goto L7;
        UserAuthService$postUserAppsPermission$1 r0 = (UserAuthService$postUserAppsPermission$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r0.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L18:
        return ((Result) r16).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        UserAuthService$postUserAppsPermission$2 r19 = new UserAuthService$postUserAppsPermission$2(r12, r13, r11, r14, null);
        r0.label = 1;
        r16 = BuildersKt.withContext(r18, r19, r0);
        if (r16 != r10) goto L18;
        return r10;
    L7:
        r0 = new UserAuthService$postUserAppsPermission$1(this, r15);
        goto L8
    }

    public final Object j(String r14, String r15, String r16, String r17, String r18, Continuation<? super Result<String>> r19) {
        if ((r19 instanceof UserAuthService$getLoginCode$1) == false) goto L7;
        UserAuthService$getLoginCode$1 r1 = (UserAuthService$getLoginCode$1) r19;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L18:
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        UserAuthService$getLoginCode$2 r20 = new UserAuthService$getLoginCode$2(r14, r16, r15, r17, r18, null);
        r1.label = 1;
        r0 = BuildersKt.withContext(r13, r20, r1);
        if (r0 != r11) goto L18;
        return r11;
    L7:
        r1 = new UserAuthService$getLoginCode$1(this, r19);
        goto L8
    }
}
