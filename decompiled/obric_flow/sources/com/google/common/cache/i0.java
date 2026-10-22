package com.google.common.cache;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends k0 {
    public final /* synthetic */ int d;
    public volatile long e;
    public v0 f;
    public v0 g;

    public /* synthetic */ i0(ReferenceQueue r5, Object r10, int r11, v0 r12, int r13) {
        this.d = r13;
        super(r11, r12, r10, r5);
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public long getAccessTime() {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getAccessTime();
    L7:
        return this.e;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public v0 getNextInAccessQueue() {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInAccessQueue();
    L7:
        return this.f;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public v0 getNextInWriteQueue() {
        switch(this.d) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInWriteQueue();
    L7:
        return this.f;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public v0 getPreviousInAccessQueue() {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInAccessQueue();
    L7:
        return this.g;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public v0 getPreviousInWriteQueue() {
        switch(this.d) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInWriteQueue();
    L7:
        return this.g;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public long getWriteTime() {
        switch(this.d) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getWriteTime();
    L7:
        return this.e;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setAccessTime(long r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setAccessTime(r5);
        return;
    L6:
        this.e = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setNextInAccessQueue(v0 r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInAccessQueue(r5);
        return;
    L6:
        this.f = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setNextInWriteQueue(v0 r5) {
        switch(this.d) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInWriteQueue(r5);
        return;
    L6:
        this.f = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setPreviousInAccessQueue(v0 r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInAccessQueue(r5);
        return;
    L6:
        this.g = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setPreviousInWriteQueue(v0 r5) {
        switch(this.d) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInWriteQueue(r5);
        return;
    L6:
        this.g = r5;
    }

    @Override // com.google.common.cache.k0, com.google.common.cache.v0
    public void setWriteTime(long r5) {
        switch(this.d) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setWriteTime(r5);
        return;
    L6:
        this.e = r5;
    }
}
