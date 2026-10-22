package com.obric.memorydata.sdk.server;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/server/AssistantStateTag;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CONTEXT", "MEMORY", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AssistantStateTag extends Enum<AssistantStateTag> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AssistantStateTag[] $VALUES = null;
    public static final AssistantStateTag MEMORY = null;
    public static final AssistantStateTag REALTIME_CONTEXT = null;

    private static final /* synthetic */ AssistantStateTag[] $values() {
        return new AssistantStateTag[]{REALTIME_CONTEXT, MEMORY};
    }

    static {
        REALTIME_CONTEXT = new AssistantStateTag("REALTIME_CONTEXT", 0);
        MEMORY = new AssistantStateTag("MEMORY", 1);
        AssistantStateTag[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AssistantStateTag(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AssistantStateTag> getEntries() {
        return $ENTRIES;
    }

    public static AssistantStateTag valueOf(String r2) {
        return (AssistantStateTag) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistantStateTag.class, r2), AssistantStateTag.class, "com.obric.memorydata.plugin");
    }

    public static AssistantStateTag[] values() {
        return (AssistantStateTag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistantStateTag[].class, "com.obric.memorydata.plugin");
    }
}
