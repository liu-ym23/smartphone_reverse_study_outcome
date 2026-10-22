package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.business.stateservice.api.GamePromoteServiceApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ ToolbarBroadcastFunction b;
    public final /* synthetic */ long c;

    public l(Function1 r1, ToolbarBroadcastFunction r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        this.a.invoke(Boolean.TRUE);
        if (this.b != ToolbarBroadcastFunction.GAME_PROMOTE) goto L5;
        ((GamePromoteServiceApi) com.bytedance.android.live.network.c.b().e(GamePromoteServiceApi.class)).setRoomStatus(String.valueOf(this.c), "2").subscribe(j.a, k.a);
    L5:
        ToolbarBroadcastFunction r5 = this.b;
        if (r5 != ToolbarBroadcastFunction.MIX_MINI_APP) goto L8;
    L9:
        jc1.k.n(IInteractGameService.class).stopRunningPlugin("user switch");
        return;
    L8:
        if (r5 == ToolbarBroadcastFunction.MINI_GAME) goto L9;
    }
}
