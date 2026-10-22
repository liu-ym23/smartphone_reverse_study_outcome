package com.bytedance.lynx.service.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/lynx/service/model/LynxServiceConfig$AdapterType", "", "Lcom/bytedance/lynx/service/model/LynxServiceConfig$AdapterType;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxServiceConfig$AdapterType extends Enum<LynxServiceConfig$AdapterType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxServiceConfig$AdapterType f6827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LynxServiceConfig$AdapterType[] f6828b = null;

    static {
        LynxServiceConfig$AdapterType r5 = new LynxServiceConfig$AdapterType("COMMON", 0);
        f6827a = r5;
        f6828b = new LynxServiceConfig$AdapterType[]{r5, new LynxServiceConfig$AdapterType("GLOBAL", 1)};
    }

    public LynxServiceConfig$AdapterType(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxServiceConfig$AdapterType valueOf(String r5) {
        return (LynxServiceConfig$AdapterType) Enum.valueOf(LynxServiceConfig$AdapterType.class, r5);
    }

    public static LynxServiceConfig$AdapterType[] values() {
        return (LynxServiceConfig$AdapterType[]) f6828b.clone();
    }
}
