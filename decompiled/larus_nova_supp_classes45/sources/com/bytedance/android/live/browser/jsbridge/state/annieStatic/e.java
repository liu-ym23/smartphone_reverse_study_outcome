package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public e() {
    }

    public final /* synthetic */ JsonElement a(String r1) {
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r1);
    }

    public final /* synthetic */ com.bytedance.android.annie.api.data.subscribe.g c() {
        return com.bytedance.android.annie.api.data.subscribe.f.e(this);
    }

    public final /* synthetic */ char d() {
        return '.';
    }

    public final /* synthetic */ JsonElement e(String r1, String r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.b(this, r1, r2);
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    public final Object g() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("is_gaming", Integer.valueOf(((IBroadcastService) jc1.k.n(IBroadcastService.class)).isPlayingGame() ? 1 : 0));
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

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.d r0 = com.bytedance.android.live.browser.jsbridge.i.g.d.b;
        return "game";
    }
}
