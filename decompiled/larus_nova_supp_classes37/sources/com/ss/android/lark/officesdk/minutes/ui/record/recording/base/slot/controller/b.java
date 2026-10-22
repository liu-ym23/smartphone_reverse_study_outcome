package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.b();
        this.a.j.invoke();
    }
}
