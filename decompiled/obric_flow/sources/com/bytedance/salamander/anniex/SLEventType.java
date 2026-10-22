package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEventType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum SLEventType extends Enum<SLEventType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SLEventType f7227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SLEventType f7228b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SLEventType f7229c = null;
    public static final /* synthetic */ SLEventType[] d = null;

    static {
        SLEventType r5 = new SLEventType("PV", 0);
        SLEventType r10 = new SLEventType("FETCH_ERROR", 1);
        SLEventType r11 = new SLEventType("JSB_ERROR", 2);
        f7227a = r11;
        SLEventType r12 = new SLEventType("JSB_PERF", 3);
        f7228b = r12;
        SLEventType r13 = new SLEventType("JS_EXCEPTION", 4);
        f7229c = r13;
        d = new SLEventType[]{r5, r10, r11, r12, r13, new SLEventType("PERFORMANCE", 5), new SLEventType("BLANK", 6), new SLEventType("JSB_PAGE_VISIT", 7), new SLEventType("NATIVE_ERROR", 8), new SLEventType("CONTAINER_ERROR", 9), new SLEventType("RESOURCE_PERFORMANCE", 10), new SLEventType("RES_LOADER_PERF", 11), new SLEventType("RES_LOADER_PERF_TEMPLATE", 12), new SLEventType("RES_LOADER_ERROR", 13), new SLEventType("RES_LOADER_ERROR_TEMPLATE", 14), new SLEventType("AJAX", 15), new SLEventType("STATIC", 16), new SLEventType("STATIC_SRI", 17)};
    }

    public SLEventType(String r5, int r10) {
        super(r5, r10);
    }

    public static SLEventType valueOf(String r5) {
        return (SLEventType) Enum.valueOf(SLEventType.class, r5);
    }

    public static SLEventType[] values() {
        return (SLEventType[]) d.clone();
    }
}
