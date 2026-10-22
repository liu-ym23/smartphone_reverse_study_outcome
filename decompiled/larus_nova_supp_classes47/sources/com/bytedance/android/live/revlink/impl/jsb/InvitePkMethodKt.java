package com.bytedance.android.live.revlink.impl.jsb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class InvitePkMethodKt {
    public static final Map<String, String> a(n.a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$extraMap");
        final JsonObject r5 = r4.getExtra();
        if (r5 == null) goto L15;
        Sequence r0 = SequencesKt.filter(CollectionsKt.asSequence(r5.keySet()), new InvitePkMethodKt$extraMap$1$1(r5));
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        JsonElement r6 = r5.get(r3);
        if (r6 == null) goto L11;
        String r7 = r6.getAsString();
        if (r7 == null) goto L11;
    L12:
        Pair r8 = TuplesKt.to(r3, r7);
        r1.put(r8.getFirst(), r8.getSecond());
    L11:
        r7 = "";
        goto L12
    L13:
        return r1;
    L15:
        return MapsKt.emptyMap();
    }
}
