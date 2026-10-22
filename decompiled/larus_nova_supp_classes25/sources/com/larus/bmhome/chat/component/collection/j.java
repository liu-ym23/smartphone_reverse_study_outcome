package com.larus.bmhome.chat.component.collection;

import android.view.View;
import gd8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ ChatCollectMessageComponent a;

    public /* synthetic */ j(ChatCollectMessageComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ChatCollectMessageComponent r3 = this.a;
        int r0 = ChatCollectMessageComponent.v;
        f r4 = (f) r3.t.getValue();
        if (r4 == null) goto L6;
        r4.N9("click_back_button");
        return;
    }
}
