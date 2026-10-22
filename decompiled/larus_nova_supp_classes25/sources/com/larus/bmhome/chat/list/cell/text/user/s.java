package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ s(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        String r0 = this.a;
        Message r4 = (Message) r3;
        int r1 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r4, "it");
        return Boolean.valueOf(Intrinsics.areEqual(com.larus.im.bean.message.a.g(r4), r0));
    }
}
