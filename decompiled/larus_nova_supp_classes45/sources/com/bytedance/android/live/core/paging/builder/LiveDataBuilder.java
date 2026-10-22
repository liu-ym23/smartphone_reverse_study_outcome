package com.bytedance.android.live.core.paging.builder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.f;
import com.bytedance.android.live.core.cache.n;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import f60.a;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveDataBuilder<V> implements DataBuilder<V> {
    private a<String, V> liveDataBuilder;

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public Listing<V> build() {
        a<String, V> r0 = this.liveDataBuilder;
        r0.n = "single.memory.list.cache.default.key";
        n r1 = new n();
        f r2 = new f();
        r0.o = r1;
        r0.p = r2;
        return r0.build();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PagingLoadCallback<V> callback() {
        return this.liveDataBuilder.r;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Boolean> empty() {
        return this.liveDataBuilder.e;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public long getGeneration() {
        return this.liveDataBuilder.getGeneration();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Boolean> hasMore() {
        return this.liveDataBuilder.d;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean hasRefreshFlag() {
        return this.liveDataBuilder.j;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean hasUpdateFlag() {
        return this.liveDataBuilder.k;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public long makeGeneration() {
        return this.liveDataBuilder.makeGeneration();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> networkState() {
        return this.liveDataBuilder.a;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> refresh() {
        return this.liveDataBuilder.f;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> refreshState() {
        return this.liveDataBuilder.b;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public boolean refreshing() {
        return this.liveDataBuilder.i;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> retry() {
        return this.liveDataBuilder.g;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> update() {
        return this.liveDataBuilder.update();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<Integer> updateAdapterItem() {
        return this.liveDataBuilder.l;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public MutableLiveData<NetworkStat> updateState() {
        return this.liveDataBuilder.c;
    }

    public LiveDataBuilder() {
        this.liveDataBuilder = new a();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public Listing<V> build(LiveData<PagedList<V>> r1) {
        return build();
    }

    public LiveDataBuilder<V> hasMore(MutableLiveData<Boolean> r2) {
        this.liveDataBuilder.d = r2;
        return this;
    }

    public LiveDataBuilder<V> loadMoreCallback(PagingLoadCallback<V> r2) {
        this.liveDataBuilder.r = r2;
        return this;
    }

    public LiveDataBuilder<V> networkStat(MutableLiveData<NetworkStat> r2) {
        this.liveDataBuilder.a = r2;
        return this;
    }

    public LiveDataBuilder<V> pageConfig(int r3) {
        a<String, V> r0 = this.liveDataBuilder;
        r0.getClass();
        r0.q = new PagedList.Config.Builder().setPageSize(r3).build();
        return this;
    }

    public LiveDataBuilder refresh(PublishSubject<Object> r2) {
        this.liveDataBuilder.f = r2;
        return this;
    }

    public LiveDataBuilder<V> refreshStat(MutableLiveData<NetworkStat> r2) {
        this.liveDataBuilder.b = r2;
        return this;
    }

    public LiveDataBuilder retry(PublishSubject<Object> r2) {
        this.liveDataBuilder.g = r2;
        return this;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setRefreshFlag(boolean r2) {
        this.liveDataBuilder.j = r2;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setRefreshing(boolean r2) {
        this.liveDataBuilder.i = r2;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public void setUpdateFlag(boolean r2) {
        this.liveDataBuilder.k = r2;
    }

    public LiveDataBuilder<V> pageConfig(PagedList.Config r2) {
        this.liveDataBuilder.q = r2;
        return this;
    }
}
