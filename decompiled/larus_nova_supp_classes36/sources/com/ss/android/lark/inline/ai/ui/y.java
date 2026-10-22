package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements PromptsRecyclerView.b {
    public final /* synthetic */ InlineAIPanelController a;

    public y(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView.b
    public final void a(boolean r2) {
        if (this.a.y.getVisibility() != 0) goto L10;
        View r0 = this.a.z;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }
}
