package com.bytedance.android.annie.container.fragment;

import android.view.View;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ AnnieFragment a;

    public k(AnnieFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        FragmentParamVoNew r11 = this.a.e;
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
    L11:
        this.a.close();
        return;
    L9:
        if (this.a.p0 == 3) goto L11;
        return;
    L5:
        if (r11.g2() != true) goto L7;
        r0 = true;
        goto L7
    }
}
