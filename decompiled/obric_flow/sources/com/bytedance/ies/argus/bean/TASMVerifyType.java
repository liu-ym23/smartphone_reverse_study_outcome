package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/TASMVerifyType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum TASMVerifyType extends Enum<TASMVerifyType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TASMVerifyType f5118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TASMVerifyType[] f5119b = null;

    static {
        TASMVerifyType r5 = new TASMVerifyType();
        f5118a = r5;
        f5119b = new TASMVerifyType[]{r5};
    }

    public TASMVerifyType() {
        super("SIGN", 0);
    }

    public static TASMVerifyType valueOf(String r5) {
        return (TASMVerifyType) Enum.valueOf(TASMVerifyType.class, r5);
    }

    public static TASMVerifyType[] values() {
        return (TASMVerifyType[]) f5119b.clone();
    }
}
