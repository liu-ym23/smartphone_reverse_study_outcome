package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes7.dex */
public class TBSCertList extends ASN1Object {
    Extensions crlExtensions;
    X500Name issuer;
    Time nextUpdate;
    ASN1Sequence revokedCertificates;
    AlgorithmIdentifier signature;
    Time thisUpdate;
    ASN1Integer version;

    /* JADX INFO: renamed from: org.bouncycastle.asn1.x509.TBSCertList$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class CRLEntry extends ASN1Object {
        Extensions crlEntryExtensions;
        ASN1Sequence seq;

        private CRLEntry(ASN1Sequence r3) {
            if (r3.size() < 2) goto L9;
            if (r3.size() > 3) goto L9;
            this.seq = r3;
            return;
        L9:
            throw new IllegalArgumentException("Bad sequence size: " + r3.size());
        }

        public static CRLEntry getInstance(Object r2) {
            if (ZeusTransformUtils.instanceOf(r2, CRLEntry.class) == true) goto L5;
            if (r2 != null) goto L8;
            return null;
        L8:
            return new CRLEntry(ASN1Sequence.getInstance(r2));
        L5:
            return (CRLEntry) ZeusTransformUtils.preCheckCast(r2, CRLEntry.class, "com.obric.memorydata.plugin");
        }

        public Extensions getExtensions() {
            if (this.crlEntryExtensions != null) goto L8;
            if (this.seq.size() != 3) goto L8;
            this.crlEntryExtensions = Extensions.getInstance(this.seq.getObjectAt(2));
        L8:
            return this.crlEntryExtensions;
        }

        public Time getRevocationDate() {
            return Time.getInstance(this.seq.getObjectAt(1));
        }

        public ASN1Integer getUserCertificate() {
            return ASN1Integer.getInstance(this.seq.getObjectAt(0));
        }

        public boolean hasExtensions() {
            if (this.seq.size() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.seq;
        }
    }

    private static class EmptyEnumeration implements Enumeration {
        private EmptyEnumeration() {
        }

        /* synthetic */ EmptyEnumeration(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    private static class RevokedCertificatesEnumeration implements Enumeration {
        private final Enumeration en;

        RevokedCertificatesEnumeration(Enumeration r3) {
            this.en = (Enumeration) ZeusTransformUtils.wrapperContextForParams(r3, Enumeration.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.en.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return CRLEntry.getInstance(this.en.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence r5) {
        if (r5.size() < 3) goto L31;
        if (r5.size() > 7) goto L31;
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(0), ASN1Integer.class) == false) goto L9;
        this.version = ASN1Integer.getInstance(r5.getObjectAt(0));
        r0 = 1;
    L10:
        int r1 = r0 + 1;
        this.signature = AlgorithmIdentifier.getInstance(r5.getObjectAt(r0));
        int r2 = r1 + 1;
        this.issuer = X500Name.getInstance(r5.getObjectAt(r1));
        int r3 = r2 + 1;
        this.thisUpdate = Time.getInstance(r5.getObjectAt(r2));
        if (r3 >= r5.size()) goto L20;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(r3), ASN1UTCTime.class) == false) goto L15;
    L18:
        this.nextUpdate = Time.getInstance(r5.getObjectAt(r3));
        r3 = r3 + 1;
        goto L20
    L15:
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(r3), ASN1GeneralizedTime.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(r3), Time.class) == true) goto L18;
    L20:
        if (r3 >= r5.size()) goto L25;
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(r3), ASN1TaggedObject.class) == true) goto L25;
        this.revokedCertificates = ASN1Sequence.getInstance(r5.getObjectAt(r3));
        r3 = r3 + 1;
    L25:
        if (r3 < r5.size()) goto L27;
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r5.getObjectAt(r3), ASN1TaggedObject.class) == false) goto L33;
        this.crlExtensions = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5.getObjectAt(r3), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true));
        return;
    L33:
        return;
    L9:
        this.version = null;
    L31:
        throw new IllegalArgumentException("Bad sequence size: " + r5.size());
    }

    public static TBSCertList getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, TBSCertList.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new TBSCertList(ASN1Sequence.getInstance(r2));
    L5:
        return (TBSCertList) ZeusTransformUtils.preCheckCast(r2, TBSCertList.class, "com.obric.memorydata.plugin");
    }

    public Extensions getExtensions() {
        return this.crlExtensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public Time getNextUpdate() {
        return this.nextUpdate;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        if (this.revokedCertificates != null) goto L7;
        return new EmptyEnumeration(null);
    L7:
        return new RevokedCertificatesEnumeration(this.revokedCertificates.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence r0 = this.revokedCertificates;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
        CRLEntry[] r3 = new CRLEntry[r2];
    L7:
        if (r1 >= r2) goto L9;
        r3[r1] = CRLEntry.getInstance(this.revokedCertificates.getObjectAt(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    L5:
        return new CRLEntry[0];
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public int getVersionNumber() {
        ASN1Integer r1 = this.version;
        if (r1 != null) goto L6;
        return 1;
    L6:
        return r1.intValueExact() + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(7);
        ASN1Integer r1 = this.version;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        r0.add(this.signature);
        r0.add(this.issuer);
        r0.add(this.thisUpdate);
        Time r2 = this.nextUpdate;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        ASN1Sequence r3 = this.revokedCertificates;
        if (r3 == null) goto L12;
        r0.add(r3);
    L12:
        if (this.crlExtensions == null) goto L15;
        r0.add(new DERTaggedObject(0, this.crlExtensions));
    L15:
        return new DERSequence(r0);
    }
}
