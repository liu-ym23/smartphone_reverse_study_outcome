package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y implements Function3 {
    public /* synthetic */ y() {
    }

    public final Object invoke(Object r2, Object r3, Object r4) {
        int r0 = UserTextCell.z;
        Intrinsics.checkNotNullParameter((Message) r2, "<unused var>");
        Intrinsics.checkNotNullParameter((NestedFileContent) r3, "<unused var>");
        Intrinsics.checkNotNullParameter((BaseResourceViewHolder.a) r4, "<unused var>");
        return Unit.INSTANCE;
    }
}
