package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import rt.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f18112b;

    public a() {
        AtomicReference r5 = new AtomicReference();
        this.f18111a = r5;
        AtomicReference r10 = new AtomicReference();
        this.f18112b = r10;
        MpscLinkedQueue$LinkedQueueNode r11 = new MpscLinkedQueue$LinkedQueueNode();
        r10.lazySet(r11);
        MpscLinkedQueue$LinkedQueueNode r12 = (MpscLinkedQueue$LinkedQueueNode) r5.getAndSet(r11);
    }

    @Override // rt.h
    public final void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // rt.h
    public final boolean isEmpty() {
        if (((MpscLinkedQueue$LinkedQueueNode) this.f18112b.get()) != ((MpscLinkedQueue$LinkedQueueNode) this.f18111a.get())) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public final boolean offer(Object r5) {
        if (r5 == null) goto L6;
        MpscLinkedQueue$LinkedQueueNode r10 = new MpscLinkedQueue$LinkedQueueNode(r5);
        ((MpscLinkedQueue$LinkedQueueNode) this.f18111a.getAndSet(r10)).soNext(r10);
        return true;
    L6:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // rt.h
    public final Object poll() {
        AtomicReference r5 = this.f18112b;
        MpscLinkedQueue$LinkedQueueNode r10 = (MpscLinkedQueue$LinkedQueueNode) r5.get();
        MpscLinkedQueue$LinkedQueueNode r11 = r10.lvNext();
        if (r11 == null) goto L7;
        Object r12 = r11.getAndNullValue();
        r5.lazySet(r11);
        return r12;
    L7:
        if (r10 == ((MpscLinkedQueue$LinkedQueueNode) this.f18111a.get())) goto L13;
    L8:
        MpscLinkedQueue$LinkedQueueNode r13 = r10.lvNext();
        if (r13 == null) goto L8;
        Object r14 = r13.getAndNullValue();
        r5.lazySet(r13);
        return r14;
    L13:
        return null;
    }
}
