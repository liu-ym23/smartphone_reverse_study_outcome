package com.ss.android.lark.keyboard.editor.input;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ BaseRichTextInputPlugin a;

    public c(BaseRichTextInputPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        com.ss.android.lark.keyboard.base.q r5 = this.a.N(true);
        Iterator<com.ss.android.lark.keyboard.base.l> r1 = this.a.v.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().g(r5) == false) goto L4;
        return true;
    L8:
        return false;
    }
}
