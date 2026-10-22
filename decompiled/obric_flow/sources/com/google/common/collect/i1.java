package com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9020a;

    public /* synthetic */ i1(int r5) {
        this.f9020a = r5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch(this.f9020a) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            default: goto L5;
        };
    L28:
        int r5 = h8.f9015a;
        final LinkedHashMap r10 = p7.a0(8);
        final MultimapBuilder$LinkedHashSetSupplier r11 = new MultimapBuilder$LinkedHashSetSupplier(2);
        return new Multimaps$CustomSetMultimap(r10, r11);
    L30:
        int r12 = h8.f9015a;
        final LinkedHashMap r13 = p7.a0(8);
        final MultimapBuilder$ArrayListSupplier r14 = new MultimapBuilder$ArrayListSupplier(2);
        return new Multimaps$CustomListMultimap(r13, r14);
    L5:
        return new z4();
    L7:
        return new p9();
    L9:
        return new p3(4);
    L11:
        return new LinkedHashMap();
    L13:
        return ImmutableSetMultimap.builder();
    L15:
        return ImmutableListMultimap.builder();
    L17:
        return new x3(4);
    L19:
        return LinkedHashMultiset.create();
    L21:
        return ImmutableRangeSet.builder();
    L23:
        return ImmutableSet.builder();
    L25:
        return ImmutableList.builder();
    L27:
        return ImmutableRangeMap.builder();
    }

    public /* synthetic */ i1(p7 r5, int r10) {
        this.f9020a = r10;
    }
}
