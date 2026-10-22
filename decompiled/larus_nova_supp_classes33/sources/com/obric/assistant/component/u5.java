package com.obric.assistant.component;

import android.view.ViewGroup;
import android.widget.Space;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class u5 implements Runnable {
    public final /* synthetic */ OrionChatWindowComponent a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ u5(OrionChatWindowComponent r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OrionChatWindowComponent r0 = this.a;
        boolean r1 = this.b;
        int r2 = OrionChatWindowComponent.T;
        Space r3 = (Space) r0.I.getValue();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L10;
        if (r1 == false) goto L6;
        int r5 = i5.m0();
    L7:
        r4.height = r5;
        r3.setLayoutParams(r4);
        return;
    L6:
        r5 = i5.A();
        goto L7
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
