package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements View.OnLayoutChangeListener {
    public final /* synthetic */ FlowMessageSelectPlugin a;

    public i(FlowMessageSelectPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        FlowMessageSelectPlugin.I(this.a);
    }
}
