package com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/orchestrator/RecordingPriorityStartMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "BACKGROUND", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum RecordingPriorityStartMode extends Enum<RecordingPriorityStartMode> {
    public static final RecordingPriorityStartMode BACKGROUND = null;
    public static final RecordingPriorityStartMode NORMAL = null;
    public static final /* synthetic */ RecordingPriorityStartMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordingPriorityStartMode> getEntries() {
        return b;
    }

    static {
        RecordingPriorityStartMode r0 = new RecordingPriorityStartMode("NORMAL", 0);
        NORMAL = r0;
        RecordingPriorityStartMode r1 = new RecordingPriorityStartMode("BACKGROUND", 1);
        BACKGROUND = r1;
        RecordingPriorityStartMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RecordingPriorityStartMode[] values() {
        return (RecordingPriorityStartMode[]) a.clone();
    }

    public static RecordingPriorityStartMode valueOf(String r1) {
        return (RecordingPriorityStartMode) a.a(RecordingPriorityStartMode.class, r1);
    }

    public RecordingPriorityStartMode(String r1, int r2) {
        super(r1, r2);
    }
}
