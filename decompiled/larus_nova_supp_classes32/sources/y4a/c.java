package y4a;

import com.lynx.animax.ui.ObjectFit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static ObjectFit a(String r2) {
        ObjectFit r0 = ObjectFit.CONTAIN;
        if ("cover".equals(r2) == false) goto L6;
        return ObjectFit.COVER;
    L6:
        if ("center".equals(r2) == false) goto L9;
        return ObjectFit.CENTER;
    L9:
        if ("fill".equals(r2) == false) goto L12;
        return ObjectFit.FILL;
    L12:
        if ("scale-down".equals(r2) == true) goto L14;
        return r0;
    L14:
        return ObjectFit.SCALE_DOWN;
    }
}
