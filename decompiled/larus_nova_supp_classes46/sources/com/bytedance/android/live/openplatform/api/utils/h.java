package com.bytedance.android.live.openplatform.api.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getAppId");
        SchemaInfo.s.getClass();
        SchemaInfo r2 = SchemaInfo.b.b(r1);
        if (r2 != null) goto L7;
        return "";
    L7:
        return r2.a();
    }

    public static final String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getStartPage");
        SchemaInfo.s.getClass();
        SchemaInfo r2 = SchemaInfo.b.b(r1);
        if (r2 == null) goto L6;
        String r3 = r2.e();
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static final String c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getStartPagePath");
        SchemaInfo.s.getClass();
        SchemaInfo r2 = SchemaInfo.b.b(r1);
        if (r2 == null) goto L6;
        String r3 = r2.f();
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMicroAppSchema");
        SchemaInfo.s.getClass();
        SchemaInfo r3 = SchemaInfo.b.b(r2);
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual((String) r3.g.getValue(), "micro_app") == false) goto L9;
        if ((!Intrinsics.areEqual(r3.a(), "null")) == false) goto L9;
        return true;
    }
}
