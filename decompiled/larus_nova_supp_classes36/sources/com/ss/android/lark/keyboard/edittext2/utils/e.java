package com.ss.android.lark.keyboard.edittext2.utils;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.a b(com.ss.android.lark.keyboard.edittext2.base.a r1) {
        return a(r1, ExtensionsKt$copy$1.INSTANCE);
    }

    public static final int c(EditText r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.getSelectionStart() - 1;
        Character r4 = StringsKt.getOrNull(r3.getText(), r0);
        if (r4 != null) goto L6;
    L8:
        return -1;
    L6:
        if (r4.charValue() != '@') goto L8;
        return r0;
    }

    public static final SpannableStringBuilder e(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SpannableStringBuilder r0 = new SpannableStringBuilder(r10.toString());
        if ((r10 instanceof Spanned) == false) goto L12;
        Spanned r1 = (Spanned) r10;
        int r11 = r10.length();
        Object[] r2 = r1.getSpans(0, r11, Object.class);
        int r4 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L12;
        int r6 = r1.getSpanStart(r2[r5]);
        int r7 = r1.getSpanEnd(r2[r5]);
        int r8 = r1.getSpanFlags(r2[r5]);
        if (r6 >= 0) goto L9;
        r6 = 0;
    L9:
        if (r7 <= r11) goto L11;
        r7 = r11;
    L11:
        r0.setSpan(r2[r5], (r6 - 0) + 0, (r7 - 0) + 0, r8);
        r5 = r5 + 1;
    L12:
        return r0;
    }

    public static final <S extends com.ss.android.lark.keyboard.edittext2.base.a> S a(S r2, Function2<? super S, ? super S, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "action");
        S r0 = (S) r2.getClass().newInstance();
        r0.A(r2.getTarget());
        r0.d();
        r0.G(r2);
        Intrinsics.checkNotNull(r0);
        r3.invoke(r0, r2);
        return r0;
    }

    public static final void d(EditText r12, Object r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, "span");
        int r0 = r12.getSelectionEnd();
        Editable r1 = r12.getEditableText();
        int r4 = 0;
        Object[] r2 = r1.getSpans(0, r1.length(), SpanWatcher.class);
        int r3 = r2.length;
    L3:
        if (r4 >= r3) goto L5;
        ((SpanWatcher) r2[r4]).onSpanChanged(r12.getEditableText(), r13, 0, r12.getEditableText().length(), 0, r12.getEditableText().length());
        r4 = r4 + 1;
        goto L3
    L5:
        r12.setSelection(r0);
    }
}
