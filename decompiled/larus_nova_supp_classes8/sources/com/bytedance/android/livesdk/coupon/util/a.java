package com.bytedance.android.livesdk.coupon.util;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static String a(long r4) {
        double r5 = r4 / 100000.0d;
        if (Double.valueOf(r5 % ((double) 1)).equals(Double.valueOf(0.0d)) == true) goto L7;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        return String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r5)}, 1));
    L7:
        return String.valueOf((int) r5);
    }

    public static String b(long r9) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L4
        TimeUnit r3 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L4
        Object r10 = Result.constructor-impl(String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r3.toHours(r9)), Long.valueOf(r3.toMinutes(r9) - TimeUnit.HOURS.toMinutes(r3.toHours(r9))), Long.valueOf(r3.toSeconds(r9) - TimeUnit.MINUTES.toSeconds(r3.toMinutes(r9)))}, 3)));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r10) == null) goto L11;
        r10 = "00:00:00";
    L11:
        return (String) r10;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String c(long r10) {
        if (r10 > 0) goto L5;
        return "0";
    L5:
        long r3 = 100;
        long r5 = r10 % r3;
        long r11 = r10 / r3;
        if (r5 != 0) goto L10;
        return String.valueOf(r11);
    L10:
        if (r5 >= 10) goto L12;
        String r0 = "0" + r5;
    L14:
        if (r11 > 0) goto L17;
        String r12 = "0." + r0;
    L24:
        return new Regex("\\.0$").replace(new Regex("\\.00$").replace(r12, ""), "");
    L17:
        if (r11 >= 10) goto L20;
        r12 = r11 + '.' + r0;
        goto L24
    L20:
        if (r11 >= r3) goto L22;
        StringBuilder r1 = new StringBuilder();
        r1.append(r11);
        r1.append('.');
        r1.append(StringsKt.first(r0));
        r12 = r1.toString();
        goto L24
    L22:
        r12 = String.valueOf(r11);
        goto L24
    L12:
        r0 = String.valueOf(r5);
        goto L14
    }

    public static String d(long r3) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r3 / 100.0d)}, 1));
    }
}
