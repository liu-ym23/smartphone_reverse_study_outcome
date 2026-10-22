package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVER_UI_COMPLETION", "RECONCILE_ONLY", "RECONCILE_OFF", "IGNORE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PinShortcutTerminalAction extends Enum<PinShortcutTerminalAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PinShortcutTerminalAction[] $VALUES = null;
    public static final PinShortcutTerminalAction DELIVER_UI_COMPLETION = null;
    public static final PinShortcutTerminalAction IGNORE = null;
    public static final PinShortcutTerminalAction RECONCILE_OFF = null;
    public static final PinShortcutTerminalAction RECONCILE_ONLY = null;

    private static final /* synthetic */ PinShortcutTerminalAction[] $values() {
        return new PinShortcutTerminalAction[]{DELIVER_UI_COMPLETION, RECONCILE_ONLY, RECONCILE_OFF, IGNORE};
    }

    static {
        DELIVER_UI_COMPLETION = new PinShortcutTerminalAction("DELIVER_UI_COMPLETION", 0);
        RECONCILE_ONLY = new PinShortcutTerminalAction("RECONCILE_ONLY", 1);
        RECONCILE_OFF = new PinShortcutTerminalAction("RECONCILE_OFF", 2);
        IGNORE = new PinShortcutTerminalAction("IGNORE", 3);
        PinShortcutTerminalAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PinShortcutTerminalAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PinShortcutTerminalAction> getEntries() {
        return $ENTRIES;
    }

    public static PinShortcutTerminalAction valueOf(String r2) {
        return (PinShortcutTerminalAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(PinShortcutTerminalAction.class, r2), PinShortcutTerminalAction.class, "com.obric.memorydata.plugin");
    }

    public static PinShortcutTerminalAction[] values() {
        return (PinShortcutTerminalAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PinShortcutTerminalAction[].class, "com.obric.memorydata.plugin");
    }
}
