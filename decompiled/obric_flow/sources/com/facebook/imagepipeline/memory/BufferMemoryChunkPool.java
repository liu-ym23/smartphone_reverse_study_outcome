package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
@DoNotStrip
public class BufferMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public BufferMemoryChunkPool(MemoryTrimmableRegistry r5, PoolParams r10, PoolStatsTracker r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object a(int r5) {
        return new BufferMemoryChunk(r5);
    }
}
