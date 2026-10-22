package com.bytedance.android.live.liveinteract.animation;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final k0 a;
    public e b;
    public volatile long c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public final void d() {
        this.b = null;
        Iterator<CopyOnWriteArrayList<f>> r0 = this.a.b.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        CopyOnWriteArrayList<f> r1 = r0.next();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        Iterator<f> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L4;
        r3.next().c();
        goto L16
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final void c() {
        d();
        k0 r0 = this.a;
        Iterator<f> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().recycle();
        goto L4
    L6:
        r0.g.clear();
        r0.a.clear();
        m r2 = r0.b;
        Iterator<CopyOnWriteArrayList<f>> r3 = r2.a.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L22;
        CopyOnWriteArrayList<f> r4 = r3.next();
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L8;
        Iterator<f> r6 = r4.iterator();
    L20:
        if (r6.hasNext() == false) goto L8;
        r6.next().recycle();
        goto L20
    L12:
        if (r4.isEmpty() == true) goto L15;
        r5 = false;
        goto L16
    L22:
        r2.a.clear();
    }

    public final void a(e r4) {
        this.b = r4;
        Iterator<CopyOnWriteArrayList<f>> r0 = this.a.b.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        CopyOnWriteArrayList<f> r1 = r0.next();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        Iterator<f> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L4;
        r3.next().g(r4);
        goto L16
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final n b(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        n r1 = new n(this);
        Intrinsics.checkNotNullParameter(r3, "data");
        r1.d = r3;
        return r1;
    }

    public h(String r3, InteractAnimationController r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "animationController");
        this.d = r3;
        k0 r1 = new k0(r4);
        this.a = r1;
        Intrinsics.checkNotNullParameter(r3, "id");
        r1.e = r3;
    }
}
