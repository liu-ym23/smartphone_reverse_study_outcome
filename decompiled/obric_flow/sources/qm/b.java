package qm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f21524c;

    public b(d r5) {
        this.f21524c = r5;
        this.f21522a = 0;
        this.f21523b = r5.f21528b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f21522a >= this.f21523b) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int r5 = this.f21522a;
        this.f21522a = r5 + 1;
        d r10 = this.f21524c;
        return new c(r10, r10.b(r5));
    }
}
