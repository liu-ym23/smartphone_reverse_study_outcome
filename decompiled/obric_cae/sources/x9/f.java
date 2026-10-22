package x9;

import android.content.res.Configuration;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static Typeface a(Configuration r8, Typeface r10) {
        int r11 = r8.fontWeightAdjustment;
        if (r11 == Integer.MAX_VALUE) goto L8;
        if (r11 == 0) goto L10;
        if (r10 != null) goto L7;
        return null;
    L7:
        return Typeface.create(r10, t2.b.p(r10.getWeight() + r8.fontWeightAdjustment, 1, 1000), r10.isItalic());
    L10:
        return null;
    L8:
        return null;
    }
}
