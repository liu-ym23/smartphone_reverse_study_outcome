package com.larus.av_call.util;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/av_call/util/ScreenWidthType;", "", "<init>", "(Ljava/lang/String;I)V", "Small", "Medium", "Large", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ScreenWidthType extends Enum<ScreenWidthType> {
    public static final ScreenWidthType Large = null;
    public static final ScreenWidthType Medium = null;
    public static final ScreenWidthType Small = null;
    public static final /* synthetic */ ScreenWidthType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ScreenWidthType> getEntries() {
        return b;
    }

    static {
        ScreenWidthType r0 = new ScreenWidthType("Small", 0);
        Small = r0;
        ScreenWidthType r1 = new ScreenWidthType("Medium", 1);
        Medium = r1;
        ScreenWidthType r3 = new ScreenWidthType("Large", 2);
        Large = r3;
        ScreenWidthType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ScreenWidthType[] values() {
        return (ScreenWidthType[]) a.clone();
    }

    public static ScreenWidthType valueOf(String r1) {
        return (ScreenWidthType) a.a(ScreenWidthType.class, r1);
    }

    public ScreenWidthType(String r1, int r2) {
        super(r1, r2);
    }
}
