package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements InputFilter, d {
    public final FunctionEditText a;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.widget.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    static {
    }

    public a(FunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "richEditor");
        this.a = r2;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
        if (r1 != null) goto L6;
        return "";
    L6:
        if (r1.length() >= 10) goto L8;
        return r1;
    L8:
        List<String> r7 = com.ss.android.lark.keyboard.edittext2.utils.b.a;
        if (com.ss.android.lark.keyboard.edittext2.utils.b.c(r1, 0, r1.length()) == false) goto L12;
        return r1;
    L12:
        if ((r1 instanceof Spannable) == false) goto L14;
        Spannable r8 = (Spannable) r1;
    L15:
        ((eob.a) this.a.q(eob.a.f)).Z(r8, r2, r3);
        return r8;
    L14:
        r8 = com.ss.android.lark.keyboard.edittext2.utils.e.e(r1);
        goto L15
    }
}
