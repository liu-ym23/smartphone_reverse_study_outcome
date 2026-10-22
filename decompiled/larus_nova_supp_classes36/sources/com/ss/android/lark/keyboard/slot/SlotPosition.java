package com.ss.android.lark.keyboard.slot;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/SlotPosition;", "", "<init>", "(Ljava/lang/String;I)V", "INNER_LEFT", "INNER_TOP", "INNER_RIGHT", "INNER_BOTTOM", "TOP", "TOP_EXTEND", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum SlotPosition extends Enum<SlotPosition> {
    public static final SlotPosition INNER_BOTTOM = null;
    public static final SlotPosition INNER_LEFT = null;
    public static final SlotPosition INNER_RIGHT = null;
    public static final SlotPosition INNER_TOP = null;
    public static final SlotPosition TOP = null;
    public static final SlotPosition TOP_EXTEND = null;
    public static final /* synthetic */ SlotPosition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SlotPosition> getEntries() {
        return b;
    }

    static {
        SlotPosition r0 = new SlotPosition("INNER_LEFT", 0);
        INNER_LEFT = r0;
        SlotPosition r1 = new SlotPosition("INNER_TOP", 1);
        INNER_TOP = r1;
        SlotPosition r3 = new SlotPosition("INNER_RIGHT", 2);
        INNER_RIGHT = r3;
        SlotPosition r5 = new SlotPosition("INNER_BOTTOM", 3);
        INNER_BOTTOM = r5;
        SlotPosition r7 = new SlotPosition("TOP", 4);
        TOP = r7;
        SlotPosition r9 = new SlotPosition("TOP_EXTEND", 5);
        TOP_EXTEND = r9;
        SlotPosition[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static SlotPosition[] values() {
        return (SlotPosition[]) a.clone();
    }

    public static SlotPosition valueOf(String r1) {
        return (SlotPosition) a.a(SlotPosition.class, r1);
    }

    public SlotPosition(String r1, int r2) {
        super(r1, r2);
    }
}
