package javax.xml.stream;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes6.dex */
public interface e {
    void close();

    int getAttributeCount();

    String getAttributeLocalName(int r1);

    String getAttributeNamespace(int r1);

    String getAttributePrefix(int r1);

    String getAttributeValue(int r1);

    String getCharacterEncodingScheme();

    int getEventType();

    String getLocalName();

    a getLocation();

    QName getName();

    int getNamespaceCount();

    String getNamespacePrefix(int r1);

    String getNamespaceURI();

    String getNamespaceURI(int r1);

    String getPIData();

    String getPITarget();

    String getPrefix();

    String getText();

    char[] getTextCharacters();

    int getTextLength();

    int getTextStart();

    String getVersion();

    boolean hasNext();

    boolean isStandalone();

    int next();
}
