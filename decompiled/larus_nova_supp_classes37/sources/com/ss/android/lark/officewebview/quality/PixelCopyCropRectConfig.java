package com.ss.android.lark.officewebview.quality;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/PixelCopyCropRectConfig;", "", "leftDp", "", "topDp", "rightDp", "bottomDp", "<init>", "(FFFF)V", "getLeftDp", "()F", "setLeftDp", "(F)V", "getTopDp", "setTopDp", "getRightDp", "setRightDp", "getBottomDp", "setBottomDp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PixelCopyCropRectConfig {

    @SerializedName("bottom_dp")
    private float bottomDp;

    @SerializedName("left_dp")
    private float leftDp;

    @SerializedName("right_dp")
    private float rightDp;

    @SerializedName("top_dp")
    private float topDp;

    public PixelCopyCropRectConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ PixelCopyCropRectConfig copy$default(PixelCopyCropRectConfig r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.leftDp;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.topDp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rightDp;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bottomDp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final float component1() {
        return this.leftDp;
    }

    public final float component2() {
        return this.topDp;
    }

    public final float component3() {
        return this.rightDp;
    }

    public final float component4() {
        return this.bottomDp;
    }

    public final PixelCopyCropRectConfig copy(float r2, float r3, float r4, float r5) {
        return new PixelCopyCropRectConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PixelCopyCropRectConfig) == true) goto L8;
        return false;
    L8:
        PixelCopyCropRectConfig r6 = (PixelCopyCropRectConfig) r5;
        if (Float.compare(this.leftDp, r6.leftDp) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.topDp, r6.topDp) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.rightDp, r6.rightDp) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.bottomDp, r6.bottomDp) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.leftDp) * 31) + Float.floatToIntBits(this.topDp)) * 31) + Float.floatToIntBits(this.rightDp)) * 31) + Float.floatToIntBits(this.bottomDp);
    }

    public String toString() {
        return "PixelCopyCropRectConfig(leftDp=" + this.leftDp + ", topDp=" + this.topDp + ", rightDp=" + this.rightDp + ", bottomDp=" + this.bottomDp + ')';
    }

    public final float getBottomDp() {
        return this.bottomDp;
    }

    public final float getLeftDp() {
        return this.leftDp;
    }

    public final float getRightDp() {
        return this.rightDp;
    }

    public final float getTopDp() {
        return this.topDp;
    }

    public final void setBottomDp(float r1) {
        this.bottomDp = r1;
    }

    public final void setLeftDp(float r1) {
        this.leftDp = r1;
    }

    public final void setRightDp(float r1) {
        this.rightDp = r1;
    }

    public final void setTopDp(float r1) {
        this.topDp = r1;
    }

    public PixelCopyCropRectConfig(float r1, float r2, float r3, float r4) {
        this.leftDp = r1;
        this.topDp = r2;
        this.rightDp = r3;
        this.bottomDp = r4;
    }

    public /* synthetic */ PixelCopyCropRectConfig(float r2, float r3, float r4, float r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0.0f;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0.0f;
    L14:
        this(r2, r3, r4, r5);
    }
}
