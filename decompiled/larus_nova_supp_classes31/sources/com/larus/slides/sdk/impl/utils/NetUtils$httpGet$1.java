package com.larus.slides.sdk.impl.utils;

import android.webkit.CookieManager;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.net.FlowDocNetApi;
import com.larus.office.base.net.FlowDocNetResponse;
import com.larus.office.base.net.e;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.chameleon.idependency.INetCallback;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.sdk.impl.utils.NetUtils$httpGet$1", f = "NetUtils.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
final class NetUtils$httpGet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ INetCallback $callback;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $url;
    int label;

    public NetUtils$httpGet$1(Map<String, String> r1, String r2, INetCallback r3, Continuation<? super NetUtils$httpGet$1> r4) {
        this.$headers = r1;
        this.$url = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NetUtils$httpGet$1(this.$headers, this.$url, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        String r6 = "";
        if (r5 == 0) goto L9;
        if (r5 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L36
    L25:
        FlowDocNetResponse r12 = (FlowDocNetResponse) r11;     // Catch: Exception -> L36
        if (r12 != null) goto L29;
        this.$callback.onFailure(-1, "response is null");     // Catch: Exception -> L36
    L43:
        return Unit.INSTANCE;
    L29:
        if (r12.getCode() != 0) goto L31;
        this.$callback.onSuccess(200, JsonUtils.INSTANCE.toJsonString(r12));     // Catch: Exception -> L36
        goto L43
    L31:
        INetCallback r0 = this.$callback;     // Catch: Exception -> L36
        int r2 = (int) r12.getCode();     // Catch: Exception -> L36
        String r1 = r12.getMsg();     // Catch: Exception -> L36
        if (r1 != null) goto L34;
        r1 = r12.getMessage();     // Catch: Exception -> L36
    L34:
        r0.onFailure(r2, r1);     // Catch: Exception -> L36
        goto L43
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Exception -> L36
        Map<String, String> r7 = this.$headers;     // Catch: Exception -> L36
        if (r7 == null) goto L13;
        r13.putAll(r7);     // Catch: Exception -> L36
    L13:
        FLogger r8 = FLogger.a;     // Catch: Exception -> L36
        r8.i("NetUtils", "User-agent: " + System.getProperty("http.agent"));     // Catch: Exception -> L36
        int r3 = a.a;     // Catch: Exception -> L36
        HashMap r9 = (HashMap) a.a(CookieManager.getInstance().getCookie(this.$url));     // Catch: Exception -> L36
        if (o0.d((String) r9.get("_csrf_token")) == false) goto L16;
        r13.put("_csrf_token", String.valueOf(r9.get("_csrf_token")));     // Catch: Exception -> L36
    L16:
        String r10 = (String) r13.get("_csrf_token");     // Catch: Exception -> L36
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        r13.put("x-csrftoken", r10);     // Catch: Exception -> L36
        String r14 = c.a();     // Catch: Exception -> L36
        r13.put("User-agent", r14);     // Catch: Exception -> L36
        r8.i("NetUtils", "httpGet: " + this.$url + ", Current user agent: " + r14);     // Catch: Exception -> L36
        if (AppHost.a.isDebug() == false) goto L22;
        r13.put("env", "Pre_release");     // Catch: Exception -> L36
    L22:
        Lazy r15 = e.a;     // Catch: Exception -> L36
        String r16 = this.$url;     // Catch: Exception -> L36
        this.label = 1;     // Catch: Exception -> L36
        r11 = ((FlowDocNetApi) e.a.getValue()).httpGet(r16, r13, this);     // Catch: Exception -> L36
        if (r11 != r4) goto L25;
        return r4;
    L36:
        e = move-exception;
        INetCallback r17 = this.$callback;
        String r18 = e.getMessage();
        if (r18 == null) goto L41;
        r6 = r18;
    L41:
        r17.onFailure(-1, r6);
        goto L43
    }
}
