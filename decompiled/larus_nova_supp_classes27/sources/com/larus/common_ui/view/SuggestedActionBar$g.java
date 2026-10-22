package com.larus.common_ui.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SuggestedActionBar$g implements View.OnLayoutChangeListener {
    public final /* synthetic */ SuggestedActionBar a;

    public SuggestedActionBar$g(SuggestedActionBar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        SuggestedActionBar.a(this.a, true);
    }
}
