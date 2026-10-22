package com.bytedance.android.livesdk.gift.platform.core;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.debug.DebugAssetPreviewDebugWidget;
import com.bytedance.android.debug.DebugGiftPreviewDebugWidget;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.gift.tray.DialogStatus;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.downloader.NewGiftResourceManager;
import com.bytedance.android.livesdk.gift.configmodel.c1;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.configmodel.y1;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.fastgift.di.FastGiftModule_ProvideFastGiftViewFactory;
import com.bytedance.android.livesdk.gift.grouplive.di.GroupLiveModule_ProviderGroupLiveContainerServiceFactory;
import com.bytedance.android.livesdk.gift.guide.di.CommentModule_ProviderCommentGuideViewFactory;
import com.bytedance.android.livesdk.gift.guide.di.GuideModule_ProvideGuideDialogFactory;
import com.bytedance.android.livesdk.gift.guide.di.GuideModule_ProvideGuidePresenterFactory;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.multiplayer.di.MultiPlayerModule_ProviderMultiPlayerClassFactory;
import com.bytedance.android.livesdk.gift.platform.business.ai.GiftAsyncSortManager;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0;
import com.bytedance.android.livesdk.gift.platform.business.effect.CommonPlayerControllerManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.CleanDataSource;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.TopAtmosphereWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.CleanOpportunity;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.GiftRoomCleanCacheService;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.GestureGiftGuideWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.GiftEffectFrontSeatLayerWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.GiftEffectInfoLynxWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.GiftEffectOperationLayerWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.GiftFourthLineCardWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.business.giftwall.GiftWallPreRequestManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.bytedance.android.livesdk.gift.platform.business.pkTray.PKTrayWidget;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.business.tray.MatchRoomGiftTrayWidget;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.business.tray2.manager.VideoGiftMsgManagerV2;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.preview.view.UgcGiftSaleDialog;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsDeleteGlobalService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMessageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.GiftEffectConfigurationDialog;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftNitaViewInfo;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftPanelNitaViewInfo;
import com.bytedance.android.livesdk.gift.platform.core.utils.g0;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftDialogViewModelNew;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftReceiverViewModel;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftTabViewModelNew;
import com.bytedance.android.livesdk.log.model.WishComboDataLog;
import com.bytedance.android.livesdk.message.model.n6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.GiftResourceManager;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.common.collect.ImmutableMap;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zg1.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class GiftServiceKt implements IGiftService, com.bytedance.android.live.base.i, dy0.c, com.bytedance.android.scope.o {
    public static final a Companion = null;
    private static long exitRoomClearGiftMemoryMills;
    private final Lazy assetsManager$delegate;
    private int cachedUserConsumeLevel;
    private final Lazy dressGlobalService$delegate;
    private final Lazy enableLeaveRoomCacheRelease$delegate;
    private final Lazy giftListRepository$delegate;
    private LiveRecyclableWidget giftPreviewDebugWidget;
    private ca0.g inRoomService;
    private h12.a mCommentGiftGuideViewFactory;
    private com.bytedance.android.livesdk.gift.platform.business.config.k mGiftConfigFactory;
    private h12.b mGroupLiveFactory;
    private h12.c mGuideDialogFactory;
    private h12.d mGuidePresenterFactory;
    private h12.e mMultiPlayerFactory;

    @Inject
    public Map<String, h12.h> mViewFactoryMap;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ca0.r {
        public final /* synthetic */ n12.f a;

        public b(n12.f r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    private final AssetsService getAssetsManager() {
        return (AssetsService) this.assetsManager$delegate.getValue();
    }

    private final zt0.e getDressGlobalService() {
        return (zt0.e) this.dressGlobalService$delegate.getValue();
    }

    private final boolean getEnableLeaveRoomCacheRelease() {
        return ((Boolean) this.enableLeaveRoomCacheRelease$delegate.getValue()).booleanValue();
    }

    private final GiftListRepository getGiftListRepository() {
        return (GiftListRepository) this.giftListRepository$delegate.getValue();
    }

    public IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        return null;
    }

    public void initGiftEffectDialog() {
    }

    public boolean needFrequencyRoomNotifyMessage() {
        return false;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void unRegisterInRoomService() {
        this.inRoomService = null;
    }

    public boolean allowSendToGuest() {
        boolean r0 = com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
        return com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
    }

    public void cleanGiftDishCache() {
        com.bytedance.android.live.revenue.core.b r0 = com.bytedance.android.live.revenue.core.util.j.C0.a();
        Intrinsics.checkNotNull(r0);
        GiftRoomCleanCacheService r1 = com.bytedance.android.live.revenue.core.util.f.b(r0, GiftRoomCleanCacheService.class);
        com.bytedance.android.livesdk.gift.platform.business.effect.delete.c r2 = r1.f;
        com.bytedance.android.livesdk.gift.platform.business.effect.delete.f r3 = new com.bytedance.android.livesdk.gift.platform.business.effect.delete.f(r1);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        Iterator r4 = ((ArrayList) r2.a).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r4.next()).a(CleanOpportunity.MANUAL_CLEAN_IN_ROOM, r3);
        goto L4
    }

    public void clearGiftExposureCache() {
        HashMap r0 = new HashMap();
        KProperty[] r1 = ay1.b.a;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ay1.b.p0.setValue(null, ay1.b.a[80], r0);
    }

    public void clearMarkResource() {
        AssetsDeleteGlobalService r0 = (AssetsDeleteGlobalService) com.bytedance.android.live.revenue.core.util.f.a(AssetsDeleteGlobalService.class);
        if (r0.b.h1() == false) goto L28;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(r0.e.u);
        if (r1.isEmpty() == false) goto L26;
        long r2 = vh6.c.b(vr2.e.class).w4();
        int r3 = CastIntegerProtector.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date(r2)));
        if (r3 < r0.b.Q0()) goto L12;
        if (r3 > r0.b.K4()) goto L12;
        return;
    L12:
        if (r0.b.U1() == false) goto L29;
        CompositeDisposable r4 = r0.d;
        AssetsService r5 = r0.e;
        r5.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.a() == false) goto L16;
        String r6 = "1";
    L17:
        Pair<String, String> r7 = r5.E();
        tz0.b r8 = tz0.b.a;
        uz0.e r9 = new uz0.e();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r10 = ((uz0.a) r9).b;
        Intrinsics.checkNotNullParameter(r10, "queriesMap");
        Integer r11 = 13;
        String r13 = r11.toString();
        Intrinsics.checkNotNullParameter("download_assets_from", "$this$setTo");
        if (r13 == null) goto L20;
        r10.put("download_assets_from", r13);
    L20:
        Intrinsics.checkNotNullParameter("asset_265_supported", "$this$setTo");
        r10.put("asset_265_supported", r6);
        String r14 = String.valueOf(g02.a.e());
        Intrinsics.checkNotNullParameter("is_living", "$this$setTo");
        if (r14 == null) goto L23;
        r10.put("is_living", r14);
    L23:
        if (r7 == null) goto L25;
        Map r15 = ((uz0.a) r9).a;
        Intrinsics.checkNotNullParameter(r15, "headersMap");
        String r16 = (String) r7.first;
        String r17 = (String) r7.second;
        Intrinsics.checkNotNullParameter(r16, "$this$setTo");
        Intrinsics.checkNotNullParameter(r17, "value");
        r15.put(r16, r17);
    L25:
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        r4.add(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(r8.b(), "/webcast/assets/effects/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.d.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g).map(new com.bytedance.android.livesdk.gift.platform.core.scope.service.i(r5)).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.gift.platform.core.scope.service.b(r0)));
        return;
    L16:
        r6 = "0";
        goto L17
    L29:
        return;
    L26:
        r0.a(r1, CleanDataSource.LOCAL);
        return;
    }

    public Bundle clearOverdueResource() {
        return new Bundle();
    }

    public void clearSensitiveLRUAsset() {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.b r0 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.b.class);
        c1 r1 = (c1) com.bytedance.android.livesdk.gift.platform.business.b.H.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[32]);
        if (r1.b() == false) goto L36;
        int r2 = r1.a();
        long r3 = r1.c();
        PolarisFileWrapper r4 = new PolarisFileWrapper(new AssetsFileCacheFactory().c());
        if (r4.exists() == false) goto L37;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L38;
        Iterator r6 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.b.a(r5, r3).iterator();
        int r7 = 0;
    L13:
        if (r6.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.l r8 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r6.next();
        if (r7 >= (r2 - 1)) goto L24;
        String r9 = r8.e;
        if (r9.length() <= 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L13;
        PolarisFileWrapper r11 = new PolarisFileWrapper(r9);
        if (r11.exists() == false) goto L13;
        com.bytedance.android.live.revenue.common.c0.b(r11);
        int r13 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(0, r8.f, r8.c, "lru_clean", null, null, null, 112);
        r7 = r7 + 1;
        goto L13
    L19:
        r10 = false;
    L24:
        if (r7 <= 0) goto L35;
        d0.i(r7, 5);
        return;
    L35:
        return;
    L38:
        return;
    L37:
        return;
    }

    public void closeGiftDialog() {
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
    }

    public ca0.c getCommonPlayerControllerManager() {
        return (CommonPlayerControllerManager) CommonPlayerControllerManager.b.getValue();
    }

    public LiveRecyclableWidget getGestureGiftGuideWidget() {
        return new GestureGiftGuideWidget();
    }

    public LiveRecyclableWidget getGiftEffectInfoLynxWidget() {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.R.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[42])).booleanValue() == false) goto L6;
        return new GiftEffectOperationLayerWidget();
    L6:
        return new GiftEffectInfoLynxWidget();
    }

    public LiveRecyclableWidget getGiftFourthLineWidget() {
        return new GiftFourthLineCardWidget();
    }

    public LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget() {
        return new GiftEffectFrontSeatLayerWidget();
    }

    public List<zo2.a> getGiftNitaViewList() {
        ArrayList r0 = new ArrayList();
        r0.add(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_FAST_V3);
        return r0;
    }

    public Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget() {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.J.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[34])).booleanValue() == false) goto L7;
        return DebugGiftPreviewDebugWidget.class;
    L7:
        if (((Boolean) ay1.b.J.getValue(null, ay1.b.a[41])).booleanValue() == false) goto L9;
        return DebugAssetPreviewDebugWidget.class;
    L9:
        return DebugGiftPreviewDebugWidget.class;
    }

    public LiveRecyclableWidget getGiftTouchReceiveWidget() {
        return new GiftTouchReceiveWidget();
    }

    public int getGiftUseDiskCacheSize() {
        return (int) ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.c) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.effect.delete.c.class)).a();
    }

    public final Map<String, h12.h> getMViewFactoryMap() {
        Map<String, h12.h> r0 = this.mViewFactoryMap;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewFactoryMap");
    L5:
        return r0;
    }

    public Widget getMatchRoomGiftTrayWidget() {
        OpenDialogService r1 = getOpenDialogService();
        if (r1 == null) goto L5;
        i12.e r2 = r1.g;
    L7:
        return new MatchRoomGiftTrayWidget(r2);
    L5:
        r2 = null;
        goto L7
    }

    public Class<? extends Widget> getMultiPlayerClass() {
        h12.e r0 = this.mMultiPlayerFactory;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provider();
    }

    public LiveRecyclableWidget getPKBattlePropEffectWidget() {
        return new PKBattlePropEffectWidget();
    }

    public LiveRecyclableWidget getPKTrayWidget() {
        return new PKTrayWidget();
    }

    public long getSensitiveClearAssetSize() {
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.b r0 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.b.class);
        c1 r1 = (c1) com.bytedance.android.livesdk.gift.platform.business.b.H.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[32]);
        long r2 = 0;
        if (r1.b() == false) goto L19;
        int r3 = r1.a();
        long r4 = r1.c();
        PolarisFileWrapper r6 = new PolarisFileWrapper(new AssetsFileCacheFactory().c());
        if (r6.exists() == false) goto L19;
        File[] r5 = r6.listFiles();
        if (r5 == null) goto L19;
        Iterator r7 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.b.a(r5, r4).iterator();
        int r8 = 0;
    L13:
        if (r7.hasNext() == false) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.l r9 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.l) r7.next();
        if (r8 >= (r3 - 1)) goto L19;
        PolarisFileWrapper r10 = new PolarisFileWrapper(r9.e);
        if (r10.exists() == false) goto L13;
        r8 = r8 + 1;
        r2 = r2 + com.bytedance.android.live.revenue.common.c0.a(r10);
    L19:
        return r2;
    }

    public List<h1> getStickerGifts() {
        h1 r0 = GiftManagerKt.a;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L17;
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        GiftManagerKt.z.getClass();
        List r3 = GiftManagerKt.t();
        if (r3 == null) goto L11;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r2.addAll(((w1) r4.next()).getGifts());
    L11:
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L24;
        h1 r6 = (h1) r5.next();
        if (r6.getType() != 4) goto L13;
        r1.add(r6);
        goto L13
    L24:
        return r1;
    L17:
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).getStickerGifts();
    }

    public LiveRecyclableWidget getTopAtmosphereEffectWidget() {
        return new TopAtmosphereWidget();
    }

    public ca0.q getUICanvasMonitor() {
        return new g0();
    }

    public int getUserConsumeLevel() {
        int r0 = this.cachedUserConsumeLevel;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = ay1.b.u();
        if (r1 < 0) goto L8;
        this.cachedUserConsumeLevel = r1;
    L8:
        return r1;
    }

    public boolean hasExpiredPKPropCard() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, PropListService.class);
    L6:
        PropListService r2 = (PropListService) r1;
        if (r2 == null) goto L10;
        Iterable r3 = r2.a;
        if (r3 == null) goto L10;
    L11:
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L22;
        l2 r5 = (l2) r4.next();
        if (r5.getPropType() != 1) goto L13;
        if (r5.getPropDefSubType() != 1) goto L13;
        if (r5.getSetGray() == true) goto L13;
        return true;
    L22:
        return false;
    L10:
        r3 = new ArrayList();
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public boolean hasPKPropCard() {
        HashMap r0 = (HashMap) ay1.b.u0.getValue(null, ay1.b.a[87]);
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L17;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L17;
        String r3 = String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b()));
        com.bytedance.live.datacontext.m r4 = r2.getRoom();
        if (r4 == null) goto L17;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L17;
        String r6 = r5.getAnchorId();
        if (r6 == null) goto L17;
        Boolean r7 = (Boolean) r0.get(r3 + '-' + r6);
        if (r7 == null) goto L17;
        return r7.booleanValue();
    L17:
        return false;
    }

    public boolean isGiftListLoaded() {
        GiftManagerKt.z.getClass();
        return GiftManagerKt.A();
    }

    public Observable<JSONObject> observeGiftMsgContent() {
        return vh6.c.b(ez0.b.class).observeGiftMsgContent();
    }

    public void removeMonkeyGameEngine() {
        if (com.bytedance.android.livesdk.gift.platform.core.manager.t.a == null) goto L5;
    L14:
        com.bytedance.android.livesdk.gift.platform.core.manager.t.a.getClass();
        return;
    L5:
        monitor-enter(com.bytedance.android.livesdk.gift.platform.core.manager.t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.android.livesdk.gift.platform.core.manager.t.a != null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.manager.t.a = new com.bytedance.android.livesdk.gift.platform.core.manager.t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.livesdk.gift.platform.core.manager.t.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void syncMultiAnchorList() {
        ca0.g r0 = this.inRoomService;
        if (r0 == null) goto L6;
        r0.syncMultiAnchorList();
        return;
    }

    public GiftServiceKt() {
        mz1.a.C0251a r0 = mz1.a.a();
        this.mViewFactoryMap = ImmutableMap.of("fast_gift", FastGiftModule_ProvideFastGiftViewFactory.provideFastGiftView(r0.e));
        setMGuideDialogFactory(GuideModule_ProvideGuideDialogFactory.provideGuideDialog(r0.o));
        setMGuidePresenterFactory(GuideModule_ProvideGuidePresenterFactory.provideGuidePresenter(r0.o));
        setMCommentGiftGuideViewFactory(CommentModule_ProviderCommentGuideViewFactory.providerCommentGuideView(r0.p));
        setMMultiPlayerFactory(MultiPlayerModule_ProviderMultiPlayerClassFactory.providerMultiPlayerClass(r0.q));
        setMGroupLiveFactory(GroupLiveModule_ProviderGroupLiveContainerServiceFactory.providerGroupLiveContainerService(r0.r));
        this.assetsManager$delegate = LazyKt.lazy(GiftServiceKt$assetsManager$2.INSTANCE);
        this.giftListRepository$delegate = LazyKt.lazy(GiftServiceKt$giftListRepository$2.INSTANCE);
        this.dressGlobalService$delegate = LazyKt.lazy(GiftServiceKt$dressGlobalService$2.INSTANCE);
        this.enableLeaveRoomCacheRelease$delegate = LazyKt.lazy(GiftServiceKt$enableLeaveRoomCacheRelease$2.INSTANCE);
        this.cachedUserConsumeLevel = -1;
    }

    private final void ensurePcdnLoaded() {
        if (h.f() == true) goto L5;
        return;
    L5:
        if (vh6.c.b(wh6.a.class).isDeepCleanDowngrade() == false) goto L8;
        return;
    L8:
        if (c12.j.b() == false) goto L10;
        return;
    L10:
        if (c12.j.b() == true) goto L19;
        Application r0 = jc1.a.b();
        if (r0 == null) goto L20;
        com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class).r8(RevHostPluginType.LivePcdnDouyin).a(r0.getApplicationContext(), new c12.i());
        return;
    L20:
        return;
    }

    private final OpenDialogService getOpenDialogService() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, OpenDialogService.class);
    L7:
        return (OpenDialogService) r1;
    L5:
        r1 = null;
        goto L7
    }

    public void clearBattlePropCardMessageQueue() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, i3.class);
    L6:
        i3 r2 = (i3) r1;
        if (r2 == null) goto L12;
        List<n6> r3 = r2.a;
        if (r3 == null) goto L13;
        ((ArrayList) r3).clear();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void clearGiftMemoryCache() {
        if (getEnableLeaveRoomCacheRelease() == true) goto L14;
        return;
    L14:
        getAssetsManager().clearGiftMemoryCache();     // Catch: Throwable -> L11
        getGiftListRepository().clearGiftMemoryCache();     // Catch: Throwable -> L11
        getDressGlobalService().clearGiftMemoryCache();     // Catch: Throwable -> L11
        boolean r0 = true;
        kotlin.Pair[] r1 = new kotlin.Pair[1];     // Catch: Throwable -> L11
        if (exitRoomClearGiftMemoryMills == 0) goto L9;
        r0 = false;
    L9:
        r1[0] = TuplesKt.to("is_first_clear", String.valueOf(r0));     // Catch: Throwable -> L11
        Map r2 = MapsKt.mutableMapOf(r1);     // Catch: Throwable -> L11
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L11
        exitRoomClearGiftMemoryMills = r3;     // Catch: Throwable -> L11
        r2.put("clear_mills", String.valueOf(r3));     // Catch: Throwable -> L11
        com.bytedance.android.livesdk.gift.platform.core.utils.h.p(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        jy0.b.c("GiftServiceKt", "clearGiftMemoryCache exception: " + Log.getStackTraceString(th), null, 4);
    }

    /* JADX INFO: renamed from: getAssetsManager, reason: collision with other method in class */
    public IAssetsManager m270getAssetsManager() {
        return getAssetsManager();
    }

    public IBaseUser getDefaultUserToSendGift() {
        GiftReceiverViewModel r0 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.m();
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a r1 = r0.f();
    L7:
        if ((r1 instanceof com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a.c) == true) goto L9;
        return null;
    L9:
        return ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a.c) r1).b;
    L5:
        r1 = null;
        goto L7
    }

    public Map<String, String> getEventCenterCommonParams() {
        IRoom r0 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return MapsKt.mutableMapOf(new kotlin.Pair[]{TuplesKt.to("room_id", String.valueOf(r0.getRoomId()))});
    }

    public h1 getFastGift() {
        return GiftManagerKt.p();
    }

    public List<zo2.a> getGiftPanelNitaViewList() {
        return ArraysKt.toList(GiftPanelNitaViewInfo.values());
    }

    public ca0.i getGiftRenderFilterWrapper() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<ca0.i> r1 = r0.getGiftRenderFilterWrapper();
        if (r1 == null) goto L7;
        return (ca0.i) r1.getValue();
    L7:
        return null;
    }

    public BehaviorSubject<Long> getGiftSelectObservable() {
        OpenDialogService r0 = getOpenDialogService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public boolean getGiftTraySwitch() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getNeedShowGiftTraySwitch();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public ca0.r getGiftUIStrategy() {
        return new b(n12.e.a());
    }

    public ca0.l getGiftWallPreRequestManager() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftWallPreRequestManager.class);
    L7:
        return (ca0.l) r1;
    L5:
        r1 = null;
        goto L7
    }

    public List<IBaseUser> getGroupMemberList() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftReceiverRepoService.class);
    L6:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r3 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) r2.b).get(7);
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.a;
    L12:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public int getGroupMemberNum() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftReceiverRepoService.class);
    L6:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j r3 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.j) ((LinkedHashMap) r2.b).get(7);
        if (r3 == null) goto L15;
        List<IBaseUser> r4 = r3.a;
        if (r4 != null) goto L13;
        return 0;
    L13:
        return r4.size();
    L15:
        return 0;
    L14:
        return 0;
    L5:
        r1 = null;
        goto L6
    }

    public boolean getIsNewGiftPanel() {
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e();
    }

    public long getLastEnterRoomTime() {
        return SharedPrefHelper.b(s1.getContext()).i("last_enter_room_time", 0);
    }

    public boolean getNeedShowGiftEffectSwitch() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getNeedShowGiftEffectSwitch();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return true;
    }

    public long getSendGiftMoney() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r1 = r0.getSendGiftMoney();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    public long getSendGiftTime() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r1 = r0.getSendGiftTime();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    public WishComboDataLog getWishComboDataMap() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<WishComboDataLog> r1 = r0.getWishComboDataLog();
        if (r1 == null) goto L9;
        WishComboDataLog r2 = (WishComboDataLog) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new WishComboDataLog();
    }

    public ILiveGiftPlayControllerManager giftPlayControllerManager() {
        return com.bytedance.android.livesdk.gift.platform.business.effect.player.i.a();
    }

    public void initGiftResourceCache() {
        if (com.bytedance.android.livesdk.gift.platform.business.i.b().getEnable() == false) goto L8;
        cy0.e.a.getClass();
        if (com.bytedance.android.scope.l.b(cy0.e.a.a) == false) goto L9;
        ((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).x();
        return;
    L9:
        return;
    }

    public Observable<Unit> onDialogHide() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.k<Unit> r1 = r0.getGiftDialogCloseEvent();
        if (r1 == null) goto L7;
        return r1.onEvent();
    L7:
        return null;
    }

    public Observable<Boolean> subscribeOnBanner() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r1 = r0.getGiftBannerShowEvent();
        if (r1 == null) goto L7;
        return r1.onEvent();
    L7:
        return null;
    }

    public void syncGiftList() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L5;
        GiftListRepo.g(1);
        return;
    L5:
        GiftManagerKt.H(1);
    }

    public void syncGiftPanel() {
        Object r1 = null;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L10;
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L7;
        r1 = com.bytedance.android.scope.m.e.d(r0, a2.class);
    L7:
        a2 r2 = (a2) r1;
        if (r2 == null) goto L12;
        r2.a(5, BuildConfig.FLAVOR);
        return;
    L12:
        return;
    L10:
        GiftStateMachineConfig.Event.v r3 = new GiftStateMachineConfig.Event.v(false, true, 5, true);
        r3.b = new GiftStateMachineConfig.c(null, 63);
        com.bytedance.android.livesdk.gift.util.b.f(r3);
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.y.b);
    }

    public static final /* synthetic */ long access$getExitRoomClearGiftMemoryMills$cp() {
        return exitRoomClearGiftMemoryMills;
    }

    public Class<? extends Widget> getGiftWidgetClass() {
        return GiftWidgetKt.class;
    }

    public final ca0.g getInRoomService() {
        return this.inRoomService;
    }

    public ca0.o getLiveRevenueEventCenter() {
        return da0.a.b;
    }

    public final h12.a getMCommentGiftGuideViewFactory() {
        return this.mCommentGiftGuideViewFactory;
    }

    public final com.bytedance.android.livesdk.gift.platform.business.config.k getMGiftConfigFactory() {
        return this.mGiftConfigFactory;
    }

    public final h12.b getMGroupLiveFactory() {
        return this.mGroupLiveFactory;
    }

    public final h12.c getMGuideDialogFactory() {
        return this.mGuideDialogFactory;
    }

    public final h12.d getMGuidePresenterFactory() {
        return this.mGuidePresenterFactory;
    }

    public final h12.e getMMultiPlayerFactory() {
        return this.mMultiPlayerFactory;
    }

    public static final /* synthetic */ void access$setExitRoomClearGiftMemoryMills$cp(long r0) {
        exitRoomClearGiftMemoryMills = r0;
    }

    public void addGiftSendResultListener(ca0.s r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.i<Set<ca0.s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L13;
        Set r3 = (Set) r1.getValue();
        if (r3 == null) goto L14;
        r3.add(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    public boolean checkGroupContainerType(int r2) {
        h12.b r0 = this.mGroupLiveFactory;
        if (r0 == null) goto L7;
        wy1.a r1 = r0.provider();
        if (r1 == null) goto L7;
        return r1.a(r2);
    L7:
        return false;
    }

    public long clearAppAssetDir(boolean r15) {
        boolean r0 = AssetsUtils.b;
        String r1 = new AssetsFileCacheFactory().c();
        int r2 = com.bytedance.android.livesdk.gift.platform.core.b.a;
        if (r1 != null) goto L26;
    L7:
        long r3 = 0;
    L8:
        if (r15 == true) goto L10;
    L24:
        return r3;
    L10:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.F.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[30])).booleanValue() == false) goto L24;
        com.bytedance.android.live.revenue.common.c0.b(new PolarisFileWrapper(r1));
        boolean r16 = d0.a;
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("status", 0);
        r17.put("consume_level", Integer.valueOf(ay1.b.u()));
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("dir_size", Long.valueOf(r3));
        LinkedHashMap r5 = new LinkedHashMap();
        String r6 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_user_clean_appaset");
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r10, "metric");
        EventModule r7 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r7, "eventModule");
        String r8 = r7.getValue();
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r17, "value");
        Iterator r18 = r17.entrySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L15;
        Map.Entry r13 = (Map.Entry) r18.next();
        r9.put((String) r13.getKey(), r13.getValue());
        goto L13
    L15:
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r4, "value");
        Iterator r19 = r4.entrySet().iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        Map.Entry r14 = (Map.Entry) r19.next();
        r10.put((String) r14.getKey(), r14.getValue());
        goto L17
    L19:
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r5, "value");
        Iterator r110 = r5.entrySet().iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        Map.Entry r20 = (Map.Entry) r110.next();
        r11.put((String) r20.getKey(), r20.getValue());
        goto L21
    L23:
        cy0.e.a.getClass();
        cy0.j r21 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r21).b(n97.a.class);
        Intrinsics.checkNotNull(r111);
        ((com.bytedance.live.kmp.core.c) r111).g(r6, r8, "bussiness_api_call", r9, r10, r11);
        goto L24
    L26:
        r3 = com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class).l4(r1);     // Catch: Exception -> L25
        goto L8
    }

    public void clearAssets(String r1) {
        if (getAssetsManager().D == false) goto L8;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 == null) goto L9;
        r2.clear();
        return;
    L9:
        return;
    }

    public void convertHonorImageModel(py.k r6) {
        RevenueImageUrlService r0 = (RevenueImageUrlService) com.bytedance.android.live.revenue.core.util.f.a(RevenueImageUrlService.class);
        if (r6 == null) goto L32;
        List r1 = r6.getUrls();
        if (r1 == null) goto L33;
        String r2 = (String) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L37;
        int r3 = RevenueImageUrlService.c;
        String r4 = RevenueImageUrlService.a.a(r2);
        if (r4 == null) goto L38;
        Iterator r5 = ((List) r0.b.getValue()).iterator();
    L13:
        List<String> r7 = null;
        if (r5.hasNext() == false) goto L18;
        Object r8 = r5.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.r) r8).b(r4) == false) goto L13;
    L19:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.r r9 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.r) r8;
        if (r9 == null) goto L34;
        List<String> r10 = r9.a(r6.getUrls());
        if (r10 != null) goto L24;
        return;
    L24:
        if ((!r10.isEmpty()) == false) goto L26;
        r7 = r10;
    L26:
        if (r7 == null) goto L36;
        r6.setUrls(CollectionsKt.filterNotNull(r7));
        return;
    L36:
        return;
    L34:
        return;
    L18:
        r8 = null;
        goto L19
    L38:
        return;
    L37:
        return;
    L33:
        return;
    }

    public List<String> convertRichContentImageUrls(List<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "urls");
        RevenueImageUrlService r1 = (RevenueImageUrlService) com.bytedance.android.live.revenue.core.util.f.a(RevenueImageUrlService.class);
        Intrinsics.checkNotNullParameter(r6, "urls");
        String r0 = (String) CollectionsKt.firstOrNull(r6);
        if (r0 == null) goto L23;
        int r3 = RevenueImageUrlService.c;
        String r2 = RevenueImageUrlService.a.a(r0);
        if (r2 == null) goto L24;
        Iterator r4 = ((List) r1.b.getValue()).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.r) r5).b(r2) == false) goto L10;
    L15:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.r r7 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.r) r5;
        if (r7 != null) goto L18;
        return null;
    L18:
        return r7.a(r6);
    L14:
        r5 = null;
        goto L15
    L24:
        return null;
    L23:
        return null;
    }

    public h1 findGiftById(long r2) {
        return GiftManagerKt.j(r2, null);
    }

    public com.bytedance.android.livesdk.gift.model.g0 findGiftExtraInfo(long r5) {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.q(r5);
    L5:
        r1 = null;
        goto L6
    }

    public h2 findLiteGiftById(long r1) {
        return GiftManagerKt.l(r1);
    }

    public BaseCommentGiftGuideView getCommentGiftGuideView(Context r2) {
        if (r2 == null) goto L6;
        h12.a r0 = this.mCommentGiftGuideViewFactory;
        if (r0 == null) goto L6;
        return r0.a(r2);
    L6:
        return null;
    }

    public ca0.b getGiftAnimationEngine(GiftType r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(r2);
    }

    public ga0.a getGiftGuidePresenter(DataCenter r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        h12.d r1 = this.mGuidePresenterFactory;
        if (r1 != null) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNull(r1);
        return r1.a(r3);
    }

    public am2.f0 getSendGiftResultLog(p2 r19) {
        Intrinsics.checkNotNullParameter(r19, "result");
        int r2 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        Intrinsics.checkNotNullParameter(r19, "result");
        Intrinsics.checkNotNullParameter(r19, "result");
        h2 r6 = GiftManagerKt.l(r19.getGiftId());
        if (r6 == null) goto L5;
        int r1 = r6.getDiamondCount();
    L6:
        long r4 = r19.getGiftId();
        long r7 = r19.getPropId();
        l2 r9 = r19.getProp();
        r19.getSendType();
        return new am2.f0(r4, r6, r7, r9, r19.getComboCount(), r19.getComboCount() * r19.getGroupCount(), r19.getGroupCount(), r1);
    L5:
        r1 = 0;
        goto L6
    }

    public void initGiftResourceManager(Context r5) {
        ensurePcdnLoaded();
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_CORE_DOWNLOAD_ENSURE_INIT_IN_SDK, Boolean.FALSE)).booleanValue() == true) goto L5;
    L8:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d.a r6 = new com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d.a(new c12.t(), new AssetsFileCacheFactory());
        r6.d = 5;
        r6.c = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_CORE_DOWNLOAD_RES_MAX_TASK_COUNT, 3)).intValue();
        r6.e = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[20])).booleanValue();
        ((Boolean) com.bytedance.android.livesdk.gift.platform.business.i.h.getValue(null, com.bytedance.android.livesdk.gift.platform.business.i.a[6])).booleanValue();
        Lazy r0 = GiftResourceManagerFactory.a;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r1 = new com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d(r6);
        Intrinsics.checkNotNullParameter(r1, "config");
        if (((com.bytedance.android.livesdk.gift.configmodel.z) GiftResourceManagerFactory.a.getValue()).getEnable() == false) goto L14;
        NewGiftResourceManager r2 = NewGiftResourceManager.m;
        Intrinsics.checkNotNullParameter(r1, "config");
        if (NewGiftResourceManager.m != null) goto L18;
        NewGiftResourceManager.m = new NewGiftResourceManager(r1);
    L18:
        ((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).x();
        return;
    L14:
        GiftResourceManager r3 = GiftResourceManager.h;
        Intrinsics.checkNotNullParameter(r1, "config");
        if (GiftResourceManager.h != null) goto L18;
        GiftResourceManager.h = new GiftResourceManager(r1);
        goto L18
    L5:
        if (c12.d.a == true) goto L8;
        Downloader.init(new DownloaderBuilder(r5).httpService(new c12.k()));
        c12.d.a = true;
        goto L8
    }

    public boolean isVSGiftIconShow(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.live.revenue.core.a r4 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r4 == null) goto L12;
        n01.a r5 = com.bytedance.android.live.revenue.core.util.f.c(r4, n01.a.class);
        if (r5 == null) goto L12;
        IEpisode r6 = r5.Xc();
        if (r6 == null) goto L12;
        IRoomAuthStatus r7 = r6.getRoomAuthStatus();
    L13:
        if (r7 == null) goto L15;
        boolean r8 = r7.getEnableGift();
    L16:
        if (r8 == true) goto L18;
        return false;
    L18:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.t() == false) goto L22;
        return true;
    L22:
        return false;
    L15:
        r8 = false;
    L12:
        r7 = null;
        goto L13
    }

    public void notifyLowPriorityDownloadTask(boolean r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        if (r2 == false) goto L7;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r3 = GiftResourceManagerFactory.a();     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        r3.j();     // Catch: Throwable -> L13
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(r4);     // Catch: Throwable -> L13
        return;
    L10:
        r4 = null;
        goto L11
    L7:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r5 = GiftResourceManagerFactory.a();     // Catch: Throwable -> L13
        if (r5 == null) goto L10;
        r5.k();     // Catch: Throwable -> L13
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public void openGiftDialog(int r8) {
        openGiftDialog(r8, -1, BuildConfig.FLAVOR, null, null);
    }

    public void openGroupLiveDialog(String r2) {
        ca0.g r0 = this.inRoomService;
        if (r0 == null) goto L8;
        if (r2 != null) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        r0.openGroupLiveDialog(r2);
        return;
    }

    public void receiveBattleDrawPropCardMessage(n6 r4) {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftMessageService.class);
    L6:
        GiftMessageService r2 = (GiftMessageService) r1;
        if (r2 == null) goto L15;
        IRoom r3 = r2.i;
        if (r3 == null) goto L16;
        if (r4 == null) goto L17;
        w0.b(r3.getId());
        i3 r5 = r2.F;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "msg");
        ((ArrayList) r5.a).add(r4);
        r5.a();
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void receiveStickGiftMSgEvent(o7 r3) {
        v12.f.M(r3, true, false);
    }

    public void registerGiftPreviewDebugWidgetInstance(LiveRecyclableWidget r1) {
        this.giftPreviewDebugWidget = r1;
    }

    public void registerInRoomService(ca0.g r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        this.inRoomService = r2;
    }

    public void registerMonkeyGameEngine(ea0.a r2) {
        if (com.bytedance.android.livesdk.gift.platform.core.manager.t.a == null) goto L5;
    L14:
        com.bytedance.android.livesdk.gift.platform.core.manager.t.a.getClass();
        return;
    L5:
        monitor-enter(com.bytedance.android.livesdk.gift.platform.core.manager.t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.android.livesdk.gift.platform.core.manager.t.a != null) goto L9;
        com.bytedance.android.livesdk.gift.platform.core.manager.t.a = new com.bytedance.android.livesdk.gift.platform.core.manager.t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.livesdk.gift.platform.core.manager.t.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void removeAnimationEngine(GiftType r3) {
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.gift.platform.core.manager.a r0 = com.bytedance.android.livesdk.gift.platform.core.manager.a.b();
        if (((HashMap) r0.a).containsKey(r3) == false) goto L11;
        ca0.b r1 = (ca0.b) ((HashMap) r0.a).get(r3);
        if (r1 == null) goto L8;
        r1.stopAnimation();
        r1.release();
    L8:
        ((HashMap) r0.a).remove(r3);
        return;
    L11:
        return;
    }

    public void removeFastGiftFromMap(long r1) {
        GiftManagerKt.D(Long.valueOf(r1));
    }

    public void removeGiftSendResultListener(ca0.s r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.i<Set<ca0.s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L13;
        Set r3 = (Set) r1.getValue();
        if (r3 == null) goto L14;
        r3.remove(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    public void removeTemporaryFastGift(long r7) {
        h1 r0 = GiftManagerKt.a;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r1 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L10;
        h1 r2 = r1.b;
        if (r2 != null) goto L7;
    L9:
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(r1.a(), 1));
        return;
    L7:
        if (r2.getId() != r7) goto L9;
        r1.b = null;
        goto L9
    L10:
        h1 r3 = GiftManagerKt.a;
        if (r3 != null) goto L13;
    L15:
        xs2.b r8 = xs2.b.a();
        GiftManagerKt.z.getClass();
        r8.post(new com.bytedance.android.livesdk.gift.platform.core.model.c(GiftManagerKt.q(), 1));
        return;
    L13:
        if (r3.getId() != r7) goto L15;
        GiftManagerKt.a = null;
        goto L15
    }

    public void reportStickEffectRenderResult(HashMap<String, String> r1) {
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r1);
        return;
    }

    public void reportStickResourceLoadResult(HashMap<String, String> r1) {
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.b(r1);
        return;
    }

    public void sendPlayAlphaVideoEvent(zg1.h2 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.k<zg1.h2> r1 = r0.getPlayLynxAlphaVideoEvent();
        if (r1 == null) goto L11;
        r1.post(r2);
        return;
    L11:
        return;
    }

    public void setAllowSendToGuest(boolean r2) {
        boolean r0 = com.bytedance.android.livesdk.gift.platform.core.manager.s.a;
        com.bytedance.android.livesdk.gift.platform.core.manager.s.a = r2;
    }

    public void setDefaultUserToSendGift(IBaseUser r2) {
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.a(r2));
    }

    public void setGiftTraySwitch(boolean r3) {
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L12;
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getNeedShowGiftTraySwitch();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r3));
    L9:
        if (r3 == false) goto L13;
        GiftTrayMessageManager r4 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m();
        return;
    L13:
        return;
    }

    public final void setInRoomService(ca0.g r1) {
        this.inRoomService = r1;
    }

    @Inject
    public final void setMCommentGiftGuideViewFactory(h12.a r1) {
        this.mCommentGiftGuideViewFactory = r1;
    }

    public final void setMGiftConfigFactory(com.bytedance.android.livesdk.gift.platform.business.config.k r1) {
        this.mGiftConfigFactory = r1;
    }

    @Inject
    public final void setMGroupLiveFactory(h12.b r1) {
        this.mGroupLiveFactory = r1;
    }

    @Inject
    public final void setMGuideDialogFactory(h12.c r1) {
        this.mGuideDialogFactory = r1;
    }

    @Inject
    public final void setMGuidePresenterFactory(h12.d r1) {
        this.mGuidePresenterFactory = r1;
    }

    @Inject
    public final void setMMultiPlayerFactory(h12.e r1) {
        this.mMultiPlayerFactory = r1;
    }

    public final void setMViewFactoryMap(Map<String, h12.h> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mViewFactoryMap = r2;
    }

    public void setNeedShowGiftEffectSwitch(boolean r4) {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getNeedShowGiftEffectSwitch();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.valueOf(r4));
    L7:
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.k<Boolean> r3 = r2.getToggleVideoGiftView();
        if (r3 == null) goto L13;
        r3.post(Boolean.valueOf(r4));
    L13:
        if (r4 == false) goto L17;
        GiftTrayMessageManager r5 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().m();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[13])).booleanValue() == true) goto L19;
        VideoGiftMsgManagerV2 r6 = VideoGiftWidgetV2.S;
        r6.getClass();
        Intrinsics.checkNotNullParameter("setNeedShowGiftEffectSwitch", "reason");
        r6.l(true, "setNeedShowGiftEffectSwitch");
        r6.i();
        return;
    L19:
        return;
    L17:
        VideoGiftWidgetV2.S.l(false, "setNeedShowGiftEffectSwitch");
    }

    public void setTemporaryFastGift(long r8) {
        h1 r0 = GiftManagerKt.a;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r1 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        w1 r2 = null;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L24;
        GiftManagerKt.z.getClass();
        List r3 = GiftManagerKt.t();
        if (Lists.isEmpty(r3) == true) goto L58;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        w1 r5 = (w1) r4.next();
        if (r5.getPageType() != 1) goto L9;
        r2 = r5;
    L13:
        if (r2 == null) goto L59;
        List<h1> r6 = r2.getGifts();
        if (Lists.isEmpty(r6) == true) goto L60;
        Iterator r7 = new ArrayList(r6).iterator();
    L20:
        if (r7.hasNext() == false) goto L64;
        h1 r9 = (h1) r7.next();
        if (r9.getId() != r8) goto L20;
        r1.b = r9;
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(r9, 1));
        return;
    L64:
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L24:
        GiftManagerKt.z.getClass();
        List r10 = GiftManagerKt.t();
        if (Lists.isEmpty(r10) == true) goto L61;
        Iterator r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L33;
        w1 r13 = (w1) r11.next();
        if (r13.getPageType() != 1) goto L29;
        r2 = r13;
    L33:
        if (r2 == null) goto L62;
        List<h1> r14 = r2.getGifts();
        if (Lists.isEmpty(r14) == true) goto L63;
        Iterator r15 = new ArrayList(r14).iterator();
    L40:
        if (r15.hasNext() == false) goto L65;
        h1 r16 = (h1) r15.next();
        if (r16.getId() != r8) goto L40;
        GiftManagerKt.a = r16;
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(r16, 1));
        return;
    L65:
        return;
    L63:
        return;
    L62:
        return;
    }

    public com.bytedance.android.livesdk.gift.platform.core.model.t startSendMultiGift(com.bytedance.android.livesdk.gift.platform.core.model.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "giftParams");
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(r2);
    }

    public void syncGiftList(int r2) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L5;
        GiftListRepo.g(r2);
        return;
    L5:
        GiftManagerKt.H(r2);
    }

    public void toggleVideoGiftView(boolean r2) {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.k<Boolean> r1 = r0.getToggleVideoGiftView();
        if (r1 == null) goto L9;
        r1.post(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public void triggerGiftAsyncSort(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        ((GiftAsyncSortManager) GiftAsyncSortManager.e.getValue()).a(r3, false);
    }

    public void updateGiftTrayPosition(zg1.f0 r4) {
        ia0.b r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r0 == null) goto L14;
        if (r4 != null) goto L6;
    L8:
        DialogStatus r1 = DialogStatus.DIALOG_CLOSE;
    L9:
        if (r4 == null) goto L11;
        int r5 = r4.a;
    L12:
        r0.Gh(r1, r5);
        return;
    L11:
        r5 = 0;
        goto L12
    L6:
        if (r4.b != true) goto L8;
        r1 = DialogStatus.DIALOG_OPEN;
        goto L9
    }

    public /* bridge */ /* synthetic */ Long clearAppAssetDir(Boolean r3) {
        return Long.valueOf(clearAppAssetDir(r3.booleanValue()));
    }

    /* JADX INFO: renamed from: findGiftExtraInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ m1 m269findGiftExtraInfo(long r1) {
        return findGiftExtraInfo(r1);
    }

    public /* bridge */ /* synthetic */ void notifyLowPriorityDownloadTask(Boolean r1) {
        notifyLowPriorityDownloadTask(r1.booleanValue());
    }

    public void openGiftDialog(String r8) {
        openGiftDialog(0, -1, BuildConfig.FLAVOR, null, null);
    }

    public void openGiftDialog(IBaseUser r2) {
        openGiftDialog(0, r2);
    }

    public com.bytedance.android.live.core.resources.e getAssets(String r1, long r2) {
        return getAssetsManager().G1(r2);
    }

    public String getAssetsPath(String r1, long r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return getAssetsManager().H0(r2);
    }

    public View.OnClickListener getEffectGameToolbarBehavior(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.c.class).P9(new com.bytedance.android.livesdk.gift.platform.business.toolbar.e(r3, r4));
    }

    public uu0.a getGiftTrayPreviewView(Context r9, uu0.b r10) {
        Intrinsics.checkNotNullParameter(r10, "previewData");
        if (r9 != null) goto L7;
        return null;
    L7:
        return new NormalGiftCombViewV2(r9, null, 0, false, r10, 8);
    }

    public boolean isAssetsDownloaded(String r1, long r2) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return getAssetsManager().g1(r2);
    }

    public void openGiftDialog(int r9, IBaseUser r10) {
        if (getOpenDialogService() == null) goto L6;
        int r0 = OpenDialogService.r;
        xs2.b r1 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r1.post(new o3(r10, LocateGiftInfo.a.b(r9), null, BuildConfig.FLAVOR, null));
        return;
    }

    public void playUsePropCardAnimation(py.k r5, kotlin.Pair<Integer, Integer> r6) {
        i12.e r0 = i12.o.b();
        PKBattlePropEffectWidget r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, i3.class);
    L7:
        if (((i3) r2) == null) goto L24;
        if (r5 == null) goto L25;
        if (r6 == null) goto L28;
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n<PKBattlePropEffectWidget> r4 = r3.getPkBattlePropEffectWidget();
        if (r4 == null) goto L16;
        r1 = (PKBattlePropEffectWidget) r4.getValue();
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.m == true) goto L27;
        HSImageView r7 = r1.h;
        if (r7 == null) goto L29;
        r7.setVisibility(8);
        r1.m = true;
        ImageLoader.bindImage(r1.h, r5, -1, -1, new u02.d(r1, r6));
        return;
    L29:
        return;
    L27:
        return;
    L28:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public void playUsePropCardAnimationOnLeftCount(py.k r5, View r6) {
        i12.e r0 = i12.o.b();
        PKBattlePropEffectWidget r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, i3.class);
    L7:
        if (((i3) r2) == null) goto L24;
        if (r5 == null) goto L25;
        if (r6 == null) goto L28;
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n<PKBattlePropEffectWidget> r4 = r3.getPkBattlePropEffectWidget();
        if (r4 == null) goto L16;
        r1 = (PKBattlePropEffectWidget) r4.getValue();
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.m == true) goto L27;
        HSImageView r7 = r1.h;
        if (r7 == null) goto L29;
        r7.setVisibility(8);
        r1.m = true;
        ImageLoader.bindImage(r1.h, r5, -1, -1, new u02.c(r1, r6));
        return;
    L29:
        return;
    L27:
        return;
    L28:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public void processRevenueApiResponse(String r6, JSONObject r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
    L11:
        if (r6 != null) goto L13;
        return;
    L13:
        if (StringsKt.endsWith$default(r6, "/webcast/gift/exhibition/home/", false, 2, null) != true) goto L19;
        ca0.l r8 = getGiftWallPreRequestManager();
        if (r8 == null) goto L20;
        r8.c(r7);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        if (StringsKt.endsWith$default(r6, "/webcast/gift/exhibition/rare/", false, 2, null) != true) goto L11;
        ca0.l r4 = getGiftWallPreRequestManager();
        if (r4 == null) goto L11;
        r4.a(r7);
        goto L11
    }

    public Observable<ExtraResponse<p2, ? extends Extra>> sendGift(com.bytedance.android.livesdk.gift.platform.core.model.b0 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "giftParams");
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.o(r2, r3);
    }

    public Observable<ExtraResponse<m2, Extra>> sendProp(com.bytedance.android.livesdk.gift.platform.core.model.b0 r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "giftParams");
        j1 r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a;
        Intrinsics.checkNotNullParameter(r20, "giftParams");
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L5;
        Object r4 = com.bytedance.android.scope.m.e.d(r3, r3.class);
    L6:
        r3 r14 = (r3) r4;
        if (r14 == null) goto L26;
        Intrinsics.checkNotNullParameter(r20, "giftParams");
        GiftTransaction r0 = r14.d(com.bytedance.android.livesdk.gift.platform.core.model.b0.b(r20, 0, null, 0, null, SendGiftStrategy.ONLY_SEND_ONCE, null, null, null, null, 0, 0, null, null, -16385, 8388607));
        r0.d(r21);
        if (r0.c == false) goto L21;
        com.bytedance.android.livesdk.gift.platform.core.model.y r15 = r0.d;
        if ((r15 instanceof com.bytedance.android.livesdk.gift.platform.core.model.y.c.a.C0067a) == true) goto L13;
        r15 = null;
    L13:
        com.bytedance.android.livesdk.gift.platform.core.model.y.c.a.C0067a r16 = (com.bytedance.android.livesdk.gift.platform.core.model.y.c.a.C0067a) r15;
        if (r16 == null) goto L18;
        ApiException r1 = r16.d;
        if (r1 == null) goto L18;
    L19:
        Observable<ExtraResponse<m2, Extra>> r5 = Observable.error(r1);
    L24:
        if (r5 == null) goto L26;
        return r5;
    L18:
        r1 = new IllegalStateException("Current transaction is disposed");
        goto L19
    L21:
        if (r0.b == false) goto L23;
        jy0.b.c("GiftTransaction", "get observable when transaction disposed, count = " + r0.p, null, 4);
        r5 = Observable.error(new IllegalStateException("Current transaction is disposed"));
        goto L24
    L23:
        r5 = r0.f;
    L26:
        return Observable.error(new IllegalStateException("giftContext is null"));
    L5:
        r4 = null;
        goto L6
    }

    public void setGiftAnimationEngine(GiftType r3, ca0.b r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.gift.platform.core.manager.a r0 = com.bytedance.android.livesdk.gift.platform.core.manager.a.b();
        if (((HashMap) r0.a).containsKey(r3) == true) goto L9;
        ((HashMap) r0.a).put(r3, r4);
        return;
    L9:
        throw new Exception("GiftType " + r3.toString() + " already has been set, or you should call release firstly.");
    }

    public void syncAssetsList(String r2, int r3) {
        if (r2 == null) goto L5;
        getAssetsManager().T2(r3, "giftService");
        return;
    }

    public void unRegisterRecommendReceiver(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x) r1;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "reason");
        r2.a = BuildConfig.FLAVOR;
        jy0.b.c("GiftRecommendReceiverService", "receiver remove success, reason: " + r5, null, 4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void openGiftDialog(IBaseUser r9, Bundle r10) {
        if (getOpenDialogService() == null) goto L6;
        xs2.b r0 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r0.post(new o3(r9, LocateGiftInfo.a.b(0), r10, BuildConfig.FLAVOR, null));
        return;
    }

    public void openGiftDialog(String r1, IBaseUser r2) {
        openGiftDialog(0, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_gift_platform_core_GiftServiceKt_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(UgcGiftSaleDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        UgcGiftSaleDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void initGiftContext(Context r4, final LifecycleOwner r5, final DataCenter r6) {
        if (r4 == null) goto L20;
        if (r5 == null) goto L21;
        if (r6 == null) goto L23;
        final GiftViewModelManager r7 = (GiftViewModelManager) ViewModelProviders.of((FragmentActivity) r4).get(GiftViewModelManager.class);
        final GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 != null) goto L9;
        return;
    L9:
        this.mGiftConfigFactory = new com.bytedance.android.livesdk.gift.platform.business.config.q();
        r0.getGiftViewModelMap().e(new AnonymousClass1(this, r7, r5, r6));
        r0.getGiftPluginActionManager().e(new AnonymousClass2(r0));
        r0.getGiftLazyActionManager().e(AnonymousClass3.INSTANCE);
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.config.j> r8 = r0.getGiftConfigStore();
        com.bytedance.android.livesdk.gift.platform.business.config.k r9 = this.mGiftConfigFactory;
        Intrinsics.checkNotNull(r9);
        r8.d(r9.create());
        r0.isVS().setValue(Boolean.valueOf(com.bytedance.android.livesdk.gift.platform.core.utils.u.p()));
        r0.getRoom().setValue(com.bytedance.android.livesdk.gift.platform.core.utils.x.a());
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == false) goto L16;
        n01.a r10 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r10 == null) goto L14;
        long r11 = r10.getEpisodeId();
    L15:
        r0.getEpisodeId().setValue(Long.valueOf(r11));
        goto L16
    L14:
        r11 = 0;
    L16:
        ca0.g r13 = this.inRoomService;
        if (r13 == null) goto L22;
        r13.j8();
        return;
    L22:
        return;
    L23:
        return;
    L21:
        return;
    }

    private final Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a> initViewModelMap(GiftViewModelManager r4, LifecycleOwner r5, DataCenter r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        r0.put("GiftDialogViewModel", new GiftDialogViewModelNew(r6, r4, r5));
        r0.put("GiftTabViewModel", new GiftTabViewModelNew(r5));
        r0.put("GiftListViewModel", new GiftListViewModelNew(r6, r4, r5));
        r0.put("GiftComboViewModel", new com.bytedance.android.livesdk.gift.vs.panel.statemachine.a(r5));
        r0.put("GiftReceiverViewModel", new GiftReceiverViewModel(r5, r6));
    L5:
        return r0;
    }

    public void autoPlayMP4(String r3, Long r4, String r5) {
        LiveRecyclableWidget r0 = this.giftPreviewDebugWidget;
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r0 instanceof DebugGiftPreviewDebugWidget) == true) goto L8;
        r0 = null;
    L8:
        DebugGiftPreviewDebugWidget r1 = (DebugGiftPreviewDebugWidget) r0;
        if (r1 == null) goto L12;
        r1.wq(r3, r4, r5);
        return;
    }

    public View createView(String r3, Context r4, AttributeSet r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (TextUtils.equals(r3, r4.getString(2131921593)) == false) goto L11;
        Map<String, h12.h> r6 = this.mViewFactoryMap;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mViewFactoryMap");
    L10:
        h12.h r7 = r6.get("fast_gift");
    L12:
        if (r7 != null) goto L14;
        return null;
    L14:
        return r7.a(r4, r5);
    L11:
        r7 = null;
        goto L12
    }

    public o7 getGiftMessage(long r3, p2 r5, IBaseUser r6) {
        Intrinsics.checkNotNullParameter(r5, "result");
        int r1 = com.bytedance.android.livesdk.gift.platform.core.utils.m.a;
        Intrinsics.checkNotNullParameter(r5, "result");
        return com.bytedance.android.livesdk.gift.platform.core.utils.m.e(r3, r5, null, r6);
    }

    public void initGiftModule(Context r1, LifecycleOwner r2, DataCenter r3) {
        initGiftContext(r1, r2, r3);
    }

    public void injectLiveLynxCanvasTTPlayer(LynxView r1, Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        int r4 = com.bytedance.android.livesdk.gift.platform.business.effect.player.j.a;
        Intrinsics.checkNotNullParameter(r3, "bizType");
    }

    public void openGiftDialog(String r4, IBaseUser r5, Bundle r6) {
        if (getOpenDialogService() == null) goto L6;
        xs2.b r0 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r0.post(new o3(r5, LocateGiftInfo.a.b(0), r6, r4));
        return;
    }

    public void openGiftEffectConfigurationDialog(Context r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(r4);
        if (r1 == null) goto L8;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L9;
        int r3 = GiftEffectConfigurationDialog.p;
        Intrinsics.checkNotNullParameter(r4, "context");
        INVOKEVIRTUAL_com_bytedance_android_livesdk_gift_platform_core_GiftServiceKt_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(new GiftEffectConfigurationDialog(r4, r5, r6), r2, "GiftEffectConfigurationDialog");
        return;
    L9:
        return;
    }

    public void updateHotRoomInfo(float r11, double r13, double r14) {
        Object r2 = null;
        if (((y1) h.p.getValue(null, h.a[14])).needReport == true) goto L5;
        return;
    L5:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L60;
        x r1 = (x) r0.getHotRoomInfo().getValue();
        if (r11 >= 0) goto L10;
        r11 = r1.a;
    L10:
        float r5 = r11;
        double r3 = 0;
        if (r13 >= r3) goto L13;
        r13 = r1.b;
    L13:
        double r6 = r13;
        if (r14 >= r3) goto L16;
        r14 = r1.c;
    L16:
        double r8 = r14;
        if (r1.b >= r3) goto L55;
        r0.getHotRoomInfo().setValue(new x(r5, r6, r8));
        i12.e r15 = i12.o.b();
        if (r15 == null) goto L21;
        r2 = com.bytedance.android.scope.m.e.d(r15, g1.class);
    L21:
        g1 r4 = (g1) r2;
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.g.isAnchor() == false) goto L58;
        HashMap r16 = new HashMap();
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L33;
        com.bytedance.live.datacontext.m<x> r18 = r17.getHotRoomInfo();
        if (r18 == null) goto L33;
        x r19 = (x) r18.getValue();
        if (r19 == null) goto L33;
        float r110 = r19.a;
    L34:
        r16.put("deviceTemp", Float.valueOf(r110));
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L41;
        com.bytedance.live.datacontext.m<x> r112 = r111.getHotRoomInfo();
        if (r112 == null) goto L41;
        x r113 = (x) r112.getValue();
        if (r113 == null) goto L41;
        int r114 = (int) r113.b;
    L42:
        r16.put("uiFps", Integer.valueOf(r114));
        GiftContext r115 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r115 == null) goto L49;
        com.bytedance.live.datacontext.m<x> r116 = r115.getHotRoomInfo();
        if (r116 == null) goto L49;
        x r117 = (x) r116.getValue();
        if (r117 == null) goto L49;
        int r118 = (int) r117.c;
    L50:
        r16.put("fps", Integer.valueOf(r118));
        GiftTrayMessageManager r119 = GiftTrayMessageManager.r;
        r16.put("giftQueueSizeSmall", Integer.valueOf(GiftTrayMessageManager.a.a().f()));
        r16.put("giftQueueSizeBig", Integer.valueOf(VideoGiftWidgetV2.S.g()));
        r16.put("platform", 1);
        String r9 = GsonProtectorUtils.toJson(GsonHelper.get(), r16);
        if (Intrinsics.areEqual(r16.get("fps"), -1) == true) goto L59;
        RxUtilKt.c(vh6.c.b(IRevBroadcastService.class).reportRoomEvent(4, r4.g.getRoom().getId(), 5, r9).subscribe(com.bytedance.android.livesdk.gift.platform.core.scope.service.h1.a, i1.a, com.bytedance.android.livesdk.gift.platform.core.scope.service.j1.a), r4.f);
        return;
    L59:
        return;
    L49:
        r118 = -1;
    L41:
        r114 = -1;
    L33:
        r110 = -1.0f;
        goto L34
    L58:
        return;
    L55:
        r0.getHotRoomInfo().setValue(new x(r5, r6, r8));
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_gift_platform_core_GiftServiceKt_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(GiftEffectConfigurationDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        GiftEffectConfigurationDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void openGiftEffectConfigurationDialog(Context r1, Boolean r2, Boolean r3) {
        openGiftEffectConfigurationDialog(r1, r2.booleanValue(), r3.booleanValue());
    }

    public static final /* synthetic */ Map access$initViewModelMap(GiftServiceKt r0, GiftViewModelManager r1, LifecycleOwner r2, DataCenter r3) {
        return r0.initViewModelMap(r1, r2, r3);
    }

    public void downloadAssets(String r1, long r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r4, int r5) {
        if (r1 != null) goto L4;
        return;
    L4:
        getAssetsManager().j4(r2, r4, r5);
    }

    public f6.c getGiftWidget(Context r2, LifecycleOwner r3, DataCenter r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        initGiftContext(r2, r3, r4);
    L5:
        OpenDialogService r6 = getOpenDialogService();
        if (r6 == null) goto L8;
        i12.e r7 = r6.g;
    L10:
        return new GiftWidgetKt(r7, r5);
    L8:
        r7 = null;
        goto L10
    }

    public void registerRecommendReceiver(String r4, String r5, Map<String, String> r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r4, "targetUid");
        Intrinsics.checkNotNullParameter(r5, "reason");
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x) r1;
        if (r2 == null) goto L10;
        r2.c(r4, r5, r6, r7);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void stickFirstFrameEvent(String r1, String r2, JSONObject r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        v12.f.A(r1, r3, r4);
    }

    public void registerRecommendReceiver(long r4, String r6, Map<String, String> r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x) r1;
        if (r2 == null) goto L10;
        r2.c(String.valueOf(r4), r6, r7, r8);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void downloadAssets(String r7, long r8, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r10, int r11, AssetDownloadPriority r13) {
        if (r7 != null) goto L4;
        return;
    L4:
        getAssetsManager().r0(r8, r10, r11, r13);
    }

    public void monitorEffectPlayEvent(EffectMessage r2, String r3, int r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "step");
        v12.f.u(r2, r3, r4, r5, r6);
    }

    public void openGiftDialog(int r13, long r14, Bundle r15, String r16, long r17) {
        openGiftDialogInner(r13, r14, BuildConfig.FLAVOR, r15, 0, null, BuildConfig.FLAVOR, r16, Long.valueOf(r17));
    }

    public void syncGiftList(ca0.w r11, long r13, int r14, boolean r15, String r16) {
        syncGiftListById(r11, r13, r14, r15, r16, 0, false);
    }

    public void monitorEffectPlayEvent(o7 r2, String r3, int r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "giftMessage");
        Intrinsics.checkNotNullParameter(r3, "step");
        v12.f.s(r2, r3, r4, r5, r6);
    }

    public void openGiftDialog(int r10, long r11, String r13, Bundle r14, JSONObject r15) {
        Intrinsics.checkNotNullParameter(r13, "toUserId");
        openGiftDialog(r10, r11, r13, r14, 0, r15);
    }

    public void openGiftDialog(int r13, long r14, Bundle r15, List<String> r16, boolean r17, String r18) {
        if (r17 == false) goto L12;
        if (r16 == null) goto L12;
        i12.e r1 = i12.o.b();
        if (r1 == null) goto L8;
        Object r2 = com.bytedance.android.scope.m.e.d(r1, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L9:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r3 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r2;
        if (r3 == null) goto L12;
        r3.d(r16);
        goto L12
    L8:
        r2 = null;
    L12:
        openGiftDialog(r13, r14, BuildConfig.FLAVOR, r15, 0, null, r18);
    }

    public void openInteractGiftDialog(Context r3, int r4, Long r5, String r6, Function0<Unit> r7, DialogInterface.OnDismissListener r8) {
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        int r1 = UgcGiftSaleDialog.z;
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        UgcGiftSaleDialog r2 = new UgcGiftSaleDialog();
        r2.d = r4;
        r2.r = r5;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.e = r6;
        r2.f = r7;
        r2.n = r8;
        Context r9 = null;
        if (r3 != null) goto L9;
        yz0.k r10 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r10 == null) goto L7;
        r3 = r10.getContext();
        goto L9
    L7:
        r3 = null;
    L9:
        if ((r3 instanceof FragmentActivity) == false) goto L12;
        r9 = r3;
    L12:
        FragmentActivity r11 = (FragmentActivity) r9;
        if (r11 == null) goto L30;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_gift_platform_core_GiftServiceKt_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r2, r11.getSupportFragmentManager(), "LiveInteractGiftDialog");
        yz0.k r13 = com.bytedance.android.livesdk.gift.platform.core.utils.u.h();
        if (r13 == null) goto L31;
        IRoom r14 = r13.getRoom();
        if (r14 == null) goto L32;
        com.bytedance.android.livesdk.gift.platform.core.preview.a r15 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        if (r5 == null) goto L21;
        long r16 = r5.longValue();
    L22:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "room");
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        if ((!Intrinsics.areEqual(r6, "message")) == true) goto L33;
        LinkedHashMap r17 = new LinkedHashMap();
        String r18 = r14.getAnchorId();
        if (r18 != null) goto L28;
        r18 = BuildConfig.FLAVOR;
    L28:
        r17.put("anchor_id", r18);
        r17.put("room_id", String.valueOf(r14.getRoomId()));
        r17.put("event_page", "live");
        r17.put("gift_id", String.valueOf(r16));
        com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_message_click", r17);
        return;
    L33:
        return;
    L21:
        r16 = 0;
        goto L22
    L32:
        return;
    L31:
        return;
    }

    public void openGiftDialog(int r11, long r13, String r14, Bundle r15, int r16, JSONObject r17) {
        Intrinsics.checkNotNullParameter(r14, "toUserId");
        openGiftDialog(r11, r13, r14, r15, r16, r17, BuildConfig.FLAVOR);
    }

    public void openGiftDialog(int r13, long r14, String r16, Bundle r17, int r18, JSONObject r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "toUserId");
        openGiftDialogInner(r13, r14, r16, r17, r18, r19, r20, null, null);
    }

    public void syncGiftListById(ca0.w r30, long r31, int r33, boolean r34, String r35, long r36, boolean r38) {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        List r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = r0.getRoom();
    L7:
        if (r31 > 0) goto L11;
        if (r2 == null) goto L10;
        long r4 = r2.getRoomId();
    L13:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L15;
        GiftManagerKt.I(r30, r4, r33, r34, r35);
        return;
    L15:
        if (r2 != null) goto L17;
    L19:
        int r19 = 0;
    L21:
        if (r36 <= 0) goto L23;
        r1 = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(r36)});
    L23:
        GiftListRepo.k(r30, r4, r4, 1, r33, r34, r35, r35, null, r36, r19, r1, Long.valueOf(r36), null, 0, null, null, r38, 122880);
        return;
    L17:
        if (r2.getRoomId() != r4) goto L19;
        r19 = (int) r2.getRoomLayout();
        goto L21
    L10:
        r4 = 0;
        goto L13
    L11:
        r4 = r31;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ void syncGiftListById(ca0.w r11, long r13, int r14, boolean r15, String r16, Long r17, boolean r18) {
        syncGiftListById(r11, r13, r14, r15, r16, r17.longValue(), r18);
    }

    public Dialog getGiftGuideDialog(Context r14, IRoom r15, IBaseUser r16, ga0.b r17, long r18, String r20, long r21, String r23, DataCenter r24) {
        h12.c r1 = this.mGuideDialogFactory;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        return r1.a(r14, r15, r16, r17, r18, r20, r21, r23, r24);
    L5:
        return null;
    }

    public final void openGiftDialogInner(int r16, long r17, String r19, Bundle r20, int r21, JSONObject r23, String r24, String r25, Long r26) {
        Intrinsics.checkNotNullParameter(r19, "toUserId");
        OpenDialogService r1 = getOpenDialogService();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r25 != null) goto L7;
        String r11 = BuildConfig.FLAVOR;
    L8:
        if (r26 == null) goto L10;
        long r2 = r26.longValue();
    L11:
        OpenDialogService.h(r1, r16, r17, r19, r20, r21, r23, r24, false, r11, r2, 128);
        return;
    L10:
        r2 = -1;
        goto L11
    L7:
        r11 = r25;
        goto L8
    }
}
