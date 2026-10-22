package com.obric.aikernel.utils;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5588a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l0 f5589b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l0 f5590c = null;

    static {
        f5588a = new c();
        f5589b = m0.a(z0.b());
        f5590c = m0.a(z0.a());
    }

    private c() {
    }

    public final l0 a() {
        return f5589b;
    }

    public final CoroutineDispatcher b() {
        return z0.c();
    L4:
        e = move-exception;
        AIKLog.INSTANCE.w("CoroutineDispatcher", "Main dispatcher missing, use IO instead", e);
        return z0.b();
    }
}
