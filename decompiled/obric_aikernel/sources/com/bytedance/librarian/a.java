package com.bytedance.librarian;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f2124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile String f2125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static c f2126c;

    static {
    }

    public static void a(String r10, Context r11) {
        b(r10, false, true, r11);
    }

    private static void b(String r10, boolean r11, boolean r12, Context r13) {
        if (r12 == true) goto L4;
    L6:
        b r14 = b.f2127p;
        if (r14 == null) goto L9;
        r14.s(r10, r11);
        return;
    L9:
        c r15 = f2126c;
        if (r15 == null) goto L12;
        r15.e(r10);
        return;
    L12:
        System.loadLibrary(r10);
        return;
    L4:
        if (f2124a != null) goto L6;
        f2124a = r13;
        goto L6
    }
}
