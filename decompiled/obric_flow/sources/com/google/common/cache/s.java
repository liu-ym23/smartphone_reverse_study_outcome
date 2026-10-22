package com.google.common.cache;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends AbstractQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f8764b;

    public s(int r5) {
        this.f8763a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        q r10 = new q(0);
        r10.f8740b = r10;
        r10.f8741c = r10;
        this.f8764b = r10;
        return;
    L6:
        q r11 = new q(1);
        r11.f8740b = r11;
        r11.f8741c = r11;
        this.f8764b = r11;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        p r5 = this.f8764b;
        switch(this.f8763a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        q r10 = (q) r5;
        v0 r11 = r10.f8740b;
    L5:
        if (r11 == r10) goto L7;
        v0 r12 = r11.getNextInWriteQueue();
        Logger r13 = q0.f8742v;
        LocalCache$NullEntry r14 = LocalCache$NullEntry.INSTANCE;
        r11.setNextInWriteQueue(r14);
        r11.setPreviousInWriteQueue(r14);
        r11 = r12;
        goto L5
    L7:
        r10.f8740b = r10;
        r10.f8741c = r10;
        return;
    L9:
        q r15 = (q) r5;
        v0 r16 = r15.f8740b;
    L10:
        if (r16 == r15) goto L12;
        v0 r17 = r16.getNextInAccessQueue();
        Logger r18 = q0.f8742v;
        LocalCache$NullEntry r19 = LocalCache$NullEntry.INSTANCE;
        r16.setNextInAccessQueue(r19);
        r16.setPreviousInAccessQueue(r19);
        r16 = r17;
        goto L10
    L12:
        r15.f8740b = r15;
        r15.f8741c = r15;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r5) {
        switch(this.f8763a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (((v0) r5).getNextInWriteQueue() == LocalCache$NullEntry.INSTANCE) goto L7;
        return true;
    L7:
        return false;
    L10:
        if (((v0) r5).getNextInAccessQueue() == LocalCache$NullEntry.INSTANCE) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        switch(this.f8763a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        q r5 = (q) this.f8764b;
        if (r5.f8740b != r5) goto L7;
        return true;
    L7:
        return false;
    L9:
        q r10 = (q) this.f8764b;
        if (r10.f8740b != r10) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch(this.f8763a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        q r5 = (q) this.f8764b;
        v0 r10 = r5.f8740b;
        if (r10 != r5) goto L8;
        r10 = null;
    L8:
        return new r(this, r10, 1);
    L9:
        q r11 = (q) this.f8764b;
        v0 r12 = r11.f8740b;
        if (r12 != r11) goto L13;
        r12 = null;
    L13:
        return new r(this, r12, 0);
    }

    @Override // java.util.Queue
    public final boolean offer(Object r5) {
        p r10 = this.f8764b;
        switch(this.f8763a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        v0 r11 = (v0) r5;
        v0 r12 = r11.getPreviousInWriteQueue();
        v0 r13 = r11.getNextInWriteQueue();
        Logger r14 = q0.f8742v;
        r12.setNextInWriteQueue(r13);
        r13.setPreviousInWriteQueue(r12);
        q r15 = (q) r10;
        v0 r16 = r15.f8741c;
        r16.setNextInWriteQueue(r11);
        r11.setPreviousInWriteQueue(r16);
        r11.setNextInWriteQueue(r15);
        r15.f8741c = r11;
        return true;
    L6:
        v0 r17 = (v0) r5;
        v0 r18 = r17.getPreviousInAccessQueue();
        v0 r19 = r17.getNextInAccessQueue();
        Logger r20 = q0.f8742v;
        r18.setNextInAccessQueue(r19);
        r19.setPreviousInAccessQueue(r18);
        q r21 = (q) r10;
        v0 r22 = r21.f8741c;
        r22.setNextInAccessQueue(r17);
        r17.setPreviousInAccessQueue(r22);
        r17.setNextInAccessQueue(r21);
        r21.f8741c = r17;
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        switch(this.f8763a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        q r5 = (q) this.f8764b;
        v0 r10 = r5.f8740b;
        if (r10 != r5) goto L12;
        return null;
    L12:
        return r10;
    L8:
        q r11 = (q) this.f8764b;
        v0 r12 = r11.f8740b;
        if (r12 != r11) goto L13;
        return null;
    L13:
        return r12;
    }

    @Override // java.util.Queue
    public final Object poll() {
        switch(this.f8763a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        q r5 = (q) this.f8764b;
        v0 r10 = r5.f8740b;
        if (r10 != r5) goto L7;
        return null;
    L7:
        remove(r10);
        return r10;
    L9:
        q r11 = (q) this.f8764b;
        v0 r12 = r11.f8740b;
        if (r12 != r11) goto L12;
        return null;
    L12:
        remove(r12);
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r5) {
        switch(this.f8763a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        v0 r10 = (v0) r5;
        v0 r11 = r10.getPreviousInWriteQueue();
        v0 r12 = r10.getNextInWriteQueue();
        Logger r13 = q0.f8742v;
        r11.setNextInWriteQueue(r12);
        r12.setPreviousInWriteQueue(r11);
        LocalCache$NullEntry r14 = LocalCache$NullEntry.INSTANCE;
        r10.setNextInWriteQueue(r14);
        r10.setPreviousInWriteQueue(r14);
        if (r12 != r14) goto L7;
        return false;
    L7:
        return true;
    L8:
        v0 r15 = (v0) r5;
        v0 r16 = r15.getPreviousInAccessQueue();
        v0 r17 = r15.getNextInAccessQueue();
        Logger r18 = q0.f8742v;
        r16.setNextInAccessQueue(r17);
        r17.setPreviousInAccessQueue(r16);
        LocalCache$NullEntry r19 = LocalCache$NullEntry.INSTANCE;
        r15.setNextInAccessQueue(r19);
        r15.setPreviousInAccessQueue(r19);
        if (r17 != r19) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch(this.f8763a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        q r5 = (q) this.f8764b;
        v0 r10 = r5.f8740b;
        int r11 = 0;
    L5:
        if (r10 == r5) goto L7;
        r11 = r11 + 1;
        r10 = r10.getNextInWriteQueue();
        goto L5
    L7:
        return r11;
    L8:
        q r12 = (q) this.f8764b;
        v0 r13 = r12.f8740b;
        int r14 = 0;
    L9:
        if (r13 == r12) goto L11;
        r14 = r14 + 1;
        r13 = r13.getNextInAccessQueue();
        goto L9
    L11:
        return r14;
    }
}
