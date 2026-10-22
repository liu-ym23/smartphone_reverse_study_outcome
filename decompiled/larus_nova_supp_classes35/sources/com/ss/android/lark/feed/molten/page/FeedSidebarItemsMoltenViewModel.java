package com.ss.android.lark.feed.molten.page;

import android.os.SystemClock;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.lark_biz_feed_android.FeedCardType;
import com.bytedance.lark.lark_biz_feed_android.FeedFilterType;
import com.bytedance.lark.lark_biz_feed_android.ViewFlowError;
import com.bytedance.lark.lark_biz_feed_android.b0;
import com.bytedance.lark.lark_biz_feed_android.d0;
import com.bytedance.lark.lark_biz_feed_android.e0;
import com.bytedance.lark.lark_biz_feed_android.j;
import com.bytedance.lark.lark_biz_feed_android.p;
import com.bytedance.lark.lark_biz_feed_android.q;
import com.bytedance.lark.lark_biz_feed_android.t;
import com.bytedance.lark.lark_biz_feed_android.v;
import com.bytedance.lark.lark_biz_feed_android.w;
import com.bytedance.lark.lark_biz_feed_android.w0;
import com.bytedance.lark.lark_biz_feed_android.y;
import com.bytedance.lark.lark_biz_feed_android_wrapper.ILarkFeedListViewFlow;
import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.bytedance.lark.molten_livequery_wrapper.g;
import com.bytedance.lark.molten_livequery_wrapper.h;
import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import com.bytedance.lark.pb.feed.v1.FeedFilter;
import com.bytedance.lark.pb.feed.v1.LarkFeedListItem;
import com.bytedance.lark.pb.feed.v1.LarkFeedListKeyChange;
import com.bytedance.lark.view_flow_wrapper.l;
import com.larksuite.arch.jack.d;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.utils.f;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.passportc.api.m;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0010*\u0001-\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0002lmB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001a\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J&\u0010\"\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00160#\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001c\u0010%\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001c\u0010&\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001c\u0010'\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u001c\u0010(\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u0014\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e*\u00020\u0011H\u0016J\u001c\u0010*\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000f0\u000e*\u00020\u0011H\u0016J\u0012\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e*\u00020\u0011H\u0016J\u0012\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0013H\u0016J\b\u00106\u001a\u00020\u0010H\u0016J\u000e\u0010;\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u0004\u0018\u00010>*\u00020?H\u0002J\u001c\u0010@\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0BH\u0002J\b\u0010E\u001a\u00020\u0010H\u0002J\b\u0010F\u001a\u00020\u0010H\u0002J\u0012\u0010G\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020\u0018H\u0016J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010I\u001a\u00020 2\u0006\u0010L\u001a\u00020\u0018H\u0016J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u00020\u00102\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010N\u001a\u00020 H\u0016J \u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0018H\u0016J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010I\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00102\u0006\u0010I\u001a\u00020 2\u0006\u0010W\u001a\u00020\u001aH\u0016J\b\u0010X\u001a\u00020\u0010H\u0016J\b\u0010Y\u001a\u00020\u0010H\u0016J\u0010\u0010Z\u001a\u00020\u00102\u0006\u0010[\u001a\u00020>H\u0016J(\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020^2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u00152\u0006\u0010`\u001a\u00020\u0018H\u0016J\"\u0010a\u001a\u00020\u00102\u0006\u0010]\u001a\u00020^2\b\u0010b\u001a\u0004\u0018\u00010>2\u0006\u0010c\u001a\u00020\u0018H\u0016J\"\u0010d\u001a\u00020\u00102\u0006\u0010]\u001a\u00020^2\b\u0010b\u001a\u0004\u0018\u00010>2\u0006\u0010c\u001a\u00020\u0018H\u0016J\u0018\u0010e\u001a\u00020\u00102\u0006\u0010]\u001a\u00020^2\u0006\u0010f\u001a\u00020\u0018H\u0002J\u0012\u0010g\u001a\u00020\u00102\b\u0010h\u001a\u0004\u0018\u00010>H\u0016J\u000e\u0010i\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u0016J\u0006\u0010j\u001a\u00020\u0010J\b\u0010k\u001a\u00020\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/ss/android/lark/feed/molten/page/FeedSidebarItemsMoltenViewModel;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/LarkFeedListViewModel;", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "passport", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "localCache", "Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;", "<init>", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;)V", "currentFeedItems", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "getCurrentFeedItems", "()Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "recoverRecentItemPositionEvent", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larksuite/arch/jack/Event;", BuildConfig.FLAVOR, "Lcom/larksuite/arch/jack/ISubscriber;", "currentFeedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "storeIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasReceivedAuthoritativeLiveList", BuildConfig.FLAVOR, "lastItemsShowedTime", BuildConfig.FLAVOR, "feedSidebarItemEntities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "packerFactory", "Lcom/ss/android/lark/feed/molten/page/PartialPackerFactory;", "notifyItemChangedEvent", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;", "showMarkedLaterDialogEvent", "handlePendingDeleteFeedEvent", "Lkotlin/Pair;", "Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "showToastEvent", "createFeedGroupActivityEvent", "startAddFeedGroupActivityEvent", "clearBadgeConfirmEvent", "feedItemEntities", "refreshItems", "canLoadMoreState", "feedClickDataChangedListener", "com/ss/android/lark/feed/molten/page/FeedSidebarItemsMoltenViewModel$feedClickDataChangedListener$2$1", "getFeedClickDataChangedListener", "()Lcom/ss/android/lark/feed/molten/page/FeedSidebarItemsMoltenViewModel$feedClickDataChangedListener$2$1;", "feedClickDataChangedListener$delegate", "Lkotlin/Lazy;", "isDataForceEmpty", "folder", "start", "feedFilter", "foregroundFilterChanged", "listWrapper", "Lcom/bytedance/lark/molten_livequery_wrapper/ListWrapperLifecycle;", "hasSubscribedToLivequery", "Ljava/util/concurrent/atomic/AtomicBoolean;", "subscribeToLivequery", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertToUIFeedCard", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lcom/bytedance/lark/pb/feed/v1/FeedEntityPreview;", "handleLiveListUpdate", "liveList", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Lcom/ss/android/lark/feed/molten/page/FeedSidebarItemsMoltenViewModel$FeedCardEntry;", "Lcom/bytedance/lark/pb/feed/v1/LarkFeedListKeyChange;", "subscribeToToastEvents", "subscribeToCanLoadMoreEvents", "updateFeedListData", "updateFeedCardFlag", "feedPreview", "isFlag", "setFeedCardShortCut", "isShortCut", "onNoDisturbSwitchChange", Keys.API_RETURN_KEY_DATA, "onAutoMuteSwitchChange", "clearUnreadBadge", "remoteMarkUnread", "feedId", "feedType", "targetUnreadStatus", "tryAddFeedTag", "removeFeedTag", "groupId", "resumeData", "pauseDataChange", "onMoveCardToDoneFeed", "feedCard", "onItemsShowed", "position", BuildConfig.FLAVOR, "uiFeedCards", "onlyChat", "onItemChanged", "uiFeedCard", "isListScrollingScene", "onItemChangedIgnoreCanLoadMore", "requestDataLoadingCheck", "skipWhenCanNotLoadMore", "showNextUnreadFeedItem", "nextUnreadFeedCard", "setFlowClickHint", "clearFlowClickHint", "onCleared", "Companion", "FeedCardEntry", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedSidebarItemsMoltenViewModel extends LarkFeedListViewModel implements s {
    public static final a Companion = null;
    private static final long ON_ITEMS_SHOWED_DEBOUNCE_IN_MILLS = 5000;
    private static final String TAG = "FeedSidebarItemsMoltenViewModel";
    private final z0<Boolean> canLoadMoreState;
    private FeedFolder currentFeedFilter;
    private final Lazy feedClickDataChangedListener$delegate;
    private final z0<UpdateRecord> feedSidebarItemEntities;
    private boolean hasReceivedAuthoritativeLiveList;
    private final AtomicBoolean hasSubscribedToLivequery;
    private long lastItemsShowedTime;
    private g listWrapper;
    private final com.ss.android.lark.feed.molten.cache.b localCache;
    private final z0<d<FeedPreview>> notifyItemChangedEvent;
    private final c packerFactory;
    private final m passport;
    private final z0<d<String>> refreshItems;
    private List<String> storeIds;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final UIFeedCard a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            UIFeedCard r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "FeedCardEntry(card=" + this.a + ')';
        }

        public b(UIFeedCard r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$clearUnreadBadge$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$clearUnreadBadge$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04531(FeedSidebarItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04531> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04531(this.this$0, this.$data, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
            Object r9 = ((com.bytedance.lark.view_flow_wrapper.d) r8).a;
        L14:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r9 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L17;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead success");
        L17:
            Throwable r4 = null;
            if (r3 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L21:
            if (r5 == null) goto L23;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L24:
            if (r6 == null) goto L26;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead failure :" + ((ViewFlowError) r6).getMessage());
        L26:
            if (r3 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L29:
            if (r7 == null) goto L31;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L31:
            if (r4 == null) goto L34;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead exception :" + r4.getMessage());
        L34:
            return Unit.INSTANCE;
        L28:
            r7 = null;
            goto L29
        L23:
            r6 = null;
            goto L24
        L20:
            r5 = null;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            FeedSidebarItemsMoltenViewModel r10 = this.this$0;
            String r11 = this.$data.getId();
            if (r11 != null) goto L11;
            r11 = BuildConfig.FLAVOR;
        L11:
            FeedCardType.a r12 = FeedCardType.Companion;
            int r13 = this.$data.getType().getNumber();
            r12.getClass();
            p r14 = new p(new j(r11, FeedCardType.a.a(r13)));
            this.label = 1;
            r9 = r10.action-vFDjHp0(r14, this);
            if (r9 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onAutoMuteSwitchChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onAutoMuteSwitchChange$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04541(FeedSidebarItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04541> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04541(this.this$0, this.$data, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((com.bytedance.lark.view_flow_wrapper.d) r7).a;
        L15:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r8 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L18;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange success");
        L18:
            Throwable r4 = null;
            if (r3 == false) goto L21;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L22:
            if (r5 == null) goto L24;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).b();
        L25:
            if (r6 == null) goto L27;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange failure :" + ((ViewFlowError) r6).getMessage());
        L27:
            if (r3 == false) goto L29;
            com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L30:
            if (r9 == null) goto L32;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).a();
        L32:
            if (r4 == null) goto L35;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange exception :" + r4.getMessage());
        L35:
            return Unit.INSTANCE;
        L29:
            r9 = null;
            goto L30
        L24:
            r6 = null;
            goto L25
        L21:
            r5 = null;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            FeedSidebarItemsMoltenViewModel r10 = this.this$0;
            Long r11 = StringsKt.toLongOrNull(this.$data.getId());
            if (r11 == null) goto L11;
            long r12 = r11.longValue();
        L12:
            e0 r13 = new e0(r12);
            this.label = 1;
            r8 = r10.action-vFDjHp0(r13, this);
            if (r8 != r0) goto L15;
            return r0;
        L11:
            r12 = 0;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onItemsShowed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onItemsShowed$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {0}, l = {427, 444}, m = "invokeSuspend", n = {"dependencyList"}, s = {"L$0"})
    public static final class C04551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $onlyChat;
        final /* synthetic */ int $position;
        final /* synthetic */ List<UIFeedCard> $uiFeedCards;
        Object L$0;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C04551(List<? extends UIFeedCard> r1, FeedSidebarItemsMoltenViewModel r2, int r3, boolean r4, Continuation<? super C04551> r5) {
            this.$uiFeedCards = r1;
            this.this$0 = r2;
            this.$position = r3;
            this.$onlyChat = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04551(this.$uiFeedCards, this.this$0, this.$position, this.$onlyChat, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Throwable r5 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
            Object r13 = ((com.bytedance.lark.view_flow_wrapper.d) r12).a;
        L45:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r13 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L48;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency success");
        L48:
            if (r3 == false) goto L50;
            com.bytedance.lark.view_flow_wrapper.d.b r4 = (com.bytedance.lark.view_flow_wrapper.d.b) r13;
        L51:
            if (r4 == null) goto L53;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r13).b();
        L54:
            if (r6 == null) goto L56;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency failure :" + ((ViewFlowError) r6).getMessage());
        L56:
            if (r3 == false) goto L58;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r13;
        L59:
            if (r7 == null) goto L61;
            r5 = ((com.bytedance.lark.view_flow_wrapper.d.b) r13).a();
        L61:
            if (r5 == null) goto L64;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency exception :" + r5.getMessage());
        L64:
            return Unit.INSTANCE;
        L58:
            r7 = null;
            goto L59
        L53:
            r6 = null;
            goto L54
        L50:
            r4 = null;
            goto L51
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            List r8 = (List) this.L$0;
            ResultKt.throwOnFailure(r12);
            Object r14 = ((com.bytedance.lark.view_flow_wrapper.d) r12).a;
        L23:
            int r9 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r10 = r14 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r10) == false) goto L26;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData success");
        L26:
            if (r10 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r11 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L29:
            if (r11 == null) goto L31;
            Object r15 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).b();
        L32:
            if (r15 == null) goto L34;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData failure :" + ((ViewFlowError) r15).getMessage());
        L34:
            if (r10 == false) goto L36;
            com.bytedance.lark.view_flow_wrapper.d.b r16 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L37:
            if (r16 == null) goto L39;
            Throwable r17 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).a();
        L40:
            if (r17 == null) goto L42;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData exception :" + r17.getMessage());
        L42:
            FeedSidebarItemsMoltenViewModel r18 = this.this$0;
            w r19 = new w(r8, this.$position);
            this.L$0 = null;
            this.label = 2;
            r13 = r18.action-vFDjHp0(r19, this);
            if (r13 != r0) goto L45;
            return r0;
        L39:
            r17 = null;
            goto L40
        L36:
            r16 = null;
            goto L37
        L31:
            r15 = null;
            goto L32
        L28:
            r11 = null;
            goto L29
        L10:
            ResultKt.throwOnFailure(r12);
            ArrayList r110 = new ArrayList();
            r8 = new ArrayList();
            List<UIFeedCard> r20 = this.$uiFeedCards;
            boolean r21 = this.$onlyChat;
            Iterator<T> r22 = r20.iterator();
        L12:
            if (r22.hasNext() == false) goto L20;
            UIFeedCard r23 = (UIFeedCard) r22.next();
            if (r21 == true) goto L16;
            Boxing.boxBoolean(r110.add(r23.getId()));
        L19:
            r8.add(r23.getId());
            goto L12
        L16:
            if (r23.getType() != FeedCard.Type.CHAT) goto L19;
            r110.add(r23.getId());
            goto L19
        L20:
            FeedSidebarItemsMoltenViewModel r24 = this.this$0;
            v r25 = new v(r110);
            this.L$0 = r8;
            this.label = 1;
            r14 = r24.action-vFDjHp0(r25, this);
            if (r14 != r0) goto L23;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onNoDisturbSwitchChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$onNoDisturbSwitchChange$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04561(FeedSidebarItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04561> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04561(this.this$0, this.$data, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
            Object r9 = ((com.bytedance.lark.view_flow_wrapper.d) r8).a;
        L14:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r9 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L17;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange success");
        L17:
            Throwable r4 = null;
            if (r3 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L21:
            if (r5 == null) goto L23;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L24:
            if (r6 == null) goto L26;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange failure :" + ((ViewFlowError) r6).getMessage());
        L26:
            if (r3 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L29:
            if (r7 == null) goto L31;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L31:
            if (r4 == null) goto L34;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange exception :" + r4.getMessage());
        L34:
            return Unit.INSTANCE;
        L28:
            r7 = null;
            goto L29
        L23:
            r6 = null;
            goto L24
        L20:
            r5 = null;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            FeedSidebarItemsMoltenViewModel r10 = this.this$0;
            String r11 = this.$data.getId();
            if (r11 != null) goto L11;
            r11 = BuildConfig.FLAVOR;
        L11:
            FeedCardType.a r12 = FeedCardType.Companion;
            int r13 = this.$data.getType().getNumber();
            r12.getClass();
            b0 r14 = new b0(new j(r11, FeedCardType.a.a(r13)), !this.$data.isRemind());
            this.label = 1;
            r9 = r10.action-vFDjHp0(r14, this);
            if (r9 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$remoteMarkUnread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$remoteMarkUnread$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $feedId;
        final /* synthetic */ FeedCard.Type $feedType;
        final /* synthetic */ boolean $targetUnreadStatus;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04571(FeedSidebarItemsMoltenViewModel r1, String r2, FeedCard.Type r3, boolean r4, Continuation<? super C04571> r5) {
            this.this$0 = r1;
            this.$feedId = r2;
            this.$feedType = r3;
            this.$targetUnreadStatus = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04571(this.this$0, this.$feedId, this.$feedType, this.$targetUnreadStatus, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
            Object r9 = ((com.bytedance.lark.view_flow_wrapper.d) r8).a;
        L11:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r9 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L14;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead success");
        L14:
            Throwable r4 = null;
            if (r3 == false) goto L17;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L18:
            if (r5 == null) goto L20;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L21:
            if (r6 == null) goto L23;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead failure :" + ((ViewFlowError) r6).getMessage());
        L23:
            if (r3 == false) goto L25;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L26:
            if (r7 == null) goto L28;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L28:
            if (r4 == null) goto L31;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead exception :" + r4.getMessage());
        L31:
            return Unit.INSTANCE;
        L25:
            r7 = null;
            goto L26
        L20:
            r6 = null;
            goto L21
        L17:
            r5 = null;
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            FeedSidebarItemsMoltenViewModel r10 = this.this$0;
            String r11 = this.$feedId;
            FeedCardType.a r12 = FeedCardType.Companion;
            int r13 = this.$feedType.getNumber();
            r12.getClass();
            t r14 = new t(new j(r11, FeedCardType.a.a(r13)), this.$targetUnreadStatus);
            this.label = 1;
            r9 = r10.action-vFDjHp0(r14, this);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$requestDataLoadingCheck$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$requestDataLoadingCheck$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $dataList;
        final /* synthetic */ FeedFolder $feedFilter;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04581(FeedSidebarItemsMoltenViewModel r1, FeedFolder r2, List<String> r3, Continuation<? super C04581> r4) {
            this.this$0 = r1;
            this.$feedFilter = r2;
            this.$dataList = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04581(this.this$0, this.$feedFilter, this.$dataList, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((com.bytedance.lark.view_flow_wrapper.d) r7).a;
        L11:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r8 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L14;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck success");
        L14:
            Throwable r4 = null;
            if (r3 == false) goto L17;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L18:
            if (r5 == null) goto L20;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).b();
        L21:
            if (r6 == null) goto L23;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck failure :" + ((ViewFlowError) r6).getMessage());
        L23:
            if (r3 == false) goto L25;
            com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L26:
            if (r9 == null) goto L28;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).a();
        L28:
            if (r4 == null) goto L31;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck exception :" + r4.getMessage());
        L31:
            return Unit.INSTANCE;
        L25:
            r9 = null;
            goto L26
        L20:
            r6 = null;
            goto L21
        L17:
            r5 = null;
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            FeedSidebarItemsMoltenViewModel r10 = this.this$0;
            FeedFilterType.a r11 = FeedFilterType.Companion;
            int r12 = this.$feedFilter.getSystemPresetType().getValue();
            r11.getClass();
            q r13 = new q(FeedFilterType.a.a(r12), this.$dataList.size(), true);
            this.label = 1;
            r8 = r10.action-vFDjHp0(r13, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$start$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {167, 172, 178}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedFolder $feedFilter;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04591(FeedSidebarItemsMoltenViewModel r1, FeedFolder r2, Continuation<? super C04591> r3) {
            this.this$0 = r1;
            this.$feedFilter = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04591(this.this$0, this.$feedFilter, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Throwable r6 = null;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
            Object r11 = ((com.bytedance.lark.view_flow_wrapper.d) r10).a;
        L40:
            int r2 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r3 = r11 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r3) == false) goto L43;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh success");
        L43:
            if (r3 == false) goto L45;
            com.bytedance.lark.view_flow_wrapper.d.b r4 = (com.bytedance.lark.view_flow_wrapper.d.b) r11;
        L46:
            if (r4 == null) goto L48;
            Object r5 = ((com.bytedance.lark.view_flow_wrapper.d.b) r11).b();
        L49:
            if (r5 == null) goto L51;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh failure :" + ((ViewFlowError) r5).getMessage());
        L51:
            if (r3 == false) goto L53;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r11;
        L54:
            if (r7 == null) goto L56;
            r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r11).a();
        L56:
            if (r6 == null) goto L58;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh exception :" + r6.getMessage());
        L58:
            this.this$0.resumeData();
            return Unit.INSTANCE;
        L53:
            r7 = null;
            goto L54
        L48:
            r5 = null;
            goto L49
        L45:
            r4 = null;
            goto L46
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
        L37:
            FeedSidebarItemsMoltenViewModel.access$subscribeToToastEvents(this.this$0);
            FeedSidebarItemsMoltenViewModel.access$subscribeToCanLoadMoreEvents(this.this$0);
            FeedSidebarItemsMoltenViewModel r12 = this.this$0;
            FeedFilterType.a r8 = FeedFilterType.Companion;
            int r9 = this.$feedFilter.getSystemPresetType().getValue();
            r8.getClass();
            y r13 = new y(FeedFilterType.a.a(r9));
            this.label = 3;
            r11 = r12.action-vFDjHp0(r13, this);
            if (r11 != r0) goto L40;
            return r0;
        L11:
            ResultKt.throwOnFailure(r10);
            Object r14 = ((com.bytedance.lark.view_flow_wrapper.d) r10).a;
        L15:
            int r15 = com.bytedance.lark.view_flow_wrapper.d.b;
            boolean r16 = r14 instanceof com.bytedance.lark.view_flow_wrapper.d.b;
            if ((!r16) == false) goto L18;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionSetup success");
        L18:
            if (r16 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r17 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L21:
            if (r17 == null) goto L23;
            Object r18 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).b();
        L24:
            if (r18 == null) goto L26;
            geb.c.d(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionSetup failure :" + ((ViewFlowError) r18).getMessage());
        L26:
            if (r16 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r19 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L29:
            if (r19 == null) goto L31;
            Throwable r110 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).a();
        L32:
            if (r110 == null) goto L34;
            geb.c.a(FeedSidebarItemsMoltenViewModel.TAG, "LarkFeedListActionSetup exception :" + r110.getMessage());
        L34:
            FeedSidebarItemsMoltenViewModel r111 = this.this$0;
            this.label = 2;
            if (FeedSidebarItemsMoltenViewModel.access$subscribeToLivequery(r111, this) != r0) goto L37;
            return r0;
        L31:
            r110 = null;
            goto L32
        L28:
            r19 = null;
            goto L29
        L23:
            r18 = null;
            goto L24
        L20:
            r17 = null;
            goto L21
        L12:
            ResultKt.throwOnFailure(r10);
            FeedSidebarItemsMoltenViewModel r112 = this.this$0;
            d0 r20 = d0.a;
            this.label = 1;
            r14 = r112.action-vFDjHp0(r20, this);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToCanLoadMoreEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "canLoadMore", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToCanLoadMoreEvents$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04601 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public C04601(FeedSidebarItemsMoltenViewModel r1, Continuation<? super C04601> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04601 r0 = new C04601(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(Boolean r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Boolean) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r4);
            Boolean r5 = (Boolean) this.L$0;
            if (r5 == null) goto L7;
            boolean r0 = r5.booleanValue();
        L8:
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "subscribeToCanLoadMoreEvents, canLoadMore=" + r5 + ", nextCanLoadMore=" + r0);
            z0 r6 = FeedSidebarItemsMoltenViewModel.access$getCanLoadMoreState$p(this.this$0);
        L9:
            Object r1 = r6.getValue();
            ((Boolean) r1).booleanValue();
            if (r6.compareAndSet(r1, Boxing.boxBoolean(r0)) == false) goto L9;
            return Unit.INSTANCE;
        L7:
            r0 = true;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToLivequery$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "liveList", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Lcom/ss/android/lark/feed/molten/page/FeedSidebarItemsMoltenViewModel$FeedCardEntry;", "Lcom/bytedance/lark/pb/feed/v1/LarkFeedListKeyChange;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToLivequery$4", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<h<b, LarkFeedListKeyChange>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FeedSidebarItemsMoltenViewModel this$0;

        public AnonymousClass4(FeedSidebarItemsMoltenViewModel r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(h<b, LarkFeedListKeyChange> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            h r4 = (h) this.L$0;
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "subscribeToLivequery success");
            FeedSidebarItemsMoltenViewModel.access$handleLiveListUpdate(this.this$0, r4);
            geb.c.c(FeedSidebarItemsMoltenViewModel.TAG, "FeedSidebarItemsMoltenViewModel subscribeToLivequery resume");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToToastEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/bytedance/lark/lark_biz_feed_android/ToastStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedSidebarItemsMoltenViewModel$subscribeToToastEvents$1", f = "FeedSidebarItemsMoltenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04611 extends SuspendLambda implements Function2<w0, Continuation<? super Unit>, Object> {
        int label;

        public C04611(Continuation<? super C04611> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C04611(r2);
        }

        public final Object invoke(w0 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((w0) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void foregroundFilterChanged() {
    }

    public void onMoveCardToDoneFeed(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCard");
    }

    public void removeFeedTag(FeedPreview r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
    }

    public void setFeedCardShortCut(FeedPreview r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void setFilterDoubaoConversation(boolean r1) {
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void showNextUnreadFeedItem(UIFeedCard r1) {
    }

    public void tryAddFeedTag(FeedPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "feedPreview");
    }

    private final FeedSidebarItemsMoltenViewModel$feedClickDataChangedListener$2.a getFeedClickDataChangedListener() {
        return (FeedSidebarItemsMoltenViewModel$feedClickDataChangedListener$2.a) this.feedClickDataChangedListener$delegate.getValue();
    }

    private final void subscribeToCanLoadMoreEvents() {
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(subscribe(ILarkFeedListViewFlow.c.a.c), new C04601(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void subscribeToToastEvents() {
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(subscribe(ILarkFeedListViewFlow.c.f.c), new C04611(null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public UpdateRecord getCurrentFeedItems() {
        return (UpdateRecord) this.feedSidebarItemEntities.getValue();
    }

    public void onCleared() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        jeb.b.a().od(getFeedClickDataChangedListener());
        super/*com.bytedance.lark.view_flow_wrapper.MoltenViewModel*/.onCleared();
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void pauseDataChange() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L6;
        geb.c.c(TAG, "FeedSidebarItemsMoltenViewModel pauseDataChange");
        r0.pause();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FeedSidebarItemsMoltenViewModel$pauseDataChange$1$1(this, null), 3, null);
        return;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void resumeData() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L6;
        geb.c.c(TAG, "FeedSidebarItemsMoltenViewModel resumeData");
        r0.resume();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FeedSidebarItemsMoltenViewModel$resumeData$1$1(this, null), 3, null);
        return;
    }

    public final void clearFlowClickHint() {
        jeb.b.a().Xa();
        z0<d<String>> r0 = this.refreshItems;
    L3:
        Object r1 = r0.getValue();
        d r2 = (d) r1;
        if (r0.compareAndSet(r1, new d(BuildConfig.FLAVOR)) == false) goto L3;
    }

    public static final /* synthetic */ z0 access$getCanLoadMoreState$p(FeedSidebarItemsMoltenViewModel r0) {
        return r0.canLoadMoreState;
    }

    public static final /* synthetic */ z0 access$getRefreshItems$p(FeedSidebarItemsMoltenViewModel r0) {
        return r0.refreshItems;
    }

    public static final /* synthetic */ void access$subscribeToCanLoadMoreEvents(FeedSidebarItemsMoltenViewModel r0) {
        r0.subscribeToCanLoadMoreEvents();
    }

    public static final /* synthetic */ void access$subscribeToToastEvents(FeedSidebarItemsMoltenViewModel r0) {
        r0.subscribeToToastEvents();
    }

    private final UIFeedCard convertToUIFeedCard(FeedEntityPreview r4) {
        UIFeedCard r0 = this.packerFactory.a(com.ss.android.lark.feed.shared.data.utils.h.a(r4));
        if (r0 == null) goto L5;
        f.b(r0);
    L6:
        geb.c.c(TAG, "convert pb=" + geb.a.a(r4) + ", uiCard=" + geb.a.b(r0));
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    private final void handleLiveListUpdate(h<b, LarkFeedListKeyChange> r10) {
        this.listWrapper = r10.c;
        LarkFeedListKeyChange r0 = (LarkFeedListKeyChange) r10.b;
        List r11 = r10.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r1.add(((b) r12.next()).a);
        goto L4
    L6:
        List<UIFeedCard> r13 = CollectionsKt.filterNotNull(r1);
        if (this.hasReceivedAuthoritativeLiveList == true) goto L12;
        if (r0 != null) goto L12;
        if (r13.isEmpty() == false) goto L12;
        boolean r3 = true;
    L13:
        StringBuilder r6 = new StringBuilder("handleLiveListUpdate raw=");
        r6.append(r1.size());
        r6.append(", nonNull=");
        r6.append(r13.size());
        r6.append(", keyChangeVersion:");
        if (r0 == null) goto L16;
        Long r7 = r0.version;
    L17:
        r6.append(r7);
        r6.append(", hasAuthoritativeLiveList=");
        r6.append(this.hasReceivedAuthoritativeLiveList);
        r6.append(", skipEmptyUpdate:");
        r6.append(r3);
        geb.c.c(TAG, r6.toString());
        if (r3 == false) goto L20;
        return;
    L20:
        this.hasReceivedAuthoritativeLiveList = true;
        List<UIFeedCard> r4 = r13;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r2 = r4.iterator();
    L22:
        if (r2.hasNext() == false) goto L24;
        r5.add(((UIFeedCard) r2.next()).getId());
        goto L22
    L24:
        this.storeIds = r5;
        this.localCache.e(r13, 20);
        z0<UpdateRecord> r8 = this.feedSidebarItemEntities;
    L25:
        Object r9 = r8.getValue();
        UpdateRecord r14 = (UpdateRecord) r9;
        UpdateRecord r15 = new UpdateRecord();
        FeedCard.FeedType r16 = FeedCard.FeedType.ALL;
        r15.c = r13.isEmpty();
        r15.a(r13);
        r15.e = this.passport.getUser().userId;
        if (r0 == null) goto L30;
        Boolean r17 = r0.force_update;
        if (r17 == null) goto L30;
        boolean r18 = r17.booleanValue();
    L33:
        r15.d = r18;
        r15.a(r13);
        if (r0 == null) goto L38;
        Long r19 = r0.version;
        if (r19 == null) goto L38;
        long r20 = r19.longValue();
    L41:
        r15.a = r20;
        if (r0 == null) goto L47;
        FeedFilter.Type r21 = r0.feed_filter;
        if (r21 == null) goto L47;
        FeedFolder r22 = FeedFolderCompat.INSTANCE.forNumber(r21.getValue());
        if (r22 == null) goto L47;
    L50:
        r15.g = r22;
        if (r0 == null) goto L56;
        FeedFilter.Type r23 = r0.last_feed_filter;
        if (r23 == null) goto L56;
        FeedFolder r24 = FeedFolderCompat.INSTANCE.forNumber(r23.getValue());
        if (r24 == null) goto L56;
    L59:
        r15.h = r24;
        if (r8.compareAndSet(r9, r15) == false) goto L25;
        return;
    L56:
        if (r14 == null) goto L58;
        r24 = r14.h;
        goto L59
    L58:
        r24 = null;
    L47:
        if (r14 == null) goto L49;
        r22 = r14.g;
        goto L50
    L49:
        r22 = null;
    L38:
        if (r14 == null) goto L40;
        r20 = r14.a;
        goto L41
    L40:
        r20 = 0;
    L30:
        if (r14 == null) goto L32;
        r18 = r14.d;
        goto L33
    L32:
        r18 = false;
        goto L33
    L16:
        r7 = null;
    L12:
        r3 = false;
        goto L13
    }

    private final Object subscribeToLivequery(Continuation<? super Unit> r6) {
        boolean r0 = false;
        if (this.hasSubscribedToLivequery.compareAndSet(false, true) == true) goto L6;
        geb.c.c(TAG, "subscribeToLivequery already invoked, skip");
        return Unit.INSTANCE;
    L6:
        ILarkFeedListViewFlow.c.b r7 = ILarkFeedListViewFlow.c.b.e;
        Function3<Integer, Function0<? extends LarkFeedListItem>, b, b> r2 = new AnonymousClass2(this);
        if (((ILarkFeedListViewFlow.c.c) r7).c != null) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L17;
        l r8 = (l) ((com.bytedance.lark.view_flow_wrapper.q) r7).a;
        KClass r1 = Reflection.getOrCreateKotlinClass(b.class);
        Object r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "actualKey");
        l r3 = new l(r9, r1);
        if (TypeIntrinsics.isFunctionOfArity(r2, 3) == true) goto L14;
        r2 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(CollectionsKt.emptyList(), "list");
        Intrinsics.checkNotNullParameter(r3, "key");
        AnonymousClass3 r10 = AnonymousClass3.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "loggerProvider");
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(subscribe(new ILarkFeedListViewFlow.c.c(r3, r2, r10)), new AnonymousClass4(this, null)), ViewModelKt.getViewModelScope(this));
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("make sure you call map only once, chained map operator not support yet".toString());
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<Boolean> canLoadMoreState(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.canLoadMoreState;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<FeedPreview>> clearBadgeConfirmEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    public void clearUnreadBadge(FeedPreview r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04531(this, r8, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> createFeedGroupActivityEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<UpdateRecord> feedItemEntities(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.feedSidebarItemEntities;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<Pair<FeedCard.Type, String>>> handlePendingDeleteFeedEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public boolean isDataForceEmpty(FeedFolder r2) {
        geb.c.d(TAG, "isDataForceEmpty not implemented on office-sdk yet");
        return false;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<FeedPreview>> notifyItemChangedEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.notifyItemChangedEvent;
    }

    public void onAutoMuteSwitchChange(FeedPreview r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04541(this, r8, null), 3, null);
    }

    public void onNoDisturbSwitchChange(FeedPreview r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04561(this, r8, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<Unit>> recoverRecentItemPositionEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> refreshItems(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.refreshItems;
    }

    public final void setFlowClickHint(String r4) {
        Intrinsics.checkNotNullParameter(r4, "feedId");
        jeb.b.a().k4(r4);
        z0<d<String>> r0 = this.refreshItems;
    L3:
        Object r1 = r0.getValue();
        d r2 = (d) r1;
        if (r0.compareAndSet(r1, new d(r4)) == false) goto L3;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<FeedFolder>> showMarkedLaterDialogEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> showToastEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void start(FeedFolder r9) {
        Intrinsics.checkNotNullParameter(r9, "feedFilter");
        this.currentFeedFilter = r9;
        geb.c.d(TAG, "FeedSidebarItemsMoltenViewModel start");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04591(this, r9, null), 3, null);
        jeb.b.a().g5(getFeedClickDataChangedListener());
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> startAddFeedGroupActivityEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return j1.a(null);
    }

    public void updateFeedListData(UpdateRecord r2) {
        geb.c.d(TAG, "updateFeedListData not implemented on office-sdk yet");
    }

    public FeedSidebarItemsMoltenViewModel(final m r4, com.ss.android.lark.feed.molten.cache.b r5) {
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "localCache");
        super(null, new AnonymousClass1(r4), 1, null);
        this.passport = r4;
        this.localCache = r5;
        this.storeIds = CollectionsKt.emptyList();
        this.feedSidebarItemEntities = j1.a(null);
        this.packerFactory = new c();
        this.notifyItemChangedEvent = j1.a(null);
        this.refreshItems = j1.a(null);
        this.canLoadMoreState = j1.a(Boolean.TRUE);
        this.feedClickDataChangedListener$delegate = LazyKt.lazy(new FeedSidebarItemsMoltenViewModel$feedClickDataChangedListener$2(this));
        this.hasSubscribedToLivequery = new AtomicBoolean(false);
    }

    public static final /* synthetic */ UIFeedCard access$convertToUIFeedCard(FeedSidebarItemsMoltenViewModel r0, FeedEntityPreview r1) {
        return r0.convertToUIFeedCard(r1);
    }

    public static final /* synthetic */ void access$handleLiveListUpdate(FeedSidebarItemsMoltenViewModel r0, h r1) {
        r0.handleLiveListUpdate(r1);
    }

    public static final /* synthetic */ Object access$subscribeToLivequery(FeedSidebarItemsMoltenViewModel r0, Continuation r1) {
        return r0.subscribeToLivequery(r1);
    }

    private final void requestDataLoadingCheck(int r10, boolean r11) {
        if (r11 == true) goto L5;
    L8:
        FeedFolder r1 = this.currentFeedFilter;
        if (r1 != null) goto L11;
        return;
    L11:
        List<String> r2 = this.storeIds;
        if (r2.isEmpty() == false) goto L14;
        r2 = new ArrayList();
    L14:
        List r3 = r2;
        geb.c.c(TAG, "requestDataLoadingCheck, position=" + r10 + ", dataSize=" + r3.size() + ", canLoadMore=" + ((Boolean) this.canLoadMoreState.getValue()).booleanValue() + ", skipWhenCanNotLoadMore=" + r11);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04581(this, r1, r3, null), 3, null);
        return;
    L5:
        if (((Boolean) this.canLoadMoreState.getValue()).booleanValue() == true) goto L8;
        geb.c.c(TAG, "requestDataLoadingCheck skip, canLoadMore is false");
    }

    public void updateFeedCardFlag(FeedPreview r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
        geb.c.d(TAG, "updateFeedCardFlag not implemented on office-sdk yet");
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void onItemChanged(int r1, UIFeedCard r2, boolean r3) {
        requestDataLoadingCheck(r1, true);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void onItemChangedIgnoreCanLoadMore(int r1, UIFeedCard r2, boolean r3) {
        requestDataLoadingCheck(r1, false);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void onItemsShowed(int r11, List<? extends UIFeedCard> r12, boolean r13) {
        List<? extends UIFeedCard> r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - this.lastItemsShowedTime) >= 5000) goto L15;
        geb.c.c(TAG, "onItemsShowed skip by debounce");
        return;
    L15:
        this.lastItemsShowedTime = r2;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04551(r12, this, r11, r13, null), 3, null);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public void remoteMarkUnread(String r11, FeedCard.Type r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "feedId");
        Intrinsics.checkNotNullParameter(r12, "feedType");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04571(this, r11, r12, r13, null), 3, null);
    }
}
