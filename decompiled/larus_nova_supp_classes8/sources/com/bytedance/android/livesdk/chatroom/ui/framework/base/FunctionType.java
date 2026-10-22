package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/FunctionType;", "", "BASE", "BUSINESS", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FunctionType extends Enum<FunctionType> {
    public static final FunctionType BASE = null;
    public static final FunctionType BUSINESS = null;
    public static final /* synthetic */ FunctionType[] a = null;

    static {
        FunctionType r1 = new FunctionType("BASE", 0);
        BASE = r1;
        FunctionType r2 = new FunctionType("BUSINESS", 1);
        BUSINESS = r2;
        a = new FunctionType[]{r1, r2};
    }

    public static FunctionType valueOf(String r1) {
        return (FunctionType) r27.a.a(FunctionType.class, r1);
    }

    public static FunctionType[] values() {
        return (FunctionType[]) a.clone();
    }

    public FunctionType(String r1, int r2) {
        super(r1, r2);
    }
}
