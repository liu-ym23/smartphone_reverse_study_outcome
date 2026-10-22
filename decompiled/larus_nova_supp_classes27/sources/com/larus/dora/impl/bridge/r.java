package com.larus.dora.impl.bridge;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.api.IDoraService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.base.networkRequest")
public final class r extends XCoreIDLBridgeMethod<c, d> {

    @XBridgeMethodName(name = "dora.base.networkRequest")
    public final String a;

    public static final class a {
        public static final /* synthetic */ int d = 0;
        public final boolean a;
        public final d b;
        public final String c;

        /* JADX INFO: renamed from: com.larus.dora.impl.bridge.r$a$a, reason: collision with other inner class name */
        public static final class C0029a {
            public static a a(String r2, d r3) {
                Intrinsics.checkNotNullParameter(r2, "msg");
                Intrinsics.checkNotNullParameter(r3, "resultModel");
                return new a(false, r3, r2);
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
            String r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "BridgeResult(isSuccess=" + this.a + ", resultModel=" + this.b + ", msg=" + this.c + ')';
        }

        public a(boolean r2, d r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "resultModel");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "headers", required = BuildConfig.DEBUG)
        Map<String, String> getHeaders();

        @XBridgeParamField(isGetter = true, keyPath = "method", required = true)
        String getMethod();

        @XBridgeParamField(isGetter = true, keyPath = "needCommonParams", required = BuildConfig.DEBUG)
        Boolean getNeedCommonParams();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = BuildConfig.DEBUG)
        Map<String, Object> getParams();

        @XBridgeParamField(isGetter = true, keyPath = "requireSignature", required = BuildConfig.DEBUG)
        Boolean getRequireSignature();

        @XBridgeParamField(isGetter = true, keyPath = "timeoutMs", required = BuildConfig.DEBUG)
        Number getTimeoutMs();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientCode", required = BuildConfig.DEBUG)
        Number getClientCode();

        @XBridgeParamField(isGetter = true, keyPath = "header", required = BuildConfig.DEBUG)
        Map<String, Object> getHeader();

        @XBridgeParamField(isGetter = true, keyPath = "httpCode", required = BuildConfig.DEBUG)
        Number getHttpCode();

        @XBridgeParamField(isGetter = true, keyPath = "rawResponse", required = BuildConfig.DEBUG)
        String getRawResponse();

        @XBridgeParamField(isGetter = true, keyPath = "response", required = BuildConfig.DEBUG)
        Object getResponse();

        @XBridgeParamField(isGetter = true, keyPath = "responseType", required = BuildConfig.DEBUG)
        String getResponseType();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "clientCode", required = BuildConfig.DEBUG)
        void setClientCode(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "header", required = BuildConfig.DEBUG)
        void setHeader(Map<String, ? extends Object> r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "httpCode", required = BuildConfig.DEBUG)
        void setHttpCode(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "rawResponse", required = BuildConfig.DEBUG)
        void setRawResponse(String r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "response", required = BuildConfig.DEBUG)
        void setResponse(Object r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "responseType", required = BuildConfig.DEBUG)
        void setResponseType(String r1);
    }

    static {
    }

    public r() {
        this.a = "dora.base.networkRequest";
    }

    public final String getName() {
        return this.a;
    }

    public static Object f(Object r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if ((r4 instanceof Boolean) == false) goto L6;
        return r4;
    L6:
        if ((r4 instanceof Number) == false) goto L8;
        return r4;
    L8:
        if ((r4 instanceof String) == false) goto L11;
        return r4;
    L11:
        if ((r4 instanceof JSONObject) == false) goto L17;
        Map r0 = MapsKt.createMapBuilder();
        JSONObject r5 = (JSONObject) r4;
        Iterator<String> r1 = r5.keys();
    L14:
        if (r1.hasNext() == false) goto L68;
        String r2 = r1.next();
        r0.put(r2, f(r5.opt(r2)));
        goto L14
    L68:
        return MapsKt.build(r0);
    L17:
        int r3 = 0;
        if ((r4 instanceof JSONArray) == false) goto L24;
        List r6 = CollectionsKt.createListBuilder();
        JSONArray r7 = (JSONArray) r4;
        int r8 = r7.length();
    L20:
        if (r3 >= r8) goto L69;
        r6.add(f(r7.opt(r3)));
        r3 = r3 + 1;
        goto L20
    L69:
        return CollectionsKt.build(r6);
    L24:
        if ((r4 instanceof Map) == false) goto L35;
        Map r9 = MapsKt.createMapBuilder();
        Iterator r10 = ((Map) r4).entrySet().iterator();
    L27:
        if (r10.hasNext() == false) goto L70;
        Map.Entry r11 = (Map.Entry) r10.next();
        Object r12 = r11.getKey();
        Object r13 = r11.getValue();
        if (r12 == null) goto L27;
        String r14 = r12.toString();
        if (r14 == null) goto L27;
        r9.put(r14, f(r13));
        goto L27
    L70:
        return MapsKt.build(r9);
    L35:
        if ((r4 instanceof Iterable) == false) goto L42;
        Iterable r15 = (Iterable) r4;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L38:
        if (r17.hasNext() == false) goto L71;
        r16.add(f(r17.next()));
    L71:
        return r16;
    L42:
        if ((r4 instanceof Object[]) == false) goto L51;
        Object[] r18 = (Object[]) r4;
        r16 = new ArrayList(r18.length);
        int r20 = r18.length;
    L44:
        if (r3 >= r20) goto L71;
        r16.add(f(r18[r3]));
        r3 = r3 + 1;
    L48:
        th = move-exception;
        throw th;
    L51:
        return r4.toString();
    }

    public final a b(com.larus.network.http.a<? extends Object> r11) {
        if ((r11 instanceof y) == false) goto L28;
        y r12 = (y) r11;
        Object r3 = f(((com.larus.network.http.a) r12).b);
        String r5 = ((com.larus.network.http.a) r12).c;
        if (r3 != null) goto L21;
        Long r1 = r12.g;
        if (r1 != null) goto L10;
    L12:
        if (r5 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        String r4 = "raw";
    L22:
        String r6 = r4;
    L23:
        int r7 = a.d;
        Long r13 = r12.g;
        if (r13 == null) goto L26;
        Integer r8 = Integer.valueOf((int) r13.longValue());
    L27:
        d r14 = e(this, r8, r3, r6, r5, 5);
        Intrinsics.checkNotNullParameter(r14, "resultModel");
        return new a(true, r14, null);
    L26:
        r8 = null;
        goto L27
    L20:
        r6 = null;
        goto L23
    L14:
        if (r5.length() == 0) goto L17;
        r2 = false;
        goto L18
    L10:
        if (r1.longValue() != 0) goto L12;
    L21:
        r4 = "json";
        goto L22
    L28:
        String r9 = "unknown error";
        if ((r11 instanceof com.larus.network.http.f) == false) goto L35;
        com.larus.network.http.f r15 = (com.larus.network.http.f) r11;
        String r0 = r15.d.getMessage();
        if (r0 == null) goto L34;
        r9 = r0;
    L34:
        int r10 = a.d;
        return a.C0029a.a(r9, e(this, Integer.valueOf((int) r15.d.getCode()), null, "raw", r9, 13));
    L35:
        int r16 = a.d;
        return a.C0029a.a("unknown error", c(this, "unknown error"));
    }

    public final Object g(Object r3) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if ((r3 instanceof Boolean) == false) goto L6;
        return r3;
    L6:
        if ((r3 instanceof Number) == false) goto L8;
        return r3;
    L8:
        if ((r3 instanceof String) == false) goto L10;
        return r3;
    L10:
        if ((r3 instanceof JSONObject) == false) goto L12;
        return r3;
    L12:
        if ((r3 instanceof JSONArray) == false) goto L15;
        return r3;
    L15:
        if ((r3 instanceof Map) == false) goto L18;
        return h(r3);
    L18:
        if ((r3 instanceof Iterable) == false) goto L25;
        JSONArray r0 = new JSONArray();
        Iterator r4 = ((Iterable) r3).iterator();
    L21:
        if (r4.hasNext() == false) goto L40;
        r0.put(g(r4.next()));
    L40:
        return r0;
    L25:
        if ((r3 instanceof Object[]) == false) goto L31;
        Iterable r5 = ArraysKt.asIterable((Object[]) r3);
        r0 = new JSONArray();
        Iterator r6 = r5.iterator();
    L28:
        if (r6.hasNext() == false) goto L40;
        r0.put(g(r6.next()));
        goto L28
    L31:
        return r3.toString();
    }

    public final JSONObject h(Object r4) {
        if (r4 != null) goto L5;
        return new JSONObject();
    L5:
        if ((r4 instanceof JSONObject) == false) goto L8;
        return (JSONObject) r4;
    L8:
        if ((r4 instanceof String) == false) goto L15;
        if (StringsKt.isBlank((CharSequence) r4) == true) goto L35;
        JSONObject r0 = new JSONObject((String) r4);
    L36:
        return r0;
    L35:
        return new JSONObject();
    L15:
        if ((r4 instanceof Map) == false) goto L26;
        r0 = new JSONObject();
        Iterator r5 = ((Map) r4).entrySet().iterator();
    L18:
        if (r5.hasNext() == false) goto L36;
        Map.Entry r1 = (Map.Entry) r5.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (r2 == null) goto L18;
        String r6 = r2.toString();
        if (r6 == null) goto L18;
        r0.put(r6, g(r3));
        goto L18
    L26:
        throw new IllegalArgumentException("unsupported params type: ".concat(r4.getClass().getSimpleName()));
    }

    public static d c(r r6, String r7) {
        r6.getClass();
        return e(r6, null, null, "raw", r7, 13);
    }

    public final void handle(IBDXBridgeContext r12, XBaseParamModel r13, CompletionBlock r14) {
        c r4 = (c) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        String r2 = r4.getUrl();
        String r15 = r4.getMethod();
        if (r15 == null) goto L5;
        String r3 = r15.toUpperCase(Locale.ROOT);
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L17;
        r14.onFailure(-3, "url is empty", c(this, "url is empty"));
        return;
    L17:
        if (Intrinsics.areEqual(r3, "GET") == false) goto L19;
    L21:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new DoraNetworkRequestMethod$handle$1(this, r2, r3, r4, r14, null), 3, null);
        return;
    L19:
        if (Intrinsics.areEqual(r3, "POST") == true) goto L21;
        String r16 = "unsupported method: " + r4.getMethod();
        r14.onFailure(-3, r16, c(this, r16));
        return;
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r0 = false;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public static d e(r r3, Integer r4, Object r5, String r6, String r7, int r8) {
        Map<String, ? extends Object> r1 = null;
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L8;
        Map<String, ? extends Object> r0 = MapsKt.emptyMap();
    L10:
        if ((r8 & 8) == 0) goto L13;
        r5 = null;
    L13:
        if ((r8 & 16) == 0) goto L16;
        r6 = null;
    L16:
        if ((r8 & 32) == 0) goto L18;
        r7 = null;
    L18:
        r3.getClass();
        d r9 = ne7.e.b(d.class);
        r9.setHttpCode(null);
        r9.setClientCode(r4);
        if ((!r0.isEmpty()) == false) goto L21;
        r1 = r0;
    L21:
        r9.setHeader(r1);
        r9.setResponse(r5);
        r9.setResponseType(r6);
        r9.setRawResponse(r7);
        return r9;
    L8:
        r0 = null;
        goto L10
    }

    public static final Object a(r r16, String r17, String r18, Object r110, Map r20, boolean r21, Long r22, Continuation r23) {
        r16.getClass();
        if ((r23 instanceof DoraNetworkRequestMethod$executeRequest$1) == false) goto L7;
        DoraNetworkRequestMethod$executeRequest$1 r3 = (DoraNetworkRequestMethod$executeRequest$1) r23;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DoraNetworkRequestMethod$executeRequest$1 r14 = r3;
        Object r2 = r14.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r14.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L55:
        a r0 = r16.b((com.larus.network.http.a) r2);
    L56:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r2);
    L42:
        r0 = r16.b((com.larus.network.http.a) r2);
        goto L56
    L16:
        ResultKt.throwOnFailure(r2);
        Map r7 = null;
        if (r22 != null) goto L19;
        RequestContext r12 = null;
    L21:
        if (Intrinsics.areEqual(r18, "GET") == false) goto L44;
        JSONObject r1 = r16.h(r110);
        Map r8 = MapsKt.createMapBuilder();
        Iterator<String> r9 = r1.keys();
    L24:
        if (r9.hasNext() == false) goto L39;
        String r10 = r9.next();
        Object r11 = r1.opt(r10);
        Intrinsics.checkNotNull(r10);
        if (r11 != null) goto L28;
    L37:
        String r13 = "";
    L38:
        r8.put(r10, r13);
        goto L24
    L28:
        if (Intrinsics.areEqual(r11, JSONObject.NULL) == true) goto L37;
        if ((r11 instanceof JSONObject) == false) goto L33;
    L36:
        r13 = r11.toString();
        goto L38
    L33:
        if ((r11 instanceof JSONArray) == true) goto L36;
        r13 = r11.toString();
        goto L38
    L39:
        Map r15 = MapsKt.build(r8);
        r14.label = 1;
        r2 = HttpExtKt.g("DORA", Object.class, r17, r15, r20, false, null, r12, r14);
        if (r2 != r5) goto L42;
        return r5;
    L44:
        JSONObject r24 = r16.h(r110);
        Map r25 = MapsKt.toMutableMap(r20);
        if (r21 == false) goto L52;
        IDoraService r26 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r26 == null) goto L49;
        r7 = r26.w0(r24);
    L49:
        if (r7 != null) goto L51;
        r7 = MapsKt.emptyMap();
    L51:
        r25.putAll(r7);
    L52:
        r14.label = 2;
        r2 = HttpExtKt.k("DORA", Object.class, r17, r24, null, r25, false, null, r12, null, r14, 528);
        if (r2 != r5) goto L55;
        return r5;
    L19:
        RequestContext r27 = new RequestContext();
        ((BaseRequestContext) r27).timeout_connect = r22.longValue();
        ((BaseRequestContext) r27).timeout_read = r22.longValue();
        ((BaseRequestContext) r27).timeout_write = r22.longValue();
        ((BaseRequestContext) r27).protect_timeout = r22.longValue();
        ((BaseRequestContext) r27).socket_connect_timeout = r22.longValue();
        ((BaseRequestContext) r27).socket_read_timeout = r22.longValue();
        ((BaseRequestContext) r27).socket_write_timeout = r22.longValue();
        r12 = r27;
    L7:
        r3 = new DoraNetworkRequestMethod$executeRequest$1(r16, r23);
        goto L8
    }
}
