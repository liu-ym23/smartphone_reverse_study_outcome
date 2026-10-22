package com.ss.android.lark.keyboard.keyboard2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class m {
    public com.ss.android.lark.keyboard.b a;
    public boolean b;

    public m() {
    }

    public abstract int a();

    public int b() {
        return 2131102493;
    }

    public abstract KeyboardMenuItemKey g();

    public Integer q() {
        return null;
    }

    public abstract void s();

    public void u() {
    }

    public void v() {
    }

    public void w(boolean r1) {
    }

    public void x(i r2) {
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
    }

    public void y(boolean r1) {
    }

    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }
}
