package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
@DoNotStrip
@TargetApi(27)
public class AshmemMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public AshmemMemoryChunkPool(MemoryTrimmableRegistry r5, PoolParams r10, PoolStatsTracker r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object a(int r5) {
        return new AshmemMemoryChunk(r5);
    }
}
