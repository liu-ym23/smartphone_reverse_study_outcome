package com.larus.bmhome.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ChatMessageList b;
    public final /* synthetic */ int c;

    public a1(ChatMessageList r2, int r3) {
        this.a = false;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r1, "view");
        r1.removeOnLayoutChangeListener(this);
        if (this.a == false) goto L5;
    L6:
        ChatMessageList r10 = this.b;
        if (r10.A == false) goto L9;
        return;
    L9:
        if (r10.R() == true) goto L17;
        ChatMessageList r11 = this.b;
        r11.S();
        if (r11.j == true) goto L18;
        ChatMessageList.u(this.b, this.c);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (this.b.E == false) goto L6;
    }
}
