package org.apache.xmlbeans;

import java.util.Set;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface QNameSetSpecification {
    boolean contains(QName r1);

    Set<QName> excludedQNamesInIncludedURIs();

    Set<String> excludedURIs();

    Set<QName> includedQNamesInExcludedURIs();

    Set<String> includedURIs();
}
