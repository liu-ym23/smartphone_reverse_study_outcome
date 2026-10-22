package com.larus.bmhome.chat.cell.slot;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageOutboxRetrySlotCell;", "Lcom/larus/bmhome/chat/cell/slot/MessageInboxRightRetrySlotCell;", "<init>", "()V", "getContainerId", "", "onSlotViewCreated", "", "slotCellView", "Landroid/view/View;", "onBindView", "view", "state", "Lcom/larus/bmhome/chat/cell/slot/MessageRetryBlockState;", "position", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageOutboxRetrySlotCell extends MessageInboxRightRetrySlotCell {
    @Override // com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell, com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final int f() {
        return 2131379991;
    }

    public MessageOutboxRetrySlotCell() {
    }

    @Override // com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "slotCellView");
        ConstraintLayout.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r4 = r3;
    L6:
        if (r4 == null) goto L9;
        ((ViewGroup.MarginLayoutParams) r4).width = -2;
        ((ViewGroup.MarginLayoutParams) r4).height = -2;
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.rightToRight = 0;
        r4.setMarginEnd(i5.h());
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell
    public final void l(View r2, final g0 r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "state");
        super.l(r2, r3, r4);
        t0.a(new e0(r3, this));
    }

    @Override // com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell, com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell
    public final /* bridge */ /* synthetic */ void onBindView(View r1, ei9.f r2, int r3) {
        l(r1, (g0) r2, r3);
    }
}
