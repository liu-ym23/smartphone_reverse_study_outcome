package com.obric.aikernel;

import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class InitTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InitTracker f4402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f4403b = 0;

    static {
        f4402a = new InitTracker();
        f4403b = 180000;
    }

    private InitTracker() {
    }

    public final long a() {
        return f4403b;
    }

    public final void b() {
        h.d(m0.a(z0.b()), null, null, new InitTracker$startWatch$1(null), 3, null);
    }
}
