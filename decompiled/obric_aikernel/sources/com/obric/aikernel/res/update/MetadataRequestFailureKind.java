package com.obric.aikernel.res.update;

/* JADX INFO: loaded from: classes2.dex */
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

    private MetadataRequestFailureKind(String r10, int r11) {
        super(r10, r11);
    }

    public static MetadataRequestFailureKind valueOf(String r10) {
        return (MetadataRequestFailureKind) Enum.valueOf(MetadataRequestFailureKind.class, r10);
    }

    public static MetadataRequestFailureKind[] values() {
        return (MetadataRequestFailureKind[]) $VALUES.clone();
    }
}
