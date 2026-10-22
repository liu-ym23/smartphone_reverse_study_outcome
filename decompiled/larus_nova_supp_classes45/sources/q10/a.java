package q10;

import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final PanelType a;
    public final PanelType b;

    public a(PanelType r2, PanelType r3) {
        Intrinsics.checkNotNullParameter(r2, "fromPanelType");
        Intrinsics.checkNotNullParameter(r3, "toPanelType");
        this.a = r2;
        this.b = r3;
    }
}
