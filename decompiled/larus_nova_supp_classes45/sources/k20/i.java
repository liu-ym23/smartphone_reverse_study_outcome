package k20;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Action {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void run() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.isXPlayGameSessionRunning();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }
}
