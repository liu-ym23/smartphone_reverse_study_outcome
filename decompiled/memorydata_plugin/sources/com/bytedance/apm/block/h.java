package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f1232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1233b;
    private static boolean c;

    static {
        f1232a = new HashSet();
        f1233b = "";
        c = true;
    }

    public static String a() {
        if (c == false) goto L6;
        f1233b = com.bytedance.apm.util.i.a(f1232a, ",");     // Catch: ConcurrentModificationException -> L7
        c = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return f1233b;
    }

    public static void a(String r1) {
        c = true;
        f1232a.add(r1);
    }

    public static void b(String r1) {
        c = true;
        f1232a.remove(r1);
    }
}
