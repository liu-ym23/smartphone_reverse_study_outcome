package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public static final boolean b(com.larus.bmhome.resource.access.h0 r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        com.larus.bmhome.resource.access.x r2 = com.larus.uaigc.service.f.a;
        if (SetsKt.setOf(new com.larus.bmhome.resource.access.x[]{com.larus.uaigc.service.f.a, com.larus.uaigc.service.f.b, com.larus.uaigc.service.f.c}).contains(r6.a.a) == true) goto L5;
        return false;
    L5:
        if (SetsKt.setOf(new ResourceMediaType[]{ResourceMediaType.IMAGE, ResourceMediaType.VIDEO}).contains(r6.a.c) == true) goto L7;
        return false;
    L7:
        if (SetsKt.setOf(new ResourceInputType[]{ResourceInputType.LOCAL_PATH, ResourceInputType.CONTENT_URI, ResourceInputType.TOS_KEY, ResourceInputType.REMOTE_URL}).contains(r6.c.getType()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean a(com.larus.bmhome.resource.access.h0 r1, String r2, Function1<? super com.larus.bmhome.resource.access.v, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "extKey");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (((Boolean) r3.invoke(r1.a.d.k)).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1.b().get(r2), "true") == true) goto L8;
        return false;
    }
}
