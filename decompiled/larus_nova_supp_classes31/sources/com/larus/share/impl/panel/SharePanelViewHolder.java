package com.larus.share.impl.panel;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.share.impl.databinding.LarusShareLayoutPanelItemBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/larus/share/impl/panel/SharePanelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemViewBinding", "Lcom/larus/share/impl/databinding/LarusShareLayoutPanelItemBinding;", "<init>", "(Lcom/larus/share/impl/databinding/LarusShareLayoutPanelItemBinding;)V", "getItemViewBinding", "()Lcom/larus/share/impl/databinding/LarusShareLayoutPanelItemBinding;", "setItemViewBinding", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SharePanelViewHolder extends RecyclerView.ViewHolder {
    public final LarusShareLayoutPanelItemBinding a;

    public SharePanelViewHolder(LarusShareLayoutPanelItemBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "itemViewBinding");
        super(r2.a);
        this.a = r2;
    }
}
