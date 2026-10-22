package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.xml.stream.e;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlTokenSource {
    XmlDocumentProperties documentProperties();

    void dump();

    Node getDomNode();

    Object monitor();

    XmlCursor newCursor();

    Node newDomNode(XmlOptions r1);

    InputStream newInputStream(XmlOptions r1);

    Reader newReader(XmlOptions r1);

    e newXMLStreamReader();

    e newXMLStreamReader(XmlOptions r1);

    void save(File r1, XmlOptions r2);

    void save(OutputStream r1, XmlOptions r2);

    void save(Writer r1, XmlOptions r2);

    void save(ContentHandler r1, LexicalHandler r2, XmlOptions r3);

    String xmlText();

    String xmlText(XmlOptions r1);
}
