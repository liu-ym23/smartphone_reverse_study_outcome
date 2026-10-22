package com.ss.android.lark.officesdk.minutes.service.foundation.network.response;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/MmObjectStatus;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "Deleted", "Trash", "Recording", "WaitASR", "Complete", "Failed", "Transcode", "Uploading", "WaitDiarization", "Pending", "PendingLowPriority", "FileCorrupted", "RealTimeRecording", "RealTimePause", "RealTimeCompleteUploading", "RealTimeCompleteForced", "RealTimeCompleteUpload", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmObjectStatus extends Enum<MmObjectStatus> implements Serializable {
    public static final a Companion = null;
    public static final MmObjectStatus Complete = null;
    public static final MmObjectStatus Deleted = null;
    public static final MmObjectStatus Failed = null;
    public static final MmObjectStatus FileCorrupted = null;
    public static final MmObjectStatus Pending = null;
    public static final MmObjectStatus PendingLowPriority = null;
    public static final MmObjectStatus RealTimeCompleteForced = null;
    public static final MmObjectStatus RealTimeCompleteUpload = null;
    public static final MmObjectStatus RealTimeCompleteUploading = null;
    public static final MmObjectStatus RealTimePause = null;
    public static final MmObjectStatus RealTimeRecording = null;
    public static final MmObjectStatus Recording = null;
    public static final MmObjectStatus Transcode = null;
    public static final MmObjectStatus Trash = null;
    public static final MmObjectStatus UNKNOWN = null;
    public static final MmObjectStatus Uploading = null;
    public static final MmObjectStatus WaitASR = null;
    public static final MmObjectStatus WaitDiarization = null;
    public static final /* synthetic */ MmObjectStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmObjectStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.response.MmObjectStatus$a] */
    static {
        MmObjectStatus r0 = new MmObjectStatus("UNKNOWN", 0, OfficeSDKPluginErrorCode.INVALID_PLUGIN_ID);
        UNKNOWN = r0;
        MmObjectStatus r1 = new MmObjectStatus("Deleted", 1, -2);
        Deleted = r1;
        MmObjectStatus r3 = new MmObjectStatus("Trash", 2, -1);
        Trash = r3;
        MmObjectStatus r5 = new MmObjectStatus("Recording", 3, 0);
        Recording = r5;
        MmObjectStatus r7 = new MmObjectStatus("WaitASR", 4, 1);
        WaitASR = r7;
        MmObjectStatus r9 = new MmObjectStatus("Complete", 5, 2);
        Complete = r9;
        MmObjectStatus r11 = new MmObjectStatus("Failed", 6, 3);
        Failed = r11;
        MmObjectStatus r13 = new MmObjectStatus("Transcode", 7, 4);
        Transcode = r13;
        MmObjectStatus r15 = new MmObjectStatus("Uploading", 8, 5);
        Uploading = r15;
        MmObjectStatus r14 = new MmObjectStatus("WaitDiarization", 9, 11);
        WaitDiarization = r14;
        MmObjectStatus r10 = new MmObjectStatus("Pending", 10, 12);
        Pending = r10;
        MmObjectStatus r12 = new MmObjectStatus("PendingLowPriority", 11, 13);
        PendingLowPriority = r12;
        MmObjectStatus r6 = new MmObjectStatus("FileCorrupted", 12, 31);
        FileCorrupted = r6;
        MmObjectStatus r2 = new MmObjectStatus("RealTimeRecording", 13, 40);
        RealTimeRecording = r2;
        MmObjectStatus r4 = new MmObjectStatus("RealTimePause", 14, 41);
        RealTimePause = r4;
        MmObjectStatus r8 = new MmObjectStatus("RealTimeCompleteUploading", 15, 42);
        RealTimeCompleteUploading = r8;
        MmObjectStatus r16 = new MmObjectStatus("RealTimeCompleteForced", 16, 43);
        RealTimeCompleteForced = r16;
        MmObjectStatus r17 = new MmObjectStatus("RealTimeCompleteUpload", 17, 44);
        RealTimeCompleteUpload = r17;
        MmObjectStatus[] r18 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r10, r12, r6, r2, r4, r8, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
        Companion = new a();
    }

    public static MmObjectStatus[] values() {
        return (MmObjectStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmObjectStatus valueOf(String r1) {
        return (MmObjectStatus) r27.a.a(MmObjectStatus.class, r1);
    }

    public MmObjectStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
