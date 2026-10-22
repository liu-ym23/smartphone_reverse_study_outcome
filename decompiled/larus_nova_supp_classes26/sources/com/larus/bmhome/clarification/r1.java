package com.larus.bmhome.clarification;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r1 implements y.a<wc9.e> {
    public final /* synthetic */ ClarificationComponent a;

    public r1(ClarificationComponent r1) {
        this.a = r1;
    }

    public final void c(Object r2) {
        wc9.e r3 = (wc9.e) r2;
        Intrinsics.checkNotNullParameter(r3, "new");
        if (this.a.n.a == null) goto L10;
        String r4 = r3.a;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        StringsKt.isBlank(r4);
        return;
    }
}
