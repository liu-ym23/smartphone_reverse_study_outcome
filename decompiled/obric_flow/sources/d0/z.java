package d0;

import com.bumptech.glide.Registry$NoModelLoaderAvailableException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final y e = null;
    public static final d0 f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f16579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f16580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f16581c;
    public final r0.d d;

    static {
        e = new y();
        f = new d0(2);
    }

    public z(r0.d r5) {
        y r10 = e;
        this.f16579a = new ArrayList();
        this.f16581c = new HashSet();
        this.d = r5;
        this.f16580b = r10;
    }

    public final synchronized void a(Class r5, Class r10, s r11) {
        monitor-enter(this);
        x r12 = new x(r5, r10, r11);     // Catch: Throwable -> L8
        ArrayList r13 = this.f16579a;     // Catch: Throwable -> L8
        r13.add(r13.size(), r12);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized r b(Class r10, Class r11) {
        monitor-enter(this);
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L17
        Iterator r12 = this.f16579a.iterator();     // Catch: Throwable -> L17
        boolean r13 = false;
    L4:
        boolean r14 = true;
        if (r12.hasNext() == false) goto L20;
        x r15 = (x) r12.next();     // Catch: Throwable -> L17
        if (this.f16581c.contains(r15) == true) goto L8;
        if (r15.f16576a.isAssignableFrom(r10) == true) goto L12;
    L14:
        r14 = false;
    L15:
        if (r14 == false) goto L4;
        this.f16581c.add(r15);     // Catch: Throwable -> L17
        r5.add(r15.f16578c.a(this));     // Catch: Throwable -> L17
        this.f16581c.remove(r15);     // Catch: Throwable -> L17
        goto L4
    L12:
        if (r15.f16577b.isAssignableFrom(r11) == false) goto L14;
    L8:
        r13 = true;
        goto L4
    L20:
        if (r5.size() <= 1) goto L25;
        y r16 = this.f16580b;     // Catch: Throwable -> L17
        r0.d r17 = this.d;     // Catch: Throwable -> L17
        r16.getClass();     // Catch: Throwable -> L17
        w r18 = new w(r5, r17);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r18;
    L25:
        if (r5.size() != 1) goto L29;
        r r19 = (r) r5.get(0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r19;
    L29:
        if (r13 == false) goto L34;
        d0 r20 = f;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r20;
    L34:
        throw new Registry$NoModelLoaderAvailableException(r10, r11);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.f16581c.clear();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized ArrayList c(Class r5) {
        monitor-enter(this);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L13
        Iterator r11 = this.f16579a.iterator();     // Catch: Throwable -> L13
    L5:
        if (r11.hasNext() == false) goto L15;
        x r12 = (x) r11.next();     // Catch: Throwable -> L13
        if (this.f16581c.contains(r12) == true) goto L5;
        if (r12.f16576a.isAssignableFrom(r5) == false) goto L5;
        this.f16581c.add(r12);     // Catch: Throwable -> L13
        r10.add(r12.f16578c.a(this));     // Catch: Throwable -> L13
        this.f16581c.remove(r12);     // Catch: Throwable -> L13
        goto L5
    L15:
        monitor-exit(this);
        return r10;
    L13:
        th = move-exception;
        this.f16581c.clear();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized ArrayList d(Class r5) {
        monitor-enter(this);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L12
        Iterator r11 = this.f16579a.iterator();     // Catch: Throwable -> L12
    L5:
        if (r11.hasNext() == false) goto L14;
        x r12 = (x) r11.next();     // Catch: Throwable -> L12
        if (r10.contains(r12.f16577b) == true) goto L5;
        if (r12.f16576a.isAssignableFrom(r5) == false) goto L5;
        r10.add(r12.f16577b);     // Catch: Throwable -> L12
        goto L5
    L14:
        monitor-exit(this);
        return r10;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized ArrayList e() {
        monitor-enter(this);
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L16
        Iterator r10 = this.f16579a.iterator();     // Catch: Throwable -> L16
    L5:
        if (r10.hasNext() == false) goto L18;
        x r11 = (x) r10.next();     // Catch: Throwable -> L16
        if (r11.f16576a.isAssignableFrom(g.class) == true) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == false) goto L5;
        r10.remove();     // Catch: Throwable -> L16
        r5.add(r11.f16578c);     // Catch: Throwable -> L16
        goto L5
    L10:
        if (r11.f16577b.isAssignableFrom(InputStream.class) == false) goto L12;
        r12 = true;
        goto L13
    L18:
        monitor-exit(this);
        return r5;
    L16:
        th = move-exception;
        throw th;
    }
}
