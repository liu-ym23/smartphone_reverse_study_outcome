package com.larus.bmhome.chat.deepsearch.component;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/component/ConversationMessageListItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalMargin", "", "<init>", "(I)V", "spacing", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationMessageListItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public ConversationMessageListItemDecoration() {
        this(0);
    }

    public ConversationMessageListItemDecoration(int r1) {
        this.a = 0;
        this.b = i5.h();
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        super.getItemOffsets(r3, r4, r5, r6);
        int r1 = 0;
        if (r4.getVisibility() != 8) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        return;
    L8:
        if (e1.r(r5.getChildViewHolder(r4).itemView) == true) goto L29;
        LinearLayoutManager r8 = r5.getLayoutManager();
        if (r8 != null) goto L14;
        return;
    L14:
        if ((r8 instanceof LinearLayoutManager) == false) goto L16;
        LinearLayoutManager r9 = r8;
    L17:
        if (r9 != null) goto L20;
        return;
    L20:
        if (r9.getReverseLayout() == false) goto L22;
        r3.top = this.b;
        r3.bottom = 0;
    L26:
        int r10 = this.a;
        r3.left = r10;
        r3.right = r10;
        return;
    L22:
        r3.bottom = this.b;
        if (r9.getPosition(r4) != 0) goto L25;
        r1 = this.b;
    L25:
        r3.top = r1;
        goto L26
    L16:
        r9 = null;
        goto L17
    L29:
        return;
    L5:
        r7 = false;
        goto L6
    }
}
