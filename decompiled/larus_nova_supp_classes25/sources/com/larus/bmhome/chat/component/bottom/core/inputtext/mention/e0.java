package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ MentionPanelListView a;

    public e0(MentionPanelListView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        MentionPanelListView.b(this.a);
    }
}
