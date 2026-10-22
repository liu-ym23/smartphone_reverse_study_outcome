package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PLAIN", "UNORDERED", "ORDERED", "KEY_VALUE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AgentRunSecondaryListStyle extends Enum<AgentRunSecondaryListStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AgentRunSecondaryListStyle[] $VALUES = null;
    public static final AgentRunSecondaryListStyle KEY_VALUE = null;
    public static final AgentRunSecondaryListStyle ORDERED = null;
    public static final AgentRunSecondaryListStyle PLAIN = null;
    public static final AgentRunSecondaryListStyle UNORDERED = null;

    private static final /* synthetic */ AgentRunSecondaryListStyle[] $values() {
        return new AgentRunSecondaryListStyle[]{PLAIN, UNORDERED, ORDERED, KEY_VALUE};
    }

    static {
        PLAIN = new AgentRunSecondaryListStyle("PLAIN", 0);
        UNORDERED = new AgentRunSecondaryListStyle("UNORDERED", 1);
        ORDERED = new AgentRunSecondaryListStyle("ORDERED", 2);
        KEY_VALUE = new AgentRunSecondaryListStyle("KEY_VALUE", 3);
        AgentRunSecondaryListStyle[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AgentRunSecondaryListStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AgentRunSecondaryListStyle> getEntries() {
        return $ENTRIES;
    }

    public static AgentRunSecondaryListStyle valueOf(String r2) {
        return (AgentRunSecondaryListStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgentRunSecondaryListStyle.class, r2), AgentRunSecondaryListStyle.class, "com.obric.memorydata.plugin");
    }

    public static AgentRunSecondaryListStyle[] values() {
        return (AgentRunSecondaryListStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgentRunSecondaryListStyle[].class, "com.obric.memorydata.plugin");
    }
}
