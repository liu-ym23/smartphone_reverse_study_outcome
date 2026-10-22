package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ t(UserTextCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        UserTextCell r0 = this.a;
        Message r1 = this.b;
        Message r5 = (Message) r4;
        int r2 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r5, "it");
        r0.getClass();
        return Boolean.valueOf(UserTextCell.O(r5, r1));
    }
}
