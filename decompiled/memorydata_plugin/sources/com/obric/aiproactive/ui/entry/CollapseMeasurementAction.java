package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/entry/CollapseMeasurementAction;", "", "<init>", "(Ljava/lang/String;I)V", "EVALUATE_NOW", "RETRY", "FORCE_ENABLE_COLLAPSE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CollapseMeasurementAction extends Enum<CollapseMeasurementAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CollapseMeasurementAction[] $VALUES = null;
    public static final CollapseMeasurementAction EVALUATE_NOW = null;
    public static final CollapseMeasurementAction FORCE_ENABLE_COLLAPSE = null;
    public static final CollapseMeasurementAction RETRY = null;

    private static final /* synthetic */ CollapseMeasurementAction[] $values() {
        return new CollapseMeasurementAction[]{EVALUATE_NOW, RETRY, FORCE_ENABLE_COLLAPSE};
    }

    static {
        EVALUATE_NOW = new CollapseMeasurementAction("EVALUATE_NOW", 0);
        RETRY = new CollapseMeasurementAction("RETRY", 1);
        FORCE_ENABLE_COLLAPSE = new CollapseMeasurementAction("FORCE_ENABLE_COLLAPSE", 2);
        CollapseMeasurementAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private CollapseMeasurementAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<CollapseMeasurementAction> getEntries() {
        return $ENTRIES;
    }

    public static CollapseMeasurementAction valueOf(String r2) {
        return (CollapseMeasurementAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(CollapseMeasurementAction.class, r2), CollapseMeasurementAction.class, "com.obric.memorydata.plugin");
    }

    public static CollapseMeasurementAction[] values() {
        return (CollapseMeasurementAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CollapseMeasurementAction[].class, "com.obric.memorydata.plugin");
    }
}
