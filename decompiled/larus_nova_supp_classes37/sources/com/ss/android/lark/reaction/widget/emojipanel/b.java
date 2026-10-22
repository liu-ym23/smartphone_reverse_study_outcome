package com.ss.android.lark.reaction.widget.emojipanel;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ EmojiPageNewFragment2 a;

    public b(EmojiPageNewFragment2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        WeakReference<c> r2 = this.a.d;
        if (r2 == null) goto L8;
        c r3 = r2.get();
        if (r3 == null) goto L9;
        r3.c();
        return;
    L9:
        return;
    }
}
