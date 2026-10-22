package com.bytedance.android.live.core.paging.datasource;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.cache.a;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.common.utility.Lists;
import g60.c;
import g60.d;
import g60.e;
import g60.f;
import g60.g;
import g60.h;
import g60.i;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class RxCacheDataSource<DataKey, V, CacheKey> extends PageKeyedDataSource<DataKey, V> implements DataSource.InvalidatedCallback {
    public final CacheKey a;
    public final a<CacheKey, V> b;
    public final Cache<CacheKey, FeedExtra> c;
    public final MutableLiveData<NetworkStat> d;
    public final MutableLiveData<NetworkStat> e;
    public final MutableLiveData<NetworkStat> f;
    public final MutableLiveData<Boolean> g;
    public final MutableLiveData<Boolean> h;
    public final f60.a<CacheKey, V> i;
    public final long j;
    public Runnable k;
    public final CompositeDisposable l;

    public abstract Observable<Pair<List<V>, FeedExtra>> e(boolean r1, DataKey r2, int r3);

    public abstract DataKey h(FeedExtra r1);

    public final void loadBefore(PageKeyedDataSource.LoadParams<DataKey> r1, PageKeyedDataSource.LoadCallback<DataKey, V> r2) {
    }

    public final boolean g() {
        f60.a<CacheKey, V> r0 = this.i;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.j != this.i.getGeneration()) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public final void onInvalidated() {
        this.l.clear();
        removeInvalidatedCallback(this);
    }

    public RxCacheDataSource(final f60.a<CacheKey, V> r6) {
        CompositeDisposable r0 = new CompositeDisposable();
        this.l = r0;
        this.a = r6.n;
        this.b = r6.o;
        this.c = r6.p;
        this.e = r6.b;
        this.d = r6.a;
        this.f = r6.c;
        this.g = r6.d;
        this.h = r6.e;
        this.i = r6;
        this.j = r6.makeGeneration();
        final DefaultRxCacheDataSource r3 = (DefaultRxCacheDataSource) this;
        r0.add(r6.g.subscribe(new g60.a(r3), new c()));
        r0.add(r6.f.observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r3, r6), new c()));
        r0.add(r6.update().subscribe(new e(r3, r6)));
        addInvalidatedCallback(this);
    }

    public final List<V> i(List<V> r3, FeedExtra r4) {
        this.c.put(this.a, r4);
        return this.b.d(this.a, new ArrayList(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadAfter(final PageKeyedDataSource.LoadParams<DataKey> r4, final PageKeyedDataSource.LoadCallback<DataKey, V> r5) {
        if (this.i.i == false) goto L5;
        return;
    L5:
        this.d.postValue(NetworkStat.LOADING);
        this.k = null;
        Disposable r6 = e(false, r4.key, r4.requestedLoadSize).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r5), new g(this, r4, r5));
        this.l.add(r6);
    }

    public final void loadInitial(PageKeyedDataSource.LoadInitialParams<DataKey> r8, PageKeyedDataSource.LoadInitialCallback<DataKey, V> r9) {
        if (g() == true) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (this.i.j == false) goto L8;
        this.i.j = false;
        this.i.i = true;
    L8:
        boolean r0 = this.i.k;
        if (r0 == false) goto L11;
        this.f.postValue(NetworkStat.LOADING);
    L12:
        this.d.postValue(NetworkStat.LOADING);
        this.g.postValue(Boolean.TRUE);
        this.k = null;
        List<V> r4 = this.b.get(this.a);
        if (Lists.isEmpty(r4) == true) goto L26;
        FeedExtra r5 = this.c.get(this.a);
        r9.onResult(new ArrayList(r4), null, h(r5));
        if (this.i.i == false) goto L17;
        f(e(true, null, r8.requestedLoadSize), r8, r9);
    L27:
        if (r0 == false) goto L30;
        this.i.k = false;
        return;
    L30:
        return;
    L17:
        this.h.postValue(Boolean.FALSE);
        MutableLiveData<Boolean> r11 = this.g;
        if (h(r5) != null) goto L21;
        r2 = false;
    L21:
        r11.postValue(Boolean.valueOf(r2));
        if (r0 == false) goto L24;
        this.f.postValue(NetworkStat.LOADED);
    L25:
        this.d.postValue(NetworkStat.LOADED);
        goto L27
    L24:
        this.e.postValue(NetworkStat.LOADED);
        goto L25
    L26:
        f(e(true, null, r8.requestedLoadSize), r8, r9);
        goto L27
    L11:
        this.e.postValue(NetworkStat.LOADING);
        goto L12
    }

    public final void f(Observable<Pair<List<V>, FeedExtra>> r3, final PageKeyedDataSource.LoadInitialParams<DataKey> r4, final PageKeyedDataSource.LoadInitialCallback<DataKey, V> r5) {
        if (r3 != null) goto L5;
        MutableLiveData<NetworkStat> r6 = this.e;
        NetworkStat r7 = NetworkStat.LOADED;
        r6.postValue(r7);
        this.d.postValue(r7);
        return;
    L5:
        Disposable r8 = r3.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r5), new i(this, r4, r5));
        this.l.add(r8);
    }
}
