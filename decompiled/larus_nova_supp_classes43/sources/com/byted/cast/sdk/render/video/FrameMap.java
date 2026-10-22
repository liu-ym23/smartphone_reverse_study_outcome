package com.byted.cast.sdk.render.video;

import com.byted.cast.sink.api.IAPI;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/byted/cast/sdk/render/video/FrameMap;", "", "()V", "mFakeFrameHashMap", "Ljava/util/concurrent/atomic/AtomicLongArray;", "find", "", "presentationTime", "findOnly", "put", "", "frameIndex", "library_internalRelease"}, k = 1, mv = {1, 1, IAPI.OPTION_SHOW_DETAIL_CAST_INFO})
public final class FrameMap {
    private final AtomicLongArray mFakeFrameHashMap;

    public FrameMap() {
        this.mFakeFrameHashMap = new AtomicLongArray(4096);
    }

    public final long find(long r10) {
        return this.mFakeFrameHashMap.getAndSet((int) (r10 & 4095), -1);
    }

    public final long findOnly(long r10) {
        return this.mFakeFrameHashMap.get((int) (r10 & 4095));
    }

    public final void put(long r10, long r11) {
        this.mFakeFrameHashMap.set((int) (r10 & 4095), r11);
    }
}
