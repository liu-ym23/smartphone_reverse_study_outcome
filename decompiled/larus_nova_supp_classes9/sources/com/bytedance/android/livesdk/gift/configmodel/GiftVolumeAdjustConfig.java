package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/GiftVolumeAdjustConfig;", BuildConfig.FLAVOR, "minDB", BuildConfig.FLAVOR, "maxDB", "leftDB", "rightDB", "minVolume", BuildConfig.FLAVOR, "maxVolume", "(IIIIFF)V", "getLeftDB", "()I", "getMaxDB", "getMaxVolume", "()F", "getMinDB", "getMinVolume", "getRightDB", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftVolumeAdjustConfig {

    @SerializedName("default_volume_range_left_dB")
    private final int leftDB;

    @SerializedName("max_dB")
    private final int maxDB;

    @SerializedName("max_volume")
    private final float maxVolume;

    @SerializedName("min_dB")
    private final int minDB;

    @SerializedName("min_volume")
    private final float minVolume;

    @SerializedName("default_volume_range_right_dB")
    private final int rightDB;

    public GiftVolumeAdjustConfig() {
        this(0, 0, 0, 0, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ GiftVolumeAdjustConfig copy$default(GiftVolumeAdjustConfig r4, int r5, int r6, int r7, int r8, float r9, float r10, int r11, Object r13) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.minDB;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.maxDB;
    L8:
        int r14 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.leftDB;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.rightDB;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.minVolume;
    L17:
        float r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.maxVolume;
    L20:
        int r15 = r5;
        return r4.copy(r15, r14, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.minDB;
    }

    public final int component2() {
        return this.maxDB;
    }

    public final int component3() {
        return this.leftDB;
    }

    public final int component4() {
        return this.rightDB;
    }

    public final float component5() {
        return this.minVolume;
    }

    public final float component6() {
        return this.maxVolume;
    }

    public final GiftVolumeAdjustConfig copy(int r9, int r10, int r11, int r13, float r14, float r15) {
        return new GiftVolumeAdjustConfig(r9, r10, r11, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GiftVolumeAdjustConfig) == false) goto L18;
        GiftVolumeAdjustConfig r4 = (GiftVolumeAdjustConfig) r3;
        if (this.minDB == r4.minDB) goto L8;
        return false;
    L8:
        if (this.maxDB == r4.maxDB) goto L10;
        return false;
    L10:
        if (this.leftDB == r4.leftDB) goto L12;
        return false;
    L12:
        if (this.rightDB == r4.rightDB) goto L14;
        return false;
    L14:
        if (Float.compare(this.minVolume, r4.minVolume) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.maxVolume, r4.maxVolume) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((((((((this.minDB * 31) + this.maxDB) * 31) + this.leftDB) * 31) + this.rightDB) * 31) + Float.floatToIntBits(this.minVolume)) * 31) + Float.floatToIntBits(this.maxVolume);
    }

    public String toString() {
        return "GiftVolumeAdjustConfig(minDB=" + this.minDB + ", maxDB=" + this.maxDB + ", leftDB=" + this.leftDB + ", rightDB=" + this.rightDB + ", minVolume=" + this.minVolume + ", maxVolume=" + this.maxVolume + ")";
    }

    public final int getLeftDB() {
        return this.leftDB;
    }

    public final int getMaxDB() {
        return this.maxDB;
    }

    public final float getMaxVolume() {
        return this.maxVolume;
    }

    public final int getMinDB() {
        return this.minDB;
    }

    public final float getMinVolume() {
        return this.minVolume;
    }

    public final int getRightDB() {
        return this.rightDB;
    }

    public GiftVolumeAdjustConfig(int r1, int r2, int r3, int r4, float r5, float r6) {
        this.minDB = r1;
        this.maxDB = r2;
        this.leftDB = r3;
        this.rightDB = r4;
        this.minVolume = r5;
        this.maxVolume = r6;
    }

    public /* synthetic */ GiftVolumeAdjustConfig(int r5, int r6, int r7, int r8, float r9, float r10, int r11, DefaultConstructorMarker r13) {
        if ((r11 & 1) == 0) goto L6;
        r5 = -40;
    L6:
        if ((r11 & 2) == 0) goto L8;
        int r14 = -8;
    L10:
        if ((r11 & 4) == 0) goto L12;
        int r0 = -25;
    L14:
        if ((r11 & 8) == 0) goto L16;
        int r1 = -20;
    L18:
        if ((r11 & 16) == 0) goto L20;
        float r2 = 0.5f;
    L22:
        if ((r11 & 32) == 0) goto L24;
        float r3 = 2.0f;
    L25:
        this(r5, r14, r0, r1, r2, r3);
        return;
    L24:
        r3 = r10;
        goto L25
    L20:
        r2 = r9;
        goto L22
    L16:
        r1 = r8;
        goto L18
    L12:
        r0 = r7;
        goto L14
    L8:
        r14 = r6;
        goto L10
    }
}
