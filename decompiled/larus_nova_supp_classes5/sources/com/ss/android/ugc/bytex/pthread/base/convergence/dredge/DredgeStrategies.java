package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u0006J@\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeStrategies;", "", "()V", "createFusingStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "expectSize", "", "fusingSize", "interval", "", "fusingInterval", "detectCycle", "createLooseStrategy", "leastCount", "expandFactor", "", "decreaseFold", "expectMaxFoldCycle", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class DredgeStrategies {
    public static final DredgeStrategies INSTANCE = null;

    static {
        INSTANCE = new DredgeStrategies();
    }

    private DredgeStrategies() {
    }

    public static /* synthetic */ IDredgeStrategy createFusingStrategy$default(DredgeStrategies r10, int r11, int r12, long r13, long r15, int r17, int r18, Object r19) {
        if ((r18 & 4) == 0) goto L5;
        long r5 = 50;
    L7:
        if ((r18 & 8) == 0) goto L9;
        long r7 = 3000;
    L11:
        if ((r18 & 16) == 0) goto L13;
        int r9 = 10;
    L15:
        return r10.createFusingStrategy(r11, r12, r5, r7, r9);
    L13:
        r9 = r17;
        goto L15
    L9:
        r7 = r15;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ IDredgeStrategy createLooseStrategy$default(DredgeStrategies r6, int r7, long r8, float r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        long r0 = 50;
    L7:
        if ((r14 & 4) == 0) goto L9;
        float r2 = 0.1f;
    L10:
        int r4 = 1;
        if ((r14 & 8) == 0) goto L13;
        int r3 = 1;
    L15:
        if ((r14 & 16) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r14 & 32) == 0) goto L21;
        int r5 = 10;
    L23:
        return r6.createLooseStrategy(r7, r0, r2, r3, r4, r5);
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r0 = r8;
        goto L7
    }

    public final IDredgeStrategy createFusingStrategy(int r10, int r11, long r12, long r14, int r16) {
        return new FusingStrategy(r12, r14, r11, r10, r16);
    }

    public final IDredgeStrategy createLooseStrategy(int r10, long r11, float r13, int r14, int r15, int r16) {
        return new LooseStrategy(r13, r14, r10, r11, r15, r16);
    }
}
