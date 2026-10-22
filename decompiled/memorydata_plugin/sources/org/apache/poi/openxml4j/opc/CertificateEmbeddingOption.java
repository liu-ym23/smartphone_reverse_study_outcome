package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum CertificateEmbeddingOption extends Enum<CertificateEmbeddingOption> {
    private static final /* synthetic */ CertificateEmbeddingOption[] $VALUES = null;
    public static final CertificateEmbeddingOption IN_CERTIFICATE_PART = null;
    public static final CertificateEmbeddingOption IN_SIGNATURE_PART = null;
    public static final CertificateEmbeddingOption NOT_EMBEDDED = null;

    static {
        CertificateEmbeddingOption r0 = new CertificateEmbeddingOption("IN_CERTIFICATE_PART", 0);
        IN_CERTIFICATE_PART = r0;
        CertificateEmbeddingOption r1 = new CertificateEmbeddingOption("IN_SIGNATURE_PART", 1);
        IN_SIGNATURE_PART = r1;
        CertificateEmbeddingOption r3 = new CertificateEmbeddingOption("NOT_EMBEDDED", 2);
        NOT_EMBEDDED = r3;
        $VALUES = new CertificateEmbeddingOption[]{r0, r1, r3};
    }

    private CertificateEmbeddingOption(String r1, int r2) {
        super(r1, r2);
    }

    public static CertificateEmbeddingOption valueOf(String r2) {
        return (CertificateEmbeddingOption) ZeusTransformUtils.preCheckCast(Enum.valueOf(CertificateEmbeddingOption.class, r2), CertificateEmbeddingOption.class, "com.obric.memorydata.plugin");
    }

    public static CertificateEmbeddingOption[] values() {
        return (CertificateEmbeddingOption[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CertificateEmbeddingOption[].class, "com.obric.memorydata.plugin");
    }
}
