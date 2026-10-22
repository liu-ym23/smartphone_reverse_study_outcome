package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends LinearLayout {
    public TextView a;

    public i(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LayoutInflater.from(getContext()).inflate(2131561535, this, true);
        this.a = (TextView) findViewById(2131388525);
    }

    public final void setText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r0.setText(r3);
    }

    public final void setTextColor(int r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r0.setTextColor(r3);
    }
}
