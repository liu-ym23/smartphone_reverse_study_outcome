package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutPolicyAction;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLE", "REFRESH_ACTIVE", "ENABLE_DISABLED", "NO_OP", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveShortcutPolicyAction extends Enum<ProactiveShortcutPolicyAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveShortcutPolicyAction[] $VALUES = null;
    public static final ProactiveShortcutPolicyAction DISABLE = null;
    public static final ProactiveShortcutPolicyAction ENABLE_DISABLED = null;
    public static final ProactiveShortcutPolicyAction NO_OP = null;
    public static final ProactiveShortcutPolicyAction REFRESH_ACTIVE = null;

    private static final /* synthetic */ ProactiveShortcutPolicyAction[] $values() {
        return new ProactiveShortcutPolicyAction[]{DISABLE, REFRESH_ACTIVE, ENABLE_DISABLED, NO_OP};
    }

    static {
        DISABLE = new ProactiveShortcutPolicyAction("DISABLE", 0);
        REFRESH_ACTIVE = new ProactiveShortcutPolicyAction("REFRESH_ACTIVE", 1);
        ENABLE_DISABLED = new ProactiveShortcutPolicyAction("ENABLE_DISABLED", 2);
        NO_OP = new ProactiveShortcutPolicyAction("NO_OP", 3);
        ProactiveShortcutPolicyAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveShortcutPolicyAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveShortcutPolicyAction> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveShortcutPolicyAction valueOf(String r2) {
        return (ProactiveShortcutPolicyAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveShortcutPolicyAction.class, r2), ProactiveShortcutPolicyAction.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveShortcutPolicyAction[] values() {
        return (ProactiveShortcutPolicyAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveShortcutPolicyAction[].class, "com.obric.memorydata.plugin");
    }
}
