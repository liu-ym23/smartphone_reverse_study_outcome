package com.bytedance.android.live.core.paging.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModelV2;", "Lcom/bytedance/android/live/core/utils/rxutils/RxViewModel;", "networkState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/core/network/NetworkStat;", "refreshState", "empty", "", "hasMore", "retry", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getEmpty", "()Landroidx/lifecycle/MutableLiveData;", "getHasMore", "getNetworkState", "getRefreshState", "getRetry", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagingViewModelV2 extends RxViewModel {
    private final MutableLiveData<Boolean> empty;
    private final MutableLiveData<Boolean> hasMore;
    private final MutableLiveData<NetworkStat> networkState;
    private final MutableLiveData<NetworkStat> refreshState;
    private final MutableLiveData<Boolean> retry;

    public PagingViewModelV2() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagingViewModelV2 copy$default(PagingViewModelV2 r3, MutableLiveData r4, MutableLiveData r5, MutableLiveData r6, MutableLiveData r7, MutableLiveData r8, int r9, Object r11) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.networkState;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.refreshState;
    L8:
        MutableLiveData r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.empty;
    L11:
        MutableLiveData r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.hasMore;
    L14:
        MutableLiveData r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.retry;
    L17:
        MutableLiveData r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final MutableLiveData<NetworkStat> component1() {
        return this.networkState;
    }

    public final MutableLiveData<NetworkStat> component2() {
        return this.refreshState;
    }

    public final MutableLiveData<Boolean> component3() {
        return this.empty;
    }

    public final MutableLiveData<Boolean> component4() {
        return this.hasMore;
    }

    public final MutableLiveData<Boolean> component5() {
        return this.retry;
    }

    public final PagingViewModelV2 copy(MutableLiveData<NetworkStat> r8, MutableLiveData<NetworkStat> r9, MutableLiveData<Boolean> r11, MutableLiveData<Boolean> r12, MutableLiveData<Boolean> r13) {
        Intrinsics.checkNotNullParameter(r8, "networkState");
        Intrinsics.checkNotNullParameter(r9, "refreshState");
        Intrinsics.checkNotNullParameter(r11, "empty");
        Intrinsics.checkNotNullParameter(r12, "hasMore");
        Intrinsics.checkNotNullParameter(r13, "retry");
        return new PagingViewModelV2(r8, r9, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PagingViewModelV2) == false) goto L16;
        PagingViewModelV2 r4 = (PagingViewModelV2) r3;
        if (Intrinsics.areEqual(this.networkState, r4.networkState) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.refreshState, r4.refreshState) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.empty, r4.empty) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r4.hasMore) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.retry, r4.retry) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        MutableLiveData<NetworkStat> r0 = this.networkState;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        MutableLiveData<NetworkStat> r4 = this.refreshState;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        MutableLiveData<Boolean> r7 = this.empty;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        MutableLiveData<Boolean> r11 = this.hasMore;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        MutableLiveData<Boolean> r14 = this.retry;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PagingViewModelV2(networkState=" + this.networkState + ", refreshState=" + this.refreshState + ", empty=" + this.empty + ", hasMore=" + this.hasMore + ", retry=" + this.retry + ")";
    }

    public final MutableLiveData<Boolean> getEmpty() {
        return this.empty;
    }

    public final MutableLiveData<Boolean> getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<NetworkStat> getNetworkState() {
        return this.networkState;
    }

    public final MutableLiveData<NetworkStat> getRefreshState() {
        return this.refreshState;
    }

    public final MutableLiveData<Boolean> getRetry() {
        return this.retry;
    }

    public PagingViewModelV2(MutableLiveData<NetworkStat> r2, MutableLiveData<NetworkStat> r3, MutableLiveData<Boolean> r4, MutableLiveData<Boolean> r5, MutableLiveData<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "networkState");
        Intrinsics.checkNotNullParameter(r3, "refreshState");
        Intrinsics.checkNotNullParameter(r4, "empty");
        Intrinsics.checkNotNullParameter(r5, "hasMore");
        Intrinsics.checkNotNullParameter(r6, "retry");
        this.networkState = r2;
        this.refreshState = r3;
        this.empty = r4;
        this.hasMore = r5;
        this.retry = r6;
    }

    public /* synthetic */ PagingViewModelV2(MutableLiveData r4, MutableLiveData r5, MutableLiveData r6, MutableLiveData r7, MutableLiveData r8, int r9, DefaultConstructorMarker r11) {
        if ((r9 & 1) == 0) goto L6;
        r4 = new MutableLiveData();
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = new MutableLiveData();
    L8:
        MutableLiveData r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = new MutableLiveData();
    L11:
        MutableLiveData r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = new MutableLiveData();
    L14:
        MutableLiveData r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = new MutableLiveData();
    L17:
        MutableLiveData r13 = r4;
        this(r13, r12, r0, r1, r8);
    }
}
