package com.ss.android.lark.coremd.utils;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import v7b.p;
import v7b.q;
import v7b.s;
import v7b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final String[] a = null;
    public static final String[] b = null;
    public static final String[] c = null;
    public static final String[] d = null;

    static {
        a = new String[]{BuildConfig.FLAVOR, "M", "MM", "MMM"};
        b = new String[]{BuildConfig.FLAVOR, "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        c = new String[]{BuildConfig.FLAVOR, "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        d = new String[]{BuildConfig.FLAVOR, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    }

    public static int a(v7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        int r0 = -1;
    L4:
        if ((r2 instanceof v7b.c) == true) goto L9;
        if ((r2 instanceof u) == true) goto L9;
        return r0;
    L9:
        r2 = (v7b.a) ((p) r2).d;
        r0 = r0 + 1;
        goto L4
    }

    public static int b(u r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "target");
        Integer r0 = r2.k;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        s r4 = r2.e;
    L7:
        if (r4 == null) goto L13;
        if (Intrinsics.areEqual(r4, r3) == true) goto L13;
        r4 = r4.h;
        if ((r4 instanceof q) == false) goto L7;
        r1 = r1 + 1;
    L13:
        return r1;
    L5:
        r1 = 1;
        goto L6
    }

    public static String c(int r5, int r6) {
        int r7 = r6 % 3;
        if (r7 != 0) goto L5;
        StringBuilder r8 = new StringBuilder();
        r8.append(r5);
        r8.append('.');
        return r8.toString();
    L5:
        if (r7 != 1) goto L7;
        StringBuilder r9 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        int r10 = Math.max(1, r5);
    L15:
        if (r10 <= 0) goto L17;
        int r11 = r10 - 1;
        r2.insert(0, String.valueOf((char) (((r11 % 26) + 1) + 96)));
        r10 = r11 / 26;
        goto L15
    L17:
        r9.append(r2.toString());
        r9.append('.');
        return r9.toString();
    L7:
        if (r7 == 2) goto L9;
        StringBuilder r12 = new StringBuilder();
        r12.append(r5);
        r12.append('.');
        return r12.toString();
    L9:
        StringBuilder r13 = new StringBuilder();
        if (r5 != 0) goto L12;
        String r14 = BuildConfig.FLAVOR;
    L13:
        r13.append(r14);
        r13.append('.');
        return r13.toString();
    L12:
        r14 = (a[r5 / 1000] + b[(r5 % 1000) / 100] + c[(r5 % 100) / 10] + d[r5 % 10]).toLowerCase(Locale.getDefault());
        goto L13
    }
}
