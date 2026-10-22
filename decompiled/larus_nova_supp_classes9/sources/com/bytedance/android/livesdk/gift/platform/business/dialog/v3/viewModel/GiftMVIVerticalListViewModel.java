package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.LongSparseArray;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.e0;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.p;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.configmodel.d1;
import com.bytedance.android.livesdk.gift.configmodel.i1;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.c3;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.e2;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.model.z2;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.ai.AiStrategyStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftPanelAssetDownloadDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftScrollDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftBuffCardHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.q0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.BanSendGiftSelfTipsEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeAllMic;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeGiftMostlyUsedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangePinupStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeTopicViewPagerPosition;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeTopicViewPagerPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeViewPagerPosition;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeViewPagerPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClearGiftSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCounterH5Icon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickLynxSeriesCard;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickPinupHintIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchBack;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CloseGiftPanelDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CounterData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DialogPause;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DialogResume;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.EndScrollGiftVerticalPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListChangedByChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftLynxPageConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelDataExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopContractKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.IncrementalRefreshGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.IncrementalUpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemDataType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftAnimShakeFinish;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftCounterItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftCounterVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftExposureAnimShow;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListFirstScreenChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListItemCompletelyVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftListItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGuideItemClick;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnLocateGiftRequestReceived;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenBackpackGiftRecord;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PinTopState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftListSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftMostlyUsedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshMostlyUsedTabPinTopStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshPropList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShakeGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGiftExposureAnim;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGiftMostlyUsedStateChangeToast;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowMostlyUsedPinupPopup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowMostlyUsedTabPinStatusChangeToast;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowProbCountErrorTipsEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowSweepAnim;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftVerticalPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicChangeSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicPagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TryLoadMoreAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateLoadMoreState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePropExpireTime;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ViewPagerPositionChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.VisualStatus;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListFilterService;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftConfirmService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftListPagingService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMostlyUsedDataStore;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.n3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.o2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.utils.b0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.ComboStatus;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.SelectStatus;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIVerticalListViewModel extends com.bytedance.android.anya.f<GiftListViewState, GiftVerticalState, GiftAction> implements o {
    public static final /* synthetic */ int O2 = 0;
    public o0 A;
    public p0 B;
    public final List<l2> C;
    public final Map<Integer, Integer> D;
    public final i0 E;
    public final GiftListSortDataStore E2;
    public final Map<Integer, IntRange> F;
    public final GiftScrollDataStore F2;
    public final Map<Integer, IntRange> G;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b G1;
    public final GiftPanelAssetDownloadDataStore G2;
    public boolean H;
    public final u0 H0;
    public final d0 H1;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f H2;
    public long I;
    public final xz1.c I2;
    public final com.bytedance.android.livesdk.gift.platform.business.config.a J;
    public final GiftSearchDataStore J2;
    public int K;
    public final GiftMostlyUsedDataStore K2;
    public int L;
    public final e1 L0;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i L1;
    public final y L2;
    public final CompositeDisposable M;
    public final GiftListPanelRepository M1;
    public final GiftTabDataStore M2;
    public final Set<Long> N;
    public final n3 N2;
    public long O;
    public Long P;
    public final PropListService P0;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i P1;
    public final Map<Integer, IntRange> Q;
    public final GiftPanelViewPreloadService Q1;
    public final Map<Integer, Map<Integer, IntRange>> R;
    public RefreshGiftListSource S;
    public final GiftDialogStateDataStore S1;
    public GiftTopViewState.Mode T;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f T1;
    public final Lazy U;
    public b V;
    public final o2 V0;
    public final GiftListFilterService V1;
    public final i1 W;
    public final Set<BaseMVIDataStore<?>> X;
    public final LocateGiftInfo Y;
    public final h0 Z;
    public final u1 b1;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c b2;
    public final GiftPanelMonitorService g1;
    public final GiftMVICarnivalDataStore g2;
    public final OpenDialogService h1;
    public final GiftListPagingService h2;
    public final yz0.k k0;
    public final GiftSendPreCheckService k1;
    public final DataCenter p0;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a p1;
    public final GiftGroupCardDataStore p2;
    public final String u;
    public final IRoom v;
    public final r3 v1;
    public final GiftDataStorageService v2;
    public final boolean w;
    public boolean x;
    public final GiftExtraRepo x1;
    public final GiftTopicDataStore x2;
    public final n y;
    public final GiftConfirmService y1;
    public final q0 y2;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h z;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public final int b;
        public final String c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L12;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            String r2 = this.c;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r1 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public final String toString() {
            return "SelectedGiftInfo(giftId=" + this.a + ", pageType=" + this.b + ", source=" + this.c + ")";
        }

        public b(long r2, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((vz1.e) r1).a.getDiamondCount()), Integer.valueOf(((vz1.e) r2).a.getDiamondCount()));
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((vz1.e) r2).a.getDiamondCount()), Integer.valueOf(((vz1.e) r1).a.getDiamondCount()));
        }
    }

    static {
    }

    public final void f2() {
        o0 r0 = this.A;
        long r1 = 0;
        if (r0 == null) goto L7;
        l1 r2 = r0.a;
        if (r2 == null) goto L7;
        long r3 = r2.getBuffGiftId();
    L9:
        if (r3 != 0) goto L14;
        h1 r4 = this.S1.q();
        if (r4 == null) goto L13;
        r1 = r4.getId();
    L13:
        r3 = r1;
    L14:
        Iterator r5 = ((ArrayList) this.H0.c).iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        ((com.bytedance.android.livesdk.gift.platform.business.f) r5.next()).j(r3, Integer.valueOf(this.S1.w()));
        goto L16
    L18:
        return;
    L7:
        r3 = 0;
        goto L9
    }

    public final void onStart() {
        this.y.a();
        this.I = -1;
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.business.b.A;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.business.b.a;
        DiamondConfig r4 = null;
        this.K = ((d1) r0.getValue(null, r1[25])).a();
        this.L = ((d1) r0.getValue(null, r1[25])).b();
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.n.getValue()).booleanValue() == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.config.j r2 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r3 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        r4 = (DiamondConfig) r2.c(r3, DiamondConfig.a.a());
    L5:
        vz1.g.a = r4;
        this.P = this.L1.c.a;
    }

    public final void onStop() {
        K0(new CloseGiftPanelDialog());
        this.M.clear();
        this.I = -1;
        vz1.g.a = null;
    }

    public static boolean K3() {
        if (nz1.a.d().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 42271. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void H3(com.bytedance.android.anya.l0<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState> r56, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState r57, int r58, int r59, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus r60, int r61, java.lang.String r62, int r63, boolean r64) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: MOVE (r11v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r58v0 int) A[DECLARE_VAR] in method: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftMVIVerticalListViewModel.H3(com.bytedance.android.anya.l0<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState>, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState, int, int, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus, int, java.lang.String, int, boolean):void, file: /private/tmp/nixiang/classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 4227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftMVIVerticalListViewModel.H3(com.bytedance.android.anya.l0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState, int, int, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus, int, java.lang.String, int, boolean):void");
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.X;
    }

    public final void n3(l0<GiftVerticalState> r46, GiftVerticalState r47, GiftAction r48) {
        GiftMVIVerticalListViewModel r11 = this;
        Intrinsics.checkNotNullParameter(r46, "$this$reduce");
        Intrinsics.checkNotNullParameter(r47, "state");
        Intrinsics.checkNotNullParameter(r48, "action");
        Integer r4 = null;
        if ((r48 instanceof ChangeReceiver) == false) goto L17;
        ChangeReceiver r1 = (ChangeReceiver) r48;
        if ((!Intrinsics.areEqual(r1.getPreUser().getIdString(), r1.getUser().getIdString())) == false) goto L616;
        String r2 = r1.getPreUser().getIdString();
        if (r2 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        if (r10 == true) goto L616;
        r11.w1(r46, r47, ClearGiftSource.ChangeReceiver);
        r11.I2.a();
        r0.a.a(r11.x1, CollectionsKt.emptyList(), "changeReceiver", null, 12);
        r11.S = RefreshGiftListSource.CHANGE_RECEIVER;
        goto L616
    L9:
        if (r2.length() == 0) goto L12;
        r10 = false;
    L616:
        GiftMVIVerticalListViewModel r3 = r11;
    L1024:
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.d().l8() == true) goto L1027;
    L1029:
        r3.T0(r47, r48);
        return;
    L1027:
        if (m.c(r48) == true) goto L1029;
        return;
    L17:
        if ((r48 instanceof GiftListChangedByChangeReceiver) == false) goto L54;
        GiftTabDataStore r5 = r11.M2;
        vz1.j r6 = (vz1.j) r5.h.getValue(r5, GiftTabDataStore.p[2]);
        List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r7 = r11.P1.n5().a();
        if (r7 == null) goto L40;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        Object r13 = r9.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r13).a() == false) goto L22;
        r8.add(r13);
        goto L22
    L26:
        Iterator r14 = r8.iterator();
        int r15 = 0;
    L28:
        if (r14.hasNext() == false) goto L38;
        int r16 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r14.next()).b();
        if (r6 != null) goto L32;
    L34:
        boolean r17 = false;
    L35:
        if (r17 == true) goto L39;
        r15 = r15 + 1;
    L39:
        Integer r18 = Integer.valueOf(r15);
    L41:
        int r19 = r18.intValue();
        if (r19 != (-1)) goto L47;
        if (r6 == null) goto L45;
        int r20 = r6.a();
    L46:
        r4 = Integer.valueOf(r20);
    L51:
        if (r4 == null) goto L616;
        int r21 = r4.intValue();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r23 = r47.getCurrentPagePosition();
        r46.getClass();
        ((Number) com.bytedance.android.anya.h.b(r23)).intValue();
        e3(this, r46, r47, r21, false, "GiftListChangedByChangeReceiver", true, 8);
        goto L616
    L45:
        r20 = r11.M2.w();
        goto L46
    L47:
        if (r6 != null) goto L49;
    L50:
        r4 = Integer.valueOf(r19);
        goto L51
    L49:
        if (r19 == r6.a()) goto L51;
    L32:
        if (r16 != r6.b()) goto L34;
        r17 = true;
        goto L35
    L38:
        r15 = -1;
        goto L39
    L40:
        r18 = null;
        goto L41
    L54:
        if ((r48 instanceof ChangeAllMic) == false) goto L61;
        ChangeAllMic r24 = (ChangeAllMic) r48;
        if (r24.getPreAllMic() == true) goto L616;
        if (r24.getAllMic() == false) goto L616;
        r11.w1(r46, r47, ClearGiftSource.ChangeReceiver);
        r11.I2.a();
        r0.a.a(r11.x1, CollectionsKt.emptyList(), "changeReceiver", null, 12);
        r11.S = RefreshGiftListSource.CHANGE_RECEIVER;
        goto L616
    L61:
        if ((r48 instanceof ClickTabItem) == false) goto L68;
        r11.x = true;
        if (((ClickTabItem) r48).isFromGuide() == false) goto L616;
        if (v.f() == false) goto L616;
        r11.b1.p0();
        goto L616
    L68:
        if ((r48 instanceof OnGuideItemClick) == false) goto L82;
        r11.b1.p0();
        k0 r25 = r46.b;
        t0<GiftVerticalState, PagerListData> r26 = r47.getPanelList();
        r25.getClass();
        Iterator r27 = k0.c(r26).iterator();
        int r28 = 0;
    L71:
        if (r27.hasNext() == false) goto L79;
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r27.next()).getTabType())).intValue() != ((OnGuideItemClick) r48).getPageType()) goto L75;
        boolean r29 = true;
    L76:
        if (r29 == true) goto L77;
        r28 = r28 + 1;
        goto L71
    L77:
        int r30 = r28;
    L80:
        h3(r46, r47, r30, ((Number) com.bytedance.android.anya.h.b(r47.getCurrentPagePosition())).intValue(), false, "slide");
        goto L616
    L75:
        r29 = false;
        goto L76
    L79:
        r30 = -1;
        goto L80
    L82:
        if ((r48 instanceof UpdatePanelGiftList) == false) goto L85;
        r11.M2.I();
        r11.R2(r46, r47, (UpdatePanelGiftList) r48);
        goto L616
    L85:
        if ((r48 instanceof RefreshGiftList) == false) goto L93;
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().p() == true) goto L89;
    L91:
        r11.O = ((RefreshGiftList) r48).getRequestTime();
        goto L616
    L89:
        if (((RefreshGiftList) r48).getRequestTime() >= r11.O) goto L91;
        return;
    L93:
        if ((r48 instanceof RefreshPropList) == false) goto L146;
        if (com.bytedance.android.livesdk.gift.platform.business.b.i() == true) goto L97;
    L101:
        ((ArrayList) r11.C).clear();
        r11.N2.a();
        RefreshPropList r31 = (RefreshPropList) r48;
        if ((!r31.getPropList().isEmpty()) == false) goto L114;
        Iterator<l2> r33 = r31.getPropList().iterator();
    L105:
        if (r33.hasNext() == false) goto L114;
        l2 r34 = r33.next();
        if (r34.getCount() > 0) goto L111;
        if (r34.getPropType() != 4) goto L105;
    L111:
        if (r34.isDisplayedOnPanel() == false) goto L105;
        ((ArrayList) r11.C).add(r34);
    L114:
        int r35 = r31.getPropList().size();
        if (r31.getUpdate() == true) goto L117;
        r11.M2.I();
        w3(this, r46, r47, r11.M1.Mn(r11.H2.g()), r11.H2.g(), false, 24);
    L117:
        k0 r36 = r46.b;
        t0<GiftVerticalState, PagerListData> r37 = r47.getPanelList();
        r36.getClass();
        List r38 = k0.c(r37);
        ArrayList r39 = new ArrayList();
        Iterator r40 = r38.iterator();
    L119:
        if (r40.hasNext() == false) goto L126;
        Object r41 = r40.next();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r41).getTabType())).intValue() != 5) goto L123;
        boolean r43 = true;
    L124:
        if (r43 == false) goto L119;
        r39.add(r41);
        goto L119
    L123:
        r43 = false;
        goto L124
    L126:
        Iterator r44 = r39.iterator();
        int r110 = 0;
    L128:
        if (r44.hasNext() == false) goto L144;
        PagerListData r45 = (PagerListData) r44.next();
        Iterator r49 = k0.c(r45.getItemDataList()).iterator();
    L131:
        if (r49.hasNext() == false) goto L135;
        if (((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) r49.next()).getItemData())).f() == false) goto L131;
        r110 = r110 + 1;
        goto L131
    L135:
        Iterator r50 = k0.c(r45.getCounterDataList()).iterator();
    L137:
        if (r50.hasNext() == false) goto L128;
        Iterator r51 = k0.c(((CounterData) r50.next()).getItemDataList()).iterator();
    L140:
        if (r51.hasNext() == false) goto L137;
        if (((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) r51.next()).getItemData())).f() == false) goto L140;
        r110 = r110 + 1;
        goto L140
    L144:
        Unit r53 = Unit.INSTANCE;
        GiftPanelMonitorService r54 = r11.g1;
        int r55 = ((ArrayList) r11.C).size();
        IBaseUser r56 = r11.H2.d();
        r54.getClass();
        GiftPanelMonitorService.h(r35, r55, r110, r56);
        r11.h1.j();
        goto L616
    L97:
        if (((RefreshPropList) r48).getPropList().isEmpty() == false) goto L101;
        if (((ArrayList) r11.C).isEmpty() == false) goto L101;
        return;
    L146:
        if ((r48 instanceof UpdatePropExpireTime) == false) goto L149;
        P3(r46, r47, ((UpdatePropExpireTime) r48).getIntervalSecond());
        goto L616
    L149:
        if ((r48 instanceof ChangeViewPagerPosition) == false) goto L152;
        int r57 = ((ChangeViewPagerPosition) r48).getPagerPosition();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r58 = r47.getCurrentPagePosition();
        r46.getClass();
        h3(r46, r47, r57, ((Number) com.bytedance.android.anya.h.b(r58)).intValue(), false, "slide");
        goto L616
    L152:
        if ((r48 instanceof ChangeTopicViewPagerPosition) == false) goto L155;
        ChangeTopicViewPagerPosition r59 = (ChangeTopicViewPagerPosition) r48;
        f3(r46, r47, r59.getTopicPagerPosition(), r59.getParentPagerPosition(), TopicChangeSource.SLIDE, false);
        goto L616
    L155:
        if ((r48 instanceof OpenBackpackGiftRecord) == false) goto L158;
        k3(((OpenBackpackGiftRecord) r48).getContext());
        r11.b1.S0();
        goto L616
    L158:
        if ((r48 instanceof StartScrollGiftVerticalPanel) == false) goto L167;
        com.bytedance.android.anya.u0<GiftVerticalState, GiftComboState> r60 = r47.getComboState();
        r46.getClass();
        if (((ComboState) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r60)).getComboStatus())) == ComboState.IDLE) goto L162;
        u1(r46, r47);
    L162:
        i0 r61 = r11.E;
        StartScrollGiftVerticalPanel r63 = (StartScrollGiftVerticalPanel) r48;
        int r64 = r63.getPagerPosition();
        IntRange r65 = (IntRange) ((LinkedHashMap) r11.F).get(Integer.valueOf(r63.getPagerPosition()));
        if (r65 != null) goto L165;
        r65 = new IntRange(-1, -1);
    L165:
        r61.d(r46, r47, r64, r65);
        Unit r66 = Unit.INSTANCE;
        goto L616
    L167:
        if ((r48 instanceof EndScrollGiftVerticalPanel) == false) goto L173;
        i0 r67 = r11.E;
        EndScrollGiftVerticalPanel r68 = (EndScrollGiftVerticalPanel) r48;
        int r69 = r68.getPagerPosition();
        IntRange r70 = (IntRange) ((LinkedHashMap) r11.F).get(Integer.valueOf(r68.getPagerPosition()));
        if (r70 != null) goto L171;
        r70 = new IntRange(-1, -1);
    L171:
        r67.b(r46, r47, r69, r70);
        Unit r71 = Unit.INSTANCE;
        u1 r73 = r11.b1;
        r73.s1(r73.F() + 1);
        goto L616
    L173:
        if ((r48 instanceof OnGiftListItemVisibleChanged) == false) goto L182;
        IntRange r74 = new IntRange(-1, -1);
        OnGiftListItemVisibleChanged r75 = (OnGiftListItemVisibleChanged) r48;
        IntRange r76 = (IntRange) ((LinkedHashMap) r11.F).get(Integer.valueOf(r75.getPagerPosition()));
        if (r76 != null) goto L177;
        IntRange r77 = r74;
    L178:
        r11.F.put(Integer.valueOf(r75.getPagerPosition()), r75.getCurrentShowRange());
        int r78 = r75.getPagerPosition();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r79 = r47.getCurrentPagePosition();
        r46.getClass();
        if (r78 != ((Number) com.bytedance.android.anya.h.b(r79)).intValue()) goto L616;
        V2(r46, r47, r75.getPagerPosition(), r77, r75.getCurrentShowRange(), r75.getTopicPagerPosition(), r75.getFirstScroll());
        goto L616
    L177:
        r77 = r76;
        goto L178
    L182:
        if ((r48 instanceof OnGiftListItemCompletelyVisibleChanged) == false) goto L191;
        IntRange r80 = new IntRange(-1, -1);
        OnGiftListItemCompletelyVisibleChanged r81 = (OnGiftListItemCompletelyVisibleChanged) r48;
        IntRange r83 = (IntRange) ((LinkedHashMap) r11.G).get(Integer.valueOf(r81.getPagerPosition()));
        if (r83 != null) goto L186;
        IntRange r84 = r80;
    L187:
        r11.G.put(Integer.valueOf(r81.getPagerPosition()), r81.getCurrentShowRange());
        int r85 = r81.getPagerPosition();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r86 = r47.getCurrentPagePosition();
        r46.getClass();
        if (r85 != ((Number) com.bytedance.android.anya.h.b(r86)).intValue()) goto L616;
        S2(r46, r47, r81.getPagerPosition(), r84, r81.getCurrentShowRange());
        goto L616
    L186:
        r84 = r83;
        goto L187
    L191:
        if ((r48 instanceof OnGiftListFirstScreenChanged) == false) goto L194;
        OnGiftListFirstScreenChanged r87 = (OnGiftListFirstScreenChanged) r48;
        r11.F2.o(r87.getPagerPosition(), r87.isFirstScreen());
        goto L616
    L194:
        if ((r48 instanceof ViewPagerPositionChanged) == false) goto L200;
        ViewPagerPositionChanged r88 = (ViewPagerPositionChanged) r48;
        int r89 = r88.getPagerPosition();
        IntRange r90 = new IntRange(-1, -1);
        IntRange r91 = (IntRange) ((LinkedHashMap) r11.G).get(Integer.valueOf(r88.getPagerPosition()));
        if (r91 != null) goto L198;
        r91 = new IntRange(-1, -1);
    L198:
        S2(r46, r47, r89, r90, r91);
        goto L616
    L200:
        if ((r48 instanceof OnGiftCounterVisibleChanged) == false) goto L208;
        OnGiftCounterVisibleChanged r93 = (OnGiftCounterVisibleChanged) r48;
        IntRange r94 = (IntRange) ((LinkedHashMap) r11.Q).get(Integer.valueOf(r93.getPagerPosition()));
        if (r94 != null) goto L204;
        r94 = new IntRange(-1, -1);
    L204:
        r11.Q.put(Integer.valueOf(r93.getPagerPosition()), r93.getCurrentShowRange());
        int r95 = r93.getPagerPosition();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r96 = r47.getCurrentPagePosition();
        r46.getClass();
        if (r95 != ((Number) com.bytedance.android.anya.h.b(r96)).intValue()) goto L616;
        r11.P2(r47, r94, r93.getCurrentShowRange(), r93.getPagerPosition());
        goto L616
    L208:
        if ((r48 instanceof OnGiftCounterItemVisibleChanged) == false) goto L216;
        OnGiftCounterItemVisibleChanged r97 = (OnGiftCounterItemVisibleChanged) r48;
        Map<Integer, IntRange> r98 = (Map) ((LinkedHashMap) r11.R).get(Integer.valueOf(r97.getPagerPosition()));
        if (r98 != null) goto L212;
        r98 = new LinkedHashMap();
    L212:
        Map<Integer, IntRange> r99 = r98;
        r11.R.put(Integer.valueOf(r97.getPagerPosition()), r97.getCounterRangeMap());
        int r100 = r97.getPagerPosition();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r101 = r47.getCurrentPagePosition();
        r46.getClass();
        if (r100 != ((Number) com.bytedance.android.anya.h.b(r101)).intValue()) goto L616;
        J2(r46, r47, r97.getPagerPosition(), r99, r97.getCounterRangeMap());
        goto L616
    L216:
        if ((r48 instanceof OnGiftAnimShakeFinish) == false) goto L221;
        OnGiftAnimShakeFinish r102 = (OnGiftAnimShakeFinish) r48;
        if (r102.isSearch() == true) goto L616;
        J3(this, r46, r47, r102.getPagerPosition(), r102.getPosition(), null, r102.getCounterPosition(), null, r102.getPagerPosition(), 168);
        goto L616
    L221:
        if ((r48 instanceof DialogPause) == false) goto L224;
        i0 r103 = r11.E;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r104 = r47.getCurrentPagePosition();
        r46.getClass();
        r103.a(r46, r47, ((Number) com.bytedance.android.anya.h.b(r104)).intValue());
        Unit r105 = Unit.INSTANCE;
        goto L616
    L224:
        if ((r48 instanceof DialogResume) == false) goto L227;
        i0 r106 = r11.E;
        Map<Integer, IntRange> r107 = r11.F;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r108 = r47.getCurrentPagePosition();
        r46.getClass();
        r106.c(r46, (IntRange) ((LinkedHashMap) r107).get(com.bytedance.android.anya.h.b(r108)));
        Unit r109 = Unit.INSTANCE;
        goto L616
    L227:
        if ((r48 instanceof OnDialogFullyShowed) == false) goto L232;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.d().E0() == false) goto L616;
        i0 r111 = r11.E;
        Map<Integer, IntRange> r112 = r11.F;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r113 = r47.getCurrentPagePosition();
        r46.getClass();
        r111.c(r46, (IntRange) ((LinkedHashMap) r112).get(com.bytedance.android.anya.h.b(r113)));
        Unit r114 = Unit.INSTANCE;
        goto L616
    L232:
        if ((r48 instanceof OnLocateGiftRequestReceived) == false) goto L270;
        OnLocateGiftRequestReceived r115 = (OnLocateGiftRequestReceived) r48;
        if (r115.getLocateGiftInfo().getTargetGiftId() > 0) goto L242;
        if (r115.getLocateGiftInfo().getTargetPageType() == 0) goto L242;
        if (r115.getLocateGiftInfo().getTargetPropDefId() > 0) goto L242;
        r11.w1(r46, r47, ClearGiftSource.ChangeTab);
        r11.V1(r46, r47, r115.getLocateGiftInfo());
    L242:
        if (r11.x == true) goto L244;
    L248:
        r11.z.d(r46, r47, r115.getLocateGiftInfo(), r48.toString());
        Unit r116 = Unit.INSTANCE;
        r r117 = r46.i(r47);
        OnLocateGiftRequestReceived r118 = (OnLocateGiftRequestReceived) r48;
        if (r118.getLocateGiftInfo().getTargetGiftId() <= 0) goto L251;
        boolean r119 = true;
    L253:
        if ((r117 instanceof GiftListBusinessState.GiftSelected) == false) goto L259;
        GiftListBusinessState.GiftSelected r120 = (GiftListBusinessState.GiftSelected) r117;
        int r121 = r120.getSelectedPagePosition();
        ((Number) com.bytedance.android.anya.h.b(r47.getCurrentPagePosition())).intValue();
        e3(this, r46, r47, r121, false, "click", false, 40);
        r11.K0(new ScrollToPositionEffect(r120.getSelectedPagePosition(), r120.getSelectedPosition(), r120.getSelectCounterPosition(), r120.getTopicPagerPosition(), true, false, 32, null));
        long r122 = r118.getLocateGiftInfo().getTargetGiftId();
        vz1.e r123 = r120.getIconModel();
        if (r123 == null) goto L259;
        if (r122 != r123.d()) goto L259;
        int r124 = r120.getSelectedPagePosition();
        boolean r125 = true;
    L260:
        if (r125 == false) goto L267;
        if (r119 == false) goto L267;
        boolean r126 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        long r127 = r118.getLocateGiftInfo().getTargetGiftId();
        Integer r128 = (Integer) ((LinkedHashMap) r11.L0.g()).get(Integer.valueOf(r124));
        if (r128 == null) goto L265;
        int r129 = r128.intValue();
    L266:
        com.bytedance.android.livesdk.gift.platform.core.d0.d(r125, r127, r129, r11.H2.d(), r11.v1.f(r11.H2.g()));
        goto L616
    L265:
        r129 = 0;
    L267:
        if (r119 == false) goto L616;
        boolean r130 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        com.bytedance.android.livesdk.gift.platform.core.d0.d(false, r118.getLocateGiftInfo().getTargetGiftId(), r118.getLocateGiftInfo().getTargetPageType(), r11.H2.d(), r11.v1.f(r11.H2.g()));
    L259:
        r124 = 0;
        r125 = false;
        goto L260
    L251:
        r119 = false;
        goto L253
    L244:
        if (r115.getSource() != 1) goto L248;
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().a() == false) goto L248;
        return;
    L270:
        if ((r48 instanceof RefreshGiftExtra) == false) goto L273;
        RefreshGiftExtra r131 = (RefreshGiftExtra) r48;
        r11.M3(r46, r47, r131.getNeedMarketingAnim(), r131.getGiftIds());
        goto L616
    L273:
        if ((r48 instanceof ClickLynxSeriesCard) == true) goto L275;
        GiftAction r132 = r48;
        if ((r132 instanceof OnGiftExposureAnimShow) == false) goto L530;
        OnGiftExposureAnimShow r133 = (OnGiftExposureAnimShow) r132;
        r11.k2(r46, r47, r133.getPagerPosition(), r133.getItemPosition());
        goto L616
    L530:
        if ((r132 instanceof ClickCounterH5Icon) == false) goto L562;
        int r134 = ((ClickCounterH5Icon) r132).getCounterPosition();
        u r135 = r47.getPanelList();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r136 = r47.getCurrentPagePosition();
        r46.getClass();
        int r137 = ((Number) com.bytedance.android.anya.h.b(r136)).intValue();
        u r138 = r135;
        MVIState r139 = (MVIState) ((s0) r138.c()).get(r137);
        new k0.a();     // Catch: Throwable -> L556
        PagerListData r140 = (PagerListData) r139;     // Catch: Throwable -> L556
        if (r134 >= ((s0) r140.getCounterDataList().c()).size()) goto L554;
        u r141 = r140.getCounterDataList();     // Catch: Throwable -> L556
        u r142 = r141;     // Catch: Throwable -> L556
        MVIState r143 = (MVIState) ((s0) r141.c()).get(r134);     // Catch: Throwable -> L556
        new k0.a();     // Catch: Throwable -> L548
        CounterData r144 = (CounterData) r143;     // Catch: Throwable -> L548
        String r145 = ((vz1.c) r144.getH5EntranceModel().c()).a();     // Catch: Throwable -> L548
        if (r145 != null) goto L538;
    L544:
        r11.b1.L((String) r144.getSectionName().c(), ((s0) r144.getItemDataList().c()).size(), r134 + 1);     // Catch: Throwable -> L548
    L546:
        if ((!r143.modifiedProperties.isEmpty()) == false) goto L554;
        ((t) r141.c()).d(r134);     // Catch: Throwable -> L556
        goto L554
    L538:
        if (r145.length() <= 0) goto L540;
        boolean r146 = true;
    L541:
        if (r146 == false) goto L543;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), r145);     // Catch: Throwable -> L548
    L543:
        Unit r147 = Unit.INSTANCE;     // Catch: Throwable -> L548
        goto L544
    L540:
        r146 = false;
    L548:
        th = move-exception;
        if ((!r143.modifiedProperties.isEmpty()) == false) goto L1208;
        ((t) r141.c()).d(r134);     // Catch: Throwable -> L556
        throw th;     // Catch: Throwable -> L556
    L1208:
        throw th;     // Catch: Throwable -> L556
    L554:
        if ((!r139.modifiedProperties.isEmpty()) == false) goto L616;
        ((t) r138.c()).d(r137);
    L556:
        th = move-exception;
        if ((!r139.modifiedProperties.isEmpty()) == false) goto L1209;
        ((t) r138.c()).d(r137);
        throw th;
    L1209:
        throw th;
    L562:
        if ((r132 instanceof TryLoadMoreAction) == false) goto L618;
        TryLoadMoreAction r148 = (TryLoadMoreAction) r132;
        if (r11.h2.d(r148.getPageType(), r148.getSelectedTopicId()) == true) goto L616;
        if (r11.h2.c(r11.H2.g(), r148.getPageType(), r148.getSelectedTopicId()) == true) goto L615;
        u r149 = r47.getPanelList();
        Iterator r150 = ((Iterable) r149.c()).iterator();
        int r151 = 0;
    L569:
        if (r150.hasNext() == false) goto L616;
        Object r152 = r150.next();
        int r153 = r151 + 1;
        if (r151 >= 0) goto L573;
        CollectionsKt.throwIndexOverflow();
    L573:
        MVIState r154 = (MVIState) r152;
        com.bytedance.android.anya.r0<PagerListData, Integer> r155 = ((PagerListData) r154).getTabType();
        r46.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r155)).intValue() != r148.getPageType()) goto L576;
        boolean r156 = true;
    L577:
        if (r156 == true) goto L1083;
        Iterator r157 = r150;
        int r210 = r153;
    L609:
        r150 = r157;
        r151 = r210;
        goto L569
    L1083:
        new k0.a();     // Catch: Throwable -> L610
        PagerListData r158 = (PagerListData) r154;     // Catch: Throwable -> L610
        u r159 = r158.getItemDataList();     // Catch: Throwable -> L610
        u r160 = r159;     // Catch: Throwable -> L610
        Iterator r161 = ((Iterable) r159.c()).iterator();     // Catch: Throwable -> L610
        int r162 = -1;
        int r163 = 0;
    L581:
        if (r161.hasNext() == false) goto L602;
        Object r164 = r161.next();     // Catch: Throwable -> L610
        int r165 = r163 + 1;     // Catch: Throwable -> L610
        if (r163 >= 0) goto L585;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L610
    L585:
        Iterator r166 = r150;
        MVIState r167 = (MVIState) r164;     // Catch: Throwable -> L610
        int r211 = r153;
        Iterator r168 = r161;
        if (((ItemDataType) ((ItemListData) r167).getItemDataType().c()) != ItemDataType.BOTTOM_LOADING) goto L588;
        boolean r169 = true;
    L589:
        if (r169 == false) goto L596;
        new k0.a();     // Catch: Throwable -> L597
        ItemListData r170 = (ItemListData) r167;     // Catch: Throwable -> L597
    L593:
        if ((!r167.modifiedProperties.isEmpty()) == false) goto L595;
        ((t) r159.c()).d(r163);     // Catch: Throwable -> L610
    L595:
        r162 = r163;
    L597:
        th = move-exception;
        if ((!r167.modifiedProperties.isEmpty()) == false) goto L1210;
        ((t) r159.c()).d(r163);     // Catch: Throwable -> L610
        throw th;     // Catch: Throwable -> L610
    L1210:
        throw th;     // Catch: Throwable -> L610
    L596:
        r161 = r168;
        r163 = r165;
        r150 = r166;
        r153 = r211;
        goto L581
    L588:
        r169 = false;
        goto L589
    L602:
        r157 = r150;
        r210 = r153;
        if (r162 == (-1)) goto L605;
        ((e0) r158.getItemDataList().c()).remove(r162);     // Catch: Throwable -> L610
    L605:
        r158.getHasMoreData().a(Boolean.FALSE);     // Catch: Throwable -> L610
        if ((!r154.modifiedProperties.isEmpty()) == false) goto L609;
        ((t) r149.c()).d(r151);
    L610:
        th = move-exception;
        if ((!r154.modifiedProperties.isEmpty()) == false) goto L1211;
        ((t) r149.c()).d(r151);
        throw th;
    L1211:
        throw th;
    L576:
        r156 = false;
        goto L577
    L615:
        r11.h2.f(r11.H2.g(), r148.getPageType(), r148.getSelectedTopicId());
        goto L616
    L618:
        if ((r132 instanceof UpdateLoadMoreState) == false) goto L727;
        u r171 = r47.getPanelList();
        Iterator r172 = ((Iterable) r171.c()).iterator();
        int r173 = 0;
    L621:
        if (r172.hasNext() == false) goto L725;
        Object r174 = r172.next();
        int r175 = r173 + 1;
        if (r173 >= 0) goto L625;
        CollectionsKt.throwIndexOverflow();
    L625:
        MVIState r176 = (MVIState) r174;
        com.bytedance.android.anya.r0<PagerListData, Integer> r177 = ((PagerListData) r176).getTabType();
        r46.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r177)).intValue() != ((UpdateLoadMoreState) r132).getPageType()) goto L628;
        boolean r178 = true;
    L629:
        if (r178 == true) goto L1072;
        Iterator r179 = r172;
        int r180 = r175;
    L719:
        r11 = this;
        r173 = r180;
        r172 = r179;
        goto L621
    L1072:
        new k0.a();     // Catch: Throwable -> L720
        PagerListData r181 = (PagerListData) r176;     // Catch: Throwable -> L720
        if (((UpdateLoadMoreState) r132).isLoading() == false) goto L634;
    L715:
        r179 = r172;
        r180 = r175;
    L717:
        if ((!r176.modifiedProperties.isEmpty()) == false) goto L719;
        ((t) r171.c()).d(r173);
        goto L719
    L634:
        if (v.h() == true) goto L636;
    L688:
        r179 = r172;
        r180 = r175;
        u r182 = r181.getItemDataList();     // Catch: Throwable -> L720
        u r183 = r182;     // Catch: Throwable -> L720
        Iterator r184 = ((Iterable) r182.c()).iterator();     // Catch: Throwable -> L720
        int r185 = -1;
        int r186 = 0;
    L690:
        if (r184.hasNext() == false) goto L712;
        Object r187 = r184.next();     // Catch: Throwable -> L720
        int r188 = r186 + 1;     // Catch: Throwable -> L720
        if (r186 >= 0) goto L694;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L720
    L694:
        MVIState r189 = (MVIState) r187;     // Catch: Throwable -> L720
        if (((ItemDataType) ((ItemListData) r189).getItemDataType().c()) != ItemDataType.BOTTOM_LOADING) goto L697;
        boolean r190 = true;
    L698:
        if (r190 == false) goto L705;
        new k0.a();     // Catch: Throwable -> L706
        ItemListData r191 = (ItemListData) r189;     // Catch: Throwable -> L706
    L702:
        if ((!r189.modifiedProperties.isEmpty()) == false) goto L704;
        ((t) r182.c()).d(r186);     // Catch: Throwable -> L720
    L704:
        r185 = r186;
    L706:
        th = move-exception;
        if ((!r189.modifiedProperties.isEmpty()) == false) goto L1214;
        ((t) r182.c()).d(r186);     // Catch: Throwable -> L720
        throw th;     // Catch: Throwable -> L720
    L1214:
        throw th;     // Catch: Throwable -> L720
    L705:
        r186 = r188;
        goto L690
    L697:
        r190 = false;
        goto L698
    L712:
        if (r185 == (-1)) goto L717;
        ((e0) r181.getItemDataList().c()).remove(r185);     // Catch: Throwable -> L720
        goto L717
    L636:
        if ((!r11.y2.a(((UpdateLoadMoreState) r132).getPageType()).isEmpty()) == false) goto L688;
        u r192 = r181.getTopicPagerListData();     // Catch: Throwable -> L720
        u r193 = r192;     // Catch: Throwable -> L720
        Iterator r194 = ((Iterable) r192.c()).iterator();     // Catch: Throwable -> L720
        int r195 = -1;
        int r196 = 0;
    L639:
        if (r194.hasNext() == false) goto L715;
        Object r197 = r194.next();     // Catch: Throwable -> L720
        int r198 = r196 + 1;     // Catch: Throwable -> L720
        if (r196 >= 0) goto L643;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L720
    L643:
        MVIState r199 = (MVIState) r197;     // Catch: Throwable -> L720
        r172 = r172;
        int r200 = ((Number) ((TopicPagerListData) r199).getTopicId().c()).intValue();     // Catch: Throwable -> L720
        Long r1100 = ((UpdateLoadMoreState) r132).getTopicId();     // Catch: Throwable -> L720
        if (r1100 == null) goto L649;
        r194 = r194;
        if (r200 != ((int) r1100.longValue())) goto L650;
        boolean r201 = true;
    L651:
        if (r201 == false) goto L652;
        new k0.a();     // Catch: Throwable -> L683
        TopicPagerListData r202 = (TopicPagerListData) r199;     // Catch: Throwable -> L683
        u r203 = r202.getItemDataList();     // Catch: Throwable -> L683
        u r204 = r203;     // Catch: Throwable -> L683
        Iterator r205 = ((Iterable) r203.c()).iterator();     // Catch: Throwable -> L683
        int r1101 = r175;
        int r206 = 0;
    L655:
        if (r205.hasNext() == false) goto L676;
        Object r212 = r205.next();     // Catch: Throwable -> L683
        int r213 = r206 + 1;     // Catch: Throwable -> L683
        if (r206 >= 0) goto L659;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L683
    L659:
        Iterator r214 = r205;
        MVIState r207 = (MVIState) r212;     // Catch: Throwable -> L683
        int r215 = r198;
        if (((ItemDataType) ((ItemListData) r207).getItemDataType().c()) != ItemDataType.BOTTOM_LOADING) goto L662;
        boolean r1102 = true;
    L663:
        if (r1102 == false) goto L670;
        new k0.a();     // Catch: Throwable -> L671
        ItemListData r1103 = (ItemListData) r207;     // Catch: Throwable -> L671
    L667:
        if ((!r207.modifiedProperties.isEmpty()) == false) goto L669;
        ((t) r203.c()).d(r206);     // Catch: Throwable -> L683
    L669:
        r195 = r206;
    L671:
        th = move-exception;
        if ((!r207.modifiedProperties.isEmpty()) == false) goto L1212;
        ((t) r203.c()).d(r206);     // Catch: Throwable -> L683
        throw th;     // Catch: Throwable -> L683
    L1212:
        throw th;     // Catch: Throwable -> L683
    L670:
        r206 = r213;
        r205 = r214;
        r198 = r215;
        goto L655
    L662:
        r1102 = false;
        goto L663
    L676:
        int r216 = r198;
        if (r195 == (-1)) goto L680;
        ((e0) r202.getItemDataList().c()).remove(r195);     // Catch: Throwable -> L683
    L680:
        if ((!r199.modifiedProperties.isEmpty()) == false) goto L682;
        ((t) r192.c()).d(r196);     // Catch: Throwable -> L720
    L682:
        r175 = r1101;
        r196 = r216;
    L683:
        th = move-exception;
        if ((!r199.modifiedProperties.isEmpty()) == false) goto L1213;
        ((t) r192.c()).d(r196);     // Catch: Throwable -> L720
        throw th;     // Catch: Throwable -> L720
    L1213:
        throw th;     // Catch: Throwable -> L720
    L652:
        r196 = r198;
    L650:
        r201 = false;
        goto L651
    L649:
        r194 = r194;
    L720:
        th = move-exception;
        if ((!r176.modifiedProperties.isEmpty()) == false) goto L1215;
        ((t) r171.c()).d(r173);
        throw th;
    L1215:
        throw th;
    L628:
        r178 = false;
        goto L629
    L725:
        r3 = this;
        goto L1024
    L727:
        if ((r132 instanceof IncrementalUpdatePanelGiftList) == false) goto L729;
        r3 = this;
        r3.W2(r46, r47, (IncrementalUpdatePanelGiftList) r132);
        goto L1024
    L729:
        r3 = this;
        if ((r132 instanceof IncrementalRefreshGiftList) == true) goto L1024;
        if ((r132 instanceof ClickSearchBack) == false) goto L741;
        k0 r208 = r46.b;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r209 = r47.getCurrentPagePosition();
        r208.getClass();
        int r217 = ((Number) com.bytedance.android.anya.h.b(r209)).intValue();
        r r218 = r46.i(r47);
        if ((r218 instanceof GiftListBusinessState.GiftSelected) == false) goto L737;
    L738:
        u1(r46, r47);
        r3.w1(r46, r47, ClearGiftSource.SearchUpdate);
    L739:
        r3.K0(new ScrollToPositionEffect(r217, 0, -1, -1, false, true));
        goto L1024
    L737:
        if ((r218 instanceof GiftListBusinessState.GiftCombo) == false) goto L739;
    L741:
        if ((r132 instanceof ChangePinupStatus) == false) goto L777;
        ChangePinupStatus r219 = (ChangePinupStatus) r132;
        if (r219.getPagerPosition() < 0) goto L769;
        int r220 = r219.getPagerPosition();
        t0<GiftVerticalState, PagerListData> r221 = r47.getPanelList();
        r46.getClass();
        if (r220 >= com.bytedance.android.anya.h.a(r221)) goto L769;
        l0.a r222 = l0.e(r47.getPanelList(), r219.getPagerPosition());
        l0 r223 = r222.b;
        u r224 = ((PagerListData) r222.a).getItemDataList();
        Iterator r225 = ((Iterable) r224.c()).iterator();
        int r226 = 0;
    L748:
        if (r225.hasNext() == false) goto L768;
        Object r227 = r225.next();
        int r1104 = r226 + 1;
        if (r226 >= 0) goto L752;
        CollectionsKt.throwIndexOverflow();
    L752:
        MVIState r228 = (MVIState) r227;
        com.bytedance.android.anya.r0<ItemListData, ItemDataType> r1105 = ((ItemListData) r228).getItemDataType();
        r223.getClass();
        if (((ItemDataType) com.bytedance.android.anya.h.b(r1105)) != ItemDataType.MOSTLY_USED_HEADER) goto L755;
        boolean r1106 = true;
    L756:
        if (r1106 == false) goto L762;
        new k0.a();     // Catch: Throwable -> L763
        ItemListData r1107 = (ItemListData) r228;     // Catch: Throwable -> L763
        r1107.getPinTopStatus().a(PinTopState.copy$default((PinTopState) r1107.getPinTopStatus().c(), ((ChangePinupStatus) r132).getTargetPinStrategy(), false, true, 2, null));     // Catch: Throwable -> L763
        if ((!r228.modifiedProperties.isEmpty()) == false) goto L762;
        ((t) r224.c()).d(r226);
    L763:
        th = move-exception;
        if ((!r228.modifiedProperties.isEmpty()) == false) goto L1216;
        ((t) r224.c()).d(r226);
        throw th;
    L1216:
        throw th;
    L762:
        r226 = r1104;
        goto L748
    L755:
        r1106 = false;
        goto L756
    L768:
        Unit r229 = Unit.INSTANCE;
    L769:
        u1 r230 = r3.b1;
        int r231 = r219.getPagerPosition();
        int r232 = r219.getTargetPinStrategy();
        if (r232 == 1) goto L774;
        if (r232 == 2) goto L773;
        String r233 = BuildConfig.FLAVOR;
    L775:
        r230.R(r231, r233);
        r3.K2.q(r219.getTargetPinStrategy(), r219.getPagerPosition(), r3.k0.getRoom().getId());
        goto L1024
    L773:
        r233 = "cancel_first";
        goto L775
    L774:
        r233 = "set_first";
        goto L775
    L777:
        if ((r132 instanceof ClickPinupHintIcon) == false) goto L780;
        u1 r234 = r3.b1;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r235 = r47.getCurrentPagePosition();
        r46.getClass();
        r234.R(((Number) com.bytedance.android.anya.h.b(r235)).intValue(), "operate_explain");
        r3.K0(new ShowMostlyUsedPinupPopup());
        goto L1024
    L780:
        if ((r132 instanceof ChangeGiftMostlyUsedStatus) == false) goto L783;
        ChangeGiftMostlyUsedStatus r236 = (ChangeGiftMostlyUsedStatus) r132;
        r3.K2.n(r236.getGiftId(), r3.k0.getRoom().getId(), 1, r236.getPageType());
        goto L1024
    L783:
        if ((r132 instanceof RefreshMostlyUsedTabPinTopStatus) == false) goto L813;
        RefreshMostlyUsedTabPinTopStatus r237 = (RefreshMostlyUsedTabPinTopStatus) r132;
        r3.K0(new ShowMostlyUsedTabPinStatusChangeToast(r237.getTargetPinTopStrategy()));
        if (r237.getPagerPosition() < 0) goto L811;
        int r238 = r237.getPagerPosition();
        t0<GiftVerticalState, PagerListData> r239 = r47.getPanelList();
        r46.getClass();
        if (r238 >= com.bytedance.android.anya.h.a(r239)) goto L811;
        l0.a r240 = l0.e(r47.getPanelList(), r237.getPagerPosition());
        l0 r241 = r240.b;
        u r242 = ((PagerListData) r240.a).getItemDataList();
        Iterator r243 = ((Iterable) r242.c()).iterator();
        int r244 = 0;
    L790:
        if (r243.hasNext() == false) goto L810;
        Object r245 = r243.next();
        int r246 = r244 + 1;
        if (r244 >= 0) goto L794;
        CollectionsKt.throwIndexOverflow();
    L794:
        MVIState r247 = (MVIState) r245;
        com.bytedance.android.anya.r0<ItemListData, ItemDataType> r1108 = ((ItemListData) r247).getItemDataType();
        r241.getClass();
        if (((ItemDataType) com.bytedance.android.anya.h.b(r1108)) != ItemDataType.MOSTLY_USED_HEADER) goto L797;
        boolean r1109 = true;
    L798:
        if (r1109 == false) goto L804;
        new k0.a();     // Catch: Throwable -> L805
        ItemListData r1110 = (ItemListData) r247;     // Catch: Throwable -> L805
        r1110.getPinTopStatus().a(PinTopState.copy$default((PinTopState) r1110.getPinTopStatus().c(), ((RefreshMostlyUsedTabPinTopStatus) r132).getTargetPinTopStrategy(), false, false, 2, null));     // Catch: Throwable -> L805
        if ((!r247.modifiedProperties.isEmpty()) == false) goto L804;
        ((t) r242.c()).d(r244);
    L805:
        th = move-exception;
        if ((!r247.modifiedProperties.isEmpty()) == false) goto L1217;
        ((t) r242.c()).d(r244);
        throw th;
    L1217:
        throw th;
    L804:
        r244 = r246;
        goto L790
    L797:
        r1109 = false;
        goto L798
    L810:
        Unit r248 = Unit.INSTANCE;
    L811:
        r3.K2.J(r237.getTargetPinTopStrategy());
        goto L1024
    L813:
        if ((r132 instanceof RefreshGiftMostlyUsedStatus) == false) goto L1024;
        RefreshGiftMostlyUsedStatus r249 = (RefreshGiftMostlyUsedStatus) r132;
        r3.K2.h.put(Long.valueOf(r249.getGiftId()), Boolean.FALSE);
        int r250 = r249.getOperateAction();
        int r251 = 17;
        if (r250 == 1) goto L913;
        if (r250 != 2) goto L1024;
        if (r249.getSuccess() == true) goto L821;
        return;
    L821:
        r3.K0(new ShowGiftMostlyUsedStateChangeToast(false));
        r3.K2.I(r249.getGiftId());
        r r252 = r46.i(r47);
        if ((r252 instanceof GiftListBusinessState.GiftSelected) == false) goto L835;
        GiftListBusinessState.GiftSelected r253 = (GiftListBusinessState.GiftSelected) r252;
        vz1.e r254 = r253.getIconModel();
        if (r254 == null) goto L835;
        h1 r255 = r254.c();
        if (r255 == null) goto L835;
        if (r255.getId() != r249.getGiftId()) goto L835;
        Integer r256 = (Integer) ((LinkedHashMap) r3.L0.g()).get(Integer.valueOf(r253.getSelectedPagePosition()));
        if (r256 == null) goto L835;
        if (r256.intValue() != 17) goto L835;
        r3.w1(r46, r47, ClearGiftSource.RemoveMostlyUsed);
    L835:
        u r257 = r47.getPanelList();
        Iterator r258 = ((Iterable) r257.c()).iterator();
        int r259 = 0;
    L837:
        if (r258.hasNext() == false) goto L1024;
        Object r260 = r258.next();
        int r261 = r259 + 1;
        if (r259 >= 0) goto L841;
        CollectionsKt.throwIndexOverflow();
    L841:
        MVIState r262 = (MVIState) r260;
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r262).getTabType())).intValue() != r251) goto L844;
        boolean r1111 = true;
    L845:
        if (r1111 == true) goto L1051;
        Iterator r410 = r258;
        int r1112 = r261;
    L906:
        r258 = r410;
        r259 = r1112;
        r251 = 17;
        goto L837
    L1051:
        new k0.a();     // Catch: Throwable -> L907
        PagerListData r1113 = (PagerListData) r262;     // Catch: Throwable -> L907
        u r1114 = r1113.getItemDataList();     // Catch: Throwable -> L907
        u r1115 = r1114;     // Catch: Throwable -> L907
        Iterator r1116 = ((Iterable) r1114.c()).iterator();     // Catch: Throwable -> L907
        int r1117 = -1;
        int r1118 = 0;
    L849:
        if (r1116.hasNext() == false) goto L874;
        Object r1119 = r1116.next();     // Catch: Throwable -> L907
        int r1120 = r1118 + 1;     // Catch: Throwable -> L907
        if (r1118 >= 0) goto L853;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L907
    L853:
        MVIState r263 = (MVIState) r1119;     // Catch: Throwable -> L907
        if (((vz1.e) ((ItemListData) r263).getItemData().c()).c().getId() != ((RefreshGiftMostlyUsedStatus) r132).getGiftId()) goto L857;
        r1117 = r1118;
    L857:
        if (r1118 > r1117) goto L859;
    L861:
        boolean r264 = false;
    L862:
        if (r264 == true) goto L1032;
        Iterator r411 = r258;
        int r1121 = r261;
    L868:
        r258 = r411;
        r1118 = r1120;
        r261 = r1121;
        goto L849
    L1032:
        new k0.a();     // Catch: Throwable -> L869
        ItemListData r265 = (ItemListData) r263;     // Catch: Throwable -> L869
        r411 = r258;
        r1121 = r261;
        ((vz1.e) r265.getItemData().c()).g(new com.bytedance.android.livesdk.gift.platform.core.model.k(r1120, 17, ((s0) r1113.getItemDataList().c()).size() - 1, ((vz1.e) r265.getItemData().c()).c().getId(), ((vz1.e) r265.getItemData().c()).b()));     // Catch: Throwable -> L869
    L866:
        if ((!r263.modifiedProperties.isEmpty()) == false) goto L868;
        ((t) r1114.c()).d(r1118);     // Catch: Throwable -> L907
    L869:
        th = move-exception;
        if ((!r263.modifiedProperties.isEmpty()) == false) goto L1218;
        ((t) r1114.c()).d(r1118);     // Catch: Throwable -> L907
        throw th;     // Catch: Throwable -> L907
    L1218:
        throw th;     // Catch: Throwable -> L907
    L859:
        if (r1117 == (-1)) goto L861;
        r264 = true;
        goto L862
    L874:
        r410 = r258;
        r1112 = r261;
        if (r1117 == (-1)) goto L878;
        ((e0) r1113.getItemDataList().c()).remove(r1117);     // Catch: Throwable -> L907
    L878:
        if (((Boolean) r1113.getHasHeader().c()).booleanValue() == false) goto L904;
        if (((s0) r1113.getItemDataList().c()).size() > 1) goto L904;
        u r266 = r1113.getItemDataList();     // Catch: Throwable -> L907
        u r267 = r266;     // Catch: Throwable -> L907
        Iterator r268 = ((Iterable) r266.c()).iterator();     // Catch: Throwable -> L907
        int r269 = 0;
    L883:
        if (r268.hasNext() == false) goto L904;
        Object r1122 = r268.next();     // Catch: Throwable -> L907
        int r1123 = r269 + 1;     // Catch: Throwable -> L907
        if (r269 >= 0) goto L887;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L907
    L887:
        MVIState r1124 = (MVIState) r1122;     // Catch: Throwable -> L907
        if (((ItemDataType) ((ItemListData) r1124).getItemDataType().c()) != ItemDataType.MOSTLY_USED_HEADER) goto L890;
        boolean r1125 = true;
    L891:
        if (r1125 == false) goto L897;
        new k0.a();     // Catch: Throwable -> L898
        ItemListData r1126 = (ItemListData) r1124;     // Catch: Throwable -> L898
        r1126.getPinTopStatus().a(PinTopState.copy$default((PinTopState) r1126.getPinTopStatus().c(), 0, true, false, 5, null));     // Catch: Throwable -> L898
    L895:
        if ((!r1124.modifiedProperties.isEmpty()) == false) goto L897;
        ((t) r266.c()).d(r269);     // Catch: Throwable -> L907
    L898:
        th = move-exception;
        if ((!r1124.modifiedProperties.isEmpty()) == false) goto L1219;
        ((t) r266.c()).d(r269);     // Catch: Throwable -> L907
        throw th;     // Catch: Throwable -> L907
    L1219:
        throw th;     // Catch: Throwable -> L907
    L897:
        r269 = r1123;
        goto L883
    L890:
        r1125 = false;
    L904:
        if ((!r262.modifiedProperties.isEmpty()) == false) goto L906;
        ((t) r257.c()).d(r259);
    L907:
        th = move-exception;
        if ((!r262.modifiedProperties.isEmpty()) == false) goto L1220;
        ((t) r257.c()).d(r259);
        throw th;
    L1220:
        throw th;
    L844:
        r1111 = false;
        goto L845
    L913:
        if (r249.getSuccess() == true) goto L915;
        return;
    L915:
        r3.K0(new ShowGiftMostlyUsedStateChangeToast(true));
        r3.K2.k(r249.getGiftId());
        com.bytedance.android.anya.internal.c r270 = (u) r47.getPanelList();
        Iterator r271 = ((Iterable) r270.c()).iterator();
        int r272 = 0;
        int r273 = 0;
    L917:
        if (r271.hasNext() == false) goto L1024;
        Object r1127 = r271.next();
        int r1128 = r272 + 1;
        if (r272 >= 0) goto L921;
        CollectionsKt.throwIndexOverflow();
    L921:
        MVIState r1129 = (MVIState) r1127;
        com.bytedance.android.anya.r0<PagerListData, Integer> r1130 = ((PagerListData) r1129).getTabType();
        r46.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r1130)).intValue() != 17) goto L924;
        boolean r1131 = true;
    L925:
        if (r1131 == false) goto L926;
        new k0.a();     // Catch: Throwable -> L1018
        PagerListData r1132 = (PagerListData) r1129;     // Catch: Throwable -> L1018
        List r1133 = CollectionsKt.toMutableList(k0.c(r1132.getItemDataList()));     // Catch: Throwable -> L1018
        int r412 = r1133.size();     // Catch: Throwable -> L1018
        Iterator r1134 = r1133.iterator();     // Catch: Throwable -> L1018
        int r1135 = 0;
    L929:
        if (r1134.hasNext() == false) goto L939;
        if (((ItemDataType) com.bytedance.android.anya.h.b(((ItemListData) r1134.next()).getItemDataType())) != ItemDataType.MOSTLY_USED_HEADER) goto L933;
        boolean r274 = true;
    L934:
        if (r274 == true) goto L940;
        r1135 = r1135 + 1;
    L940:
        int r275 = r1135 + 1;
        h1 r276 = GiftManagerKt.j(((RefreshGiftMostlyUsedStatus) r132).getGiftId(), Integer.valueOf(((RefreshGiftMostlyUsedStatus) r132).getOriginPageType()));     // Catch: Throwable -> L1018
        if (r276 == null) goto L944;
        r273 = r273 + 1;
        int r1136 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L1018
        IBaseUser r1137 = r3.H2.d();     // Catch: Throwable -> L1018
        if (r1137 != null) goto L951;
        String r277 = null;
    L953:
        Iterator r278 = r271;
        int r413 = r272;
        com.bytedance.android.anya.internal.c r414 = r270;
        vz1.e r279 = com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r276, 17, r277, r3.H2.g(), r3.x1, r3.T1, r3.b2, r3.J, r3.w, r3.H2, r3.v, r3.P1, r3.L0, r3.M1, r3.E2, r273, r412);     // Catch: Throwable -> L1010
        ItemListData r280 = new ItemListData();     // Catch: Throwable -> L1010
        new k0.a();     // Catch: Throwable -> L1010
        r280.getItemData().a(r279);     // Catch: Throwable -> L1010
        if (j0.e(r276) == false) goto L966;
        r280.getVisualStatus().a(Integer.valueOf(((Number) r280.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));     // Catch: Throwable -> L963
    L963:
        th = move-exception;
        Throwable r281 = th;
        int r1138 = r413;
        r1129 = r1129;
    L1021:
        if ((!r1129.modifiedProperties.isEmpty()) == false) goto L1223;
        ((t) r414.c()).d(r1138);
        throw r281;
    L1223:
        throw r281;
    L966:
        if (j0.f(r276) == false) goto L969;
        r280.getVisualStatus().a(Integer.valueOf(((Number) r280.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));     // Catch: Throwable -> L963
    L969:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.b(r3.H2.d().getIdString()) == false) goto L971;
        r280.getVisualStatus().a(Integer.valueOf(((Number) r280.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));     // Catch: Throwable -> L963
    L971:
        Unit r282 = Unit.INSTANCE;     // Catch: Throwable -> L1010
        r1133.add(r275, r280);     // Catch: Throwable -> L1010
        Iterator r283 = r1133.iterator();     // Catch: Throwable -> L1010
        int r284 = 0;
    L973:
        if (r283.hasNext() == false) goto L979;
        Object r285 = r283.next();     // Catch: Throwable -> L963
        int r286 = r284 + 1;     // Catch: Throwable -> L963
        if (r284 >= 0) goto L977;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L963
    L977:
        ItemListData r287 = (ItemListData) r285;     // Catch: Throwable -> L963
        ((vz1.e) com.bytedance.android.anya.h.b(r287.getItemData())).g(new com.bytedance.android.livesdk.gift.platform.core.model.k(r284, 17, r1133.size(), ((vz1.e) com.bytedance.android.anya.h.b(r287.getItemData())).d(), ((vz1.e) com.bytedance.android.anya.h.b(r287.getItemData())).b()));     // Catch: Throwable -> L963
        r284 = r286;
        goto L973
    L979:
        l0.d(r1132.getItemDataList());     // Catch: Throwable -> L1010
        l0.c(r1132.getItemDataList(), r1133);     // Catch: Throwable -> L1010
        if (((Boolean) com.bytedance.android.anya.h.b(r1132.getHasHeader())).booleanValue() == false) goto L1007;
        if (com.bytedance.android.anya.h.a(r1132.getItemDataList()) <= 1) goto L1007;
        u r288 = r1132.getItemDataList();     // Catch: Throwable -> L963
        u r289 = r288;     // Catch: Throwable -> L963
        Iterator r290 = ((Iterable) r288.c()).iterator();     // Catch: Throwable -> L963
        int r291 = 0;
    L985:
        if (r290.hasNext() == false) goto L1007;
        Object r292 = r290.next();     // Catch: Throwable -> L963
        int r293 = r291 + 1;     // Catch: Throwable -> L963
        if (r291 >= 0) goto L989;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L963
    L989:
        MVIState r294 = (MVIState) r292;     // Catch: Throwable -> L963
        if (((ItemDataType) com.bytedance.android.anya.h.b(((ItemListData) r294).getItemDataType())) != ItemDataType.MOSTLY_USED_HEADER) goto L992;
        boolean r295 = true;
    L993:
        if (r295 == false) goto L999;
        new k0.a();     // Catch: Throwable -> L1000
        ItemListData r296 = (ItemListData) r294;     // Catch: Throwable -> L1000
        r296.getPinTopStatus().a(PinTopState.copy$default((PinTopState) r296.getPinTopStatus().c(), 0, false, false, 5, null));     // Catch: Throwable -> L1000
    L997:
        if ((!r294.modifiedProperties.isEmpty()) == false) goto L999;
        ((t) r288.c()).d(r291);     // Catch: Throwable -> L963
    L1000:
        th = move-exception;
        if ((!r294.modifiedProperties.isEmpty()) == false) goto L1222;
        ((t) r288.c()).d(r291);     // Catch: Throwable -> L963
        throw th;     // Catch: Throwable -> L963
    L1222:
        throw th;     // Catch: Throwable -> L963
    L999:
        r291 = r293;
        goto L985
    L992:
        r295 = false;
    L1007:
        if ((!r1129.modifiedProperties.isEmpty()) == false) goto L1009;
        ((t) r414.c()).d(r413);
    L1009:
        r132 = r48;
        r271 = r278;
        r272 = r1128;
        r270 = r414;
    L1010:
        th = th;
        r1138 = r413;
        r1129 = r1129;
    L1012:
        r281 = th;
    L1013:
        th = th;
    L1017:
        r1138 = r413;
    L1015:
        th = th;
        r414 = r270;
        goto L1017
    L951:
        r277 = r1137.getIdString();     // Catch: Throwable -> L937
        goto L953
    L944:
        if ((!r1129.modifiedProperties.isEmpty()) == false) goto L1221;
        ((t) r270.c()).d(r272);
        return;
    L1221:
        return;
    L933:
        r274 = false;
    L937:
        th = move-exception;
        r281 = th;
        r414 = r270;
        r1138 = r272;
        goto L1021
    L939:
        r1135 = -1;
    L1018:
        th = th;
        r414 = r270;
        r1138 = r272;
        goto L1012
    L926:
        r272 = r1128;
        goto L917
    L924:
        r1131 = false;
        goto L925
    L275:
        if (v.h() == true) goto L277;
    L340:
        int r297 = -1;
        int r298 = -1;
        int r299 = -1;
        int r1139 = -1;
    L341:
        if (r1139 != r298) goto L419;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r300 = r47.getCurrentPagePosition();
        r46.getClass();
        int r301 = ((Number) com.bytedance.android.anya.h.b(r300)).intValue();
        long r302 = ((ClickLynxSeriesCard) r48).getGiftID();
        if (com.bytedance.android.anya.h.a(r47.getPanelList()) <= r301) goto L417;
        u r303 = r47.getPanelList();
        MVIState r304 = (MVIState) ((s0) r303.c()).get(r301);
        new k0.a();     // Catch: Throwable -> L412
        PagerListData r305 = (PagerListData) r304;     // Catch: Throwable -> L412
        u r1140 = r305.getItemDataList();     // Catch: Throwable -> L412
        u r1141 = r1140;     // Catch: Throwable -> L412
        Iterator r1142 = ((Iterable) r1140.c()).iterator();     // Catch: Throwable -> L412
        int r1143 = r1139;
        int r1144 = 0;
    L347:
        if (r1142.hasNext() == false) goto L368;
        Object r1145 = r1142.next();     // Catch: Throwable -> L412
        r1144 = r1144 + 1;     // Catch: Throwable -> L412
        if (r1144 >= 0) goto L351;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L412
    L351:
        int r2100 = r297;
        MVIState r306 = (MVIState) r1145;     // Catch: Throwable -> L412
        if (((vz1.e) ((ItemListData) r306).getItemData().c()).c().getId() != r302) goto L355;
        boolean r1146 = true;
    L356:
        if (r1146 == false) goto L357;
        new k0.a();     // Catch: Throwable -> L363
        ItemListData r1147 = (ItemListData) r306;     // Catch: Throwable -> L363
    L360:
        if ((!r306.modifiedProperties.isEmpty()) == false) goto L362;
        ((t) r1140.c()).d(r1144);     // Catch: Throwable -> L412
    L362:
        r297 = r301;
        r1143 = r1144;
    L363:
        th = move-exception;
        if ((!r306.modifiedProperties.isEmpty()) == false) goto L1200;
        ((t) r1140.c()).d(r1144);     // Catch: Throwable -> L412
        throw th;     // Catch: Throwable -> L412
    L1200:
        throw th;     // Catch: Throwable -> L412
    L357:
        r297 = r2100;
        goto L347
    L355:
        r1146 = false;
        goto L356
    L368:
        int r2101 = r297;
        u r307 = r305.getCounterDataList();     // Catch: Throwable -> L412
        u r308 = r307;     // Catch: Throwable -> L412
        Iterator r309 = ((Iterable) r307.c()).iterator();     // Catch: Throwable -> L412
        int r1148 = -1;
        int r1149 = 0;
    L370:
        if (r309.hasNext() == false) goto L408;
        Object r1150 = r309.next();     // Catch: Throwable -> L412
        int r1151 = r1149 + 1;     // Catch: Throwable -> L412
        if (r1149 >= 0) goto L374;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L412
    L374:
        MVIState r1152 = (MVIState) r1150;     // Catch: Throwable -> L412
        new k0.a();     // Catch: Throwable -> L403
        u r1153 = ((CounterData) r1152).getItemDataList();     // Catch: Throwable -> L403
        u r2102 = r1153;     // Catch: Throwable -> L403
        Iterator r2103 = ((Iterable) r1153.c()).iterator();     // Catch: Throwable -> L403
        Iterator r2104 = r309;
        int r310 = 0;
    L377:
        if (r2103.hasNext() == false) goto L398;
        Object r2105 = r2103.next();     // Catch: Throwable -> L403
        int r2106 = r310 + 1;     // Catch: Throwable -> L403
        if (r310 >= 0) goto L381;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L403
    L381:
        int r2107 = r299;
        MVIState r311 = (MVIState) r2105;     // Catch: Throwable -> L403
        if (((vz1.e) ((ItemListData) r311).getItemData().c()).c().getId() != r302) goto L385;
        boolean r2108 = true;
    L386:
        if (r2108 == false) goto L387;
        new k0.a();     // Catch: Throwable -> L393
        ItemListData r1154 = (ItemListData) r311;     // Catch: Throwable -> L393
    L390:
        if ((!r311.modifiedProperties.isEmpty()) == false) goto L392;
        ((t) r1153.c()).d(r310);     // Catch: Throwable -> L403
    L392:
        r2101 = r301;
        r1143 = r310;
        r1148 = r1149;
    L393:
        th = move-exception;
        if ((!r311.modifiedProperties.isEmpty()) == false) goto L1201;
        ((t) r1153.c()).d(r310);     // Catch: Throwable -> L403
        throw th;     // Catch: Throwable -> L403
    L1201:
        throw th;     // Catch: Throwable -> L403
    L387:
        r310 = r2106;
        r299 = r2107;
        goto L377
    L385:
        r2108 = false;
        goto L386
    L398:
        int r2109 = r299;
        if ((!r1152.modifiedProperties.isEmpty()) == false) goto L402;
        ((t) r307.c()).d(r1149);     // Catch: Throwable -> L412
    L402:
        r1149 = r1151;
        r309 = r2104;
        r299 = r2109;
    L403:
        th = move-exception;
        if ((!r1152.modifiedProperties.isEmpty()) == false) goto L1202;
        ((t) r307.c()).d(r1149);     // Catch: Throwable -> L412
        throw th;     // Catch: Throwable -> L412
    L1202:
        throw th;     // Catch: Throwable -> L412
    L408:
        int r2110 = r299;
        if ((!r304.modifiedProperties.isEmpty()) == false) goto L411;
        ((t) r303.c()).d(r301);
    L411:
        r1139 = r1143;
        r297 = r2101;
    L418:
        int r312 = -1;
    L420:
        if (r1139 != r312) goto L511;
        long r313 = ((ClickLynxSeriesCard) r48).getGiftID();
        u r314 = r47.getPanelList();
        Iterator r315 = ((Iterable) r314.c()).iterator();
        int r316 = 0;
    L423:
        if (r315.hasNext() == false) goto L511;
        Object r317 = r315.next();
        int r318 = r316 + 1;
        if (r316 >= 0) goto L427;
        CollectionsKt.throwIndexOverflow();
    L427:
        MVIState r319 = (MVIState) r317;
        new k0.a();     // Catch: Throwable -> L506
        PagerListData r1155 = (PagerListData) r319;     // Catch: Throwable -> L506
        u r1156 = r1155.getItemDataList();     // Catch: Throwable -> L506
        u r1157 = r1156;     // Catch: Throwable -> L506
        Iterator r1158 = ((Iterable) r1156.c()).iterator();     // Catch: Throwable -> L506
        int r1159 = r297;
        int r320 = 0;
    L430:
        if (r1158.hasNext() == false) goto L455;
        Object r2111 = r1158.next();     // Catch: Throwable -> L506
        int r2112 = r320 + 1;     // Catch: Throwable -> L506
        if (r320 >= 0) goto L434;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L506
    L434:
        Iterator r2113 = r315;
        MVIState r321 = (MVIState) r2111;     // Catch: Throwable -> L506
        if (((vz1.e) ((ItemListData) r321).getItemData().c()).c().getId() != r313) goto L438;
        boolean r2114 = true;
    L439:
        if (r2114 == true) goto L1039;
        r320 = r2112;
        r315 = r2113;
        goto L430
    L1039:
        new k0.a();     // Catch: Throwable -> L449
        ItemListData r322 = (ItemListData) r321;     // Catch: Throwable -> L449
    L443:
        if ((!r321.modifiedProperties.isEmpty()) == false) goto L446;
        ((t) r1156.c()).d(r320);     // Catch: Throwable -> L506
    L446:
        if ((!r319.modifiedProperties.isEmpty()) == false) goto L448;
        ((t) r314.c()).d(r316);
    L448:
        int r1160 = r320;
        int r1161 = r316;
        int r323 = -1;
        int r324 = -1;
    L513:
        if (r1161 == r323) goto L616;
        if (r1160 == r323) goto L616;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r325 = r47.getCurrentPagePosition();
        r46.getClass();
        if (r1161 == ((Number) com.bytedance.android.anya.h.b(r325)).intValue()) goto L520;
        r11.w1(r46, r47, ClearGiftSource.ChangeTab);
        ((Number) com.bytedance.android.anya.h.b(r47.getCurrentPagePosition())).intValue();
        e3(this, r46, r47, r1161, false, "click", false, 40);
    L520:
        if (r324 == (-1)) goto L524;
        k0 r326 = r46.b;
        t0<GiftVerticalState, PagerListData> r327 = r47.getPanelList();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r328 = r47.getCurrentPagePosition();
        r326.getClass();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r327, ((Number) com.bytedance.android.anya.h.b(r328)).intValue())).getCurrentTopicPagerPosition())).intValue() == r324) goto L524;
        r11.w1(r46, r47, ClearGiftSource.ChangeTopicPage);
        f3(r46, r47, r324, r1161, TopicChangeSource.SLIDE, true);
    L524:
        J3(this, r46, r47, r1161, r1160, SelectedStatus.SERIES_CARD, r1148, null, r324, 160);
    L449:
        th = move-exception;
        if ((!r321.modifiedProperties.isEmpty()) == false) goto L1204;
        ((t) r1156.c()).d(r320);     // Catch: Throwable -> L506
        throw th;     // Catch: Throwable -> L506
    L1204:
        throw th;     // Catch: Throwable -> L506
    L438:
        r2114 = false;
        goto L439
    L455:
        Iterator r2115 = r315;
        u r329 = r1155.getTopicPagerListData();     // Catch: Throwable -> L506
        u r330 = r329;     // Catch: Throwable -> L506
        Iterator r331 = ((Iterable) r329.c()).iterator();     // Catch: Throwable -> L506
        int r1162 = 0;
    L457:
        if (r331.hasNext() == false) goto L502;
        Object r1163 = r331.next();     // Catch: Throwable -> L506
        int r1164 = r1162 + 1;     // Catch: Throwable -> L506
        if (r1162 >= 0) goto L461;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L506
    L461:
        Iterator r2116 = r331;
        MVIState r332 = (MVIState) r1163;     // Catch: Throwable -> L506
        new k0.a();     // Catch: Throwable -> L497
        u r1165 = ((TopicPagerListData) r332).getItemDataList();     // Catch: Throwable -> L497
        u r2117 = r1165;     // Catch: Throwable -> L497
        Iterator r2118 = ((Iterable) r1165.c()).iterator();     // Catch: Throwable -> L497
        int r2119 = r318;
        int r333 = 0;
    L464:
        if (r2118.hasNext() == false) goto L492;
        Object r2120 = r2118.next();     // Catch: Throwable -> L497
        int r2121 = r333 + 1;     // Catch: Throwable -> L497
        if (r333 >= 0) goto L468;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L497
    L468:
        int r2122 = r1139;
        MVIState r1166 = (MVIState) r2120;     // Catch: Throwable -> L497
        if (((vz1.e) ((ItemListData) r1166).getItemData().c()).c().getId() != r313) goto L472;
        boolean r2123 = true;
    L473:
        if (r2123 == true) goto L1037;
        r333 = r2121;
        r1139 = r2122;
        goto L464
    L1037:
        new k0.a();     // Catch: Throwable -> L486
        ItemListData r334 = (ItemListData) r1166;     // Catch: Throwable -> L486
    L477:
        if ((!r1166.modifiedProperties.isEmpty()) == false) goto L480;
        ((t) r1165.c()).d(r333);     // Catch: Throwable -> L497
    L480:
        if ((!r332.modifiedProperties.isEmpty()) == false) goto L483;
        ((t) r329.c()).d(r1162);     // Catch: Throwable -> L506
    L483:
        if ((!r319.modifiedProperties.isEmpty()) == false) goto L485;
        ((t) r314.c()).d(r316);
    L485:
        int r335 = r316;
        r1160 = r333;
        r324 = r1162;
    L512:
        r1161 = r335;
        r323 = -1;
    L486:
        th = move-exception;
        if ((!r1166.modifiedProperties.isEmpty()) == false) goto L1205;
        ((t) r1165.c()).d(r333);     // Catch: Throwable -> L497
        throw th;     // Catch: Throwable -> L497
    L1205:
        throw th;     // Catch: Throwable -> L497
    L472:
        r2123 = false;
        goto L473
    L492:
        int r2124 = r1139;
        if ((!r332.modifiedProperties.isEmpty()) == false) goto L496;
        ((t) r329.c()).d(r1162);     // Catch: Throwable -> L506
    L496:
        r1162 = r1164;
        r331 = r2116;
        r318 = r2119;
        r1139 = r2124;
    L497:
        th = move-exception;
        if ((!r332.modifiedProperties.isEmpty()) == false) goto L1206;
        ((t) r329.c()).d(r1162);     // Catch: Throwable -> L506
        throw th;     // Catch: Throwable -> L506
    L1206:
        throw th;     // Catch: Throwable -> L506
    L502:
        int r2125 = r318;
        int r2126 = r1139;
        if ((!r319.modifiedProperties.isEmpty()) == false) goto L505;
        ((t) r314.c()).d(r316);
    L505:
        r297 = r1159;
        r315 = r2115;
        r316 = r2125;
        r1139 = r2126;
    L506:
        th = move-exception;
        if ((!r319.modifiedProperties.isEmpty()) == false) goto L1207;
        ((t) r314.c()).d(r316);
        throw th;
    L1207:
        throw th;
    L511:
        r335 = r297;
        r324 = r2110;
        r1160 = r1139;
    L412:
        th = move-exception;
        if ((!r304.modifiedProperties.isEmpty()) == false) goto L1203;
        ((t) r303.c()).d(r301);
        throw th;
    L1203:
        throw th;
    L417:
        r2110 = r299;
        r1148 = -1;
        goto L418
    L419:
        r2110 = r299;
        r312 = -1;
        r1148 = -1;
        goto L420
    L277:
        if (com.bytedance.android.livesdk.gift.platform.core.h.c() == false) goto L340;
        k0 r336 = r46.b;
        t0<GiftVerticalState, PagerListData> r337 = r47.getPanelList();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r338 = r47.getCurrentPagePosition();
        r336.getClass();
        if (k0.c(((PagerListData) k0.d(r337, ((Number) com.bytedance.android.anya.h.b(r338)).intValue())).getTopicPagerListData()).size() <= 1) goto L340;
        r297 = ((Number) com.bytedance.android.anya.h.b(r47.getCurrentPagePosition())).intValue();
        long r339 = ((ClickLynxSeriesCard) r48).getGiftID();
        if (com.bytedance.android.anya.h.a(r47.getPanelList()) <= r297) goto L340;
        u r340 = r47.getPanelList();
        MVIState r341 = (MVIState) ((s0) r340.c()).get(r297);
        new k0.a();     // Catch: Throwable -> L335
        u r342 = ((PagerListData) r341).getTopicPagerListData();     // Catch: Throwable -> L335
        u r343 = r342;     // Catch: Throwable -> L335
        Iterator r344 = ((Iterable) r342.c()).iterator();     // Catch: Throwable -> L335
        r299 = 0;
    L285:
        if (r344.hasNext() == false) goto L333;
        Object r1167 = r344.next();     // Catch: Throwable -> L335
        int r1168 = r299 + 1;     // Catch: Throwable -> L335
        if (r299 >= 0) goto L289;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L335
    L289:
        MVIState r1169 = (MVIState) r1167;     // Catch: Throwable -> L335
        new k0.a();     // Catch: Throwable -> L327
        TopicPagerListData r1170 = (TopicPagerListData) r1169;     // Catch: Throwable -> L327
        if (r299 == 0) goto L324;
        u r1171 = r1170.getItemDataList();     // Catch: Throwable -> L327
        u r1172 = r1171;     // Catch: Throwable -> L327
        Iterator r1173 = ((Iterable) r1171.c()).iterator();     // Catch: Throwable -> L327
        r1139 = 0;
    L295:
        if (r1173.hasNext() == false) goto L324;
        Object r2127 = r1173.next();     // Catch: Throwable -> L327
        int r2128 = r1139 + 1;     // Catch: Throwable -> L327
        if (r1139 >= 0) goto L299;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L327
    L299:
        MVIState r1174 = (MVIState) r2127;     // Catch: Throwable -> L327
        if (((vz1.e) ((ItemListData) r1174).getItemData().c()).c().getId() != r339) goto L303;
        boolean r2129 = true;
    L304:
        if (r2129 == true) goto L1066;
        r1139 = r2128;
        goto L295
    L1066:
        new k0.a();     // Catch: Throwable -> L317
        ItemListData r345 = (ItemListData) r1174;     // Catch: Throwable -> L317
    L308:
        if ((!r1174.modifiedProperties.isEmpty()) == false) goto L311;
        ((t) r1171.c()).d(r1139);     // Catch: Throwable -> L327
    L311:
        if ((!r1169.modifiedProperties.isEmpty()) == false) goto L314;
        ((t) r342.c()).d(r299);     // Catch: Throwable -> L335
    L314:
        if ((!r341.modifiedProperties.isEmpty()) == false) goto L316;
        ((t) r340.c()).d(r297);
    L316:
        r298 = -1;
    L317:
        th = move-exception;
        if ((!r1174.modifiedProperties.isEmpty()) == false) goto L1197;
        ((t) r1171.c()).d(r1139);     // Catch: Throwable -> L327
        throw th;     // Catch: Throwable -> L327
    L1197:
        throw th;     // Catch: Throwable -> L327
    L303:
        r2129 = false;
    L324:
        if ((!r1169.modifiedProperties.isEmpty()) == false) goto L326;
        ((t) r342.c()).d(r299);     // Catch: Throwable -> L335
    L326:
        r299 = r1168;
    L327:
        th = move-exception;
        if ((!r1169.modifiedProperties.isEmpty()) == false) goto L1198;
        ((t) r342.c()).d(r299);     // Catch: Throwable -> L335
        throw th;     // Catch: Throwable -> L335
    L1198:
        throw th;     // Catch: Throwable -> L335
    L333:
        if ((!r341.modifiedProperties.isEmpty()) == false) goto L340;
        ((t) r340.c()).d(r297);
    L335:
        th = move-exception;
        if ((!r341.modifiedProperties.isEmpty()) == false) goto L1199;
        ((t) r340.c()).d(r297);
        throw th;
    L1199:
        throw th;
    }

    public static void k3(Context r2) {
        String r0 = nz1.a.d();
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(r2, r0);
    }

    public final String A1(int r2) {
        if (r2 == 15) goto L8;
        if (r2 == 17) goto L8;
        return BuildConfig.FLAVOR;
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().g() == false) goto L11;
        return (String) this.U.getValue();
    L11:
        return s1.B(2131914408);
    }

    public final int B1(int r3) {
        int r1 = 0;
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().i() == false) goto L13;
        GiftDataStorageService r0 = this.v2;
        if (r0 == null) goto L10;
        Map<Integer, Integer> r2 = r0.h;
        LinkedHashMap r4 = (LinkedHashMap) r2;
        Integer r5 = (Integer) r4.get(Integer.valueOf(r3));
        if (r5 == null) goto L9;
        r1 = r5.intValue();
    L9:
        Integer r6 = Integer.valueOf(r1);
    L12:
        return r6.intValue();
    L10:
        r6 = null;
        goto L12
    L13:
        Map<Integer, Integer> r7 = this.D;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        Integer r9 = (Integer) r8.get(Integer.valueOf(r3));
        if (r9 != null) goto L16;
        return 0;
    L16:
        return r9.intValue();
    }

    public final MVIState F(l0 r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$createState");
        GiftVerticalState r0 = new GiftVerticalState();
        ((ArrayList) this.C).clear();
        List<l2> r1 = this.C;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(this.P0.a);
        com.bytedance.android.livesdk.gift.platform.core.model.j r4 = this.M1.Mn(this.H2.b);
        com.bytedance.android.anya.r0<GiftVerticalState, GiftPanelDataExtra> r3 = r0.getPanelDataExtra();
        GiftPanelDataExtra r5 = new GiftPanelDataExtra(r4.e, r4.d, r4.f, r4.g);
        r13.getClass();
        l0.h(r3, r5);
        w3(this, r13, r0, r4, this.H2.b, false, 24);
        return r0;
    }

    public final int J1(int r2) {
        Map<Integer, Integer> r0 = this.L0.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Integer r3 = (Integer) r1.get(Integer.valueOf(r2));
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.intValue();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftListViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIVerticalListViewModel$bindToParent$1 r0 = GiftMVIVerticalListViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final List<vz1.e> m2(List<vz1.e> r5) {
        List<vz1.e> r6 = CollectionsKt.toMutableList(r5);
        int r0 = this.W.c() - 1;
        if (r0 < 0) goto L8;
        int r1 = 0;
    L5:
        int r2 = r1 * 4;
        x1(r6, r2, r2 + 3);
        x1(r6, r2 + 1, r2 + 2);
        if (r1 == r0) goto L8;
        r1 = r1 + 1;
    L8:
        return r6;
    }

    public final void q(com.bytedance.android.anya.dsl.l<GiftVerticalState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        GiftMVIVerticalListViewModel$buildStateMachine$1 r0 = new GiftMVIVerticalListViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        com.bytedance.android.anya.dsl.l.a r3 = new com.bytedance.android.anya.dsl.l.a();
        r0.invoke(r3);
        r1.put(GiftListBusinessState.Idle.class, r3.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftVerticalState, r, GiftAction>.a<GiftListBusinessState.GiftSelected>, Unit> r2 = new GiftMVIVerticalListViewModel$buildStateMachine$2(this);
        LinkedHashMap r4 = r5.a;
        com.bytedance.android.anya.dsl.l.a r6 = new com.bytedance.android.anya.dsl.l.a();
        r2.invoke(r6);
        r4.put(GiftListBusinessState.GiftSelected.class, r6.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftVerticalState, r, GiftAction>.a<GiftListBusinessState.GiftCombo>, Unit> r7 = new GiftMVIVerticalListViewModel$buildStateMachine$3(this);
        LinkedHashMap r8 = r5.a;
        com.bytedance.android.anya.dsl.l.a r9 = new com.bytedance.android.anya.dsl.l.a();
        r7.invoke(r9);
        r8.put(GiftListBusinessState.GiftCombo.class, r9.a);
    }

    public final List<vz1.e> s2(List<vz1.e> r5) {
        List<vz1.e> r6 = CollectionsKt.toMutableList(r5);
        int r0 = this.W.c() - 1;
        if (r0 < 0) goto L8;
        int r1 = 0;
    L5:
        int r2 = r1 * 4;
        x1(r6, r2, r2 + 2);
        x1(r6, r2 + 1, r2 + 3);
        if (r1 == r0) goto L8;
        r1 = r1 + 1;
    L8:
        return r6;
    }

    public final void G3(final l0<GiftVerticalState> r31, final GiftVerticalState r33) {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h r1 = this.z;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r33, "state");
        final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l0 r10 = r1.a;
        if (r10.a == false) goto L289;
        final Ref.IntRef r13 = new Ref.IntRef();
        r13.element = -1;
        final Ref.IntRef r15 = new Ref.IntRef();
        r15.element = -1;
        final Ref.BooleanRef r9 = new Ref.BooleanRef();
        r9.element = false;
        Ref.IntRef r7 = new Ref.IntRef();
        r7.element = -1;
        Ref.IntRef r6 = new Ref.IntRef();
        r6.element = -1;
        final Ref.IntRef r23 = r6;
        final Ref.IntRef r24 = r7;
        Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> r25 = new GiftMVIVerticalListViewModel$setDefaultSelectAfterRefresh$$inlined$modifyListDataWithRuleIndexed$1(r31, r33, r9, r10, r13, r15, r24, r23);
        k0 r2 = r31.b;
        t0<GiftVerticalState, PagerListData> r3 = r33.getPanelList();
        r2.getClass();
        Iterator r4 = k0.c(r3).iterator();
        int r8 = 0;
    L6:
        if (r4.hasNext() == false) goto L79;
        Object r5 = r4.next();
        int r11 = r8 + 1;
        if (r8 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        PagerListData r14 = (PagerListData) r5;
        Iterator r16 = k0.c(r14.getItemDataList()).iterator();
        int r17 = 0;
    L12:
        if (r16.hasNext() == false) goto L28;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        ItemListData r110 = (ItemListData) r18;
        vz1.e r20 = r10.d;
        if (r20 == null) goto L23;
        int r26 = r11;
        Iterator r27 = r4;
        if (r20.b == ((vz1.e) com.bytedance.android.anya.h.b(r110.getItemData())).b) goto L21;
    L24:
        boolean r0 = false;
    L25:
        if (r0 == false) goto L27;
        r25.invoke(r110, Integer.valueOf(r8), Integer.valueOf(r17), -1, -1);
    L27:
        r17 = r19;
        r11 = r26;
        r4 = r27;
        goto L12
    L21:
        if (r9.element == true) goto L24;
        r0 = true;
        goto L25
    L23:
        r27 = r4;
        r26 = r11;
        goto L24
    L28:
        Iterator r28 = r4;
        int r29 = r11;
        Iterator r21 = k0.c(r14.getCounterDataList()).iterator();
        int r30 = 0;
    L30:
        if (r21.hasNext() == false) goto L53;
        Object r34 = r21.next();
        int r35 = r30 + 1;
        if (r30 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        Iterator r36 = k0.c(((CounterData) r34).getItemDataList()).iterator();
        int r37 = 0;
    L36:
        if (r36.hasNext() == false) goto L52;
        Object r38 = r36.next();
        int r39 = r37 + 1;
        if (r37 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        ItemListData r111 = (ItemListData) r38;
        vz1.e r40 = r10.d;
        Iterator r210 = r36;
        int r41 = r35;
        if (r40 == null) goto L47;
        int r211 = r39;
        if (r40.b == ((vz1.e) com.bytedance.android.anya.h.b(r111.getItemData())).b) goto L45;
    L48:
        boolean r43 = false;
    L49:
        if (r43 == false) goto L51;
        r25.invoke(r111, Integer.valueOf(r8), Integer.valueOf(r37), Integer.valueOf(r30), -1);
    L51:
        r35 = r41;
        r36 = r210;
        r37 = r211;
        goto L36
    L45:
        if (r9.element == true) goto L48;
        r43 = true;
        goto L49
    L47:
        r211 = r39;
        goto L48
    L52:
        r30 = r35;
        goto L30
    L53:
        Iterator r44 = k0.c(r14.getTopicPagerListData()).iterator();
        int r45 = 0;
    L55:
        if (r44.hasNext() == false) goto L78;
        Object r46 = r44.next();
        int r47 = r45 + 1;
        if (r45 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        Iterator r48 = k0.c(((TopicPagerListData) r46).getItemDataList()).iterator();
        int r49 = 0;
    L61:
        if (r48.hasNext() == false) goto L77;
        Object r50 = r48.next();
        int r51 = r49 + 1;
        if (r49 >= 0) goto L65;
        CollectionsKt.throwIndexOverflow();
    L65:
        ItemListData r112 = (ItemListData) r50;
        vz1.e r53 = r10.d;
        Iterator r54 = r48;
        int r55 = r47;
        if (r53 == null) goto L72;
        int r212 = r51;
        if (r53.b == ((vz1.e) com.bytedance.android.anya.h.b(r112.getItemData())).b) goto L70;
    L73:
        boolean r56 = false;
    L74:
        if (r56 == false) goto L76;
        r25.invoke(r112, Integer.valueOf(r8), Integer.valueOf(r49), -1, Integer.valueOf(r45));
    L76:
        r47 = r55;
        r48 = r54;
        r49 = r212;
        goto L61
    L70:
        if (r9.element == true) goto L73;
        r56 = true;
        goto L74
    L72:
        r212 = r51;
        goto L73
    L77:
        r45 = r47;
        goto L55
    L78:
        r8 = r29;
        r4 = r28;
        goto L6
    L79:
        Unit r57 = Unit.INSTANCE;
        com.bytedance.android.anya.internal.c r58 = (u) r33.getPanelList();
        Iterator r59 = ((Iterable) r58.c()).iterator();
        int r60 = 0;
        boolean r61 = false;
        boolean r63 = false;
    L81:
        if (r59.hasNext() == false) goto L244;
        Object r64 = r59.next();
        int r65 = r60 + 1;
        if (r60 >= 0) goto L85;
        CollectionsKt.throwIndexOverflow();
    L85:
        MVIState r66 = (MVIState) r64;
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r66).getTabType())).intValue() != r10.e) goto L88;
        boolean r67 = true;
    L89:
        if (r67 == false) goto L90;
        new k0.a();     // Catch: Throwable -> L238
        PagerListData r68 = (PagerListData) r66;     // Catch: Throwable -> L238
        u r69 = r68.getItemDataList();     // Catch: Throwable -> L238
        u r70 = r69;     // Catch: Throwable -> L238
        Iterator r71 = ((Iterable) r69.c()).iterator();     // Catch: Throwable -> L238
        int r73 = 0;
    L93:
        if (r71.hasNext() == false) goto L120;
        Object r113 = r71.next();     // Catch: Throwable -> L238
        int r114 = r73 + 1;     // Catch: Throwable -> L238
        if (r73 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L238
    L97:
        Iterator r115 = r71;
        MVIState r74 = (MVIState) r113;     // Catch: Throwable -> L238
        Iterator r213 = r59;
        long r116 = ((vz1.e) ((ItemListData) r74).getItemData().c()).b;     // Catch: Throwable -> L238
        vz1.e r75 = r10.d;     // Catch: Throwable -> L238
        com.bytedance.android.anya.internal.c r117 = r58;
        if (r75 != null) goto L311;
    L104:
        boolean r76 = false;
    L105:
        if (r76 == true) goto L300;
        r58 = r117;
        r73 = r114;
        r71 = r115;
        r59 = r213;
        goto L93
    L300:
        new k0.a();     // Catch: Throwable -> L115
        ItemListData r77 = (ItemListData) r74;     // Catch: Throwable -> L115
        vz1.e r78 = r10.d;     // Catch: Throwable -> L115
        if (r78 == null) goto L110;
        r77.getItemData().a(r78);     // Catch: Throwable -> L115
        Unit r79 = Unit.INSTANCE;     // Catch: Throwable -> L115
    L110:
        r13.element = r60;     // Catch: Throwable -> L115
        r15.element = r73;     // Catch: Throwable -> L115
        if ((!r74.modifiedProperties.isEmpty()) == false) goto L114;
        ((t) r69.c()).d(r73);     // Catch: Throwable -> L236
    L114:
        boolean r214 = r61;
        MVIState r118 = r66;
        boolean r215 = r63;
        Ref.IntRef r80 = r23;
        Ref.IntRef r216 = r24;
    L229:
        MVIState r81 = r118;
        r63 = r215;
        r61 = r214;
    L231:
        if ((!r81.modifiedProperties.isEmpty()) == false) goto L233;
        ((t) r117.c()).d(r60);
    L233:
        r23 = r80;
        r60 = r65;
        r58 = r117;
        r59 = r213;
        r24 = r216;
        goto L81
    L115:
        th = move-exception;
        if ((!r74.modifiedProperties.isEmpty()) == false) goto L119;
        ((t) r69.c()).d(r73);     // Catch: Throwable -> L236
    L119:
        throw th;     // Catch: Throwable -> L236
    L236:
        th = th;
    L241:
        if ((!r66.modifiedProperties.isEmpty()) == false) goto L243;
        ((t) r117.c()).d(r60);
    L243:
        throw th;
    L311:
        if (r116 != r75.b) goto L104;
        r76 = true;
        goto L105
    L120:
        r213 = r59;
        r117 = r58;
        u r83 = r68.getCounterDataList();     // Catch: Throwable -> L236
        u r84 = r83;     // Catch: Throwable -> L236
        Iterator r85 = ((Iterable) r83.c()).iterator();     // Catch: Throwable -> L236
        int r86 = 0;
    L122:
        if (r85.hasNext() == false) goto L176;
        Object r87 = r85.next();     // Catch: Throwable -> L236
        int r88 = r86 + 1;     // Catch: Throwable -> L236
        if (r86 >= 0) goto L126;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L236
    L126:
        MVIState r89 = (MVIState) r87;     // Catch: Throwable -> L236
        new k0.a();     // Catch: Throwable -> L170
        u r119 = ((CounterData) r89).getItemDataList();     // Catch: Throwable -> L170
        u r120 = r119;     // Catch: Throwable -> L170
        Iterator r121 = ((Iterable) r119.c()).iterator();     // Catch: Throwable -> L170
        int r90 = 0;
    L129:
        if (r121.hasNext() == false) goto L165;
        Object r122 = r121.next();     // Catch: Throwable -> L170
        int r217 = r90 + 1;     // Catch: Throwable -> L170
        if (r90 >= 0) goto L133;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L170
    L133:
        Iterator r218 = r121;
        MVIState r123 = (MVIState) r122;     // Catch: Throwable -> L170
        Iterator r219 = r85;
        boolean r220 = r61;
        MVIState r124 = r66;
        long r91 = ((vz1.e) ((ItemListData) r123).getItemData().c()).b;     // Catch: Throwable -> L163
        vz1.e r93 = r10.d;     // Catch: Throwable -> L163
        u r221 = r83;
        if (r93 != null) goto L302;
    L144:
        boolean r94 = false;
    L145:
        if (r94 == true) goto L298;
        r66 = r124;
        r90 = r217;
        r121 = r218;
        r85 = r219;
        r61 = r220;
        r83 = r221;
        goto L129
    L298:
        new k0.a();     // Catch: Throwable -> L158
        ItemListData r95 = (ItemListData) r123;     // Catch: Throwable -> L158
        vz1.e r96 = r10.d;     // Catch: Throwable -> L158
        if (r96 == null) goto L150;
        r95.getItemData().a(r96);     // Catch: Throwable -> L158
        Unit r97 = Unit.INSTANCE;     // Catch: Throwable -> L158
    L150:
        r13.element = r60;     // Catch: Throwable -> L158
        r15.element = r90;     // Catch: Throwable -> L158
        Ref.IntRef r98 = r24;
        r98.element = r86;     // Catch: Throwable -> L158
        if ((!r123.modifiedProperties.isEmpty()) == false) goto L306;
        ((t) r119.c()).d(r90);     // Catch: Throwable -> L142
    L306:
    L234:
        th = th;
        r66 = r124;
        goto L241
    L155:
        if ((!r89.modifiedProperties.isEmpty()) == false) goto L157;
        ((t) r221.c()).d(r86);     // Catch: Throwable -> L234
    L157:
        r216 = r98;
        r81 = r124;
        r80 = r23;
        r61 = r220;
        r63 = true;
        goto L231
    L158:
        th = move-exception;
        if ((!r123.modifiedProperties.isEmpty()) == false) goto L162;
        ((t) r119.c()).d(r90);     // Catch: Throwable -> L142
    L162:
        throw th;     // Catch: Throwable -> L142
    L142:
        th = th;
    L173:
        if ((!r89.modifiedProperties.isEmpty()) == false) goto L175;
        ((t) r221.c()).d(r86);     // Catch: Throwable -> L234
    L175:
        throw th;     // Catch: Throwable -> L234
    L302:
        if (r91 != r93.b) goto L144;
        r94 = true;
    L163:
        th = th;
        r221 = r83;
        goto L173
    L165:
        Iterator r222 = r85;
        u r223 = r83;
        boolean r224 = r61;
        MVIState r125 = r66;
        Ref.IntRef r99 = r24;
        if ((!r89.modifiedProperties.isEmpty()) == false) goto L169;
        ((t) r223.c()).d(r86);     // Catch: Throwable -> L234
    L169:
        r24 = r99;
        r86 = r88;
        r66 = r125;
        r85 = r222;
        r61 = r224;
        r83 = r223;
    L170:
        th = th;
        r221 = r83;
        goto L173
    L176:
        r214 = r61;
        r118 = r66;
        Ref.IntRef r100 = r24;
        u r101 = r68.getTopicPagerListData();     // Catch: Throwable -> L234
        u r102 = r101;     // Catch: Throwable -> L234
        Iterator r103 = ((Iterable) r101.c()).iterator();     // Catch: Throwable -> L234
        int r104 = 0;
    L178:
        if (r103.hasNext() == false) goto L228;
        Object r105 = r103.next();     // Catch: Throwable -> L234
        int r106 = r104 + 1;     // Catch: Throwable -> L234
        if (r104 >= 0) goto L182;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L234
    L182:
        MVIState r107 = (MVIState) r105;     // Catch: Throwable -> L234
        new k0.a();     // Catch: Throwable -> L217
        u r108 = ((TopicPagerListData) r107).getItemDataList();     // Catch: Throwable -> L217
        u r109 = r108;     // Catch: Throwable -> L217
        Iterator r126 = ((Iterable) r108.c()).iterator();     // Catch: Throwable -> L217
        int r127 = 0;
    L185:
        if (r126.hasNext() == false) goto L219;
        Object r128 = r126.next();     // Catch: Throwable -> L217
        int r129 = r127 + 1;     // Catch: Throwable -> L217
        if (r127 >= 0) goto L189;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L217
    L189:
        MVIState r130 = (MVIState) r128;     // Catch: Throwable -> L217
        Iterator r225 = r103;
        boolean r226 = r63;
        Iterator r227 = r126;
        long r131 = ((vz1.e) ((ItemListData) r130).getItemData().c()).b;     // Catch: Throwable -> L217
        vz1.e r132 = r10.d;     // Catch: Throwable -> L217
        r216 = r100;
        u r228 = r101;
        if (r132 != null) goto L304;
    L198:
        boolean r133 = false;
    L199:
        if (r133 == true) goto L294;
        r127 = r129;
        r63 = r226;
        r103 = r225;
        r126 = r227;
        r100 = r216;
        r101 = r228;
        goto L185
    L294:
        new k0.a();     // Catch: Throwable -> L212
        ItemListData r134 = (ItemListData) r130;     // Catch: Throwable -> L212
        vz1.e r135 = r10.d;     // Catch: Throwable -> L212
        if (r135 == null) goto L204;
        r134.getItemData().a(r135);     // Catch: Throwable -> L212
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L212
    L204:
        r13.element = r60;     // Catch: Throwable -> L212
        r15.element = r127;     // Catch: Throwable -> L212
        r80 = r23;
        r80.element = r104;     // Catch: Throwable -> L212
        if ((!r130.modifiedProperties.isEmpty()) == false) goto L209;
        ((t) r108.c()).d(r127);     // Catch: Throwable -> L196
    L209:
        if ((!r107.modifiedProperties.isEmpty()) == false) goto L211;
        ((t) r228.c()).d(r104);     // Catch: Throwable -> L234
    L211:
        r81 = r118;
        r63 = r226;
        r61 = true;
        goto L231
    L212:
        th = move-exception;
        if ((!r130.modifiedProperties.isEmpty()) == false) goto L216;
        ((t) r108.c()).d(r127);     // Catch: Throwable -> L196
    L216:
        throw th;     // Catch: Throwable -> L196
    L196:
        th = th;
    L225:
        if ((!r107.modifiedProperties.isEmpty()) == false) goto L227;
        ((t) r228.c()).d(r104);     // Catch: Throwable -> L234
    L227:
        throw th;     // Catch: Throwable -> L234
    L304:
        if (r131 != r132.b) goto L198;
        r133 = true;
        goto L199
    L219:
        Ref.IntRef r229 = r100;
        u r230 = r101;
        Iterator r231 = r103;
        boolean r232 = r63;
        Ref.IntRef r137 = r23;
        if ((!r107.modifiedProperties.isEmpty()) == false) goto L223;
        ((t) r230.c()).d(r104);     // Catch: Throwable -> L234
    L223:
        r23 = r137;
        r104 = r106;
        r63 = r232;
        r103 = r231;
        r100 = r229;
        r101 = r230;
    L217:
        th = th;
        r228 = r101;
        goto L225
    L228:
        r216 = r100;
        r215 = r63;
        r80 = r23;
    L238:
        th = th;
        r117 = r58;
        goto L241
    L90:
        r60 = r65;
        goto L81
    L88:
        r67 = false;
        goto L89
    L244:
        boolean r233 = r61;
        Ref.IntRef r138 = r23;
        Ref.IntRef r234 = r24;
        if (r63 == true) goto L247;
        r234.element = -1;
    L247:
        if (r233 == true) goto L249;
        r138.element = -1;
    L249:
        int r139 = r13.element;
        if (r139 == (-1)) goto L257;
        if (r139 == ((Number) com.bytedance.android.anya.h.b(r33.getCurrentPagePosition())).intValue()) goto L254;
        e3(this, r31, r33, r13.element, false, "slide", false, 40);
    L254:
        J3(this, r31, r33, r13.element, r15.element, SelectedStatus.LOCATE, r234.element, "afterRefreshList", r138.element, 128);
        GiftMVIVerticalListViewModel r140 = this;
    L255:
        l0<GiftVerticalState> r141 = r31;
        GiftVerticalState r142 = r33;
    L291:
        if (nz1.a.o() == true) goto L346;
        r140.z.b(r141, r142);
        Unit r143 = Unit.INSTANCE;
        return;
    L346:
        return;
    L257:
        if (r9.element == true) goto L286;
        vz1.e r144 = r10.d;
        if (r144 == null) goto L263;
        if (r144.e == true) goto L286;
    L263:
        if (r144 == null) goto L265;
        long r145 = r144.b;
    L267:
        if (r145 <= 0) goto L286;
        r140 = this;
        Iterator r146 = ((LinkedHashMap) r140.L0.c).entrySet().iterator();
    L270:
        if (r146.hasNext() == false) goto L277;
        Object r147 = r146.next();
        if (((Number) ((Map.Entry) r147).getValue()).intValue() != 1) goto L274;
        boolean r148 = true;
    L275:
        if (r148 == false) goto L270;
    L278:
        Map.Entry r149 = (Map.Entry) r147;
        if (r149 == null) goto L283;
        Integer r150 = (Integer) r149.getKey();
        if (r150 == null) goto L283;
        int r151 = r150.intValue();
    L284:
        if (r151 < 0) goto L255;
        r141 = r31;
        r142 = r33;
        r140.w1(r141, r142, ClearGiftSource.ChangeTab);
        e3(this, r31, r33, r151, false, "slide", false, 40);
        r140.z.g(r141, r142, r151, "afterRefreshList");
        Unit r152 = Unit.INSTANCE;
    L283:
        r151 = -1;
        goto L284
    L274:
        r148 = false;
        goto L275
    L277:
        r147 = null;
        goto L278
    L265:
        r145 = 0;
    L286:
        r140 = this;
        r141 = r31;
        r142 = r33;
        if (nz1.a.o() == false) goto L291;
        r140.z.b(r141, r142);
        Unit r153 = Unit.INSTANCE;
        goto L291
    L289:
        r141 = r31;
        r140 = this;
        r142 = r33;
        goto L291
    }

    public final void J0(com.bytedance.android.anya.internal.e r6, MVIState r7) {
        final GiftVerticalState r8 = (GiftVerticalState) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        com.bytedance.android.anya.t<GiftTabDataStore, vz1.j> r0 = this.M2.s();
        GiftTabDataStore r1 = this.M2;
        r6.d(r0, (com.bytedance.android.anya.t) r1.g.getValue(r1, GiftTabDataStore.p[1]), new GiftMVIVerticalListViewModel$reduce$23(this, r8));
        r6.e(this.x1.R(), new GiftMVIVerticalListViewModel$reduce$24(this, r8));
        if (v.e() == false) goto L6;
        r6.e(this.p2.n(), new GiftMVIVerticalListViewModel$reduce$25(this, r8));
    L6:
        if (nz1.a.h().c() == false) goto L9;
        r6.e(this.b2.n(), new GiftMVIVerticalListViewModel$reduce$26(this, r8));
    L9:
        if (nz1.a.h().d() == false) goto L11;
        com.bytedance.android.anya.t<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c, com.bytedance.android.livesdk.gift.model.n> r2 = this.b2.o();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r3 = this.b2;
        r6.d(r2, (com.bytedance.android.anya.t) r3.j.getValue(r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c.u[4]), new GiftMVIVerticalListViewModel$reduce$27(this, r8));
    L11:
        r6.d(this.x2.L(), this.x2.F(), new GiftMVIVerticalListViewModel$reduce$28(this, r8));
        r6.e(this.x2.w(), new GiftMVIVerticalListViewModel$reduce$29(this, r8));
        r6.e(this.x1.L(), new GiftMVIVerticalListViewModel$reduce$30(this, r8));
        r6.e(this.J2.n(), new GiftMVIVerticalListViewModel$reduce$31(this, r8));
    }

    public final void N3(int r2, int r3) {
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().i() == false) goto L7;
        GiftDataStorageService r0 = this.v2;
        if (r0 == null) goto L9;
        r0.h.put(Integer.valueOf(r2), Integer.valueOf(r3));
        return;
    L9:
        return;
    L7:
        this.D.put(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    public final void u1(final l0<GiftVerticalState> r21, final GiftVerticalState r23) {
        this.g2.k();
        SubStatePropertyImpl r2 = r23.getComboState();
        new k0.a();
        GiftComboState r3 = (GiftComboState) r2.c();
        r3.getComboNum().a(0);
        com.bytedance.android.anya.internal.c r4 = r3.getComboStatus();
        com.bytedance.android.anya.internal.c r5 = r4;
        r5.a(ComboState.IDLE);
        r3.getPositionX().a(0);
        r3.getPositionY().a(0);
        Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> r6 = new GiftMVIVerticalListViewModel$clearCombo$$inlined$modifyListDataWithRule$1(r21, r23);
        k0 r1 = r21.b;
        t0<GiftVerticalState, PagerListData> r7 = r23.getPanelList();
        r1.getClass();
        Iterator r8 = k0.c(r7).iterator();
        int r9 = 0;
    L4:
        if (r8.hasNext() == false) goto L62;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PagerListData r13 = (PagerListData) r10;
        Iterator r14 = k0.c(r13.getItemDataList()).iterator();
        int r15 = 0;
    L9:
        boolean r16 = true;
        if (r14.hasNext() == false) goto L21;
        Object r17 = r14.next();
        int r18 = r15 + 1;
        if (r15 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ItemListData r19 = (ItemListData) r17;
        if (((ItemStatus) com.bytedance.android.anya.h.b(r19.getItemStatus())) == ItemStatus.GONE) goto L18;
        r16 = false;
    L18:
        if (r16 == false) goto L20;
        r6.invoke(r19, Integer.valueOf(r9), Integer.valueOf(r15), -1, -1);
    L20:
        r15 = r18;
        goto L9
    L21:
        Iterator r110 = k0.c(r13.getCounterDataList()).iterator();
        int r111 = 0;
    L23:
        if (r110.hasNext() == false) goto L41;
        Object r20 = r110.next();
        int r112 = r111 + 1;
        if (r111 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        Iterator r113 = k0.c(((CounterData) r20).getItemDataList()).iterator();
        int r24 = 0;
    L29:
        if (r113.hasNext() == false) goto L40;
        Object r25 = r113.next();
        int r114 = r24 + 1;
        if (r24 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        ItemListData r26 = (ItemListData) r25;
        if (((ItemStatus) com.bytedance.android.anya.h.b(r26.getItemStatus())) != ItemStatus.GONE) goto L36;
        boolean r27 = true;
    L37:
        if (r27 == false) goto L39;
        r6.invoke(r26, Integer.valueOf(r9), Integer.valueOf(r24), Integer.valueOf(r111), -1);
    L39:
        r24 = r114;
        goto L29
    L36:
        r27 = false;
        goto L37
    L40:
        r111 = r112;
        goto L23
    L41:
        Iterator r115 = k0.c(r13.getTopicPagerListData()).iterator();
        int r116 = 0;
    L43:
        if (r115.hasNext() == false) goto L61;
        Object r28 = r115.next();
        int r117 = r116 + 1;
        if (r116 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        Iterator r118 = k0.c(((TopicPagerListData) r28).getItemDataList()).iterator();
        int r29 = 0;
    L49:
        if (r118.hasNext() == false) goto L60;
        Object r30 = r118.next();
        int r119 = r29 + 1;
        if (r29 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        ItemListData r31 = (ItemListData) r30;
        if (((ItemStatus) com.bytedance.android.anya.h.b(r31.getItemStatus())) != ItemStatus.GONE) goto L56;
        boolean r33 = true;
    L57:
        if (r33 == false) goto L59;
        r6.invoke(r31, Integer.valueOf(r9), Integer.valueOf(r29), -1, Integer.valueOf(r116));
    L59:
        r29 = r119;
        goto L49
    L56:
        r33 = false;
        goto L57
    L60:
        r116 = r117;
        goto L43
    L61:
        r9 = r11;
        goto L4
    L62:
        this.y.a();
        h0 r34 = this.Z;
        GiftTransaction r35 = r34.a;
        if (r35 == null) goto L65;
        r35.finish();
    L65:
        r34.a = null;
        this.S1.R(ComboStatus.IDLE);
    }

    public static void P3(final l0 r21, final GiftVerticalState r23, final long r24) {
        Function5<ItemListData, Integer, Integer, Integer, Integer, Unit> r6 = new GiftMVIVerticalListViewModel$updatePropsExpireTime$$inlined$modifyListDataWithRule$1(r21, r23, r24);
        k0 r0 = r21.b;
        t0<GiftVerticalState, PagerListData> r1 = r23.getPanelList();
        r0.getClass();
        Iterator r7 = k0.c(r1).iterator();
        int r9 = 0;
    L4:
        if (r7.hasNext() == false) goto L70;
        Object r2 = r7.next();
        int r10 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        PagerListData r11 = (PagerListData) r2;
        Iterator r13 = k0.c(r11.getItemDataList()).iterator();
        int r3 = 0;
    L9:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L23;
        Object r4 = r13.next();
        int r17 = r3 + 1;
        if (r3 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        ItemListData r5 = (ItemListData) r4;
        if (((vz1.e) com.bytedance.android.anya.h.b(r5.getItemData())).a.getGiftEndingTime() <= 0) goto L17;
    L20:
        if (r14 == false) goto L22;
        r6.invoke(r5, Integer.valueOf(r9), Integer.valueOf(r3), -1, -1);
    L22:
        r3 = r17;
        goto L9
    L17:
        if (((vz1.e) com.bytedance.android.anya.h.b(r5.getItemData())).g.d > 0) goto L20;
        r14 = false;
        goto L20
    L23:
        Iterator r15 = k0.c(r11.getCounterDataList()).iterator();
        int r18 = 0;
    L25:
        if (r15.hasNext() == false) goto L46;
        Object r8 = r15.next();
        int r19 = r18 + 1;
        if (r18 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        Iterator r110 = k0.c(((CounterData) r8).getItemDataList()).iterator();
        int r16 = 0;
    L31:
        if (r110.hasNext() == false) goto L45;
        Object r20 = r110.next();
        int r25 = r16 + 1;
        if (r16 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        ItemListData r26 = (ItemListData) r20;
        if (((vz1.e) com.bytedance.android.anya.h.b(r26.getItemData())).a.getGiftEndingTime() <= 0) goto L38;
    L41:
        boolean r27 = true;
    L42:
        if (r27 == false) goto L44;
        r6.invoke(r26, Integer.valueOf(r9), Integer.valueOf(r16), Integer.valueOf(r18), -1);
    L44:
        r16 = r25;
        goto L31
    L38:
        if (((vz1.e) com.bytedance.android.anya.h.b(r26.getItemData())).g.d > 0) goto L41;
        r27 = false;
        goto L42
    L45:
        r18 = r19;
        goto L25
    L46:
        Iterator r111 = k0.c(r11.getTopicPagerListData()).iterator();
        int r112 = 0;
    L48:
        if (r111.hasNext() == false) goto L69;
        Object r28 = r111.next();
        int r113 = r112 + 1;
        if (r112 >= 0) goto L52;
        CollectionsKt.throwIndexOverflow();
    L52:
        Iterator r114 = k0.c(((TopicPagerListData) r28).getItemDataList()).iterator();
        int r29 = 0;
    L54:
        if (r114.hasNext() == false) goto L68;
        Object r30 = r114.next();
        int r115 = r29 + 1;
        if (r29 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        ItemListData r31 = (ItemListData) r30;
        if (((vz1.e) com.bytedance.android.anya.h.b(r31.getItemData())).a.getGiftEndingTime() <= 0) goto L61;
    L64:
        boolean r33 = true;
    L65:
        if (r33 == false) goto L67;
        r6.invoke(r31, Integer.valueOf(r9), Integer.valueOf(r29), -1, Integer.valueOf(r112));
    L67:
        r29 = r115;
        goto L54
    L61:
        if (((vz1.e) com.bytedance.android.anya.h.b(r31.getItemData())).g.d > 0) goto L64;
        r33 = false;
        goto L65
    L68:
        r112 = r113;
        goto L48
    L69:
        r9 = r10;
        goto L4
    }

    public static void x1(List r2, int r3, int r4) {
        List r0 = r2;
        int r1 = r0.size();
        if (r3 < 0) goto L14;
        if (r1 <= r3) goto L12;
        int r5 = r0.size();
        if (r4 < 0) goto L13;
        if (r5 <= r4) goto L15;
        Object r6 = ListProtector.get(r2, r3);
        ListProtector.set(r2, r3, ListProtector.get(r2, r4));
        ListProtector.set(r2, r4, r6);
        return;
    L15:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final List<vz1.e> C1(int r2, List<vz1.e> r3, int r4) {
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L10;
        return r3;
    L10:
        return L3(r3, r4, false);
    L9:
        return L3(r3, r4, true);
    }

    public final List<vz1.e> L3(List<vz1.e> r7, int r8, boolean r9) {
        vz1.e r0 = (vz1.e) CollectionsKt.getOrNull(r7, r8);
        if (r9 == false) goto L14;
        List r10 = CollectionsKt.sortedWith(r7, new c());
        ArrayList r11 = new ArrayList();
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L13;
        Object r4 = r13.next();
        if (((vz1.e) r4).a.getType() == 3) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
        r11.add(r4);
        goto L6
    L10:
        r5 = false;
        goto L11
    L13:
        List<vz1.e> r14 = CollectionsKt.toMutableList(r11);
    L24:
        if (r0 == null) goto L26;
        ListProtector.add(r14, r8, r0);
    L26:
        return r14;
    L14:
        List r15 = CollectionsKt.sortedWith(r7, new d());
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L16:
        if (r17.hasNext() == false) goto L23;
        Object r6 = r17.next();
        if (((vz1.e) r6).a.getType() == 3) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L16;
        r16.add(r6);
        goto L16
    L20:
        r18 = false;
        goto L21
    L23:
        r14 = CollectionsKt.toMutableList(r16);
        goto L24
    }

    public final void R2(l0<GiftVerticalState> r26, GiftVerticalState r27, UpdatePanelGiftList r28) {
        com.bytedance.android.livesdk.gift.platform.core.model.j r9 = this.M1.Mn(r28.getReceiverType());
        List<w1> r0 = r9.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        boolean r2 = true;
    L15:
        Pair<Integer, Long> r3 = new Pair(-1, -3L);
        if (r2 == true) goto L111;
        List<w1> r4 = r9.c;
        if (r4 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L111;
        com.bytedance.android.anya.r0<GiftVerticalState, GiftPanelDataExtra> r6 = r27.getPanelDataExtra();
        r26.getClass();
        GiftPanelDataExtra r16 = (GiftPanelDataExtra) com.bytedance.android.anya.h.b(r6);
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        k0 r10 = r26.b;
        t0<GiftVerticalState, PagerListData> r11 = r27.getPanelList();
        r10.getClass();
        Iterator r13 = k0.c(r11).iterator();
    L27:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r14).getTabType())).intValue() != 1) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
    L35:
        PagerListData r17 = (PagerListData) r14;
        if (r17 == null) goto L43;
        t0<PagerListData, ItemListData> r18 = r17.getItemDataList();
        if (r18 == null) goto L43;
        Iterator r19 = k0.c(r18).iterator();
    L41:
        if (r19.hasNext() == false) goto L43;
        r7.add(Long.valueOf(((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) r19.next()).getItemData())).b));
    L43:
        w3(this, r26, r27, r9, r28.getReceiverType(), true, 8);
        k0 r20 = r26.b;
        t0<GiftVerticalState, PagerListData> r21 = r27.getPanelList();
        r20.getClass();
        Iterator r23 = k0.c(r21).iterator();
    L45:
        if (r23.hasNext() == false) goto L52;
        Object r24 = r23.next();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r24).getTabType())).intValue() != 1) goto L49;
        boolean r25 = true;
    L50:
        if (r25 == false) goto L45;
    L53:
        PagerListData r29 = (PagerListData) r24;
        if (r29 == null) goto L61;
        t0<PagerListData, ItemListData> r30 = r29.getItemDataList();
        if (r30 == null) goto L61;
        Iterator r31 = k0.c(r30).iterator();
    L59:
        if (r31.hasNext() == false) goto L61;
        r8.add(Long.valueOf(((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) r31.next()).getItemData())).b));
    L61:
        Iterator r33 = r7.iterator();
        int r34 = 0;
    L63:
        if (r33.hasNext() == false) goto L74;
        long r35 = ((Number) r33.next()).longValue();
        if (r34 >= r8.size()) goto L66;
        if (r34 >= r7.size()) goto L69;
        if (((Number) ListProtector.get(r8, r34)).longValue() != r35) goto L72;
        r34 = r34 + 1;
        goto L63
    L72:
        Pair<Integer, Long> r36 = new Pair(Integer.valueOf(r34), ListProtector.get(r8, r34));
    L75:
        GiftPanelMonitorService r37 = this.g1;
        long r38 = this.I;
        r37.getClass();
        Intrinsics.checkNotNullParameter(r7, "oldList");
        Intrinsics.checkNotNullParameter(r8, "newList");
        if ((!r37.F.isEmpty()) == true) goto L83;
        GiftPanelMonitorService.b r39 = r37.H;
        if (r39 != null) goto L81;
        LocateGiftInfo r110 = null;
        r37.F.put("display_list_change_type", "no_select");
    L110:
        GiftPanelDataExtra r111 = r16;
        Pair<Integer, Long> r112 = r36;
    L112:
        t0<GiftVerticalState, PagerListData> r40 = r27.getPanelList();
        r26.getClass();
        if (com.bytedance.android.anya.h.a(r40) != 0) goto L137;
        boolean r41 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r43 = this.H2;
        IBaseUser r44 = r43.a;
        int r45 = this.v1.f(r43.b);
        Intrinsics.checkNotNullParameter(r44, "toUser");
        JSONObject r46 = new JSONObject();
        r46.put("send_scene", r45);
        r46.put("is_send_all_mic", com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() ? 1 : 0);
        List<IBaseUser> r47 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.e();
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r49 = r47.iterator();
    L116:
        if (r49.hasNext() == false) goto L118;
        r48.add(((IBaseUser) r49.next()).getIdString());
        goto L116
    L118:
        r46.put("user_identifier", com.bytedance.android.livesdk.gift.platform.core.d0.a(r48));
        r46.put("to_user_identifier", com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d().getValue());
        JSONObject r50 = new JSONObject();
        Object r51 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        yz0.k r53 = com.bytedance.android.livesdk.gift.platform.core.d0.b();
        if (r53 == null) goto L123;
        IRoom r54 = r53.getRoom();
        if (r54 == null) goto L123;
        long r55 = r54.getRoomId();
    L124:
        r50.put("room_id", r55);
        if (r51 != null) goto L127;
        r51 = 0L;
    L127:
        r50.put("user_id", r51);
        r50.put("to_user_id", r44.getIdString());
        yz0.k r56 = com.bytedance.android.livesdk.gift.platform.core.d0.b();
        if (r56 == null) goto L130;
        long r57 = r56.Hl();
    L132:
        if (r57 <= 0) goto L134;
        r50.put("stay_room_duration", System.currentTimeMillis() - r57);
    L135:
        LiveTracingMonitor.f("ttlive_gift_panel_empty_status", LiveTracingMonitor.EventModule.LIVE_GIFT, r46, r50, new JSONObject());
        goto L137
    L134:
        r50.put("stay_room_duration", 0);
        goto L135
    L130:
        r57 = 0;
    L123:
        r55 = 0;
    L137:
        k0 r58 = r26.b;
        t0<GiftVerticalState, PagerListData> r59 = r27.getPanelList();
        r58.getClass();
        Iterator r60 = k0.c(r59).iterator();
    L139:
        if (r60.hasNext() == false) goto L146;
        Object r61 = r60.next();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) r61).getTabType())).intValue() != 1) goto L143;
        boolean r63 = true;
    L144:
        if (r63 == false) goto L139;
    L147:
        PagerListData r64 = (PagerListData) r61;
        if (r64 == null) goto L156;
        t0<PagerListData, ItemListData> r65 = r64.getItemDataList();
        if (r65 == null) goto L156;
        Iterator r66 = k0.c(r65).iterator();
        int r67 = 0;
    L153:
        if (r66.hasNext() == false) goto L155;
        ItemListData r68 = (ItemListData) r66.next();
        r67 = r67 + 1;
        goto L153
    L155:
        int r113 = r67;
    L157:
        com.bytedance.android.livesdk.gift.platform.core.model.j r69 = r9;
        this.g1.j(r69.c);
        GiftPanelMonitorService r70 = this.g1;
        int r114 = this.V1.e;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r71 = this.H2;
        IBaseUser r115 = r71.a;
        GiftListPanelRepository r73 = this.M1;
        ReceiverType r74 = r71.b;
        r73.getClass();
        Intrinsics.checkNotNullParameter(r74, "receiverType");
        com.bytedance.android.livesdk.gift.platform.core.model.l r75 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) r73.a).get(r74);
        if (r75 == null) goto L165;
        List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r76 = r75.a;
        if (r76 == null) goto L165;
        if ((!r76.isEmpty()) != true) goto L165;
        boolean r116 = true;
    L166:
        LocateGiftInfo r77 = r110;
        r70.d(r69, r113, r114, r112, r115, r116, r111);
        if (nz1.a.o() == true) goto L204;
        OpenDialogService r78 = this.h1;
        LocateGiftInfo r79 = r78.d;
        if (r79 == null) goto L205;
        Intrinsics.checkNotNull(r79);
        if (r79.getTargetGiftId() <= 0) goto L206;
        uz1.a r80 = b0.a();
        if (r80 == null) goto L175;
        LocateGiftInfo r81 = r78.d;
        Intrinsics.checkNotNull(r81);
        r80.a(new OnLocateGiftRequestReceived(r81, 1));
    L175:
        r78.d = r77;
        return;
    L206:
        return;
    L205:
        return;
    L204:
        return;
    L165:
        r116 = false;
    L156:
        r113 = 0;
        goto L157
    L143:
        r63 = false;
        goto L144
    L146:
        r61 = r110;
        goto L147
    L81:
        if (r39.e == 1) goto L84;
        r37.F.put("display_list_change_type", "not_gift_tab");
        goto L83
    L84:
        StringBuilder r117 = new StringBuilder();
        if (r38 == r39.a) goto L87;
        r117.append("select_gift,");
    L87:
        int r118 = r8.indexOf(Long.valueOf(r39.a));
        if (r118 == r39.b) goto L90;
        r117.append("select_position,");
    L90:
        int r119 = (r39.b / 4) * 4;
        int r83 = Math.min(r119 + 11, Math.min(r7.size(), r8.size()));
        if (r119 > r83) goto L104;
        int r120 = r119;
    L94:
        if (r120 >= r8.size()) goto L104;
        if (r120 >= r7.size()) goto L104;
        if (((Number) ListProtector.get(r7, r120)).longValue() != ((Number) ListProtector.get(r8, r120)).longValue()) goto L100;
        r110 = null;
        if (r120 == r83) goto L105;
        r120 = r120 + 1;
    L105:
        int r84 = -1;
        r120 = -1;
    L106:
        if (r120 == r84) goto L108;
        r117.append("display_list");
    L108:
        r37.F.put("display_list_change_type", StringsKt.removeSuffix(r117, ",").toString());
        jy0.b.a("ttlive_gift_panel_metrics", "check display list: changeType=" + r117 + ", giftId:" + r38 + "->" + r39.a + ", pos:" + r39.b + "->" + r118);
        goto L110
    L100:
        jy0.b.f("ttlive_gift_panel_metrics", "display list changed, range=[" + r119 + ',' + r83 + "] index=" + r120, null, 4);
        r110 = null;
        r84 = -1;
    L104:
        r110 = null;
    L83:
        r110 = null;
        goto L110
    L69:
        r36 = new Pair(Integer.valueOf(r34), -2L);
        goto L75
    L66:
        r36 = new Pair(Integer.valueOf(r34), -1L);
        goto L75
    L74:
        r36 = new Pair(-1, -3L);
        goto L75
    L49:
        r25 = false;
        goto L50
    L52:
        r24 = null;
        goto L53
    L31:
        r15 = false;
        goto L32
    L34:
        r14 = null;
        goto L35
    L20:
        if (r4.isEmpty() == true) goto L23;
        r5 = false;
    L111:
        r9 = r9;
        r110 = null;
        r112 = r3;
        r111 = null;
        goto L112
    L11:
        if (this.H2.b != r28.getReceiverType()) goto L14;
        r2 = false;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void V1(l0<GiftVerticalState> r11, GiftVerticalState r13, LocateGiftInfo r14) {
        if (r14.getTargetPageType() == 0) goto L18;
        Iterator r0 = ((LinkedHashMap) this.L0.c).entrySet().iterator();
        int r5 = -1;
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r0.next();
        if (((Number) r2.getValue()).intValue() != r14.getTargetPageType()) goto L6;
        r5 = ((Number) r2.getKey()).intValue();
        goto L6
    L10:
        if (r5 == (-1)) goto L19;
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r15 = r13.getCurrentPagePosition();
        r11.getClass();
        ((Number) com.bytedance.android.anya.h.b(r15)).intValue();
        e3(this, r11, r13, r5, false, "click", false, 40);
        return;
    L19:
        return;
    }

    public final void W2(l0<GiftVerticalState> r19, GiftVerticalState r20, IncrementalUpdatePanelGiftList r21) {
        com.bytedance.android.livesdk.gift.platform.core.giftlist.k r0 = this.M1.d(r21.getReceiverType(), r21.getPageType(), r21.getTopicId());
        if (r0 != null) goto L5;
    L61:
        h1(r19, r20, r21.getPageType(), (int) r21.getTopicId(), r0);
        return;
    L5:
        if ((!r0.e.isEmpty()) == false) goto L61;
        r0.b.size();
        List<Long> r1 = r0.e;
        ArrayList r10 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        h1 r3 = GiftManagerKt.j(((Number) r2.next()).longValue(), null);
        if (r3 == null) goto L8;
        r10.add(r3);
        goto L8
    L12:
        K1(r19, r20, r21.getPageType(), (int) r21.getTopicId(), r10, false);
        u r4 = r20.getPanelList();
        Iterator r5 = ((Iterable) r4.c()).iterator();
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r5.hasNext() == false) goto L34;
        Object r8 = r5.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        MVIState r11 = (MVIState) r8;
        com.bytedance.android.anya.r0<PagerListData, Integer> r13 = ((PagerListData) r11).getTabType();
        r19.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r13)).intValue() != r21.getPageType()) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L28;
        new k0.a();     // Catch: Throwable -> L29
        r7 = ((s0) ((PagerListData) r11).getItemDataList().c()).size();     // Catch: Throwable -> L29
        if ((!r11.modifiedProperties.isEmpty()) == false) goto L28;
        ((t) r4.c()).d(r6);
    L29:
        th = move-exception;
        if ((!r11.modifiedProperties.isEmpty()) == false) goto L33;
        ((t) r4.c()).d(r6);
    L33:
        throw th;
    L28:
        r6 = r9;
        goto L14
    L21:
        r14 = false;
        goto L22
    L34:
        this.g1.getClass();
        Intrinsics.checkNotNullParameter(r10, "giftList");
        LinkedHashMap r15 = new LinkedHashMap();
        com.bytedance.android.livesdk.gift.platform.business.config.j r16 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r17 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        DiamondConfig r18 = (DiamondConfig) r16.c(r17, DiamondConfig.a.a());
        Iterator r23 = r10.iterator();
        int r24 = 0;
    L36:
        if (r23.hasNext() == false) goto L60;
        Object r25 = r23.next();
        int r110 = r24 + 1;
        if (r24 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        h1 r26 = (h1) r25;
        JSONObject r111 = new JSONObject();
        r111.put("display_by_server", r26.isDisplayedOnPanel());
        com.bytedance.android.livesdk.gift.model.k0 r112 = r26.getGiftPreviewInfo();
        if (r112 != null) goto L43;
    L46:
        boolean r113 = true;
    L47:
        r111.put("lock", r113);
        r111.put("position", r24 + r7);
        String r27 = r26.getName();
        if (r27 != null) goto L50;
        r27 = BuildConfig.FLAVOR;
    L50:
        r111.put("gift_name", r27);
        r111.put("gift_id", r26.getId());
        py.k r28 = r26.getLeftLogo();
        if (r28 == null) goto L54;
        String r29 = r28.getUri();
        if (r29 == null) goto L54;
    L55:
        r111.put("gift_label_uri", r29);
        r111.put("gift_bottom_text", vh6.c.b(ur2.a.class).Lf(r26.getBottomText(), BuildConfig.FLAVOR).toString());
        if (r26.getDiamondCount() <= 0) goto L58;
        r111.put("gift_bottom_text", String.valueOf(r26.getDiamondCount()) + " " + r18.b);
    L59:
        r15.put(String.valueOf(r26.getId()), r111);
        r24 = r110;
        goto L36
    L58:
        r111.put("gift_bottom_text", s1.B(2131919120));
    L54:
        r29 = BuildConfig.FLAVOR;
        goto L55
    L43:
        if (r112.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L46;
        r113 = false;
        goto L47
    L60:
        boolean r30 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.GIFT_LIST_INFO, r15, null);
        goto L61
    }

    public final void d2(Pair r6, RefreshGiftListSource r7, int r8) {
        this.E2.getClass();
        this.E2.getClass();
        if ((!Intrinsics.areEqual(null, (String) r6.getFirst())) == false) goto L5;
        StringBuilder r0 = new StringBuilder("expect scene is null, actual scene is ");
        this.E2.getClass();
        r0.append((String) r6.getFirst());
        r0.append(", actual insert id is ");
        r0.append((List) r6.getSecond());
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftMVIVerticalListViewModel", r0.toString());
    L5:
        u1 r9 = this.b1;
        r9.getClass();
        Intrinsics.checkNotNullParameter(AiStrategyStatus.NO_STRATEGY, "aiStrategyStatus");
        Intrinsics.checkNotNullParameter(r7, "refreshGiftListSource");
        LinkedHashMap r2 = new LinkedHashMap();
        r9.v.getClass();
        String r4 = BuildConfig.FLAVOR;
        r2.put("strategy_info", BuildConfig.FLAVOR);
        r2.put("strategy_final_status", AiStrategyStatus.NO_STRATEGY);
        r2.put("not_insert_reason", String.valueOf(0));
        r9.v.getClass();
        r2.put("strategy_slice_id", BuildConfig.FLAVOR);
        r9.v.getClass();
        r2.put("strategy_scene", BuildConfig.FLAVOR);
        r2.put("trigger_time", r7.getSource());
        r9.v.getClass();
        r2.put("strategy_gift_info", BuildConfig.FLAVOR);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L8;
        String r10 = "1";
    L9:
        r2.put("is_anchor", r10);
        r2.put("to_user_type", r9.t1(r9.q.R(r9.p.a), r9.p.a));
        r2.put("to_user_id", r9.p.a.getIdString());
        r9.v.getClass();
        r2.put("room_live_scene", BuildConfig.FLAVOR);
        String r11 = r9.v.g;
        if (r11 == null) goto L13;
        r4 = r11;
    L13:
        r2.put("strategy_sticker_content", r4);
        r2.put("actual_sticker_content", r9.y.d);
        r2.put("price_diff", String.valueOf(1000000));
        r2.put("pos_diff", String.valueOf(1000000));
        r2.put("last_gift_id", String.valueOf(-1));
        r2.put("new_gift_id", String.valueOf(-1));
        r2.put("panel_open_times", String.valueOf(r9.t.p));
        r2.put("gift_cache_source", String.valueOf(r8));
        r9.j(r2);
        r9.p1("livesdk_gift_panel_refresh_show", r2, true);
        return;
    L8:
        r10 = "0";
        goto L9
    }

    public final void m3(com.bytedance.android.anya.j0<GiftVerticalState> r23, GiftVerticalState r24, GiftAction r25) {
        Intrinsics.checkNotNullParameter(r23, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r24, "state");
        Intrinsics.checkNotNullParameter(r25, "action");
        p r1 = r23.getContext();
        int r8 = 0;
        Object r9 = 0;
        com.bytedance.android.anya.internal.c r10 = (com.bytedance.android.anya.v) r1.b(r1.c(GiftPanelState.class), GiftMVIVerticalListViewModel$postReduce$1$1.INSTANCE).a.invoke();
        boolean r11 = true;
        if (r10 == null) goto L30;
        com.bytedance.android.anya.internal.c r13 = r10;
        Object r2 = r10.c();     // Catch: Throwable -> L25
        int r3 = r10.c;     // Catch: Throwable -> L25
        Object r4 = ((LinkedHashMap) r23.d).get(r10);     // Catch: Throwable -> L25
        if (r4 != null) goto L10;
        r4 = r9;
    L10:
        if (r3 <= ((Number) r4).intValue()) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L27;
        GiftTabViewState r5 = (GiftTabViewState) r2;     // Catch: Throwable -> L25
        r r7 = com.bytedance.android.anya.j0.a.a.e(r5);     // Catch: Throwable -> L25
        if ((r7 instanceof GiftTabBusinessState.TabSelected) == false) goto L27;
        int r6 = ((Number) com.bytedance.android.anya.h.b(((GiftTabItem) k0.c(r5.getGiftTabItemList()).get(((GiftTabBusinessState.TabSelected) r7).getPosition())).getOrderRule())).intValue();     // Catch: Throwable -> L25
        if (r6 == B1(((GiftTabBusinessState.TabSelected) r7).getPosition())) goto L21;
        N3(((GiftTabBusinessState.TabSelected) r7).getPosition(), r6);     // Catch: Throwable -> L25
        l0<GiftVerticalState> r14 = r23.g;     // Catch: Throwable -> L25
        GiftVerticalState r16 = (GiftVerticalState) r14.f();     // Catch: Throwable -> L25
        t3(r14, r24, this.M1.Mn(this.H2.g()), this.H2.g(), !com.bytedance.android.livesdk.gift.platform.core.h.n().i(), true);     // Catch: Throwable -> L25
    L21:
        if (((Number) com.bytedance.android.anya.h.b(r24.getCurrentPagePosition())).intValue() == ((GiftTabBusinessState.TabSelected) r7).getPosition()) goto L27;
        if (v.f() == true) goto L27;
        l0 r17 = r23.g;     // Catch: Throwable -> L25
        GiftVerticalState r18 = (GiftVerticalState) r17.f();     // Catch: Throwable -> L25
        i3(this, r17, r24, ((GiftTabBusinessState.TabSelected) r7).getPosition(), ((Number) com.bytedance.android.anya.h.b(r24.getCurrentPagePosition())).intValue());     // Catch: Throwable -> L25
    L27:
        if (r15 == false) goto L29;
        r23.a();     // Catch: Throwable -> L25
    L29:
        r23.c.put(r10, Integer.valueOf(r13.c));
        goto L30
    L12:
        r15 = false;
    L25:
        th = move-exception;
        r23.c.put(r10, Integer.valueOf(r13.c));
        throw th;
    L30:
        p r19 = r23.getContext();
        r25 = (com.bytedance.android.anya.v) r19.b(r19.c(GiftPanelState.class), GiftMVIVerticalListViewModel$postReduce$3$1.INSTANCE).a.invoke();
        if (r25 == null) goto L257;
        com.bytedance.android.anya.internal.c r110 = (com.bytedance.android.anya.internal.c) r25;
        Object r20 = ((com.bytedance.android.anya.internal.c) r25).c();     // Catch: Throwable -> L238
        int r21 = ((com.bytedance.android.anya.internal.c) r25).c;     // Catch: Throwable -> L238
        Object r26 = ((LinkedHashMap) r23.d).get(r25);     // Catch: Throwable -> L238
        if (r26 != null) goto L37;
        r26 = r9;
    L37:
        if (r21 <= ((Number) r26).intValue()) goto L40;
        boolean r111 = true;
    L244:
        if (r111 == true) goto L253;
    L233:
        r110 = r110;
        r25 = r25;
    L234:
        if (r111 == false) goto L236;
        r23.a();     // Catch: Throwable -> L198
    L236:
        r23.c.put(r25, Integer.valueOf(r110.c));
        return;
    L253:
        com.bytedance.android.anya.j0.a r27 = com.bytedance.android.anya.j0.a.a;     // Catch: Throwable -> L130
        GiftTopViewState r28 = (GiftTopViewState) r20;     // Catch: Throwable -> L130
        com.bytedance.android.anya.r0<GiftTopViewState, GiftTopViewState.Mode> r29 = r28.getMode();     // Catch: Throwable -> L130
        r27.getClass();     // Catch: Throwable -> L130
        this.T = (GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r29);     // Catch: Throwable -> L130
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r28.getMode())) == GiftTopViewState.Mode.BuffCard) goto L45;
    L132:
        r110 = r110;
        r25 = r25;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r28.getMode())) != GiftTopViewState.Mode.DIY) goto L201;
        if (nz1.a.h().d() == true) goto L201;
        GiftBuffCardHelper.a.getClass();     // Catch: Throwable -> L198
        this.B = GiftBuffCardHelper.Companion.e(r23, r24);     // Catch: Throwable -> L198
        this.A = null;     // Catch: Throwable -> L198
        this.G1.a(null);     // Catch: Throwable -> L198
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r30 = this.G1;     // Catch: Throwable -> L198
        p0 r31 = this.B;     // Catch: Throwable -> L198
        if (r31 == null) goto L139;
        com.bytedance.android.livesdk.gift.model.n r33 = r31.a();     // Catch: Throwable -> L198
    L140:
        r30.c(r33);     // Catch: Throwable -> L198
        com.bytedance.android.anya.internal.c r112 = (com.bytedance.android.anya.v) r23.getContext().d(r28.getDiyCardViewState()).a.invoke();     // Catch: Throwable -> L198
        if (r112 == null) goto L234;
        com.bytedance.android.anya.internal.c r34 = r112;     // Catch: Throwable -> L198
        Object r35 = r112.c();     // Catch: Throwable -> L156
        int r36 = r112.c;     // Catch: Throwable -> L156
        Object r37 = ((LinkedHashMap) r23.d).get(r112);     // Catch: Throwable -> L156
        if (r37 == null) goto L149;
        r9 = r37;
    L149:
        if (r36 <= ((Number) r9).intValue()) goto L151;
        boolean r113 = true;
    L152:
        if (r113 == false) goto L193;
        GiftDIYViewState r38 = (GiftDIYViewState) r35;     // Catch: Throwable -> L156
        l0 r39 = r23.g;     // Catch: Throwable -> L156
        GiftVerticalState r40 = (GiftVerticalState) r39.f();     // Catch: Throwable -> L156
        p0 r41 = this.B;     // Catch: Throwable -> L156
        if (r41 == null) goto L158;
        vz1.i r43 = r41.c();     // Catch: Throwable -> L156
    L159:
        int r44 = ((Number) com.bytedance.android.anya.h.b(((GiftDIYViewState) com.bytedance.android.anya.h.b(r28.getDiyCardViewState())).getSelectedPosition())).intValue();     // Catch: Throwable -> L156
        p0 r45 = this.B;     // Catch: Throwable -> L156
        if (r45 == null) goto L166;
        com.bytedance.android.livesdk.gift.model.n r46 = r45.a();     // Catch: Throwable -> L156
        if (r46 == null) goto L166;
        if (gz1.a.c(r46) == true) goto L166;
    L167:
        p0 r47 = this.B;     // Catch: Throwable -> L156
        if (r47 == null) goto L174;
        com.bytedance.android.livesdk.gift.model.n r48 = r47.a();     // Catch: Throwable -> L156
        if (r48 == null) goto L174;
        CardLockInfo r49 = r48.getLockInfo();     // Catch: Throwable -> L156
        if (r49 == null) goto L174;
        String r50 = r49.getCellText();     // Catch: Throwable -> L156
    L175:
        p0 r51 = this.B;     // Catch: Throwable -> L156
        if (r51 == null) goto L180;
        com.bytedance.android.livesdk.gift.model.n r53 = r51.a();     // Catch: Throwable -> L156
        if (r53 == null) goto L180;
        r8 = (int) r53.getTotalDiamonds();     // Catch: Throwable -> L156
    L180:
        p0 r54 = this.B;     // Catch: Throwable -> L156
        if (r54 == null) goto L187;
        com.bytedance.android.livesdk.gift.model.n r55 = r54.a();     // Catch: Throwable -> L156
        if (r55 == null) goto L187;
        CardLockInfo r56 = r55.getLockInfo();     // Catch: Throwable -> L156
        if (r56 == null) goto L187;
        Boolean r57 = Boolean.valueOf(r56.getUseCustomButtonColor());     // Catch: Throwable -> L156
    L188:
        p0 r58 = this.B;     // Catch: Throwable -> L156
        if (r58 == null) goto L191;
        com.bytedance.android.livesdk.gift.model.n r114 = r58.a();     // Catch: Throwable -> L156
    L192:
        s1(this, r39, r24, r43, r44, r11, r50, r8, r57, null, r114, 128);     // Catch: Throwable -> L156
        goto L193
    L191:
        r114 = null;
    L187:
        r57 = null;
    L174:
        r50 = null;
    L166:
        r11 = false;
        goto L167
    L158:
        r43 = null;
    L193:
        if (r113 == false) goto L195;
        r23.a();     // Catch: Throwable -> L156
    L195:
        r23.c.put(r112, Integer.valueOf(r112.c));     // Catch: Throwable -> L198
        goto L234
    L151:
        r113 = false;
    L156:
        th = move-exception;
        r23.c.put(r112, Integer.valueOf(r112.c));     // Catch: Throwable -> L198
        throw th;     // Catch: Throwable -> L198
    L139:
        r33 = null;
    L201:
        if (nz1.a.h().d() == false) goto L205;
        if (nz1.a.h().c() == true) goto L234;
    L205:
        if (nz1.a.h().d() == true) goto L219;
        if (GiftTopContractKt.isGroupMode((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r28.getMode())) == false) goto L217;
        p0 r59 = this.B;     // Catch: Throwable -> L198
        if (r59 == null) goto L216;
        Long r60 = Long.valueOf(r59.b());     // Catch: Throwable -> L198
        GiftBuffCardHelper.a.getClass();     // Catch: Throwable -> L198
        h1 r61 = GiftBuffCardHelper.Companion.g(r27, r24);     // Catch: Throwable -> L198
        if (r61 == null) goto L213;
        Long r63 = Long.valueOf(r61.getId());     // Catch: Throwable -> L198
    L215:
        if (Intrinsics.areEqual(r60, r63) == true) goto L219;
    L213:
        r63 = null;
    L216:
        this.B = null;     // Catch: Throwable -> L198
        this.G1.c(null);     // Catch: Throwable -> L198
        goto L219
    L217:
        this.B = null;     // Catch: Throwable -> L198
        this.G1.c(null);     // Catch: Throwable -> L198
    L219:
        if (nz1.a.h().c() == true) goto L234;
        if (GiftTopContractKt.isGroupMode((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r28.getMode())) == false) goto L231;
        o0 r64 = this.A;     // Catch: Throwable -> L198
        if (r64 == null) goto L230;
        Long r65 = Long.valueOf(r64.c());     // Catch: Throwable -> L198
        GiftBuffCardHelper.a.getClass();     // Catch: Throwable -> L198
        h1 r0 = GiftBuffCardHelper.Companion.g(r27, r24);     // Catch: Throwable -> L198
        if (r0 == null) goto L227;
        Long r66 = Long.valueOf(r0.getId());     // Catch: Throwable -> L198
    L229:
        if (Intrinsics.areEqual(r65, r66) == true) goto L234;
    L227:
        r66 = null;
    L230:
        this.A = null;     // Catch: Throwable -> L198
        this.G1.a(null);     // Catch: Throwable -> L198
        goto L234
    L231:
        this.A = null;     // Catch: Throwable -> L198
        this.G1.a(null);     // Catch: Throwable -> L198
        goto L234
    L45:
        if (nz1.a.h().c() == true) goto L132;
        GiftBuffCardHelper.Companion r67 = GiftBuffCardHelper.a;     // Catch: Throwable -> L130
        e1 r68 = this.L0;     // Catch: Throwable -> L130
        r67.getClass();     // Catch: Throwable -> L130
        o0 r69 = GiftBuffCardHelper.Companion.c(r23, r68, r24);     // Catch: Throwable -> L130
        this.A = r69;     // Catch: Throwable -> L130
        this.B = null;     // Catch: Throwable -> L130
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r70 = this.G1;     // Catch: Throwable -> L130
        if (r69 == null) goto L49;
        l1 r71 = r69.a();     // Catch: Throwable -> L130
    L50:
        r70.a(r71);     // Catch: Throwable -> L130
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r73 = this.G1;     // Catch: Throwable -> L130
        p0 r74 = this.B;     // Catch: Throwable -> L130
        if (r74 == null) goto L53;
        com.bytedance.android.livesdk.gift.model.n r75 = r74.a();     // Catch: Throwable -> L130
    L54:
        r73.c(r75);     // Catch: Throwable -> L130
        com.bytedance.android.anya.internal.c r115 = (com.bytedance.android.anya.v) r23.getContext().d(r28.getBuffCardViewState()).a.invoke();     // Catch: Throwable -> L130
        if (r115 == null) goto L233;
        com.bytedance.android.anya.internal.c r76 = r115;     // Catch: Throwable -> L130
        Object r77 = r115.c();     // Catch: Throwable -> L119
        int r78 = r115.c;     // Catch: Throwable -> L119
        Object r79 = ((LinkedHashMap) r23.d).get(r115);     // Catch: Throwable -> L119
        if (r79 == null) goto L63;
        r9 = r79;
    L63:
        if (r78 <= ((Number) r9).intValue()) goto L65;
        boolean r116 = true;
    L66:
        if (r116 == false) goto L121;
        GiftBuffCardViewState r80 = (GiftBuffCardViewState) r77;     // Catch: Throwable -> L119
        l0 r81 = r23.g;     // Catch: Throwable -> L119
        GiftVerticalState r83 = (GiftVerticalState) r81.f();     // Catch: Throwable -> L119
        f2();     // Catch: Throwable -> L119
        o0 r84 = this.A;     // Catch: Throwable -> L119
        if (r84 == null) goto L70;
        py.k r85 = r84.d();     // Catch: Throwable -> L119
    L71:
        o0 r86 = this.A;     // Catch: Throwable -> L119
        if (r86 == null) goto L74;
        py.k r87 = r86.b();     // Catch: Throwable -> L119
    L75:
        vz1.i r88 = GiftBuffCardHelper.Companion.d(r85, r87);     // Catch: Throwable -> L119
        o0 r89 = this.A;     // Catch: Throwable -> L119
        if (r89 == null) goto L80;
        l1 r90 = r89.a();     // Catch: Throwable -> L119
        if (r90 == null) goto L80;
        int r91 = r90.getBuffLevel();     // Catch: Throwable -> L119
    L81:
        o0 r93 = this.A;     // Catch: Throwable -> L119
        if (r93 == null) goto L90;
        l1 r94 = r93.a();     // Catch: Throwable -> L119
        if (r94 == null) goto L90;
        com.bytedance.android.livesdk.gift.model.i r95 = r94.getLockInfo();     // Catch: Throwable -> L119
        if (r95 == null) goto L90;
        if (r95.getLocked() != true) goto L90;
    L91:
        o0 r96 = this.A;     // Catch: Throwable -> L119
        if (r96 == null) goto L98;
        l1 r97 = r96.a();     // Catch: Throwable -> L119
        if (r97 == null) goto L98;
        com.bytedance.android.livesdk.gift.model.i r98 = r97.getLockInfo();     // Catch: Throwable -> L119
        if (r98 == null) goto L98;
        String r99 = r98.getCellText();     // Catch: Throwable -> L119
    L99:
        o0 r100 = this.A;     // Catch: Throwable -> L119
        if (r100 == null) goto L104;
        l1 r101 = r100.a();     // Catch: Throwable -> L119
        if (r101 == null) goto L104;
        r8 = (int) r101.getBuffDiamondCount();     // Catch: Throwable -> L119
    L104:
        o0 r102 = this.A;     // Catch: Throwable -> L119
        if (r102 == null) goto L111;
        l1 r103 = r102.a();     // Catch: Throwable -> L119
        if (r103 == null) goto L111;
        com.bytedance.android.livesdk.gift.model.i r104 = r103.getLockInfo();     // Catch: Throwable -> L119
        if (r104 == null) goto L111;
        Boolean r105 = Boolean.valueOf(r104.getUseCustomButtonColor());     // Catch: Throwable -> L119
    L112:
        o0 r106 = this.A;     // Catch: Throwable -> L119
        if (r106 == null) goto L116;
        l1 r117 = r106.a();     // Catch: Throwable -> L119
    L117:
        com.bytedance.android.anya.internal.c r118 = r115;
        s1(this, r81, r24, r88, r91, r11, r99, r8, r105, r117, null, 256);     // Catch: Throwable -> L125
    L122:
        if (r116 == false) goto L127;
        r23.a();     // Catch: Throwable -> L125
    L127:
        r23.c.put(r118, Integer.valueOf(r118.c));     // Catch: Throwable -> L198
    L125:
        th = th;
    L128:
        r23.c.put(r118, Integer.valueOf(r118.c));     // Catch: Throwable -> L198
        throw th;     // Catch: Throwable -> L198
    L116:
        r117 = null;
    L111:
        r105 = null;
    L98:
        r99 = null;
    L90:
        r11 = false;
    L80:
        r91 = -1;
        goto L81
    L74:
        r87 = null;
        goto L75
    L70:
        r85 = null;
        goto L71
    L121:
        r118 = r115;
        goto L122
    L65:
        r116 = false;
    L119:
        th = th;
        r118 = r115;
        goto L128
    L53:
        r75 = null;
        goto L54
    L49:
        r71 = null;
    L130:
        th = th;
        r110 = r110;
        r25 = r25;
    L232:
        GiftAction r107 = r25;
        com.bytedance.android.anya.internal.c r119 = r110;
    L240:
        r23.c.put(r107, Integer.valueOf(r119.c));
        throw th;
    L198:
        th = th;
        goto L232
    L40:
        r111 = false;
    L238:
        th = th;
        r107 = r25;
        r119 = r110;
        goto L240
    }

    public final /* bridge */ /* synthetic */ void w0(com.bytedance.android.anya.j0 r1, MVIState r2, com.bytedance.android.anya.p r3) {
        m3(r1, (GiftVerticalState) r2, (GiftAction) r3);
    }

    public final void w1(final l0<GiftVerticalState> r4, final GiftVerticalState r5, ClearGiftSource r6) {
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.g.c(this.S1, this.H0, r6, new GiftMVIVerticalListViewModel$clearSelected$1(r4, r5));
    }

    public final /* bridge */ /* synthetic */ void y0(l0 r1, MVIState r2, com.bytedance.android.anya.p r3) {
        n3(r1, (GiftVerticalState) r2, (GiftAction) r3);
    }

    public static int z1(l0 r8, GiftVerticalState r9, int r10, int r11) {
        int r1 = 0;
        if (r10 != (-1)) goto L5;
        return 0;
    L5:
        t0<GiftVerticalState, PagerListData> r0 = r9.getPanelList();
        r8.getClass();
        if (com.bytedance.android.anya.h.a(r0) <= r11) goto L49;
        u r13 = r9.getPanelList();
        MVIState r14 = (MVIState) ((s0) r13.c()).get(r11);
        new k0.a();     // Catch: Throwable -> L44
        PagerListData r2 = (PagerListData) r14;     // Catch: Throwable -> L44
        if (((s0) r2.getCounterDataList().c()).size() <= r10) goto L42;
        u r3 = r2.getCounterDataList();     // Catch: Throwable -> L44
        u r4 = r3;     // Catch: Throwable -> L44
        Iterator r5 = ((Iterable) r3.c()).iterator();     // Catch: Throwable -> L44
        int r6 = 0;
    L12:
        if (r5.hasNext() == false) goto L42;
        Object r7 = r5.next();     // Catch: Throwable -> L44
        int r15 = r6 + 1;     // Catch: Throwable -> L44
        if (r6 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L44
    L16:
        MVIState r16 = (MVIState) r7;     // Catch: Throwable -> L44
        new k0.a();     // Catch: Throwable -> L36
        CounterData r17 = (CounterData) r16;     // Catch: Throwable -> L36
        if (r6 >= r10) goto L20;
        int r18 = ((s0) r17.getItemDataList().c()).size();     // Catch: Throwable -> L36
        if ((r18 % 4) != 0) goto L30;
        int r19 = r18 / 4;     // Catch: Throwable -> L36
    L31:
        r1 = r1 + r19;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L35;
        ((t) r3.c()).d(r6);     // Catch: Throwable -> L44
    L35:
        r6 = r15;
        goto L12
    L30:
        r19 = (r18 / 4) + 1;
        goto L31
    L20:
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L23;
        ((t) r3.c()).d(r6);     // Catch: Throwable -> L44
    L23:
        if ((!r14.modifiedProperties.isEmpty()) == false) goto L25;
        ((t) r13.c()).d(r11);
    L25:
        return r1;
    L36:
        th = move-exception;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L40;
        ((t) r3.c()).d(r6);     // Catch: Throwable -> L44
    L40:
        throw th;     // Catch: Throwable -> L44
    L42:
        if ((!r14.modifiedProperties.isEmpty()) == false) goto L49;
        ((t) r13.c()).d(r11);
    L44:
        th = move-exception;
        if ((!r14.modifiedProperties.isEmpty()) == false) goto L48;
        ((t) r13.c()).d(r11);
    L48:
        throw th;
    L49:
        return r1;
    }

    public final void M3(final l0<GiftVerticalState> r33, final GiftVerticalState r34, boolean r35, List<Long> r36) {
        Intrinsics.checkNotNullParameter(r33, "$this$updateGiftIcon");
        Intrinsics.checkNotNullParameter(r34, "state");
        Intrinsics.checkNotNullParameter(r36, "refreshGiftId");
        r r0 = r33.i(r34);
        boolean r1 = r0 instanceof GiftListBusinessState.GiftSelected;
        if (r1 == true) goto L5;
        r r3 = null;
    L6:
        GiftListBusinessState.GiftSelected r4 = (GiftListBusinessState.GiftSelected) r3;
        if (r4 == null) goto L9;
        int r5 = r4.getSelectedPagePosition();
    L10:
        if (r1 == true) goto L12;
        r r6 = null;
    L13:
        GiftListBusinessState.GiftSelected r7 = (GiftListBusinessState.GiftSelected) r6;
        if (r7 == null) goto L16;
        int r8 = r7.getSelectedPosition();
    L17:
        if (r1 == true) goto L19;
        r r9 = null;
    L20:
        GiftListBusinessState.GiftSelected r10 = (GiftListBusinessState.GiftSelected) r9;
        if (r10 == null) goto L23;
        int r11 = r10.getSelectCounterPosition();
    L24:
        if (r1 == true) goto L26;
        r0 = null;
    L26:
        GiftListBusinessState.GiftSelected r2 = (GiftListBusinessState.GiftSelected) r0;
        if (r2 == null) goto L29;
        int r13 = r2.getTopicPagerPosition();
    L30:
        String r17 = this.H2.a.getIdString();
        this.b2.s();
        final int r14 = r5;
        final int r15 = r8;
        final int r16 = r11;
        final int r18 = r13;
        Function5<vz1.e, Integer, Integer, Integer, Integer, Unit> r19 = new GiftMVIVerticalListViewModel$updateGiftIcon$modifyAction$1(r33, r14, r15, r16, r18, r34);
        k0<GiftVerticalState, ?> r110 = r33.b;
        t0<GiftVerticalState, PagerListData> r20 = r34.getPanelList();
        r110.getClass();
        Iterator r111 = k0.c(r20).iterator();
        int r21 = 0;
    L32:
        if (r111.hasNext() == false) goto L90;
        Object r23 = r111.next();
        int r24 = r21 + 1;
        if (r21 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        PagerListData r25 = (PagerListData) r23;
        List r26 = k0.c(r25.getItemDataList());
        ArrayList r27 = new ArrayList();
        Iterator r28 = r26.iterator();
    L38:
        if (r28.hasNext() == false) goto L45;
        Object r29 = r28.next();
        if (((ItemDataType) com.bytedance.android.anya.h.b(((ItemListData) r29).getItemDataType())) != ItemDataType.NORMAL_ITEM) goto L42;
        boolean r30 = true;
    L43:
        if (r30 == false) goto L38;
        r27.add(r29);
        goto L38
    L42:
        r30 = false;
        goto L43
    L45:
        int r210 = r27.size();
        Iterator r211 = r27.iterator();
        int r212 = 0;
    L47:
        if (r211.hasNext() == false) goto L55;
        Object r31 = r211.next();
        int r213 = r212 + 1;
        if (r212 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        k0<GiftVerticalState, ?> r214 = r110;
        vz1.e r37 = E1(r110, r34, (ItemListData) r31, ((Number) com.bytedance.android.anya.h.b(r25.getTabType())).intValue(), r21, -1, -1, r212, r36, r17, r35, this.H2.b, r210);
        if (r37 == null) goto L54;
        r19.invoke(r37, Integer.valueOf(r21), Integer.valueOf(r212), -1, -1);
    L54:
        r212 = r213;
        r110 = r214;
        goto L47
    L55:
        k0<GiftVerticalState, ?> r215 = r110;
        List r38 = k0.c(r25.getCounterDataList());
        int r216 = r38.size();
        Iterator r217 = r38.iterator();
        int r218 = 0;
    L57:
        if (r217.hasNext() == false) goto L72;
        Object r39 = r217.next();
        int r219 = r218 + 1;
        if (r218 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        Iterator r220 = k0.c(((CounterData) r39).getItemDataList()).iterator();
        int r310 = 0;
    L63:
        if (r220.hasNext() == false) goto L71;
        Object r40 = r220.next();
        int r311 = r310 + 1;
        if (r310 >= 0) goto L67;
        CollectionsKt.throwIndexOverflow();
    L67:
        vz1.e r41 = E1(r215, r34, (ItemListData) r40, ((Number) com.bytedance.android.anya.h.b(r25.getTabType())).intValue(), r21, r218, -1, r310, r36, r17, r35, this.H2.b, r216);
        if (r41 == null) goto L70;
        r19.invoke(r41, Integer.valueOf(r21), Integer.valueOf(r310), Integer.valueOf(r218), -1);
    L70:
        r310 = r311;
        goto L63
    L71:
        r218 = r219;
        goto L57
    L72:
        List r43 = k0.c(r25.getTopicPagerListData());
        int r221 = r43.size();
        Iterator r222 = r43.iterator();
        int r223 = 0;
    L74:
        if (r222.hasNext() == false) goto L89;
        Object r44 = r222.next();
        int r224 = r223 + 1;
        if (r223 >= 0) goto L78;
        CollectionsKt.throwIndexOverflow();
    L78:
        Iterator r225 = k0.c(((TopicPagerListData) r44).getItemDataList()).iterator();
        int r312 = 0;
    L80:
        if (r225.hasNext() == false) goto L88;
        Object r45 = r225.next();
        int r313 = r312 + 1;
        if (r312 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        vz1.e r46 = E1(r215, r34, (ItemListData) r45, ((Number) com.bytedance.android.anya.h.b(r25.getTabType())).intValue(), r21, -1, r223, r312, r36, r17, r35, this.H2.b, r221);
        if (r46 == null) goto L87;
        r19.invoke(r46, Integer.valueOf(r21), Integer.valueOf(r312), -1, Integer.valueOf(r223));
    L87:
        r312 = r313;
        goto L80
    L88:
        r223 = r224;
        goto L74
    L89:
        r21 = r24;
        r110 = r215;
        goto L32
    L90:
        return;
    L29:
        r13 = -1;
        goto L30
    L23:
        r11 = -1;
        goto L24
    L19:
        r9 = r0;
        goto L20
    L16:
        r8 = -1;
        goto L17
    L12:
        r6 = r0;
        goto L13
    L9:
        r5 = -1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public final void P2(GiftVerticalState r7, IntRange r8, IntRange r9, int r10) {
        u r11 = r7.getPanelList();
        MVIState r0 = (MVIState) ((s0) r11.c()).get(r10);
        new k0.a();     // Catch: Throwable -> L15
        PagerListData r1 = (PagerListData) r0;     // Catch: Throwable -> L15
        int r2 = ((s0) r1.getCounterDataList().c()).size();     // Catch: Throwable -> L15
        Iterator<T> r13 = m.b(r8, r9).iterator();     // Catch: Throwable -> L15
    L5:
        if (r13.hasNext() == false) goto L12;
        int r14 = ((Number) r13.next()).intValue();     // Catch: Throwable -> L15
        if (r14 >= r2) goto L5;
        if (r14 < 0) goto L5;
        CounterData r3 = (CounterData) k0.d(r1.getCounterDataList(), r14);     // Catch: Throwable -> L15
        this.b1.S((String) com.bytedance.android.anya.h.b(r3.getSectionName()), com.bytedance.android.anya.h.a(r3.getItemDataList()), r14 + 1);     // Catch: Throwable -> L15
        goto L5
    L12:
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L29;
        ((t) r11.c()).d(r10);
        return;
    L29:
        return;
    L15:
        th = move-exception;
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L19;
        ((t) r11.c()).d(r10);
    L19:
        throw th;
    }

    public final void k2(l0<GiftVerticalState> r16, GiftVerticalState r17, int r18, int r19) {
        if (r18 < 0) goto L76;
        t0<GiftVerticalState, PagerListData> r3 = r17.getPanelList();
        r16.getClass();
        if (r18 >= com.bytedance.android.anya.h.a(r3)) goto L77;
        l0.a r1 = l0.e(r17.getPanelList(), r18);
        l0 r4 = r1.b;
        PagerListData r2 = (PagerListData) r1.a;
        if (r19 < 0) goto L78;
        t0<PagerListData, ItemListData> r5 = r2.getItemDataList();
        r4.getClass();
        if (r19 >= com.bytedance.android.anya.h.a(r5)) goto L79;
        l0.a r6 = l0.e(r2.getItemDataList(), r19);
        l0 r7 = r6.b;
        com.bytedance.android.anya.r0<ItemListData, vz1.e> r8 = ((ItemListData) r6.a).getItemData();
        r7.getClass();
        long r9 = ((vz1.e) com.bytedance.android.anya.h.b(r8)).b;
        this.N.add(Long.valueOf(r9));
        g0 r10 = this.x1.q(r9);
        if (r10 == null) goto L13;
        IGiftExposureAnimInfo r11 = r10.getGiftExposureAnimInfo();
    L14:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j.a.getClass();
        boolean r13 = true;
        String r14 = BuildConfig.FLAVOR;
        if (r11 != null) goto L17;
        List r15 = null;
    L47:
        if (r11 == null) goto L62;
        py.k r20 = r11.getAssetUrl();
        if (r20 == null) goto L62;
        List r21 = r20.getUrls();
        if (r21 == null) goto L62;
        if (r21.size() > 0) goto L56;
        r13 = false;
    L56:
        if (r13 == true) goto L59;
        r21 = r15;
    L59:
        if (r21 == null) goto L62;
        String r23 = (String) ListProtector.get(r21, 0);
        if (r23 == null) goto L62;
    L63:
        u1 r24 = this.b1;
        if (r11 == null) goto L67;
        String r25 = r11.getFrequencyKey();
        if (r25 == null) goto L67;
    L68:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r23, "effectName");
        Intrinsics.checkNotNullParameter(r25, "effectId");
        mz0.n r26 = new mz0.n();
        Map r27 = r26.a;
        Intrinsics.checkNotNullParameter(r27, "map");
        String r28 = r24.d.getIdStr().toString();
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r28, "value");
        r27.put("room_id", r28);
        String r29 = r24.d.getAnchorId();
        if (r29 == null) goto L72;
        r14 = r29;
    L72:
        Intrinsics.checkNotNullParameter("anchor_id", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r27.put("anchor_id", r14);
        String r30 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r30, "value");
        r27.put("gift_id", r30);
        Intrinsics.checkNotNullParameter("effect_name", "key");
        Intrinsics.checkNotNullParameter(r23, "value");
        r27.put("effect_name", r23);
        Intrinsics.checkNotNullParameter("effect_id", "key");
        Intrinsics.checkNotNullParameter(r25, "value");
        r27.put("effect_id", r25);
        mz0.m r31 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r33 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r33, "pageSourceLog");
        ((ArrayList) r31.a).add(r33.a);
        r31.b(LogCommon.ROOM);
        ((ArrayList) r26.b).addAll(r31.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((f80.a) r35).w3("livesdk_gift_icon_effect_show", r26.a, r26.b);
        return;
    L67:
        r25 = BuildConfig.FLAVOR;
    L62:
        r23 = BuildConfig.FLAVOR;
        goto L63
    L17:
        String r36 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        HashMap r37 = (HashMap) ay1.b.p0.getValue(null, ay1.b.a[80]);
        if (r37 != null) goto L21;
        r37 = new HashMap();
    L21:
        if (r37.get(r36) != null) goto L23;
        r37.put(r36, new HashMap());
        HashMap r38 = (HashMap) r37.get(r36);
    L24:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i r110 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i(0);
        Gson r111 = new Gson();     // Catch: Exception -> L32
        if (r38 == null) goto L29;
        String r112 = (String) r38.get(String.valueOf(r9));     // Catch: Exception -> L32
        if (r112 == null) goto L29;
    L30:
        r110 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i) r111.fromJson(r112, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i.class);     // Catch: Exception -> L32
    L29:
        r112 = BuildConfig.FLAVOR;
    L33:
        String r113 = r11.getFrequencyKey();
        if (r113 != null) goto L36;
        r113 = BuildConfig.FLAVOR;
    L36:
        int r114 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.a(r110.a, r113) == true) goto L39;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r110.a = r113;
        r110.c = 1;
    L43:
        r110.b = new Date().getTime();
        if (r38 == null) goto L46;
        String r39 = (String) r38.put(String.valueOf(r9), GsonProtectorUtils.toJson(new Gson(), r110, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i.class));
    L46:
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r15 = null;
        ay1.b.p0.setValue(null, ay1.b.a[80], r37);
        goto L47
    L39:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j.a.a(r11.getInterval(), r110.b) == false) goto L41;
        r110.c++;
        goto L43
    L41:
        r110.c = 1;
        goto L43
    L23:
        r38 = (HashMap) r37.get(r36);
        goto L24
    L13:
        r11 = null;
        goto L14
    L79:
        return;
    L78:
        return;
    L77:
        return;
    }

    public static /* synthetic */ void i3(GiftMVIVerticalListViewModel r7, l0 r8, GiftVerticalState r9, int r10, int r11) {
        r7.h3(r8, r9, r10, r11, true, "click");
    }

    public static void y3(l0 r37, GiftVerticalState r38, int r39, int r40, int r41) {
        int r2 = r40;
        t0<GiftVerticalState, PagerListData> r0 = r38.getPanelList();
        r37.getClass();
        if (com.bytedance.android.anya.h.a(r0) <= r39) goto L55;
        l0 r3 = (u) r38.getPanelList();
        MVIState r4 = (MVIState) ((s0) r3.c()).get(r39);
        new k0.a();     // Catch: Throwable -> L49
        PagerListData r1 = (PagerListData) r4;     // Catch: Throwable -> L49
        if (((s0) r1.getItemDataList().c()).size() > r2) goto L60;
        r3 = r3;
    L47:
        if ((!r4.modifiedProperties.isEmpty()) == false) goto L68;
        ((t) r3.c()).d(r39);
        return;
    L68:
        return;
    L60:
        u r5 = r1.getItemDataList();     // Catch: Throwable -> L43
        u r6 = r5;     // Catch: Throwable -> L43
        MVIState r7 = (MVIState) ((s0) r5.c()).get(r2);     // Catch: Throwable -> L43
        new k0.a();     // Catch: Throwable -> L35
        ItemListData r8 = (ItemListData) r7;     // Catch: Throwable -> L35
        l0.h(r8.getItemStatus(), ItemStatus.GONE);     // Catch: Throwable -> L35
        if (((vz1.e) com.bytedance.android.anya.h.b(r8.getItemData())).e == true) goto L56;
        u r35 = r5;
        MVIState r9 = r7;
    L32:
        if ((!r9.modifiedProperties.isEmpty()) == false) goto L47;
        ((t) r35.c()).d(r40);     // Catch: Throwable -> L41
        goto L47
    L56:
        com.bytedance.android.anya.r0<ItemListData, vz1.e> r10 = ((ItemListData) k0.d(((PagerListData) k0.d(r38.getPanelList(), r39)).getItemDataList(), r2)).getItemData();     // Catch: Throwable -> L27
        int r11 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.b - r41;     // Catch: Throwable -> L27
        py.k r13 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.a;     // Catch: Throwable -> L27
        long r14 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.d;     // Catch: Throwable -> L27
        long r15 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.e;     // Catch: Throwable -> L27
        if (r11 > 0) goto L14;
        r11 = 0;
    L14:
        long r16 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.g;     // Catch: Throwable -> L25
        String r17 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.c;     // Catch: Throwable -> L25
        long r18 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.f;     // Catch: Throwable -> L25
        r35 = r5;
        MVIState r36 = r7;
        long r19 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.k;     // Catch: Throwable -> L22
        String r20 = ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.j;     // Catch: Throwable -> L22
        int r110 = r11;
        vz1.e r21 = new vz1.e(((vz1.e) com.bytedance.android.anya.h.b(r10)).a, ((vz1.e) com.bytedance.android.anya.h.b(r10)).b, ((vz1.e) com.bytedance.android.anya.h.b(r10)).c, 0, true, false, new vz1.h(r13, r110, r17, r14, r15, r18, r16, ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.h, ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.i, r20, r19, ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.l, ((vz1.e) com.bytedance.android.anya.h.b(r10)).g.m), null, null, null, null, null, null, null, null, null, null, null, false, ((vz1.e) com.bytedance.android.anya.h.b(r10)).x, null, 58720168);     // Catch: Throwable -> L22
        l0.h(r8.getItemData(), r21);     // Catch: Throwable -> L22
        if (r21.g.b > 0) goto L24;
        l0.h(r8.getVisualStatus(), Integer.valueOf(((Number) com.bytedance.android.anya.h.b(r8.getVisualStatus())).intValue() | VisualStatus.INSTANCE.getDISABLE()));     // Catch: Throwable -> L22
    L24:
        r9 = r36;
    L22:
        th = th;
    L29:
        r2 = r40;
        MVIState r23 = r36;
    L38:
        if ((!r23.modifiedProperties.isEmpty()) == false) goto L40;
        ((t) r35.c()).d(r2);     // Catch: Throwable -> L41
    L40:
        throw th;     // Catch: Throwable -> L41
    L25:
        th = th;
    L26:
        r35 = r5;
        r36 = r7;
    L27:
        th = th;
    L35:
        th = th;
        r35 = r5;
        r23 = r7;
    L41:
        th = th;
    L42:
        int r24 = r39;
        MVIState r25 = r4;
    L52:
        if ((!r25.modifiedProperties.isEmpty()) == false) goto L54;
        ((t) r37.c()).d(r24);
    L54:
        throw th;
    L43:
        th = th;
        r37 = r3;
    L49:
        th = th;
        r24 = r39;
        r37 = r3;
        r25 = r4;
        goto L52
    }

    public final void J2(l0<GiftVerticalState> r15, GiftVerticalState r16, int r17, Map<Integer, IntRange> r18, Map<Integer, IntRange> r19) {
        Iterator<Map.Entry<Integer, IntRange>> r0 = r19.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<Integer, IntRange> r1 = r0.next();
        int r9 = r1.getKey().intValue();
        IntRange r8 = r1.getValue();
        if (Intrinsics.areEqual(r8, new IntRange(-1, -1)) == true) goto L4;
        IntRange r2 = r18.get(Integer.valueOf(r9));
        if (r2 != null) goto L10;
        r2 = new IntRange(-1, -1);
    L10:
        D2(this, r15, r16, r17, m.b(r2, r8), r8, r9, 0, false, 96);
        goto L4
    }

    @Deprecated(message = "该功能已下线")
    public final void S2(l0<GiftVerticalState> r11, GiftVerticalState r13, int r14, IntRange r15, IntRange r16) {
        if (Intrinsics.areEqual(r16, new IntRange(-1, -1)) == false) goto L5;
        return;
    L5:
        Iterator<T> r17 = m.b(r15, r16).iterator();
    L7:
        if (r17.hasNext() == false) goto L34;
        int r18 = ((Number) r17.next()).intValue();
        if (r18 < 0) goto L7;
        k0 r0 = r11.b;
        t0<GiftVerticalState, PagerListData> r1 = r13.getPanelList();
        r0.getClass();
        if (com.bytedance.android.anya.h.a(r1) <= r14) goto L7;
        t0<PagerListData, ItemListData> r2 = ((PagerListData) k0.d(r13.getPanelList(), r14)).getItemDataList();
        if (com.bytedance.android.anya.h.a(r2) <= r18) goto L15;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L7;
        ItemListData r4 = (ItemListData) k0.d(r2, r18);
        long r5 = ((vz1.e) com.bytedance.android.anya.h.b(r4.getItemData())).b;
        g0 r6 = this.x1.q(r5);
        if (r6 == null) goto L24;
        IGiftExposureAnimInfo r8 = r6.getGiftExposureAnimInfo();
    L26:
        if (((ItemStatus) com.bytedance.android.anya.h.b(r4.getItemStatus())) == ItemStatus.SELECTED) goto L7;
        if (t1(r5, r8, r14, r14, r18) == false) goto L7;
        if (r8 == null) goto L32;
        py.k r7 = r8.getAssetUrl();
    L33:
        K0(new ShowGiftExposureAnim(r14, r18, r7, 0, 0, 24, null));
        goto L7
    L32:
        r7 = null;
        goto L33
    L24:
        r8 = null;
        goto L26
    L15:
        r3 = false;
        goto L17
    }

    public final void h1(l0<GiftVerticalState> r20, GiftVerticalState r21, int r23, int r24, com.bytedance.android.livesdk.gift.platform.core.giftlist.k r25) {
        if (r25 != null) goto L5;
    L95:
        if (r25 == null) goto L97;
        return;
    L97:
        if (v.h() == true) goto L99;
    L143:
        u r2 = r21.getPanelList();
        Iterator r3 = ((Iterable) r2.c()).iterator();
        int r4 = 0;
    L145:
        if (r3.hasNext() == false) goto L203;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L149;
        CollectionsKt.throwIndexOverflow();
    L149:
        MVIState r7 = (MVIState) r5;
        com.bytedance.android.anya.r0<PagerListData, Integer> r8 = ((PagerListData) r7).getTabType();
        r20.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r8)).intValue() != r23) goto L152;
        boolean r9 = true;
    L153:
        if (r9 == false) goto L159;
        new k0.a();     // Catch: Throwable -> L160
        ((PagerListData) r7).getHasMoreData().a(Boolean.FALSE);     // Catch: Throwable -> L160
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L159;
        ((t) r2.c()).d(r4);
    L160:
        th = move-exception;
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L164;
        ((t) r2.c()).d(r4);
    L164:
        throw th;
    L159:
        r4 = r6;
        goto L145
    L152:
        r9 = false;
        goto L153
    L203:
        return;
    L99:
        if ((!this.y2.a(r23).isEmpty()) == false) goto L143;
        u r10 = r21.getPanelList();
        Iterator r11 = ((Iterable) r10.c()).iterator();
        int r13 = 0;
    L102:
        if (r11.hasNext() == false) goto L202;
        Object r14 = r11.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L106;
        CollectionsKt.throwIndexOverflow();
    L106:
        MVIState r16 = (MVIState) r14;
        com.bytedance.android.anya.r0<PagerListData, Integer> r17 = ((PagerListData) r16).getTabType();
        r20.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r17)).intValue() != r23) goto L109;
        boolean r18 = true;
    L110:
        if (r18 == false) goto L137;
        new k0.a();     // Catch: Throwable -> L138
        u r19 = ((PagerListData) r16).getTopicPagerListData();     // Catch: Throwable -> L138
        u r26 = r19;     // Catch: Throwable -> L138
        Iterator r27 = ((Iterable) r19.c()).iterator();     // Catch: Throwable -> L138
        int r110 = 0;
    L114:
        if (r27.hasNext() == false) goto L135;
        Object r111 = r27.next();     // Catch: Throwable -> L138
        int r112 = r110 + 1;     // Catch: Throwable -> L138
        if (r110 >= 0) goto L118;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L138
    L118:
        MVIState r113 = (MVIState) r111;     // Catch: Throwable -> L138
        if (((Number) ((TopicPagerListData) r113).getTopicId().c()).intValue() != r24) goto L121;
        boolean r114 = true;
    L122:
        if (r114 == false) goto L128;
        new k0.a();     // Catch: Throwable -> L129
        ((TopicPagerListData) r113).getHasMoreData().a(Boolean.FALSE);     // Catch: Throwable -> L129
    L126:
        if ((!r113.modifiedProperties.isEmpty()) == false) goto L128;
        ((t) r19.c()).d(r110);     // Catch: Throwable -> L138
    L129:
        th = move-exception;
        if ((!r113.modifiedProperties.isEmpty()) == false) goto L133;
        ((t) r19.c()).d(r110);     // Catch: Throwable -> L138
    L133:
        throw th;     // Catch: Throwable -> L138
    L128:
        r110 = r112;
        goto L114
    L121:
        r114 = false;
        goto L122
    L135:
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L137;
        ((t) r10.c()).d(r13);
    L138:
        th = move-exception;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L142;
        ((t) r10.c()).d(r13);
    L142:
        throw th;
    L137:
        r13 = r15;
        goto L102
    L109:
        r18 = false;
        goto L110
    L202:
        return;
    L5:
        if (r25.c.isEmpty() == false) goto L7;
    L10:
        boolean r28 = true;
    L12:
        if (v.h() == true) goto L14;
    L66:
        u r29 = r21.getPanelList();
        Iterator r30 = ((Iterable) r29.c()).iterator();
        int r31 = 0;
    L68:
        if (r30.hasNext() == false) goto L94;
        Object r33 = r30.next();
        int r34 = r31 + 1;
        if (r31 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        MVIState r35 = (MVIState) r33;
        com.bytedance.android.anya.r0<PagerListData, Integer> r115 = ((PagerListData) r35).getTabType();
        r20.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r115)).intValue() != r23) goto L75;
        boolean r116 = true;
    L76:
        if (r116 == false) goto L88;
        new k0.a();     // Catch: Throwable -> L89
        PagerListData r117 = (PagerListData) r35;     // Catch: Throwable -> L89
        com.bytedance.android.anya.internal.c r118 = r117.getHasMoreData();     // Catch: Throwable -> L89
        if (r28 == true) goto L81;
        boolean r119 = true;
    L82:
        r118.a(Boolean.valueOf(r119));     // Catch: Throwable -> L89
        if (r28 == true) goto L86;
        u r120 = r117.getItemDataList();     // Catch: Throwable -> L89
        ItemListData r121 = new ItemListData();     // Catch: Throwable -> L89
        new k0.a();     // Catch: Throwable -> L89
        r121.getItemDataType().a(ItemDataType.BOTTOM_LOADING);     // Catch: Throwable -> L89
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L89
        ((e0) r120.c()).add(r121);     // Catch: Throwable -> L89
    L86:
        if ((!r35.modifiedProperties.isEmpty()) == false) goto L88;
        ((t) r29.c()).d(r31);
        goto L88
    L81:
        r119 = false;
    L89:
        th = move-exception;
        if ((!r35.modifiedProperties.isEmpty()) == false) goto L93;
        ((t) r29.c()).d(r31);
    L93:
        throw th;
    L88:
        r31 = r34;
        goto L68
    L75:
        r116 = false;
    L94:
        Unit r36 = Unit.INSTANCE;
        goto L95
    L14:
        if ((!this.y2.a(r23).isEmpty()) == false) goto L66;
        u r37 = r21.getPanelList();
        Iterator r38 = ((Iterable) r37.c()).iterator();
        int r39 = 0;
    L17:
        if (r38.hasNext() == false) goto L94;
        Object r123 = r38.next();
        int r124 = r39 + 1;
        if (r39 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        MVIState r125 = (MVIState) r123;
        com.bytedance.android.anya.r0<PagerListData, Integer> r126 = ((PagerListData) r125).getTabType();
        r20.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r126)).intValue() != r23) goto L24;
        boolean r127 = true;
    L25:
        if (r127 == true) goto L174;
        Iterator r128 = r38;
        int r129 = r124;
    L60:
        r39 = r129;
        r38 = r128;
        goto L17
    L174:
        new k0.a();     // Catch: Throwable -> L61
        u r130 = ((PagerListData) r125).getTopicPagerListData();     // Catch: Throwable -> L61
        u r131 = r130;     // Catch: Throwable -> L61
        Iterator r132 = ((Iterable) r130.c()).iterator();     // Catch: Throwable -> L61
        int r133 = 0;
    L29:
        if (r132.hasNext() == false) goto L57;
        Object r134 = r132.next();     // Catch: Throwable -> L61
        int r135 = r133 + 1;     // Catch: Throwable -> L61
        if (r133 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L61
    L33:
        MVIState r136 = (MVIState) r134;     // Catch: Throwable -> L61
        if (((Number) ((TopicPagerListData) r136).getTopicId().c()).intValue() != r24) goto L36;
        boolean r40 = true;
    L37:
        if (r40 == true) goto L166;
        Iterator r137 = r38;
        r124 = r124;
    L51:
        r133 = r135;
        r124 = r124;
        r38 = r137;
        goto L29
    L166:
        new k0.a();     // Catch: Throwable -> L52
        TopicPagerListData r41 = (TopicPagerListData) r136;     // Catch: Throwable -> L52
        com.bytedance.android.anya.internal.c r138 = r41.getHasMoreData();     // Catch: Throwable -> L52
        if (r28 == true) goto L42;
        boolean r139 = true;
    L43:
        Boolean r43 = Boolean.valueOf(r139);     // Catch: Throwable -> L52
        r137 = r38;
        r138.a(r43);     // Catch: Throwable -> L52
        if (r28 == true) goto L49;
        u r44 = r41.getItemDataList();     // Catch: Throwable -> L52
        ItemListData r45 = new ItemListData();     // Catch: Throwable -> L52
        new k0.a();     // Catch: Throwable -> L52
        r45.getItemDataType().a(ItemDataType.BOTTOM_LOADING);     // Catch: Throwable -> L52
        Unit r46 = Unit.INSTANCE;     // Catch: Throwable -> L52
        ((e0) r44.c()).add(r45);     // Catch: Throwable -> L52
    L49:
        if ((!r136.modifiedProperties.isEmpty()) == false) goto L51;
        ((t) r130.c()).d(r133);     // Catch: Throwable -> L61
        goto L51
    L42:
        r139 = false;
    L52:
        th = move-exception;
        if ((!r136.modifiedProperties.isEmpty()) == false) goto L56;
        ((t) r130.c()).d(r133);     // Catch: Throwable -> L61
    L56:
        throw th;     // Catch: Throwable -> L61
    L36:
        r40 = false;
        goto L37
    L57:
        r128 = r38;
        r129 = r124;
        if ((!r125.modifiedProperties.isEmpty()) == false) goto L60;
        ((t) r37.c()).d(r39);
    L61:
        th = move-exception;
        if ((!r125.modifiedProperties.isEmpty()) == false) goto L65;
        ((t) r37.c()).d(r39);
    L65:
        throw th;
    L24:
        r127 = false;
        goto L25
    L7:
        if (((c1) CollectionsKt.last(r25.c)).getId() == r25.d) goto L10;
        r28 = false;
        goto L12
    }

    public final boolean t1(long r10, IGiftExposureAnimInfo r13, int r14, int r15, int r16) {
        if (r13 != null) goto L6;
        return false;
    L6:
        if (r13.getAssetUrl() != null) goto L8;
        return false;
    L8:
        IntRange r1 = (IntRange) ((LinkedHashMap) this.G).get(Integer.valueOf(r14));
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r14 == r15) goto L13;
        return false;
    L13:
        if (r1.contains(r16) == false) goto L53;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j.a.getClass();
        String r17 = r13.getFrequencyKey();
        int r18 = r13.getInterval();
        Long r19 = r13.getShowTime();
        if (r19 == null) goto L18;
        long r3 = r19.longValue();
    L19:
        String r110 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        HashMap r111 = (HashMap) ay1.b.p0.getValue(null, ay1.b.a[80]);
        if (r111 != null) goto L23;
        r111 = new HashMap();
    L23:
        if (r111.get(r110) != null) goto L25;
        r111.put(r110, new HashMap());
        HashMap r112 = (HashMap) r111.get(r110);
    L26:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i r113 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i(0);
        Gson r5 = new Gson();     // Catch: Exception -> L34
        if (r112 == null) goto L31;
        String r11 = (String) r112.get(String.valueOf(r10));     // Catch: Exception -> L34
        if (r11 == null) goto L31;
    L32:
        r113 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i) r5.fromJson(r11, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.i.class);     // Catch: Exception -> L34
    L31:
        r11 = BuildConfig.FLAVOR;
    L35:
        long r114 = new Date().getTime();
        int r115 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.a(r113.a, r17) == false) goto L38;
        int r116 = r113.c;
        r114 = r113.b;
    L40:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j.a.a(r18, r114) == false) goto L45;
        if (r116 >= r3) goto L51;
    L46:
        return true;
    L51:
        return false;
    L45:
        if (r3 > 0) goto L46;
        return false;
    L38:
        r116 = 0;
        goto L40
    L25:
        r112 = (HashMap) r111.get(r110);
        goto L26
    L18:
        r3 = 0;
        goto L19
    L53:
        return false;
    }

    public final void K1(l0<GiftVerticalState> r34, GiftVerticalState r35, int r36, int r37, List<? extends h1> r38, boolean r39) {
        GiftMVIVerticalListViewModel r1 = this;
        int r2 = r36;
        int r3 = r37;
        if (r38.isEmpty() == false) goto L5;
        return;
    L5:
        Object r4 = null;
        if (r39 == true) goto L26;
        ArrayList r7 = new ArrayList();
        Iterator<T> r0 = r38.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        Object r8 = r0.next();
        if ((((h1) r8).getReqExtraType() & 1) != 1) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L9;
        r7.add(r8);
        goto L9
    L13:
        r9 = false;
        goto L14
    L16:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r10 = r7.iterator();
    L18:
        if (r10.hasNext() == false) goto L21;
        r5.add(Long.valueOf(((h1) r10.next()).getId()));
        goto L18
    L21:
        if ((!r5.isEmpty()) == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
        r1.I2.a();
        r0.a.a(r1.x1, r5, "incrementalUpdateList", null, 12);
        Unit r6 = Unit.INSTANCE;
    L26:
        r1.b2.s();
        String r15 = r1.H2.a.getIdString();
        LongSparseArray r14 = new LongSparseArray();
        u r24 = r35.getPanelList();
        Iterator r25 = ((Iterable) r24.c()).iterator();
        int r13 = 0;
    L28:
        if (r25.hasNext() == false) goto L183;
        Object r11 = r25.next();
        int r26 = r13 + 1;
        if (r13 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        MVIState r16 = (MVIState) r11;
        com.bytedance.android.anya.r0<PagerListData, Integer> r17 = ((PagerListData) r16).getTabType();
        r34.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r17)).intValue() != r2) goto L35;
        boolean r18 = true;
    L36:
        if (r18 == true) goto L186;
        r37 = r3;
        Object r19 = r4;
        LongSparseArray r20 = r14;
        String r21 = r15;
    L173:
        r14 = r20;
        r15 = r21;
        r4 = r19;
        r3 = r37;
        r13 = r26;
        goto L28
    L186:
        new k0.a();     // Catch: Throwable -> L176
        PagerListData r27 = (PagerListData) r16;     // Catch: Throwable -> L176
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L176
        int r23 = r38.size();     // Catch: Throwable -> L176
        if (r39 == true) goto L41;
        int r28 = ((s0) r27.getItemDataList().c()).size();     // Catch: Throwable -> L176
    L42:
        Iterator<T> r29 = r38.iterator();     // Catch: Throwable -> L176
        int r30 = 0;
    L44:
        if (r29.hasNext() == false) goto L53;
        h1 r111 = (h1) r29.next();     // Catch: Throwable -> L51
        int r31 = r30 + 1;     // Catch: Throwable -> L51
        int r33 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L51
        int r40 = ((Number) r27.getTabType().c()).intValue();     // Catch: Throwable -> L51
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r41 = r1.H2;     // Catch: Throwable -> L51
        ReceiverType r43 = r41.b;     // Catch: Throwable -> L51
        GiftExtraRepo r44 = r1.x1;     // Catch: Throwable -> L51
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r45 = r1.T1;     // Catch: Throwable -> L51
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r46 = r1.b2;     // Catch: Throwable -> L51
        LongSparseArray r112 = r14;
        com.bytedance.android.livesdk.gift.platform.business.config.a r113 = r1.J;     // Catch: Throwable -> L51
        boolean r47 = r1.w;     // Catch: Throwable -> L51
        IRoom r48 = r1.v;     // Catch: Throwable -> L51
        com.bytedance.android.livesdk.gift.platform.core.giftlist.i r49 = r1.P1;     // Catch: Throwable -> L51
        e1 r50 = r1.L0;     // Catch: Throwable -> L51
        GiftListPanelRepository r51 = r1.M1;     // Catch: Throwable -> L51
        GiftListSortDataStore r53 = r1.E2;     // Catch: Throwable -> L51
        ArrayList r54 = r110;
        MVIState r55 = r16;
        int r310 = r13;
        String r56 = r15;
        r54.add(com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r111, r40, r15, r43, r44, r45, r46, r113, r47, r41, r48, r49, r50, r51, r53, r31 + r28, r23 + r28));     // Catch: Throwable -> L49
        r112.append(r111.getId(), r111);     // Catch: Throwable -> L49
        r110 = r54;
        r14 = r112;
        r16 = r55;
        r15 = r56;
        r30 = r31;
        r13 = r310;
        r1 = this;
    L49:
        th = th;
    L175:
        int r57 = r310;
    L180:
        if ((!r55.modifiedProperties.isEmpty()) == false) goto L182;
        ((t) r24.c()).d(r57);
    L182:
        throw th;
    L51:
        th = th;
        r55 = r16;
    L178:
        r57 = r13;
        goto L180
    L53:
        ArrayList r58 = r110;
        r55 = r16;
        r310 = r13;
        r20 = r14;
        r21 = r15;
        d0 r59 = r1.H1;     // Catch: Throwable -> L174
        r59.getClass();     // Catch: Throwable -> L174
        Intrinsics.checkNotNullParameter(r20, "incrementalGiftList");     // Catch: Throwable -> L174
        LongSparseArray<h1> r60 = r59.a;     // Catch: Exception -> L60 Throwable -> L174
        int r61 = r20.size();     // Catch: Exception -> L60 Throwable -> L174
        int r63 = 0;
    L56:
        if (r63 >= r61) goto L59;
        r60.put(r20.keyAt(r63), (h1) r20.valueAt(r63));     // Catch: Exception -> L60 Throwable -> L174
        r63 = r63 + 1;
        goto L56
    L59:
        r19 = null;
    L65:
        i12.e r64 = i12.o.b();     // Catch: Throwable -> L174
        if (r64 == null) goto L68;
        Object r65 = com.bytedance.android.scope.m.e.d(r64, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);     // Catch: Throwable -> L174
    L69:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r66 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r65;     // Catch: Throwable -> L174
        if (r66 != null) goto L72;
    L74:
        boolean r67 = false;
    L75:
        ArrayList r68 = new ArrayList();     // Catch: Throwable -> L174
        if (r58.size() == 0) goto L105;
        Iterator r69 = r58.iterator();     // Catch: Throwable -> L174
    L79:
        if (r69.hasNext() == false) goto L105;
        vz1.e r70 = (vz1.e) r69.next();     // Catch: Throwable -> L174
        GiftPanelViewPreloadService r71 = r1.Q1;     // Catch: Throwable -> L174
        if (GiftPanelViewPreloadService.k == false) goto L83;
        r71.getClass();     // Catch: Throwable -> L174
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r73 = GiftPreloadManager.a;     // Catch: Throwable -> L174
        ItemListData r74 = (ItemListData) GiftPreloadManager.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.f.d.c);     // Catch: Throwable -> L174
    L84:
        if (r74 != null) goto L86;
        r74 = new ItemListData();     // Catch: Throwable -> L174
    L86:
        new k0.a();     // Catch: Throwable -> L174
        r74.getItemData().a(r70);     // Catch: Throwable -> L174
        if (r70.e == false) goto L94;
        vz1.h r114 = r70.g;     // Catch: Throwable -> L174
        if (r114.b != 0) goto L94;
        if (r114.f == 4) goto L94;
        r74.getVisualStatus().a(Integer.valueOf(((Number) r74.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getDISABLE()));     // Catch: Throwable -> L174
    L94:
        if (j0.e(r70.a) == false) goto L97;
        r74.getVisualStatus().a(Integer.valueOf(((Number) r74.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));     // Catch: Throwable -> L174
    L97:
        if (j0.f(r70.a) == false) goto L100;
        r74.getVisualStatus().a(Integer.valueOf(((Number) r74.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));     // Catch: Throwable -> L174
    L100:
        if (r70.e == true) goto L104;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.c(r21, r67, r1.u, r1.v.getAnchorId()) == false) goto L104;
        r74.getVisualStatus().a(Integer.valueOf(((Number) r74.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));     // Catch: Throwable -> L174
    L104:
        Unit r75 = Unit.INSTANCE;     // Catch: Throwable -> L174
        r68.add(r74);     // Catch: Throwable -> L174
        goto L79
    L83:
        r74 = r71.g.poll();     // Catch: Throwable -> L174
    L105:
        if (r39 == true) goto L107;
        r2 = r36;
        r37 = r37;
        if (v.h() == true) goto L146;
    L169:
        ((e0) r27.getItemDataList().c()).addAll(r68);     // Catch: Throwable -> L174
    L171:
        if ((!r55.modifiedProperties.isEmpty()) == false) goto L173;
        ((t) r24.c()).d(r310);
        goto L173
    L146:
        if ((!r1.y2.a(r2).isEmpty()) == false) goto L169;
        u r76 = r27.getTopicPagerListData();     // Catch: Throwable -> L174
        u r77 = r76;     // Catch: Throwable -> L174
        Iterator r78 = ((Iterable) r76.c()).iterator();     // Catch: Throwable -> L174
        int r79 = 0;
    L149:
        if (r78.hasNext() == false) goto L171;
        Object r115 = r78.next();     // Catch: Throwable -> L174
        int r116 = r79 + 1;     // Catch: Throwable -> L174
        if (r79 >= 0) goto L153;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L174
    L153:
        MVIState r117 = (MVIState) r115;     // Catch: Throwable -> L174
        if (((Number) ((TopicPagerListData) r117).getTopicId().c()).intValue() != r37) goto L156;
        boolean r118 = true;
    L157:
        if (r118 == false) goto L163;
        new k0.a();     // Catch: Throwable -> L164
        ((e0) ((TopicPagerListData) r117).getItemDataList().c()).addAll(r68);     // Catch: Throwable -> L164
    L161:
        if ((!r117.modifiedProperties.isEmpty()) == false) goto L163;
        ((t) r76.c()).d(r79);     // Catch: Throwable -> L174
    L164:
        th = move-exception;
        if ((!r117.modifiedProperties.isEmpty()) == false) goto L168;
        ((t) r76.c()).d(r79);     // Catch: Throwable -> L174
    L168:
        throw th;     // Catch: Throwable -> L174
    L163:
        r79 = r116;
        goto L149
    L156:
        r118 = false;
        goto L157
    L107:
        if (v.h() == false) goto L134;
        r2 = r36;
        if ((!r1.y2.a(r2).isEmpty()) == false) goto L135;
        u r80 = r27.getTopicPagerListData();     // Catch: Throwable -> L174
        u r81 = r80;     // Catch: Throwable -> L174
        Iterator r83 = ((Iterable) r80.c()).iterator();     // Catch: Throwable -> L174
        int r84 = 0;
    L112:
        if (r83.hasNext() == false) goto L137;
        Object r119 = r83.next();     // Catch: Throwable -> L174
        int r120 = r84 + 1;     // Catch: Throwable -> L174
        if (r84 >= 0) goto L116;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L174
    L116:
        MVIState r121 = (MVIState) r119;     // Catch: Throwable -> L174
        if (((Number) ((TopicPagerListData) r121).getTopicId().c()).intValue() != r37) goto L120;
        boolean r122 = true;
    L121:
        if (r122 == false) goto L127;
        new k0.a();     // Catch: Throwable -> L128
        ((e0) ((TopicPagerListData) r121).getItemDataList().c()).q(r68);     // Catch: Throwable -> L128
    L125:
        if ((!r121.modifiedProperties.isEmpty()) == false) goto L127;
        ((t) r80.c()).d(r84);     // Catch: Throwable -> L174
    L128:
        th = move-exception;
        if ((!r121.modifiedProperties.isEmpty()) == false) goto L132;
        ((t) r80.c()).d(r84);     // Catch: Throwable -> L174
    L132:
        throw th;     // Catch: Throwable -> L174
    L127:
        r84 = r120;
        goto L112
    L120:
        r122 = false;
    L137:
        if (r2 != 1) goto L171;
        if (v.c() == false) goto L171;
        if (v.b() == false) goto L171;
        ArrayList r85 = new ArrayList();     // Catch: Throwable -> L174
        ItemListData r86 = new ItemListData();     // Catch: Throwable -> L174
        new k0.a();     // Catch: Throwable -> L174
        r86.isGuideItem().a(Boolean.TRUE);     // Catch: Throwable -> L174
        Unit r87 = Unit.INSTANCE;     // Catch: Throwable -> L174
        r85.add(r86);     // Catch: Throwable -> L174
        ((e0) r27.getItemDataList().c()).addAll(r85);     // Catch: Throwable -> L174
    L135:
        ((e0) r27.getItemDataList().c()).q(r68);     // Catch: Throwable -> L174
        goto L137
    L134:
        r2 = r36;
        goto L135
    L72:
        if (r66.j() != true) goto L74;
        r67 = true;
        goto L75
    L68:
        r65 = r19;
    L60:
        e = move-exception;
        String r88 = e.getMessage();     // Catch: Throwable -> L174
        if (r88 != null) goto L64;
        r88 = "exception is null";
    L64:
        r19 = null;
        jy0.b.c("GiftPanelListTempRepo", r88, null, 4);     // Catch: Throwable -> L174
    L174:
        th = th;
        goto L175
    L41:
        r28 = 0;
    L176:
        th = th;
        r55 = r16;
        goto L178
    L35:
        r18 = false;
        goto L36
    }

    public final void f3(l0<GiftVerticalState> r10, GiftVerticalState r11, int r13, int r14, TopicChangeSource r15, boolean r16) {
        if (r14 == (-1)) goto L29;
        t0<GiftVerticalState, PagerListData> r1 = r11.getPanelList();
        r10.getClass();
        if (r14 >= com.bytedance.android.anya.h.a(r1)) goto L30;
        if (r13 == (-1)) goto L24;
        k0 r2 = r10.b;
        t0<GiftVerticalState, PagerListData> r3 = r11.getPanelList();
        r2.getClass();
        if (r13 >= com.bytedance.android.anya.h.a(((PagerListData) k0.d(r3, r14)).getTopicPagerListData())) goto L24;
        k0 r4 = r10.b;
        t0<GiftVerticalState, PagerListData> r5 = r11.getPanelList();
        r4.getClass();
        int r6 = ((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r5, r14)).getCurrentTopicPagerPosition())).intValue();
        k0 r7 = r10.b;
        t0<GiftVerticalState, PagerListData> r8 = r11.getPanelList();
        r7.getClass();
        int r9 = ((Number) com.bytedance.android.anya.h.b(((TopicPagerListData) k0.d(((PagerListData) k0.d(r8, r14)).getTopicPagerListData(), r13)).getTopicId())).intValue();
        if (r13 == r6) goto L28;
        w1(r10, r11, ClearGiftSource.ChangeTopicPage);
        u1(r10, r11);
        l0.a r17 = l0.e(r11.getPanelList(), r14);
        l0 r18 = r17.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r19 = ((PagerListData) r17.a).getCurrentTopicPagerPosition();
        Integer r20 = Integer.valueOf(r13);
        r18.getClass();
        l0.h(r19, r20);
        l0.a r21 = l0.e(r11.getPanelList(), r14);
        l0 r23 = r21.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r24 = ((PagerListData) r21.a).getSelectedTopicId();
        long r25 = r9;
        Long r26 = Long.valueOf(r25);
        r23.getClass();
        l0.h(r24, r26);
        if (r15 != TopicChangeSource.SLIDE) goto L16;
        this.x2.selectTopic(r25, r14);
    L16:
        if (r16 == false) goto L18;
        K0(new ChangeTopicViewPagerPositionEffect(r13));
    L18:
        IntRange r27 = new IntRange(-1, -1);
        IntRange r110 = (IntRange) ((LinkedHashMap) this.F).get(Integer.valueOf(r14));
        if (r110 != null) goto L21;
        r110 = new IntRange(-1, -1);
    L21:
        V2(r10, r11, r14, r27, r110, r13, false);
        return;
    L28:
        return;
    L24:
        if (r15 != TopicChangeSource.SLIDE) goto L26;
        this.x2.selectTopic(-1, r14);
    L26:
        l0.a r111 = l0.e(r11.getPanelList(), r14);
        l0 r112 = r111.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r113 = ((PagerListData) r111.a).getCurrentTopicPagerPosition();
        r112.getClass();
        l0.h(r113, -1);
        l0.a r114 = l0.e(r11.getPanelList(), r14);
        l0 r115 = r114.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r116 = ((PagerListData) r114.a).getSelectedTopicId();
        r115.getClass();
        l0.h(r116, -1L);
        return;
    L30:
        return;
    }

    public final void h3(l0<GiftVerticalState> r9, GiftVerticalState r10, int r11, int r13, boolean r14, String r15) {
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r16 = r10.getCurrentPagePosition();
        r9.getClass();
        if (r11 == ((Number) com.bytedance.android.anya.h.b(r16)).intValue()) goto L6;
        w1(r9, r10, ClearGiftSource.ChangeTab);
        e3(this, r9, r10, r11, r14, r15, false, 32);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Integer, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r56v0, types: [com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftMVIVerticalListViewModel] */
    /* JADX WARN: Type inference failed for: r8v57 */
    /* JADX WARN: Type inference failed for: r8v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v82 */
    public final void t3(l0<GiftVerticalState> r57, GiftVerticalState r58, com.bytedance.android.livesdk.gift.platform.core.model.j r59, ReceiverType r60, boolean r61, boolean r63) {
        com.bytedance.android.livesdk.gift.platform.core.model.j r1 = r59;
        u1(r57, r58);
        if (r61 == false) goto L10;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h r3 = this.z;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r57, "$this$saveStatus");
        Intrinsics.checkNotNullParameter(r58, "state");
        r r4 = r57.i(r58);
        if ((r4 instanceof GiftListBusinessState.GiftSelected) == false) goto L7;
        l0.a r7 = l0.e(r58.getPanelList(), ((Number) com.bytedance.android.anya.h.b(r58.getCurrentPagePosition())).intValue());
        l0 r8 = r7.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r9 = ((PagerListData) r7.a).getTabType();
        r8.getClass();
        GiftListBusinessState.GiftSelected r5 = (GiftListBusinessState.GiftSelected) r4;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l0 r10 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l0(true, r5.getSelectedPagePosition(), r5.getSelectedPosition(), r5.getIconModel(), ((Number) com.bytedance.android.anya.h.b(r9)).intValue(), r5.getSelectCounterPosition());
    L8:
        r3.a = r10;
        Unit r6 = Unit.INSTANCE;
        goto L10
    L7:
        r10 = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l0(0);
    L10:
        GiftListSortDataStore r11 = this.E2;
        if (r11 == null) goto L13;
        r11.i = r1;
        Unit r13 = Unit.INSTANCE;
    L13:
        Pair<String, List<com.bytedance.android.livesdk.gift.platform.core.giftlist.p>> r14 = this.M1.c(r60);
        RefreshGiftListSource r15 = this.S;
        if (r15 != RefreshGiftListSource.OPEN_DIALOG) goto L16;
    L17:
        d2(r14, r15, ((GiftPanelDataExtra) com.bytedance.android.anya.h.b(r58.getPanelDataExtra())).getPageDataFrom());
        this.S = RefreshGiftListSource.NONE;
    L18:
        this.b2.s();
        ArrayList r16 = new ArrayList();
        String r17 = this.H2.a.getIdString();
        i12.e r18 = i12.o.b();
        if (r18 == null) goto L21;
        Object r19 = com.bytedance.android.scope.m.e.d(r18, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L22:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r20 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r19;
        boolean r21 = true;
        if (r20 != null) goto L25;
    L27:
        boolean r23 = false;
    L28:
        ArrayList r24 = new ArrayList();
        LinkedHashMap<Integer, List<vz1.e>> r110 = new LinkedHashMap();
        List<w1> r111 = r1.c;
        if (r111 == null) goto L52;
        Iterator r112 = r111.iterator();
    L32:
        if (r112.hasNext() == false) goto L39;
        Object r113 = r112.next();
        if (((w1) r113).getPageType() != 17) goto L36;
        boolean r114 = true;
    L37:
        if (r114 == false) goto L32;
    L40:
        w1 r115 = (w1) r113;
        if (r115 == null) goto L52;
        if (r115.getDisplay() == true) goto L46;
        r115 = null;
    L46:
        if (r115 == null) goto L52;
        GiftMostlyUsedDataStore r116 = this.K2;
        int r117 = r115.getPageSortStrategy();
        r116.j = r117;
        r116.k = r117;
        GiftMostlyUsedDataStore r118 = this.K2;
        if (r115.getPageSortStrategy() == 0) goto L50;
        boolean r119 = true;
    L51:
        r118.i = r119;
        Unit r120 = Unit.INSTANCE;
    L53:
        GiftMostlyUsedDataStore r121 = this.K2;
        List<w1> r122 = r1.c;
        if (r122 != null) goto L56;
        r122 = CollectionsKt.emptyList();
    L56:
        r121.L(r122);
        List<w1> r123 = r1.c;
        if (r123 == null) goto L333;
        Iterator r25 = r123.iterator();
        int r26 = 0;
    L60:
        if (r25.hasNext() == false) goto L332;
        Object r124 = r25.next();
        int r27 = r26 + 1;
        if (r26 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();
    L64:
        w1 r28 = (w1) r124;
        if (r28.getDisplay() == false) goto L329;
        ArrayList r125 = new ArrayList();
        if (r28.getPageType() == 5) goto L69;
    L84:
        int r2 = r28.getGifts().size();
        Iterator r29 = r28.getGifts().iterator();
        int r126 = 0;
        int r210 = -1;
    L86:
        if (r29.hasNext() == false) goto L91;
        h1 r30 = (h1) r29.next();
        int r31 = r126 + 1;
        int r127 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        int r128 = r28.getPageType();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r129 = this.H2;
        ArrayList r33 = r125;
        LinkedHashMap<Integer, List<vz1.e>> r34 = r110;
        ArrayList r35 = r24;
        ArrayList r36 = r16;
        boolean r37 = r23;
        r33.add(com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r30, r128, r17, r129.b, this.x1, this.T1, this.b2, this.J, this.w, r129, this.v, this.P1, this.L0, this.M1, this.E2, r31, r2));
        if (r30.getType() != 3) goto L90;
        r210 = r33.size() - 1;
    L90:
        r23 = r37;
        r125 = r33;
        r126 = r31;
        r16 = r36;
        r24 = r35;
        r110 = r34;
        goto L86
    L91:
        ArrayList r38 = r16;
        ArrayList r39 = r24;
        boolean r40 = r23;
        ArrayList r41 = r125;
        LinkedHashMap<Integer, List<vz1.e>> r310 = r110;
        int r43 = 1;
        int r44 = r210;
    L92:
        ArrayList r130 = new ArrayList();
        int r45 = r41.size();
        if (r45 == 0) goto L142;
        int r46 = B1(r39.size());
        List<vz1.e> r47 = C1(r46, r41, r44);
        int r48 = this.v2.q;
        r1.a = r48;
        if (r46 == 0) goto L97;
    L109:
        Iterator r49 = r47.iterator();
        int r50 = 1;
    L111:
        if (r49.hasNext() == false) goto L137;
        vz1.e r131 = (vz1.e) r49.next();
        GiftPanelViewPreloadService r132 = this.Q1;
        if (GiftPanelViewPreloadService.k == false) goto L115;
        r132.getClass();
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r133 = GiftPreloadManager.a;
        ItemListData r134 = (ItemListData) GiftPreloadManager.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.f.d.c);
    L116:
        if (r134 != null) goto L118;
        r134 = new ItemListData();
    L118:
        ItemListData r135 = r134;
        new k0.a();
        r135.getItemData().a(r131);
        int r136 = r45;
        Iterator r211 = r49;
        ((vz1.e) r135.getItemData().c()).x = new com.bytedance.android.livesdk.gift.platform.core.model.k(r50, r28.getPageType(), r136, ((vz1.e) r135.getItemData().c()).b, r131.y);
        if (r131.e == false) goto L126;
        vz1.h r51 = r131.g;
        if (r51.b != 0) goto L126;
        if (r51.f == 4) goto L126;
        r135.getVisualStatus().a(Integer.valueOf(((Number) r135.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getDISABLE()));
    L126:
        if (j0.e(r131.a) == false) goto L129;
        r135.getVisualStatus().a(Integer.valueOf(((Number) r135.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));
    L129:
        if (j0.f(r131.a) == false) goto L132;
        r135.getVisualStatus().a(Integer.valueOf(((Number) r135.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));
    L132:
        if (r131.e == true) goto L136;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.c(r17, r40, this.u, this.v.getAnchorId()) == false) goto L136;
        r135.getVisualStatus().a(Integer.valueOf(((Number) r135.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));
    L136:
        Unit r53 = Unit.INSTANCE;
        r130.add(r135);
        r50 = r50 + 1;
        r45 = r136;
        r49 = r211;
        goto L111
    L115:
        r134 = r132.g.poll();
        goto L116
    L137:
        LinkedHashMap<Integer, List<vz1.e>> r54 = r310;
        r54.put(Integer.valueOf(r28.getPageType()), r47);
        if (r28.getPageType() == 1) goto L140;
    L143:
        List<c3> r55 = r28.getSectionList();
        if (r55 != null) goto L146;
    L149:
        boolean r56 = true;
    L150:
        if (r56 == true) goto L152;
    L216:
        ArrayList r64 = r39;
        List r137 = null;
    L217:
        List<c3> r65 = r28.getSectionList();
        if (r65 != null) goto L220;
    L257:
        boolean r311 = r40;
        ArrayList r312 = r130;
        ?? r66 = r137;
    L258:
        List<d2> r67 = r28.getTopicList();
        if ((!r67.isEmpty()) == false) goto L331;
        if (v.h() == false) goto L331;
        ArrayList r68 = new ArrayList();
        ArrayList r138 = new ArrayList();
        if (r67 == null) goto L267;
        d2 r69 = (d2) CollectionsKt.getOrNull(r67, 0);
        if (r69 == null) goto L267;
        long r70 = r69.getId();
    L268:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.k r71 = this.M1.d(this.H2.b, r28.getPageType(), r70);
        if (r71 == null) goto L287;
        List<Long> r73 = r71.b;
        if (r73 == null) goto L287;
        List<Long> r74 = r73;
        ArrayList r139 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r74, 10));
        Iterator r75 = r74.iterator();
    L274:
        if (r75.hasNext() == false) goto L276;
        r139.add(GiftManagerKt.j(((Number) r75.next()).longValue(), r66));
        goto L274
    L276:
        ArrayList r76 = new ArrayList();
        Iterator r140 = r139.iterator();
    L278:
        if (r140.hasNext() == false) goto L286;
        Object r141 = r140.next();
        if (((h1) r141) == null) goto L282;
        boolean r142 = true;
    L283:
        if (r142 == false) goto L286;
        r76.add(r141);
        goto L278
    L282:
        r142 = false;
    L286:
        ?? r77 = CollectionsKt.filterNotNull(r76);
    L288:
        if (r77 == 0) goto L290;
        int r212 = r77.size();
    L291:
        if (r77 == 0) goto L306;
        Iterator r78 = ((Iterable) r77).iterator();
        int r143 = 0;
    L294:
        if (r78.hasNext() == false) goto L305;
        h1 r213 = (h1) r78.next();
        int r214 = r143 + 1;
        int r144 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        int r145 = r28.getPageType();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r146 = this.H2;
        long r79 = r70;
        Iterator r313 = r78;
        ArrayList r314 = r64;
        ArrayList r510 = r138;
        vz1.e r80 = com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r213, r145, r17, r146.b, this.x1, this.T1, this.b2, this.J, this.w, r146, this.v, this.P1, this.L0, this.M1, this.E2, r214, r212);
        ItemListData r81 = new ItemListData();
        new k0.a();
        r81.getItemData().a(r80);
        if (j0.e(r213) == false) goto L299;
        r81.getVisualStatus().a(Integer.valueOf(((Number) r81.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));
    L299:
        if (j0.f(r213) == false) goto L302;
        r81.getVisualStatus().a(Integer.valueOf(((Number) r81.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));
    L302:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(this.H2.a.getIdString(), r66) == false) goto L304;
        r81.getVisualStatus().a(Integer.valueOf(((Number) r81.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));
    L304:
        Unit r83 = Unit.INSTANCE;
        r510.add(r81);
        r138 = r510;
        r143 = r214;
        r70 = r79;
        r64 = r314;
        r78 = r313;
        goto L294
    L305:
        ArrayList r315 = r64;
        long r84 = r70;
        ArrayList r85 = r138;
        Unit r86 = Unit.INSTANCE;
    L307:
        TopicPagerListData r87 = new TopicPagerListData();
        new k0.a();
        ((e0) r87.getItemDataList().c()).q(r85);
        r87.getTopicId().a(Integer.valueOf((int) r84));
        r87.getTabType().a(Integer.valueOf(r28.getPageType()));
        if (r312.isEmpty() == false) goto L310;
        r87.getEmptyListDescription().a(A1(r28.getPageType()));
    L310:
        com.bytedance.android.anya.internal.c r88 = r87.getHasMoreData();
        List<c1> r89 = r28.getBaseGifts();
        if (r89 != null) goto L313;
    L316:
        boolean r90 = true;
    L317:
        r88.a(Boolean.valueOf(!r90));
        List<c1> r91 = r28.getBaseGifts();
        if (r91 != null) goto L320;
    L323:
        boolean r93 = true;
    L324:
        if (r93 == true) goto L326;
        u r94 = r87.getItemDataList();
        ItemListData r95 = new ItemListData();
        new k0.a();
        r95.getItemDataType().a(ItemDataType.BOTTOM_LOADING);
        Unit r96 = Unit.INSTANCE;
        ((e0) r94.c()).add(r95);
    L326:
        Unit r97 = Unit.INSTANCE;
        r68.add(r87);
        PagerListData r98 = new PagerListData();
        new k0.a();
        ((e0) r98.getTopicPagerListData().c()).q(r68);
        r98.getTabType().a(Integer.valueOf(r28.getPageType()));
        r98.isTopicPage().a(Boolean.TRUE);
        r64 = r315;
        r64.add(r98);
        if (v.f() == false) goto L331;
        this.L0.c.put(Integer.valueOf(r143), Integer.valueOf(r28.getPageType()));
        goto L331
    L320:
        if (r91.isEmpty() == true) goto L323;
        r93 = false;
        goto L324
    L313:
        if (r89.isEmpty() == true) goto L316;
        r90 = false;
        goto L317
    L306:
        r315 = r64;
        r84 = r70;
        r85 = r138;
        r143 = 0;
        goto L307
    L290:
        r212 = 0;
    L287:
        r77 = r66;
    L267:
        r70 = 0;
    L331:
        r1 = r59;
        r24 = r64;
        r110 = r54;
        r26 = r27;
        r16 = r38;
        r23 = r311;
        r21 = true;
        goto L60
    L220:
        if ((!r65.isEmpty()) != true) goto L257;
        ArrayList r99 = new ArrayList();
        ArrayList r100 = new ArrayList();
        List<c3> r101 = r28.getSectionList();
        if (r101 == null) goto L251;
        Iterator r215 = r101.iterator();
        int r102 = 0;
        int r147 = 0;
    L225:
        if (r215.hasNext() == false) goto L250;
        c3 r216 = (c3) r215.next();
        ArrayList r103 = new ArrayList();
        if (r216.d().size() < this.K) goto L248;
        int r217 = r147 + r216.d().size();
        Iterator r316 = r216.d().iterator();
    L230:
        if (r316.hasNext() == false) goto L241;
        h1 r317 = (h1) r316.next();
        int r318 = r102 + 1;
        int r104 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        int r148 = r28.getPageType();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r105 = this.H2;
        boolean r319 = r40;
        List r106 = r137;
        ArrayList r511 = r103;
        ArrayList r512 = r100;
        ArrayList r320 = r130;
        vz1.e r107 = com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r317, r148, r17, r105.b, this.x1, this.T1, this.b2, this.J, this.w, r105, this.v, this.P1, this.L0, this.M1, this.E2, r318, r217);
        ItemListData r108 = new ItemListData();
        new k0.a();
        r108.getItemData().a(r107);
        if (j0.e(r317) == false) goto L235;
        r108.getVisualStatus().a(Integer.valueOf(((Number) r108.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));
    L235:
        if (j0.f(r317) == false) goto L238;
        r108.getVisualStatus().a(Integer.valueOf(((Number) r108.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));
    L238:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(this.H2.a.getIdString(), r106) == false) goto L240;
        r108.getVisualStatus().a(Integer.valueOf(((Number) r108.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));
    L240:
        Unit r109 = Unit.INSTANCE;
        r103 = r511;
        r103.add(r108);
        r100 = r512;
        r100.add(r107);
        r137 = r106;
        r102 = r318;
        r40 = r319;
        r130 = r320;
        goto L230
    L241:
        boolean r321 = r40;
        ArrayList r322 = r130;
        List r149 = r137;
        CounterData r150 = new CounterData();
        new k0.a();
        com.bytedance.android.anya.internal.c r151 = r150.getCounterHeaderImg();
        py.k r152 = r216.g();
        if (r152 != null) goto L244;
        r152 = (py.k) vh7.f.c(py.k.class);
    L244:
        r151.a(r152);
        ((e0) r150.getItemDataList().c()).q(r103);
        com.bytedance.android.anya.internal.c r153 = r150.getCounterEntranceIconImg();
        py.k r154 = r216.a();
        if (r154 != null) goto L247;
        r154 = (py.k) vh7.f.c(py.k.class);
    L247:
        r153.a(r154);
        r150.getH5EntranceModel().a(new vz1.c(r216.b(), r216.c(), r216.a()));
        r150.getBgColorModel().a(new vz1.b(CollectionsKt.toIntArray(r216.f()), CollectionsKt.toIntArray(r216.e())));
        r150.getSectionName().a(r216.h());
        Unit r155 = Unit.INSTANCE;
        r99.add(r150);
        r147 = r217;
    L249:
        r137 = r149;
        r40 = r321;
        r130 = r322;
        goto L225
    L248:
        r321 = r40;
        r322 = r130;
        r149 = r137;
        goto L249
    L250:
        r311 = r40;
        r312 = r130;
        List r156 = r137;
        Unit r157 = Unit.INSTANCE;
    L252:
        r66 = r156;
        if (r147 < this.L) goto L258;
        PagerListData r158 = new PagerListData();
        new k0.a();
        ((e0) r158.getCounterDataList().c()).addAll(r99);
        r158.getTabType().a(Integer.valueOf(r28.getPageType()));
        Unit r159 = Unit.INSTANCE;
        r64.add(r158);
        r54.put(Integer.valueOf(r28.getPageType()), r100);
        r66 = r156;
        if (v.f() == false) goto L258;
        this.L0.c.put(Integer.valueOf(r102), Integer.valueOf(r28.getPageType()));
        r66 = r156;
        goto L258
    L251:
        r311 = r40;
        r312 = r130;
        r156 = r137;
        r102 = 0;
        r147 = 0;
        goto L252
    L152:
        if (v.h() == false) goto L161;
        List<d2> r160 = r28.getTopicList();
        if (r160 != null) goto L156;
    L159:
        boolean r161 = true;
    L160:
        if (r161 == false) goto L216;
    L156:
        if (r160.isEmpty() == true) goto L159;
        r161 = false;
    L161:
        PagerListData r162 = new PagerListData();
        new k0.a();
        if (r28.getPageType() == 17) goto L164;
    L168:
        ((e0) r162.getItemDataList().c()).addAll(r130);
        r162.getTabType().a(Integer.valueOf(r28.getPageType()));
        r162.getEmptyListDescription().a(A1(r28.getPageType()));
        com.bytedance.android.anya.internal.c r163 = r162.getHasMoreData();
        List<c1> r164 = r28.getBaseGifts();
        if (r164 != null) goto L171;
    L174:
        boolean r165 = true;
    L175:
        r163.a(Boolean.valueOf(!r165));
        List<c1> r166 = r28.getBaseGifts();
        if (r166 != null) goto L178;
    L181:
        boolean r167 = true;
    L182:
        if (r167 == true) goto L185;
        u r168 = r162.getItemDataList();
        ItemListData r169 = new ItemListData();
        new k0.a();
        r169.getItemDataType().a(ItemDataType.BOTTOM_LOADING);
        Unit r170 = Unit.INSTANCE;
        ((e0) r168.c()).add(r169);
    L185:
        if (r28.getPageType() == 26) goto L187;
    L203:
        r137 = null;
    L205:
        if (r28.getLynxConfig() != null) goto L207;
    L213:
        Unit r171 = Unit.INSTANCE;
        r64 = r39;
        r64.add(r162);
        if (v.f() == false) goto L217;
        this.L0.c.put(Integer.valueOf(r26), Integer.valueOf(r28.getPageType()));
        goto L217
    L207:
        if (r28.getDisplay() == false) goto L213;
        com.bytedance.android.anya.internal.c r172 = r162.getPageLynxConfig();
        z2 r173 = r28.getLynxConfig();
        if (r173 == null) goto L211;
        ?? r174 = r173.getSchema();
    L212:
        r172.a(new GiftLynxPageConfig(Integer.valueOf(r28.getPageType()), r174));
        goto L213
    L211:
        r174 = r137;
        goto L212
    L187:
        if (r28.getDisplay() == false) goto L203;
        com.bytedance.android.livesdk.gift.platform.core.model.d r175 = this.P1.j0();
        if (r175 == null) goto L191;
        String r176 = r175.getSchema();
    L192:
        if (r176 != null) goto L194;
    L197:
        boolean r177 = true;
    L198:
        if (r177 == true) goto L203;
        Uri.Builder r178 = UriProtector.parse(r176).buildUpon();
        r178.appendQueryParameter("tab_name", r28.getPageName());
        r137 = null;
        if (StringsKt.contains$default(r176, "panel_style=tab_panel", false, 2, null) == true) goto L202;
        r178.appendQueryParameter("panel_style", "tab_panel");
    L202:
        r162.getPageSchemaUri().a(r178.build());
        goto L205
    L194:
        if (StringsKt.isBlank(r176) == true) goto L197;
        r177 = false;
        goto L198
    L191:
        r176 = null;
        goto L192
    L178:
        if (r166.isEmpty() == true) goto L181;
        r167 = false;
        goto L182
    L171:
        if (r164.isEmpty() == true) goto L174;
        r165 = false;
        goto L175
    L164:
        if (r28.getPageSortStrategy() == 0) goto L168;
        if (this.K2.s() == false) goto L168;
        u r179 = r162.getItemDataList();
        ItemListData r180 = new ItemListData();
        new k0.a();
        r180.getItemDataType().a(ItemDataType.MOSTLY_USED_HEADER);
        r180.getPinTopStatus().a(new PinTopState(r28.getPageSortStrategy(), r130.isEmpty(), false));
        Unit r181 = Unit.INSTANCE;
        ((e0) r179.c()).add(r180);
        r162.getHasHeader().a(Boolean.TRUE);
        goto L168
    L146:
        if (r55.isEmpty() == true) goto L149;
        r56 = false;
        goto L150
    L140:
        if (v.c() == false) goto L143;
        ItemListData r182 = new ItemListData();
        new k0.a();
        r182.isGuideItem().a(Boolean.TRUE);
        Unit r183 = Unit.INSTANCE;
        r130.add(r182);
        goto L143
    L97:
        if (this.W.a() == false) goto L109;
        List<Integer> r184 = this.W.b();
        if (r184 == null) goto L109;
        if (r184.contains(Integer.valueOf(r28.getPageType())) != r43) goto L109;
        if (r48 != 2) goto L109;
        int r185 = this.W.d();
        if (r185 == r43) goto L108;
        if (r185 != 2) goto L109;
        r1.b = 2;
        r47 = m2(r47);
        goto L109
    L108:
        r1.b = r43;
        r47 = s2(r47);
        goto L109
    L142:
        r54 = r310;
        goto L143
    L69:
        if ((((ArrayList) this.C).isEmpty() ^ r21) == false) goto L84;
        Iterator r186 = ((ArrayList) this.C).iterator();
    L72:
        if (r186.hasNext() == false) goto L81;
        l2 r187 = (l2) r186.next();
        py.k r218 = r187.getDiamondLabel();
        long r323 = r187.getNextExpire();
        long r324 = r187.getNowTimeDiff();
        vz1.h r188 = new vz1.h(r218, r187.getCount(), r187.getName(), r323, r324, r187.getPropType(), r187.getDiamond(), r187.getSetGray(), r187.getPropDescription(), r187.getExpiredException(), r187.getPropDefSubType(), r187.getDescription(), r187.getRefId());
        if (r187.getGift().getImage() != null) goto L77;
        r187.getGift().setImage(r187.getIcon());
    L77:
        if (r187.getGift().getName() != null) goto L79;
        r187.getGift().setName(r187.getName());
    L79:
        r125.add(new vz1.e(r187.getGift(), r187.getId(), TuplesKt.to(-1, new vz1.i(null, r187.getGift().getImage(), null, null, 13)), r187.getNextExpire() - ((System.currentTimeMillis() / 1000) + r187.getNowTimeDiff()), true, false, r188, Long.valueOf(r187.getDiamond()), null, null, null, null, null, null, null, null, null, null, false, null, null, 67108640));
        goto L72
    L81:
        if (K3() == false) goto L83;
        r125.add(new vz1.e((h1) vh7.f.c(h1.class), 0, null, 0, false, true, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108830));
    L83:
        r38 = r16;
        r39 = r24;
        r40 = r23;
        r41 = r125;
        r310 = r110;
        r44 = -1;
        r43 = 1;
        goto L92
    L329:
        r38 = r16;
        r64 = r24;
        r311 = r23;
        r54 = r110;
        goto L331
    L332:
        ArrayList r325 = r16;
        ArrayList r189 = r24;
        LinkedHashMap<Integer, List<vz1.e>> r190 = r110;
        Unit r191 = Unit.INSTANCE;
    L334:
        l0.g(r58.getPanelList(), r189);
        l0.h(r58.getPanelDataExtra(), new GiftPanelDataExtra(r59.e, r59.d, r59.f, r59.g));
        if (this.x == true) goto L339;
        u1 r192 = this.b1;
        if (r192 == null) goto L339;
        r192.j++;
    L339:
        o2 r193 = this.V0;
        r193.getClass();
        if (r325.isEmpty() == true) goto L343;
        ArrayList r194 = r325;
        r193.b = r194;
        r193.c(r194);
    L343:
        if (r61 == false) goto L345;
        G3(r57, r58);
    L345:
        if (r63 == false) goto L347;
        this.G2.c(r190, CollectionsKt.toList(this.V1.f));
    L347:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.d.a("GiftMVIVerticalListViewModel", "refresh gift panel, currentReceiverType" + this.H2.b + ", cache is empty " + r189.isEmpty());
        return;
    L333:
        r325 = r16;
        r189 = r24;
        r190 = r110;
        goto L334
    L50:
        r119 = false;
        goto L51
    L36:
        r114 = false;
        goto L37
    L39:
        r113 = null;
    L52:
        GiftMostlyUsedDataStore r195 = this.K2;
        r195.j = 0;
        r195.k = 0;
        r195.i = false;
        Unit r196 = Unit.INSTANCE;
        goto L53
    L25:
        if (r20.j() != true) goto L27;
        r23 = true;
        goto L28
    L21:
        r19 = null;
        goto L22
    L16:
        if (r15 != RefreshGiftListSource.CHANGE_RECEIVER) goto L18;
        goto L17
    }

    public static /* synthetic */ void w3(GiftMVIVerticalListViewModel r9, l0 r10, GiftVerticalState r11, com.bytedance.android.livesdk.gift.platform.core.model.j r13, ReceiverType r14, boolean r15, int r16) {
        if ((r16 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r8 = false;
    L10:
        r9.t3(r10, r11, r13, r14, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    public final void V2(l0<GiftVerticalState> r25, GiftVerticalState r26, int r27, IntRange r28, IntRange r29, int r30, boolean r31) {
        l0<GiftVerticalState> r1 = r25;
        int r4 = -1;
        if (Intrinsics.areEqual(r29, new IntRange(-1, -1)) == false) goto L5;
        return;
    L5:
        this.b1.g(r29);
        i0 r0 = this.E;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$onScrollChanged");
        Intrinsics.checkNotNullParameter(r26, "state");
        Intrinsics.checkNotNullParameter(r29, "currentRange");
        IntRange r7 = (IntRange) ((LinkedHashMap) r0.a).get(Integer.valueOf(r27));
        if (r7 != null) goto L8;
        r0.a.put(Integer.valueOf(r27), r29);
    L10:
        if (m.a(r28, r29).isEmpty() == false) goto L12;
        this.E.c(r1, r28);
    L46:
        D2(this, r25, r26, r27, m.b(r28, r29), r29, 0, r30, r31, 16);
        return;
    L12:
        i0 r2 = this.E;
        Set<Integer> r8 = m.a(r28, r29);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$refreshGiftShow");
        Intrinsics.checkNotNullParameter(r26, "state");
        Intrinsics.checkNotNullParameter(r8, "diffShowRange");
        LinkedHashMap r6 = new LinkedHashMap();
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator<T> r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L39;
        int r15 = ((Number) r10.next()).intValue();
        if (((LinkedHashMap) r2.c).get(Integer.valueOf(r15)) == null) goto L37;
        k0 r11 = r1.b;
        t0<GiftVerticalState, PagerListData> r13 = r26.getPanelList();
        r11.getClass();
        if (com.bytedance.android.anya.h.a(r13) <= r27) goto L35;
        t0<PagerListData, ItemListData> r14 = ((PagerListData) k0.d(r26.getPanelList(), r27)).getItemDataList();
        if (com.bytedance.android.anya.h.a(r14) <= r15) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == true) goto L26;
        r14 = null;
    L26:
        if (r14 == null) goto L33;
        if (r15 <= r4) goto L33;
        vz1.e r17 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r14, r15)).getItemData());
        u1 r18 = r2.d;
        long r5 = r17.b;
        boolean r19 = !r17.e;
        Integer r3 = (Integer) ((LinkedHashMap) r2.e.c).get(Integer.valueOf(r27));
        if (r3 == null) goto L31;
        int r110 = r3.intValue();
    L32:
        m0.e.getClass();
        boolean r111 = m0.a.a(r17);
        Object r20 = ((LinkedHashMap) r2.c).get(Integer.valueOf(r15));
        Intrinsics.checkNotNull(r20);
        int r21 = r15;
        r18.y0(r5, r19, r110, r27, r21, r111, ((Number) r20).longValue(), System.currentTimeMillis(), ((Number) r2.f.invoke(Integer.valueOf(r27))).intValue());
    L34:
        com.bytedance.android.anya.h.a(((PagerListData) k0.d(r26.getPanelList(), r27)).getCounterDataList());
        com.bytedance.android.anya.h.a(((PagerListData) k0.d(r26.getPanelList(), r27)).getTopicPagerListData());
    L36:
        r9.add(Integer.valueOf(r21));
    L38:
        r1 = r25;
        r4 = -1;
        goto L14
    L31:
        r110 = 0;
    L33:
        r21 = r15;
        goto L34
    L22:
        r16 = false;
        goto L23
    L35:
        r21 = r15;
        goto L36
    L37:
        r6.put(Integer.valueOf(r15), Long.valueOf(System.currentTimeMillis()));
        goto L38
    L39:
        Iterator r23 = ((LinkedHashMap) r2.c).entrySet().iterator();
    L41:
        if (r23.hasNext() == false) goto L45;
        Map.Entry r24 = (Map.Entry) r23.next();
        int r33 = ((Number) r24.getKey()).intValue();
        long r112 = ((Number) r24.getValue()).longValue();
        if (r9.contains(Integer.valueOf(r33)) == true) goto L41;
        r6.put(Integer.valueOf(r33), Long.valueOf(r112));
        goto L41
    L45:
        ((LinkedHashMap) r2.c).clear();
        r2.c.putAll(r6);
        goto L46
    L8:
        r0.a.put(Integer.valueOf(r27), new IntRange(Math.min(r29.getFirst(), r7.getFirst()), Math.max(r29.getLast(), r7.getLast())));
        goto L10
    }

    public static final void e1(GiftMVIVerticalListViewModel r20, l0 r21, GiftVerticalState r23, int r24, int r25, int r26, int r27, int r28) {
        r20.getClass();
        KProperty[] r1 = m.a;
        Intrinsics.checkNotNullParameter(r21, "$this$getListData");
        Intrinsics.checkNotNullParameter(r23, "state");
        t0<GiftVerticalState, PagerListData> r2 = r23.getPanelList();
        r21.getClass();
        SelectedStatus r3 = null;
        if (com.bytedance.android.anya.h.a(r2) <= r24) goto L93;
        u r4 = r23.getPanelList();
        MVIState r5 = (MVIState) ((s0) r4.c()).get(r24);
        new k0.a();     // Catch: Throwable -> L88
        PagerListData r6 = (PagerListData) r5;     // Catch: Throwable -> L88
        if (r27 != (-1)) goto L23;
        if (r28 != (-1)) goto L23;
        if (((s0) r6.getItemDataList().c()).size() <= r26) goto L23;
        u r7 = r6.getItemDataList();     // Catch: Throwable -> L88
        u r8 = r7;     // Catch: Throwable -> L88
        MVIState r9 = (MVIState) ((s0) r7.c()).get(r26);     // Catch: Throwable -> L88
        new k0.a();     // Catch: Throwable -> L18
        ItemListData r10 = (ItemListData) r9;     // Catch: Throwable -> L18
    L13:
        if ((!r9.modifiedProperties.isEmpty()) == false) goto L16;
        ((t) r7.c()).d(r26);     // Catch: Throwable -> L88
    L16:
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L71;
        ((t) r4.c()).d(r24);
    L71:
        ItemListData r16 = r10;
    L94:
        if (r16 != null) goto L97;
        return;
    L97:
        if (r24 != r25) goto L144;
        r r11 = r21.i(r23);
        if ((r11 instanceof GiftListBusinessState.GiftSelected) == true) goto L102;
        r11 = null;
    L102:
        GiftListBusinessState.GiftSelected r13 = (GiftListBusinessState.GiftSelected) r11;
        if (r13 == null) goto L105;
        r3 = r13.getSelectedStatus();
    L105:
        int r17 = 0;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g0.a((vz1.e) com.bytedance.android.anya.h.b(r16.getItemData())) == false) goto L108;
    L125:
        SelectedStatus r14 = SelectedStatus.GROUP;
        if (r3 == r14) goto L145;
        J3(r20, r21, r23, r24, r26, r14, r27, null, r28, 160);
        r20.S1.S(SelectStatus.LONG_PRESS);
        int r15 = (r26 % 4) + 1;
        int r18 = (z1(r21, r23, r27, r24) + (r26 / 4)) + 1;
        u1 r19 = r20.b1;
        long r29 = ((vz1.e) com.bytedance.android.anya.h.b(r16.getItemData())).a.getId();
        Integer r0 = (Integer) ((LinkedHashMap) r20.L0.c).get(Integer.valueOf(r24));
        if (r0 == null) goto L131;
        r17 = r0.intValue();
    L131:
        u1.j0(r19, r29, "bunching_panel", r17, r24, r18, r15, (vz1.e) com.bytedance.android.anya.h.b(r16.getItemData()));
        return;
    L145:
        return;
    L108:
        if (r20.K2.s() == true) goto L110;
    L112:
        r20.u1(r21, r23);
        r20.w1(r21, r23, ClearGiftSource.GroupCancel);
        if (r20.p1.j() == false) goto L117;
        String r30 = s1.B(2131917199);
    L115:
        String r110 = r30;
        int r31 = (r26 % 4) + 1;
        int r33 = (z1(r21, r23, r27, r24) + (r26 / 4)) + 1;
        u1 r34 = r20.b1;
        long r35 = ((vz1.e) com.bytedance.android.anya.h.b(r16.getItemData())).a.getId();
        Integer r36 = (Integer) ((LinkedHashMap) r20.L0.c).get(Integer.valueOf(r24));
        if (r36 == null) goto L123;
        int r37 = r36.intValue();
    L124:
        u1.j0(r34, r35, "toast", r37, r24, r33, r31, (vz1.e) com.bytedance.android.anya.h.b(r16.getItemData()));
        r20.K0(new ShakeGiftIcon(r24, r26, r110, r27, r28));
        return;
    L123:
        r37 = 0;
        goto L124
    L117:
        if (((vz1.e) com.bytedance.android.anya.h.b(r16.getItemData())).a.getBizType() != 1) goto L119;
        r30 = s1.B(2131917200);
        goto L115
    L119:
        r30 = nz1.a.t();
        goto L115
    L110:
        if (((vz1.e) com.bytedance.android.anya.h.b(r16.getItemData())).e == true) goto L112;
    L144:
        return;
    L18:
        th = move-exception;
        if ((!r9.modifiedProperties.isEmpty()) == false) goto L22;
        ((t) r7.c()).d(r26);     // Catch: Throwable -> L88
    L22:
        throw th;     // Catch: Throwable -> L88
    L23:
        if (r27 != (-1)) goto L25;
        if (r28 != (-1)) goto L56;
    L86:
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L93;
        ((t) r4.c()).d(r24);
        goto L93
    L56:
        if (((s0) r6.getTopicPagerListData().c()).size() <= r28) goto L86;
        u r38 = r6.getTopicPagerListData();     // Catch: Throwable -> L88
        u r39 = r38;     // Catch: Throwable -> L88
        MVIState r40 = (MVIState) ((s0) r38.c()).get(r28);     // Catch: Throwable -> L88
        new k0.a();     // Catch: Throwable -> L80
        TopicPagerListData r41 = (TopicPagerListData) r40;     // Catch: Throwable -> L80
        if (((s0) r41.getItemDataList().c()).size() <= r26) goto L78;
        u r43 = r41.getItemDataList();     // Catch: Throwable -> L80
        u r44 = r43;     // Catch: Throwable -> L80
        MVIState r45 = (MVIState) ((s0) r43.c()).get(r26);     // Catch: Throwable -> L80
        new k0.a();     // Catch: Throwable -> L72
        ItemListData r46 = (ItemListData) r45;     // Catch: Throwable -> L72
    L63:
        if ((!r45.modifiedProperties.isEmpty()) == false) goto L66;
        ((t) r43.c()).d(r26);     // Catch: Throwable -> L80
    L66:
        if ((!r40.modifiedProperties.isEmpty()) == false) goto L69;
        ((t) r38.c()).d(r28);     // Catch: Throwable -> L88
    L69:
        if ((!r5.modifiedProperties.isEmpty()) == true) goto L70;
    L40:
        r10 = r46;
    L70:
        ((t) r4.c()).d(r24);
    L72:
        th = move-exception;
        if ((!r45.modifiedProperties.isEmpty()) == false) goto L76;
        ((t) r43.c()).d(r26);     // Catch: Throwable -> L80
    L76:
        throw th;     // Catch: Throwable -> L80
    L78:
        if ((!r40.modifiedProperties.isEmpty()) == false) goto L86;
        ((t) r38.c()).d(r28);     // Catch: Throwable -> L88
    L80:
        th = move-exception;
        if ((!r40.modifiedProperties.isEmpty()) == false) goto L84;
        ((t) r38.c()).d(r28);     // Catch: Throwable -> L88
    L84:
        throw th;     // Catch: Throwable -> L88
    L25:
        if (((s0) r6.getCounterDataList().c()).size() <= r27) goto L86;
        u r47 = r6.getCounterDataList();     // Catch: Throwable -> L88
        u r48 = r47;     // Catch: Throwable -> L88
        MVIState r49 = (MVIState) ((s0) r47.c()).get(r27);     // Catch: Throwable -> L88
        new k0.a();     // Catch: Throwable -> L49
        CounterData r50 = (CounterData) r49;     // Catch: Throwable -> L49
        if (((s0) r50.getItemDataList().c()).size() <= r26) goto L47;
        u r51 = r50.getItemDataList();     // Catch: Throwable -> L49
        u r53 = r51;     // Catch: Throwable -> L49
        MVIState r54 = (MVIState) ((s0) r51.c()).get(r26);     // Catch: Throwable -> L49
        new k0.a();     // Catch: Throwable -> L41
        r46 = (ItemListData) r54;     // Catch: Throwable -> L41
    L32:
        if ((!r54.modifiedProperties.isEmpty()) == false) goto L35;
        ((t) r51.c()).d(r26);     // Catch: Throwable -> L49
    L35:
        if ((!r49.modifiedProperties.isEmpty()) == false) goto L38;
        ((t) r47.c()).d(r27);     // Catch: Throwable -> L88
    L38:
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L40;
    L41:
        th = move-exception;
        if ((!r54.modifiedProperties.isEmpty()) == false) goto L45;
        ((t) r51.c()).d(r26);     // Catch: Throwable -> L49
    L45:
        throw th;     // Catch: Throwable -> L49
    L47:
        if ((!r49.modifiedProperties.isEmpty()) == false) goto L86;
        ((t) r47.c()).d(r27);     // Catch: Throwable -> L88
    L49:
        th = move-exception;
        if ((!r49.modifiedProperties.isEmpty()) == false) goto L53;
        ((t) r47.c()).d(r27);     // Catch: Throwable -> L88
    L53:
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L92;
        ((t) r4.c()).d(r24);
    L92:
        throw th;
    L93:
        r16 = null;
        goto L94
    }

    public static void e3(GiftMVIVerticalListViewModel r20, l0 r21, GiftVerticalState r23, int r24, boolean r25, String r26, boolean r27, int r28) {
        if ((r28 & 8) == 0) goto L5;
        boolean r13 = true;
    L7:
        if ((r28 & 32) == 0) goto L9;
        boolean r2 = false;
    L10:
        r20.getClass();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r5 = r23.getCurrentPagePosition();
        r21.getClass();
        if (r24 != ((Number) com.bytedance.android.anya.h.b(r5)).intValue()) goto L13;
        if (r2 == true) goto L13;
        return;
    L13:
        if (r24 >= 0) goto L15;
    L17:
        Integer r3 = (Integer) ((LinkedHashMap) r20.L0.c).get(Integer.valueOf(r24));
        if (r3 == null) goto L20;
        int r4 = r3.intValue();
    L21:
        r20.M2.y(r24, r4);
        if (com.bytedance.android.anya.h.a(r23.getPanelList()) <= r24) goto L26;
        k0 r6 = r21.b;
        t0<GiftVerticalState, PagerListData> r7 = r23.getPanelList();
        r6.getClass();
        if (((Boolean) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r7, r24)).isTopicPage())).booleanValue() == false) goto L26;
        int r8 = 0;
    L27:
        u1 r9 = r20.b1;
        IRoom r10 = r20.k0.getRoom();
        int r11 = ((Number) com.bytedance.android.anya.h.b(r23.getCurrentPagePosition())).intValue();
        String r14 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        IntRange r15 = (IntRange) ((LinkedHashMap) r20.F).get(Integer.valueOf(r24));
        if (r15 != null) goto L30;
        r15 = new IntRange(-1, -1);
    L30:
        HashMap r16 = new HashMap();
        u r17 = r23.getPanelList();
        MVIState r18 = (MVIState) ((s0) r17.c()).get(r24);
        new k0.a();     // Catch: Throwable -> L118
        Iterator r19 = k0.c(((PagerListData) r18).getItemDataList()).iterator();     // Catch: Throwable -> L118
        int r110 = 0;
    L32:
        if (r19.hasNext() == false) goto L43;
        Object r111 = r19.next();     // Catch: Throwable -> L118
        int r112 = r110 + 1;     // Catch: Throwable -> L118
        if (r110 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L118
    L37:
        ItemListData r113 = (ItemListData) r111;     // Catch: Throwable -> L118
        if (r15.contains(r110) == false) goto L42;
        r16.put(Long.valueOf(((vz1.e) com.bytedance.android.anya.h.b(r113.getItemData())).b), Long.valueOf(r110));     // Catch: Throwable -> L118
    L42:
        r8 = r8;
        r15 = r15;
        r110 = r112;
        goto L32
    L43:
        int r29 = r8;
        if ((!r18.modifiedProperties.isEmpty()) == false) goto L46;
        ((t) r17.c()).d(r24);
    L46:
        String r30 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a0(r16);
        Integer r31 = (Integer) ((LinkedHashMap) r20.L0.c).get(Integer.valueOf(r24));
        if (r31 == null) goto L49;
        int r33 = r31.intValue();
    L50:
        Integer r34 = (Integer) ((LinkedHashMap) r20.L0.c).get(com.bytedance.android.anya.h.b(r23.getCurrentPagePosition()));
        if (r34 == null) goto L53;
        int r35 = r34.intValue();
    L54:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r30, "giftSeen");
        Intrinsics.checkNotNullParameter(r26, "switchFrom");
        LinkedHashMap r36 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r36, "$this$addTabExtraInfo");
        String r114 = (String) ((LinkedHashMap) r9.a).get("red_dot");
        String r115 = BuildConfig.FLAVOR;
        if (r114 != null) goto L57;
        r114 = BuildConfig.FLAVOR;
    L57:
        r36.put("red_dot", r114);
        if (r10 == null) goto L63;
        String r116 = r10.getAnchorId();
        if (r116 != null) goto L62;
        r116 = BuildConfig.FLAVOR;
    L62:
        r36.put("anchor_id", r116);
        r36.put("room_id", String.valueOf(r10.getId()));
    L63:
        r36.put("switch_from", r26);
        int r1 = r24 + 1;
        r36.put("page", String.valueOf(r1));
        r36.put("pageType", String.valueOf(r33));
        r36.put("gift_seen", r30);
        r36.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r33));
        r36.put("from_tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r35));
        if (r33 != r35) goto L66;
        String r37 = "0";
    L67:
        r36.put("is_tab_switch", r37);
        r36.put("tab_location", String.valueOf(r1));
        r36.put("from_page", String.valueOf(r11 + 1));
        GiftContext r38 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r38 == null) goto L73;
        com.bytedance.live.datacontext.m<String> r39 = r38.getGiftListResultLogId();
        if (r39 == null) goto L73;
        String r40 = (String) r39.getValue();
        if (r40 == null) goto L73;
    L74:
        r36.put("gift_dialog_request_id", r40);
        Long r41 = Long.valueOf(r9.m.e.e);
        if (r41.longValue() == 0) goto L77;
        boolean r43 = true;
    L78:
        Long r44 = null;
        if (r43 == true) goto L82;
        r41 = null;
    L82:
        if (r41 != null) goto L88;
        r41 = Long.valueOf(r9.m.e.a);
        if (r41.longValue() == 0) goto L86;
        boolean r45 = true;
    L87:
        if (r45 == true) goto L88;
    L89:
        if (r44 == null) goto L91;
        long r46 = r44.longValue();
    L92:
        long r47 = System.currentTimeMillis();
        r9.m.e.e = r47;
        r36.put("switch_time", String.valueOf(((r47 - r46) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        GiftContext r48 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r48 == null) goto L104;
        com.bytedance.live.datacontext.n<Bundle> r49 = r48.getGiftLogExtra();
        if (r49 == null) goto L104;
        Bundle r50 = (Bundle) r49.getValue();
        if (r50 == null) goto L104;
        Object r51 = r50.get("gift_show_from");
        if (r51 == null) goto L104;
        String r53 = r51.toString();
        if (r53 == null) goto L104;
        r115 = r53;
    L104:
        r36.put("source", r115);
        r36.putAll(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService().q());
        r9.p1("livesdk_gift_pages_show", r36, true);
        r20.E.a(r21, r23, ((Number) com.bytedance.android.anya.h.b(r23.getCurrentPagePosition())).intValue());
        r20.u1(r21, r23);
        IntRange r54 = new IntRange(-1, -1);
        IntRange r55 = (IntRange) ((LinkedHashMap) r20.F).get(Integer.valueOf(r24));
        if (r55 != null) goto L107;
        r55 = new IntRange(-1, -1);
    L107:
        r20.V2(r21, r23, r24, r54, r55, r29, false);
        IntRange r56 = new IntRange(-1, -1);
        IntRange r57 = (IntRange) ((LinkedHashMap) r20.Q).get(Integer.valueOf(r24));
        if (r57 != null) goto L110;
        r57 = new IntRange(-1, -1);
    L110:
        r20.P2(r23, r56, r57, r24);
        LinkedHashMap r58 = new LinkedHashMap();
        Map<Integer, IntRange> r59 = (Map) ((LinkedHashMap) r20.R).get(Integer.valueOf(r24));
        if (r59 != null) goto L113;
        r59 = new LinkedHashMap();
    L113:
        r20.J2(r21, r23, r24, r58, r59);
        if (r13 == false) goto L116;
        r20.K0(new ChangeViewPagerPositionEffect(r24));
    L116:
        l0.h(r23.getCurrentPagePosition(), Integer.valueOf(r24));
        return;
    L91:
        r46 = System.currentTimeMillis();
        goto L92
    L86:
        r45 = false;
    L88:
        r44 = r41;
        goto L89
    L77:
        r43 = false;
    L73:
        r40 = BuildConfig.FLAVOR;
        goto L74
    L66:
        r37 = "1";
        goto L67
    L53:
        r35 = 0;
        goto L54
    L49:
        r33 = 0;
    L118:
        th = move-exception;
        if ((!r18.modifiedProperties.isEmpty()) == false) goto L122;
        ((t) r17.c()).d(r24);
    L122:
        throw th;
    L26:
        r8 = -1;
        goto L27
    L20:
        r4 = 0;
        goto L21
    L15:
        if (r24 >= com.bytedance.android.anya.h.a(r23.getPanelList())) goto L17;
        l0.a r60 = l0.e(r23.getPanelList(), r24);
        l0 r61 = r60.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r63 = ((PagerListData) r60.a).getTabType();
        r61.getClass();
        r4 = ((Number) com.bytedance.android.anya.h.b(r63)).intValue();
        goto L21
    L9:
        r2 = r27;
        goto L10
    L5:
        r13 = r25;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0] */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.bytedance.android.livesdk.gift.model.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void D3(final l0<GiftVerticalState> r30, final GiftVerticalState r31, final int r33, final int r34, final vz1.e r35, final o0 r36, final p0 r37, final com.bytedance.android.livesdk.gift.platform.core.model.n r38) {
        t0<GiftVerticalState, PagerListData> r0 = r31.getPanelList();
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r1 = r31.getCurrentPagePosition();
        r30.getClass();
        l0.a r2 = l0.e(r0, ((Number) com.bytedance.android.anya.h.b(r1)).intValue());
        l0 r3 = r2.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r4 = ((PagerListData) r2.a).getTabType();
        r3.getClass();
        final int r13 = ((Number) com.bytedance.android.anya.h.b(r4)).intValue();
        l0.a r5 = l0.e(r31.getPanelList(), ((Number) com.bytedance.android.anya.h.b(r31.getCurrentPagePosition())).intValue());
        l0 r6 = r5.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r7 = ((PagerListData) r5.a).getSelectedTopicId();
        r6.getClass();
        final String r27 = this.y2.c(r13, ((Number) com.bytedance.android.anya.h.b(r7)).longValue());
        int r8 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        final int r9 = com.bytedance.android.livesdk.gift.platform.core.utils.g.f(r35, this.p2);
        if (r35 == null) goto L38;
        Object r10 = null;
        if (r9 > 1) goto L7;
        ?? r11 = this.Z;
        if (r36 == null) goto L21;
        l1 r14 = r36.a;
        if (r14 == null) goto L21;
        int r18 = r14.getBuffLevel();
    L22:
        if (r37 == null) goto L26;
        com.bytedance.android.livesdk.gift.model.n r15 = r37.a;
        if (r15 == null) goto L26;
        r10 = gz1.c.g(r15);
    L26:
        ?? r19 = r10;
        if (r37 == null) goto L29;
        boolean r20 = true;
    L30:
        Function0<Unit> r21 = new GiftMVIVerticalListViewModel$sendGift$$inlined$let$lambda$1(this, r30, r9, r38, r36, r37, r27, r35, r33, r34, r31, r13);
        if (r37 == null) goto L35;
        com.bytedance.android.livesdk.gift.model.n r16 = r37.a;
        if (r16 == null) goto L35;
        long r17 = r16.getConfigId();
    L36:
        r11.f(r33, r34, r35, r18, r19, r20, r21, r17, r13, r38, this.b1.g, r27, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r35.b, this.x1, this.E2, this.T));
        return;
    L35:
        r17 = 0;
        goto L36
    L29:
        r20 = false;
    L21:
        r18 = 0;
        goto L22
    L7:
        if (nz1.a.g() == false) goto L15;
        ?? r23 = this.Z;
        if (r36 == null) goto L11;
        l1 r24 = r36.a;
    L12:
        if (r37 == null) goto L14;
        r10 = r37.a;
    L14:
        r23.c(r9, r35, r38, r24, r10, r27, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r35.b, this.x1, this.E2, this.T), GiftMVIVerticalListViewModel$sendGift$1$1.INSTANCE);
        return;
    L11:
        r24 = null;
        goto L12
    L15:
        this.Z.a(r9, r35, r38, r27, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r35.b, this.x1, this.E2, this.T), GiftMVIVerticalListViewModel$sendGift$1$2.INSTANCE);
        return;
    }

    public final void Z2(l0<GiftVerticalState> r13, GiftVerticalState r14, int r15, int r16, int r17, int r18, int r19, vz1.e r20, com.bytedance.android.livesdk.gift.platform.core.model.n r21) {
        com.bytedance.android.anya.u0<GiftVerticalState, GiftComboState> r0 = r14.getComboState();
        r13.getClass();
        int r3 = r19 - ((Number) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r0)).getComboNum())).intValue();
        if (r20.e != true) goto L10;
        vz1.h r1 = r20.g;
        if (r1.f == 4) goto L10;
        if (r1.b >= 1) goto L10;
        K0(new ShowProbCountErrorTipsEffect());
        return;
    L10:
        y3(r13, r14, r15, r16, r3);
        SubStatePropertyImpl r2 = r14.getComboState();
        new k0.a();
        GiftComboState r4 = (GiftComboState) r2.c();
        com.bytedance.android.anya.internal.c r5 = r4.getComboNum();
        com.bytedance.android.anya.internal.c r6 = r5;
        r6.a(Integer.valueOf(r19));
        com.bytedance.android.anya.internal.c r7 = r4.getComboStatus();
        com.bytedance.android.anya.internal.c r8 = r7;
        r8.a(ComboState.ON_LONG_CLICK);
        com.bytedance.android.anya.internal.c r9 = r4.getPositionX();
        com.bytedance.android.anya.internal.c r10 = r9;
        r10.a(Integer.valueOf(r17));
        com.bytedance.android.anya.internal.c r11 = r4.getPositionY();
        com.bytedance.android.anya.internal.c r23 = r11;
        r23.a(Integer.valueOf(r18));
        if (nz1.a.h().c() == false) goto L14;
        GiftBuffCardHelper.Companion r24 = GiftBuffCardHelper.a;
        l1 r25 = this.b2.q();
        h1 r26 = r20.a;
        r24.getClass();
        this.A = GiftBuffCardHelper.Companion.h(r25, r26);
    L14:
        if (nz1.a.h().d() == false) goto L16;
        GiftBuffCardHelper.Companion r27 = GiftBuffCardHelper.a;
        com.bytedance.android.livesdk.gift.model.n r28 = this.b2.k();
        h1 r29 = r20.a;
        r27.getClass();
        this.B = GiftBuffCardHelper.Companion.i(r28, r29);
    L16:
        D3(r13, r14, r3, 3, r20, this.A, this.B, r21);
    }

    public static void D2(GiftMVIVerticalListViewModel r57, l0 r58, GiftVerticalState r59, int r60, Set r61, IntRange r63, int r64, int r65, boolean r66, int r67) {
        GiftMVIVerticalListViewModel r15 = r57;
        l0 r14 = r58;
        int r13 = r60;
        int r16 = -1;
        if ((r67 & 16) == 0) goto L5;
        int r11 = -1;
    L7:
        if ((r67 & 32) == 0) goto L9;
        int r8 = -1;
    L11:
        if ((r67 & 64) == 0) goto L13;
        boolean r20 = false;
    L14:
        r57.getClass();
        r r0 = r58.i(r59);
        boolean r1 = r0 instanceof GiftListBusinessState.GiftSelected;
        if (r1 == false) goto L17;
        vz1.e r5 = ((GiftListBusinessState.GiftSelected) r0).getIconModel();
    L18:
        if (r1 == false) goto L20;
        SelectedStatus r2 = ((GiftListBusinessState.GiftSelected) r0).getSelectedStatus();
    L21:
        SelectedStatus r4 = r2;
        int r21 = z1(r14, r59, r11, r13);
        int r23 = com.bytedance.android.anya.h.a(r59.getPanelList());
        l0.a r3 = l0.e(r59.getPanelList(), r13);
        l0 r6 = r3.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r7 = ((PagerListData) r3.a).getSelectedTopicId();
        r6.getClass();
        long r9 = ((Number) com.bytedance.android.anya.h.b(r7)).longValue();
        l0.a r10 = l0.e(r59.getPanelList(), r13);
        l0 r17 = r10.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r18 = ((PagerListData) r10.a).getTabType();
        r17.getClass();
        int r68 = r8;
        String r24 = r15.y2.c(((Number) com.bytedance.android.anya.h.b(r18)).intValue(), r9);
        z1 r25 = r15.E2.k();
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = null;
        ArrayList r26 = new ArrayList();
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.o.getValue()).booleanValue() == false) goto L48;
        Integer r27 = (Integer) ((LinkedHashMap) r15.L0.c).get(Integer.valueOf(r60));
        if (r27 == null) goto L26;
        int r28 = r27.intValue();
    L27:
        u1 r29 = r15.b1;
        boolean r40 = GiftPanelBizBoostUtils.b().Y1();
        r29.getClass();
        String r210 = u1.s();
        HashMap<String, String> r211 = ay1.b.l();
        String r212 = ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r28);
        String r213 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a());
        String r30 = r29.w();
        GiftContext r31 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r31 == null) goto L32;
        com.bytedance.live.datacontext.n<Bundle> r33 = r31.getGiftLogExtra();
        if (r33 == null) goto L32;
        Bundle r34 = (Bundle) r33.getValue();
    L33:
        HashMap r35 = vh6.c.b(er2.b.class).Z6();
        boolean r36 = tz1.a.d(r28);
        GiftManagerKt.z.getClass();
        Map r37 = GiftManagerKt.o();
        com.bytedance.android.livesdk.gift.platform.business.config.n r38 = (com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class);
        String r39 = r29.I(r29.p.a.getIdString());
        if (r29.r.i().size() <= 1) goto L36;
        boolean r310 = true;
    L37:
        i12.e r41 = i12.o.b();
        if (r41 == null) goto L40;
        Object r43 = com.bytedance.android.scope.m.e.d(r41, GroupLiveReceiverService.class);
    L41:
        GroupLiveReceiverService r44 = (GroupLiveReceiverService) r43;
        if (r44 != null) goto L44;
    L46:
        boolean r311 = false;
    L47:
        r19.element = new u1.b(r210, r211, r212, r213, r30, r34, r35, r36, r37, r38, r39, r310, r311, r29.t1(r29.q.R(r29.p.a), r29.p.a), r40);
        goto L48
    L44:
        if (r44.i() != true) goto L46;
        r311 = true;
        goto L47
    L40:
        r43 = null;
        goto L41
    L36:
        r310 = false;
    L32:
        r34 = null;
        goto L33
    L26:
        r28 = 0;
    L48:
        Iterator r214 = r61.iterator();
        GiftMVIVerticalListViewModel r45 = r15;
    L50:
        if (r214.hasNext() == false) goto L447;
        int r46 = ((Number) r214.next()).intValue();
        k0 r47 = r14.b;
        t0<GiftVerticalState, PagerListData> r48 = r59.getPanelList();
        r47.getClass();
        if (com.bytedance.android.anya.h.a(r48) <= r13) goto L66;
        t0<PagerListData, ItemListData> r49 = ((PagerListData) k0.d(r59.getPanelList(), r13)).getItemDataList();
        if (com.bytedance.android.anya.h.a(r49) <= r46) goto L56;
        boolean r50 = true;
    L57:
        if (r50 == true) goto L60;
        r49 = null;
    L60:
        if (r49 == null) goto L65;
        if (r46 <= r16) goto L65;
        vz1.e r51 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r49, r46)).getItemData());
        m0.e.getClass();
        if (m0.a.a(r51) == false) goto L65;
        r45.K0(new ShowSweepAnim(r13, r46));
    L65:
        com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r13)).getCounterDataList());
        com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r13)).getTopicPagerListData());
        goto L66
    L56:
        r50 = false;
    L66:
        k0 r53 = r14.b;
        t0<GiftVerticalState, PagerListData> r54 = r59.getPanelList();
        r53.getClass();
        if (com.bytedance.android.anya.h.a(r54) <= r13) goto L424;
        t0<PagerListData, ItemListData> r55 = ((PagerListData) k0.d(r59.getPanelList(), r13)).getItemDataList();
        if (com.bytedance.android.anya.h.a(r55) <= r46) goto L71;
        boolean r56 = true;
    L72:
        if (r56 == true) goto L75;
        r55 = null;
    L75:
        long r215 = 0;
        if (r55 == null) goto L186;
        if (r46 <= r16) goto L184;
        vz1.e r69 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r55, r46)).getItemData());
        long r110 = r69.a.getId();
        if (r5 != null) goto L81;
    L82:
        r45.E2.getClass();
    L83:
        long r70 = r69.b;
        if (r5 != null) goto L86;
    L100:
        GiftPanelIconSource r71 = r69.q;
    L101:
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = CardType.None;
        ArrayList r112 = r26;
        Ref.ObjectRef r113 = r19;
        long r73 = r69.b;
        if (r5 != null) goto L104;
    L124:
        String r74 = r69.t.a;
    L125:
        long r75 = r69.b;
        if (r5 != null) goto L128;
    L145:
        r111.element = CardType.DIY;
        List r76 = r69.t.b;
    L146:
        Ref.BooleanRef r77 = new Ref.BooleanRef();
        r77.element = false;
        int r114 = r11;
        long r115 = r69.b;
        if (r5 != null) goto L149;
    L153:
        g0 r78 = r45.x1.q(r115);
        if (r78 == null) goto L158;
        l3 r79 = r78.getSeriesGift();
        if (r79 == null) goto L158;
        String r116 = r79.getName();
    L159:
        com.bytedance.android.livesdk.gift.model.k0 r80 = r69.a.getGiftPreviewInfo();
        if (r80 != null) goto L162;
    L164:
        boolean r117 = false;
    L165:
        e2 r81 = r69.a.getGiftTouchLabel();
        if (r81 == null) goto L168;
        String r118 = r81.getTouchUniqueKey();
    L169:
        List r83 = r76;
        t0<PagerListData, ItemListData> r312 = null;
        vz1.e r410 = r5;
        String r84 = r116;
        Ref.ObjectRef r313 = r113;
        int r411 = r68;
        int r412 = r114;
        int r413 = r46;
        e r85 = new e(r69, r71, r74, r83, r117, r118, r84, r77, ((r46 / 4) + 1) + r21, (r46 % 4) + 1, r111, r46, r57, r60, r25, r23, r24, r313, r112);
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.b().Y1() == false) goto L172;
        ArrayList r119 = r112;
        r119.add(r85);
    L174:
        if (r69.e == false) goto L178;
        vz1.h r86 = r69.g;
        long r87 = r86.f;
        if (r87 != 4) goto L178;
        GiftMVIVerticalListViewModel r120 = r57;
        r120.b1.N0(r86.b, r86.l, r87, r86.k);
    L180:
        if (r69.a.getMysteryShopStatus() == 0) goto L182;
        u1 r88 = r120.b1;
        long r89 = r69.a.getId();
        int r90 = r69.a.getMysteryShopStatus();
        r88.getClass();
        String r121 = "livesdk_distinct_mystery_gift_show";
        r88.p1(r121, u1.E(r89, r90), true);
    L183:
        r45 = r120;
    L185:
        Unit r91 = Unit.INSTANCE;
    L187:
        int r93 = r412;
        if (com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r60)).getCounterDataList()) > r93) goto L190;
    L305:
        int r510 = r93;
        SelectedStatus r511 = r4;
        vz1.e r414 = r410;
    L306:
        int r94 = r411;
        if (com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r60)).getTopicPagerListData()) > r94) goto L309;
    L423:
        int r216 = r94;
        GiftMVIVerticalListViewModel r122 = r120;
        ArrayList r95 = r119;
        vz1.e r217 = r414;
        SelectedStatus r314 = r511;
        boolean r96 = true;
    L426:
        Unit r97 = Unit.INSTANCE;
        if (v.c() == false) goto L445;
        l0 r98 = r58;
        k0 r99 = r98.b;
        t0<GiftVerticalState, PagerListData> r100 = r59.getPanelList();
        r99.getClass();
        int r101 = com.bytedance.android.anya.h.a(r100);
        int r102 = r60;
        if (r101 <= r102) goto L446;
        t0<PagerListData, ItemListData> r103 = ((PagerListData) k0.d(r59.getPanelList(), r102)).getItemDataList();
        int r104 = r413;
        if (com.bytedance.android.anya.h.a(r103) <= r104) goto L433;
        boolean r105 = true;
    L434:
        if (r105 == true) goto L437;
        r103 = r312;
    L437:
        if (r103 == null) goto L446;
        if (((Boolean) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r103, r104)).isGuideItem())).booleanValue() == false) goto L446;
        u1 r106 = r45.b1;
        r106.getClass();
        LinkedHashMap r107 = new LinkedHashMap();
        if (r106.A() == false) goto L443;
        String r108 = "1";
    L444:
        r107.put("is_anchor", r108);
        r106.p1("livesdk_gift_recommend_to_find_chain_show", r107, r96);
        goto L446
    L443:
        r108 = "0";
        goto L444
    L433:
        r105 = false;
    L446:
        r26 = r95;
        r14 = r98;
        r13 = r102;
        r15 = r122;
        r5 = r217;
        r68 = r216;
        r19 = r313;
        r4 = r314;
        r11 = r510;
        r16 = -1;
        goto L50
    L445:
        r98 = r58;
        r102 = r60;
        goto L446
    L309:
        if (r94 == (-1)) goto L423;
        TopicPagerListData r109 = (TopicPagerListData) k0.d(((PagerListData) k0.d(r59.getPanelList(), r60)).getTopicPagerListData(), r94);
        int r123 = r413;
        if (com.bytedance.android.anya.h.a(r109.getItemDataList()) <= r123) goto L422;
        if (r123 == (-1)) goto L422;
        vz1.e r124 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r109.getItemDataList(), r123)).getItemData());
        long r125 = r124.a.getId();
        vz1.e r126 = r414;
        if (r126 != null) goto L316;
    L317:
        r45.E2.getClass();
    L318:
        long r127 = r124.b;
        if (r126 != null) goto L321;
    L334:
        GiftPanelIconSource r128 = r124.q;
    L335:
        GiftPanelIconSource r129 = r128;
        Ref.ObjectRef r130 = new Ref.ObjectRef();
        r130.element = CardType.None;
        long r131 = r124.b;
        if (r126 != null) goto L338;
    L359:
        t0<PagerListData, ItemListData> r132 = r124.t.a;
    L360:
        t0<PagerListData, ItemListData> r133 = r132;
    L361:
        long r134 = r124.b;
        String r610 = r121;
        if (r126 != null) goto L364;
    L381:
        r130.element = CardType.DIY;
        t0<PagerListData, ItemListData> r135 = r124.t.b;
    L382:
        t0<PagerListData, ItemListData> r136 = r135;
    L383:
        Ref.BooleanRef r137 = new Ref.BooleanRef();
        r137.element = false;
        long r138 = r124.b;
        if (r126 != null) goto L386;
    L390:
        SelectedStatus r139 = r511;
    L391:
        g0 r140 = r45.x1.q(r138);
        if (r140 == null) goto L396;
        l3 r141 = r140.getSeriesGift();
        if (r141 == null) goto L396;
        t0<PagerListData, ItemListData> r142 = r141.getName();
    L397:
        com.bytedance.android.livesdk.gift.model.k0 r143 = r124.a.getGiftPreviewInfo();
        if (r143 != null) goto L400;
    L402:
        boolean r144 = false;
    L403:
        e2 r145 = r124.a.getGiftTouchLabel();
        if (r145 == null) goto L406;
        t0<PagerListData, ItemListData> r146 = r145.getTouchUniqueKey();
    L407:
        r217 = r126;
        r413 = r123;
        r216 = r94;
        r314 = r139;
        ArrayList r611 = r119;
        g r147 = new g(r124, r129, r133, r136, r144, r146, r142, r137, ((r123 / 4) + 1) + r21, (r123 % 4) + 1, r130, r413, r57, r60, r25, r23, r24, r313, r611);
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.b().Y1() == false) goto L410;
        r95 = r611;
        r95.add(r147);
    L412:
        if (r124.e == false) goto L416;
        vz1.h r148 = r124.g;
        long r149 = r148.f;
        if (r149 != 4) goto L416;
        r122 = r57;
        r122.b1.N0(r148.b, r148.l, r149, r148.k);
    L418:
        if (r124.a.getMysteryShopStatus() == 0) goto L420;
        u1 r150 = r122.b1;
        long r151 = r124.a.getId();
        int r152 = r124.a.getMysteryShopStatus();
        r150.getClass();
        r96 = true;
        r150.p1(r610, u1.E(r151, r152), true);
    L421:
        r45 = r122;
        goto L426
    L420:
        r96 = true;
    L416:
        r122 = r57;
        goto L418
    L410:
        r95 = r611;
        r147.run();
        goto L412
    L406:
        r146 = r312;
        goto L407
    L400:
        if (r143.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L402;
        r144 = true;
    L396:
        r142 = r312;
        goto L397
    L386:
        if (r138 != r126.b) goto L390;
        r139 = r511;
        if (r139 != SelectedStatus.SERIES_CARD) goto L391;
        r137.element = true;
        goto L391
    L364:
        if (r134 != r126.b) goto L381;
        p0 r153 = r45.B;
        if (r153 == null) goto L373;
        r130.element = CardType.DIY;
        com.bytedance.android.livesdk.gift.model.n r154 = r153.a;
        if (r154 == null) goto L371;
        r135 = gz1.c.g(r154);
        goto L382
    L371:
        r135 = r312;
        goto L382
    L373:
        if (r45.A == null) goto L380;
        r130.element = CardType.Buff;
        e3 r155 = (e3) vh7.f.c(e3.class);
        o0 r156 = r45.A;
        if (r156 == null) goto L379;
        l1 r157 = r156.a;
        if (r157 == null) goto L379;
        r215 = r157.getBuffGiftId();
    L379:
        r155.setPluginId(r215);
        r135 = CollectionsKt.listOf(r155);
        goto L382
    L380:
        r136 = r312;
        goto L383
    L338:
        if (r131 != r126.b) goto L359;
        p0 r158 = r45.B;
        if (r158 == null) goto L346;
        com.bytedance.android.livesdk.gift.model.n r159 = r158.a;
        if (r159 == null) goto L345;
        r132 = r159.getCardName();
        goto L360
    L345:
        r132 = r312;
        goto L360
    L346:
        o0 r160 = r45.A;
        if (r160 == null) goto L356;
        l1 r161 = r160.a;
        if (r161 == null) goto L351;
        long r162 = r161.getBuffGiftId();
    L352:
        h2 r163 = GiftManagerKt.l(r162);
        if (r163 == null) goto L358;
        r132 = r163.getName();
    L358:
        r133 = r312;
        goto L361
    L351:
        r162 = 0;
        goto L352
    L356:
        if (r2.a(r124.t.a) == false) goto L358;
        r132 = r124.t.a;
        goto L360
    L321:
        if (r127 != r126.b) goto L334;
        p0 r164 = r45.B;
        if (r164 == null) goto L329;
        GiftBuffCardHelper.Companion r165 = GiftBuffCardHelper.a;
        Intrinsics.checkNotNull(r164);
        com.bytedance.android.livesdk.gift.model.n r166 = r164.a;
        com.bytedance.android.livesdk.gift.model.n r167 = r45.x1.I(Long.valueOf(r124.b));
        r165.getClass();
        if (GiftBuffCardHelper.Companion.a(r166, r167) == false) goto L329;
        r128 = GiftPanelIconSource.DIY_CARD;
    L329:
        if (r45.A == null) goto L333;
        l1.a r168 = l1.Companion;
        int r169 = r45.J1(r60);
        o0 r170 = r45.A;
        Intrinsics.checkNotNull(r170);
        l1 r171 = r170.a;
        r168.getClass();
        if (l1.a.g(r169, r171) == 0) goto L333;
        r128 = GiftPanelIconSource.BUFF_CARD;
    L333:
        r128 = GiftPanelIconSource.GIFT_LIST;
        goto L335
    L316:
        if (r125 == r126.b) goto L318;
    L422:
        r413 = r123;
        goto L423
    L190:
        if (r93 == (-1)) goto L305;
        CounterData r172 = (CounterData) k0.d(((PagerListData) k0.d(r59.getPanelList(), r60)).getCounterDataList(), r93);
        int r173 = r413;
        if (com.bytedance.android.anya.h.a(r172.getItemDataList()) <= r173) goto L304;
        if (r173 == (-1)) goto L304;
        vz1.e r174 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r172.getItemDataList(), r173)).getItemData());
        long r175 = r174.a.getId();
        vz1.e r176 = r410;
        if (r176 != null) goto L197;
    L198:
        r45.E2.getClass();
    L199:
        long r177 = r174.b;
        if (r176 != null) goto L202;
    L215:
        GiftPanelIconSource r178 = r174.q;
    L216:
        GiftPanelIconSource r179 = r178;
        Ref.ObjectRef r180 = new Ref.ObjectRef();
        r180.element = CardType.None;
        long r181 = r174.b;
        if (r176 != null) goto L219;
    L240:
        t0<PagerListData, ItemListData> r182 = r174.t.a;
    L241:
        t0<PagerListData, ItemListData> r183 = r182;
    L242:
        long r184 = r174.b;
        String r612 = r121;
        if (r176 != null) goto L245;
    L263:
        r180.element = CardType.DIY;
        t0<PagerListData, ItemListData> r185 = r174.t.b;
    L264:
        t0<PagerListData, ItemListData> r186 = r185;
    L265:
        Ref.BooleanRef r187 = new Ref.BooleanRef();
        r187.element = false;
        long r188 = r174.b;
        if (r176 != null) goto L268;
    L272:
        SelectedStatus r189 = r4;
    L273:
        g0 r190 = r45.x1.q(r188);
        if (r190 == null) goto L278;
        l3 r191 = r190.getSeriesGift();
        if (r191 == null) goto L278;
        t0<PagerListData, ItemListData> r192 = r191.getName();
    L279:
        com.bytedance.android.livesdk.gift.model.k0 r193 = r174.a.getGiftPreviewInfo();
        if (r193 != null) goto L282;
    L284:
        boolean r194 = false;
    L285:
        e2 r195 = r174.a.getGiftTouchLabel();
        if (r195 == null) goto L288;
        t0<PagerListData, ItemListData> r196 = r195.getTouchUniqueKey();
    L289:
        r413 = r173;
        r414 = r176;
        r510 = r93;
        r511 = r189;
        ArrayList r613 = r119;
        f r197 = new f(r174, r179, r183, r186, r194, r196, r192, r187, ((r173 / 4) + 1) + r21, (r173 % 4) + 1, r180, r413, r57, r60, r25, r23, r24, r313, r613);
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.b().Y1() == false) goto L292;
        r119 = r613;
        r119.add(r197);
    L294:
        if (r174.e == false) goto L298;
        vz1.h r198 = r174.g;
        long r199 = r198.f;
        if (r199 != 4) goto L298;
        r120 = r57;
        r120.b1.N0(r198.b, r198.l, r199, r198.k);
    L300:
        if (r174.a.getMysteryShopStatus() == 0) goto L302;
        u1 r200 = r120.b1;
        long r201 = r174.a.getId();
        int r202 = r174.a.getMysteryShopStatus();
        r200.getClass();
        r121 = r612;
        r200.p1(r121, u1.E(r201, r202), true);
    L303:
        r45 = r120;
        goto L306
    L302:
        r121 = r612;
    L298:
        r120 = r57;
        goto L300
    L292:
        r119 = r613;
        r197.run();
        goto L294
    L288:
        r196 = r312;
        goto L289
    L282:
        if (r193.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L284;
        r194 = true;
    L278:
        r192 = r312;
        goto L279
    L268:
        if (r188 != r176.b) goto L272;
        r189 = r4;
        if (r189 != SelectedStatus.SERIES_CARD) goto L273;
        r187.element = true;
        goto L273
    L245:
        if (r184 != r176.b) goto L263;
        p0 r203 = r45.B;
        if (r203 == null) goto L254;
        r180.element = CardType.DIY;
        com.bytedance.android.livesdk.gift.model.n r204 = r203.a;
        if (r204 == null) goto L252;
        r185 = gz1.c.g(r204);
        goto L264
    L252:
        r185 = r312;
        goto L264
    L254:
        if (r45.A == null) goto L262;
        r180.element = CardType.Buff;
        e3 r205 = (e3) vh7.f.c(e3.class);
        o0 r206 = r45.A;
        if (r206 == null) goto L260;
        l1 r207 = r206.a;
        if (r207 == null) goto L260;
        long r208 = r207.getBuffGiftId();
    L261:
        r205.setPluginId(r208);
        r185 = CollectionsKt.listOf(r205);
    L260:
        r208 = 0;
        goto L261
    L262:
        r186 = r312;
        goto L265
    L219:
        if (r181 != r176.b) goto L240;
        p0 r209 = r45.B;
        if (r209 == null) goto L227;
        com.bytedance.android.livesdk.gift.model.n r218 = r209.a;
        if (r218 == null) goto L226;
        r182 = r218.getCardName();
        goto L241
    L226:
        r182 = r312;
        goto L241
    L227:
        o0 r219 = r45.A;
        if (r219 == null) goto L237;
        l1 r220 = r219.a;
        if (r220 == null) goto L232;
        long r221 = r220.getBuffGiftId();
    L233:
        h2 r222 = GiftManagerKt.l(r221);
        if (r222 == null) goto L239;
        r182 = r222.getName();
    L239:
        r183 = r312;
        goto L242
    L232:
        r221 = 0;
        goto L233
    L237:
        if (r2.a(r174.t.a) == false) goto L239;
        r182 = r174.t.a;
        goto L241
    L202:
        if (r177 != r176.b) goto L215;
        p0 r223 = r45.B;
        if (r223 == null) goto L210;
        GiftBuffCardHelper.Companion r224 = GiftBuffCardHelper.a;
        Intrinsics.checkNotNull(r223);
        com.bytedance.android.livesdk.gift.model.n r225 = r223.a;
        com.bytedance.android.livesdk.gift.model.n r226 = r45.x1.I(Long.valueOf(r174.b));
        r224.getClass();
        if (GiftBuffCardHelper.Companion.a(r225, r226) == false) goto L210;
        r178 = GiftPanelIconSource.DIY_CARD;
    L210:
        if (r45.A == null) goto L214;
        l1.a r227 = l1.Companion;
        int r228 = r45.J1(r60);
        o0 r229 = r45.A;
        Intrinsics.checkNotNull(r229);
        l1 r230 = r229.a;
        r227.getClass();
        if (l1.a.g(r228, r230) == 0) goto L214;
        r178 = GiftPanelIconSource.BUFF_CARD;
    L214:
        r178 = GiftPanelIconSource.GIFT_LIST;
        goto L216
    L197:
        if (r175 == r176.b) goto L199;
    L304:
        r413 = r173;
        goto L305
    L182:
        r121 = "livesdk_distinct_mystery_gift_show";
    L178:
        r120 = r57;
        goto L180
    L172:
        r119 = r112;
        r85.run();
        goto L174
    L168:
        r118 = null;
        goto L169
    L162:
        if (r80.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L164;
        r117 = true;
    L158:
        r116 = null;
        goto L159
    L149:
        if (r115 != r5.b) goto L153;
        if (r4 != SelectedStatus.SERIES_CARD) goto L153;
        r77.element = true;
        goto L153
    L128:
        if (r75 != r5.b) goto L145;
        p0 r231 = r45.B;
        if (r231 == null) goto L136;
        r111.element = CardType.DIY;
        com.bytedance.android.livesdk.gift.model.n r232 = r231.a;
        if (r232 == null) goto L144;
        r76 = gz1.c.g(r232);
    L144:
        r76 = null;
        goto L146
    L136:
        if (r45.A == null) goto L144;
        r111.element = CardType.Buff;
        e3 r233 = (e3) vh7.f.c(e3.class);
        o0 r234 = r45.A;
        if (r234 == null) goto L142;
        l1 r235 = r234.a;
        if (r235 == null) goto L142;
        long r236 = r235.getBuffGiftId();
    L143:
        r233.setPluginId(r236);
        r76 = CollectionsKt.listOf(r233);
    L142:
        r236 = 0;
        goto L143
    L104:
        if (r73 != r5.b) goto L124;
        p0 r237 = r45.B;
        if (r237 == null) goto L111;
        com.bytedance.android.livesdk.gift.model.n r238 = r237.a;
        if (r238 == null) goto L123;
        r74 = r238.getCardName();
    L123:
        r74 = null;
        goto L125
    L111:
        o0 r239 = r45.A;
        if (r239 == null) goto L121;
        l1 r240 = r239.a;
        if (r240 == null) goto L116;
        long r241 = r240.getBuffGiftId();
    L117:
        h2 r242 = GiftManagerKt.l(r241);
        if (r242 == null) goto L123;
        r74 = r242.getName();
        goto L125
    L116:
        r241 = 0;
        goto L117
    L121:
        if (r2.a(r69.t.a) == false) goto L123;
        r74 = r69.t.a;
        goto L125
    L86:
        if (r70 != r5.b) goto L100;
        p0 r243 = r45.B;
        if (r243 == null) goto L94;
        GiftBuffCardHelper.Companion r244 = GiftBuffCardHelper.a;
        Intrinsics.checkNotNull(r243);
        com.bytedance.android.livesdk.gift.model.n r245 = r243.a;
        com.bytedance.android.livesdk.gift.model.n r246 = r45.x1.I(Long.valueOf(r69.b));
        r244.getClass();
        if (GiftBuffCardHelper.Companion.a(r245, r246) == false) goto L94;
        r71 = GiftPanelIconSource.DIY_CARD;
    L94:
        if (r45.A == null) goto L99;
        l1.a r247 = l1.Companion;
        int r248 = r45.J1(r60);
        o0 r249 = r45.A;
        Intrinsics.checkNotNull(r249);
        l1 r250 = r249.a;
        r247.getClass();
        if (l1.a.g(r248, r250) == 0) goto L99;
        r71 = GiftPanelIconSource.BUFF_CARD;
    L99:
        r71 = GiftPanelIconSource.GIFT_LIST;
        goto L101
    L81:
        if (r110 == r5.b) goto L83;
    L184:
        r411 = r68;
        r410 = r5;
        r413 = r46;
        r313 = r19;
        r121 = "livesdk_distinct_mystery_gift_show";
        r412 = r11;
        r120 = r15;
        r312 = null;
        r119 = r26;
        goto L185
    L186:
        r411 = r68;
        r4 = r4;
        r410 = r5;
        r413 = r46;
        r313 = r19;
        r121 = "livesdk_distinct_mystery_gift_show";
        r412 = r11;
        r120 = r15;
        r312 = null;
        r119 = r26;
        goto L187
    L71:
        r56 = false;
        goto L72
    L424:
        r216 = r68;
        r314 = r4;
        r217 = r5;
        r413 = r46;
        r95 = r26;
        r313 = r19;
        r510 = r11;
        r122 = r15;
        r96 = true;
        r312 = null;
        goto L426
    L447:
        final ArrayList r251 = r26;
        int r512 = r11;
        int r252 = r13;
        l0 r253 = r14;
        if ((!r251.isEmpty()) == false) goto L451;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(true, new GiftMVIVerticalListViewModel$onChangedCurrentShowIconRange$2(r251));
    L451:
        if (v.e() == false) goto L518;
        if (r20 == false) goto L454;
        return;
    L454:
        if (((Number) com.bytedance.android.anya.h.b(r59.getCurrentPagePosition())).intValue() != r252) goto L520;
        r r254 = r58.i(r59);
        if ((r254 instanceof GiftListBusinessState.GiftSelected) == false) goto L463;
        vz1.e r255 = ((GiftListBusinessState.GiftSelected) r254).getIconModel();
        if (r255 == null) goto L463;
        h1 r256 = r255.a;
        if (r256 == null) goto L463;
        long r257 = r256.getId();
    L464:
        if (r63 == null) goto L497;
        IntIterator r258 = r63.iterator();
        boolean r259 = false;
    L467:
        if (r258.hasNext() == false) goto L496;
        int r260 = r258.nextInt();
        k0 r261 = r253.b;
        t0<GiftVerticalState, PagerListData> r1100 = r59.getPanelList();
        r261.getClass();
        if (com.bytedance.android.anya.h.a(r1100) <= r252) goto L494;
        t0<PagerListData, ItemListData> r262 = ((PagerListData) k0.d(r59.getPanelList(), r252)).getItemDataList();
        if (com.bytedance.android.anya.h.a(r262) <= r260) goto L473;
        boolean r1101 = true;
    L474:
        if (r1101 == true) goto L478;
        r262 = null;
    L478:
        if (r262 == null) goto L484;
        if (r260 > (-1)) goto L481;
    L483:
        Unit r263 = Unit.INSTANCE;
        goto L484
    L481:
        if (((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r262, r260)).getItemData())).a.getId() != r257) goto L483;
        int r1102 = r512;
    L492:
        r512 = r1102;
        r259 = true;
    L484:
        r1102 = r512;
        if (com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r252)).getCounterDataList()) <= r1102) goto L493;
        if (r1102 == (-1)) goto L493;
        CounterData r264 = (CounterData) k0.d(((PagerListData) k0.d(r59.getPanelList(), r252)).getCounterDataList(), r1102);
        if (com.bytedance.android.anya.h.a(r264.getItemDataList()) <= r260) goto L493;
        if (r260 == (-1)) goto L493;
        if (((vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r264.getItemDataList(), r260)).getItemData())).a.getId() == r257) goto L492;
    L493:
        com.bytedance.android.anya.h.a(((PagerListData) k0.d(r59.getPanelList(), r252)).getTopicPagerListData());
    L495:
        Unit r265 = Unit.INSTANCE;
        r512 = r1102;
        goto L467
    L473:
        r1101 = false;
        goto L474
    L494:
        r1102 = r512;
        goto L495
    L496:
        Unit r266 = Unit.INSTANCE;
        boolean r267 = r259;
    L498:
        r45.F2.q(r267);
        return;
    L497:
        r267 = false;
    L463:
        r257 = -1;
        goto L464
    L520:
        return;
    L518:
        return;
    L20:
        r2 = SelectedStatus.IDLE;
        goto L21
    L17:
        r5 = null;
        goto L18
    L13:
        r20 = r66;
        goto L14
    L9:
        r8 = r65;
        goto L11
    L5:
        r11 = r64;
        goto L7
    }

    public static /* synthetic */ void J3(GiftMVIVerticalListViewModel r11, l0 r13, GiftVerticalState r14, int r15, int r16, SelectedStatus r17, int r18, String r19, int r110, int r20) {
        if ((r20 & 8) == 0) goto L5;
        SelectedStatus r6 = SelectedStatus.CLICK;
    L7:
        if ((r20 & 16) == 0) goto L9;
        int r7 = -1;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r8 = BuildConfig.FLAVOR;
    L15:
        if ((r20 & 64) == 0) goto L17;
        int r9 = -1;
    L18:
        r11.H3(r13, r14, r15, r16, r6, r7, r8, r9, false);
        return;
    L17:
        r9 = r110;
        goto L18
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }

    public final void E3(l0<GiftVerticalState> r33, GiftVerticalState r34, final int r35, final int r36, boolean r37, SelectedStatus r38, int r39, int r40, final int r41, final int r43) {
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        t0<GiftVerticalState, PagerListData> r4 = r34.getPanelList();
        r33.getClass();
        if (com.bytedance.android.anya.h.a(r4) <= r35) goto L74;
        u r5 = r34.getPanelList();
        MVIState r6 = (MVIState) ((s0) r5.c()).get(r35);
        new k0.a();     // Catch: Throwable -> L69
        PagerListData r7 = (PagerListData) r6;     // Catch: Throwable -> L69
        if (r39 != (-1)) goto L8;
        if (r40 == (-1)) goto L55;
        if (((s0) r7.getTopicPagerListData().c()).size() <= r40) goto L67;
        u r1 = r7.getTopicPagerListData();     // Catch: Throwable -> L69
        u r8 = r1;     // Catch: Throwable -> L69
        MVIState r9 = (MVIState) ((s0) r1.c()).get(r40);     // Catch: Throwable -> L69
        new k0.a();     // Catch: Throwable -> L49
        TopicPagerListData r11 = (TopicPagerListData) r9;     // Catch: Throwable -> L49
        if (((s0) r11.getItemDataList().c()).size() <= r36) goto L47;
        u r13 = r11.getItemDataList();     // Catch: Throwable -> L49
        u r14 = r13;     // Catch: Throwable -> L49
        MVIState r15 = (MVIState) ((s0) r13.c()).get(r36);     // Catch: Throwable -> L49
        new k0.a();     // Catch: Throwable -> L41
        r10.element = (vz1.e) ((ItemListData) r15).getItemData().c();     // Catch: Throwable -> L41
    L39:
        if ((!r15.modifiedProperties.isEmpty()) == false) goto L47;
        ((t) r13.c()).d(r36);     // Catch: Throwable -> L49
    L41:
        th = move-exception;
        if ((!r15.modifiedProperties.isEmpty()) == false) goto L45;
        ((t) r13.c()).d(r36);     // Catch: Throwable -> L49
    L45:
        throw th;     // Catch: Throwable -> L49
    L47:
        if ((!r9.modifiedProperties.isEmpty()) == false) goto L67;
        ((t) r1.c()).d(r40);     // Catch: Throwable -> L69
    L49:
        th = move-exception;
        if ((!r9.modifiedProperties.isEmpty()) == false) goto L53;
        ((t) r1.c()).d(r40);     // Catch: Throwable -> L69
    L53:
        throw th;     // Catch: Throwable -> L69
    L67:
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L74;
        ((t) r5.c()).d(r35);
        goto L74
    L55:
        if (((s0) r7.getItemDataList().c()).size() <= r36) goto L67;
        u r2 = r7.getItemDataList();     // Catch: Throwable -> L69
        u r3 = r2;     // Catch: Throwable -> L69
        MVIState r16 = (MVIState) ((s0) r2.c()).get(r36);     // Catch: Throwable -> L69
        new k0.a();     // Catch: Throwable -> L61
        r10.element = (vz1.e) ((ItemListData) r16).getItemData().c();     // Catch: Throwable -> L61
    L59:
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L67;
        ((t) r2.c()).d(r36);     // Catch: Throwable -> L69
    L61:
        th = move-exception;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L65;
        ((t) r2.c()).d(r36);     // Catch: Throwable -> L69
    L65:
        throw th;     // Catch: Throwable -> L69
    L8:
        if (((s0) r7.getCounterDataList().c()).size() <= r39) goto L67;
        u r17 = r7.getCounterDataList();     // Catch: Throwable -> L69
        u r18 = r17;     // Catch: Throwable -> L69
        MVIState r19 = (MVIState) ((s0) r17.c()).get(r39);     // Catch: Throwable -> L69
        new k0.a();     // Catch: Throwable -> L25
        CounterData r20 = (CounterData) r19;     // Catch: Throwable -> L25
        if (((s0) r20.getItemDataList().c()).size() <= r36) goto L23;
        u r21 = r20.getItemDataList();     // Catch: Throwable -> L25
        u r110 = r21;     // Catch: Throwable -> L25
        MVIState r111 = (MVIState) ((s0) r21.c()).get(r36);     // Catch: Throwable -> L25
        new k0.a();     // Catch: Throwable -> L17
        r10.element = (vz1.e) ((ItemListData) r111).getItemData().c();     // Catch: Throwable -> L17
    L15:
        if ((!r111.modifiedProperties.isEmpty()) == false) goto L23;
        ((t) r21.c()).d(r36);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        if ((!r111.modifiedProperties.isEmpty()) == false) goto L21;
        ((t) r21.c()).d(r36);     // Catch: Throwable -> L25
    L21:
        throw th;     // Catch: Throwable -> L25
    L23:
        if ((!r19.modifiedProperties.isEmpty()) == false) goto L67;
        ((t) r17.c()).d(r39);     // Catch: Throwable -> L69
    L25:
        th = move-exception;
        if ((!r19.modifiedProperties.isEmpty()) == false) goto L29;
        ((t) r17.c()).d(r39);     // Catch: Throwable -> L69
    L29:
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L73;
        ((t) r5.c()).d(r35);
    L73:
        throw th;
    L74:
        vz1.e r23 = (vz1.e) r10.element;
        if (r23 == null) goto L81;
        h1 r24 = r23.a;
        if (r24 == null) goto L81;
        if (r24.getType() != 3) goto L81;
        return;
    L81:
        vz1.e r25 = (vz1.e) r10.element;
        if (r25 == null) goto L88;
        h1 r26 = r25.a;
        if (r26 == null) goto L88;
        if (r26.getBizType() != 2) goto L88;
        return;
    L88:
        final Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 0;
        l0.a r27 = l0.e(r34.getPanelList(), r35);
        l0 r28 = r27.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r29 = ((PagerListData) r27.a).getTabType();
        r28.getClass();
        r112.element = ((Number) com.bytedance.android.anya.h.b(r29)).intValue();
        Unit r30 = Unit.INSTANCE;
        vz1.e r31 = (vz1.e) r10.element;
        if (r31 == null) goto L95;
        h1 r44 = r31.a;
        if (r44 == null) goto L95;
        py.k r45 = r44.getDynamicImgForSelected();
        if (r45 == null) goto L95;
        boolean r113 = r45.isValid();
    L96:
        vz1.e r46 = (vz1.e) r10.element;
        if (r46 == null) goto L101;
        h1 r47 = r46.a;
        if (r47 == null) goto L101;
        long r48 = r47.getId();
    L102:
        long r49 = r48;
        SelectedStatus r50 = SelectedStatus.SERIES_CARD;
        if (r38 == r50) goto L105;
    L113:
        String r210 = null;
    L114:
        l0.a r51 = l0.e(r34.getPanelList(), r35);
        l0 r114 = r51.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r53 = ((PagerListData) r51.a).getSelectedTopicId();
        r114.getClass();
        final String r211 = this.y2.c(r112.element, ((Number) com.bytedance.android.anya.h.b(r53)).longValue());
        if (r37 == true) goto L126;
        u1 r115 = this.b1;
        vz1.e r116 = (vz1.e) r10.element;
        IBaseUser r54 = this.H2.a;
        int r55 = r112.element;
        int r212 = B1(r35);
        if (r38 != r50) goto L119;
        boolean r213 = true;
    L120:
        g0 r0 = this.x1.q(r49);
        if (r0 == null) goto L123;
        IGiftExposureAnimInfo r214 = r0.getGiftExposureAnimInfo();
    L124:
        GiftTopViewState.Mode r56 = this.T;
        int r57 = u1.B;
        r115.o0(r116, r36, r54, r113, r55, r35, r212, r210, r213, r214, r41, r43, r211, r56, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        return;
    L123:
        r214 = null;
        goto L124
    L119:
        r213 = false;
        goto L120
    L126:
        if (this.H == true) goto L156;
        this.H = true;
        GiftContext r58 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r58 == null) goto L143;
        com.bytedance.live.datacontext.m<Long> r59 = r58.getDefaultGiftLocatedAt();
        if (r59 == null) goto L143;
        if (((Number) r59.getValue()).longValue() != 0) goto L143;
        r59.setValue(Long.valueOf(System.currentTimeMillis()));
        GiftPanelMonitorService r60 = this.g1;
        vz1.e r61 = (vz1.e) r10.element;
        if (r61 == null) goto L139;
        h1 r63 = r61.a;
        if (r63 == null) goto L139;
        String r64 = r63.getName();
        if (r64 == null) goto L139;
    L140:
        String r117 = r64;
        int r118 = r112.element;
        int r119 = com.bytedance.android.anya.h.a(r34.getPanelList());
        r60.getClass();
        Intrinsics.checkNotNullParameter(r117, "giftName");
        long r120 = r49;
        GiftPanelMonitorService.b r65 = new GiftPanelMonitorService.b(r49, r36, r41, r35, r118);
        r60.H = r65;
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r66 = GiftPreloadManager.a;
        GiftPreloadManager.b(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h.e(r65));
        r60.E.put("default_gift_position", String.valueOf(r36));
        r60.E.put("default_gift_row", String.valueOf(r41));
        r60.E.put("default_gift_name", r117);
        r60.E.put("default_tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r118));
        r60.E.put("default_tab_position", String.valueOf(r35));
        r60.E.put("tab_count", String.valueOf(r119));
        jy0.b.a("ttlive_gift_panel_metrics", "onDefaultGiftSelected " + r60.E);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r67 = r60.D;
        if (r67 == null) goto L144;
        r67.e = true;
        r67.f = 0;
        r67.g = 0;
        r67.h = 0;
        r67.i = 0;
        r67.j = 0;
        r67.k = 0;
    L144:
        GiftPanelBizBoostUtils.E.getClass();
        final boolean r68 = r113;
        final long r69 = r120;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(GiftPanelBizBoostUtils.b().B0(), new GiftMVIVerticalListViewModel$sendGiftPreviewLog$4(this, r10, r112, r36, r68, r35, r69, r41, r43, r211));
        return;
    L139:
        r64 = BuildConfig.FLAVOR;
    L143:
        r120 = r49;
        goto L144
    L156:
        return;
    L105:
        if (r49 <= 0) goto L113;
        g0 r70 = this.x1.q(r49);
        if (r70 == null) goto L111;
        l3 r71 = r70.getSeriesGift();
        if (r71 == null) goto L111;
        String r73 = r71.getName();
    L112:
        r210 = r73;
    L111:
        r73 = null;
    L101:
        r48 = -1;
    L95:
        r113 = false;
        goto L96
    }

    public final void H2(l0 r39, GiftVerticalState r40, int r41, int r43, int r44, int r45, int r46, vz1.e r47, boolean r48, int r49, com.bytedance.android.livesdk.gift.platform.core.model.n r410) {
        if (nz1.a.h().c() == false) goto L10;
        GiftBuffCardHelper.Companion r0 = GiftBuffCardHelper.a;
        l1 r2 = this.b2.q();
        if (r47 == null) goto L7;
        h1 r3 = r47.a;
    L8:
        r0.getClass();
        this.A = GiftBuffCardHelper.Companion.h(r2, r3);
        goto L10
    L7:
        r3 = null;
    L10:
        if (nz1.a.h().d() == false) goto L16;
        GiftBuffCardHelper.Companion r1 = GiftBuffCardHelper.a;
        com.bytedance.android.livesdk.gift.model.n r4 = this.b2.k();
        if (r47 == null) goto L14;
        h1 r5 = r47.a;
    L15:
        r1.getClass();
        this.B = GiftBuffCardHelper.Companion.i(r4, r5);
        goto L16
    L14:
        r5 = null;
    L16:
        int r6 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        o0 r7 = this.A;
        if (r7 == null) goto L19;
        l1 r8 = r7.a;
    L21:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.a(r8) == false) goto L23;
        return;
    L23:
        p0 r9 = this.B;
        if (r9 == null) goto L26;
        com.bytedance.android.livesdk.gift.model.n r10 = r9.a;
    L28:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.b(r10) == false) goto L30;
        return;
    L30:
        k0 r11 = r39.b;
        t0<GiftVerticalState, PagerListData> r13 = r40.getPanelList();
        r11.getClass();
        if (((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r13, r41)).getTabType())).intValue() != 16) goto L42;
        if (r47 == null) goto L42;
        vz1.a r14 = r47.u;
        if (r14 == null) goto L42;
        l1 r15 = r14.f;
        com.bytedance.android.livesdk.gift.model.n r16 = r14.g;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.a(r15) == false) goto L40;
    L41:
        boolean r17 = true;
    L43:
        if (r17 == false) goto L46;
        return;
    L46:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.l(r47, this.b1, this.H2, this.v1, this.x1) == false) goto L48;
        return;
    L48:
        if (r47 == null) goto L52;
        if (r47.e != true) goto L52;
    L55:
        if (r47 != null) goto L57;
    L64:
        GiftSendPreCheckService r18 = this.k1;
        IBaseUser r19 = this.H2.a;
        if (r47 == null) goto L67;
        h1 r20 = r47.a;
    L68:
        h1 r110 = r20;
        PropListService r21 = this.P0;
        if (r47 == null) goto L71;
        Long r23 = Long.valueOf(r47.b);
    L72:
        l2 r111 = r21.f(r23);
        ReceiverType r24 = this.H2.b;
        o0 r25 = this.A;
        if (r25 == null) goto L75;
        l1 r26 = r25.a;
    L76:
        p0 r27 = this.B;
        if (r27 == null) goto L79;
        com.bytedance.android.livesdk.gift.model.n r28 = r27.a;
    L80:
        int r29 = GiftSendPreCheckService.f(r18, r19, r110, r111, r24, null, null, r26, r28, 48);
        if (r29 == 0) goto L89;
        if (r47 == null) goto L86;
        h1 r30 = r47.a;
        if (r30 == null) goto L86;
        long r31 = r30.getId();
    L87:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Q(r29, r31, -1);
        com.bytedance.android.livesdk.gift.platform.core.utils.g.m(r47, r29, BuildConfig.FLAVOR, this.H2, this.v1);
        return;
    L86:
        r31 = 0;
        goto L87
    L89:
        l0.a r33 = l0.e(r40.getPanelList(), ((Number) com.bytedance.android.anya.h.b(r40.getCurrentPagePosition())).intValue());
        l0 r34 = r33.b;
        com.bytedance.android.anya.r0<PagerListData, Integer> r35 = ((PagerListData) r33.a).getTabType();
        r34.getClass();
        int r36 = ((Number) com.bytedance.android.anya.h.b(r35)).intValue();
        l0.a r37 = l0.e(r40.getPanelList(), ((Number) com.bytedance.android.anya.h.b(r40.getCurrentPagePosition())).intValue());
        l0 r38 = r37.b;
        com.bytedance.android.anya.r0<PagerListData, Long> r50 = ((PagerListData) r37.a).getSelectedTopicId();
        r38.getClass();
        long r51 = ((Number) com.bytedance.android.anya.h.b(r50)).longValue();
        String r112 = this.y2.c(r36, r51);
        if (r47 != null) goto L92;
    L98:
        if (r47 == null) goto L100;
        h1 r53 = r47.a;
    L101:
        AbsPanel r54 = com.bytedance.android.livesdk.gift.platform.core.utils.g.k(r53, this.B);
    L97:
        AbsPanel r310 = r54;
        o0 r55 = this.A;
        if (r55 == null) goto L107;
        l1 r56 = r55.a;
        if (r56 == null) goto L107;
        int r311 = r56.getBuffLevel();
    L108:
        IBaseUser r57 = this.H2.a;
        boolean r312 = this.p1.j();
        List<IBaseUser> r313 = this.p1.i();
        int r210 = (r43 % 4) + 1;
        int r211 = (z1(r39, r40, r49, r41) + (r43 / 4)) + 1;
        q0 r58 = this.y2;
        Integer r59 = (Integer) ((LinkedHashMap) this.L0.c).get(com.bytedance.android.anya.h.b(r40.getCurrentPagePosition()));
        if (r59 == null) goto L111;
        int r60 = r59.intValue();
    L112:
        String r212 = r58.c(r60, r51);
        if (r47 == null) goto L132;
        if (r48 == false) goto L122;
        g0 r61 = this.x1.q(r47.b);
        if (r61 == null) goto L120;
        l3 r63 = r61.getSeriesGift();
        if (r63 == null) goto L120;
        String r64 = r63.getName();
    L121:
        String r213 = r64;
    L123:
        u1 r65 = this.b1;
        Integer r66 = (Integer) ((LinkedHashMap) this.L0.c).get(com.bytedance.android.anya.h.b(r40.getCurrentPagePosition()));
        if (r66 == null) goto L126;
        int r113 = r66.intValue();
    L127:
        int r114 = ((Number) com.bytedance.android.anya.h.b(r40.getCurrentPagePosition())).intValue();
        int r214 = B1(((Number) com.bytedance.android.anya.h.b(r40.getCurrentPagePosition())).intValue());
        p0 r67 = this.B;
        if (r67 == null) goto L130;
        com.bytedance.android.livesdk.gift.model.n r215 = r67.a;
    L131:
        IBaseUser r68 = this.H2.a;
        Map r216 = com.bytedance.android.livesdk.gift.platform.core.utils.g.g(r47.b, this.x1);
        int r217 = com.bytedance.android.anya.h.a(r40.getPanelList());
        GiftTopViewState.Mode r69 = this.T;
        int r70 = u1.B;
        r65.w0(r47, r113, r114, r214, r215, r68, r48, r213, r216, r211, r210, r217, r212, r69, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        goto L132
    L130:
        r215 = null;
        goto L131
    L126:
        r113 = 0;
    L120:
        r64 = null;
        goto L121
    L122:
        r213 = null;
    L132:
        u1 r71 = this.b1;
        r410.c = r71.h;
        r71.h = 0;
        int r73 = com.bytedance.android.livesdk.gift.platform.core.utils.g.f(r47, this.p2);
        p0 r74 = this.B;
        if (r74 == null) goto L135;
        com.bytedance.android.livesdk.gift.model.n r75 = r74.a;
    L136:
        o0 r76 = this.A;
        if (r76 == null) goto L139;
        l1 r77 = r76.a;
    L140:
        if (r47 == null) goto L142;
        h1 r78 = r47.a;
    L143:
        if (r78 == null) goto L145;
        long r79 = r78.getDiamondCount();
    L146:
        if (r77 == null) goto L148;
        long r115 = r77.getBuffDiamondCount();
    L150:
        r79 = r79 + r115;
    L151:
        long r116 = r79;
        o0 r80 = this.A;
        if (r80 == null) goto L154;
        l1 r81 = r80.a;
    L155:
        if (r47 == null) goto L157;
        h1 r83 = r47.a;
    L158:
        String r218 = com.bytedance.android.livesdk.gift.platform.core.utils.g.e(r81, r83, this.x1);
        p0 r84 = this.B;
        if (r84 == null) goto L161;
        com.bytedance.android.livesdk.gift.model.n r85 = r84.a;
    L162:
        o0 r86 = this.A;
        if (r86 == null) goto L165;
        l1 r87 = r86.a;
    L166:
        if (r47 == null) goto L170;
        h1 r88 = r47.a;
        if (r88 == null) goto L170;
        long r89 = r88.getId();
    L171:
        String r219 = com.bytedance.android.livesdk.gift.platform.core.utils.g.j(r85, r87, r89);
        GiftConfirmService r90 = this.y1;
        if (r47 == null) goto L174;
        h1 r117 = r47.a;
    L175:
        Observable<GiftConfirmService.ConfirmResult> r91 = r90.a(r117, this.b1, r116, r218, r219);
        Function1<GiftConfirmService.ConfirmResult, ObservableSource<com.bytedance.android.livesdk.gift.platform.business.f>> r93 = new GiftMVIVerticalListViewModel$onComboing$1(this);
        Lazy r94 = RxCompatKt.a;
        Intrinsics.checkNotNullParameter(r91, "$this$concatMapCompat");
        Intrinsics.checkNotNullParameter(r93, "mapper");
        RxUtilKt.c(r91.concatMap(new com.bytedance.android.live.core.utils.rxutils.n(r93), 2).map(new h(this, r73, r47, r311, r36, r112, r310, r57, r312, r313, r48, r410)).all(i.a).doAfterSuccess(new j(r47)).subscribe(new k(this, r39, r46, r40, r41, r43, r47, r44, r45, r410), RxUtil.getNoOpThrowable()), this.M);
        return;
    L174:
        r117 = null;
    L170:
        r89 = 0;
        goto L171
    L165:
        r87 = null;
        goto L166
    L161:
        r85 = null;
        goto L162
    L157:
        r83 = null;
        goto L158
    L154:
        r81 = null;
        goto L155
    L148:
        if (r75 == null) goto L151;
        r115 = r75.getTotalDiamonds();
        goto L150
    L145:
        r79 = 0;
        goto L146
    L142:
        r78 = null;
        goto L143
    L139:
        r77 = null;
        goto L140
    L135:
        r75 = null;
        goto L136
    L111:
        r60 = 0;
    L107:
        r311 = 0;
        goto L108
    L100:
        r53 = null;
        goto L101
    L92:
        if (r47.e != true) goto L98;
        l2 r95 = this.P0.f(Long.valueOf(r47.b));
        if (r95 != null) goto L96;
        r54 = new pz1.d();
        goto L97
    L96:
        r54 = ((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).d(r95);
        goto L97
    L79:
        r28 = null;
        goto L80
    L75:
        r26 = null;
        goto L76
    L71:
        r23 = null;
        goto L72
    L67:
        r20 = null;
        goto L68
    L57:
        if (r47.e != true) goto L64;
        vz1.h r96 = r47.g;
        if (r96.f == 4) goto L64;
        if (r96.b >= 1) goto L64;
        K0(new ShowProbCountErrorTipsEffect());
        com.bytedance.android.livesdk.gift.platform.core.utils.g.m(r47, 506, "prop count is not enough", this.H2, this.v1);
        return;
    L52:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(this.H2.a.getIdString(), null) == false) goto L55;
        com.bytedance.android.livesdk.gift.platform.core.utils.g.m(r47, 410, "ban send gift to self", this.H2, this.v1);
        K0(new BanSendGiftSelfTipsEffect());
        return;
    L40:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.b(r16) == true) goto L41;
    L42:
        r17 = false;
        goto L43
    L26:
        r10 = null;
        goto L28
    L19:
        r8 = null;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v17, types: [com.bytedance.android.anya.MVIState] */
    /* JADX WARN: Type inference failed for: r11v18, types: [com.bytedance.android.anya.MVIState] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22, types: [com.bytedance.android.anya.MVIState] */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r39v0, types: [int] */
    /* JADX WARN: Type inference failed for: r39v1 */
    /* JADX WARN: Type inference failed for: r39v11 */
    /* JADX WARN: Type inference failed for: r39v12 */
    /* JADX WARN: Type inference failed for: r39v13 */
    /* JADX WARN: Type inference failed for: r39v14 */
    /* JADX WARN: Type inference failed for: r39v15 */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r39v3 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.android.anya.MVIState] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.bytedance.android.anya.MVIState] */
    public static void s1(GiftMVIVerticalListViewModel r28, l0 r29, GiftVerticalState r30, vz1.i r31, int r33, boolean r34, String r35, int r36, Boolean r37, l1 r38, com.bytedance.android.livesdk.gift.model.n r39, int r310) {
        com.bytedance.android.livesdk.gift.model.n r4 = null;
        if ((r310 & 128) == 0) goto L5;
        l1 r3 = null;
    L7:
        if ((r310 & 256) != 0) goto L10;
        r4 = r39;
    L10:
        r28.getClass();
        r r2 = r29.i(r30);
        if ((r2 instanceof GiftListBusinessState.GiftSelected) == false) goto L197;
        GiftListBusinessState.GiftSelected r5 = (GiftListBusinessState.GiftSelected) r2;
        int r6 = r5.getSelectedPagePosition();
        int r7 = r5.getSelectedPosition();
        int r8 = r5.getSelectCounterPosition();
        int r9 = r5.getTopicPagerPosition();
        if (com.bytedance.android.anya.h.a(r30.getPanelList()) <= r6) goto L213;
        com.bytedance.android.livesdk.gift.model.n r10 = (u) r30.getPanelList();
        MVIState r11 = (MVIState) ((s0) r10.c()).get(r6);
        new k0.a();     // Catch: Throwable -> L191
        PagerListData r13 = (PagerListData) r11;     // Catch: Throwable -> L191
        if (r8 != (-1)) goto L19;
        if (r9 != (-1)) goto L82;
        r39 = r10;
        r310 = r11;
        ?? r311 = r310;
        if (((s0) r13.getItemDataList().c()).size() <= r7) goto L185;
        u r14 = r13.getItemDataList();     // Catch: Throwable -> L189
        u r15 = r14;     // Catch: Throwable -> L189
        MVIState r16 = (MVIState) ((s0) r14.c()).get(r7);     // Catch: Throwable -> L189
        new k0.a();     // Catch: Throwable -> L180
        ItemListData r17 = (ItemListData) r16;     // Catch: Throwable -> L180
        if (r34 == false) goto L149;
        int r18 = CardStatus.INSTANCE.getLOCK();     // Catch: Throwable -> L180
    L150:
        int r19 = r18;
        if (r4 == null) goto L156;
        String r110 = r4.getSendButtonText();     // Catch: Throwable -> L180
        if (r110 == null) goto L156;
        String r111 = r110;
    L157:
        if (r37 == null) goto L159;
        boolean r20 = r37.booleanValue();     // Catch: Throwable -> L180
    L160:
        int r112 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L180
        vz1.a r21 = new vz1.a(r19, r35, r36, r111, r20, null, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.h(((vz1.e) r17.getItemData().c()).b, r3, r4, r28.x1), 96);     // Catch: Throwable -> L180
        if (r31 != null) goto L163;
    L176:
        py.k r0 = ((vz1.e) r17.getItemData().c()).a.getImage();     // Catch: Throwable -> L180
        r17.getItemData().a(vz1.e.a((vz1.e) r17.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), new vz1.i(null, r0, null, null, 13)), 0, 0, 0, r21, 66060283));     // Catch: Throwable -> L180
    L177:
        r311 = r310;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L185;
        ((t) r14.c()).d(r7);     // Catch: Throwable -> L189
        r311 = r310;
        goto L185
    L163:
        if (r31.getType() != ImageType.ImageModel) goto L165;
    L166:
        py.k r1 = r31.b;     // Catch: Throwable -> L180
        if (r1 == null) goto L176;
        if (r1.isValid() != true) goto L176;
    L171:
        if (r31.getType() == ImageType.BitMap) goto L173;
    L175:
        r17.getItemData().a(vz1.e.a((vz1.e) r17.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), r31), 0, 0, 0, r21, 66060283));     // Catch: Throwable -> L180
        goto L177
    L173:
        if (r31.d != null) goto L175;
    L165:
        if (r31.getType() != ImageType.DynamicImage) goto L171;
    L159:
        r20 = false;
    L156:
        r111 = BuildConfig.FLAVOR;
        goto L157
    L149:
        r18 = CardStatus.INSTANCE.getUNLOCK();     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        if ((!r16.modifiedProperties.isEmpty()) == false) goto L184;
        ((t) r14.c()).d(r7);     // Catch: Throwable -> L189
    L184:
        throw th;     // Catch: Throwable -> L189
    L185:
        ?? r23 = r311;
    L187:
        if ((!((MVIState) r23).modifiedProperties.isEmpty()) == false) goto L214;
        ((t) r39.c()).d(r6);
        return;
    L214:
        return;
    L82:
        if (((s0) r13.getTopicPagerListData().c()).size() > r9) goto L83;
    L79:
        r39 = r10;
        r23 = r11;
        goto L187
    L83:
        u r24 = r13.getTopicPagerListData();     // Catch: Throwable -> L191
        u r113 = r24;     // Catch: Throwable -> L191
        MVIState r114 = (MVIState) ((s0) r24.c()).get(r9);     // Catch: Throwable -> L191
        new k0.a();     // Catch: Throwable -> L137
        TopicPagerListData r115 = (TopicPagerListData) r114;     // Catch: Throwable -> L137
        if (((s0) r115.getItemDataList().c()).size() > r7) goto L212;
        r39 = r10;
        MVIState r312 = r11;
    L134:
        r311 = r312;
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L185;
        ((t) r24.c()).d(r9);     // Catch: Throwable -> L189
        r311 = r312;
        goto L185
    L212:
        u r116 = r115.getItemDataList();     // Catch: Throwable -> L137
        u r117 = r116;     // Catch: Throwable -> L137
        MVIState r118 = (MVIState) ((s0) r116.c()).get(r7);     // Catch: Throwable -> L137
        new k0.a();     // Catch: Throwable -> L125
        ItemListData r119 = (ItemListData) r118;     // Catch: Throwable -> L125
        if (r34 == false) goto L90;
        int r120 = CardStatus.INSTANCE.getLOCK();     // Catch: Throwable -> L125
    L91:
        int r121 = r120;
        if (r4 == null) goto L97;
        String r122 = r4.getSendButtonText();     // Catch: Throwable -> L125
        if (r122 == null) goto L97;
        String r25 = r122;
    L98:
        if (r37 == null) goto L100;
        boolean r26 = r37.booleanValue();     // Catch: Throwable -> L125
    L101:
        int r123 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L125
        r39 = r10;
        MVIState r313 = r11;
        vz1.a r27 = new vz1.a(r121, r35, r36, r25, r26, null, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.h(((vz1.e) r119.getItemData().c()).b, r3, r4, r28.x1), 96);     // Catch: Throwable -> L118
        if (r31 != null) goto L106;
    L121:
        py.k r40 = ((vz1.e) r119.getItemData().c()).a.getImage();     // Catch: Throwable -> L118
        r119.getItemData().a(vz1.e.a((vz1.e) r119.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), new vz1.i(null, r40, null, null, 13)), 0, 0, 0, r27, 66060283));     // Catch: Throwable -> L118
    L122:
        r312 = r313;
        if ((!r118.modifiedProperties.isEmpty()) == false) goto L134;
        ((t) r116.c()).d(r7);     // Catch: Throwable -> L131
        r312 = r313;
        goto L134
    L106:
        if (r31.getType() != ImageType.ImageModel) goto L108;
    L109:
        py.k r41 = r31.b;     // Catch: Throwable -> L118
        if (r41 == null) goto L121;
        if (r41.isValid() != true) goto L121;
    L114:
        if (r31.getType() == ImageType.BitMap) goto L116;
    L120:
        r119.getItemData().a(vz1.e.a((vz1.e) r119.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), r31), 0, 0, 0, r27, 66060283));     // Catch: Throwable -> L118
        goto L122
    L116:
        if (r31.d != null) goto L120;
    L108:
        if (r31.getType() != ImageType.DynamicImage) goto L114;
    L118:
        th = th;
    L128:
        if ((!r118.modifiedProperties.isEmpty()) == false) goto L130;
        ((t) r116.c()).d(r7);     // Catch: Throwable -> L131
    L130:
        throw th;     // Catch: Throwable -> L131
    L100:
        r26 = false;
    L97:
        r25 = BuildConfig.FLAVOR;
        goto L98
    L90:
        r120 = CardStatus.INSTANCE.getUNLOCK();     // Catch: Throwable -> L125
    L125:
        th = th;
    L131:
        th = th;
    L140:
        if ((!r114.modifiedProperties.isEmpty()) == false) goto L142;
        ((t) r24.c()).d(r9);     // Catch: Throwable -> L189
    L142:
        throw th;     // Catch: Throwable -> L189
    L137:
        th = th;
    L189:
        th = th;
        ?? r43 = r310;
    L194:
        if ((!((MVIState) r43).modifiedProperties.isEmpty()) == false) goto L196;
        ((t) r39.c()).d(r6);
    L196:
        throw th;
    L19:
        if (((s0) r13.getCounterDataList().c()).size() <= r8) goto L79;
        u r44 = r13.getCounterDataList();     // Catch: Throwable -> L191
        u r124 = r44;     // Catch: Throwable -> L191
        ?? r125 = (MVIState) ((s0) r44.c()).get(r8);     // Catch: Throwable -> L191
        new k0.a();     // Catch: Throwable -> L74
        CounterData r126 = (CounterData) r125;     // Catch: Throwable -> L74
        ?? r127 = r125;
        if (((s0) r126.getItemDataList().c()).size() <= r7) goto L72;
        u r128 = r126.getItemDataList();     // Catch: Throwable -> L74
        u r129 = r128;     // Catch: Throwable -> L74
        MVIState r130 = (MVIState) ((s0) r128.c()).get(r7);     // Catch: Throwable -> L74
        new k0.a();     // Catch: Throwable -> L63
        ItemListData r131 = (ItemListData) r130;     // Catch: Throwable -> L63
        if (r34 == false) goto L27;
        int r132 = CardStatus.INSTANCE.getLOCK();     // Catch: Throwable -> L63
    L28:
        int r133 = r132;
        if (r4 == null) goto L34;
        String r134 = r4.getSendButtonText();     // Catch: Throwable -> L63
        if (r134 == null) goto L34;
        String r210 = r134;
    L35:
        if (r37 == null) goto L37;
        boolean r211 = r37.booleanValue();     // Catch: Throwable -> L63
    L38:
        int r135 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L63
        vz1.a r212 = new vz1.a(r133, r35, r36, r210, r211, null, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.h(((vz1.e) r131.getItemData().c()).b, r3, r4, r28.x1), 96);     // Catch: Throwable -> L55
        if (r31 != null) goto L43;
    L58:
        py.k r45 = ((vz1.e) r131.getItemData().c()).a.getImage();     // Catch: Throwable -> L55
        r131.getItemData().a(vz1.e.a((vz1.e) r131.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), new vz1.i(null, r45, null, null, 13)), 0, 0, 0, r212, 66060283));     // Catch: Throwable -> L55
    L60:
        if ((!r130.modifiedProperties.isEmpty()) == false) goto L62;
        ((t) r128.c()).d(r7);     // Catch: Throwable -> L69
    L62:
        r127 = r125;
        goto L72
    L43:
        if (r31.getType() != ImageType.ImageModel) goto L45;
    L46:
        py.k r46 = r31.b;     // Catch: Throwable -> L55
        if (r46 == null) goto L58;
        if (r46.isValid() != true) goto L58;
    L51:
        if (r31.getType() == ImageType.BitMap) goto L53;
    L57:
        r131.getItemData().a(vz1.e.a((vz1.e) r131.getItemData().c(), TuplesKt.to(Integer.valueOf(r33), r31), 0, 0, 0, r212, 66060283));     // Catch: Throwable -> L55
        goto L60
    L53:
        if (r31.d != null) goto L57;
    L45:
        if (r31.getType() != ImageType.DynamicImage) goto L51;
    L55:
        th = th;
    L66:
        if ((!r130.modifiedProperties.isEmpty()) == false) goto L68;
        ((t) r128.c()).d(r7);     // Catch: Throwable -> L69
    L68:
        throw th;     // Catch: Throwable -> L69
    L37:
        r211 = false;
    L34:
        r210 = BuildConfig.FLAVOR;
        goto L35
    L27:
        r132 = CardStatus.INSTANCE.getUNLOCK();     // Catch: Throwable -> L63
    L63:
        th = th;
    L69:
        th = th;
        r125 = r39;
    L76:
        if ((!((MVIState) r125).modifiedProperties.isEmpty()) == false) goto L78;
        ((t) r44.c()).d(r8);     // Catch: Throwable -> L191
    L78:
        throw th;     // Catch: Throwable -> L191
    L72:
        if ((!((MVIState) r127).modifiedProperties.isEmpty()) == false) goto L79;
        ((t) r44.c()).d(r8);     // Catch: Throwable -> L191
    L74:
        th = th;
    L191:
        th = th;
        r39 = r10;
        r43 = r11;
        goto L194
    L213:
        return;
    L197:
        return;
    L5:
        r3 = r38;
        goto L7
    }

    public final vz1.e E1(k0<GiftVerticalState, ?> r31, GiftVerticalState r33, ItemListData r34, int r35, int r36, int r37, int r38, int r39, List<Long> r310, String r40, boolean r41, ReceiverType r43, int r44) {
        h1 r8 = ((vz1.e) com.bytedance.android.anya.h.b(r34.getItemData())).a;
        g0 r26 = this.x1.q(r8.getId());
        if (r26 == null) goto L7;
        com.bytedance.android.livesdk.gift.model.p r0 = r26.getDiyGiftToolbarInfo();
        if (r0 == null) goto L7;
        List<com.bytedance.android.livesdk.gift.model.n> r1 = r0.getForceIndexCards();
    L8:
        if (r26 == null) goto L10;
        List<l1> r2 = r26.getGiftBuffInfos();
    L11:
        List<com.bytedance.android.livesdk.gift.model.n> r3 = r1;
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L20;
        com.bytedance.android.livesdk.gift.model.n r28 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r1, 0);
    L21:
        if (r2 == null) goto L35;
        Iterator<T> r5 = r2.iterator();
        boolean r6 = false;
    L24:
        if (r5.hasNext() == false) goto L34;
        l1 r7 = (l1) r5.next();
        com.bytedance.android.livesdk.gift.model.i r9 = r7.getLockInfo();
        if (r9 == null) goto L31;
        if (r9.getLocked() != true) goto L31;
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.c(this.J, r35) == false) goto L24;
    L31:
        l1.Companion.getClass();
        if (l1.a.g(r35, r7) == 0) goto L24;
        r6 = true;
        goto L24
    L34:
        boolean r29 = r6;
    L37:
        if (this.N.contains(Long.valueOf(r8.getId())) == false) goto L39;
    L53:
        int r10 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        vz1.e r11 = com.bytedance.android.livesdk.gift.platform.core.utils.g.o(r8, (vz1.e) com.bytedance.android.anya.h.b(r34.getItemData()), r35, r40, r43, this.x1, this.T1, this.b2, this.J, this.w, this.H2, this.v, this.P1, this.L0, this.M1, this.E2, r39 + 1, r44);
        if (r28 != null) goto L70;
        if (r29 == true) goto L70;
        if (r26 == null) goto L60;
        com.bytedance.android.livesdk.gift.model.p r13 = r26.getDiyGiftToolbarInfo();
        if (r13 == null) goto L60;
        List<com.bytedance.android.livesdk.gift.model.n> r14 = r13.getCards();
    L61:
        List<com.bytedance.android.livesdk.gift.model.n> r15 = r14;
        if (r15 != null) goto L64;
    L67:
        boolean r16 = true;
    L68:
        if (r16 == false) goto L70;
    L78:
        boolean r17 = false;
    L81:
        if (((ItemStatus) com.bytedance.android.anya.h.b(r34.getItemStatus())) != ItemStatus.SELECTED) goto L89;
        GiftDialogStateDataStore r18 = this.S1;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r310, "refreshGiftId");
        h1 r19 = (h1) r18.j.getValue();
        if (r19 == null) goto L85;
        long r20 = r19.getId();
    L87:
        if (r310.contains(Long.valueOf(r20)) == false) goto L89;
        r18.u.n(r20, r41);
        goto L89
    L85:
        r20 = 0;
    L89:
        if (r17 == false) goto L91;
        return r11;
    L91:
        return null;
    L64:
        if (r15.isEmpty() == true) goto L67;
        r16 = false;
    L60:
        r14 = null;
    L70:
        if ((!Intrinsics.areEqual(((vz1.e) com.bytedance.android.anya.h.b(r34.getItemData())).o, r11.o)) == true) goto L74;
        if ((!Intrinsics.areEqual(((vz1.e) com.bytedance.android.anya.h.b(r34.getItemData())).p, r11.p)) == false) goto L78;
    L74:
        if ((!Intrinsics.areEqual(((vz1.e) com.bytedance.android.anya.h.b(r34.getItemData())).o, r11.o)) == false) goto L76;
    L79:
        r17 = true;
        goto L81
    L76:
        if ((!Intrinsics.areEqual(((vz1.e) com.bytedance.android.anya.h.b(r34.getItemData())).p, r11.p)) == false) goto L78;
    L39:
        if (((ItemStatus) com.bytedance.android.anya.h.b(r34.getItemStatus())) == ItemStatus.SELECTED) goto L53;
        long r21 = r8.getId();
        if (r26 == null) goto L43;
        IGiftExposureAnimInfo r23 = r26.getGiftExposureAnimInfo();
    L45:
        if (t1(r21, r23, ((Number) com.bytedance.android.anya.h.b(r33.getCurrentPagePosition())).intValue(), r36, r39) == false) goto L53;
        if (r26 == null) goto L51;
        IGiftExposureAnimInfo r24 = r26.getGiftExposureAnimInfo();
        if (r24 == null) goto L51;
        py.k r25 = r24.getAssetUrl();
    L52:
        K0(new ShowGiftExposureAnim(r36, r39, r25, r37, r38));
    L51:
        r25 = null;
        goto L52
    L43:
        r23 = null;
        goto L45
    L35:
        r29 = false;
        goto L37
    L20:
        r28 = null;
        goto L21
    L14:
        if (r3.isEmpty() == true) goto L17;
        r4 = false;
        goto L18
    L10:
        r2 = null;
    L7:
        r1 = null;
        goto L8
    }

    public GiftMVIVerticalListViewModel(LocateGiftInfo r17, h0 r18, yz0.k r19, DataCenter r20, u0 r21, e1 r23, PropListService r24, o2 r25, u1 r26, GiftPanelMonitorService r27, OpenDialogService r28, GiftSendPreCheckService r29, GiftReceiverRepoService r210, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r30, r3 r31, GiftExtraRepo r33, GiftConfirmService r34, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r35, d0 r36, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r37, GiftListPanelRepository r38, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r39, GiftPanelViewPreloadService r310, GiftDialogStateDataStore r40, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r41, GiftListFilterService r43, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r44, GiftMVICarnivalDataStore r45, GiftListPagingService r46, GiftGroupCardDataStore r47, GiftDataStorageService r48, GiftTopicDataStore r49, q0 r410, GiftListSortDataStore r50, GiftScrollDataStore r51, GiftPanelAssetDownloadDataStore r53, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r54, xz1.c r55, GiftSearchDataStore r56, GiftMostlyUsedDataStore r57, y r58, GiftTabDataStore r59, n3 r510) {
        Intrinsics.checkNotNullParameter(r17, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r18, "panelSendGiftRepo");
        Intrinsics.checkNotNullParameter(r19, "roomDataService");
        Intrinsics.checkNotNullParameter(r20, "dataCenter");
        Intrinsics.checkNotNullParameter(r21, "internalScopeService");
        Intrinsics.checkNotNullParameter(r23, "giftListService");
        Intrinsics.checkNotNullParameter(r24, "propListService");
        Intrinsics.checkNotNullParameter(r25, "giftTimerService");
        Intrinsics.checkNotNullParameter(r26, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r27, "giftPanelMonitorService");
        Intrinsics.checkNotNullParameter(r28, "openDialogService");
        Intrinsics.checkNotNullParameter(r29, "sendPreCheckService");
        Intrinsics.checkNotNullParameter(r210, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r30, "allMicService");
        Intrinsics.checkNotNullParameter(r31, "giftSendService");
        Intrinsics.checkNotNullParameter(r33, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r34, "giftConfirmService");
        Intrinsics.checkNotNullParameter(r35, "buffRepository");
        Intrinsics.checkNotNullParameter(r36, "giftPanelListTempRepo");
        Intrinsics.checkNotNullParameter(r37, "giftPreloaderService");
        Intrinsics.checkNotNullParameter(r38, "listPanelRepository");
        Intrinsics.checkNotNullParameter(r39, "giftListRepository");
        Intrinsics.checkNotNullParameter(r310, "panelPreloadService");
        Intrinsics.checkNotNullParameter(r40, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r41, "giftDIYDataStore");
        Intrinsics.checkNotNullParameter(r43, "giftListFilterService");
        Intrinsics.checkNotNullParameter(r44, "cardDataStore");
        Intrinsics.checkNotNullParameter(r45, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r46, "giftListPagingService");
        Intrinsics.checkNotNullParameter(r47, "giftGroupCardDataStore");
        Intrinsics.checkNotNullParameter(r48, "dataStorageService");
        Intrinsics.checkNotNullParameter(r49, "giftTopicDataStore");
        Intrinsics.checkNotNullParameter(r410, "giftTopicRepo");
        Intrinsics.checkNotNullParameter(r50, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r51, "giftScrollDataStore");
        Intrinsics.checkNotNullParameter(r53, "giftPanelAssetDownloadDataStore");
        Intrinsics.checkNotNullParameter(r54, "receiverService");
        Intrinsics.checkNotNullParameter(r55, "giftExtraInterfaceMonitor");
        Intrinsics.checkNotNullParameter(r56, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r57, "giftMostlyUsedDataStore");
        Intrinsics.checkNotNullParameter(r58, "giftSelectReceiverService");
        Intrinsics.checkNotNullParameter(r59, "giftTabDataStore");
        Intrinsics.checkNotNullParameter(r510, "propTipService");
        this.Y = r17;
        this.Z = r18;
        this.k0 = r19;
        this.p0 = r20;
        this.H0 = r21;
        this.L0 = r23;
        this.P0 = r24;
        this.V0 = r25;
        this.b1 = r26;
        this.g1 = r27;
        this.h1 = r28;
        this.k1 = r29;
        this.p1 = r30;
        this.v1 = r31;
        this.x1 = r33;
        this.y1 = r34;
        this.G1 = r35;
        this.H1 = r36;
        this.L1 = r37;
        this.M1 = r38;
        this.P1 = r39;
        this.Q1 = r310;
        this.S1 = r40;
        this.T1 = r41;
        this.V1 = r43;
        this.b2 = r44;
        this.g2 = r45;
        this.h2 = r46;
        this.p2 = r47;
        this.v2 = r48;
        this.x2 = r49;
        this.y2 = r410;
        this.E2 = r50;
        this.F2 = r51;
        this.G2 = r53;
        this.H2 = r54;
        this.I2 = r55;
        this.J2 = r56;
        this.K2 = r57;
        this.L2 = r58;
        this.M2 = r59;
        this.N2 = r510;
        this.u = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        this.v = r19.getRoom();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L12;
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isVS();
        if (r4 == null) goto L11;
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L12;
    L11:
        boolean r5 = false;
    L13:
        this.w = r5;
        this.y = new n();
        this.z = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h(r17, Integer.valueOf(r59.w()), new GiftMVIVerticalListViewModel$defaultSelectHelper$1(this));
        new ArrayList();
        this.C = new ArrayList();
        this.D = new LinkedHashMap();
        this.E = new i0(r26, r23, new GiftMVIVerticalListViewModel$giftShowStrategyHelper$1(this));
        this.F = new LinkedHashMap();
        this.G = new LinkedHashMap();
        this.I = -1;
        this.J = nz1.b.a();
        this.K = 2;
        this.L = 4;
        this.M = new CompositeDisposable();
        this.N = new LinkedHashSet();
        this.Q = new LinkedHashMap();
        this.R = new LinkedHashMap();
        this.S = RefreshGiftListSource.OPEN_DIALOG;
        this.T = GiftTopViewState.Mode.Default;
        this.U = LazyKt.lazy(GiftMVIVerticalListViewModel$emptyDesc$2.INSTANCE);
        this.W = (i1) com.bytedance.android.livesdk.gift.platform.business.b.b0.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[52]);
        this.X = SetsKt.setOf(new BaseMVIDataStore[]{r44, r40, r33, r47, r49, r51, r56, r59});
        return;
    L12:
        r5 = true;
        goto L13
    }
}
