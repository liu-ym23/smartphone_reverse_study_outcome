package com.bytedance.android.live.impl;

import com.bytedance.android.live.feature.api.IFeatureService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    static {
    }

    public static Object a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chName");
        IFeatureService r0 = (IFeatureService) k.f(IFeatureService.class);
        if (r0 == null) goto L8;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L8;
        Object r2 = r1.getFeature(r4, null);
        if (r2 == null) goto L8;
    L10:
        if (r4.hashCode() != (-585881751)) goto L18;
        if (r4.equals("device_score") == false) goto L18;
        if (Intrinsics.areEqual(r2, 0) == false) goto L18;
        return null;
    L18:
        return r2;
    L8:
        r2 = null;
        goto L10
    }

    public static Object b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chName");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        IFeatureService r0 = (IFeatureService) k.f(IFeatureService.class);
        if (r0 == null) goto L11;
        z90.a r1 = r0.getFeatureManager();
        if (r1 == null) goto L12;
        Object r4 = r1.b(r2, r3, null);
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4;
    L12:
        return null;
    L11:
        return null;
    }
}
