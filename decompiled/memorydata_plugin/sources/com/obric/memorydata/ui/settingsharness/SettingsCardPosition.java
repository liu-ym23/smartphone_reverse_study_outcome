package com.obric.memorydata.ui.settingsharness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsCardPosition;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "TOP", "MIDDLE", "BOTTOM", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SettingsCardPosition extends Enum<SettingsCardPosition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SettingsCardPosition[] $VALUES = null;
    public static final SettingsCardPosition BOTTOM = null;
    public static final SettingsCardPosition MIDDLE = null;
    public static final SettingsCardPosition SINGLE = null;
    public static final SettingsCardPosition TOP = null;

    private static final /* synthetic */ SettingsCardPosition[] $values() {
        return new SettingsCardPosition[]{SINGLE, TOP, MIDDLE, BOTTOM};
    }

    static {
        SINGLE = new SettingsCardPosition("SINGLE", 0);
        TOP = new SettingsCardPosition("TOP", 1);
        MIDDLE = new SettingsCardPosition("MIDDLE", 2);
        BOTTOM = new SettingsCardPosition("BOTTOM", 3);
        SettingsCardPosition[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SettingsCardPosition(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SettingsCardPosition> getEntries() {
        return $ENTRIES;
    }

    public static SettingsCardPosition valueOf(String r2) {
        return (SettingsCardPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(SettingsCardPosition.class, r2), SettingsCardPosition.class, "com.obric.memorydata.plugin");
    }

    public static SettingsCardPosition[] values() {
        return (SettingsCardPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SettingsCardPosition[].class, "com.obric.memorydata.plugin");
    }
}
