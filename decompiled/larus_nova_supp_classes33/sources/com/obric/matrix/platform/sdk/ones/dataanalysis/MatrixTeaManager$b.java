package com.obric.matrix.platform.sdk.ones.dataanalysis;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MatrixTeaManager$b {
    public final String a;
    public final JSONObject b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MatrixTeaManager$b) == true) goto L8;
        return false;
    L8:
        MatrixTeaManager$b r6 = (MatrixTeaManager$b) r5;
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
        return "PendingEvent(eventName=" + this.a + ", jsonObject=" + this.b + ')';
    }

    public MatrixTeaManager$b(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        this.a = r2;
        this.b = r3;
    }
}
