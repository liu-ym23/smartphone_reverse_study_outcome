package com.bytedance.android.livesdk.dislike.sharefans.widget;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends i<e0> {
    public d() {
    }

    public final Class<? extends Widget> c() {
        return ShareFansWidget.class;
    }

    public final boolean B(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (jr1.b.a(r3) == false) goto L5;
    L7:
        return false;
    L5:
        if (d90.c.i(r3) == false) goto L7;
        return true;
    }

    public final f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.L1;
    }
}
