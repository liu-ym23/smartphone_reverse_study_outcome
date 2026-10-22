package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class DataObserverInstance implements IDataObserver {
    private final CopyOnWriteArraySet<IDataObserver> mDataObserver;

    public DataObserverInstance() {
        this.mDataObserver = new CopyOnWriteArraySet();
    }

    public void addDataObserver(IDataObserver r10) {
        if (r10 == null) goto L5;
        this.mDataObserver.add(r10);
        return;
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onIdLoaded(String r10, String r11, String r12) {
        Iterator<IDataObserver> r13 = this.mDataObserver.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().onIdLoaded(r10, r11, r12);
        goto L4
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<IDataObserver> r10 = this.mDataObserver.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    public void removeAllDataObserver() {
        this.mDataObserver.clear();
    }

    public void removeDataObserver(IDataObserver r10) {
        if (r10 == null) goto L5;
        this.mDataObserver.remove(r10);
        return;
    }
}
