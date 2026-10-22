package ji0;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import sh0.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends com.bytedance.android.live.liveinteract.revenuebase.e {

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
            int r1 = j.a;
            r3.put("is_guestbattle_showing", "guest_battle_is_showing");
        }
    }

    public i() {
    }

    @Override // xh0.e
    public final ne0.d a(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new a();
    }

    @Override // xh0.e
    public final Widget b(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new GuestBattleWidget(r2);
    }

    @Override // xh0.e
    public final boolean c(SceneType r3) {
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        int r4 = h.a[r3.ordinal()];
        if (r4 == 1) goto L8;
        if (r4 == 2) goto L9;
        return false;
    L9:
        return true;
    L8:
        return ((Boolean) vm2.d.r4.getValue(null, vm2.d.a[275(0x113, float:3.85E-43)])).booleanValue();
    }
}
