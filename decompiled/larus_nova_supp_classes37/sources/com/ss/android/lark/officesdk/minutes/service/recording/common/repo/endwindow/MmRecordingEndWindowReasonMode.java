package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowReasonMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_ALLOW_LIST", "ALL_EXCEPT_BLOCKED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingEndWindowReasonMode extends Enum<MmRecordingEndWindowReasonMode> {
    public static final MmRecordingEndWindowReasonMode ALL_EXCEPT_BLOCKED = null;
    public static final MmRecordingEndWindowReasonMode DEFAULT_ALLOW_LIST = null;
    public static final /* synthetic */ MmRecordingEndWindowReasonMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingEndWindowReasonMode> getEntries() {
        return b;
    }

    static {
        MmRecordingEndWindowReasonMode r0 = new MmRecordingEndWindowReasonMode("DEFAULT_ALLOW_LIST", 0);
        DEFAULT_ALLOW_LIST = r0;
        MmRecordingEndWindowReasonMode r1 = new MmRecordingEndWindowReasonMode("ALL_EXCEPT_BLOCKED", 1);
        ALL_EXCEPT_BLOCKED = r1;
        MmRecordingEndWindowReasonMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmRecordingEndWindowReasonMode[] values() {
        return (MmRecordingEndWindowReasonMode[]) a.clone();
    }

    public static MmRecordingEndWindowReasonMode valueOf(String r1) {
        return (MmRecordingEndWindowReasonMode) r27.a.a(MmRecordingEndWindowReasonMode.class, r1);
    }

    public MmRecordingEndWindowReasonMode(String r1, int r2) {
        super(r1, r2);
    }
}
