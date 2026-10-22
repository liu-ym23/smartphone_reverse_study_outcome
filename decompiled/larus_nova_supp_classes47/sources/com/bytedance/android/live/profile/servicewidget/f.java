package com.bytedance.android.live.profile.servicewidget;

import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends i<d90.d> {
    public f() {
    }

    public final Class<? extends Widget> c() {
        return ProfileServiceWidget.class;
    }

    public final boolean B(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.d) r2, "layerContext");
        return true;
    }

    public final j70.f C(h70.b r2) {
        d90.d r3 = (d90.d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.O1;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.d) r3, "layerContext");
        return 0.1d;
    }
}
