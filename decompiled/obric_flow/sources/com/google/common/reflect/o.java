package com.google.common.reflect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.u3;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f9367c;

    public o(q r5) {
        this.f9367c = r5;
    }

    @Override // com.google.common.reflect.q
    public final ImmutableList b(ImmutableCollection r5) {
        u3 r10 = ImmutableList.builder();
        Iterator<E> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();
        if (this.f9367c.d(r12).isInterface() == true) goto L4;
        r10.B0(r12);
        goto L4
    L9:
        return super.b(r10.D0());
    }

    @Override // com.google.common.reflect.q
    public final Iterable c(Object r5) {
        return ImmutableSet.of();
    }

    @Override // com.google.common.reflect.q
    public final Class d(Object r5) {
        return this.f9367c.d(r5);
    }

    @Override // com.google.common.reflect.q
    public final Object e(Object r5) {
        return this.f9367c.e(r5);
    }
}
