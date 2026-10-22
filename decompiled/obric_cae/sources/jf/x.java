package jf;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8881d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8884c;

    public class a extends x {
        @Override // jf.x
        public final x d(long r8) {
            return this;
        }

        @Override // jf.x
        public final void f() {
        }

        @Override // jf.x
        public final x g(long r8, TimeUnit r10) {
            return this;
        }
    }

    static {
        f8881d = new a();
    }

    public x a() {
        this.f8882a = false;
        return this;
    }

    public x b() {
        this.f8884c = 0;
        return this;
    }

    public long c() {
        if (this.f8882a == false) goto L7;
        return this.f8883b;
    L7:
        throw new IllegalStateException("No deadline");
    }

    public x d(long r8) {
        this.f8882a = true;
        this.f8883b = r8;
        return this;
    }

    public boolean e() {
        return this.f8882a;
    }

    public void f() {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    L5:
        if (this.f8882a == true) goto L7;
        return;
    L7:
        if ((this.f8883b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    }

    public x g(long r8, TimeUnit r10) {
        if (r8 < 0) goto L10;
        if (r10 == null) goto L8;
        this.f8884c = r10.toNanos(r8);
        return this;
    L8:
        throw new IllegalArgumentException("unit == null");
    L10:
        throw new IllegalArgumentException(android.aimedia.a.d("timeout < 0: ", r8));
    }

    public long h() {
        return this.f8884c;
    }
}
