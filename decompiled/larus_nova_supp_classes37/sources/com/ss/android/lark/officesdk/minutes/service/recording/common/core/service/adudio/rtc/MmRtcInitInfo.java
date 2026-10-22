package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcInitInfo;", "Ljava/io/Serializable;", "serverVendorType", "", "rtcAppId", "", "businessId", "isMediaOversea", "", "isDataOversea", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZZ)V", "getServerVendorType", "()I", "getRtcAppId", "()Ljava/lang/String;", "getBusinessId", "()Z", "getRtcVendorType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcVendorType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRtcInitInfo implements Serializable {

    @SerializedName("businessId")
    private final String businessId;

    @SerializedName("isDataOversea")
    private final boolean isDataOversea;

    @SerializedName("isMediaOversea")
    private final boolean isMediaOversea;

    @SerializedName("rtcAppId")
    private final String rtcAppId;

    @SerializedName("serverVendorType")
    private final int serverVendorType;

    public static /* synthetic */ MmRtcInitInfo copy$default(MmRtcInitInfo r3, int r4, String r5, String r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.serverVendorType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.rtcAppId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.businessId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isMediaOversea;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isDataOversea;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.serverVendorType;
    }

    public final String component2() {
        return this.rtcAppId;
    }

    public final String component3() {
        return this.businessId;
    }

    public final boolean component4() {
        return this.isMediaOversea;
    }

    public final boolean component5() {
        return this.isDataOversea;
    }

    public final MmRtcInitInfo copy(int r8, String r9, String r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "rtcAppId");
        Intrinsics.checkNotNullParameter(r10, "businessId");
        return new MmRtcInitInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRtcInitInfo) == true) goto L8;
        return false;
    L8:
        MmRtcInitInfo r6 = (MmRtcInitInfo) r5;
        if (this.serverVendorType == r6.serverVendorType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rtcAppId, r6.rtcAppId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.businessId, r6.businessId) == true) goto L18;
        return false;
    L18:
        if (this.isMediaOversea == r6.isMediaOversea) goto L21;
        return false;
    L21:
        if (this.isDataOversea == r6.isDataOversea) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.serverVendorType * 31) + this.rtcAppId.hashCode()) * 31) + this.businessId.hashCode()) * 31;
        int r2 = 1231;
        if (this.isMediaOversea == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isDataOversea == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRtcInitInfo(serverVendorType=" + this.serverVendorType + ", rtcAppId=" + this.rtcAppId + ", businessId=" + this.businessId + ", isMediaOversea=" + this.isMediaOversea + ", isDataOversea=" + this.isDataOversea + ')';
    }

    public final MmRtcVendorType getRtcVendorType() {
        MmServerVendorType.a r0 = MmServerVendorType.Companion;
        int r1 = this.serverVendorType;
        r0.getClass();
        MmServerVendorType[] r2 = MmServerVendorType.values();
        int r3 = r2.length;
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L12;
        MmServerVendorType r6 = r2[r4];
        if (r6.getValue() != r1) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r6 != null) goto L15;
        r6 = MmServerVendorType.UNKNOWN_VENDOR_TYPE;
    L15:
        int r5 = MmServerVendorType.a.C0025a.a[r6.ordinal()];
        if (r5 == 1) goto L31;
        if (r5 == 2) goto L38;
        if (r5 == 3) goto L37;
        if (r5 == 4) goto L36;
        if (r5 == 5) goto L35;
        return MmRtcVendorType.VENDOR_TYPE_RTC;
    L35:
        return MmRtcVendorType.VENDOR_TYPE_TEST;
    L36:
        return MmRtcVendorType.VENDOR_TYPE_TEST_GAUSS;
    L37:
        return MmRtcVendorType.VENDOR_TYPE_TEST_PRE;
    L38:
        return MmRtcVendorType.VENDOR_TYPE_LARKPRERTC;
    L31:
        return MmRtcVendorType.VENDOR_TYPE_LARKRTC;
    L8:
        r7 = false;
        goto L9
    L12:
        r6 = null;
        goto L13
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    public final int getServerVendorType() {
        return this.serverVendorType;
    }

    public final boolean isDataOversea() {
        return this.isDataOversea;
    }

    public final boolean isMediaOversea() {
        return this.isMediaOversea;
    }

    public MmRtcInitInfo(int r2, String r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "rtcAppId");
        Intrinsics.checkNotNullParameter(r4, "businessId");
        this.serverVendorType = r2;
        this.rtcAppId = r3;
        this.businessId = r4;
        this.isMediaOversea = r5;
        this.isDataOversea = r6;
    }

    public /* synthetic */ MmRtcInitInfo(int r7, String r8, String r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = "";
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
