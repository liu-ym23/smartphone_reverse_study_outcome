package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.config.ah;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public c() {
    }

    public final Class<? extends Widget> c() {
        return AnchorToolbarDotMessageWidget.class;
    }

    public final boolean B(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.c.c(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (ah.a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.n2;
    }
}
