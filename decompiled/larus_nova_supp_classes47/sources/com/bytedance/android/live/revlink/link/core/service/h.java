package com.bytedance.android.live.revlink.link.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final o51.e a(com.bytedance.android.live.revlink.link.biz.service.a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$parseDoubleUILayout");
        Boolean r0 = (Boolean) r5.getContext().getLinkDataSet().Fc().getValue();
        if (r0 != null) goto L5;
        r0 = Boolean.FALSE;
    L5:
        boolean r1 = r0.booleanValue();
        Boolean r2 = (Boolean) r5.getContext().getLinkDataSet().z9().getValue();
        if (r2 != null) goto L8;
        r2 = Boolean.FALSE;
    L8:
        boolean r3 = r2.booleanValue();
        if (r1 == true) goto L14;
        if (r3 == true) goto L14;
        return o51.e.g.e;
    L14:
        String r4 = r5.getContext().Ab();
        Intrinsics.checkNotNullParameter(r5, "$this$doubleGuestUID");
        return new o51.e.i(r1, r3, r4, com.bytedance.android.live.revlink.link.biz.service.i.u(r5));
    }
}
