package com.ss.android.lark.keyboard.editor.input;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ BaseRichTextInputPlugin a;
    public final /* synthetic */ String b;

    public g(BaseRichTextInputPlugin r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.b.d(this.b);
    }
}
