package com.bytedance.android.live.browser;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ HybridDebugFragment a;

    public s(HybridDebugFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        w r3 = this.a.g;
        if (r3 == null) goto L6;
        r3.setEnableDevtoolDebug(r2);
        return;
    }
}
