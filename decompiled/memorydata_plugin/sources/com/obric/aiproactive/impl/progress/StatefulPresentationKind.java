package com.obric.aiproactive.impl.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/impl/progress/StatefulPresentationKind;", "", "<init>", "(Ljava/lang/String;I)V", "MOBILE_USE", "ACTIVITY", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum StatefulPresentationKind extends Enum<StatefulPresentationKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StatefulPresentationKind[] $VALUES = null;
    public static final StatefulPresentationKind ACTIVITY = null;
    public static final StatefulPresentationKind MOBILE_USE = null;

    private static final /* synthetic */ StatefulPresentationKind[] $values() {
        return new StatefulPresentationKind[]{MOBILE_USE, ACTIVITY};
    }

    static {
        MOBILE_USE = new StatefulPresentationKind("MOBILE_USE", 0);
        ACTIVITY = new StatefulPresentationKind("ACTIVITY", 1);
        StatefulPresentationKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private StatefulPresentationKind(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<StatefulPresentationKind> getEntries() {
        return $ENTRIES;
    }

    public static StatefulPresentationKind valueOf(String r2) {
        return (StatefulPresentationKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(StatefulPresentationKind.class, r2), StatefulPresentationKind.class, "com.obric.memorydata.plugin");
    }

    public static StatefulPresentationKind[] values() {
        return (StatefulPresentationKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StatefulPresentationKind[].class, "com.obric.memorydata.plugin");
    }
}
