package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmptyGoneTextView extends TextView {
    public EmptyGoneTextView(Context r2) {
        this(r2, null);
    }

    public EmptyGoneTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setVisibility(8);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }
}
