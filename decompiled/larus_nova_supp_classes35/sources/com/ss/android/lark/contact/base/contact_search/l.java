package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.ss.android.lark.utils.ViewUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnFocusChangeListener {
    public final /* synthetic */ s a;

    public l(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r7, boolean r8) {
        boolean r9 = true;
        if (r8 == true) goto L5;
        s r10 = this.a;
        if (r10.r.getText().length() != 0) goto L13;
        r10.y.setEnabled(false);
        return;
    L13:
        if (h9b.b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r10.r.getText().toString().replace(" ", BuildConfig.FLAVOR)) == true) goto L15;
        r10.s.setText(r10.r.getText());
        r10.s.setVisibility(0);
        r10.r.setVisibility(8);
        ViewUtils.showToastShort(2131892788);
        r10.y.setEnabled(false);
        r9 = false;
    L16:
        if (r9 == true) goto L18;
        return;
    L18:
        if (r10.A == false) goto L26;
        r10.A = false;
        s.a r11 = r10.n;
        if (r11 == null) goto L27;
        r11.a(r10.r.getText().toString().replace(" ", BuildConfig.FLAVOR), false, r10.B);
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r10.s.setVisibility(8);
        r10.r.setVisibility(0);
        r10.y.setEnabled(true);
        goto L16
    L5:
        if (this.a.r.getText().length() != 0) goto L7;
        this.a.y.setEnabled(false);
    L8:
        this.a.r.setVisibility(0);
        this.a.s.setVisibility(8);
        return;
    L7:
        this.a.y.setEnabled(true);
        goto L8
    }
}
