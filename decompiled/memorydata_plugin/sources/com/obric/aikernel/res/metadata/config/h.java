package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0018R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", ActivityLifecycle.NAME, "", "json", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "version", "getVersion", "()Ljava/lang/String;", "finalArtifactSpecs", "", "Lcom/obric/aikernel/res/metadata/config/ModelArtifactSpec;", "decryptFeature", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "finalArtifactSpecs$resource_manager_release", "generateCheckFile", "", "downloadRoot", "Ljava/io/File;", "targetRoot", "getDownloads", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "hasDecryptKeyInfo", "", "needDownload", "context", "Lcom/obric/aikernel/res/PrmContext;", "shouldDecryptToStorage", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6071a;

    public h(String r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "json");
        super("model", r2, r3);
        JsonElement r4 = r3.get("version");
        if (r4 != null) goto L5;
    L11:
        String r5 = "";
    L12:
        this.f6071a = r5;
        return;
    L5:
        if (r4.isJsonPrimitive() == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r5 = Integer.valueOf(r4.getAsInt()).toString();
        if (r5 != null) goto L12;
        goto L11
    }

    public final List<f> a(PackageResourceManager.PresmConfig.a r5) {
        PackageResourceManager.PresmConfig.a r6 = (PackageResourceManager.PresmConfig.a) ZeusTransformUtils.wrapperContextForParams(r5, PackageResourceManager.PresmConfig.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "decryptFeature");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        r0.add(g.a((c) ZeusTransformUtils.preCheckCast(r7.next(), c.class, "com.obric.memorydata.plugin"), r6));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aikernel.res.metadata.config.a
    public void a(File r8, File r9) {
        Intrinsics.checkNotNullParameter(r8, "downloadRoot");
        Intrinsics.checkNotNullParameter(r9, "targetRoot");
        com.obric.aikernel.res.metadata.data.d.a r10 = com.obric.aikernel.res.metadata.data.d.f;
        String r11 = r9.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "targetRoot.path");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(e(), Iterable.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r7.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r12.next(), c.class, "com.obric.memorydata.plugin");
        String r4 = r2.f();
        if (r2.p() == false) goto L8;
        long r5 = r2.k();
    L9:
        Pair r3 = new Pair(r4, Long.valueOf(r5));
        r0.put(r3.getFirst(), r3.getSecond());
        goto L4
    L8:
        r5 = r2.j();
        goto L9
    L10:
        r10.a(r11, r0);
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public boolean a(PrmContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.obric.aikernel.res.metadata.data.a(a(), c(), r3.getConfig()).E();
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public String c() {
        return this.f6071a;
    }

    @Override // com.obric.aikernel.res.metadata.config.a
    public List<c> e() {
        List<c> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (b().has("weight_files") == false) goto L10;
        JsonArray r1 = b().getAsJsonArray("weight_files");
        Intrinsics.checkNotNullExpressionValue(r1, "json.getAsJsonArray(\"weight_files\")");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r4.next(), JsonElement.class, "com.obric.memorydata.plugin");
        String r6 = a();
        JsonObject r7 = r5.getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r7, "it.asJsonObject");
        r3.add(new c(r6, r7, 1, false, 8, null));
        goto L6
    L8:
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    L10:
        if (b().has("tokenizer_file") == false) goto L12;
        String r8 = a();
        JsonObject r9 = b().getAsJsonObject("tokenizer_file");
        Intrinsics.checkNotNullExpressionValue(r9, "json.getAsJsonObject(\"tokenizer_file\")");
        r0.add(new c(r8, r9, 1, false, 8, null));
    L12:
        return r0;
    }

    public final boolean f() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(e(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((c) ZeusTransformUtils.preCheckCast(r5.next(), c.class, "com.obric.memorydata.plugin")).q() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }
}
