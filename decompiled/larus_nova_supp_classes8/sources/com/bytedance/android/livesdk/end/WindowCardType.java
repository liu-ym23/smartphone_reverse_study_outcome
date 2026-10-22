package com.bytedance.android.livesdk.end;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/end/WindowCardType;", "", "", "type", "J", "getType", "()J", "NO_COMPONENT", "WINDOW_RANK", "SHOP_CARD", "SECURITY_CARD", "VIP_END", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowCardType extends Enum<WindowCardType> {
    public static final WindowCardType NO_COMPONENT = null;
    public static final WindowCardType SECURITY_CARD = null;
    public static final WindowCardType SHOP_CARD = null;
    public static final WindowCardType VIP_END = null;
    public static final WindowCardType WINDOW_RANK = null;
    public static final /* synthetic */ WindowCardType[] a = null;
    private final long type;

    static {
        WindowCardType r1 = new WindowCardType("NO_COMPONENT", 0, 0);
        NO_COMPONENT = r1;
        WindowCardType r2 = new WindowCardType("WINDOW_RANK", 1, 1);
        WINDOW_RANK = r2;
        WindowCardType r3 = new WindowCardType("SHOP_CARD", 2, 2);
        SHOP_CARD = r3;
        WindowCardType r4 = new WindowCardType("SECURITY_CARD", 3, 3);
        SECURITY_CARD = r4;
        WindowCardType r5 = new WindowCardType("VIP_END", 4, 4);
        VIP_END = r5;
        a = new WindowCardType[]{r1, r2, r3, r4, r5};
    }

    public static WindowCardType valueOf(String r1) {
        return (WindowCardType) a.a(WindowCardType.class, r1);
    }

    public static WindowCardType[] values() {
        return (WindowCardType[]) a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public WindowCardType(String r1, int r2, long r3) {
        super(r1, r2);
        this.type = r3;
    }
}
