package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g0 implements LinkEmojiTextView.f {
    public final rcc.a a;
    public final /* synthetic */ c0 b;

    public final boolean c(View r1, String r2, String r3) {
        return true;
    }

    public g0(c0 r1) {
        this.b = r1;
        this.a = new rcc.a();
    }

    public final void d(View r1, String r2, String r3) {
        krb.a.a(this.b.f, "open_link", "markdown");
        if (this.a.a() == false) goto L5;
        return;
    L5:
        this.b.getClass();
    }
}
