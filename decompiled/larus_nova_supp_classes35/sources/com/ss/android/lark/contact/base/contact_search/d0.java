package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ b0 a;

    public d0(b0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        b0 r5 = this.a;
        r5.b.x0(r5.e.getText().toString().replace(" ", BuildConfig.FLAVOR));
        KeyboardUtils.hideKeyboard(this.a.a.getActivity());
    }
}
