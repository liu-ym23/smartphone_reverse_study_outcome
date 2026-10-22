package com.ss.android.lark.officesdk.minutes.api.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "PreCheckSuccess", "QuotaReady", "Uploading", "DriveAllUploaded", "UploadCompleted", "Interrupted", "Idle", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmMinutesFileUploadTaskState extends Enum<MmMinutesFileUploadTaskState> {
    public static final MmMinutesFileUploadTaskState DriveAllUploaded = null;
    public static final MmMinutesFileUploadTaskState Idle = null;
    public static final MmMinutesFileUploadTaskState Init = null;
    public static final MmMinutesFileUploadTaskState Interrupted = null;
    public static final MmMinutesFileUploadTaskState PreCheckSuccess = null;
    public static final MmMinutesFileUploadTaskState QuotaReady = null;
    public static final MmMinutesFileUploadTaskState UploadCompleted = null;
    public static final MmMinutesFileUploadTaskState Uploading = null;
    public static final /* synthetic */ MmMinutesFileUploadTaskState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmMinutesFileUploadTaskState> getEntries() {
        return b;
    }

    static {
        MmMinutesFileUploadTaskState r0 = new MmMinutesFileUploadTaskState("Init", 0);
        Init = r0;
        MmMinutesFileUploadTaskState r1 = new MmMinutesFileUploadTaskState("PreCheckSuccess", 1);
        PreCheckSuccess = r1;
        MmMinutesFileUploadTaskState r3 = new MmMinutesFileUploadTaskState("QuotaReady", 2);
        QuotaReady = r3;
        MmMinutesFileUploadTaskState r5 = new MmMinutesFileUploadTaskState("Uploading", 3);
        Uploading = r5;
        MmMinutesFileUploadTaskState r7 = new MmMinutesFileUploadTaskState("DriveAllUploaded", 4);
        DriveAllUploaded = r7;
        MmMinutesFileUploadTaskState r9 = new MmMinutesFileUploadTaskState("UploadCompleted", 5);
        UploadCompleted = r9;
        MmMinutesFileUploadTaskState r11 = new MmMinutesFileUploadTaskState("Interrupted", 6);
        Interrupted = r11;
        MmMinutesFileUploadTaskState r13 = new MmMinutesFileUploadTaskState("Idle", 7);
        Idle = r13;
        MmMinutesFileUploadTaskState[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static MmMinutesFileUploadTaskState[] values() {
        return (MmMinutesFileUploadTaskState[]) a.clone();
    }

    public static MmMinutesFileUploadTaskState valueOf(String r1) {
        return (MmMinutesFileUploadTaskState) a.a(MmMinutesFileUploadTaskState.class, r1);
    }

    public MmMinutesFileUploadTaskState(String r1, int r2) {
        super(r1, r2);
    }
}
