package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.feed.openui.adapter.HorizontalListAdapter;
import com.bytedance.android.livesdk.feed.openui.vm.RoomListViewModel;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomIntentBuilder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/HorizontalLiveListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdkapi/feed/ui/ILiveBlock;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "a", "I", "getDefaultBg", "()I", "defaultBg", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/bytedance/android/livesdk/feed/openui/vm/RoomListViewModel;", "g", "getFeedViewModel", "()Lcom/bytedance/android/livesdk/feed/openui/vm/RoomListViewModel;", "feedViewModel", "Lcom/bytedance/android/livesdk/feed/openui/adapter/HorizontalListAdapter;", "i", "getAdapter", "()Lcom/bytedance/android/livesdk/feed/openui/adapter/HorizontalListAdapter;", "adapter", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class HorizontalLiveListView extends FrameLayout implements LifecycleOwnerCompat, ILiveBlock {
    public final int a;
    public final Lazy b;
    public Disposable c;
    public final List<Room> d;
    public final String e;
    public final String f;
    public final Lazy g;
    public final MutableLiveData<Boolean> h;
    public final Lazy i;
    public final MutableLiveData<Boolean> j;
    public final b k;
    public final MutableLiveData<Integer> l;
    public final HorFollowListParams m;
    public HashMap n;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ HorizontalLiveListView a;

        public a(HorizontalLiveListView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "motionEvent");
            if (r5.getAction() != 0) goto L5;
        L10:
            this.a.a(2131384076).getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        L5:
            if (r5.getAction() == 2) goto L10;
            if (r5.getAction() == 1) goto L10;
            this.a.a(2131384076).getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ HorizontalLiveListView a;

        public b(HorizontalLiveListView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<Boolean> r0 = this.a.j;
            r0.postValue((Boolean) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ HorizontalLiveListView a;

        public c(HorizontalLiveListView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            NetworkStat r6 = (NetworkStat) r5;
            NetworkStat.Status r0 = null;
            if (r6 == null) goto L5;
            NetworkStat.Status r1 = r6.mStatus;
        L6:
            int r3 = 0;
            if (r1 != NetworkStat.Status.FAILED) goto L11;
            this.a.h.postValue(Boolean.TRUE);
            if (this.a.m.getSupportStatusView() == false) goto L12;
            f2.b(2131916600, 0);
        L12:
            if (r6 == null) goto L15;
            r0 = r6.mStatus;
        L15:
            if (r0 != NetworkStat.Status.SUCCESS) goto L21;
            HorizontalLiveListView r7 = this.a;
            MutableLiveData<Integer> r2 = r7.l;
            Listing r8 = HorizontalLiveListView.c(r7).listing();
            if (r8 == null) goto L19;
            r3 = r8.size();
        L19:
            r2.postValue(Integer.valueOf(r3));
            return;
        L21:
            return;
        L11:
            this.a.h.postValue(Boolean.FALSE);
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    private final HorizontalListAdapter getAdapter() {
        return (HorizontalListAdapter) this.i.getValue();
    }

    private final RoomListViewModel getFeedViewModel() {
        return (RoomListViewModel) this.g.getValue();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.b.getValue();
    }

    public final View a(int r3) {
        if (this.n != null) goto L5;
        this.n = new HashMap();
    L5:
        View r4 = (View) this.n.get(2131384076);
        if (r4 != null) goto L9;
        View r5 = findViewById(2131384076);
        this.n.put(2131384076, r5);
        return r5;
    L9:
        return r4;
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().markState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().markState(Lifecycle.State.DESTROYED);
        Disposable r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.c;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final void refresh() {
        if (Intrinsics.areEqual((Boolean) getFeedViewModel().isDataEmpty().getValue(), Boolean.FALSE) == false) goto L6;
        getFeedViewModel().refresh();
        return;
    L6:
        String r0 = com.bytedance.android.live.core.feed.d.a(this.e, this.f);
        String r1 = this.e + '-' + this.f;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("content_type", 1);
        getFeedViewModel().fetch(r0, r1, r2);
        if (this.m.getFeedType() != FeedType.FOLLOW_FEED) goto L16;
        Disposable r3 = this.c;
        if (r3 != null) goto L11;
    L15:
        this.c = Observable.just(1).delay(300000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.feed.openui.view.c(this));
        goto L16
    L11:
        if (r3.isDisposed() == true) goto L15;
        Disposable r4 = this.c;
        if (r4 == null) goto L15;
        r4.dispose();
    L16:
        getFeedViewModel().networkStat().observe(this, new c(this));
        getFeedViewModel().listing().isEmpty().removeObserver(this.k);
        getFeedViewModel().listing().isEmpty().observeForever(this.k);
    }

    public final int getDefaultBg() {
        return this.a;
    }

    public final LiveData<Boolean> isEmpty() {
        return this.j;
    }

    public final LiveData<Boolean> isError() {
        return this.h;
    }

    public static final /* synthetic */ RoomListViewModel c(HorizontalLiveListView r0) {
        return r0.getFeedViewModel();
    }

    public static final void b(HorizontalLiveListView r6, Room r7) {
        r6.getClass();
        Bundle r0 = new Bundle();
        r0.putString("log_pb", r7.getLog_pb());
        r0.putString("request_id", r7.getRequestId());
        r0.putString("enter_from_merge", r6.e);
        r0.putString("enter_method", r6.f);
        r0.putString("anchor_id", r7.getOwnerUserIdString());
        String r1 = (String) LiveConfigSettingKeys.LIVE_FEED_TOP_PORTRAINT_CLICK.getValue();
        if (r1 != null) goto L5;
        r1 = "https://webcast-open.douyin.com/webcast/openapi/feed/?channel_id=160007&hidden_banner=1&content_type=1";
    L5:
        r0.putString("live.intent.extra.EXTRA_LIVE_FEED_URL_NEW", r1);
        Bundle r2 = LiveRoomIntentBuilder.buildBundle(r6.getContext(), r7, "homepage_hot", r0);
        if (r2 != null) goto L8;
        return;
    L8:
        if (TTLiveSDK.hostService() != null) goto L10;
        return;
    L10:
        if (TTLiveSDK.hostService().action() == null) goto L42;
        r2.putAll(ArgumentsBuilder.buildRoomArgs(r7));
        if (r2.get("live.intent.extra.USER_ID") != null) goto L15;
        r2.putString("live.intent.extra.USER_ID", r7.getOwnerUserIdString());
    L15:
        if (r6.m.getFeedType() != FeedType.FOLLOW_FEED) goto L31;
        Listing r3 = r6.getFeedViewModel().listing();
        int r4 = 0;
        if (r3 == null) goto L19;
        int r5 = r3.size();
    L20:
        ((ArrayList) r6.d).clear();
    L21:
        if (r4 >= r5) goto L26;
        Room r8 = (Room) r6.getFeedViewModel().get(r4);
        if (r8 == null) goto L25;
        ((ArrayList) r6.d).add(r8);
    L25:
        r4 = r4 + 1;
        goto L21
    L26:
        List<Room> r9 = r6.d;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = ((ArrayList) r9).iterator();
    L28:
        if (r11.hasNext() == false) goto L30;
        r10.add(Long.valueOf(((Room) r11.next()).id));
        goto L28
    L30:
        r2.putLongArray("live.intent.extra.ENTER_ROOM_IDS", CollectionsKt.toLongArray(r10));
        r2.putBoolean("live.intent.extra.FORCE_NO_RECOMMEND_DRAW", true);
        goto L31
    L19:
        r5 = 0;
    L31:
        int r12 = kw1.c.a;
        kw1.c.b(r6.getContext(), r0);
        nn2.a r13 = nn2.a.d;
        if (nn2.a.a.a().b(r7.id) == false) goto L34;
        r2.putString("source", "ad_union");
        r2.putString("ad_data_params", r7.adRawString);
    L34:
        TTLiveSDK.hostService().action().startLive(r6.getContext(), r7.id, r2);
        return;
    }

    public HorizontalLiveListView(HorFollowListParams r3, Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "feedParams");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.m = r3;
        this.a = -1;
        this.b = LazyKt.lazy(new HorizontalLiveListView$lifecycleRegistry$2(this));
        this.d = new ArrayList();
        this.e = "homepage_follow";
        this.f = "top_portrait";
        this.g = LazyKt.lazy(HorizontalLiveListView$feedViewModel$2.INSTANCE);
        this.h = new MutableLiveData();
        this.i = LazyKt.lazy(new HorizontalLiveListView$adapter$2(this));
        getLifecycleRegistry().markState(Lifecycle.State.CREATED);
        String r7 = r3.getEnterFromMerge();
        if (r7 != null) goto L5;
    L13:
        FrameLayout.inflate(r4, 2131566008, this);
        a(2131384076).setAdapter(getAdapter());
        a(2131384076).setLayoutManager(new LinearLayoutManager(r4, 0, false));
        a(2131384076).addItemDecoration(new FollowSkyItemDecoration());
        a(2131384076).setOnTouchListener(new a(this));
        getAdapter().setViewModel(getFeedViewModel());
        Integer r8 = r3.getBackgroundColor();
        if (r8 == null) goto L16;
        setBackgroundColor(r8.intValue());
    L16:
        this.j = new MutableLiveData();
        this.k = new b(this);
        this.l = new MutableLiveData();
        return;
    L5:
        if (r7.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r7 = null;
    L11:
        if (r7 == null) goto L13;
        this.e = r7;
        goto L13
    L7:
        r0 = false;
        goto L8
    }
}
