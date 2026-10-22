package com.ss.android.lark.feed.shared.page.listener;

import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mFeedItemProvider", "Lcom/ss/android/lark/feed/shared/page/experiment/utils/FeedItemListUtils$IFeedItemProvider;", "mOnScrollListener", "Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener$OnScrollListener;", "<init>", "(Landroidx/recyclerview/widget/LinearLayoutManager;Lcom/ss/android/lark/feed/shared/page/experiment/utils/FeedItemListUtils$IFeedItemProvider;Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener$OnScrollListener;)V", "mLastVisibleFirstEndPosition", "Lkotlin/Pair;", "Ljava/util/concurrent/atomic/AtomicInteger;", "mLastPreloadFirstEndPosition", "mLastVelocityY", BuildConfig.FLAVOR, "mStart", BuildConfig.FLAVOR, "mLastPreloadStart", "setVelocity", BuildConfig.FLAVOR, "velocityX", "velocityY", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "getCurrentPageShowedItems", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "layoutManager", "Companion", "OnScrollListener", "ItemSource", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedItemScrollListener extends RecyclerView.OnScrollListener {
    public final LinearLayoutManager a;
    public final xeb.a.InterfaceC0320a b;
    public final b c;
    public final Pair<? extends AtomicInteger, ? extends AtomicInteger> d;
    public final Pair<? extends AtomicInteger, ? extends AtomicInteger> e;
    public int f;
    public long g;
    public long h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/listener/FeedItemScrollListener$ItemSource;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PREDICT", "SHOWN", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ItemSource extends Enum<ItemSource> {
        public static final ItemSource PREDICT = null;
        public static final ItemSource SHOWN = null;
        public static final /* synthetic */ ItemSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ItemSource> getEntries() {
            return b;
        }

        static {
            ItemSource r0 = new ItemSource("PREDICT", 0);
            PREDICT = r0;
            ItemSource r1 = new ItemSource("SHOWN", 1);
            SHOWN = r1;
            ItemSource[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ItemSource[] values() {
            return (ItemSource[]) a.clone();
        }

        public static ItemSource valueOf(String r1) {
            return (ItemSource) r27.a.a(ItemSource.class, r1);
        }

        public ItemSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void C(RecyclerView r1, int r2);

        void a(List r1, ItemSource r2);

        void b(RecyclerView r1);
    }

    static {
    }

    public final void onScrollStateChanged(RecyclerView r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        super.onScrollStateChanged(r12, r13);
        Log.d("FeedItemScrollListener", "onScrollStateChanged, state = " + r13);
        if (r13 != 0) goto L5;
        Log.i("FeedItemScrollListener", "onItemsShowed, after preload interval = " + (SystemClock.elapsedRealtime() - this.g) + ", fist = " + this.a.findFirstVisibleItemPosition() + ", last = " + this.a.findLastVisibleItemPosition());
        LinearLayoutManager r0 = this.a;
        List<UIFeedCard> r1 = xeb.a.d(r0.findFirstVisibleItemPosition(), r0.findLastVisibleItemPosition(), (AtomicInteger) this.d.getFirst(), (AtomicInteger) this.d.getSecond(), this.b);
        xeb.a.e(xeb.a.c(r1));
        if (r1 == null) goto L32;
        b r2 = this.c;
        if (r2 == null) goto L32;
        r2.a(r1, ItemSource.SHOWN);
    L32:
        b r3 = this.c;
        if (r3 == null) goto L36;
        r3.C(r12, r13);
        return;
    L36:
        return;
    L5:
        if (r13 != 1) goto L7;
        this.g = SystemClock.elapsedRealtime();
        goto L32
    L7:
        if (r13 != 2) goto L32;
        r12.computeVerticalScrollOffset();
        this.g = SystemClock.elapsedRealtime();
        int r4 = this.a.findFirstVisibleItemPosition();
        int r5 = this.a.findLastVisibleItemPosition();
        View r6 = this.a.getChildAt(0);
        if (r6 == null) goto L12;
        Integer r7 = Integer.valueOf(r6.getHeight());
    L13:
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
        if (r8 <= 0) goto L17;
        int r9 = (int) ((((double) this.f) * 0.44d) / ((double) r8));
    L18:
        Log.d("FeedItemScrollListener", "onScrollStateChanged:" + r9 + ", childHeight=" + r7 + ", velocityY=" + this.f);
        int r10 = Math.max((r4 + r9) + (-3), 0);
        int r11 = Math.max((r5 + r9) + 3, 10);
        List<UIFeedCard> r14 = xeb.a.d(r10, r11, (AtomicInteger) this.e.getFirst(), (AtomicInteger) this.e.getSecond(), this.b);
        if (r14 == null) goto L32;
        if ((SystemClock.elapsedRealtime() - this.h) <= 300) goto L32;
        b r15 = this.c;
        if (r15 == null) goto L25;
        r15.a(r14, ItemSource.PREDICT);
    L25:
        Log.i("FeedItemScrollListener", "onItemPreload, interval = " + (SystemClock.elapsedRealtime() - this.h) + ", changed position, first = " + r10 + ", last = " + r11 + ", childHeight = " + r7);
        this.h = this.g;
    L17:
        r9 = 0;
        goto L18
    L12:
        r7 = null;
        goto L13
    }

    public FeedItemScrollListener(StableLinearLayoutManager r2, xeb.a.InterfaceC0320a r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "mLayoutManager");
        Intrinsics.checkNotNullParameter(r3, "mFeedItemProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new Pair(new AtomicInteger(0), new AtomicInteger(0));
        this.e = new Pair(new AtomicInteger(0), new AtomicInteger(0));
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        b r4 = this.c;
        if (r4 == null) goto L6;
        r4.b(r1);
        return;
    }
}
