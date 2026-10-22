package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f8221j;

    public GenericByteArrayPool(NoOpMemoryTrimmableRegistry r5, PoolParams r10, NoOpPoolStatsTracker r11) {
        super(r5, r10, r11);
        SparseIntArray r12 = r10.f8249c;
        this.f8221j = new int[r12.size()];
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L6;
        this.f8221j[r13] = r12.keyAt(r13);
        r13 = r13 + 1;
        goto L4
    L6:
        this.f8200b.getClass();
        this.f8203i.getClass();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void a(Object r5) {
        ((byte[]) r5).getClass();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int b(Object r5) {
        byte[] r10 = (byte[]) r5;
        r10.getClass();
        return r10.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int e(int r5) {
        if (r5 <= 0) goto L11;
        int[] r10 = this.f8221j;
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

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object a(int r5) {
        return new byte[r5];
    }
}
