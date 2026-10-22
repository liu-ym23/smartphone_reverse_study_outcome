package com.obric.memorydata.memory.ui.list.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetSearchAction;", "", "<init>", "(Ljava/lang/String;I)V", "WAIT", "SCROLL_TO_TARGET", "LOAD_NEXT_PAGE", "LOAD_PREVIOUS_PAGE", "COMPLETE_NOT_FOUND", "COMPLETE_FAILED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContextAwarenessTargetSearchAction extends Enum<ContextAwarenessTargetSearchAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContextAwarenessTargetSearchAction[] $VALUES = null;
    public static final ContextAwarenessTargetSearchAction COMPLETE_FAILED = null;
    public static final ContextAwarenessTargetSearchAction COMPLETE_NOT_FOUND = null;
    public static final ContextAwarenessTargetSearchAction LOAD_NEXT_PAGE = null;
    public static final ContextAwarenessTargetSearchAction LOAD_PREVIOUS_PAGE = null;
    public static final ContextAwarenessTargetSearchAction SCROLL_TO_TARGET = null;
    public static final ContextAwarenessTargetSearchAction WAIT = null;

    private static final /* synthetic */ ContextAwarenessTargetSearchAction[] $values() {
        return new ContextAwarenessTargetSearchAction[]{WAIT, SCROLL_TO_TARGET, LOAD_NEXT_PAGE, LOAD_PREVIOUS_PAGE, COMPLETE_NOT_FOUND, COMPLETE_FAILED};
    }

    static {
        WAIT = new ContextAwarenessTargetSearchAction("WAIT", 0);
        SCROLL_TO_TARGET = new ContextAwarenessTargetSearchAction("SCROLL_TO_TARGET", 1);
        LOAD_NEXT_PAGE = new ContextAwarenessTargetSearchAction("LOAD_NEXT_PAGE", 2);
        LOAD_PREVIOUS_PAGE = new ContextAwarenessTargetSearchAction("LOAD_PREVIOUS_PAGE", 3);
        COMPLETE_NOT_FOUND = new ContextAwarenessTargetSearchAction("COMPLETE_NOT_FOUND", 4);
        COMPLETE_FAILED = new ContextAwarenessTargetSearchAction("COMPLETE_FAILED", 5);
        ContextAwarenessTargetSearchAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ContextAwarenessTargetSearchAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ContextAwarenessTargetSearchAction> getEntries() {
        return $ENTRIES;
    }

    public static ContextAwarenessTargetSearchAction valueOf(String r2) {
        return (ContextAwarenessTargetSearchAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContextAwarenessTargetSearchAction.class, r2), ContextAwarenessTargetSearchAction.class, "com.obric.memorydata.plugin");
    }

    public static ContextAwarenessTargetSearchAction[] values() {
        return (ContextAwarenessTargetSearchAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContextAwarenessTargetSearchAction[].class, "com.obric.memorydata.plugin");
    }
}
