package ti0;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import sh0.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.revenuebase.e {

    public static final class a implements ne0.d {
        public a() {
        }

        @Override // ne0.d
        public final void b() {
        }

        @Override // ne0.d
        public final void a(HashMap<String, String> r3) {
            Intrinsics.checkNotNullParameter(r3, "stateMapping");
            int r0 = h0.a;
            int r1 = e.a;
            r3.put("is_danmu_game_on", "danmu_game_is_on");
            r3.put("linkmic_game_state", "linkmic_game_state");
            r3.put("is_xplay_mixing", "is_xplay_mixing");
            r3.put("is_mic_seat_fold", "is_mic_seat_fold");
        }
    }

    public d() {
    }

    @Override // xh0.e
    public final ne0.d a(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new a();
    }

    @Override // xh0.e
    public final Widget b(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new LinkMicGameWidget();
    }

    @Override // xh0.e
    public final boolean c(SceneType r3) {
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return true;
    L5:
        if (r4 == 2) goto L9;
        return false;
    L9:
        return true;
    }
}
