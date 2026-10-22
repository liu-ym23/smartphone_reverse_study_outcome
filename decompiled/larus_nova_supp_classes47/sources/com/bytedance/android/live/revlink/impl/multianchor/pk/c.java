package com.bytedance.android.live.revlink.impl.multianchor.pk;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(String r7, Map r8) {
        Intrinsics.checkNotNullParameter(r8, "userIdToTeamId");
        HashMap r0 = new HashMap();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r9.next();
        String r2 = (String) r1.getKey();
        long r3 = ((Number) r1.getValue()).longValue();
        if (r3 == 0) goto L4;
        List r4 = (List) r0.get(Long.valueOf(r3));
        if (r4 != null) goto L10;
        r4 = new ArrayList();
        r0.put(Long.valueOf(r3), r4);
    L10:
        r4.add(r2);
        goto L4
    L12:
        if (r0.entrySet().size() != 1) goto L16;
        return TuplesKt.to(ListProtector.get(CollectionsKt.toList(r0.values()), 0), CollectionsKt.emptyList());
    L16:
        if (r0.entrySet().size() != 2) goto L24;
        List r10 = (List) ListProtector.get(CollectionsKt.toList(r0.values()), 0);
        List r5 = (List) ListProtector.get(CollectionsKt.toList(r0.values()), 1);
        if (CollectionsKt.contains(r5, r7) == false) goto L22;
        return TuplesKt.to(r5, r10);
    L22:
        return TuplesKt.to(r10, r5);
    L24:
        return TuplesKt.to(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
