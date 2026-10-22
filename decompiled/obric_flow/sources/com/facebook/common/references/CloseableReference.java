package com.facebook.common.references;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CloseableReference<T> implements Cloneable, Closeable {
    public static final ResourceReleaser e = null;
    public static final LeakHandler f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedReference f7671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LeakHandler f7672c;
    public final Throwable d;

    public interface LeakHandler {
        void a();

        void b();
    }

    static {
        e = new AnonymousClass1();
        f = new AnonymousClass2();
    }

    public CloseableReference(SharedReference r5, LeakHandler r10, Throwable r11) {
        this.f7670a = false;
        r5.getClass();
        this.f7671b = r5;
        monitor-enter(r5);
        r5.c();     // Catch: Throwable -> L8
        r5.f7677b++;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        this.f7672c = r10;
        this.d = r11;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static DefaultCloseableReference a(Object r5, ResourceReleaser r10, LeakHandler r11) {
        if (r5 != null) goto L5;
        return null;
    L5:
        r11.a();
        if ((r5 instanceof Bitmap) == true) goto L9;
        boolean r12 = r5 instanceof HasBitmap;
    L9:
        return new DefaultCloseableReference(r5, r10, r11, null);
    }

    public final synchronized CloseableReference b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (d() == false) goto L10;
        CloseableReference r5 = clone();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L10:
        monitor-exit(this);
        return null;
    }

    public final synchronized Object c() {
        monitor-enter(this);
        Object r5 = this.f7671b.d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public abstract CloseableReference clone();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f7670a == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f7670a = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        this.f7671b.b();
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        boolean r5 = !this.f7670a;
        monitor-exit(this);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public void finalize() {
        monitor-enter(this);     // Catch: Throwable -> L14
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L4:
        if (this.f7670a == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        super.finalize();
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f7672c.b();     // Catch: Throwable -> L14
        Integer r5 = Integer.valueOf(System.identityHashCode(this));     // Catch: Throwable -> L14
        Integer r10 = Integer.valueOf(System.identityHashCode(this.f7671b));     // Catch: Throwable -> L14
        String r11 = this.f7671b.d().getClass().getName();     // Catch: Throwable -> L14
        if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L16;
        String r12 = String.format(null, "Finalized without closing: %x %x (type = %s)", new Object[]{r5, r10, r11});     // Catch: Throwable -> L14
        Log.println(3, FLogDefaultLoggingDelegate.a("CloseableReference"), r12);     // Catch: Throwable -> L14
    L16:
        close();     // Catch: Throwable -> L14
        super.finalize();
        return;
    L14:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public static boolean b(CloseableReference r5) {
        if (r5 == null) goto L12;
        monitor-enter(r5);
        boolean r10 = r5.f7670a;     // Catch: Throwable -> L9
        monitor-exit(r5);
        if (r10 == true) goto L16;
        return true;
    L16:
        return false;
    L9:
        th = move-exception;
        throw th;
    L12:
        return false;
    }

    public static void a(CloseableReference r5) {
        if (r5 == null) goto L5;
        r5.close();
        return;
    }

    public CloseableReference(Object r5, ResourceReleaser r10, LeakHandler r11, Throwable r12) {
        this.f7670a = false;
        this.f7671b = new SharedReference(r5, r10);
        this.f7672c = r11;
        this.d = r12;
    }
}
