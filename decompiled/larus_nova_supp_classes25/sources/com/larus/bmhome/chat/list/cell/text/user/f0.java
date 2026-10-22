package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRegenForImmerseSlotCell;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f0 implements Function1 {
    public /* synthetic */ f0() {
    }

    public final Object invoke(Object r2) {
        BaseMessageSlotCell r3 = (BaseMessageSlotCell) r2;
        int r0 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r3.getClass(), MessageInboxRightRegenForImmerseSlotCell.class));
    }
}
