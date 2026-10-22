package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map.Entry f8882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterator f8883c;
    public final /* synthetic */ AbstractMapBasedMultiset d;

    public /* synthetic */ a0(AbstractMapBasedMultiset r5, Iterator r10, int r11) {
        this.f8881a = r11;
        this.d = r5;
        this.f8883c = r10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f8881a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f8883c.hasNext();
    L7:
        return this.f8883c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f8881a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Map.Entry r5 = (Map.Entry) this.f8883c.next();
        this.f8882b = r5;
        return new b0(this, r5);
    L6:
        Map.Entry r10 = (Map.Entry) this.f8883c.next();
        this.f8882b = r10;
        return r10.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch(this.f8881a) {
            case 0: goto L11;
            default: goto L5;
        };
    L5:
        if (this.f8882b == null) goto L7;
        boolean r5 = true;
    L8:
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
        AbstractMapBasedMultiset.access$022(this.d, ((Count) this.f8882b.getValue()).getAndSet(0));
        this.f8883c.remove();
        this.f8882b = null;
        return;
    L7:
        r5 = false;
        goto L8
    L11:
        if (this.f8882b == null) goto L13;
        boolean r10 = true;
    L14:
        com.google.common.base.b0.u(r10, "no calls to next() since the last call to remove()");
        AbstractMapBasedMultiset.access$022(this.d, ((Count) this.f8882b.getValue()).getAndSet(0));
        this.f8883c.remove();
        this.f8882b = null;
        return;
    L13:
        r10 = false;
        goto L14
    }
}
