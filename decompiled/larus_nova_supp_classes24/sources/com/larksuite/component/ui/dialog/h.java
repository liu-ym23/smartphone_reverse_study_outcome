package com.larksuite.component.ui.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h {
    public CharSequence a;
    public int b;

    public h() {
        this.a = "";
    }

    public h(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this();
        this.a = r2;
    }

    public h(CharSequence r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "content");
        this();
        this.a = r1;
    }
}
