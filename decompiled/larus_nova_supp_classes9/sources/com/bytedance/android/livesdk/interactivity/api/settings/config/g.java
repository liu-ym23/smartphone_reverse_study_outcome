package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/g;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableRenderOpt", "Z", "b", "()Z", BuildConfig.FLAVOR, "delayTime", "J", "a", "()J", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("delay_time")
    private final long delayTime;

    @SerializedName("enable_render_opt")
    private final boolean enableRenderOpt;

    public g() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof g) == false) goto L10;
        g r6 = (g) r5;
        if (this.enableRenderOpt == r6.enableRenderOpt) goto L8;
        return false;
    L8:
        if (this.delayTime == r6.delayTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.enableRenderOpt;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        long r2 = this.delayTime;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    }

    public final String toString() {
        return "DanmukuRenderOptConfig(enableRenderOpt=" + this.enableRenderOpt + ", delayTime=" + this.delayTime + ")";
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enableRenderOpt;
    }

    public g(int r3) {
        this.enableRenderOpt = false;
        this.delayTime = 60000;
    }
}
