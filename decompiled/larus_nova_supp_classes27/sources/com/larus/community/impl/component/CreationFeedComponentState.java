package com.larus.community.impl.component;

import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/larus/community/impl/component/CreationFeedComponentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationModelList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "pageState", "Lcom/larus/community/impl/view/PageState;", "refreshState", "Lcom/larus/community/impl/view/RefreshState;", "moreState", "Lcom/larus/profile/api/model/MoreState;", "invokeLoadMoreEvent", "Lcom/larus/community/impl/component/InvokeEvent;", "invokeNotifyDataList", "Lcom/larus/community/impl/component/InvokeNotifyEvent;", "<init>", "(Ljava/util/List;Lcom/larus/community/impl/view/PageState;Lcom/larus/community/impl/view/RefreshState;Lcom/larus/profile/api/model/MoreState;Lcom/larus/community/impl/component/InvokeEvent;Lcom/larus/community/impl/component/InvokeNotifyEvent;)V", "getCreationModelList", "()Ljava/util/List;", "getPageState", "()Lcom/larus/community/impl/view/PageState;", "getRefreshState", "()Lcom/larus/community/impl/view/RefreshState;", "getMoreState", "()Lcom/larus/profile/api/model/MoreState;", "getInvokeLoadMoreEvent", "()Lcom/larus/community/impl/component/InvokeEvent;", "getInvokeNotifyDataList", "()Lcom/larus/community/impl/component/InvokeNotifyEvent;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFeedComponentState implements w1a.b {
    private final List<UserCreationModel> creationModelList;
    private final p1 invokeLoadMoreEvent;
    private final q1 invokeNotifyDataList;
    private final gs9.i moreState;
    private final r29.k pageState;
    private final r29.l refreshState;

    public CreationFeedComponentState() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationFeedComponentState copy$default(CreationFeedComponentState r4, List r5, r29.k r6, r29.l r7, gs9.i r8, p1 r9, q1 r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.creationModelList;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.pageState;
    L8:
        r29.k r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.refreshState;
    L11:
        r29.l r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.moreState;
    L14:
        gs9.i r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.invokeLoadMoreEvent;
    L17:
        p1 r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.invokeNotifyDataList;
    L20:
        List r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final List<UserCreationModel> component1() {
        return this.creationModelList;
    }

    public final r29.k component2() {
        return this.pageState;
    }

    public final r29.l component3() {
        return this.refreshState;
    }

    public final gs9.i component4() {
        return this.moreState;
    }

    public final p1 component5() {
        return this.invokeLoadMoreEvent;
    }

    public final q1 component6() {
        return this.invokeNotifyDataList;
    }

    public final CreationFeedComponentState copy(List<UserCreationModel> r9, r29.k r10, r29.l r11, gs9.i r12, p1 r13, q1 r14) {
        Intrinsics.checkNotNullParameter(r9, "creationModelList");
        Intrinsics.checkNotNullParameter(r10, "pageState");
        return new CreationFeedComponentState(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationFeedComponentState) == true) goto L8;
        return false;
    L8:
        CreationFeedComponentState r6 = (CreationFeedComponentState) r5;
        if (Intrinsics.areEqual(this.creationModelList, r6.creationModelList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageState, r6.pageState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refreshState, r6.refreshState) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moreState, r6.moreState) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.invokeLoadMoreEvent, r6.invokeLoadMoreEvent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.invokeNotifyDataList, r6.invokeNotifyDataList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.creationModelList.hashCode() * 31) + this.pageState.hashCode()) * 31;
        r29.l r1 = this.refreshState;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        gs9.i r5 = this.moreState;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        p1 r8 = this.invokeLoadMoreEvent;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        q1 r11 = this.invokeNotifyDataList;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationFeedComponentState(creationModelList=" + this.creationModelList + ", pageState=" + this.pageState + ", refreshState=" + this.refreshState + ", moreState=" + this.moreState + ", invokeLoadMoreEvent=" + this.invokeLoadMoreEvent + ", invokeNotifyDataList=" + this.invokeNotifyDataList + ')';
    }

    public final List<UserCreationModel> getCreationModelList() {
        return this.creationModelList;
    }

    public final p1 getInvokeLoadMoreEvent() {
        return this.invokeLoadMoreEvent;
    }

    public final q1 getInvokeNotifyDataList() {
        return this.invokeNotifyDataList;
    }

    public final gs9.i getMoreState() {
        return this.moreState;
    }

    public final r29.k getPageState() {
        return this.pageState;
    }

    public final r29.l getRefreshState() {
        return this.refreshState;
    }

    public CreationFeedComponentState(List<UserCreationModel> r2, r29.k r3, r29.l r4, gs9.i r5, p1 r6, q1 r7) {
        Intrinsics.checkNotNullParameter(r2, "creationModelList");
        Intrinsics.checkNotNullParameter(r3, "pageState");
        this.creationModelList = r2;
        this.pageState = r3;
        this.refreshState = r4;
        this.moreState = r5;
        this.invokeLoadMoreEvent = r6;
        this.invokeNotifyDataList = r7;
    }

    public /* synthetic */ CreationFeedComponentState(List r5, r29.k r6, r29.l r7, gs9.i r8, p1 r9, q1 r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = CollectionsKt.emptyList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r29.k.d.a;
    L8:
        r29.k r13 = r6;
        q1 r0 = null;
        if ((r11 & 4) == 0) goto L11;
        r29.l r1 = null;
    L13:
        if ((r11 & 8) == 0) goto L15;
        gs9.i r2 = null;
    L17:
        if ((r11 & 16) == 0) goto L19;
        p1 r3 = null;
    L21:
        if ((r11 & 32) != 0) goto L24;
        r0 = r10;
    L24:
        this(r5, r13, r1, r2, r3, r0);
        return;
    L19:
        r3 = r9;
        goto L21
    L15:
        r2 = r8;
        goto L17
    L11:
        r1 = r7;
        goto L13
    }
}
