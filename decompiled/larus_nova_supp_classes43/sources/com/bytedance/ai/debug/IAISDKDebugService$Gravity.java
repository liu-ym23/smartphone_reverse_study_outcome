package com.bytedance.ai.debug;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/debug/IAISDKDebugService$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_CENTER", "BOTTOM_RIGHT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IAISDKDebugService$Gravity extends Enum<IAISDKDebugService$Gravity> {
    public static final IAISDKDebugService$Gravity BOTTOM_CENTER = null;
    public static final IAISDKDebugService$Gravity BOTTOM_LEFT = null;
    public static final IAISDKDebugService$Gravity BOTTOM_RIGHT = null;
    public static final IAISDKDebugService$Gravity TOP_LEFT = null;
    public static final IAISDKDebugService$Gravity TOP_RIGHT = null;
    public static final /* synthetic */ IAISDKDebugService$Gravity[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IAISDKDebugService$Gravity> getEntries() {
        return b;
    }

    static {
        IAISDKDebugService$Gravity r0 = new IAISDKDebugService$Gravity("TOP_LEFT", 0);
        TOP_LEFT = r0;
        IAISDKDebugService$Gravity r1 = new IAISDKDebugService$Gravity("TOP_RIGHT", 1);
        TOP_RIGHT = r1;
        IAISDKDebugService$Gravity r10 = new IAISDKDebugService$Gravity("BOTTOM_LEFT", 2);
        BOTTOM_LEFT = r10;
        IAISDKDebugService$Gravity r11 = new IAISDKDebugService$Gravity("BOTTOM_CENTER", 3);
        BOTTOM_CENTER = r11;
        IAISDKDebugService$Gravity r12 = new IAISDKDebugService$Gravity("BOTTOM_RIGHT", 4);
        BOTTOM_RIGHT = r12;
        IAISDKDebugService$Gravity[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static IAISDKDebugService$Gravity[] values() {
        return (IAISDKDebugService$Gravity[]) a.clone();
    }

    public static IAISDKDebugService$Gravity valueOf(String r1) {
        return (IAISDKDebugService$Gravity) r27.a.a(IAISDKDebugService$Gravity.class, r1);
    }

    public IAISDKDebugService$Gravity(String r1, int r10) {
        super(r1, r10);
    }
}
