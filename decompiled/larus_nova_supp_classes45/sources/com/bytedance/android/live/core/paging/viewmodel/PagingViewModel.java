package com.bytedance.android.live.core.paging.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import h60.a;
import h60.b;
import h60.c;
import h60.d;
import h60.e;
import h60.f;
import h60.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PagingViewModel<T> extends RxViewModel {
    private final Observer<PagedList<T>> dataObserver;
    private MutableLiveData<Boolean> empty;
    private final Observer<Boolean> emptyObserver;
    private MutableLiveData<PagedList<T>> listData;
    private Listing<T> listing;
    private MutableLiveData<Boolean> more;
    private final Observer<Boolean> moreObserver;
    private final Observer<NetworkStat> networkObserver;
    private MutableLiveData<NetworkStat> networkState;
    private final Observer<NetworkStat> refreshObserver;
    private MutableLiveData<NetworkStat> refreshState;
    private MutableLiveData<Integer> updateAdapterItem;
    private final Observer<Integer> updateAdapterItemObserver;
    private final Observer<NetworkStat> updateObserver;
    private MutableLiveData<NetworkStat> updateState;

    public static /* synthetic */ void Mo(PagingViewModel r0, Boolean r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ void No(PagingViewModel r0, NetworkStat r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void Oo(PagingViewModel r0, NetworkStat r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void Po(PagingViewModel r0, NetworkStat r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void Qo(PagingViewModel r0, Integer r1) {
        r0.lambda$new$6(r1);
    }

    public static /* synthetic */ void So(PagingViewModel r0, Boolean r1) {
        r0.lambda$new$4(r1);
    }

    public static /* synthetic */ void yo(PagingViewModel r0, PagedList r1) {
        r0.lambda$new$3(r1);
    }

    public boolean refresh() {
        if (this.refreshState.getValue() != null) goto L5;
    L7:
        Listing<T> r0 = this.listing;
        if (r0 == null) goto L11;
        r0.refresh();
        return true;
    L11:
        return false;
    L5:
        if (((NetworkStat) this.refreshState.getValue()).isLoading() == false) goto L7;
        return false;
    }

    public void retry() {
        Listing<T> r0 = this.listing;
        if (r0 == null) goto L6;
        r0.retry();
        return;
    }

    public void setLiveDataEmpty() {
        this.listData.postValue(null);
    }

    public void update() {
        Listing<T> r0 = this.listing;
        if (r0 == null) goto L6;
        r0.update();
        return;
    }

    public PagingViewModel() {
        this.networkState = new MutableLiveData();
        this.refreshState = new MutableLiveData();
        this.updateState = new MutableLiveData();
        this.empty = new MutableLiveData();
        this.more = new MutableLiveData();
        this.updateAdapterItem = new MutableLiveData();
        this.listData = new MutableLiveData();
        this.networkObserver = new a(this);
        this.refreshObserver = new b(this);
        this.updateObserver = new c(this);
        this.dataObserver = new d(this);
        this.emptyObserver = new e(this);
        this.moreObserver = new f(this);
        this.updateAdapterItemObserver = new g(this);
    }

    public LiveData<Boolean> hasMore() {
        return this.more;
    }

    public LiveData<Boolean> isDataEmpty() {
        return this.empty;
    }

    public Listing<T> listing() {
        return this.listing;
    }

    public LiveData<PagedList<T>> liveData() {
        return this.listData;
    }

    public LiveData<NetworkStat> networkStat() {
        return this.networkState;
    }

    public LiveData<NetworkStat> refreshStat() {
        return this.refreshState;
    }

    public LiveData<Integer> updateAdapterItem() {
        return this.updateAdapterItem;
    }

    public LiveData<NetworkStat> updateStat() {
        return this.updateState;
    }

    private /* synthetic */ void lambda$new$0(NetworkStat r2) {
        this.networkState.postValue(r2);
    }

    private /* synthetic */ void lambda$new$1(NetworkStat r2) {
        this.refreshState.postValue(r2);
    }

    private /* synthetic */ void lambda$new$2(NetworkStat r2) {
        this.updateState.postValue(r2);
    }

    private /* synthetic */ void lambda$new$3(PagedList r2) {
        this.listData.postValue(r2);
    }

    private /* synthetic */ void lambda$new$4(Boolean r2) {
        this.empty.postValue(r2);
    }

    private /* synthetic */ void lambda$new$5(Boolean r2) {
        this.more.postValue(r2);
    }

    private /* synthetic */ void lambda$new$6(Integer r2) {
        this.updateAdapterItem.setValue(r2);
    }

    public T find(j<T> r2) {
        if (listing() != null) goto L5;
        return null;
    L5:
        return listing().find(r2);
    }

    public T get(int r2) {
        if (listing() != null) goto L5;
        return null;
    L5:
        return listing().get(r2);
    }

    public int indexOf(T r2) {
        if (listing() != null) goto L5;
        return -1;
    L5:
        return listing().indexOf(r2);
    }

    public void register(Listing<T> r3) {
        Listing<T> r0 = this.listing;
        if (r0 == null) goto L5;
        r0.getNetworkStat().removeObserver(this.networkObserver);
        this.listing.getRefreshStat().removeObserver(this.refreshObserver);
        this.listing.getUpdateStat().removeObserver(this.updateObserver);
        this.listing.getPageList().removeObserver(this.dataObserver);
        this.listing.isEmpty().removeObserver(this.emptyObserver);
        this.listing.hasMore().removeObserver(this.moreObserver);
        this.listing.updateAdapterItemEvent().removeObserver(this.updateAdapterItemObserver);
    L5:
        this.listing = r3;
        if (r3 == null) goto L9;
        r3.getNetworkStat().observeForever(this.networkObserver);
        this.listing.getRefreshStat().observeForever(this.refreshObserver);
        this.listing.getUpdateStat().observeForever(this.updateObserver);
        this.listing.getPageList().observeForever(this.dataObserver);
        this.listing.isEmpty().observeForever(this.emptyObserver);
        this.listing.hasMore().observeForever(this.moreObserver);
        this.listing.updateAdapterItemEvent().observeForever(this.updateAdapterItemObserver);
        return;
    }

    public void remove(T r2) {
        if (listing() == null) goto L7;
        if (r2 == null) goto L8;
        listing().remove(r2);
        return;
    L8:
        return;
    }

    public void updateAdapterItem(int r2) {
        Listing<T> r0 = this.listing;
        if (r0 == null) goto L6;
        r0.updateAdapterItem(r2);
        return;
    }

    public void remove(int r2) {
        if (listing() == null) goto L6;
        listing().remove(r2);
        return;
    }

    public void add(int r2, T r3) {
        if (listing() == null) goto L6;
        listing().add(r2, r3);
        return;
    }

    public void put(int r2, T r3) {
        if (listing() == null) goto L6;
        listing().put(r2, r3);
        return;
    }
}
