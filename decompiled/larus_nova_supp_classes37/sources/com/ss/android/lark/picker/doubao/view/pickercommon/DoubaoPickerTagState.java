package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JO\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "", "isResigned", "", "isFrozen", "isOnLeave", "isExternal", "isPublic", "isDepartment", "isAgent", "<init>", "(ZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerTagState {
    private final boolean isAgent;
    private final boolean isDepartment;
    private final boolean isExternal;
    private final boolean isFrozen;
    private final boolean isOnLeave;
    private final boolean isPublic;
    private final boolean isResigned;

    public DoubaoPickerTagState() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ DoubaoPickerTagState copy$default(DoubaoPickerTagState r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.isResigned;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.isFrozen;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.isOnLeave;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isExternal;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.isPublic;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isDepartment;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isAgent;
    L23:
        boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
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

    public final boolean component5() {
        return this.isPublic;
    }

    public final boolean component6() {
        return this.isDepartment;
    }

    public final boolean component7() {
        return this.isAgent;
    }

    public final DoubaoPickerTagState copy(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        return new DoubaoPickerTagState(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoubaoPickerTagState) == true) goto L8;
        return false;
    L8:
        DoubaoPickerTagState r6 = (DoubaoPickerTagState) r5;
        if (this.isResigned == r6.isResigned) goto L12;
        return false;
    L12:
        if (this.isFrozen == r6.isFrozen) goto L15;
        return false;
    L15:
        if (this.isOnLeave == r6.isOnLeave) goto L18;
        return false;
    L18:
        if (this.isExternal == r6.isExternal) goto L21;
        return false;
    L21:
        if (this.isPublic == r6.isPublic) goto L24;
        return false;
    L24:
        if (this.isDepartment == r6.isDepartment) goto L27;
        return false;
    L27:
        if (this.isAgent == r6.isAgent) goto L29;
        return false;
    L29:
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
        if (this.isExternal == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.isPublic == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.isDepartment == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.isAgent == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
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
        return "DoubaoPickerTagState(isResigned=" + this.isResigned + ", isFrozen=" + this.isFrozen + ", isOnLeave=" + this.isOnLeave + ", isExternal=" + this.isExternal + ", isPublic=" + this.isPublic + ", isDepartment=" + this.isDepartment + ", isAgent=" + this.isAgent + ')';
    }

    public final boolean isAgent() {
        return this.isAgent;
    }

    public final boolean isDepartment() {
        return this.isDepartment;
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

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean isResigned() {
        return this.isResigned;
    }

    public DoubaoPickerTagState(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.isResigned = r1;
        this.isFrozen = r2;
        this.isOnLeave = r3;
        this.isExternal = r4;
        this.isPublic = r5;
        this.isDepartment = r6;
        this.isAgent = r7;
    }

    public /* synthetic */ DoubaoPickerTagState(boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        boolean r16 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r14 & 4) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r14 & 8) == 0) goto L17;
        boolean r3 = false;
    L19:
        if ((r14 & 16) == 0) goto L21;
        boolean r4 = false;
    L23:
        if ((r14 & 32) == 0) goto L25;
        boolean r5 = false;
    L27:
        if ((r14 & 64) == 0) goto L29;
        boolean r17 = false;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
