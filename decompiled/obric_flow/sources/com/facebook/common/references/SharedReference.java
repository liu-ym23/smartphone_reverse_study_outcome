package com.facebook.common.references;

import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SharedReference<T> {
    public static final IdentityHashMap d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResourceReleaser f7678c;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    static {
        d = new IdentityHashMap();
    }

    public SharedReference(Object r5, ResourceReleaser r10) {
        r5.getClass();
        this.f7676a = r5;
        r10.getClass();
        this.f7678c = r10;
        this.f7677b = 1;
        IdentityHashMap r11 = d;
        monitor-enter(r11);
        Integer r12 = (Integer) r11.get(r5);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r11.put(r5, 1);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L9:
        r11.put(r5, Integer.valueOf(r12.intValue() + 1));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(Object r5) {
        IdentityHashMap r10 = d;
        monitor-enter(r10);
        Integer r11 = (Integer) r10.get(r5);     // Catch: Throwable -> L7
        if (r11 != null) goto L10;
        FLog.a("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[]{r5.getClass()});     // Catch: Throwable -> L7
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L10:
        if (r11.intValue() != 1) goto L12;
        r10.remove(r5);     // Catch: Throwable -> L7
        goto L13
    L12:
        r10.put(r5, Integer.valueOf(r11.intValue() - 1));     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (a() != 0) goto L12;
        monitor-enter(this);
        Object r5 = this.f7676a;     // Catch: Throwable -> L9
        this.f7676a = null;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f7678c.release(r5);
        a(r5);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void c() {
        monitor-enter(this);
        if (this.f7677b <= 0) goto L7;
        monitor-exit(this);
        return;
    L7:
        monitor-exit(this);
        throw new NullReferenceException();
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Object d() {
        monitor-enter(this);
        Object r5 = this.f7676a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int a() {
        monitor-enter(this);
        c();     // Catch: Throwable -> L8
        int r5 = this.f7677b;     // Catch: Throwable -> L8
        if (r5 <= 0) goto L11;
        int r10 = r5 - 1;     // Catch: Throwable -> L8
        this.f7677b = r10;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }
}
