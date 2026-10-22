package we8;

import com.larus.bmhome.chat.font.FontLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public static final String a(int r2) {
        if (r2 != FontLevel.EXTRA_SMALL.getValue()) goto L6;
        return "extra_small";
    L6:
        if (r2 != FontLevel.SMALL.getValue()) goto L9;
        return "small";
    L9:
        if (r2 != FontLevel.STANDARD.getValue()) goto L12;
    L23:
        return "standard";
    L12:
        if (r2 != FontLevel.LARGE.getValue()) goto L15;
        return "large";
    L15:
        if (r2 != FontLevel.EXTRA_LARGE.getValue()) goto L18;
        return "extra_large";
    L18:
        if (r2 != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L23;
        return "super_extra_large";
    }
}
