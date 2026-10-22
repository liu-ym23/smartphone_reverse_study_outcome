package com.obric.assistant.util;

import android.text.InputFilter;
import android.text.Spanned;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o1 implements InputFilter {
    public final int a;
    public final Function0<Unit> b;

    public o1(int r1, com.obric.assistant.chat.component.bottom.core.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r6, int r7, int r8, Spanned r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r9, "dest");
        int r1 = r11 - r10;
        int r0 = this.a - (r9.length() - r1);
        FLogger r12 = FLogger.a;
        StringBuilder r2 = new StringBuilder("filter, keep: ");
        r2.append(r0);
        r2.append(", end - start: ");
        int r3 = r8 - r7;
        r2.append(r3);
        r2.append(", dend - dstart: ");
        r2.append(r1);
        r2.append(", ");
        r2.append(r7);
        r2.append(", ");
        r2.append(r8);
        r2.append(", ");
        r2.append(r10);
        r2.append(", ");
        r2.append(r11);
        r2.append(", ");
        r12.d("ObricInputLengthFilter", r2.toString());
        if (r0 > 0) goto L8;
        if (r3 <= r1) goto L20;
        Function0<Unit> r13 = this.b;
        if (r13 == null) goto L21;
        r13.invoke();
        return "";
    L21:
        return "";
    L20:
        return "";
    L8:
        if (r0 < r3) goto L10;
        return null;
    L10:
        Function0<Unit> r14 = this.b;
        if (r14 == null) goto L13;
        r14.invoke();
    L13:
        int r4 = r0 + r7;
        if (Character.isHighSurrogate(r6.charAt(r4 - 1)) == false) goto L19;
        r4 = r4 - 1;
        if (r4 != r7) goto L19;
        return "";
    L19:
        return r6.subSequence(r7, r4);
    }
}
