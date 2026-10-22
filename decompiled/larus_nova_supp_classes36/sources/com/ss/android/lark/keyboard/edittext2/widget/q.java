package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.PatternProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements InputFilter, d {

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if (PatternProtector.compile("[\\u0737]|[\\u0736]").matcher(r1).find() == true) goto L8;
        return r1;
    L8:
        return "";
    }
}
