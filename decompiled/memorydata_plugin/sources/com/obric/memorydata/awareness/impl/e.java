package com.obric.memorydata.awareness.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016J<\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016J<\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016JD\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0002J\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u000bH\u0002J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessPackageEventListener;", "Lcom/obric/memorydata/awareness/api/EventListener;", "papayaPackage", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "subscribedName", "", "triggerTypes", "", "Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", "shouldRunAutoTrigger", "Lkotlin/Function2;", "", "<init>", "(Lcom/obric/aikernel/res/metadata/config/PackageConfig;Ljava/lang/String;Ljava/util/Set;Lkotlin/jvm/functions/Function2;)V", ObricMemoryConstants.KEY_PACKAGE_NAME, "getPackageName", "()Ljava/lang/String;", "active", "hasFeatureTrigger", "getHasFeatureTrigger", "()Z", "onEvent", "", "eventName", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "dispatchFeatureTrigger", "triggerType", "deactivate", "isInWhiteList", "equals", "other", "hashCode", "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements com.obric.memorydata.awareness.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8664a = null;
    private static final ArrayList<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aikernel.res.metadata.config.i f8665b;
    private final String c;
    private final Set<AwarenessEventTriggerType> d;
    private final Function2<AwarenessEventTriggerType, String, Boolean> e;
    private volatile boolean f;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessPackageEventListener$Companion;", "", "<init>", "()V", "KEY_EVENT", "", "KEY_FEATURE", "KEY_OLD_VALUE", "KEY_NEW_VALUE", "KEY_EXTRA", "KEY_TRIGGER_TYPE", "KEY_RECOMMEND_RESULT", "WHITE_FEATURE_PACKAGE_LIST", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getWHITE_FEATURE_PACKAGE_LIST", "()Ljava/util/ArrayList;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8664a = new a(null);
        g = CollectionsKt.arrayListOf(new String[]{com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME});
    }

    public e(com.obric.aikernel.res.metadata.config.i r3, String r4, Set<? extends AwarenessEventTriggerType> r5, Function2<? super AwarenessEventTriggerType, ? super String, Boolean> r6) {
        Set<AwarenessEventTriggerType> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Function2<AwarenessEventTriggerType, String, Boolean> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "papayaPackage");
        Intrinsics.checkNotNullParameter(r4, "subscribedName");
        Intrinsics.checkNotNullParameter(r7, "triggerTypes");
        Intrinsics.checkNotNullParameter(r8, "shouldRunAutoTrigger");
        this.f8665b = r3;
        this.c = r4;
        this.d = r7;
        this.e = r8;
        this.f = true;
    }

    private final void a(final AwarenessEventTriggerType r4, final String r5, Object r6, Object r7, Map<String, ? extends Object> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (this.d.contains(r4) == true) goto L5;
        return;
    L5:
        if (b.f8632a.b() == false) goto L7;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("trigger_type", r4.getValue());
        r0.put("feature", r5);
        r0.put("oldValue", g.a(r6));
        r0.put("newValue", g.a(r7));
        if (r9 == null) goto L12;
        r0.put(WsConstants.KEY_EXTRA, new JSONObject(u.a(r9)));
    L12:
        r0.put(AwarenessManagerImpl.KEY_ACTION_TYPE, AwarenessManagerImpl.ACTION_SUBSCRIBE);
        com.obric.memorydata.awareness.task.b.f8794a.a(this.f8665b, r0, new $$Lambda$e$Ix2AbXlZsNv0efMrdcjHbPTPyE(this, r4, r5));
        return;
    L7:
        if (e() == true) goto L9;
    }

    private static final boolean a(e r1, AwarenessEventTriggerType r2, String r3) {
        if (r1.f == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.e.invoke(r2, r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }

    private static final boolean a(e r1, String r2) {
        if (r1.f == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.e.invoke(AwarenessEventTriggerType.CONTEXT_EVENT, r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }

    private final boolean e() {
        return g.contains(this.f8665b.a());
    }

    /* JADX INFO: renamed from: lambda$Ix2AbX-lZsNv0efMrdcjHbPTPyE, reason: not valid java name */
    public static /* synthetic */ boolean m511lambda$Ix2AbXlZsNv0efMrdcjHbPTPyE(e r0, AwarenessEventTriggerType r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$h2a98-C1ESnZpepsjwobiTVz46Y, reason: not valid java name */
    public static /* synthetic */ boolean m512lambda$h2a98C1ESnZpepsjwobiTVz46Y(e r0, String r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r7, Object r8, Object r9, Map<String, ? extends Object> r10) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "feature");
        a(AwarenessEventTriggerType.FEATURE_CHANGED, r7, r8, r9, r5);
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(final String r4, Map<String, ? extends Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        if (this.d.contains(AwarenessEventTriggerType.CONTEXT_EVENT) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("trigger_type", AwarenessEventTriggerType.CONTEXT_EVENT.getValue());
        r0.put("event", r4);
        if (r6 == null) goto L8;
        r0.put(WsConstants.KEY_EXTRA, new JSONObject(u.a(r6)));
    L8:
        com.obric.memorydata.awareness.task.b.f8794a.a(this.f8665b, r0, new $$Lambda$e$h2a98C1ESnZpepsjwobiTVz46Y(this, r4));
    }

    @Override // com.obric.memorydata.awareness.api.a
    public boolean a() {
        return com.obric.memorydata.awareness.api.a.C0430a.a(this);
    }

    public final String b() {
        return this.f8665b.a();
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void b(String r7, Object r8, Object r9, Map<String, ? extends Object> r10) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "feature");
        a(AwarenessEventTriggerType.FEATURE_EVENT, r7, r8, r9, r5);
    }

    public final boolean c() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((AwarenessEventTriggerType) ZeusTransformUtils.preCheckCast(r5.next(), AwarenessEventTriggerType.class, "com.obric.memorydata.plugin")).isFeatureTrigger() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final void d() {
        this.f = false;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f8665b.a(), ((e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin")).f8665b.a()) == false) goto L16;
        if (Intrinsics.areEqual(this.c, ((e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin")).c) == false) goto L16;
        if (Intrinsics.areEqual(this.d, ((e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin")).d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return (((this.f8665b.a().hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
