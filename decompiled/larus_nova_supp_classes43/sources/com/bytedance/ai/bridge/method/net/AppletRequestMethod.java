package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import android.util.Base64;
import b4.k;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0012\u0015\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J#\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "getContentType", "", "headers", "", "createStreamResponseCallback", "com/bytedance/ai/bridge/method/net/AppletRequestMethod$createStreamResponseCallback$1", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod$createStreamResponseCallback$1;", "createResponseCallback", "com/bytedance/ai/bridge/method/net/AppletRequestMethod$createResponseCallback$1", "(Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod$createResponseCallback$1;", "sendStreamEvent", "streamResponseData", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletRequestMethod extends AbsAppletRequestMethodIDL {
    public static final ConcurrentHashMap<String, k> b = null;
    public static final CoroutineScope c = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1", f = "AppletRequestMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $body;
        final /* synthetic */ String $bodyType;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsAppletRequestMethodIDL.b> $callback;
        final /* synthetic */ Map<String, Object> $header;
        final /* synthetic */ Map<String, Object> $methodParams;
        final /* synthetic */ AbsAppletRequestMethodIDL.a $params;
        final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType $requestMethodType;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ AppletRequestMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1$a */
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

        public AnonymousClass1(Map<String, ? extends Object> r1, AppletRequestMethod r10, String r11, Map<String, ? extends Object> r12, AbsAppletRequestMethodIDL.RequestMethodType r13, AbsAppletRequestMethodIDL.a r14, e3.d r15, f3.h<AbsAppletRequestMethodIDL.b> r16, Object r17, String r18, Continuation<? super AnonymousClass1> r19) {
            this.$header = r1;
            this.this$0 = r10;
            this.$url = r11;
            this.$methodParams = r12;
            this.$requestMethodType = r13;
            this.$params = r14;
            this.$bridgeContext = r15;
            this.$callback = r16;
            this.$body = r17;
            this.$bodyType = r18;
            super(2, r19);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new AnonymousClass1(this.$header, this.this$0, this.$url, this.$methodParams, this.$requestMethodType, this.$params, this.$bridgeContext, this.$callback, this.$body, this.$bodyType, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L104;
            ResultKt.throwOnFailure(r17);
            b4.e r0 = b4.e.a;
            Map<String, Object> r10 = this.$header;
            r0.getClass();
            Map<String, String> r11 = b4.e.c(r10);
            AppletRequestMethod r1 = this.this$0;
            ConcurrentHashMap<String, k> r12 = AppletRequestMethod.b;
            r1.getClass();
            if (r11.containsKey("content-type") == false) goto L8;
            String r13 = (String) ((LinkedHashMap) r11).get("content-type");
        L11:
            String r14 = this.$url;
            Map<String, Object> r15 = this.$methodParams;
            Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
            b4.g r16 = new b4.g(r14);
            if (r15 == null) goto L17;
            Iterator<Map.Entry<String, Object>> r18 = r15.entrySet().iterator();
        L15:
            if (r18.hasNext() == false) goto L17;
            Map.Entry<String, Object> r19 = r18.next();
            String r20 = r19.getKey();
            Object r21 = r19.getValue();
            b4.e.a.getClass();
            String r22 = b4.e.h(r21);
            Intrinsics.checkNotNullParameter(r20, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r22, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            r16.b.put(r20, r22);
        L17:
            String r23 = r16.a();
            IHostNetworkDepend r24 = r4.a.c;
            if (r24 != null) goto L20;
            r24 = new b4.a();
        L20:
            AbsAppletRequestMethodIDL.RequestMethodType r25 = this.$requestMethodType;
            int r26 = a.a[r25.ordinal()];
            if (r26 != 1) goto L23;
            boolean r27 = false;
            if (Intrinsics.areEqual(this.$params.getStreamType(), "sse") == false) goto L96;
            b4.e r28 = b4.e.a;
            AppletRequestMethod r29 = this.this$0;
            e3.d r30 = this.$bridgeContext;
            f3.h<AbsAppletRequestMethodIDL.b> r31 = this.$callback;
            r29.getClass();
            b r110 = new b(r31, r29, r30);
            boolean r32 = this.$params.getAddCommonParams();
            Boolean r33 = this.$params.isCustomizedCookie();
            if (r33 == null) goto L95;
            r27 = r33.booleanValue();
        L95:
            r28.getClass();
            Intrinsics.checkNotNullParameter(r23, "targetUrl");
            Intrinsics.checkNotNullParameter(r11, "headers");
            Intrinsics.checkNotNullParameter(r110, "callback");
            Intrinsics.checkNotNullParameter(r24, "hostNetworkDepend");
            b4.f r34 = new b4.f(r23);
            Intrinsics.checkNotNullParameter(r11, "headers");
            r34.b = r11;
            r34.c = r32;
            r34.j = r27;
            r34.g = 15000;
            r34.i = 15000;
            r34.h = 15000;
            Intrinsics.checkNotNullParameter(r24, "hostNetworkDepend");
            b4.b r35 = b4.b.a;
            com.bytedance.ai.bridge.method.net.core.RequestMethod r36 = com.bytedance.ai.bridge.method.net.core.RequestMethod.GET;
            r35.getClass();
            r110.a(b4.b.e(r36, r34, r24));
        L102:
            return Unit.INSTANCE;
        L96:
            b4.e r37 = b4.e.a;
            AppletRequestMethod r38 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r39 = this.$callback;
            r38.getClass();
            com.bytedance.ai.bridge.method.net.a r40 = new com.bytedance.ai.bridge.method.net.a(r39);
            boolean r41 = this.$params.getAddCommonParams();
            Boolean r42 = this.$params.isCustomizedCookie();
            if (r42 == null) goto L99;
            boolean r111 = r42.booleanValue();
        L100:
            b4.e.d(r37, r23, r11, r40, null, r24, r41, r111);
            goto L102
        L99:
            r111 = false;
            goto L100
        L23:
            if (r26 != 2) goto L25;
            if (r13 != null) goto L51;
            String r43 = "application/x-www-form-urlencoded";
        L52:
            r11.put("Content-Type", r43);
            if (Intrinsics.areEqual(this.$params.getStreamType(), "sse") == false) goto L77;
            b4.e r44 = b4.e.a;
            Object r45 = this.$body;
            AppletRequestMethod r46 = this.this$0;
            e3.d r112 = this.$bridgeContext;
            f3.h<AbsAppletRequestMethodIDL.b> r47 = this.$callback;
            r46.getClass();
            b r113 = new b(r47, r46, r112);
            boolean r48 = this.$params.getAddCommonParams();
            Boolean r49 = this.$params.isCustomizedCookie();
            if (r49 == null) goto L57;
            boolean r50 = r49.booleanValue();
        L58:
            r44.getClass();
            Intrinsics.checkNotNullParameter(r23, "targetUrl");
            Intrinsics.checkNotNullParameter(r11, "headers");
            Intrinsics.checkNotNullParameter(r43, "contentType");
            Intrinsics.checkNotNullParameter(r113, "callback");
            Intrinsics.checkNotNullParameter(r24, "hostNetworkDepend");
        L74:
            th = move-exception;
            com.bytedance.ai.utils.g.a.e(b4.e.b, "get failed", th);
            goto L102
        L60:
            if ((r45 instanceof byte[]) == false) goto L63;
            b4.f r114 = new b4.f(r23);     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r11, "headers");     // Catch: Throwable -> L74
            r114.b = r11;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r43, "contentType");     // Catch: Throwable -> L74
            r114.f = r43;     // Catch: Throwable -> L74
            r114.c = r48;     // Catch: Throwable -> L74
            r114.j = r50;     // Catch: Throwable -> L74
            r114.e = (byte[]) r45;     // Catch: Throwable -> L74
            r114.g = 15000;     // Catch: Throwable -> L74
            r114.i = 15000;     // Catch: Throwable -> L74
            r114.h = 15000;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r24, "hostNetworkDepend");     // Catch: Throwable -> L74
            b4.b r51 = b4.b.a;     // Catch: Throwable -> L74
            com.bytedance.ai.bridge.method.net.core.RequestMethod r52 = com.bytedance.ai.bridge.method.net.core.RequestMethod.POST;     // Catch: Throwable -> L74
            r51.getClass();     // Catch: Throwable -> L74
            r113.a(b4.b.e(r52, r114, r24));     // Catch: Throwable -> L74
            goto L102
        L63:
            if ((r45 instanceof String) == false) goto L66;
            byte[] r53 = ((String) r45).getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
        L72:
            b4.f r115 = new b4.f(r23);     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r11, "headers");     // Catch: Throwable -> L74
            r115.b = r11;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r43, "contentType");     // Catch: Throwable -> L74
            r115.f = r43;     // Catch: Throwable -> L74
            r115.c = r48;     // Catch: Throwable -> L74
            r115.j = r50;     // Catch: Throwable -> L74
            r115.e = r53;     // Catch: Throwable -> L74
            r115.g = 15000;     // Catch: Throwable -> L74
            r115.i = 15000;     // Catch: Throwable -> L74
            r115.h = 15000;     // Catch: Throwable -> L74
            r115.k = -1;     // Catch: Throwable -> L74
            Intrinsics.checkNotNullParameter(r24, "hostNetworkDepend");     // Catch: Throwable -> L74
            b4.b r54 = b4.b.a;     // Catch: Throwable -> L74
            com.bytedance.ai.bridge.method.net.core.RequestMethod r55 = com.bytedance.ai.bridge.method.net.core.RequestMethod.POST;     // Catch: Throwable -> L74
            r54.getClass();     // Catch: Throwable -> L74
            r113.a(b4.b.e(r55, r115, r24));     // Catch: Throwable -> L74
            goto L102
        L66:
            if ((r45 instanceof List) == false) goto L69;
            r53 = new JSONArray((Collection) r45).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L69:
            if ((r45 instanceof Map) == false) goto L71;
            r53 = new JSONObject((Map) r45).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L71:
            r53 = new JSONObject().toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L74
            goto L72
        L57:
            r50 = false;
            goto L58
        L77:
            if ((this.$body instanceof String) == true) goto L79;
        L85:
            b4.e r56 = b4.e.a;
            Object r57 = this.$body;
            AppletRequestMethod r58 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r59 = this.$callback;
            r58.getClass();
            com.bytedance.ai.bridge.method.net.a r60 = new com.bytedance.ai.bridge.method.net.a(r59);
            boolean r116 = this.$params.getAddCommonParams();
            Boolean r117 = this.$params.isCustomizedCookie();
            if (r117 == null) goto L88;
            boolean r118 = r117.booleanValue();
        L89:
            b4.e.f(r56, r23, r11, r43, r57, r60, null, r24, r116, r118);
            goto L102
        L88:
            r118 = false;
            goto L89
        L79:
            if (Intrinsics.areEqual(this.$bodyType, "base64") == false) goto L85;
            b4.e r61 = b4.e.a;
            byte[] r62 = Base64.decode((String) this.$body, 0);
            AppletRequestMethod r63 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r64 = this.$callback;
            r63.getClass();
            com.bytedance.ai.bridge.method.net.a r65 = new com.bytedance.ai.bridge.method.net.a(r64);
            boolean r119 = this.$params.getAddCommonParams();
            Boolean r120 = this.$params.isCustomizedCookie();
            if (r120 == null) goto L83;
            boolean r121 = r120.booleanValue();
        L84:
            b4.e.f(r61, r23, r11, r43, r62, r65, null, r24, r119, r121);
            goto L102
        L83:
            r121 = false;
            goto L84
        L51:
            r43 = r13;
            goto L52
        L25:
            if (r26 != 3) goto L27;
            Object r66 = this.$body;
            if (r66 != null) goto L37;
        L39:
            JSONObject r67 = new JSONObject();
        L40:
            JSONObject r68 = r67;
            b4.e r69 = b4.e.a;
            if (r13 != null) goto L43;
            String r70 = "application/x-www-form-urlencoded";
        L44:
            AppletRequestMethod r71 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r72 = this.$callback;
            r71.getClass();
            com.bytedance.ai.bridge.method.net.a r73 = new com.bytedance.ai.bridge.method.net.a(r72);
            boolean r122 = this.$params.getAddCommonParams();
            Boolean r123 = this.$params.isCustomizedCookie();
            if (r123 == null) goto L47;
            boolean r124 = r123.booleanValue();
        L48:
            b4.e.g(r69, r23, r11, r70, r68, r73, null, r24, r122, r124);
            goto L102
        L47:
            r124 = false;
            goto L48
        L43:
            r70 = r13;
            goto L44
        L37:
            if ((r66 instanceof Map) == false) goto L39;
            r67 = new JSONObject((Map) this.$body);
            goto L40
        L27:
            if (r26 != 4) goto L102;
            b4.e r74 = b4.e.a;
            AppletRequestMethod r75 = this.this$0;
            f3.h<AbsAppletRequestMethodIDL.b> r76 = this.$callback;
            r75.getClass();
            com.bytedance.ai.bridge.method.net.a r77 = new com.bytedance.ai.bridge.method.net.a(r76);
            boolean r78 = this.$params.getAddCommonParams();
            Boolean r79 = this.$params.isCustomizedCookie();
            if (r79 == null) goto L32;
            boolean r125 = r79.booleanValue();
        L33:
            b4.e.b(r74, r23, r11, r77, null, r24, r78, r125);
            goto L102
        L32:
            r125 = false;
            goto L33
        L8:
            if (r11.containsKey("Content-Type") == false) goto L10;
            r13 = (String) ((LinkedHashMap) r11).get("Content-Type");
            goto L11
        L10:
            r13 = null;
            goto L11
        L104:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        b = new ConcurrentHashMap();
        c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(TTExecutors.getNormalExecutor()));
    }

    public AppletRequestMethod() {
    }

    public static final void b(AppletRequestMethod r0, e3.d r1, AbsAppletRequestMethodIDL.StreamResponseData r10) {
        r0.getClass();
        r1.a("applet.streamResponse", com.bytedance.ai.applet.base.gson.e.d(r10));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r18, ParamModel r19, f3.h r20) {
        AbsAppletRequestMethodIDL.a r10 = (AbsAppletRequestMethodIDL.a) r19;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        AbsAppletRequestMethodIDL.RequestMethodType.a r0 = AbsAppletRequestMethodIDL.RequestMethodType.Companion;
        String r1 = r10.getMethod();
        r0.getClass();
        if (r1 != null) goto L16;
        AbsAppletRequestMethodIDL.RequestMethodType r11 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
    L8:
        AbsAppletRequestMethodIDL.RequestMethodType r12 = r11;
        if (r12 != AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED) goto L11;
        f3.h.a.a(r20, "Illegal method " + r10.getMethod(), null, null, 14);
        return;
    L11:
        Map<String, Object> r13 = r10.getHeader();
        Object r14 = r10.getBody();
        String r15 = r10.getBodyType();
        Map<String, Object> r16 = r10.getParams();
        String r17 = r10.getUrl();
        if (TextUtils.isEmpty(r17) == false) goto L14;
        f3.h.a.a(r20, "url is empty", null, null, 14);
        return;
    L14:
        BuildersKt.launch$default(c, null, null, new AnonymousClass1(r13, this, r17, r16, r12, r10, r18, r20, r14, r15, null), 3, null);
        return;
    L16:
        r11 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r1.toUpperCase());     // Catch: Exception -> L6
    L6:
        r11 = AbsAppletRequestMethodIDL.RequestMethodType.UNSUPPORTED;
        goto L8
    }
}
