package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcVendorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VENDOR_TYPE_RTC", "VENDOR_TYPE_LARKRTC", "VENDOR_TYPE_LARKPRERTC", "VENDOR_TYPE_TEST_PRE", "VENDOR_TYPE_TEST_GAUSS", "VENDOR_TYPE_TEST", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRtcVendorType extends Enum<MmRtcVendorType> {
    public static final MmRtcVendorType VENDOR_TYPE_LARKPRERTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_LARKRTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_RTC = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST_GAUSS = null;
    public static final MmRtcVendorType VENDOR_TYPE_TEST_PRE = null;
    public static final /* synthetic */ MmRtcVendorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmRtcVendorType> getEntries() {
        return b;
    }

    static {
        MmRtcVendorType r0 = new MmRtcVendorType("VENDOR_TYPE_RTC", 0, 0);
        VENDOR_TYPE_RTC = r0;
        MmRtcVendorType r1 = new MmRtcVendorType("VENDOR_TYPE_LARKRTC", 1, 1);
        VENDOR_TYPE_LARKRTC = r1;
        MmRtcVendorType r3 = new MmRtcVendorType("VENDOR_TYPE_LARKPRERTC", 2, 2);
        VENDOR_TYPE_LARKPRERTC = r3;
        MmRtcVendorType r5 = new MmRtcVendorType("VENDOR_TYPE_TEST_PRE", 3, 240);
        VENDOR_TYPE_TEST_PRE = r5;
        MmRtcVendorType r7 = new MmRtcVendorType("VENDOR_TYPE_TEST_GAUSS", 4, 241);
        VENDOR_TYPE_TEST_GAUSS = r7;
        MmRtcVendorType r8 = new MmRtcVendorType("VENDOR_TYPE_TEST", 5, 255);
        VENDOR_TYPE_TEST = r8;
        MmRtcVendorType[] r10 = {r0, r1, r3, r5, r7, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static MmRtcVendorType[] values() {
        return (MmRtcVendorType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmRtcVendorType valueOf(String r1) {
        return (MmRtcVendorType) r27.a.a(MmRtcVendorType.class, r1);
    }

    public MmRtcVendorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
