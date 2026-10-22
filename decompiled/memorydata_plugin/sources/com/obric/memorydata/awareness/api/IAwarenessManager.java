package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J>\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H&J>\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H&J*\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H&J*\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\bH&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\n\u001a\u00020\bH&J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH&J\u001a\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"H&¨\u0006#"}, d2 = {"Lcom/obric/memorydata/awareness/api/IAwarenessManager;", "Lcom/bytedance/news/common/service/manager/IService;", "updatePackageInfo", "", "firstLaunch", "", "makeAwarenessFeature", "feature", "", "registerAwarenessEvent", "event", "listener", "Lcom/obric/memorydata/awareness/api/EventListener;", "unregisterAwarenessEvent", "onFeatureChanged", "oldValue", "", "newValue", WsConstants.KEY_EXTRA, "", "onFeatureEvent", "dispatchAwarenessEvent", "eventName", "dispatchTaskEvent", "isPackageAutoTriggerEnabled", ObricMemoryConstants.KEY_PACKAGE_NAME, "observeAnyListener", "Lkotlinx/coroutines/flow/StateFlow;", "getAddressByGps", "longitude", "", "latitude", "getCachedAddressByGps", "resolveAtHomeEventLocation", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAwarenessManager extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(IAwarenessManager r2, boolean r3, int r4, Object r5) {
            IAwarenessManager r6 = (IAwarenessManager) ZeusTransformUtils.wrapperContextForParams(r2, IAwarenessManager.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = false;
        L7:
            r6.updatePackageInfo(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePackageInfo");
        }
    }

    void dispatchAwarenessEvent(String r1, Map<String, ? extends Object> r2);

    void dispatchTaskEvent(String r1, Map<String, ? extends Object> r2);

    String getAddressByGps(double r1, double r3);

    String getCachedAddressByGps(double r1, double r3);

    boolean isPackageAutoTriggerEnabled(String r1);

    boolean makeAwarenessFeature(String r1);

    ar<Boolean> observeAnyListener(String r1);

    void onFeatureChanged(String r1, Object r2, Object r3, Map<String, ? extends Object> r4);

    void onFeatureEvent(String r1, Object r2, Object r3, Map<String, ? extends Object> r4);

    void registerAwarenessEvent(String r1, com.obric.memorydata.awareness.api.a r2);

    List<Double> resolveAtHomeEventLocation();

    void unregisterAwarenessEvent(String r1, com.obric.memorydata.awareness.api.a r2);

    void updatePackageInfo(boolean r1);
}
