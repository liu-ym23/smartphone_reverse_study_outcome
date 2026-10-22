package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/config/PreviewAutoEnterConfig;", "", "playTimeSeconds", "", "countDownSeconds", "noAutoEnterHours", "frequencyCount", "noAutoEnterDays", "(IIIII)V", "getCountDownSeconds", "()I", "setCountDownSeconds", "(I)V", "getFrequencyCount", "setFrequencyCount", "getNoAutoEnterDays", "setNoAutoEnterDays", "getNoAutoEnterHours", "setNoAutoEnterHours", "getPlayTimeSeconds", "setPlayTimeSeconds", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAutoEnterConfig {

    @SerializedName("count_down_seconds")
    private int countDownSeconds;

    @SerializedName("frequency_count")
    private int frequencyCount;

    @SerializedName("no_auto_enter_days")
    private int noAutoEnterDays;

    @SerializedName("no_auto_enter_hours")
    private int noAutoEnterHours;

    @SerializedName("play_time_seconds")
    private int playTimeSeconds;

    public PreviewAutoEnterConfig() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ PreviewAutoEnterConfig copy$default(PreviewAutoEnterConfig r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.playTimeSeconds;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.countDownSeconds;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.noAutoEnterHours;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.frequencyCount;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.noAutoEnterDays;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.playTimeSeconds;
    }

    public final int component2() {
        return this.countDownSeconds;
    }

    public final int component3() {
        return this.noAutoEnterHours;
    }

    public final int component4() {
        return this.frequencyCount;
    }

    public final int component5() {
        return this.noAutoEnterDays;
    }

    public final PreviewAutoEnterConfig copy(int r8, int r9, int r10, int r11, int r12) {
        return new PreviewAutoEnterConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PreviewAutoEnterConfig) == false) goto L16;
        PreviewAutoEnterConfig r4 = (PreviewAutoEnterConfig) r3;
        if (this.playTimeSeconds == r4.playTimeSeconds) goto L8;
        return false;
    L8:
        if (this.countDownSeconds == r4.countDownSeconds) goto L10;
        return false;
    L10:
        if (this.noAutoEnterHours == r4.noAutoEnterHours) goto L12;
        return false;
    L12:
        if (this.frequencyCount == r4.frequencyCount) goto L14;
        return false;
    L14:
        if (this.noAutoEnterDays == r4.noAutoEnterDays) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return (((((((this.playTimeSeconds * 31) + this.countDownSeconds) * 31) + this.noAutoEnterHours) * 31) + this.frequencyCount) * 31) + this.noAutoEnterDays;
    }

    public String toString() {
        return "PreviewAutoEnterConfig(playTimeSeconds=" + this.playTimeSeconds + ", countDownSeconds=" + this.countDownSeconds + ", noAutoEnterHours=" + this.noAutoEnterHours + ", frequencyCount=" + this.frequencyCount + ", noAutoEnterDays=" + this.noAutoEnterDays + ")";
    }

    public final int getCountDownSeconds() {
        return this.countDownSeconds;
    }

    public final int getFrequencyCount() {
        return this.frequencyCount;
    }

    public final int getNoAutoEnterDays() {
        return this.noAutoEnterDays;
    }

    public final int getNoAutoEnterHours() {
        return this.noAutoEnterHours;
    }

    public final int getPlayTimeSeconds() {
        return this.playTimeSeconds;
    }

    public final void setCountDownSeconds(int r1) {
        this.countDownSeconds = r1;
    }

    public final void setFrequencyCount(int r1) {
        this.frequencyCount = r1;
    }

    public final void setNoAutoEnterDays(int r1) {
        this.noAutoEnterDays = r1;
    }

    public final void setNoAutoEnterHours(int r1) {
        this.noAutoEnterHours = r1;
    }

    public final void setPlayTimeSeconds(int r1) {
        this.playTimeSeconds = r1;
    }

    public PreviewAutoEnterConfig(int r1, int r2, int r3, int r4, int r5) {
        this.playTimeSeconds = r1;
        this.countDownSeconds = r2;
        this.noAutoEnterHours = r3;
        this.frequencyCount = r4;
        this.noAutoEnterDays = r5;
    }

    public /* synthetic */ PreviewAutoEnterConfig(int r4, int r5, int r6, int r7, int r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 10;
    L5:
        int r0 = 5;
        if ((r9 & 2) == 0) goto L8;
        int r11 = 5;
    L10:
        if ((r9 & 4) == 0) goto L12;
        int r1 = 24;
    L14:
        if ((r9 & 8) == 0) goto L16;
        int r2 = 20;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r0 = r8;
    L21:
        this(r4, r11, r1, r2, r0);
        return;
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
