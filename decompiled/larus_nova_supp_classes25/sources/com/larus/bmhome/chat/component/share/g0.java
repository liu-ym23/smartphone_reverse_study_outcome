package com.larus.bmhome.chat.component.share;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g0 implements View.OnClickListener {
    public final /* synthetic */ ChatShareBottomComponent a;

    public /* synthetic */ g0(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ChatShareBottomComponent r3 = this.a;
        int r0 = ChatShareBottomComponent.R;
        r3.e4().exitSelectMode();
    }
}
