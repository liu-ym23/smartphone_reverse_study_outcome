package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f8227j;

    public MemoryChunkPool(MemoryTrimmableRegistry r5, PoolParams r10, PoolStatsTracker r11) {
        super(r5, r10, r11);
        SparseIntArray r12 = r10.f8249c;
        this.f8227j = new int[r12.size()];
        int r13 = 0;
    L3:
        int[] r14 = this.f8227j;
        if (r13 >= r14.length) goto L6;
        r14[r13] = r12.keyAt(r13);
        r13 = r13 + 1;
        goto L3
    L6:
        this.f8200b.getClass();
        this.f8203i.getClass();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void a(Object r5) {
        MemoryChunk r10 = (MemoryChunk) r5;
        r10.getClass();
        r10.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int b(Object r5) {
        MemoryChunk r10 = (MemoryChunk) r5;
        r10.getClass();
        return r10.c();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final boolean c(Object r5) {
        MemoryChunk r10 = (MemoryChunk) r5;
        r10.getClass();
        return !r10.a();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int e(int r5) {
        if (r5 <= 0) goto L11;
        int[] r10 = this.f8227j;
        int r11 = r10.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        int r13 = r10[r12];
        if (r13 >= r5) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r13;
    L9:
        return r5;
    L11:
        throw new BasePool.InvalidSizeException(Integer.valueOf(r5));
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int f(int r5) {
        return r5;
    }
}
