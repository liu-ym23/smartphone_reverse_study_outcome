package com.bytedance.android.live.anchormodelink.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVoiceFeedPreview;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revenue.core.f;
import com.bytedance.android.livesdk.config.b60;
import com.bytedance.android.livesdk.config.uj0;
import com.bytedance.android.livesdk.config.vb0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.IPreviewPlayerContainerAbility;
import com.bytedance.android.livesdkapi.feed.anchormode.ILivePreviewAnchorModeLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.anchormode.IPreviewAnchorModeContainerProvider;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkBaseDegradeConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.scope.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LivePreviewAnchorModeDynamicWidget implements ILivePreviewAnchorModeLinkCommonWidget, c, ILivePreviewMultiLinkCommonWidget.IEnterBundleExtraParamsProvider, OnWRDSDataUpdateListener {
    public IRoom a;
    public int b;
    public Disposable c;
    public IPreviewMultiLinkOuterConfigProvider d;
    public IPreviewAnchorModeContainerProvider e;
    public IPreviewPlayerContainerAbility f;
    public MessageHub g;
    public final CompositeDisposable h;
    public FrameLayout i;
    public AnchorModeDynamicFeedPreview j;
    public ylc.c k;
    public long l;
    public long m;
    public final Lazy n;
    public ParseSeiData o;
    public AnchorModeParseSeiData p;
    public String q;
    public int r;
    public int s;
    public long t;
    public final long u;
    public boolean v;
    public boolean w;
    public final Lazy x;
    public final Lazy y;
    public final Object z;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Pair<String, ParseSeiData>> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            int r0 = ve0.a.a;
            ParseSeiData r1 = ve0.a.b(this.a);
            r4.onNext(new Pair(this.a, r1));
            r4.onComplete();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LivePreviewAnchorModeDynamicWidget a;
        public final /* synthetic */ String b;

        public b(LivePreviewAnchorModeDynamicWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Pair r4 = (Pair) r3;
            LivePreviewAnchorModeDynamicWidget r0 = this.a;
            r0.q = (String) r4.getFirst();
            ParseSeiData r5 = (ParseSeiData) r4.getSecond();
            if (r5 != null) goto L5;
        L7:
            LivePreviewAnchorModeDynamicWidget r6 = this.a;
            String r1 = r6.q;
            if (r1 == null) goto L12;
            AnchorModeDynamicFeedPreview r7 = r6.j;
            if (r7 == null) goto L12;
            r7.h(r1);
        L12:
            this.a.c(this.b);
            return;
        L5:
            if (r5.getSeiVersion() < 3) goto L7;
            this.a.o = r5;
            goto L7
        }
    }

    public final void clickEnterRoomEventUpdate(boolean r1) {
    }

    public final ld0.a getCurrentVideoStateSeiData() {
        return null;
    }

    public final int getSeiVersion() {
        return -1;
    }

    public final String getShowPlayer() {
        return null;
    }

    public final void onSeiRawUpdatedV2(String r2, ye1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "seiRaw");
        Intrinsics.checkNotNullParameter(r3, "info");
    }

    public final void onWRDSDataUpdate(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "syncKey");
    }

    public final void recordPlayerFirstFrameLoad(long r1) {
    }

    public final void release() {
        this.w = true;
        IPreviewMultiLinkOuterConfigProvider r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        r1.printALogger("LivePreviewAnchorModeDynamicWidget", hashCode(), "call release", true);
        this.h.clear();
        a();
        this.q = null;
        this.o = new ParseSeiData(0, 0, 0, null, 0, false, null, 0, 255, null);
        this.p = null;
        Disposable r2 = this.c;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        this.c = null;
    }

    public final void updateFeedDataToPreLoad() {
    }

    public final void a() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        int r2 = hashCode();
        StringBuilder r3 = new StringBuilder("clearMultiLinkFeedPreview ");
        r3.append(this.j);
        r3.append(", ");
        AnchorModeDynamicFeedPreview r4 = this.j;
        if (r4 == null) goto L8;
        int r5 = r4.hashCode();
    L9:
        r3.append(r5);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "LivePreviewAnchorModeDynamicWidget", r2, r3.toString(), false, 8, null);
        if (((Boolean) d.w2.getValue(null, d.a[176(0xb0, float:2.47E-43)])).booleanValue() == false) goto L14;
        AnchorModeDynamicFeedPreview r1 = this.j;
        if (r1 == null) goto L14;
        r1.s();
    L14:
        AnchorModeDynamicFeedPreview r6 = this.j;
        if (r6 == null) goto L17;
        r6.release();
    L17:
        FrameLayout r7 = this.i;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L20:
        AnchorModeDynamicFeedPreview r8 = this.j;
        if (r8 == null) goto L23;
        View r9 = r8.getViewCompat();
    L24:
        r7.removeView(r9);
        FrameLayout r11 = this.i;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L27:
        a1.j(r11, 0);
        this.j = null;
        FrameLayout r12 = this.i;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L31:
        if (r12.getVisibility() != 0) goto L39;
        FrameLayout r13 = this.i;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L35:
        r13.setVisibility(8);
        if (shouldUseNewLivePlayerLayout() == false) goto L40;
        this.s = 0;
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r9 = null;
        goto L24
    L8:
        r5 = 0;
        goto L9
    }

    public final boolean b() {
        if (((Boolean) this.x.getValue()).booleanValue() == false) goto L10;
        LinkFeedTypeConstant.Companion r0 = LinkFeedTypeConstant.Companion;
        IPreviewMultiLinkOuterConfigProvider r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        if (r0.isDouyinFullScreen(r1.getFeedLiveType()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof MultiLinkCommonVoiceFeedPreview) == true) goto L5;
        r0 = null;
    L5:
        MultiLinkCommonVoiceFeedPreview r1 = (MultiLinkCommonVoiceFeedPreview) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getChatRoomEnterRoomExtraParam();
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.c
    public final int getContainerWidth() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.width);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.y();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.d;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getWidth();
        goto L25
    }

    public final Object getCurrentSeiParseResultData() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getCurrentSeiParseResultData();
    }

    public final String getCurrentSingUserIdString() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        String r2 = r1.getCurrentSingUserIdString();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    public final View getFeedPreview() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getViewCompat();
    }

    public final HashMap<String, Object> getKtvEnterRoomExtraParam() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getKtvEnterRoomExtraParam();
    }

    public final Object getKtvSeiModelObject() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getKtvSeiModelObject();
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.c
    public final int l() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewPlayerContainerAbility r1 = r0.getPlayerContainerAbility();
        Integer r2 = null;
        if (r1 == null) goto L19;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L19;
        Integer r4 = Integer.valueOf(r3.height);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L19;
        r2 = r4;
    L25:
        if (r2 == null) goto L28;
        return r2.intValue();
    L28:
        return s1.w();
    L12:
        r5 = false;
    L19:
        IPreviewMultiLinkOuterConfigProvider r6 = this.d;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L22:
        IPreviewPlayerContainerAbility r7 = r6.getPlayerContainerAbility();
        if (r7 == null) goto L25;
        r2 = r7.getHeight();
        goto L25
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.c
    public final IInteractPlayView n() {
        return (IInteractPlayView) this.n.getValue();
    }

    public final void onLivePlayerVideoSizeChanged() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "LivePreviewAnchorModeDynamicWidget", hashCode(), "onLivePlayerVideoSizeChanged", false, 8, null);
        d();
    }

    public final void onViewHolderPause() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void onViewHolderResume() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    public final void onViewHolderSelect() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "LivePreviewAnchorModeDynamicWidget", hashCode(), "onViewHolderSelect: ", false, 8, null);
        this.v = true;
        AnchorModeDynamicFeedPreview r1 = this.j;
        if (r1 == null) goto L9;
        r1.o();
        return;
    }

    public final void onViewHolderUnSelect() {
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "LivePreviewAnchorModeDynamicWidget", hashCode(), "onViewHolderUnSelect: ", false, 8, null);
        this.v = false;
        AnchorModeDynamicFeedPreview r1 = this.j;
        if (r1 == null) goto L9;
        r1.s();
        return;
    }

    public final void resetKtvSeiModelObject() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        r1.resetKtvSeiModelObject();
        return;
    }

    public final void setRenderViewBitmapToMockView() {
        AnchorModeDynamicFeedPreview r0 = this.j;
        if ((r0 instanceof com.bytedance.android.live.liveinteract.feedv2.feedview.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.liveinteract.feedv2.feedview.b r1 = (com.bytedance.android.live.liveinteract.feedv2.feedview.b) r0;
        if (r1 == null) goto L9;
        r1.setRenderViewBitmapToMockView();
        return;
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.c
    public final boolean shouldUseNewLivePlayerLayout() {
        int r0 = this.b;
        if (r0 != 2) goto L5;
    L10:
        boolean r1 = true;
    L11:
        IMiddlewareLiveService r2 = TTLiveServiceMiddleware.getLiveService();
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L21;
        if (r1 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L14:
        if (r2.shouldUseNewLivePlayerLayout() != true) goto L16;
        r3 = true;
        goto L17
    L5:
        if (r0 == 3) goto L10;
        if (r0 == 4) goto L10;
        r1 = false;
        goto L11
    }

    public final void d() {
        if (b() == true) goto L5;
    L40:
        String r0 = this.q;
        if (r0 == null) goto L45;
        AnchorModeDynamicFeedPreview r1 = this.j;
        if (r1 == null) goto L45;
        r1.h(r0);
    L45:
        AnchorModeParseSeiData r2 = this.p;
        if (r2 == null) goto L51;
        AnchorModeDynamicFeedPreview r3 = this.j;
        if (r3 == null) goto L52;
        r3.g(r2);
        return;
    L52:
        return;
    L51:
        return;
    L5:
        if (this.p == null) goto L40;
        int r4 = this.o.getSeiSubScene();
        AnchorModeParseSeiData r5 = this.p;
        if (r5 == null) goto L40;
        if (r4 != r5.getSeiScene()) goto L40;
        IPreviewMultiLinkOuterConfigProvider r6 = this.d;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L13:
        LivePlayerView r7 = r6.getLivePlayerView();
        ViewParent r8 = null;
        if (r7 == null) goto L16;
        IRenderView r9 = r7.getRenderView();
    L17:
        IPreviewMultiLinkOuterConfigProvider r11 = this.d;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L20:
        FrameLayout r12 = r11.getContainerView();
        IInteractPlayView r13 = (IInteractPlayView) this.n.getValue();
        if (r13 == null) goto L40;
        AnchorModeParseSeiData r14 = this.p;
        int r15 = this.o.getSeiUiLayout();
        if (r9 == null) goto L25;
        ViewParent r16 = r9.getParent();
    L27:
        if ((r16 instanceof LivePlayerView) == false) goto L30;
        r8 = r16;
    L30:
        LivePlayerView r17 = (LivePlayerView) r8;
        IPreviewMultiLinkOuterConfigProvider r18 = this.d;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L33:
        Context r19 = r18.getContext();
        IRoom r110 = this.a;
        if (r110 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L36:
        IPreviewMultiLinkOuterConfigProvider r21 = this.d;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L39:
        r13.resizePlayViewForNewLinkFeedView(r14, r15, r17, r19, r110, r21.getFeedLiveType(), r12.getWidth(), r12.getHeight());
        goto L40
    L25:
        r16 = null;
        goto L27
    L16:
        r9 = null;
        goto L17
    }

    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return CollectionsKt.emptyList();
    }

    public final ylc.c getDataSyncListener() {
        return this.k;
    }

    public final String getSeiRaw() {
        return this.q;
    }

    public final int getSubScene() {
        return this.r;
    }

    public final int getUILayout() {
        return this.s;
    }

    public LivePreviewAnchorModeDynamicWidget(Object r12) {
        this.z = r12;
        this.h = new CompositeDisposable();
        this.n = LazyKt.lazy(new LivePreviewAnchorModeDynamicWidget$mInteractPlayView$2(this));
        this.o = new ParseSeiData(0, 0, 0, null, 0, false, null, 0, 255, null);
        this.q = "";
        this.r = -1;
        this.s = -1;
        this.u = 15000;
        this.x = LazyKt.lazy(LivePreviewAnchorModeDynamicWidget$liveSmoothEnterRoomSwitch$2.INSTANCE);
        this.y = LazyKt.lazy(LivePreviewAnchorModeDynamicWidget$seiUpdateTimeoutSwitchPreview$2.INSTANCE);
    }

    public final void c(String r19) {
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r19) == false) goto L45;
        long r5 = ((MultiLinkBaseDegradeConfig) b60.a.getValue()).getSeiConsumeDebounceTime();
        if (r5 > 0) goto L7;
    L9:
        this.m = System.currentTimeMillis();
        boolean r6 = true;
    L10:
        if (r6 == false) goto L46;
        JSONObject r7 = LiveSeiUtil.c(r19);     // Catch: JSONException -> L43
        if (r7.has("info") == false) goto L23;
        if (r7.has("source") == false) goto L23;
        if (TextUtils.equals(r7.optString("source"), "zego") == false) goto L23;
        Object r2 = r7.get("info");     // Catch: JSONException -> L43
        if (r2 == null) goto L21;
        r7 = (JSONObject) r2;     // Catch: JSONException -> L43
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L43
    L23:
        if (r7.has("app_data") == false) goto L47;
        JSONObject r11 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r7, "app_data"), ""));     // Catch: JSONException -> L43
        long r3 = r11.optLong("timestamp");     // Catch: JSONException -> L43
        if (r3 > this.l) goto L27;
        return;
    L27:
        int r12 = r11.optInt("ui_layout", 0);     // Catch: JSONException -> L43
        if (r11.has("interactive_scene") == false) goto L30;
        int r13 = r11.optInt("interactive_scene");     // Catch: JSONException -> L43
    L31:
        this.l = r3;     // Catch: JSONException -> L43
        if (r13 != 20) goto L48;
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r11, "layout_info");     // Catch: JSONException -> L43
        if (r1 == null) goto L38;
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r1, "ui_container_android");     // Catch: JSONException -> L43
        if (r4 == null) goto L38;
        int r14 = JSONObjectProtectorUtils.getInt(r4, "top");     // Catch: JSONException -> L43
    L39:
        AnchorModeParseSeiData r8 = new AnchorModeParseSeiData(r11, r12, r13, r14, null, 16, null);     // Catch: JSONException -> L43
        this.p = r8;     // Catch: JSONException -> L43
        AnchorModeDynamicFeedPreview r9 = this.j;     // Catch: JSONException -> L43
        if (r9 == null) goto L49;
        r9.g(r8);     // Catch: JSONException -> L43
        return;
    L49:
        return;
    L38:
        r14 = 0;
        goto L39
    L48:
        return;
    L30:
        r13 = 0;
        goto L31
    L47:
        return;
    L50:
        return;
    L46:
        return;
    L7:
        if ((System.currentTimeMillis() - this.m) >= r5) goto L9;
        r6 = false;
        goto L10
    }

    public final void onSeiRawUpdated(String r4) {
        Intrinsics.checkNotNullParameter(r4, "seiRaw");
        if (((Boolean) vb0.a.getValue()).booleanValue() == false) goto L5;
        this.c = Observable.create(new a(r4)).subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4));
        return;
    L5:
        this.q = r4;
        ParseSeiData r0 = ve0.a.b(r4);
        if (r0 != null) goto L8;
    L10:
        String r1 = this.q;
        if (r1 == null) goto L15;
        AnchorModeDynamicFeedPreview r2 = this.j;
        if (r2 == null) goto L15;
        r2.h(r1);
    L15:
        c(r4);
        return;
    L8:
        if (r0.getSeiVersion() < 3) goto L10;
        this.o = r0;
        goto L10
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.k = r1;
    }

    public final void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r3) {
        Intrinsics.checkNotNullParameter(r3, "wrds");
        if (this.j == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "wrds");
        Intrinsics.checkNotNullParameter(r3, "wrds");
        return;
    }

    public final void updateUILayoutBySei(int r17, int r18, AnchorModeParseSeiData r19, boolean r21) {
        Intrinsics.checkNotNullParameter(r19, "parseSeiData");
        IPreviewMultiLinkOuterConfigProvider r3 = this.d;
        if (r3 != null) goto L5;
        ALogger.i("LivePreviewAnchorModeDynamicWidget", "realUpdateUILayoutBySei but configOuterProvider not init");
        return;
    L5:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r3, "LivePreviewAnchorModeDynamicWidget", hashCode(), "updateUILayoutBySei targetUILayout = " + r17 + ", fromUILayout = " + r18 + ", parseSeiData =  " + r19 + ", mCurrentUILayout " + this.s + ", mCurrentSubScene " + this.r, false, 8, null);
        if (this.w == false) goto L11;
        IPreviewMultiLinkOuterConfigProvider r4 = this.d;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L10:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r4, "LivePreviewAnchorModeDynamicWidget", hashCode(), "updateUILayoutBySei but released=" + this.w, false, 8, null);
        return;
    L11:
        this.p = r19;
        int r13 = r19.getSeiScene();
        int r14 = r19.getSeiUiLayout();
        IPreviewMultiLinkOuterConfigProvider r2 = this.d;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L14:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r2, "LivePreviewAnchorModeDynamicWidget", hashCode(), "updateUILayoutBySei mCurrentSubScene =  " + this.r + ", subScene= " + r13 + "， uiLayout=" + r14, false, 8, null);
        int r5 = this.r;
        if (r5 == r13) goto L90;
        String r15 = null;
        if (b() == false) goto L52;
        IInteractPlayView r6 = (IInteractPlayView) this.n.getValue();
        if (r6 == null) goto L24;
        IPreviewMultiLinkOuterConfigProvider r7 = this.d;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L23:
        r6.setFeedViewDesiredTopSpaceHeight(r7.getDesiredTopSpaceHeight());
    L24:
        IPreviewMultiLinkOuterConfigProvider r8 = this.d;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L27:
        LivePlayerView r9 = r8.getLivePlayerView();
        if (r9 == null) goto L30;
        IRenderView r11 = r9.getRenderView();
    L31:
        IPreviewMultiLinkOuterConfigProvider r12 = this.d;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L34:
        FrameLayout r16 = r12.getContainerView();
        IInteractPlayView r22 = (IInteractPlayView) this.n.getValue();
        if (r22 == null) goto L52;
        if (r11 == null) goto L38;
        ViewParent r23 = r11.getParent();
    L40:
        if ((r23 instanceof LivePlayerView) == true) goto L42;
        r23 = null;
    L42:
        LivePlayerView r24 = (LivePlayerView) r23;
        IPreviewMultiLinkOuterConfigProvider r25 = this.d;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L45:
        Context r26 = r25.getContext();
        IRoom r27 = this.a;
        if (r27 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L48:
        IPreviewMultiLinkOuterConfigProvider r28 = this.d;
        if (r28 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L51:
        r22.resizePlayViewForNewLinkFeedView(r19, r14, r24, r26, r27, r28.getFeedLiveType(), r16.getWidth(), r16.getHeight());
        goto L52
    L38:
        r23 = null;
        goto L40
    L30:
        r11 = null;
    L52:
        a();
        IPreviewMultiLinkOuterConfigProvider r29 = this.d;
        if (r29 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L55:
        Context r31 = r29.getContext();
        Object r32 = this.z;
        if (r32 != null) goto L58;
    L60:
        j r33 = (rh6.a) CollectionsKt.lastOrNull(f.a);
    L61:
        AnchorModeDynamicFeedPreview r34 = new AnchorModeDynamicFeedPreview(r31, r17, r19, r33);
        this.j = r34;
        IPreviewMultiLinkOuterConfigProvider r1 = this.d;
        if (r1 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L64:
        r34.f(r1, this, r21);
        AnchorModeDynamicFeedPreview r35 = this.j;
        if (r35 == null) goto L88;
        View r36 = r35.getViewCompat();
        if (r36 == null) goto L88;
        FrameLayout r37 = this.i;
        if (r37 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L71:
        r37.setVisibility(0);
        IPreviewMultiLinkOuterConfigProvider r38 = this.d;
        if (r38 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L74:
        int r39 = hashCode();
        StringBuilder r41 = new StringBuilder("containerView addview  ");
        AnchorModeDynamicFeedPreview r42 = this.j;
        if (r42 == null) goto L77;
        r15 = r42.getFeedViewName();
    L77:
        r41.append(r15);
        r41.append(' ');
        r41.append(r36);
        r41.append(", containerView=");
        FrameLayout r43 = this.i;
        if (r43 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L80:
        r41.append(r43.hashCode());
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r38, "LivePreviewAnchorModeDynamicWidget", r39, r41.toString(), false, 8, null);
        FrameLayout r44 = this.i;
        if (r44 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L83:
        r44.addView(r36);
        if (this.v == false) goto L88;
        AnchorModeDynamicFeedPreview r45 = this.j;
        if (r45 == null) goto L88;
        r45.o();
    L88:
        this.r = r13;
        this.s = r14;
    L96:
        if (((Boolean) this.y.getValue()).booleanValue() == true) goto L98;
        return;
    L98:
        if ((System.currentTimeMillis() - this.t) <= this.u) goto L104;
        this.t = System.currentTimeMillis();
        d();
        return;
    L104:
        return;
    L58:
        if ((r32 instanceof j) == false) goto L60;
        r33 = (j) r32;
        goto L61
    L90:
        if (this.s == r14) goto L96;
        AnchorModeDynamicFeedPreview r46 = this.j;
        if (r46 == null) goto L94;
        r46.t(r19, r5, r14);
    L94:
        this.s = r14;
        goto L96
    }

    public final void init(IPreviewMultiLinkOuterConfigProvider r9, IPreviewAnchorModeContainerProvider r11, boolean r12, long r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "configProvider");
        Intrinsics.checkNotNullParameter(r11, "containerProvider");
        r9.printALogger("LivePreviewAnchorModeDynamicWidget", hashCode(), "call init", true);
        int r3 = hashCode();
        StringBuilder r15 = new StringBuilder("multiLinkPreviewUseSetting=");
        ReadOnlyProperty r16 = d.x2;
        KProperty[] r17 = d.a;
        r15.append(((Boolean) r16.getValue(null, r17[177(0xb1, float:2.48E-43)])).booleanValue());
        r15.append(", tryLoadByRoomSetting=");
        r15.append(((Boolean) d.A2.getValue(null, r17[180(0xb4, float:2.52E-43)])).booleanValue());
        r15.append(",tryLoadByRoomForRadioSetting=");
        r15.append(((Boolean) d.B2.getValue(null, r17[181(0xb5, float:2.54E-43)])).booleanValue());
        r15.append(",loadCommonWidgetOptSetting=");
        r15.append(((Boolean) d.C2.getValue(null, r17[182(0xb6, float:2.55E-43)])).booleanValue());
        r15.append(",livePreviewMultiLinkModeOpt=");
        r15.append((Boolean) uj0.a.getValue());
        r15.append(",isPreload = ");
        r15.append(r14);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r9, "LivePreviewAnchorModeDynamicWidget", r3, r15.toString(), false, 8, null);
        this.d = r9;
        this.e = r11;
        this.i = r11.getContainerView();
        this.f = r9.getPlayerContainerAbility();
        this.g = r9.getMessageHub();
        this.b = r9.getShowFrom();
        this.a = r9.getRoom();
        IPreviewMultiLinkOuterConfigProvider r18 = this.d;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L5:
        String r19 = r18.getLastAppData();
        IPreviewMultiLinkOuterConfigProvider r0 = this.d;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L8:
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r0, "LivePreviewAnchorModeDynamicWidget", hashCode(), "handleLastAppData lastAppData=" + r19, false, 8, null);
        if (r2.a(r19) == false) goto L12;
        c(r19);
        return;
    }
}
