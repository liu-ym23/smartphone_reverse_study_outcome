package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/PickerSelectionMode;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTIPLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PickerSelectionMode extends Enum<PickerSelectionMode> {
    private static final /* synthetic */ PickerSelectionMode[] $VALUES = null;
    public static final PickerSelectionMode MULTIPLE = null;
    public static final PickerSelectionMode SINGLE = null;

    private static final /* synthetic */ PickerSelectionMode[] $values() {
        return new PickerSelectionMode[]{SINGLE, MULTIPLE};
    }

    static {
        SINGLE = new PickerSelectionMode("SINGLE", 0);
        MULTIPLE = new PickerSelectionMode("MULTIPLE", 1);
        $VALUES = $values();
    }

    private PickerSelectionMode(String r1, int r2) {
        super(r1, r2);
    }

    public static PickerSelectionMode valueOf(String r2) {
        return (PickerSelectionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(PickerSelectionMode.class, r2), PickerSelectionMode.class, "com.obric.memorydata.plugin");
    }

    public static PickerSelectionMode[] values() {
        return (PickerSelectionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PickerSelectionMode[].class, "com.obric.memorydata.plugin");
    }
}
