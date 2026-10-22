package com.obric.memorydata.observation.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/observation/api/ObservationIngest;", "Lcom/bytedance/news/common/service/manager/IService;", "writeScreenshot", "", "input", "Lcom/obric/memorydata/observation/api/ScreenshotObservationInput;", "writeAgent", "", "timestamp", "agentText", "", ObricMemoryConstants.KEY_SESSION_ID, "writeOAuto", "writeGlasses", "Lcom/obric/memorydata/observation/api/GlassesObservationInput;", "observation_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ObservationIngest extends IService {
    void writeAgent(long r1, String r3, String r4);

    void writeGlasses(a r1);

    void writeOAuto(long r1, String r3, String r4);

    long writeScreenshot(b r1);
}
