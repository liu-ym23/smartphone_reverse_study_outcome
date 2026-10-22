package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Function1<f5b.b, f5b.b> {
    public final n5b.a a;

    public h(n5b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "threadInfo");
        this.a = r2;
    }

    public final Object invoke(Object r4) {
        Object r5 = (f5b.b) r4;
        if ((r5 instanceof y6b.c) == false) goto L5;
        y6b.c r0 = (y6b.c) r5;
    L6:
        if (r0 == null) goto L8;
        List<y6b.f> r1 = u2b.c.c(this.a.e);
        r0.T1 = this.a.b.getReplyCount();
        r0.g2 = r1;
    L8:
        return r5;
    L5:
        r0 = null;
        goto L6
    }
}
