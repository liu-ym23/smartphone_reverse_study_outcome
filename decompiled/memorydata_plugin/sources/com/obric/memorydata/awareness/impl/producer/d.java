package com.obric.memorydata.awareness.impl.producer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J2\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/LocationFeatureProducer;", "Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "features", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatures", "()Ljava/util/HashSet;", "needCacheFeatures", "getNeedCacheFeatures", "recoverState", "", "subscribeLocation", "onDataReceive", "locationEntity", "Lcom/obric/memorydata/database/entity/LocationEntity;", "setFeature", "featureName", EventBody.KEY_VALUE, "", WsConstants.KEY_EXTRA, "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends com.obric.memorydata.awareness.impl.producer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8747b = null;
    private final IStore c;
    private final HashSet<String> d;
    private final HashSet<String> e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/LocationFeatureProducer$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8747b = new a(null);
    }

    public d() {
        this.c = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "awareness_store", 0, 2, null);
        this.d = SetsKt.hashSetOf(new String[]{"location_city", "current_location_info", "current_location_type", "current_geofences", "commute_state", "commute_predict_full_interval_result"});
        this.e = SetsKt.hashSetOf(new String[]{"location_city"});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationFeatureProducer", "LocationFeatureProducer init", false, 4, null);
        f();
        e();
    }

    private static final Unit a(LiveData r2, final d r3) {
        r2.observeForever((Observer) ZeusTransformUtils.preCheckCast(new LocationFeatureProducer$sam$androidx_lifecycle_Observer$0(new $$Lambda$d$klVcxXMrSAwez09AjM0OQpnx9s(r3)), Observer.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(d r0, cl r1) {
        if (r1 == null) goto L5;
        r0.a(r1);
    L5:
        return Unit.INSTANCE;
    }

    private final void a(cl r1) {
    }

    private final void e() {
        String r0 = this.c.getString("location_city", "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        a("location_city", r0);
    L8:
        this.c.remove(new String[]{"commute_state"});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationFeatureProducer", "recoverState featureCached " + a(), false, 4, null);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void f() {
        final LiveData<cl> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecordLiveData();
        j.a(new $$Lambda$d$LunNqYVGej2PvGT_jRs8psV_Atc(r0, this));
    }

    public static /* synthetic */ Unit lambda$LunNqYVGej2PvGT_jRs8psV_Atc(LiveData r0, d r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$klVcxXMrSAwez09-AjM0OQpnx9s, reason: not valid java name */
    public static /* synthetic */ Unit m522lambda$klVcxXMrSAwez09AjM0OQpnx9s(d r0, cl r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a
    public /* synthetic */ Set b() {
        return (Set) ZeusTransformUtils.preCheckCast(c(), Set.class, "com.obric.memorydata.plugin");
    }

    public HashSet<String> c() {
        return this.d;
    }

    public HashSet<String> d() {
        return this.e;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void setFeature(String r11, Object r12, Map<String, ? extends Object> r13) {
        Map<String, ? extends Object> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "featureName");
        if (Intrinsics.areEqual(r11, "current_location_info") == false) goto L6;
        Object r0 = com.obric.memorydata.awareness.impl.location.d.f8742a.a(r12);
    L9:
        if (r12 == null) goto L14;
        if (r0 != null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationFeatureProducer", "ignore invalid " + r11 + " value", null, 4, null);
        return;
    L14:
        if (com.obric.memorydata.awareness.impl.b.f8632a.a().contains(r11) == false) goto L16;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("setFeature ").append(r11);
    L17:
        IRunLog.a.a(r4, "LocationFeatureProducer", r15.toString(), false, 4, null);
        super.setFeature(r11, r0, r14);
        if (d().contains(r11) == false) goto L25;
        if (r0 != null) goto L22;
        this.c.remove(new String[]{r11});
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L27;
        RunLog.INSTANCE.debug("LocationFeatureProducer", "store save " + r11 + " value " + ((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin")));
        this.c.save(r11, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        return;
    L27:
        return;
    L25:
        return;
    L16:
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r15 = new StringBuilder().append("setFeature ").append(r11).append(" value ").append(r0);
        goto L17
    L6:
        if (Intrinsics.areEqual(r11, "current_geofences") == false) goto L8;
        r0 = com.obric.memorydata.awareness.impl.location.a.f8729a.a(r12);
        goto L9
    L8:
        r0 = r12;
        goto L9
    }
}
