package com.ss.android.lark.flow.chat.message.block.audio;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FlowAudioPlayBar a;

    public b(FlowAudioPlayBar r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        FlowAudioPlayBar.b r3 = this.a.getAudioPlayBarListener();
        if (r3 == null) goto L6;
        r3.b(this.a.a.b);
        return;
    }
}
