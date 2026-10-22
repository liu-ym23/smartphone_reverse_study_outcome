package com.obric.oui.orecyclerview.widget;

import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 {
    public static final Pools.SimplePool d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f13798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f13799c;

    static {
        d = new Pools.SimplePool(20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c1 a() {
        c1 r5 = (c1) d.acquire();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new c1();
    }
}
