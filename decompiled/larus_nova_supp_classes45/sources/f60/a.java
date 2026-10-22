package f60;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.builder.DataBuilder;
import com.bytedance.android.live.core.paging.builder.DefaultBoundaryCallback;
import com.bytedance.android.live.core.paging.datasource.DefaultRxCacheDataSource;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import e60.b;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<CacheKey, V> implements DataBuilder<V> {
    public static final PagedList.Config s = null;
    public MutableLiveData<NetworkStat> a;
    public MutableLiveData<NetworkStat> b;
    public final MutableLiveData<NetworkStat> c;
    public MutableLiveData<Boolean> d;
    public final MutableLiveData<Boolean> e;
    public PublishSubject<Object> f;
    public PublishSubject<Object> g;
    public final PublishSubject<Object> h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile boolean k;
    public final MutableLiveData<Integer> l;
    public final AtomicLong m;
    public CacheKey n;
    public com.bytedance.android.live.core.cache.a<CacheKey, V> o;
    public Cache<CacheKey, FeedExtra> p;
    public PagedList.Config q;
    public PagingLoadCallback<V> r;

    /* JADX INFO: renamed from: f60.a$a, reason: collision with other inner class name */
    public class C0232a extends DataSource.Factory<Long, V> {
        public final /* synthetic */ a a;

        public final DataSource<Long, V> create() {
            return new DefaultRxCacheDataSource(this.a);
        }

        public C0232a(a r1) {
            this.a = r1;
        }
    }

    static {
        s = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(12).setPrefetchDistance(12).build();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final Listing<V> build() {
        C0232a r0 = new C0232a(this);
        DefaultBoundaryCallback r1 = new DefaultBoundaryCallback(this.d, this.e);
        return new b(this, new LivePagedListBuilder(r0, this.q).setBoundaryCallback(r1).build());
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final long getGeneration() {
        return this.m.get();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final long makeGeneration() {
        return this.m.incrementAndGet();
    }

    public a() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
        this.f = PublishSubject.create();
        this.g = PublishSubject.create();
        this.h = PublishSubject.create();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = new MutableLiveData();
        this.m = new AtomicLong(0);
        this.q = s;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PagingLoadCallback<V> callback() {
        return this.r;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Boolean> empty() {
        return this.e;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Boolean> hasMore() {
        return this.d;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean hasRefreshFlag() {
        return this.j;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean hasUpdateFlag() {
        return this.k;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> networkState() {
        return this.a;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PublishSubject<Object> refresh() {
        return this.f;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> refreshState() {
        return this.b;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean refreshing() {
        return this.i;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PublishSubject<Object> retry() {
        return this.g;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> update() {
        return this.h;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Integer> updateAdapterItem() {
        return this.l;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> updateState() {
        return this.c;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final Listing<V> build(LiveData<PagedList<V>> r2) {
        return new b(this, r2);
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setRefreshFlag(boolean r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setRefreshing(boolean r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setUpdateFlag(boolean r1) {
        this.k = r1;
    }
}
