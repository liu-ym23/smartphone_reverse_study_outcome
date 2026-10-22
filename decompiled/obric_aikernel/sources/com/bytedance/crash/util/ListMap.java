package com.bytedance.crash.util;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ListMap<K, V> extends ConcurrentHashMap<K, List<V>> {
    private static final long serialVersionUID = -8278080958339137414L;

    public ListMap() {
    }

    public void add(K r10, V r11) {
        getList(r10).add(r11);
    }

    public void addMulti(V r10, K... r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.length <= 0) goto L12;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        getList(r11[r13]).add(r10);
        r13 = r13 + 1;
        goto L8
    L13:
        return;
    }

    @NonNull
    public List<V> getList(K r10) {
        List<V> r11 = (List) super.get(r10);
        if (r11 != null) goto L6;
        List<V> r12 = newList();
        put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public List<V> newList() {
        return new ArrayList();
    }

    public void removeAll(V r10) {
        Iterator<V> r11 = values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((List) r11.next()).remove(r10);
        goto L4
    }

    public void removeInList(K r10, V r11) {
        getList(r10).remove(r11);
    }
}
