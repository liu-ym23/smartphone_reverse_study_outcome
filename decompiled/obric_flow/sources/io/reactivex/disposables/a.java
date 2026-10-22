package io.reactivex.disposables;

import com.airbnb.lottie.parser.moshi.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.e;
import io.reactivex.internal.util.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Disposable, qt.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f17605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f17606b;

    @Override // qt.a
    public final boolean a(Disposable r5) {
        if (c(r5) == false) goto L6;
        r5.dispose();
        return true;
    L6:
        return false;
    }

    @Override // qt.a
    public final boolean b(Disposable r10) {
        e.d(r10, "disposable is null");
        if (this.f17606b == true) goto L19;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f17606b == true) goto L15;
        c r5 = this.f17605a;     // Catch: Throwable -> L10
        if (r5 != null) goto L12;
        r5 = new c();     // Catch: Throwable -> L10
        int r11 = 1 << (32 - Integer.numberOfLeadingZeros(15));     // Catch: Throwable -> L10
        r5.f1313a = r11 - 1;     // Catch: Throwable -> L10
        r5.f1315c = (int) (0.75f * r11);     // Catch: Throwable -> L10
        r5.d = new Object[r11];     // Catch: Throwable -> L10
        this.f17605a = r5;     // Catch: Throwable -> L10
    L12:
        r5.d(r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L10
    L19:
        r10.dispose();
        return false;
    }

    @Override // qt.a
    public final boolean c(Disposable r10) {
        e.d(r10, "disposables is null");
        if (this.f17606b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f17606b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L12:
        c r5 = this.f17605a;     // Catch: Throwable -> L10
        if (r5 == null) goto L28;
        Object[] r11 = (Object[]) r5.d;     // Catch: Throwable -> L10
        int r12 = r5.f1313a;     // Catch: Throwable -> L10
        int r13 = r10.hashCode() * (-1640531527);     // Catch: Throwable -> L10
        int r14 = (r13 ^ (r13 >>> 16)) & r12;     // Catch: Throwable -> L10
        Object r15 = r11[r14];     // Catch: Throwable -> L10
        if (r15 == null) goto L28;
        if (r15.equals(r10) == false) goto L20;
        r5.i(r14, r12, r11);     // Catch: Throwable -> L10
    L26:
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    L20:
        r14 = (r14 + 1) & r12;     // Catch: Throwable -> L10
        Object r16 = r11[r14];     // Catch: Throwable -> L10
        if (r16 == null) goto L28;
        if (r16.equals(r10) == false) goto L20;
        r5.i(r14, r12, r11);     // Catch: Throwable -> L10
    L28:
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    }

    public final int d() {
        int r5 = 0;
        if (this.f17606b == false) goto L5;
        return 0;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f17606b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return 0;
    L12:
        c r10 = this.f17605a;     // Catch: Throwable -> L10
        if (r10 == null) goto L15;
        r5 = r10.f1314b;     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f17606b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f17606b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.f17606b = true;     // Catch: Throwable -> L10
        c r5 = this.f17605a;     // Catch: Throwable -> L10
        ArrayList r10 = null;
        this.f17605a = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r5 == null) goto L45;
        Object[] r11 = (Object[]) r5.d;
        int r12 = r11.length;
        int r13 = 0;
    L17:
        if (r13 >= r12) goto L28;
        Object r14 = r11[r13];
        if ((r14 instanceof Disposable) == false) goto L27;
        ((Disposable) r14).dispose();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        if (r10 != null) goto L26;
        r10 = new ArrayList();
    L26:
        r10.add(th);
    L27:
        r13 = r13 + 1;
        goto L17
    L28:
        if (r10 != null) goto L30;
        return;
    L30:
        if (r10.size() != 1) goto L34;
        throw d.d((Throwable) r10.get(0));
    L34:
        throw new CompositeException(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17606b;
    }
}
