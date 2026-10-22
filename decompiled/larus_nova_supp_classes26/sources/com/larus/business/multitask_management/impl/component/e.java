package com.larus.business.multitask_management.impl.component;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements ListUpdateCallback {
    public final RecyclerView.Adapter<?> a;
    public final int b;

    public e(RecyclerView.Adapter<?> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.a = r2;
        this.b = r3;
    }

    public final void onInserted(int r3, int r4) {
        this.a.notifyItemRangeInserted(r3 + this.b, r4);
    }

    public final void onMoved(int r3, int r4) {
        RecyclerView.Adapter<?> r0 = this.a;
        int r1 = this.b;
        r0.notifyItemMoved(r3 + r1, r4 + r1);
    }

    public final void onRemoved(int r3, int r4) {
        this.a.notifyItemRangeRemoved(r3 + this.b, r4);
    }

    public final void onChanged(int r3, int r4, Object r5) {
        this.a.notifyItemRangeChanged(r3 + this.b, r4, r5);
    }
}
