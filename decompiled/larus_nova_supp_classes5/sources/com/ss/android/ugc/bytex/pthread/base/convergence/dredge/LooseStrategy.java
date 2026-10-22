package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0082\bJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/LooseStrategy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "expandFactor", "", "decreaseFold", "", "expectCount", "interval", "", "expectMaxFoldCycle", "detectCycle", "(FIIJII)V", "foldCycle", "period", "dredgeInterval", "prepare", "", "currentPoolSize", "maxPoolSize", "expandPoolSize", "blockSize", "foldPoolSize", "blockFlag", "isContinueDredge", "onBlockedInPeriod", "", "callback", "Lkotlin/Function0;", "onPoolSizeConfigChange", "minSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class LooseStrategy implements IDredgeStrategy {
    private final int decreaseFold;
    private final float expandFactor;
    private int expectCount;
    private final int expectMaxFoldCycle;
    private int foldCycle;
    private final long interval;
    private final int period;

    public LooseStrategy(float r1, int r2, int r3, long r4, int r6, int r7) {
        this.expandFactor = r1;
        this.decreaseFold = r2;
        this.expectCount = r3;
        this.interval = r4;
        this.expectMaxFoldCycle = r6;
        this.period = ~(Integer.MAX_VALUE << r7);
    }

    public /* synthetic */ LooseStrategy(float r10, int r11, int r12, long r13, int r15, int r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 32) == 0) goto L5;
        int r8 = 30;
    L6:
        this(r10, r11, r12, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public static final /* synthetic */ int access$getPeriod$p(LooseStrategy r0) {
        return r0.period;
    }

    private final void onBlockedInPeriod(int r2, Function0<Unit> r3) {
        if ((r2 & access$getPeriod$p(this)) == 0) goto L6;
        r3.invoke();
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public long dredgeInterval(boolean r1, int r2, int r3) {
        return this.interval;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int expandPoolSize(int r2, int r3, int r4) {
        return RangesKt.coerceAtLeast((MathKt.roundToInt(r3 * this.expandFactor) + r2) - r4, 0);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int foldPoolSize(int r1, int r2, int r3) {
        if ((r1 & access$getPeriod$p(this)) == 0) goto L6;
        return 0;
    L6:
        if (r2 > this.expectCount) goto L8;
        return 0;
    L8:
        return this.decreaseFold;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public boolean isContinueDredge(int r2, int r3, int r4) {
        if ((r2 & access$getPeriod$p(this)) == 0) goto L6;
        return true;
    L6:
        if (r4 > this.expectCount) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        this.foldCycle++;
    L14:
        return r5;
    L13:
        this.foldCycle = 0;
        goto L14
    L8:
        if (this.foldCycle >= this.expectMaxFoldCycle) goto L10;
        r5 = true;
        goto L11
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int onPoolSizeConfigChange(int r1, int r2) {
        this.expectCount = r1;
        return 0;
    }
}
