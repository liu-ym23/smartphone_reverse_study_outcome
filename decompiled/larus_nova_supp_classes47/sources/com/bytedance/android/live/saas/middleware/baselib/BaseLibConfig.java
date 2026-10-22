package com.bytedance.android.live.saas.middleware.baselib;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "", "ttExecutors", "Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;", "isToB", "", "(Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;Z)V", "()Z", "getTtExecutors", "()Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BaseLibConfig {
    private final boolean isToB;
    private final ITTExecutors ttExecutors;

    public BaseLibConfig() {
        ITTExecutors r2 = null;
        this(r2, false, 3, r2);
    }

    public static /* synthetic */ BaseLibConfig copy$default(BaseLibConfig r0, ITTExecutors r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ttExecutors;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isToB;
    L9:
        return r0.copy(r1, r2);
    }

    public final ITTExecutors component1() {
        return this.ttExecutors;
    }

    public final boolean component2() {
        return this.isToB;
    }

    public final BaseLibConfig copy(ITTExecutors r2, boolean r3) {
        return new BaseLibConfig(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BaseLibConfig) == false) goto L10;
        BaseLibConfig r4 = (BaseLibConfig) r3;
        if (Intrinsics.areEqual(this.ttExecutors, r4.ttExecutors) == true) goto L8;
        return false;
    L8:
        if (this.isToB == r4.isToB) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ITTExecutors r0 = this.ttExecutors;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.isToB;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "BaseLibConfig(ttExecutors=" + this.ttExecutors + ", isToB=" + this.isToB + ")";
    }

    public final ITTExecutors getTtExecutors() {
        return this.ttExecutors;
    }

    public final boolean isToB() {
        return this.isToB;
    }

    public BaseLibConfig(ITTExecutors r1, boolean r2) {
        this.ttExecutors = r1;
        this.isToB = r2;
    }

    public /* synthetic */ BaseLibConfig(ITTExecutors r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
