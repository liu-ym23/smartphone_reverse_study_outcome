package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.a;

/* JADX INFO: loaded from: classes7.dex */
public class XmlValidationError extends XmlError {
    public static final int ATTRIBUTE_TYPE_INVALID = 1001;
    public static final int ELEMENT_NOT_ALLOWED = 2;
    public static final int ELEMENT_TYPE_INVALID = 3;
    public static final int INCORRECT_ATTRIBUTE = 1000;
    public static final int INCORRECT_ELEMENT = 1;
    public static final int LIST_INVALID = 2000;
    public static final int NIL_ELEMENT = 4;
    public static final int UNDEFINED = 10000;
    public static final int UNION_INVALID = 3000;
    private SchemaType _badSchemaType;
    private int _errorType;
    private List<QName> _expectedQNames;
    private SchemaType _expectedSchemaType;
    private QName _fieldQName;
    private QName _offendingQName;

    private XmlValidationError(String r4, int r5, a r6, QName r7, QName r8, SchemaType r9, List<QName> r10, int r11, SchemaType r12) {
        a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r9, SchemaType.class, "com.obric.memorydata.plugin");
        List<QName> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        SchemaType r16 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        super(r4, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r5, r13);
        setFieldQName(r7);
        setOffendingQName(r8);
        setExpectedSchemaType(r14);
        setExpectedQNames(r15);
        setErrorType(r11);
        setBadSchemaType(r16);
    }

    private XmlValidationError(String r4, int r5, XmlCursor r6, QName r7, QName r8, SchemaType r9, List<QName> r10, int r11, SchemaType r12) {
        XmlCursor r13 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r6, XmlCursor.class, "com.obric.memorydata.plugin");
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r9, SchemaType.class, "com.obric.memorydata.plugin");
        List<QName> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        SchemaType r16 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        super(r4, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), r5, r13);
        setFieldQName(r7);
        setOffendingQName(r8);
        setExpectedSchemaType(r14);
        setExpectedQNames(r15);
        setErrorType(r11);
        setBadSchemaType(r16);
    }

    private XmlValidationError(String r3, Object[] r4, int r5, a r6, QName r7, QName r8, SchemaType r9, List<QName> r10, int r11, SchemaType r12) {
        a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r9, SchemaType.class, "com.obric.memorydata.plugin");
        List<QName> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        SchemaType r16 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        super(r3, r4, r5, r13);
        setFieldQName(r7);
        setOffendingQName(r8);
        setExpectedSchemaType(r14);
        setExpectedQNames(r15);
        setErrorType(r11);
        setBadSchemaType(r16);
    }

    private XmlValidationError(String r3, Object[] r4, int r5, XmlCursor r6, QName r7, QName r8, SchemaType r9, List<QName> r10, int r11, SchemaType r12) {
        XmlCursor r13 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r6, XmlCursor.class, "com.obric.memorydata.plugin");
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r9, SchemaType.class, "com.obric.memorydata.plugin");
        List<QName> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        SchemaType r16 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin");
        super(r3, r4, r5, r13);
        setFieldQName(r7);
        setOffendingQName(r8);
        setExpectedSchemaType(r14);
        setExpectedQNames(r15);
        setErrorType(r11);
        setBadSchemaType(r16);
    }

    public static XmlValidationError forCursorWithDetails(String r13, String r14, Object[] r15, int r16, XmlCursor r17, QName r18, QName r19, SchemaType r20, List<QName> r21, int r22, SchemaType r23) {
        XmlCursor r6 = (XmlCursor) ZeusTransformUtils.wrapperContextForParams(r17, XmlCursor.class, "com.obric.memorydata.plugin");
        SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r20, SchemaType.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        SchemaType r12 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r23, SchemaType.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L7;
        return new XmlValidationError(r13, r16, r6, r18, r19, r9, r10, r22, r12);
    L7:
        return new XmlValidationError(r14, r15, r16, r6, r18, r19, r9, r10, r22, r12);
    }

    public static XmlValidationError forLocationWithDetails(String r13, String r14, Object[] r15, int r16, a r17, QName r18, QName r19, SchemaType r20, List<QName> r21, int r22, SchemaType r23) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.memorydata.plugin");
        SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r20, SchemaType.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        SchemaType r12 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r23, SchemaType.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L7;
        return new XmlValidationError(r13, r16, r6, r18, r19, r9, r10, r22, r12);
    L7:
        return new XmlValidationError(r14, r15, r16, r6, r18, r19, r9, r10, r22, r12);
    }

    public SchemaType getBadSchemaType() {
        return this._badSchemaType;
    }

    public int getErrorType() {
        return this._errorType;
    }

    public List<QName> getExpectedQNames() {
        return this._expectedQNames;
    }

    public SchemaType getExpectedSchemaType() {
        return this._expectedSchemaType;
    }

    public QName getFieldQName() {
        return this._fieldQName;
    }

    @Override // org.apache.xmlbeans.XmlError
    public String getMessage() {
        if (this._fieldQName == null) goto L12;
        String r0 = super.getMessage();
        StringBuilder r1 = new StringBuilder(r0.length() + 100);
        r1.append(r0);
        r1.append(" in element ");
        r1.append(this._fieldQName.getLocalPart());
        if (this._fieldQName.getNamespaceURI() == null) goto L10;
        if (this._fieldQName.getNamespaceURI().length() == 0) goto L10;
        r1.append('@').append(this._fieldQName.getNamespaceURI());
    L10:
        return r1.toString();
    L12:
        return super.getMessage();
    }

    public QName getOffendingQName() {
        return this._offendingQName;
    }

    public void setBadSchemaType(SchemaType r3) {
        this._badSchemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
    }

    public void setErrorType(int r1) {
        this._errorType = r1;
    }

    public void setExpectedQNames(List<QName> r3) {
        this._expectedQNames = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setExpectedSchemaType(SchemaType r3) {
        this._expectedSchemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
    }

    public void setFieldQName(QName r1) {
        this._fieldQName = r1;
    }

    public void setOffendingQName(QName r1) {
        this._offendingQName = r1;
    }
}
