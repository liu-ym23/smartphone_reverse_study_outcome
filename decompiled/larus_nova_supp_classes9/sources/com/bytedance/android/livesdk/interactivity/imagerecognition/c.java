package com.bytedance.android.livesdk.interactivity.imagerecognition;

import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends i<d90.a> {
    public c() {
    }

    public final Class<? extends Widget> c() {
        return ImageRecognitionServiceWidget.class;
    }

    public final boolean B(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        int r0 = s32.b.a;
        if (((d8) y00.a.getValue()).a() == true) goto L5;
    L7:
        return false;
    L5:
        if (d90.c.i(r3) == false) goto L7;
        return true;
    }

    public final f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.t;
    }
}
