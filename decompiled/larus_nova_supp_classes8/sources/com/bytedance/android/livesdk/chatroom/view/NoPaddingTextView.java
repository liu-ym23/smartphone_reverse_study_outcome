package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NoPaddingTextView extends AppCompatTextView {
    public NoPaddingTextView(Context r3) {
        this(r3, null, 0);
    }

    public NoPaddingTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NoPaddingTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        Paint r4 = new Paint();
        r4.setTextSize(getTextSize());
        Paint.FontMetricsInt r5 = r4.getFontMetricsInt();
        setPadding(0, -Math.abs(r5.top - r5.ascent), 0, r5.top - r5.ascent);
    }
}
