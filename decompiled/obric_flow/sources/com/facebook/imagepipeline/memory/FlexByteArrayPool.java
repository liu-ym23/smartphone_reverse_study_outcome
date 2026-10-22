package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes2.dex */
public class FlexByteArrayPool {

    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(NoOpMemoryTrimmableRegistry r5, PoolParams r10, NoOpPoolStatsTracker r11) {
            super(r5, r10, r11);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        public final Bucket g(int r5) {
            return new OOMSoftReferenceBucket(r5, this.f8201c.d);
        }
    }

    public FlexByteArrayPool(NoOpMemoryTrimmableRegistry r5, PoolParams r10) {
        if (r10.d <= 0) goto L18;
        monitor-enter(NoOpPoolStatsTracker.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (NoOpPoolStatsTracker.f8235a != null) goto L11;
        NoOpPoolStatsTracker.f8235a = new NoOpPoolStatsTracker();     // Catch: Throwable -> L9
    L11:
        NoOpPoolStatsTracker r11 = NoOpPoolStatsTracker.f8235a;     // Catch: Throwable -> L9
        monitor-exit(NoOpPoolStatsTracker.class);     // Catch: Throwable -> L9
        new SoftRefByteArrayPool(r5, r10, r11);
        return;
    L18:
        throw new IllegalArgumentException();
    }
}
