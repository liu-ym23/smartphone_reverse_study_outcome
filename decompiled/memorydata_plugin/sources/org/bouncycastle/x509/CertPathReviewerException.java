package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocalizedException;

/* JADX INFO: loaded from: classes7.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;
    private int index;

    public CertPathReviewerException(ErrorBundle r1) {
        super(r1);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle r1, Throwable r2) {
        super(r1, r2);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle r1, Throwable r2, CertPath r3, int r4) {
        super(r1, r2);
        this.index = -1;
        this.certPath = null;
        if (r3 == null) goto L13;
        if (r4 == (-1)) goto L13;
        if (r4 < (-1)) goto L11;
        if (r4 >= r3.getCertificates().size()) goto L11;
        this.certPath = r3;
        this.index = r4;
        return;
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new IllegalArgumentException();
    }

    public CertPathReviewerException(ErrorBundle r2, CertPath r3, int r4) {
        super(r2);
        this.index = -1;
        this.certPath = null;
        if (r3 == null) goto L13;
        if (r4 == (-1)) goto L13;
        if (r4 < (-1)) goto L11;
        if (r4 >= r3.getCertificates().size()) goto L11;
        this.certPath = r3;
        this.index = r4;
        return;
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new IllegalArgumentException();
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
