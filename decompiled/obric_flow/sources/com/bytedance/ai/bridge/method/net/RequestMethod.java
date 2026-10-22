package com.bytedance.ai.bridge.method.net;

import android.text.TextUtils;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.network.AbsRequestMethodIDL;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.lynx.jsbridge.LynxResourceModule;
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
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/net/RequestMethod;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL;", "<init>", "()V", "", "rawData", "", "contentType", "normalizeRequestData", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "data", "toJsonString", "(Ljava/lang/Object;)Ljava/lang/String;", "toQueryString", "value", "encodeURIComponent", "(Ljava/lang/String;)Ljava/lang/String;", "Lo1/f;", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestResultModel;", "callback", "com/bytedance/ai/bridge/method/net/g", "createResponseCallback", "(Lo1/f;)Lcom/bytedance/ai/bridge/method/net/g;", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;", LynxResourceModule.PARAMS_KEY, "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/network/AbsRequestMethodIDL$RequestParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/net/f", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRequestMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestMethod.kt\ncom/bytedance/ai/bridge/method/net/RequestMethod\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,220:1\n216#2,2:221\n*S KotlinDebug\n*F\n+ 1 RequestMethod.kt\ncom/bytedance/ai/bridge/method/net/RequestMethod\n*L\n149#1:221,2\n*E\n"})
public final class RequestMethod extends AbsRequestMethodIDL {
    private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_TYPE_KEY_LOWER = "content-type";
    public static final f Companion = null;
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    private static final String TAG = "RequestMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.RequestMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.net.RequestMethod$handle$1", f = "RequestMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsRequestMethodIDL.RequestParamModel f1869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RequestMethod f1870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o1.f f1871c;
        public final /* synthetic */ AbsAppletRequestMethodIDL.RequestMethodType d;
        public final /* synthetic */ String e;

        public AnonymousClass1(AbsRequestMethodIDL.RequestParamModel r5, RequestMethod r10, o1.f r11, AbsAppletRequestMethodIDL.RequestMethodType r12, String r13, Continuation r14) {
            this.f1869a = r5;
            this.f1870b = r10;
            this.f1871c = r11;
            this.d = r12;
            this.e = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f1869a, this.f1870b, this.f1871c, this.d, this.e, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r10);
            Map<String, String> r11 = this.f1869a.getHeader();
            LinkedHashMap r5 = new LinkedHashMap();
            if (r11 == null) goto L22;
            Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L22;
            Map.Entry<String, String> r13 = r12.next();
            CharSequence r14 = r13.getValue();
            if (r14 != null) goto L11;
            String r15 = "";
        L18:
            if (com.bytedance.ai.utils.c.l(r13.getKey()) == false) goto L6;
            if (r15.length() <= 0) goto L6;
            r5.put(r13.getKey(), r15);
            goto L6
        L11:
            if ((r14 instanceof Map) == false) goto L14;
            r15 = new JSONObject((Map) r14).toString();
            goto L18
        L14:
            if ((r14 instanceof List) == false) goto L16;
            r15 = new JSONArray((Collection) r14).toString();
            goto L18
        L16:
            r15 = r14.toString();
        L22:
            String r16 = "application/json";
            if (r5.containsKey(RequestMethod.CONTENT_TYPE_KEY) == false) goto L25;
        L27:
            IHostNetworkDepend r17 = k5.d.f18602c;
            if (r17 != null) goto L30;
            r17 = new com.bytedance.sdk.xbridge.cn.auth.g(2);
        L30:
            IHostNetworkDepend r18 = r17;
            g r19 = RequestMethod.access$createResponseCallback(this.f1870b, this.f1871c);
            String r110 = (String) r5.get(RequestMethod.CONTENT_TYPE_KEY);
            if (r110 != null) goto L35;
            r110 = (String) r5.get(RequestMethod.CONTENT_TYPE_KEY_LOWER);
            if (r110 != null) goto L35;
        L36:
            Object r20 = RequestMethod.access$normalizeRequestData(this.f1870b, this.f1869a.getData(), r16);
            int r111 = this.d.ordinal();
            if (r111 != 0) goto L39;
            com.lynx.tasm.utils.a.n(this.e, r5, r19, this.f1869a.getDataType(), r18, true, false);
        L50:
            return Unit.INSTANCE;
        L39:
            if (r111 != 1) goto L41;
            com.lynx.tasm.utils.a.h(this.e, r5, r16, r20, r19, this.f1869a.getDataType(), r18, true, false);
            goto L50
        L41:
            if (r111 != 2) goto L43;
            com.lynx.tasm.utils.a.o(this.e, r5, r16, r20, r19, this.f1869a.getDataType(), r18, true, false);
            goto L50
        L43:
            if (r111 != 3) goto L50;
            com.lynx.tasm.utils.a.g(this.e, r5, RequestMethod.access$createResponseCallback(this.f1870b, this.f1871c), this.f1869a.getDataType(), r18, true, false);
        L35:
            r16 = r110;
            goto L36
        L25:
            if (r5.containsKey(RequestMethod.CONTENT_TYPE_KEY_LOWER) == true) goto L27;
            r5.put(RequestMethod.CONTENT_TYPE_KEY, "application/json");
            goto L27
        }
    }

    static {
        Companion = new f();
    }

    public RequestMethod() {
    }

    public static final /* synthetic */ g access$createResponseCallback(RequestMethod r5, o1.f r10) {
        return r5.createResponseCallback(r10);
    }

    public static final /* synthetic */ Object access$normalizeRequestData(RequestMethod r5, Object r10, String r11) {
        return r5.normalizeRequestData(r10, r11);
    }

    public static /* synthetic */ CharSequence b(RequestMethod r5, Pair r10) {
        return toQueryString$lambda$1(r5, r10);
    }

    private final g createResponseCallback(o1.f r5) {
        return new g(r5);
    }

    private final String encodeURIComponent(String r5) {
        return StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(URLEncoder.encode(r5, StandardCharsets.UTF_8.name()), "+", "%20"), "%21", XPath.NOT), "%27", "'"), "%28", "("), "%29", ")"), "%7E", "~");
    }

    private final Object normalizeRequestData(Object r5, String r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof String) == false) goto L8;
        return r5;
    L8:
        if ((r5 instanceof byte[]) == false) goto L10;
        return r5;
    L10:
        String r11 = StringsKt.trim(StringsKt.X(r10, ";")).toString().toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r11, CONTENT_TYPE_FORM) == false) goto L15;
        return toQueryString(r5);
    L15:
        if (Intrinsics.areEqual(r11, "application/json") == false) goto L19;
        return toJsonString(r5);
    L19:
        if ((r5 instanceof Map) == true) goto L30;
        if ((r5 instanceof JSONObject) == true) goto L30;
        if ((r5 instanceof List) == true) goto L30;
        if ((r5 instanceof JSONArray) == true) goto L30;
        return r5.toString();
    L30:
        return toJsonString(r5);
    }

    private final String toJsonString(Object r5) {
        if (r5 != null) goto L6;
        return "";
    L6:
        if ((r5 instanceof JSONObject) == false) goto L10;
        return ((JSONObject) r5).toString();
    L10:
        if ((r5 instanceof JSONArray) == false) goto L14;
        return ((JSONArray) r5).toString();
    L14:
        if ((r5 instanceof Map) == false) goto L18;
        return new JSONObject((Map) r5).toString();
    L18:
        if ((r5 instanceof List) == false) goto L22;
        return new JSONArray((Collection) r5).toString();
    L22:
        return r5.toString();
    }

    private final String toQueryString(Object r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        ArrayList r5 = new ArrayList();
        if ((r10 instanceof Map) == false) goto L19;
        Iterator r11 = ((Map) r10).entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L30;
        Map.Entry r12 = (Map.Entry) r11.next();
        Object r13 = r12.getKey();
        Object r14 = r12.getValue();
        if (r13 == null) goto L9;
        String r15 = r13.toString();
        if (r14 == null) goto L16;
        String r16 = r14.toString();
        if (r16 == null) goto L16;
    L17:
        r5.add(TuplesKt.to(r15, r16));
    L16:
        r16 = "null";
    L30:
        return CollectionsKt.q(r5, "&", null, null, 0, null, new e(this, 0), 30);
    L19:
        if ((r10 instanceof JSONObject) == false) goto L32;
        JSONObject r17 = (JSONObject) r10;
        Iterator<String> r18 = r17.keys();
    L22:
        if (r18.hasNext() == false) goto L30;
        String r19 = r18.next();
        Object r20 = r17.opt(r19);
        if (r20 == null) goto L27;
        String r21 = r20.toString();
        if (r21 == null) goto L27;
    L28:
        r5.add(TuplesKt.to(r19, r21));
    L27:
        r21 = "null";
        goto L28
    L32:
        return r10.toString();
    }

    private static final CharSequence toQueryString$lambda$1(RequestMethod r5, Pair r10) {
        Intrinsics.checkNotNullParameter(r10, "<destruct>");
        return r5.encodeURIComponent((String) r10.component1()) + '=' + r5.encodeURIComponent((String) r10.component2());
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsRequestMethodIDL.RequestParamModel) r10, r11);
    }

    public void handle(n1.c r13, AbsRequestMethodIDL.RequestParamModel r14, o1.f r15) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        String r5 = r14.getUrl();
        if (TextUtils.isEmpty(r5) == false) goto L6;
        r15.a("url is empty");
        return;
    L6:
        a r16 = AbsAppletRequestMethodIDL.RequestMethodType.f1857a;
        String r10 = r14.getMethod();
        if (r10 != null) goto L9;
        r10 = "GET";
    L9:
        r16.getClass();
        AbsAppletRequestMethodIDL.RequestMethodType r17 = AbsAppletRequestMethodIDL.RequestMethodType.valueOf(r10.toUpperCase());     // Catch: Exception -> L12
    L11:
        AbsAppletRequestMethodIDL.RequestMethodType r11 = r17;
        if (r11 != AbsAppletRequestMethodIDL.RequestMethodType.f1858b) goto L17;
        r15.a("Illegal method " + r14.getMethod());
        return;
    L17:
        AppletRequestMethod.Companion.getClass();
        BuildersKt.launch$default(AppletRequestMethod.access$getScope$cp(), null, null, new AnonymousClass1(r14, this, r15, r11, r5, null), 3, null);
        return;
    L12:
        r17 = AbsAppletRequestMethodIDL.RequestMethodType.f1858b;
        goto L11
    }
}
