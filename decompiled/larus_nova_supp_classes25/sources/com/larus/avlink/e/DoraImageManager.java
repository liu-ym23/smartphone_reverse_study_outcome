package com.larus.avlink.e;

import com.larus.utils.logger.FLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraImageManager {
    public static final Map<String, com.larus.avlink.model.a> a = null;

    static {
        a = Collections.synchronizedMap(new DoraImageManager$imageInfoMap$1());
    }

    public static com.larus.avlink.model.a a(Integer r1) {
        if (r1 == null) goto L5;
        r1.intValue();
        return a.get(r1.toString());
    L5:
        return null;
    }

    public static com.larus.avlink.model.a b(String r4) {
        Map<String, com.larus.avlink.model.a> r0 = a;
        monitor-enter(r0);
        Iterator<T> r1 = r0.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((com.larus.avlink.model.a) r2).H, r4) == false) goto L6;
    L11:
        com.larus.avlink.model.a r3 = (com.larus.avlink.model.a) r2;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return r3;
    L10:
        r2 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static void c(int r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        Map<String, com.larus.avlink.model.a> r0 = a;
        com.larus.avlink.model.a r1 = r0.get(String.valueOf(r2));
        if (r1 != null) goto L6;
        FLogger.a.e("DoraImageManager", "model is null, imageUUid: " + r2);
        return;
    L6:
        r3.invoke(r1);
        r0.put(String.valueOf(r2), r1);
    }
}
