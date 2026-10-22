package com.bytedance.apm.block;

import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jg.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    volatile boolean haveAdd;
    volatile boolean haveRemove;
    List<c> mAddObservers;
    final List<c> mObservers;
    List<c> mRemoveObservers;

    public d() {
        this.mObservers = new ArrayList();
        this.mRemoveObservers = new ArrayList();
        this.mAddObservers = new ArrayList();
        this.haveRemove = false;
        this.haveAdd = false;
    }

    public void addMessageObserver(c r5) {
        List<c> r10 = this.mObservers;
        monitor-enter(r10);
        if (r5 != null) goto L14;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L14:
        if (this.mAddObservers.contains(r5) == true) goto L10;
        this.mAddObservers.add(r5);     // Catch: Throwable -> L8
        this.haveAdd = true;     // Catch: Throwable -> L8
        goto L10
    }

    public void messageDispatchStarting(String r5) {
        if (this.haveAdd == false) goto L19;
        List<c> r10 = this.mObservers;
        monitor-enter(r10);
        Iterator<c> r11 = this.mAddObservers.iterator();     // Catch: Throwable -> L12
    L8:
        if (r11.hasNext() == false) goto L14;
        c r12 = r11.next();     // Catch: Throwable -> L12
        if (this.mObservers.contains(r12) == true) goto L8;
        this.mObservers.add(r12);     // Catch: Throwable -> L12
        goto L8
    L14:
        this.mAddObservers.clear();     // Catch: Throwable -> L12
        this.haveAdd = false;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L19:
        Iterator<c> r13 = this.mObservers.iterator();
    L21:
        if (r13.hasNext() == false) goto L25;
        if (r13.next() == null) goto L21;
        i.a(true, r5, null);
        goto L21
    }

    public void messageDispatched(String r5, Message r10) {
        Iterator<c> r11 = this.mObservers.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r11.next() == null) goto L4;
        i.a(false, r5, r10);
        goto L4
    L9:
        if (this.haveRemove == false) goto L23;
        List<c> r12 = this.mObservers;
        monitor-enter(r12);
        Iterator<c> r13 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L16
    L14:
        if (r13.hasNext() == false) goto L18;
        c r14 = r13.next();     // Catch: Throwable -> L16
        this.mObservers.remove(r14);     // Catch: Throwable -> L16
        this.mAddObservers.remove(r14);     // Catch: Throwable -> L16
        goto L14
    L18:
        this.mRemoveObservers.clear();     // Catch: Throwable -> L16
        this.haveRemove = false;     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void removeMessageObserver(c r5) {
        List<c> r10 = this.mObservers;
        monitor-enter(r10);
        if (r5 != null) goto L14;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L14:
        if (this.mRemoveObservers.contains(r5) == true) goto L10;
        this.mRemoveObservers.add(r5);     // Catch: Throwable -> L8
        this.haveRemove = true;     // Catch: Throwable -> L8
        goto L10
    }
}
