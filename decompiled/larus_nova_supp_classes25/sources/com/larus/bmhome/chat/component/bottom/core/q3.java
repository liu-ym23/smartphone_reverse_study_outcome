package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q3 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ q3(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        com.larus.bmhome.instruction.g r2 = r0.vc();
        boolean r3 = false;
        if (r2 == null) goto L13;
        if (r2.yW() == false) goto L8;
        r3 = true;
        goto L13
    L8:
        ReplyOption r4 = r2.WK("office");
        if (r4 == null) goto L13;
        com.larus.bmhome.instruction.g.a.b(r2, null, r4, false, 5);
        r3 = r2.yW();
    L13:
        return Boolean.valueOf(r3);
    }
}
