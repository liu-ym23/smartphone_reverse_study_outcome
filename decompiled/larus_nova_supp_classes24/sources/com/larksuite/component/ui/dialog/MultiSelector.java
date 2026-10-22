package com.larksuite.component.ui.dialog;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class MultiSelector<Value> extends RecyclerView.AdapterDataObserver {
    public final void onItemRangeRemoved(int r1, int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        throw null;
    }

    public final void onItemRangeMoved(int r1, int r2, int r3) {
        if (r3 > 0) goto L5;
        return;
    L5:
        throw null;
    }
}
