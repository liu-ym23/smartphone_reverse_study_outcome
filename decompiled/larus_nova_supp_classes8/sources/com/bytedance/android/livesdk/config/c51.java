package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/c51;", "", "", "digHoleOpt", "Z", "a", "()Z", "", "margin", "I", "b", "()I", "", "maskAlpha", "F", "c", "()F", "cutoutShortEdges", "getCutoutShortEdges", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c51 {

    @SerializedName("cutout_short_edges")
    private final boolean cutoutShortEdges;

    @SerializedName("dig_hole_opt")
    private final boolean digHoleOpt;

    @SerializedName("margin_min")
    private final int margin;

    @SerializedName("mask_alpha")
    private final float maskAlpha;

    public c51() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c51) == false) goto L14;
        c51 r4 = (c51) r3;
        if (this.digHoleOpt == r4.digHoleOpt) goto L8;
        return false;
    L8:
        if (this.margin == r4.margin) goto L10;
        return false;
    L10:
        if (Float.compare(this.maskAlpha, r4.maskAlpha) == 0) goto L12;
        return false;
    L12:
        if (this.cutoutShortEdges == r4.cutoutShortEdges) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.digHoleOpt;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((r2 * 31) + this.margin) * 31) + Float.floatToIntBits(this.maskAlpha)) * 31;
        boolean r4 = this.cutoutShortEdges;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public final String toString() {
        return "LiveLandscapeMarginConfig(digHoleOpt=" + this.digHoleOpt + ", margin=" + this.margin + ", maskAlpha=" + this.maskAlpha + ", cutoutShortEdges=" + this.cutoutShortEdges + ")";
    }

    public final boolean a() {
        return this.digHoleOpt;
    }

    public final int b() {
        return this.margin;
    }

    public final float c() {
        return this.maskAlpha;
    }

    public c51(int r2) {
        this.digHoleOpt = false;
        this.margin = 20;
        this.maskAlpha = 1.0f;
        this.cutoutShortEdges = false;
    }
}
