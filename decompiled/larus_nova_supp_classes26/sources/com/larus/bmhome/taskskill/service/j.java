package com.larus.bmhome.taskskill.service;

import android.text.InputFilter;
import android.text.Spanned;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements InputFilter {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public static int a(CharSequence r7, int r8, int r9) {
        int r1 = 0;
    L3:
        if (r8 >= r9) goto L20;
        char r2 = r7.charAt(r8);
        int r4 = 1;
        if (Character.isHighSurrogate(r2) == false) goto L11;
        int r3 = r8 + 1;
        if (r3 >= r9) goto L11;
        if (Character.isLowSurrogate(r7.charAt(r3)) == false) goto L11;
        boolean r5 = true;
    L13:
        if (r2 > 127) goto L15;
        int r6 = 1;
    L16:
        r1 = r1 + r6;
        if (r5 == false) goto L19;
        r4 = 2;
    L19:
        r8 = r8 + r4;
        goto L3
    L15:
        r6 = 2;
    L11:
        r5 = false;
        goto L13
    L20:
        return r1;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r5, int r6, int r7, Spanned r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r5, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r8, "dest");
        int r11 = (40 - a(r8, 0, r9)) - a(r8, r10, r8.length());
        if (r11 > 0) goto L6;
        return "";
    L6:
        int r12 = r6;
    L7:
        if (r12 >= r7) goto L21;
        char r13 = r5.charAt(r12);
        int r1 = 2;
        if (Character.isHighSurrogate(r13) == false) goto L15;
        int r0 = r12 + 1;
        if (r0 >= r7) goto L15;
        if (Character.isLowSurrogate(r5.charAt(r0)) == false) goto L15;
        int r2 = 2;
    L17:
        if (r13 > 127) goto L19;
        r1 = 1;
    L19:
        if (r1 > r11) goto L21;
        r11 = r11 - r1;
        r12 = r12 + r2;
    L15:
        r2 = 1;
    L21:
        if (r12 != r7) goto L24;
        return null;
    L24:
        return r5.subSequence(r6, r12);
    }
}
