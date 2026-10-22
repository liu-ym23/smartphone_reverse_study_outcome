package com.bytedance.env.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/env/api/AccessKeyType;", "", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final enum AccessKeyType extends Enum<AccessKeyType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AccessKeyType f4187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AccessKeyType[] f4188b = null;

    static {
        AccessKeyType r5 = new AccessKeyType("INHOUSE", 0);
        f4187a = r5;
        f4188b = new AccessKeyType[]{r5, new AccessKeyType("ONLINE", 1), new AccessKeyType("BOE", 2)};
    }

    public AccessKeyType(String r5, int r10) {
        super(r5, r10);
    }

    public static AccessKeyType valueOf(String r5) {
        return (AccessKeyType) Enum.valueOf(AccessKeyType.class, r5);
    }

    public static AccessKeyType[] values() {
        return (AccessKeyType[]) f4188b.clone();
    }
}
