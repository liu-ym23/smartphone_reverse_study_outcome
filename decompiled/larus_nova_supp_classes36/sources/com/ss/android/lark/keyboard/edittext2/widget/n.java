package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements KeyListener {
    public final KeyListener a;

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.a.getInputType();
    }

    public n(KeyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "mKeyListener");
        this.a = r2;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View r2, Editable r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.clearMetaKeyState(r2, r3, r4);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View r2, Editable r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "event");
        return this.a.onKeyOther(r2, r3, r4);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View r2, Editable r3, int r4, KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r5, "event");
        if (h.a.b(r3, r4, r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.a.onKeyDown(r2, r3, r4, r5) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View r2, Editable r3, int r4, KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r5, "event");
        return this.a.onKeyUp(r2, r3, r4, r5);
    }
}
