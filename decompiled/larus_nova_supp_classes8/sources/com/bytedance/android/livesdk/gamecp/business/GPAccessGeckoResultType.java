package com.bytedance.android.livesdk.gamecp.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/business/GPAccessGeckoResultType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPAccessGeckoResultType extends Enum<GPAccessGeckoResultType> {
    public static final GPAccessGeckoResultType FAIL = null;
    public static final GPAccessGeckoResultType SUCCESS = null;
    public static final /* synthetic */ GPAccessGeckoResultType[] a = null;
    private final String value;

    static {
        GPAccessGeckoResultType r1 = new GPAccessGeckoResultType("SUCCESS", 0, "success");
        SUCCESS = r1;
        GPAccessGeckoResultType r2 = new GPAccessGeckoResultType("FAIL", 1, "fail");
        FAIL = r2;
        a = new GPAccessGeckoResultType[]{r1, r2};
    }

    public static GPAccessGeckoResultType valueOf(String r1) {
        return (GPAccessGeckoResultType) a.a(GPAccessGeckoResultType.class, r1);
    }

    public static GPAccessGeckoResultType[] values() {
        return (GPAccessGeckoResultType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public GPAccessGeckoResultType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
