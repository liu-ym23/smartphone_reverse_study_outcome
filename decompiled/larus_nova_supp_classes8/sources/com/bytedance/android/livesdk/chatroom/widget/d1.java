package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d1 extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public d1() {
    }

    public final Class<? extends Widget> c() {
        return LiveVisibilityControlWidget.class;
    }

    public final boolean B(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        LiveVisibilityControlContext.Companion.getClass();
        if (((e51) j40.b1.a.getValue()).b() == true) goto L5;
    L13:
        return false;
    L5:
        if (jr1.b.a(r5) == true) goto L13;
        if (d90.c.i(r5) == true) goto L13;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r0 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        RoomContext r1 = r5.b();
        DataCenter r2 = ((d90.d) r5).h;
        r0.getClass();
        if (com.bytedance.android.livesdk.chatroom.utils.h1.a.d(r1, r2) == true) goto L13;
        if (VSMediaUIConfigHelper.c(r5) == true) goto L13;
        return true;
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.T;
    }
}
