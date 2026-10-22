package com.larus.bot.impl.common.util;

import android.text.InputFilter;
import android.text.Spanned;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends InputFilter.LengthFilter {
    public final Function0<Unit> a;

    public c(int r1, Function0<Unit> r2) {
        super(r1);
        this.a = r2;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    public final CharSequence filter(CharSequence r4, int r5, int r6, Spanned r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r4, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r7, "dest");
        if ((getMax() - (r7.length() - (r9 - r8))) >= (r6 - r5)) goto L8;
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L8;
        r0.invoke();
    L8:
        return super.filter(r4, r5, r6, r7, r8, r9);
    }
}
