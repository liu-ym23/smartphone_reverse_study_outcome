package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f3754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3756c;

    static {
        f3754a = new HashSet();
        f3755b = "";
        f3756c = true;
    }

    public static String a() {
        if (f3756c == false) goto L18;
        HashSet<String> r8 = f3754a;     // Catch: ConcurrentModificationException -> L19
        if (r8 != null) goto L7;
        String r10 = null;
    L16:
        f3755b = r10;     // Catch: ConcurrentModificationException -> L19
        f3756c = false;     // Catch: ConcurrentModificationException -> L19
        goto L18
    L7:
        StringBuilder r11 = new StringBuilder();     // Catch: ConcurrentModificationException -> L19
        Iterator<String> r12 = r8.iterator();     // Catch: ConcurrentModificationException -> L19
        boolean r13 = true;
    L9:
        if (r12.hasNext() == false) goto L15;
        String r14 = r12.next();     // Catch: ConcurrentModificationException -> L19
        if (r13 == false) goto L13;
        r13 = false;
    L14:
        r11.append(r14.toString());     // Catch: ConcurrentModificationException -> L19
        goto L9
    L13:
        r11.append(",");     // Catch: ConcurrentModificationException -> L19
        goto L14
    L15:
        r10 = r11.toString();     // Catch: ConcurrentModificationException -> L19
    L18:
        return f3755b;
    }
}
