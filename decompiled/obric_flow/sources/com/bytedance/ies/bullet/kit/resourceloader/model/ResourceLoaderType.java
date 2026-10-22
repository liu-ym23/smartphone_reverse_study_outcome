package com.bytedance.ies.bullet.kit.resourceloader.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ResourceLoaderType extends Enum<ResourceLoaderType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceLoaderType[] f5460a = null;

    static {
        f5460a = new ResourceLoaderType[]{new ResourceLoaderType("PPE", 0), new ResourceLoaderType("BOE", 1)};
    }

    public ResourceLoaderType(String r5, int r10) {
        super(r5, r10);
    }

    public static ResourceLoaderType valueOf(String r5) {
        return (ResourceLoaderType) Enum.valueOf(ResourceLoaderType.class, r5);
    }

    public static ResourceLoaderType[] values() {
        return (ResourceLoaderType[]) f5460a.clone();
    }
}
