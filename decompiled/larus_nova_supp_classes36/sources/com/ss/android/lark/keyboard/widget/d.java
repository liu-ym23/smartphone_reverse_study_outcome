package com.ss.android.lark.keyboard.widget;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnKeyListener {
    public final /* synthetic */ BottomSheet a;

    public d(com.ss.android.lark.keyboard.biz.mention.j r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r2 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r3.getAction() != 1) goto L7;
        this.a.b();
        return true;
    }
}
