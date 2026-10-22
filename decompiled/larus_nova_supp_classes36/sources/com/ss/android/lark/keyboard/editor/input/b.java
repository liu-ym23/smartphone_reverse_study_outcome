package com.ss.android.lark.keyboard.editor.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BaseRichTextInputPlugin a;

    public b(BaseRichTextInputPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        BaseRichTextInputPlugin.l0(this.a, true, false, null, null, null, false, null, null, 254);
    }
}
