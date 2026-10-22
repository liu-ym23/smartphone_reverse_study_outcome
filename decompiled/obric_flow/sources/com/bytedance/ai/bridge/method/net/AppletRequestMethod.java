package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
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
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u000e\u0011\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001b\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/AppletRequestMethod;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL;", "<init>", "()V", "", "", "headers", "getContentType", "(Ljava/util/Map;)Ljava/lang/String;", "Ln1/c;", "bridgeContext", "Lo1/f;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestResultModel;", "callback", "com/bytedance/ai/bridge/method/net/d", "createStreamResponseCallback", "(Ln1/c;Lo1/f;)Lcom/bytedance/ai/bridge/method/net/d;", "com/bytedance/ai/bridge/method/net/c", "createResponseCallback", "(Lo1/f;)Lcom/bytedance/ai/bridge/method/net/c;", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;", "streamResponseData", "", "sendStreamEvent", "(Ln1/c;Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$StreamResponseData;)V", "Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;", LynxResourceModule.PARAMS_KEY, "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/net/AbsAppletRequestMethodIDL$AppletRequestParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/net/b", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppletRequestMethod extends AbsAppletRequestMethodIDL {
    private static final String BODY_TYPE_BASE64 = "base64";
    private static final String CONTENT_TYPE = "content-type";
    private static final String CONTENT_TYPE_CAPITAL = "Content-Type";
    public static final b Companion = null;
    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String STREAM_RESPONSE_KEY = "applet.streamResponse";
    private static final String STREAM_TYPE_SSE = "sse";
    private static final String TAG = "AppletRequestMethod";
    private static final CoroutineScope scope = null;
    private static final ConcurrentHashMap<String, c2.a> streamRequestMap = null;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.AppletRequestMethod$handle$1", f = "AppletRequestMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f1863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppletRequestMethod f1864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1865c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType e;
        public final /* synthetic */ AbsAppletRequestMethodIDL.AppletRequestParamModel f;
        public final /* synthetic */ n1.c g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o1.f f1866h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Object f1867i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f1868j;

        public AnonymousClass1(Map r5, AppletRequestMethod r10, String r11, Map r12, AbsAppletRequestMethodIDL.RequestMethodType r13, AbsAppletRequestMethodIDL.AppletRequestParamModel r14, n1.c r15, o1.f r16, Object r17, String r18, Continuation r19) {
            this.f1863a = r5;
            this.f1864b = r10;
            this.f1865c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.f1866h = r16;
            this.f1867i = r17;
            this.f1868j = r18;
            super(2, r19);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r13, Continuation r14) {
            return new AnonymousClass1(this.f1863a, this.f1864b, this.f1865c, this.d, this.e, this.f, this.g, this.f1866h, this.f1867i, this.f1868j, r14);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r15);
            Map r16 = this.f1863a;
            LinkedHashMap r5 = new LinkedHashMap();
            if (r16 == null) goto L22;
            Iterator r17 = r16.entrySet().iterator();
        L6:
            if (r17.hasNext() == false) goto L22;
            Map.Entry r10 = (Map.Entry) r17.next();
            Object r11 = r10.getValue();
            if (r11 != null) goto L11;
            String r12 = "";
        L18:
            if (com.bytedance.ai.utils.c.l((String) r10.getKey()) == false) goto L6;
            if (r12.length() <= 0) goto L6;
            r5.put(r10.getKey(), r12);
            goto L6
        L11:
            if ((r11 instanceof Map) == false) goto L14;
            r12 = new JSONObject((Map) r11).toString();
            goto L18
        L14:
            if ((r11 instanceof List) == false) goto L16;
            r12 = new JSONArray((Collection) r11).toString();
            goto L18
        L16:
            r12 = r11.toString();
        L22:
            String r18 = AppletRequestMethod.access$getContentType(this.f1864b, r5);
            String r13 = this.f1865c;
            Map r14 = this.d;
            Intrinsics.checkNotNullParameter(r13, "url");
            c2.c r19 = new c2.c(r13);
            if (r14 == null) goto L38;
            Iterator r20 = r14.entrySet().iterator();
        L26:
            if (r20.hasNext() == false) goto L38;
            Map.Entry r21 = (Map.Entry) r20.next();
            String r22 = (String) r21.getKey();
            Object r23 = r21.getValue();
            if (r23 != null) goto L31;
            String r24 = "";
        L37:
            Intrinsics.checkNotNullParameter(r22, "name");
            Intrinsics.checkNotNullParameter(r24, "value");
            r19.f1112b.put(r22, r24);
            goto L26
        L31:
            if ((r23 instanceof Map) == false) goto L34;
            r24 = new JSONObject((Map) r23).toString();
            goto L37
        L34:
            if ((r23 instanceof List) == false) goto L36;
            r24 = new JSONArray((Collection) r23).toString();
            goto L37
        L36:
            r24 = r23.toString();
        L38:
            String r25 = "build url is " + r19.a();
            Intrinsics.checkNotNullParameter("AppletRequestUtils", "tag");
            t0.d r26 = com.bytedance.ai.utils.c.f2846a;
            if (r26 == null) goto L41;
            r26.d("AppletRequestUtils", r25);
        L41:
            String r27 = r19.a();
            IHostNetworkDepend r28 = k5.d.f18602c;
            if (r28 != null) goto L44;
            r28 = new com.bytedance.sdk.xbridge.cn.auth.g(2);
        L44:
            IHostNetworkDepend r29 = r28;
            int r30 = this.e.ordinal();
            boolean r110 = false;
            if (r30 == 0) goto L116;
            if (r30 != 1) goto L49;
            if (r18 != null) goto L75;
            r18 = AppletRequestMethod.DEFAULT_CONTENT_TYPE;
        L75:
            r5.put(AppletRequestMethod.CONTENT_TYPE_CAPITAL, r18);
            if (Intrinsics.areEqual(this.f.getStreamType(), AppletRequestMethod.STREAM_TYPE_SSE) == false) goto L102;
            Object r31 = this.f1867i;
            d r32 = AppletRequestMethod.access$createStreamResponseCallback(this.f1864b, this.g, this.f1866h);
            boolean r111 = this.f.getAddCommonParams();
            Boolean r112 = this.f.isCustomizedCookie();
            if (r112 == null) goto L80;
            r110 = r112.booleanValue();
        L80:
            Intrinsics.checkNotNullParameter(r27, "targetUrl");
            Intrinsics.checkNotNullParameter(r5, "headers");
            Intrinsics.checkNotNullParameter(r18, "contentType");
            Intrinsics.checkNotNullParameter(r32, "callback");
            Intrinsics.checkNotNullParameter(r29, "hostNetworkDepend");
        L84:
            th = move-exception;
            Intrinsics.checkNotNullParameter("AppletRequestUtils", "tag");
            t0.d r113 = com.bytedance.ai.utils.c.f2846a;
            if (r113 == null) goto L127;
            r113.e("AppletRequestUtils", "get failed", th);
        L127:
            return Unit.INSTANCE;
        L82:
            if ((r31 instanceof byte[]) == false) goto L87;
            c2.b r33 = new c2.b(r27);     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r5, "headers");     // Catch: Throwable -> L84
            r33.e = r5;     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r18, "contentType");     // Catch: Throwable -> L84
            r33.d = r18;     // Catch: Throwable -> L84
            r33.f1108a = r111;     // Catch: Throwable -> L84
            r33.f1109b = r110;     // Catch: Throwable -> L84
            r33.f = (byte[]) r31;     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r29, "hostNetworkDepend");     // Catch: Throwable -> L84
            r32.a(f0.a(com.bytedance.ai.bridge.method.net.core.RequestMethod.f1874b, r33, r29));     // Catch: Throwable -> L84
            goto L127
        L87:
            if ((r31 instanceof String) == false) goto L90;
            byte[] r34 = ((String) r31).getBytes(Charsets.UTF_8);     // Catch: Throwable -> L84
        L96:
            c2.b r35 = new c2.b(r27);     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r5, "headers");     // Catch: Throwable -> L84
            r35.e = r5;     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r18, "contentType");     // Catch: Throwable -> L84
            r35.d = r18;     // Catch: Throwable -> L84
            r35.f1108a = r111;     // Catch: Throwable -> L84
            r35.f1109b = r110;     // Catch: Throwable -> L84
            r35.f = r34;     // Catch: Throwable -> L84
            Intrinsics.checkNotNullParameter(r29, "hostNetworkDepend");     // Catch: Throwable -> L84
            r32.a(f0.a(com.bytedance.ai.bridge.method.net.core.RequestMethod.f1874b, r35, r29));     // Catch: Throwable -> L84
            goto L127
        L90:
            if ((r31 instanceof List) == false) goto L93;
            r34 = new JSONArray((Collection) r31).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L84
            goto L96
        L93:
            if ((r31 instanceof Map) == false) goto L95;
            r34 = new JSONObject((Map) r31).toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L84
            goto L96
        L95:
            r34 = new JSONObject().toString().getBytes(Charsets.UTF_8);     // Catch: Throwable -> L84
            goto L96
        L102:
            if ((this.f1867i instanceof String) == true) goto L104;
        L110:
            Object r36 = this.f1867i;
            c r37 = AppletRequestMethod.access$createResponseCallback(this.f1864b, this.f1866h);
            boolean r38 = this.f.getAddCommonParams();
            Boolean r114 = this.f.isCustomizedCookie();
            if (r114 == null) goto L113;
            boolean r39 = r114.booleanValue();
        L114:
            com.lynx.tasm.utils.a.h(r27, r5, r18, r36, r37, null, r29, r38, r39);
            goto L127
        L113:
            r39 = false;
            goto L114
        L104:
            if (Intrinsics.areEqual(this.f1868j, AppletRequestMethod.BODY_TYPE_BASE64) == false) goto L110;
            byte[] r40 = Base64.decode((String) this.f1867i, 0);
            c r41 = AppletRequestMethod.access$createResponseCallback(this.f1864b, this.f1866h);
            boolean r42 = this.f.getAddCommonParams();
            Boolean r115 = this.f.isCustomizedCookie();
            if (r115 == null) goto L108;
            boolean r43 = r115.booleanValue();
        L109:
            com.lynx.tasm.utils.a.h(r27, r5, r18, r40, r41, null, r29, r42, r43);
            goto L127
        L108:
            r43 = false;
            goto L109
        L49:
            if (r30 != 2) goto L51;
            Object r44 = this.f1867i;
            if (r44 != null) goto L61;
        L64:
            JSONObject r45 = new JSONObject();
        L63:
            JSONObject r46 = r45;
            if (r18 != null) goto L67;
            String r47 = AppletRequestMethod.DEFAULT_CONTENT_TYPE;
        L68:
            c r48 = AppletRequestMethod.access$createResponseCallback(this.f1864b, this.f1866h);
            boolean r49 = this.f.getAddCommonParams();
            Boolean r116 = this.f.isCustomizedCookie();
            if (r116 == null) goto L71;
            boolean r50 = r116.booleanValue();
        L72:
            com.lynx.tasm.utils.a.o(r27, r5, r47, r46, r48, null, r29, r49, r50);
            goto L127
        L71:
            r50 = false;
            goto L72
        L67:
            r47 = r18;
            goto L68
        L61:
            if ((r44 instanceof Map) == false) goto L64;
            r45 = new JSONObject((Map) this.f1867i);
            goto L63
        L51:
            if (r30 != 3) goto L127;
            c r51 = AppletRequestMethod.access$createResponseCallback(this.f1864b, this.f1866h);
            boolean r52 = this.f.getAddCommonParams();
            Boolean r117 = this.f.isCustomizedCookie();
            if (r117 == null) goto L56;
            boolean r118 = r117.booleanValue();
        L57:
            com.lynx.tasm.utils.a.g(r27, r5, r51, null, r29, r52, r118);
            goto L127
        L56:
            r118 = false;
            goto L57
        L116:
            if (Intrinsics.areEqual(this.f.getStreamType(), AppletRequestMethod.STREAM_TYPE_SSE) == false) goto L121;
            d r119 = AppletRequestMethod.access$createStreamResponseCallback(this.f1864b, this.g, this.f1866h);
            boolean r53 = this.f.getAddCommonParams();
            Boolean r120 = this.f.isCustomizedCookie();
            if (r120 == null) goto L120;
            r110 = r120.booleanValue();
        L120:
            Intrinsics.checkNotNullParameter(r27, "targetUrl");
            Intrinsics.checkNotNullParameter(r5, "headers");
            Intrinsics.checkNotNullParameter(r119, "callback");
            Intrinsics.checkNotNullParameter(r29, "hostNetworkDepend");
            c2.b r121 = new c2.b(r27);
            Intrinsics.checkNotNullParameter(r5, "headers");
            r121.e = r5;
            r121.f1108a = r53;
            r121.f1109b = r110;
            Intrinsics.checkNotNullParameter(r29, "hostNetworkDepend");
            r119.a(f0.a(com.bytedance.ai.bridge.method.net.core.RequestMethod.f1873a, r121, r29));
            goto L127
        L121:
            c r54 = AppletRequestMethod.access$createResponseCallback(this.f1864b, this.f1866h);
            boolean r55 = this.f.getAddCommonParams();
            Boolean r122 = this.f.isCustomizedCookie();
            if (r122 == null) goto L124;
            boolean r123 = r122.booleanValue();
        L125:
            com.lynx.tasm.utils.a.n(r27, r5, r54, null, r29, r55, r123);
            goto L127
        L124:
            r123 = false;
            goto L125
        }
    }

    static {
        Companion = new b();
        streamRequestMap = new ConcurrentHashMap();
        scope = h0.a(new e1(e8.d.f16785a));
    }

    public AppletRequestMethod() {
    }

    public static final /* synthetic */ c access$createResponseCallback(AppletRequestMethod r5, o1.f r10) {
        return r5.createResponseCallback(r10);
    }

    public static final /* synthetic */ d access$createStreamResponseCallback(AppletRequestMethod r5, n1.c r10, o1.f r11) {
        return r5.createStreamResponseCallback(r10, r11);
    }

    public static final /* synthetic */ String access$getContentType(AppletRequestMethod r5, Map r10) {
        return r5.getContentType(r10);
    }

    public static final /* synthetic */ CoroutineScope access$getScope$cp() {
        return scope;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getStreamRequestMap$cp() {
        return streamRequestMap;
    }

    public static final /* synthetic */ void access$sendStreamEvent(AppletRequestMethod r5, n1.c r10, AbsAppletRequestMethodIDL.StreamResponseData r11) {
        r5.sendStreamEvent(r10, r11);
    }

    private final c createResponseCallback(o1.f r5) {
        return new c(r5);
    }

    private final d createStreamResponseCallback(n1.c r5, o1.f r10) {
        return new d(this, r5, r10);
    }

    private final String getContentType(Map<String, String> r5) {
        if (r5.containsKey(CONTENT_TYPE) == false) goto L7;
        return r5.get(CONTENT_TYPE);
    L7:
        if (r5.containsKey(CONTENT_TYPE_CAPITAL) == true) goto L9;
        return null;
    L9:
        return r5.get(CONTENT_TYPE_CAPITAL);
    }

    private final void sendStreamEvent(n1.c r5, AbsAppletRequestMethodIDL.StreamResponseData r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        JsonObject r11 = z0.a.a().toJsonTree(r10).getAsJsonObject();
        n1.a r12 = (n1.a) r5;
        r12.getClass();
        Intrinsics.checkNotNullParameter(STREAM_RESPONSE_KEY, "eventName");
        Intrinsics.checkNotNullParameter(STREAM_RESPONSE_KEY, "eventName");
        r12.f20195a.f19965a.e(STREAM_RESPONSE_KEY, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsAppletRequestMethodIDL.AppletRequestParamModel) r10, r11);
    }

    public void handle(n1.c r15, AbsAppletRequestMethodIDL.AppletRequestParamModel r16, o1.f r17) {
        Intrinsics.checkNotNullParameter(r15, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r17, "callback");
        a r5 = AbsAppletRequestMethodIDL.RequestMethodType.f1857a;
        String r10 = r16.getMethod();
        r5.getClass();
        if (r10 != null) goto L18;
        AbsAppletRequestMethodIDL.RequestMethodType r11 = AbsAppletRequestMethodIDL.RequestMethodType.f1858b;
    L5:
        AbsAppletRequestMethodIDL.RequestMethodType r12 = r11;
        if (r12 != AbsAppletRequestMethodIDL.RequestMethodType.f1858b) goto L12;
        r17.a("Illegal method " + r16.getMethod());
        return;
    L12:
        Map<String, Object> r13 = r16.getHeader();
        Object r14 = r16.getBody();
        String r18 = r16.getBodyType();
        Map<String, Object> r19 = r16.getParams();
        String r20 = r16.getUrl();
        if (TextUtils.isEmpty(r20) == false) goto L16;
        r17.a("url is empty");
        return;
    L16:
        BuildersKt.launch$default(scope, null, null, new AnonymousClass1(r13, this, r20, r19, r12, r16, r15, r17, r14, r18, null), 3, null);
        return;
    L18:
        r11 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r10.toUpperCase());     // Catch: Exception -> L6
    L6:
        r11 = AbsAppletRequestMethodIDL.RequestMethodType.f1858b;
        goto L5
    }
}
