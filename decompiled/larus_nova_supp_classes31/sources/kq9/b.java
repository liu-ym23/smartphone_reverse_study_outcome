package kq9;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final Map<String, Integer> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "albumNodeId");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        Map<String, Integer> r0 = a;
        monitor-enter(r0);
        Integer r1 = (Integer) ((LinkedHashMap) r0).get(r2);     // Catch: Throwable -> L14
        if (r1 == null) goto L10;
        int r3 = r1.intValue();     // Catch: Throwable -> L14
    L11:
        r0.put(r2, Integer.valueOf(r3 + 1));     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L10:
        r3 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "albumNodeId");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        Map<String, Integer> r0 = a;
        monitor-enter(r0);
        Integer r1 = (Integer) ((LinkedHashMap) r0).get(r2);     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        int r3 = r1.intValue();     // Catch: Throwable -> L17
    L11:
        int r4 = r3 - 1;     // Catch: Throwable -> L17
        if (r4 <= 0) goto L14;
        r0.put(r2, Integer.valueOf(r4));     // Catch: Throwable -> L17
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);
        return;
    L14:
        r0.remove(r2);     // Catch: Throwable -> L17
        goto L15
    L10:
        r3 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    public static boolean c(String r4) {
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Map<String, Integer> r3 = a;
        monitor-enter(r3);
        Integer r5 = (Integer) ((LinkedHashMap) r3).get(r4);     // Catch: Throwable -> L23
        if (r5 == null) goto L17;
        int r6 = r5.intValue();     // Catch: Throwable -> L23
    L18:
        if (r6 > 0) goto L21;
        r0 = false;
    L21:
        monitor-exit(r3);
        return r0;
    L17:
        r6 = 0;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }
}
