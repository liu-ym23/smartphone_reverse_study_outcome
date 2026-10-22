package com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/http/MmRecordingUpdateStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RECORD_PAUSE", "RECORD_RESUME", "RECORD_FINISH", "UPLOAD_COMPLETED", "SET_AUDIO_STATUS", "SET_SIMULTANEOUS_SAVE_ARTIFACT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingUpdateStatus extends Enum<MmRecordingUpdateStatus> {
    public static final MmRecordingUpdateStatus RECORD_FINISH = null;
    public static final MmRecordingUpdateStatus RECORD_PAUSE = null;
    public static final MmRecordingUpdateStatus RECORD_RESUME = null;
    public static final MmRecordingUpdateStatus SET_AUDIO_STATUS = null;
    public static final MmRecordingUpdateStatus SET_SIMULTANEOUS_SAVE_ARTIFACT = null;
    public static final MmRecordingUpdateStatus UPLOAD_COMPLETED = null;
    public static final /* synthetic */ MmRecordingUpdateStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<MmRecordingUpdateStatus> getEntries() {
        return b;
    }

    static {
        MmRecordingUpdateStatus r0 = new MmRecordingUpdateStatus("RECORD_PAUSE", 0, 1);
        RECORD_PAUSE = r0;
        MmRecordingUpdateStatus r1 = new MmRecordingUpdateStatus("RECORD_RESUME", 1, 2);
        RECORD_RESUME = r1;
        MmRecordingUpdateStatus r4 = new MmRecordingUpdateStatus("RECORD_FINISH", 2, 3);
        RECORD_FINISH = r4;
        MmRecordingUpdateStatus r6 = new MmRecordingUpdateStatus("UPLOAD_COMPLETED", 3, 4);
        UPLOAD_COMPLETED = r6;
        MmRecordingUpdateStatus r8 = new MmRecordingUpdateStatus("SET_AUDIO_STATUS", 4, 5);
        SET_AUDIO_STATUS = r8;
        MmRecordingUpdateStatus r10 = new MmRecordingUpdateStatus("SET_SIMULTANEOUS_SAVE_ARTIFACT", 5, 6);
        SET_SIMULTANEOUS_SAVE_ARTIFACT = r10;
        MmRecordingUpdateStatus[] r12 = {r0, r1, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static MmRecordingUpdateStatus[] values() {
        return (MmRecordingUpdateStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmRecordingUpdateStatus valueOf(String r1) {
        return (MmRecordingUpdateStatus) a.a(MmRecordingUpdateStatus.class, r1);
    }

    public MmRecordingUpdateStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
