package com.obric.memorydata.middleware.impl.network.rpc;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.env.EnvManager;
import com.obric.memorydata.middleware.api.env.NetEnv;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.rpc.AppNetConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u0012\u0010(\u001a\u00020)*\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J\u0012\u0010+\u001a\u00020)*\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J\u0012\u0010,\u001a\u00020)*\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J\f\u0010-\u001a\u00020\u0015*\u00020&H\u0002J\u000e\u0010.\u001a\u00020&2\u0006\u0010%\u001a\u00020&J\u0016\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u000302H\u0002J\u0010\u00103\u001a\u00020\u0015*\u0006\u0012\u0002\b\u000302H\u0002J\u0014\u00104\u001a\u00020&*\u00020&2\u0006\u00105\u001a\u00020\u0005H\u0002J&\u00106\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00107\u001a\u0002082\u0006\u0010%\u001a\u00020&2\n\u00109\u001a\u0006\u0012\u0002\b\u000302R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0010R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/EnvInterceptor;", "", "<init>", "()V", "TAG", "", "X_PICO_ENV_FORCE", "X_PICO_ENV", "ENV_CANARY", "xTTEnv", "netEnv", "Lcom/obric/memorydata/middleware/api/env/NetEnv;", "rpcTTEnv", "spRpcEnv", "featureHeader", "getFeatureHeader", "()Ljava/lang/String;", "featureHeader$delegate", "Lkotlin/Lazy;", "whiteHeaderPath", "", "", "getWhiteHeaderPath", "()Ljava/util/Map;", "whiteHeaderPath$delegate", "interceptHost", "getInterceptHost", "interceptHost$delegate", "interceptHostList", "", "getInterceptHostList", "()Ljava/util/List;", "interceptHostList$delegate", "isAdminMode", "()Z", "isAdminMode$delegate", "hitWhite", Ext.KEY_REQUEST, "Lcom/bytedance/retrofit2/client/Request;", "xUsePPEFlag", "appendOnlineParams", "", "Lcom/bytedance/retrofit2/client/Header;", "appendPPEParams", "appendBOEParams", "shouldIgnore", "interceptRequest", "appendCommonHeader", "headers", "picoEnv", "Lcom/bytedance/retrofit2/SsResponse;", "picoEnvForce", "replaceHeader", "env", "interceptResponse", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", ChatMessage.TYPE_RESPONSE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11783b;
    private static NetEnv c;
    private static String d;
    private static String e;
    private static final Lazy f = null;
    private static final Lazy g = null;
    private static final Lazy h = null;
    private static final Lazy i = null;
    private static final Lazy j = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.network.rpc.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0636a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11784a = null;

        static {
            int[] r0 = new int[NetEnv.values().length];
            r0[NetEnv.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[NetEnv.PPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[NetEnv.BOE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f11784a = r0;
        }
    }

    static {
        f11782a = new a();
        f11783b = EnvManager.INSTANCE.getAdminTTEnvHeader();
        c = EnvManager.INSTANCE.getAdminNetEnv();
        String r0 = EnvManager.INSTANCE.getRpcResponseEnvHeader();
        d = r0;
        e = r0;
        f = LazyKt.lazy($$Lambda$a$KAwiaW13FxBiPQAoaUJPDf7CLnk.INSTANCE);
        g = LazyKt.lazy($$Lambda$a$9i_IL3jDA6GbFNUxAcoyEx7B1hE.INSTANCE);
        h = LazyKt.lazy($$Lambda$a$DEWaL8Dxr8Z4c2QgE0822SkJXM4.INSTANCE);
        i = LazyKt.lazy($$Lambda$a$44LquRrs8mjx4TDAxaulmv1tSu4.INSTANCE);
        j = LazyKt.lazy($$Lambda$a$1gEocT9nI5xw6fGonKBhyOnQLbQ.INSTANCE);
        RunLog.INSTANCE.debug("EnvInterceptor", "init env: X_ENV:" + f11783b + " NET_ENV: " + c + "  RPC_ENV: " + d + "  enableCanary: true ");
    }

    private a() {
    }

    private final Request a(Request r4, String r5) {
        final boolean r3 = Intrinsics.areEqual(r5, "canary");
        List<Header> r0 = r4.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r0, "getHeaders(...)");
        List<Header> r1 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        final Function1 r2 = new $$Lambda$a$ROGbmf9K5VeZeOJWK0fYZKO6TUU(r3);
        r1.removeIf(new $$Lambda$a$9XmV3ISP5RGTlS7epIb5i6anZXA(r2));
        r1.add(new Header("X-TT-Env", r5));
        Request r6 = r4.newBuilder().headers(r1).build();
        Intrinsics.checkNotNullExpressionValue(r6, "let(...)");
        return r6;
    }

    private final String a() {
        return (String) ZeusTransformUtils.preCheckCast(f.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final String a(SsResponse<?> r2) {
        Response r1 = r2.raw();
        if (r1 == null) goto L11;
        Header r3 = r1.getFirstHeader("X-Pico-Env");
        if (r3 == null) goto L11;
        String r4 = r3.getValue();
        if (r4 == null) goto L11;
        String r5 = r4.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
        if (r5 == null) goto L11;
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L11:
        return null;
    }

    private final String a(String r4) {
        return (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.b.a(Boolean.valueOf(StringsKt.startsWith$default(r4, "ppe_", false, 2, null)), "1", null), String.class, "com.obric.memorydata.plugin");
    }

    private final void a(List<Header> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(f11783b, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0 = d;
    L8:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        r3 = true;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        if (StringsKt.equals("canary", r1, true) == false) goto L16;
        r7.add(new Header("X-TT-Env", "canary"));
        return;
    L16:
        if (e() == false) goto L23;
        r7.add(new Header("X-TT-Env", r1));
        String r5 = a(r1);
        if (r5 == null) goto L24;
        r7.add(new Header("X-Use-PPE", r5));
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean a(boolean r3, Header r4) {
        if (StringsKt.equals("X-TT-Env", r4.getName(), true) == false) goto L5;
        return true;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.b.a(Boolean.valueOf(r3), Boolean.valueOf(StringsKt.equals("X-Use-PPE", r4.getName(), true)), false), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        return true;
    L8:
        return false;
    }

    private final Map<String, Boolean> b() {
        return (Map) ZeusTransformUtils.preCheckCast(g.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    private final void b(List<Header> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(f11783b, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0 = d;
    L8:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        r3 = true;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        if (StringsKt.equals("canary", r1, true) == true) goto L17;
        String r5 = a(r1);
        if (r5 == null) goto L17;
        r7.add(new Header("X-Use-PPE", r5));
    L17:
        r7.add(new Header("X-TT-Env", r1));
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final boolean b(SsResponse<?> r1) {
        Response r0 = r1.raw();
        if (r0 == null) goto L7;
        Header r2 = r0.getFirstHeader("x-pico-env-force");
        if (r2 == null) goto L7;
        String r3 = r2.getValue();
    L9:
        return Intrinsics.areEqual(r3, "1");
    L7:
        r3 = null;
        goto L9
    }

    private final boolean b(Request r1) {
        Map<String, Boolean> r0 = b();
        String r2 = r1.getPath();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.containsKey(r2);
    }

    private final String c() {
        return (String) ZeusTransformUtils.preCheckCast(h.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final void c(List<Header> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        String r5 = f11783b;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r3.add(new Header("x-use-boe", "1"));
        r3.add(new Header("X-TT-Env", r5));
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean c(Request r2) {
        if (b(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (d().contains(r2.getHost()) == false) goto L8;
        return false;
    }

    private final List<String> d() {
        return (List) ZeusTransformUtils.preCheckCast(i.getValue(), List.class, "com.obric.memorydata.plugin");
    }

    private final void d(List<Header> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(a(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r7.add(new Header("feature", a()));
    L9:
        if (AppContext.INSTANCE.isLogin() == true) goto L11;
        return;
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getToken(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L14;
        r2 = false;
    L14:
        if (r2 == false) goto L18;
        r7.add(new Header("X-Tt-Token", AppContext.INSTANCE.getToken()));
        r7.add(new Header("Sdk-Version", "2"));
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean e() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(j.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final String f() {
        return EnvManager.INSTANCE.getAdminTTFeatureHeader();
    }

    private static final Map g() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("/pico_video/admin/release_info/list", true), TuplesKt.to("/pico_video/admin/env_info/list", true)});
    }

    private static final String h() {
        return AppNetConfig.INSTANCE.getBaseHost();
    }

    private static final List i() {
        return CollectionsKt.mutableListOf(new String[]{f11782a.c(), "api.obriccloud.com", "os.oceancloudapi.com", "fa.obriccloud.com"});
    }

    private static final boolean j() {
        return AppContext.INSTANCE.isAdminMode();
    }

    public static /* synthetic */ boolean lambda$1gEocT9nI5xw6fGonKBhyOnQLbQ() {
        return j();
    }

    public static /* synthetic */ List lambda$44LquRrs8mjx4TDAxaulmv1tSu4() {
        return i();
    }

    public static /* synthetic */ boolean lambda$9XmV3ISP5RGTlS7epIb5i6anZXA(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Map lambda$9i_IL3jDA6GbFNUxAcoyEx7B1hE() {
        return g();
    }

    public static /* synthetic */ String lambda$DEWaL8Dxr8Z4c2QgE0822SkJXM4() {
        return h();
    }

    public static /* synthetic */ String lambda$KAwiaW13FxBiPQAoaUJPDf7CLnk() {
        return f();
    }

    public static /* synthetic */ boolean lambda$ROGbmf9K5VeZeOJWK0fYZKO6TUU(boolean r0, Header r1) {
        return a(r0, r1);
    }

    public final SsResponse<?> a(Interceptor.Chain r7, Request r8, SsResponse<?> r9) {
        Interceptor.Chain r10 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r7, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "chain");
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_RESPONSE);
        if (c(r8) == false) goto L6;
        return r9;
    L6:
        if (r9.isSuccessful() == true) goto L8;
    L24:
        return r9;
    L8:
        if (c == NetEnv.BOE) goto L24;
        String r0 = a(r9);
        if (r0 != null) goto L13;
        return r9;
    L13:
        if (Intrinsics.areEqual(e, r0) == true) goto L16;
        RunLog.INSTANCE.debug("EnvInterceptor", "save rpc env: " + r0);
        e = r0;
        EnvManager.INSTANCE.saveRpcResponseEnvHeader(r0);
    L16:
        if (b(r9) == false) goto L24;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
        boolean r1 = true;
    L21:
        if (r1 == false) goto L24;
        RunLog.INSTANCE.debug("EnvInterceptor", "force serve env: " + r0);
        d = r0;
        SsResponse<?> r6 = r10.proceed(a(r8, r0));
        Intrinsics.checkNotNullExpressionValue(r6, "proceed(...)");
        return r6;
    L20:
        r1 = false;
        goto L21
    }

    public final Request a(Request r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        if (c(r4) == false) goto L5;
        return r4;
    L5:
        List<Header> r0 = r4.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r0, "getHeaders(...)");
        List<Header> r1 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        d(r1);
        NetEnv r2 = c;
        int r3 = C0636a.f11784a[r2.ordinal()];
        if (r3 != 1) goto L8;
        a(r1);
    L16:
        Request r5 = r4.newBuilder().headers(r1).build();
        Intrinsics.checkNotNullExpressionValue(r5, "build(...)");
        return r5;
    L8:
        if (r3 != 2) goto L10;
        b(r1);
        goto L16
    L10:
        if (r3 != 3) goto L13;
        c(r1);
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
