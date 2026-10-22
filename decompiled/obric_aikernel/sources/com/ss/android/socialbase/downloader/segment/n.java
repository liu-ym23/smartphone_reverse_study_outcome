package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static long a(@NonNull List<i> r13) {
        Iterator<i> r14 = r13.iterator();
        long r10 = 0;
    L3:
        long r11 = -1;
        long r12 = -1;
    L5:
        if (r14.hasNext() == false) goto L21;
        i r15 = r14.next();
        if (r11 == (-1)) goto L9;
        if (r15.i() > r12) goto L17;
        if (r15.c() <= r12) goto L5;
    L11:
        r12 = r15.c();
        goto L5
    L17:
        r10 = r10 + (r12 - r11);
        if (r15.e() <= 0) goto L3;
    L10:
        r11 = r15.i();
        goto L11
    L9:
        if (r15.e() <= 0) goto L5;
    L21:
        if (r11 >= 0) goto L23;
        return r10;
    L23:
        if (r12 > r11) goto L25;
        return r10;
    L25:
        return r10 + (r12 - r11);
    }

    public static long b(@NonNull List<i> r10) {
        int r11 = r10.size();
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        i r14 = r10.get(r13);
        if (r14.i() > r12) goto L10;
        if (r14.d() <= r12) goto L9;
        r12 = r14.d();
    L9:
        r13 = r13 + 1;
    L10:
        return r12;
    }
}
