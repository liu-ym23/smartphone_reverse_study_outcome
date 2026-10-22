package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveShortcutCompletion;", "", "<init>", "(Ljava/lang/String;I)V", "PINNED", "NOT_PINNED", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProactiveShortcutCompletion extends Enum<ProactiveShortcutCompletion> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProactiveShortcutCompletion[] $VALUES = null;
    public static final ProactiveShortcutCompletion NOT_PINNED = null;
    public static final ProactiveShortcutCompletion PINNED = null;

    private static final /* synthetic */ ProactiveShortcutCompletion[] $values() {
        return new ProactiveShortcutCompletion[]{PINNED, NOT_PINNED};
    }

    static {
        PINNED = new ProactiveShortcutCompletion("PINNED", 0);
        NOT_PINNED = new ProactiveShortcutCompletion("NOT_PINNED", 1);
        ProactiveShortcutCompletion[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProactiveShortcutCompletion(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProactiveShortcutCompletion> getEntries() {
        return $ENTRIES;
    }

    public static ProactiveShortcutCompletion valueOf(String r2) {
        return (ProactiveShortcutCompletion) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProactiveShortcutCompletion.class, r2), ProactiveShortcutCompletion.class, "com.obric.memorydata.plugin");
    }

    public static ProactiveShortcutCompletion[] values() {
        return (ProactiveShortcutCompletion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProactiveShortcutCompletion[].class, "com.obric.memorydata.plugin");
    }
}
