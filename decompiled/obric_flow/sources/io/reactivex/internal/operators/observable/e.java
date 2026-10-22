package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f17761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f17762b;

    public e(f r5) {
        this.f17762b = r5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object r5 = this.f17762b.f17775b;
        this.f17761a = r5;
        return !NotificationLite.isComplete(r5);
    }

    @Override // java.util.Iterator
    public final Object next() {
    L6:
        th = move-exception;
        this.f17761a = null;
        throw th;
    L4:
        if (this.f17761a != null) goto L9;
        this.f17761a = this.f17762b.f17775b;     // Catch: Throwable -> L6
    L9:
        if (NotificationLite.isComplete(this.f17761a) == true) goto L18;
        if (NotificationLite.isError(this.f17761a) == true) goto L16;
        Object r5 = NotificationLite.getValue(this.f17761a);     // Catch: Throwable -> L6
        this.f17761a = null;
        return r5;
    L16:
        throw io.reactivex.internal.util.d.d(NotificationLite.getError(this.f17761a));     // Catch: Throwable -> L6
    L18:
        throw new NoSuchElementException();     // Catch: Throwable -> L6
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
