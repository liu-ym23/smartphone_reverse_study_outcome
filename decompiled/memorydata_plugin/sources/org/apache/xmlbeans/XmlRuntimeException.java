package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class XmlRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private List<XmlError> _errors;

    public XmlRuntimeException(String r1) {
        super(r1);
    }

    public XmlRuntimeException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public XmlRuntimeException(String r3, Throwable r4, Collection<XmlError> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        if (r6 == null) goto L6;
        this._errors = Collections.unmodifiableList(new ArrayList(r6));
        return;
    }

    public XmlRuntimeException(String r1, Throwable r2, XmlError r3) {
        this(r1, r2, Collections.singletonList(r3));
    }

    public XmlRuntimeException(Throwable r1) {
        super(r1);
    }

    public XmlRuntimeException(XmlError r3) {
        this(r3.toString(), null, r3);
    }

    public XmlRuntimeException(XmlException r3) {
        super(r3.getMessage(), r3.getCause());
        Collection<XmlError> r4 = r3.getErrors();
        if (r4 == null) goto L6;
        this._errors = Collections.unmodifiableList(new ArrayList(r4));
        return;
    }

    public XmlError getError() {
        List<XmlError> r0 = this._errors;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() != 0) goto L8;
        return null;
    L8:
        return (XmlError) ZeusTransformUtils.preCheckCast(this._errors.get(0), XmlError.class, "com.obric.memorydata.plugin");
    }

    public Collection<XmlError> getErrors() {
        return this._errors;
    }
}
