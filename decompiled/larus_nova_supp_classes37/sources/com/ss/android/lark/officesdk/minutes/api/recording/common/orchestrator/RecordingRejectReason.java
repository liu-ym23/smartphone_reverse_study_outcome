package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingRejectReason;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_INSTANCE_ALREADY_RUNNING", "SAME_SCENE_ALREADY_RUNNING", "BLOCKED_BY_ACTIVE_SCENE", "BLOCKED_BY_SAME_PRIORITY", "BLOCKED_BY_HIGHER_PRIORITY", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingRejectReason extends Enum<RecordingRejectReason> {
    public static final RecordingRejectReason BLOCKED_BY_ACTIVE_SCENE = null;
    public static final RecordingRejectReason BLOCKED_BY_HIGHER_PRIORITY = null;
    public static final RecordingRejectReason BLOCKED_BY_SAME_PRIORITY = null;
    public static final RecordingRejectReason SAME_INSTANCE_ALREADY_RUNNING = null;
    public static final RecordingRejectReason SAME_SCENE_ALREADY_RUNNING = null;
    public static final /* synthetic */ RecordingRejectReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordingRejectReason> getEntries() {
        return b;
    }

    static {
        RecordingRejectReason r0 = new RecordingRejectReason("SAME_INSTANCE_ALREADY_RUNNING", 0);
        SAME_INSTANCE_ALREADY_RUNNING = r0;
        RecordingRejectReason r1 = new RecordingRejectReason("SAME_SCENE_ALREADY_RUNNING", 1);
        SAME_SCENE_ALREADY_RUNNING = r1;
        RecordingRejectReason r3 = new RecordingRejectReason("BLOCKED_BY_ACTIVE_SCENE", 2);
        BLOCKED_BY_ACTIVE_SCENE = r3;
        RecordingRejectReason r5 = new RecordingRejectReason("BLOCKED_BY_SAME_PRIORITY", 3);
        BLOCKED_BY_SAME_PRIORITY = r5;
        RecordingRejectReason r7 = new RecordingRejectReason("BLOCKED_BY_HIGHER_PRIORITY", 4);
        BLOCKED_BY_HIGHER_PRIORITY = r7;
        RecordingRejectReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static RecordingRejectReason[] values() {
        return (RecordingRejectReason[]) a.clone();
    }

    public static RecordingRejectReason valueOf(String r1) {
        return (RecordingRejectReason) a.a(RecordingRejectReason.class, r1);
    }

    public RecordingRejectReason(String r1, int r2) {
        super(r1, r2);
    }
}
