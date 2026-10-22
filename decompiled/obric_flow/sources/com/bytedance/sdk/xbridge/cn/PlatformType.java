package com.bytedance.sdk.xbridge.cn;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum PlatformType extends Enum<PlatformType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlatformType f7287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlatformType f7288b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PlatformType f7289c = null;
    public static final /* synthetic */ PlatformType[] d = null;

    static {
        PlatformType r5 = new PlatformType("LYNX", 0);
        f7287a = r5;
        PlatformType r10 = new PlatformType("WEB", 1);
        f7288b = r10;
        PlatformType r11 = new PlatformType("WORKER", 2);
        f7289c = r11;
        d = new PlatformType[]{r5, r10, r11};
    }

    public PlatformType(String r5, int r10) {
        super(r5, r10);
    }

    public static PlatformType valueOf(String r5) {
        return (PlatformType) Enum.valueOf(PlatformType.class, r5);
    }

    public static PlatformType[] values() {
        return (PlatformType[]) d.clone();
    }
}
