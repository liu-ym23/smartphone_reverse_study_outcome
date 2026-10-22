package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.actionbar.model.ReplyOption;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s1 {
    public static final CopyOnWriteArraySet<rs8.f> a = null;

    static {
        a = new CopyOnWriteArraySet();
    }

    public static void a() {
        Iterator<rs8.f> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().q0();
        goto L4
    }

    public static void b(com.larus.bmhome.actionbar.model.z0 r2, ReplyOption r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "targetOption");
        Iterator<rs8.f> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().w1(r2, r3);
        goto L4
    }
}
