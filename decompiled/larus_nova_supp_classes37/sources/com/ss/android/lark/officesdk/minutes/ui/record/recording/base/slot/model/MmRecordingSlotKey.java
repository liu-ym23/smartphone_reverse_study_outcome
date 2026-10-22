package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingSlotKey;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "TITLE", "MIDDLE", "TOOLBAR", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmRecordingSlotKey extends Enum<MmRecordingSlotKey> {
    public static final MmRecordingSlotKey MIDDLE = null;
    public static final MmRecordingSlotKey TITLE = null;
    public static final MmRecordingSlotKey TOOLBAR = null;
    public static final MmRecordingSlotKey TOP = null;
    public static final /* synthetic */ MmRecordingSlotKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmRecordingSlotKey> getEntries() {
        return b;
    }

    static {
        MmRecordingSlotKey r0 = new MmRecordingSlotKey("TOP", 0);
        TOP = r0;
        MmRecordingSlotKey r1 = new MmRecordingSlotKey("TITLE", 1);
        TITLE = r1;
        MmRecordingSlotKey r3 = new MmRecordingSlotKey("MIDDLE", 2);
        MIDDLE = r3;
        MmRecordingSlotKey r5 = new MmRecordingSlotKey("TOOLBAR", 3);
        TOOLBAR = r5;
        MmRecordingSlotKey[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmRecordingSlotKey[] values() {
        return (MmRecordingSlotKey[]) a.clone();
    }

    public static MmRecordingSlotKey valueOf(String r1) {
        return (MmRecordingSlotKey) a.a(MmRecordingSlotKey.class, r1);
    }

    public MmRecordingSlotKey(String r1, int r2) {
        super(r1, r2);
    }
}
