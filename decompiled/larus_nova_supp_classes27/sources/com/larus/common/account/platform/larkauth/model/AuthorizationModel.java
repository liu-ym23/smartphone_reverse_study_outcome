package com.larus.common.account.platform.larkauth.model;

import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.common.account.platform.larkauth.api.LarkAuthorizeApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import rx5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AuthorizationModel {
    public static final AuthorizationModel a = null;
    public static final LarkAuthorizeApi b = null;

    public AuthorizationModel() {
    }

    static {
        a = new AuthorizationModel();
        FlowHttpConnection r0 = FlowHttpConnection.a;
        b = (LarkAuthorizeApi) RetrofitUtils.createSsRetrofit(FlowHttpConnection.a(), CollectionsKt.emptyList(), a.a()).create(LarkAuthorizeApi.class);
    }

    public final Object b(Continuation<? super String> r5) {
        if ((r5 instanceof AuthorizationModel$getDomainsAll$1) == false) goto L7;
        AuthorizationModel$getDomainsAll$1 r0 = (AuthorizationModel$getDomainsAll$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L13
    L24:
        return r6;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r6);
        LarkAuthorizeApi r7 = b;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r6 = r7.getAuthList(r0);     // Catch: Throwable -> L13
        if (r6 != r2) goto L24;
        return r2;
    L13:
        th = move-exception;
        FLogger.a.e("AuthorizationModel", "getDomainsAll e=" + th.getMessage());
        return null;
    L7:
        r0 = new AuthorizationModel$getDomainsAll$1(this, r5);
        goto L8
    }

    public final Object a(Map<String, String> r5, Continuation<? super String> r6) {
        if ((r6 instanceof AuthorizationModel$getAuthToken$1) == false) goto L7;
        AuthorizationModel$getAuthToken$1 r0 = (AuthorizationModel$getAuthToken$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13
    L24:
        return r7;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        LarkAuthorizeApi r8 = b;     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r7 = r8.getAuthToken(r5, r0);     // Catch: Throwable -> L13
        if (r7 != r2) goto L24;
        return r2;
    L13:
        th = move-exception;
        FLogger.a.e("AuthorizationModel", "getAuthToken e=" + th.getMessage());
        return null;
    L7:
        r0 = new AuthorizationModel$getAuthToken$1(this, r6);
        goto L8
    }
}
