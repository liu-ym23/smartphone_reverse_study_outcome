package com.ss.android.lark.chat.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 {
    public static int b(float r1) {
        if (r1 <= 0.0f) goto L7;
        r1 = UIHelper.dp2px(r1);
    L7:
        return (int) r1;
    }

    public static ConstraintLayout.LayoutParams a(float r1, float r2, int r3, int r4) {
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(b(r1), b(r2));
        float r5 = 0;
        r0.setMargins(b(r5), b(r3), b(r5), b(r4));
        return r0;
    }
}
