package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/api/DebugEntranceMode;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebugEntranceMode extends Enum<DebugEntranceMode> {
    public static final DebugEntranceMode CLOSE = null;
    public static final DebugEntranceMode OPEN = null;
    public static final /* synthetic */ DebugEntranceMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DebugEntranceMode> getEntries() {
        return b;
    }

    static {
        DebugEntranceMode r0 = new DebugEntranceMode("OPEN", 0);
        OPEN = r0;
        DebugEntranceMode r1 = new DebugEntranceMode("CLOSE", 1);
        CLOSE = r1;
        DebugEntranceMode[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static DebugEntranceMode[] values() {
        return (DebugEntranceMode[]) a.clone();
    }

    public static DebugEntranceMode valueOf(String r1) {
        return (DebugEntranceMode) r27.a.a(DebugEntranceMode.class, r1);
    }

    public DebugEntranceMode(String r1, int r10) {
        super(r1, r10);
    }
}
