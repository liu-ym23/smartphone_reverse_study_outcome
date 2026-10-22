package com.google.common.collect;

import java.util.AbstractList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class y5 implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f9231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractList f9232c;

    public /* synthetic */ y5(AbstractList r5, Predicate r10, int r11) {
        this.f9230a = r11;
        this.f9232c = r5;
        this.f9231b = r10;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r5) {
        switch(this.f9230a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Object r10 = ((Lists$TransformingSequentialList) this.f9232c).function.apply(r5);
        return this.f9231b.test(r10);
    L6:
        Object r11 = ((Lists$TransformingRandomAccessList) this.f9232c).function.apply(r5);
        return this.f9231b.test(r11);
    }
}
