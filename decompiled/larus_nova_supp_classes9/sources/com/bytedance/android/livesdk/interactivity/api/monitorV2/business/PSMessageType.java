package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSMessageType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "msgType", "Ljava/lang/String;", "getMsgType", "()Ljava/lang/String;", "CHAT", "GIFT", "SYSTEM", "OTHER", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessageType extends Enum<PSMessageType> {
    public static final PSMessageType CHAT = null;
    public static final PSMessageType GIFT = null;
    public static final PSMessageType OTHER = null;
    public static final PSMessageType SYSTEM = null;
    public static final /* synthetic */ PSMessageType[] a = null;
    private final String msgType;

    static {
        PSMessageType r1 = new PSMessageType("CHAT", 0, "chat");
        CHAT = r1;
        PSMessageType r2 = new PSMessageType("GIFT", 1, "gift");
        GIFT = r2;
        PSMessageType r3 = new PSMessageType("SYSTEM", 2, "system");
        SYSTEM = r3;
        PSMessageType r4 = new PSMessageType("OTHER", 3, "other");
        OTHER = r4;
        a = new PSMessageType[]{r1, r2, r3, r4};
    }

    public static PSMessageType valueOf(String r1) {
        return (PSMessageType) a.a(PSMessageType.class, r1);
    }

    public static PSMessageType[] values() {
        return (PSMessageType[]) a.clone();
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public PSMessageType(String r1, int r2, String r3) {
        super(r1, r2);
        this.msgType = r3;
    }
}
