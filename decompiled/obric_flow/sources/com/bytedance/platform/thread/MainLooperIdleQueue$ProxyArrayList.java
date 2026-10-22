package com.bytedance.platform.thread;

import android.os.MessageQueue;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MainLooperIdleQueue$ProxyArrayList extends ArrayList<MessageQueue.IdleHandler> {
    public MainLooperIdleQueue$ProxyArrayList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r5) {
        return add((MessageQueue.IdleHandler) r5);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r5) {
        if ((r5 instanceof b) == false) goto L5;
        return true;
    L5:
        ArrayList r10 = b.f7203c;
        b r11 = a.f7202a;
        MessageQueue.IdleHandler r12 = (MessageQueue.IdleHandler) r5;
        monitor-enter(r11);
        r11.f7204a.remove(r12);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean add(MessageQueue.IdleHandler r5) {
        if ((r5 instanceof b) == true) goto L5;
        String r10 = r5.getClass().getName();
        Iterator r11 = b.f7203c.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        if (r10.startsWith((String) r11.next()) == false) goto L11;
        return super.add(r5);
    L16:
        b r12 = a.f7202a;
        monitor-enter(r12);
        r12.f7204a.add(r5);     // Catch: Throwable -> L21
        monitor-exit(r12);     // Catch: Throwable -> L21
        return true;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (contains(r5) == false) goto L7;
        return true;
    L7:
        return super.add(r5);
    }
}
