package com.bytedance.platform.godzilla.anr.sp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class LinkedListProxyForFinishers<E> extends LinkedList<E> {
    private LinkedList<Runnable> mRealList;

    public LinkedListProxyForFinishers(LinkedList<Runnable> r1) {
        this.mRealList = r1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r3) {
        return this.mRealList.add((Runnable) ZeusTransformUtils.preCheckCast(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        return null;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r1) {
        return this.mRealList.remove(r1);
    }
}
