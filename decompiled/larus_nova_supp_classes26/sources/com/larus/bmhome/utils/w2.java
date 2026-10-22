package com.larus.bmhome.utils;

import com.larus.utils.logger.FLogger;
import dh8.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w2 {
    public static final ConcurrentHashMap<String, Integer> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static int a(String r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        Integer r3 = a.get(r2);
        if (r3 != null) goto L8;
        return 0;
    L8:
        return r3.intValue();
    }

    public static void b(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parentMessageId");
        FLogger.a.i("MultiContentSelectManager", "updateSelectIndex: " + r4 + " to " + r5);
        if (a(r4) == r5) goto L10;
        b.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "parentMessageId");
        if (b.b == null) goto L10;
        if (StringsKt.isBlank(r4) == true) goto L10;
        b.g.add(r4 + "#sub:" + r5);
    L10:
        a.put(r4, Integer.valueOf(r5));
    }
}
