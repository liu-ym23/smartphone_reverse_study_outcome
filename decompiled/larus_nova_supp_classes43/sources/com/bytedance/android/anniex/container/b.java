package com.bytedance.android.anniex.container;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends com.bytedance.android.anniex.base.lifecycle.c {
    public final CopyOnWriteArrayList<com.bytedance.android.anniex.base.lifecycle.a> a;
    public final CopyOnWriteArrayList<com.bytedance.android.anniex.base.lifecycle.c> b;

    public b() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).j(r10);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).j(r10);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void a(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).a(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).a(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void b(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Iterator<com.bytedance.android.anniex.base.lifecycle.c> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r10, r11);
        goto L4
    L6:
        Iterator<com.bytedance.android.anniex.base.lifecycle.a> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().b(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void d(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).d(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).d(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void e(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).e(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).e(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void f(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).f(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).f(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).h(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).h(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void i(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).i(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).i(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void k(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).k(r10, r11);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).k(r10, r11);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void c(String r10, AnnieXContainer r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        Iterator<com.bytedance.android.anniex.base.lifecycle.c> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().c(r10, r11, r12);
        goto L4
    L6:
        Iterator<com.bytedance.android.anniex.base.lifecycle.a> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().c(r10, r11, r12);
        goto L8
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void g(String r10, ia.c r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.anniex.base.lifecycle.c) r0.next()).g(r10, r11, r12);
        goto L4
    L6:
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.android.anniex.base.lifecycle.a) r1.next()).g(r10, r11, r12);
        goto L8
    }
}
