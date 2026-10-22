package com.ss.android.lark.picker.doubao.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "", "isResigned", "", "isFrozen", "isOnLeave", "isExternal", "<init>", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoLocalChatterTagState {
    private final boolean isExternal;
    private final boolean isFrozen;
    private final boolean isOnLeave;
    private final boolean isResigned;

    public DoubaoLocalChatterTagState() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ DoubaoLocalChatterTagState copy$default(DoubaoLocalChatterTagState r0, boolean r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isResigned;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isFrozen;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.isOnLeave;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isExternal;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.isResigned;
    }

    public final boolean component2() {
        return this.isFrozen;
    }

    public final boolean component3() {
        return this.isOnLeave;
    }

    public final boolean component4() {
        return this.isExternal;
    }

    public final DoubaoLocalChatterTagState copy(boolean r2, boolean r3, boolean r4, boolean r5) {
        return new DoubaoLocalChatterTagState(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoubaoLocalChatterTagState) == true) goto L8;
        return false;
    L8:
        DoubaoLocalChatterTagState r6 = (DoubaoLocalChatterTagState) r5;
        if (this.isResigned == r6.isResigned) goto L12;
        return false;
    L12:
        if (this.isFrozen == r6.isFrozen) goto L15;
        return false;
    L15:
        if (this.isOnLeave == r6.isOnLeave) goto L18;
        return false;
    L18:
        if (this.isExternal == r6.isExternal) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isResigned == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isFrozen == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.isOnLeave == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.isExternal == true) goto L19;
        r1 = 1237;
    L19:
        return r6 + r1;
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "DoubaoLocalChatterTagState(isResigned=" + this.isResigned + ", isFrozen=" + this.isFrozen + ", isOnLeave=" + this.isOnLeave + ", isExternal=" + this.isExternal + ')';
    }

    public final boolean isExternal() {
        return this.isExternal;
    }

    public final boolean isFrozen() {
        return this.isFrozen;
    }

    public final boolean isOnLeave() {
        return this.isOnLeave;
    }

    public final boolean isResigned() {
        return this.isResigned;
    }

    public DoubaoLocalChatterTagState(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.isResigned = r1;
        this.isFrozen = r2;
        this.isOnLeave = r3;
        this.isExternal = r4;
    }

    public /* synthetic */ DoubaoLocalChatterTagState(boolean r2, boolean r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
