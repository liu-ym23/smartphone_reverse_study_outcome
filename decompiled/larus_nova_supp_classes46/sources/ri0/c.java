package ri0;

import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements g10.d {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    public c(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        Intrinsics.checkNotNullParameter(r2, "instance");
        MultiLinkGameWindowManager.q1(this.a, true);
    }

    public final void d(com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        Intrinsics.checkNotNullParameter(r2, "instance");
        MultiLinkGameWindowManager.q1(this.a, false);
    }
}
