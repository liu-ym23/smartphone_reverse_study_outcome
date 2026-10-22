package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ c0 a;

    public j0(c0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        krb.a.a(this.a.f, "interaction", "forward");
        LKUIToast.show(r4.getContext(), 2131892336);
    }
}
