package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaAttributeModel {
    SchemaLocalAttribute getAttribute(QName r1);

    SchemaLocalAttribute[] getAttributes();

    int getWildcardProcess();

    QNameSet getWildcardSet();
}
