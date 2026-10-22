package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/address/y;", "", "", "offsetDistance", "I", "b", "()I", "setOffsetDistance", "(I)V", "noGpsRequestInterval", "a", "setNoGpsRequestInterval", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("no_gps_request_interval")
    private int noGpsRequestInterval;

    @SerializedName("offset_distance")
    private int offsetDistance;

    public y() {
        this(0);
    }

    public final int a() {
        return this.noGpsRequestInterval;
    }

    public final int b() {
        return this.offsetDistance;
    }

    public y(int r1) {
        this.offsetDistance = 500;
        this.noGpsRequestInterval = 2;
    }
}
