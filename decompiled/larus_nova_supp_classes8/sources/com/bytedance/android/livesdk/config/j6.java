package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/j6;", "", "", "enable", "Z", "b", "()Z", "", "Lcom/bytedance/android/livesdk/config/n4;", "backendConfigs", "Ljava/util/List;", "a", "()Ljava/util/List;", "feedConfigs", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j6 {

    @SerializedName("backend_configs")
    private final List<n4> backendConfigs;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("feed_configs")
    private final List<n4> feedConfigs;

    public j6() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j6) == false) goto L12;
        j6 r4 = (j6) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backendConfigs, r4.backendConfigs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedConfigs, r4.feedConfigs) == true) goto L19;
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
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<n4> r3 = this.backendConfigs;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<n4> r7 = this.feedConfigs;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "GameLiveEnterOptimizeConfig(enable=" + this.enable + ", backendConfigs=" + this.backendConfigs + ", feedConfigs=" + this.feedConfigs + ")";
    }

    public final List<n4> a() {
        return this.backendConfigs;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<n4> c() {
        return this.feedConfigs;
    }

    public j6(Object r3) {
        List<n4> r4 = CollectionsKt.emptyList();
        List<n4> r0 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r4, "backendConfigs");
        Intrinsics.checkNotNullParameter(r0, "feedConfigs");
        this.enable = false;
        this.backendConfigs = r4;
        this.feedConfigs = r0;
    }
}
