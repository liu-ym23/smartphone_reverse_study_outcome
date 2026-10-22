package com.obric.aikernel.model.cloud.common;

import android.content.Context;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.model.cloud.coze.CozeModelRequest;
import com.obric.aikernel.model.cloud.fa.FaModelRequest;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.service.session.ApiRequestSession;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class CloudRequestConfigs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CloudRequestConfigs f4631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function5<Context, String, String, RequestParams, com.obric.aikernel.b, CozeModelRequest> f4632b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function5<Context, String, String, RequestParams, com.obric.aikernel.b, x7.b> f4633c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Function5<Context, String, String, RequestParams, com.obric.aikernel.b, FaModelRequest> f4634d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, Map<String, Function5<Context, String, String, RequestParams, com.obric.aikernel.b, CloudModelRequest>>> f4635e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, ? extends Map<String, ? extends Function5<? super Context, ? super String, ? super String, ? super RequestParams, ? super com.obric.aikernel.b, ? extends CloudModelRequest>>> f4636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Set<String> f4637g;

    static {
        f4631a = new CloudRequestConfigs();
        CloudRequestConfigs$cozeRequestBuilder$1 r10 = CloudRequestConfigs$cozeRequestBuilder$1.INSTANCE;
        f4632b = r10;
        CloudRequestConfigs$modelCenterRequestBuilder$1 r11 = CloudRequestConfigs$modelCenterRequestBuilder$1.INSTANCE;
        f4633c = r11;
        CloudRequestConfigs$faRequestBuilder$1 r12 = CloudRequestConfigs$faRequestBuilder$1.INSTANCE;
        f4634d = r12;
        Map<String, Map<String, Function5<Context, String, String, RequestParams, com.obric.aikernel.b, CloudModelRequest>>> r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("coze_common_server", MapsKt.mapOf(TuplesKt.to("v_default", r10))), TuplesKt.to("vlm_caption", MapsKt.mapOf(new Pair[]{TuplesKt.to("", null), TuplesKt.to("v_default", r11)})), TuplesKt.to("vlm_tag", MapsKt.mapOf(new Pair[]{TuplesKt.to("", null), TuplesKt.to("v_default", r11)})), TuplesKt.to("slm_summarize", MapsKt.mapOf(TuplesKt.to("v_default", r12))), TuplesKt.to("picture_classify", MapsKt.mapOf(TuplesKt.to("v_default", r11)))});
        f4635e = r13;
        f4636f = r13;
        f4637g = SetsKt.emptySet();
        s7.e.a("cloud_slm_biz_mapping_v2", AnonymousClass1.INSTANCE);
    }

    private CloudRequestConfigs() {
    }

    public static final /* synthetic */ void a(CloudRequestConfigs r10) {
        r10.g();
    }

    private final boolean e(String r10, RequestParams r11, boolean r12) {
        boolean r13 = r11.getBackend().getBoolean(IdlKeys.Args_UseCloud);
        boolean r14 = r11.getBackend().getBoolean("useCloud");
        boolean r15 = r11.getBackend().getBoolean("forceRunPackage");
        if (r13 == true) goto L8;
        if (r14 == false) goto L7;
        if (r15 == false) goto L8;
    L7:
        boolean r16 = false;
    L10:
        if (f4637g.contains(r10) == false) goto L15;
        if (r12 == true) goto L13;
    L14:
        boolean r17 = true;
    L16:
        if (r16 == true) goto L21;
        if (r17 == true) goto L21;
        if (r11.getBackend().containsKey("cloud_research_model") == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        if (Intrinsics.areEqual(e8.a.h(r11.getBackend()), IdlKeys.Method_RunBiz) == true) goto L14;
    L15:
        r17 = false;
    L8:
        r16 = true;
        goto L10
    }

    static /* synthetic */ boolean f(CloudRequestConfigs r10, String r11, RequestParams r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = true;
    L6:
        return r10.e(r11, r12, r13);
    }

    private final void g() {
        LinkedHashSet r10 = new LinkedHashSet();
        LinkedHashMap r11 = new LinkedHashMap();
        r11.putAll(f4635e);
        s7.b r12 = AppSettingsManager.INSTANCE.getCloudSlmInterceptorSetting();
        s7.a[] r13 = r12.b();
        int r14 = r13.length;
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L6;
        s7.a r16 = r13[r15];
        final int r17 = r16.a();
        Function5<Context, String, String, RequestParams, com.obric.aikernel.b, x7.b> r18 = new CloudRequestConfigs$refreshRequestBuilderMap$1$1$1$builderWithArgs$1(r17);
        r11.put(r16.b(), MapsKt.mapOf(TuplesKt.to("", r18)));
        r10.add(r16.b());
        r15 = r15 + 1;
        goto L4
    L6:
        Iterator<T> r19 = r12.a().iterator();
    L8:
        if (r19.hasNext() == false) goto L10;
        String r20 = (String) r19.next();
        r11.put(r20, MapsKt.mapOf(TuplesKt.to("", f4634d)));
        r10.add(r20);
        goto L8
    L10:
        f4636f = r11;
        f4637g = r10;
    }

    public final CloudModelRequest b(Context r10, String r11, RequestParams r12, com.obric.aikernel.b r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bizName");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (f(this, r11, r12, false, 4, null) == true) goto L5;
        return null;
    L5:
        String r14 = r12.getBackend().getString("version");
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        String r15 = r14;
        ApiRequestSession.a r16 = new ApiRequestSession.a(r13, r12, CloudRequestConfigs$buildCloudRequest$cb$1.INSTANCE);
        Map<String, ? extends Function5<? super Context, ? super String, ? super String, ? super RequestParams, ? super com.obric.aikernel.b, ? extends CloudModelRequest>> r17 = f4636f.get(r11);
        if (r17 == null) goto L17;
        if (r17.containsKey(r15) == false) goto L13;
        Function5 r18 = r17.get(r15);
    L14:
        Function5 r19 = r18;
        if (r19 == null) goto L17;
    L19:
        Function5<Context, String, String, RequestParams, com.obric.aikernel.b, x7.b> r20 = r19;
    L21:
        if (r20 != null) goto L23;
        return null;
    L23:
        return r20.invoke(r10, r11, r15, r12, r16);
    L13:
        r18 = r17.get("v_default");
    L17:
        if (r12.getBackend().containsKey("cloud_research_model") == false) goto L20;
        r19 = f4633c;
        goto L19
    L20:
        r20 = null;
        goto L21
    }

    public final PackageResource c(String r10, RequestParams r11) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        Intrinsics.checkNotNullParameter(r11, "params");
        String r12 = r11.getBackend().getString("version");
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        String r13 = r12;
        if (e(r10, r11, false) == true) goto L10;
        return null;
    L10:
        return new PackageResource(r10, 1, 2, r13, 2);
    }

    public final String d() {
        return "/cloud/os/api/ai/common";
    }
}
