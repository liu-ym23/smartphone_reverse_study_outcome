package com.bytedance.ies.xbridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum XBridgePlatformType extends Enum<XBridgePlatformType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XBridgePlatformType[] f6319a = null;

    static {
        f6319a = new XBridgePlatformType[]{new XBridgePlatformType("RN", 0), new XBridgePlatformType("WEB", 1), new XBridgePlatformType("LYNX", 2), new XBridgePlatformType("NONE", 3), new XBridgePlatformType("ALL", 4)};
    }

    public XBridgePlatformType(String r5, int r10) {
        super(r5, r10);
    }

    public static XBridgePlatformType valueOf(String r5) {
        return (XBridgePlatformType) Enum.valueOf(XBridgePlatformType.class, r5);
    }

    public static XBridgePlatformType[] values() {
        return (XBridgePlatformType[]) f6319a.clone();
    }
}
