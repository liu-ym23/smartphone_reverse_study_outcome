package cf0;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<E> {
    public final ConcurrentLinkedQueue<E> a;
    public final AtomicInteger b;
    public final int c;

    public final String toString() {
        return this.a.toString();
    }

    public a() {
        this.c = 8;
        this.a = new ConcurrentLinkedQueue();
        this.b = new AtomicInteger(0);
    }
}
