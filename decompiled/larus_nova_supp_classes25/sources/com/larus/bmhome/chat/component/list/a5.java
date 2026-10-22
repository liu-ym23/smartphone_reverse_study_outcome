package com.larus.bmhome.chat.component.list;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.list.base.MessageCellHolder;
import com.larus.bmhome.chat.list.cell.botmaker.BotMakerCell;
import com.larus.list.arch.FlowListViewHolder;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a5 implements Function2 {
    public /* synthetic */ a5() {
    }

    public final Object invoke(Object r1, Object r2) {
        ((Integer) r1).intValue();
        MessageCellHolder r3 = (RecyclerView.ViewHolder) r2;
        int r4 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof MessageCellHolder) == true) goto L5;
    L7:
        boolean r5 = false;
    L9:
        return Boolean.valueOf(r5);
    L5:
        if (BotMakerCell.class.isInstance(((FlowListViewHolder) r3).b) == false) goto L7;
        r5 = true;
        goto L9
    }
}
