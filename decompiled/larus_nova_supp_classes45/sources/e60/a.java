package e60;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.builder.DataBuilder;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a<T> implements Listing<T> {
    public final LiveData<PagedList<T>> a;
    public final MutableLiveData<NetworkStat> b;
    public final MutableLiveData<NetworkStat> c;
    public final MutableLiveData<NetworkStat> d;
    public final MutableLiveData<Boolean> e;
    public final PublishSubject<Object> f;
    public final PublishSubject<Object> g;
    public final PublishSubject<Object> h;
    public final MutableLiveData<Integer> i;
    public final MutableLiveData<Boolean> j;
    public final PublishSubject<Pair<String, String>> k;

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void refresh() {
        this.f.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void retry() {
        this.g.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public int size() {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void update() {
        this.h.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getNetworkStat() {
        return this.b;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<PagedList<T>> getPageList() {
        return this.a;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getRefreshStat() {
        return this.c;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final PublishSubject<Pair<String, String>> getReqFrom() {
        return this.k;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getUpdateStat() {
        return this.d;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Boolean> hasMore() {
        return this.j;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Boolean> isEmpty() {
        return this.e;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Integer> updateAdapterItemEvent() {
        return this.i;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public T find(j<T> r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public T get(int r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public int indexOf(T r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void remove(int r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void updateAdapterItem(int r2) {
        this.i.setValue(Integer.valueOf(r2));
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void remove(T r2) {
        throw new RuntimeException("unsupported operation");
    }

    public a(DataBuilder<T> r2, LiveData<PagedList<T>> r3) {
        this.k = PublishSubject.create();
        this.b = r2.networkState();
        this.c = r2.refreshState();
        this.d = r2.updateState();
        this.j = r2.hasMore();
        this.f = r2.refresh();
        this.g = r2.retry();
        this.h = r2.update();
        this.a = r3;
        this.e = r2.empty();
        this.i = r2.updateAdapterItem();
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void add(int r1, T r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void put(int r1, T r2) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void setReqFrom(String r3, String r4) {
        this.k.onNext(new Pair(r3, r4));
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void add(int r1, List<T> r2) {
        throw new RuntimeException("unsupported operation");
    }
}
