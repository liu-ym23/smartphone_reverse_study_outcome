package com.bytedance.android.live.core.paging;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface Listing<T> {
    void add(int r1, T r2);

    void add(int r1, List<T> r2);

    T find(j<T> r1);

    T get(int r1);

    LiveData<NetworkStat> getNetworkStat();

    LiveData<PagedList<T>> getPageList();

    LiveData<NetworkStat> getRefreshStat();

    PublishSubject<Pair<String, String>> getReqFrom();

    LiveData<NetworkStat> getUpdateStat();

    LiveData<Boolean> hasMore();

    int indexOf(T r1);

    LiveData<Boolean> isEmpty();

    void put(int r1, T r2);

    void refresh();

    void remove(int r1);

    void remove(T r1);

    void retry();

    void setReqFrom(String r1, String r2);

    int size();

    void update();

    void updateAdapterItem(int r1);

    LiveData<Integer> updateAdapterItemEvent();
}
