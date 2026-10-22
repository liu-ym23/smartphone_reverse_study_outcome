package com.bytedance.android.live.openplatform.impl.minigameanchor.context;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import br0.b;
import br0.c;
import br0.d;
import br0.f;
import br0.g;
import br0.h;
import br0.i;
import br0.k;
import br0.l;
import br0.m;
import br0.o;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.e;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/context/LiveAnchorMiniGameContext;", "Lcom/bytedance/android/live/openplatform/impl/minigameanchor/context/AnchorMiniGameContext;", "", "startMount", "onCreate", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "instance", "onMiniGameInstanceCreate", "", "isInLive", "Z", "()Z", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/ViewGroup;", "containerView", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/view/ViewGroup;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorMiniGameContext extends AnchorMiniGameContext {
    public static final a Companion = null;
    private static final String TAG = "LiveAnchorMiniGameContext";
    private final boolean isInLive;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.context.AnchorMiniGameContext, com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final void startMount() {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        String r1 = null;
        if (r0 == null) goto L7;
        n<OpenPlatformMgInfoModel> r2 = r0.getOpenPlatformMg();
        if (r2 == null) goto L7;
        OpenPlatformMgInfoModel r3 = (OpenPlatformMgInfoModel) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        String r4 = r3.getTaskId();
    L11:
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        qo0.a.c(TAG, "task id is null or blank, can not start mount minigame");
        y3.m(getDataCenter()).i(ToolbarButton.LITTLE_GAME.extended());
        return;
    L21:
        if (r3 == null) goto L23;
        String r6 = r3.getTaskSource();
    L25:
        if (Intrinsics.areEqual(r6, "pop") == true) goto L31;
        if (r3 == null) goto L28;
        String r7 = r3.getTaskSource();
    L30:
        if (Intrinsics.areEqual(r7, "star") == true) goto L31;
        return;
    L28:
        r7 = null;
    L31:
        qo0.a.c(TAG, "start mount minigame");
        LiveMgMountContextService r8 = (LiveMgMountContextService) getService(LiveMgMountContextService.class);
        if (r3 == null) goto L34;
        r1 = r3.getAppId();
    L34:
        LiveMgMountContextService.h(r8, r4, r1);
        return;
    L23:
        r6 = null;
        goto L25
    L13:
        if (StringsKt.isBlank(r4) == true) goto L16;
        r5 = false;
        goto L18
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.context.AnchorMiniGameContext, com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext, com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public void onCreate() {
        super.onCreate();
        qo0.a.c(TAG, "onCreate");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, getDataCenter(), 0, 2);
        if (r0 == null) goto L9;
        j r1 = r0.getPreviewSourceParam();
        if (r1 == null) goto L9;
        PreviewSourceParam r2 = (PreviewSourceParam) r1.getValue();
        if (r2 == null) goto L9;
        OpenPlatformMgInfoModel r3 = r2.getOpenPlatformMg();
    L10:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r4 = AnchorMiniGameDataContext.a.a();
        if (r4 == null) goto L15;
        n<OpenPlatformMgInfoModel> r5 = r4.getOpenPlatformMg();
        if (r5 == null) goto L15;
        r5.setValue(r3);
    L15:
        LiveMgMountContextService r6 = (LiveMgMountContextService) getService(LiveMgMountContextService.class);
        r6.getClass();
        Lazy r7 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r6.getOpenPlatformContext().getDataCenter(), NewToolbarButtonConstants.LittleGame.INSTANCE, new e(r6));
        startMount();
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext
    public boolean isInLive() {
        return this.isInLive;
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext
    public void onMiniGameInstanceCreate(MiniAppInstance r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        super.onMiniGameInstanceCreate(r3);
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_resume_cast", new br0.j(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_pause_cast", new i(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_start_cast", new l(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_stop_cast", new m(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_cast_result", new g(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("is_live_casting", new d(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_game_process_killed", new b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_start_camera_preview", new k(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_camera_preview_rect", new br0.e(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_camera_status", new f(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_biz_finish_multilink", new h(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_open_lynx_page_in_game", new o(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_click_live_audience_num", new br0.a(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_instant_play_status", new lr0.b(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_instant_play_upload_progress", new c(this));
        ((BridgeContextService) getService(BridgeContextService.class)).h("on_live_xplay_audio_frame", new br0.n(this));
    }

    public LiveAnchorMiniGameContext(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.isInLive = true;
    }
}
