package com.bytedance.android.ec.core.address.api;

import com.bytedance.android.ec.core.address.z;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/core/address/api/RecommendAddressConfig;", "Ljava/io/Serializable;", "invalidTime", "", "bizCode", "", "(JLjava/lang/String;)V", "getBizCode", "()Ljava/lang/String;", "setBizCode", "(Ljava/lang/String;)V", "getInvalidTime", "()J", "setInvalidTime", "(J)V", "adjustInvalidTime", "", "serverTime", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendAddressConfig implements Serializable {

    @SerializedName("biz_code")
    private String bizCode;

    @SerializedName("invalid_time")
    private long invalidTime;

    public final String getBizCode() {
        return this.bizCode;
    }

    public final long getInvalidTime() {
        return this.invalidTime;
    }

    public final void adjustInvalidTime(long r10) {
        this.invalidTime += z.j() - r10;
    }

    public final void setBizCode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.bizCode = r10;
    }

    public final void setInvalidTime(long r1) {
        this.invalidTime = r1;
    }

    public RecommendAddressConfig(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "bizCode");
        this.invalidTime = r10;
        this.bizCode = r11;
    }

    public /* synthetic */ RecommendAddressConfig(long r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r1 = z.j() + ((long) 1800);
    L5:
        this(r1, r10);
    }
}
