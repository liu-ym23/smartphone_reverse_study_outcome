package com.obric.memorydata.middleware.api.settings;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R,\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00050\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/settings/IFeatureCollectSetting;", "", "defaultCollectMap", "", "", "", "getDefaultCollectMap", "()Ljava/util/Map;", "setDefaultCollectMap", "(Ljava/util/Map;)V", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IFeatureCollectSetting {
    Map<String, List<String>> getDefaultCollectMap();

    void setDefaultCollectMap(Map<String, ? extends List<String>> r1);
}
