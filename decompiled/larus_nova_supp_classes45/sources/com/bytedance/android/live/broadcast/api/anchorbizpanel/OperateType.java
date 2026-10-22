package com.bytedance.android.live.broadcast.api.anchorbizpanel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/anchorbizpanel/OperateType;", "", "ENTER", "EXIT", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperateType extends Enum<OperateType> {
    public static final OperateType ENTER = null;
    public static final OperateType EXIT = null;
    public static final /* synthetic */ OperateType[] a = null;

    static {
        OperateType r1 = new OperateType("ENTER", 0);
        ENTER = r1;
        OperateType r2 = new OperateType("EXIT", 1);
        EXIT = r2;
        a = new OperateType[]{r1, r2};
    }

    public static OperateType valueOf(String r1) {
        return (OperateType) a.a(OperateType.class, r1);
    }

    public static OperateType[] values() {
        return (OperateType[]) a.clone();
    }

    public OperateType(String r1, int r2) {
        super(r1, r2);
    }
}
