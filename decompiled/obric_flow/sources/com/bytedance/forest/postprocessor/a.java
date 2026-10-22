package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.p;
import com.bytedance.forest.model.w;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends ForestPostProcessor {
    public abstract void onBuiltinProcess(w r5);

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public void onPostProcess$forest_release(f r5) {
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public ProcessedData<w> onProcess(f r5) {
        w r10 = r5.f4552i;
        onBuiltinProcess(r10);
        p r11 = r10.i();
        int r12 = 1;
        if (r11 == null) goto L6;
        r12 = RangesKt.coerceAtLeast(r11.size(), 1);
    L6:
        return new ProcessedData(r12, r10);
    }
}
