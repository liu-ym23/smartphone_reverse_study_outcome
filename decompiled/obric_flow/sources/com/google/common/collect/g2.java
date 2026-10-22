package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class g2 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f8989c;

    public g2(ConcurrentHashMultiset r5) {
        this.f8989c = ConcurrentHashMultiset.access$100(r5).entrySet().iterator();
    }

    @Override // com.google.common.collect.g
    public final Object a() {
    L2:
        Iterator r5 = this.f8989c;
        if (r5.hasNext() == false) goto L4;
        Map.Entry r10 = (Map.Entry) r5.next();
        int r11 = ((AtomicInteger) r10.getValue()).get();
        if (r11 == 0) goto L2;
        return new Multisets$ImmutableEntry(r10.getKey(), r11);
    L4:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    }
}
