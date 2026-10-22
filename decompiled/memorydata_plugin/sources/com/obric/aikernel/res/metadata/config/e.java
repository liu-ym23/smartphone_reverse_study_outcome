package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0015\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/aikernel/res/metadata/config/LoraConfig;", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "autoDownload", "", "getAutoDownload", "()Z", "autoDownload$delegate", "Lkotlin/Lazy;", "baseModelTag", "getBaseModelTag", "()Ljava/lang/String;", "baseModelTag$delegate", "packageMinVersion", "getPackageMinVersion", "packageMinVersion$delegate", ObricMemoryConstants.KEY_PACKAGE_NAME, "getPackageName", "packageName$delegate", "describeForLog", "describeModelVersionsForLog", "getModelConfigs", "", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "getResources", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "needDownload", "context", "Lcom/obric/aikernel/res/PrmContext;", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f6068b;
    private final Lazy c;
    private final Lazy d;
    private final Lazy e;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\t¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/LoraConfig$Companion;", "", "()V", "isLoraConfig", "", "json", "Lcom/google/gson/JsonObject;", "getModelTag", "", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean a(JsonObject r1) {
            Intrinsics.checkNotNullParameter(r1, "json");
            return r1.has("base_model");
        }
    }

    static {
        f6067a = new a(null);
    }

    public e(String r3, final JsonObject r4) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "json");
        super("lora", r3, r4);
        this.f6068b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new LoraConfig$baseModelTag$2(r4), Function0.class, "com.obric.memorydata.plugin"));
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new LoraConfig$packageMinVersion$2(r4), Function0.class, "com.obric.memorydata.plugin"));
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new LoraConfig$packageName$2(r4), Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new LoraConfig$autoDownload$2(r4), Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public boolean a(PrmContext r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    public final String f() {
        return (String) ZeusTransformUtils.preCheckCast(this.f6068b.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final String g() {
        return (String) ZeusTransformUtils.preCheckCast(this.c.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.res.metadata.config.k
    public List<com.obric.aikernel.res.metadata.config.a> getResources() {
        return j();
    }

    public final String h() {
        return (String) ZeusTransformUtils.preCheckCast(this.d.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public final boolean i() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.e.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final List<h> j() {
        JsonObject r6 = b().getAsJsonObject("model_center_conf");
        Set<String> r0 = r6.keySet();
        Intrinsics.checkNotNullExpressionValue(r0, "modelConf.keySet()");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        JsonObject r4 = r6.getAsJsonObject((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r4, "partConfig");
        r2.add(new h(b.a(r4, ActivityLifecycle.NAME), r4));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    public final String k() {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(j(), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(LoraConfig$describeModelVersionsForLog$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null);
    }
}
