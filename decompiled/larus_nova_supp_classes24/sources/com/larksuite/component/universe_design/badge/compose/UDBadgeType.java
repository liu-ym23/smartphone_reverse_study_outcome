package com.larksuite.component.universe_design.badge.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/badge/compose/UDBadgeType;", "", "<init>", "(Ljava/lang/String;I)V", "Dot", "Text", "Icon", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDBadgeType extends Enum<UDBadgeType> {
    public static final UDBadgeType Dot = null;
    public static final UDBadgeType Icon = null;
    public static final UDBadgeType Text = null;
    public static final /* synthetic */ UDBadgeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDBadgeType> getEntries() {
        return b;
    }

    static {
        UDBadgeType r0 = new UDBadgeType("Dot", 0);
        Dot = r0;
        UDBadgeType r1 = new UDBadgeType("Text", 1);
        Text = r1;
        UDBadgeType r3 = new UDBadgeType("Icon", 2);
        Icon = r3;
        UDBadgeType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDBadgeType[] values() {
        return (UDBadgeType[]) a.clone();
    }

    public static UDBadgeType valueOf(String r1) {
        return (UDBadgeType) r27.a.a(UDBadgeType.class, r1);
    }

    public UDBadgeType(String r1, int r2) {
        super(r1, r2);
    }
}
