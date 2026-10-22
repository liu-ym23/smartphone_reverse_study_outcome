package org.codehaus.stax2.typed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: classes7.dex */
public class TypedXMLStreamException extends XMLStreamException {
    private static final long serialVersionUID = 1;
    protected String mLexical;

    public TypedXMLStreamException(String r1, IllegalArgumentException r2) {
        super(r2);
        this.mLexical = r1;
    }

    public TypedXMLStreamException(String r1, String r2) {
        super(r2);
        this.mLexical = r1;
    }

    public TypedXMLStreamException(String r1, String r2, IllegalArgumentException r3) {
        super(r2, r3);
        this.mLexical = r1;
    }

    public TypedXMLStreamException(String r3, String r4, javax.xml.stream.a r5) {
        super(r4, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
        this.mLexical = r3;
    }

    public TypedXMLStreamException(String r3, String r4, javax.xml.stream.a r5, IllegalArgumentException r6) {
        super(r4, (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r6);
        this.mLexical = r3;
    }

    public String getLexical() {
        return this.mLexical;
    }
}
