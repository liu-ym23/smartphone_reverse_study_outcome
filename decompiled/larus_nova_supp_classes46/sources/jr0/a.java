package jr0;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.openplatform.impl.minigameaudience.widget.AudienceMiniGameWidget;
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
        return AudienceMiniGameWidget.class;
    }

    public final boolean B(b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (jr1.b.a(r3) == false) goto L5;
    L7:
        return false;
    L5:
        if (OpenPlatformHostInfoPresenter.a() == false) goto L7;
        return true;
    }

    public final f C(b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d) r3).f.getClass();
        return d.a.D3;
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
