package com.bytedance.android.live.core.tetris.layer.core.data;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DataCenterV2 extends DataCenter {
    protected Map<Observer<KVData>, Set<String>> observerKeyMap;

    public DataCenterV2() {
        this.observerKeyMap = new HashMap();
    }

    public void onCleared() {
        super.onCleared();
        this.observerKeyMap.clear();
    }

    public DataCenter removeObserver(Observer<KVData> r3) {
        Set<String> r0 = removeObserverKeySet(r3);
        if (r0 == null) goto L8;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        super.removeObserver(r1.next(), r3);
    L8:
        return this;
    }

    public Set<String> removeObserverKeySet(Observer<KVData> r2) {
        return this.observerKeyMap.remove(r2);
    }

    public static DataCenter create(ViewModelProvider r2, LifecycleOwner r3) {
        int r0 = a.a;
        boolean r1 = true;
        if ((a.a & 1) > 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        DataCenter r4 = (DataCenter) r2.get(DataCenterV2.class);
    L9:
        r4.lifecycleOwner = r3;
        return r4;
    L8:
        r4 = r2.get(DataCenter.class);
        goto L9
    }

    public DataCenter observe(String r2, Observer<KVData> r3) {
        DataCenter r0 = super.observe(r2, r3);
        updateKeySet(r2, r3);
        return r0;
    }

    public DataCenter observeForever(String r2, Observer<KVData> r3) {
        DataCenter r0 = super.observeForever(r2, r3);
        updateKeySet(r2, r3);
        return r0;
    }

    public DataCenter removeObserver(String r2, Observer<KVData> r3) {
        if (r3 == null) goto L12;
        if (r2 == null) goto L12;
        Set<String> r0 = this.observerKeyMap.get(r3);
        if (r0 == null) goto L11;
        r0.remove(r2);
        if (r0.isEmpty() == false) goto L11;
        this.observerKeyMap.remove(r3);
    L11:
        return super.removeObserver(r2, r3);
    L12:
        return this;
    }

    public void updateKeySet(String r2, Observer<KVData> r3) {
        if (r2 == null) goto L10;
        if (r3 == null) goto L11;
        Set<String> r0 = this.observerKeyMap.get(r3);
        if (r0 != null) goto L8;
        r0 = new HashSet();
    L8:
        r0.add(r2);
        this.observerKeyMap.put(r3, r0);
        return;
    L11:
        return;
    }

    public DataCenter observe(String r1, Observer<KVData> r2, boolean r3) {
        DataCenter r4 = super.observe(r1, r2, r3);
        updateKeySet(r1, r2);
        return r4;
    }

    public DataCenter observeForever(String r1, Observer<KVData> r2, boolean r3) {
        DataCenter r4 = super.observeForever(r1, r2, r3);
        updateKeySet(r1, r2);
        return r4;
    }
}
