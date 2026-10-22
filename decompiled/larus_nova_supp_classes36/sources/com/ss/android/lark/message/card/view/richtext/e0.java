package com.ss.android.lark.message.card.view.richtext;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ RichTextElement.LinkProperty a;
    public final /* synthetic */ c0 b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if ((r3 instanceof LinkEmojiTextView) == false) goto L8;
        if (((TextViewFixTouchConsume) ((LinkEmojiTextView) r3)).l == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.a.getAndroidUrl()) == true) goto L10;
        String r4 = this.a.getAndroidUrl();
    L11:
        krb.a.b(this.b.f, "card_link", r4);
        this.b.getClass();
        return;
    L10:
        r4 = this.a.getUrl();
        goto L11
    }

    public e0(c0 r1, RichTextElement.LinkProperty r2) {
        this.b = r1;
        this.a = r2;
    }
}
