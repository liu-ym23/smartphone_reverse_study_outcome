package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ s a;

    public p(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.r.hasFocus() == false) goto L5;
        s r5 = this.a;
        r5.A = true;
        r5.f();
        return;
    L5:
        s r6 = this.a;
        s.a r0 = r6.n;
        if (r0 == null) goto L10;
        r0.a(r6.r.getText().toString().replace(" ", BuildConfig.FLAVOR), false, this.a.B);
        return;
    }
}
