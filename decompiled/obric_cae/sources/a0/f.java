package a0;

import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {
    public static Font a(FontFamily r8, int r10) {
        if ((r10 & 1) == 0) goto L5;
        int r11 = 700;
    L6:
        int r12 = 1;
        if ((r10 & 2) == 0) goto L9;
        int r13 = 1;
    L10:
        FontStyle r14 = new FontStyle(r11, r13);
        Font r15 = r8.getFont(0);
        int r16 = b(r14, r15.getStyle());
    L12:
        if (r12 >= r8.getSize()) goto L17;
        Font r17 = r8.getFont(r12);
        int r18 = b(r14, r17.getStyle());
        if (r18 >= r16) goto L16;
        r15 = r17;
        r16 = r18;
    L16:
        r12 = r12 + 1;
        goto L12
    L17:
        return r15;
    L9:
        r13 = 0;
        goto L10
    L5:
        r11 = 400;
        goto L6
    }

    public static int b(FontStyle r8, FontStyle r10) {
        int r11 = Math.abs(r8.getWeight() - r10.getWeight()) / 100;
        if (r8.getSlant() != r10.getSlant()) goto L5;
        int r12 = 0;
    L7:
        return r11 + r12;
    L5:
        r12 = 2;
        goto L7
    }
}
