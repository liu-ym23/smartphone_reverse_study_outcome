package com.lynx.tasm.fontface;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public final String a;
    public final float b;
    public final String c;

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + Float.floatToIntBits(this.b)) * 31;
        String r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (TextUtils.equals(this.c, r6.c) == true) goto L11;
    L15:
        return false;
    L11:
        if (Float.compare(this.b, r6.b) != 0) goto L15;
        if (TextUtils.equals(this.a, r6.a) == false) goto L15;
        return true;
    }

    public g(String r1, float r2, String r3) {
        if (r1 != null) goto L6;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
