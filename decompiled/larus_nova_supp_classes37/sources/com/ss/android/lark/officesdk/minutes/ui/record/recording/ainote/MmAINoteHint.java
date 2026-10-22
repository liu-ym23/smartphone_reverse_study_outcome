package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteHint;", "", "<init>", "(Ljava/lang/String;I)V", "SUBTITLE_MISSING", "MARK_THROTTLE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmAINoteHint extends Enum<MmAINoteHint> {
    public static final MmAINoteHint MARK_THROTTLE = null;
    public static final MmAINoteHint SUBTITLE_MISSING = null;
    public static final /* synthetic */ MmAINoteHint[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmAINoteHint> getEntries() {
        return b;
    }

    static {
        MmAINoteHint r0 = new MmAINoteHint("SUBTITLE_MISSING", 0);
        SUBTITLE_MISSING = r0;
        MmAINoteHint r1 = new MmAINoteHint("MARK_THROTTLE", 1);
        MARK_THROTTLE = r1;
        MmAINoteHint[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MmAINoteHint[] values() {
        return (MmAINoteHint[]) a.clone();
    }

    public static MmAINoteHint valueOf(String r1) {
        return (MmAINoteHint) r27.a.a(MmAINoteHint.class, r1);
    }

    public MmAINoteHint(String r1, int r2) {
        super(r1, r2);
    }
}
