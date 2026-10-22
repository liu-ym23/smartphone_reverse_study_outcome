package com.ss.ugc.live.sdk.message.data;

import com.ss.android.lark.http.model.http.HttpHeaders;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/sdk/message/data/PayloadItemType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "PAYLOAD_TYPE_CLOSE", "PAYLOAD_TYPE_ACK", "PAYLOAD_TYPE_MSG", "PAYLOAD_TYPE_HEARTBEAT", "PAYLOAD_TYPE_HOST_ACK", "PAYLOAD_TYPE_UPLINK", "PAYLOAD_TYPE_UMGW", "PAYLOAD_TYPE_RECONNECT", "PAYLOAD_TYPE_UNKNOW", "message_release"}, k = 1, mv = {1, 4, 0})
public final enum PayloadItemType extends Enum<PayloadItemType> {
    public static final PayloadItemType PAYLOAD_TYPE_ACK = null;
    public static final PayloadItemType PAYLOAD_TYPE_CLOSE = null;
    public static final PayloadItemType PAYLOAD_TYPE_HEARTBEAT = null;
    public static final PayloadItemType PAYLOAD_TYPE_HOST_ACK = null;
    public static final PayloadItemType PAYLOAD_TYPE_MSG = null;
    public static final PayloadItemType PAYLOAD_TYPE_RECONNECT = null;
    public static final PayloadItemType PAYLOAD_TYPE_UMGW = null;
    public static final PayloadItemType PAYLOAD_TYPE_UNKNOW = null;
    public static final PayloadItemType PAYLOAD_TYPE_UPLINK = null;
    public static final /* synthetic */ PayloadItemType[] a = null;
    private final String type;

    public static PayloadItemType valueOf(String r1) {
        return (PayloadItemType) a.a(PayloadItemType.class, r1);
    }

    public static PayloadItemType[] values() {
        return (PayloadItemType[]) a.clone();
    }

    static {
        PayloadItemType r1 = new PayloadItemType("PAYLOAD_TYPE_CLOSE", 0, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
        PAYLOAD_TYPE_CLOSE = r1;
        PayloadItemType r2 = new PayloadItemType("PAYLOAD_TYPE_ACK", 1, "ack");
        PAYLOAD_TYPE_ACK = r2;
        PayloadItemType r3 = new PayloadItemType("PAYLOAD_TYPE_MSG", 2, "msg");
        PAYLOAD_TYPE_MSG = r3;
        PayloadItemType r4 = new PayloadItemType("PAYLOAD_TYPE_HEARTBEAT", 3, "hb");
        PAYLOAD_TYPE_HEARTBEAT = r4;
        PayloadItemType r5 = new PayloadItemType("PAYLOAD_TYPE_HOST_ACK", 4, "frontier_ack");
        PAYLOAD_TYPE_HOST_ACK = r5;
        PayloadItemType r6 = new PayloadItemType("PAYLOAD_TYPE_UPLINK", 5, "uplink_im_gateway");
        PAYLOAD_TYPE_UPLINK = r6;
        PayloadItemType r7 = new PayloadItemType("PAYLOAD_TYPE_UMGW", 6, "umgw");
        PAYLOAD_TYPE_UMGW = r7;
        PayloadItemType r8 = new PayloadItemType("PAYLOAD_TYPE_RECONNECT", 7, "reconnect");
        PAYLOAD_TYPE_RECONNECT = r8;
        PayloadItemType r9 = new PayloadItemType("PAYLOAD_TYPE_UNKNOW", 8, "unknow");
        PAYLOAD_TYPE_UNKNOW = r9;
        a = new PayloadItemType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getType() {
        return this.type;
    }

    public PayloadItemType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
