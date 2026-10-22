package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsDayEmissionDecision;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVER", "RESTART", "IGNORE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SensingEventsDayEmissionDecision extends Enum<SensingEventsDayEmissionDecision> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SensingEventsDayEmissionDecision[] $VALUES = null;
    public static final SensingEventsDayEmissionDecision DELIVER = null;
    public static final SensingEventsDayEmissionDecision IGNORE = null;
    public static final SensingEventsDayEmissionDecision RESTART = null;

    private static final /* synthetic */ SensingEventsDayEmissionDecision[] $values() {
        return new SensingEventsDayEmissionDecision[]{DELIVER, RESTART, IGNORE};
    }

    static {
        DELIVER = new SensingEventsDayEmissionDecision("DELIVER", 0);
        RESTART = new SensingEventsDayEmissionDecision("RESTART", 1);
        IGNORE = new SensingEventsDayEmissionDecision("IGNORE", 2);
        SensingEventsDayEmissionDecision[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SensingEventsDayEmissionDecision(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SensingEventsDayEmissionDecision> getEntries() {
        return $ENTRIES;
    }

    public static SensingEventsDayEmissionDecision valueOf(String r2) {
        return (SensingEventsDayEmissionDecision) ZeusTransformUtils.preCheckCast(Enum.valueOf(SensingEventsDayEmissionDecision.class, r2), SensingEventsDayEmissionDecision.class, "com.obric.memorydata.plugin");
    }

    public static SensingEventsDayEmissionDecision[] values() {
        return (SensingEventsDayEmissionDecision[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SensingEventsDayEmissionDecision[].class, "com.obric.memorydata.plugin");
    }
}
