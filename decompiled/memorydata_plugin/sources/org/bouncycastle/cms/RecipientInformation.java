package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecipientInformation {
    private AuthAttributesProvider additionalData;
    protected AlgorithmIdentifier keyEncAlg;
    protected AlgorithmIdentifier messageAlgorithm;
    private RecipientOperator operator;
    protected RecipientId rid;
    protected CMSSecureReadable secureReadable;

    RecipientInformation(AlgorithmIdentifier r3, AlgorithmIdentifier r4, CMSSecureReadable r5, AuthAttributesProvider r6) {
        CMSSecureReadable r7 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r8 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r6, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        this.keyEncAlg = r3;
        this.messageAlgorithm = r4;
        this.secureReadable = r7;
        this.additionalData = r8;
    }

    public byte[] getContent(Recipient r3) {
        return CMSUtils.streamToByteArray(getContentStream((Recipient) ZeusTransformUtils.wrapperContextForParams(r3, Recipient.class, "com.obric.memorydata.plugin")).getContentStream());
    L5:
        e = move-exception;
        throw new CMSException("unable to parse internal stream: " + e.getMessage(), e);
    }

    public CMSTypedStream getContentStream(Recipient r3) {
        this.operator = getRecipientOperator((Recipient) ZeusTransformUtils.wrapperContextForParams(r3, Recipient.class, "com.obric.memorydata.plugin"));
        AuthAttributesProvider r4 = this.additionalData;
        if (r4 == null) goto L11;
        if (r4.isAead() == false) goto L9;
        this.operator.getAADStream().write(this.additionalData.getAuthAttributes().getEncoded("DER"));
        return new CMSTypedStream(this.secureReadable.getContentType(), this.operator.getInputStream(this.secureReadable.getInputStream()));
    L9:
        return new CMSTypedStream(this.secureReadable.getContentType(), this.secureReadable.getInputStream());
    L11:
        return new CMSTypedStream(this.secureReadable.getContentType(), this.operator.getInputStream(this.secureReadable.getInputStream()));
    }

    public RecipientId getRID() {
        return this.rid;
    }

    public abstract RecipientOperator getRecipientOperator(Recipient r1);
}
