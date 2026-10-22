package com.obric.capabilitykit.search;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/search/FrameScore;", "Lcom/obric/capabilitykit/search/PhotoScore;", "startTime", "", "(J)V", "getStartTime", "()J", "setStartTime", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FrameScore extends PhotoScore {
    private long startTime;

    public FrameScore(long r3) {
        super("", 0.0f);
        this.startTime = r3;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }
}
