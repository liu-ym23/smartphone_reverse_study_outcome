package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final enum BaseDispatchAction$DispatchResultEnum extends Enum<BaseDispatchAction$DispatchResultEnum> {
    public static final BaseDispatchAction$DispatchResultEnum DISPATCH_DELAY = null;
    public static final BaseDispatchAction$DispatchResultEnum DISPATCH_DROP = null;
    public static final BaseDispatchAction$DispatchResultEnum DISPATCH_HIT = null;
    public static final BaseDispatchAction$DispatchResultEnum DISPATCH_NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseDispatchAction$DispatchResultEnum[] f4686a = null;

    static {
        BaseDispatchAction$DispatchResultEnum r5 = new BaseDispatchAction$DispatchResultEnum("DISPATCH_NONE", 0);
        DISPATCH_NONE = r5;
        BaseDispatchAction$DispatchResultEnum r10 = new BaseDispatchAction$DispatchResultEnum("DISPATCH_HIT", 1);
        DISPATCH_HIT = r10;
        BaseDispatchAction$DispatchResultEnum r11 = new BaseDispatchAction$DispatchResultEnum("DISPATCH_DROP", 2);
        DISPATCH_DROP = r11;
        BaseDispatchAction$DispatchResultEnum r12 = new BaseDispatchAction$DispatchResultEnum("DISPATCH_DELAY", 3);
        DISPATCH_DELAY = r12;
        f4686a = new BaseDispatchAction$DispatchResultEnum[]{r5, r10, r11, r12};
    }

    public static BaseDispatchAction$DispatchResultEnum valueOf(String r5) {
        return (BaseDispatchAction$DispatchResultEnum) Enum.valueOf(BaseDispatchAction$DispatchResultEnum.class, r5);
    }

    public static BaseDispatchAction$DispatchResultEnum[] values() {
        return (BaseDispatchAction$DispatchResultEnum[]) f4686a.clone();
    }
}
