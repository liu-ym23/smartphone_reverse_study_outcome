package com.bytedance.ai.bridge.method.net;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.mt.protector.impl.UriProtector;
import d3.a0;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001$\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014H\u0002J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001b\u0010#\u001a\u00020$2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010,¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/method/net/RequestMethod;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestResultModel;", "appendGetDataToUrl", "", com.bytedance.android.ec.core.event.a.KEY_URL, "rawData", "", "toGetQueryString", "data", "", "Lorg/json/JSONObject;", "getQueryValueString", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "appendQueryString", "queryString", "normalizeRequestData", "contentType", "containsCustomizedCookie", "", "headers", "toJsonString", "toQueryString", "encodeURIComponent", "maskUrl", "createResponseCallback", "com/bytedance/ai/bridge/method/net/RequestMethod$createResponseCallback$1", "(Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/RequestMethod$createResponseCallback$1;", "mapRequestErrNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "errorCode", "", "throwable", "", "(Ljava/lang/Integer;Ljava/lang/Throwable;)Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestMethod extends AbsRequestMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.RequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.RequestMethod$handle$1", f = "RequestMethod.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsRequestMethodIDL.b> $callback;
        final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType $method;
        final /* synthetic */ AbsRequestMethodIDL.a $params;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ RequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.RequestMethod$handle$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[AbsAppletRequestMethodIDL.RequestMethodType.values().length];
                r0[AbsAppletRequestMethodIDL.RequestMethodType.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[AbsAppletRequestMethodIDL.RequestMethodType.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[AbsAppletRequestMethodIDL.RequestMethodType.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[AbsAppletRequestMethodIDL.RequestMethodType.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public AnonymousClass1(String r1, String r10, f3.h<AbsRequestMethodIDL.b> r11, AbsRequestMethodIDL.a r12, RequestMethod r13, AbsAppletRequestMethodIDL.RequestMethodType r14, Continuation<? super AnonymousClass1> r15) {
            this.$appletId = r1;
            this.$url = r10;
            this.$callback = r11;
            this.$params = r12;
            this.this$0 = r13;
            this.$method = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.$url, this.$callback, this.$params, this.this$0, this.$method, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r25) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            boolean r11 = true;
            if (r10 == 0) goto L8;
            if (r10 != 1) goto L7;
            ResultKt.throwOnFailure(r25);
            Object r12 = r25;
        L11:
            com.bytedance.ai.applet.domain.e r13 = (com.bytedance.ai.applet.domain.e) r12;
            if (r13.a == true) goto L15;
            com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
            StringBuilder r15 = new StringBuilder("call failed, errNo=");
            f3.a r16 = f3.a.l;
            r15.append(r16.a);
            r15.append(", msg=");
            r15.append(r13.b);
            r14.e("AISDK_JSB_RequestMethod", r15.toString());
            f3.h.a.a(this.$callback, r13.b, r16, null, 10);
            return Unit.INSTANCE;
        L15:
            b4.e r17 = b4.e.a;
            Map<String, Object> r18 = this.$params.getHeader();
            r17.getClass();
            Map r19 = b4.e.c(r18);
            r19.put("x-metasec-bypass-ttnet-features", "1");
            if (r19.containsKey("Content-Type") == false) goto L18;
        L20:
            IHostNetworkDepend r20 = r4.a.c;
            if (r20 != null) goto L23;
            r20 = new b4.a();
        L23:
            RequestMethod r21 = this.this$0;
            f3.h<AbsRequestMethodIDL.b> r22 = this.$callback;
            int r110 = RequestMethod.b;
            r21.getClass();
            j r111 = new j(r22, r21);
            LinkedHashMap r23 = (LinkedHashMap) r19;
            String r24 = (String) r23.get("Content-Type");
            if (r24 != null) goto L28;
            r24 = (String) r23.get("content-type");
            if (r24 != null) goto L28;
            r24 = "application/json";
        L28:
            final RequestMethod r26 = this.this$0;
            Object r27 = this.$params.getData();
            r26.getClass();
            if (r27 != null) goto L32;
            r27 = null;
        L79:
            this.this$0.getClass();
            if (r19.isEmpty() == true) goto L93;
            Iterator r28 = r23.entrySet().iterator();
        L84:
            if (r28.hasNext() == false) goto L93;
            Map.Entry r29 = (Map.Entry) r28.next();
            String r112 = (String) r29.getKey();
            String r30 = (String) r29.getValue();
            if (StringsKt.equals(r112, "cookie", true) == true) goto L88;
        L90:
            boolean r31 = false;
        L91:
            if (r31 == false) goto L84;
            boolean r113 = true;
        L94:
            int r32 = a.a[this.$method.ordinal()];
            if (r32 == 1) goto L105;
            if (r32 != 2) goto L98;
            b4.e.f(b4.e.a, this.$url, r19, r24, r27, r111, this.$params.getDataType(), r20, false, r113);
        L152:
            return Unit.INSTANCE;
        L98:
            if (r32 != 3) goto L100;
            b4.e.g(b4.e.a, this.$url, r19, r24, r27, r111, this.$params.getDataType(), r20, false, r113);
            goto L152
        L100:
            if (r32 != 4) goto L152;
            b4.e r33 = b4.e.a;
            String r34 = this.$url;
            RequestMethod r35 = this.this$0;
            f3.h<AbsRequestMethodIDL.b> r36 = this.$callback;
            r35.getClass();
            b4.e.b(r33, r34, r19, new j(r36, r35), this.$params.getDataType(), r20, false, r113);
            goto L152
        L105:
            final RequestMethod r37 = this.this$0;
            String r38 = this.$url;
            Object r39 = this.$params.getData();
            r37.getClass();
            if (r39 != null) goto L108;
        L149:
            String r40 = r38;
        L150:
            b4.e.d(b4.e.a, r40, r19, r111, this.$params.getDataType(), r20, false, r113);
            goto L152
        L108:
            if ((r39 instanceof byte[]) == true) goto L149;
            if ((r39 instanceof Map) == false) goto L120;
            ArrayList r114 = new ArrayList();
            Iterator r41 = ((Map) r39).entrySet().iterator();
        L114:
            if (r41.hasNext() == false) goto L118;
            Map.Entry r42 = (Map.Entry) r41.next();
            Object r115 = r42.getKey();
            Object r43 = r42.getValue();
            if (r115 == null) goto L114;
            r114.add(TuplesKt.to(r115.toString(), RequestMethod.c(r43)));
            goto L114
        L118:
            String r44 = CollectionsKt.joinToString$default(r114, "&", null, null, 0, null, new h(r37), 30, null);
        L126:
            String r45 = StringsKt.trim(r44).toString();
        L127:
            String r46 = "?";
            if (StringsKt.startsWith$default(r45, "?", false, 2, null) == true) goto L148;
            if (StringsKt.startsWith$default(r45, "&", false, 2, null) == true) goto L148;
            if (r45.length() == 0) goto L136;
            r11 = false;
        L136:
            if (r11 == true) goto L149;
            if (StringsKt.endsWith$default(r38, "?", false, 2, null) == false) goto L141;
        L146:
            r46 = "";
        L147:
            r40 = r38 + r46 + r45;
            goto L150
        L141:
            if (StringsKt.endsWith$default(r38, "&", false, 2, null) == true) goto L146;
            if (StringsKt.contains$default(r38, "?", false, 2, null) == false) goto L147;
            r46 = "&";
        L148:
            r45 = StringsKt.drop(r45, 1);
            goto L127
        L120:
            if ((r39 instanceof JSONObject) == false) goto L149;
            JSONObject r47 = (JSONObject) r39;
            ArrayList r116 = new ArrayList();
            Iterator<String> r48 = r47.keys();
        L123:
            if (r48.hasNext() == false) goto L125;
            String r117 = r48.next();
            r116.add(TuplesKt.to(r117, RequestMethod.c(r47.opt(r117))));
            goto L123
        L125:
            r44 = CollectionsKt.joinToString$default(r116, "&", null, null, 0, null, new i(r37), 30, null);
            goto L126
        L88:
            if ((!StringsKt.isBlank(r30)) == false) goto L90;
            r31 = true;
        L93:
            r113 = false;
            goto L94
        L32:
            if ((r27 instanceof String) == true) goto L79;
            if ((r27 instanceof byte[]) == true) goto L79;
            String r118 = StringsKt.trim(StringsKt.substringBefore$default(r24, ";", null, 2, null)).toString().toLowerCase(Locale.ROOT);
            if (Intrinsics.areEqual(r118, "application/x-www-form-urlencoded") == false) goto L65;
            ArrayList r119 = new ArrayList();
            if ((r27 instanceof Map) == false) goto L52;
            Iterator r49 = ((Map) r27).entrySet().iterator();
        L42:
            if (r49.hasNext() == false) goto L62;
            Map.Entry r50 = (Map.Entry) r49.next();
            Object r120 = r50.getKey();
            Object r51 = r50.getValue();
            if (r120 == null) goto L42;
            String r121 = r120.toString();
            if (r51 == null) goto L49;
            String r52 = r51.toString();
            if (r52 == null) goto L49;
        L50:
            r119.add(TuplesKt.to(r121, r52));
        L49:
            r52 = "null";
        L62:
            String r53 = CollectionsKt.joinToString$default(r119, "&", null, null, 0, null, new g(r26), 30, null);
        L78:
            r27 = r53;
            goto L79
        L52:
            if ((r27 instanceof JSONObject) == false) goto L63;
            JSONObject r54 = (JSONObject) r27;
            Iterator<String> r55 = r54.keys();
        L55:
            if (r55.hasNext() == false) goto L62;
            String r122 = r55.next();
            Object r123 = r54.opt(r122);
            if (r123 == null) goto L60;
            String r124 = r123.toString();
            if (r124 == null) goto L60;
        L61:
            r119.add(TuplesKt.to(r122, r124));
        L60:
            r124 = "null";
            goto L61
        L63:
            r53 = r27.toString();
            goto L78
        L65:
            if (Intrinsics.areEqual(r118, "application/json") == false) goto L68;
            r53 = RequestMethod.d(r27);
            goto L78
        L68:
            if ((r27 instanceof Map) == false) goto L70;
        L77:
            r53 = RequestMethod.d(r27);
            goto L78
        L70:
            if ((r27 instanceof JSONObject) == true) goto L77;
            if ((r27 instanceof List) == true) goto L77;
            if ((r27 instanceof JSONArray) == true) goto L77;
            r53 = r27.toString();
            goto L78
        L18:
            if (r19.containsKey("content-type") == true) goto L20;
            r19.put("Content-Type", "application/json");
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r25);
            AppletDomainPolicyManager r56 = AppletDomainPolicyManager.a;
            String r57 = this.$appletId;
            String r58 = this.$url;
            this.label = 1;
            r12 = r56.d(r57, r58, this);
            if (r12 != r1) goto L11;
            return r1;
        }
    }

    static {
    }

    public RequestMethod() {
    }

    public static String b(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(URLEncoder.encode(r18, StandardCharsets.UTF_8.name()), "+", "%20", false, 4, null), "%21", "!", false, 4, null), "%27", "'", false, 4, null), "%28", "(", false, 4, null), "%29", ")", false, 4, null), "%7E", "~", false, 4, null);
    }

    public static String c(Object r1) {
        if (r1 != null) goto L4;
        return "null";
    L4:
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L7;
        return "null";
    L7:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        if ((r1 instanceof Number) == true) goto L31;
        if ((r1 instanceof Boolean) == true) goto L31;
        if ((r1 instanceof JSONObject) == false) goto L18;
        return ((JSONObject) r1).toString();
    L18:
        if ((r1 instanceof JSONArray) == false) goto L21;
        return ((JSONArray) r1).toString();
    L21:
        if ((r1 instanceof Map) == false) goto L24;
        return new JSONObject((Map) r1).toString();
    L24:
        if ((r1 instanceof List) == false) goto L27;
        return new JSONArray((Collection) r1).toString();
    L27:
        if ((r1 instanceof Object[]) == false) goto L40;
        return new JSONArray(ArraysKt.toList((Object[]) r1)).toString();
    L40:
        return r1.toString();
    L31:
        return r1.toString();
    }

    public static String d(Object r1) {
        if ((r1 instanceof JSONObject) == false) goto L6;
        return ((JSONObject) r1).toString();
    L6:
        if ((r1 instanceof JSONArray) == false) goto L9;
        return ((JSONArray) r1).toString();
    L9:
        if ((r1 instanceof Map) == false) goto L12;
        return new JSONObject((Map) r1).toString();
    L12:
        if ((r1 instanceof List) == false) goto L15;
        return new JSONArray((Collection) r1).toString();
    L15:
        return r1.toString();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r14, ParamModel r15, f3.h r16) {
        AbsRequestMethodIDL.a r10 = (AbsRequestMethodIDL.a) r15;
        Intrinsics.checkNotNullParameter(r14, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r16, "callback");
        String r11 = r10.getUrl();
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        StringBuilder r13 = new StringBuilder("call start, url=");
        Object r17 = "invalid_url";
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Uri r1 = UriProtector.parse(r11);     // Catch: Throwable -> L15
        String r18 = r1.getScheme();     // Catch: Throwable -> L15
        if (r18 == null) goto L8;
        String r19 = r1.getHost();     // Catch: Throwable -> L15
        if (r19 == null) goto L8;
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L15
        r110.append(r18);     // Catch: Throwable -> L15
        r110.append("://");     // Catch: Throwable -> L15
        r110.append(r19);     // Catch: Throwable -> L15
        String r20 = r1.getPath();     // Catch: Throwable -> L15
        if (r20 != null) goto L12;
        r20 = "";
    L12:
        r110.append(r20);     // Catch: Throwable -> L15
        String r21 = r110.toString();     // Catch: Throwable -> L15
    L13:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r22) == true) goto L21;
        r17 = r22;
    L21:
        r13.append((String) r17);
        r13.append(", method=");
        String r23 = r10.getMethod();
        if (r23 != null) goto L24;
        r23 = "unknown";
    L24:
        r13.append(r23);
        r12.i("AISDK_JSB_RequestMethod", r13.toString());
        if (TextUtils.isEmpty(r11) == false) goto L27;
        com.bytedance.ai.utils.g r24 = com.bytedance.ai.utils.g.a;
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.h;
        r25.append(r26.a);
        r25.append(", msg=url is empty");
        r24.e("AISDK_JSB_RequestMethod", r25.toString());
        f3.h.a.a(r16, "url is empty", r26, null, 10);
        return;
    L27:
        AbsAppletRequestMethodIDL.RequestMethodType.a r27 = AbsAppletRequestMethodIDL.RequestMethodType.Companion;
        String r28 = r10.getMethod();
        if (r28 != null) goto L30;
        r28 = "GET";
    L30:
        r27.getClass();
        AbsAppletRequestMethodIDL.RequestMethodType r29 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r28.toUpperCase());     // Catch: Exception -> L33
    L35:
        if (r29 != AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED) goto L37;
        String r30 = "Illegal method " + r10.getMethod();
        com.bytedance.ai.utils.g r31 = com.bytedance.ai.utils.g.a;
        StringBuilder r32 = new StringBuilder("call failed, errNo=");
        f3.a r33 = f3.a.h;
        r32.append(r33.a);
        r32.append(", msg=");
        r32.append(r30);
        r31.e("AISDK_JSB_RequestMethod", r32.toString());
        f3.h.a.a(r16, r30, r33, null, 10);
        return;
    L37:
        a0 r34 = r14.getContainerContext();
        if (r34 == null) goto L40;
        String r35 = r34.getAppletId();
    L41:
        BuildersKt.launch$default(AppletRequestMethod.c, null, null, new AnonymousClass1(r35, r11, r16, r10, this, r29, null), 3, null);
        return;
    L40:
        r35 = null;
    L33:
        r29 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
    L8:
        r21 = "invalid_url";
    L15:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
