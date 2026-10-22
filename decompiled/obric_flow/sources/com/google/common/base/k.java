package com.google.common.base;

import com.google.common.collect.d8;
import com.google.common.collect.g9;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8662c;

    public k(l r5) {
        this.f8660a = 0;
        this.f8662c = r5;
        this.f8661b = r5.f8663a.iterator();
    }

    public kotlinx.metadata.internal.protobuf.x a() {
        kotlinx.metadata.internal.protobuf.x r5 = (kotlinx.metadata.internal.protobuf.x) this.f8662c;
        if (r5 == null) goto L17;
    L4:
        Stack r10 = (Stack) this.f8661b;
        if (r10.isEmpty() == true) goto L6;
        kotlinx.metadata.internal.protobuf.e r11 = ((kotlinx.metadata.internal.protobuf.f0) r10.pop()).d;
    L9:
        if ((r11 instanceof kotlinx.metadata.internal.protobuf.f0) == false) goto L11;
        kotlinx.metadata.internal.protobuf.f0 r12 = (kotlinx.metadata.internal.protobuf.f0) r11;
        r10.push(r12);
        r11 = r12.f19165c;
        goto L9
    L11:
        kotlinx.metadata.internal.protobuf.x r13 = (kotlinx.metadata.internal.protobuf.x) r11;
        if (r13.f19212b.length == 0) goto L4;
    L14:
        this.f8662c = r13;
        return r5;
    L6:
        r13 = null;
        goto L14
    L17:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f8660a) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L5;
        };
    L5:
        if (((kotlinx.metadata.internal.protobuf.x) this.f8662c) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        return ((Iterator) this.f8661b).hasNext();
    L12:
        return ((Iterator) this.f8661b).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f8660a) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        Map.Entry r5 = (Map.Entry) ((Iterator) this.f8661b).next();
        ((g9) this.f8662c).getClass();
        return new d8(r5, 1);
    L5:
        return a();
    L9:
        return ((l) this.f8662c).f8664b.convert(((Iterator) this.f8661b).next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch(this.f8660a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        ((Iterator) this.f8661b).remove();
        ((g9) this.f8662c).b();
        return;
    L8:
        ((Iterator) this.f8661b).remove();
        return;
    L5:
        throw new UnsupportedOperationException();
    }

    public k(g9 r5, Iterator r10) {
        this.f8660a = 1;
        this.f8662c = r5;
        this.f8661b = r10;
    }

    public k(kotlinx.metadata.internal.protobuf.e r5) {
        this.f8660a = 2;
        this.f8661b = new Stack();
    L4:
        if ((r5 instanceof kotlinx.metadata.internal.protobuf.f0) == false) goto L6;
        kotlinx.metadata.internal.protobuf.f0 r10 = (kotlinx.metadata.internal.protobuf.f0) r5;
        ((Stack) this.f8661b).push(r10);
        r5 = r10.f19165c;
        goto L4
    L6:
        this.f8662c = (kotlinx.metadata.internal.protobuf.x) r5;
    }
}
