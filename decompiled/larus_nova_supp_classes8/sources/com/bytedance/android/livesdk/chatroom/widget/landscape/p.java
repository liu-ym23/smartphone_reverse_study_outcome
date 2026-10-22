package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends j70.i<e0> {
    public p() {
    }

    public final Class<? extends Widget> c() {
        return LandscapeQuickShotServiceWidget.class;
    }

    public final boolean B(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.c.f(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (m50.a.getValue().q() == false) goto L7;
        return true;
    }

    public final j70.f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.k2;
    }
}
