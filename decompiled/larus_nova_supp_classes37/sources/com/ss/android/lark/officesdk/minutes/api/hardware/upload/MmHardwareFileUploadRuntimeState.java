package com.ss.android.lark.officesdk.minutes.api.hardware.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/upload/MmHardwareFileUploadRuntimeState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "PREPARING", "UPLOADING", "PROCESSING", "COMPLETED", "FAILED", "CANCELLED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHardwareFileUploadRuntimeState extends Enum<MmHardwareFileUploadRuntimeState> {
    public static final MmHardwareFileUploadRuntimeState CANCELLED = null;
    public static final MmHardwareFileUploadRuntimeState COMPLETED = null;
    public static final MmHardwareFileUploadRuntimeState FAILED = null;
    public static final MmHardwareFileUploadRuntimeState PREPARING = null;
    public static final MmHardwareFileUploadRuntimeState PROCESSING = null;
    public static final MmHardwareFileUploadRuntimeState UNKNOWN = null;
    public static final MmHardwareFileUploadRuntimeState UPLOADING = null;
    public static final /* synthetic */ MmHardwareFileUploadRuntimeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHardwareFileUploadRuntimeState> getEntries() {
        return b;
    }

    static {
        MmHardwareFileUploadRuntimeState r0 = new MmHardwareFileUploadRuntimeState("UNKNOWN", 0);
        UNKNOWN = r0;
        MmHardwareFileUploadRuntimeState r1 = new MmHardwareFileUploadRuntimeState("PREPARING", 1);
        PREPARING = r1;
        MmHardwareFileUploadRuntimeState r3 = new MmHardwareFileUploadRuntimeState("UPLOADING", 2);
        UPLOADING = r3;
        MmHardwareFileUploadRuntimeState r5 = new MmHardwareFileUploadRuntimeState("PROCESSING", 3);
        PROCESSING = r5;
        MmHardwareFileUploadRuntimeState r7 = new MmHardwareFileUploadRuntimeState("COMPLETED", 4);
        COMPLETED = r7;
        MmHardwareFileUploadRuntimeState r9 = new MmHardwareFileUploadRuntimeState("FAILED", 5);
        FAILED = r9;
        MmHardwareFileUploadRuntimeState r11 = new MmHardwareFileUploadRuntimeState("CANCELLED", 6);
        CANCELLED = r11;
        MmHardwareFileUploadRuntimeState[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static MmHardwareFileUploadRuntimeState[] values() {
        return (MmHardwareFileUploadRuntimeState[]) a.clone();
    }

    public static MmHardwareFileUploadRuntimeState valueOf(String r1) {
        return (MmHardwareFileUploadRuntimeState) a.a(MmHardwareFileUploadRuntimeState.class, r1);
    }

    public MmHardwareFileUploadRuntimeState(String r1, int r2) {
        super(r1, r2);
    }
}
