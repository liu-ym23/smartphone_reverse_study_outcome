package javax.xml.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class XMLStreamException extends Exception {
    protected a location;
    protected Throwable nested;

    public XMLStreamException() {
    }

    public XMLStreamException(String r1) {
        super(r1);
    }

    public XMLStreamException(String r1, Throwable r2) {
        super(r1);
        this.nested = r2;
    }

    public XMLStreamException(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super("ParseError at [row,col]:[" + r5.getLineNumber() + "," + r5.getColumnNumber() + "]\nMessage: " + r3);
        this.location = r5;
    }

    public XMLStreamException(String r3, a r4, Throwable r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super("ParseError at [row,col]:[" + r6.getLineNumber() + "," + r6.getColumnNumber() + "]\nMessage: " + r3);
        this.nested = r5;
        this.location = r6;
    }

    public XMLStreamException(Throwable r1) {
        this.nested = r1;
    }

    public a getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }
}
