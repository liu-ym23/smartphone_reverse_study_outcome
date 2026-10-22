package ac;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements io.reactivex.disposables.b, a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<io.reactivex.disposables.b> f137c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f138g;

    public b() {
    }

    @Override // ac.a
    public boolean a(io.reactivex.disposables.b r10) {
        if (c(r10) == false) goto L6;
        r10.dispose();
        return true;
    L6:
        return false;
    }

    @Override // ac.a
    public boolean b(io.reactivex.disposables.b r10) {
        io.reactivex.internal.functions.a.d(r10, "d is null");
        if (this.f138g == true) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.f138g == true) goto L13;
        List r11 = this.f137c;     // Catch: Throwable -> L15
        if (r11 != null) goto L10;
        r11 = new LinkedList();     // Catch: Throwable -> L15
        this.f137c = r11;     // Catch: Throwable -> L15
    L10:
        r11.add(r10);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        r10.dispose();
        return false;
    }

    @Override // ac.a
    public boolean c(io.reactivex.disposables.b r10) {
        io.reactivex.internal.functions.a.d(r10, "Disposable item is null");
        if (this.f138g == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f138g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L10:
        List<io.reactivex.disposables.b> r11 = this.f137c;     // Catch: Throwable -> L20
        if (r11 != null) goto L13;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return false;
    L13:
        if (r11.remove(r10) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    }

    void d(List<io.reactivex.disposables.b> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = null;
        Iterator<io.reactivex.disposables.b> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        r12.next().dispose();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(th);
        goto L6
    L15:
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.size() != 1) goto L21;
        throw ExceptionHelper.d((Throwable) r11.get(0));
    L21:
        throw new CompositeException(r11);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.f138g == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f138g == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        this.f138g = true;     // Catch: Throwable -> L14
        List<io.reactivex.disposables.b> r10 = this.f137c;     // Catch: Throwable -> L14
        this.f137c = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        d(r10);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f138g;
    }
}
