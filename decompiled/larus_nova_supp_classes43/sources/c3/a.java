package c3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Comparable<a> {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Version(versionString=" + this.a + ')';
    }

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "versionString");
        this.a = r10;
        boolean r0 = true;
        Object r11 = 0;
        List r12 = StringsKt.split$default(r10, new char[]{'.'}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Integer r14 = StringsKt.toIntOrNull((String) r13.next());
        if (r14 == null) goto L8;
        int r15 = r14.intValue();
    L9:
        r1.add(Integer.valueOf(r15));
        goto L4
    L8:
        r15 = 0;
        goto L9
    L11:
        if (r1.size() <= 0) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == false) goto L16;
        Object r17 = ListProtector.get(r1, 0);
    L17:
        this.b = ((Number) r17).intValue();
        if (1 >= r1.size()) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L23;
        Object r19 = ListProtector.get(r1, 1);
    L24:
        this.c = ((Number) r19).intValue();
        if (2 < r1.size()) goto L28;
        r0 = false;
    L28:
        if (r0 == false) goto L30;
        r11 = ListProtector.get(r1, 2);
    L30:
        this.d = ((Number) r11).intValue();
        return;
    L23:
        r19 = r11;
        goto L24
    L20:
        r18 = false;
        goto L21
    L16:
        r17 = r11;
        goto L17
    L13:
        r16 = false;
        goto L14
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r10) {
        a r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "other");
        int r0 = this.b;
        int r1 = r11.b;
        if (r0 != r1) goto L10;
        int r12 = this.c;
        int r13 = r11.c;
        if (r12 == r13) goto L9;
        return Intrinsics.compare(r12, r13);
    L9:
        return Intrinsics.compare(this.d, r11.d);
    L10:
        return Intrinsics.compare(r0, r1);
    }
}
