package com.google.common.collect;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g7 extends j6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8996b;

    public /* synthetic */ g7(int r5) {
        this.f8996b = r5;
        super(1);
    }

    public abstract Map b();

    public abstract z7 c();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch(this.f8996b) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        c().clear();
        return;
    L6:
        c().clear();
        return;
    L8:
        b().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.f8996b) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L5;
        };
    L5:
        if ((r5 instanceof y7) == false) goto L24;
        y7 r10 = (y7) r5;
        if (r10.getCount() > 0) goto L10;
        return false;
    L10:
        if (c().count(r10.getElement()) != r10.getCount()) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L14:
        return c().contains(r5);
    L16:
        if ((r5 instanceof Map.Entry) == false) goto L27;
        Map.Entry r11 = (Map.Entry) r5;
        Object r12 = r11.getKey();
        Object r13 = p7.l0(b(), r12);
        if (com.google.common.base.b0.w(r13, r11.getValue()) == false) goto L28;
        if (r13 == null) goto L21;
    L22:
        return true;
    L21:
        if (b().containsKey(r12) == true) goto L22;
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection r5) {
        switch(this.f8996b) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.containsAll(r5);
    L7:
        return c().containsAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch(this.f8996b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.isEmpty();
    L7:
        return c().isEmpty();
    L9:
        return b().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r5) {
        switch(this.f8996b) {
            case 0: goto L16;
            case 1: goto L11;
            default: goto L5;
        };
    L5:
        if ((r5 instanceof y7) == false) goto L22;
        y7 r10 = (y7) r5;
        Object r11 = r10.getElement();
        int r12 = r10.getCount();
        if (r12 != 0) goto L9;
        return false;
    L9:
        return c().setCount(r11, r12, 0);
    L22:
        return false;
    L11:
        if (c().remove(r5, Integer.MAX_VALUE) <= 0) goto L13;
        return true;
    L13:
        return false;
    L16:
        if (contains(r5) == true) goto L18;
    L20:
        return false;
    L18:
        if ((r5 instanceof Map.Entry) == false) goto L20;
        return b().keySet().remove(((Map.Entry) r5).getKey());
    }

    @Override // com.google.common.collect.j6, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection r5) {
        switch(this.f8996b) {
            case 0: goto L10;
            default: goto L5;
        };
    L10:
        r5.getClass();     // Catch: UnsupportedOperationException -> L8
        return p7.i0(this, r5);
    L9:
        return p7.j0(this, r5.iterator());
    L5:
        return super.removeAll(r5);
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r5) {
        switch(this.f8996b) {
            case 0: goto L18;
            default: goto L5;
        };
    L18:
        r5.getClass();     // Catch: UnsupportedOperationException -> L8
        return super.retainAll(r5);
    L8:
        HashSet r10 = p7.Y(r5.size());
        Iterator r11 = r5.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        Object r12 = r11.next();
        if (contains(r12) == false) goto L10;
        if ((r12 instanceof Map.Entry) == false) goto L10;
        r10.add(((Map.Entry) r12).getKey());
        goto L10
    L17:
        return b().keySet().retainAll(r10);
    L5:
        return super.retainAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        switch(this.f8996b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return c().entrySet().size();
    L7:
        return b().size();
    }
}
