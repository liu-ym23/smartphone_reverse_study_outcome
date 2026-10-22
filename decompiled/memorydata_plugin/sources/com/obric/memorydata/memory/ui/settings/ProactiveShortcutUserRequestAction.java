package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/ProactiveShortcutUserRequestAction;", "", "<init>", "(Ljava/lang/String;I)V", "RESTRICT", "REFRESH_ACTIVE", "ENABLE_DISABLED", "REQUEST_PIN", "FAIL", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveShortcutUserRequestAction extends Enum<ProactiveShortcutUserRequestAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveShortcutUserRequestAction[] $VALUES = null;
    public static final ProactiveShortcutUserRequestAction ENABLE_DISABLED = null;
    public static final ProactiveShortcutUserRequestAction FAIL = null;
    public static final ProactiveShortcutUserRequestAction REFRESH_ACTIVE = null;
    public static final ProactiveShortcutUserRequestAction REQUEST_PIN = null;
    public static final ProactiveShortcutUserRequestAction RESTRICT = null;

    private static final /* synthetic */ ProactiveShortcutUserRequestAction[] $values() {
        return new ProactiveShortcutUserRequestAction[]{RESTRICT, REFRESH_ACTIVE, ENABLE_DISABLED, REQUEST_PIN, FAIL};
    }

    static {
        RESTRICT = new ProactiveShortcutUserRequestAction("RESTRICT", 0);
        REFRESH_ACTIVE = new ProactiveShortcutUserRequestAction("REFRESH_ACTIVE", 1);
        ENABLE_DISABLED = new ProactiveShortcutUserRequestAction("ENABLE_DISABLED", 2);
        REQUEST_PIN = new ProactiveShortcutUserRequestAction("REQUEST_PIN", 3);
        FAIL = new ProactiveShortcutUserRequestAction("FAIL", 4);
        ProactiveShortcutUserRequestAction[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveShortcutUserRequestAction(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveShortcutUserRequestAction> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveShortcutUserRequestAction valueOf(String r2) {
        return (ProactiveShortcutUserRequestAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveShortcutUserRequestAction.class, r2), ProactiveShortcutUserRequestAction.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveShortcutUserRequestAction[] values() {
        return (ProactiveShortcutUserRequestAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveShortcutUserRequestAction[].class, "com.obric.memorydata.plugin");
    }
}
