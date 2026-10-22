package com.obric.memorydata.awareness.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.awareness.api.IFeatureManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureManagerImpl;", "Lcom/obric/memorydata/awareness/api/IFeatureManager;", "<init>", "()V", "producers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "getInst", "addProducer", "", "groupName", "producer", "removeProducer", "getFeature", "", "featureName", "getFeatureExtra", "", "getFeatureValueAndExtra", "setFeature", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "hasDefineFeature", "", "collectFeatures", "featureNames", "", "collect", "getFeatureProducer", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureManagerImpl implements IFeatureManager {
    public static final FeatureManagerImpl INSTANCE = null;
    private static final ConcurrentHashMap<String, com.obric.memorydata.awareness.api.b> producers = null;

    static {
        FeatureManagerImpl r0 = new FeatureManagerImpl();
        INSTANCE = r0;
        producers = new ConcurrentHashMap();
        r0.addProducer("device", (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.producer.c(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"));
        r0.addProducer("user_profile", (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.producer.g(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"));
        r0.addProducer("location", (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.producer.d(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"));
        r0.addProducer("data_time", (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.producer.b(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"));
        r0.addProducer("papaya", (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.producer.e(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.awareness.impl.a.d.f8622a.a("current_location_info", (com.obric.memorydata.awareness.impl.a.b) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.impl.a.i.f8631a, com.obric.memorydata.awareness.impl.a.b.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.awareness.impl.a.d.f8622a.a("current_location_type", (com.obric.memorydata.awareness.impl.a.b) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.impl.a.i.f8631a, com.obric.memorydata.awareness.impl.a.b.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.awareness.impl.a.d.f8622a.a("current_geofences", (com.obric.memorydata.awareness.impl.a.b) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.impl.a.i.f8631a, com.obric.memorydata.awareness.impl.a.b.class, "com.obric.memorydata.plugin"));
    }

    private FeatureManagerImpl() {
    }

    private final com.obric.memorydata.awareness.api.b getFeatureProducer(String r9) {
        Collection<com.obric.memorydata.awareness.api.b> r8 = producers.values();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-values>(...)");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r2 = r11.next();
        if (((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin")).hasDefineFeature(r9) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "feature " + r9 + " has not define", null, 4, null);
        return null;
    L11:
        if (r12.size() <= 1) goto L14;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "featureName " + r9 + " has declare in multiple places", null, 4, null);
    L14:
        return (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r12), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final FeatureManagerImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void addProducer(String r9, com.obric.memorydata.awareness.api.b r10) {
        com.obric.memorydata.awareness.api.b r8 = (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "groupName");
        Intrinsics.checkNotNullParameter(r8, "producer");
        ConcurrentHashMap<String, com.obric.memorydata.awareness.api.b> r11 = producers;
        if (r11.contains(r9) == false) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "duplicate put featureProducer groupName: " + r9, null, 4, null);
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin")).put(r9, r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "addProducer groupName: " + r9, false, 4, null);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r4, boolean r5) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureNames");
        Collection<com.obric.memorydata.awareness.api.b> r6 = producers.values();
        Intrinsics.checkNotNullExpressionValue(r6, "<get-values>(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin")).collectFeatures(r3, r5);
        goto L4
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        com.obric.memorydata.awareness.api.b r1 = getFeatureProducer(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getFeature(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        com.obric.memorydata.awareness.api.b r1 = getFeatureProducer(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getFeatureExtra(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureValueAndExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        com.obric.memorydata.awareness.api.b r1 = getFeatureProducer(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getFeatureValueAndExtra(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r4) {
        Intrinsics.checkNotNullParameter(r4, "featureName");
        Collection<com.obric.memorydata.awareness.api.b> r3 = producers.values();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-values>(...)");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin")).hasDefineFeature(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void removeProducer(String r7) {
        Intrinsics.checkNotNullParameter(r7, "groupName");
        producers.remove(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "removeProducer groupName: " + r7, false, 4, null);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void setFeature(String r3, Object r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        com.obric.memorydata.awareness.api.b r2 = getFeatureProducer(r3);
        if (r2 == null) goto L6;
        r2.setFeature(r3, r4, r6);
        return;
    }
}
