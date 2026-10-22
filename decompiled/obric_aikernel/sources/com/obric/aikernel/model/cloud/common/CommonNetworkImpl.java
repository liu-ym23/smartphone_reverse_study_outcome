package com.obric.aikernel.model.cloud.common;

import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.aikernel.api.security.TlsBootstrapState;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o4.a0;
import o4.e0;
import o4.f;
import o4.g;
import o4.g0;
import o4.h;
import o4.m;
import o4.q;
import o4.t;
import o4.w;
import okhttp3.v;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonNetworkImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonNetworkImpl f4638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f4639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e f4640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f4641d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lazy f4642e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f4643f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f4644g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f4645h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f4646i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final q4.a f4647j = null;

    public interface IApi {
        @h
        com.bytedance.retrofit2.b<String> doGet(@g0 String r10, @o4.a boolean r11, @a0 Map<String, String> r12, @m Map<String, String> r13);

        @t
        com.bytedance.retrofit2.b<String> doPost(@g0 String r10, @a0 Map<String, String> r11, @o4.b Object r12, @m Map<String, String> r13);

        @t
        @g
        com.bytedance.retrofit2.b<String> doPost(@g0 String r10, @a0 Map<String, String> r11, @f(encode = true) Map<String, String> r12, @m Map<String, String> r13);

        @t
        com.bytedance.retrofit2.b<String> doPostV2(@g0 String r10, @a0 Map<String, String> r11, @o4.b y r12, @m Map<String, String> r13);

        @q
        @t
        com.bytedance.retrofit2.b<String> doUpload(@g0 String r10, @w Map<String, v.c> r11, @m Map<String, String> r12);

        @e0
        @t
        com.bytedance.retrofit2.b<r4.e> streamPull(@g0 String r10, @a0 Map<String, String> r11, @o4.b Object r12, @m Map<String, String> r13);
    }

    static {
        f4638a = new CommonNetworkImpl();
        f4641d = LazyKt.lazy(CommonNetworkImpl$apiRetrofit$2.INSTANCE);
        f4642e = LazyKt.lazy(CommonNetworkImpl$boeApiRetrofit$2.INSTANCE);
        f4643f = LazyKt.lazy(CommonNetworkImpl$modelCenterRetrofit$2.INSTANCE);
        f4644g = LazyKt.lazy(CommonNetworkImpl$slmTwoStepRetrofit$2.INSTANCE);
        f4645h = LazyKt.lazy(CommonNetworkImpl$slmTwoStepApi$2.INSTANCE);
        f4646i = LazyKt.lazy(CommonNetworkImpl$modelCenterApi$2.INSTANCE);
        f4647j = b.f4653c;
    }

    private CommonNetworkImpl() {
    }

    public static /* synthetic */ com.bytedance.retrofit2.a0 a(q4.a.InterfaceC0283a r10) {
        return r(r10);
    }

    public static final /* synthetic */ IApi b(CommonNetworkImpl r10) {
        return r10.n();
    }

    public static final /* synthetic */ IApi c(CommonNetworkImpl r10) {
        return r10.q();
    }

    private final IApi e() {
        return (IApi) f4641d.getValue();
    }

    private final IApi g() {
        return (IApi) f4642e.getValue();
    }

    private final Map<String, String> i() {
        return new LinkedHashMap();
    }

    private final IApi n() {
        return (IApi) f4643f.getValue();
    }

    private final IApi q() {
        return (IApi) f4644g.getValue();
    }

    private static final com.bytedance.retrofit2.a0 r(q4.a.InterfaceC0283a r10) {
        Map<String, String> r11 = f4638a.k();
        n4.c r12 = r10.a();
        n4.c.a r13 = r12.O();
        j r14 = new j(r12.G());
        Iterator<Map.Entry<String, String>> r15 = r11.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Map.Entry<String, String> r16 = r15.next();
        r14.b(r16.getKey(), r16.getValue());
        goto L4
    L6:
        Map<String, String> r17 = f4638a.i();
        ArrayList r18 = new ArrayList();
        r18.addAll(r12.v());
        Iterator<Map.Entry<String, String>> r19 = r17.entrySet().iterator();
    L8:
        if (r19.hasNext() == false) goto L10;
        Map.Entry<String, String> r20 = r19.next();
        r18.add(new n4.b(r20.getKey(), r20.getValue()));
        goto L8
    L10:
        r13.f(r14.c());
        return r10.c(r13.b(r18).a());
    }

    public final IApi d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "baseUrl");
        com.obric.aikernel.api.security.e r11 = com.obric.aikernel.api.b.f4431a.j();
        if (r11.d(r10) == false) goto L6;
        Object r12 = RetrofitUtils.e(r10, CollectionsKt.listOf(f4647j), b3.a.f()).e(IApi.class);
        Intrinsics.checkNotNullExpressionValue(r12, "createSsRetrofit(\n      ….create(IApi::class.java)");
        return (IApi) r12;
    L6:
        TlsBootstrapState r13 = r11.c(r10);
        r11.b(r10);
        throw new IllegalAccessException("request " + r10 + " but tls not ready. tlsState=" + r13);
    }

    public final String f() {
        return "https://os-boe.bytedance.net";
    }

    public final e h() {
        if (f4639b != null) goto L5;
        f4639b = l(e());
    L5:
        AIKLog.INSTANCE.i("CommonNetworkImpl", "getCommonApi " + e());
        e r10 = f4639b;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final e j() {
        if (f4640c != null) goto L5;
        f4640c = l(g());
    L5:
        e r10 = f4640c;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    public final Map<String, String> k() {
        HashMap r10 = new HashMap();
        AppContext r11 = AppContext.INSTANCE;
        r10.put("aid", String.valueOf(r11.getAid()));
        r10.put("channel", r11.getChannel());
        r10.put("app_version", r11.getVersionName());
        r10.put("version_code", String.valueOf(r11.getVersionCode()));
        r10.put("update_version_code", String.valueOf(r11.getUpdateVersionCode()));
        r10.put("release_build", r11.getBuildInfo());
        return r10;
    }

    public final e l(final IApi r10) {
        Intrinsics.checkNotNullParameter(r10, "retrofit");
        return new CommonNetworkImpl$getHttpApi$1(r10);
    }

    public final e m() {
        return (e) f4646i.getValue();
    }

    public final String o() {
        return "https://os.oceancloudapi.com";
    }

    public final e p() {
        return (e) f4645h.getValue();
    }
}
