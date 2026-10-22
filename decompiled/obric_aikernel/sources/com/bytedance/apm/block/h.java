package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f778c;

    static {
        f776a = new HashSet();
        f777b = "";
        f778c = true;
    }

    public static void a(String r10) {
        f778c = true;
        f776a.add(r10);
    }

    public static String b() {
        if (f778c == false) goto L6;
        f777b = com.bytedance.apm.util.j.c(f776a, ",");     // Catch: ConcurrentModificationException -> L7
        f778c = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return f777b;
    }

    public static void c(String r10) {
        f778c = true;
        f776a.remove(r10);
    }
}
