package com.larksuite.component.ui.dialog;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.SelectableViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class SelectableAdapter<Value, T extends SelectableViewHolder> extends RecyclerView.Adapter<T> {
    public abstract SelectableViewHolder y2();

    public SelectableAdapter() {
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        SelectableViewHolder r3 = y2();
        r3.getClass();
        return r3;
    }
}
