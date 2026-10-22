package k20;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Action {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void run() {
        if (((XplayScene) this.a.c.getCurrentScene().getValue()) == XplayScene.TalkRoom) goto L5;
    L6:
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L13;
        m<Boolean> r1 = r0.isXPlayGameSessionRunning();
        if (r1 == null) goto L14;
        r1.setValue(Boolean.FALSE);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (this.a.b.d == false) goto L6;
    }
}
