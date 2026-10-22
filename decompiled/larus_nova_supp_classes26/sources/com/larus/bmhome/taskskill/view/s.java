package com.larus.bmhome.taskskill.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class s implements View.OnLayoutChangeListener {
    public final /* synthetic */ v a;
    public final /* synthetic */ View b;

    public /* synthetic */ s(v r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.a.b(this.b, r5 - r3);
    }
}
