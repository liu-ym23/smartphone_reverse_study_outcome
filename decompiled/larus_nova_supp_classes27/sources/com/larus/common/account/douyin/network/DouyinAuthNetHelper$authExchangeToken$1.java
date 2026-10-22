package com.larus.common.account.douyin.network;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.larus.network.HttpConst;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.network.DouyinAuthNetHelper$authExchangeToken$1", f = "DouyinAuthNetHelper.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class DouyinAuthNetHelper$authExchangeToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DouyinAuthNetHelper.c $callback;
    final /* synthetic */ Authorization.Response $resp;
    int label;

    public DouyinAuthNetHelper$authExchangeToken$1(Authorization.Response r1, DouyinAuthNetHelper.c r2, Continuation<? super DouyinAuthNetHelper$authExchangeToken$1> r3) {
        this.$resp = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DouyinAuthNetHelper$authExchangeToken$1(this.$resp, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L18:
        y r12 = (a) r11;
        if ((r12 instanceof y) == false) goto L25;
        DouyinAuthNetHelper.a r13 = (DouyinAuthNetHelper.a) ((a) r12).b;
        if (r13 != null) goto L23;
    L40:
        r2 = false;
    L41:
        DouyinAuthNetHelper.c r14 = this.$callback;
        if (r14 == null) goto L45;
        r14.onResult(r2);
    L45:
        return Unit.INSTANCE;
    L23:
        if (r13.a() != true) goto L40;
    L25:
        String r3 = null;
        if ((r12 instanceof f) == false) goto L28;
        f r15 = (f) r12;
    L29:
        if (r15 == null) goto L31;
        AsyncThrowable r16 = r15.d;
    L32:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("authExchangeToken fails, code:");
        if (r16 == null) goto L35;
        Long r6 = Boxing.boxLong(r16.getCode());
    L36:
        r5.append(r6);
        r5.append(", msg:");
        if (r16 == null) goto L39;
        r3 = r16.getMessage();
    L39:
        r5.append(r3);
        r4.i("DouyinAuthNetHelper", r5.toString());
        goto L40
    L35:
        r6 = null;
        goto L36
    L31:
        r16 = null;
        goto L32
    L28:
        r15 = null;
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        StringBuilder r17 = new StringBuilder();
        HttpConst.a.getClass();
        r17.append(HttpConst.y);
        r17.append("/api/oauth/exchange_token?code=");
        String r7 = this.$resp.authCode;
        String r8 = "";
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r17.append(r7);
        r17.append("&state=");
        String r9 = this.$resp.state;
        if (r9 == null) goto L15;
        r8 = r9;
    L15:
        r17.append(r8);
        String r10 = r17.toString();
        this.label = 1;
        r11 = HttpExtKt.h("Basic", DouyinAuthNetHelper.a.class, r10, null, this, 248);
        if (r11 != r0) goto L18;
        return r0;
    }
}
