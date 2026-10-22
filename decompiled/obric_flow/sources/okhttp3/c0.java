package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f20622a;

    public c0(String[] r5) {
        this.f20622a = r5;
    }

    public final String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String[] r10 = this.f20622a;
        IntProgression r11 = RangesKt.step(RangesKt.downTo(r10.length - 2, 0), 2);
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        int r14 = r11.getStep();
        if (r14 < 0) goto L6;
        if (r12 <= r13) goto L8;
    L12:
        return null;
    L8:
        if (StringsKt.l(r5, r10[r12]) == true) goto L17;
        if (r12 == r13) goto L12;
        r12 = r12 + r14;
        goto L8
    L17:
        return r10[r12 + 1];
    L6:
        if (r12 < r13) goto L12;
        goto L12
    }

    public final String c(int r5) {
        String[] r10 = this.f20622a;
        return r10[r5 * 2];
    }

    public final b0 d() {
        b0 r5 = new b0();
        CollectionsKt.c(r5.f20620a, this.f20622a);
        return r5;
    }

    public final String e(int r5) {
        String[] r10 = this.f20622a;
        return r10[(r5 * 2) + 1];
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof c0) == false) goto L7;
        String[] r10 = ((c0) r5).f20622a;
        if (Arrays.equals(this.f20622a, r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final List f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        int r10 = size();
        ArrayList r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        if (StringsKt.l(r5, c(r12)) == false) goto L9;
        if (r11 != null) goto L8;
        r11 = new ArrayList(2);
    L8:
        r11.add(e(r12));
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r11 == null) goto L13;
        return Collections.unmodifiableList(r11);
    L13:
        return CollectionsKt.emptyList();
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f20622a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int r5 = size();
        Pair[] r10 = new Pair[r5];
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L6;
        r10[r11] = TuplesKt.to(c(r11), e(r11));
        r11 = r11 + 1;
        goto L3
    L6:
        return ArrayIteratorKt.iterator(r10);
    }

    public final int size() {
        return this.f20622a.length / 2;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        String r12 = c(r11);
        String r13 = e(r11);
        r5.append(r12);
        r5.append(": ");
        if (Util.isSensitiveHeader(r12) == false) goto L7;
        r13 = "██";
    L7:
        r5.append(r13);
        r5.append("\n");
        r11 = r11 + 1;
        goto L3
    L9:
        return r5.toString();
    }
}
