package com.bytedance.android.livesdk.feed.repository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.cache.a;
import com.bytedance.android.live.core.cache.i;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.feed.ApiCallBack;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.b;
import com.bytedance.android.livesdk.feed.z0;
import com.bytedance.common.utility.NetworkUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseFeedRepository implements ItemRepository<FeedItem>, ApiCallBack {
    public final f a;
    public final CompositeDisposable b;
    public final a<FeedDataKey, FeedItem> c;
    public final PublishSubject<ApiDataStatus> d;
    public final PublishSubject<ApiDataStatus> e;
    public z0 f;

    public static final enum ApiDataStatus extends Enum<ApiDataStatus> {
        public static final ApiDataStatus FAIL = null;
        public static final ApiDataStatus START = null;
        public static final ApiDataStatus SUCCESS = null;
        public static final /* synthetic */ ApiDataStatus[] a = null;

        static {
            ApiDataStatus r0 = new ApiDataStatus("START", 0);
            START = r0;
            ApiDataStatus r1 = new ApiDataStatus("SUCCESS", 1);
            SUCCESS = r1;
            ApiDataStatus r3 = new ApiDataStatus("FAIL", 2);
            FAIL = r3;
            a = new ApiDataStatus[]{r0, r1, r3};
        }

        public static ApiDataStatus[] values() {
            return (ApiDataStatus[]) a.clone();
        }

        public static ApiDataStatus valueOf(String r1) {
            return (ApiDataStatus) r27.a.a(ApiDataStatus.class, r1);
        }

        public ApiDataStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public abstract FeedDataKey d();

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public Listing<FeedItem> pc() {
        return null;
    }

    public abstract com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, b> query();

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public void update(String r1) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unRegisterFeedRepository() {
        if (this.a.h(d(), this) == false) goto L6;
        clear();
        this.b.clear();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void registerFeedRepository() {
        if (d() != null) goto L5;
        return;
    L5:
        this.a.g(d(), this);
    }

    public final void b(ApiCallBack.ApiType r2) {
        z0 r0 = new z0();
        this.f = r0;
        r0.l();
        if (r2 != ApiCallBack.ApiType.REFRESH) goto L6;
        this.d.onNext(ApiDataStatus.START);
        return;
    L6:
        if (r2 != ApiCallBack.ApiType.LOAD_MORE) goto L12;
        this.e.onNext(ApiDataStatus.START);
        z0 r3 = this.f;
        if (r3 == null) goto L13;
        r3.l();
        return;
    L13:
        return;
    }

    public final void c(ApiCallBack.ApiType r4) {
        if (r4 != ApiCallBack.ApiType.REFRESH) goto L8;
        this.d.onNext(ApiDataStatus.SUCCESS);
        z0 r5 = this.f;
        if (r5 == null) goto L13;
        r5.n(z0.d, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L13:
        return;
    L8:
        if (r4 != ApiCallBack.ApiType.LOAD_MORE) goto L15;
        this.e.onNext(ApiDataStatus.SUCCESS);
        z0 r6 = this.f;
        if (r6 == null) goto L16;
        r6.n(z0.e, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L16:
        return;
    }

    public final void vK(LifecycleOwner r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.getLifecycle().addObserver(this);
    }

    public BaseFeedRepository(f r2, i r3) {
        this.b = new CompositeDisposable();
        this.d = PublishSubject.create();
        this.e = PublishSubject.create();
        this.a = r2;
        this.c = r3;
    }

    public final void a(ApiCallBack.ApiType r4, Throwable r5) {
        if (r4 != ApiCallBack.ApiType.REFRESH) goto L10;
        this.d.onNext(ApiDataStatus.FAIL);
        if (this.f != null) goto L7;
        return;
    L7:
        if (NetworkUtils.isNetworkAvailable(TTMiddlewareLiveSDK.getContext()) == false) goto L18;
        z0 r6 = this.f;
        String r0 = z0.d;
        r6.getClass();
        r6.m(r5, r0, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L18:
        return;
    L10:
        if (r4 != ApiCallBack.ApiType.LOAD_MORE) goto L20;
        this.e.onNext(ApiDataStatus.FAIL);
        if (this.f != null) goto L14;
        return;
    L14:
        if (NetworkUtils.isNetworkAvailable(TTMiddlewareLiveSDK.getContext()) == false) goto L22;
        z0 r7 = this.f;
        String r1 = z0.e;
        r7.getClass();
        r7.m(r5, r1, BaseFeedMonitor.Scene.SERVICE_SCENE_DRAWER, BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_NONE);
        return;
    L22:
        return;
    }
}
