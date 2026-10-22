package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends lh0.b {

    public static final class a {
    }

    static {
    }

    public n(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }

    public final void f(ih0.f r4, ih0.h r5) {
        Intrinsics.checkNotNullParameter(r4, "updateStatus");
        Intrinsics.checkNotNullParameter(r5, "updateCallback");
        JsonObject r1 = r4.d;
        if (r1 != null) goto L5;
        return;
    L5:
        DynamicUpdateType r6 = r4.getType();
        if (o.a[r6.ordinal()] != 1) goto L17;
        IKtvService r7 = jc1.k.f(IKtvService.class);
        if (r7 == null) goto L11;
        JsonObject r8 = r7.handleKtvCommonJsbUpdateAction(r1, false);
    L12:
        if (r8 == null) goto L14;
        Intrinsics.checkNotNullParameter(r5, "updateCallback");
        lh0.c.a.a(r5, r8);
        return;
    L14:
        e(r5, "");
        return;
    L11:
        r8 = null;
        goto L12
    }
}
