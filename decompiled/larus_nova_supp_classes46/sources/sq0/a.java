package sq0;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.openplatform.api.utils.OpenPlatformHostInfoPresenter;
import com.bytedance.android.live.openplatform.impl.miniappaudience.widget.AudienceMiniAppWidget;
import com.bytedance.android.livesdk.config.c6;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.c;
import d90.d;
import h70.b;
import j70.f;
import j70.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends n<d90.a> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return AudienceMiniAppWidget.class;
    }

    public final boolean B(b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (jr1.b.a(r3) == false) goto L5;
    L9:
        return false;
    L5:
        if (OpenPlatformHostInfoPresenter.a() == false) goto L9;
        if (c.i(r3) == false) goto L9;
        return true;
    }

    public final f C(b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d) r3).f.getClass();
        return d.a.B3;
    }

    public final LayerIndex E(b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_6;
    }

    public final double H(b r4) {
        d90.a r5 = (d90.a) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        Room r6 = c.q(r5);
        c6 r0 = com.bytedance.android.livesdk.config.setting.d.a;
        Intrinsics.checkNotNullParameter("AudienceMiniApp", "widget");
        if (r6 != null) goto L5;
    L20:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L25;
        return 1.1d;
    L25:
        if (((wc1) de0.a.getValue()).n() == false) goto L28;
        return 0.2d;
    L28:
        return 1.1d;
    L5:
        if (r6.isVsRoom() == true) goto L20;
        if (r6.isMergeVSRoom() == true) goto L20;
        if (r6.isMediaRoom() == true) goto L20;
        c6 r1 = com.bytedance.android.livesdk.config.setting.d.a;
        if (r1.b() == false) goto L20;
        r2 = true;
        if (r6.isGameRoom() != 1) goto L20;
        List r7 = r1.a();
        if (r7 == null) goto L20;
        if (r7.contains("AudienceMiniApp") != true) goto L20;
        goto L20
    }

    public final ElementConstraint J(b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.b.a();
    }
}
