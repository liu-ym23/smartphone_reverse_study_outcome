package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/CacheType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum CacheType extends Enum<CacheType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheType f5916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CacheType f5917b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ CacheType[] f5918c = null;

    static {
        CacheType r5 = new CacheType("PRE_RENDER", 0);
        f5916a = r5;
        CacheType r10 = new CacheType("REUSE", 1);
        CacheType r11 = new CacheType("NONE", 2);
        f5917b = r11;
        f5918c = new CacheType[]{r5, r10, r11};
    }

    public CacheType(String r5, int r10) {
        super(r5, r10);
    }

    public static CacheType valueOf(String r5) {
        return (CacheType) Enum.valueOf(CacheType.class, r5);
    }

    public static CacheType[] values() {
        return (CacheType[]) f5918c.clone();
    }
}
