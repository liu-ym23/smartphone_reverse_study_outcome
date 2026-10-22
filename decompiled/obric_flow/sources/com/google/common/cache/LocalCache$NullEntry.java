package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
final enum LocalCache$NullEntry extends Enum<LocalCache$NullEntry> implements v0 {
    public static final LocalCache$NullEntry INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalCache$NullEntry[] f8681a = null;

    static {
        LocalCache$NullEntry r5 = new LocalCache$NullEntry("INSTANCE", 0);
        INSTANCE = r5;
        f8681a = new LocalCache$NullEntry[]{r5};
    }

    public static LocalCache$NullEntry valueOf(String r5) {
        return (LocalCache$NullEntry) Enum.valueOf(LocalCache$NullEntry.class, r5);
    }

    public static LocalCache$NullEntry[] values() {
        return (LocalCache$NullEntry[]) f8681a.clone();
    }

    @Override // com.google.common.cache.v0
    public long getAccessTime() {
        return 0;
    }

    @Override // com.google.common.cache.v0
    public int getHash() {
        return 0;
    }

    @Override // com.google.common.cache.v0
    public Object getKey() {
        return null;
    }

    @Override // com.google.common.cache.v0
    public v0 getNext() {
        return null;
    }

    @Override // com.google.common.cache.v0
    public v0 getNextInAccessQueue() {
        return this;
    }

    @Override // com.google.common.cache.v0
    public v0 getNextInWriteQueue() {
        return this;
    }

    @Override // com.google.common.cache.v0
    public v0 getPreviousInAccessQueue() {
        return this;
    }

    @Override // com.google.common.cache.v0
    public v0 getPreviousInWriteQueue() {
        return this;
    }

    @Override // com.google.common.cache.v0
    public g0 getValueReference() {
        return null;
    }

    @Override // com.google.common.cache.v0
    public long getWriteTime() {
        return 0;
    }

    @Override // com.google.common.cache.v0
    public void setAccessTime(long r5) {
    }

    @Override // com.google.common.cache.v0
    public void setNextInAccessQueue(v0 r5) {
    }

    @Override // com.google.common.cache.v0
    public void setNextInWriteQueue(v0 r5) {
    }

    @Override // com.google.common.cache.v0
    public void setPreviousInAccessQueue(v0 r5) {
    }

    @Override // com.google.common.cache.v0
    public void setPreviousInWriteQueue(v0 r5) {
    }

    @Override // com.google.common.cache.v0
    public void setValueReference(g0 r5) {
    }

    @Override // com.google.common.cache.v0
    public void setWriteTime(long r5) {
    }
}
