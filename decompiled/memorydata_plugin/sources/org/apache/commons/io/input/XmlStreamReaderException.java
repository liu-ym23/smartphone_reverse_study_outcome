package org.apache.commons.io.input;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class XmlStreamReaderException extends IOException {
    private static final long serialVersionUID = 1;
    private final String bomEncoding;
    private final String contentTypeEncoding;
    private final String contentTypeMime;
    private final String xmlEncoding;
    private final String xmlGuessEncoding;

    public XmlStreamReaderException(String r8, String r9, String r10, String r11) {
        this(r8, null, null, r9, r10, r11);
    }

    public XmlStreamReaderException(String r1, String r2, String r3, String r4, String r5, String r6) {
        super(r1);
        this.contentTypeMime = r2;
        this.contentTypeEncoding = r3;
        this.bomEncoding = r4;
        this.xmlGuessEncoding = r5;
        this.xmlEncoding = r6;
    }

    public String getBomEncoding() {
        return this.bomEncoding;
    }

    public String getContentTypeEncoding() {
        return this.contentTypeEncoding;
    }

    public String getContentTypeMime() {
        return this.contentTypeMime;
    }

    public String getXmlEncoding() {
        return this.xmlEncoding;
    }

    public String getXmlGuessEncoding() {
        return this.xmlGuessEncoding;
    }
}
