package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.a;
import javax.xml.stream.e;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: classes7.dex */
public class Jsr173 {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static abstract class Jsr173GateWay {
        Locale _l;
        XMLStreamReaderBase _xs;

        public Jsr173GateWay(Locale r1, XMLStreamReaderBase r2) {
            this._l = r1;
            this._xs = r2;
        }
    }

    private static final class SyncedJsr173 extends Jsr173GateWay implements NamespaceContext, a, e {
        public SyncedJsr173(Locale r1, XMLStreamReaderBase r2) {
            super(r1, r2);
        }

        @Override // javax.xml.stream.e
        public void close() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            this._xs.close();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getAttributeCount() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getAttributeCount();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeLocalName(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getAttributeLocalName(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeNamespace(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getAttributeNamespace(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributePrefix(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getAttributePrefix(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeValue(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getAttributeValue(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getCharacterEncodingScheme() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getCharacterEncodingScheme();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getCharacterOffset() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getCharacterOffset();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getColumnNumber() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getColumnNumber();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getEventType() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getEventType();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getLineNumber() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getLineNumber();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getLocalName() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getLocalName();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public a getLocation() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            a r1 = this._xs.getLocation();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public QName getName() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            QName r1 = this._xs.getName();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getNamespaceCount() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getNamespaceCount();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespacePrefix(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getNamespacePrefix(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getNamespaceURI();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI(int r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getNamespaceURI(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getNamespaceURI(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPIData() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getPIData();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPITarget() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getPITarget();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPrefix() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getPrefix();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r4 = this._xs.getPrefix(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String r3) {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            Iterator<String> r4 = this._xs.getPrefixes(r3);     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r4;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public String getPublicId() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getPublicId();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public String getSystemId() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getSystemId();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getText() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getText();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public char[] getTextCharacters() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            char[] r1 = this._xs.getTextCharacters();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getTextLength() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getTextLength();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getTextStart() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getTextStart();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getVersion() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getVersion();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public boolean hasNext() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            boolean r1 = this._xs.hasNext();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public boolean isStandalone() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            boolean r1 = this._xs.isStandalone();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public int next() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.next();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }
    }

    private static final class UnsyncedJsr173 extends Jsr173GateWay implements NamespaceContext, a, e {
        public UnsyncedJsr173(Locale r1, XMLStreamReaderBase r2) {
            super(r1, r2);
        }

        @Override // javax.xml.stream.e
        public void close() {
            this._l.enter();     // Catch: Throwable -> L5
            this._xs.close();     // Catch: Throwable -> L5
            this._l.exit();
            return;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getAttributeCount() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getAttributeCount();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeLocalName(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getAttributeLocalName(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeNamespace(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getAttributeNamespace(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributePrefix(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getAttributePrefix(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getAttributeValue(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getAttributeValue(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getCharacterEncodingScheme() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getCharacterEncodingScheme();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getCharacterOffset() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getCharacterOffset();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getColumnNumber() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getColumnNumber();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getEventType() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getEventType();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.a
        public int getLineNumber() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            int r1 = this._xs.getLineNumber();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getLocalName() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getLocalName();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public a getLocation() {
            this._l.enter();     // Catch: Throwable -> L5
            a r0 = this._xs.getLocation();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public QName getName() {
            this._l.enter();     // Catch: Throwable -> L5
            QName r0 = this._xs.getName();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getNamespaceCount() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getNamespaceCount();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespacePrefix(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getNamespacePrefix(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getNamespaceURI();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI(int r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getNamespaceURI(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getNamespaceURI(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPIData() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getPIData();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPITarget() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getPITarget();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getPrefix() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getPrefix();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String r2) {
            this._l.enter();     // Catch: Throwable -> L5
            String r3 = this._xs.getPrefix(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String r2) {
            this._l.enter();     // Catch: Throwable -> L5
            Iterator<String> r3 = this._xs.getPrefixes(r2);     // Catch: Throwable -> L5
            this._l.exit();
            return r3;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.a
        public String getPublicId() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getPublicId();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.a
        public String getSystemId() {
            Locale r0 = this._l;
            monitor-enter(r0);
            this._l.enter();     // Catch: Throwable -> L12
            String r1 = this._xs.getSystemId();     // Catch: Throwable -> L9
            this._l.exit();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            th = move-exception;
            this._l.exit();     // Catch: Throwable -> L12
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getText() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getText();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public char[] getTextCharacters() {
            this._l.enter();     // Catch: Throwable -> L5
            char[] r0 = this._xs.getTextCharacters();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getTextLength() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getTextLength();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int getTextStart() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.getTextStart();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public String getVersion() {
            this._l.enter();     // Catch: Throwable -> L5
            String r0 = this._xs.getVersion();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public boolean hasNext() {
            this._l.enter();     // Catch: Throwable -> L5
            boolean r0 = this._xs.hasNext();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public boolean isStandalone() {
            this._l.enter();     // Catch: Throwable -> L5
            boolean r0 = this._xs.isStandalone();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }

        @Override // javax.xml.stream.e
        public int next() {
            this._l.enter();     // Catch: Throwable -> L5
            int r0 = this._xs.next();     // Catch: Throwable -> L5
            this._l.exit();
            return r0;
        L5:
            th = move-exception;
            this._l.exit();
            throw th;
        }
    }

    private static abstract class XMLStreamReaderBase implements NamespaceContext, a, e {
        int _column;
        int _line;
        private Locale _locale;
        int _offset;
        String _uri;
        private long _version;

        XMLStreamReaderBase(Cur r3) {
            this._line = -1;
            this._column = -1;
            this._offset = -1;
            Locale r4 = r3._locale;
            this._locale = r4;
            this._version = r4.version();
        }

        public final void checkChanged() {
            if (this._version != this._locale.version()) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("Document changed while streaming");
        }

        @Override // javax.xml.stream.e
        public void close() {
            checkChanged();
        }

        @Override // javax.xml.stream.e
        public String getCharacterEncodingScheme() {
            checkChanged();
            XmlDocumentProperties r1 = Locale.getDocProps(getStreamCur(), false);
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.getEncoding();
        }

        @Override // javax.xml.stream.a
        public int getCharacterOffset() {
            return this._offset;
        }

        @Override // javax.xml.stream.a
        public int getColumnNumber() {
            return this._column;
        }

        @Override // javax.xml.stream.a
        public int getLineNumber() {
            return this._line;
        }

        @Override // javax.xml.stream.e
        public a getLocation() {
            checkChanged();
            XmlLineNumber r0 = (XmlLineNumber) ZeusTransformUtils.preCheckCast(getStreamCur().getBookmark(XmlLineNumber.class), XmlLineNumber.class, "com.obric.memorydata.plugin");
            this._uri = null;
            if (r0 == null) goto L5;
            this._line = r0.getLine();
            this._column = r0.getColumn();
            int r1 = r0.getOffset();
        L6:
            this._offset = r1;
            return this;
        L5:
            r1 = -1;
            this._line = -1;
            this._column = -1;
            goto L6
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String r2) {
            checkChanged();
            Cur r1 = getStreamCur();
            r1.push();
            if (r1.isContainer() == true) goto L5;
            r1.toParent();
        L5:
            String r3 = r1.namespaceForPrefix(r2, true);
            r1.pop();
            return r3;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String r3) {
            checkChanged();
            Cur r2 = getStreamCur();
            r2.push();
            if (r2.isContainer() == true) goto L5;
            r2.toParent();
        L5:
            String r4 = r2.prefixForNamespace(r3, null, false);
            r2.pop();
            return r4;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String r2) {
            checkChanged();
            HashMap r0 = new HashMap();
            r0.put(r2, getPrefix(r2));
            return r0.values().iterator();
        }

        @Override // javax.xml.stream.a
        public String getPublicId() {
            return null;
        }

        public abstract Cur getStreamCur();

        @Override // javax.xml.stream.a
        public String getSystemId() {
            return null;
        }

        @Override // javax.xml.stream.e
        public String getVersion() {
            checkChanged();
            XmlDocumentProperties r1 = Locale.getDocProps(getStreamCur(), false);
            if (r1 != null) goto L6;
            return null;
        L6:
            return r1.getVersion();
        }

        @Override // javax.xml.stream.e
        public boolean isStandalone() {
            checkChanged();
            XmlDocumentProperties r1 = Locale.getDocProps(getStreamCur(), false);
            if (r1 != null) goto L6;
            return false;
        L6:
            return r1.getStandalone();
        }
    }

    private static final class XMLStreamReaderForNode extends XMLStreamReaderBase {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchChars;
        private char[] _chars;
        private Cur _cur;
        private boolean _done;
        private Cur _end;
        private int _offChars;
        private boolean _srcFetched;
        private boolean _textFetched;
        private boolean _wholeDoc;

        static {
        }

        public XMLStreamReaderForNode(Cur r1, boolean r2) {
            super(r1);
            if (r2 == false) goto L8;
            Cur r3 = r1.weakCur(this);
            this._cur = r3;
            if (r3.toFirstAttr() == true) goto L7;
            this._cur.next();
        L7:
            Cur r4 = r1.weakCur(this);
            this._end = r4;
            r4.toEnd();
        L18:
            if (this._wholeDoc == true) goto L25;
            this._cur.push();
            next();     // Catch: XMLStreamException -> L22
            this._cur.pop();
            return;
        L22:
            e = move-exception;
            throw new RuntimeException(e.getMessage(), e);
        L25:
            return;
        L8:
            this._cur = r1.weakCur(this);
            if (r1.isRoot() == false) goto L11;
            this._wholeDoc = true;
            goto L18
        L11:
            this._end = r1.weakCur(this);
            if (r1.isAttr() == true) goto L14;
            this._end.skip();
            goto L18
        L14:
            if (this._end.toNextAttr() == true) goto L18;
            this._end.toParent();
            this._end.next();
            goto L18
        }

        private void ensureCharBufLen(int r2) {
            char[] r0 = this._chars;
            if (r0 != null) goto L5;
        L6:
            int r1 = 256;
        L7:
            if (r1 >= r2) goto L9;
            r1 = r1 * 2;
            goto L7
        L9:
            this._chars = new char[r1];
            return;
        L5:
            if (r0.length < r2) goto L6;
        }

        private void fetchChars() {
            if (this._textFetched == true) goto L15;
            int r0 = this._cur.kind();
            if (r0 != 4) goto L7;
            Cur r1 = this._cur.tempCur();
            r1.next();
        L9:
            Object r2 = r1.getChars(-1);
            ensureCharBufLen(r1._cchSrc);
            char[] r3 = this._chars;
            this._offChars = 0;
            int r4 = r1._offSrc;
            int r5 = r1._cchSrc;
            this._cchChars = r5;
            CharUtil.getChars(r3, 0, r2, r4, r5);
            if (r1 == this._cur) goto L12;
            r1.release();
        L12:
            this._textFetched = true;
            return;
        L7:
            if (r0 != 0) goto L14;
            r1 = this._cur;
            goto L9
        L14:
            throw new IllegalStateException();
        }

        private static Cur toAttr(Cur r4, int r5) {
            if (r5 < 0) goto L26;
            Cur r0 = r4.tempCur();
            boolean r2 = true;
            if (r4.isElem() == false) goto L17;
            if (r0.toFirstAttr() == true) goto L8;
        L15:
            r2 = false;
        L19:
            if (r2 == false) goto L21;
            return r0;
        L21:
            r0.release();
            throw new IndexOutOfBoundsException("Attribute index is too large");
        L8:
            if (r0.isNormalAttr() == false) goto L14;
            int r6 = r5 - 1;
            if (r5 == 0) goto L19;
            r5 = r6;
        L14:
            if (r0.toNextSibling() == true) goto L8;
        L17:
            if (r4.isNormalAttr() == false) goto L24;
            if (r5 != 0) goto L15;
        L24:
            throw new IllegalStateException();
        L26:
            throw new IndexOutOfBoundsException("Attribute index is negative");
        }

        private static Cur toXmlns(Cur r5, int r6) {
            if (r6 < 0) goto L33;
            Cur r0 = r5.tempCur();
            boolean r2 = true;
            if (r5.isElem() == true) goto L15;
            if (r5.kind() == (-2)) goto L15;
            if (r5.isXmlns() == false) goto L13;
            if (r6 == 0) goto L28;
        L27:
            r2 = false;
        L28:
            if (r2 == false) goto L30;
            return r0;
        L30:
            r0.release();
            throw new IndexOutOfBoundsException("Namespace index is too large");
        L13:
            throw new IllegalStateException();
        L15:
            if (r5.kind() != (-2)) goto L18;
            r0.toParent();
        L18:
            if (r0.toFirstAttr() == false) goto L27;
        L20:
            if (r0.isXmlns() == false) goto L26;
            int r7 = r6 - 1;
            if (r6 == 0) goto L28;
            r6 = r7;
        L26:
            if (r0.toNextSibling() == true) goto L20;
        L33:
            throw new IndexOutOfBoundsException("Namespace index is negative");
        }

        @Override // javax.xml.stream.e
        public int getAttributeCount() {
            boolean r0 = this._cur.isElem();
            Cur r2 = this._cur;
            if (r0 == false) goto L13;
            Cur r3 = r2.tempCur();
            int r1 = 0;
            if (r3.toFirstAttr() == true) goto L7;
        L11:
            r3.release();
            return r1;
        L7:
            if (r3.isNormalAttr() == false) goto L10;
            r1 = r1 + 1;
        L10:
            if (r3.toNextSibling() == true) goto L7;
        L13:
            if (r2.isNormalAttr() == false) goto L17;
            return 1;
        L17:
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getAttributeLocalName(int r1) {
            return getAttributeName(r1).getLocalPart();
        }

        public QName getAttributeName(int r1) {
            Cur r0 = toAttr(this._cur, r1);
            QName r2 = r0.getName();
            r0.release();
            return r2;
        }

        @Override // javax.xml.stream.e
        public String getAttributeNamespace(int r1) {
            return getAttributeName(r1).getNamespaceURI();
        }

        @Override // javax.xml.stream.e
        public String getAttributePrefix(int r1) {
            return getAttributeName(r1).getPrefix();
        }

        @Override // javax.xml.stream.e
        public String getAttributeValue(int r1) {
            Cur r0 = toAttr(this._cur, r1);
            if (r0 == null) goto L5;
            String r2 = r0.getValueAsString();
            r0.release();
            return r2;
        L5:
            return null;
        }

        @Override // javax.xml.stream.e
        public int getEventType() {
            switch(this._cur.kind()) {
                case -2: goto L23;
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L11;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            return 3;
        L8:
            return 5;
        L15:
            return 1;
        L17:
            return 7;
        L19:
            return 4;
        L21:
            return 8;
        L23:
            return 2;
        L5:
            throw new IllegalStateException();
        L11:
            if (this._cur.isXmlns() == false) goto L13;
            return 13;
        L13:
            return 10;
        }

        @Override // javax.xml.stream.e
        public String getLocalName() {
            return getName().getLocalPart();
        }

        @Override // javax.xml.stream.e
        public QName getName() {
            if (hasName() == false) goto L7;
            return this._cur.getName();
        L7:
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public int getNamespaceCount() {
            if (this._cur.isElem() == false) goto L5;
        L12:
            Cur r0 = this._cur.tempCur();
            if (this._cur.kind() != (-2)) goto L15;
            r0.toParent();
        L15:
            int r1 = 0;
            if (r0.toFirstAttr() == true) goto L18;
        L22:
            int r2 = r1;
            r0.release();
            return r2;
        L18:
            if (r0.isXmlns() == false) goto L21;
            r1 = r1 + 1;
        L21:
            if (r0.toNextSibling() == true) goto L18;
        L5:
            if (this._cur.kind() == (-2)) goto L12;
            if (this._cur.isXmlns() == false) goto L11;
            return 1;
        L11:
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getNamespacePrefix(int r1) {
            Cur r0 = toXmlns(this._cur, r1);
            String r2 = r0.getXmlnsPrefix();
            r0.release();
            return r2;
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI() {
            return getName().getNamespaceURI();
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI(int r1) {
            Cur r0 = toXmlns(this._cur, r1);
            String r2 = r0.getXmlnsUri();
            r0.release();
            return r2;
        }

        @Override // javax.xml.stream.e
        public String getPIData() {
            if (this._cur.kind() == 5) goto L7;
            return null;
        L7:
            return this._cur.getValueAsString();
        }

        @Override // javax.xml.stream.e
        public String getPITarget() {
            if (this._cur.kind() == 5) goto L7;
            return null;
        L7:
            return this._cur.getName().getLocalPart();
        }

        @Override // javax.xml.stream.e
        public String getPrefix() {
            return getName().getPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public Cur getStreamCur() {
            return this._cur;
        }

        @Override // javax.xml.stream.e
        public String getText() {
            checkChanged();
            int r0 = this._cur.kind();
            if (r0 == 4) goto L5;
            if (r0 != 0) goto L10;
            return this._cur.getCharsAsString();
        L10:
            throw new IllegalStateException();
        L5:
            return this._cur.getValueAsString();
        }

        @Override // javax.xml.stream.e
        public char[] getTextCharacters() {
            checkChanged();
            fetchChars();
            return this._chars;
        }

        @Override // javax.xml.stream.e
        public int getTextLength() {
            checkChanged();
            fetchChars();
            return this._cchChars;
        }

        @Override // javax.xml.stream.e
        public int getTextStart() {
            checkChanged();
            fetchChars();
            return this._offChars;
        }

        public boolean hasName() {
            int r1 = this._cur.kind();
            if (r1 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r1 == (-2)) goto L8;
            return false;
        }

        @Override // javax.xml.stream.e
        public boolean hasNext() {
            checkChanged();
            return !this._done;
        }

        @Override // javax.xml.stream.e
        public int next() {
            checkChanged();
            if (hasNext() == false) goto L33;
            int r0 = this._cur.kind();
            boolean r3 = true;
            if (r0 != (-1)) goto L8;
        L6:
            this._done = r3;
            this._textFetched = false;
            this._srcFetched = false;
            return getEventType();
        L8:
            if (r0 != 3) goto L14;
            if (this._cur.toNextAttr() == true) goto L24;
            this._cur.toParent();
        L12:
            this._cur.next();
        L24:
            if (this._wholeDoc == true) goto L26;
            r3 = this._cur.isSamePos(this._end);
            goto L6
        L26:
            if (this._cur.kind() == (-1)) goto L6;
            r3 = false;
            goto L6
        L14:
            if (r0 != 4) goto L16;
        L22:
            this._cur.skip();
            goto L24
        L16:
            if (r0 == 5) goto L22;
            if (r0 != 1) goto L12;
            if (this._cur.toFirstAttr() == true) goto L24;
        L33:
            throw new IllegalStateException("No next event in stream");
        }
    }

    private static final class XMLStreamReaderForString extends XMLStreamReaderBase {
        private int _cch;
        private Cur _cur;
        private int _off;
        private Object _src;

        XMLStreamReaderForString(Cur r1, Object r2, int r3, int r4) {
            super(r1);
            this._src = r2;
            this._off = r3;
            this._cch = r4;
            this._cur = r1;
        }

        @Override // javax.xml.stream.e
        public int getAttributeCount() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getAttributeLocalName(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getAttributeNamespace(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getAttributePrefix(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getAttributeValue(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public int getEventType() {
            checkChanged();
            return 4;
        }

        @Override // javax.xml.stream.e
        public String getLocalName() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public QName getName() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public int getNamespaceCount() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getNamespacePrefix(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getNamespaceURI(int r1) {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getPIData() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getPITarget() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getPrefix() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, javax.xml.stream.a
        public String getPublicId() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public Cur getStreamCur() {
            return this._cur;
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, javax.xml.stream.a
        public String getSystemId() {
            throw new IllegalStateException();
        }

        @Override // javax.xml.stream.e
        public String getText() {
            checkChanged();
            return CharUtil.getString(this._src, this._off, this._cch);
        }

        @Override // javax.xml.stream.e
        public char[] getTextCharacters() {
            checkChanged();
            int r0 = this._cch;
            char[] r1 = new char[r0];
            CharUtil.getChars(r1, 0, this._src, this._off, r0);
            return r1;
        }

        @Override // javax.xml.stream.e
        public int getTextLength() {
            checkChanged();
            return this._cch;
        }

        @Override // javax.xml.stream.e
        public int getTextStart() {
            checkChanged();
            return this._off;
        }

        @Override // javax.xml.stream.e
        public boolean hasNext() {
            checkChanged();
            return false;
        }

        @Override // javax.xml.stream.e
        public int next() {
            throw new IllegalStateException();
        }
    }

    static {
    }

    public Jsr173() {
    }

    public static e newXmlStreamReader(Cur r3, XmlOptions r4) {
        XmlOptions r5 = XmlOptions.maskNull(r4);
        if (r5.isSaveInner() == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        int r0 = r3.kind();
        if (r0 == 0) goto L20;
        if (r0 < 0) goto L20;
        if (r6 == true) goto L14;
        XMLStreamReaderBase r7 = new XMLStreamReaderForNode(r3, false);
    L22:
        if (r3._locale.noSync() == false) goto L26;
        return new UnsyncedJsr173(r3._locale, r7);
    L26:
        return new SyncedJsr173(r3._locale, r7);
    L14:
        if (r3.hasAttrs() == false) goto L16;
    L18:
        r7 = new XMLStreamReaderForNode(r3, true);
        goto L22
    L16:
        if (r3.hasChildren() == true) goto L18;
        r7 = new XMLStreamReaderForString(r3, r3.getFirstChars(), r3._offSrc, r3._cchSrc);
    L20:
        r7 = new XMLStreamReaderForString(r3, r3.getChars(-1), r3._offSrc, r3._cchSrc);
        goto L22
    L5:
        if (r5.isSaveOuter() == true) goto L7;
        r6 = true;
        goto L8
    }
}
