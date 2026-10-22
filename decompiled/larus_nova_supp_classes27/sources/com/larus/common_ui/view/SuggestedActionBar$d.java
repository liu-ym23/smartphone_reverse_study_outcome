package com.larus.common_ui.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SuggestedActionBar$d implements View.OnLayoutChangeListener {
    public final /* synthetic */ SuggestedActionBar a;
    public final /* synthetic */ Function0 b;

    public SuggestedActionBar$d(SuggestedActionBar r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.i(false, this.b);
    }
}
