package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.middleware.api.settings.ICommonFeatureSettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/CommonFeatureSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/ICommonFeatureSettings;", "<init>", "()V", "create", "enableStrictBatteryCharge10Min", "", "getEnableStrictBatteryCharge10Min", "()Z", "enableContextAwarenessEnhancedTimeliness", "getEnableContextAwarenessEnhancedTimeliness", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements ICommonFeatureSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enableStrictBatteryCharge10Min")
    private final boolean f11855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("enableContextAwarenessEnhancedTimeliness")
    private final boolean f11856b;

    public c() {
        this.f11855a = true;
        this.f11856b = true;
    }

    public c a() {
        return new c();
    }

    @Override // com.obric.memorydata.middleware.api.settings.ICommonFeatureSettings
    public boolean getEnableContextAwarenessEnhancedTimeliness() {
        return this.f11856b;
    }

    @Override // com.obric.memorydata.middleware.api.settings.ICommonFeatureSettings
    public boolean getEnableStrictBatteryCharge10Min() {
        return this.f11855a;
    }
}
