package com.ss.android.lark.framework.assembly.rust;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/framework/assembly/rust/RustThroughputABConfig;", "", "semaphoreCount", "", "increaseThreadCoreSize", "<init>", "(II)V", "getSemaphoreCount", "()I", "getIncreaseThreadCoreSize", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "", "rust-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class y {

    @SerializedName("increase_thread_core_size")
    private final int increaseThreadCoreSize;

    @SerializedName("semaphore_count")
    private final int semaphoreCount;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
        if (this.semaphoreCount == r6.semaphoreCount) goto L12;
        return false;
    L12:
        if (this.increaseThreadCoreSize == r6.increaseThreadCoreSize) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.semaphoreCount * 31) + this.increaseThreadCoreSize;
    }

    public final String toString() {
        return "RustThroughputABConfig(semaphoreCount=" + this.semaphoreCount + ", increaseThreadCoreSize=" + this.increaseThreadCoreSize + ')';
    }

    public final int a() {
        return this.increaseThreadCoreSize;
    }

    public final int b() {
        return this.semaphoreCount;
    }
}
