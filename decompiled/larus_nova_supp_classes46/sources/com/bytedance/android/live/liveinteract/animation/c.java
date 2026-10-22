package com.bytedance.android.live.liveinteract.animation;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c implements f {
    public final CopyOnWriteArrayList<g> a;
    public final String b;
    public final int c;

    public final void i() {
        Iterator<g> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    }

    public final void j() {
        Iterator<g> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f();
        goto L4
    }

    public final void k() {
        Iterator<g> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().d();
        goto L4
    }

    public final void l() {
        Iterator<g> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().g();
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String a() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public int getType() {
        return this.c;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void d(g r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        if (this.a.contains(r2) == true) goto L6;
        this.a.add(r2);
        return;
    }

    public final void h(f r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Iterator<g> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r3);
        goto L4
    }

    public c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.b = r2;
        this.c = r3;
        this.a = new CopyOnWriteArrayList();
    }
}
