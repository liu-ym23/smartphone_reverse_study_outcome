package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/n0;", "", "", "startColor", "Ljava/lang/String;", "getStartColor", "()Ljava/lang/String;", "setStartColor", "(Ljava/lang/String;)V", "endColor", "getEndColor", "setEndColor", "", "angle", "Ljava/lang/Double;", "getAngle", "()Ljava/lang/Double;", "setAngle", "(Ljava/lang/Double;)V", "", "textSizeUnselect", "Ljava/lang/Long;", "getTextSizeUnselect", "()Ljava/lang/Long;", "setTextSizeUnselect", "(Ljava/lang/Long;)V", "textSizeSelected", "getTextSizeSelected", "setTextSizeSelected", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n0 implements vh7.h {

    @SerializedName("angle")
    protected Double angle;

    @SerializedName("end_color")
    protected String endColor;

    @SerializedName("start_color")
    protected String startColor;

    @SerializedName("text_size_selected")
    protected Long textSizeSelected;

    @SerializedName("text_size_unselect")
    protected Long textSizeUnselect;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L16;
        n0 r4 = (n0) r3;
        if (Intrinsics.areEqual(this.startColor, r4.startColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.endColor, r4.endColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.angle, r4.angle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textSizeUnselect, r4.textSizeUnselect) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.textSizeSelected, r4.textSizeSelected) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.startColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.endColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.angle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r11 = this.textSizeUnselect;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Long r14 = this.textSizeSelected;
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

    public final String toString() {
        return "PlayListTabTitleFont(startColor=" + this.startColor + ", endColor=" + this.endColor + ", angle=" + this.angle + ", textSizeUnselect=" + this.textSizeUnselect + ", textSizeSelected=" + this.textSizeSelected + ")";
    }

    public n0() {
        this.startColor = null;
        this.endColor = null;
        this.angle = null;
        this.textSizeUnselect = null;
        this.textSizeSelected = null;
    }

    public n0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.startColor = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.endColor = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.angle = Double.valueOf(Double.longBitsToDouble(r5.h()));
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.textSizeUnselect = Long.valueOf(r5.j());
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.textSizeSelected = Long.valueOf(r5.j());
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.startColor != null) goto L25;
        this.startColor = null;
    L25:
        if (this.endColor != null) goto L28;
        this.endColor = null;
    L28:
        if (this.angle != null) goto L31;
        this.angle = null;
    L31:
        if (this.textSizeUnselect != null) goto L34;
        this.textSizeUnselect = null;
    L34:
        if (this.textSizeSelected != null) goto L55;
        this.textSizeSelected = null;
        return;
    }
}
