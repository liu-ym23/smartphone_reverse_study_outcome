package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends j70.i<e0> {
    public u() {
    }

    public final Class<? extends Widget> c() {
        return WelfareAnchorServiceWidget.class;
    }

    public final boolean B(h70.b r5) {
        e0 r6 = (e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (d90.c.i(r6) == false) goto L24;
        LiveMode r0 = d90.c.o(r6);
        if (r0 == null) goto L15;
        int r1 = t.a[r0.ordinal()];
        if (r1 != 1) goto L10;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
        return false;
    L19:
        if (jr1.b.a(r6) == true) goto L21;
        return false;
    L21:
        if (yt2.b.a().booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L10:
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L16;
    L15:
        r2 = false;
        goto L17
    L24:
        return false;
    }

    public final j70.f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.j;
    }
}
