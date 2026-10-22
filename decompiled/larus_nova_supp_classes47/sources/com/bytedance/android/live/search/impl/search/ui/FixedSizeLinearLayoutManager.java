package com.bytedance.android.live.search.impl.search.ui;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/FixedSizeLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedSizeLinearLayoutManager extends LinearLayoutManager {
    public int a;
    public final int b;

    public FixedSizeLinearLayoutManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 0, true);
        this.a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
    }

    public final void setMeasuredDimension(int r3, int r4) {
        int r0 = this.a;
        if (r3 <= r0) goto L7;
        int r1 = this.b;
        if (r4 <= r1) goto L7;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.setMeasuredDimension(r0, r1);
        return;
    L7:
        if (r3 > r0) goto L9;
    L11:
        if (r3 > r0) goto L15;
        int r2 = this.b;
        if (r4 <= r2) goto L15;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.setMeasuredDimension(r3, r2);
        return;
    L15:
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.setMeasuredDimension(r3, r4);
        return;
    L9:
        if (r4 > this.b) goto L11;
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.setMeasuredDimension(r0, r4);
    }
}
