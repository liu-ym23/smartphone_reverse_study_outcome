package com.obric.assistant.card;

import android.view.View;
import com.obric.oui.sheet.v2.OSheet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements View.OnLayoutChangeListener {
    public final /* synthetic */ OSheet a;
    public final /* synthetic */ ShowAllDialogFragment b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public p(ShowAllDialogFragment.b r1, ShowAllDialogFragment r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        ShowAllDialogFragment.X90(this.a, this.b, this.c, this.d, this.e);
    }
}
