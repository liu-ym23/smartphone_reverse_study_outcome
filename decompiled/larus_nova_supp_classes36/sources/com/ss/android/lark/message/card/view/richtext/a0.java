package com.ss.android.lark.message.card.view.richtext;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ RichTextElement.LinkProperty a;
    public final /* synthetic */ c0 b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (TextUtils.isEmpty(this.a.getAndroidUrl()) == true) goto L5;
        String r4 = this.a.getAndroidUrl();
    L6:
        krb.a.b(this.b.f, "card_link", r4);
        this.b.getClass();
        return;
    L5:
        r4 = this.a.getUrl();
        goto L6
    }

    public a0(c0 r1, RichTextElement.LinkProperty r2) {
        this.b = r1;
        this.a = r2;
    }
}
