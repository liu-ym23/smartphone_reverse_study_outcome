package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.bmhome.chat.e5;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ UserTextCell a;

    public /* synthetic */ i(UserTextCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        UserTextCell r0 = this.a;
        int r1 = UserTextCell.z;
        e5 r2 = (e5) lf8.a.c(r0, e5.class);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new e5(0);
    }
}
