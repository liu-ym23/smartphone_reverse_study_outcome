package com.obric.memorydata.awareness.har;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.api.ProactiveRecommendationEnabledStore;
import com.obric.aiproactive.api.ae;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\rJ(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016J<\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/har/HarDemandGate;", "Lcom/obric/memorydata/awareness/api/EventListener;", "onDemandChanged", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "proactiveRecommendationEnabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", CommonConsts.APM_INNER_EVENT_COST_START, "isDemanded", "", "onEvent", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "isValidGps", EventBody.KEY_VALUE, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.awareness.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f8612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f8613b;
    private final ae c;

    public a(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onDemandChanged");
        this.f8612a = r4;
        this.f8613b = new AtomicBoolean(false);
        this.c = new $$Lambda$a$PcE3Gu2HfcVNOZQfnrh0EP0F_E(this);
    }

    public static final /* synthetic */ Function0 a(a r0) {
        return r0.f8612a;
    }

    private static final void a(a r0, boolean r1) {
        r0.f8612a.invoke();
    }

    private final boolean a(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, List.class) == true) goto L5;
        return false;
    L5:
        if (((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L24;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L9;
    L11:
        Iterator r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r6.next(), Number.class) == true) goto L13;
        boolean r7 = false;
    L17:
        if (r7 == true) goto L19;
        return false;
    L19:
        return true;
    L10:
        r7 = true;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
    L24:
        return false;
    }

    /* JADX INFO: renamed from: lambda$PcE3G-u2HfcVNOZQfnrh0EP0F_E, reason: not valid java name */
    public static /* synthetic */ void m502lambda$PcE3Gu2HfcVNOZQfnrh0EP0F_E(a r0, boolean r1) {
        a(r0, r1);
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "feature");
        if (Intrinsics.areEqual(r1, "location_home_gps") == false) goto L5;
    L6:
        this.f8612a.invoke();
        return;
    L5:
        if (Intrinsics.areEqual(r1, "location_company_gps") == true) goto L6;
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    @Override // com.obric.memorydata.awareness.api.a
    public boolean a() {
        return com.obric.memorydata.awareness.api.a.C0430a.a(this);
    }

    public final void b() {
        if (this.f8613b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_home_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_company_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        ProactiveRecommendationEnabledStore.INSTANCE.registerListener(this.c, true);
        k.b(k.f((i) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new HarDemandGate$start$1(this, null), Function2.class, "com.obric.memorydata.plugin")), j.a());
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
        com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    public final boolean c() {
        if (a(FeatureManager.INSTANCE.getFeature("location_home_gps")) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L15;
        if (ProactiveRecommendationEnabledStore.INSTANCE.isEnabled() == true) goto L15;
        if (((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (a(FeatureManager.INSTANCE.getFeature("location_company_gps")) == true) goto L8;
        r4 = false;
        goto L9
    }
}
