package com.larus.bmhome.taskskill;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c2 {
    public final String a;
    public final List<String> b;
    public final Integer c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r6 = (c2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SkillMessagePayload(queryPrefix=" + this.a + ", selectedSkillIds=" + this.b + ", runtimeType=" + this.c + ')';
    }

    public c2() {
        this("", CollectionsKt.emptyList(), null);
    }

    public c2(String r2, List<String> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "queryPrefix");
        Intrinsics.checkNotNullParameter(r3, "selectedSkillIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
