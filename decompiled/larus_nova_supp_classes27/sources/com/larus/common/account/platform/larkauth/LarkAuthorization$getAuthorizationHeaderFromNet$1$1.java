package com.larus.common.account.platform.larkauth;

import android.os.Build;
import com.larus.applog.api.IApplog;
import com.larus.common.account.platform.larkauth.model.b;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.o0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.LarkAuthorization$getAuthorizationHeaderFromNet$1$1", f = "LarkAuthorization.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LarkAuthorization$getAuthorizationHeaderFromNet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $context;
    final /* synthetic */ Map<String, String> $result;
    int label;
    final /* synthetic */ LarkAuthorization this$0;

    public LarkAuthorization$getAuthorizationHeaderFromNet$1$1(LarkAuthorization r1, b r2, Map<String, String> r3, Continuation<? super LarkAuthorization$getAuthorizationHeaderFromNet$1$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$result = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LarkAuthorization$getAuthorizationHeaderFromNet$1$1(this.this$0, this.$context, this.$result, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r9);
        AuthorizationFactory.a.getClass();
        String r1 = null;
        Object r2 = null;
        r1 = null;
        if (Build.VERSION.SDK_INT < 24) goto L20;
        com.bytedance.dpop.c r10 = AuthorizationFactory.i;
        if (r10 != null) goto L12;
        int r11 = com.bytedance.dpop.c.e;
        Object r12 = com.bytedance.dpop.c.a.a(AuthorizationFactory.d().d, new ml4.c(AuthorizationFactory.d().e));
        if (Result.isFailure-impl(r12) == false) goto L11;
        r12 = null;
    L11:
        r10 = (com.bytedance.dpop.c) r12;
    L12:
        AuthorizationFactory.i = r10;
        if (r10 == null) goto L20;
        Object r13 = r10.a().a();
        if (Result.isFailure-impl(r13) == true) goto L18;
        r2 = r13;
    L18:
        r1 = (String) r2;
    L20:
        if (o0.d(r1) == false) goto L26;
        ConcurrentHashMap r14 = AuthorizationFactory.h;
        if (r1 != null) goto L24;
        String r5 = "";
    L25:
        r14.put(r5, Long.valueOf(System.currentTimeMillis()));
        IApplog.Companion r15 = IApplog.a;
        JSONObject r6 = new JSONObject();
        r6.put(FlowDoraConnectReason.SUCCESS, 1);
        Unit r3 = Unit.INSTANCE;
        r15.reportEvent("lark_auth_dpop_result", r6);
    L27:
        this.$result.putAll(com.larus.common.account.platform.larkauth.util.c.a(this.this$0.h(this.$context, true), r1, false));
        return Unit.INSTANCE;
    L24:
        r5 = r1;
        goto L25
    L26:
        IApplog.Companion r16 = IApplog.a;
        JSONObject r7 = new JSONObject();
        r7.put(FlowDoraConnectReason.SUCCESS, 0);
        Unit r4 = Unit.INSTANCE;
        r16.reportEvent("lark_auth_dpop_result", r7);
        goto L27
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
