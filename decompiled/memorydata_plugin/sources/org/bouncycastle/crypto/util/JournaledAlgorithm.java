package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class JournaledAlgorithm implements Serializable, Encodable {
    private transient AlgorithmIdentifier algID;
    private transient JournalingSecureRandom journaling;

    public JournaledAlgorithm(AlgorithmIdentifier r2, JournalingSecureRandom r3) {
        Objects.requireNonNull(r2, "AlgorithmIdentifier passed to JournaledAlgorithm is null");
        Objects.requireNonNull(r3, "JournalingSecureRandom passed to JournaledAlgorithm is null");
        this.journaling = r3;
        this.algID = r2;
    }

    public JournaledAlgorithm(byte[] r2) {
        this(r2, CryptoServicesRegistrar.getSecureRandom());
    }

    public JournaledAlgorithm(byte[] r2, SecureRandom r3) {
        Objects.requireNonNull(r2, "encoding passed to JournaledAlgorithm is null");
        Objects.requireNonNull(r3, "random passed to JournaledAlgorithm is null");
        initFromEncoding(r2, r3);
    }

    public static JournaledAlgorithm getState(File r2, SecureRandom r3) {
        Objects.requireNonNull(r2, "File for loading is null in JournaledAlgorithm");
        BufferedInputStream r0 = new BufferedInputStream(new FileInputStream(r2));
        JournaledAlgorithm r4 = new JournaledAlgorithm(Streams.readAll(r0), r3);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static JournaledAlgorithm getState(InputStream r2, SecureRandom r3) {
        Objects.requireNonNull(r2, "stream for loading is null in JournaledAlgorithm");
        BufferedInputStream r0 = new BufferedInputStream(r2);
        JournaledAlgorithm r4 = new JournaledAlgorithm(Streams.readAll(r0), r3);     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    private void initFromEncoding(byte[] r3, SecureRandom r4) {
        ASN1Sequence r5 = ASN1Sequence.getInstance(r3);
        this.algID = AlgorithmIdentifier.getInstance(r5.getObjectAt(0));
        this.journaling = new JournalingSecureRandom(ASN1OctetString.getInstance(r5.getObjectAt(1)).getOctets(), r4);
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        initFromEncoding((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), CryptoServicesRegistrar.getSecureRandom());
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algID;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        r0.add(this.algID);
        r0.add(new DEROctetString(this.journaling.getFullTranscript()));
        return new DERSequence(r0).getEncoded();
    }

    public JournalingSecureRandom getJournalingSecureRandom() {
        return this.journaling;
    }

    public void storeState(File r2) {
        Objects.requireNonNull(r2, "file for storage is null in JournaledAlgorithm");
        FileOutputStream r0 = new FileOutputStream(r2);
        storeState(r0);     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public void storeState(OutputStream r2) {
        Objects.requireNonNull(r2, "output stream for storage is null in JournaledAlgorithm");
        r2.write(getEncoded());
    }
}
