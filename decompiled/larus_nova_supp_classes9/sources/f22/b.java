package f22;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.android.livesdk.guide.DSGuideWidget;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.c;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends n<e0> {
    public final boolean h() {
        return true;
    }

    public b() {
    }

    public final Class<? extends Widget> c() {
        return DSGuideWidget.class;
    }

    public final boolean B(h70.b r4) {
        e0 r5 = (e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        if (c.i(r5) == true) goto L5;
        return false;
    L5:
        if (b0.a() == true) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (jr1.b.a(r5) == false) goto L9;
        r6 = true;
        goto L10
    }

    public final f C(h70.b r2) {
        e0 r3 = (e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d) r3).f.getClass();
        return d.a.s0;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((e0) r2, "layerContext");
        return LayerIndex.INDEX_6;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((e0) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(h70.b r3) {
        Intrinsics.checkNotNullParameter((e0) r3, "layerContext");
        ElementConstraint r4 = new ElementConstraint(-1.0f, -2.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.BOTTOM;
        r4.d(r0, r0, 56.0f);
        return r4;
    }
}
