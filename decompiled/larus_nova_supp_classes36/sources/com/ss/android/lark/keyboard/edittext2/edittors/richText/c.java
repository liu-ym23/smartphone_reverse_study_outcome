package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.h0;
import com.ss.android.lark.widget.span.l0;
import com.ss.android.lark.widget.span.q;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lec.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final void a(SpannableStringBuilder r2, int r3, int r4, TextStyleInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isBold == false) goto L8;
        r2.setSpan(new com.ss.android.lark.widget.span.c(), r3, r4, 33);
    L8:
        if (r5.isItalic == false) goto L11;
        r2.setSpan(new q(), r3, r4, 33);
    L11:
        if (r5.isUnderlineText == false) goto L14;
        r2.setSpan(new l0(), r3, r4, 33);
    L14:
        if (r5.isStrikeThruText == false) goto L18;
        r2.setSpan(new h0(), r3, r4, 33);
        return;
    }

    public static final void b(SpannableStringBuilder r2, int r3, int r4, Map<String, String> r5, Context r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L19;
        if (r3 > r4) goto L20;
        if (r3 >= 0) goto L13;
        return;
    L13:
        if (r4 > r2.length()) goto L22;
        if (r6 != null) goto L17;
        r6 = UIHelper.getContext();
    L17:
        String r1 = r2.subSequence(r3, r4).toString();
        f r7 = new f(r6);
        r7.d();
        r7.c(r5);
        a(r2, r3, r4, r7.e(r1));
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r5.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }
}
