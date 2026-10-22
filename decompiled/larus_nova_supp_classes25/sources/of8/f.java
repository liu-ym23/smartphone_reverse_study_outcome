package of8;

import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.list.cell.block.BlockCell;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function1 {
    public /* synthetic */ f() {
    }

    public final Object invoke(Object r2) {
        BaseMessageSlotCell r3 = (BaseMessageSlotCell) r2;
        int r0 = BlockCell.q;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r3.getClass(), MessageInboxRightRetrySlotCell.class));
    }
}
