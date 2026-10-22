package com.obric.memorydata.awareness.impl.collector;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000b\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/ForegroundAppFeatureCollector;", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "<init>", "()V", "startCollect", "", "stopCollect", "queryFeatureAndExtra", "Lkotlin/Pair;", "", "", "", "featureName", "onAppOpen", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends e implements af.a {
    public f() {
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public Pair<Object, Map<String, Object>> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        String r1 = af.f13160a.b();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return TuplesKt.to("", null);
    L7:
        return TuplesKt.to(r1, MapsKt.mapOf(TuplesKt.to(Api.KEY_APP_NAME, af.f13160a.a())));
    }

    @Override // com.obric.memorydata.utils.af.a
    public void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        FeatureManager.INSTANCE.setFeature("device_foreground_app", r3, MapsKt.mapOf(TuplesKt.to(Api.KEY_APP_NAME, r2)));
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void b() {
        super.b();
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.utils.af.a
    public void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r3, af.f13160a.b()) == true) goto L5;
        return;
    L5:
        FeatureManager.INSTANCE.setFeature("device_foreground_app", "", null);
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void c() {
        super.c();
        af.f13160a.b((af.a) ZeusTransformUtils.preCheckCast(this, af.a.class, "com.obric.memorydata.plugin"));
    }
}
