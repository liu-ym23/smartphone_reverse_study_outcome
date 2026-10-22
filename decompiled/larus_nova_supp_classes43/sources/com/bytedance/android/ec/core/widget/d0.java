package com.bytedance.android.ec.core.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 {
    public static final boolean a(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r11 = false;
        goto L8
    }

    public static final String b(PriceView r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asDescription");
        StringBuilder r0 = new StringBuilder();
        if (a(r10.getPrefixText()) == false) goto L5;
        r0.append(r10.getPrefixText());
    L5:
        String r1 = c(r10.getPriceIntegerText(), r10.getPriceDecimalText());
        CharSequence r11 = null;
        if (a(r1) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        r0.append(r1);
    L11:
        String r12 = c(r10.getMaxPriceIntegerText(), r10.getMaxPriceDecimalText());
        if (a(r12) == true) goto L15;
        r12 = null;
    L15:
        if (r12 == null) goto L18;
        r0.append(r12);
    L18:
        if (a(r10.getExtraText()) == false) goto L20;
        r11 = r0;
    L20:
        if (r11 == null) goto L23;
        r0.append(r11);
    L23:
        return r0.toString();
    }

    public static final String c(String r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        if (a(r10) == false) goto L5;
        r0.append(r10);
    L5:
        boolean r1 = true;
        if (a(r11) == false) goto L15;
        if (r0.length() != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        r0.append("0");
    L13:
        r0.append(r11);
        goto L15
    L10:
        r12 = false;
    L15:
        if (r0.length() > 0) goto L18;
        r1 = false;
    L18:
        if (r1 == false) goto L21;
        r0.append("元");
    L21:
        return r0.toString();
    }
}
