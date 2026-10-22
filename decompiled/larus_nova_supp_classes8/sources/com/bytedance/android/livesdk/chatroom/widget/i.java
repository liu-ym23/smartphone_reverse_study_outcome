package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final Class<? extends Widget> c() {
        IBarrageService r0 = jc1.k.f(IBarrageService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideCarnivalManagerWidget();
    }

    public i() {
    }

    public final boolean B(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.t3;
    }
}
