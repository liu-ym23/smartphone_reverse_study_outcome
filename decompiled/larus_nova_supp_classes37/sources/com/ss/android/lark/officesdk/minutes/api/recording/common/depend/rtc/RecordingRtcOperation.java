package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/rtc/RecordingRtcOperation;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INIT", "JOIN", "CAPTURE", "PUBLISH", "EXTERNAL_PUSH", "CAPTURE_STOP", "LEAVE", "DESTROY", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingRtcOperation extends Enum<RecordingRtcOperation> {
    public static final RecordingRtcOperation CAPTURE = null;
    public static final RecordingRtcOperation CAPTURE_STOP = null;
    public static final RecordingRtcOperation DESTROY = null;
    public static final RecordingRtcOperation EXTERNAL_PUSH = null;
    public static final RecordingRtcOperation INIT = null;
    public static final RecordingRtcOperation JOIN = null;
    public static final RecordingRtcOperation LEAVE = null;
    public static final RecordingRtcOperation PUBLISH = null;
    public static final /* synthetic */ RecordingRtcOperation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<RecordingRtcOperation> getEntries() {
        return b;
    }

    static {
        RecordingRtcOperation r0 = new RecordingRtcOperation("INIT", 0, "init");
        INIT = r0;
        RecordingRtcOperation r1 = new RecordingRtcOperation("JOIN", 1, "join");
        JOIN = r1;
        RecordingRtcOperation r2 = new RecordingRtcOperation("CAPTURE", 2, "capture");
        CAPTURE = r2;
        RecordingRtcOperation r4 = new RecordingRtcOperation("PUBLISH", 3, "publish");
        PUBLISH = r4;
        RecordingRtcOperation r6 = new RecordingRtcOperation("EXTERNAL_PUSH", 4, "external_push");
        EXTERNAL_PUSH = r6;
        RecordingRtcOperation r8 = new RecordingRtcOperation("CAPTURE_STOP", 5, "capture_stop");
        CAPTURE_STOP = r8;
        RecordingRtcOperation r10 = new RecordingRtcOperation("LEAVE", 6, "leave");
        LEAVE = r10;
        RecordingRtcOperation r12 = new RecordingRtcOperation("DESTROY", 7, "destroy");
        DESTROY = r12;
        RecordingRtcOperation[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static RecordingRtcOperation[] values() {
        return (RecordingRtcOperation[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RecordingRtcOperation valueOf(String r1) {
        return (RecordingRtcOperation) a.a(RecordingRtcOperation.class, r1);
    }

    public RecordingRtcOperation(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
