package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/FusingStrategy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "interval", "", "fusingInterval", "fusingSize", "", "expectedSize", "detectCycle", "(JJIII)V", "lastBlockTime", "period", "dredgeInterval", "prepare", "", "currentPoolSize", "maxPoolSize", "expandPoolSize", "blockSize", "foldPoolSize", "blockFlag", "isBlockedInPeriod", "isContinueDredge", "onPoolSizeConfigChange", "minSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class FusingStrategy implements IDredgeStrategy {
    private final int expectedSize;
    private final long fusingInterval;
    private int fusingSize;
    private final long interval;
    private long lastBlockTime;
    private final int period;

    public FusingStrategy(long r1, long r3, int r5, int r6, int r7) {
        this.interval = r1;
        this.fusingInterval = r3;
        this.fusingSize = r5;
        this.expectedSize = r6;
        this.period = ~(Integer.MAX_VALUE << r7);
    }

    public /* synthetic */ FusingStrategy(long r10, long r12, int r14, int r15, int r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        int r8 = 30;
    L6:
        this(r10, r12, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final boolean isBlockedInPeriod(int r2) {
        if ((r2 & this.period) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public long dredgeInterval(boolean r5, int r6, int r7) {
        long r8 = this.lastBlockTime;
        if (r8 <= 0) goto L7;
        return RangesKt.coerceAtLeast((r8 + this.fusingInterval) - System.currentTimeMillis(), 0);
    L7:
        return this.interval;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int expandPoolSize(int r8, int r9, int r10) {
        int r0 = RangesKt.coerceAtMost((r9 / r8) + 1, 5) + r8;
        if (r0 > r10) goto L6;
        return 0;
    L6:
        if (r0 < this.fusingSize) goto L16;
        long r1 = this.lastBlockTime;
        long r2 = System.currentTimeMillis();
        if (r1 != 0) goto L11;
        this.lastBlockTime = r2;
    L14:
        r0 = this.fusingSize;
        goto L16
    L11:
        if ((r2 - this.lastBlockTime) < this.fusingInterval) goto L14;
        this.lastBlockTime = 0;
        return r9;
    L16:
        return RangesKt.coerceAtLeast(r0 - r10, 0);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int foldPoolSize(int r3, int r4, int r5) {
        this.lastBlockTime = 0;
        if (isBlockedInPeriod(r3) == false) goto L6;
        return 0;
    L6:
        if (r5 <= this.expectedSize) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public boolean isContinueDredge(int r1, int r2, int r3) {
        if (isBlockedInPeriod(r1) == false) goto L6;
        return true;
    L6:
        if (r3 > this.fusingSize) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int onPoolSizeConfigChange(int r1, int r2) {
        this.fusingSize = r2;
        return r1;
    }
}
