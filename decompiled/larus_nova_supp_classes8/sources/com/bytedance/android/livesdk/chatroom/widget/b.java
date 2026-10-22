package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public b() {
    }

    public final Class<? extends Widget> c() {
        return AnchorEffectStatusServiceWidget.class;
    }

    public final boolean B(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (jr1.b.a(r4) == false) goto L5;
    L9:
        return false;
    L5:
        if (d90.c.o(r4) != LiveMode.VIDEO) goto L7;
    L8:
        return true;
    L7:
        if (d90.c.o(r4) != LiveMode.THIRD_PARTY) goto L9;
        goto L8
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.m2;
    }
}
