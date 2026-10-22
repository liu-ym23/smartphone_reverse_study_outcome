package je0;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements InputFilter {
    public final int a;

    public a(int r1) {
        this.a = r1;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
        int r0 = this.a;
        if (r5 == null) goto L5;
        int r8 = r5.length();
    L6:
        int r1 = (r0 - r8) + (r7 - r6);
        if (r1 <= 0) goto L18;
        CharSequence r9 = null;
        if (r1 < (r4 - r3)) goto L13;
        return null;
    L13:
        if (r2 == null) goto L16;
        r9 = r2.subSequence(r3, r1 + r3);
    L16:
        return String.valueOf(r9).concat("...");
    L18:
        return "...";
    L5:
        r8 = 0;
        goto L6
    }
}
