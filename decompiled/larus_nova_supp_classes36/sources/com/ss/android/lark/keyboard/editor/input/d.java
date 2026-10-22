package com.ss.android.lark.keyboard.editor.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BaseRichTextInputPlugin a;

    public d(BaseRichTextInputPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        BaseRichTextInputPlugin r3 = this.a;
        int r0 = com.ss.android.lark.keyboard.base.e.a;
        r3.o(true);
    }
}
