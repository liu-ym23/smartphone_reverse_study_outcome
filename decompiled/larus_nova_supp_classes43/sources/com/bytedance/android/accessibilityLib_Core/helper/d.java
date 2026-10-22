package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends c {
    public final FrameLayout a;

    @Override // android.view.Window
    public final View getDecorView() {
        return this.a;
    }

    @Override // android.view.Window
    public final View peekDecorView() {
        return this.a;
    }

    public d(Context r1, FrameLayout r10) {
        super(r1);
        this.a = r10;
    }
}
