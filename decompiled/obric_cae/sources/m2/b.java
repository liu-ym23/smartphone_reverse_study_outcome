package m2;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f9257a;

    public b(a r8) {
        this.f9257a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractCollection r8 = this.f9257a.f9253a;
        monitor-enter(r8);
        LinkedList r10 = new LinkedList(this.f9257a.f9253a);     // Catch: Throwable -> L11
        this.f9257a.f9253a.clear();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        c r12 = (c) r11.next();
        this.f9257a.e(r12);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
