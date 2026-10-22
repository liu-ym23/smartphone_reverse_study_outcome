package com.larus.slides.impl.select;

import com.larus.common.mockloading.ILoadingProgressMocker;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 implements ILoadingProgressMocker {
    public final StateFlowImpl a;

    public final int getProgress() {
        return ((Number) this.a.getValue()).intValue();
    }

    public b0() {
        this.a = j1.a(0);
    }

    public final void setProgress(int r2) {
        this.a.setValue(Integer.valueOf(r2));
    }
}
