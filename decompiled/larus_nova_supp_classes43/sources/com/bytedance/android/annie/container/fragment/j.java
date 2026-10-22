package com.bytedance.android.annie.container.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ AnnieFragment a;

    public j(AnnieFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        AnnieFragment r11 = this.a;
        int r0 = AnnieFragment.H1;
        r11.getClass();
        if (this.a.canBack() == false) goto L6;
        this.a.back();
        return;
    L6:
        this.a.close();
    }
}
