package wa8;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 {
    public final String a;
    public final f1 b;
    public final Map<CreationReferenceMediaType, g1> c;
    public final List<h1> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r6 = (d1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        f1 r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationReferenceCapability(displayText=" + this.a + ", mediaInfo=" + this.b + ", mediaRules=" + this.c + ", mixedRules=" + this.d + ')';
    }

    public final Integer c() {
        Set<CreationReferenceMediaType> r0 = this.c.keySet();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        g1 r4 = this.c.get((CreationReferenceMediaType) r3);
        if (r4 == null) goto L10;
        Integer r5 = r4.b;
        if (r5 == null) goto L10;
        r1.put(r3, Integer.valueOf(r5.intValue()));
    L10:
        return null;
    L12:
        if ((!r1.isEmpty()) == true) goto L15;
        r1 = null;
    L15:
        if (r1 != null) goto L17;
        return null;
    L17:
        int r6 = CollectionsKt.sumOfInt(r1.values());
        Iterator<T> r7 = this.d.iterator();
        int r8 = r6;
    L19:
        if (r7.hasNext() == false) goto L32;
        h1 r9 = (h1) r7.next();
        Integer r10 = r9.b;
        if (r10 == null) goto L19;
        int r11 = r10.intValue();
        Iterator<T> r12 = r9.a.iterator();
        int r13 = 0;
    L24:
        if (r12.hasNext() == false) goto L30;
        Integer r14 = (Integer) r1.get((CreationReferenceMediaType) r12.next());
        if (r14 == null) goto L28;
        int r15 = r14.intValue();
    L29:
        r13 = r13 + r15;
        goto L24
    L28:
        r15 = 0;
        goto L29
    L30:
        r8 = Math.min(r8, (r6 - r13) + r11);
        goto L19
    L32:
        return Integer.valueOf(r8);
    }

    public final boolean a(CreationReferenceMediaType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        g1 r4 = d(r3);
        if (r4 == null) goto L13;
        Integer r5 = r4.b;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.intValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r6 = false;
        goto L10
    L13:
        return false;
    }

    public final g1 d(CreationReferenceMediaType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.c.get(r2);
    }

    public final boolean b(final CreationReferenceMediaType r7, Map<CreationReferenceMediaType, Integer> r8) {
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, "currentCounts");
        g1 r0 = d(r7);
        if (r0 == null) goto L43;
        Integer r1 = r0.b;
        if (r1 == null) goto L44;
        int r2 = r1.intValue();
        if (r2 <= 0) goto L45;
        Integer r3 = r8.get(r7);
        if (r3 == null) goto L11;
        int r4 = RangesKt.coerceAtLeast(r3.intValue(), 0);
    L12:
        if (r4 >= r2) goto L46;
        Iterator r9 = SequencesKt.filter(CollectionsKt.asSequence(this.d), new c1(r7)).iterator();
    L15:
        boolean r5 = true;
        if (r9.hasNext() == false) goto L32;
        h1 r6 = (h1) r9.next();
        Integer r10 = r6.b;
        if (r10 == null) goto L30;
        int r11 = r10.intValue();
        Iterator<T> r12 = r6.a.iterator();
        int r13 = 0;
    L21:
        if (r12.hasNext() == false) goto L27;
        Integer r14 = r8.get((CreationReferenceMediaType) r12.next());
        if (r14 == null) goto L25;
        int r15 = RangesKt.coerceAtLeast(r14.intValue(), 0);
    L26:
        r13 = r13 + r15;
        goto L21
    L25:
        r15 = 0;
        goto L26
    L27:
        if (r13 < r11) goto L30;
        r5 = false;
    L30:
        if (r5 == true) goto L15;
        return false;
    L32:
        return true;
    L46:
        return false;
    L11:
        r4 = 0;
        goto L12
    L45:
        return false;
    L44:
        return false;
    L43:
        return false;
    }

    public d1(String r2, f1 r3, Map<CreationReferenceMediaType, g1> r4, List<h1> r5) {
        Intrinsics.checkNotNullParameter(r4, "mediaRules");
        Intrinsics.checkNotNullParameter(r5, "mixedRules");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
