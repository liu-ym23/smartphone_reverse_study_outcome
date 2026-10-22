package com.larus.suggest.impl.wcb.loading;

import com.larus.im.bean.message.Message;
import com.larus.suggest.impl.wcb.render.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements td8.c {
    public final td8.d a;

    public a(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        ConcurrentHashMap<Long, b> r5 = c.a;
        if (c.a(this.a.b()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<xc8.b> b(int r7, xc8.b r8, xc8.b r9, List<xc8.b> r10) {
        Intrinsics.checkNotNullParameter(r9, "current");
        Intrinsics.checkNotNullParameter(r10, "input");
        ConcurrentHashMap<Long, b> r11 = c.a;
        b r12 = c.a(this.a.b());
        if (r12 != null) goto L6;
        return r10;
    L6:
        if (r12.o.isCompleted() == true) goto L42;
        List<xc8.b> r13 = r10;
        boolean r0 = false;
        if ((r13 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L40;
        Message r15 = ((xc8.b) r14.next()).getMessage();
        Intrinsics.checkNotNullParameter(r15, "message");
        n.b r1 = r12.m;
        if (r1 == null) goto L37;
        Map r3 = r15.getExt();
        if (r3 != null) goto L22;
        r3 = MapsKt.emptyMap();
    L22:
        if (Intrinsics.areEqual(r15.getConversationId(), r12.c) == false) goto L37;
        if (Intrinsics.areEqual(r15.getLocalMessageId(), r1.a) == false) goto L37;
        Map<String, String> r16 = r1.b;
        if (r16.isEmpty() == true) goto L34;
        Iterator<Map.Entry<String, String>> r17 = r16.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L34;
        Map.Entry<String, String> r2 = r17.next();
        String r4 = r2.getKey();
        String r5 = r2.getValue();
        if (Intrinsics.areEqual(r3.get(r4), r5) == true) goto L30;
        boolean r18 = false;
    L35:
        if (r18 == false) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == false) goto L14;
        r0 = true;
    L34:
        r18 = true;
    L37:
        r19 = false;
    L40:
        if (r0 == false) goto L42;
        r12.o.complete(Unit.INSTANCE);
        goto L42
    L10:
        if (r13.isEmpty() == false) goto L12;
    L42:
        return r10;
    }
}
