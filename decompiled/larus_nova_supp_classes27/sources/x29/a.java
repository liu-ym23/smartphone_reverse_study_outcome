package x29;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r6) {
        if (r6 >= 1000) goto L6;
        return String.valueOf(r6);
    L6:
        if (r6 >= 1000000) goto L9;
        return BigDecimal.valueOf(r6).divide(BigDecimal.valueOf(1000), 1, RoundingMode.HALF_UP).toPlainString() + 'K';
    L9:
        return BigDecimal.valueOf(r6).divide(BigDecimal.valueOf(1000000), 1, RoundingMode.HALF_UP).toPlainString() + 'M';
    }

    public static int b(long r4, long r6) {
        if (r4 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (r6 <= 0) goto L9;
        return BigDecimal.valueOf(r4).multiply(BigDecimal.valueOf(1000)).divide(BigDecimal.valueOf(r6), 0, RoundingMode.HALF_UP).min(BigDecimal.valueOf(1000)).min(BigDecimal.valueOf(2147483647L)).intValue();
    }
}
