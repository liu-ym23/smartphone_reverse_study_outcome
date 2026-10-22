package qt;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Disposable, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f21574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21575b;

    @Override // qt.a
    public final boolean a(Disposable r5) {
        if (c(r5) == false) goto L6;
        r5.dispose();
        return true;
    L6:
        return false;
    }

    @Override // qt.a
    public final boolean b(Disposable r5) {
        if (this.f21575b == true) goto L20;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f21575b == true) goto L16;
        LinkedList r10 = this.f21574a;     // Catch: Throwable -> L10
        if (r10 != null) goto L12;
        r10 = new LinkedList();     // Catch: Throwable -> L10
        this.f21574a = r10;     // Catch: Throwable -> L10
    L12:
        r10.add(r5);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L10
    L20:
        r5.dispose();
        return false;
    }

    @Override // qt.a
    public final boolean c(Disposable r5) {
        if (this.f21575b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f21575b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L12:
        LinkedList r10 = this.f21574a;     // Catch: Throwable -> L10
        if (r10 != null) goto L15;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L10
        return false;
    L15:
        if (r10.remove(r5) == false) goto L20;
        monitor-exit(this);     // Catch: Throwable -> L10
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f21575b == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f21575b == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.f21575b = true;     // Catch: Throwable -> L10
        LinkedList r5 = this.f21574a;     // Catch: Throwable -> L10
        ArrayList r10 = null;
        this.f21574a = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r5 == null) goto L44;
        Iterator r11 = r5.iterator();
    L18:
        if (r11.hasNext() == false) goto L27;
        ((Disposable) r11.next()).dispose();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        if (r10 != null) goto L26;
        r10 = new ArrayList();
    L26:
        r10.add(th);
        goto L18
    L27:
        if (r10 != null) goto L29;
        return;
    L29:
        if (r10.size() != 1) goto L33;
        throw d.d((Throwable) r10.get(0));
    L33:
        throw new CompositeException(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f21575b;
    }
}
