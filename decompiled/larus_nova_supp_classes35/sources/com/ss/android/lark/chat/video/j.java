package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        h r4 = this.a;
        boolean r0 = r4.m.isSelected();
        if (r0 == false) goto L7;
        h.f r1 = r4.w;
        if (r1 == null) goto L8;
        r1.onPlay();
    L8:
        r4.m.setSelected(!r0);
        return;
    L7:
        r4.o();
        goto L8
    }
}
