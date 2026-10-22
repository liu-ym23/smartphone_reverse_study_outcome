package com.bytedance.android.live.broadcastgame.opengame.cloud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$containsKey");
        Intrinsics.checkNotNullParameter(r3, "key");
        Set r4 = r2.keySet();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        String r1 = (String) r5.next();
        if (r1 == null) goto L9;
        r0.add(r1.toLowerCase());
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        return r0.contains(r3.toLowerCase());
    }

    public static Object b(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$remove");
        Intrinsics.checkNotNullParameter(r4, "key");
        Iterator<String> r0 = r3.keys();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        if (StringsKt.equals(r1, r4, true) == false) goto L4;
        return r3.remove(r1);
    L9:
        return null;
    }
}
