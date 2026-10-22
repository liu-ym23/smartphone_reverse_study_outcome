package com.ss.android.lark.flow.feed.sidebar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.feed.export.feedcard.h;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.feed.shared.page.experiment.FeedCallbackExecutor;
import com.ss.android.lark.flow.feed.sidebar.cell.FeedSidebarLoadMoreViewHolder;
import com.ss.android.lark.flow.feed.sidebar.view.FeedSidebarCommonViewHolder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b)*\u0001$\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000fH\u0016J\u0018\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u000fH\u0016J\u0016\u00106\u001a\u00020*2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u00108\u001a\u00020*H\u0016J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0012H\u0002J\u0018\u0010;\u001a\u00020*2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020/H\u0016J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020AH\u0016J\u000e\u0010B\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u0012J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u0017H\u0016J\b\u0010E\u001a\u00020\u000fH\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010\u00152\u0006\u00105\u001a\u00020\u000fH\u0016J\u0010\u0010G\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0016J\u0010\u0010H\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u000fH\u0016J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020*H\u0002J\b\u0010K\u001a\u00020*H\u0002J\b\u0010L\u001a\u00020*H\u0002J\u0010\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020AH\u0002J\u0010\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020\u001dH\u0002J\u0010\u0010Q\u001a\u00020*2\u0006\u0010N\u001a\u00020AH\u0002J\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020\u0012H\u0002J\u001e\u0010T\u001a\u00020\u00122\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010V\u001a\u00020\u001dH\u0002J\u0010\u0010W\u001a\u00020*2\u0006\u0010N\u001a\u00020AH\u0002J\b\u0010X\u001a\u00020*H\u0002J\b\u0010Y\u001a\u00020*H\u0002J\u0010\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\u0017H\u0002J\u0016\u0010\\\u001a\u00020*2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010`\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u000fH\u0002J\b\u0010a\u001a\u00020\u0012H\u0002J\b\u0010b\u001a\u00020\u000fH\u0002J\b\u0010c\u001a\u00020\u000fH\u0002J\u001a\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020A2\b\b\u0002\u0010f\u001a\u00020AH\u0002J\u001a\u0010g\u001a\u00020\u0017*\u00020\u00172\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&¨\u0006j"}, d2 = {"Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapter;", "Lcom/ss/android/lark/feed/shared/page/adapter/LarkFeedInBoxListAdapter;", "Lcom/ss/android/lark/feed/export/mixed/IMixedFeedSidebarAbility;", "feedCardFactoryWrapper", "Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardFactory;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "sidebarItemConfig", "Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;", "dependency", "Lcom/ss/android/lark/flow/feed/sidebar/adapter/dependency/IFeedSidebarAdapterDependency;", "<init>", "(Lcom/ss/android/lark/feed/shared/openfeed/card/OpenFeedCardWrapper;Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;Lcom/ss/android/lark/biz/officesdk/im/feed/sidebar/SidebarItemConfig;Lcom/ss/android/lark/flow/feed/sidebar/adapter/dependency/IFeedSidebarAdapterDependency;)V", "mRecyclerViewState", "", "currentPagingDisplaySize", "hasLoadedMoreAfterDisplaySizeReset", "", "sourceItems", "", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "latestSourceRecord", "Lcom/ss/android/lark/feed/shared/data/UpdateRecord;", "pendingPagingRecord", "showLoadMoreCell", "canLoadMore", "isFillingDisplaySize", "lastLoadMoreComparedVersion", "", "boundaryLoadRequestedSourceSize", "boundaryLoadRequestedDisplayBoundarySize", "boundaryLoadRequestedSourceVersion", "boundaryLoadCheckedSourceSize", "boundaryLoadCheckedDisplayBoundarySize", "mOnScrollListener", "com/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapter$mOnScrollListener$2$1", "getMOnScrollListener", "()Lcom/ss/android/lark/flow/feed/sidebar/adapter/FeedSidebarAdapter$mOnScrollListener$2$1;", "mOnScrollListener$delegate", "Lkotlin/Lazy;", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setLocalConversationData", "conversationData", "loadMoreConversation", "requestLoadMoreConversation", "ignoreCanLoadMore", "reportShowCellHitPoint", "viewHolder", "setDisplaySize", "count", "getPositionByFeedId", "feedId", "", "setCanLoadMore", "update", "boxData", "getItemCount", "getItem", "getItemViewType", "getItemId", "onLoadMoreClick", "fillDisplaySizeIfNeeded", "startFillingDisplaySize", "continueLoadMoreIfNeeded", "requestBoundaryLoadCheckIfNeeded", "reason", "completeBoundaryLoadCheckIfNeeded", "currentSourceVersion", "completeBoundaryLoadCheck", "resetBoundaryLoadCheck", "isBoundaryLoadCheckSettledForCurrentSource", "shouldSkipTransientEmptySource", "nextSourceItems", "sourceVersion", "stopFillingDisplaySize", "refreshPagingDisplay", "dispatchPendingPagingUpdate", "dispatchPagingUpdate", "sourceRecord", "notifyDisplayCellBadge", "displayItems", "buildDisplayItems", "source", "isLoadMorePosition", "isPagingEnabled", "getFirstPageLoadMoreSize", "getNextPageLoadMoreSize", "logPagingState", "action", "detail", "copyWithFeedCards", "feedCards", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FeedSidebarAdapter extends LarkFeedInBoxListAdapter implements deb.c {
    public int A;
    public int B;
    public boolean C;
    public List<? extends UIFeedCard> D;
    public UpdateRecord E;
    public UpdateRecord F;
    public boolean G;
    public boolean H;
    public boolean I;
    public long J;
    public int K;
    public int L;
    public long M;
    public int N;
    public int O;
    public final Lazy P;
    public final reb.a<e> w;
    public final com.ss.android.lark.feed.export.feedcard.d x;
    public final iza.e y;
    public final hhb.a z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.sidebar.adapter.FeedSidebarAdapter$onCreateViewHolder$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r8) {
            super(0, r8, FeedSidebarAdapter.class, "onLoadMoreClick", "onLoadMoreClick()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m419invoke() {
            FeedSidebarAdapter r0 = (FeedSidebarAdapter) ((CallableReference) this).receiver;
            if (r0.G == false) goto L12;
            iza.e r1 = r0.y;
            if (r1.d == false) goto L12;
            int r2 = r0.B;
            if (r0.C == false) goto L10;
            int r3 = RangesKt.coerceAtLeast(r1.h, 1);
        L11:
            r0.B += r3;
            r0.C = true;
            r0.O2("onLoadMoreClick", "oldDisplaySize=" + r2 + ", loadMoreSize=" + r3);
            r0.L2();
            r0.Q2();
            return;
        L10:
            r3 = RangesKt.coerceAtLeast(r1.e, 1);
        L12:
            r0.O2("onLoadMoreClickIgnored", "");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m419invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void j() {
        T2(false);
    }

    public final void L2() {
        if (this.y.d == true) goto L7;
        O2("fillDisplaySizeSkipped", "paging is disabled");
        return;
    L7:
        if (this.D.size() >= (this.B + 1)) goto L9;
        boolean r0 = this.H;
        if (r0 == false) goto L20;
        this.K = -1;
        this.L = -1;
        long r6 = Long.MIN_VALUE;
        this.M = Long.MIN_VALUE;
        this.N = -1;
        this.O = -1;
        boolean r1 = this.I;
        if (r1 == true) goto L31;
        if (r0 == true) goto L49;
        O2("startFillingDisplaySizeSkipped", "canLoadMore is false");
        return;
    L49:
        this.I = true;
        UpdateRecord r2 = this.E;
        if (r2 == null) goto L52;
        r6 = r2.a;
    L52:
        this.J = r6;
        O2("startFillingDisplaySize", "");
        T2(false);
        return;
    L31:
        if (r1 == true) goto L33;
        O2("continueLoadMoreSkipped", "filling is inactive");
        return;
    L33:
        if (r0 == true) goto L35;
        U2("can load more is false");
        return;
    L35:
        int r3 = this.D.size();
        int r4 = this.B + 1;
        UpdateRecord r5 = this.E;
        if (r5 == null) goto L38;
        r6 = r5.a;
    L38:
        O2("continueLoadMoreCheck", "currentItemCount=" + r3 + ", displayBoundarySize=" + r4 + ", currentSourceVersion=" + r6);
        if (r3 < r4) goto L44;
        if (M2() == false) goto L44;
        U2("display boundary checked");
        return;
    L44:
        if (r6 != this.J) goto L46;
        O2("continueLoadMoreSkipped", "source version unchanged, currentSourceVersion=" + r6);
        return;
    L46:
        this.J = r6;
        O2("continueLoadMoreRequested", "");
        T2(false);
        return;
    L20:
        if (M2() == true) goto L24;
        R2("canLoadMore is false");
        return;
    L24:
        if (this.I == false) goto L26;
        U2("can load more is false");
        return;
    L26:
        O2("fillDisplaySizeSkipped", "canLoadMore is false, boundary sourceSize checked");
        return;
    L9:
        if (M2() == true) goto L13;
        R2("source reached display boundary");
        return;
    L13:
        if (this.I == false) goto L15;
        U2("display boundary checked");
        return;
    L15:
        O2("fillDisplaySizeSkipped", "local data is enough");
    }

    public final boolean M2() {
        if (this.N == this.D.size()) goto L5;
    L7:
        return false;
    L5:
        if (this.O != (this.B + 1)) goto L7;
        return true;
    }

    public final void Q2() {
        UpdateRecord r0 = this.E;
        if (r0 != null) goto L5;
        O2("refreshPagingDisplaySkipped", "latest record is null");
        return;
    L5:
        O2("refreshPagingDisplay", "");
        K2(r0);
    }

    public final int getItemCount() {
        int r0 = super.getItemCount();
        boolean r1 = this.G;
        int r2 = r0 + (r1 ? 1 : 0);
        if (r1 == false) goto L5;
        com.ss.android.lark.flow.feed.utils.b.a("getItemCount includes load more cell, count=" + r2);
    L5:
        return r2;
    }

    public final int D(String r6) {
        Intrinsics.checkNotNullParameter(r6, "feedId");
        Iterator r0 = ((LarkRecyclerViewBaseAdapter) this).items.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((UIFeedCard) r0.next()).getId(), r6) == true) goto L10;
        r2 = r2 + 1;
    L10:
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapter", "getPositionByFeedId, feedId=" + r6 + ", position=" + r2);
        if (r2 != (-1)) goto L20;
        Iterator r3 = ((LarkRecyclerViewBaseAdapter) this).items.iterator();
    L14:
        if (r3.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((UIFeedCard) r3.next()).getBizId(), r6) == true) goto L19;
        r1 = r1 + 1;
        goto L14
    L19:
        return r1;
    L25:
        return -1;
    L20:
        return r2;
    L9:
        r2 = -1;
        goto L10
    }

    public final UIFeedCard G2(int r3) {
        if (this.G == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        com.ss.android.lark.flow.feed.utils.b.a("getItem returns null for load more cell, position=" + r3);
        return null;
    L12:
        return super.G2(r3);
    L5:
        if (r3 != ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L7;
        r0 = true;
        goto L8
    }

    public final void J0(int r4) {
        if (this.y.d == true) goto L6;
        O2("setDisplaySizeIgnored", "count=" + r4 + ", paging is disabled");
        return;
    L6:
        int r0 = this.B;
        this.B = RangesKt.coerceAtLeast(r4, 1);
        this.C = false;
        O2("setDisplaySize", "requested=" + r4 + ", oldDisplaySize=" + r0 + ", resetLoadMoreStep=true");
        L2();
        Q2();
    }

    public final void K2(UpdateRecord r7) {
        List<? extends UIFeedCard> r0 = this.D;
        if (this.y.d == true) goto L5;
        this.G = false;
        O2("buildDisplayItems", "paging is disabled, resultSize=" + r0.size());
    L20:
        UpdateRecord r1 = new UpdateRecord();
        r1.a = r7.a;
        r1.a(r0);
        r1.c = r0.isEmpty();
        r1.e = r7.e;
        r1.g = r7.g;
        r1.h = r7.h;
        r1.i = r7.i;
        r1.d = true;
        r1.f = null;
        O2("dispatchPagingUpdate", "displayItemCount=" + r0.size() + ", sourceVersion=" + r7.a);
        FeedListAdapter.c r8 = ((FeedListAdapter) this).l;
        if (r8 == null) goto L23;
        r8.a(r1);
    L23:
        ((LarkRecyclerViewBaseAdapter) this).items = r1.b;
        notifyDataSetChanged();
        P2(r0);
        FeedListAdapter.c r9 = ((FeedListAdapter) this).l;
        if (r9 == null) goto L27;
        r9.b(r1);
        return;
    L27:
        return;
    L5:
        int r2 = this.B + 1;
        if (r0.size() <= r2) goto L9;
    L14:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        this.G = true;
        r0 = CollectionsKt.take(r0, this.B);
    L19:
        O2("buildDisplayItems", "resultSize=" + r0.size() + ", shouldShowLoadMore=" + r3);
        goto L20
    L18:
        this.G = false;
        goto L19
    L9:
        if (r0.size() == r2) goto L11;
    L15:
        r3 = false;
        goto L16
    L11:
        if (M2() == true) goto L15;
        if (this.H == false) goto L15;
        goto L14
    }

    public final void P2(List<? extends UIFeedCard> r6) {
        Iterator<T> r0 = r6.iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((UIFeedCard) r0.next()).getUnreadCount();
        goto L4
    L6:
        int r2 = (int) RangesKt.coerceAtMost(r1, 2147483647L);
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapter", "notifyDisplayCellBadge, badgeCount=" + r2 + ", displaySize=" + r6.size());
        deb.d r7 = this.x.b();
        if (r7 == null) goto L11;
        r7.b(r2);
        return;
    }

    public final void Q(List<? extends UIFeedCard> r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationData");
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapter", "setLocalConversationData, size=" + r3.size());
        this.z.Q(r3);
    }

    public final void R2(String r6) {
        int r0 = this.B + 1;
        if (this.K == this.D.size()) goto L5;
    L8:
        this.K = this.D.size();
        this.L = r0;
        UpdateRecord r2 = this.E;
        if (r2 == null) goto L11;
        long r3 = r2.a;
    L12:
        this.M = r3;
        O2("fillDisplaySizeBoundaryCheck", "reason=" + r6 + ", request once for sourceSize=" + this.D.size() + ", displayBoundarySize=" + r0 + ", sourceVersion=" + this.M);
        T2(true);
        return;
    L11:
        r3 = Long.MIN_VALUE;
        goto L12
    L5:
        if (this.L != r0) goto L8;
        O2("fillDisplaySizeBoundaryCheckSkipped", "boundary check already requested, reason=".concat(r6));
    }

    public final void T2(boolean r3) {
        if (r3 == false) goto L4;
    L7:
        O2("loadMoreConversation", "ignoreCanLoadMore=" + r3);
        this.z.a(r3);
        return;
    L4:
        if (this.H == true) goto L7;
        O2("loadMoreConversationSkipped", "canLoadMore is false");
    }

    public final void U2(String r3) {
        this.I = false;
        this.J = Long.MIN_VALUE;
        O2("stopFillingDisplaySize", "reason=".concat(r3));
    }

    public final void Y7(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        if ((r2 instanceof FeedSidebarCommonViewHolder) == false) goto L5;
        FeedSidebarCommonViewHolder r3 = (FeedSidebarCommonViewHolder) r2;
    L6:
        if (r3 == null) goto L11;
        h r4 = r3.k;
        if (r4 == null) goto L12;
        r4.c();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Object getItem(int r1) {
        return G2(r1);
    }

    public final long getItemId(int r3) {
        if (this.G == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        com.ss.android.lark.flow.feed.utils.b.a("getItemId returns load more id, position=" + r3);
        return 9223372036854775707L;
    L12:
        return super.getItemId(r3);
    L5:
        if (r3 != ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L7;
        r0 = true;
        goto L8
    }

    public final int getItemViewType(int r3) {
        if (this.G == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        com.ss.android.lark.flow.feed.utils.b.a("getItemViewType returns load more type, position=" + r3);
        return 2147483547;
    L12:
        return super.getItemViewType(r3);
    L5:
        if (r3 != ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L7;
        r0 = true;
        goto L8
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener((FeedSidebarAdapter$mOnScrollListener$2.AnonymousClass1) this.P.getValue());
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.a(r2);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener((FeedSidebarAdapter$mOnScrollListener$2.AnonymousClass1) this.P.getValue());
        FeedCallbackExecutor.a.getClass();
        FeedCallbackExecutor.b();
    }

    public void update(UpdateRecord r8) {
        Intrinsics.checkNotNullParameter(r8, "boxData");
        int r1 = 0;
        if (this.y.d == true) goto L9;
        StringBuilder r0 = new StringBuilder("update pass through, paging is disabled, sourceSize=");
        List r2 = r8.b;
        if (r2 == null) goto L7;
        r1 = ((ArrayList) r2).size();
    L7:
        r0.append(r1);
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapter", r0.toString());
        super.update(r8);
        P2(((LarkRecyclerViewBaseAdapter) this).items);
        return;
    L9:
        List<? extends UIFeedCard> r3 = r8.b;
        if (r3 != null) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        long r4 = r8.a;
        if (this.I == false) goto L15;
    L18:
        boolean r5 = true;
    L20:
        if (r3.isEmpty() == true) goto L22;
    L25:
        if (r1 == 0) goto L27;
        O2("updateSourceSkipped", "transient empty source, recordVersion=" + r4 + ", oldSourceSize=" + this.D.size());
    L27:
        if (r1 == 0) goto L29;
        return;
    L29:
        this.E = r8;
        this.D = r3;
        long r6 = r8.a;
        int r7 = this.K;
        if (r7 >= 0) goto L33;
    L38:
        O2("updateSource", "recordVersion=" + r8.a);
        L2();
        if (this.A != 0) goto L41;
        K2(r8);
        return;
    L41:
        this.F = r8;
        O2("updateDeferred", "scrollState=" + this.A);
        return;
    L33:
        if (r6 == this.M) goto L38;
        if (r7 < 0) goto L38;
        this.N = r3.size();
        this.O = this.L;
        this.K = -1;
        this.L = -1;
        this.M = Long.MIN_VALUE;
        O2("fillDisplaySizeBoundaryCheckCompleted", "reason=source version changed");
        goto L38
    L22:
        if ((!this.D.isEmpty()) == false) goto L25;
        if (r5 == false) goto L25;
        r1 = 1;
        goto L25
    L15:
        if (this.K >= 0) goto L18;
        r5 = false;
        goto L20
    }

    public final void O2(String r4, String r5) {
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r6 = "";
    L9:
        StringBuilder r1 = new StringBuilder("paging action=");
        r1.append(r4);
        r1.append(", scrollState=");
        r1.append(this.A);
        r1.append(", displaySize=");
        r1.append(this.B);
        r1.append(", firstPageLoadMoreSize=");
        r1.append(RangesKt.coerceAtLeast(this.y.e, 1));
        r1.append(", nextPageLoadMoreSize=");
        r1.append(RangesKt.coerceAtLeast(this.y.h, 1));
        r1.append(", hasLoadedMoreAfterDisplaySizeReset=");
        r1.append(this.C);
        r1.append(", sourceSize=");
        r1.append(this.D.size());
        r1.append(", latestSourceSize=");
        UpdateRecord r7 = this.E;
        int r2 = -1;
        if (r7 == null) goto L14;
        List r8 = r7.b;
        if (r8 == null) goto L14;
        int r9 = ((ArrayList) r8).size();
    L15:
        r1.append(r9);
        r1.append(", pendingSourceSize=");
        UpdateRecord r10 = this.F;
        if (r10 == null) goto L20;
        List r11 = r10.b;
        if (r11 == null) goto L20;
        r2 = ((ArrayList) r11).size();
    L20:
        r1.append(r2);
        r1.append(", showLoadMore=");
        r1.append(this.G);
        r1.append(", canLoadMore=");
        r1.append(this.H);
        r1.append(", isFilling=");
        r1.append(this.I);
        r1.append(", lastLoadMoreComparedVersion=");
        r1.append(this.J);
        r1.append(", boundaryLoadRequestedSourceSize=");
        r1.append(this.K);
        r1.append(", boundaryLoadRequestedDisplayBoundarySize=");
        r1.append(this.L);
        r1.append(", boundaryLoadRequestedSourceVersion=");
        r1.append(this.M);
        r1.append(", boundaryLoadCheckedSourceSize=");
        r1.append(this.N);
        r1.append(", boundaryLoadCheckedDisplayBoundarySize=");
        r1.append(this.O);
        r1.append(r6);
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarAdapter", r1.toString());
        return;
    L14:
        r9 = -1;
        goto L15
    L8:
        r6 = ", ".concat(r5);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        if ((r5 instanceof FeedSidebarLoadMoreViewHolder) == false) goto L6;
        O2("onBindLoadMoreViewHolder", "position=" + r6);
        ((FeedSidebarLoadMoreViewHolder) r5).a.setText(2131890025);
        com.ss.android.lark.flow.feed.utils.b.d("FeedSidebarLoadMoreViewHolder", "bind");
        return;
    L6:
        UIFeedCard r0 = G2(r6);
        if (r0 != null) goto L10;
        com.ss.android.lark.flow.feed.utils.b.b("FeedSidebarAdapter", "bind view holder, get item is empty at position " + r6);
        return;
    L10:
        r0.setDataObserver(((FeedListAdapter) this).c);
        FeedListAdapter.g r2 = ((FeedListAdapter) this).m;
        if (r2 == null) goto L14;
        r2.a(r6, r0);
    L14:
        if ((r5 instanceof FeedSidebarCommonViewHolder) == false) goto L21;
        FeedSidebarCommonViewHolder r7 = (FeedSidebarCommonViewHolder) r5;
        e r8 = (e) this.w.a(r7.m, r7.n);
        if (r7.k == null) goto L19;
        if (r8 == null) goto L19;
        r7.l = r8.c(this.x);
        r7.V3(r0, ((FeedListAdapter) this).p, this, this.x);
        r7.U3(r0, ((FeedListAdapter) this).k, this, this.x);
        return;
    L19:
        com.ss.android.lark.flow.feed.utils.b.b("FeedSidebarAdapter", "FeedSidebarCommonViewHolder bindView error! cell or factory is null");
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 == 2147483547) goto L5;
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131561594, r6, false);
        AppFeedCardType r0 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        if (r7 < 2000) goto L9;
        r0 = AppFeedCardType.fromValue(r7 - 2000);
        FeedCard.Type r9 = FeedCard.Type.APP_FEED;
    L10:
        h r1 = null;
        if (r9 == null) goto L13;
        e r2 = (e) this.w.a(r9, r0);
    L14:
        if (r2 == null) goto L16;
        Intrinsics.checkNotNull(r8);
        r1 = r2.b(r8);
    L16:
        Intrinsics.checkNotNull(r8);
        FeedSidebarCommonViewHolder r3 = new FeedSidebarCommonViewHolder(r8, this.x, this.y);
        r3.X3(r1);
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r3.m = r9;
    L19:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r3.n = r0;
        return r3;
    L13:
        r2 = null;
        goto L14
    L9:
        r9 = FeedCard.Type.forNumber(r7 - 1000);
        goto L10
    L5:
        return new FeedSidebarLoadMoreViewHolder(LayoutInflater.from(r6.getContext()).inflate(2131561595, r6, false), this.y, new AnonymousClass1(this));
    }

    public FeedSidebarAdapter(reb.a r2, FeedSidebarAdapterWrapper$feedCardContext$2.a r3, iza.e r4, FeedSidebarAdapterWrapper$feedAdapter$2.a r5) {
        Intrinsics.checkNotNullParameter(r2, "feedCardFactoryWrapper");
        Intrinsics.checkNotNullParameter(r3, "feedCardContext");
        Intrinsics.checkNotNullParameter(r4, "sidebarItemConfig");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        super(r2, r3, null);
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
        this.B = RangesKt.coerceAtLeast(r4.e, 1);
        this.D = CollectionsKt.emptyList();
        this.H = true;
        this.J = Long.MIN_VALUE;
        this.K = -1;
        this.L = -1;
        this.M = Long.MIN_VALUE;
        this.N = -1;
        this.O = -1;
        this.P = LazyKt.lazy(new FeedSidebarAdapter$mOnScrollListener$2(this));
    }
}
