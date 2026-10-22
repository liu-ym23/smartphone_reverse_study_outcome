package k20;

import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r2) {
        int r0 = InteractGameLocalStatusUtils.a;
        String r3 = String.valueOf(((XplayScene) r2).getSceneId());
        Intrinsics.checkNotNullParameter(r3, "liveScene");
        InteractGameLocalStatusUtils.c("live_scene", r3);
    }
}
