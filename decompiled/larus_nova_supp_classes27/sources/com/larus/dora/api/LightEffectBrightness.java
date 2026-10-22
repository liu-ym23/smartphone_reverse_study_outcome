package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/api/LightEffectBrightness;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;II)V", "getProtocolValue", "()I", "LOW", "NORMAL", "HIGH", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LightEffectBrightness extends Enum<LightEffectBrightness> {
    public static final LightEffectBrightness HIGH = null;
    public static final LightEffectBrightness LOW = null;
    public static final LightEffectBrightness NORMAL = null;
    public static final /* synthetic */ LightEffectBrightness[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int protocolValue;

    public static EnumEntries<LightEffectBrightness> getEntries() {
        return b;
    }

    static {
        LightEffectBrightness r0 = new LightEffectBrightness("LOW", 0, 1);
        LOW = r0;
        LightEffectBrightness r1 = new LightEffectBrightness("NORMAL", 1, 2);
        NORMAL = r1;
        LightEffectBrightness r4 = new LightEffectBrightness("HIGH", 2, 3);
        HIGH = r4;
        LightEffectBrightness[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static LightEffectBrightness[] values() {
        return (LightEffectBrightness[]) a.clone();
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static LightEffectBrightness valueOf(String r1) {
        return (LightEffectBrightness) a.a(LightEffectBrightness.class, r1);
    }

    public LightEffectBrightness(String r1, int r2, int r3) {
        super(r1, r2);
        this.protocolValue = r3;
    }
}
