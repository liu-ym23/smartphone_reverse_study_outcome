package com.bytedance.ies.bullet.service.base.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum KitType extends Enum<KitType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KitType f6011b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KitType f6012c = null;
    public static final KitType d = null;
    public static final /* synthetic */ KitType[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6013a;

    static {
        KitType r5 = new KitType("UNKNOWN", 0, "unknown");
        f6011b = r5;
        KitType r10 = new KitType("WEB", 1, "web");
        f6012c = r10;
        KitType r11 = new KitType("RN", 2, "rn");
        KitType r12 = new KitType("LYNX", 3, "lynx");
        d = r12;
        e = new KitType[]{r5, r10, r11, r12};
    }

    public KitType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f6013a = r11;
    }

    public static KitType valueOf(String r5) {
        return (KitType) Enum.valueOf(KitType.class, r5);
    }

    public static KitType[] values() {
        return (KitType[]) e.clone();
    }
}
