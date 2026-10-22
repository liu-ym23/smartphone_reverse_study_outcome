package com.bytedance.apm.trace.fps;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class RealFpsTracer$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ c this$0;

    RealFpsTracer$1(c r1) {
        this.this$0 = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        c r0 = this.this$0;
        if (r2 == 0) goto L5;
        r0.a();
        return;
    L5:
        r0.b();
    }
}
