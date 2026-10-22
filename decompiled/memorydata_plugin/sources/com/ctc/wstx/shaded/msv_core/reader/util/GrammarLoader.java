package com.ctc.wstx.shaded.msv_core.reader.util;

import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class GrammarLoader {

    private static class GrammarLoaderException extends RuntimeException {
        public final SAXException e;

        GrammarLoaderException(SAXException r2) {
            super(r2.getMessage());
            this.e = r2;
        }
    }
}
