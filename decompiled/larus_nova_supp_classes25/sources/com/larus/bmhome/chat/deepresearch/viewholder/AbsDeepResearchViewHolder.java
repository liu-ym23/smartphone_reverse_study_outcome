package com.larus.bmhome.chat.deepresearch.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.AbsBlockView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/viewholder/AbsDeepResearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", "<init>", "(Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;)V", "bindData", "", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "", "", "onViewRecycled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class AbsDeepResearchViewHolder extends RecyclerView.ViewHolder {
    public final AbsBlockView a;

    public AbsDeepResearchViewHolder(AbsBlockView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r2;
    }
}
