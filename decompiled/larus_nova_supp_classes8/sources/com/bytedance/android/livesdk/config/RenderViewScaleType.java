package com.bytedance.android.livesdk.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/RenderViewScaleType;", "", "", "value", "I", "getValue", "()I", "WIDTH_ALIGN", "HEIGHT_ALIGN", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RenderViewScaleType extends Enum<RenderViewScaleType> {
    public static final RenderViewScaleType HEIGHT_ALIGN = null;
    public static final RenderViewScaleType WIDTH_ALIGN = null;
    public static final /* synthetic */ RenderViewScaleType[] a = null;
    private final int value;

    static {
        RenderViewScaleType r2 = new RenderViewScaleType("WIDTH_ALIGN", 0, 1);
        WIDTH_ALIGN = r2;
        RenderViewScaleType r3 = new RenderViewScaleType("HEIGHT_ALIGN", 1, 2);
        HEIGHT_ALIGN = r3;
        a = new RenderViewScaleType[]{r2, r3};
    }

    public static RenderViewScaleType valueOf(String r1) {
        return (RenderViewScaleType) r27.a.a(RenderViewScaleType.class, r1);
    }

    public static RenderViewScaleType[] values() {
        return (RenderViewScaleType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RenderViewScaleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
