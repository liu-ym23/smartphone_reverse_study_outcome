package com.google.common.util.concurrent;

import com.google.common.collect.a6;
import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f9413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g0 f9414b = null;

    static {
        a6 r5 = new a6();
        r5.e();
        r5.c();
        f9413a = Logger.getLogger(j0.class.getName());
        f9414b = new g0();
    }

    public static void a(h0 r5) {
        if (r5.isAcquiredByCurrentThread() == true) goto L10;
        ArrayList r10 = (ArrayList) f9414b.get();
        r5.getLockGraphNode();
        int r11 = r10.size() - 1;
    L5:
        if (r11 < 0) goto L14;
        if (r10.get(r11) == null) goto L8;
        r11 = r11 - 1;
        goto L5
    L8:
        r10.remove(r11);
        return;
    L14:
        return;
    }
}
