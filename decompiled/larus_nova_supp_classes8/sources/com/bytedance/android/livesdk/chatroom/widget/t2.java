package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.config.cf1;
import com.bytedance.android.livesdk.config.kq0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t2 extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public t2() {
    }

    public final Class<? extends Widget> c() {
        return XBridgeServiceWidget.class;
    }

    public final boolean B(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (tb1.c.g == true) goto L5;
    L13:
        return false;
    L5:
        if (cf1.a.getValue().booleanValue() == false) goto L13;
        if (kq0.a.getValue().booleanValue() == true) goto L9;
    L12:
        return true;
    L9:
        if (d90.c.o(r4) != LiveMode.SCREEN_RECORD) goto L12;
        if (d90.c.c(r4) == true) goto L13;
        goto L12
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.x0;
    }
}
