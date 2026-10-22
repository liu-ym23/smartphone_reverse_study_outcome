package com.bytedance.android.live.ktv.common.model.api;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 {
    public static final List<String> a(i0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getViceSingerList");
        List<String> r0 = r1.chorusUserOpenIds;
        if (r0 == null) goto L6;
        List<String> r2 = CollectionsKt.toMutableList(r0);
        if (r2 == null) goto L6;
    L7:
        r2.remove(r1.c());
        return r2;
    L6:
        r2 = new ArrayList();
        goto L7
    }
}
