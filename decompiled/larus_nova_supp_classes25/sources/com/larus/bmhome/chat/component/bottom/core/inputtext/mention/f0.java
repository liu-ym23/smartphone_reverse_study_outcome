package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public final List<c1> a;
    public final List<c> b;
    public final List<c1> c;
    public final List<c1> d;
    public final Map<MentionSearchDomain, d1> e;

    public f0() {
        this(null, null, null, null, 31);
    }

    public static f0 a(List r7, List r8, List r9, List r10, Map r11) {
        Intrinsics.checkNotNullParameter(r7, "drives");
        Intrinsics.checkNotNullParameter(r8, "contacts");
        Intrinsics.checkNotNullParameter(r9, "groups");
        Intrinsics.checkNotNullParameter(r10, "conversations");
        Intrinsics.checkNotNullParameter(r11, "pages");
        return new f0(r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ f0 b(f0 r1, List r2, List r3, List r4, List r5, Map r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = r1.d;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = r1.e;
    L17:
        r1.getClass();
        return a(r2, r3, r4, r5, r6);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "MentionPanelRemoteData(drives=" + this.a + ", contacts=" + this.b + ", groups=" + this.c + ", conversations=" + this.d + ", pages=" + this.e + ')';
    }

    public /* synthetic */ f0(List r7, List r8, List r9, List r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        List r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        List r2 = r8;
        if ((r11 & 4) == 0) goto L11;
        r9 = CollectionsKt.emptyList();
    L11:
        List r3 = r9;
        if ((r11 & 8) == 0) goto L14;
        r10 = CollectionsKt.emptyList();
    L14:
        List r4 = r10;
        if ((r11 & 16) == 0) goto L17;
        Map r12 = MapsKt.emptyMap();
    L18:
        this(r1, r2, r3, r4, r12);
        return;
    L17:
        r12 = null;
        goto L18
    }

    public f0(List<c1> r2, List<c> r3, List<c1> r4, List<c1> r5, Map<MentionSearchDomain, d1> r6) {
        Intrinsics.checkNotNullParameter(r2, "drives");
        Intrinsics.checkNotNullParameter(r3, "contacts");
        Intrinsics.checkNotNullParameter(r4, "groups");
        Intrinsics.checkNotNullParameter(r5, "conversations");
        Intrinsics.checkNotNullParameter(r6, "pages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
