package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/api/LightEffectStatus;", "", "<init>", "(Ljava/lang/String;I)V", "TURN_ON", "SLOWLY_FLASHING", "RAPID_FLASHING", "TURN_OFF", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LightEffectStatus extends Enum<LightEffectStatus> {
    public static final LightEffectStatus RAPID_FLASHING = null;
    public static final LightEffectStatus SLOWLY_FLASHING = null;
    public static final LightEffectStatus TURN_OFF = null;
    public static final LightEffectStatus TURN_ON = null;
    public static final /* synthetic */ LightEffectStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LightEffectStatus> getEntries() {
        return b;
    }

    static {
        LightEffectStatus r0 = new LightEffectStatus("TURN_ON", 0);
        TURN_ON = r0;
        LightEffectStatus r1 = new LightEffectStatus("SLOWLY_FLASHING", 1);
        SLOWLY_FLASHING = r1;
        LightEffectStatus r3 = new LightEffectStatus("RAPID_FLASHING", 2);
        RAPID_FLASHING = r3;
        LightEffectStatus r5 = new LightEffectStatus("TURN_OFF", 3);
        TURN_OFF = r5;
        LightEffectStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static LightEffectStatus[] values() {
        return (LightEffectStatus[]) a.clone();
    }

    public static LightEffectStatus valueOf(String r1) {
        return (LightEffectStatus) a.a(LightEffectStatus.class, r1);
    }

    public LightEffectStatus(String r1, int r2) {
        super(r1, r2);
    }
}
