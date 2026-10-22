package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class q {
    public static final List<String> a(List<? extends AppEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "appEntityList");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(((AppEntity) r3.next()).getId());
        goto L4
    L6:
        return r0;
    }

    public static final String b(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, a.a, 30, null);
    }
}
