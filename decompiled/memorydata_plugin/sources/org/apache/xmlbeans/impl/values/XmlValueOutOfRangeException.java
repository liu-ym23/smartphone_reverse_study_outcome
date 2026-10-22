package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: classes7.dex */
public class XmlValueOutOfRangeException extends IllegalArgumentException {
    public XmlValueOutOfRangeException() {
    }

    public XmlValueOutOfRangeException(String r1) {
        super(r1);
    }

    public XmlValueOutOfRangeException(String r1, Object[] r2) {
        super(XmlError.formattedMessage(r1, r2));
    }
}
