package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class z8 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9249b;

    public /* synthetic */ z8(Object r5, int r10) {
        this.f9248a = r10;
        this.f9249b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        Object r10 = this.f9249b;
        switch(this.f9248a) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ((g9) r10).getClass();
        return new d8((Map.Entry) r5, 1);
    L6:
        int r11 = ImmutableSortedMultiset.e;
        Comparator r12 = (Comparator) r10;
        return ImmutableSortedMultiset.c(r12, ((z7) r5).entrySet());
    L10:
        Map.Entry r13 = (Map.Entry) r5;
        return new Tables$ImmutableCell(((Map.Entry) r10).getKey(), r13.getKey(), r13.getValue());
    L9:
        return ((n) r10).d((Map.Entry) r5);
    }
}
