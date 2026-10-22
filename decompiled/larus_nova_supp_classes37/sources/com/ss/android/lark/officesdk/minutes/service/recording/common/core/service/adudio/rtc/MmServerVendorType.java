package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmServerVendorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_VENDOR_TYPE", "ZOOM", "RTC", "LARK_RTC", "LARK_PRE_RTC", "LARK_RTC_TEST_PRE", "LARK_RTC_TEST_GAUSS", "LARK_RTC_TEST", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmServerVendorType extends Enum<MmServerVendorType> {
    public static final a Companion = null;
    public static final MmServerVendorType LARK_PRE_RTC = null;
    public static final MmServerVendorType LARK_RTC = null;
    public static final MmServerVendorType LARK_RTC_TEST = null;
    public static final MmServerVendorType LARK_RTC_TEST_GAUSS = null;
    public static final MmServerVendorType LARK_RTC_TEST_PRE = null;
    public static final MmServerVendorType RTC = null;
    public static final MmServerVendorType UNKNOWN_VENDOR_TYPE = null;
    public static final MmServerVendorType ZOOM = null;
    public static final /* synthetic */ MmServerVendorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmServerVendorType$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0025a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MmServerVendorType.values().length];
                r0[MmServerVendorType.LARK_RTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[MmServerVendorType.LARK_PRE_RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[MmServerVendorType.LARK_RTC_TEST_PRE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[MmServerVendorType.LARK_RTC_TEST_GAUSS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[MmServerVendorType.LARK_RTC_TEST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public a() {
        }
    }

    public static EnumEntries<MmServerVendorType> getEntries() {
        return b;
    }

    static {
        MmServerVendorType r0 = new MmServerVendorType("UNKNOWN_VENDOR_TYPE", 0, 0);
        UNKNOWN_VENDOR_TYPE = r0;
        MmServerVendorType r1 = new MmServerVendorType("ZOOM", 1, 1);
        ZOOM = r1;
        MmServerVendorType r3 = new MmServerVendorType("RTC", 2, 2);
        RTC = r3;
        MmServerVendorType r5 = new MmServerVendorType("LARK_RTC", 3, 3);
        LARK_RTC = r5;
        MmServerVendorType r7 = new MmServerVendorType("LARK_PRE_RTC", 4, 4);
        LARK_PRE_RTC = r7;
        MmServerVendorType r9 = new MmServerVendorType("LARK_RTC_TEST_PRE", 5, 240);
        LARK_RTC_TEST_PRE = r9;
        MmServerVendorType r11 = new MmServerVendorType("LARK_RTC_TEST_GAUSS", 6, 241);
        LARK_RTC_TEST_GAUSS = r11;
        MmServerVendorType r13 = new MmServerVendorType("LARK_RTC_TEST", 7, 255);
        LARK_RTC_TEST = r13;
        MmServerVendorType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static MmServerVendorType[] values() {
        return (MmServerVendorType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmServerVendorType valueOf(String r1) {
        return (MmServerVendorType) r27.a.a(MmServerVendorType.class, r1);
    }

    public MmServerVendorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
