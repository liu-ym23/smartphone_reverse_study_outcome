package com.bytedance.android.live.liveinteract.animation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public final HashMap<Integer, CopyOnWriteArrayList<f>> a;

    public final int b() {
        Iterator<CopyOnWriteArrayList<f>> r0 = this.a.values().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        CopyOnWriteArrayList<f> r3 = r0.next();
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L4;
        r2 = r2 + r3.size();
        goto L4
    L8:
        if (r3.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    L15:
        return r2;
    }

    public m() {
        this.a = new HashMap();
    }

    public final int a(int r3) {
        CopyOnWriteArrayList<f> r4 = this.a.get(Integer.valueOf(r3));
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return 0;
    L12:
        return r4.size();
    L5:
        if (r4.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final f c(int r6) {
        CopyOnWriteArrayList<f> r0 = this.a.get(Integer.valueOf(r6));
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        f r4 = null;
        if (r3 == false) goto L12;
        return null;
    L12:
        if (r0 == null) goto L14;
        r4 = r0.remove(0);
    L14:
        if (r0 != null) goto L16;
    L19:
        if (r1 == false) goto L21;
        this.a.remove(Integer.valueOf(r6));
    L21:
        return r4;
    L16:
        if (r0.isEmpty() == true) goto L19;
        r1 = false;
        goto L19
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void d(f r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        if (this.a.get(Integer.valueOf(r3.getType())) != null) goto L5;
        CopyOnWriteArrayList<f> r0 = new CopyOnWriteArrayList();
        r0.add(r3);
        this.a.put(Integer.valueOf(r3.getType()), r0);
        return;
    L5:
        CopyOnWriteArrayList<f> r1 = this.a.get(Integer.valueOf(r3.getType()));
        if (r1 == null) goto L10;
        r1.add(r3);
        return;
    }
}
