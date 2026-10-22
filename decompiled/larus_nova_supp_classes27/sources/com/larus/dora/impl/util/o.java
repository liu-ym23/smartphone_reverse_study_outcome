package com.larus.dora.impl.util;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(DoraDevice r1) {
        String r0 = o59.a.d(r1);
        if (r0 != null) goto L8;
        String r2 = r1.name;
        if (r2 != null) goto L9;
        return "Ola Friend";
    L9:
        return r2;
    L8:
        return r0;
    }

    public static String b(String r5, String r6) {
        List r0 = DoraAdapterExtKt.k(kj4.a.g());
        if (r0 == null) goto L14;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L14;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        DoraDevice r7 = (DoraDevice) r4.next();
        if (Intrinsics.areEqual(r7.mac, r5) == true) goto L12;
        r3.add(Unit.INSTANCE);
        goto L8
    L12:
        return a(r7);
    L14:
        List r8 = DoraAdapterExtKt.j(kj4.a.g());
        if (r8 == null) goto L26;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L26;
        List r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L20:
        if (r12.hasNext() == false) goto L26;
        DoraDevice r13 = (DoraDevice) r12.next();
        if (Intrinsics.areEqual(r13.mac, r5) == true) goto L24;
        r11.add(Unit.INSTANCE);
        goto L20
    L24:
        return a(r13);
    L26:
        if (r5 != null) goto L29;
        r5 = "";
    L29:
        return o59.a.z(r5, r6);
    }
}
