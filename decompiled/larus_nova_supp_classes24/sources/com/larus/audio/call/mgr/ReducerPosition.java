package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/mgr/ReducerPosition;", "", "<init>", "(Ljava/lang/String;I)V", "APPEND", "PREPEND", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ReducerPosition extends Enum<ReducerPosition> {
    public static final ReducerPosition APPEND = null;
    public static final ReducerPosition PREPEND = null;
    public static final /* synthetic */ ReducerPosition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReducerPosition> getEntries() {
        return b;
    }

    static {
        ReducerPosition r0 = new ReducerPosition("APPEND", 0);
        APPEND = r0;
        ReducerPosition r1 = new ReducerPosition("PREPEND", 1);
        PREPEND = r1;
        ReducerPosition[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReducerPosition[] values() {
        return (ReducerPosition[]) a.clone();
    }

    public static ReducerPosition valueOf(String r1) {
        return (ReducerPosition) r27.a.a(ReducerPosition.class, r1);
    }

    public ReducerPosition(String r1, int r2) {
        super(r1, r2);
    }
}
