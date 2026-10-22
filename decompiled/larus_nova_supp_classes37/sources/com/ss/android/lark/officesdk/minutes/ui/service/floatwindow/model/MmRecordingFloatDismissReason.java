package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CLOSE", "PAGE_RESUME", "RECORDING_END", "RECORDING_INTERRUPTED", "SESSION_INACTIVE", "HOST_DISMISS", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatDismissReason extends Enum<MmRecordingFloatDismissReason> {
    public static final MmRecordingFloatDismissReason HOST_DISMISS = null;
    public static final MmRecordingFloatDismissReason PAGE_RESUME = null;
    public static final MmRecordingFloatDismissReason RECORDING_END = null;
    public static final MmRecordingFloatDismissReason RECORDING_INTERRUPTED = null;
    public static final MmRecordingFloatDismissReason SESSION_INACTIVE = null;
    public static final MmRecordingFloatDismissReason USER_CLOSE = null;
    public static final /* synthetic */ MmRecordingFloatDismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatDismissReason> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatDismissReason r0 = new MmRecordingFloatDismissReason("USER_CLOSE", 0);
        USER_CLOSE = r0;
        MmRecordingFloatDismissReason r1 = new MmRecordingFloatDismissReason("PAGE_RESUME", 1);
        PAGE_RESUME = r1;
        MmRecordingFloatDismissReason r3 = new MmRecordingFloatDismissReason("RECORDING_END", 2);
        RECORDING_END = r3;
        MmRecordingFloatDismissReason r5 = new MmRecordingFloatDismissReason("RECORDING_INTERRUPTED", 3);
        RECORDING_INTERRUPTED = r5;
        MmRecordingFloatDismissReason r7 = new MmRecordingFloatDismissReason("SESSION_INACTIVE", 4);
        SESSION_INACTIVE = r7;
        MmRecordingFloatDismissReason r9 = new MmRecordingFloatDismissReason("HOST_DISMISS", 5);
        HOST_DISMISS = r9;
        MmRecordingFloatDismissReason[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static MmRecordingFloatDismissReason[] values() {
        return (MmRecordingFloatDismissReason[]) a.clone();
    }

    public static MmRecordingFloatDismissReason valueOf(String r1) {
        return (MmRecordingFloatDismissReason) a.a(MmRecordingFloatDismissReason.class, r1);
    }

    public MmRecordingFloatDismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
