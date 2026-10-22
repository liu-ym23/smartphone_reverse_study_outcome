package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/service/floatwindow/model/MmRecordingFloatFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "NO_PERMISSION", "CONTEXT_UNAVAILABLE", "SESSION_INACTIVE", "HOST_CREATE_FAILED", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingFloatFailureReason extends Enum<MmRecordingFloatFailureReason> {
    public static final MmRecordingFloatFailureReason CONTEXT_UNAVAILABLE = null;
    public static final MmRecordingFloatFailureReason HOST_CREATE_FAILED = null;
    public static final MmRecordingFloatFailureReason NO_PERMISSION = null;
    public static final MmRecordingFloatFailureReason SESSION_INACTIVE = null;
    public static final /* synthetic */ MmRecordingFloatFailureReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingFloatFailureReason> getEntries() {
        return b;
    }

    static {
        MmRecordingFloatFailureReason r0 = new MmRecordingFloatFailureReason("NO_PERMISSION", 0);
        NO_PERMISSION = r0;
        MmRecordingFloatFailureReason r1 = new MmRecordingFloatFailureReason("CONTEXT_UNAVAILABLE", 1);
        CONTEXT_UNAVAILABLE = r1;
        MmRecordingFloatFailureReason r3 = new MmRecordingFloatFailureReason("SESSION_INACTIVE", 2);
        SESSION_INACTIVE = r3;
        MmRecordingFloatFailureReason r5 = new MmRecordingFloatFailureReason("HOST_CREATE_FAILED", 3);
        HOST_CREATE_FAILED = r5;
        MmRecordingFloatFailureReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmRecordingFloatFailureReason[] values() {
        return (MmRecordingFloatFailureReason[]) a.clone();
    }

    public static MmRecordingFloatFailureReason valueOf(String r1) {
        return (MmRecordingFloatFailureReason) a.a(MmRecordingFloatFailureReason.class, r1);
    }

    public MmRecordingFloatFailureReason(String r1, int r2) {
        super(r1, r2);
    }
}
