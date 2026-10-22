package com.bytedance.android.annie.container.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ AnnieFragment a;

    public l(AnnieFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        AnnieFragment r11 = this.a;
        int r0 = AnnieFragment.H1;
        r11.getClass();
        FragmentActivity r12 = this.a.getActivity();
        if (r12 == null) goto L6;
        AnnieFragment r1 = this.a;
        ((z9.b) r1.getService(z9.b.class)).D(r1.aa0(), r12);
        return;
    }
}
