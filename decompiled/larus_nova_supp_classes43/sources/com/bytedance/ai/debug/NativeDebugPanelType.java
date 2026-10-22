package com.bytedance.ai.debug;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/debug/NativeDebugPanelType;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG_PANEL", "AGENT_TRACE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NativeDebugPanelType extends Enum<NativeDebugPanelType> {
    public static final NativeDebugPanelType AGENT_TRACE = null;
    public static final NativeDebugPanelType DEBUG_PANEL = null;
    public static final /* synthetic */ NativeDebugPanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NativeDebugPanelType> getEntries() {
        return b;
    }

    static {
        NativeDebugPanelType r0 = new NativeDebugPanelType("DEBUG_PANEL", 0);
        DEBUG_PANEL = r0;
        NativeDebugPanelType r1 = new NativeDebugPanelType("AGENT_TRACE", 1);
        AGENT_TRACE = r1;
        NativeDebugPanelType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static NativeDebugPanelType[] values() {
        return (NativeDebugPanelType[]) a.clone();
    }

    public static NativeDebugPanelType valueOf(String r1) {
        return (NativeDebugPanelType) r27.a.a(NativeDebugPanelType.class, r1);
    }

    public NativeDebugPanelType(String r1, int r10) {
        super(r1, r10);
    }
}
