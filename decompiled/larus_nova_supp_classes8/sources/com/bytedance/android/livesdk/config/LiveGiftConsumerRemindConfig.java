package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveGiftConsumerRemindConfig;", "", "enabled", "", "delay", "", "lynxSchema", "", "(ZILjava/lang/String;)V", "getDelay", "()I", "getEnabled", "()Z", "getLynxSchema", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftConsumerRemindConfig {

    @SerializedName("delay_time")
    private final int delay;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("lynx_schema")
    private final String lynxSchema;

    public LiveGiftConsumerRemindConfig() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ LiveGiftConsumerRemindConfig copy$default(LiveGiftConsumerRemindConfig r0, boolean r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enabled;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.delay;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.lynxSchema;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final int component2() {
        return this.delay;
    }

    public final String component3() {
        return this.lynxSchema;
    }

    public final LiveGiftConsumerRemindConfig copy(boolean r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxSchema");
        return new LiveGiftConsumerRemindConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveGiftConsumerRemindConfig) == false) goto L12;
        LiveGiftConsumerRemindConfig r4 = (LiveGiftConsumerRemindConfig) r3;
        if (this.enabled == r4.enabled) goto L8;
        return false;
    L8:
        if (this.delay == r4.delay) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxSchema, r4.lynxSchema) == true) goto L19;
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
        boolean r0 = this.enabled;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.delay) * 31;
        String r3 = this.lynxSchema;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public String toString() {
        return "LiveGiftConsumerRemindConfig(enabled=" + this.enabled + ", delay=" + this.delay + ", lynxSchema=" + this.lynxSchema + ")";
    }

    public final int getDelay() {
        return this.delay;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }

    public LiveGiftConsumerRemindConfig(boolean r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxSchema");
        this.enabled = r2;
        this.delay = r3;
        this.lynxSchema = r4;
    }

    public /* synthetic */ LiveGiftConsumerRemindConfig(boolean r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 5;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Frevenue_consume_calm_douyin%2Fpages%2Fcalm_setting%2Ftemplate.js&gravity=bottom&type=popup&rate_height=457";
    L11:
        this(r1, r2, r3);
    }
}
