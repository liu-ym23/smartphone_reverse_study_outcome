package com.ctc.wstx.shaded.msv_core.util.xml;

import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public class SAXEventGenerator {

    private static class SAXWrapper extends RuntimeException {
        SAXException e;

        SAXWrapper(SAXException r1) {
            this.e = r1;
        }
    }
}
