package com.ss.android.lark.keyboard.base.inputinner;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "InnerStart", "InnerTop", "InnerEnd", "InnerBottom", "Top", "TopExpand", "InnerEndVertical", "TopMiddle", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum Direction extends Enum<Direction> {
    public static final Direction InnerBottom = null;
    public static final Direction InnerEnd = null;
    public static final Direction InnerEndVertical = null;
    public static final Direction InnerStart = null;
    public static final Direction InnerTop = null;
    public static final Direction Top = null;
    public static final Direction TopExpand = null;
    public static final Direction TopMiddle = null;
    public static final /* synthetic */ Direction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Direction> getEntries() {
        return b;
    }

    static {
        Direction r0 = new Direction("InnerStart", 0);
        InnerStart = r0;
        Direction r1 = new Direction("InnerTop", 1);
        InnerTop = r1;
        Direction r3 = new Direction("InnerEnd", 2);
        InnerEnd = r3;
        Direction r5 = new Direction("InnerBottom", 3);
        InnerBottom = r5;
        Direction r7 = new Direction("Top", 4);
        Top = r7;
        Direction r9 = new Direction("TopExpand", 5);
        TopExpand = r9;
        Direction r11 = new Direction("InnerEndVertical", 6);
        InnerEndVertical = r11;
        Direction r13 = new Direction("TopMiddle", 7);
        TopMiddle = r13;
        Direction[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static Direction[] values() {
        return (Direction[]) a.clone();
    }

    public static Direction valueOf(String r1) {
        return (Direction) a.a(Direction.class, r1);
    }

    public Direction(String r1, int r2) {
        super(r1, r2);
    }
}
