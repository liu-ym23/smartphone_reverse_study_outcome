package aq1;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.utils.w1;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.MatchRoomLandscapeGestureWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends n<d> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return MatchRoomLandscapeGestureWidget.class;
    }

    public final boolean B(h70.b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (w1.b(r3) == true) goto L7;
        return false;
    L7:
        return jr1.a.e(r3);
    }

    public final f C(h70.b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.o3;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        return LayerIndex.INDEX_4;
    }

    public final ElementConstraint J(h70.b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        ElementConstraint r3 = ElementConstraint.n;
        return ElementConstraint.b.a();
    }
}
