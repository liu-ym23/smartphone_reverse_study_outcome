package kq9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final ConcurrentHashMap<String, Function2<d, Boolean, Unit>> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r1, d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((!StringsKt.isBlank(r1)) == false) goto L8;
        Function2<d, Boolean, Unit> r4 = a.get(r1);
        if (r4 == null) goto L9;
        r4.invoke(r2, Boolean.valueOf(r3));
        return;
    L9:
        return;
    }
}
