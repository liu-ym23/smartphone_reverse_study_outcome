package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends e0 {
    public final /* synthetic */ int e;
    public volatile long f;
    public v0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v0 f8694h;

    public /* synthetic */ c0(Object r5, int r10, v0 r11, int r12) {
        this.e = r12;
        super(r5, r10, r11);
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public long getAccessTime() {
        switch(this.e) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getAccessTime();
    L7:
        return this.f;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getNextInAccessQueue() {
        switch(this.e) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInAccessQueue();
    L7:
        return this.g;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getNextInWriteQueue() {
        switch(this.e) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInWriteQueue();
    L7:
        return this.g;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getPreviousInAccessQueue() {
        switch(this.e) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInAccessQueue();
    L7:
        return this.f8694h;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getPreviousInWriteQueue() {
        switch(this.e) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInWriteQueue();
    L7:
        return this.f8694h;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public long getWriteTime() {
        switch(this.e) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getWriteTime();
    L7:
        return this.f;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setAccessTime(long r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setAccessTime(r5);
        return;
    L6:
        this.f = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setNextInAccessQueue(v0 r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInAccessQueue(r5);
        return;
    L6:
        this.g = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setNextInWriteQueue(v0 r5) {
        switch(this.e) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInWriteQueue(r5);
        return;
    L6:
        this.g = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setPreviousInAccessQueue(v0 r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInAccessQueue(r5);
        return;
    L6:
        this.f8694h = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setPreviousInWriteQueue(v0 r5) {
        switch(this.e) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInWriteQueue(r5);
        return;
    L6:
        this.f8694h = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setWriteTime(long r5) {
        switch(this.e) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setWriteTime(r5);
        return;
    L6:
        this.f = r5;
    }
}
