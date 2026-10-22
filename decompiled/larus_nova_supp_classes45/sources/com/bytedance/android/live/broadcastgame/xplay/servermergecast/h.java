package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        IInteractGameService r6 = (IInteractGameService) k.n(IInteractGameService.class);
        JSONObject r0 = new JSONObject();
        r0.put("app_data", this.a.d);
        Unit r1 = Unit.INSTANCE;
        r6.sendGameSeiData("key_game_pod_merge_stream_sei", r0.toString());
    }
}
