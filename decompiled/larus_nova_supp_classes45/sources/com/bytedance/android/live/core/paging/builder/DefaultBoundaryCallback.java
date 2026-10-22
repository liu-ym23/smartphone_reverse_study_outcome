package com.bytedance.android.live.core.paging.builder;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DefaultBoundaryCallback<V> extends PagedList.BoundaryCallback<V> {
    public final MutableLiveData<Boolean> a;
    public final MutableLiveData<Boolean> b;

    public final void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        this.b.postValue(Boolean.TRUE);
    }

    public final void onItemAtEndLoaded(V r2) {
        super.onItemAtEndLoaded(r2);
        this.a.postValue(Boolean.FALSE);
    }

    public DefaultBoundaryCallback(MutableLiveData<Boolean> r2, MutableLiveData<Boolean> r3) {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.a = r2;
        this.b = r3;
    }
}
