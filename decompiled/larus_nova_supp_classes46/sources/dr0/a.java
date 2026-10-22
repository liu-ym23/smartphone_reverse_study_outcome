package dr0;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.openplatform.impl.minigameanchor.widget.AnchorMiniGameWidget;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import h70.b;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends n<d90.a> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return AnchorMiniGameWidget.class;
    }

    public final boolean B(b r3) {
        d90.a r4 = (d90.a) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (jr1.b.a(r4) == false) goto L16;
        DataCenter r5 = ((d) r4).h;
        if (r5 == null) goto L8;
        LiveMode r6 = (LiveMode) r5.get("data_live_mode", LiveMode.VIDEO);
    L10:
        if (r6 != LiveMode.VIDEO) goto L12;
    L17:
        return true;
    L12:
        if (r6 == LiveMode.AUDIO) goto L17;
        if (r6 != LiveMode.SCREEN_RECORD) goto L16;
    L8:
        r6 = null;
    L16:
        return false;
    }

    public final f C(b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d) r3).f.getClass();
        return d.a.C3;
    }

    public final LayerIndex E(b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_6;
    }

    public final double H(b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 0.2d;
    }

    public final ElementConstraint J(b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.b.a();
    }
}
