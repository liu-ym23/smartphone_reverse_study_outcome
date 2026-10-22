package com.obric.aikernel.res.update;

import android.os.Build;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import com.obric.aikernel.res.metadata.controller.MetadataController;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.utils.MemoryUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.u;
import okhttp3.y;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f5112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f5113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.d f5115d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
    }

    public static final class c implements b {
        public c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "version");
            Intrinsics.checkNotNullParameter(r11, "depVersion");
        }

        public /* synthetic */ c(String r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        L8:
            this(r10, r11);
        }
    }

    public static final class d implements b {
        public d(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "version");
            Intrinsics.checkNotNullParameter(r11, "depVersion");
        }
    }

    static {
        new a(null);
    }

    public MetadataRequest(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f5112a = r10;
        this.f5113b = r10.getConfig();
        this.f5114c = String.valueOf(Build.VERSION.SDK_INT);
        this.f5115d = new com.google.gson.d();
    }

    public static final /* synthetic */ Object a(MetadataRequest r10, boolean r11, Map r12, Continuation r13) {
        return r10.h(r11, r12, r13);
    }

    public static final /* synthetic */ Object b(MetadataRequest r10, Continuation r11) {
        return r10.i(r11);
    }

    public static final /* synthetic */ Object c(MetadataRequest r10, Continuation r11) {
        return r10.j(r11);
    }

    public static final /* synthetic */ Object d(MetadataRequest r10, com.google.gson.k r11, Continuation r12) {
        return r10.k(r11, r12);
    }

    public static final /* synthetic */ Object e(MetadataRequest r10, com.google.gson.k r11, Continuation r12) {
        return r10.l(r11, r12);
    }

    public static final /* synthetic */ List f(MetadataRequest r10, com.google.gson.k r11) {
        return r10.m(r11);
    }

    public static final /* synthetic */ Object g(MetadataRequest r10, boolean r11, Map r12, b8.a r13, Continuation r14) {
        return r10.s(r11, r12, r13, r14);
    }

    private final Object h(boolean r10, Map<String, ? extends b> r11, Continuation<? super com.google.gson.k> r12) {
        if ((r12 instanceof MetadataRequest$buildRequestBody$1) == false) goto L7;
        MetadataRequest$buildRequestBody$1 r13 = (MetadataRequest$buildRequestBody$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        String r18 = (String) r13.L$3;
        com.google.gson.k r19 = (com.google.gson.k) r13.L$2;
        com.google.gson.k r110 = (com.google.gson.k) r13.L$1;
        MetadataRequest r20 = (MetadataRequest) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L33:
        r19.p(r18, (String) r15);
        r110.p("app_version", r20.f5113b.getAppConfig().getAppVersion());
        r110.p("uid", r20.f5113b.getAppConfig().getUserId());
        r110.p("channel", r20.f5113b.getAppConfig().getChannel());
        r110.p("device", Build.MODEL);
        r110.p("product_device", Build.DEVICE);
        String r21 = r20.f5113b.getAppConfig().getRegion();
        if (r21 == null) goto L36;
        r110.p("o_region", r21);
    L36:
        r110.p("os_version", r20.f5114c);
        r110.p("mem_size", MemoryUtils.f5219a.c());
        r110.p("project_id", r20.f5113b.getAppConfig().getProjectId());
        r110.p("sem_app_version", r20.f5113b.getAppConfig().getSemAppVersion());
        r110.p(WsConstants.KEY_PLATFORM, "android");
        r110.p("sdk_version", "4.0.0");
        r110.p("feature_engineering_version", "1.0.0");
        com.google.gson.k r22 = (com.google.gson.k) new com.google.gson.d().k("{\n    \"bridge\": \"4.0.0\",\n    \"foundation\": \"4.0.0\",\n    \"libs\": {\n      \"numpy\": \"2.0.0\"\n    },\n    \"vm\": \"" + r20.f5113b.getPyVmVersion() + "\"\n  }", com.google.gson.k.class);
        com.google.gson.k r23 = r22.u("libs");
        Map<String, Set<String>> r111 = r20.f5113b.getPresetLibraries();
        if (r111 == null) goto L42;
        Iterator<Map.Entry<String, Set<String>>> r112 = r111.entrySet().iterator();
    L40:
        if (r112.hasNext() == false) goto L42;
        Map.Entry<String, Set<String>> r24 = r112.next();
        r23.p(r24.getKey(), (String) CollectionsKt.first(r24.getValue()));
    L42:
        r110.m("py", r22);
        r110.m("native", (com.google.gson.i) new com.google.gson.d().k("{\n\"operation\": \"1.0.0\"\n}", com.google.gson.k.class));
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        com.google.gson.k r113 = new com.google.gson.k();
        if (r10 == false) goto L17;
        String r25 = "all";
    L18:
        r113.p("update", r25);
        if ((!r11.isEmpty()) == false) goto L29;
        com.google.gson.k r26 = new com.google.gson.k();
        Iterator<Map.Entry<String, ? extends b>> r114 = r11.entrySet().iterator();
    L22:
        if (r114.hasNext() == false) goto L28;
        Map.Entry<String, ? extends b> r27 = r114.next();
        String r28 = r27.getKey();
        b r29 = r27.getValue();
        com.google.gson.k r30 = new com.google.gson.k();
        com.google.gson.i r31 = this.f5115d.z(r29);
        if ((r29 instanceof d) == false) goto L26;
        String r32 = "valid";
    L27:
        r30.m(r32, r31);
        Unit r33 = Unit.INSTANCE;
        r26.m(r28, r30);
        goto L22
    L26:
        r32 = "expect";
        goto L27
    L28:
        Unit r115 = Unit.INSTANCE;
        r113.m("package", r26);
    L29:
        r113.p("aid", this.f5113b.getAppConfig().getAid());
        r13.L$0 = this;
        r13.L$1 = r113;
        r13.L$2 = r113;
        r13.L$3 = "device_id";
        r13.label = 1;
        Object r116 = j(r13);
        if (r116 != r16) goto L32;
        return r16;
    L32:
        r20 = this;
        r18 = "device_id";
        r19 = r113;
        r15 = r116;
        r110 = r19;
        goto L33
    L17:
        r25 = "specific";
    L7:
        r13 = new MetadataRequest$buildRequestBody$1(this, r12);
        goto L8
    }

    private final Object i(Continuation<? super String> r10) {
        if ((r10 instanceof MetadataRequest$buildRequestUrl$1) == false) goto L7;
        MetadataRequest$buildRequestUrl$1 r11 = (MetadataRequest$buildRequestUrl$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        StringBuilder r16 = (StringBuilder) r11.L$1;
        String r17 = (String) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        r16.append((String) r13);
        r16.append("&mem_size=");
        r16.append(MemoryUtils.f5219a.c());
        if (r17 == null) goto L22;
        String r18 = "&soc_model=" + r17;
        if (r18 == null) goto L22;
    L23:
        r16.append(r18);
        return r16.toString();
    L22:
        r18 = "";
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        String r19 = this.f5113b.getAppConfig().getAid();
        String r20 = this.f5113b.getAppConfig().getSoc();
        StringBuilder r21 = new StringBuilder();
        r21.append(this.f5113b.getAppConfig().getUrl());
        r21.append("?aid=");
        r21.append(r19);
        r21.append("&device_id=");
        r11.L$0 = r20;
        r11.L$1 = r21;
        r11.label = 1;
        r13 = j(r11);
        if (r13 != r14) goto L17;
        return r14;
    L17:
        r17 = r20;
        r16 = r21;
    L7:
        r11 = new MetadataRequest$buildRequestUrl$1(this, r10);
        goto L8
    }

    private final Object j(Continuation<? super String> r10) {
        if ((r10 instanceof MetadataRequest$getDid$1) == false) goto L7;
        MetadataRequest$getDid$1 r11 = (MetadataRequest$getDid$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return (String) r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Function1<Continuation<? super String>, Object> r16 = this.f5113b.getAppConfig().getDid();
        r11.label = 1;
        r13 = r16.invoke(r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new MetadataRequest$getDid$1(this, r10);
        goto L8
    }

    private final Object k(com.google.gson.k r12, Continuation<? super List<? extends UpdateTaskConfig>> r13) {
        if ((r13 instanceof MetadataRequest$parseBusinessDistribute$1) == false) goto L7;
        MetadataRequest$parseBusinessDistribute$1 r10 = (MetadataRequest$parseBusinessDistribute$1) r13;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r10.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        List r17 = (List) r10.L$0;
        ResultKt.throwOnFailure(r14);
    L24:
        r17.addAll((List) r14);
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.google.gson.i r18 = r12.s("businesses");
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "MetadataRequest", "parseDistributeResponse: businesses:" + r18, 0, 4, null);
        ArrayList r19 = new ArrayList();
        boolean r20 = false;
        if (r18 != null) goto L17;
    L19:
        if (r20 == false) goto L26;
        com.google.gson.k r110 = r18.e();
        Intrinsics.checkNotNullExpressionValue(r110, "businesses.asJsonObject");
        r10.L$0 = r19;
        r10.label = 1;
        Object r111 = o(r110, r10);
        if (r111 != r15) goto L23;
        return r15;
    L23:
        r14 = r111;
        r17 = r19;
        goto L24
    L26:
        return r19;
    L17:
        if (r18.k() != true) goto L19;
        r20 = true;
    L7:
        r10 = new MetadataRequest$parseBusinessDistribute$1(this, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    private final Object l(com.google.gson.k r17, Continuation<? super List<? extends UpdateTaskConfig>> r18) {
        final MetadataRequest r10 = this;
        final com.google.gson.k r11 = r17;
        if ((r18 instanceof MetadataRequest$parseDistributeResponse$1) == false) goto L7;
        MetadataRequest$parseDistributeResponse$1 r12 = (MetadataRequest$parseDistributeResponse$1) r18;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        List r19 = (List) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        r11 = r19;
    L47:
        Object r20 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        Object r21 = r11;
    L50:
        Throwable r22 = Result.m35exceptionOrNullimpl(r20);
        if (r22 == null) goto L53;
        com.obric.aikernel.runtime.utils.d.f5417a.f("MetadataRequest", "updatePendingDecryptModels failed: " + ExceptionsKt.stackTraceToString(r22));
    L53:
        return r21;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = (MetadataRequest) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L23:
        List r23 = (List) r14;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L15
        LinkedHashMap r25 = new LinkedHashMap();     // Catch: Throwable -> L15
        Iterator r26 = r23.iterator();     // Catch: Throwable -> L15
    L26:
        if (r26.hasNext() == false) goto L44;
        Iterator<T> r27 = ((UpdateTaskConfig) r26.next()).l().iterator();     // Catch: Throwable -> L15
    L29:
        if (r27.hasNext() == false) goto L26;
        DistConfig r110 = (DistConfig) r27.next();     // Catch: Throwable -> L15
        if ((r110 instanceof com.obric.aikernel.res.metadata.config.d) == false) goto L29;
        String r111 = r110.g() + '@' + r110.i();     // Catch: Throwable -> L15
        List<com.obric.aikernel.res.metadata.config.b> r112 = r110.d();     // Catch: Throwable -> L15
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<T> r114 = r112.iterator();     // Catch: Throwable -> L15
    L34:
        if (r114.hasNext() == false) goto L42;
        com.obric.aikernel.res.metadata.config.b r115 = (com.obric.aikernel.res.metadata.config.b) r114.next();     // Catch: Throwable -> L15
        if (r115.v(r10.f5113b.getDecryptFeature()) == false) goto L38;
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", r111 + ' ' + r115.o() + " needDecrypt");     // Catch: Throwable -> L15
        Pair r28 = new Pair(r115.o(), r115.f());     // Catch: Throwable -> L15
    L39:
        if (r28 == null) goto L34;
        r113.add(r28);     // Catch: Throwable -> L15
        goto L34
    L38:
        r28 = null;
        goto L39
    L42:
        r25.put(r111, r113);     // Catch: Throwable -> L15
        goto L29
    L44:
        PackageResourceManager.PresmConfig.b r29 = r10.f5113b.getDecryptFeature();     // Catch: Throwable -> L15
        r12.L$0 = r23;     // Catch: Throwable -> L15
        r12.label = 2;     // Catch: Throwable -> L15
        r11 = r23;
        if (r29.d(r25, r12) != r15) goto L47;
        return r15;
    L20:
        ResultKt.throwOnFailure(r14);
        MetadataRequest$parseDistributeResponse$dists$1 r30 = new MetadataRequest$parseDistributeResponse$dists$1(r10, r11, null);
        Function0<List<? extends UpdateTaskConfig>> r31 = new MetadataRequest$parseDistributeResponse$dists$2(r10, r11);
        MetadataRequest$parseDistributeResponse$dists$3 r32 = MetadataRequest$parseDistributeResponse$dists$3.INSTANCE;
        MetadataRequest$parseDistributeResponse$dists$4 r116 = MetadataRequest$parseDistributeResponse$dists$4.INSTANCE;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = MetadataRequestFailureKt.a(r30, r31, r32, r116, r12);
        if (r14 != r15) goto L23;
        return r15;
    L15:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
        r21 = r11;
    L7:
        r12 = new MetadataRequest$parseDistributeResponse$1(r10, r18);
        goto L8
    }

    private final List<UpdateTaskConfig> m(com.google.gson.k r10) {
        com.google.gson.i r11 = r10.s("lora");
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "MetadataRequest", "parseLoraDistribute: loras:" + r11, 0, 4, null);
        ArrayList r12 = new ArrayList();
        boolean r13 = true;
        if (r11 != null) goto L5;
    L7:
        r13 = false;
    L8:
        if (r13 == false) goto L10;
        com.google.gson.k r14 = r11.e();
        Intrinsics.checkNotNullExpressionValue(r14, "loras.asJsonObject");
        r12.addAll(p(r14));
    L10:
        return r12;
    L5:
        if (r11.k() != true) goto L7;
        goto L7
    }

    private final void n(String r27, com.google.gson.k r28, List<com.obric.aikernel.res.metadata.config.e> r29, Map<String, Map<String, com.obric.aikernel.res.metadata.config.c>> r30) {
        List r10 = CollectionsKt.emptyList();
        com.google.gson.i r11 = r28.s("delete");
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L14;
        com.google.gson.f r13 = r11.d();
        Intrinsics.checkNotNullExpressionValue(r13, "removePackage.asJsonArray");
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<com.google.gson.i> r15 = r13.iterator();
    L11:
        if (r15.hasNext() == false) goto L13;
        r14.add(r15.next().h());
        goto L11
    L13:
        r10 = r14;
    L14:
        com.google.gson.i r16 = r28.s("add");
        if (r16 == null) goto L21;
        com.google.gson.k r17 = r16.e();
        if (r17 == null) goto L21;
        com.google.gson.k r18 = r17.u("dependency");
        if (r18 == null) goto L21;
        String r19 = com.obric.aikernel.res.metadata.config.a.d(r18, "py_vm");
    L23:
        if (Intrinsics.areEqual(r19, this.f5113b.getPyVmVersion()) == false) goto L92;
        com.google.gson.k r20 = r16.e();
        Intrinsics.checkNotNullExpressionValue(r20, "json");
        if (Intrinsics.areEqual(com.obric.aikernel.res.metadata.config.a.d(r20, "from"), "debug") == false) goto L27;
        com.google.gson.k r21 = r20.u("dependency").u("handler");
        Intrinsics.checkNotNullExpressionValue(r21, "json.getAsJsonObject(\"de…etAsJsonObject(\"handler\")");
        r20.p("version_debug", com.obric.aikernel.res.metadata.config.a.c(r21, "version"));
        r20.p("version", "debug");
        boolean r22 = true;
    L28:
        com.obric.aikernel.res.metadata.config.e r110 = new com.obric.aikernel.res.metadata.config.e(r27, r20, this.f5113b);
        List<DistConfig> r23 = r110.m();
        ArrayList r111 = new ArrayList();
        Iterator<T> r24 = r23.iterator();
    L30:
        if (r24.hasNext() == false) goto L40;
        Object r112 = r24.next();
        DistConfig r25 = (DistConfig) r112;
        if ((r25 instanceof com.obric.aikernel.res.metadata.config.c) == true) goto L34;
    L36:
        boolean r26 = false;
    L37:
        if (r26 == false) goto L30;
        r111.add(r112);
        goto L30
    L34:
        if (((com.obric.aikernel.res.metadata.config.c) r25).k() == false) goto L36;
        r26 = true;
        goto L37
    L40:
        Iterator r31 = r111.iterator();
    L42:
        if (r31.hasNext() == false) goto L65;
        DistConfig r32 = (DistConfig) r31.next();
        if ((r32 instanceof com.obric.aikernel.res.metadata.config.c) == false) goto L46;
        com.obric.aikernel.res.metadata.config.c r113 = (com.obric.aikernel.res.metadata.config.c) r32;
    L47:
        if (r113 == null) goto L42;
        Map<String, Set<String>> r114 = this.f5113b.getPresetLibraries();
        if (r114 == null) goto L55;
        Set<String> r33 = r114.get(r113.g());
        if (r33 == null) goto L55;
        if (r33.contains(r113.i()) == true) goto L55;
        boolean r34 = true;
    L56:
        if (r34 == true) goto L57;
        if (r113.k() != true) goto L42;
        String r35 = r32.g();
        Map<String, com.obric.aikernel.res.metadata.config.c> r115 = r30.get(r35);
        if (r115 != null) goto L64;
        r115 = new LinkedHashMap();
        r30.put(r35, r115);
    L64:
        r115.put(r32.i(), r113);
        goto L42
    L57:
        com.obric.aikernel.runtime.utils.d.f5417a.l("MetadataRequest", "parsePackageInfo: ignore " + r27 + '@' + r110.i() + " depends on " + r113.g() + '@' + r113.i() + " not in preset config. " + this.f5113b.getPresetLibraries());
        return;
    L55:
        r34 = false;
        goto L56
    L46:
        r113 = null;
        goto L47
    L65:
        com.obric.aikernel.res.metadata.data.b r36 = this.f5112a.getMetadataCtrl$resource_manager_release().p().b("package", r27).get(r110.i());
        if ((r36 instanceof AIPackage) == false) goto L68;
        final AIPackage r37 = (AIPackage) r36;
    L69:
        if (r37 != null) goto L71;
    L91:
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", "Got new config " + r110.g() + '@' + r110.i() + '@' + r110.k());
        r29.add(r110);
        r10 = CollectionsKt.emptyList();
    L93:
        Iterator r38 = r10.iterator();
    L95:
        if (r38.hasNext() == false) goto L98;
        String r39 = (String) r38.next();
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", "delete pkg " + r27 + ' ' + r39);
        this.f5112a.getMetadataCtrl$resource_manager_release().F(r27, r39, false);
        goto L95
    L98:
        if (r22 == false) goto L100;
        return;
    L100:
        com.google.gson.i r40 = r28.s("current");
        if (r40 != null) goto L103;
    L105:
        boolean r41 = false;
    L106:
        String r42 = "";
        if (r41 == false) goto L112;
        com.google.gson.k r43 = r40.e();
        Intrinsics.checkNotNullExpressionValue(r43, "it.asJsonObject");
        String r44 = com.obric.aikernel.res.metadata.config.a.d(r43, "version");
        if (r44 == null) goto L112;
        r42 = r44;
    L112:
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", r27 + " current is " + r42);
        this.f5112a.getMetadataCtrl$resource_manager_release().D(r27, r42, true);
        if (r42.length() <= 0) goto L115;
        boolean r45 = true;
    L116:
        if (r45 == false) goto L145;
        com.obric.aikernel.res.metadata.data.b r46 = this.f5112a.getMetadataCtrl$resource_manager_release().p().b("package", r27).get(r42);
        if ((r46 instanceof AIPackage) == false) goto L120;
        AIPackage r116 = (AIPackage) r46;
    L121:
        if (r116 != null) goto L123;
    L125:
        boolean r47 = false;
    L126:
        if (r47 == false) goto L130;
        DistConfig r48 = r116.s();
        if (r48 == null) goto L146;
        r29.add(new com.obric.aikernel.res.metadata.config.e(r27, r48.f(), this.f5113b));
        return;
    L146:
        return;
    L130:
        this.f5112a.getMetadataCtrl$resource_manager_release().l(r27, r42);
        return;
    L123:
        if (r116.F() != true) goto L125;
        r47 = true;
        goto L126
    L120:
        r116 = null;
        goto L121
    L145:
        return;
    L115:
        r45 = false;
        goto L116
    L103:
        if (r40.k() != true) goto L105;
        r41 = true;
        goto L106
    L71:
        if (r37.o0() == true) goto L73;
    L77:
        boolean r49 = false;
    L78:
        if (r49 == true) goto L81;
        r37 = null;
    L81:
        if (r37 == null) goto L91;
        MetadataController r117 = this.f5112a.getMetadataCtrl$resource_manager_release();
        String r118 = r37.w();
        String r119 = r37.D();
        DistConfig r50 = r37.s();
        if (r50 == null) goto L85;
        com.google.gson.k r210 = r50.f();
    L86:
        MetadataController.x(r117, r118, r119, r210, false, false, new MetadataRequest$parsePackageInfo$5$1(r37), 24, null);
        if (r37.H() == false) goto L89;
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", r37.w() + '@' + r37.D() + '@' + r37.t() + " is Avail.");
    L90:
        if (r37 != null) goto L93;
    L89:
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", r37.w() + '@' + r37.D() + '@' + r37.t() + " resourceAllReady " + r37.o0() + '.');
        r37 = null;
        goto L90
    L85:
        r210 = null;
        goto L86
    L73:
        if (r37.r0(r110.f()) == false) goto L77;
        if (r37.F() == true) goto L77;
        r49 = true;
        goto L78
    L68:
        r37 = null;
        goto L69
    L27:
        r22 = false;
        goto L28
    L92:
        r22 = false;
    L21:
        r19 = null;
        goto L23
    L5:
        if (r11.i() != true) goto L7;
        r12 = true;
        goto L8
    }

    private final Object o(com.google.gson.k r10, Continuation<? super List<com.obric.aikernel.res.metadata.config.e>> r11) {
        ArrayList r12 = new ArrayList();
        LinkedHashMap r13 = new LinkedHashMap();
        Set<String> r14 = r10.x();
        Intrinsics.checkNotNullExpressionValue(r14, "businesses.keySet()");
        Iterator<T> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L13;
        String r16 = (String) r15.next();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L8
        com.google.gson.k r18 = r10.s(r16).e();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r16, "biz");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r18, "bizData");     // Catch: Throwable -> L8
        n(r16, r18, r12, r13);     // Catch: Throwable -> L8
        Object r19 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);
        if (r20 == null) goto L4;
        com.obric.aikernel.runtime.utils.d.f5417a.f("MetadataRequest", "processBusinesses ignore broken biz " + r16 + ": " + ExceptionsKt.stackTraceToString(r20));
    L8:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        return r12;
    }

    private final List<LoraConfig> p(com.google.gson.k r10) {
        ArrayList r11 = new ArrayList();
        Set<Map.Entry<String, com.google.gson.i>> r12 = r10.r();
        if (r12 == null) goto L18;
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r14 = (Map.Entry) r13.next();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        Object r16 = r14.getKey();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r16, "it.key");     // Catch: Throwable -> L10
        com.google.gson.k r17 = ((com.google.gson.i) r14.getValue()).e();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r17, "it.value.asJsonObject");     // Catch: Throwable -> L10
        LoraConfig r18 = new LoraConfig((String) r16, r17);     // Catch: Throwable -> L10
        com.obric.aikernel.runtime.utils.d.f5417a.d("MetadataRequest", "processLoras parsed " + r18.n());     // Catch: Throwable -> L10
        Object r19 = Result.m32constructorimpl(r18);     // Catch: Throwable -> L10
    L13:
        if (Result.m39isSuccessimpl(r19) == false) goto L15;
        r11.add((LoraConfig) r19);
    L15:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);
        if (r20 == null) goto L6;
        com.obric.aikernel.runtime.utils.d.f5417a.f("MetadataRequest", "processLoras ignore broken config " + ((String) r14.getKey()) + ": " + ExceptionsKt.stackTraceToString(r20));
    L10:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L18:
        return r11;
    }

    private final Object s(boolean r19, Map<String, ? extends b> r20, b8.a r21, Continuation<? super List<? extends UpdateTaskConfig>> r22) {
        MetadataRequest r10 = this;
        if ((r22 instanceof MetadataRequest$requestInner$1) == false) goto L7;
        MetadataRequest$requestInner$1 r11 = (MetadataRequest$requestInner$1) r22;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L20;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 != 4) goto L16;
        ResultKt.throwOnFailure(r13);
    L46:
        return r13;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (MetadataRequest) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L35:
        String r16 = (String) r13;
        if (r16 == null) goto L39;
    L43:
        e r17 = MetadataRequestFailureKt.f(r16, r10.f5115d);
        com.obric.aikernel.runtime.utils.c.a.a(com.obric.aikernel.runtime.utils.d.f5417a, "MetadataRequest", "after request status:" + r17.d() + " message:" + r17.c() + " extra:" + r17.b(), 0, 4, null);
        com.google.gson.k r18 = r17.a();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
        r13 = r10.l(r18, r11);
        if (r13 != r14) goto L46;
        return r14;
    L39:
        throw new MetadataRequestException(MetadataRequestFailureKind.RESPONSE_PARSE_FAILED, "metadata request delegate returned empty response", null, 4, null);
    L18:
        String r23 = (String) r11.L$2;
        b8.a r24 = (b8.a) r11.L$1;
        MetadataRequest r25 = (MetadataRequest) r11.L$0;
        ResultKt.throwOnFailure(r13);
        String r26 = r23;
        r10 = r25;
    L30:
        com.google.gson.k r27 = (com.google.gson.k) r13;
        if (r10.f5113b.getAppConfig().getNetworkRequestDelegate() == null) goto L40;
        Function2<y, Continuation<? super String>, Object> r28 = r10.f5113b.getAppConfig().getNetworkRequestDelegate();
        u r29 = u.g(NetConst.CONTENT_TYPE);
        String r30 = r27.toString();
        Intrinsics.checkNotNullExpressionValue(r30, "body.toString()");
        byte[] r31 = r30.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r31, "this as java.lang.String).getBytes(charset)");
        y r32 = y.d(r29, r31);
        Intrinsics.checkNotNullExpressionValue(r32, "create(MediaType.parse(\"…toString().toByteArray())");
        r11.L$0 = r10;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
        r13 = r28.invoke(r32, r11);
        if (r13 != r14) goto L35;
        return r14;
    L40:
        byte[] r33 = r24.a(r26, r27);
        if (r33 == null) goto L48;
        r16 = new String(r33, Charsets.UTF_8);
        goto L43
    L48:
        throw new MetadataRequestException(MetadataRequestFailureKind.UNKNOWN_TRANSPORT, "metadata request adapter returned empty response", null, 4, null);
    L19:
        boolean r34 = r11.Z$0;
        r24 = (b8.a) r11.L$2;
        Map<String, ? extends b> r35 = (Map) r11.L$1;
        MetadataRequest r110 = (MetadataRequest) r11.L$0;
        ResultKt.throwOnFailure(r13);
        boolean r111 = r34;
        r10 = r110;
        Object r36 = r13;
        Map<String, ? extends b> r37 = r35;
    L27:
        r26 = (String) r36;
        r11.L$0 = r10;
        r11.L$1 = r24;
        r11.L$2 = r26;
        r11.label = 2;
        r13 = r10.h(r111, r37, r11);
        if (r13 != r14) goto L30;
        return r14;
    L20:
        ResultKt.throwOnFailure(r13);
        if (r10.f5113b.getAppConfig().getAllowNetworkRequest().invoke().booleanValue() == true) goto L24;
        com.obric.aikernel.runtime.utils.d.f5417a.i("MetadataRequest", "requestInner: not allow NetworkRequest");
        return CollectionsKt.emptyList();
    L24:
        r11.L$0 = r10;
        r37 = r20;
        r11.L$1 = r37;
        r24 = r21;
        r11.L$2 = r24;
        r111 = r19;
        r11.Z$0 = r111;
        r11.label = 1;
        r36 = r10.i(r11);
        if (r36 != r14) goto L27;
        return r14;
    L7:
        r11 = new MetadataRequest$requestInner$1(r10, r22);
        goto L8
    }

    public final Object q(com.google.gson.k r10, Continuation<? super Map<String, ? extends List<? extends DistConfig>>> r11) {
        if ((r11 instanceof MetadataRequest$pushDebugDistributeInfo$1) == false) goto L7;
        MetadataRequest$pushDebugDistributeInfo$1 r12 = (MetadataRequest$pushDebugDistributeInfo$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = ((List) r14).iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        Object r19 = r18.next();
        String r20 = ((UpdateTaskConfig) r19).h();
        Object r21 = r17.get(r20);
        if (r21 != null) goto L23;
        r21 = new ArrayList();
        r17.put(r20, r21);
    L23:
        ((List) r21).add(r19);
        goto L19
    L24:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.label = 1;
        r14 = l(r10, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new MetadataRequest$pushDebugDistributeInfo$1(this, r11);
        goto L8
    }

    public final Object r(boolean r10, Map<String, ? extends b> r11, b8.a r12, Continuation<? super Map<String, ? extends List<? extends UpdateTaskConfig>>> r13) {
        if ((r13 instanceof MetadataRequest$request$1) == false) goto L7;
        MetadataRequest$request$1 r14 = (MetadataRequest$request$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L18:
        return ((com.obric.aikernel.res.update.d) r16).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r14.label = 1;
        r16 = t(r10, r11, r12, r14);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r14 = new MetadataRequest$request$1(this, r13);
        goto L8
    }

    public final Object t(boolean r12, Map<String, ? extends b> r13, b8.a r14, Continuation<? super com.obric.aikernel.res.update.d> r15) {
        if ((r15 instanceof MetadataRequest$requestOutcome$1) == false) goto L7;
        MetadataRequest$requestOutcome$1 r10 = (MetadataRequest$requestOutcome$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        MetadataRequest$requestOutcome$1 r16 = r10;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        if (r19 == 0) goto L17;
        if (r19 != 1) goto L16;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L13
    L30:
        Object r110 = Result.m32constructorimpl((List) r17);     // Catch: Throwable -> L13
    L33:
        Throwable r111 = Result.m35exceptionOrNullimpl(r110);
        if (r111 != null) goto L43;
        com.obric.aikernel.res.update.d.a r112 = com.obric.aikernel.res.update.d.f5169c;
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r114 = ((List) r110).iterator();
    L37:
        if (r114.hasNext() == false) goto L50;
        Object r115 = r114.next();
        String r116 = ((UpdateTaskConfig) r115).h();
        Object r20 = r113.get(r116);
        if (r20 != null) goto L41;
        r20 = new ArrayList();
        r113.put(r116, r20);
    L41:
        ((List) r20).add(r115);
        goto L37
    L50:
        return r112.b(r113);
    L43:
        MetadataRequestException r117 = MetadataRequestFailureKt.e(r111);
        com.obric.aikernel.runtime.utils.d.f5417a.f("MetadataRequest", "request final failed kind=" + r117.getKind() + " reason=" + r117.getMessage());
        return com.obric.aikernel.res.update.d.f5169c.a(r117);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r17);
        if (r12 == false) goto L20;
    L23:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L13
        if (r12 == false) goto L26;
        boolean r21 = true;
    L27:
        MetadataRequest$requestOutcome$2$1 r22 = new MetadataRequest$requestOutcome$2$1(this, r21, r13, r14, null);     // Catch: Throwable -> L13
        MetadataRequest$requestOutcome$2$2 r23 = MetadataRequest$requestOutcome$2$2.INSTANCE;     // Catch: Throwable -> L13
        r16.label = 1;     // Catch: Throwable -> L13
        r17 = MetadataRequestFailureKt.h(r22, null, r23, r16, 2, null);     // Catch: Throwable -> L13
        if (r17 != r18) goto L30;
        return r18;
    L26:
        r21 = false;
        goto L27
    L20:
        if (r13.isEmpty() == false) goto L23;
        return com.obric.aikernel.res.update.d.f5169c.b(MapsKt.emptyMap());
    L13:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r10 = new MetadataRequest$requestOutcome$1(this, r15);
        goto L8
    }
}
