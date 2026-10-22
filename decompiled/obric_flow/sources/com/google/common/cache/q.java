package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0 f8740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0 f8741c;

    public /* synthetic */ q(int r5) {
        this.f8739a = r5;
    }

    private final void a(long r5) {
    }

    private final void b(long r5) {
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public long getAccessTime() {
        switch(this.f8739a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return Long.MAX_VALUE;
    L5:
        return super.getAccessTime();
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getNextInAccessQueue() {
        switch(this.f8739a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInAccessQueue();
    L7:
        return this.f8740b;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getNextInWriteQueue() {
        switch(this.f8739a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getNextInWriteQueue();
    L7:
        return this.f8740b;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getPreviousInAccessQueue() {
        switch(this.f8739a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInAccessQueue();
    L7:
        return this.f8741c;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public v0 getPreviousInWriteQueue() {
        switch(this.f8739a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.getPreviousInWriteQueue();
    L7:
        return this.f8741c;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public long getWriteTime() {
        switch(this.f8739a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        return Long.MAX_VALUE;
    L5:
        return super.getWriteTime();
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setAccessTime(long r5) {
        switch(this.f8739a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setAccessTime(r5);
        return;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setNextInAccessQueue(v0 r5) {
        switch(this.f8739a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInAccessQueue(r5);
        return;
    L6:
        this.f8740b = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setNextInWriteQueue(v0 r5) {
        switch(this.f8739a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setNextInWriteQueue(r5);
        return;
    L6:
        this.f8740b = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setPreviousInAccessQueue(v0 r5) {
        switch(this.f8739a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInAccessQueue(r5);
        return;
    L6:
        this.f8741c = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setPreviousInWriteQueue(v0 r5) {
        switch(this.f8739a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setPreviousInWriteQueue(r5);
        return;
    L6:
        this.f8741c = r5;
    }

    @Override // com.google.common.cache.p, com.google.common.cache.v0
    public void setWriteTime(long r5) {
        switch(this.f8739a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.setWriteTime(r5);
        return;
    }
}
