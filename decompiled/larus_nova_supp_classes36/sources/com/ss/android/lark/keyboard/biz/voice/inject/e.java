package com.ss.android.lark.keyboard.biz.voice.inject;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceInnerEndPlugin a;

    public e(VoiceInnerEndPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if (this.a.m == true) goto L11;
        VoiceInnerEndPlugin r10 = this.a;
        if (r10.n == true) goto L7;
        return;
    L7:
        if (r10.o == false) goto L13;
        r10.o = false;
        r10.k(0);
        return;
    L13:
        return;
    }
}
