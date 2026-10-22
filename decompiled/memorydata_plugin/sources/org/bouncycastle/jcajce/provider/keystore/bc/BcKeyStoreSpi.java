package org.bouncycastle.jcajce.provider.keystore.bc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.MacInputStream;
import org.bouncycastle.crypto.io.MacOutputStream;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.io.CipherInputStream;
import org.bouncycastle.jcajce.io.CipherOutputStream;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.TeeOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class BcKeyStoreSpi extends KeyStoreSpi {
    private final JcaJceHelper helper;
    protected SecureRandom random;
    protected Hashtable table;
    protected int version;

    private static class BCKeyStoreException extends KeyStoreException {
        private final Exception cause;

        public BCKeyStoreException(String r1, Exception r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    private class StoreEntry {
        String alias;
        Certificate[] certChain;
        Date date;
        Object obj;
        final /* synthetic */ BcKeyStoreSpi this$0;
        int type;

        StoreEntry(BcKeyStoreSpi r8, String r9, Key r10, char[] r11, Certificate[] r12) {
            Key r13 = (Key) ZeusTransformUtils.wrapperContextForParams(r10, Key.class, "com.obric.memorydata.plugin");
            this.this$0 = r8;
            this.date = new Date();
            this.type = 4;
            this.alias = r9;
            this.certChain = r12;
            byte[] r4 = new byte[20];
            r8.random.nextBytes(r4);
            int r5 = (r8.random.nextInt() & 1023) + 1024;
            ByteArrayOutputStream r14 = new ByteArrayOutputStream();
            DataOutputStream r6 = new DataOutputStream(r14);
            r6.writeInt(20);
            r6.write(r4);
            r6.writeInt(r5);
            DataOutputStream r15 = new DataOutputStream(new CipherOutputStream(r6, r8.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, r11, r4, r5)));
            BcKeyStoreSpi.access$000(r8, r13, r15);
            r15.close();
            this.obj = r14.toByteArray();
        }

        StoreEntry(BcKeyStoreSpi r1, String r2, Certificate r3) {
            this.this$0 = r1;
            this.date = new Date();
            this.type = 1;
            this.alias = r2;
            this.obj = r3;
            this.certChain = null;
        }

        StoreEntry(BcKeyStoreSpi r1, String r2, Date r3, int r4, Object r5) {
            this.this$0 = r1;
            this.date = new Date();
            this.alias = r2;
            this.date = r3;
            this.type = r4;
            this.obj = r5;
        }

        StoreEntry(BcKeyStoreSpi r1, String r2, Date r3, int r4, Object r5, Certificate[] r6) {
            this.this$0 = r1;
            this.date = new Date();
            this.alias = r2;
            this.date = r3;
            this.type = r4;
            this.obj = r5;
            this.certChain = r6;
        }

        StoreEntry(BcKeyStoreSpi r1, String r2, byte[] r3, Certificate[] r4) {
            this.this$0 = r1;
            this.date = new Date();
            this.type = 3;
            this.alias = r2;
            this.obj = r3;
            this.certChain = r4;
        }

        String getAlias() {
            return this.alias;
        }

        Certificate[] getCertificateChain() {
            return this.certChain;
        }

        Date getDate() {
            return this.date;
        }

        Object getObject() {
            return this.obj;
        }

        Object getObject(char[] r13) {
            if (r13 == null) goto L7;
            if (r13.length == 0) goto L7;
        L11:
            if (this.type != 4) goto L28;
            DataInputStream r3 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.obj, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
            byte[] r9 = new byte[r3.readInt()];     // Catch: Exception -> L25
            r3.readFully(r9);     // Catch: Exception -> L25
            int r10 = r3.readInt();     // Catch: Exception -> L25
            CipherInputStream r5 = new CipherInputStream(r3, this.this$0.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 2, r13, r9, r10));     // Catch: Exception -> L25
            return BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r5));
        L16:
            DataInputStream r4 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.obj, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L25
            byte[] r2 = new byte[r4.readInt()];     // Catch: Exception -> L25
            r4.readFully(r2);     // Catch: Exception -> L25
            int r11 = r4.readInt();     // Catch: Exception -> L25
            CipherInputStream r6 = new CipherInputStream(r4, this.this$0.makePBECipher("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r13, r2, r11));     // Catch: Exception -> L25
            Key r1 = BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r6));     // Catch: Exception -> L19
        L18:
            byte[] r7 = r2;
            int r8 = r11;
            if (r1 == null) goto L24;
            ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: Exception -> L25
            DataOutputStream r14 = new DataOutputStream(r12);     // Catch: Exception -> L25
            r14.writeInt(r7.length);     // Catch: Exception -> L25
            r14.write(r7);     // Catch: Exception -> L25
            r14.writeInt(r8);     // Catch: Exception -> L25
            DataOutputStream r15 = new DataOutputStream(new CipherOutputStream(r14, this.this$0.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, r13, r7, r8)));     // Catch: Exception -> L25
            BcKeyStoreSpi.access$000(this.this$0, r1, r15);     // Catch: Exception -> L25
            r15.close();     // Catch: Exception -> L25
            this.obj = r12.toByteArray();     // Catch: Exception -> L25
            return r1;
        L24:
            throw new UnrecoverableKeyException("no match");     // Catch: Exception -> L25
        L19:
            DataInputStream r16 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.obj, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L25
            r2 = new byte[r16.readInt()];     // Catch: Exception -> L25
            r16.readFully(r2);     // Catch: Exception -> L25
            r11 = r16.readInt();     // Catch: Exception -> L25
            CipherInputStream r17 = new CipherInputStream(r16, this.this$0.makePBECipher("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r13, r2, r11));     // Catch: Exception -> L25
            r1 = BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r17));     // Catch: Exception -> L25
        L26:
            throw new UnrecoverableKeyException("no match");
        L28:
            throw new RuntimeException("forget something!");
        L7:
            if (ZeusTransformUtils.instanceOf(this.obj, Key.class) == false) goto L11;
            return this.obj;
        }

        int getType() {
            return this.type;
        }
    }

    static /* synthetic */ void access$000(BcKeyStoreSpi r2, Key r3, DataOutputStream r4) {
        r2.encodeKey((Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Key access$100(BcKeyStoreSpi r0, DataInputStream r1) {
        return r0.decodeKey(r1);
    }

    private Certificate decodeCertificate(DataInputStream r3) {
        String r0 = r3.readUTF();
        byte[] r1 = new byte[r3.readInt()];
        r3.readFully(r1);
        return this.helper.createCertificateFactory(r0).generateCertificate(new ByteArrayInputStream(r1));
    L8:
        e = move-exception;
        throw new IOException(e.toString());
    L5:
        e = move-exception;
        throw new IOException(e.toString());
    }

    private Key decodeKey(DataInputStream r6) {
        int r0 = r6.read();
        String r1 = r6.readUTF();
        String r2 = r6.readUTF();
        byte[] r3 = new byte[r6.readInt()];
        r6.readFully(r3);
        if (r1.equals("PKCS#8") == false) goto L5;
    L19:
        KeySpec r7 = new PKCS8EncodedKeySpec(r3);
    L36:
        if (r0 == 0) goto L32;
        if (r0 == 1) goto L30;
        if (r0 != 2) goto L28;
        return this.helper.createSecretKeyFactory(r2).generateSecret(r7);
    L28:
        throw new IOException("Key type " + r0 + " not recognised!");     // Catch: Exception -> L33
    L30:
        return BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(r3));
    L32:
        return BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(r3));
    L33:
        e = move-exception;
        throw new IOException("Exception creating key: " + e.toString());
    L5:
        if (r1.equals("PKCS8") == true) goto L19;
        if (r1.equals("X.509") == false) goto L10;
    L18:
        r7 = new X509EncodedKeySpec(r3);
        goto L36
    L10:
        if (r1.equals("X509") == true) goto L18;
        if (r1.equals("RAW") == false) goto L17;
        return new SecretKeySpec(r3, r2);
    L17:
        throw new IOException("Key format " + r1 + " not recognised!");
    }

    private void encodeCertificate(Certificate r1, DataOutputStream r2) {
        byte[] r0 = r1.getEncoded();     // Catch: CertificateEncodingException -> L4
        r2.writeUTF(r1.getType());     // Catch: CertificateEncodingException -> L4
        r2.writeInt(r0.length);     // Catch: CertificateEncodingException -> L4
        r2.write(r0);     // Catch: CertificateEncodingException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    private void encodeKey(Key r2, DataOutputStream r3) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        byte[] r4 = r1.getEncoded();
        if (r4 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r1, PrivateKey.class) == false) goto L9;
        int r0 = 0;
    L7:
        r3.write(r0);
        r3.writeUTF(r1.getFormat());
        r3.writeUTF(r1.getAlgorithm());
        r3.writeInt(r4.length);
        r3.write(r4);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, PublicKey.class) == false) goto L11;
        r0 = 1;
        goto L7
    L11:
        r0 = 2;
        goto L7
    L15:
        throw new IOException("unable to store encoding of protected key");
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        return this.table.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String r1) {
        if (this.table.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String r2) {
        if (this.table.get(r2) != null) goto L5;
        return;
    L5:
        this.table.remove(r2);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String r3) {
        StoreEntry r2 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r3), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.getType() == 1) goto L7;
        Certificate[] r4 = r2.getCertificateChain();
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4[0];
    L7:
        return (Certificate) ZeusTransformUtils.preCheckCast(r2.getObject(), Certificate.class, "com.obric.memorydata.plugin");
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate r5) {
        Enumeration r4 = this.table.elements();
    L4:
        if (r4.hasMoreElements() == false) goto L17;
        StoreEntry r0 = (StoreEntry) ZeusTransformUtils.preCheckCast(r4.nextElement(), StoreEntry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0.getObject(), Certificate.class) == true) goto L8;
        Certificate[] r1 = r0.getCertificateChain();
        if (r1 == null) goto L4;
        if (r1[0].equals(r5) == false) goto L4;
        return r0.getAlias();
    L8:
        if (((Certificate) ZeusTransformUtils.preCheckCast(r0.getObject(), Certificate.class, "com.obric.memorydata.plugin")).equals(r5) == false) goto L4;
        return r0.getAlias();
    L17:
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String r2) {
        StoreEntry r1 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r2), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getCertificateChain();
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String r2) {
        StoreEntry r1 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r2), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getDate();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String r3, char[] r4) {
        StoreEntry r2 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r3), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.getType() != 1) goto L8;
        return null;
    L8:
        return (Key) ZeusTransformUtils.preCheckCast(r2.getObject(r4), Key.class, "com.obric.memorydata.plugin");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String r2) {
        StoreEntry r1 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r2), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getType() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String r2) {
        StoreEntry r1 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r2), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getType() == 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream r8, char[] r9) {
        this.table.clear();
        if (r8 != null) goto L5;
        return;
    L5:
        DataInputStream r0 = new DataInputStream(r8);
        int r10 = r0.readInt();
        if (r10 == 2) goto L13;
        if (r10 == 0) goto L13;
        if (r10 == 1) goto L13;
        throw new IOException("Wrong version of key store.");
    L13:
        int r2 = r0.readInt();
        if (r2 <= 0) goto L31;
        byte[] r3 = new byte[r2];
        r0.readFully(r3);
        int r4 = r0.readInt();
        HMac r5 = new HMac(new SHA1Digest());
        if (r9 != null) goto L18;
    L28:
        loadStore(r0);
        r0.readFully(new byte[r5.getMacSize()]);
        return;
    L18:
        if (r9.length == 0) goto L28;
        byte[] r11 = PBEParametersGenerator.PKCS12PasswordToBytes(r9);
        PKCS12ParametersGenerator r6 = new PKCS12ParametersGenerator(new SHA1Digest());
        r6.init(r11, r3, r4);
        if (r10 == 2) goto L22;
        int r12 = r5.getMacSize();
    L23:
        CipherParameters r13 = r6.generateDerivedMacParameters(r12);
        Arrays.fill(r11, (byte) 0);
        r5.init(r13);
        loadStore(new MacInputStream(r0, r5));
        byte[] r14 = new byte[r5.getMacSize()];
        r5.doFinal(r14, 0);
        byte[] r15 = new byte[r5.getMacSize()];
        r0.readFully(r15);
        if (Arrays.constantTimeAreEqual(r14, r15) == true) goto L32;
        this.table.clear();
        throw new IOException("KeyStore integrity check failed.");
    L32:
        return;
    L22:
        r12 = r5.getMacSize() * 8;
        goto L23
    L31:
        throw new IOException("Invalid salt detected");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String r4, Certificate r5) {
        StoreEntry r0 = (StoreEntry) ZeusTransformUtils.preCheckCast(this.table.get(r4), StoreEntry.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L9:
        this.table.put(r4, new StoreEntry(this, r4, r5));
        return;
    L5:
        if (r0.getType() == 1) goto L9;
        throw new KeyStoreException("key store already has a key entry with alias " + r4);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r9, Key r10, char[] r11, Certificate[] r12) {
        Key r13 = (Key) ZeusTransformUtils.wrapperContextForParams(r10, Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, PrivateKey.class) == false) goto L16;
        if (r12 == null) goto L10;
        if (r13.getEncoded() != null) goto L16;
        this.table.put(r9, new StoreEntry(this, r9, new Date(), 2, r13, r12));
        return;
    L10:
        throw new KeyStoreException("no certificate chain for private key");
    L16:
        this.table.put(r9, new StoreEntry(this, r9, r13, r11, r12));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        throw new BCKeyStoreException(e.toString(), e);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r3, byte[] r4, Certificate[] r5) {
        this.table.put(r3, new StoreEntry(this, r3, r4, r5));
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.table.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream r7, char[] r8) {
        DataOutputStream r0 = new DataOutputStream(r7);
        byte[] r1 = new byte[20];
        int r2 = (this.random.nextInt() & 1023) + 1024;
        this.random.nextBytes(r1);
        r0.writeInt(this.version);
        r0.writeInt(20);
        r0.write(r1);
        r0.writeInt(r2);
        HMac r9 = new HMac(new SHA1Digest());
        MacOutputStream r3 = new MacOutputStream(r9);
        PKCS12ParametersGenerator r4 = new PKCS12ParametersGenerator(new SHA1Digest());
        byte[] r10 = PBEParametersGenerator.PKCS12PasswordToBytes(r8);
        r4.init(r10, r1, r2);
        if (this.version >= 2) goto L5;
        int r5 = r9.getMacSize();
    L6:
        r9.init(r4.generateDerivedMacParameters(r5));
        int r6 = 0;
    L8:
        if (r6 == r10.length) goto L10;
        r10[r6] = 0;
        r6 = r6 + 1;
        goto L8
    L10:
        saveStore(new TeeOutputStream(r0, r3));
        byte[] r11 = new byte[r9.getMacSize()];
        r9.doFinal(r11, 0);
        r0.write(r11);
        r0.close();
        return;
    L5:
        r5 = r9.getMacSize() * 8;
        goto L6
    }

    public void loadStore(InputStream r14) {
        DataInputStream r0 = new DataInputStream(r14);
        int r5 = r0.read();
    L3:
        if (r5 <= 0) goto L25;
        String r15 = r0.readUTF();
        Date r9 = new Date(r0.readLong());
        int r1 = r0.readInt();
        Certificate[] r2 = null;
        if (r1 == 0) goto L9;
        r2 = new Certificate[r1];
        int r3 = 0;
    L7:
        if (r3 == r1) goto L9;
        r2[r3] = decodeCertificate(r0);
        r3 = r3 + 1;
    L9:
        Certificate[] r12 = r2;
        if (r5 != 1) goto L12;
        Certificate r11 = decodeCertificate(r0);
        Hashtable r4 = this.table;
        StoreEntry r6 = new StoreEntry(this, r15, r9, 1, r11);
    L23:
        r4.put(r15, r6);
    L24:
        r5 = r0.read();
        goto L3
    L12:
        if (r5 != 2) goto L14;
        Key r13 = decodeKey(r0);
        r4 = this.table;
        r6 = new StoreEntry(this, r15, r9, 2, r13, r12);
        goto L23
    L14:
        if (r5 != 3) goto L16;
    L20:
        byte[] r7 = new byte[r0.readInt()];
        r0.readFully(r7);
        this.table.put(r15, new StoreEntry(this, r15, r9, r5, r7, r12));
        goto L24
    L16:
        if (r5 == 4) goto L20;
        throw new IOException("Unknown object type in store.");
    }

    public Cipher makePBECipher(String r3, int r4, char[] r5, byte[] r6, int r7) {
        PBEKeySpec r0 = new PBEKeySpec(r5);     // Catch: Exception -> L4
        SecretKeyFactory r8 = this.helper.createSecretKeyFactory(r3);     // Catch: Exception -> L4
        PBEParameterSpec r1 = new PBEParameterSpec(r6, r7);     // Catch: Exception -> L4
        Cipher r2 = this.helper.createCipher(r3);     // Catch: Exception -> L4
        r2.init(r4, r8.generateSecret(r0), r1);     // Catch: Exception -> L4
        return r2;
    L4:
        e = move-exception;
        throw new IOException("Error initialising store of key store: " + e);
    }

    public void saveStore(OutputStream r9) {
        Enumeration r1 = this.table.elements();
        DataOutputStream r2 = new DataOutputStream(r9);
    L3:
        int r3 = 0;
        if (r1.hasMoreElements() == false) goto L26;
        StoreEntry r10 = (StoreEntry) ZeusTransformUtils.preCheckCast(r1.nextElement(), StoreEntry.class, "com.obric.memorydata.plugin");
        r2.write(r10.getType());
        r2.writeUTF(r10.getAlias());
        r2.writeLong(r10.getDate().getTime());
        Certificate[] r4 = r10.getCertificateChain();
        if (r4 != null) goto L8;
        r2.writeInt(0);
    L12:
        int r5 = r10.getType();
        if (r5 != 1) goto L15;
        encodeCertificate((Certificate) ZeusTransformUtils.preCheckCast(r10.getObject(), Certificate.class, "com.obric.memorydata.plugin"), r2);
        goto L3
    L15:
        if (r5 != 2) goto L17;
        encodeKey((Key) ZeusTransformUtils.preCheckCast(r10.getObject(), Key.class, "com.obric.memorydata.plugin"), r2);
        goto L3
    L17:
        if (r5 != 3) goto L19;
    L23:
        byte[] r11 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10.getObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        r2.writeInt(r11.length);
        r2.write(r11);
        goto L3
    L19:
        if (r5 == 4) goto L23;
        throw new IOException("Unknown object type in store.");
    L8:
        r2.writeInt(r4.length);
    L10:
        if (r3 == r4.length) goto L12;
        encodeCertificate(r4[r3], r2);
        r3 = r3 + 1;
        goto L10
    L26:
        r2.write(0);
    }
}
