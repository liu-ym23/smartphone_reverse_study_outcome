package com.bytedance.android.btm.impl.util;

import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final AtomicLong a = null;
    public static final AtomicLong b = null;
    public static final AtomicLong c = null;

    static {
        a = new AtomicLong();
        b = new AtomicLong();
        c = new AtomicLong();
    }

    public static String b() {
        AtomicLong r0 = c;
        long r1 = r0.incrementAndGet();
        if (r1 <= ServerInfo.ERROR_BIND_SERVICE) goto L6;
        r0.set(0);
    L6:
        return "" + System.currentTimeMillis() + "_" + r1;
    }

    public static String c() {
        AtomicLong r0 = a;
        long r1 = r0.incrementAndGet();
        if (r1 <= ServerInfo.ERROR_BIND_SERVICE) goto L6;
        r0.set(0);
    L6:
        return "" + System.currentTimeMillis() + r1;
    }

    public static String a(String r10, String r11) {
        if (BtmSetting.d.c().c().x() != 1) goto L17;
        if (r11 == null) goto L13;
        List r12 = StringsKt.split$default(r11, new String[]{"#"}, false, 0, 6, null);
        if (r12 == null) goto L13;
        String r13 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r13 == null) goto L13;
        Long r14 = StringsKt.toLongOrNull(r13);
        if (r14 == null) goto L13;
        long r1 = r14.longValue();
    L15:
        return r10 + "#" + (r1 + 1);
    L13:
        r1 = 0;
        goto L15
    L17:
        return UUID.randomUUID().toString();
    }
}
