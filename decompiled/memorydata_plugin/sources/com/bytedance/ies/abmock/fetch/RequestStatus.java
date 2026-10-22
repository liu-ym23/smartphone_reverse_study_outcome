package com.bytedance.ies.abmock.fetch;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/abmock/fetch/RequestStatus;", "", "(Ljava/lang/String;I)V", "SUCCESS", "REQUEST_BUILD_FAILED", "REQUEST_FAIL", "HASH_CHECK_FAILED", "DATA_STORE_FAILED", "OTHER_FAILED", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum RequestStatus extends Enum<RequestStatus> {
    private static final /* synthetic */ RequestStatus[] $VALUES = null;
    public static final RequestStatus DATA_STORE_FAILED = null;
    public static final RequestStatus HASH_CHECK_FAILED = null;
    public static final RequestStatus OTHER_FAILED = null;
    public static final RequestStatus REQUEST_BUILD_FAILED = null;
    public static final RequestStatus REQUEST_FAIL = null;
    public static final RequestStatus SUCCESS = null;

    private static final /* synthetic */ RequestStatus[] $values() {
        return new RequestStatus[]{SUCCESS, REQUEST_BUILD_FAILED, REQUEST_FAIL, HASH_CHECK_FAILED, DATA_STORE_FAILED, OTHER_FAILED};
    }

    static {
        SUCCESS = new RequestStatus("SUCCESS", 0);
        REQUEST_BUILD_FAILED = new RequestStatus("REQUEST_BUILD_FAILED", 1);
        REQUEST_FAIL = new RequestStatus("REQUEST_FAIL", 2);
        HASH_CHECK_FAILED = new RequestStatus("HASH_CHECK_FAILED", 3);
        DATA_STORE_FAILED = new RequestStatus("DATA_STORE_FAILED", 4);
        OTHER_FAILED = new RequestStatus("OTHER_FAILED", 5);
        $VALUES = $values();
    }

    private RequestStatus(String r1, int r2) {
        super(r1, r2);
    }

    public static RequestStatus valueOf(String r2) {
        return (RequestStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(RequestStatus.class, r2), RequestStatus.class, "com.obric.memorydata.plugin");
    }

    public static RequestStatus[] values() {
        return (RequestStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RequestStatus[].class, "com.obric.memorydata.plugin");
    }
}
