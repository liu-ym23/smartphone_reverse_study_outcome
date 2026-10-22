package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/audio/GuideConfig;", "", "guideX", "", "guideY", "", "guideM", "guideN", "<init>", "(FIFF)V", "getGuideX", "()F", "getGuideY", "()I", "getGuideM", "getGuideN", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GuideConfig {

    @SerializedName("open_tts_guide_m")
    private final float guideM;

    @SerializedName("open_tts_guide_n")
    private final float guideN;

    @SerializedName("open_tts_guide_x")
    private final float guideX;

    @SerializedName("open_tts_guide_y")
    private final int guideY;

    public GuideConfig() {
        this(0.0f, 0, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ GuideConfig copy$default(GuideConfig r0, float r1, int r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.guideX;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.guideY;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.guideM;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.guideN;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final float component1() {
        return this.guideX;
    }

    public final int component2() {
        return this.guideY;
    }

    public final float component3() {
        return this.guideM;
    }

    public final float component4() {
        return this.guideN;
    }

    public final GuideConfig copy(float r2, int r3, float r4, float r5) {
        return new GuideConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GuideConfig) == true) goto L8;
        return false;
    L8:
        GuideConfig r6 = (GuideConfig) r5;
        if (Float.compare(this.guideX, r6.guideX) == 0) goto L12;
        return false;
    L12:
        if (this.guideY == r6.guideY) goto L15;
        return false;
    L15:
        if (Float.compare(this.guideM, r6.guideM) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.guideN, r6.guideN) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.guideX) * 31) + this.guideY) * 31) + Float.floatToIntBits(this.guideM)) * 31) + Float.floatToIntBits(this.guideN);
    }

    public String toString() {
        return "GuideConfig(guideX=" + this.guideX + ", guideY=" + this.guideY + ", guideM=" + this.guideM + ", guideN=" + this.guideN + ')';
    }

    public final float getGuideM() {
        return this.guideM;
    }

    public final float getGuideN() {
        return this.guideN;
    }

    public final float getGuideX() {
        return this.guideX;
    }

    public final int getGuideY() {
        return this.guideY;
    }

    public GuideConfig(float r1, int r2, float r3, float r4) {
        this.guideX = r1;
        this.guideY = r2;
        this.guideM = r3;
        this.guideN = r4;
    }

    public /* synthetic */ GuideConfig(float r2, int r3, float r4, float r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = -1.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = -1.0f;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = -1.0f;
    L14:
        this(r2, r3, r4, r5);
    }
}
