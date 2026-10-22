package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends LinearLayout {
    public TextView a;

    public final TextView getTextView() {
        return this.a;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        TextView r0 = new TextView(r2);
        this.a = r0;
        addView(r0);
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
