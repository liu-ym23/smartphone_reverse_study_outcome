package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9000a;

    public /* synthetic */ h(int r5) {
        this.f9000a = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f9000a) {
            case 0: goto L56;
            case 1: goto L55;
            case 2: goto L53;
            case 3: goto L51;
            case 4: goto L49;
            case 5: goto L47;
            case 6: goto L45;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L35;
            case 12: goto L33;
            case 13: goto L31;
            case 14: goto L29;
            case 15: goto L27;
            case 16: goto L25;
            case 17: goto L23;
            case 18: goto L20;
            case 19: goto L19;
            case 20: goto L17;
            case 21: goto L14;
            case 22: goto L12;
            case 23: goto L11;
            case 24: goto L8;
            case 25: goto L7;
            default: goto L5;
        };
    L8:
        Map.Entry r10 = (Map.Entry) r5;
        return p7.R(((Map) r10.getValue()).entrySet().spliterator(), new z8(r10, 0));
    L12:
        y7 r11 = (y7) r5;
        return Collections.nCopies(r11.getCount(), r11.getElement()).spliterator();
    L14:
        Map.Entry r12 = (Map.Entry) r5;
        final Object r13 = r12.getKey();
        final int r14 = 1;
        return p7.R(((Collection) r12.getValue()).spliterator(), new j(r13, r14));
    L20:
        Map.Entry r15 = (Map.Entry) r5;
        r15.getClass();
        return new e7(r15);
    L56:
        Map.Entry r16 = (Map.Entry) r5;
        final Object r17 = r16.getKey();
        final int r18 = 0;
        return p7.R(((Collection) r16.getValue()).spliterator(), new j(r17, r18));
    L5:
        return ((z4) r5).a();
    L7:
        return ImmutableTable.copyOf(((p9) r5).f9123a);
    L11:
        return MutableClassToInstanceMap.access$100((Map.Entry) r5);
    L17:
        return ((Map.Entry) r5).getValue();
    L19:
        return ((Map.Entry) r5).getKey();
    L23:
        return ((v4) r5).j();
    L25:
        return ImmutableMap.copyOf((LinkedHashMap) r5);
    L27:
        return ((s4) r5).e();
    L29:
        return ((v3) r5).e();
    L31:
        return ((y4) r5).G0();
    L33:
        return ((x3) r5).a();
    L35:
        return ((j4) r5).a();
    L37:
        return ImmutableSortedMap.copyOfSorted((TreeMap) r5);
    L39:
        return ImmutableSetMultimap.copyOf((s8) r5);
    L41:
        return ImmutableMultiset.copyFromEntries(((z7) r5).entrySet());
    L43:
        return ImmutableListMultimap.copyOf((x5) r5);
    L45:
        return ((n4) r5).C0();
    L47:
        return ((u3) r5).D0();
    L49:
        return ((m4) r5).a();
    L51:
        return ((p3) r5).j();
    L53:
        return ((k9) r5).getValue();
    L55:
        return ((Collection) r5).spliterator();
    }
}
