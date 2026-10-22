package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.livesdk.config.yo;
import com.bytedance.android.livesdk.config.z2;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends j70.i<d90.a> {
    public c() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return DraggableComponentServiceWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        int r3 = d.a;
        return Intrinsics.areEqual(((z2) yo.a.getValue()).a(), Boolean.TRUE);
    }

    @Override // j70.d
    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.X1;
    }
}
