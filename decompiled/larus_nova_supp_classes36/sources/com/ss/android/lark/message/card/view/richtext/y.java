package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ RichTextElement.ButtonProperty b;
    public final /* synthetic */ MsgCardRoundedYogaLayout c;
    public final /* synthetic */ c0 d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        String r0 = this.d.f;
        if (this.a == false) goto L5;
        String r1 = "open_link";
    L6:
        krb.a.a(r0, r1, "button");
        if (a.a(r7) == false) goto L9;
        return;
    L9:
        this.d.d(this.b.getConfirm(), this.c, this.b.getActionId(), null, null);
        return;
    L5:
        r1 = "interaction";
        goto L6
    }

    public y(c0 r1, boolean r2, RichTextElement.ButtonProperty r3, MsgCardRoundedYogaLayout r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
