package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "presmConfig", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "getResources", "", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "needDownload", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f6073b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/PackageConfig$Companion;", "", "()V", "isPackageConfig", "", "json", "Lcom/google/gson/JsonObject;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean a(JsonObject r1) {
            Intrinsics.checkNotNullParameter(r1, "json");
            return r1.has("dependency");
        }
    }

    static {
        f6072a = new a(null);
    }

    public i(String r2, JsonObject r3, PackageResourceManager.PresmConfig r4) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "presmConfig");
        super("package", r2, r3);
        this.f6073b = r4;
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public boolean a(PrmContext r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    @Override // com.obric.aikernel.res.metadata.config.k
    public List<com.obric.aikernel.res.metadata.config.a> getResources() {
        List<com.obric.aikernel.res.metadata.config.a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        JsonObject r1 = b().getAsJsonObject("dependency");
        boolean r3 = Intrinsics.areEqual(c(), "debug");
        String r6 = a();
        JsonObject r7 = r1.getAsJsonObject("handler");
        Intrinsics.checkNotNullExpressionValue(r7, "depend.getAsJsonObject(\"handler\")");
        r0.add(new j(r6, r7, c()));
        if (r1.has("bridge") == false) goto L9;
        JsonObject r8 = r1.getAsJsonObject("bridge");
        if (r3 == false) goto L7;
        r8.addProperty("from", "debug");
    L7:
        Intrinsics.checkNotNullExpressionValue(r8, "libCfg");
        r0.add(new d("bridge", r8));
    L9:
        if (r1.has("libs") == false) goto L18;
        JsonObject r5 = r1.getAsJsonObject("libs");
        Set<String> r9 = r5.keySet();
        Intrinsics.checkNotNullExpressionValue(r9, "libs.keySet()");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r10.hasNext() == false) goto L18;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        JsonObject r12 = r5.getAsJsonObject(r11);
        if (r3 == false) goto L16;
        r12.addProperty("from", "debug");
    L16:
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r12, "libCfg");
        r0.add(new d(r11, r12));
    L18:
        if (this.f6073b.getUseAIKernelModel() == false) goto L20;
    L27:
        return r0;
    L20:
        if (r1.has("model_center_name") == false) goto L27;
        if (r1.has("model_center_conf") == false) goto L27;
        JsonObject r4 = r1.getAsJsonObject("model_center_conf");
        JsonArray r13 = r1.getAsJsonArray("model_center_name");
        Intrinsics.checkNotNullExpressionValue(r13, "depend.getAsJsonArray(\"model_center_name\")");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        JsonObject r2 = r4.getAsJsonObject(((JsonElement) ZeusTransformUtils.preCheckCast(r14.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString());
        Intrinsics.checkNotNullExpressionValue(r2, "modelConfig");
        r0.add(new h(b.a(r2, ActivityLifecycle.NAME), r2));
        goto L25
    }
}
