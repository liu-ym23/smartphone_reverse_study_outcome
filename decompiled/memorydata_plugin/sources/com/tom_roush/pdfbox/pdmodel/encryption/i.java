package com.tom_roush.pdfbox.pdmodel.encryption;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.cms.RecipientId;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends l {
    public i() {
    }

    public i(h r1) {
        a(r1);
        a(r1.a());
    }

    private void a(StringBuilder r3, KeyTransRecipientId r4, X509Certificate r5, X509CertificateHolder r6) {
        BigInteger r2 = r4.getSerialNumber();
        if (r2 == null) goto L14;
        BigInteger r7 = r5.getSerialNumber();
        if (r7 == null) goto L7;
        String r8 = r7.toString(16);
    L8:
        r3.append("serial-#: rid ");
        r3.append(r2.toString(16));
        r3.append(" vs. cert ");
        r3.append(r8);
        r3.append(" issuer: rid '");
        r3.append(r4.getIssuer());
        r3.append("' vs. cert '");
        if (r6 != null) goto L11;
        Object r9 = "null";
    L12:
        r3.append(r9);
        r3.append("' ");
        return;
    L11:
        r9 = r6.getIssuer();
        goto L12
    L7:
        r8 = "unknown";
        goto L8
    }

    @Override // com.tom_roush.pdfbox.pdmodel.encryption.l
    public void a(e r21, com.tom_roush.pdfbox.a.a r22, b r23) {
        if (ZeusTransformUtils.instanceOf(r23, g.class) == false) goto L92;
        d r2 = r21.o();
        if (r2 == null) goto L10;
        if (r2.b() == 0) goto L10;
        a(r2.b());
        boolean r3 = r2.d();
    L12:
        a(r3);
    L13:
        g r1 = (g) ZeusTransformUtils.preCheckCast(r23, g.class, "com.obric.memorydata.plugin");
        X509Certificate r4 = r1.a();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        byte[] r5 = null;
        if (r4 == null) goto L17;
        X509CertificateHolder r6 = new X509CertificateHolder(r4.getEncoded());     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L18:
        com.tom_roush.pdfbox.a.a r7 = r21.b().f(com.tom_roush.pdfbox.a.i.gO);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (r7 != null) goto L22;
        if (r2 == null) goto L22;
        r7 = r2.a().f(com.tom_roush.pdfbox.a.i.gO);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L22:
        if (r7 == null) goto L81;
        int r8 = r7.b();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        byte[][] r9 = new byte[r8][];     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        StringBuilder r10 = new StringBuilder();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        int r12 = 0;
        boolean r13 = false;
        int r14 = 0;
    L25:
        if (r12 >= r7.b()) goto L43;
        byte[] r11 = ((com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(r7.a(r12), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin")).b();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        Iterator<RecipientInformation> r15 = new CMSEnvelopedData(r11).getRecipientInfos().getRecipients().iterator();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        int r17 = 0;
    L28:
        if (r15.hasNext() == false) goto L41;
        com.tom_roush.pdfbox.a.a r24 = r7;
        Iterator<RecipientInformation> r18 = r15;
        RecipientInformation r16 = (RecipientInformation) ZeusTransformUtils.preCheckCast(r15.next(), RecipientInformation.class, "com.obric.memorydata.plugin");     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        RecipientId r19 = r16.getRID();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (r13 == false) goto L32;
    L34:
        int r20 = r17 + 1;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (r4 == null) goto L39;
        g r110 = r1;
        r10.append('\n');     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r10.append(r20);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r10.append(": ");     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (ZeusTransformUtils.instanceOf(r19, KeyTransRecipientId.class) == false) goto L40;
        a(r10, (KeyTransRecipientId) ZeusTransformUtils.preCheckCast(r19, KeyTransRecipientId.class, "com.obric.memorydata.plugin"), r4, r6);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L40:
        r1 = r110;
        r15 = r18;
        r17 = r20;
        r7 = r24;
        goto L28
    L39:
        r110 = r1;
        goto L40
    L32:
        if (r19.match(r6) == false) goto L34;
        r5 = r16.getContent(new JceKeyTransEnvelopedRecipient((PrivateKey) ZeusTransformUtils.preCheckCast(r1.b(), PrivateKey.class, "com.obric.memorydata.plugin")));     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r13 = true;
    L42:
        r9[r12] = r11;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r14 = r14 + r11.length;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r12 = r12 + 1;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r7 = r24;
        r1 = r1;
        goto L25
    L41:
        r24 = r7;
        goto L42
    L43:
        com.tom_roush.pdfbox.a.a r25 = r7;
        if (r13 == false) goto L79;
        if (r5 == null) goto L79;
        if (r5.length != 24) goto L77;
        byte[] r26 = new byte[4];     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        System.arraycopy(r5, 20, r26, 0, 4);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        a r27 = new a(r26);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r27.b();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        a(r27);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        int r111 = r14 + 20;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        byte[] r28 = new byte[r111];     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        int r29 = 0;
        System.arraycopy(r5, 0, r28, 0, 20);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        int r30 = 20;
        int r31 = 0;
    L49:
        if (r31 >= r8) goto L52;
        byte[] r32 = r9[r31];     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        System.arraycopy(r32, r29, r28, r30, r32.length);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r30 = r30 + r32.length;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r31 = r31 + 1;     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        r29 = 0;
        goto L49
    L52:
        if (r21.d() == 4) goto L58;
        if (r21.d() == 5) goto L58;
        byte[] r33 = c.b().digest(r28);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L74:
        a(new byte[b() / 8]);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        System.arraycopy(r33, 0, d(), 0, b() / 8);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        return;
    L58:
        if (a() == true) goto L61;
        r28 = Arrays.copyOf(r28, r111 + 4);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        System.arraycopy(new byte[]{-1, -1, -1, -1}, 0, r28, r28.length - 4, 4);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L61:
        if (r21.d() != 4) goto L64;
        MessageDigest r34 = c.b();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L63:
        r33 = r34.digest(r28);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (r2 == null) goto L74;
        com.tom_roush.pdfbox.a.i r35 = r2.c();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        if (com.tom_roush.pdfbox.a.i.k.equals(r35) == false) goto L69;
    L72:
        boolean r36 = true;
    L73:
        b(r36);     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        goto L74
    L69:
        if (com.tom_roush.pdfbox.a.i.l.equals(r35) == true) goto L72;
        r36 = false;
        goto L73
    L64:
        r34 = c.c();     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
        goto L63
    L77:
        throw new IOException("The enveloped data does not contain 24 bytes");     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L79:
        throw new IOException("The certificate matches none of " + r25.b() + " recipient entries" + r10.toString());     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L81:
        throw new IOException("/Recipients entry is missing in encryption dictionary");     // Catch: CertificateEncodingException -> L82 KeyStoreException -> L85 CMSException -> L88
    L17:
        r6 = null;
    L85:
        e = move-exception;
        throw new IOException(e);
    L82:
        e = move-exception;
        throw new IOException(e);
    L88:
        e = move-exception;
        throw new IOException(e);
    L10:
        if (r21.f() == 0) goto L13;
        a(r21.f());
        r3 = r21.m();
        goto L12
    L92:
        throw new IOException("Provided decryption material is not compatible with the document - did you pass a null keyStore?");
    }
}
