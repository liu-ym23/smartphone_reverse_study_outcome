package com.bytedance.android.livesdk.chatroom.vs_host.business;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerServiceV2;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;
import zg1.p1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements yr1.s, com.bytedance.android.scope.o {

    public static final class a {
    }

    static {
    }

    public z() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.s
    public final NextLiveData<Boolean> d() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L9;
        IGameStickerServiceV2 r1 = r0.getGameStickerServiceV2();
        if (r1 == null) goto L9;
        IGameStickerContext r2 = r1.getDataContext(GameStickerScene.ENTER);
        if (r2 == null) goto L9;
        return r2.isGameStickerVisible();
    L9:
        return null;
    }

    @Override // yr1.s
    public final MutableLiveData<Boolean> f() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.gameExtraRenderController().isEnable() == false) goto L11;
        return r0.gameExtraRenderController().eventHub().getExtraRenderIsShow();
    L11:
        return r0.multiRenderController().eventHub().getMultiRenderIsShow();
    }

    @Override // yr1.s
    public final boolean c(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Integer r5 = (Integer) r4.get("data_link_state", 0);
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        if (r6 == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r6 = 0;
        goto L6
    }

    @Override // yr1.s
    public final void a(DataCenter r2, Observer<KVData> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.removeObserver("data_link_state", r3);
    }

    @Override // yr1.s
    public final void g(DataCenter r2, Observer<KVData> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.observe("data_link_state", r3);
    }

    @Override // yr1.s
    public final void h(DataCenter r4, int r5) {
        if (r4 == null) goto L4;
        r4.put("cmd_ugc_linked_room_state_change", new p1(r5));
    L4:
        RxBusAbility.INSTANCE.getRxBus(r4).post(new o42.c(false, true, "UGC_LINKED_ROOM"));
    }
}
