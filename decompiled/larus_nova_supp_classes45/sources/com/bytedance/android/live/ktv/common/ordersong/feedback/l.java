package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements TextView.OnEditorActionListener {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
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
