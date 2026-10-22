package com.ss.android.lark.keyboard.keyboard2.content;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnLayoutChangeListener {
    public final /* synthetic */ KeyboardMainContent a;

    public d(KeyboardMainContent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if ((!this.a.k.isEmpty()) == false) goto L5;
        this.a.k.clear();
    L5:
        this.a.l = false;
    }
}
