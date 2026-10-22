package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmMinutesInfoToJS;", "Ljava/io/Serializable;", "titleName", "", "address", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "getAddress", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmMinutesInfoToJS implements Serializable {
    private final String address;
    private final String titleName;

    public MmMinutesInfoToJS() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MmMinutesInfoToJS copy$default(MmMinutesInfoToJS r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.titleName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.address;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.titleName;
    }

    public final String component2() {
        return this.address;
    }

    public final MmMinutesInfoToJS copy(String r2, String r3) {
        return new MmMinutesInfoToJS(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmMinutesInfoToJS) == true) goto L8;
        return false;
    L8:
        MmMinutesInfoToJS r6 = (MmMinutesInfoToJS) r5;
        if (Intrinsics.areEqual(this.titleName, r6.titleName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.titleName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.address;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MmMinutesInfoToJS(titleName=" + this.titleName + ", address=" + this.address + ')';
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public MmMinutesInfoToJS(String r1, String r2) {
        this.titleName = r1;
        this.address = r2;
    }

    public /* synthetic */ MmMinutesInfoToJS(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
