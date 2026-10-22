package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1ObjectIdentifier extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = null;
    private byte[] contents;
    private final String identifier;

    private static class OidHandle {
        private final byte[] contents;
        private final int key;

        OidHandle(byte[] r2) {
            this.key = Arrays.hashCode(r2);
            this.contents = r2;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, OidHandle.class) == true) goto L5;
            return false;
        L5:
            return Arrays.areEqual(this.contents, ((OidHandle) ZeusTransformUtils.preCheckCast(r3, OidHandle.class, "com.obric.memorydata.plugin")).contents);
        }

        public int hashCode() {
            return this.key;
        }
    }

    static {
        final Class<ASN1ObjectIdentifier> r1 = ASN1ObjectIdentifier.class;
        final int r2 = 6;
        TYPE = new AnonymousClass1(r1, r2);
        pool = new ConcurrentHashMap();
    }

    public ASN1ObjectIdentifier(String r3) {
        Objects.requireNonNull(r3, "'identifier' cannot be null");
        if (isValidIdentifier(r3) == false) goto L7;
        this.identifier = r3;
        return;
    L7:
        throw new IllegalArgumentException("string " + r3 + " not an OID");
    }

    ASN1ObjectIdentifier(ASN1ObjectIdentifier r2, String r3) {
        if (ASN1RelativeOID.isValidIdentifier(r3, 0) == false) goto L7;
        this.identifier = r2.getId() + "." + r3;
        return;
    L7:
        throw new IllegalArgumentException("string " + r3 + " not a valid OID branch");
    }

    ASN1ObjectIdentifier(byte[] r18, boolean r19) {
        byte[] r1 = r18;
        StringBuffer r2 = new StringBuffer();
        boolean r3 = true;
        int r7 = 0;
        long r8 = 0;
        BigInteger r10 = null;
    L4:
        if (r7 == r1.length) goto L29;
        int r11 = r1[r7] & 255;
        if (r8 > 72057594037927808L) goto L20;
        long r9 = r8 + ((long) (r11 & 127));
        if ((r11 & 128) != 0) goto L19;
        if (r3 == true) goto L11;
    L18:
        r2.append('.');
        r2.append(r9);
        r8 = 0;
    L28:
        r7 = r7 + 1;
        goto L4
    L11:
        if (r9 >= 40) goto L14;
        r2.append('0');
    L17:
        r3 = false;
        goto L18
    L14:
        if (r9 >= 80) goto L16;
        r2.append('1');
        r9 = r9 - 40;
        goto L17
    L16:
        r2.append('2');
        r9 = r9 - 80;
        goto L17
    L19:
        r8 = r9 << 7;
        goto L28
    L20:
        if (r10 != null) goto L22;
        r10 = BigInteger.valueOf(r8);
    L22:
        BigInteger r5 = r10.or(BigInteger.valueOf(r11 & 127));
        if ((r11 & 128) != 0) goto L27;
        if (r3 == false) goto L26;
        r2.append('2');
        r5 = r5.subtract(BigInteger.valueOf(80));
        r3 = false;
    L26:
        r2.append('.');
        r2.append(r5);
        r8 = 0;
        r10 = null;
        goto L28
    L27:
        r10 = r5.shiftLeft(7);
        goto L28
    L29:
        this.identifier = r2.toString();
        if (r19 == false) goto L32;
        r1 = Arrays.clone(r18);
    L32:
        this.contents = r1;
    }

    static ASN1ObjectIdentifier createPrimitive(byte[] r3, boolean r4) {
        OidHandle r0 = new OidHandle(r3);
        ASN1ObjectIdentifier r1 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(pool.get(r0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new ASN1ObjectIdentifier(r3, r4);
    }

    private void doOutput(ByteArrayOutputStream r7) {
        OIDTokenizer r0 = new OIDTokenizer(this.identifier);
        int r6 = Integer.parseInt(r0.nextToken()) * 40;
        String r1 = r0.nextToken();
        if (r1.length() > 18) goto L5;
        ASN1RelativeOID.writeField(r7, ((long) r6) + Long.parseLong(r1));
    L7:
        if (r0.hasMoreTokens() == false) goto L12;
        String r8 = r0.nextToken();
        if (r8.length() <= 18) goto L10;
        ASN1RelativeOID.writeField(r7, new BigInteger(r8));
        goto L7
    L10:
        ASN1RelativeOID.writeField(r7, Long.parseLong(r8));
        goto L7
    L12:
        return;
    L5:
        ASN1RelativeOID.writeField(r7, new BigInteger(r1).add(BigInteger.valueOf(r6)));
        goto L7
    }

    public static ASN1ObjectIdentifier fromContents(byte[] r1) {
        return createPrimitive(r1, true);
    }

    private synchronized byte[] getContents() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.contents != null) goto L6;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        doOutput(r0);     // Catch: Throwable -> L9
        this.contents = r0.toByteArray();     // Catch: Throwable -> L9
    L6:
        byte[] r1 = this.contents;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    public static ASN1ObjectIdentifier getInstance(Object r4) {
        if (r4 != null) goto L5;
    L23:
        Object r5 = ZeusTransformUtils.preCheckCast(r4, ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    L13:
        return (ASN1ObjectIdentifier) r5;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ASN1ObjectIdentifier.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Encodable.class) == false) goto L15;
        ASN1Primitive r0 = ((ASN1Encodable) ZeusTransformUtils.preCheckCast(r4, ASN1Encodable.class, "com.obric.memorydata.plugin")).toASN1Primitive();
        if (ZeusTransformUtils.instanceOf(r0, ASN1ObjectIdentifier.class) == false) goto L22;
        r5 = ZeusTransformUtils.preCheckCast(r0, ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    L22:
        throw new IllegalArgumentException("illegal object in getInstance: " + r4.getClass().getName());
    L15:
        if ((r4 instanceof byte[]) == false) goto L22;
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(TYPE.fromByteArray((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    L18:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject r3, boolean r4) {
        if (r4 == true) goto L11;
        if (r3.isParsed() == true) goto L11;
        ASN1Primitive r1 = r3.getObject();
        if (ZeusTransformUtils.instanceOf(r1, ASN1ObjectIdentifier.class) == true) goto L11;
        return fromContents(ASN1OctetString.getInstance(r1).getOctets());
    L11:
        return (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(TYPE.getContextInstance(r3, r4), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
    }

    private static boolean isValidIdentifier(String r3) {
        if (r3.length() >= 3) goto L5;
    L14:
        return false;
    L5:
        if (r3.charAt(1) != '.') goto L14;
        char r0 = r3.charAt(0);
        if (r0 < '0') goto L14;
        if (r0 > '2') goto L14;
        return ASN1RelativeOID.isValidIdentifier(r3, 2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ASN1ObjectIdentifier.class) == true) goto L11;
        return false;
    L11:
        return this.identifier.equals(((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r3, ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")).identifier);
    }

    public ASN1ObjectIdentifier branch(String r2) {
        return new ASN1ObjectIdentifier(this, r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 6, getContents());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, getContents().length);
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle r1 = new OidHandle(getContents());
        ConcurrentMap<OidHandle, ASN1ObjectIdentifier> r2 = pool;
        ASN1ObjectIdentifier r3 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r2.get(r1), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        ASN1ObjectIdentifier r0 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r2.putIfAbsent(r1, this), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return this;
    L10:
        return r0;
    L9:
        return r3;
    }

    public boolean on(ASN1ObjectIdentifier r3) {
        String r2 = getId();
        String r4 = r3.getId();
        if (r2.length() > r4.length()) goto L5;
    L9:
        return false;
    L5:
        if (r2.charAt(r4.length()) != '.') goto L9;
        if (r2.startsWith(r4) == false) goto L9;
        return true;
    }

    public String toString() {
        return getId();
    }
}
