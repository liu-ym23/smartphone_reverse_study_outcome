package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/t0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "getEnable", "()Z", BuildConfig.FLAVOR, "scrollMsgCountFloor", "I", "getScrollMsgCountFloor", "()I", "scrollMsgCountUpper", "getScrollMsgCountUpper", "scrollTimesFloor", "getScrollTimesFloor", "scrollTimesUpper", "getScrollTimesUpper", "foldTimesFloor", "getFoldTimesFloor", "foldTimesUpper", "getFoldTimesUpper", "discardDelayMsgEnable", "getDiscardDelayMsgEnable", "discardDelayMsgTimeSec", "getDiscardDelayMsgTimeSec", BuildConfig.FLAVOR, "monitorTag", "Ljava/lang/String;", "getMonitorTag", "()Ljava/lang/String;", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("discard_delay_msg_enable")
    private final boolean discardDelayMsgEnable;

    @SerializedName("discard_delay_msg_time_sec")
    private final int discardDelayMsgTimeSec;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fold_times_floor")
    private final int foldTimesFloor;

    @SerializedName("fold_times_upper")
    private final int foldTimesUpper;

    @SerializedName("monitor_tag")
    private final String monitorTag;

    @SerializedName("scroll_msg_count_floor")
    private final int scrollMsgCountFloor;

    @SerializedName("scroll_msg_count_upper")
    private final int scrollMsgCountUpper;

    @SerializedName("scroll_times_floor")
    private final int scrollTimesFloor;

    @SerializedName("scroll_times_upper")
    private final int scrollTimesUpper;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t0) == false) goto L26;
        t0 r4 = (t0) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.scrollMsgCountFloor == r4.scrollMsgCountFloor) goto L10;
        return false;
    L10:
        if (this.scrollMsgCountUpper == r4.scrollMsgCountUpper) goto L12;
        return false;
    L12:
        if (this.scrollTimesFloor == r4.scrollTimesFloor) goto L14;
        return false;
    L14:
        if (this.scrollTimesUpper == r4.scrollTimesUpper) goto L16;
        return false;
    L16:
        if (this.foldTimesFloor == r4.foldTimesFloor) goto L18;
        return false;
    L18:
        if (this.foldTimesUpper == r4.foldTimesUpper) goto L20;
        return false;
    L20:
        if (this.discardDelayMsgEnable == r4.discardDelayMsgEnable) goto L22;
        return false;
    L22:
        if (this.discardDelayMsgTimeSec == r4.discardDelayMsgTimeSec) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.monitorTag, r4.monitorTag) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((((((((r2 * 31) + this.scrollMsgCountFloor) * 31) + this.scrollMsgCountUpper) * 31) + this.scrollTimesFloor) * 31) + this.scrollTimesUpper) * 31) + this.foldTimesFloor) * 31) + this.foldTimesUpper) * 31;
        boolean r4 = this.discardDelayMsgEnable;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (((r3 + r1) * 31) + this.discardDelayMsgTimeSec) * 31;
        String r6 = this.monitorTag;
        if (r6 == null) goto L12;
        int r7 = r6.hashCode();
    L14:
        return r5 + r7;
    L12:
        r7 = 0;
        goto L14
    }

    public final String toString() {
        return "PublicScreenUpdateHotOptConfig(enable=" + this.enable + ", scrollMsgCountFloor=" + this.scrollMsgCountFloor + ", scrollMsgCountUpper=" + this.scrollMsgCountUpper + ", scrollTimesFloor=" + this.scrollTimesFloor + ", scrollTimesUpper=" + this.scrollTimesUpper + ", foldTimesFloor=" + this.foldTimesFloor + ", foldTimesUpper=" + this.foldTimesUpper + ", discardDelayMsgEnable=" + this.discardDelayMsgEnable + ", discardDelayMsgTimeSec=" + this.discardDelayMsgTimeSec + ", monitorTag=" + this.monitorTag + ")";
    }

    public t0() {
        Intrinsics.checkNotNullParameter("normal", "monitorTag");
        this.enable = false;
        this.scrollMsgCountFloor = 3;
        this.scrollMsgCountUpper = 3;
        this.scrollTimesFloor = 2;
        this.scrollTimesUpper = 2;
        this.foldTimesFloor = 3;
        this.foldTimesUpper = 3;
        this.discardDelayMsgEnable = true;
        this.discardDelayMsgTimeSec = 10;
        this.monitorTag = "normal";
    }
}
