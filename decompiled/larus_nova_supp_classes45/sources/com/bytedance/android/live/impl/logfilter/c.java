package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements v {
    public static final CopyOnWriteArraySet<f> a = null;
    public static final c b = null;

    public c() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        b = new c();
        a = new CopyOnWriteArraySet();
    }

    public static void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        CopyOnWriteArraySet<f> r0 = a;
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
        return;
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        f r1 = (f) r0.next();
        if (r1 == null) goto L4;
        r1.onEvent(r3, r4);
        goto L4
    }
}
