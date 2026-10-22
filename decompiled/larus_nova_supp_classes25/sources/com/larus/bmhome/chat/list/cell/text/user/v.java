package com.larus.bmhome.chat.list.cell.text.user;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function1 {
    public final /* synthetic */ UserTextCell a;

    public /* synthetic */ v(UserTextCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        UserTextCell r0 = this.a;
        String r4 = (String) r3;
        int r1 = UserTextCell.z;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.getClass();
        return Integer.toHexString(r4.hashCode());
    }
}
