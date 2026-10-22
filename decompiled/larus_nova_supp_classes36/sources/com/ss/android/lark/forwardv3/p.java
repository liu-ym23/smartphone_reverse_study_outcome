package com.ss.android.lark.forwardv3;

import com.ss.android.lark.picker.base.widget.BasePicker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements BasePicker.IOnPickModeChangeListener {
    public final /* synthetic */ ForwardNewFragment a;

    public p(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final void onPickModeChanged(boolean r2) {
        this.a.q = r2;
    }
}
