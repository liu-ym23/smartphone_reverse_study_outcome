package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.IFeatureCollectSetting;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R2\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t0\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/FeatureCollectSetting;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IFeatureCollectSetting;", "<init>", "()V", "create", "defaultCollectMap", "", "", "", "getDefaultCollectMap", "()Ljava/util/Map;", "setDefaultCollectMap", "(Ljava/util/Map;)V", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements IFeatureCollectSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("defaultCollectMap")
    private Map<String, ? extends List<String>> f11859a;

    public e() {
        this.f11859a = MapsKt.emptyMap();
    }

    public e a() {
        return new e();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IFeatureCollectSetting
    public Map<String, List<String>> getDefaultCollectMap() {
        return this.f11859a;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IFeatureCollectSetting
    public void setDefaultCollectMap(Map<String, ? extends List<String>> r3) {
        Map<String, ? extends List<String>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f11859a = r4;
    }
}
