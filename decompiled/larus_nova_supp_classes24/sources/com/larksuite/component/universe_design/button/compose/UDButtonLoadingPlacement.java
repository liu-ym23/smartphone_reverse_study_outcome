package com.larksuite.component.universe_design.button.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonLoadingPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "TextStart", "TextEnd", "Center", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDButtonLoadingPlacement extends Enum<UDButtonLoadingPlacement> {
    public static final UDButtonLoadingPlacement Center = null;
    public static final UDButtonLoadingPlacement TextEnd = null;
    public static final UDButtonLoadingPlacement TextStart = null;
    public static final /* synthetic */ UDButtonLoadingPlacement[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDButtonLoadingPlacement> getEntries() {
        return b;
    }

    static {
        UDButtonLoadingPlacement r0 = new UDButtonLoadingPlacement("TextStart", 0);
        TextStart = r0;
        UDButtonLoadingPlacement r1 = new UDButtonLoadingPlacement("TextEnd", 1);
        TextEnd = r1;
        UDButtonLoadingPlacement r3 = new UDButtonLoadingPlacement("Center", 2);
        Center = r3;
        UDButtonLoadingPlacement[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDButtonLoadingPlacement[] values() {
        return (UDButtonLoadingPlacement[]) a.clone();
    }

    public static UDButtonLoadingPlacement valueOf(String r1) {
        return (UDButtonLoadingPlacement) r27.a.a(UDButtonLoadingPlacement.class, r1);
    }

    public UDButtonLoadingPlacement(String r1, int r2) {
        super(r1, r2);
    }
}
