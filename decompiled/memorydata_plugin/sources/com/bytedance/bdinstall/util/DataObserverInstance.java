package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.IDataObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class DataObserverInstance implements IDataObserver {
    private final CopyOnWriteArraySet<IDataObserver> mDataObserver;

    public DataObserverInstance() {
        this.mDataObserver = new CopyOnWriteArraySet();
    }

    public void addDataObserver(IDataObserver r3) {
        IDataObserver r4 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r3, IDataObserver.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mDataObserver.add(r4);
        return;
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onIdLoaded(String r4, String r5, String r6) {
        Iterator<IDataObserver> r3 = this.mDataObserver.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((IDataObserver) ZeusTransformUtils.preCheckCast(r3.next(), IDataObserver.class, "com.obric.memorydata.plugin")).onIdLoaded(r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<IDataObserver> r0 = this.mDataObserver.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IDataObserver) ZeusTransformUtils.preCheckCast(r0.next(), IDataObserver.class, "com.obric.memorydata.plugin")).onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    public void removeAllDataObserver() {
        this.mDataObserver.clear();
    }

    public void removeDataObserver(IDataObserver r3) {
        IDataObserver r4 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r3, IDataObserver.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mDataObserver.remove(r4);
        return;
    }
}
