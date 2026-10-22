package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class c5 extends s2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Collection f8921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8922c;

    public c5(Collection r5, int r10) {
        this.f8921b = r5;
        this.f8922c = r10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Collection r5 = this.f8921b;
        boolean r10 = r5 instanceof List;
        int r11 = this.f8922c;
        if (r10 == false) goto L6;
        List r12 = (List) r5;
        return r12.subList(Math.min(r12.size(), r11), r12.size()).iterator();
    L6:
        Iterator r13 = r5.iterator();
        r13.getClass();
        int r14 = 0;
        if (r11 < 0) goto L9;
        boolean r15 = true;
    L10:
        com.google.common.base.b0.g("numberToAdvance must be nonnegative", r15);
    L11:
        if (r14 >= r11) goto L16;
        if (r13.hasNext() == false) goto L16;
        r13.next();
        r14 = r14 + 1;
    L16:
        return new b5(r13);
    L9:
        r15 = false;
        goto L10
    }

    @Override // java.lang.Iterable
    public final Spliterator spliterator() {
        Collection r5 = this.f8921b;
        boolean r10 = r5 instanceof List;
        int r11 = this.f8922c;
        if (r10 == false) goto L7;
        List r12 = (List) r5;
        return r12.subList(Math.min(r12.size(), r11), r12.size()).spliterator();
    L7:
        if ((r5 instanceof Collection) == false) goto L9;
        Stream r13 = r5.stream();
    L11:
        return r13.skip(r11).spliterator();
    L9:
        r13 = StreamSupport.stream(r5.spliterator(), false);
        goto L11
    }
}
