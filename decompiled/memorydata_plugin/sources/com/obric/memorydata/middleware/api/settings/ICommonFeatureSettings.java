package com.obric.memorydata.middleware.api.settings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/ICommonFeatureSettings;", "", "enableStrictBatteryCharge10Min", "", "getEnableStrictBatteryCharge10Min", "()Z", "enableContextAwarenessEnhancedTimeliness", "getEnableContextAwarenessEnhancedTimeliness", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICommonFeatureSettings {
    boolean getEnableContextAwarenessEnhancedTimeliness();

    boolean getEnableStrictBatteryCharge10Min();
}
