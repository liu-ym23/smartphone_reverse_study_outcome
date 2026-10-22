package p3;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.c;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f9936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0133a<T> f9937c;

    /* JADX INFO: renamed from: p3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0133a<T> {
    }

    public a(int r8) {
        this.f9936b = new ConcurrentLinkedQueue();
        this.f9935a = r8;
    }

    public final void a(T r8) {
        ConcurrentLinkedQueue<T> r10 = this.f9936b;
        r10.add(r8);
        if (r10.size() <= this.f9935a) goto L12;
        T r11 = r10.poll();
        if (this.f9937c == null) goto L13;
        c r12 = (c) r11;
        if (h3.a.f7905c == false) goto L14;
        String r13 = "evicted Monitorable " + r12;
        if (b.G() == false) goto L15;
        Log.e("APM-CommonEvent", r13);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
