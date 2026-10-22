package com.obric.oui.calendar;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/PickerSelectionMode;", "", "SINGLE", "MULTIPLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum PickerSelectionMode extends Enum<PickerSelectionMode> {
    public static final PickerSelectionMode MULTIPLE = null;
    public static final PickerSelectionMode SINGLE = null;
    public static final /* synthetic */ PickerSelectionMode[] a = null;

    public static PickerSelectionMode valueOf(String r1) {
        return (PickerSelectionMode) r27.a.a(PickerSelectionMode.class, r1);
    }

    public static PickerSelectionMode[] values() {
        return (PickerSelectionMode[]) a.clone();
    }

    static {
        PickerSelectionMode r0 = new PickerSelectionMode("SINGLE", 0);
        SINGLE = r0;
        PickerSelectionMode r1 = new PickerSelectionMode("MULTIPLE", 1);
        MULTIPLE = r1;
        a = new PickerSelectionMode[]{r0, r1};
    }

    public PickerSelectionMode(String r1, int r2) {
        super(r1, r2);
    }
}
