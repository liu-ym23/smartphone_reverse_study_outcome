package com.obric.assistant.cocreationreview;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e4 {
    public final String a;
    public final String b;

    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("recommend_task_type", "omni_mobile_task"), TuplesKt.to("recommend_task_origin_query", this.b)});
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e4) == true) goto L8;
        return false;
    L8:
        e4 r6 = (e4) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CocreationTask(id=" + this.a + ", prompt=" + this.b + ')';
    }

    public e4(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "prompt");
        this.a = r2;
        this.b = r3;
    }
}
