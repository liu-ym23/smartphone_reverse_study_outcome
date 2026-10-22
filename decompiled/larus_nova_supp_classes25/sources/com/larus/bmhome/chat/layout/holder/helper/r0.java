package com.larus.bmhome.chat.layout.holder.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r0 {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new p0());
        b = LazyKt.lazy(new q0());
    }

    public static List a(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        Lazy r1 = b;
        if (((Number) r1.getValue()).intValue() >= 0) goto L14;
        int r2 = Integer.MAX_VALUE;
    L16:
        if (r5.length() <= r2) goto L18;
        return null;
    L18:
        Matcher r6 = ((Pattern) a.getValue()).matcher(r5);
        ArrayList r3 = new ArrayList();
    L20:
        if (r6.find() == false) goto L22;
        int r4 = r6.start();
        int r7 = r6.end();
        String r8 = r6.group();
        r3.add(new Triple(Integer.valueOf(r4), Integer.valueOf(r7), r8));
        goto L20
    L22:
        return r3;
    L14:
        r2 = ((Number) r1.getValue()).intValue();
        goto L16
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}
