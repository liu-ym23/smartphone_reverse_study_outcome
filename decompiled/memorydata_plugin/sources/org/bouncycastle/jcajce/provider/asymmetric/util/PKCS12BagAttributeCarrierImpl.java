package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes7.dex */
public class PKCS12BagAttributeCarrierImpl implements PKCS12BagAttributeCarrier {
    private Hashtable pkcs12Attributes;
    private Vector pkcs12Ordering;

    public PKCS12BagAttributeCarrierImpl() {
        this(new Hashtable(), new Vector());
    }

    PKCS12BagAttributeCarrierImpl(Hashtable r1, Vector r2) {
        this.pkcs12Attributes = r1;
        this.pkcs12Ordering = r2;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r2) {
        return (ASN1Encodable) ZeusTransformUtils.preCheckCast(this.pkcs12Attributes.get(r2), ASN1Encodable.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.pkcs12Ordering.elements();
    }

    public void readObject(ObjectInputStream r5) {
        Object r1 = r5.readObject();
        if (ZeusTransformUtils.instanceOf(r1, Hashtable.class) == false) goto L5;
        this.pkcs12Attributes = (Hashtable) ZeusTransformUtils.preCheckCast(r1, Hashtable.class, "com.obric.memorydata.plugin");
        this.pkcs12Ordering = (Vector) ZeusTransformUtils.preCheckCast(r5.readObject(), Vector.class, "com.obric.memorydata.plugin");
        return;
    L5:
        ASN1InputStream r6 = new ASN1InputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r1, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    L6:
        ASN1ObjectIdentifier r0 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.readObject(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        setBagAttribute(r0, r6.readObject());
        goto L6
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (this.pkcs12Attributes.containsKey(r3) == false) goto L5;
        this.pkcs12Attributes.put(r3, r5);
        return;
    L5:
        this.pkcs12Attributes.put(r3, r5);
        this.pkcs12Ordering.addElement(r3);
    }

    public void writeObject(ObjectOutputStream r7) {
        if (this.pkcs12Ordering.size() != 0) goto L5;
        r7.writeObject(new Hashtable());
        r7.writeObject(new Vector());
        return;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ASN1OutputStream r1 = ASN1OutputStream.create(r0);
        Enumeration r2 = getBagAttributeKeys();
    L7:
        if (r2.hasMoreElements() == false) goto L9;
        ASN1ObjectIdentifier r3 = ASN1ObjectIdentifier.getInstance(r2.nextElement());
        r1.writeObject(r3);
        r1.writeObject((ASN1Encodable) ZeusTransformUtils.preCheckCast(this.pkcs12Attributes.get(r3), ASN1Encodable.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        r7.writeObject(r0.toByteArray());
    }
}
