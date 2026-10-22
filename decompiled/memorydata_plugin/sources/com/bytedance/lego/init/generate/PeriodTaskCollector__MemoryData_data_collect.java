package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IPeriodTaskCollector;
import com.bytedance.lego.init.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PeriodTaskCollector__MemoryData_data_collect implements IPeriodTaskCollector {
    public PeriodTaskCollector__MemoryData_data_collect() {
    }

    @Override // com.bytedance.lego.init.IPeriodTaskCollector
    public void collectPeriodTask(List<c> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }
}
