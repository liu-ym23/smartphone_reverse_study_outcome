package com.bytedance.android.live.saas.middleware.di;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/di/FuncType;", "", "(Ljava/lang/String;I)V", "TYPE_INHOUSE", "TYPE_TOB", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final enum FuncType extends Enum<FuncType> {
    private static final /* synthetic */ FuncType[] $VALUES = null;
    public static final FuncType TYPE_INHOUSE = null;
    public static final FuncType TYPE_TOB = null;

    static {
        FuncType r1 = new FuncType("TYPE_INHOUSE", 0);
        TYPE_INHOUSE = r1;
        FuncType r2 = new FuncType("TYPE_TOB", 1);
        TYPE_TOB = r2;
        $VALUES = new FuncType[]{r1, r2};
    }

    public static FuncType valueOf(String r1) {
        return (FuncType) a.a(FuncType.class, r1);
    }

    public static FuncType[] values() {
        return (FuncType[]) $VALUES.clone();
    }

    private FuncType(String r1, int r2) {
        super(r1, r2);
    }
}
