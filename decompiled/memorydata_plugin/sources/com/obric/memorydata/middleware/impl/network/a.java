package com.obric.memorydata.middleware.impl.network;

import android.content.Context;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.env.EnvManager;
import com.obric.memorydata.middleware.api.env.NetEnv;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00112\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/AppNetInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "PUI_VERSION", "", "PACKAGE_NAME", "puiVersion", "getPuiVersion", "()Ljava/lang/String;", "puiVersion$delegate", "Lkotlin/Lazy;", ObricMemoryConstants.KEY_PACKAGE_NAME, "kotlin.jvm.PlatformType", "getPackageName", "packageName$delegate", "envWhiteList", "", "puiBlackList", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "transformRequest", "Lcom/bytedance/retrofit2/client/Request;", Ext.KEY_REQUEST, "isInWhiteList", "", "url", "isInBlackList", "handleHeaders", "Lcom/bytedance/retrofit2/client/Header;", "headers", "env", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11760b = null;
    private static final Lazy c = null;
    private static final List<String> d = null;
    private static final List<String> e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.network.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0635a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11761a = null;

        static {
            int[] r0 = new int[NetEnv.values().length];
            r0[NetEnv.BOE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f11761a = r0;
        }
    }

    static {
        f11759a = new a();
        f11760b = LazyKt.lazy($$Lambda$a$dnJCijGWsvm6aqXzVotz7DWdkaE.INSTANCE);
        c = LazyKt.lazy($$Lambda$a$3OuiOKM2JCvL2io1VE_3tUey41Q.INSTANCE);
        d = CollectionsKt.emptyList();
        e = CollectionsKt.emptyList();
    }

    private a() {
    }

    private final Request a(Request r5) {
        HttpUrl.Companion r4 = HttpUrl.Companion;
        String r0 = r5.getUrl();
        Intrinsics.checkNotNullExpressionValue(r0, "getUrl(...)");
        HttpUrl r6 = r4.parse(r0);
        if (r6 == null) goto L20;
        HttpUrl.Builder r7 = r6.newBuilder();
        if (r7 == null) goto L20;
        a r1 = f11759a;
        String r2 = r5.getUrl();
        Intrinsics.checkNotNullExpressionValue(r2, "getUrl(...)");
        if (r1.b(r2) == true) goto L9;
        r7.addQueryParameter("pui_version", r1.a());
        r7.addQueryParameter("package_name", r1.b());
    L9:
        HttpUrl r8 = r7.build();
        if (r8 == null) goto L20;
        URL r9 = r8.url();
        if (r9 == null) goto L20;
        String r10 = r9.toString();
        if (r10 == null) goto L20;
        Request.Builder r3 = r5.newBuilder();
        String r11 = r5.getUrl();
        Intrinsics.checkNotNullExpressionValue(r11, "getUrl(...)");
        if (r1.a(r11) == false) goto L18;
        r3.headers(r1.a(r5.getHeaders(), EnvManager.INSTANCE.getAdminTTEnvHeader()));
    L18:
        Request r12 = r3.url(r10).build();
        Intrinsics.checkNotNullExpressionValue(r12, "build(...)");
        return r12;
    L20:
        return r5;
    }

    private final String a() {
        return (String) ZeusTransformUtils.preCheckCast(f11760b.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final List<Header> a(List<Header> r6, String r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        List<Header> r8 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L21;
        boolean r1 = false;
        if (C0635a.f11761a[EnvManager.INSTANCE.getAdminNetEnv().ordinal()] != 1) goto L11;
        Header r9 = new Header("x-use-boe", "1");
    L9:
        r8.add(r9);
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L23;
        r8.add(new Header("X-TT-Env", r7));
        return r8;
    L23:
        return r8;
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L17;
        r9 = new Header("X-Use-PPE", "1");
        goto L9
    L13:
        r10 = false;
    L21:
        return null;
    }

    private final boolean a(String r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private final String b() {
        return (String) ZeusTransformUtils.preCheckCast(c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    private final boolean b(String r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static final String c() {
        return AppContext.INSTANCE.getPuiVersion();
    }

    private static final String d() {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
    }

    public static /* synthetic */ String lambda$3OuiOKM2JCvL2io1VE_3tUey41Q() {
        return d();
    }

    public static /* synthetic */ String lambda$dnJCijGWsvm6aqXzVotz7DWdkaE() {
        return c();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r3) {
        Interceptor.Chain r4 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "chain");
        Request r0 = r4.request();
        Intrinsics.checkNotNull(r0);
        SsResponse<?> r2 = r4.proceed(a(r0));
        Intrinsics.checkNotNullExpressionValue(r2, "proceed(...)");
        return r2;
    }
}
