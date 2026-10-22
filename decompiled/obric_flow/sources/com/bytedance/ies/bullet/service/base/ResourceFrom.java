package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ResourceFrom extends Enum<ResourceFrom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceFrom f5925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ResourceFrom f5926b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ResourceFrom f5927c = null;
    public static final ResourceFrom d = null;
    public static final /* synthetic */ ResourceFrom[] e = null;

    static {
        ResourceFrom r5 = new ResourceFrom("GECKO", 0);
        f5925a = r5;
        ResourceFrom r10 = new ResourceFrom("BUILTIN", 1);
        f5926b = r10;
        ResourceFrom r11 = new ResourceFrom("CDN", 2);
        f5927c = r11;
        ResourceFrom r12 = new ResourceFrom("LOCAL_FILE", 3);
        ResourceFrom r13 = new ResourceFrom("PRELOAD", 4);
        d = r13;
        e = new ResourceFrom[]{r5, r10, r11, r12, r13};
    }

    public ResourceFrom(String r5, int r10) {
        super(r5, r10);
    }

    public static ResourceFrom valueOf(String r5) {
        return (ResourceFrom) Enum.valueOf(ResourceFrom.class, r5);
    }

    public static ResourceFrom[] values() {
        return (ResourceFrom[]) e.clone();
    }
}
