package com.ctc.wstx.shaded.msv_core.verifier.jarv;

import com.ctc.wstx.shaded.msv.org_isorelax.verifier.b;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FactoryImpl extends b {

    private static class WrapperException extends RuntimeException {
        public final SAXException e;

        WrapperException(SAXException r2) {
            super(r2.getMessage());
            this.e = r2;
        }
    }
}
