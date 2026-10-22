package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0 implements View.OnClickListener {
    public final /* synthetic */ j0.c a;

    public l0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        KeyEvent r4 = new KeyEvent(0, 67);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.o.a;
        if (r0 == null) goto L8;
        EditText r1 = r0.a;
        if (r1 == null) goto L9;
        r1.dispatchKeyEvent(r4);
        return;
    L9:
        return;
    }
}
