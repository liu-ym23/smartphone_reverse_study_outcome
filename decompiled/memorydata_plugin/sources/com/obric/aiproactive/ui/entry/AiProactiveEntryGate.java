package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/entry/AiProactiveEntryGate;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "BLOCK", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AiProactiveEntryGate extends Enum<AiProactiveEntryGate> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AiProactiveEntryGate[] $VALUES = null;
    public static final AiProactiveEntryGate ALLOW = null;
    public static final AiProactiveEntryGate BLOCK = null;

    private static final /* synthetic */ AiProactiveEntryGate[] $values() {
        return new AiProactiveEntryGate[]{ALLOW, BLOCK};
    }

    static {
        ALLOW = new AiProactiveEntryGate("ALLOW", 0);
        BLOCK = new AiProactiveEntryGate("BLOCK", 1);
        AiProactiveEntryGate[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AiProactiveEntryGate(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AiProactiveEntryGate> getEntries() {
        return $ENTRIES;
    }

    public static AiProactiveEntryGate valueOf(String r2) {
        return (AiProactiveEntryGate) ZeusTransformUtils.preCheckCast(Enum.valueOf(AiProactiveEntryGate.class, r2), AiProactiveEntryGate.class, "com.obric.memorydata.plugin");
    }

    public static AiProactiveEntryGate[] values() {
        return (AiProactiveEntryGate[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AiProactiveEntryGate[].class, "com.obric.memorydata.plugin");
    }
}
