package com.ss.android.socialbase.downloader.utils;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.t;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qb.k;
import qb.m;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void a(int r10, Map<Integer, a0> r11, boolean r12, DownloadInfo r13, BaseException r14, ListenerType r15, com.ss.android.socialbase.downloader.model.d r16) {
        if (r12 == false) goto L96;
        if (r11 == null) goto L97;
    L55:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r11.size() <= 0) goto L98;
        Iterator<a0> r17 = r11.values().iterator();     // Catch: Throwable -> L55
    L8:
        if (r17.hasNext() == false) goto L99;
        a0 r18 = r17.next();     // Catch: Throwable -> L55
        if (r10 != (-7)) goto L13;
    L21:
        ((m) k.a(m.class)).b(r16);     // Catch: Throwable -> L55
    L22:
        if (r18 == null) goto L8;
        if (r10 != 1) goto L26;
        r18.r0(r13);     // Catch: Throwable -> L55
        goto L8
    L26:
        if (r10 != 2) goto L28;
        r18.D0(r13);     // Catch: Throwable -> L55
        goto L8
    L28:
        if (r10 != 4) goto L30;
        r18.Z(r13);     // Catch: Throwable -> L55
        goto L8
    L30:
        if (r10 != 5) goto L32;
        r18.G(r13, r14);     // Catch: Throwable -> L55
        goto L8
    L32:
        if (r10 != 6) goto L34;
        r18.I(r13);     // Catch: Throwable -> L55
        goto L8
    L34:
        if (r10 != 11) goto L35;
        if ((r18 instanceof t) == false) goto L8;
        ((t) r18).U(r13);     // Catch: Throwable -> L55
        goto L8
    L35:
        switch(r10) {
            case -7: goto L44;
            case -6: goto L42;
            case -5: goto L41;
            case -4: goto L40;
            case -3: goto L39;
            case -2: goto L41;
            case -1: goto L37;
            default: goto L8;
        };     // Catch: Throwable -> L55
    L37:
        r18.p0(r13, r14);     // Catch: Throwable -> L55
    L38:
        f(r16, r15, r18);     // Catch: Throwable -> L55
        goto L8
    L39:
        r18.W(r13);     // Catch: Throwable -> L55
        goto L38
    L40:
        r18.q0(r13);     // Catch: Throwable -> L55
        goto L38
    L41:
        r18.l0(r13);     // Catch: Throwable -> L55
        goto L38
    L42:
        r18.R(r13);     // Catch: Throwable -> L55
        goto L8
    L44:
        if ((r18 instanceof ib.c) == false) goto L8;
        ((ib.c) r18).a(r13);     // Catch: Throwable -> L55
        goto L38
    L13:
        if (r10 == (-4)) goto L21;
        if (r10 == (-3)) goto L21;
        if (r10 == (-2)) goto L21;
        if (r10 == (-1)) goto L21;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    }

    private static void b(int r10, Map<Integer, a0> r11, DownloadInfo r12, byte[] r13, int r14, List<Pair<String, String>> r15, String r16) {
        if (r11 == null) goto L45;
    L24:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (r11.size() <= 0) goto L46;
        Iterator<a0> r17 = r11.values().iterator();     // Catch: Throwable -> L24
    L7:
        if (r17.hasNext() == false) goto L47;
        a0 r18 = r17.next();     // Catch: Throwable -> L24
        if (r18 == null) goto L7;
        if ((r18 instanceof ib.c) == false) goto L7;
        if (r10 != 1) goto L16;
        ((ib.c) r18).b(r12, r13, r14);     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r10 != 2) goto L18;
        ((ib.c) r18).c(r12, r15);     // Catch: Throwable -> L24
        goto L7
    L18:
        if (r10 != 3) goto L7;
        ((ib.c) r18).d(r12, r16);     // Catch: Throwable -> L24
        goto L7
    L47:
        return;
    L46:
        return;
    }

    public static void c(Map<Integer, a0> r10, DownloadInfo r11, byte[] r12, int r13) {
        b(1, r10, r11, r12, r13, null, null);
    }

    public static void d(Map<Integer, a0> r10, DownloadInfo r11, List<Pair<String, String>> r12) {
        b(2, r10, r11, null, 0, r12, null);
    }

    public static void e(Map<Integer, a0> r10, DownloadInfo r11, String r12) {
        b(3, r10, r11, null, 0, null, r12);
    }

    private static void f(com.ss.android.socialbase.downloader.model.d r10, ListenerType r11, a0 r12) {
        if (r10 == null) goto L5;
        r10.a0(r11, r12);
        return;
    }
}
