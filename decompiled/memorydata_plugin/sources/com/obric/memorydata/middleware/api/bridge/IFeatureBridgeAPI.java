package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tH&J<\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tH&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IFeatureBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "setFeature", "", "featureName", "", "newValue", "", WsConstants.KEY_EXTRA, "", "getFeature", "getFeatureExtra", "getFeatureValueExtra", "getSupportedFeatureList", "", "sendAwarenessEvent", "event", "sendFeatureEvent", "oldValue", "getCurrentLocationWeather", "dailySteps", "", "hourlySteps", "getWeatherOfLocation", "location", "getOAutoWhiteListApp", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IFeatureBridgeAPI extends IService {
    String getCurrentLocationWeather(int r1, int r2);

    Object getFeature(String r1);

    Map<String, Object> getFeatureExtra(String r1);

    Map<String, Object> getFeatureValueExtra(String r1);

    List<String> getOAutoWhiteListApp();

    List<String> getSupportedFeatureList();

    String getWeatherOfLocation(String r1, int r2, int r3);

    void sendAwarenessEvent(String r1, Map<String, ? extends Object> r2);

    void sendFeatureEvent(String r1, Object r2, Object r3, Map<String, ? extends Object> r4);

    void setFeature(String r1, Object r2, Map<String, ? extends Object> r3);
}
