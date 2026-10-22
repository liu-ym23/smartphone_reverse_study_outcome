package com.bytedance.common.utility;

import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3954b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f3955c;
    public static boolean d;

    static {
        f3953a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f3954b = new c();
    }

    public static boolean a(String r5, String r10) {
        if (b(r5) == true) goto L5;
    L6:
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.equals(r10) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r10) == true) goto L9;
        goto L6
    }

    public static boolean b(String r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static String c(byte[] r10) {
        if (r10 == null) goto L13;
        int r5 = r10.length;
        if (r5 > r10.length) goto L11;
        int r11 = r5 * 2;
        char[] r12 = new char[r11];
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r5) goto L9;
        byte r15 = r10[r13];
        int r16 = r15 & UByte.MAX_VALUE;
        int r17 = r14 + 1;
        char[] r18 = f3953a;
        r12[r14] = r18[r16 >> 4];
        r14 = r14 + 2;
        r12[r17] = r18[r15 & 15];
        r13 = r13 + 1;
        goto L6
    L9:
        return new String(r12, 0, r11);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }
}
