package com.obric.memorydata.middleware.impl.network.rpc;

import android.net.Uri;
import android.util.Log;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.crash.Ensure;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.RpcRequestModifier;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.transport.TransportRequest;
import com.bytedance.rpc.transport.TransportResult;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.BackgroundNetworkMode;
import com.obric.memorydata.middleware.api.settings.BackgroundOsResourceOptimizeSettings;
import com.obric.memorydata.middleware.api.settings.NetworkInterceptConfig;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u000289B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J?\u0010\u001c\u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016¢\u0006\u0002\u0010'JL\u0010(\u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020#2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0-2\u0006\u0010&\u001a\u00020\tH\u0016J,\u0010.\u001a\u00020\u001a2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020\tH\u0016J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010)\u001a\u0002022\u0006\u0010\u0013\u001a\u000203H\u0016J$\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010-H\u0002¨\u0006:"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/GlobalRpcInterceptor;", "Lcom/bytedance/rpc/callback/RpcInterceptor;", "Lcom/bytedance/rpc/transport/TransportResultInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "shouldEncrypt", "", "url", "", "encryptTypedByteArray", "Lcom/bytedance/retrofit2/mime/TypedByteArray;", "originBody", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "isRequestAlreadyEncrypted", "shouldBlockByStrictNetworkPolicy", Ext.KEY_REQUEST, "Lcom/bytedance/retrofit2/client/Request;", "isNetworkWhiteListed", "config", "Lcom/obric/memorydata/middleware/api/settings/NetworkInterceptConfig;", "requestPath", "reportStrictNetworkPolicyBlockedException", "", "buildNetworkPolicyBlockedResponse", "preHandle", "serviceClass", "Ljava/lang/Class;", "method", "Ljava/lang/reflect/Method;", "parameters", "", "", "modifier", "Lcom/bytedance/rpc/RpcRequestModifier;", "operationType", "(Ljava/lang/Class;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lcom/bytedance/rpc/RpcRequestModifier;Ljava/lang/String;)Z", "postHandle", "result", "resultReset", "Ljava/lang/ThreadLocal;", "headers", "", "exceptionHandle", "error", "Lcom/bytedance/rpc/RpcException;", "interceptResult", "Lcom/bytedance/rpc/transport/TransportResult;", "Lcom/bytedance/rpc/transport/TransportRequest;", "transportHeaders", "", "Lcom/bytedance/retrofit2/client/Header;", "map", "Companion", "StrictNetworkPolicyBlockedException", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalRpcInterceptor implements Interceptor, RpcInterceptor, TransportResultInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f11781b = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/GlobalRpcInterceptor$StrictNetworkPolicyBlockedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "<init>", "(Ljava/lang/String;)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class StrictNetworkPolicyBlockedException extends RuntimeException {
        public StrictNetworkPolicyBlockedException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/GlobalRpcInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "ENCRYPT_URLS", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11780a = new a(null);
        f11781b = CollectionsKt.listOf(new String[]{"https://ofa.obriccloud.com/explore/api/o_memory/", "https://ofa.obriccloud.com/explore/client/push_client_memory_data", "https://ofa.obriccloud.com/explore/chat/completion", "https://ofa.obriccloud.com/explore/chat/completion/stream", "https://ofa.obriccloud.com/api/v1/chat/completions", "https://ofa.obriccloud.com/ocean/device_intelligence/chat", "https://ofa.obriccloud.com/mcp_hub_proxy/api/v1/weather/info", "https://ofa.obriccloud.com/explore/proactive/user_feedback"});
    }

    public GlobalRpcInterceptor() {
    }

    private final TypedByteArray a(TypedByteArray r5) {
        com.obric.memorydata.middleware.api.b.a r4 = com.obric.memorydata.middleware.api.b.a.f11604a;
        byte[] r0 = r5.getBytes();
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        byte[] r6 = r4.a(r0);
        if (r6 != null) goto L5;
        return null;
    L5:
        return new TypedByteArray(r5.mimeType(), r6, new String[]{r5.fileName()});
    }

    private final List<Header> a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        List<Header> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        Iterator r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        GlobalRpcInterceptor r5 = (GlobalRpcInterceptor) ZeusTransformUtils.preCheckCast(this, GlobalRpcInterceptor.class, "com.obric.memorydata.plugin");
        r0.add(new Header(r3, r4));
    L8:
        return r0;
    }

    private final boolean a(Request r15) {
        SettingsManager r0 = SettingsManager.INSTANCE;
        Object r7 = new BackgroundOsResourceOptimizeSettings(false, null, null, 7, null);
        String r1 = r0.getSettingsStr(SettingsManager.KEY_BACKGROUND_OS_RESOURCE_OPTIMIZE);
        Object r2 = null;
        if (r1 != null) goto L24;
    L9:
        if (r2 == null) goto L12;
        r7 = r2;
    L12:
        BackgroundOsResourceOptimizeSettings r3 = (BackgroundOsResourceOptimizeSettings) ZeusTransformUtils.preCheckCast(r7, BackgroundOsResourceOptimizeSettings.class, "com.obric.memorydata.plugin");
        int r4 = BackgroundNetworkMode.INSTANCE.normalize(r3.getBackgroundNetworkModeConfig().getMode());
        if (r3.getEnable() == true) goto L15;
    L23:
        return false;
    L15:
        if (r4 != 2) goto L23;
        if (a(r15, r3.getNetworkInterceptConfig()) == false) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "strict network policy allow white list request url: " + r15.getHost() + r15.getPath(), false, 4, null);
        return false;
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "strict network policy block request url: " + r15.getHost() + r15.getPath(), null, 4, null);
        c(r15);
        return true;
    L24:
        r2 = r0.getGSON().fromJson(r1, BackgroundOsResourceOptimizeSettings.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    private final boolean a(Request r8, NetworkInterceptConfig r9) {
        if (r9.getEnable() == true) goto L5;
        return false;
    L5:
        String r0 = r8.getHost();
        if (r0 != null) goto L8;
    L12:
        Uri r1 = az.a(r8.getUrl());
        if (r1 == null) goto L15;
        r0 = r1.getHost();
    L16:
        if (r0 != null) goto L18;
        r0 = "";
    L18:
        String r7 = b(r8);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9.getNetworkHostWhiteList(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L21;
    L23:
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L22;
        if (StringsKt.equals((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), r0, true) == false) goto L25;
        boolean r12 = true;
    L29:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r9.getNetworkPathWhiteList(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L32;
    L34:
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L33;
        if (StringsKt.startsWith$default(r7, (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L36;
        boolean r15 = true;
    L40:
        if (r12 == true) goto L43;
        if (r15 == true) goto L43;
        return false;
    L43:
        return true;
    L33:
        r15 = false;
        goto L40
    L32:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L34;
    L22:
        r12 = false;
        goto L29
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L15:
        r0 = null;
        goto L16
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L18;
        goto L12
    }

    private final boolean a(String r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(f11781b, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final String b(Request r4) {
        String r3 = r4.getPath();
        String r0 = null;
        if (r3 != null) goto L5;
    L9:
        Uri r5 = az.a(r4.getUrl());
        if (r5 == null) goto L12;
        r0 = r5.getPath();
    L12:
        if (r0 != null) goto L15;
        return "";
    L15:
        return r0;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L9;
        return r3;
    }

    private final boolean b(String r1) {
        Uri r0 = az.a(r1);
        if (r0 == null) goto L5;
        String r2 = r0.getQueryParameter("request_encrypt");
    L7:
        return Boolean.parseBoolean(r2);
    L5:
        r2 = null;
        goto L7
    }

    private final SsResponse<?> c(String r10) {
        String r0 = new JSONObject().put("code", 403).put("message", "Blocked by strict memory network policy").toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        byte[] r1 = r0.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r1, "getBytes(...)");
        TypedByteArray r9 = new TypedByteArray("application/json", r1, new String[0]);
        Response r2 = new Response(r10, 403, "Blocked by strict memory network policy", CollectionsKt.emptyList(), (TypedInput) ZeusTransformUtils.preCheckCast(r9, TypedInput.class, "com.obric.memorydata.plugin"));
        SsResponse<?> r11 = SsResponse.error((TypedInput) ZeusTransformUtils.preCheckCast(r9, TypedInput.class, "com.obric.memorydata.plugin"), r2);
        Intrinsics.checkNotNullExpressionValue(r11, "error(...)");
        return r11;
    }

    private final void c(Request r6) {
        String r5 = r6.getHost();
        String r0 = "";
        String r2 = null;
        if (r5 != null) goto L5;
    L9:
        Uri r7 = az.a(r6.getUrl());
        if (r7 == null) goto L12;
        r5 = r7.getHost();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        String r3 = r6.getPath();
        if (r3 != null) goto L18;
    L24:
        Uri r4 = az.a(r6.getUrl());
        if (r4 == null) goto L27;
        r2 = r4.getPath();
    L27:
        if (r2 == null) goto L30;
        r0 = r2;
    L30:
        String r8 = "strict network policy blocked request, method=" + r6.getMethod() + ", host=" + r5 + ", path=" + r0;
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(new StrictNetworkPolicyBlockedException(r8), Throwable.class, "com.obric.memorydata.plugin"), r8);
        return;
    L18:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L24;
        r0 = r3;
        goto L30
    L12:
        r5 = null;
        goto L13
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L15;
        goto L9
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public void exceptionHandle(Class<?> r1, Method r2, RpcException r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "serviceClass");
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "error");
        Intrinsics.checkNotNullParameter(r4, "operationType");
        Log.e("GlobalRpcInterceptor", "method: " + r2.getName() + ", error: " + r3);
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r18) {
        Interceptor.Chain r1 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r18, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "chain");
        com.obric.memorydata.middleware.impl.network.rpc.a r3 = com.obric.memorydata.middleware.impl.network.rpc.a.f11782a;
        Request r4 = r1.request();
        Intrinsics.checkNotNullExpressionValue(r4, "request(...)");
        Request r5 = r3.a(r4);
        String r6 = r5.getUrl();
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "PowerChecker: network policy not satisfied, try request url: " + r5.getHost() + r5.getPath(), null, 4, null);
        if (a(r5) == false) goto L8;
        Intrinsics.checkNotNull(r6);
        return c(r6);
    L8:
        boolean r7 = true;
        String r8 = f.a(r6, r5.isAddCommonParam(), r5.getMetrics(), new Object[]{r5.getBody()});
        Request.Builder r9 = r5.newBuilder().url(r8).headers(r5.getHeaders());
        Intrinsics.checkNotNull(r8);
        boolean r10 = b(r8);
        String r11 = r5.getHost() + r5.getPath();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "start request url " + r11, false, 4, null);
        if (a(r8) == false) goto L16;
        if (r10 == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r5.getBody(), TypedByteArray.class) == false) goto L16;
        TypedOutput r12 = r5.getBody();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
        TypedByteArray r0 = a((TypedByteArray) ZeusTransformUtils.preCheckCast(r12, TypedByteArray.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L16;
        r9.method(r5.getMethod(), (TypedOutput) ZeusTransformUtils.preCheckCast(r0, TypedOutput.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "encrypt body for url " + r5.getPath(), false, 4, null);
        boolean r2 = true;
    L17:
        if (r10 == true) goto L21;
        if (r2 == true) goto L21;
        boolean r13 = false;
    L22:
        Uri r14 = az.a(r8);
        TypedInput r15 = null;
        if (r14 == null) goto L25;
        Uri r16 = az.a(r14, MapsKt.mapOf(TuplesKt.to("request_encrypt", Boolean.valueOf(r13))));
    L26:
        r9.url(String.valueOf(r16));
        Request r17 = r9.build();
        Intrinsics.checkNotNullExpressionValue(r17, "build(...)");
        SsResponse<?> r19 = r1.proceed(r17);
        JSONObject r20 = new JSONObject();
        r20.put("api_name", r11);
        r20.put("errorCode", r19.raw().getStatus());
        r20.put(DTraitConstant.ERROR, r19.raw().message());
        Tracker.INSTANCE.reportEvent("memory_network_request_event", r20);
        List<Header> r21 = r17.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r21, "getHeaders(...)");
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r22.hasNext() == false) goto L32;
        Object r23 = r22.next();
        if (StringsKt.equals(((Header) ZeusTransformUtils.preCheckCast(r23, Header.class, "com.obric.memorydata.plugin")).getName(), "Accept", true) == false) goto L28;
    L33:
        Header r24 = (Header) ZeusTransformUtils.preCheckCast(r23, Header.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L36;
        String r25 = r24.getValue();
    L37:
        if (r25 != null) goto L39;
    L41:
        r7 = false;
    L42:
        if (r2 == false) goto L56;
        if (r19.isSuccessful() == false) goto L56;
        if (r7 == true) goto L56;
        Object r26 = r19.body();
        if (ZeusTransformUtils.instanceOf(r26, TypedInput.class) == false) goto L49;
        r15 = (TypedInput) ZeusTransformUtils.preCheckCast(r26, TypedInput.class, "com.obric.memorydata.plugin");
    L49:
        if (r15 == null) goto L56;
        com.obric.memorydata.middleware.api.b.a r27 = com.obric.memorydata.middleware.api.b.a.f11604a;
        InputStream r28 = r15.in();
        Intrinsics.checkNotNullExpressionValue(r28, "in(...)");
        byte[] r29 = r27.b(ByteStreamsKt.readBytes(r28));
        if (r29 == null) goto L54;
        TypedByteArray r30 = new TypedByteArray(r15.mimeType(), r29, new String[0]);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "decrypt TypedInput response for url " + r17.getPath(), false, 4, null);
        SsResponse<?> r31 = SsResponse.success(r30, r19.raw());
        com.obric.memorydata.middleware.impl.network.rpc.a r32 = com.obric.memorydata.middleware.impl.network.rpc.a.f11782a;
        Intrinsics.checkNotNull(r31);
        return r32.a(r1, r17, r31);
    L54:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "decrypt body failed for url: " + r17.getPath(), null, 4, null);
        Ensure.ensureNotReachHere("decrypt body failed for url " + r17.getPath() + ' ');
    L56:
        if (r19.isSuccessful() == true) goto L58;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GlobalRpcInterceptor", "request failed for url: " + r17.getUrl() + ", response: " + r19.raw().getStatus() + " - " + r19.raw().message(), null, 4, null);
    L58:
        com.obric.memorydata.middleware.impl.network.rpc.a r33 = com.obric.memorydata.middleware.impl.network.rpc.a.f11782a;
        Intrinsics.checkNotNull(r19);
        return r33.a(r1, r17, r19);
    L39:
        if (StringsKt.equals(r25, "text/event-stream", true) == false) goto L41;
    L36:
        r25 = null;
        goto L37
    L32:
        r23 = null;
        goto L33
    L25:
        r16 = null;
    L21:
        r13 = true;
    L16:
        r2 = false;
        goto L17
    }

    @Override // com.bytedance.rpc.transport.TransportResultInterceptor
    public void interceptResult(TransportResult r2, TransportRequest r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        if (r2.getData() != null) goto L5;
        return;
    L5:
        a(r2.getHeaders());
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public boolean postHandle(Class<?> r2, Method r3, Object r4, ThreadLocal<?> r5, Map<String, String> r6, String r7) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "serviceClass");
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "resultReset");
        Intrinsics.checkNotNullParameter(r1, "headers");
        Intrinsics.checkNotNullParameter(r7, "operationType");
        return true;
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public boolean preHandle(Class<?> r1, Method r2, Object[] r3, RpcRequestModifier r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "serviceClass");
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "parameters");
        Intrinsics.checkNotNullParameter(r4, "modifier");
        Intrinsics.checkNotNullParameter(r5, "operationType");
        if (AppContext.INSTANCE.isLogin() == true) goto L5;
    L10:
        return true;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getToken(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r4.addHeader("X-Tt-Token", AppContext.INSTANCE.getToken());
        r4.addHeader("Sdk-Version", "2");
        goto L10
    L7:
        r0 = false;
        goto L8
    }
}
