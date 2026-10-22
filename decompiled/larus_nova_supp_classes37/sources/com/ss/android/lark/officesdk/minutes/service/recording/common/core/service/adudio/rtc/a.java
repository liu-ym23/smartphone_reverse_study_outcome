package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.pb.videochat.Bandwidth;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final b a;
    public final MmRtcInitInfo b;
    public final Bandwidth c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Bandwidth r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRtcData(rtcInfo=" + this.a + ", vendorType=" + this.b + ".serverVendorType, rtcAppId=" + this.b + ".rtcAppId, businessId=" + this.b + ".businessId, isMediaOversea=" + this.b + ".isMediaOversea, isDataOversea=" + this.b + ".isDataOversea)";
    }

    public a(b r2, MmRtcInitInfo r3, Bandwidth r4) {
        Intrinsics.checkNotNullParameter(r2, "rtcInfo");
        Intrinsics.checkNotNullParameter(r3, "basicInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
