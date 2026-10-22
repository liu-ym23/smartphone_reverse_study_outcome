package com.obric.memorydata.personalcontext.search;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/FrameScoreEntity;", "Lcom/obric/memorydata/personalcontext/search/PhotoScoreEntity;", "startTime", "", "<init>", "(J)V", "getStartTime", "()J", "setStartTime", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameScoreEntity extends PhotoScoreEntity {
    private long startTime;

    public FrameScoreEntity(long r10) {
        super(-1, "", -1, "", null, 0.0f);
        this.startTime = r10;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }
}
