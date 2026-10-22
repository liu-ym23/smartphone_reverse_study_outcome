package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, ac.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    f<b> f9482c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f9483g;

    public a() {
    }

    @Override // ac.a
    public boolean a(b r10) {
        if (c(r10) == false) goto L6;
        r10.dispose();
        return true;
    L6:
        return false;
    }

    @Override // ac.a
    public boolean b(b r10) {
        io.reactivex.internal.functions.a.d(r10, "d is null");
        if (this.f9483g == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f9483g == true) goto L13;
        f<b> r11 = this.f9482c;     // Catch: Throwable -> L15
        if (r11 != null) goto L10;
        r11 = new f();     // Catch: Throwable -> L15
        this.f9482c = r11;     // Catch: Throwable -> L15
    L10:
        r11.a(r10);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r10.dispose();
        return false;
    }

    @Override // ac.a
    public boolean c(b r10) {
        io.reactivex.internal.functions.a.d(r10, "Disposable item is null");
        if (this.f9483g == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f9483g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        f<b> r11 = this.f9482c;     // Catch: Throwable -> L20
        if (r11 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r11.e(r10) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    void d(f<b> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = null;
        Object[] r12 = r10.b();
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L16;
        Object r15 = r12[r14];
        if ((r15 instanceof b) == false) goto L15;
        ((b) r15).dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(th);
    L15:
        r14 = r14 + 1;
        goto L5
    L16:
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.size() != 1) goto L22;
        throw ExceptionHelper.d((Throwable) r11.get(0));
    L22:
        throw new CompositeException(r11);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f9483g == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f9483g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f9483g = true;     // Catch: Throwable -> L14
        f<b> r10 = this.f9482c;     // Catch: Throwable -> L14
        this.f9482c = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        d(r10);
    }

    public int e() {
        int r10 = 0;
        if (this.f9483g == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.f9483g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L15
        return 0;
    L10:
        f<b> r11 = this.f9482c;     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        r10 = r11.g();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r10;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f9483g;
    }
}
