package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.model.PreviewStatusInfo;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.api.panel.PanelCoverListener;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdNetWorkCallback;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.CardCountResp;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.dv0;
import com.bytedance.android.livesdk.config.nj1;
import com.bytedance.android.livesdk.config.ny;
import com.bytedance.android.livesdk.config.v81;
import com.bytedance.android.livesdk.config.xu0;
import com.bytedance.android.livesdk.config.yu0;
import com.bytedance.android.livesdk.message.model.em;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdk.toolbarservice.utils.ToolbarRuleUtil;
import com.bytedance.android.livesdk.utils.LiveInflateUtil;
import com.bytedance.android.livesdk.view.LivePlaceHolderView;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadCompConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.RoomControllerKeyProvider;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ILiveEnterRoomBridgeExtKt;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IPreviewBridgeHost;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.MergeDataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeBottomToolBar, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class LiveToolbarWidget extends RoomRecyclableWidget implements Observer<KVData>, vlc.l, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, com.bytedance.android.livesdk.chatroom.widget.landscape.w, ot2.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p, ILivePreviewBusinessBridge.Provider, ap2.b, IPreviewBridgeHost {
    private static final float DISABLED_ALPHA = 0.64f;
    private static final String TAG = "LiveToolbarWidget";
    private ILivePreviewBusinessBridge bridge;
    private Disposable guideAnimDp;
    private boolean hasDoWithRoomEnter;
    protected boolean isAnchor;
    private boolean isClearToolbarData;
    private boolean isHideOther;
    private boolean isMultiToolbar;
    private final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.c layoutReloadABUtil;
    protected Map<ToolbarButton, View> mCachedViewMap;
    private r0 mExpand;
    private v81 mExpandConfig;
    private c0.b mGamePromoteBehavior;
    private c0.b mPaidLiveTicketAnchorBehavior;
    private boolean mShouldShowKeyboard;
    protected ViewGroup mToolbarContainer;
    protected List<ToolbarButton> mUnfoldedList;
    protected x3 mUnfoldedToolbarManager;
    protected Map<ExtendedToolbarButton, View> mViewMap;
    private List<View> mVisiableViews;
    private List<Runnable> mWidgetOptTasks;
    private CompositeDisposable mWidgetTasks;
    private ViewGroup maskContainer;
    private Disposable maskContainerGoneDisposable;
    private final com.bytedance.android.live.room.api.panel.a panelListener;
    private CompositeDisposable previewOnReleaseCd;
    private z51.e<Unit> previewOnShowEvent;
    private z51.e<Unit> previewOnUnShowEvent;
    private com.bytedance.android.livesdk.arch.data.g processService;
    private boolean skipClearForReload;
    private com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> tbBottomRightContainer;
    private com.bytedance.android.livesdk.arch.context.a tbContext;
    private com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> tbPanelContainer;
    private final String triggerGiftAnimationEventName;

    public class a extends PanelCoverListener {
        public final /* synthetic */ LiveToolbarWidget c;

        public final String getName() {
            return LiveToolbarWidget.TAG;
        }

        public final View d() {
            return ((Widget) this.c).contentView;
        }

        public a(LiveToolbarWidget r1) {
            this.c = r1;
        }

        public final boolean e(com.bytedance.android.live.room.api.panel.e r2) {
            if (r2.a == PanelName.RightCard) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class b extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveToolbarWidget c;

        public final void run() {
            LiveToolbarWidget.access$000(this.c);
            b(true);
        }

        public b(LiveToolbarWidget r1) {
            this.c = r1;
            super("toolbar_widget_load");
        }
    }

    public class c implements rv2.d {
        public final /* synthetic */ LiveToolbarWidget a;

        public final void a() {
            if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(this.a.isScreenPortrait(), (IRoom) ((Widget) this.a).dataCenter.get("data_room", null)) == false) goto L5;
            ALogger.i(LiveToolbarWidget.TAG, "LiveToolbarWidget setWidgetVisible INVISIBLE");
            UIUtils.setViewVisibility(((Widget) this.a).contentView, 4);
            return;
        L5:
            UIUtils.setViewVisibility(((Widget) this.a).contentView, 0);
        }

        public final void b() {
            UIUtils.setViewVisibility(((Widget) this.a).contentView, 4);
            ALogger.i(LiveToolbarWidget.TAG, "LiveToolbarWidget setWidgetInVisible INVISIBLE");
        }

        public c(LiveToolbarWidget r1) {
            this.a = r1;
        }
    }

    public class d implements Consumer<SubscriberJsEvent> {
        public final /* synthetic */ LiveToolbarWidget a;

        public d(LiveToolbarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) throws Exception {
            if (TextUtils.equals(((SubscriberJsEvent) r3).component1(), "triggerGiftItemAnimation") == false) goto L6;
            this.a.mUnfoldedToolbarManager.b(ToolbarButton.GIFT, new pp1.l());
            return;
        }
    }

    public class e extends g61.a.a {
        public final /* synthetic */ IAnimationScheduler a;

        public final boolean a() {
            IAnimationScheduler r0 = this.a;
            if (r0 == null) goto L5;
            r0.enableShowAnim(true);
        L5:
            return true;
        }

        public final boolean b() {
            IAnimationScheduler r0 = this.a;
            if (r0 == null) goto L7;
            r0.enableShowAnim(false);
            return true;
        L7:
            return true;
        }

        public e(IAnimationScheduler r1) {
            this.a = r1;
        }
    }

    public class f implements ot2.e {
        public int a;
        public final int b;
        public final /* synthetic */ Room c;
        public final /* synthetic */ LiveToolbarWidget d;

        public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r8) {
            if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(this.d.isScreenPortrait(), this.c) == false) goto L13;
            int r0 = this.a + 1;
            this.a = r0;
            if (r0 < this.b) goto L11;
            RoomContext r1 = LiveToolbarWidget.access$100(this.d);
            if (com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this.d).dataCenter) == null) goto L11;
            if (com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this.d).dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L11;
            ALogger.i(LiveToolbarWidget.TAG, "IToolbarInitLoadListener onComponentLoadFinish call ToolbarAndCommentShowCtrlManager notifyToolbarReady");
            ((a32.a) com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this.d).dataCenter).getToolbarAndCommentShowCtrlManager().getValue()).b();
        L11:
            ALogger.i(LiveToolbarWidget.TAG, "IToolbarInitLoadListener onComponentLoadFinish, id: " + r8.a + ", finishedComponentCount: " + this.a + ", maskViewCount: " + this.b);
            return;
        L13:
            if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.c(this.d.isScreenPortrait(), this.c) == true) goto L15;
            return;
        L15:
            if (LiveToolbarWidget.access$200(this.d) != null) goto L17;
            return;
        L17:
            if (LiveToolbarWidget.access$200(this.d).getVisibility() == 8) goto L29;
            this.a++;
            int r2 = LiveToolbarWidget.access$200(this.d).getChildCount();
            if (this.a >= r2) goto L21;
            UIUtils.setViewVisibility(LiveToolbarWidget.access$200(this.d).getChildAt(r2 - this.a), 4);
            ALogger.i(LiveToolbarWidget.TAG, "IToolbarInitLoadListener set children INVISIBLE, index: " + (r2 - this.a));
        L24:
            ALogger.i(LiveToolbarWidget.TAG, "IToolbarInitLoadListener onComponentLoadFinish, id: " + r8.a + ", finishedComponentCount: " + this.a + ", maskViewCount: " + r2);
            return;
        L21:
            ALogger.i(LiveToolbarWidget.TAG, "IToolbarInitLoadListener set maskContainer GONE");
            UIUtils.setViewVisibility(LiveToolbarWidget.access$200(this.d), 8);
            if (LiveToolbarWidget.access$300(this.d) == null) goto L24;
            LiveToolbarWidget.access$300(this.d).dispose();
            goto L24
        }

        public f(LiveToolbarWidget r3, Room r4) {
            this.d = r3;
            this.c = r4;
            this.a = 0;
            ot2.f r5 = jc1.k.f(IToolbarService.class).toolbarUtil();
            this.b = Math.min(r5.a(r3.isScreenPortrait(), ((Widget) r3).dataCenter), r5.b(r3.isScreenPortrait(), ((Widget) r3).dataCenter));
        }
    }

    public class g implements ILiveAdNetWorkCallback<CardCountResp> {
        public final /* synthetic */ LiveToolbarWidget a;

        public final void onError(Throwable r1) {
        }

        public g(LiveToolbarWidget r1) {
            this.a = r1;
        }

        public final void onSuccess(BaseResponse r5) {
            CardCountResp r6 = (CardCountResp) r5;
            if (((Widget) this.a).dataCenter.has("data_live_broadcast_preview_info") == true) goto L5;
            return;
        L5:
            if (((Boolean) ((Widget) this.a).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L15;
            ((PreviewStatusInfo) ((Widget) this.a).dataCenter.get("data_live_broadcast_preview_info", new PreviewStatusInfo())).setTransformCardCount(r6.getTotal());
            p2 r0 = (p2) ((Widget) this.a).dataCenter.get("data_live_mini_app_commerce_status", new p2());
            if (r0.n == false) goto L9;
            return;
        L9:
            if (r6.getTotal() <= 0) goto L11;
            boolean r7 = true;
        L12:
            r0.e = r7;
            ((Widget) this.a).dataCenter.put("data_live_mini_app_commerce_status", r0);
            return;
        L11:
            r7 = false;
            goto L12
        }
    }

    public class h implements com.bytedance.android.live.core.utils.o0.b {
        public final /* synthetic */ em a;
        public final /* synthetic */ LiveToolbarWidget b;

        public final void a() {
            LiveToolbarWidget.access$400(this.b, this.a);
        }

        public final void b() {
            LiveToolbarWidget.access$400(this.b, this.a);
        }

        public final void c() {
            LiveToolbarWidget.access$400(this.b, this.a);
        }

        public h(LiveToolbarWidget r1, em r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ void Aq(LiveToolbarWidget r0, u22.k r1) {
        r0.onTotalWidgetReady(r1);
    }

    public static /* synthetic */ Unit Bq(LiveToolbarWidget r0, com.bytedance.android.live.core.tetris.task.a r1, com.bytedance.android.livesdk.widget.schedule.c r2) {
        return r0.lambda$onLoad$0(r1, r2);
    }

    public static /* synthetic */ void Cq(LiveToolbarWidget r0, IRoom r1) {
        r0.lambda$prepareViewOnLoad$3(r1);
    }

    public static /* synthetic */ void Eq(LiveToolbarWidget r0, c0.d r1) {
        r0.lambda$registerButtonDisableEvent$9(r1);
    }

    public static /* synthetic */ void Fq(LiveToolbarWidget r0, Room r1) {
        r0.lambda$prepareViewOnLoad$4(r1);
    }

    public static /* synthetic */ void Gq(Throwable r0) {
        lambda$registerButtonDisableEvent$10(r0);
    }

    public static /* synthetic */ void Iq(LiveToolbarWidget r0, IRoom r1) {
        r0.lambda$prepareViewOnLoad$2(r1);
    }

    public static /* synthetic */ void Jq(Throwable r0) {
        lambda$initEvents$8(r0);
    }

    public static /* synthetic */ void Kq(LiveToolbarWidget r0, Long r1) {
        r0.lambda$setMaskContainerGoneTimer$6(r1);
    }

    public static /* synthetic */ void Lq(LiveToolbarWidget r0, int r1, LayoutInflater r2) {
        r0.lambda$configToolbarViews$13(r1, r2);
    }

    public static /* synthetic */ void Mq(LiveToolbarWidget r0, IRoom r1) {
        r0.lambda$onLoad$1(r1);
    }

    public static /* synthetic */ void Nq(LiveToolbarWidget r0, IRoom r1) {
        r0.doWithRoomEnter(r1);
    }

    private void autoAddToFirstWhenError(ViewGroup r1, View r2) {
    }

    private boolean fixViewMapSingleton() {
        return true;
    }

    public static /* synthetic */ void wq(LiveToolbarWidget r0) {
        r0.lambda$doWithRoomEnter$5();
    }

    public static /* synthetic */ void xq(Throwable r0) {
        lambda$registerButtonDisableEvent$12(r0);
    }

    public static /* synthetic */ void yq(x3 r0, c0.d r1) {
        lambda$registerButtonDisableEvent$11(r0, r1);
    }

    public static /* synthetic */ void zq(LiveToolbarWidget r0, c0.c r1) {
        r0.lambda$initEvents$7(r1);
    }

    public boolean isDefaultPreviewClientComponentOpen(MergeDataContext r1, IRoom r2) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.w
    public void startHideView() {
        translateButton(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.w
    public void startShowView() {
        translateButton(false);
    }

    private void containerOnDestroy() {
        if (u40.a.c(this.isAnchor) == true) goto L5;
        return;
    L5:
        ViewGroup r0 = this.mToolbarContainer;
        if (r0 == null) goto L9;
        r0.removeAllViews();
        return;
    }

    private String getRoomId() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return "";
    L5:
        Room r1 = (Room) r0.get("data_room", null);
        if (r1 != null) goto L8;
    L12:
        return "";
    L8:
        if (r1.getIdStr() == null) goto L12;
        return r1.getIdStr();
    }

    private void initEvents() {
        ((Widget) this).dataCenter.observe("data_screen_record_is_open", this).observe("data_keyboard_status", this).observe("cmd_hide_other_toolbar", this).observe("data_media_introduction_showing", this).observe("data_broadcast_pause_state", this).observe("cmd_toolbar_visibility_controller", this).observe("cmd_toolbar_fast_start_live", this).observe("cmd_toolbar_reload", this).observe("data_live_mini_app_commerce_status", this).observe("data_is_hiding_landscape_buttons", this).observe("cmd_special_dialog_show", this);
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.TOOLBAR_ITEM_MESSAGE.getIntType(), this);
    L5:
        this.mWidgetTasks.add(this.mUnfoldedToolbarManager.h.subscribe(new l1(this)));
        registerButtonDisableEvent(y3.f(((Widget) this).dataCenter));
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(isScreenPortrait(), (IRoom) ((Widget) this).dataCenter.get("data_room", null)) == false) goto L12;
        RoomContext r1 = getDataContext();
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this).dataCenter) == null) goto L12;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this).dataCenter).getToolbarAndCommentShowCtrlManager().getValue() == null) goto L12;
        ALogger.i(TAG, "subscribe ToolbarAndCommentShowCtrlManager onTotalWidgetReady");
        Disposable r2 = ((a32.a) com.bytedance.android.livesdk.interactivity.api.i.a(r1, ((Widget) this).dataCenter).getToolbarAndCommentShowCtrlManager().getValue()).a().timeout(((Long) r52.i4.a.getValue()).longValue(), TimeUnit.MILLISECONDS).doOnError(new m1()).onErrorReturnItem(new u22.k()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n1(this));
        this.mWidgetTasks.add(r2);
    L12:
        int r3 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r4 = com.bytedance.android.live.room.api.panel.d.b(((Widget) this).dataCenter, 0);
        if (r4 != null) goto L15;
        return;
    L15:
        if (isScreenPortrait() == false) goto L19;
        r4.registerPanelListener(this.panelListener);
        return;
    }

    private void initMaskContainerIfNeed() {
        if (this.maskContainer != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.c(isScreenPortrait(), (IRoom) ((Widget) this).dataCenter.get("data_room", null)) == false) goto L8;
        ALogger.i(TAG, "set maskContainer VISIBLE in initMaskContainerIfNeed");
        UIUtils.setViewVisibility(this.maskContainer, 0);
        this.maskContainer.removeAllViews();
        ot2.f r0 = jc1.k.f(IToolbarService.class).toolbarUtil();
        int r2 = r0.a(isScreenPortrait(), ((Widget) this).dataCenter);
        int r1 = r0.b(isScreenPortrait(), ((Widget) this).dataCenter);
        ALogger.i(TAG, "getLoadIconCount = " + r2 + ", maxSlot = " + r1);
        initMaskContainer(this.maskContainer, Math.min(r2, r1));
        return;
    L8:
        ALogger.i(TAG, "set maskContainer GONE in initMaskContainerIfNeed");
        UIUtils.setViewVisibility(this.maskContainer, 8);
    }

    private void initTbArch() {
        if (LiveTbArchUtils.INSTANCE.enableOpt(((Widget) this).dataCenter) == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.arch.context.a r0 = jc1.k.f(IToolbarService.class).getTbContext(getRoomContext(), ((Widget) this).dataCenter);
        this.tbContext = r0;
        if (r0 == null) goto L8;
        r0.initPreviewBizBridgeProvider(com.bytedance.android.livesdk.arch.container.d.a.c, new s1(this));
    L8:
        com.bytedance.android.livesdk.arch.data.g r1 = jc1.k.f(IToolbarService.class).createDataProcessService(getRoomContext(), ((Widget) this).dataCenter);
        this.processService = r1;
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.arch.context.a r2 = this.tbContext;
        if (r2 == null) goto L14;
        r2.initDataPsService(r1);
    L14:
        if (this.tbBottomRightContainer != null) goto L19;
        if (this.tbContext == null) goto L19;
        this.tbBottomRightContainer = jc1.k.f(IToolbarService.class).createTbContainer(com.bytedance.android.livesdk.arch.container.d.a.c, this.tbContext, this, this.mToolbarContainer);
    L19:
        if (this.tbPanelContainer == null) goto L21;
    L23:
        com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> r3 = this.tbBottomRightContainer;
        if (r3 == null) goto L26;
        r3.c(getRoomContext(), ((Widget) this).dataCenter);
    L26:
        com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> r4 = this.tbPanelContainer;
        if (r4 == null) goto L29;
        r4.c(getRoomContext(), ((Widget) this).dataCenter);
    L29:
        com.bytedance.android.livesdk.arch.data.g r5 = this.processService;
        if (r5 == null) goto L33;
        r5.A(getContext(), getRoomContext(), ((Widget) this).dataCenter);
        return;
    L33:
        return;
    L21:
        if (this.tbContext == null) goto L23;
        this.tbPanelContainer = jc1.k.f(IToolbarService.class).createTbContainer(com.bytedance.android.livesdk.arch.container.d.c.c, this.tbContext, this, this.mToolbarContainer);
        goto L23
    }

    private void initToolbarStatus() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.has("data_live_broadcast_preview_info") == true) goto L8;
        return;
    L8:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L48;
        PreviewStatusInfo r1 = (PreviewStatusInfo) ((Widget) this).dataCenter.get("data_live_broadcast_preview_info", new PreviewStatusInfo());
        p2 r2 = (p2) ((Widget) this).dataCenter.get("data_live_mini_app_commerce_status", new p2());
        Room r3 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r1 == null) goto L45;
        r2.a = r1.getHasMiniAppPermission();
        boolean r5 = true;
        if (r1.getMiniAppCount() <= 0) goto L14;
        boolean r4 = true;
    L15:
        r2.g = r4;
        if (r3 != null) goto L18;
    L22:
        boolean r6 = false;
    L23:
        r2.b = r6;
        if (r1.getMixMiniAppCount() <= 0) goto L26;
        boolean r7 = true;
    L27:
        r2.j = r7;
        if (r1.getCommodityCount() <= 0) goto L30;
        boolean r8 = true;
    L31:
        r2.k = r8;
        r2.i = false;
        initPaidLiveTicketStatus(r2, r3);
        r2.d = r1.getHasWelfarePermission();
        RoomContext r9 = getDataContext();
        if (r1.getWelfareProjectId() <= 0) goto L34;
    L39:
        boolean r10 = true;
    L40:
        r2.m = r10;
        r2.f = r1.getGroupPurchasePermission();
        if (r1.getGroupPurchaseCount() > 0) goto L44;
        r5 = false;
    L44:
        r2.o = r5;
        goto L45
    L34:
        if (r9.getWelfareProjectInfo().getValue() != null) goto L36;
    L38:
        r10 = false;
        goto L40
    L36:
        if (((WelfareProjectInfo) r9.getWelfareProjectInfo().getValue()).isValid() == false) goto L38;
    L30:
        r8 = false;
        goto L31
    L26:
        r7 = false;
        goto L27
    L18:
        if (r3.getBaseOwner() == null) goto L22;
        if (r3.getBaseOwner().getEnableShowCommerceSale() == false) goto L22;
        r6 = true;
        goto L23
    L14:
        r4 = false;
    L45:
        ((Widget) this).dataCenter.put("data_live_mini_app_commerce_status", r2);
        return;
    }

    private boolean isAnchorUsing() {
        if (this.mUnfoldedToolbarManager != null) goto L5;
        return false;
    L5:
        if (fixViewMapSingleton() == true) goto L7;
        return false;
    L7:
        if (this.isAnchor == false) goto L9;
        return false;
    L9:
        return this.mUnfoldedToolbarManager.n;
    }

    private /* synthetic */ void lambda$doWithRoomEnter$5() {
        UIUtils.setViewVisibility(this.mToolbarContainer, 0);
    }

    private void loadIndependentBehaviorsOnEnterRoom() {
        if (((Widget) this).dataCenter == null) goto L13;
        ALogger.i(TAG, "loadIndependentBehaviorsOnEnterRoom.");
        long r2 = SystemClock.uptimeMillis();
        this.mWidgetOptTasks = com.bytedance.android.livesdk.service.l.d().f().d(((Widget) this).dataCenter, ((Widget) this).context);
        long r4 = SystemClock.uptimeMillis();
        com.bytedance.android.livesdk.sharedpref.e<Long> r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.b.a;
        long r5 = r4 - r2;
        boolean r1 = this.isAnchor;
        LiveMonitor.a r3 = new LiveMonitor.a("livesdk_toolbar_load_behavior_time", LiveTracingMonitor.EventModule.common);
        r3.j(r5);
        r3.l(0);
        String r6 = "1";
        if (r1 == false) goto L7;
        String r7 = "1";
    L8:
        r3.e("isAnchor", r7);
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L12;
        r6 = "0";
    L12:
        r3.e("optMode", r6);
        r3.a().report();
        DataCenter r8 = ((Widget) this).dataCenter;
        AudienceVideoResolutionManager.l(r8, y3.f(r8));
        goto L13
    L7:
        r7 = "0";
    L13:
        Widget.WidgetCallback r9 = ((Widget) this).widgetCallback;
        if (r9 != null) goto L16;
    L18:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.MORE, new pp1.j(false));
        return;
    L16:
        if (r9.getWidgetManager() == null) goto L18;
        enableSubWidgetManager();
        goto L18
    }

    private void prefetchCardCount() {
        if (tb1.c.a == true) goto L5;
        return;
    L5:
        boolean r0 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
        this.isAnchor = r0;
        if (r0 == true) goto L8;
        return;
    L8:
        Room r1 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        String r2 = jc1.k.f(IUserService.class).user().b().getCastSecUid();
        CardCountRequest r3 = new CardCountRequest();
        r3.setSecUid(r2);
        if (r1 == null) goto L11;
        r3.setRoomId(r1.getIdStr());
    L11:
        ILiveService r4 = TTLiveService.getLiveService();
        if (r4 != null) goto L14;
        return;
    L14:
        ILiveAdService r5 = (ILiveAdService) r4.liveAdService(ILiveAdService.class);
        if (r5 != null) goto L17;
        return;
    L17:
        r5.getCardCount(r3, new g(this));
    }

    private void prepareMutexHelper() {
        y3.m(((Widget) this).dataCenter).m(new ToolbarMutexHelper(((Widget) this).dataCenter));
        y3.f(((Widget) this).dataCenter).m(null);
    }

    private boolean shouldShowCouponPopupWindow() {
        String r0 = (String) ((Widget) this).dataCenter.get("data_enter_ecom_live_params", "");
        if (TextUtils.isEmpty(r0) == true) goto L7;
        return "live_preview_exchange_coupon".equals(UriProtector.getQueryParameter(UriProtector.parse(new JSONObject(r0).optString("jump_schema")), "scene"));
    L7:
        return false;
    L12:
        return false;
    }

    public void configToolbarViews() {
        jc1.k.f(ILiveUxTracer.class).recordTimeStamp("toolbar_config_views", "start");
        final LayoutInflater r0 = LivePlaceHolderView.b(LayoutInflater.from(((Widget) this).context));
        final int r1 = 0;
    L4:
        if (r1 >= this.mUnfoldedList.size()) goto L6;
        AnchorMainPostOptUtils.b("configview", new t1(this, r1, r0));
        r1 = r1 + 1;
        goto L4
    L6:
        jc1.k.f(ILiveUxTracer.class).recordTimeStamp("toolbar_config_views", "end");
    }

    public LayoutInflater getLayoutInflate() {
        return LivePlaceHolderView.b(LayoutInflater.from(((Widget) this).context));
    }

    public String getPreviewClientComponentKey() {
        int r0 = ap2.a.a;
        return "preview_interact_toolbar";
    }

    public Observable<Unit> getVhSelectObservable() {
        return this.previewOnShowEvent.a();
    }

    public Observable<Unit> getVhUnSelectObservable() {
        return ((z51.d) this.previewOnUnShowEvent).b;
    }

    public void onUnload() {
        Disposable r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        r1.removeObserver(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b.a);
    L5:
        Disposable r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.a = null;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.b = null;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.e.c = null;
        ALogger.i("Toolbar_Preload", "onUnload :::  isMultiToolbar" + this.isMultiToolbar + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        vlc.d r3 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r3 == null) goto L11;
        r3.addMessageListener(MessageType.TOOLBAR_ITEM_MESSAGE.getIntType(), this);
    L11:
        List<Runnable> r4 = this.mWidgetOptTasks;
        if (r4 != null) goto L14;
    L19:
        this.mWidgetTasks.clear();
        this.previewOnReleaseCd.clear();
        ((Widget) this).dataCenter.removeObserver(this);
        removeButtonsFromContainer();
        this.mUnfoldedList.clear();
        this.hasDoWithRoomEnter = false;
        if (this.isClearToolbarData == false) goto L22;
    L26:
        ((HashMap) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc.a.a).clear();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.b = true;
        containerOnDestroy();
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L31;
        BottomToolbarViewModel.a r5 = BottomToolbarViewModel.Companion;
        DataCenter r6 = ((Widget) this).dataCenter;
        r5.getClass();
        if (BottomToolbarViewModel.a.a(r6) == null) goto L31;
        BottomToolbarViewModel.a.a(((Widget) this).dataCenter).onRoomUiDestory(this.skipClearForReload);
    L31:
        com.bytedance.android.livesdk.arch.data.g r7 = this.processService;
        if (r7 == null) goto L34;
        getRoomContext();
        r7.C(((Widget) this).dataCenter);
    L34:
        com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> r8 = this.tbBottomRightContainer;
        if (r8 == null) goto L37;
        getRoomContext();
        r8.onUnload();
    L37:
        com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> r9 = this.tbPanelContainer;
        if (r9 == null) goto L40;
        getRoomContext();
        r9.onUnload();
    L40:
        com.bytedance.android.livesdk.arch.context.a r10 = this.tbContext;
        if (r10 == null) goto L43;
        r10.onRoomUiDestroy(this.skipClearForReload);
    L43:
        this.skipClearForReload = false;
        ALogger.i(TAG, "unload." + getRoomId());
        Disposable r11 = this.guideAnimDp;
        if (r11 != null) goto L46;
    L48:
        int r12 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r13 = com.bytedance.android.live.room.api.panel.d.b(((Widget) this).dataCenter, 0);
        if (r13 == null) goto L52;
        r13.unregisterPanelListener(this.panelListener);
    L52:
        if (this.isClearToolbarData == false) goto L54;
        return;
    L54:
        if (isAnchorUsing() == false) goto L56;
        return;
    L56:
        if (this.isMultiToolbar == false) goto L62;
        y3.k(((Widget) this).dataCenter);
        return;
    L62:
        return;
    L46:
        if (r11.isDisposed() == true) goto L48;
        this.guideAnimDp.dispose();
        goto L48
    L22:
        if (this.skipClearForReload == true) goto L26;
        if (isAnchorUsing() == true) goto L26;
        y3.g(((Widget) this).dataCenter);
        goto L26
    L14:
        if (r4.isEmpty() == true) goto L19;
        Iterator<Runnable> r14 = this.mWidgetOptTasks.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(r14.next());
        goto L17
    }

    public LiveToolbarWidget() {
        this.mUnfoldedList = new ArrayList();
        this.mCachedViewMap = new HashMap();
        this.isAnchor = false;
        this.mExpandConfig = xu0.a.getValue();
        this.mVisiableViews = new ArrayList();
        this.isHideOther = false;
        this.mWidgetTasks = new CompositeDisposable();
        this.triggerGiftAnimationEventName = "triggerGiftItemAnimation";
        this.hasDoWithRoomEnter = false;
        this.isMultiToolbar = false;
        this.bridge = null;
        this.previewOnReleaseCd = new CompositeDisposable();
        int r1 = z51.e.c;
        this.previewOnShowEvent = new z51.e(null);
        this.previewOnUnShowEvent = new z51.e(null);
        this.panelListener = new a(this);
        this.tbBottomRightContainer = null;
        this.tbPanelContainer = null;
        this.layoutReloadABUtil = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.c();
    }

    private void prepareViewOnLoad() {
        if (com.bytedance.android.livesdk.config.b0.a() == true) goto L5;
    L7:
        jc1.k.f(ILiveUxTracer.class).recordTimeStamp("widget_load_toolbar", "start");
        prefetchCardCount();
        initToolbarStatus();
        prepareMutexHelper();
        y3.f(((Widget) this).dataCenter).E(((Widget) this).dataCenter);
        initUnfoldedList(this.mUnfoldedList);
        if (u40.a.c(this.isAnchor) == true) goto L10;
        configToolbarViews();
    L10:
        ALogger.i(TAG, "load." + getRoomId());
        if (shouldShowCouponPopupWindow() == false) goto L14;
        ((Widget) this).dataCenter.put("coupon_pannel_already_show", Boolean.TRUE);
    L14:
        if (ToolbarLoadTimeStatsVM.isOpen() == false) goto L21;
        RoomContext r0 = getDataContext();
        ap1.a r2 = ToolbarLoadTimeStatsVM.getInstance(r0);
        if (r2 == null) goto L21;
        r2.recordTime(ToolbarLoadTimeStatsVM.TOOLBAR_ADD_VIEW_END);
        if (r2.isEnterFinished(jc1.k.f(IRoomContextService.class).getRoomDataContext(r0)) == false) goto L21;
        r2.recordStatus(ToolbarLoadTimeStatsVM.STATUS_IS_ENTER_ROOM_FINISH_WHEN_LOAD);
    L21:
        if (ny.a.getValue().booleanValue() == true) goto L32;
        int r1 = com.bytedance.android.live.openplatform.api.utils.g.a;
        boolean r3 = true;
        if (de0.a.getValue().m() == 1) goto L26;
        r3 = false;
    L26:
        if (r3 == true) goto L32;
        if (ToolbarLoadTimeStatsVM.needUseNewSyncRoom(this.isAnchor) == false) goto L31;
        ToolbarLoadTimeStatsVM.doWithRoomEnter(autoDispose(), getDataContext(), new j1(this));
    L33:
        jc1.k.f(ILiveUxTracer.class).recordTimeStamp("widget_load_toolbar", "end");
        ((ObservableSubscribeProxy) jc1.k.f(IBrowserService.class).registerJsEventSubscriber("triggerGiftItemAnimation").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new d(this));
        if (RoomContext.getShared(((Widget) this).dataCenter) == null) goto L37;
        RoomContext.getShared(((Widget) this).dataCenter).getToolbarContainerImpl().d(this);
        return;
    L37:
        return;
    L31:
        runWithRoomEntered(new k1(this));
    L32:
        ToolbarLoadTimeStatsVM.doWithRoomEnter(autoDispose(), getDataContext(), new y1(this));
        runWithRoomEntered(new z1(this));
        goto L33
    L5:
        if (this.isAnchor == false) goto L7;
        UIUtils.setViewVisibility(this.mToolbarContainer, 4);
        goto L7
    }

    public int getLayoutId() {
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.b() == false) goto L6;
        return 2131567765;
    L6:
        return 2131567762;
    }

    public void onClear() {
        super.onClear();
        this.mWidgetTasks.clear();
        ALogger.i(TAG, "onClear.");
        if (this.isClearToolbarData == false) goto L5;
        return;
    L5:
        if (isAnchorUsing() == false) goto L7;
        return;
    L7:
        if (((Boolean) dv0.a.getValue()).booleanValue() == false) goto L9;
    L10:
        y3.j();
        return;
    L9:
        if (this.isMultiToolbar == false) goto L10;
    }

    public void onMergeHolderSelect() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onMergeHolderSelect();
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L6;
        this.previewOnShowEvent.b(Unit.INSTANCE);
        this.previewOnUnShowEvent.b(null);
        return;
    }

    public void onMergeHolderUnSelect() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onMergeHolderUnSelect();
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L6;
        this.previewOnShowEvent.b(null);
        this.previewOnUnShowEvent.b(Unit.INSTANCE);
        return;
    }

    public ILivePreviewBusinessBridge previewBridge() {
        return provide();
    }

    public ILivePreviewBusinessBridge provide() {
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L8;
        if (this.bridge != null) goto L8;
        this.bridge = ILiveEnterRoomBridgeExtKt.createPreviewDefaultBridge(this, ILiveEnterRoomScene.PreviewToolbar.INSTANCE);
    L8:
        return this.bridge;
    }

    public void removeButtonsFromContainer() {
        if (isAnchorUsing() == false) goto L5;
        return;
    L5:
        Iterator<ToolbarButton> r0 = this.mUnfoldedList.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        ToolbarButton r1 = r0.next();
        ExtendedToolbarButton.b r2 = ExtendedToolbarButton.e(r1);
        View r3 = this.mViewMap.get(r2);
        if (r3 == null) goto L7;
        this.mToolbarContainer.removeView(r3);
        this.mUnfoldedToolbarManager.C(r2, r3);
        reportGameCpToolbarError(r1, r3);
        goto L7
    }

    public int supportClearScene() {
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (this.isAnchor == true) goto L11;
        return 0;
    L11:
        if (xu0.a.getValue().a() == false) goto L14;
        return 53;
    L14:
        return 52;
    L5:
        r0 = false;
        goto L6
    }

    public ViewGroup getContainerView() {
        return this.mToolbarContainer;
    }

    public CompositeDisposable getOnReleaseCd() {
        return this.previewOnReleaseCd;
    }

    public static /* synthetic */ void access$000(LiveToolbarWidget r0) {
        r0.prepareViewOnLoad();
    }

    public static /* synthetic */ RoomContext access$100(LiveToolbarWidget r0) {
        return r0.getDataContext();
    }

    public static /* synthetic */ ViewGroup access$200(LiveToolbarWidget r0) {
        return r0.maskContainer;
    }

    public static /* synthetic */ Disposable access$300(LiveToolbarWidget r0) {
        return r0.maskContainerGoneDisposable;
    }

    private void doWithRoomEnter(IRoom r6) {
        Room r7 = (Room) jm2.a.e(r6);
        if (ny.a.getValue().booleanValue() == false) goto L7;
        if (r7.isGameCPRoom() == false) goto L7;
    L9:
        if (this.hasDoWithRoomEnter == false) goto L11;
        return;
    L11:
        this.hasDoWithRoomEnter = true;
    L12:
        loadIndependentBehaviorsOnEnterRoom();
        if (yu0.a.getValue().booleanValue() == false) goto L19;
        if (r7 == null) goto L18;
        boolean r0 = r7.isHasCommerceGoods();
        ALogger.i(TAG, "hasCommerceGoods=" + r0);
        if (r0 == false) goto L20;
        ((Widget) this).dataCenter.put("cmd_specific_widget_loaded", "1");
    L20:
        BottomToolbarViewModel.a r1 = BottomToolbarViewModel.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        r1.getClass();
        BottomToolbarViewModel r3 = BottomToolbarViewModel.a.a(r2);
        LiveTbArchUtils r4 = LiveTbArchUtils.INSTANCE;
        if (r4.enableOpt(((Widget) this).dataCenter) == true) goto L28;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L28;
        if (r3 == null) goto L28;
        if (r7 == null) goto L28;
        r3.initContainer(ot2.a.a.a, this);
        r3.initContainer(ot2.a.b.a, null);
        r3.onRoomUiLoadFinished(r7, getToolbarInitLoadListener(r7));
        setMaskContainerGoneTimer(r7);
    L28:
        if (r4.enableOpt(((Widget) this).dataCenter) == true) goto L30;
    L35:
        IAnimationScheduler.Companion r8 = IAnimationScheduler.M0;
        DataCenter r5 = ((Widget) this).dataCenter;
        r8.getClass();
        IAnimationScheduler r9 = IAnimationScheduler.Companion.a(r5);
        initAnimSuppress(r9);
        if (IAnimationScheduler.Companion.c() == false) goto L40;
        if (r9 == null) goto L40;
        r9.onToolbarLoaded();
    L40:
        if (com.bytedance.android.livesdk.config.b0.a() == true) goto L42;
        return;
    L42:
        if (this.isAnchor == false) goto L46;
        AnchorMainPostOptUtils.b("after_toolbar_load", new q1(this));
        return;
    L46:
        return;
    L30:
        if (this.tbContext == null) goto L33;
        new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.k().e(((Widget) this).dataCenter, getContext(), this.tbContext.configRegister());
    L33:
        if (this.processService == null) goto L35;
        ALogger.i("LiveTbMonitor", "roomEnter::::" + r7.getIdStr());
        this.processService.z(r7);
        goto L35
    L18:
        ((Widget) this).dataCenter.put("cmd_specific_widget_loaded", "1");
        goto L20
    L19:
        ((Widget) this).dataCenter.put("cmd_specific_widget_loaded", "1");
    L7:
        if (com.bytedance.android.live.openplatform.api.utils.g.a(r7) == false) goto L12;
        goto L12
    }

    private void downLoadIcon(em r4) {
        new com.bytedance.android.live.core.utils.o0().a(sb2.a.d(r4.G().g()), new h(this, r4));
    }

    private ot2.e getToolbarInitLoadListener(Room r3) {
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.c(isScreenPortrait(), r3) == false) goto L5;
    L9:
        ALogger.i(TAG, "getToolbarInitLoadListener");
        return new f(this, r3);
    L5:
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(isScreenPortrait(), r3) == true) goto L9;
        return null;
    }

    private void initAnimSuppress(IAnimationScheduler r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ILiveExpOptService r0 = jc1.k.f(ILiveExpOptService.class);
        if (r0 != null) goto L7;
    L9:
        this.guideAnimDp = jc1.k.f(ILiveExpOptService.class).registerExpBizListener(l61.d.a.h1.e, new e(r4));
        return;
    L7:
        if (r0.getSceneState(((Widget) this).dataCenter, l61.d.a.h1.e).a() == false) goto L9;
        r4.enableShowAnim(false);
        goto L9
    }

    private void lambda$initEvents$7(c0.c r3) throws Exception {
        if (r3.c == false) goto L10;
        View r0 = this.mCachedViewMap.get(r3.a);
        if (r0 == null) goto L11;
        ExtendedToolbarButton r4 = r3.a;
        if ((r4 instanceof ExtendedToolbarButton.b) == false) goto L12;
        applyDynamicButtons(((ExtendedToolbarButton.b) r4).i, r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    private static /* synthetic */ void lambda$initEvents$8(Throwable r1) throws Exception {
        ALogger.e(TAG, "ToolbarAndCommentShowCtrlManager onTotalWidgetReady timeout");
    }

    private /* synthetic */ void lambda$onLoad$1(IRoom r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r5.getIdStr()) == false) goto L6;
        return;
    L6:
        if (LiveTbArchUtils.INSTANCE.enableOpt(((Widget) this).dataCenter) == true) goto L8;
        return;
    L8:
        if (this.tbContext == null) goto L11;
        new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.k().e(((Widget) this).dataCenter, getContext(), this.tbContext.configRegister());
    L11:
        if (this.processService == null) goto L17;
        ALogger.i("LiveTbMonitor", "preload::::" + r5.getIdStr());
        this.processService.B(r5);
        return;
    }

    private /* synthetic */ void lambda$prepareViewOnLoad$2(IRoom r1) {
        doWithRoomEnter(r1);
    }

    private /* synthetic */ void lambda$prepareViewOnLoad$3(IRoom r1) {
        doWithRoomEnter(r1);
    }

    private /* synthetic */ void lambda$prepareViewOnLoad$4(Room r1) {
        doWithRoomEnter(r1);
    }

    private static /* synthetic */ void lambda$registerButtonDisableEvent$10(Throwable r0) throws Exception {
        Logger.e(r0.getMessage());
    }

    private static /* synthetic */ void lambda$registerButtonDisableEvent$12(Throwable r0) throws Exception {
        Logger.e(r0.getMessage());
    }

    private /* synthetic */ void lambda$registerButtonDisableEvent$9(c0.d r3) throws Exception {
        View r0 = this.mViewMap.get(r3.a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3.b == false) goto L7;
        r0.setAlpha(DISABLED_ALPHA);
        return;
    L7:
        r0.setAlpha(1.0f);
    }

    private /* synthetic */ void lambda$setMaskContainerGoneTimer$6(Long r2) throws Exception {
        ALogger.e(TAG, "setMaskContainerGoneTimer time out");
        UIUtils.setViewVisibility(this.maskContainer, 8);
    }

    private void onToolbarItemMessage(em r5) {
        RoomContext r0 = getDataContext();
        String r1 = jc1.k.f(IUserService.class).user().n();
        if (r0 == null) goto L5;
        long r2 = ((Room) r0.getRoom().getValue()).getId();
    L7:
        if (r5.E(r1, r2) == true) goto L9;
        return;
    L9:
        if (r5.H() != 4) goto L11;
    L13:
        showBubbleOnToolbarIcon(r5);
        return;
    L11:
        if (ListUtils.isEmpty(sb2.a.d(r5.G().g())) == true) goto L13;
        downLoadIcon(r5);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    private void onTotalWidgetReady(u22.k r3) {
        ALogger.i(TAG, "onTotalWidgetReady, set contentView VISIBLE, " + r3.toString());
        ((Widget) this).contentView.setVisibility(0);
    }

    private void registerButtonDisableEvent(final x3 r4) {
        Disposable r0 = this.mUnfoldedToolbarManager.i.subscribe(new u1(this), new v1());
        Disposable r5 = r4.i.subscribe(new w1(r4), new x1());
        this.mWidgetTasks.add(r0);
        this.mWidgetTasks.add(r5);
    }

    private void setMaskContainerGoneTimer(Room r3) {
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.c(isScreenPortrait(), r3) == false) goto L10;
        ViewGroup r4 = this.maskContainer;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.getVisibility() == 8) goto L12;
        Disposable r5 = Observable.timer(((Long) r52.h4.a.getValue()).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i1(this));
        this.maskContainerGoneDisposable = r5;
        this.mWidgetTasks.add(r5);
        return;
    L12:
        return;
    }

    private void showBubbleOnToolbarIcon(em r18) {
        em.a r1 = r18.G();
        String r3 = r1.c();
        Text r2 = r1.g();
        Text r4 = em.a.a;
        if (r2 == em.a.a) goto L5;
        Text r5 = r1.g();
    L6:
        pp1.c r15 = new pp1.c(r3, r5, r1.h(), r1.d(), r1.b(), r1.a(), r18.getActionType(), r18.getMessageType(), r18.getExtra(), 1, r1.i(), r1.e(), r1.f());
        switch(r18.H()) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L26;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L9;
            default: goto L26;
        };
    L9:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L19;
        r6.put("cmd_toolbar_left_avatar_bubble", r15);
        return;
    L19:
        return;
    L12:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.PK, r15);
        return;
    L13:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.BROADCAST_EFFECT, r15);
        return;
    L14:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.MORE, r15);
        return;
    L15:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.INTERACT_GAME, r15);
        return;
    L16:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.FAST_GIFT, r15);
        return;
    L17:
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.GIFT, r15);
        return;
    L26:
        return;
    L5:
        r5 = null;
        goto L6
    }

    private void translateButton(boolean r7) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        Room r1 = (Room) r0.get("data_room", null);
        int r2 = com.bytedance.android.livesdk.config.setting.f.a;
        if (com.bytedance.android.livesdk.config.setting.f.a(((Widget) this).dataCenter) == false) goto L13;
        View r3 = ((Widget) this).contentView;
        if (r7 == false) goto L10;
        int r8 = com.bytedance.android.live.core.utils.s1.f(100.0f);
    L11:
        translateY(r3, r8);
        return;
    L10:
        r8 = com.bytedance.android.live.core.utils.s1.f(0.0f);
        goto L11
    L13:
        translateExceptVisibleButton(r7, r1);
        if (r1.isMergeVSRoom() == false) goto L16;
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.mToolbarContainer.getChildCount()) goto L30;
        View r5 = this.mToolbarContainer.getChildAt(r4);
        if (r5.getTag() != ToolbarButton.VS_SELECT_EPISODE) goto L24;
    L25:
        if (r7 == false) goto L27;
        int r6 = com.bytedance.android.live.core.utils.s1.f(100.0f);
    L28:
        translateY(r5, r6);
    L29:
        r4 = r4 + 1;
        goto L20
    L27:
        r6 = com.bytedance.android.live.core.utils.s1.f(0.0f);
        goto L28
    L24:
        if (r5.getTag() != ToolbarButton.MULTI_CAMERA_LINKED_ROOM) goto L29;
    L30:
        return;
    L16:
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L18;
    }

    public boolean canControlByPlayer(PlayerViewControl.KEY r3) {
        return !((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
    }

    public boolean filterUnFoldToolbarButton(ToolbarButton r2) {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.extraRenderController().isUgcRoom() == true) goto L7;
        return false;
    L7:
        if (r2 != ToolbarButton.SWITCH_VIDEO_QUALITY) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p
    public int getViewIndexById(int r5) {
        ViewGroup r0 = getContainerView();
        if (r0 == null) goto L15;
        int r1 = 0;
    L6:
        if (r1 >= r0.getChildCount()) goto L22;
        View r2 = r0.getChildAt(r1);
        if (r2 == null) goto L14;
        Object r3 = r2.getTag(2131389840);
        if ((r3 instanceof Integer) == false) goto L14;
        if (((Integer) r3).intValue() != r5) goto L14;
        return r1;
    L14:
        r1 = r1 + 1;
        goto L6
    L22:
        return -1;
    L15:
        return -1;
    }

    public void hideOtherView(boolean r2) {
        hideVisibleView(r2, this.mUnfoldedList);
    }

    public void initUnfoldedList(List<ToolbarButton> r3) {
        com.bytedance.android.livesdk.service.l.d().f().b(((Widget) this).dataCenter, r3);
        Iterator<ToolbarButton> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (filterUnFoldToolbarButton(r4.next()) == false) goto L4;
        r4.remove();
        goto L4
    }

    public void onChanged(KVData r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.getKey() != null) goto L6;
        return;
    L6:
        if (r9.getData() == null) goto L134;
        String r0 = r9.getKey();
        r0.getClass();
        int r2 = 4;
        int r3 = 2;
        byte r7 = -1;
        switch(r0.hashCode()) {
            case -1755796428: goto L52;
            case -1548871708: goto L48;
            case -968289056: goto L44;
            case -91258461: goto L40;
            case 309908432: goto L36;
            case 436352130: goto L32;
            case 912007817: goto L28;
            case 919040494: goto L24;
            case 1060055221: goto L20;
            case 1883240861: goto L16;
            case 1939188655: goto L12;
            default: goto L55;
        };
    L55:
        switch(r7) {
            case 0: goto L110;
            case 1: goto L107;
            case 2: goto L93;
            case 3: goto L90;
            case 4: goto L85;
            case 5: goto L84;
            case 6: goto L81;
            case 7: goto L74;
            case 8: goto L70;
            case 9: goto L64;
            case 10: goto L58;
            default: goto L135;
        };
    L64:
        int r1 = com.bytedance.android.livesdk.config.setting.z.a;
        if (nj1.a.getValue().e() == false) goto L116;
        int r4 = com.bytedance.android.livesdk.config.setting.f.a;
        if (com.bytedance.android.livesdk.config.setting.f.a(((Widget) this).dataCenter) == true) goto L117;
        translateButton(((Boolean) r9.getData()).booleanValue());
        return;
    L117:
        return;
    L116:
        return;
    L84:
        this.skipClearForReload = ((Boolean) r9.getData()).booleanValue();
        return;
    L85:
        boolean r10 = ((Boolean) r9.getData()).booleanValue();
        View r5 = ((Widget) this).contentView;
        if (r10 == true) goto L89;
        r2 = 0;
    L89:
        r5.setVisibility(r2);
        return;
    L90:
        boolean r11 = ((Boolean) r9.getData()).booleanValue();
        this.isClearToolbarData = r11;
        if (r11 == false) goto L126;
        ALogger.i(TAG, "onChange clear.");
        y3.k(((Widget) this).dataCenter);
        return;
    L126:
        return;
    L93:
        Pair r12 = (Pair) r9.getData();
        if (r12 == null) goto L128;
        ExtendedToolbarButton r6 = (ExtendedToolbarButton) r12.getFirst();
        if (r6 != ToolbarButton.GAME_GUESS.extended()) goto L98;
        return;
    L98:
        if (r6 == ToolbarButton.OPEN_PLATFORM_LYNX_GAME.extended()) goto L112;
        int r13 = ((Integer) r12.getSecond()).intValue();
        View r8 = this.mViewMap.get(r6);
        if (r8 == null) goto L129;
        if (r13 != 0) goto L104;
        UIUtils.setViewVisibility(r8, 8);
        this.mVisiableViews.add(r8);
        return;
    L104:
        this.mVisiableViews.remove(r8);
        return;
    L129:
        return;
    L112:
        return;
    L128:
        return;
    L110:
        boolean r14 = ((Boolean) r9.getData(Boolean.FALSE)).booleanValue();
        hideOtherView(r14);
        HashMap r15 = o70.c.a;
        o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode())).b(new zg1.q0(r14));
        return;
    L135:
        return;
    L58:
        if (((Boolean) r9.getData()).booleanValue() == false) goto L60;
    L63:
        ((Widget) this).contentView.setVisibility(r2);
        return;
    L60:
        if (this.mShouldShowKeyboard == true) goto L63;
        r2 = 0;
        goto L63
    L70:
        if (((Boolean) r9.getData()).booleanValue() == false) goto L72;
        ((Widget) this).contentView.setVisibility(4);
        return;
    L72:
        ((Widget) this).contentView.setVisibility(0);
        this.mShouldShowKeyboard = false;
        return;
    L74:
        if (this.isAnchor == false) goto L121;
        p2 r16 = (p2) r9.getData();
        JsonObject r17 = new JsonObject();
        if (r16.c() != 1) goto L78;
        r3 = 1;
    L78:
        r17.addProperty("anchor_has_promotion_games", Integer.valueOf(r3));
        jc1.k.f(IBrowserService.class).registerOrNotifyState(com.bytedance.android.live.browser.jsbridge.i.e.e.a.c, r17);
        com.bytedance.android.livesdk.config.setting.s.b();
        return;
    L121:
        return;
    L81:
        if (((Boolean) r9.getData()).booleanValue() == false) goto L83;
        ((Widget) this).contentView.setAlpha(0.5f);
        return;
    L83:
        ((Widget) this).contentView.setAlpha(1.0f);
        return;
    L107:
        if (((Boolean) r9.getData()).booleanValue() == false) goto L109;
        ((Widget) this).contentView.setVisibility(4);
        return;
    L109:
        ((Widget) this).contentView.setVisibility(0);
        return;
    L12:
        if (r0.equals("data_screen_record_is_open") == false) goto L55;
        r7 = 10;
        goto L55
    L16:
        if (r0.equals("data_is_hiding_landscape_buttons") == false) goto L55;
        r7 = 9;
        goto L55
    L20:
        if (r0.equals("data_keyboard_status") == false) goto L55;
        r7 = 8;
        goto L55
    L24:
        if (r0.equals("data_live_mini_app_commerce_status") == false) goto L55;
        r7 = 7;
        goto L55
    L28:
        if (r0.equals("cmd_special_dialog_show") == false) goto L55;
        r7 = 6;
        goto L55
    L32:
        if (r0.equals("cmd_toolbar_reload") == false) goto L55;
        r7 = 5;
        goto L55
    L36:
        if (r0.equals("data_media_introduction_showing") == false) goto L55;
        r7 = 4;
        goto L55
    L40:
        if (r0.equals("cmd_toolbar_fast_start_live") == false) goto L55;
        r7 = 3;
        goto L55
    L44:
        if (r0.equals("cmd_toolbar_visibility_controller") == false) goto L55;
        r7 = 2;
        goto L55
    L48:
        if (r0.equals("cmd_hide_in_douyin_commerce") == false) goto L55;
        r7 = 1;
        goto L55
    L52:
        if (r0.equals("cmd_hide_other_toolbar") == false) goto L55;
        r7 = 0;
        goto L55
    }

    public void onEnterClear(int r3) {
        if (r3 != 4) goto L5;
    L8:
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        r0.setVisibility(8);
    L12:
        if (r3 == 1) goto L14;
        return;
    L14:
        if (this.isAnchor == false) goto L16;
        return;
    L16:
        if (this.mExpand != null) goto L18;
        return;
    L18:
        if (this.mExpandConfig.a() == false) goto L24;
        this.mExpand.h = true;
        return;
    L24:
        return;
    L5:
        if (r3 == 16) goto L8;
        if (r3 != 32) goto L12;
        goto L8
    }

    public void onExitClear(int r3) {
        if (r3 != 4) goto L5;
    L8:
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        if (r3 == 1) goto L14;
        return;
    L14:
        if (this.isAnchor == false) goto L16;
        return;
    L16:
        if (this.mExpand != null) goto L18;
        return;
    L18:
        if (this.mExpandConfig.a() == false) goto L24;
        this.mExpand.h = false;
        return;
    L24:
        return;
    L5:
        if (r3 == 16) goto L8;
        if (r3 != 32) goto L12;
        goto L8
    }

    public void onInit(Object... r2) {
        this.mToolbarContainer = (ViewGroup) ((Widget) this).contentView.findViewById(2131362082);
        this.maskContainer = (ViewGroup) ((Widget) this).containerView.findViewById(2131379664);
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.b() == false) goto L7;
        ViewGroup r3 = (ViewGroup) ((Widget) this).containerView.findViewById(2131381283);
        if (r3 == null) goto L7;
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
    L7:
        int r4 = g2.a;
        if (g2.b(Boolean.valueOf(this.isAnchor)) == false) goto L11;
        com.bytedance.android.live.core.utils.a1.k(this.mToolbarContainer, com.bytedance.android.live.core.utils.s1.f(38.0f));
    L11:
        if (this.isAnchor == false) goto L13;
        return;
    L13:
        if (this.mExpandConfig.a() == false) goto L17;
        this.mExpand = new r0(this.mToolbarContainer);
        return;
    }

    public void onLoad(Object... r6) {
        ALogger.i("toolbar_widget", "onLoad");
        RoomContext r7 = getDataContext();
        ToolbarLoadTimeStatsVM.getInstance(r7).recordTime(ToolbarLoadTimeStatsVM.TOOLBAR_START);
        this.skipClearForReload = false;
        x3 r1 = (x3) y3.m(((Widget) this).dataCenter);
        this.mUnfoldedToolbarManager = r1;
        this.mViewMap = r1.c;
        r1.m = true;
        r1.E(((Widget) this).dataCenter);
        this.isAnchor = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.isMultiToolbar = y3.h(((Widget) this).dataCenter);
        ALogger.i("Toolbar_Preload", "onLoad:::  isMultiToolbar" + this.isMultiToolbar + "   dataCenter" + ((Widget) this).dataCenter.hashCode() + " widget : " + hashCode());
        initTbArch();
        initEvents();
        initMaskContainerIfNeed();
        Object r3 = null;
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L5;
        prepareViewOnLoad();
    L15:
        if (PreloadCompConfig.INSTANCE.enableToolbar() == false) goto L18;
        runWithRoomPreload(new p1(this));
    L18:
        if (this.isAnchor == false) goto L20;
        return;
    L20:
        if (this.mExpand != null) goto L22;
        return;
    L22:
        if (this.mExpandConfig.a() == false) goto L37;
        r0 r8 = this.mExpand;
        boolean r2 = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        r8.i = r2;
        if (r8.c.a() == false) goto L38;
        if (r2 == false) goto L39;
        ViewParent r4 = r8.j.getParent();
        if ((r4 instanceof View) == false) goto L30;
        r3 = r4;
    L30:
        View r5 = (View) r3;
        r8.b = r5;
        if (r5 == null) goto L33;
        r5.setOnTouchListener(new s0(r8));
    L33:
        r8.g.set(false);
        r8.a();
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L5:
        final b r9 = new b(this);
        if (r7 == null) goto L15;
        if (((Boolean) com.bytedance.android.live.core.setting.f0.a.getValue()).booleanValue() == true) goto L10;
        r7.getWidgetLoadTaskScheduler().c(new o1(this, r9));
        goto L15
    L10:
        if (com.bytedance.android.livesdk.interactivity.api.settings.config.z0.a(isScreenPortrait(), (IRoom) ((Widget) this).dataCenter.get("data_room", null)) == false) goto L12;
        ALogger.i(TAG, "LiveToolbarWidget setWidgetVisible INVISIBLE");
        UIUtils.setViewVisibility(((Widget) this).contentView, 4);
        goto L15
    L12:
        UIUtils.setViewVisibility(((Widget) this).contentView, 0);
        goto L15
    }

    public void onMessage(tlc.d r2) {
        if ((r2 instanceof em) == false) goto L6;
        onToolbarItemMessage((em) r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget
    public void onRoomVisible(boolean r1) {
        super.onRoomVisible(r1);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public static /* synthetic */ void access$400(LiveToolbarWidget r0, em r1) {
        r0.showBubbleOnToolbarIcon(r1);
    }

    private void applyDynamicButtons(ToolbarButton r4, final View r5) {
        if (this.mUnfoldedToolbarManager == null) goto L8;
        c0.b r6 = this.mUnfoldedToolbarManager.t(r4);
        if ((r6 instanceof c0.a) == false) goto L9;
        c0.a r7 = (c0.a) r6;
        Maybe<String> r0 = r7.getTitle();
        CompositeDisposable r1 = this.mWidgetTasks;
        Maybe r2 = r0.observeOn(AndroidSchedulers.mainThread());
        Objects.requireNonNull(r5);
        r1.add(r2.subscribe(new r1(r5)));
        Maybe<Drawable> r8 = r7.getIcon();
        this.mWidgetTasks.add(r8.observeOn(AndroidSchedulers.mainThread()).subscribe(new b1(r5)));
        return;
    L9:
        return;
    }

    private int getIndexOfId(int r6, ViewGroup r7) {
        int r0 = ToolbarRuleUtil.a;
        List r1 = (List) new ToolbarRuleUtil.Rule(((Widget) this).dataCenter).b.getValue();
        int r8 = r1.indexOf(Integer.valueOf(r6));
        if (r8 != (-1)) goto L5;
        return -1;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r7.getChildCount()) goto L19;
        View r3 = r7.getChildAt(r2);
        if (r3 == null) goto L17;
        Object r4 = r3.getTag(2131389840);
        if ((r4 instanceof Integer) == false) goto L16;
        int r5 = r1.indexOf(Integer.valueOf(((Integer) r4).intValue()));
        if (r5 > r8) goto L14;
        if (r5 != r8) goto L17;
    L14:
        return r2;
    L16:
        return -1;
    L17:
        r2 = r2 + 1;
        goto L7
    L19:
        return r7.getChildCount();
    }

    private void initMaskContainer(ViewGroup r5, int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        ALogger.i(TAG, "add maskView, count: " + r6);
        if (r6 != 0) goto L7;
        UIUtils.setViewVisibility(r5, 8);
    L7:
        if (r6 <= 0) goto L9;
        View r0 = new View(((Widget) this).context);
        r0.setBackgroundResource(2131250016);
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(com.bytedance.android.live.core.utils.s1.f(38.0f), com.bytedance.android.live.core.utils.s1.f(38.0f));
        r1.setMargins(com.bytedance.android.live.core.utils.s1.f(8.0f), 0, 0, 0);
        r5.addView(r0, r1);
        r6 = r6 - 1;
        goto L7
    }

    private void initPaidLiveTicketStatus(p2 r4, Room r5) {
        if (r5 != null) goto L4;
    L8:
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L12;
        ((Widget) this).dataCenter.put("data_paid_live_sell_ticket_owner_id", ((Long) r6.getOwnerIdOfSellTicket().getValue()).toString());
        return;
    L12:
        return;
    L4:
        if (r5.getPaidLiveData() == null) goto L8;
        if (r5.getPaidLiveData().getTicketSession() == null) goto L8;
        ((Widget) this).dataCenter.put("data_paid_live_sell_ticket_id", String.valueOf(r5.getPaidLiveData().getTicketSession().getTicketId()));
        r4.getClass();
        r4.h = false;
        goto L8
    }

    private void lambda$configToolbarViews$13(int r3, LayoutInflater r4) {
        if (com.bytedance.android.livesdk.config.b0.a() == true) goto L5;
    L7:
        ToolbarButton r0 = (ToolbarButton) ListProtector.get(this.mUnfoldedList, r3);
        ExtendedToolbarButton.b r1 = ExtendedToolbarButton.e(r0);
        r1.b = r3;
        View r5 = configToView(r4, r0, this.mToolbarContainer);
        this.mViewMap.put(r1, r5);
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r6).removeView(r5);
    L10:
        this.mToolbarContainer.addView(r5);
        this.mUnfoldedToolbarManager.D(r1, r5);
        return;
    L5:
        if (r3 < this.mUnfoldedList.size()) goto L7;
    }

    private /* synthetic */ Unit lambda$onLoad$0(com.bytedance.android.live.core.tetris.task.a r2, com.bytedance.android.livesdk.widget.schedule.c r3) {
        r3.L(r2, new c(this));
        return null;
    }

    private static void lambda$registerButtonDisableEvent$11(x3 r1, c0.d r2) throws Exception {
        Map<ExtendedToolbarButton, View> r3 = r1.c;
        HashMap r4 = (HashMap) r3;
        View r5 = (View) r4.get(r2.a);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r2.b == false) goto L7;
        r5.setAlpha(DISABLED_ALPHA);
        return;
    L7:
        r5.setAlpha(1.0f);
    }

    private void reportGameCpToolbarError(ToolbarButton r7, View r8) {
        DataCenter r1 = ((Widget) this).dataCenter;     // Catch: ClassCastException -> L45
        Boolean r2 = Boolean.FALSE;     // Catch: ClassCastException -> L45
        if (((Boolean) r1.get("data_gamecp_remove_toolbar_event", r2)).booleanValue() == false) goto L7;
        return;
    L7:
        if (((Boolean) ((Widget) this).dataCenter.get("data_has_orientation_change", r2)).booleanValue() == false) goto L10;
        return;
    L10:
        if (jc1.k.f(IHostGameCP.class) != null) goto L12;
        return;
    L12:
        if (jc1.k.f(IHostGameCP.class).getGameCpLiveService() != null) goto L14;
        return;
    L14:
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        String r4 = ILiveRoomControllerProvider.ProviderSource.PREVIEW.name();     // Catch: ClassCastException -> L45
    L20:
        int r5 = ((Integer) ((Widget) this).dataCenter.get("room_controller_unique_key", 0)).intValue();     // Catch: ClassCastException -> L45
        String r6 = RoomControllerKeyProvider.generateKey(getRoomId(), r5);     // Catch: ClassCastException -> L45
        Pair r9 = jc1.k.f(IHostGameCP.class).getGameCpLiveService().isGameCpToolbarShowSuccess(getRoomId(), r6, r4);     // Catch: ClassCastException -> L45
        boolean r10 = ((Boolean) r9.getFirst()).booleanValue();     // Catch: ClassCastException -> L45
        boolean r11 = ((Boolean) r9.getSecond()).booleanValue();     // Catch: ClassCastException -> L45
        if (r10 == false) goto L50;
        if (r11 == true) goto L51;
        Integer r12 = Integer.valueOf((int) r7.getId());     // Catch: ClassCastException -> L45
        Object r13 = r8.getTag(2131389840);     // Catch: ClassCastException -> L45
        if ((r13 instanceof Integer) == false) goto L27;
        r12 = (Integer) r13;     // Catch: ClassCastException -> L45
    L27:
        BottomToolbarViewModel.a r14 = BottomToolbarViewModel.Companion;     // Catch: ClassCastException -> L45
        DataCenter r15 = ((Widget) this).dataCenter;     // Catch: ClassCastException -> L45
        r14.getClass();     // Catch: ClassCastException -> L45
        BottomToolbarViewModel r16 = BottomToolbarViewModel.a.a(r15);     // Catch: ClassCastException -> L45
        if (r16 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r17 = r16.findContainButtonById(r12.intValue());     // Catch: ClassCastException -> L45
    L31:
        if (r17 == null) goto L33;
    L39:
        if (r17 == null) goto L52;
        int r18 = r17.a;     // Catch: ClassCastException -> L45
        if (r18 != 5) goto L53;
        int r19 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0.a;     // Catch: ClassCastException -> L45
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0.a(String.valueOf(r18), ((Widget) this).dataCenter, r17.l.b, ErrorReason.REMOVE_GAMECP_TOOLBAR_VIEW_ON_UNLOAD.getValue(), "");     // Catch: ClassCastException -> L45
        jc1.k.f(IHostGameCP.class).getGameCpLiveService().sendGameCpToolbarCancelEvent(getRoomId(), r6, r4);     // Catch: ClassCastException -> L45
        ((Widget) this).dataCenter.put("data_gamecp_remove_toolbar_event", Boolean.TRUE);     // Catch: ClassCastException -> L45
        return;
    L53:
        return;
    L52:
        return;
    L33:
        if (LiveTbArchUtils.INSTANCE.enableOpt(((Widget) this).dataCenter) == false) goto L39;
        com.bytedance.android.livesdk.arch.context.a r20 = this.tbContext;     // Catch: ClassCastException -> L45
        if (r20 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r21 = r20.getCompactTbLoader();     // Catch: ClassCastException -> L45
        if (r21 == null) goto L39;
        r17 = r21.findContainButtonById(r12.intValue());     // Catch: ClassCastException -> L45
        goto L39
    L30:
        r17 = null;
        goto L31
    L51:
        return;
    L50:
        return;
    L19:
        r4 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();     // Catch: ClassCastException -> L45
        goto L20
    L16:
        r3 = false;
    }

    private void translateExceptVisibleButton(boolean r4, Room r5) {
        if (((d51) j40.a1.a.getValue()).a() == true) goto L5;
        return;
    L5:
        if (r5.isMediaRoom() == true) goto L20;
        int r6 = 0;
    L8:
        if (r6 >= this.mToolbarContainer.getChildCount()) goto L21;
        View r0 = this.mToolbarContainer.getChildAt(r6);
        if (r0.getTag() != ToolbarButton.SWITCH_VIDEO_QUALITY) goto L15;
        if (r4 == false) goto L13;
        float r1 = 100.0f;
    L14:
        translateY(r0, com.bytedance.android.live.core.utils.s1.f(r1));
        goto L15
    L13:
        r1 = 0.0f;
    L15:
        r6 = r6 + 1;
        goto L8
    L21:
        return;
    }

    private void translateY(View r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.animate().setDuration(200).translationY(r4).start();
    }

    public int attachToContainer(int r5, View r6) {
        ViewParent r0 = r6.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r0).removeView(r6);
    L5:
        ViewGroup r1 = getContainerView();
        if (r1 == null) goto L11;
        int r2 = getIndexOfId(r5, r1);
        if (r2 == (-1)) goto L10;
        r1.addView(r6, r2);
        ALogger.i(TAG, "add " + r5 + " view at " + r2);
        return r2;
    L10:
        autoAddToFirstWhenError(r1, r6);
        ALogger.e(TAG, "add view error." + r5);
        return r2;
    L11:
        ALogger.i(TAG, "container is null error.");
        return 0;
    }

    public View createCustomView(int r3, ToolbarButton r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        View r0 = configToView(getLayoutInflate(), r4, getContainerView());
        r0.setTag(2131389840, Integer.valueOf(r3));
        this.mViewMap.put(r4.extended(), r0);
        return r0;
    }

    public void hideVisibleView(boolean r3, List<ToolbarButton> r4) {
        if (r3 == false) goto L23;
        if (this.isHideOther == false) goto L6;
        return;
    L6:
        this.isHideOther = true;
        this.mVisiableViews.clear();
        Iterator<ToolbarButton> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L54;
        ToolbarButton r6 = r5.next();
        View r0 = this.mViewMap.get(ExtendedToolbarButton.e(r6));
        if (r0 == null) goto L8;
        if (r6 == ToolbarButton.GAME_EXIT) goto L8;
        if (r6 == ToolbarButton.MORE) goto L8;
        if (r6 == ToolbarButton.GAME_GUESS) goto L8;
        if (r6 == ToolbarButton.OPEN_PLATFORM_LYNX_GAME) goto L8;
        if (r0.getVisibility() != 0) goto L8;
        r0.setVisibility(8);
        this.mVisiableViews.add(r0);
        goto L8
    L54:
        return;
    L23:
        if (this.isHideOther == true) goto L25;
        return;
    L25:
        this.isHideOther = false;
        Iterator<View> r7 = this.mVisiableViews.iterator();
    L27:
        if (r7.hasNext() == false) goto L32;
        View r1 = r7.next();
        if (r1 == null) goto L27;
        r1.setVisibility(0);
        goto L27
    L32:
        this.mVisiableViews.clear();
    }

    public void putView2ToolbarManager(ToolbarButton r2, View r3) {
        if (r2 == null) goto L8;
        if (r3 == null) goto L9;
        Map<ExtendedToolbarButton, View> r0 = this.mViewMap;
        if (r0 == null) goto L10;
        r0.put(r2.extended(), r3);
        return;
    L10:
        return;
    L9:
        return;
    }

    public View configToView(LayoutInflater r12, ToolbarButton r13, ViewGroup r14) {
        View r0 = this.mCachedViewMap.get(r13);
        SkinLoader.c.getClass();
        boolean r3 = false;
        if (SkinLoader.a.b() == false) goto L13;
        if (r13.useStandardLayout() == false) goto L13;
        if (r0 != null) goto L8;
        int r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.behavior.a.a;
        r0 = r12.inflate(2131567862, r14, false);
    L8:
        if (r0 == null) goto L13;
        View r2 = r0.findViewById(2131389079);
        View r4 = r0.findViewById(2131362951);
        View r5 = r0.findViewById(2131362953);
        View r6 = r0.findViewById(2131392581);
        UIUtils.setViewVisibility(r4, 8);
        UIUtils.setViewVisibility(r5, 8);
        UIUtils.setViewVisibility(r6, 8);
        if (r2 == null) goto L13;
        r2.setBackgroundResource(r13.getDrawableUnfolded());
    L13:
        if (r0 != null) goto L30;
        r0 = LiveInflateUtil.a(r13.name(), r13.getLayoutId(), r13.name(), ContextUtil.contextToActivity(getContext()), r14, r12);
        int r15 = g2.a;
        if (g2.b(Boolean.valueOf(this.isAnchor)) == false) goto L25;
        if (r0 == null) goto L25;
        if (r0.getLayoutParams() == null) goto L25;
        if (r0.getLayoutParams().width != r0.getLayoutParams().height) goto L25;
        if (r0.getLayoutParams().width != com.bytedance.android.live.core.utils.s1.f(36.0f)) goto L25;
        UIUtils.setLayoutParams(r0, com.bytedance.android.live.core.utils.s1.f(38.0f), com.bytedance.android.live.core.utils.s1.f(38.0f));
    L25:
        if (r13.getLayoutId() != 2131567861) goto L30;
        if (r13 == ToolbarButton.VS_ACTIVITY_ONE) goto L30;
        this.mCachedViewMap.put(r13, r0);
    L30:
        if (r13.getLayoutId() != 2131567861) goto L35;
        View r16 = r0.findViewById(2131374718);
        if (r16 == null) goto L35;
        r16.setBackgroundResource(r13.getDrawableUnfolded());
    L35:
        if (r13.isPureText() == false) goto L41;
        View r17 = r0.findViewById(2131390392);
        String r18 = r13.extended().g();
        if ((r17 instanceof TextView) == false) goto L41;
        if (TextUtils.isEmpty(r18) == true) goto L41;
        com.bytedance.android.live.core.utils.a1.p(r17, com.bytedance.android.live.core.utils.s1.f(36.0f));
        r17.setPadding(0, 0, 0, 0);
        ((TextView) r17).setText(r18);
        UIUtils.setViewVisibility(r17, 0);
    L41:
        applyDynamicButtons(r13, r0);
        r0.setTag(r13);
        r0.setVisibility(8);
        boolean r19 = VSMediaUIConfigHelper.b(((Widget) this).dataCenter);
        if (r19 == false) goto L44;
        float r110 = 16.0f;
    L45:
        boolean r7 = isScreenPortrait();
        int r8 = com.bytedance.android.livesdk.utils.landscape.d.a;
        boolean r9 = true;
        if ((!r7) == true) goto L48;
    L50:
        if (r19 == true) goto L52;
    L54:
        com.bytedance.android.livesdk.r3.i(r0, r13);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.c r111 = this.layoutReloadABUtil;
        if (r111.a == false) goto L88;
        Intrinsics.checkNotNullParameter(r13, "config");
        List<String> r112 = r111.b;
        if (r112 == null) goto L59;
        boolean r113 = r112.contains(r13.name());
    L60:
        if (r113 == true) goto L88;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.c r114 = this.layoutReloadABUtil;
        Room r10 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        r114.getClass();
        Intrinsics.checkNotNullParameter(r13, "config");
        if (r10 == null) goto L68;
        ActivityRoomSkinInfo r115 = r10.getActivityRoomSkinInfo();
        if (r115 == null) goto L68;
        Map r116 = r115.getVerticalImages();
        if (r116 == null) goto L68;
        r3 = !r116.isEmpty();
    L68:
        if (r3 == true) goto L85;
        if (r10 == null) goto L76;
        ActivityRoomSkinInfo r117 = r10.getActivityRoomSkinInfo();
        if (r117 == null) goto L76;
        Map r118 = r117.getHorizontalImages();
        if (r118 == null) goto L76;
        r3 = !r118.isEmpty();
    L76:
        if (r3 == true) goto L85;
        if (r10 == null) goto L84;
        LiveToolbarData r119 = r10.getToolbarData();
        if (r119 == null) goto L84;
        Map r120 = r119.getSkinResource();
        if (r120 == null) goto L84;
        r9 = true ^ r120.isEmpty();
    L84:
        r9 = r3;
    L85:
        if (r9 == false) goto L87;
        this.mCachedViewMap.clear();
        goto L88
    L87:
        this.mCachedViewMap.put(r13, r0);
        goto L88
    L59:
        r113 = false;
    L88:
        return r0;
    L52:
        if (com.bytedance.android.live.core.utils.a1.f(r0) != com.bytedance.android.live.core.utils.s1.f(r110)) goto L54;
        UIUtils.updateLayoutMargin(r0, com.bytedance.android.live.core.utils.s1.f(8.0f), -3, 0, -3);
        goto L54
    L48:
        if (this.isAnchor == true) goto L50;
        UIUtils.updateLayoutMargin(r0, com.bytedance.android.live.core.utils.s1.f(r110), -3, 0, -3);
        goto L54
    L44:
        r110 = 14.0f;
        goto L45
    }

    public void onChildViewChanged(boolean r1, int r2, View r3) {
        if (this.isAnchor == false) goto L5;
        return;
    L5:
        if (this.mExpand != null) goto L7;
        return;
    L7:
        if (this.mExpandConfig.a() == false) goto L12;
        this.mExpand.a();
        return;
    }
}
