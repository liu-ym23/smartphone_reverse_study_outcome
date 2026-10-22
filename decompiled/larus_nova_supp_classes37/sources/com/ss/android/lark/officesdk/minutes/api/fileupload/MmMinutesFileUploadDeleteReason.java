package com.ss.android.lark.officesdk.minutes.api.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadDeleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE_BY_USER", "DUPLICATE_IN_SERVER", "ACCOUNT_CHANGE", "OTHERS", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmMinutesFileUploadDeleteReason extends Enum<MmMinutesFileUploadDeleteReason> {
    public static final MmMinutesFileUploadDeleteReason ACCOUNT_CHANGE = null;
    public static final MmMinutesFileUploadDeleteReason DELETE_BY_USER = null;
    public static final MmMinutesFileUploadDeleteReason DUPLICATE_IN_SERVER = null;
    public static final MmMinutesFileUploadDeleteReason OTHERS = null;
    public static final /* synthetic */ MmMinutesFileUploadDeleteReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmMinutesFileUploadDeleteReason> getEntries() {
        return b;
    }

    static {
        MmMinutesFileUploadDeleteReason r0 = new MmMinutesFileUploadDeleteReason("DELETE_BY_USER", 0);
        DELETE_BY_USER = r0;
        MmMinutesFileUploadDeleteReason r1 = new MmMinutesFileUploadDeleteReason("DUPLICATE_IN_SERVER", 1);
        DUPLICATE_IN_SERVER = r1;
        MmMinutesFileUploadDeleteReason r3 = new MmMinutesFileUploadDeleteReason("ACCOUNT_CHANGE", 2);
        ACCOUNT_CHANGE = r3;
        MmMinutesFileUploadDeleteReason r5 = new MmMinutesFileUploadDeleteReason("OTHERS", 3);
        OTHERS = r5;
        MmMinutesFileUploadDeleteReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmMinutesFileUploadDeleteReason[] values() {
        return (MmMinutesFileUploadDeleteReason[]) a.clone();
    }

    public static MmMinutesFileUploadDeleteReason valueOf(String r1) {
        return (MmMinutesFileUploadDeleteReason) a.a(MmMinutesFileUploadDeleteReason.class, r1);
    }

    public MmMinutesFileUploadDeleteReason(String r1, int r2) {
        super(r1, r2);
    }
}
