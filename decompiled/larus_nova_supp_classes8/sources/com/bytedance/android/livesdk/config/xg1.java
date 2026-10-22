package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/xg1;", "", "", "enable", "Z", "getEnable", "()Z", "", "fixTargetWidth", "I", "getFixTargetWidth", "()I", "fixTargetHeight", "getFixTargetHeight", "maxSize", "getMaxSize", "", "resolution", "Ljava/lang/String;", "getResolution", "()Ljava/lang/String;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xg1 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fix_target_height")
    private final int fixTargetHeight;

    @SerializedName("fix_target_width")
    private final int fixTargetWidth;

    @SerializedName("max_size")
    private final int maxSize;

    @SerializedName("resolution")
    private final String resolution;

    public xg1() {
        this(0);
    }

    public xg1(int r2) {
        Intrinsics.checkNotNullParameter("uhd_60", "resolution");
        this.enable = true;
        this.fixTargetWidth = 1080;
        this.fixTargetHeight = 1920;
        this.maxSize = 3500000;
        this.resolution = "uhd_60";
    }
}
