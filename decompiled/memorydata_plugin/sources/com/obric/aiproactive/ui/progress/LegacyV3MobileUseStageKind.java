package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/progress/LegacyV3MobileUseStageKind;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "ACTION", "DESTROY", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum LegacyV3MobileUseStageKind extends Enum<LegacyV3MobileUseStageKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LegacyV3MobileUseStageKind[] $VALUES = null;
    public static final LegacyV3MobileUseStageKind ACTION = null;
    public static final LegacyV3MobileUseStageKind DESTROY = null;
    public static final LegacyV3MobileUseStageKind INIT = null;

    private static final /* synthetic */ LegacyV3MobileUseStageKind[] $values() {
        return new LegacyV3MobileUseStageKind[]{INIT, ACTION, DESTROY};
    }

    static {
        INIT = new LegacyV3MobileUseStageKind("INIT", 0);
        ACTION = new LegacyV3MobileUseStageKind("ACTION", 1);
        DESTROY = new LegacyV3MobileUseStageKind("DESTROY", 2);
        LegacyV3MobileUseStageKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private LegacyV3MobileUseStageKind(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<LegacyV3MobileUseStageKind> getEntries() {
        return $ENTRIES;
    }

    public static LegacyV3MobileUseStageKind valueOf(String r2) {
        return (LegacyV3MobileUseStageKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(LegacyV3MobileUseStageKind.class, r2), LegacyV3MobileUseStageKind.class, "com.obric.memorydata.plugin");
    }

    public static LegacyV3MobileUseStageKind[] values() {
        return (LegacyV3MobileUseStageKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LegacyV3MobileUseStageKind[].class, "com.obric.memorydata.plugin");
    }
}
