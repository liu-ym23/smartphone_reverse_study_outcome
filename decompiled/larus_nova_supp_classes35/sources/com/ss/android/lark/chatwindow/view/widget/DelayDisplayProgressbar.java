package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import s7b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DelayDisplayProgressbar extends ProgressBar {
    public final Runnable a;

    public DelayDisplayProgressbar(Context r1) {
        super(r1);
        this.a = new a(this);
    }

    public static /* synthetic */ void a(DelayDisplayProgressbar r1) {
        Object r0 = r1.getTag(2131368776);
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) r0).booleanValue() == false) goto L9;
        r1.setVisibility(0);
        return;
    }

    public DelayDisplayProgressbar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new a(this);
    }

    public DelayDisplayProgressbar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new a(this);
    }
}
