package p0;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<T> f12313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12314b;

    public a(int r10) {
        this.f12313a = new LinkedList();
        this.f12314b = r10;
    }

    public void a(T r10) {
        if (this.f12313a.size() <= this.f12314b) goto L5;
        this.f12313a.removeFirst();
    L5:
        this.f12313a.addLast(r10);
    }

    public LinkedList<T> b() {
        return this.f12313a;
    }
}
