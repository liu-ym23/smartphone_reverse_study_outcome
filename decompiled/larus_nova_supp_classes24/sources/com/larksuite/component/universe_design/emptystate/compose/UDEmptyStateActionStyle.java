package com.larksuite.component.universe_design.emptystate.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/emptystate/compose/UDEmptyStateActionStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Button", "TextLink", "universe-ui-emptystate_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDEmptyStateActionStyle extends Enum<UDEmptyStateActionStyle> {
    public static final UDEmptyStateActionStyle Button = null;
    public static final UDEmptyStateActionStyle TextLink = null;
    public static final /* synthetic */ UDEmptyStateActionStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDEmptyStateActionStyle> getEntries() {
        return b;
    }

    static {
        UDEmptyStateActionStyle r0 = new UDEmptyStateActionStyle("Button", 0);
        Button = r0;
        UDEmptyStateActionStyle r1 = new UDEmptyStateActionStyle("TextLink", 1);
        TextLink = r1;
        UDEmptyStateActionStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static UDEmptyStateActionStyle[] values() {
        return (UDEmptyStateActionStyle[]) a.clone();
    }

    public static UDEmptyStateActionStyle valueOf(String r1) {
        return (UDEmptyStateActionStyle) r27.a.a(UDEmptyStateActionStyle.class, r1);
    }

    public UDEmptyStateActionStyle(String r1, int r2) {
        super(r1, r2);
    }
}
