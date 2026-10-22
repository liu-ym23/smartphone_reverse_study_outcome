package com.larus.common_ui.view;

import android.view.View;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z implements View.OnLayoutChangeListener {
    public final /* synthetic */ SuggestedActionBar a;
    public final /* synthetic */ int b;
    public final /* synthetic */ List c;
    public final /* synthetic */ Set d;
    public final /* synthetic */ Integer e;

    public z(SuggestedActionBar r1, int r2, List r3, Set r4, Integer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        SuggestedActionBar r10 = this.a;
        if (r10.r != this.b) goto L6;
        r10.h(this.c, this.d, this.e);
        return;
    }
}
