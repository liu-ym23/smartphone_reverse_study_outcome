package com.ss.android.lark.keyboard.ime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;

    public f() {
    }

    public final String toString() {
        return "ImeInsetsHolder {from: " + this.a + ", to: " + this.b + ", systemBarHeight: " + this.c + ", isVisibleChange: " + this.d + ", decorFitSystemWindow: " + this.f + ", isVisible: " + this.e + '}';
    }

    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
    }
}
