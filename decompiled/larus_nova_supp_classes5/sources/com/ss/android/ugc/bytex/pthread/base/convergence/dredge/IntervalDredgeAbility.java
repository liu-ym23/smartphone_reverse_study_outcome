package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IntervalDredgeAbility;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeAbility;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;", "mStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;)V", "mBlockFlag", "", "mExpectConsumeCount", "", "dredge", "", "interval", "prepare", "onPoolSizeConfigChange", "", "minSize", "maxSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class IntervalDredgeAbility implements IDredgeAbility {
    private final ExpandablePool executor;
    private int mBlockFlag;
    private long mExpectConsumeCount;
    private final IDredgeStrategy mStrategy;

    public IntervalDredgeAbility(ExpandablePool r1, IDredgeStrategy r2) {
        this.executor = r1;
        this.mStrategy = r2;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public boolean dredge() {
        long r0 = this.executor.getConsumeCount();
        long r2 = this.mExpectConsumeCount;
        if (r0 >= r2) goto L5;
        int r5 = 1;
    L6:
        int r4 = (this.mBlockFlag << 1) + r5;
        this.mBlockFlag = r4;
        long r1 = RangesKt.coerceAtLeast(r2 - r0, 0);
        int r3 = this.executor.getPoolSize();
        int r6 = this.executor.getMaxPoolSize();
        if (r5 == 0) goto L11;
        int r7 = this.mStrategy.expandPoolSize(r3, (int) r1, r6);
        if (r7 <= 0) goto L15;
        ExpandablePool r8 = this.executor;
        int r9 = r7 + r6;
    L14:
        r8.setMaxPoolSize(r9);
    L15:
        this.mExpectConsumeCount = this.executor.getConsumeCount() + ((long) this.executor.getPendingCount());
        return this.mStrategy.isContinueDredge(r4, r3, r6);
    L11:
        int r10 = this.mStrategy.foldPoolSize(r4, r3, r6);
        if (r10 <= 0) goto L15;
        r8 = this.executor;
        r9 = r6 - r10;
        goto L14
    L5:
        r5 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public long interval(boolean r4) {
        return this.mStrategy.dredgeInterval(r4, this.executor.getPoolSize(), this.executor.getMaxPoolSize());
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public void onPoolSizeConfigChange(int r2, int r3) {
        int r4 = this.mStrategy.onPoolSizeConfigChange(r2, r3);
        if (r4 <= 0) goto L6;
        this.executor.setMaxPoolSize(r4);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public boolean prepare() {
        int r0 = this.executor.getPendingCount();
        if (r0 != 0) goto L5;
        return false;
    L5:
        if ((this.executor.getPoolSize() + r0) < this.executor.getMaxPoolSize()) goto L11;
        this.mExpectConsumeCount = this.executor.getConsumeCount() + ((long) r0);
        return true;
    L11:
        return false;
    }
}
