package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/grantingV2/FlowResult;", "", "<init>", "(Ljava/lang/String;I)V", "REQUIRES_CONFIRMATION", "CONTINUE_NEXT", "STOP_FLOW", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowResult extends Enum<FlowResult> {
    public static final FlowResult CONTINUE_NEXT = null;
    public static final FlowResult REQUIRES_CONFIRMATION = null;
    public static final FlowResult STOP_FLOW = null;
    public static final /* synthetic */ FlowResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowResult> getEntries() {
        return b;
    }

    static {
        FlowResult r0 = new FlowResult("REQUIRES_CONFIRMATION", 0);
        REQUIRES_CONFIRMATION = r0;
        FlowResult r1 = new FlowResult("CONTINUE_NEXT", 1);
        CONTINUE_NEXT = r1;
        FlowResult r10 = new FlowResult("STOP_FLOW", 2);
        STOP_FLOW = r10;
        FlowResult[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static FlowResult[] values() {
        return (FlowResult[]) a.clone();
    }

    public static FlowResult valueOf(String r1) {
        return (FlowResult) r27.a.a(FlowResult.class, r1);
    }

    public FlowResult(String r1, int r10) {
        super(r1, r10);
    }
}
