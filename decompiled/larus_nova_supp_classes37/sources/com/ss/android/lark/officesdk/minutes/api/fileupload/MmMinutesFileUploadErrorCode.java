package com.ss.android.lark.officesdk.minutes.api.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "NETWORK_ERROR", "NO_QUOTA", "PRE_FILE_COUNT_EMPTY", "PRE_FILE_COUNT_EXCEEDED", "FILE_TYPE_ERROR", "MEDIA_DURATION_ERROR", "FILE_SIZE_ERROR", "FILE_READ_FAIL", "PRE_FILE_NOT_EXIST", "QUOTA_REQUEST_ERROR", "PREPARE_REQUEST_ERROR", "DRIVE_UPLOAD_REQUEST_ERROR", "DRIVE_PUSH_CALLBACK_ERROR", "FINISH_REQUEST_ERROR", "DUPLICATE_IN_SERVER", "ALREADY_UPLOAD", "RETRY_TOO_MANY_TIMES", "CANCEL_BY_USER", "SOMETHING_WRONG", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmMinutesFileUploadErrorCode extends Enum<MmMinutesFileUploadErrorCode> {
    public static final MmMinutesFileUploadErrorCode ALREADY_UPLOAD = null;
    public static final MmMinutesFileUploadErrorCode CANCEL_BY_USER = null;
    public static final MmMinutesFileUploadErrorCode DRIVE_PUSH_CALLBACK_ERROR = null;
    public static final MmMinutesFileUploadErrorCode DRIVE_UPLOAD_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode DUPLICATE_IN_SERVER = null;
    public static final MmMinutesFileUploadErrorCode FILE_READ_FAIL = null;
    public static final MmMinutesFileUploadErrorCode FILE_SIZE_ERROR = null;
    public static final MmMinutesFileUploadErrorCode FILE_TYPE_ERROR = null;
    public static final MmMinutesFileUploadErrorCode FINISH_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode MEDIA_DURATION_ERROR = null;
    public static final MmMinutesFileUploadErrorCode NETWORK_ERROR = null;
    public static final MmMinutesFileUploadErrorCode NO_QUOTA = null;
    public static final MmMinutesFileUploadErrorCode PREPARE_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_COUNT_EMPTY = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_COUNT_EXCEEDED = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_NOT_EXIST = null;
    public static final MmMinutesFileUploadErrorCode QUOTA_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode RETRY_TOO_MANY_TIMES = null;
    public static final MmMinutesFileUploadErrorCode SOMETHING_WRONG = null;
    public static final MmMinutesFileUploadErrorCode SUCCESS = null;
    public static final /* synthetic */ MmMinutesFileUploadErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmMinutesFileUploadErrorCode> getEntries() {
        return b;
    }

    static {
        MmMinutesFileUploadErrorCode r0 = new MmMinutesFileUploadErrorCode("SUCCESS", 0);
        SUCCESS = r0;
        MmMinutesFileUploadErrorCode r1 = new MmMinutesFileUploadErrorCode("NETWORK_ERROR", 1);
        NETWORK_ERROR = r1;
        MmMinutesFileUploadErrorCode r3 = new MmMinutesFileUploadErrorCode("NO_QUOTA", 2);
        NO_QUOTA = r3;
        MmMinutesFileUploadErrorCode r5 = new MmMinutesFileUploadErrorCode("PRE_FILE_COUNT_EMPTY", 3);
        PRE_FILE_COUNT_EMPTY = r5;
        MmMinutesFileUploadErrorCode r7 = new MmMinutesFileUploadErrorCode("PRE_FILE_COUNT_EXCEEDED", 4);
        PRE_FILE_COUNT_EXCEEDED = r7;
        MmMinutesFileUploadErrorCode r9 = new MmMinutesFileUploadErrorCode("FILE_TYPE_ERROR", 5);
        FILE_TYPE_ERROR = r9;
        MmMinutesFileUploadErrorCode r11 = new MmMinutesFileUploadErrorCode("MEDIA_DURATION_ERROR", 6);
        MEDIA_DURATION_ERROR = r11;
        MmMinutesFileUploadErrorCode r13 = new MmMinutesFileUploadErrorCode("FILE_SIZE_ERROR", 7);
        FILE_SIZE_ERROR = r13;
        MmMinutesFileUploadErrorCode r15 = new MmMinutesFileUploadErrorCode("FILE_READ_FAIL", 8);
        FILE_READ_FAIL = r15;
        MmMinutesFileUploadErrorCode r14 = new MmMinutesFileUploadErrorCode("PRE_FILE_NOT_EXIST", 9);
        PRE_FILE_NOT_EXIST = r14;
        MmMinutesFileUploadErrorCode r12 = new MmMinutesFileUploadErrorCode("QUOTA_REQUEST_ERROR", 10);
        QUOTA_REQUEST_ERROR = r12;
        MmMinutesFileUploadErrorCode r10 = new MmMinutesFileUploadErrorCode("PREPARE_REQUEST_ERROR", 11);
        PREPARE_REQUEST_ERROR = r10;
        MmMinutesFileUploadErrorCode r8 = new MmMinutesFileUploadErrorCode("DRIVE_UPLOAD_REQUEST_ERROR", 12);
        DRIVE_UPLOAD_REQUEST_ERROR = r8;
        MmMinutesFileUploadErrorCode r6 = new MmMinutesFileUploadErrorCode("DRIVE_PUSH_CALLBACK_ERROR", 13);
        DRIVE_PUSH_CALLBACK_ERROR = r6;
        MmMinutesFileUploadErrorCode r4 = new MmMinutesFileUploadErrorCode("FINISH_REQUEST_ERROR", 14);
        FINISH_REQUEST_ERROR = r4;
        MmMinutesFileUploadErrorCode r2 = new MmMinutesFileUploadErrorCode("DUPLICATE_IN_SERVER", 15);
        DUPLICATE_IN_SERVER = r2;
        MmMinutesFileUploadErrorCode r16 = new MmMinutesFileUploadErrorCode("ALREADY_UPLOAD", 16);
        ALREADY_UPLOAD = r16;
        MmMinutesFileUploadErrorCode r17 = new MmMinutesFileUploadErrorCode("RETRY_TOO_MANY_TIMES", 17);
        RETRY_TOO_MANY_TIMES = r17;
        MmMinutesFileUploadErrorCode r18 = new MmMinutesFileUploadErrorCode("CANCEL_BY_USER", 18);
        CANCEL_BY_USER = r18;
        MmMinutesFileUploadErrorCode r19 = new MmMinutesFileUploadErrorCode("SOMETHING_WRONG", 19);
        SOMETHING_WRONG = r19;
        MmMinutesFileUploadErrorCode[] r20 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        a = r20;
        b = EnumEntriesKt.enumEntries(r20);
    }

    public static MmMinutesFileUploadErrorCode[] values() {
        return (MmMinutesFileUploadErrorCode[]) a.clone();
    }

    public static MmMinutesFileUploadErrorCode valueOf(String r1) {
        return (MmMinutesFileUploadErrorCode) a.a(MmMinutesFileUploadErrorCode.class, r1);
    }

    public MmMinutesFileUploadErrorCode(String r1, int r2) {
        super(r1, r2);
    }
}
