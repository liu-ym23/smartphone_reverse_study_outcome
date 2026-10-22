package com.ss.android.lark.officesdk.minutes.api.hardware.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/upload/MmHardwareFileUploadRuntimeDeleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE_BY_USER", "UPLOAD_SUCCESS", "ACCOUNT_CHANGE", "DUPLICATE_IN_SERVER", "OTHERS", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHardwareFileUploadRuntimeDeleteReason extends Enum<MmHardwareFileUploadRuntimeDeleteReason> {
    public static final MmHardwareFileUploadRuntimeDeleteReason ACCOUNT_CHANGE = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason DELETE_BY_USER = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason DUPLICATE_IN_SERVER = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason OTHERS = null;
    public static final MmHardwareFileUploadRuntimeDeleteReason UPLOAD_SUCCESS = null;
    public static final /* synthetic */ MmHardwareFileUploadRuntimeDeleteReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHardwareFileUploadRuntimeDeleteReason> getEntries() {
        return b;
    }

    static {
        MmHardwareFileUploadRuntimeDeleteReason r0 = new MmHardwareFileUploadRuntimeDeleteReason("DELETE_BY_USER", 0);
        DELETE_BY_USER = r0;
        MmHardwareFileUploadRuntimeDeleteReason r1 = new MmHardwareFileUploadRuntimeDeleteReason("UPLOAD_SUCCESS", 1);
        UPLOAD_SUCCESS = r1;
        MmHardwareFileUploadRuntimeDeleteReason r3 = new MmHardwareFileUploadRuntimeDeleteReason("ACCOUNT_CHANGE", 2);
        ACCOUNT_CHANGE = r3;
        MmHardwareFileUploadRuntimeDeleteReason r5 = new MmHardwareFileUploadRuntimeDeleteReason("DUPLICATE_IN_SERVER", 3);
        DUPLICATE_IN_SERVER = r5;
        MmHardwareFileUploadRuntimeDeleteReason r7 = new MmHardwareFileUploadRuntimeDeleteReason("OTHERS", 4);
        OTHERS = r7;
        MmHardwareFileUploadRuntimeDeleteReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmHardwareFileUploadRuntimeDeleteReason[] values() {
        return (MmHardwareFileUploadRuntimeDeleteReason[]) a.clone();
    }

    public static MmHardwareFileUploadRuntimeDeleteReason valueOf(String r1) {
        return (MmHardwareFileUploadRuntimeDeleteReason) a.a(MmHardwareFileUploadRuntimeDeleteReason.class, r1);
    }

    public MmHardwareFileUploadRuntimeDeleteReason(String r1, int r2) {
        super(r1, r2);
    }
}
