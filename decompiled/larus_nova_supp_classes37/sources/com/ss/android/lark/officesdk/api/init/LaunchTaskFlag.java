package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/LaunchTaskFlag;", "", "sdkInitReadyFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "rustLoginFlag", "firstFeedShowFlag", "<init>", "(Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getSdkInitReadyFlag", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getRustLoginFlag", "getFirstFeedShowFlag", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LaunchTaskFlag {
    private final AtomicBoolean firstFeedShowFlag;
    private final AtomicBoolean rustLoginFlag;
    private final AtomicBoolean sdkInitReadyFlag;

    public LaunchTaskFlag() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LaunchTaskFlag copy$default(LaunchTaskFlag r0, AtomicBoolean r1, AtomicBoolean r2, AtomicBoolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sdkInitReadyFlag;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.rustLoginFlag;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.firstFeedShowFlag;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final AtomicBoolean component1() {
        return this.sdkInitReadyFlag;
    }

    public final AtomicBoolean component2() {
        return this.rustLoginFlag;
    }

    public final AtomicBoolean component3() {
        return this.firstFeedShowFlag;
    }

    public final LaunchTaskFlag copy(AtomicBoolean r2, AtomicBoolean r3, AtomicBoolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sdkInitReadyFlag");
        Intrinsics.checkNotNullParameter(r3, "rustLoginFlag");
        Intrinsics.checkNotNullParameter(r4, "firstFeedShowFlag");
        return new LaunchTaskFlag(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LaunchTaskFlag) == true) goto L8;
        return false;
    L8:
        LaunchTaskFlag r6 = (LaunchTaskFlag) r5;
        if (Intrinsics.areEqual(this.sdkInitReadyFlag, r6.sdkInitReadyFlag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rustLoginFlag, r6.rustLoginFlag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.firstFeedShowFlag, r6.firstFeedShowFlag) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.sdkInitReadyFlag.hashCode() * 31) + this.rustLoginFlag.hashCode()) * 31) + this.firstFeedShowFlag.hashCode();
    }

    public String toString() {
        return "LaunchTaskFlag(sdkInitReadyFlag=" + this.sdkInitReadyFlag + ", rustLoginFlag=" + this.rustLoginFlag + ", firstFeedShowFlag=" + this.firstFeedShowFlag + ')';
    }

    public final AtomicBoolean getFirstFeedShowFlag() {
        return this.firstFeedShowFlag;
    }

    public final AtomicBoolean getRustLoginFlag() {
        return this.rustLoginFlag;
    }

    public final AtomicBoolean getSdkInitReadyFlag() {
        return this.sdkInitReadyFlag;
    }

    public LaunchTaskFlag(AtomicBoolean r2, AtomicBoolean r3, AtomicBoolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sdkInitReadyFlag");
        Intrinsics.checkNotNullParameter(r3, "rustLoginFlag");
        Intrinsics.checkNotNullParameter(r4, "firstFeedShowFlag");
        this.sdkInitReadyFlag = r2;
        this.rustLoginFlag = r3;
        this.firstFeedShowFlag = r4;
    }

    public /* synthetic */ LaunchTaskFlag(AtomicBoolean r2, AtomicBoolean r3, AtomicBoolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = new AtomicBoolean(false);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = new AtomicBoolean(false);
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new AtomicBoolean(false);
    L11:
        this(r2, r3, r4);
    }
}
