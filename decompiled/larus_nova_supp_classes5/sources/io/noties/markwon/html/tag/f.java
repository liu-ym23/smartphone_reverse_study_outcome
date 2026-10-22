package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import wsc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements e.a {
    public final tsc.c a;

    public f(tsc.c.a r1) {
        this.a = r1;
    }

    public static o.a a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        int r0 = r6.length();
        int r2 = r0 - 1;
        int r3 = r2;
    L7:
        if (r3 <= (-1)) goto L19;
        if (Character.isDigit(r6.charAt(r3)) == true) goto L10;
        r3 = r3 - 1;
        goto L7
    L10:
        int r4 = r3 + 1;
        float r5 = CastFloatProtector.parseFloat(r6.substring(0, r4));     // Catch: NumberFormatException -> L17
        if (r3 != r2) goto L14;
        String r7 = null;
    L15:
        return new o.a(r5, r7);
    L14:
        r7 = r6.substring(r4, r0);     // Catch: NumberFormatException -> L17
    L17:
        return null;
    L19:
        return null;
    }
}
