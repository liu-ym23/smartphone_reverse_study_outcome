package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
class CMSEnvelopedHelper {

    static class CMSEnvelopedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private final ASN1ObjectIdentifier contentType;
        private CMSReadable readable;

        CMSEnvelopedSecureReadable(AlgorithmIdentifier r3, ASN1ObjectIdentifier r4, CMSReadable r5) {
            CMSReadable r6 = (CMSReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSReadable.class, "com.obric.memorydata.plugin");
            this.algorithm = r3;
            this.contentType = r4;
            this.readable = r6;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public ASN1ObjectIdentifier getContentType() {
            return this.contentType;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() {
            return this.readable.getInputStream();
        }
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set r2, AlgorithmIdentifier r3, CMSSecureReadable r4) {
        return buildRecipientInformationStore(r2, r3, (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r4, CMSSecureReadable.class, "com.obric.memorydata.plugin"), null);
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set r3, AlgorithmIdentifier r4, CMSSecureReadable r5, AuthAttributesProvider r6) {
        CMSSecureReadable r7 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r8 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r6, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 == r3.size()) goto L7;
        readRecipientInfo(r0, RecipientInfo.getInstance(r3.getObjectAt(r1)), r4, r7, r8);
        r1 = r1 + 1;
        goto L4
    L7:
        return new RecipientInformationStore(r0);
    }

    private static void readRecipientInfo(List r3, RecipientInfo r4, AlgorithmIdentifier r5, CMSSecureReadable r6, AuthAttributesProvider r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        CMSSecureReadable r9 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r6, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r10 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r7, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        ASN1Encodable r11 = r4.getInfo();
        if (ZeusTransformUtils.instanceOf(r11, KeyTransRecipientInfo.class) == false) goto L7;
        Object r0 = new KeyTransRecipientInformation((KeyTransRecipientInfo) ZeusTransformUtils.preCheckCast(r11, KeyTransRecipientInfo.class, "com.obric.memorydata.plugin"), r5, r9, r10);
    L5:
        r8.add(r0);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11, KEKRecipientInfo.class) == false) goto L10;
        r0 = new KEKRecipientInformation((KEKRecipientInfo) ZeusTransformUtils.preCheckCast(r11, KEKRecipientInfo.class, "com.obric.memorydata.plugin"), r5, r9, r10);
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r11, KeyAgreeRecipientInfo.class) == false) goto L13;
        KeyAgreeRecipientInformation.readRecipientInfo(r8, (KeyAgreeRecipientInfo) ZeusTransformUtils.preCheckCast(r11, KeyAgreeRecipientInfo.class, "com.obric.memorydata.plugin"), r5, r9, r10);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r11, PasswordRecipientInfo.class) == false) goto L17;
        r0 = new PasswordRecipientInformation((PasswordRecipientInfo) ZeusTransformUtils.preCheckCast(r11, PasswordRecipientInfo.class, "com.obric.memorydata.plugin"), r5, r9, r10);
        goto L5
    }
}
