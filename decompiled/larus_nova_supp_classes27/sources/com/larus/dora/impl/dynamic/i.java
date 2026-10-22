package com.larus.dora.impl.dynamic;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    static {
    }

    public static DoraDevice b() {
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 == null) goto L7;
        DoraDevice r1 = a(r0.mac);
        if (r1 == null) goto L7;
        return r1;
    L7:
        List r2 = DoraAdapterExtKt.k(kj4.a.g());
        List r3 = r2;
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        return null;
    L17:
        return (DoraDevice) CollectionsKt.first(r2);
    L10:
        if (r3.isEmpty() == true) goto L13;
        r4 = false;
        goto L14
    }

    public static DoraDevice a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mac");
        List r0 = DoraAdapterExtKt.k(kj4.a.g());
        if (r0 == null) goto L10;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((DoraDevice) r3).mac, r5) == false) goto L6;
        r2.add(r3);
    L11:
        boolean r6 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L21;
        if (r2 != null) goto L20;
        return null;
    L20:
        return (DoraDevice) CollectionsKt.first(r2);
    L21:
        List r7 = DoraAdapterExtKt.k(kj4.a.g());
        List r8 = r7;
        if (r8 != null) goto L24;
    L25:
        r6 = true;
    L26:
        if (r6 == false) goto L29;
        return null;
    L29:
        return (DoraDevice) CollectionsKt.first(r7);
    L24:
        if (r8.isEmpty() == false) goto L26;
    L14:
        if ((!r2.isEmpty()) != true) goto L16;
        r4 = true;
        goto L17
    L10:
        r2 = null;
        goto L11
    }
}
