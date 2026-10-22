package com.larus.bmhome.chat.layout.widget;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class w0 extends ClickableSpan implements View.OnLongClickListener {
    public final View.OnClickListener a;
    public final View.OnLongClickListener b;

    @Override // android.text.style.ClickableSpan
    public void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        View.OnLongClickListener r0 = this.b;
        if (r0 == null) goto L7;
        r0.onLongClick(r2);
        return true;
    L7:
        return true;
    }

    public w0(View.OnClickListener r1, View.OnLongClickListener r2) {
        this.a = r1;
        this.b = r2;
    }
}
