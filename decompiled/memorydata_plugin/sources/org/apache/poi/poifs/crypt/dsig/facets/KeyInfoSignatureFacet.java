package org.apache.poi.poifs.crypt.dsig.facets;

import java.security.Key;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class KeyInfoSignatureFacet {
    private static final c LOG = null;

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet$1, reason: invalid class name */
    class AnonymousClass1 implements Key {
        private static final long serialVersionUID = 1;
        final /* synthetic */ KeyInfoSignatureFacet this$0;

        AnonymousClass1(KeyInfoSignatureFacet r1) {
            this.this$0 = r1;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return null;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            return null;
        }

        @Override // java.security.Key
        public String getFormat() {
            return null;
        }
    }

    static {
        LOG = b.a(KeyInfoSignatureFacet.class);
    }

    public KeyInfoSignatureFacet() {
    }
}
