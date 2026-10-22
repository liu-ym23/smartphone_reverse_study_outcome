package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Map<Object, UnknownPageInfo> a = null;

    static {
        a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static UnknownPageInfo a(Object r10) {
        UnknownPageInfo r0 = c(r10);
        if (UnionBufferQueue.a(r0) == false) goto L5;
        String r1 = r10.getClass().getName();
        Lazy r11 = BtmFormatUtils.a;
        r0.setPageBtm("aUnknown.b" + StringsKt.replace$default(r1, '.', '_', false, 4, null) + ".c0.d0");
    L5:
        return r0;
    }

    public static UnknownPageInfo b(String r10) {
        Object r0 = null;
        if (r10 == null) goto L18;
        Map<Object, UnknownPageInfo> r1 = a;
        monitor-enter(r1);
        Iterator<T> r11 = r1.values().iterator();     // Catch: Throwable -> L15
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r12 = r11.next();     // Catch: Throwable -> L15
        if (((UnknownPageInfo) r12).getMountBtmIds().contains(r10) == false) goto L8;
        r0 = r12;
    L12:
        UnknownPageInfo r13 = (UnknownPageInfo) r0;     // Catch: Throwable -> L15
        monitor-exit(r1);
        return r13;
    L15:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public static UnknownPageInfo c(Object r10) {
        Map<Object, UnknownPageInfo> r0 = a;
        UnknownPageInfo r1 = r0.get(r10);
        if (r1 != null) goto L6;
        UnknownPageInfo r11 = new UnknownPageInfo();
        r0.put(r10, r11);
        return r11;
    L6:
        return r1;
    }
}
