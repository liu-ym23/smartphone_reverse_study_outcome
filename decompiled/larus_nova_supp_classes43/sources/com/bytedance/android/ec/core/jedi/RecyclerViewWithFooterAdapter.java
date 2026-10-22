package com.bytedance.android.ec.core.jedi;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/jedi/RecyclerViewWithFooterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public boolean a;

    public static final class a {
    }

    static {
    }

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r1) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r1, int r10);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r1);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r1, int r10);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r1);

    public int getItemCount() {
        if (this.a == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.a = true;
    }

    public final int getItemViewType(int r10) {
        if (this.a == false) goto L8;
        if (r10 != getBasicItemCount()) goto L8;
        return Integer.MIN_VALUE;
    L8:
        return getBasicItemViewType(r10);
    }

    public final void setShowFooter(boolean r10) {
        if (this.a == r10) goto L9;
        this.a = r10;
        if (r10 == false) goto L7;
        notifyItemInserted(getItemCount() - 1);
        return;
    L7:
        notifyItemRemoved(getItemCount());
        return;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        if (getItemViewType(r11) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r10);
        return;
    L5:
        onBindBasicViewHolder(r10, r11);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (Integer.MIN_VALUE != r11) goto L6;
        return onCreateFooterViewHolder(r10);
    L6:
        return onCreateBasicViewHolder(r10, r11);
    }
}
