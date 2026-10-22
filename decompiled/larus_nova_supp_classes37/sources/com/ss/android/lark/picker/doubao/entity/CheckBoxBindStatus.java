package com.ss.android.lark.picker.doubao.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/doubao/entity/CheckBoxBindStatus;", "", "isConsume", "", "isChecked", "isEnabled", "<init>", "(ZZZ)V", "()Z", "setConsume", "(Z)V", "setChecked", "setEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CheckBoxBindStatus {
    private boolean isChecked;
    private boolean isConsume;
    private boolean isEnabled;

    public CheckBoxBindStatus() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ CheckBoxBindStatus copy$default(CheckBoxBindStatus r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isConsume;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isChecked;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isEnabled;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isConsume;
    }

    public final boolean component2() {
        return this.isChecked;
    }

    public final boolean component3() {
        return this.isEnabled;
    }

    public final CheckBoxBindStatus copy(boolean r2, boolean r3, boolean r4) {
        return new CheckBoxBindStatus(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CheckBoxBindStatus) == true) goto L8;
        return false;
    L8:
        CheckBoxBindStatus r6 = (CheckBoxBindStatus) r5;
        if (this.isConsume == r6.isConsume) goto L12;
        return false;
    L12:
        if (this.isChecked == r6.isChecked) goto L15;
        return false;
    L15:
        if (this.isEnabled == r6.isEnabled) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isConsume == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isChecked == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.isEnabled == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CheckBoxBindStatus(isConsume=" + this.isConsume + ", isChecked=" + this.isChecked + ", isEnabled=" + this.isEnabled + ')';
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final boolean isConsume() {
        return this.isConsume;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setChecked(boolean r1) {
        this.isChecked = r1;
    }

    public final void setConsume(boolean r1) {
        this.isConsume = r1;
    }

    public final void setEnabled(boolean r1) {
        this.isEnabled = r1;
    }

    public CheckBoxBindStatus(boolean r1, boolean r2, boolean r3) {
        this.isConsume = r1;
        this.isChecked = r2;
        this.isEnabled = r3;
    }

    public /* synthetic */ CheckBoxBindStatus(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }
}
