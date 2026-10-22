package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "RECORDING", "PAUSED", "DISABLED", "IDLE", "isNotIdle", "", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MMRecordingState extends Enum<MMRecordingState> {
    public static final MMRecordingState DISABLED = null;
    public static final MMRecordingState IDLE = null;
    public static final MMRecordingState INIT = null;
    public static final MMRecordingState PAUSED = null;
    public static final MMRecordingState RECORDING = null;
    public static final /* synthetic */ MMRecordingState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MMRecordingState> getEntries() {
        return b;
    }

    static {
        MMRecordingState r0 = new MMRecordingState("INIT", 0);
        INIT = r0;
        MMRecordingState r1 = new MMRecordingState("RECORDING", 1);
        RECORDING = r1;
        MMRecordingState r3 = new MMRecordingState("PAUSED", 2);
        PAUSED = r3;
        MMRecordingState r5 = new MMRecordingState("DISABLED", 3);
        DISABLED = r5;
        MMRecordingState r7 = new MMRecordingState("IDLE", 4);
        IDLE = r7;
        MMRecordingState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MMRecordingState[] values() {
        return (MMRecordingState[]) a.clone();
    }

    public final boolean isNotIdle() {
        if (this == IDLE) goto L5;
        return true;
    L5:
        return false;
    }

    public static MMRecordingState valueOf(String r1) {
        return (MMRecordingState) r27.a.a(MMRecordingState.class, r1);
    }

    public MMRecordingState(String r1, int r2) {
        super(r1, r2);
    }
}
