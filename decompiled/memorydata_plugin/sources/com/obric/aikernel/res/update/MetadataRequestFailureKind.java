package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/update/MetadataRequestFailureKind;", "", "(Ljava/lang/String;I)V", "TLS_BOOTSTRAP_PENDING", "NO_NETWORK", "STANDBY_REJECTED", "HTTP_STATUS_FAILURE", "BUSINESS_REJECTED", "RESPONSE_PARSE_FAILED", "UNKNOWN_TRANSPORT", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum MetadataRequestFailureKind extends Enum<MetadataRequestFailureKind> {
    private static final /* synthetic */ MetadataRequestFailureKind[] $VALUES = null;
    public static final MetadataRequestFailureKind BUSINESS_REJECTED = null;
    public static final MetadataRequestFailureKind HTTP_STATUS_FAILURE = null;
    public static final MetadataRequestFailureKind NO_NETWORK = null;
    public static final MetadataRequestFailureKind RESPONSE_PARSE_FAILED = null;
    public static final MetadataRequestFailureKind STANDBY_REJECTED = null;
    public static final MetadataRequestFailureKind TLS_BOOTSTRAP_PENDING = null;
    public static final MetadataRequestFailureKind UNKNOWN_TRANSPORT = null;

    private static final /* synthetic */ MetadataRequestFailureKind[] $values() {
        return new MetadataRequestFailureKind[]{TLS_BOOTSTRAP_PENDING, NO_NETWORK, STANDBY_REJECTED, HTTP_STATUS_FAILURE, BUSINESS_REJECTED, RESPONSE_PARSE_FAILED, UNKNOWN_TRANSPORT};
    }

    static {
        TLS_BOOTSTRAP_PENDING = new MetadataRequestFailureKind("TLS_BOOTSTRAP_PENDING", 0);
        NO_NETWORK = new MetadataRequestFailureKind("NO_NETWORK", 1);
        STANDBY_REJECTED = new MetadataRequestFailureKind("STANDBY_REJECTED", 2);
        HTTP_STATUS_FAILURE = new MetadataRequestFailureKind("HTTP_STATUS_FAILURE", 3);
        BUSINESS_REJECTED = new MetadataRequestFailureKind("BUSINESS_REJECTED", 4);
        RESPONSE_PARSE_FAILED = new MetadataRequestFailureKind("RESPONSE_PARSE_FAILED", 5);
        UNKNOWN_TRANSPORT = new MetadataRequestFailureKind("UNKNOWN_TRANSPORT", 6);
        $VALUES = $values();
    }

    private MetadataRequestFailureKind(String r1, int r2) {
        super(r1, r2);
    }

    public static MetadataRequestFailureKind valueOf(String r2) {
        return (MetadataRequestFailureKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(MetadataRequestFailureKind.class, r2), MetadataRequestFailureKind.class, "com.obric.memorydata.plugin");
    }

    public static MetadataRequestFailureKind[] values() {
        return (MetadataRequestFailureKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MetadataRequestFailureKind[].class, "com.obric.memorydata.plugin");
    }
}
