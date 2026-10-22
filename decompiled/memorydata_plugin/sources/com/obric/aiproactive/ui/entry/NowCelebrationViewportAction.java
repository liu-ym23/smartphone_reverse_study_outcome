package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowCelebrationViewportAction;", "", "<init>", "(Ljava/lang/String;I)V", "WAIT_FOR_LIST_TOP", "REQUEST_APP_BAR_EXPANSION", "WAIT_FOR_APP_BAR_EXPANSION", "START_CELEBRATION", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum NowCelebrationViewportAction extends Enum<NowCelebrationViewportAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NowCelebrationViewportAction[] $VALUES = null;
    public static final NowCelebrationViewportAction REQUEST_APP_BAR_EXPANSION = null;
    public static final NowCelebrationViewportAction START_CELEBRATION = null;
    public static final NowCelebrationViewportAction WAIT_FOR_APP_BAR_EXPANSION = null;
    public static final NowCelebrationViewportAction WAIT_FOR_LIST_TOP = null;

    private static final /* synthetic */ NowCelebrationViewportAction[] $values() {
        return new NowCelebrationViewportAction[]{WAIT_FOR_LIST_TOP, REQUEST_APP_BAR_EXPANSION, WAIT_FOR_APP_BAR_EXPANSION, START_CELEBRATION};
    }

    static {
        WAIT_FOR_LIST_TOP = new NowCelebrationViewportAction("WAIT_FOR_LIST_TOP", 0);
        REQUEST_APP_BAR_EXPANSION = new NowCelebrationViewportAction("REQUEST_APP_BAR_EXPANSION", 1);
        WAIT_FOR_APP_BAR_EXPANSION = new NowCelebrationViewportAction("WAIT_FOR_APP_BAR_EXPANSION", 2);
        START_CELEBRATION = new NowCelebrationViewportAction("START_CELEBRATION", 3);
        NowCelebrationViewportAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private NowCelebrationViewportAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<NowCelebrationViewportAction> getEntries() {
        return $ENTRIES;
    }

    public static NowCelebrationViewportAction valueOf(String r2) {
        return (NowCelebrationViewportAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(NowCelebrationViewportAction.class, r2), NowCelebrationViewportAction.class, "com.obric.memorydata.plugin");
    }

    public static NowCelebrationViewportAction[] values() {
        return (NowCelebrationViewportAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NowCelebrationViewportAction[].class, "com.obric.memorydata.plugin");
    }
}
