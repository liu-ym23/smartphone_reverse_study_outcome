package com.ss.android.lark.imageocr.select;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        e r4 = this.a;
        e.a(r4, r4.h, r4.i);
        return true;
    }
}
