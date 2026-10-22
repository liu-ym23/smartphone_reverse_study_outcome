package com.larus.contextwindow.impl.membership;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public static MembershipQuotaBarTier a(double r3) {
        if (r3 < 100.0d) goto L6;
        return MembershipQuotaBarTier.NEUTRAL;
    L6:
        if (r3 < 90.0d) goto L9;
        return MembershipQuotaBarTier.DANGER;
    L9:
        if (r3 < 75.0d) goto L12;
        return MembershipQuotaBarTier.WARNING;
    L12:
        if (r3 <= 0.0d) goto L15;
        return MembershipQuotaBarTier.PRIMARY;
    L15:
        return MembershipQuotaBarTier.EMPTY;
    }

    public static Double b(JsonElement r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isJsonNull() == false) goto L8;
        r4 = null;
    L8:
        if (r4 != null) goto L10;
        return null;
    L10:
        if (r4.isJsonPrimitive() == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L41;
        JsonPrimitive r5 = r4.getAsJsonPrimitive();
        if (r5 != null) goto L17;
        return null;
    L17:
        if (r5.isBoolean() == false) goto L37;
        return null;
    L37:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        Object r6 = Result.constructor-impl(Double.valueOf(CastDoubleProtector.parseDouble(StringsKt.trim(r5.getAsString()).toString())));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r6) == false) goto L26;
        r6 = null;
    L26:
        Double r7 = (Double) r6;
        if (r7 == null) goto L43;
        double r2 = r7.doubleValue();
        if (Double.isInfinite(r2) == false) goto L31;
    L33:
        boolean r3 = false;
    L34:
        if (r3 == true) goto L36;
        return null;
    L36:
        return r7;
    L31:
        if (Double.isNaN(r2) == true) goto L33;
        r3 = true;
        goto L34
    L43:
        return null;
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L41:
        return null;
    }

    public static Integer c(JsonElement r6) {
        Double r7 = b(r6);
        if (r7 == null) goto L16;
        double r0 = r7.doubleValue();
        if ((r0 % 1.0d) != 0.0d) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L10;
        return null;
    L10:
        if (r0 >= (-2.147483648E9d)) goto L12;
        return null;
    L12:
        if (r0 <= 2.147483647E9d) goto L15;
        return null;
    L15:
        return Integer.valueOf((int) r0);
    L7:
        r8 = false;
        goto L8
    L16:
        return null;
    }

    public static z29.d d(Double r14, boolean r15, boolean r16, boolean r17, String r18, String r110) {
        boolean r2 = false;
        double r4 = 0.0d;
        if (r14 == null) goto L15;
        double r7 = r14.doubleValue();
        if (Double.isInfinite(r7) == false) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        Double r9 = r14;
    L13:
        if (r9 == null) goto L15;
        double r10 = RangesKt.coerceIn(r9.doubleValue(), 0.0d, 100.0d);
    L16:
        if (r15 == false) goto L20;
        double r11 = 0.5d;
        if (r10 >= 0.5d) goto L20;
    L22:
        if (r16 == false) goto L25;
        if (r17 == true) goto L25;
        r11 = 100.0d;
    L25:
        if (r17 == true) goto L29;
        r4 = r11;
    L29:
        if (r17 == true) goto L34;
        if (r16 == false) goto L32;
    L33:
        boolean r12 = true;
    L35:
        if (r18 != null) goto L37;
    L40:
        boolean r13 = true;
    L41:
        if (r13 == true) goto L49;
        if (r110 != null) goto L44;
    L45:
        r2 = true;
    L46:
        if (r2 == true) goto L49;
        z29.a r111 = new z29.a(r18, r110);
    L51:
        return new z29.d(r10, r4, r15, r12, r17, r111);
    L44:
        if (StringsKt.isBlank(r110) == false) goto L46;
    L49:
        r111 = null;
        goto L51
    L37:
        if (StringsKt.isBlank(r18) == true) goto L40;
        r13 = false;
        goto L41
    L32:
        if (r10 >= 100.0d) goto L33;
    L34:
        r12 = false;
    L20:
        r11 = r10;
        goto L22
    L12:
        r9 = null;
        goto L13
    L7:
        if (Double.isNaN(r7) == true) goto L9;
        r8 = true;
    L15:
        r10 = 0.0d;
        goto L16
    }
}
