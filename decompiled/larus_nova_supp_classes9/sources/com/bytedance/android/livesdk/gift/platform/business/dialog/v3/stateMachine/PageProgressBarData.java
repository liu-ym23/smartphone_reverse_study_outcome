package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PageProgressBarData;", BuildConfig.FLAVOR, "show", BuildConfig.FLAVOR, "percentage", BuildConfig.FLAVOR, "color", BuildConfig.FLAVOR, "(ZFI)V", "getColor", "()I", "getPercentage", "()F", "getShow", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageProgressBarData {
    private final int color;
    private final float percentage;
    private final boolean show;

    public PageProgressBarData() {
        this(false, 0.0f, 0, 7, null);
    }

    public static /* synthetic */ PageProgressBarData copy$default(PageProgressBarData r0, boolean r1, float r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.percentage;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.color;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.show;
    }

    public final float component2() {
        return this.percentage;
    }

    public final int component3() {
        return this.color;
    }

    public final PageProgressBarData copy(boolean r2, float r3, int r4) {
        return new PageProgressBarData(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PageProgressBarData) == false) goto L12;
        PageProgressBarData r4 = (PageProgressBarData) r3;
        if (this.show == r4.show) goto L8;
        return false;
    L8:
        if (Float.compare(this.percentage, r4.percentage) == 0) goto L10;
        return false;
    L10:
        if (this.color == r4.color) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.show;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((r1 * 31) + Float.floatToIntBits(this.percentage)) * 31) + this.color;
    }

    public String toString() {
        return "PageProgressBarData(show=" + this.show + ", percentage=" + this.percentage + ", color=" + this.color + ")";
    }

    public final int getColor() {
        return this.color;
    }

    public final float getPercentage() {
        return this.percentage;
    }

    public final boolean getShow() {
        return this.show;
    }

    public PageProgressBarData(boolean r1, float r2, int r3) {
        this.show = r1;
        this.percentage = r2;
        this.color = r3;
    }

    public /* synthetic */ PageProgressBarData(boolean r2, float r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
