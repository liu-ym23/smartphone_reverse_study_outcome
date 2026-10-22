package com.bytedance.android.live.openplatform.impl.minigameanchor;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.launch.AnchorLaunchMgContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.h;
import com.bytedance.android.live.openplatform.impl.minigameanchor.panel.MiniGameFeaturePanelContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.panel.MiniGameFeaturePanelDialog;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameDialogFragment;
import com.bytedance.android.live.openplatform.impl.minigameanchor.widget.PreviewMiniGameWidgetDelegate;
import com.bytedance.android.livesdk.config.m51;
import com.bytedance.android.livesdk.config.r50;
import com.bytedance.android.livesdk.config.x80;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import cr0.b;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniGameAnchorServiceImpl implements vo0.a {
    public PreviewMiniGameWidgetDelegate a;
    public OpenPlatformContext b;

    public static final class a {
    }

    static {
    }

    public MiniGameAnchorServiceImpl() {
    }

    @Override // vo0.a
    public final boolean c() {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L7;
        LiveMgMountContextService r1 = (LiveMgMountContextService) r0.getService(LiveMgMountContextService.class);
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return false;
    }

    @Override // vo0.a
    public final dr0.a getAnchorMiniGameWidgetDescriptor() {
        return new dr0.a();
    }

    @Override // vo0.a
    public final Map<String, String> getMiniGameAppCommonLogMap() {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        AnchorMiniGameAppLogContextService r1 = (AnchorMiniGameAppLogContextService) r0.getService(AnchorMiniGameAppLogContextService.class);
        if (r1 == null) goto L8;
        Map<String, String> r2 = r1.getPreviewMgCommonLogMap();
        if (r2 == null) goto L8;
        return r2;
    L8:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("_param_for_special", "micro_game");
        return r3;
    }

    @Override // vo0.a
    public final void unmount() {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        LiveMgMountContextService r1 = (LiveMgMountContextService) r0.getService(LiveMgMountContextService.class);
        if (r1 == null) goto L9;
        r1.n(AnonymousClass1.INSTANCE);
        return;
    L9:
        return;
    }

    @Override // xo0.a
    public final OpenPlatformContext a() {
        return this.b;
    }

    @Override // xo0.a
    public final void b(OpenPlatformContext r1) {
        this.b = r1;
    }

    @Override // vo0.a
    public final void d(String r3) {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        AnchorLaunchMgContextService r1 = (AnchorLaunchMgContextService) r0.getService(AnchorLaunchMgContextService.class);
        if (r1 == null) goto L9;
        r1.j(r3, null);
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void previewItemClick(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        PreviewMiniGameWidgetDelegate r1 = this.a;
        if (r1 == null) goto L23;
        Intrinsics.checkNotNullParameter(r4, "context");
        if (((Boolean) x80.a.getValue()).booleanValue() == false) goto L12;
        ((PreviewMiniGameContextService) r1.a.getService(PreviewMiniGameContextService.class)).getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = ((m51) r50.a.getValue()).a();
        if (r0 != null) goto L9;
        r0 = "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fwww.xingtu.cn%2Fmobile%2Fstar-vue3%2Fsup%2Fgame%2Flive-landing%3Futm_source3Dlive_entrance&hide_nav_bar=1&height_percent=100&mix_container_type=annie&hide_status_bar=1&should_full_screen=1&host=aweme&engine_type=new&status_bar_color=black&status_font_mode=dark";
    L9:
        ILiveActionHandler r2 = k.f(ILiveActionHandler.class);
        if (r2 == null) goto L23;
        r2.handle(r4, r0);
        goto L23
    L12:
        ((PreviewMiniGameContextService) r1.a.getService(PreviewMiniGameContextService.class)).getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r3 = AnchorMiniGameDataContext.a.a();
        if (r3 == null) goto L23;
        n<OpenPlatformMgInfoModel> r5 = r3.getOpenPlatformMg();
        if (r5 == null) goto L23;
        OpenPlatformMgInfoModel r6 = (OpenPlatformMgInfoModel) r5.getValue();
        if (r6 == null) goto L23;
        PreviewMiniGameDialogFragment r7 = new PreviewMiniGameDialogFragment();
        r7.f = r6;
        FragmentManager r8 = ((FragmentActivity) r4).getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "PreviewMiniGameDialogFragment", r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r9) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L22:
        r7.showNow(r8, "PreviewMiniGameDialogFragment");
    L23:
        OpenPlatformContext r10 = this.b;
        if (r10 == null) goto L32;
        AnchorMiniGameAppLogContextService r11 = (AnchorMiniGameAppLogContextService) r10.getService(AnchorMiniGameAppLogContextService.class);
        if (r11 == null) goto L33;
        AnchorMiniGameAppLogContextService.reportPreviewMgAppLog$default(r11, "livesdk_takepage_micro_game_click", null, 2, null);
        return;
    L33:
        return;
    }

    @Override // vo0.a
    public final void setMountStatus(boolean r3) {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        LiveMgMountContextService r1 = (LiveMgMountContextService) r0.getService(LiveMgMountContextService.class);
        if (r1 == null) goto L9;
        r1.j(r3);
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void mount(Context r10, u r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "item");
        OpenPlatformContext r2 = this.b;
        if (r2 == null) goto L31;
        LiveMgMountContextService r3 = (LiveMgMountContextService) r2.getService(LiveMgMountContextService.class);
        if (r3 == null) goto L32;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "item");
        r r0 = r11.c();
        if (r0 == null) goto L33;
        c0 r5 = r0.x();
        if (r5 == null) goto L34;
        r5.a = r11.d;
        r5.b = r11.e;
        if (r3.c == true) goto L13;
    L23:
        r3.f = r5;
        ((AnchorMiniGameAppLogContextService) r3.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class)).setMicroGameInfo(r3.f);
        String r12 = r5.schema;
        if (r12 == null) goto L27;
        m.f(Observable.create(new h(r12)).subscribeOn(Schedulers.io()), null);
    L27:
        if (r5.b == true) goto L29;
        LiveMgMountContextService.k(r3, r3.getOpenPlatformContext().getContext(), r5, null, null, 28);
        return;
    L29:
        r3.g(r10, r5);
        return;
    L13:
        if (Intrinsics.areEqual(r5.gameId, r3.b) == false) goto L23;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.m<String> r4 = r1.getOpenFeatureBinderId();
        if (r4 == null) goto L20;
        r4.setValue(r3.b);
    L20:
        if (r11.e == false) goto L22;
        r3.l();
        return;
    L22:
        ((MiniGameCommonJsbContextService) r3.getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).j(r10, null);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    }

    @Override // vo0.a
    public final void openBottomFeaturePanel(Context r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        OpenPlatformContext r1 = this.b;
        if (r1 == null) goto L18;
        MiniGameFeaturePanelContextService r2 = (MiniGameFeaturePanelContextService) r1.getService(MiniGameFeaturePanelContextService.class);
        if (r2 == null) goto L18;
        Intrinsics.checkNotNullParameter(r5, "context");
        DataCenter r0 = r2.getOpenPlatformContext().getDataCenter();
        if (r0 == null) goto L9;
        LiveMode r3 = (LiveMode) r0.get("data_live_mode", LiveMode.VIDEO);
    L11:
        if (r3 != LiveMode.VIDEO) goto L13;
        ((MiniGameCommonJsbContextService) r2.getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).j(r5, r6);
        goto L18
    L13:
        MiniGameFeaturePanelDialog r7 = new MiniGameFeaturePanelDialog();
        FragmentManager r8 = ((FragmentActivity) r5).getSupportFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "MiniGameFeaturePanelDialog", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r4) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L17:
        r7.showNow(r8, "MiniGameFeaturePanelDialog");
        goto L18
    L9:
        r3 = null;
    L18:
        OpenPlatformContext r9 = this.b;
        if (r9 == null) goto L27;
        AnchorMiniGameAppLogContextService r10 = (AnchorMiniGameAppLogContextService) r9.getService(AnchorMiniGameAppLogContextService.class);
        if (r10 == null) goto L28;
        HashMap<String, String> r11 = new HashMap();
        r11.put("click_type", "icon");
        Unit r12 = Unit.INSTANCE;
        r10.reportLiveRoomMgAppLog("livesdk_anchor_micro_game_click", r11);
        return;
    L28:
        return;
    }

    @Override // vo0.a
    public final void previewSwitchTask(String r4, String r5) {
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        PreviewMiniGameContextService r1 = (PreviewMiniGameContextService) r0.getService(PreviewMiniGameContextService.class);
        if (r1 == null) goto L9;
        Lazy r2 = LiveOpenPlatformMgClient.c;
        r1.autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).previewSwitchTask(r4, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(cr0.a.a, b.a));
        return;
    L9:
        return;
    }

    @Override // vo0.a
    public final void reportMiniGameAppLog(String r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        OpenPlatformContext r0 = this.b;
        if (r0 != null) goto L5;
    L11:
        OpenPlatformContext r1 = this.b;
        if (r1 == null) goto L20;
        AnchorMiniGameAppLogContextService r2 = (AnchorMiniGameAppLogContextService) r1.getService(AnchorMiniGameAppLogContextService.class);
        if (r2 == null) goto L21;
        r2.reportLiveRoomMgAppLog(r3, r4);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r0.isInLive() == true) goto L11;
        OpenPlatformContext r5 = this.b;
        if (r5 == null) goto L17;
        AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
        if (r6 == null) goto L18;
        r6.reportPreviewMgAppLog(r3, r4);
        return;
    L18:
        return;
    }

    @Override // vo0.a
    public final PreviewMiniGameWidgetDelegate getPreviewMiniGameWidgetLifecycleObserver(Context r2, ViewGroup r3, PreviewSourceParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        PreviewMiniGameWidgetDelegate r0 = new PreviewMiniGameWidgetDelegate(r2, r3, r4);
        this.a = r0;
        return r0;
    }

    @Override // vo0.a
    public final void handleCommonJSBInvoke(String r3, JsonObject r4, Function1<? super JsonObject, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "param");
        OpenPlatformContext r0 = this.b;
        if (r0 == null) goto L8;
        MiniGameCommonJsbContextService r1 = (MiniGameCommonJsbContextService) r0.getService(MiniGameCommonJsbContextService.class);
        if (r1 == null) goto L9;
        r1.i(r3, r4, r5);
        return;
    L9:
        return;
    }
}
