package com.bytedance.android.live.schema.convert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/schema/convert/HybridUiType;", "", "FULLSCREEN", "POPUP", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HybridUiType extends Enum<HybridUiType> {
    public static final HybridUiType FULLSCREEN = null;
    public static final HybridUiType POPUP = null;
    public static final /* synthetic */ HybridUiType[] a = null;

    static {
        HybridUiType r1 = new HybridUiType("FULLSCREEN", 0);
        FULLSCREEN = r1;
        HybridUiType r2 = new HybridUiType("POPUP", 1);
        POPUP = r2;
        a = new HybridUiType[]{r1, r2};
    }

    public static HybridUiType valueOf(String r1) {
        return (HybridUiType) a.a(HybridUiType.class, r1);
    }

    public static HybridUiType[] values() {
        return (HybridUiType[]) a.clone();
    }

    public HybridUiType(String r1, int r2) {
        super(r1, r2);
    }
}
