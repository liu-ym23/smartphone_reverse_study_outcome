package com.larus.collection.impl.view;

import com.larus.platform.model.MessageCollection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final int a;
    public final List<MessageCollection> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CollectionListResponse(status=" + this.a + ", list=" + this.b + ')';
    }

    public b(@ResultStatus int r2, List<MessageCollection> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        this.a = r2;
        this.b = r3;
    }
}
