package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaField {
    String getDefaultText();

    XmlAnySimpleType getDefaultValue();

    QName getName();

    SchemaType getType();

    boolean isAttribute();

    boolean isDefault();

    boolean isFixed();

    boolean isNillable();
}
