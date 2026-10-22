package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface Saaj {

    public interface SaajCallback {
    }

    Class identifyElement(QName r1, QName r2);

    void setCallback(SaajCallback r1);
}
