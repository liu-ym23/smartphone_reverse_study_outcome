package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: classes7.dex */
public class XmlValueNotSupportedException extends XmlValueOutOfRangeException {
    public XmlValueNotSupportedException() {
    }

    public XmlValueNotSupportedException(String r1) {
        super(r1);
    }

    public XmlValueNotSupportedException(String r1, Object[] r2) {
        super(XmlError.formattedMessage(r1, r2));
    }
}
