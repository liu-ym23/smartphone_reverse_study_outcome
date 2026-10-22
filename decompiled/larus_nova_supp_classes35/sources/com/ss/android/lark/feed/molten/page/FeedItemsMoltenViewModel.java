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
import com.bytedance.lark.lark_biz_feed_android.x;
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
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0002bcB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u001a\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001a\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001a\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e0\u001f*\u00020 H\u0016J&\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001c\u0010(\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001c\u0010)\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001c\u0010*\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u001c\u0010+\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u0014\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001f*\u00020 H\u0016J\u001c\u0010,\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001e0\u001f*\u00020 H\u0016J\u0012\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u000eH\u0016J\u000e\u00105\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u0004\u0018\u00010\u0018*\u000208H\u0002J\u001c\u00109\u001a\u00020\u00142\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0;H\u0002J\b\u0010>\u001a\u00020\u0014H\u0002J\u0012\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010'H\u0002J\b\u0010A\u001a\u00020\u0014H\u0016J\u0012\u0010B\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u0012H\u0016J\u0018\u0010F\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\"2\u0006\u0010G\u001a\u00020\u0012H\u0016J\u0010\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\"H\u0016J\u0010\u0010J\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\"H\u0016J\u0010\u0010K\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\"H\u0016J \u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020\u0012H\u0016J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\"H\u0016J\u0018\u0010Q\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\"2\u0006\u0010R\u001a\u00020\u0010H\u0016J\b\u0010S\u001a\u00020\u0014H\u0016J\b\u0010T\u001a\u00020\u0014H\u0016J\u0010\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0018H\u0016J(\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010[\u001a\u00020\u0012H\u0016J\"\u0010\\\u001a\u00020\u00142\u0006\u0010X\u001a\u00020Y2\b\u0010]\u001a\u0004\u0018\u00010\u00182\u0006\u0010^\u001a\u00020\u0012H\u0016J\u0012\u0010_\u001a\u00020\u00142\b\u0010`\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010a\u001a\u00020\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010$\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001e0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/ss/android/lark/feed/molten/page/FeedItemsMoltenViewModel;", "Lcom/bytedance/lark/lark_biz_feed_android_wrapper/LarkFeedListViewModel;", "Lcom/ss/android/lark/feed/shared/page/IFeedItemsViewModel;", "passport", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "localCache", "Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;", "<init>", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;Lcom/ss/android/lark/feed/molten/cache/IFeedItemsMoltenLocalCache;)V", "currentFeedItems", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "getCurrentFeedItems", "()Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "currentFeedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "lastItemsShowedTime", BuildConfig.FLAVOR, "filterDoubaoConversation", BuildConfig.FLAVOR, "setFilterDoubaoConversation", BuildConfig.FLAVOR, "isFilterDoubaoConversation", "filterDoubaoConversationIfNeeded", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "feedItemEntities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "packerFactory", "Lcom/ss/android/lark/feed/molten/page/PartialPackerFactory;", "recoverRecentItemPositionEvent", "Lcom/larksuite/arch/jack/Event;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larksuite/arch/jack/ISubscriber;", "notifyItemChangedEvent", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;", "showMarkedLaterDialogEvent", "handlePendingDeleteFeedEvent", "Lkotlin/Pair;", "Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", BuildConfig.FLAVOR, "showToastEvent", "createFeedGroupActivityEvent", "startAddFeedGroupActivityEvent", "clearBadgeConfirmEvent", "refreshItems", "isDataForceEmpty", "folder", "start", "feedFilter", "listWrapper", "Lcom/bytedance/lark/molten_livequery_wrapper/ListWrapperLifecycle;", "hasSubscribedToLivequery", "Ljava/util/concurrent/atomic/AtomicBoolean;", "subscribeToLivequery", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertToUIFeedCard", "Lcom/bytedance/lark/pb/feed/v1/FeedEntityPreview;", "handleLiveListUpdate", "liveList", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Lcom/ss/android/lark/feed/molten/page/FeedItemsMoltenViewModel$FeedCardEntry;", "Lcom/bytedance/lark/pb/feed/v1/LarkFeedListKeyChange;", "subscribeToToastEvents", "showToast", "tip", "foregroundFilterChanged", "updateFeedListData", "updateFeedCardFlag", "feedPreview", "isFlag", "setFeedCardShortCut", "isShortCut", "onNoDisturbSwitchChange", Keys.API_RETURN_KEY_DATA, "onAutoMuteSwitchChange", "clearUnreadBadge", "remoteMarkUnread", "feedId", "feedType", "targetUnreadStatus", "tryAddFeedTag", "removeFeedTag", "groupId", "resumeData", "pauseDataChange", "onMoveCardToDoneFeed", "feedCard", "onItemsShowed", "position", BuildConfig.FLAVOR, "uiFeedCards", "onlyChat", "onItemChanged", "uiFeedCard", "isListScrollingScene", "showNextUnreadFeedItem", "nextUnreadFeedCard", "onCleared", "Companion", "FeedCardEntry", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedItemsMoltenViewModel extends LarkFeedListViewModel implements s {
    public static final a Companion = null;
    private static final long ON_ITEMS_SHOWED_DEBOUNCE_IN_MILLS = 5000;
    private static final String TAG = "FeedItemsMoltenViewModel";
    private final z0<d<FeedPreview>> clearBadgeConfirmEvent;
    private final z0<d<String>> createFeedGroupActivityEvent;
    private FeedFolder currentFeedFilter;
    private final z0<UpdateRecord> feedItemEntities;
    private boolean filterDoubaoConversation;
    private final z0<d<Pair<FeedCard.Type, String>>> handlePendingDeleteFeedEvent;
    private final AtomicBoolean hasSubscribedToLivequery;
    private long lastItemsShowedTime;
    private g listWrapper;
    private final com.ss.android.lark.feed.molten.cache.b localCache;
    private final z0<d<FeedPreview>> notifyItemChangedEvent;
    private final c packerFactory;
    private final m passport;
    private final z0<d<Unit>> recoverRecentItemPositionEvent;
    private final z0<d<String>> refreshItems;
    private final z0<d<FeedFolder>> showMarkedLaterDialogEvent;
    private final z0<d<String>> showToastEvent;
    private final z0<d<String>> startAddFeedGroupActivityEvent;

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

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$clearUnreadBadge$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$clearUnreadBadge$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04441(FeedItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04441> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04441(this.this$0, this.$data, r4);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead success");
        L17:
            Throwable r4 = null;
            if (r3 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L21:
            if (r5 == null) goto L23;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L24:
            if (r6 == null) goto L26;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead failure :" + ((ViewFlowError) r6).getMessage());
        L26:
            if (r3 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L29:
            if (r7 == null) goto L31;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L31:
            if (r4 == null) goto L34;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
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

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onAutoMuteSwitchChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onAutoMuteSwitchChange$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04451(FeedItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04451> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04451(this.this$0, this.$data, r4);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange success");
        L18:
            Throwable r4 = null;
            if (r3 == false) goto L21;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L22:
            if (r5 == null) goto L24;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).b();
        L25:
            if (r6 == null) goto L27;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange failure :" + ((ViewFlowError) r6).getMessage());
        L27:
            if (r3 == false) goto L29;
            com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L30:
            if (r9 == null) goto L32;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).a();
        L32:
            if (r4 == null) goto L35;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "onAutoMuteSwitchChange exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
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

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onItemChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onItemChanged$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedFolder $feedFilter;
        final /* synthetic */ boolean $isListScrollingScene;
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04461(FeedItemsMoltenViewModel r1, FeedFolder r2, int r3, boolean r4, Continuation<? super C04461> r5) {
            this.this$0 = r1;
            this.$feedFilter = r2;
            this.$position = r3;
            this.$isListScrollingScene = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04461(this.this$0, this.$feedFilter, this.$position, this.$isListScrollingScene, r8);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck success");
        L14:
            Throwable r4 = null;
            if (r3 == false) goto L17;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L18:
            if (r5 == null) goto L20;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).b();
        L21:
            if (r6 == null) goto L23;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck failure :" + ((ViewFlowError) r6).getMessage());
        L23:
            if (r3 == false) goto L25;
            com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L26:
            if (r9 == null) goto L28;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).a();
        L28:
            if (r4 == null) goto L31;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionDataLoadingCheck exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
            FeedFilterType.a r11 = FeedFilterType.Companion;
            int r12 = this.$feedFilter.getSystemPresetType().getValue();
            r11.getClass();
            q r13 = new q(FeedFilterType.a.a(r12), this.$position, this.$isListScrollingScene);
            this.label = 1;
            r8 = r10.action-vFDjHp0(r13, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onItemsShowed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onItemsShowed$1", f = "FeedItemsMoltenViewModel.kt", i = {0}, l = {439, 446}, m = "invokeSuspend", n = {"dependencyList"}, s = {"L$0"})
    public static final class C04471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $onlyChat;
        final /* synthetic */ int $position;
        final /* synthetic */ List<UIFeedCard> $uiFeedCards;
        Object L$0;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C04471(List<? extends UIFeedCard> r1, FeedItemsMoltenViewModel r2, int r3, boolean r4, Continuation<? super C04471> r5) {
            this.$uiFeedCards = r1;
            this.this$0 = r2;
            this.$position = r3;
            this.$onlyChat = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04471(this.$uiFeedCards, this.this$0, this.$position, this.$onlyChat, r8);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency success");
        L48:
            if (r3 == false) goto L50;
            com.bytedance.lark.view_flow_wrapper.d.b r4 = (com.bytedance.lark.view_flow_wrapper.d.b) r13;
        L51:
            if (r4 == null) goto L53;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r13).b();
        L54:
            if (r6 == null) goto L56;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency failure :" + ((ViewFlowError) r6).getMessage());
        L56:
            if (r3 == false) goto L58;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r13;
        L59:
            if (r7 == null) goto L61;
            r5 = ((com.bytedance.lark.view_flow_wrapper.d.b) r13).a();
        L61:
            if (r5 == null) goto L64;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsDependency exception :" + r5.getMessage());
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData success");
        L26:
            if (r10 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r11 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L29:
            if (r11 == null) goto L31;
            Object r15 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).b();
        L32:
            if (r15 == null) goto L34;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData failure :" + ((ViewFlowError) r15).getMessage());
        L34:
            if (r10 == false) goto L36;
            com.bytedance.lark.view_flow_wrapper.d.b r16 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L37:
            if (r16 == null) goto L39;
            Throwable r17 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).a();
        L40:
            if (r17 == null) goto L42;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "onItemChanged LarkFeedListActionPreloadItemsData exception :" + r17.getMessage());
        L42:
            FeedItemsMoltenViewModel r18 = this.this$0;
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
            FeedItemsMoltenViewModel r24 = this.this$0;
            v r25 = new v(r110);
            this.L$0 = r8;
            this.label = 1;
            r14 = r24.action-vFDjHp0(r25, this);
            if (r14 != r0) goto L23;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onNoDisturbSwitchChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$onNoDisturbSwitchChange$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedPreview $data;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04481(FeedItemsMoltenViewModel r1, FeedPreview r2, Continuation<? super C04481> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04481(this.this$0, this.$data, r4);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange success");
        L17:
            Throwable r4 = null;
            if (r3 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L21:
            if (r5 == null) goto L23;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L24:
            if (r6 == null) goto L26;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange failure :" + ((ViewFlowError) r6).getMessage());
        L26:
            if (r3 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L29:
            if (r7 == null) goto L31;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L31:
            if (r4 == null) goto L34;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "onNoDisturbSwitchChange exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
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

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$remoteMarkUnread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$remoteMarkUnread$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $feedId;
        final /* synthetic */ FeedCard.Type $feedType;
        final /* synthetic */ boolean $targetUnreadStatus;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04491(FeedItemsMoltenViewModel r1, String r2, FeedCard.Type r3, boolean r4, Continuation<? super C04491> r5) {
            this.this$0 = r1;
            this.$feedId = r2;
            this.$feedType = r3;
            this.$targetUnreadStatus = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04491(this.this$0, this.$feedId, this.$feedType, this.$targetUnreadStatus, r8);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead success");
        L14:
            Throwable r4 = null;
            if (r3 == false) goto L17;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L18:
            if (r5 == null) goto L20;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).b();
        L21:
            if (r6 == null) goto L23;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead failure :" + ((ViewFlowError) r6).getMessage());
        L23:
            if (r3 == false) goto L25;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r9;
        L26:
            if (r7 == null) goto L28;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r9).a();
        L28:
            if (r4 == null) goto L31;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionMarkItemAsRead exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
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

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$showNextUnreadFeedItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$showNextUnreadFeedItem$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {476}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UIFeedCard $uiFeedCard;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04501(FeedItemsMoltenViewModel r1, UIFeedCard r2, Continuation<? super C04501> r3) {
            this.this$0 = r1;
            this.$uiFeedCard = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04501(this.this$0, this.$uiFeedCard, r4);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "showNextUnreadFeedItem LarkFeedListActionPreloadNextUnread success");
        L14:
            Throwable r4 = null;
            if (r3 == false) goto L17;
            com.bytedance.lark.view_flow_wrapper.d.b r5 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L18:
            if (r5 == null) goto L20;
            Object r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).b();
        L21:
            if (r6 == null) goto L23;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "showNextUnreadFeedItem LarkFeedListActionPreloadNextUnread failure :" + ((ViewFlowError) r6).getMessage());
        L23:
            if (r3 == false) goto L25;
            com.bytedance.lark.view_flow_wrapper.d.b r9 = (com.bytedance.lark.view_flow_wrapper.d.b) r8;
        L26:
            if (r9 == null) goto L28;
            r4 = ((com.bytedance.lark.view_flow_wrapper.d.b) r8).a();
        L28:
            if (r4 == null) goto L31;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "showNextUnreadFeedItem LarkFeedListActionPreloadNextUnread exception :" + r4.getMessage());
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
            FeedItemsMoltenViewModel r10 = this.this$0;
            x r11 = new x(this.$uiFeedCard.getId());
            this.label = 1;
            r8 = r10.action-vFDjHp0(r11, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$start$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {163, 168, 172}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedFolder $feedFilter;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public C04511(FeedItemsMoltenViewModel r1, FeedFolder r2, Continuation<? super C04511> r3) {
            this.this$0 = r1;
            this.$feedFilter = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04511(this.this$0, this.$feedFilter, r4);
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh success");
        L43:
            if (r3 == false) goto L45;
            com.bytedance.lark.view_flow_wrapper.d.b r4 = (com.bytedance.lark.view_flow_wrapper.d.b) r11;
        L46:
            if (r4 == null) goto L48;
            Object r5 = ((com.bytedance.lark.view_flow_wrapper.d.b) r11).b();
        L49:
            if (r5 == null) goto L51;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh failure :" + ((ViewFlowError) r5).getMessage());
        L51:
            if (r3 == false) goto L53;
            com.bytedance.lark.view_flow_wrapper.d.b r7 = (com.bytedance.lark.view_flow_wrapper.d.b) r11;
        L54:
            if (r7 == null) goto L56;
            r6 = ((com.bytedance.lark.view_flow_wrapper.d.b) r11).a();
        L56:
            if (r6 == null) goto L58;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionRefresh exception :" + r6.getMessage());
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
            FeedItemsMoltenViewModel.access$subscribeToToastEvents(this.this$0);
            FeedItemsMoltenViewModel r12 = this.this$0;
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionSetup success");
        L18:
            if (r16 == false) goto L20;
            com.bytedance.lark.view_flow_wrapper.d.b r17 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L21:
            if (r17 == null) goto L23;
            Object r18 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).b();
        L24:
            if (r18 == null) goto L26;
            geb.c.d(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionSetup failure :" + ((ViewFlowError) r18).getMessage());
        L26:
            if (r16 == false) goto L28;
            com.bytedance.lark.view_flow_wrapper.d.b r19 = (com.bytedance.lark.view_flow_wrapper.d.b) r14;
        L29:
            if (r19 == null) goto L31;
            Throwable r110 = ((com.bytedance.lark.view_flow_wrapper.d.b) r14).a();
        L32:
            if (r110 == null) goto L34;
            geb.c.a(FeedItemsMoltenViewModel.TAG, "LarkFeedListActionSetup exception :" + r110.getMessage());
        L34:
            FeedItemsMoltenViewModel r111 = this.this$0;
            this.label = 2;
            if (FeedItemsMoltenViewModel.access$subscribeToLivequery(r111, this) != r0) goto L37;
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
            FeedItemsMoltenViewModel r112 = this.this$0;
            d0 r20 = d0.a;
            this.label = 1;
            r14 = r112.action-vFDjHp0(r20, this);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$subscribeToLivequery$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "liveList", "Lcom/bytedance/lark/molten_livequery_wrapper/LiveList;", "Lcom/ss/android/lark/feed/molten/page/FeedItemsMoltenViewModel$FeedCardEntry;", "Lcom/bytedance/lark/pb/feed/v1/LarkFeedListKeyChange;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$subscribeToLivequery$4", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<h<b, LarkFeedListKeyChange>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FeedItemsMoltenViewModel this$0;

        public AnonymousClass4(FeedItemsMoltenViewModel r1, Continuation<? super AnonymousClass4> r2) {
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
            geb.c.c(FeedItemsMoltenViewModel.TAG, "subscribeToLivequery success");
            FeedItemsMoltenViewModel.access$handleLiveListUpdate(this.this$0, r4);
            geb.c.c(FeedItemsMoltenViewModel.TAG, "FeedItemsMoltenViewModel subscribeToLivequery resume");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$subscribeToToastEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/bytedance/lark/lark_biz_feed_android/ToastStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.feed.molten.page.FeedItemsMoltenViewModel$subscribeToToastEvents$1", f = "FeedItemsMoltenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04521 extends SuspendLambda implements Function2<w0, Continuation<? super Unit>, Object> {
        int label;

        public C04521(Continuation<? super C04521> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C04521(r2);
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

    private final void subscribeToToastEvents() {
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(subscribe(ILarkFeedListViewFlow.c.f.c), new C04521(null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void foregroundFilterChanged() {
        geb.c.d(TAG, "foregroundFilterChanged not implemented on office-sdk yet");
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public UpdateRecord getCurrentFeedItems() {
        return (UpdateRecord) this.feedItemEntities.getValue();
    }

    public void onCleared() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        super/*com.bytedance.lark.view_flow_wrapper.MoltenViewModel*/.onCleared();
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void pauseDataChange() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L6;
        geb.c.c(TAG, "FeedItemsMoltenViewModel pauseDataChange");
        r0.pause();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FeedItemsMoltenViewModel$pauseDataChange$1$1(this, null), 3, null);
        return;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void resumeData() {
        g r0 = this.listWrapper;
        if (r0 == null) goto L6;
        geb.c.c(TAG, "FeedItemsMoltenViewModel resumeData");
        r0.resume();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FeedItemsMoltenViewModel$resumeData$1$1(this, null), 3, null);
        return;
    }

    public static final /* synthetic */ void access$subscribeToToastEvents(FeedItemsMoltenViewModel r0) {
        r0.subscribeToToastEvents();
    }

    private final UIFeedCard convertToUIFeedCard(FeedEntityPreview r4) {
        UIFeedCard r0 = this.packerFactory.a(com.ss.android.lark.feed.shared.data.utils.h.a(r4));
        if (r0 == null) goto L5;
        f.b(r0);
    L6:
        geb.c.c(TAG, "convert pb=" + geb.a.a(r4) + ", to uiCard=" + geb.a.b(r0));
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<UIFeedCard> filterDoubaoConversationIfNeeded(List<? extends UIFeedCard> r5) {
        if (this.filterDoubaoConversation == false) goto L20;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        if (((UIFeedCard) r1).getType() == FeedCard.Type.DOUBAO_CONVERSATION) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        r2 = false;
        goto L11
    L14:
        return r0;
    L20:
        return r5;
    }

    private final void handleLiveListUpdate(h<b, LarkFeedListKeyChange> r12) {
        this.listWrapper = r12.c;
        LarkFeedListKeyChange r0 = (LarkFeedListKeyChange) r12.b;
        List r13 = r12.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r1.add(((b) r14.next()).a);
        goto L4
    L6:
        List<? extends UIFeedCard> r15 = CollectionsKt.filterNotNull(r1);
        List<UIFeedCard> r2 = filterDoubaoConversationIfNeeded(r15);
        if (r0 == null) goto L9;
    L18:
        boolean r7 = false;
    L19:
        StringBuilder r6 = new StringBuilder("handleLiveListUpdate raw=");
        r6.append(r1.size());
        r6.append(", nonNull=");
        r6.append(r15.size());
        r6.append(", afterFilter=");
        r6.append(r2.size());
        r6.append(", filterDoubao=");
        r6.append(this.filterDoubaoConversation);
        r6.append(", keyChangeVersion:");
        if (r0 == null) goto L22;
        Long r3 = r0.version;
    L23:
        r6.append(r3);
        r6.append(", skipEmptyUpdate:");
        r6.append(r7);
        geb.c.c(TAG, r6.toString());
        if (r7 == false) goto L26;
        return;
    L26:
        this.localCache.e(r2, 15);
        z0<UpdateRecord> r4 = this.feedItemEntities;
    L27:
        Object r8 = r4.getValue();
        UpdateRecord r9 = (UpdateRecord) r8;
        UpdateRecord r10 = new UpdateRecord();
        FeedCard.FeedType r11 = FeedCard.FeedType.ALL;
        r10.c = r2.isEmpty();
        r10.a(r2);
        r10.e = this.passport.getUser().userId;
        if (r0 == null) goto L32;
        Boolean r16 = r0.force_update;
        if (r16 == null) goto L32;
        boolean r17 = r16.booleanValue();
    L35:
        r10.d = r17;
        if (r0 == null) goto L40;
        Long r18 = r0.version;
        if (r18 == null) goto L40;
        long r19 = r18.longValue();
    L43:
        r10.a = r19;
        if (r0 == null) goto L49;
        FeedFilter.Type r20 = r0.feed_filter;
        if (r20 == null) goto L49;
        FeedFolder r21 = FeedFolderCompat.INSTANCE.forNumber(r20.getValue());
        if (r21 == null) goto L49;
    L52:
        r10.g = r21;
        if (r0 == null) goto L58;
        FeedFilter.Type r22 = r0.last_feed_filter;
        if (r22 == null) goto L58;
        FeedFolder r23 = FeedFolderCompat.INSTANCE.forNumber(r22.getValue());
        if (r23 == null) goto L58;
    L61:
        r10.h = r23;
        if (r4.compareAndSet(r8, r10) == false) goto L27;
        return;
    L58:
        if (r9 == null) goto L60;
        r23 = r9.h;
        goto L61
    L60:
        r23 = null;
    L49:
        if (r9 == null) goto L51;
        r21 = r9.g;
        goto L52
    L51:
        r21 = null;
    L40:
        if (r9 == null) goto L42;
        r19 = r9.a;
        goto L43
    L42:
        r19 = 0;
    L32:
        if (r9 == null) goto L34;
        r17 = r9.d;
        goto L35
    L34:
        r17 = false;
        goto L35
    L22:
        r3 = null;
        goto L23
    L9:
        if (r2.isEmpty() == false) goto L18;
        UpdateRecord r24 = (UpdateRecord) this.feedItemEntities.getValue();
        r7 = true;
        if (r24 != null) goto L13;
    L15:
        boolean r25 = false;
    L16:
        if (r25 == false) goto L18;
    L13:
        if (r24.a != 0) goto L15;
        r25 = true;
        goto L16
    }

    private final void showToast(String r4) {
        z0<d<String>> r0 = this.showToastEvent;
    L3:
        Object r1 = r0.getValue();
        d r2 = (d) r1;
        if (r0.compareAndSet(r1, new d(r4)) == false) goto L3;
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
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        return j1.a(Boolean.TRUE);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<FeedPreview>> clearBadgeConfirmEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.clearBadgeConfirmEvent;
    }

    public void clearUnreadBadge(FeedPreview r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04441(this, r8, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> createFeedGroupActivityEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.createFeedGroupActivityEvent;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<UpdateRecord> feedItemEntities(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.feedItemEntities;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<Pair<FeedCard.Type, String>>> handlePendingDeleteFeedEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.handlePendingDeleteFeedEvent;
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
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04451(this, r8, null), 3, null);
    }

    public void onMoveCardToDoneFeed(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "feedCard");
        geb.c.d(TAG, "onMoveCardToDoneFeed not implemented on office-sdk yet");
    }

    public void onNoDisturbSwitchChange(FeedPreview r8) {
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04481(this, r8, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<Unit>> recoverRecentItemPositionEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.recoverRecentItemPositionEvent;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> refreshItems(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.refreshItems;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void setFilterDoubaoConversation(boolean r1) {
        this.filterDoubaoConversation = r1;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<FeedFolder>> showMarkedLaterDialogEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.showMarkedLaterDialogEvent;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void showNextUnreadFeedItem(UIFeedCard r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04501(this, r7, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> showToastEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.showToastEvent;
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void start(FeedFolder r9) {
        Intrinsics.checkNotNullParameter(r9, "feedFilter");
        this.currentFeedFilter = r9;
        geb.c.d(TAG, "FeedItemsMoltenViewModel start");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04511(this, r9, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public i1<d<String>> startAddFeedGroupActivityEvent(com.larksuite.arch.jack.f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return this.startAddFeedGroupActivityEvent;
    }

    public void tryAddFeedTag(FeedPreview r2) {
        Intrinsics.checkNotNullParameter(r2, "feedPreview");
        geb.c.d(TAG, "tryAddFeedTag not implemented on office-sdk yet");
    }

    public void updateFeedListData(UpdateRecord r2) {
        geb.c.d(TAG, "updateFeedListData not implemented on office-sdk yet");
    }

    public FeedItemsMoltenViewModel(final m r4, com.ss.android.lark.feed.molten.cache.b r5) {
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "localCache");
        super(null, new AnonymousClass1(r4), 1, null);
        this.passport = r4;
        this.localCache = r5;
        this.feedItemEntities = j1.a(null);
        this.packerFactory = new c();
        this.recoverRecentItemPositionEvent = j1.a(null);
        this.notifyItemChangedEvent = j1.a(null);
        this.showMarkedLaterDialogEvent = j1.a(null);
        this.handlePendingDeleteFeedEvent = j1.a(null);
        this.showToastEvent = j1.a(null);
        this.createFeedGroupActivityEvent = j1.a(null);
        this.startAddFeedGroupActivityEvent = j1.a(null);
        this.clearBadgeConfirmEvent = j1.a(null);
        this.refreshItems = j1.a(null);
        this.hasSubscribedToLivequery = new AtomicBoolean(false);
    }

    public static final /* synthetic */ UIFeedCard access$convertToUIFeedCard(FeedItemsMoltenViewModel r0, FeedEntityPreview r1) {
        return r0.convertToUIFeedCard(r1);
    }

    public static final /* synthetic */ void access$handleLiveListUpdate(FeedItemsMoltenViewModel r0, h r1) {
        r0.handleLiveListUpdate(r1);
    }

    public static final /* synthetic */ Object access$subscribeToLivequery(FeedItemsMoltenViewModel r0, Continuation r1) {
        return r0.subscribeToLivequery(r1);
    }

    public void removeFeedTag(FeedPreview r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
        geb.c.d(TAG, "removeFeedTag not implemented on office-sdk yet");
    }

    public void setFeedCardShortCut(FeedPreview r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
        geb.c.d(TAG, "setFeedCardShortCut not implemented on office-sdk yet");
    }

    public void updateFeedCardFlag(FeedPreview r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "feedPreview");
        geb.c.d(TAG, "updateFeedCardFlag not implemented on office-sdk yet");
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void onItemChanged(int r10, UIFeedCard r11, boolean r12) {
        FeedFolder r2 = this.currentFeedFilter;
        if (r2 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04461(this, r2, r10, r12, null), 3, null);
    }

    @Override // com.ss.android.lark.feed.shared.page.s
    public void onItemChangedIgnoreCanLoadMore(int r1, UIFeedCard r2, boolean r3) {
        onItemChanged(r1, r2, r3);
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
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04471(r12, this, r11, r13, null), 3, null);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public void remoteMarkUnread(String r11, FeedCard.Type r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "feedId");
        Intrinsics.checkNotNullParameter(r12, "feedType");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04491(this, r11, r12, r13, null), 3, null);
    }
}
