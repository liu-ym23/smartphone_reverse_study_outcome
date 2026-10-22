package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaProperty {
    QName[] acceptedNames();

    String getDefaultText();

    QNameSet getJavaSetterDelimiter();

    BigInteger getMinOccurs();

    QName getName();

    SchemaType getType();

    int hasDefault();

    int hasFixed();

    int hasNillable();

    boolean isAttribute();
}
