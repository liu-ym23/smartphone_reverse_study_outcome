package com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TypeVariable f9360c;

    public h(AtomicInteger r5, TypeVariable r10) {
        this.f9360c = r10;
        super(r5);
    }

    @Override // com.google.common.reflect.i
    public final TypeVariable b(Type[] r5) {
        LinkedHashSet r10 = new LinkedHashSet(Arrays.asList(r5));
        r10.addAll(Arrays.asList(this.f9360c.getBounds()));
        if (r10.size() <= 1) goto L6;
        r10.remove(Object.class);
    L6:
        return super.b((Type[]) r10.toArray(new Type[0]));
    }
}
