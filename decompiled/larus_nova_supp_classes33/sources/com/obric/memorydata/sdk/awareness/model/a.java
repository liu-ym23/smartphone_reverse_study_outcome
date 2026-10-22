package com.obric.memorydata.sdk.awareness.model;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static final LocationInfo.AoiInfo a(LocationInfo.AoiInfo r3) {
        String r0 = r3.a();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r3.b();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r4 = r3.c();
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        Intrinsics.checkNotNullParameter(r0, "aoiId");
        Intrinsics.checkNotNullParameter(r2, "aoiName");
        Intrinsics.checkNotNullParameter(r1, "aoiType");
        return new LocationInfo.AoiInfo(r0, r2, r1);
    }
}
