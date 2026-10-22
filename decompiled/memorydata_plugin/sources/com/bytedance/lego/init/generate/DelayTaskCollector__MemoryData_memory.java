package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IDelayTaskCollector;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DelayTaskCollector__MemoryData_memory implements IDelayTaskCollector {
    public DelayTaskCollector__MemoryData_memory() {
    }

    @Override // com.bytedance.lego.init.IDelayTaskCollector
    public void collectDelayTask(List<DelayTaskInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }
}
