package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class t implements View.OnClickListener {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ RichTextElement.ButtonProperty b;

    public /* synthetic */ t(c0 r1, RichTextElement.ButtonProperty r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        c0 r0 = this.a;
        RichTextElement.ButtonProperty r1 = this.b;
        krb.a.a(r0.f, "interaction", "button");
        if (a.a(r8) == true) goto L7;
        r0.e(r1.getConfirm(), null, r1.getActionId(), null, null, r8.getContext());
        return;
    }
}
