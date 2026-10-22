package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.config.b11;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d7 {
    public static final Map<Long, Long> a = null;
    public static boolean b;
    public static long c;

    static {
        a = new LinkedHashMap();
    }

    public static boolean a(long r8) {
        if (((b11) com.bytedance.android.livesdk.config.v9.a.getValue()).a() == true) goto L6;
        return false;
    L6:
        if (b == false) goto L8;
        return false;
    L8:
        long r2 = System.currentTimeMillis() - c;
        Map<Long, Long> r0 = a;
        Long r4 = Long.valueOf(r8);
        Long r9 = (Long) ((LinkedHashMap) r0).get(Long.valueOf(r8));
        if (r9 == null) goto L11;
        long r10 = r9.longValue();
    L12:
        r0.put(r4, Long.valueOf(r10 + r2));
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = ((LinkedHashMap) r0).entrySet().iterator();
    L13:
        boolean r3 = true;
        if (r12.hasNext() == false) goto L22;
        Map.Entry r1 = (Map.Entry) r12.next();
        if (((Number) r1.getValue()).longValue() > 30000) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L13;
        r11.put(r1.getKey(), r1.getValue());
        goto L13
    L22:
        if (r11.size() > 0) goto L25;
        return false;
    L25:
        if (com.bytedance.android.livesdk.chatroom.utils.o4.d == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r10 = 0;
        goto L12
    }
}
