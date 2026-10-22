package j30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("is_gaming", Integer.valueOf(((IBroadcastService) k.n(IBroadcastService.class)).isPlayingGame() ? 1 : 0));
        AudienceGameContext r1 = (AudienceGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, AudienceGameContext.class);
        if (r1 == null) goto L7;
        n<r> r2 = r1.getCurrentGame();
        if (r2 == null) goto L7;
        r r3 = (r) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        r0.addProperty("game_id", String.valueOf(r3.p()));
        r0.addProperty("game_name", String.valueOf(r3.q()));
    L10:
        return r0;
    L7:
        r3 = null;
        goto L8
    }

    public c() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.d.b;
    }
}
