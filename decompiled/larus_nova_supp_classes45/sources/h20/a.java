package h20;

import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(int r1) {
        if (r1 != InteractID.InteractLoki.getValue()) goto L5;
    L10:
        return true;
    L5:
        if (r1 == InteractID.InteractGamePlus.getValue()) goto L10;
        if (r1 == InteractID.InteractMiniApp.getValue()) goto L10;
        return false;
    }
}
