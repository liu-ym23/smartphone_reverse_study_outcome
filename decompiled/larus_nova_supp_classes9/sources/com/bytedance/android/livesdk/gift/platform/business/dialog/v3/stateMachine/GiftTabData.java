package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabData;", BuildConfig.FLAVOR, "title", BuildConfig.FLAVOR, "orderIcon", BuildConfig.FLAVOR, "isSelected", BuildConfig.FLAVOR, "showRedDot", "(Ljava/lang/String;Ljava/lang/Integer;ZZ)V", "()Z", "setSelected", "(Z)V", "getOrderIcon", "()Ljava/lang/Integer;", "setOrderIcon", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShowRedDot", "setShowRedDot", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZZ)Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTabData;", "equals", "other", "hashCode", "toString", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTabData {
    private boolean isSelected;
    private Integer orderIcon;
    private boolean showRedDot;
    private final String title;

    public static /* synthetic */ GiftTabData copy$default(GiftTabData r0, String r1, Integer r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.orderIcon;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.isSelected;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.showRedDot;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.orderIcon;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final boolean component4() {
        return this.showRedDot;
    }

    public final GiftTabData copy(String r2, Integer r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        return new GiftTabData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GiftTabData) == false) goto L14;
        GiftTabData r4 = (GiftTabData) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderIcon, r4.orderIcon) == true) goto L10;
        return false;
    L10:
        if (this.isSelected == r4.isSelected) goto L12;
        return false;
    L12:
        if (this.showRedDot == r4.showRedDot) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.orderIcon;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.isSelected;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.showRedDot;
        if (r10 == true) goto L17;
        r7 = r10;
    L17:
        return r9 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "GiftTabData(title=" + this.title + ", orderIcon=" + this.orderIcon + ", isSelected=" + this.isSelected + ", showRedDot=" + this.showRedDot + ")";
    }

    public final Integer getOrderIcon() {
        return this.orderIcon;
    }

    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setOrderIcon(Integer r1) {
        this.orderIcon = r1;
    }

    public final void setSelected(boolean r1) {
        this.isSelected = r1;
    }

    public final void setShowRedDot(boolean r1) {
        this.showRedDot = r1;
    }

    public GiftTabData(String r2, Integer r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.title = r2;
        this.orderIcon = r3;
        this.isSelected = r4;
        this.showRedDot = r5;
    }

    public /* synthetic */ GiftTabData(String r2, Integer r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = false;
    L8:
        this(r2, r3, r4, r5);
    }
}
