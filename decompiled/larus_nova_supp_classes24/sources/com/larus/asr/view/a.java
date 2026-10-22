package com.larus.asr.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ a(ChatSpeaker r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ChatSpeaker r10 = this.a;
        int r11 = ChatSpeaker.T;
        if ((r4 - r2) == (r8 - r6)) goto L6;
        r10.S5();
        return;
    }
}
