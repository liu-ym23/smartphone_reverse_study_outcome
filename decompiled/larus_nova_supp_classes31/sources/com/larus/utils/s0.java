package com.larus.utils;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 {
    public static final void b(TextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r2.setVisibility(8);
        return;
    L11:
        r2.setVisibility(0);
        r2.setText(r3);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final void a(TextView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        float r0 = r2.getPaint().measureText(r2.getText().toString());
        float r5 = r4;
        if (r0 <= r5) goto L14;
        Paint r1 = new Paint();
    L6:
        if (r0 <= r5) goto L9;
        if (r3 <= 0) goto L9;
        r3 = r3 - 1;
        r1.setTextSize(r3);
        r0 = r1.measureText(r2.getText().toString());
    L9:
        if (r3 <= 0) goto L15;
        r2.setTextSize(0, r3);
        return;
    L15:
        return;
    }

    public static final SpannableString c(SpannableString r8, int r9, int r10, float r11) {
        SpannableString r0 = new SpannableString(r8);
        Object[] r12 = r0.getSpans(r9, r10, AbsoluteSizeSpan.class);
        int r1 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        AbsoluteSizeSpan r3 = (AbsoluteSizeSpan) r12[r2];
        int r4 = r0.getSpanStart(r3);
        int r5 = r0.getSpanEnd(r3);
        int r6 = r0.getSpanFlags(r3);
        r0.removeSpan(r3);
        if (r4 >= r9) goto L7;
        r0.setSpan(r3, r4, r9, r6);
    L7:
        if (r5 <= r10) goto L9;
        r0.setSpan(new AbsoluteSizeSpan(r3.getSize(), r3.getDip()), r10, r5, r6);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        r0.setSpan(new AbsoluteSizeSpan((int) r11), r9, r10, 33);
        return r0;
    }
}
