package com.larksuite.component.universe_design.badge.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/badge/compose/UDBadgeAnchorAlign;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "LeftTop", "LeftBottom", "Right", "RightTop", "RightBottom", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDBadgeAnchorAlign extends Enum<UDBadgeAnchorAlign> {
    public static final UDBadgeAnchorAlign Left = null;
    public static final UDBadgeAnchorAlign LeftBottom = null;
    public static final UDBadgeAnchorAlign LeftTop = null;
    public static final UDBadgeAnchorAlign Right = null;
    public static final UDBadgeAnchorAlign RightBottom = null;
    public static final UDBadgeAnchorAlign RightTop = null;
    public static final /* synthetic */ UDBadgeAnchorAlign[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDBadgeAnchorAlign> getEntries() {
        return b;
    }

    static {
        UDBadgeAnchorAlign r0 = new UDBadgeAnchorAlign("Left", 0);
        Left = r0;
        UDBadgeAnchorAlign r1 = new UDBadgeAnchorAlign("LeftTop", 1);
        LeftTop = r1;
        UDBadgeAnchorAlign r3 = new UDBadgeAnchorAlign("LeftBottom", 2);
        LeftBottom = r3;
        UDBadgeAnchorAlign r5 = new UDBadgeAnchorAlign("Right", 3);
        Right = r5;
        UDBadgeAnchorAlign r7 = new UDBadgeAnchorAlign("RightTop", 4);
        RightTop = r7;
        UDBadgeAnchorAlign r9 = new UDBadgeAnchorAlign("RightBottom", 5);
        RightBottom = r9;
        UDBadgeAnchorAlign[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static UDBadgeAnchorAlign[] values() {
        return (UDBadgeAnchorAlign[]) a.clone();
    }

    public static UDBadgeAnchorAlign valueOf(String r1) {
        return (UDBadgeAnchorAlign) r27.a.a(UDBadgeAnchorAlign.class, r1);
    }

    public UDBadgeAnchorAlign(String r1, int r2) {
        super(r1, r2);
    }
}
