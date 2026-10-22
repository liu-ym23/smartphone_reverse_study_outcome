package com.larus.bmhome.music.utils;

import android.text.InputFilter;
import android.text.Spanned;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements InputFilter {
    public final int a;
    public final Function0<Unit> b;

    public a(int r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "dest");
        int r8 = r7 - r6;
        int r0 = this.a - (r5.length() - r8);
        if (r0 > 0) goto L10;
        if ((r4 - r3) <= r8) goto L22;
        Function0<Unit> r9 = this.b;
        if (r9 == null) goto L23;
        r9.invoke();
        return "";
    L23:
        return "";
    L22:
        return "";
    L10:
        if (r0 < (r4 - r3)) goto L12;
        return null;
    L12:
        Function0<Unit> r10 = this.b;
        if (r10 == null) goto L15;
        r10.invoke();
    L15:
        int r1 = r0 + r3;
        if (Character.isHighSurrogate(r2.charAt(r1 - 1)) == false) goto L21;
        r1 = r1 - 1;
        if (r1 != r3) goto L21;
        return "";
    L21:
        return r2.subSequence(r3, r1);
    }
}
