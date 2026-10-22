package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes7.dex */
public class XmlError implements Serializable {
    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_INFO = 2;
    public static final int SEVERITY_WARNING = 1;
    private static final ResourceBundle _bundle = null;
    private static final long serialVersionUID = 1;
    private final String _code;
    private final int _column;
    private transient XmlCursor _cursor;
    private final int _line;
    private final String _message;
    private int _offset;
    private final int _severity;
    private final String _source;

    static {
        _bundle = PropertyResourceBundle.getBundle("org.apache.xmlbeans.message", Locale.ROOT);
    }

    private XmlError(String r3, String r4, int r5, String r6, int r7, int r8, int r9, XmlCursor r10) {
        XmlCursor r11 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r10, XmlCursor.class, "com.obric.memorydata.plugin");
        this._offset = -1;
        this._message = r3;
        this._code = r4;
        this._severity = r5;
        this._source = r6;
        this._line = r7;
        this._column = r8;
        this._offset = r9;
        this._cursor = r11;
    }

    public XmlError(String r4, String r5, int r6, a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        int r0 = -1;
        this._offset = -1;
        if (r8 == null) goto L7;
        r0 = r8.getLineNumber();
        int r1 = r8.getColumnNumber();
        String r2 = r8.getPublicId();
        if (r2 != null) goto L8;
        r2 = r8.getSystemId();
    L8:
        this._message = r4;
        this._code = r5;
        this._severity = r6;
        this._source = r2;
        this._line = r0;
        this._column = r1;
        return;
    L7:
        r2 = null;
        r1 = -1;
        goto L8
    }

    public XmlError(String r7, String r8, int r9, XmlCursor r10) {
        XmlCursor r11 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r10, XmlCursor.class, "com.obric.memorydata.plugin");
        int r0 = -1;
        this._offset = -1;
        if (r11 == null) goto L23;
        String r2 = r11.documentProperties().getSourceName();
        XmlCursor r3 = r11.newCursor();
        XmlLineNumber r4 = (XmlLineNumber) ZeusTransformUtils.preCheckCast(r3.getBookmark(XmlLineNumber.class), XmlLineNumber.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r4 != null) goto L8;
        r4 = (XmlLineNumber) ZeusTransformUtils.preCheckCast(r3.toPrevBookmark(XmlLineNumber.class), XmlLineNumber.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L8:
        if (r4 == null) goto L11;
        r0 = r4.getLine();     // Catch: Throwable -> L14
        int r1 = r4.getColumn();     // Catch: Throwable -> L14
        int r5 = r4.getOffset();     // Catch: Throwable -> L14
    L12:
        if (r3 == null) goto L24;
        r3.close();
    L24:
        this._message = r7;
        this._code = r8;
        this._severity = r9;
        this._source = r2;
        this._line = r0;
        this._column = r1;
        this._offset = r5;
        this._cursor = r11;
        return;
    L11:
        r1 = -1;
        r5 = -1;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r3 != null) goto L30;
    L22:
        throw th;
    L30:
        r3.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L23:
        r2 = null;
        r1 = -1;
        r5 = -1;
        goto L24
    }

    private XmlError(String r11, Object[] r12, int r13, String r14, int r15, int r16, int r17, XmlCursor r18) {
        XmlCursor r9 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r18, XmlCursor.class, "com.obric.memorydata.plugin");
        this(formattedMessage(r11, r12), r11, r13, r14, r15, r16, r17, r9);
    }

    public XmlError(String r3, Object[] r4, int r5, a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        this(formattedMessage(r3, r4), r3, r5, r7);
    }

    public XmlError(String r3, Object[] r4, int r5, XmlCursor r6) {
        XmlCursor r7 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r6, XmlCursor.class, "com.obric.memorydata.plugin");
        this(formattedMessage(r3, r4), r3, r5, r7);
    }

    public XmlError(XmlError r2) {
        this._offset = -1;
        this._message = r2.getMessage();
        this._code = r2.getErrorCode();
        this._severity = r2.getSeverity();
        this._source = r2.getSourceName();
        this._line = r2.getLine();
        this._column = r2.getColumn();
        this._offset = r2.getOffset();
        this._cursor = r2.getCursorLocation();
    }

    public static XmlError forCursor(String r4, int r5, XmlCursor r6) {
        XmlCursor r7 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r6, XmlCursor.class, "com.obric.memorydata.plugin");
        return new XmlError(r4, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r5, r7);
    }

    public static XmlError forCursor(String r2, XmlCursor r3) {
        return forCursor(r2, 0, (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r3, XmlCursor.class, "com.obric.memorydata.plugin"));
    }

    public static XmlError forCursor(String r2, Object[] r3, int r4, XmlCursor r5) {
        return new XmlError(r2, r3, r4, (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r5, XmlCursor.class, "com.obric.memorydata.plugin"));
    }

    public static XmlError forCursor(String r2, Object[] r3, XmlCursor r4) {
        return forCursor(r2, r3, 0, (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r4, XmlCursor.class, "com.obric.memorydata.plugin"));
    }

    public static XmlError forLocation(String r10, int r11, String r12, int r13, int r14, int r15) {
        return new XmlError(r10, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, r15, null);
    }

    public static XmlError forLocation(String r10, String r11, int r12, int r13, int r14) {
        return new XmlError(r10, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), 0, r11, r12, r13, r14, null);
    }

    public static XmlError forLocation(String r11, String r12, a r13) {
        a r14 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
        return new XmlError(r11, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), 0, r12, r14.getLineNumber(), r14.getColumnNumber(), -1, null);
    }

    public static XmlError forLocation(String r10, Object[] r11, int r12, String r13, int r14, int r15, int r16) {
        return new XmlError(r10, r11, r12, r13, r14, r15, r16, null);
    }

    public static XmlError forLocationAndCursor(String r11, int r12, String r13, int r14, int r15, int r16, XmlCursor r17) {
        XmlCursor r10 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r17, XmlCursor.class, "com.obric.memorydata.plugin");
        return new XmlError(r11, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r16, r10);
    }

    public static XmlError forMessage(String r1) {
        return forMessage(r1, 0);
    }

    public static XmlError forMessage(String r1, int r2) {
        return forSource(r1, r2, null);
    }

    public static XmlError forMessage(String r2, Object[] r3) {
        return forSource(r2, r3, 0, null);
    }

    public static XmlError forMessage(String r1, Object[] r2, int r3) {
        return forSource(r1, r2, r3, null);
    }

    public static XmlError forObject(String r2, int r3, XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return forMessage(r2, r3);
    L7:
        return forCursor(r2, r3, r5.newCursor());
    }

    public static XmlError forObject(String r2, XmlObject r3) {
        return forObject(r2, 0, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public static XmlError forObject(String r2, Object[] r3, int r4, XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        return forMessage(r2, r3, r4);
    L7:
        return forCursor(r2, r3, r4, r6.newCursor());
    }

    public static XmlError forObject(String r2, Object[] r3, XmlObject r4) {
        return forObject(r2, r3, 0, (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public static XmlError forSource(String r6, int r7, String r8) {
        return forLocation(r6, r7, r8, -1, -1, -1);
    }

    public static XmlError forSource(String r6, String r7) {
        return forLocation(r6, 0, r7, -1, -1, -1);
    }

    public static XmlError forSource(String r7, Object[] r8, int r9, String r10) {
        return forLocation(r7, r8, r9, r10, -1, -1, -1);
    }

    public static String formattedFileName(String r3, URI r4) {
        URI r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        URI r1 = new URI(r3);     // Catch: URISyntaxException -> L27
        if (r1.isAbsolute() == false) goto L9;
        r0 = r1;
    L9:
        if (r0 != null) goto L11;
        r0 = new File(r3).toURI();
    L11:
        if (r4 == null) goto L14;
        r0 = r4.relativize(r0);
    L14:
        if (r0.isAbsolute() == true) goto L16;
        if (r4 != null) goto L20;
    L26:
        return r0.toString();
    L20:
        if (r4.isAbsolute() == false) goto L26;
        if (r4.getScheme().compareToIgnoreCase("file") != 0) goto L26;
    L31:
        return new File(r0).toString();
    L16:
        if (r0.getScheme().compareToIgnoreCase("file") != 0) goto L26;
        goto L31
    }

    public static String formattedMessage(String r2, Object[] r3) {
        if (r2 != null) goto L14;
        return null;
    L14:
        return new MessageFormat(_bundle.getString(r2), Locale.ROOT).format(r3);
    L7:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, MissingResourceException.class) == false) goto L11;
        String r4 = "message.missing.resource";
    L13:
        return new MessageFormat(_bundle.getString(r4), Locale.ROOT).format(e.getMessage());
    L11:
        r4 = "message.pattern.invalid";
        goto L13
    }

    public static String severityAsString(int r1) {
        if (r1 != 0) goto L4;
        return "error";
    L4:
        if (r1 != 1) goto L6;
        return "warning";
    L6:
        if (r1 != 2) goto L10;
        return "info";
    L10:
        throw new IllegalArgumentException("unknown severity");
    }

    public int getColumn() {
        return this._column;
    }

    public XmlCursor getCursorLocation() {
        return (XmlCursor) ZeusTransformUtils.preCheckCast(getLocation(XmlCursor.class), XmlCursor.class, "com.obric.memorydata.plugin");
    }

    public String getErrorCode() {
        return this._code;
    }

    public int getLine() {
        return this._line;
    }

    public Object getLocation(Object r2) {
        if (r2 != XmlCursor.class) goto L7;
        return this._cursor;
    L7:
        if (r2 != XmlObject.class) goto L12;
        XmlCursor r1 = this._cursor;
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getObject();
    L12:
        return null;
    }

    public String getMessage() {
        return this._message;
    }

    public XmlObject getObjectLocation() {
        return (XmlObject) ZeusTransformUtils.preCheckCast(getLocation(XmlObject.class), XmlObject.class, "com.obric.memorydata.plugin");
    }

    public int getOffset() {
        return this._offset;
    }

    public int getSeverity() {
        return this._severity;
    }

    public String getSourceName() {
        return this._source;
    }

    public String toString() {
        return toString(null);
    }

    public String toString(URI r3) {
        StringBuilder r0 = new StringBuilder();
        String r4 = formattedFileName(getSourceName(), r3);
        if (r4 == null) goto L11;
        r0.append(r4);
        int r5 = getLine();
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        r0.append(':');
        r0.append(r5);
        r0.append(':');
        if (getColumn() <= 0) goto L10;
        r0.append(getColumn());
        r0.append(':');
    L10:
        r0.append(" ");
    L11:
        int r6 = getSeverity();
        if (r6 != 0) goto L14;
        String r7 = "error: ";
    L18:
        r0.append(r7);
    L20:
        if (getErrorCode() == null) goto L22;
        r0.append(getErrorCode()).append(": ");
    L22:
        String r2 = getMessage();
        if (r2 != null) goto L25;
        r2 = "<Unspecified message>";
    L25:
        r0.append(r2);
        return r0.toString();
    L14:
        if (r6 != 1) goto L20;
        r7 = "warning: ";
        goto L18
    }
}
