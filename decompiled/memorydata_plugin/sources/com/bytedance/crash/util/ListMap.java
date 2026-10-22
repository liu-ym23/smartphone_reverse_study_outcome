package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ListMap<K, V> extends ConcurrentHashMap<K, List<V>> {
    private static final long serialVersionUID = -8278080958339137414L;

    public ListMap() {
    }

    public void add(K r1, V r2) {
        getList(r1).add(r2);
    }

    public void addMulti(V r4, K... r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length <= 0) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        getList(r5[r1]).add(r4);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    public List<V> getList(K r4) {
        List<V> r0 = (List) ZeusTransformUtils.preCheckCast(super.get(r4), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        List<V> r1 = newList();
        put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public List<V> newList() {
        return new ArrayList();
    }

    public void removeAll(V r4) {
        Iterator<V> r3 = values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin")).remove(r4);
        goto L4
    }

    public void removeInList(K r1, V r2) {
        getList(r1).remove(r2);
    }
}
