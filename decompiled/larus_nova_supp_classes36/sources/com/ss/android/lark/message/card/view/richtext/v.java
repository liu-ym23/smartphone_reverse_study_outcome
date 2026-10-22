package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class v implements View.OnClickListener {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ RichTextElement.LinkProperty b;

    public /* synthetic */ v(c0 r1, RichTextElement.LinkProperty r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        c0 r0 = this.a;
        r0.getClass();
        if ((r3 instanceof LinkEmojiTextView) == true) goto L5;
    L7:
        r0.getClass();
        return;
    L5:
        if (((TextViewFixTouchConsume) ((LinkEmojiTextView) r3)).l == false) goto L7;
    }
}
