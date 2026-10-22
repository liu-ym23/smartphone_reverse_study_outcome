package com.larus.av_call.constant;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/av_call/constant/ThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "MAIN_BOT", "UGC_BOT", "IMMERS_BOT", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ThemeType extends Enum<ThemeType> {
    public static final ThemeType DEFAULT = null;
    public static final ThemeType IMMERS_BOT = null;
    public static final ThemeType MAIN_BOT = null;
    public static final ThemeType UGC_BOT = null;
    public static final /* synthetic */ ThemeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ThemeType> getEntries() {
        return b;
    }

    static {
        ThemeType r0 = new ThemeType("DEFAULT", 0);
        DEFAULT = r0;
        ThemeType r1 = new ThemeType("MAIN_BOT", 1);
        MAIN_BOT = r1;
        ThemeType r3 = new ThemeType("UGC_BOT", 2);
        UGC_BOT = r3;
        ThemeType r5 = new ThemeType("IMMERS_BOT", 3);
        IMMERS_BOT = r5;
        ThemeType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ThemeType[] values() {
        return (ThemeType[]) a.clone();
    }

    public static ThemeType valueOf(String r1) {
        return (ThemeType) a.a(ThemeType.class, r1);
    }

    public ThemeType(String r1, int r2) {
        super(r1, r2);
    }
}
