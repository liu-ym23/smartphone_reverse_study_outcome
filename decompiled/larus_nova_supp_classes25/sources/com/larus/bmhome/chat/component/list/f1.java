package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.stop.a;
import com.larus.bmhome.chat.stop.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f1 implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ com.larus.bmhome.chat.stop.c b;

    public /* synthetic */ f1(e1 r1, com.larus.bmhome.chat.stop.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Function1 r0 = this.a;
        com.larus.bmhome.chat.stop.c r1 = this.b;
        a r5 = (a) r4;
        int r2 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r5, "candidate");
        String r3 = (String) r0.invoke(r5);
        if (r3 != null) goto L5;
    L9:
        boolean r6 = false;
    L11:
        return Boolean.valueOf(r6);
    L5:
        if (r1.c(r3) == false) goto L9;
        if (b.a(r5, r3) == true) goto L9;
        r6 = true;
        goto L11
    }
}
