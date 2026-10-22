package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueAmountSource;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "PRESET", "CUSTOM", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveValueAmountSource extends Enum<ProactiveValueAmountSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveValueAmountSource[] $VALUES = null;
    public static final ProactiveValueAmountSource CUSTOM = null;
    public static final ProactiveValueAmountSource PRESET = null;
    private final String wireValue;

    private static final /* synthetic */ ProactiveValueAmountSource[] $values() {
        return new ProactiveValueAmountSource[]{PRESET, CUSTOM};
    }

    static {
        PRESET = new ProactiveValueAmountSource("PRESET", 0, "preset");
        CUSTOM = new ProactiveValueAmountSource("CUSTOM", 1, "custom");
        ProactiveValueAmountSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveValueAmountSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }

    public static EnumEntries<ProactiveValueAmountSource> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveValueAmountSource valueOf(String r2) {
        return (ProactiveValueAmountSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveValueAmountSource.class, r2), ProactiveValueAmountSource.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveValueAmountSource[] values() {
        return (ProactiveValueAmountSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveValueAmountSource[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireValue() {
        return this.wireValue;
    }
}
