package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IFeedShowTaskCollector;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FeedShowTaskCollector__MemoryData_recommend implements IFeedShowTaskCollector {
    public FeedShowTaskCollector__MemoryData_recommend() {
    }

    @Override // com.bytedance.lego.init.IFeedShowTaskCollector
    public void collectTask(List<FeedShowTaskInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }
}
