package com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends j70.i<e0> {
    public a() {
    }

    public final Class<? extends Widget> c() {
        return WelfareAudienceWelfareServiceWidget.class;
    }

    public final boolean B(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.c.i(r3) == true) goto L5;
    L9:
        return false;
    L5:
        if (jr1.b.a(r3) == true) goto L9;
        if (yt2.b.a().booleanValue() == false) goto L9;
        return true;
    }

    public final j70.f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.j;
    }
}
