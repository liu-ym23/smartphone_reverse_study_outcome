package com.larus.bmhome.chat.component.title;

import com.larus.platform.model.UserSubInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ t(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ChatTitleComponent r0 = this.a;
        UserSubInfo r3 = (UserSubInfo) r2;
        int r4 = ChatTitleComponent.P1;
        r0.getClass();
        if (ChatTitleComponent.z3() == false) goto L6;
        r0.B4();
    L6:
        return Unit.INSTANCE;
    }
}
