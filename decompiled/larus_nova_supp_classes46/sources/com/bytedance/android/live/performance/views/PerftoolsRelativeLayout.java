package com.bytedance.android.live.performance.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class PerftoolsRelativeLayout extends RelativeLayout {
    public Activity a;
    public Dialog b;

    public PerftoolsRelativeLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r2) {
        Dialog r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispatchKeyEvent(r2);
    L5:
        Activity r1 = this.a;
        if (r1 == null) goto L10;
        r1.dispatchKeyEvent(r2);
        return false;
    L10:
        return false;
    }

    public void setActivity(Activity r1) {
        this.a = r1;
    }

    public void setDialog(Dialog r1) {
        this.b = r1;
    }

    public PerftoolsRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public PerftoolsRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
