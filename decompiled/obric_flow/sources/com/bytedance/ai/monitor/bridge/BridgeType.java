package com.bytedance.ai.monitor.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/BridgeType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BridgeType extends Enum<BridgeType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BridgeType f2387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BridgeType f2388c = null;
    public static final /* synthetic */ BridgeType[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2389a;

    static {
        BridgeType r5 = new BridgeType("V1", 0, "v1");
        f2387b = r5;
        BridgeType r10 = new BridgeType("IVY", 1, "ivy");
        BridgeType r11 = new BridgeType("XBridge", 2, "xbridge");
        f2388c = r11;
        BridgeType[] r12 = {r5, r10, r11};
        d = r12;
        EnumEntriesKt.enumEntries(r12);
    }

    public BridgeType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f2389a = r11;
    }

    public static BridgeType valueOf(String r5) {
        return (BridgeType) Enum.valueOf(BridgeType.class, r5);
    }

    public static BridgeType[] values() {
        return (BridgeType[]) d.clone();
    }
}
