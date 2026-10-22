package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ InteractPkRecordFragmentNew a;

    public k(InteractPkRecordFragmentNew r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        InteractPkRecordFragmentNew r3 = this.a;
        if (r3.m == false) goto L5;
        r3.d.dismiss();
        return;
    L5:
        r3.d.v0();
    }
}
