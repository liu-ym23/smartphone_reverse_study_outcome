package com.ss.android.lark.picker.doubao.organization;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "", "isSelected", "", "isEnabled", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoOrganizationItemState {
    private final boolean isEnabled;
    private final boolean isSelected;

    public static /* synthetic */ DoubaoOrganizationItemState copy$default(DoubaoOrganizationItemState r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isSelected;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isEnabled;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isSelected;
    }

    public final boolean component2() {
        return this.isEnabled;
    }

    public final DoubaoOrganizationItemState copy(boolean r2, boolean r3) {
        return new DoubaoOrganizationItemState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoubaoOrganizationItemState) == true) goto L8;
        return false;
    L8:
        DoubaoOrganizationItemState r6 = (DoubaoOrganizationItemState) r5;
        if (this.isSelected == r6.isSelected) goto L12;
        return false;
    L12:
        if (this.isEnabled == r6.isEnabled) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isSelected == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isEnabled == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "DoubaoOrganizationItemState(isSelected=" + this.isSelected + ", isEnabled=" + this.isEnabled + ')';
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public DoubaoOrganizationItemState(boolean r1, boolean r2) {
        this.isSelected = r1;
        this.isEnabled = r2;
    }
}
