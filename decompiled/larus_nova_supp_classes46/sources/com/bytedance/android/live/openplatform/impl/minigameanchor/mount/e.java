package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.p7;
import com.bytedance.android.livesdkapi.depend.model.live.GameCategoryInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ToolbarComponentCheckInterface {
    public final /* synthetic */ LiveMgMountContextService a;

    public e(LiveMgMountContextService r1) {
        this.a = r1;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r4, Function0<Unit> r5, Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "loadButton");
        Intrinsics.checkNotNullParameter(r6, "stopLoadCallback");
        String r7 = r4.getComponentExtra();
        if (r4.getSource() != 1) goto L34;
        int r8 = qo0.a.a;
        qo0.a.c("LiveMgMountContextService", "candy toolbar message from IM message, extras: " + r7);
        LiveMgMountContextService r9 = this.a;
        int r10 = LiveMgMountContextService.h;
        if (y3.m(r9.getOpenPlatformContext().getDataCenter()).n(ToolbarButton.LITTLE_GAME) == true) goto L16;
        r5.invoke();
        AnchorMiniGameAppLogContextService.reportLiveRoomMgAppLog$default((AnchorMiniGameAppLogContextService) this.a.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class), "livesdk_anchor_micro_game_show", null, 2, null);
        Room r11 = this.a.getOpenPlatformContext().getRoom();
        if (r11 == null) goto L12;
        GameCategoryInfo r12 = r11.gameCategoryInfo;
        if (r12 == null) goto L12;
        Long r13 = r12.getCategoryId();
    L14:
        if (Intrinsics.areEqual(r13, p7.a.getValue()) == false) goto L16;
        AnchorMiniGameAppLogContextService r14 = (AnchorMiniGameAppLogContextService) this.a.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r15 = new HashMap();
        r15.put("launch_from", "live");
        r15.put("scene", LaunchParamConstant$Scene.b);
        r15.put("location", "anchor_game_live_btn");
        Unit r1 = Unit.INSTANCE;
        r14.reportLiveRoomMgAppLog("mp_show", r15);
    L12:
        r13 = null;
    L16:
        LiveMgMountContextService r16 = this.a;
        r16.c = true;
        r16.j(true);
        ((AnchorExplainCardContextService) this.a.getOpenPlatformContext().getService(AnchorExplainCardContextService.class)).b = true;
        this.a.getClass();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r17 = AnchorMiniGameDataContext.a.a();
        if (r17 == null) goto L23;
        com.bytedance.live.datacontext.n<OpenPlatformMgInfoModel> r18 = r17.getOpenPlatformMg();
        if (r18 == null) goto L23;
        OpenPlatformMgInfoModel r19 = (OpenPlatformMgInfoModel) r18.getValue();
        if (r19 == null) goto L23;
        String r20 = r19.getAppId();
    L24:
        if (r20 == null) goto L34;
        if (r20.length() <= 0) goto L28;
        boolean r21 = true;
    L29:
        if (r21 == true) goto L32;
        r20 = null;
    L32:
        if (r20 == null) goto L34;
        com.bytedance.android.live.openplatform.impl.base.utils.m.f(Observable.create(new j("sslocal://" + SchemaInfo.Host.MICROGAME + "?app_id=" + r20)).subscribeOn(Schedulers.io()), null);
        goto L34
    L28:
        r21 = false;
    L23:
        r20 = null;
    L34:
        return true;
    }
}
