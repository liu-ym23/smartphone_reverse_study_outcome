package com.bytedance.android.live.schema.convert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/schema/convert/PopupGraType;", "", "BOTTOM", "OTHER", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupGraType extends Enum<PopupGraType> {
    public static final PopupGraType BOTTOM = null;
    public static final PopupGraType OTHER = null;
    public static final /* synthetic */ PopupGraType[] a = null;

    static {
        PopupGraType r1 = new PopupGraType("BOTTOM", 0);
        BOTTOM = r1;
        PopupGraType r2 = new PopupGraType("OTHER", 1);
        OTHER = r2;
        a = new PopupGraType[]{r1, r2};
    }

    public static PopupGraType valueOf(String r1) {
        return (PopupGraType) a.a(PopupGraType.class, r1);
    }

    public static PopupGraType[] values() {
        return (PopupGraType[]) a.clone();
    }

    public PopupGraType(String r1, int r2) {
        super(r1, r2);
    }
}
