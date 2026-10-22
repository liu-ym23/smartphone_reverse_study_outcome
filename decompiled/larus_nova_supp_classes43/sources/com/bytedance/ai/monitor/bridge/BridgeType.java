package com.bytedance.ai.monitor.bridge;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/monitor/bridge/BridgeType;", "", a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "V1", "IVY", "XBridge", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BridgeType extends Enum<BridgeType> {
    public static final BridgeType IVY = null;
    public static final BridgeType V1 = null;
    public static final BridgeType XBridge = null;
    public static final /* synthetic */ BridgeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<BridgeType> getEntries() {
        return b;
    }

    static {
        BridgeType r0 = new BridgeType("V1", 0, "v1");
        V1 = r0;
        BridgeType r1 = new BridgeType("IVY", 1, "ivy");
        IVY = r1;
        BridgeType r10 = new BridgeType("XBridge", 2, "xbridge");
        XBridge = r10;
        BridgeType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static BridgeType[] values() {
        return (BridgeType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BridgeType valueOf(String r1) {
        return (BridgeType) r27.a.a(BridgeType.class, r1);
    }

    public BridgeType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
