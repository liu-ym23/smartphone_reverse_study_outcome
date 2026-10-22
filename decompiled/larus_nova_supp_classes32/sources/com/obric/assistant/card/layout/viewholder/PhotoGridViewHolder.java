package com.obric.assistant.card.layout.viewholder;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardPhotoGridContainerBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/PhotoGridViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "Lcom/obric/assistant/card/layout/bean/wrapper/PhotoEntityGridStyleWrapper;", "Lcom/obric/assistant/card/databinding/ObricCardPhotoGridContainerBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "itemPadding", NameKeys.UnloadStrategy_No_Strategy, "getItemPadding", "()I", "itemPadding$delegate", "Lkotlin/Lazy;", "halfItemPadding", "getHalfItemPadding", "halfItemPadding$delegate", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "MyAdapter", "MyViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoGridViewHolder extends AbsCardItemViewHolder<mca.c, ObricCardPhotoGridContainerBinding> {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: com.obric.assistant.card.layout.viewholder.PhotoGridViewHolder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/assistant/card/layout/viewholder/PhotoGridViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", NameKeys.UnloadStrategy_No_Strategy, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AnonymousClass1 extends RecyclerView.ItemDecoration {
        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.set(0, 0, 0, 0);
            GridLayoutManager r6 = r4.getLayoutManager();
            if ((r6 instanceof GridLayoutManager) == false) goto L5;
            GridLayoutManager r7 = r6;
        L6:
            if (r7 != null) goto L8;
            return;
        L8:
            r7.getSpanCount();
            r4.getChildAdapterPosition(r3);
            int r8 = PhotoGridViewHolder.j;
            throw null;
        L5:
            r7 = null;
            goto L6
        }
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r1, mca.c r2, int r3, boolean r4, boolean r5) {
        mca.c r6 = r2;
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        Intrinsics.checkNotNullParameter(r6, "entity");
        int r7 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r6.a.size(), 3), 1);
        new GridLayoutManager(getContext(), r7, 1, false);
        throw null;
    }
}
