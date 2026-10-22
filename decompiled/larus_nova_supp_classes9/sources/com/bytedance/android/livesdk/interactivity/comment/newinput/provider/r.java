package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements TextView.OnEditorActionListener {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r3 != null) goto L4;
    L6:
        return false;
    L4:
        if (r3.getKeyCode() != 66) goto L6;
        return true;
    }
}
