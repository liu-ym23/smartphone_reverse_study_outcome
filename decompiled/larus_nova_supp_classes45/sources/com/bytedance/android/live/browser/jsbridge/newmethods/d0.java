package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ View b;

    public d0(h0 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.a.a = r2;
    }
}
