package com.larus.bmhome.chat.deepresearch.component;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepResearchAiDisclaimerView;
import com.larus.bmhome.chat.deepresearch.view.MarkdownIconTextBlockView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/component/DeepResearchContentListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchContentListItemDecoration extends RecyclerView.ItemDecoration {
    public DeepResearchContentListItemDecoration() {
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.getItemOffsets(r4, r5, r6, r7);
        int r2 = 0;
        if (r5.getVisibility() != 8) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        return;
    L8:
        if (e1.r(r6.getChildViewHolder(r5).itemView) == false) goto L11;
        return;
    L11:
        if ((r5 instanceof DeepResearchAiDisclaimerView) == false) goto L14;
        r4.set(0, 0, 0, 0);
        return;
    L14:
        r4.top = 0;
        if ((r5 instanceof MarkdownIconTextBlockView) == true) goto L17;
        r4.left = i5.q();
        r4.right = i5.q();
    L17:
        int r9 = r6.getChildAdapterPosition(r5);
        RecyclerView.Adapter r10 = r6.getAdapter();
        if (r10 == null) goto L21;
        r2 = r10.getItemCount();
    L21:
        if (r9 != (r2 - 1)) goto L25;
        r4.bottom = i5.O();
        return;
    L25:
        return;
    L5:
        r8 = false;
        goto L6
    }
}
