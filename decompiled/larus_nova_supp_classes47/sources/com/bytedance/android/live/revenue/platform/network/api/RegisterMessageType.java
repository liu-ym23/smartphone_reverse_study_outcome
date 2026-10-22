package com.bytedance.android.live.revenue.platform.network.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/RegisterMessageType;", "", "", "type", "I", "getType", "()I", "IM", "WRDS", "ByteLink", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RegisterMessageType extends Enum<RegisterMessageType> {
    public static final RegisterMessageType ByteLink = null;
    public static final RegisterMessageType IM = null;
    public static final RegisterMessageType WRDS = null;
    public static final /* synthetic */ RegisterMessageType[] a = null;
    private final int type;

    static {
        RegisterMessageType r1 = new RegisterMessageType("IM", 0, 0);
        IM = r1;
        RegisterMessageType r2 = new RegisterMessageType("WRDS", 1, 1);
        WRDS = r2;
        RegisterMessageType r3 = new RegisterMessageType("ByteLink", 2, 2);
        ByteLink = r3;
        a = new RegisterMessageType[]{r1, r2, r3};
    }

    public static RegisterMessageType valueOf(String r1) {
        return (RegisterMessageType) a.a(RegisterMessageType.class, r1);
    }

    public static RegisterMessageType[] values() {
        return (RegisterMessageType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public RegisterMessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
