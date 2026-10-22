package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ResourceType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceType f5928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ResourceType f5929b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f5930c = null;

    static {
        ResourceType r5 = new ResourceType("DISK", 0);
        f5928a = r5;
        ResourceType r10 = new ResourceType("ASSET", 1);
        f5929b = r10;
        f5930c = new ResourceType[]{r5, r10};
    }

    public ResourceType(String r5, int r10) {
        super(r5, r10);
    }

    public static ResourceType valueOf(String r5) {
        return (ResourceType) Enum.valueOf(ResourceType.class, r5);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f5930c.clone();
    }
}
