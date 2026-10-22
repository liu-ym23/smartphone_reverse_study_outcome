package com.ss.android.lark.message.card.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ View.OnLongClickListener a;

    public f(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        View.OnLongClickListener r0 = this.a;
        if (r0 == null) goto L7;
        r0.onLongClick(r2);
        return true;
    L7:
        return true;
    }
}
