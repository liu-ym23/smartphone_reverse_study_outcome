package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes7.dex */
class PEMUtil {
    private final Boundaries[] _supportedBoundaries;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.x509.PEMUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Boundaries {
        private final String _footer;
        private final String _header;

        private Boundaries(String r4) {
            this._header = "-----BEGIN " + r4 + "-----";
            this._footer = "-----END " + r4 + "-----";
        }

        /* synthetic */ Boundaries(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean isTheExpectedFooter(String r1) {
            return r1.startsWith(this._footer);
        }

        public boolean isTheExpectedHeader(String r1) {
            return r1.startsWith(this._header);
        }
    }

    PEMUtil(String r6) {
        AnonymousClass1 r2 = null;
        this._supportedBoundaries = new Boundaries[]{new Boundaries(r6, r2), new Boundaries("X509 " + r6, r2), new Boundaries("PKCS7", r2)};
    }

    private Boundaries getBoundaries(String r4) {
        int r0 = 0;
    L3:
        Boundaries[] r1 = this._supportedBoundaries;
        if (r0 == r1.length) goto L12;
        Boundaries r2 = r1[r0];
        if (r2.isTheExpectedHeader(r4) == true) goto L11;
        if (r2.isTheExpectedFooter(r4) == true) goto L11;
        r0 = r0 + 1;
    L11:
        return r2;
    L12:
        return null;
    }

    private String readLine(InputStream r5) {
        StringBuffer r4 = new StringBuffer();
    L3:
        int r0 = r5.read();
        if (r0 == 13) goto L8;
        if (r0 == 10) goto L8;
        if (r0 < 0) goto L8;
        r4.append((char) r0);
    L8:
        if (r0 < 0) goto L11;
        if (r4.length() == 0) goto L3;
    L11:
        if (r0 < 0) goto L13;
        if (r0 != 13) goto L25;
        r5.mark(1);
        int r2 = r5.read();
        if (r2 != 10) goto L22;
        r5.mark(1);
    L22:
        if (r2 <= 0) goto L25;
        r5.reset();
    L25:
        return r4.toString();
    L13:
        if (r4.length() != 0) goto L17;
        return null;
    L17:
        return r4.toString();
    }

    ASN1Sequence readPEMObject(InputStream r5, boolean r6) {
        StringBuffer r0 = new StringBuffer();
        Boundaries r2 = null;
    L3:
        if (r2 != null) goto L13;
        String r3 = readLine(r5);
        if (r3 == null) goto L13;
        r2 = getBoundaries(r3);
        if (r2 == null) goto L3;
        if (r2.isTheExpectedHeader(r3) == true) goto L3;
        throw new IOException("malformed PEM data: found footer where header was expected");
    L13:
        if (r2 != null) goto L18;
        if (r6 == true) goto L17;
        return null;
    L17:
        throw new IOException("malformed PEM data: no header found");
    L18:
        Boundaries r7 = null;
    L19:
        if (r7 != null) goto L30;
        String r4 = readLine(r5);
        if (r4 == null) goto L30;
        r7 = getBoundaries(r4);
        if (r7 != null) goto L25;
        r0.append(r4);
        goto L19
    L25:
        if (r2.isTheExpectedFooter(r4) == true) goto L19;
        throw new IOException("malformed PEM data: header/footer mismatch");
    L30:
        if (r7 == null) goto L39;
        if (r0.length() != 0) goto L40;
        return null;
    L40:
        return ASN1Sequence.getInstance(Base64.decode(r0.toString()));
    L36:
        throw new IOException("malformed PEM data encountered");
    L39:
        throw new IOException("malformed PEM data: no footer found");
    }
}
