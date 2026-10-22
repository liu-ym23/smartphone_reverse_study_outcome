package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueQuickSelection;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ZERO", "ONE", "FIVE", "TEN", "TWENTY", "OTHER", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveValueQuickSelection extends Enum<ProactiveValueQuickSelection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveValueQuickSelection[] $VALUES = null;
    public static final ProactiveValueQuickSelection FIVE = null;
    public static final ProactiveValueQuickSelection NONE = null;
    public static final ProactiveValueQuickSelection ONE = null;
    public static final ProactiveValueQuickSelection OTHER = null;
    public static final ProactiveValueQuickSelection TEN = null;
    public static final ProactiveValueQuickSelection TWENTY = null;
    public static final ProactiveValueQuickSelection ZERO = null;

    private static final /* synthetic */ ProactiveValueQuickSelection[] $values() {
        return new ProactiveValueQuickSelection[]{NONE, ZERO, ONE, FIVE, TEN, TWENTY, OTHER};
    }

    static {
        NONE = new ProactiveValueQuickSelection("NONE", 0);
        ZERO = new ProactiveValueQuickSelection("ZERO", 1);
        ONE = new ProactiveValueQuickSelection("ONE", 2);
        FIVE = new ProactiveValueQuickSelection("FIVE", 3);
        TEN = new ProactiveValueQuickSelection("TEN", 4);
        TWENTY = new ProactiveValueQuickSelection("TWENTY", 5);
        OTHER = new ProactiveValueQuickSelection("OTHER", 6);
        ProactiveValueQuickSelection[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveValueQuickSelection(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveValueQuickSelection> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveValueQuickSelection valueOf(String r2) {
        return (ProactiveValueQuickSelection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveValueQuickSelection.class, r2), ProactiveValueQuickSelection.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveValueQuickSelection[] values() {
        return (ProactiveValueQuickSelection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveValueQuickSelection[].class, "com.obric.memorydata.plugin");
    }
}
