package com.bytedance.env.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/env/api/EnvType;", "", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final enum EnvType extends Enum<EnvType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnvType f4190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnvType f4191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnvType f4192c = null;
    public static final EnvType d = null;
    public static final /* synthetic */ EnvType[] e = null;

    static {
        EnvType r5 = new EnvType("PRODUCT", 0);
        f4190a = r5;
        EnvType r10 = new EnvType("CANARY", 1);
        f4191b = r10;
        EnvType r11 = new EnvType("PPE", 2);
        f4192c = r11;
        EnvType r12 = new EnvType("BOE", 3);
        d = r12;
        e = new EnvType[]{r5, r10, r11, r12};
    }

    public EnvType(String r5, int r10) {
        super(r5, r10);
    }

    public static EnvType valueOf(String r5) {
        return (EnvType) Enum.valueOf(EnvType.class, r5);
    }

    public static EnvType[] values() {
        return (EnvType[]) e.clone();
    }
}
