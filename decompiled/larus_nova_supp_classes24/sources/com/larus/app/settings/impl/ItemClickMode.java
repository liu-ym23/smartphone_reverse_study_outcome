package com.larus.app.settings.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/app/settings/impl/ItemClickMode;", "", "<init>", "(Ljava/lang/String;I)V", "DIRECT", "DEBOUNCE", "STICKY_DEBOUNCE_1S", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ItemClickMode extends Enum<ItemClickMode> {
    public static final ItemClickMode DEBOUNCE = null;
    public static final ItemClickMode DIRECT = null;
    public static final ItemClickMode STICKY_DEBOUNCE_1S = null;
    public static final /* synthetic */ ItemClickMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ItemClickMode> getEntries() {
        return b;
    }

    static {
        ItemClickMode r0 = new ItemClickMode("DIRECT", 0);
        DIRECT = r0;
        ItemClickMode r1 = new ItemClickMode("DEBOUNCE", 1);
        DEBOUNCE = r1;
        ItemClickMode r3 = new ItemClickMode("STICKY_DEBOUNCE_1S", 2);
        STICKY_DEBOUNCE_1S = r3;
        ItemClickMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ItemClickMode[] values() {
        return (ItemClickMode[]) a.clone();
    }

    public static ItemClickMode valueOf(String r1) {
        return (ItemClickMode) r27.a.a(ItemClickMode.class, r1);
    }

    public ItemClickMode(String r1, int r2) {
        super(r1, r2);
    }
}
