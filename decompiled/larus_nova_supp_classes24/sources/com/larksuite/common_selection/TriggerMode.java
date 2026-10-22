package com.larksuite.common_selection;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/TriggerMode;", "", "<init>", "(Ljava/lang/String;I)V", "LongPress", "DoubleTap", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TriggerMode extends Enum<TriggerMode> {
    public static final TriggerMode DoubleTap = null;
    public static final TriggerMode LongPress = null;
    public static final /* synthetic */ TriggerMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TriggerMode> getEntries() {
        return b;
    }

    static {
        TriggerMode r0 = new TriggerMode("LongPress", 0);
        LongPress = r0;
        TriggerMode r1 = new TriggerMode("DoubleTap", 1);
        DoubleTap = r1;
        TriggerMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TriggerMode[] values() {
        return (TriggerMode[]) a.clone();
    }

    public static TriggerMode valueOf(String r1) {
        return (TriggerMode) r27.a.a(TriggerMode.class, r1);
    }

    public TriggerMode(String r1, int r2) {
        super(r1, r2);
    }
}
