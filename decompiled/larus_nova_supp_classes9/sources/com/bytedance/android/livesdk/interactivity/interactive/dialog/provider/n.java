package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ j.b a;

    public n(j.b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        KeyEvent r4 = new KeyEvent(0, 67);
        k82.a r0 = this.a.n.a;
        if (r0 == null) goto L8;
        EditText r1 = r0.a;
        if (r1 == null) goto L9;
        r1.dispatchKeyEvent(r4);
        return;
    L9:
        return;
    }
}
