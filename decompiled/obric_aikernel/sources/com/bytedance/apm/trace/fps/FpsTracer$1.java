package com.bytedance.apm.trace.fps;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class FpsTracer$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ b this$0;

    FpsTracer$1(b r10) {
        this.this$0 = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView r10, int r11) {
        super.onScrollStateChanged(r10, r11);
        b r12 = this.this$0;
        if (r11 == 0) goto L5;
        r12.M();
        return;
    L5:
        r12.Q();
    }
}
