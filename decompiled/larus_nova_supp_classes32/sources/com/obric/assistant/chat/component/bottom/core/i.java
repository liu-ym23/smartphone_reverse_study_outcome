package com.obric.assistant.chat.component.bottom.core;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ ObricChatInputComponent a;

    public /* synthetic */ i(ObricChatInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ObricChatInputComponent r0 = this.a;
        boolean r5 = ((Boolean) r4).booleanValue();
        int r1 = 0;
        r0.H = false;
        if (r5 == true) goto L5;
        r0.G = 0;
    L5:
        FrameLayout r6 = r0.X2();
        if (r6 == null) goto L13;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L11:
        if (r8 == null) goto L14;
        r1 = r8.bottomMargin;
    L14:
        r0.p4(r1);
        return Unit.INSTANCE;
    L10:
        r8 = null;
        goto L11
    L13:
        r1 = 56;
        goto L14
    }
}
