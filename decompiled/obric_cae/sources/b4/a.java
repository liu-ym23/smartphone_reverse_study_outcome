package b4;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import r3.h;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3049a;

    public a() {
        this.f3049a = new ConcurrentHashMap();
    }

    public final boolean a(int r8) {
        return !this.f3049a.containsKey(Integer.valueOf(r8));
    }

    public final void b(int r8, long r10, long r11, String r12, String r13, String r14, String r15) {
        if (a(r8) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r16 = (CopyOnWriteArraySet) this.f3049a.get(Integer.valueOf(r8));
        if (r16 != null) goto L8;
        return;
    L8:
        Iterator r17 = r16.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        ((h) r17.next()).a();
        goto L10
    }

    public final void c(int r8, String r10, String r11) {
        if (a(r8) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r12 = (CopyOnWriteArraySet) this.f3049a.get(Integer.valueOf(r8));
        if (r12 != null) goto L8;
        return;
    L8:
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        ((h) r13.next()).c();
        goto L10
    }

    public final void d(int r8, String r10, String r11) {
        if (a(r8) == false) goto L5;
        return;
    L5:
        CopyOnWriteArraySet r12 = (CopyOnWriteArraySet) this.f3049a.get(Integer.valueOf(r8));
        if (r12 != null) goto L8;
        return;
    L8:
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        ((h) r13.next()).b();
        goto L10
    }
}
