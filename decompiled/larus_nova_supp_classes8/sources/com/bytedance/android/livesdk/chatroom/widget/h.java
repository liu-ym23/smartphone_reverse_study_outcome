package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public h() {
    }

    public final Class<? extends Widget> c() {
        return AudienceStickerServiceWidget.class;
    }

    public final boolean B(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (jr1.b.a(r3) != true) goto L7;
        return false;
    L7:
        return true;
    }

    public final j70.f C(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.r2;
    }
}
