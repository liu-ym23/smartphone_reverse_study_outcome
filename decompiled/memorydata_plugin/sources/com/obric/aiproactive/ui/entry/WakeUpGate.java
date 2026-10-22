package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/entry/WakeUpGate;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "BLOCK", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WakeUpGate extends Enum<WakeUpGate> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WakeUpGate[] $VALUES = null;
    public static final WakeUpGate ALLOW = null;
    public static final WakeUpGate BLOCK = null;

    private static final /* synthetic */ WakeUpGate[] $values() {
        return new WakeUpGate[]{ALLOW, BLOCK};
    }

    static {
        ALLOW = new WakeUpGate("ALLOW", 0);
        BLOCK = new WakeUpGate("BLOCK", 1);
        WakeUpGate[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private WakeUpGate(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<WakeUpGate> getEntries() {
        return $ENTRIES;
    }

    public static WakeUpGate valueOf(String r2) {
        return (WakeUpGate) ZeusTransformUtils.preCheckCast(Enum.valueOf(WakeUpGate.class, r2), WakeUpGate.class, "com.obric.memorydata.plugin");
    }

    public static WakeUpGate[] values() {
        return (WakeUpGate[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WakeUpGate[].class, "com.obric.memorydata.plugin");
    }
}
