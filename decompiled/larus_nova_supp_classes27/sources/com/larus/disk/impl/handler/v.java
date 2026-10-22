package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.disk.api.d;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v implements d {

    public static final class a {
    }

    public static final class b {
    }

    static {
    }

    public v() {
        throw null;
    }

    public final String bizTag() {
        return "message_cache";
    }

    public final String business() {
        return "message_cache";
    }

    public final synchronized long d() {
        monitor-enter(this);
        query(l(false, true)).getClass();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean e(boolean r1) {
        return false;
    }

    public final boolean f() {
        return true;
    }

    public final synchronized long getCacheSize() {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public final boolean i() {
        return true;
    }

    public final synchronized void k() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final String a() {
        return new PolarisFileWrapper(aa9.a.a.a(), ".message_cache_eviction_provider").getAbsolutePath();
    }

    public final boolean g() {
        throw null;
    }

    private final b query(com.larus.disk.api.k r2) {
        r2.getClass();
        Lazy r3 = com.larus.disk.impl.d.a;
        if (Intrinsics.areEqual(null, com.larus.disk.impl.d.c()) == true) goto L7;
        throw new IllegalStateException("Message cache account changed before query".toString());
    L7:
        throw null;
    }

    public final synchronized long b(boolean r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (g() == true) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        query(l(r3, false)).getClass();     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    }

    public final synchronized void j(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "accountScope");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(boolean r1, boolean r2) {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    public final synchronized void h(boolean r1, boolean r2) {
        monitor-enter(this);
        if (r2 == true) goto L8;
        throw null;     // Catch: Throwable -> L6
    L8:
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final com.larus.disk.api.k l(boolean r1, boolean r2) {
        throw null;
    }
}
