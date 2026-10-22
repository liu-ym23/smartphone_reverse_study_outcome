package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements TextView.OnEditorActionListener {
    public final /* synthetic */ ExplainCardTitleEditorDialog a;

    public n(ExplainCardTitleEditorDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L5;
    L14:
        ExplainCardTitleEditorDialog r4 = this.a;
        EditText r5 = (EditText) r4.S90(2131388860);
        if (r5 == null) goto L17;
        Editable r6 = r5.getText();
    L18:
        ExplainCardTitleEditorDialog.T90(r4, r6.toString());
        return true;
    L17:
        r6 = null;
        goto L18
    L5:
        if (r2 == 6) goto L14;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.getAction() == 0) goto L10;
        return false;
    L10:
        if (r3.getKeyCode() == 66) goto L14;
        return false;
    }
}
