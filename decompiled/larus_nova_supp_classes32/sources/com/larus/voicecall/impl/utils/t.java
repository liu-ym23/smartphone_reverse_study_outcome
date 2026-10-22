package com.larus.voicecall.impl.utils;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {
    public static final f2a.d a = null;
    public static final Map<String, Long> b = null;

    static {
        a = new f2a.d("voice_call", "subtitle");
        b = new LinkedHashMap();
    }

    public static final void a(String r6, long r7, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "uniTag");
        Intrinsics.checkNotNullParameter(r9, "block");
        Map<String, Long> r0 = b;
        Long r1 = (Long) ((LinkedHashMap) r0).get(r6);
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - r2) < r7) goto L10;
        r9.invoke();
        r0.put(r6, Long.valueOf(r3));
        return;
    L10:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
