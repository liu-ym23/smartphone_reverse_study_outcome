package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/b41;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "minimum_fling_velocity", "I", "e", "()I", "setMinimum_fling_velocity", "(I)V", "", "fling_distance_rate", "F", "d", "()F", "fling_animation_duration", "c", "drag_conflict_enable", "a", "setDrag_conflict_enable", "rank_no_touch_enable", "getRank_no_touch_enable", "setRank_no_touch_enable", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b41 {

    @SerializedName("drag_conflict_enable")
    private boolean drag_conflict_enable;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fling_animation_duration")
    private final int fling_animation_duration;

    @SerializedName("fling_distance_rate")
    private final float fling_distance_rate;

    @SerializedName("minimum_fling_velocity")
    private int minimum_fling_velocity;

    @SerializedName("rank_enable")
    private boolean rank_no_touch_enable;

    public b41() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b41) == false) goto L18;
        b41 r4 = (b41) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.minimum_fling_velocity == r4.minimum_fling_velocity) goto L10;
        return false;
    L10:
        if (Float.compare(this.fling_distance_rate, r4.fling_distance_rate) == 0) goto L12;
        return false;
    L12:
        if (this.fling_animation_duration == r4.fling_animation_duration) goto L14;
        return false;
    L14:
        if (this.drag_conflict_enable == r4.drag_conflict_enable) goto L16;
        return false;
    L16:
        if (this.rank_no_touch_enable == r4.rank_no_touch_enable) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((r2 * 31) + this.minimum_fling_velocity) * 31) + Float.floatToIntBits(this.fling_distance_rate)) * 31) + this.fling_animation_duration) * 31;
        boolean r4 = this.drag_conflict_enable;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.rank_no_touch_enable;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public final String toString() {
        return "LiveHorizontalGestureConfig(enable=" + this.enable + ", minimum_fling_velocity=" + this.minimum_fling_velocity + ", fling_distance_rate=" + this.fling_distance_rate + ", fling_animation_duration=" + this.fling_animation_duration + ", drag_conflict_enable=" + this.drag_conflict_enable + ", rank_no_touch_enable=" + this.rank_no_touch_enable + ")";
    }

    public final boolean a() {
        return this.drag_conflict_enable;
    }

    public final boolean b() {
        return this.enable;
    }

    public final int c() {
        return this.fling_animation_duration;
    }

    public final float d() {
        return this.fling_distance_rate;
    }

    public final int e() {
        return this.minimum_fling_velocity;
    }

    public b41(int r2) {
        this.enable = false;
        this.minimum_fling_velocity = 150;
        this.fling_distance_rate = 2.0f;
        this.fling_animation_duration = 200;
        this.drag_conflict_enable = false;
        this.rank_no_touch_enable = false;
    }
}
