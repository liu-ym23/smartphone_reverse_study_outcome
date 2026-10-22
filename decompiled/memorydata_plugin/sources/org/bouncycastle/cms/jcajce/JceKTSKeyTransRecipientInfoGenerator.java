package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class JceKTSKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    private static final byte[] ANONYMOUS_SENDER = null;

    /* JADX INFO: renamed from: org.bouncycastle.cms.jcajce.JceKTSKeyTransRecipientInfoGenerator$1, reason: invalid class name */
    static class AnonymousClass1 extends CertificateEncodingException {
        final /* synthetic */ IOException val$e;

        AnonymousClass1(String r1, IOException r2) {
            this.val$e = r2;
            super(r1);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.val$e;
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.cms.jcajce.JceKTSKeyTransRecipientInfoGenerator$2, reason: invalid class name */
    static class AnonymousClass2 extends IllegalArgumentException {
        final /* synthetic */ IOException val$e;

        AnonymousClass2(String r1, IOException r2) {
            this.val$e = r2;
            super(r1);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.val$e;
        }
    }

    static {
        ANONYMOUS_SENDER = Hex.decode("0c14416e6f6e796d6f75732053656e64657220202020");
    }
}
