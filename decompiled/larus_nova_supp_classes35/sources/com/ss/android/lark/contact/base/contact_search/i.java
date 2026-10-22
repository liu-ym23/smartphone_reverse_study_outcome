package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.ss.android.lark.utils.ViewUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ s a;

    public i(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        s r7 = this.a;
        r7.A = true;
        r7.f();
        s r8 = this.a;
        if (r8.z == false) goto L6;
        return;
    L6:
        if (r8.v.getText().length() != 0) goto L8;
        r8.y.setEnabled(false);
        return;
    L8:
        String r1 = h9b.b.a(r8.v.getText().toString());
        if (r8.u.getText().toString().equals("+86") == false) goto L15;
        if (h9b.b.b("^[1]\\d{10}$", r1) == true) goto L13;
        r8.l();
        ViewUtils.showToastShort(2131892789);
    L17:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L22;
        return;
    L22:
        if (r8.A == false) goto L29;
        r8.A = false;
        s.a r3 = r8.n;
        if (r3 == null) goto L30;
        r3.a(r8.u.getText() + h9b.b.a(r8.v.getText().toString()), true, r8.B);
        return;
    L30:
        return;
    L29:
        return;
    L13:
        r8.m(Boolean.TRUE);
    L19:
        r2 = true;
        goto L20
    L15:
        if (h9b.b.b("^\\d{1,14}$", r1) == true) goto L18;
        r8.l();
        ViewUtils.showToastShort(2131892789);
        goto L17
    L18:
        r8.m(Boolean.TRUE);
        goto L19
    }
}
