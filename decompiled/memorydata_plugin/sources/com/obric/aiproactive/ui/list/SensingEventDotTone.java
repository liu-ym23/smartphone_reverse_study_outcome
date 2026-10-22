package com.obric.aiproactive.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/list/SensingEventDotTone;", "", "<init>", "(Ljava/lang/String;I)V", "HIGHLIGHT", "NORMAL", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SensingEventDotTone extends Enum<SensingEventDotTone> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SensingEventDotTone[] $VALUES = null;
    public static final SensingEventDotTone HIGHLIGHT = null;
    public static final SensingEventDotTone NORMAL = null;

    private static final /* synthetic */ SensingEventDotTone[] $values() {
        return new SensingEventDotTone[]{HIGHLIGHT, NORMAL};
    }

    static {
        HIGHLIGHT = new SensingEventDotTone("HIGHLIGHT", 0);
        NORMAL = new SensingEventDotTone("NORMAL", 1);
        SensingEventDotTone[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SensingEventDotTone(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SensingEventDotTone> getEntries() {
        return $ENTRIES;
    }

    public static SensingEventDotTone valueOf(String r2) {
        return (SensingEventDotTone) ZeusTransformUtils.preCheckCast(Enum.valueOf(SensingEventDotTone.class, r2), SensingEventDotTone.class, "com.obric.memorydata.plugin");
    }

    public static SensingEventDotTone[] values() {
        return (SensingEventDotTone[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SensingEventDotTone[].class, "com.obric.memorydata.plugin");
    }
}
