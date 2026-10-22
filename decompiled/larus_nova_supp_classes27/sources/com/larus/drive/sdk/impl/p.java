package com.larus.drive.sdk.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class p implements Function1 {
    public /* synthetic */ p() {
    }

    public final Object invoke(Object r2) {
        int r0 = FlowDriveSdkServiceImpl.d;
        if (((WeakReference) r2).get() != null) goto L5;
        boolean r3 = true;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = false;
        goto L7
    }
}
