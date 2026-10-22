package com.obric.assistant.component;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r5 implements Function1 {
    public final /* synthetic */ OrionChatWindowComponent a;

    public /* synthetic */ r5(OrionChatWindowComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        OrionChatWindowComponent r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        int r1 = OrionChatWindowComponent.T;
        if (r6 == true) goto L23;
        com.larus.bmhome.chat.component.bottom.core.a r7 = r0.p3();
        AppCompatImageView r2 = null;
        if (r7 == null) goto L7;
        AppCompatImageView r8 = r7.o();
    L8:
        boolean r3 = false;
        if (r8 != null) goto L11;
    L16:
        if (r3 == false) goto L23;
        com.larus.bmhome.chat.component.bottom.core.a r9 = r0.p3();
        if (r9 == null) goto L20;
        r2 = r9.o();
    L20:
        if (r2 == null) goto L23;
        com.larus.utils.e1.o(r2);
        goto L23
    L11:
        if (r8.getVisibility() != 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 != true) goto L16;
        r3 = true;
        goto L16
    L13:
        r10 = false;
        goto L14
    L7:
        r8 = null;
    L23:
        return Unit.INSTANCE;
    }
}
