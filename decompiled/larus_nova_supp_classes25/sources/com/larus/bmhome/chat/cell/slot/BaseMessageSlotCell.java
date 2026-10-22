package com.larus.bmhome.chat.cell.slot;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import ei9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H&J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0018H&¢\u0006\u0002\u0010\u0019J%\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Lcom/larus/ui/arch/component/external/delegate/BaseCellComponentFeature;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "itemHolderView", "Landroid/view/View;", "getItemHolderView", "()Landroid/view/View;", "setItemHolderView", "(Landroid/view/View;)V", "onCreate", "", "getContainerId", "", "transformState", "state", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "(Lcom/larus/bmhome/chat/cell/BaseMessageCellState;)Lcom/larus/list/arch/IFlowListCellState;", "onBindView", "view", "position", "(Landroid/view/View;Lcom/larus/list/arch/IFlowListCellState;I)V", "onSlotViewCreated", "slotCellView", "onSlotCellVisibilityChange", "isVisible", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class BaseMessageSlotCell<STATE extends ei9.f> extends BaseCellComponentFeature<STATE> {
    public RecyclerView b;
    public View c;

    public abstract int f();

    public void g(boolean r1) {
    }

    public void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "slotCellView");
    }

    public abstract STATE k(xc8.b r1);

    public void onBindView(View r1, STATE r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public BaseMessageSlotCell() {
    }

    public final void onCreate(RecyclerView r1) {
        this.b = r1;
    }
}
