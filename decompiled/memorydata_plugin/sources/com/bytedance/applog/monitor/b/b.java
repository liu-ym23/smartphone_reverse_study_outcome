package com.bytedance.applog.monitor.b;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f1671a = null;

    static {
        f1671a = new CopyOnWriteArrayList();
    }

    public static void a(a r1) {
        f1671a.add(r1);
    }
}
