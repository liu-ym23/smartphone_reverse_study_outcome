package com.larksuite.framework.utils;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final a a = null;
    public static long b;

    public class a extends v<b> {
        public a() {
            super(5);
        }

        @Override // com.larksuite.framework.utils.v
        public final b a(Object[] r7) {
            Locale r2 = null;
            if (r7.length < 1) goto L7;
            Object r0 = r7[0];
            if ((r0 instanceof TimeZone) == false) goto L7;
            TimeZone r1 = (TimeZone) r0;
        L8:
            if (r1 != null) goto L11;
            r1 = TimeZone.getDefault();
        L11:
            if (r7.length < 2) goto L15;
            Object r8 = r7[1];
            if ((r8 instanceof Locale) == false) goto L15;
            r2 = (Locale) r8;
        L15:
            if (r2 != null) goto L18;
            r2 = Locale.getDefault();
        L18:
            return new b(new j.d(new Object[]{r1, r2}), Calendar.getInstance(r1, r2));
        L7:
            r1 = null;
            goto L8
        }

        @Override // com.larksuite.framework.utils.v
        public final boolean b(b r3, Object[] r4) {
            b r5 = r3;
            if (r4[0] != null) goto L6;
            r4[0] = TimeZone.getDefault();
        L6:
            if (r4[1] != null) goto L9;
            r4[1] = Locale.getDefault();
        L9:
            return Arrays.equals(r5.a.a, r4);
        }
    }

    public static class b {
        public final j.d a;
        public final Calendar b;

        public b(j.d r1, Calendar r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new a();
    }

    public static long c() {
        if (b > 0) goto L5;
    L6:
        a r0 = a;
        b r1 = r0.c(new Object[]{null, null});
        Calendar r3 = r1.b;
        d(r3, System.currentTimeMillis());
        r3.set(11, 0);
        r3.set(12, 0);
        r3.set(13, 0);
        r3.set(14, 0);
        b = r3.getTimeInMillis();
        r0.d(r1);
    L8:
        return b;
    L5:
        if ((System.currentTimeMillis() - b) <= 86400000) goto L8;
        goto L6
    }

    public static int b(long r5, int r7) {
        TimeZone r0 = TimeZone.getDefault();
        a r1 = a;
        b r2 = r1.c(new Object[]{r0, null});
        Calendar r3 = r2.b;
        d(r3, r5);
        if (r7 != 5) goto L5;
        r7 = 5;
    L5:
        int r6 = r3.get(r7);
        if (r7 != 2) goto L9;
        r6 = r6 + 1;
    L9:
        if (r7 != 10) goto L12;
        if (r6 != 0) goto L12;
        r6 = 12;
    L12:
        r1.d(r2);
        return r6;
    }

    public static void d(Calendar r3, long r4) {
        r3.add(14, (int) (r4 - r3.getTimeInMillis()));
        if (r3.getTimeInMillis() == r4) goto L6;
        r3.setTimeInMillis(r4);
        return;
    }

    public static String a(String r5, long r6, TimeZone r8, Locale r9) {
        ConcurrentMap<j.d, j> r0 = j.f;
        if (TextUtils.isEmpty(r5) == true) goto L34;
        if (r8 != null) goto L6;
        r8 = TimeZone.getDefault();
    L6:
        if (r9 != null) goto L8;
        r9 = Locale.getDefault();
    L8:
        int r2 = 0;
        j.d r1 = new j.d(new Object[]{r5, r8, r9});
        j r3 = (j) ((ConcurrentHashMap) j.f).get(r1);
        if (r3 != null) goto L19;
        r3 = new j(r5, r8, r9);
        r3.d();     // Catch: IllegalArgumentException -> L13
    L15:
        j r7 = (j) ((ConcurrentHashMap) j.f).putIfAbsent(r1, r3);
        if (r7 == null) goto L19;
        r3 = r7;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r3.d == null) goto L40;
        TimeZone r10 = r3.b;
        Locale r11 = r3.c;
        b r12 = a.c(new Object[]{r10, r11});
        Calendar r13 = r12.b;
        r13.add(14, (int) (r6 - r13.getTimeInMillis()));
        if (r13.getTimeInMillis() == r6) goto L24;
        r13.setTimeInMillis(r6);
    L24:
        StringBuilder r14 = new StringBuilder(r3.e);
        j.g[] r15 = r3.d;     // Catch: IOException -> L29
        int r16 = r15.length;     // Catch: IOException -> L29
    L26:
        if (r2 >= r16) goto L31;
        r15[r2].appendTo(r14, r13);     // Catch: IOException -> L29
        r2 = r2 + 1;
    L31:
        String r17 = r14.toString();
        a.d(r12);
        return r17;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L40:
        return r3.a;
    L34:
        throw new IllegalArgumentException("date pattern must not be null");
    }
}
