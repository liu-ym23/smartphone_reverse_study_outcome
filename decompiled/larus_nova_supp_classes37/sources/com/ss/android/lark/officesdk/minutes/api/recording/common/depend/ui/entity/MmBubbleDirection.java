package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmBubbleDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmBubbleDirection extends Enum<MmBubbleDirection> {
    public static final MmBubbleDirection BOTTOM = null;
    public static final MmBubbleDirection LEFT = null;
    public static final MmBubbleDirection RIGHT = null;
    public static final MmBubbleDirection TOP = null;
    public static final /* synthetic */ MmBubbleDirection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmBubbleDirection> getEntries() {
        return b;
    }

    static {
        MmBubbleDirection r0 = new MmBubbleDirection("LEFT", 0);
        LEFT = r0;
        MmBubbleDirection r1 = new MmBubbleDirection("TOP", 1);
        TOP = r1;
        MmBubbleDirection r3 = new MmBubbleDirection("RIGHT", 2);
        RIGHT = r3;
        MmBubbleDirection r5 = new MmBubbleDirection("BOTTOM", 3);
        BOTTOM = r5;
        MmBubbleDirection[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmBubbleDirection[] values() {
        return (MmBubbleDirection[]) a.clone();
    }

    public static MmBubbleDirection valueOf(String r1) {
        return (MmBubbleDirection) a.a(MmBubbleDirection.class, r1);
    }

    public MmBubbleDirection(String r1, int r2) {
        super(r1, r2);
    }
}
