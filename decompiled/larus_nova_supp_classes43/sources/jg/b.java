package jg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(long r10) {
        long r1 = 100;
        if ((r10 % r1) != 0) goto L6;
        return String.valueOf(r10 / r1);
    L6:
        if ((r10 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(a(r10, 100, 1))}, 1));
    L8:
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(a(r10, 100, 2))}, 1));
    }

    public static double a(double r1, double r10, int r11) {
        if (r11 < 0) goto L6;
        return new BigDecimal(String.valueOf(r1)).divide(new BigDecimal(String.valueOf(r10)), r11, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
