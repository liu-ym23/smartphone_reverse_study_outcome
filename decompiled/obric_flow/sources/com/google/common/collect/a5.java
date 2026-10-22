package com.google.common.collect;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class a5 extends s2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterable f8889c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a5(Iterable r5, Object r10, int r11) {
        this.f8888b = r11;
        this.f8889c = r5;
        this.d = r10;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer r5) {
        switch(this.f8888b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r5.getClass();
        t1 r10 = new t1(r5, (com.google.common.base.q) this.d);
        this.f8889c.forEach(r10);
        return;
    L6:
        r5.getClass();
        t1 r11 = new t1((com.google.common.base.z) this.d, r5, 1);
        this.f8889c.forEach(r11);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f8888b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Iterator r5 = this.f8889c.iterator();
        r5.getClass();
        com.google.common.base.z r10 = (com.google.common.base.z) this.d;
        r10.getClass();
        return new e5(r5, r10);
    L5:
        return new d7(this.f8889c.iterator(), (com.google.common.base.q) this.d, 1);
    }

    @Override // java.lang.Iterable
    public final Spliterator spliterator() {
        switch(this.f8888b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Spliterator r5 = this.f8889c.spliterator();
        r5.getClass();
        com.google.common.base.z r10 = (com.google.common.base.z) this.d;
        r10.getClass();
        return new q1(r5, r10);
    L5:
        return p7.R(this.f8889c.spliterator(), (com.google.common.base.q) this.d);
    }
}
