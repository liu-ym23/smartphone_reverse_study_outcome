package com.bytedance.android.ec.core.abtest;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/k;", "", "", "explainingHeadShrink", "Z", "b", "()Z", "", "explainingHeadShrinkNewSize", "F", "c", "()F", "bizHeadShrink", "a", "", "halfHeadSpaceOpt", "I", "getHalfHeadSpaceOpt", "()I", "headSpace", "f", "halfPdpSlideCloseThresholdOpt", "d", "headSelectedPositionOpt", "e", "moreVideoOnlyShowInFullSwitch", "g", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("biz_head_shrink")
    private final boolean bizHeadShrink;

    @SerializedName("explaining_head_shrink")
    private final boolean explainingHeadShrink;

    @SerializedName("explaining_head_shrink_new_size")
    private final float explainingHeadShrinkNewSize;

    @SerializedName("half_head_space_opt")
    private final int halfHeadSpaceOpt;

    @SerializedName("half_pdp_slide_close_threshold_opt")
    private final boolean halfPdpSlideCloseThresholdOpt;

    @SerializedName("head_selected_position_opt")
    private final boolean headSelectedPositionOpt;

    @SerializedName("head_space")
    private final int headSpace;

    @SerializedName("more_video_only_show_in_full_switch")
    private final boolean moreVideoOnlyShowInFullSwitch;

    public k() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof k) == false) goto L22;
        k r11 = (k) r10;
        if (this.explainingHeadShrink == r11.explainingHeadShrink) goto L8;
        return false;
    L8:
        if (Float.compare(this.explainingHeadShrinkNewSize, r11.explainingHeadShrinkNewSize) == 0) goto L10;
        return false;
    L10:
        if (this.bizHeadShrink == r11.bizHeadShrink) goto L12;
        return false;
    L12:
        if (this.halfHeadSpaceOpt == r11.halfHeadSpaceOpt) goto L14;
        return false;
    L14:
        if (this.headSpace == r11.headSpace) goto L16;
        return false;
    L16:
        if (this.halfPdpSlideCloseThresholdOpt == r11.halfPdpSlideCloseThresholdOpt) goto L18;
        return false;
    L18:
        if (this.headSelectedPositionOpt == r11.headSelectedPositionOpt) goto L20;
        return false;
    L20:
        if (this.moreVideoOnlyShowInFullSwitch == r11.moreVideoOnlyShowInFullSwitch) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r0 = this.explainingHeadShrink;
        ?? r1 = 1;
        ?? r10 = r0;
        if (r0 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = ((r10 * 31) + Float.floatToIntBits(this.explainingHeadShrinkNewSize)) * 31;
        boolean r12 = this.bizHeadShrink;
        ?? r13 = r12;
        if (r12 == false) goto L8;
        r13 = 1;
    L8:
        int r14 = (((((r11 + r13) * 31) + this.halfHeadSpaceOpt) * 31) + this.headSpace) * 31;
        boolean r15 = this.halfPdpSlideCloseThresholdOpt;
        ?? r16 = r15;
        if (r15 == false) goto L11;
        r16 = 1;
    L11:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.headSelectedPositionOpt;
        ?? r19 = r18;
        if (r18 == false) goto L14;
        r19 = 1;
    L14:
        int r20 = (r17 + r19) * 31;
        boolean r21 = this.moreVideoOnlyShowInFullSwitch;
        if (r21 == true) goto L19;
        r1 = r21;
    L19:
        return r20 + r1;
    }

    public final String toString() {
        return "PdpHeadShrinkConfig(explainingHeadShrink=" + this.explainingHeadShrink + ", explainingHeadShrinkNewSize=" + this.explainingHeadShrinkNewSize + ", bizHeadShrink=" + this.bizHeadShrink + ", halfHeadSpaceOpt=" + this.halfHeadSpaceOpt + ", headSpace=" + this.headSpace + ", halfPdpSlideCloseThresholdOpt=" + this.halfPdpSlideCloseThresholdOpt + ", headSelectedPositionOpt=" + this.headSelectedPositionOpt + ", moreVideoOnlyShowInFullSwitch=" + this.moreVideoOnlyShowInFullSwitch + ")";
    }

    public final boolean a() {
        return this.bizHeadShrink;
    }

    public final boolean b() {
        return this.explainingHeadShrink;
    }

    public final float c() {
        return this.explainingHeadShrinkNewSize;
    }

    public final boolean d() {
        return this.halfPdpSlideCloseThresholdOpt;
    }

    public final boolean e() {
        return this.headSelectedPositionOpt;
    }

    public final int f() {
        return this.headSpace;
    }

    public final boolean g() {
        return this.moreVideoOnlyShowInFullSwitch;
    }

    public k(int r10) {
        this.explainingHeadShrink = false;
        this.explainingHeadShrinkNewSize = 0.0f;
        this.bizHeadShrink = false;
        this.halfHeadSpaceOpt = 0;
        this.headSpace = 2;
        this.halfPdpSlideCloseThresholdOpt = true;
        this.headSelectedPositionOpt = true;
        this.moreVideoOnlyShowInFullSwitch = true;
    }
}
