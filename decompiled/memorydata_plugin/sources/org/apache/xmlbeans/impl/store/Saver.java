package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptionCharEscapeMap;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.EncodingMap;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;

/* JADX INFO: loaded from: classes7.dex */
abstract class Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String _newLine = null;
    private List<String> _ancestorNamespaces;
    private final ArrayList<QName> _attrNames;
    private final ArrayList<String> _attrValues;
    private SaveCur _cur;
    private int _currentMapping;
    private String _initialDefaultUri;
    private final Locale _locale;
    private final ArrayList<String> _namespaceStack;
    private Map<String, String> _preComputedNamespaces;
    private final HashMap<String, String> _prefixMap;
    protected XmlOptionCharEscapeMap _replaceChar;
    private final boolean _saveNamespacesFirst;
    private final Map<String, String> _suggestedPrefixes;
    private final HashMap<String, String> _uriMap;
    private final boolean _useDefaultNamespace;
    private final long _version;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.Saver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DocSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur _cur;

        static {
        }

        DocSaveCur(Cur r1) {
            this._cur = r1.weakCur(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object r0 = this._cur.getChars(-1);
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return r0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            return this._cur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    private static final class FilterPiSaveCur extends FilterSaveCur {
        private final String _piTarget;

        FilterPiSaveCur(SaveCur r1, String r2) {
            super(r1);
            this._piTarget = r2;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.FilterSaveCur
        public boolean filter() {
            if (kind() == 5) goto L5;
        L7:
            return false;
        L5:
            if (getName().getLocalPart().equals(this._piTarget) == false) goto L7;
            return true;
        }
    }

    private static abstract class FilterSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SaveCur _cur;

        static {
        }

        FilterSaveCur(SaveCur r1) {
            this._cur = r1;
        }

        public abstract boolean filter();

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object r0 = this._cur.getChars();
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return r0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            if (this._cur.next() == true) goto L7;
            return false;
        L7:
            if (filter() == true) goto L10;
            return true;
        L10:
            toEnd();
            return next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    private static final class FragSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> _ancestorNamespaces;
        private Cur _cur;
        private final QName _elem;
        private Cur _end;
        private final boolean _saveAttr;
        private int _state;
        private int[] _stateStack;
        private int _stateStackSize;

        static {
        }

        FragSaveCur(Cur r3, Cur r4, QName r5) {
            if (r3.isAttr() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            this._saveAttr = r0;
            this._cur = r3.weakCur(this);
            this._end = r4.weakCur(this);
            this._elem = r5;
            this._state = 1;
            this._stateStack = new int[8];
            r3.push();
            computeAncestorNamespaces(r3);
            r3.pop();
            return;
        L5:
            if (r3.isSamePos(r4) == false) goto L7;
            r0 = true;
            goto L8
        }

        private void computeAncestorNamespaces(Cur r3) {
            this._ancestorNamespaces = new ArrayList();
        L4:
            if (r3.toParentRaw() == false) goto L17;
            if (r3.toFirstAttr() == false) goto L4;
        L8:
            if (r3.isXmlns() == false) goto L15;
            String r0 = r3.getXmlnsPrefix();
            if (r3.getXmlnsUri().length() <= 0) goto L12;
        L13:
            this._ancestorNamespaces.add(r3.getXmlnsPrefix());
            this._ancestorNamespaces.add(r3.getXmlnsUri());
            goto L15
        L12:
            if (r0.length() == 0) goto L13;
        L15:
            if (r3.toNextAttr() == true) goto L8;
            r3.toParent();
            goto L4
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._ancestorNamespaces;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object r0 = this._cur.getChars(-1);
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return r0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            int r0 = this._state;
            if (r0 != 1) goto L5;
            return null;
        L5:
            if (r0 == 2) goto L13;
            if (r0 != 3) goto L9;
            return null;
        L9:
            if (r0 == 4) goto L13;
            return this._cur.getName();
        L13:
            return this._elem;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            boolean r1 = false;
            if (isContainer() == false) goto L10;
            push();
            next();
            if (isText() == false) goto L7;
        L9:
            pop();
            goto L10
        L7:
            if (isFinish() == true) goto L9;
            r1 = true;
        L10:
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            if (isContainer() == false) goto L5;
            push();
            next();
            boolean r0 = isText();
            pop();
            return r0;
        L5:
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            int r0 = this._state;
            int r1 = 1;
            if (r0 == 1) goto L16;
            r1 = 2;
            if (r0 == 2) goto L16;
            if (r0 != 3) goto L9;
            return -1;
        L9:
            if (r0 != 4) goto L11;
            return -2;
        L11:
            return this._cur.kind();
        L16:
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            int r0 = this._state;
            int r1 = 2;
            if (r0 == 1) goto L30;
            int r4 = 4;
            if (r0 == 2) goto L20;
            r1 = 3;
            if (r0 == 3) goto L17;
            if (r0 == 4) goto L16;
            if (r0 != 5) goto L32;
            this._cur.next();
            if (this._cur.isSamePos(this._end) == false) goto L32;
            if (this._elem != null) goto L21;
            r4 = 3;
        L21:
            this._state = r4;
        L32:
            return true;
        L16:
            this._state = r1;
            goto L32
        L17:
            return false;
        L20:
            if (this._saveAttr == true) goto L21;
            if (this._cur.isAttr() == false) goto L26;
            this._cur.toParent();
            this._cur.next();
        L26:
            if (this._cur.isSamePos(this._end) == true) goto L21;
            this._state = 5;
            goto L32
        L30:
            if (this._elem != null) goto L16;
            r1 = 5;
            goto L16
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            int[] r0 = this._stateStack;
            int r1 = this._stateStackSize - 1;
            this._stateStackSize = r1;
            this._state = r0[r1];
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            int r0 = this._stateStackSize;
            int[] r1 = this._stateStack;
            if (r0 != r1.length) goto L5;
            int[] r2 = new int[r0 * 2];
            System.arraycopy(r1, 0, r2, 0, r0);
            this._stateStack = r2;
        L5:
            int[] r3 = this._stateStack;
            int r4 = this._stateStackSize;
            this._stateStackSize = r4 + 1;
            r3[r4] = this._state;
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
            this._end.release();
            this._end = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            int r0 = this._state;
            if (r0 != 1) goto L5;
            this._state = 3;
            return;
        L5:
            if (r0 == 2) goto L10;
            if (r0 == 3) goto L14;
            if (r0 == 4) goto L15;
            this._cur.toEnd();
            return;
        L15:
            return;
        L14:
            return;
        L10:
            this._state = 4;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            int r0 = this._state;
            if (r0 != 1) goto L5;
        L17:
            return false;
        L5:
            if (r0 == 3) goto L17;
            if (r0 == 4) goto L17;
            if (r0 == 5) goto L16;
            if (this._cur.isAttr() == true) goto L13;
            return false;
        L13:
            this._state = 5;
            return true;
        L16:
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            if (this._saveAttr == false) goto L5;
        L7:
            return false;
        L5:
            if (this._cur.toNextAttr() == false) goto L7;
            return true;
        }
    }

    static final class InputStreamSaver extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean _closed;
        private final OutputStreamWriter _converter;
        private final Locale _locale;
        private final OutputStreamImpl _outStreamImpl;
        private final TextSaver _textSaver;

        private final class OutputStreamImpl extends OutputStream {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private byte[] _buf;
            private int _free;
            private int _in;
            private int _out;
            final /* synthetic */ InputStreamSaver this$0;

            static {
            }

            private OutputStreamImpl(InputStreamSaver r1) {
                this.this$0 = r1;
            }

            /* synthetic */ OutputStreamImpl(InputStreamSaver r1, AnonymousClass1 r2) {
                this(r1);
            }

            int getAvailable() {
                byte[] r0 = this._buf;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.length - this._free;
            }

            int read() {
                if (InputStreamSaver.access$200(this.this$0, 1) != 0) goto L6;
                return -1;
            L6:
                byte[] r0 = this._buf;
                int r2 = this._out;
                byte r3 = r0[r2];
                this._out = (r2 + 1) % r0.length;
                this._free++;
                return r3;
            }

            int read(byte[] r5, int r6, int r7) {
                int r0 = InputStreamSaver.access$200(this.this$0, r7);
                if (r0 != 0) goto L7;
                return -1;
            L7:
                if (r5 == null) goto L21;
                if (r7 <= 0) goto L21;
                if (r0 >= r7) goto L12;
                r7 = r0;
            L12:
                int r1 = this._out;
                if (r1 >= this._in) goto L15;
                System.arraycopy(this._buf, r1, r5, r6, r7);
            L19:
                this._out = (this._out + r7) % this._buf.length;
                this._free += r7;
                return r7;
            L15:
                byte[] r2 = this._buf;
                int r3 = r2.length - r1;
                if (r3 < r7) goto L18;
                System.arraycopy(r2, r1, r5, r6, r7);
                goto L19
            L18:
                System.arraycopy(r2, r1, r5, r6, r3);
                System.arraycopy(this._buf, 0, r5, r6 + r3, r7 - r3);
            L21:
                return 0;
            }

            void resize(int r7) {
                byte[] r0 = this._buf;
                if (r0 != null) goto L5;
                int r1 = 4096;
            L6:
                int r2 = getAvailable();
            L8:
                if ((r1 - r2) >= r7) goto L10;
                r1 = r1 * 2;
                goto L8
            L10:
                byte[] r8 = new byte[r1];
                if (r2 <= 0) goto L17;
                int r3 = this._in;
                int r4 = this._out;
                if (r3 <= r4) goto L15;
                System.arraycopy(this._buf, r4, r8, 0, r2);
            L16:
                this._out = 0;
                this._in = r2;
                this._free += r1 - this._buf.length;
            L18:
                this._buf = r8;
                return;
            L15:
                System.arraycopy(this._buf, r4, r8, 0, r2 - r3);
                byte[] r5 = this._buf;
                int r6 = this._in;
                System.arraycopy(r5, 0, r8, r2 - r6, r6);
                goto L16
            L17:
                this._free = r1;
                goto L18
            L5:
                r1 = r0.length * 2;
                goto L6
            }

            @Override // java.io.OutputStream
            public void write(int r4) {
                if (this._free != 0) goto L5;
                resize(1);
            L5:
                byte[] r0 = this._buf;
                int r2 = this._in;
                r0[r2] = (byte) r4;
                this._in = (r2 + 1) % r0.length;
                this._free--;
            }

            @Override // java.io.OutputStream
            public void write(byte[] r6, int r7, int r8) {
                if (r8 != 0) goto L5;
                return;
            L5:
                if (this._free >= r8) goto L8;
                resize(r8);
            L8:
                if (this._in != this._out) goto L10;
                this._out = 0;
                this._in = 0;
            L10:
                byte[] r0 = this._buf;
                int r1 = r0.length;
                int r3 = this._in;
                int r2 = r1 - r3;
                if (r3 <= this._out) goto L15;
                if (r8 < r2) goto L15;
                System.arraycopy(r6, r7, r0, r3, r2);
                System.arraycopy(r6, r7 + r2, this._buf, 0, r8 - r2);
                int r9 = (this._in + r8) % this._buf.length;
            L16:
                this._in = r9;
                this._free -= r8;
                return;
            L15:
                System.arraycopy(r6, r7, r0, r3, r8);
                r9 = this._in + r8;
                goto L16
            }
        }

        static {
        }

        /* JADX WARN: Multi-variable type inference failed */
        InputStreamSaver(Cur r5, XmlOptions r6) {
            this._locale = r5._locale;
            this._closed = false;
            XmlOptions r7 = XmlOptions.maskNull(r6);
            String r2 = null;
            OutputStreamImpl r1 = new OutputStreamImpl(this, 0 == true ? 1 : 0);
            this._outStreamImpl = r1;
            XmlDocumentProperties r0 = Locale.getDocProps(r5, false);
            if (r0 != null) goto L5;
        L7:
            String r3 = null;
        L8:
            String r4 = r7.getCharacterEncoding();
            if (r4 == null) goto L11;
            r3 = r4;
        L11:
            if (r3 == null) goto L15;
            String r8 = EncodingMap.getJava2IANAMapping(r3);
            if (r8 == null) goto L15;
            r3 = r8;
        L15:
            if (r3 != null) goto L17;
            r3 = EncodingMap.getJava2IANAMapping("UTF8");
        L17:
            if (r3 == null) goto L20;
            r2 = EncodingMap.getIANA2JavaMapping(r3);
        L20:
            if (r2 == null) goto L28;
            this._converter = new OutputStreamWriter(r1, r2);     // Catch: UnsupportedEncodingException -> L24
            this._textSaver = new TextSaver(r5, r7, r3);
            return;
        L24:
            e = move-exception;
            throw new RuntimeException(e);
        L28:
            throw new IllegalStateException("Unknown encoding: " + r3);
        L5:
            if (r0.getEncoding() == null) goto L7;
            r3 = EncodingMap.getIANA2JavaMapping(r0.getEncoding());
            goto L8
        }

        static /* synthetic */ int access$200(InputStreamSaver r0, int r1) {
            return r0.ensure(r1);
        }

        private void checkClosed() {
            if (this._closed == true) goto L6;
            return;
        L6:
            throw new IOException("Stream closed");
        }

        private int ensure(int r4) {
            if (r4 > 0) goto L5;
            r4 = 1;
        L5:
            if (this._outStreamImpl.getAvailable() >= r4) goto L9;
            if (this._textSaver.write(this._converter, 2048) >= 2048) goto L5;
        L9:
            return this._outStreamImpl.getAvailable();
        }

        @Override // java.io.InputStream
        public int available() {
            return Saver.access$000(this._locale, new $$Lambda$Saver$InputStreamSaver$fmrVwDWKNx04OxtCj9lMXrCw0BU(this));
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        public /* synthetic */ int lambda$available$1$Saver$InputStreamSaver() {
            return ensure(1024);
        }

        public /* synthetic */ int lambda$read$0$Saver$InputStreamSaver(byte[] r1, int r2, int r3) {
            return this._outStreamImpl.read(r1, r2, r3);
        }

        @Override // java.io.InputStream
        public int read() {
            checkClosed();
            if (this._locale.noSync() == false) goto L11;
            this._locale.enter();
            int r0 = this._outStreamImpl.read();     // Catch: Throwable -> L8
            this._locale.exit();
            return r0;
        L8:
            th = move-exception;
            this._locale.exit();
            throw th;
        L11:
            Locale r1 = this._locale;
            monitor-enter(r1);
            this._locale.enter();     // Catch: Throwable -> L21
            int r2 = this._outStreamImpl.read();     // Catch: Throwable -> L18
            this._locale.exit();     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            return r2;
        L18:
            th = move-exception;
            this._locale.exit();     // Catch: Throwable -> L21
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public int read(final byte[] r3, final int r4, final int r5) {
            checkClosed();
            Objects.requireNonNull(r3, "buf to read into is null");
            if (r4 < 0) goto L9;
            if (r4 > r3.length) goto L9;
            return Saver.access$000(this._locale, new $$Lambda$Saver$InputStreamSaver$PL1seBmFavH1HPfgUmEorl9pv4(this, r3, r4, r5));
        L9:
            throw new IndexOutOfBoundsException("Offset is not within buf");
        }
    }

    static final class OptimizedForSpeedSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] _buf;
        Writer _w;

        private static class SaverIOException extends RuntimeException {
            SaverIOException(IOException r1) {
                super(r1);
            }
        }

        static {
        }

        OptimizedForSpeedSaver(Cur r2, Writer r3) {
            super(r2, XmlOptions.maskNull(null));
            this._buf = new char[1024];
            this._w = r3;
        }

        private void emit(char r3) {
            char[] r0 = this._buf;     // Catch: IOException -> L4
            r0[0] = r3;     // Catch: IOException -> L4
            this._w.write(r0, 0, 1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SaverIOException(e);
        }

        private void emit(char r3, char r4) {
            char[] r0 = this._buf;     // Catch: IOException -> L4
            r0[0] = r3;     // Catch: IOException -> L4
            r0[1] = r4;     // Catch: IOException -> L4
            this._w.write(r0, 0, 2);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SaverIOException(e);
        }

        private void emit(String r1) {
            this._w.write(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SaverIOException(e);
        }

        private void emit(char[] r1, int r2, int r3) {
            this._w.write(r1, r2, r3);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new SaverIOException(e);
        }

        private void emitAttrHelper(QName r2, String r3) {
            emit(' ');
            emitName(r2, true);
            emit('=', Typography.quote);
            emitAttrValue(r3);
            emit(Typography.quote);
        }

        private void emitAttrValue(CharSequence r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
            int r0 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L16;
            char r2 = r6.charAt(r1);
            if (r2 != '<') goto L9;
            String r3 = "&lt;";
        L7:
            emit(r3);
        L15:
            r1 = r1 + 1;
            goto L3
        L9:
            if (r2 != '&') goto L12;
            r3 = "&amp;";
            goto L7
        L12:
            if (r2 != '\"') goto L14;
            r3 = "&quot;";
            goto L7
        L14:
            emit(r2);
            goto L15
        }

        private void emitLiteral(String r2) {
            if (r2.contains("\"") == true) goto L5;
            char r0 = Typography.quote;
        L6:
            emit(r0);
            emit(r2);
            emit(r0);
            return;
        L5:
            r0 = '\'';
            goto L6
        }

        private void emitName(QName r4, boolean r5) {
            String r0 = r4.getNamespaceURI();
            if (r0.length() == 0) goto L16;
            String r1 = r4.getPrefix();
            String r2 = getNamespaceForPrefix(r1);
            if (r2 != null) goto L7;
        L8:
            r1 = getUriMapping(r0);
        L9:
            if (r5 == false) goto L14;
            if (r1.length() != 0) goto L14;
            r1 = getNonDefaultUriMapping(r0);
        L14:
            if (r1.length() <= 0) goto L16;
            emit(r1);
            emit(':');
            goto L16
        L7:
            if (r2.equals(r0) == true) goto L9;
        L16:
            emit(r4.getLocalPart());
        }

        private void emitNamespacesHelper() {
            iterateMappings();
        L4:
            if (hasMapping() == false) goto L6;
            emit(' ');
            emitXmlns(mappingPrefix(), mappingUri());
            nextMapping();
            goto L4
        }

        private void entitizeAndWriteCommentText(int r9) {
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r9) goto L17;
            char r5 = this._buf[r1];
            if (isBadChar(r5) == false) goto L8;
            this._buf[r1] = '?';
        L14:
            if (r1 != this._buf.length) goto L16;
            r1 = 0;
        L16:
            r1 = r1 + 1;
            goto L4
        L8:
            if (r5 != '-') goto L12;
            if (r2 == false) goto L11;
            this._buf[r1] = ' ';
            goto L12
        L11:
            r2 = true;
        L12:
            r2 = false;
            goto L14
        L17:
            char[] r3 = this._buf;
            int r4 = r9 - 1;
            if (r3[r4] != '-') goto L20;
            r3[r4] = ' ';
        L20:
            emit(r3, 0, r9);
        }

        private void entitizeAndWritePIText(int r7) {
            int r1 = 0;
            boolean r2 = false;
        L3:
            if (r1 >= r7) goto L15;
            char r3 = this._buf[r1];
            if (isBadChar(r3) == false) goto L8;
            this._buf[r1] = '?';
            r3 = '?';
        L8:
            if (r3 != '>') goto L12;
            if (r2 == false) goto L11;
            this._buf[r1] = ' ';
        L11:
            r2 = false;
        L14:
            r1 = r1 + 1;
            goto L3
        L12:
            if (r3 != '?') goto L11;
            r2 = true;
            goto L14
        L15:
            emit(this._buf, 0, r7);
        }

        private void entitizeAndWriteText(int r6) {
            int r0 = 0;
            int r1 = 0;
        L3:
            if (r0 >= r6) goto L13;
            char[] r2 = this._buf;
            char r3 = r2[r0];
            if (r3 != '&') goto L7;
            emit(r2, r1, r0 - r1);
            String r4 = "&amp;";
        L11:
            emit(r4);
            r1 = r0 + 1;
        L12:
            r0 = r0 + 1;
            goto L3
        L7:
            if (r3 != '<') goto L12;
            emit(r2, r1, r0 - r1);
            r4 = "&lt;";
            goto L11
        L13:
            emit(this._buf, r1, r6 - r1);
        }

        static void save(Cur r1, Writer r2) {
            OptimizedForSpeedSaver r0 = new OptimizedForSpeedSaver(r1, r2);     // Catch: SaverIOException -> L7
        L3:
            if (r0.process() == true) goto L3;
            return;
        L7:
            e = move-exception;
            throw ((IOException) ZeusTransformUtils.preCheckCast(e.getCause(), IOException.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur r2) {
            emit("<!--");
            r2.push();
            r2.next();
            emitCommentText(r2);
            r2.pop();
            emit("-->");
        }

        public void emitCommentText(SaveCur r8) {
            Object r0 = r8.getChars();
            int r1 = r8._cchSrc;
            int r9 = r8._offSrc;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            if ((r3 + 512) <= r1) goto L7;
            int r4 = r1;
        L8:
            CharUtil.getChars(this._buf, 0, r0, r9 + r3, r4);
            entitizeAndWriteCommentText(r4 - r3);
            r3 = r4;
            goto L3
        L7:
            r4 = 512;
            goto L8
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String r2, String r3, String r4) {
            emit("<!DOCTYPE ");
            emit(r2);
            if (r3 != null) goto L6;
            if (r4 == null) goto L6;
            emit(" SYSTEM ");
        L8:
            emitLiteral(r4);
        L9:
            emit(Typography.greater);
            emit(_newLine);
            return;
        L6:
            if (r3 == null) goto L9;
            emit(" PUBLIC ");
            emitLiteral(r3);
            emit(' ');
            goto L8
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur r7, List<QName> r8, List<String> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            emit(Typography.less);
            emitName(r7.getName(), false);
            int r0 = 0;
        L4:
            if (r0 >= r10.size()) goto L7;
            emitAttrHelper((QName) ZeusTransformUtils.preCheckCast(r10.get(r0), QName.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.get(r0), String.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L4
        L7:
            if (saveNamespacesFirst() == true) goto L10;
            emitNamespacesHelper();
        L10:
            if (r7.hasChildren() == false) goto L12;
        L15:
            emit(Typography.greater);
            return false;
        L12:
            if (r7.hasText() == true) goto L15;
            emit('/', Typography.greater);
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur r3) {
            emit(Typography.less, '/');
            emitName(r3.getName(), false);
            emit(Typography.greater);
        }

        public void emitPiText(SaveCur r8) {
            Object r0 = r8.getChars();
            int r1 = r8._cchSrc;
            int r9 = r8._offSrc;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            if ((r3 + 512) <= r1) goto L7;
            int r4 = r1;
        L8:
            CharUtil.getChars(this._buf, 0, r0, r9 + r3, r4);
            entitizeAndWritePIText(r4 - r3);
            r3 = r4;
            goto L3
        L7:
            r4 = 512;
            goto L8
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur r2) {
            emit("<?");
            emit(r2.getName().getLocalPart());
            r2.push();
            r2.next();
            if (r2.isText() == false) goto L5;
            emit(' ');
            emitPiText(r2);
        L5:
            r2.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur r8) {
            Object r0 = r8.getChars();
            int r1 = r8._cchSrc;
            int r9 = r8._offSrc;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            int r4 = Math.min(r3 + 512, r1);
            int r6 = r9 + r3;
            int r5 = r4 - r3;
            CharUtil.getChars(this._buf, 0, r0, r6, r5);
            entitizeAndWriteText(r5);
            r3 = r4;
            goto L3
        }

        public void emitXmlns(String r2, String r3) {
            emit("xmlns");
            if (r2.length() <= 0) goto L5;
            emit(':');
            emit(r2);
        L5:
            emit('=', Typography.quote);
            emitAttrValue(r3);
            emit(Typography.quote);
        }
    }

    private static final class PrettySaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final SaveCur _cur;
        private int _depth;
        private boolean _isTextCData;
        private int _prettyIndent;
        private int _prettyOffset;
        private final StringBuffer _sb;
        private final ArrayList<Object> _stack;
        private String _txt;
        private final boolean _useCDataBookmarks;

        static {
        }

        PrettySaveCur(SaveCur r2, XmlOptions r3) {
            this._isTextCData = false;
            this._sb = new StringBuffer();
            this._stack = new ArrayList();
            this._cur = r2;
            this._prettyIndent = 2;
            if (r3.getSavePrettyPrintIndent() == null) goto L6;
            this._prettyIndent = r3.getSavePrettyPrintIndent().intValue();
        L6:
            if (r3.getSavePrettyPrintOffset() == null) goto L8;
            this._prettyOffset = r3.getSavePrettyPrintOffset().intValue();
        L8:
            this._useCDataBookmarks = r3.isUseCDataBookmarks();
        }

        static void spaces(StringBuffer r1, int r2, int r3) {
        L2:
            int r0 = r3 - 1;
            if (r3 <= 0) goto L5;
            r1.insert(r2, ' ');
            r3 = r0;
            goto L2
        }

        static void trim(StringBuffer r3) {
            int r1 = 0;
        L4:
            if (r1 >= r3.length()) goto L9;
            if (CharUtil.isWhiteSpace(r3.charAt(r1)) == false) goto L9;
            r1 = r1 + 1;
        L9:
            r3.delete(0, r1);
            int r0 = r3.length();
        L10:
            if (r0 <= 0) goto L15;
            if (CharUtil.isWhiteSpace(r3.charAt(r0 - 1)) == false) goto L15;
            r0 = r0 - 1;
        L15:
            r3.delete(r0, r3.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            if (this._txt == null) goto L6;
            this._offSrc = 0;
            this._cchSrc = this._txt.length();
            return this._txt;
        L6:
            Object r0 = this._cur.getChars();
            this._offSrc = this._cur._offSrc;
            this._cchSrc = this._cur._cchSrc;
            return r0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            if (this._txt == null) goto L5;
        L7:
            return false;
        L5:
            if (this._cur.hasChildren() == false) goto L7;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            if (this._txt == null) goto L5;
        L7:
            return false;
        L5:
            if (this._cur.hasText() == false) goto L7;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            if (this._txt != null) goto L11;
            if (this._useCDataBookmarks == true) goto L7;
        L9:
            return false;
        L7:
            if (this._cur.isTextCData() == false) goto L9;
            return true;
        L11:
            return this._isTextCData;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            if (this._txt == null) goto L5;
        L7:
            return false;
        L5:
            if (this._cur.isXmlns() == false) goto L7;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            if (this._txt == null) goto L7;
            return 0;
        L7:
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            int r4 = 0;
            if (this._txt == null) goto L5;
            this._txt = null;
            this._isTextCData = false;
            r4 = this._cur.kind();
        L43:
            if (r4 != 2) goto L46;
            int r0 = this._depth + 1;
        L45:
            this._depth = r0;
        L48:
            return true;
        L46:
            if (r4 != (-2)) goto L48;
            r0 = this._depth - 1;
            goto L45
        L5:
            int r1 = this._cur.kind();
            if (this._cur.next() == true) goto L8;
            return false;
        L8:
            StringBuffer r5 = this._sb;
            r5.delete(0, r5.length());
            if (this._cur.isText() == true) goto L11;
        L20:
            int r6 = this._cur.kind();
            if (this._prettyIndent < 0) goto L40;
            if (r1 == 4) goto L40;
            if (r1 == 5) goto L40;
            if (r1 != 2) goto L29;
            if (r6 == (-2)) goto L40;
        L29:
            if (this._sb.length() <= 0) goto L32;
            this._sb.insert(0, Saver._newLine);
            spaces(this._sb, Saver._newLine.length(), this._prettyOffset + (this._prettyIndent * this._depth));
        L32:
            if (r6 == (-1)) goto L40;
            if (r1 == 1) goto L35;
            this._sb.append(Saver._newLine);
        L35:
            int r2 = this._depth;
            if (r6 >= 0) goto L38;
            r2 = r2 - 1;
        L38:
            StringBuffer r7 = this._sb;
            spaces(r7, r7.length(), this._prettyOffset + (this._prettyIndent * r2));
        L40:
            if (this._sb.length() <= 0) goto L42;
            this._txt = this._sb.toString();
            goto L43
        L42:
            r4 = r6;
            goto L43
        L11:
            if (this._useCDataBookmarks == true) goto L13;
        L15:
            boolean r8 = false;
        L16:
            this._isTextCData = r8;
            CharUtil.getString(this._sb, this._cur.getChars(), this._cur._offSrc, this._cur._cchSrc);
            this._cur.next();
            int r9 = this._cur.kind();
            if (r1 != 2) goto L19;
            if (r9 == (-2)) goto L20;
        L19:
            trim(this._sb);
            goto L20
        L13:
            if (this._cur.isTextCData() == false) goto L15;
            r8 = true;
            goto L16
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            ArrayList<Object> r0 = this._stack;
            this._depth = ((Integer) ZeusTransformUtils.preCheckCast(r0.remove(r0.size() - 1), Integer.class, "com.obric.memorydata.plugin")).intValue();
            ArrayList<Object> r1 = this._stack;
            this._txt = (String) ZeusTransformUtils.preCheckCast(r1.remove(r1.size() - 1), String.class, "com.obric.memorydata.plugin");
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
            this._stack.add(this._txt);
            this._stack.add(Integer.valueOf(this._depth));
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
            if (this._cur.kind() != (-2)) goto L6;
            this._depth--;
            return;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    static abstract class SaveCur {
        int _cchSrc;
        int _offSrc;

        SaveCur() {
        }

        abstract List<String> getAncestorNamespaces();

        abstract String getAttrValue();

        abstract Object getChars();

        abstract XmlDocumentProperties getDocProps();

        abstract QName getName();

        abstract String getXmlnsPrefix();

        abstract String getXmlnsUri();

        abstract boolean hasChildren();

        abstract boolean hasText();

        final boolean isAttr() {
            if (kind() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        final boolean isComment() {
            if (kind() != 4) goto L5;
            return true;
        L5:
            return false;
        }

        final boolean isContainer() {
            return Cur.kindIsContainer(kind());
        }

        final boolean isElem() {
            if (kind() != 2) goto L5;
            return true;
        L5:
            return false;
        }

        final boolean isFinish() {
            return Cur.kindIsFinish(kind());
        }

        final boolean isNormalAttr() {
            if (kind() == 3) goto L5;
        L7:
            return false;
        L5:
            if (isXmlns() == true) goto L7;
            return true;
        }

        final boolean isProcinst() {
            if (kind() != 5) goto L5;
            return true;
        L5:
            return false;
        }

        final boolean isRoot() {
            if (kind() == 1) goto L7;
            return false;
        L7:
            return true;
        }

        final boolean isText() {
            if (kind() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        abstract boolean isTextCData();

        abstract boolean isXmlns();

        abstract int kind();

        abstract boolean next();

        abstract void pop();

        abstract void push();

        abstract void release();

        abstract void toEnd();

        abstract boolean toFirstAttr();

        abstract boolean toNextAttr();
    }

    static final class SaxSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AttributesImpl _attributes;
        private char[] _buf;
        private final ContentHandler _contentHandler;
        private final LexicalHandler _lexicalHandler;
        private final boolean _nsAsAttrs;

        private static class SaverSAXException extends RuntimeException {
            SAXException _saxException;

            SaverSAXException(SAXException r1) {
                this._saxException = r1;
            }
        }

        static {
        }

        SaxSaver(Cur r3, XmlOptions r4, ContentHandler r5, LexicalHandler r6) {
            ContentHandler r7 = (ContentHandler) ZeusTransformUtils.wrapperContextForParams(r5, ContentHandler.class, "com.obric.memorydata.plugin");
            LexicalHandler r8 = (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r6, LexicalHandler.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this._contentHandler = r7;
            this._lexicalHandler = r8;
            this._attributes = new AttributesImpl();
            this._nsAsAttrs = !r4.isSaveSaxNoNSDeclsInAttributes();
            r7.startDocument();
        L11:
            if (process() == true) goto L11;
            this._contentHandler.endDocument();
            return;
        L8:
            e = move-exception;
            throw e._saxException;
        }

        private void emitNamespacesHelper() {
            iterateMappings();
        L4:
            if (hasMapping() == false) goto L19;
            String r3 = mappingPrefix();
            String r9 = mappingUri();
            this._contentHandler.startPrefixMapping(r3, r9);     // Catch: SAXException -> L16
            if (this._nsAsAttrs == false) goto L15;
            if (r3 != null) goto L11;
        L14:
            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", "xmlns", "xmlns", "CDATA", r9);
            goto L15
        L11:
            if (r3.length() == 0) goto L14;
            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", r3, "xmlns:" + r3, "CDATA", r9);
        L15:
            nextMapping();
        L16:
            e = move-exception;
            throw new SaverSAXException(e);
        }

        private String getPrefixedName(QName r3) {
            String r0 = r3.getNamespaceURI();
            String r4 = r3.getLocalPart();
            if (r0.length() != 0) goto L5;
            return r4;
        L5:
            String r2 = getUriMapping(r0);
            if (r2.length() != 0) goto L9;
            return r4;
        L9:
            return r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur r6) {
            if (this._lexicalHandler == null) goto L21;
            r6.push();
            r6.next();
        L18:
            e = move-exception;
            throw new SaverSAXException(e);
        L6:
            if (r6.isText() == true) goto L8;
            this._lexicalHandler.comment(null, 0, 0);     // Catch: SAXException -> L18
        L17:
            r6.pop();
            return;
        L8:
            Object r2 = r6.getChars();     // Catch: SAXException -> L18
            if ((r2 instanceof char[]) == false) goto L11;
            this._lexicalHandler.comment((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r2, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"), r6._offSrc, r6._cchSrc);     // Catch: SAXException -> L18
            goto L17
        L11:
            char[] r0 = this._buf;     // Catch: SAXException -> L18
            if (r0 != null) goto L14;
        L15:
            this._buf = new char[Math.max(1024, r6._cchSrc)];     // Catch: SAXException -> L18
        L16:
            CharUtil.getChars(this._buf, 0, r2, r6._offSrc, r6._cchSrc);     // Catch: SAXException -> L18
            this._lexicalHandler.comment(this._buf, 0, r6._cchSrc);     // Catch: SAXException -> L18
            goto L17
        L14:
            if (r0.length >= r6._cchSrc) goto L16;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String r2, String r3, String r4) {
            LexicalHandler r0 = this._lexicalHandler;
            if (r0 != null) goto L10;
            return;
        L10:
            r0.startDTD(r2, r3, r4);     // Catch: SAXException -> L6
            this._lexicalHandler.endDTD();     // Catch: SAXException -> L6
            return;
        L6:
            e = move-exception;
            throw new SaverSAXException(e);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur r11, List<QName> r12, List<String> r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            this._attributes.clear();
            if (saveNamespacesFirst() == false) goto L5;
            emitNamespacesHelper();
        L5:
            int r2 = 0;
        L7:
            if (r2 >= r14.size()) goto L10;
            QName r3 = (QName) ZeusTransformUtils.preCheckCast(r14.get(r2), QName.class, "com.obric.memorydata.plugin");
            this._attributes.addAttribute(r3.getNamespaceURI(), r3.getLocalPart(), getPrefixedName(r3), "CDATA", (String) ZeusTransformUtils.preCheckCast(r15.get(r2), String.class, "com.obric.memorydata.plugin"));
            r2 = r2 + 1;
            goto L7
        L10:
            if (saveNamespacesFirst() == true) goto L12;
            emitNamespacesHelper();
        L12:
            QName r16 = r11.getName();
            this._contentHandler.startElement(r16.getNamespaceURI(), r16.getLocalPart(), getPrefixedName(r16), this._attributes);     // Catch: SAXException -> L15
            return false;
        L15:
            e = move-exception;
            throw new SaverSAXException(e);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur r4) {
            QName r5 = r4.getName();
            this._contentHandler.endElement(r5.getNamespaceURI(), r5.getLocalPart(), getPrefixedName(r5));     // Catch: SAXException -> L9
            iterateMappings();     // Catch: SAXException -> L9
        L5:
            if (hasMapping() == false) goto L8;
            this._contentHandler.endPrefixMapping(mappingPrefix());     // Catch: SAXException -> L9
            nextMapping();     // Catch: SAXException -> L9
            goto L5
        L8:
            return;
        L9:
            e = move-exception;
            throw new SaverSAXException(e);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur r4) {
            r4.push();
            r4.next();
            String r0 = CharUtil.getString(r4.getChars(), r4._offSrc, r4._cchSrc);
            r4.pop();
            this._contentHandler.processingInstruction(r4.getName().getLocalPart(), r0);     // Catch: SAXException -> L5
            return;
        L5:
            e = move-exception;
            throw new SaverSAXException(e);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur r6) {
            Object r2 = r6.getChars();
        L14:
            e = move-exception;
            throw new SaverSAXException(e);
        L4:
            if ((r2 instanceof char[]) == false) goto L7;
            this._contentHandler.characters((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r2, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin"), r6._offSrc, r6._cchSrc);     // Catch: SAXException -> L14
            return;
        L7:
            if (this._buf != null) goto L10;
            this._buf = new char[1024];     // Catch: SAXException -> L14
        L10:
            if (r6._cchSrc <= 0) goto L20;
            int r0 = Math.min(this._buf.length, r6._cchSrc);     // Catch: SAXException -> L14
            CharUtil.getChars(this._buf, 0, r2, r6._offSrc, r0);     // Catch: SAXException -> L14
            this._contentHandler.characters(this._buf, 0, r0);     // Catch: SAXException -> L14
            r6._offSrc += r0;     // Catch: SAXException -> L14
            r6._cchSrc -= r0;     // Catch: SAXException -> L14
            goto L10
        }
    }

    private interface SyncWrapFun {
        int process();
    }

    static final class SynthNamespaceSaver extends Saver {
        LinkedHashMap<String, String> _synthNamespaces;

        SynthNamespaceSaver(Cur r1, XmlOptions r2) {
            super(r1, r2);
            this._synthNamespaces = new LinkedHashMap();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String r1, String r2, String r3) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur r1, List<QName> r2, List<String> r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void syntheticNamespace(String r1, String r2, boolean r3) {
            LinkedHashMap<String, String> r0 = this._synthNamespaces;
            if (r3 == false) goto L5;
            r1 = "";
        L5:
            r0.put(r2, r1);
        }
    }

    static final class TextReader extends Reader {
        private boolean _closed;
        private final Locale _locale;
        private final TextSaver _textSaver;

        TextReader(Cur r3, XmlOptions r4) {
            this._textSaver = new TextSaver(r3, r4, null);
            this._locale = r3._locale;
            this._closed = false;
        }

        private void checkClosed() {
            if (this._closed == true) goto L6;
            return;
        L6:
            throw new IOException("Reader has been closed");
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        public /* synthetic */ int lambda$read$0$Saver$TextReader(char[] r3) {
            TextSaver r2 = this._textSaver;
            if (r3 != null) goto L5;
            int r1 = 0;
        L7:
            return r2.read(r3, 0, r1);
        L5:
            r1 = r3.length;
            goto L7
        }

        public /* synthetic */ int lambda$read$1$Saver$TextReader(char[] r1, int r2, int r3) {
            return this._textSaver.read(r1, r2, r3);
        }

        @Override // java.io.Reader
        public int read() {
            checkClosed();
            Locale r0 = this._locale;
            final TextSaver r2 = this._textSaver;
            r2.getClass();
            return Saver.access$000(r0, new $$Lambda$4gXgR8ZgNeG_Vi7_MXwvE13BXMQ(r2));
        }

        @Override // java.io.Reader
        public int read(final char[] r3) {
            checkClosed();
            return Saver.access$000(this._locale, new $$Lambda$Saver$TextReader$8gP6TW_9G5T3sk3fGtC3D2HNtiE(this, r3));
        }

        @Override // java.io.Reader
        public int read(final char[] r3, final int r4, final int r5) {
            checkClosed();
            return Saver.access$000(this._locale, new $$Lambda$Saver$TextReader$5L4TG0dRGcb7zOH8yeAJpyUlti4(this, r3, r4, r5));
        }

        @Override // java.io.Reader
        public boolean ready() {
            return !this._closed;
        }
    }

    static final class TextSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private char[] _buf;
        private int _cdataEntityCountThreshold;
        private int _cdataLengthThreshold;
        private int _free;
        private int _in;
        private boolean _isPrettyPrint;
        private int _lastEmitCch;
        private int _lastEmitIn;
        private int _out;
        private boolean _useCDataBookmarks;

        static {
        }

        TextSaver(Cur r5, XmlOptions r6, String r7) {
            super(r5, r6);
            this._cdataLengthThreshold = 32;
            this._cdataEntityCountThreshold = 5;
            this._useCDataBookmarks = false;
            this._isPrettyPrint = false;
            if (r6 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r6 != null) goto L10;
        L12:
            if (r6 != null) goto L14;
        L16:
            if (r6 != null) goto L18;
        L20:
            if (r6 != null) goto L22;
        L24:
            this._out = 0;
            this._in = 0;
            this._free = 0;
            if (r7 == null) goto L46;
            if (r2 == true) goto L47;
            XmlDocumentProperties r8 = Locale.getDocProps(r5, false);
            Boolean r9 = null;
            if (r8 != null) goto L30;
            String r0 = null;
        L31:
            if (r0 != null) goto L33;
            r0 = "1.0";
        L33:
            if (r8 != null) goto L35;
        L37:
            emit("<?xml version=\"");
            emit(r0);
            emit("\" encoding=\"" + r7 + "\"");
            if (r9 == null) goto L44;
            StringBuilder r10 = new StringBuilder().append(" standalone=\"");
            if (r9.booleanValue() == false) goto L42;
            String r11 = "yes";
        L43:
            emit(r10.append(r11).append("\"").toString());
            goto L44
        L42:
            r11 = "no";
        L44:
            emit("?>" + _newLine);
            return;
        L35:
            if (r8.get(XmlDocumentProperties.STANDALONE) == null) goto L37;
            r9 = Boolean.valueOf(r8.getStandalone());
            goto L37
        L30:
            r0 = r8.getVersion();
            goto L31
        L47:
            return;
        L46:
            return;
        L22:
            if (r6.isSavePrettyPrint() == false) goto L24;
            this._isPrettyPrint = true;
            goto L24
        L18:
            if (r6.isUseCDataBookmarks() == false) goto L20;
            this._useCDataBookmarks = true;
            goto L20
        L14:
            if (r6.getSaveCDataEntityCountThreshold() == null) goto L16;
            this._cdataEntityCountThreshold = r6.getSaveCDataEntityCountThreshold().intValue();
            goto L16
        L10:
            if (r6.getSaveCDataLengthThreshold() == null) goto L12;
            this._cdataLengthThreshold = r6.getSaveCDataLengthThreshold().intValue();
            goto L12
        L5:
            if (r6.isSaveNoXmlDecl() == false) goto L7;
            r2 = true;
            goto L8
        }

        private void emit(char r4) {
            preEmit(1);
            char[] r1 = this._buf;
            int r2 = this._in;
            r1[r2] = r4;
            this._in = (r2 + 1) % r1.length;
        }

        private void emit(char r3, char r4) {
            if (preEmit(2) == false) goto L5;
            return;
        L5:
            char[] r0 = this._buf;
            int r1 = this._in;
            r0[r1] = r3;
            int r2 = (r1 + 1) % r0.length;
            this._in = r2;
            r0[r2] = r4;
            this._in = (r2 + 1) % r0.length;
        }

        private void emit(String r6) {
            if (r6 != null) goto L5;
            int r1 = 0;
        L7:
            if (preEmit(r1) == true) goto L19;
            if (r6 == null) goto L20;
            int r2 = this._in;
            if (r2 <= this._out) goto L16;
            char[] r3 = this._buf;
            int r4 = r3.length - r2;
            if (r1 < r4) goto L16;
            r6.getChars(0, r4, r3, r2);
            r6.getChars(r4, r1, this._buf, 0);
            int r7 = (this._in + r1) % this._buf.length;
        L17:
            this._in = r7;
            return;
        L16:
            r6.getChars(0, r1, this._buf, r2);
            r7 = this._in + r1;
            goto L17
        L20:
            return;
        L19:
            return;
        L5:
            r1 = r6.length();
            goto L7
        }

        private void emit(SaveCur r8) {
            if (r8.isText() == false) goto L15;
            Object r0 = r8.getChars();
            int r2 = r8._cchSrc;
            if (preEmit(r2) == false) goto L7;
            return;
        L7:
            int r3 = this._in;
            if (r3 <= this._out) goto L13;
            char[] r4 = this._buf;
            int r5 = r4.length - r3;
            if (r2 < r5) goto L13;
            CharUtil.getChars(r4, r3, r0, r8._offSrc, r5);
            CharUtil.getChars(this._buf, 0, r0, r8._offSrc + r5, r2 - r5);
            int r9 = (this._in + r2) % this._buf.length;
        L14:
            this._in = r9;
            return;
        L13:
            CharUtil.getChars(this._buf, r3, r0, r8._offSrc, r2);
            r9 = this._in + r2;
            goto L14
        L15:
            preEmit(0);
        }

        private void emitAttrHelper(QName r3, String r4) {
            emit(' ');
            emitName(r3, true);
            emit('=', Typography.quote);
            emit(r4);
            entitizeAttrValue(true);
            emit(Typography.quote);
        }

        private void emitLiteral(String r2) {
            if (r2.contains("\"") == true) goto L5;
            char r0 = Typography.quote;
        L6:
            emit(r0);
            emit(r2);
            emit(r0);
            return;
        L5:
            r0 = '\'';
            goto L6
        }

        private void emitName(QName r4, boolean r5) {
            String r0 = r4.getNamespaceURI();
            if (r0.length() == 0) goto L16;
            String r1 = r4.getPrefix();
            String r2 = getNamespaceForPrefix(r1);
            if (r2 != null) goto L7;
        L8:
            r1 = getUriMapping(r0);
        L9:
            if (r5 == false) goto L14;
            if (r1.length() != 0) goto L14;
            r1 = getNonDefaultUriMapping(r0);
        L14:
            if (r1.length() <= 0) goto L16;
            emit(r1);
            emit(':');
            goto L16
        L7:
            if (r2.equals(r0) == true) goto L9;
        L16:
            emit(r4.getLocalPart());
        }

        private void emitNamespacesHelper() {
            LinkedHashMap r0 = new LinkedHashMap();
            iterateMappings();
        L4:
            if (hasMapping() == false) goto L13;
            String r1 = mappingPrefix();
            String r3 = mappingUri();
            if (r0.containsKey(r1) == true) goto L8;
        L11:
            r0.put(r1, r3);
        L12:
            nextMapping();
            goto L4
        L8:
            if (r1.length() != 0) goto L12;
            if (((String) ZeusTransformUtils.preCheckCast(r0.get(r1), String.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        L13:
            Iterator r2 = r0.entrySet().iterator();
        L15:
            if (r2.hasNext() == false) goto L17;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            emit(' ');
            emitXmlns((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L15
        }

        private int ensure(int r3) {
            if (r3 > 0) goto L4;
            r3 = 1;
        L4:
            int r0 = getAvailable();
            if (r0 >= r3) goto L8;
            if (process() == true) goto L4;
        L8:
            return r0;
        }

        private void entitizeAttrValue(boolean r5) {
            int r0 = this._lastEmitCch;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this._lastEmitIn;
        L6:
            if (r0 <= 0) goto L26;
            char r2 = this._buf[r1];
            if (r2 != '<') goto L12;
            String r3 = "&lt;";
        L10:
            r1 = replace(r1, r3);
        L23:
            if (r1 != this._buf.length) goto L25;
            r1 = 0;
        L25:
            r0 = r0 - 1;
            goto L6
        L12:
            if (r2 != '&') goto L15;
            r3 = "&amp;";
            goto L10
        L15:
            if (r2 != '\"') goto L18;
            r3 = "&quot;";
            goto L10
        L18:
            if (isEscapedChar(r2) == false) goto L21;
            if (r5 == false) goto L23;
            r3 = this._replaceChar.getEscapedString(r2);
            goto L10
        L21:
            r1 = r1 + 1;
            goto L23
        }

        private void entitizeComment() {
            int r0 = this._lastEmitCch;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this._lastEmitIn;
            boolean r3 = false;
        L7:
            if (r0 <= 0) goto L21;
            char r7 = this._buf[r1];
            if (isBadChar(r7) == false) goto L11;
            r1 = replace(r1, "?");
        L18:
            if (r1 != this._buf.length) goto L20;
            r1 = 0;
        L20:
            r0 = r0 - 1;
            goto L7
        L11:
            if (r7 != '-') goto L15;
            if (r3 == false) goto L14;
            r1 = replace(r1, " ");
        L16:
            r3 = false;
            goto L18
        L14:
            r1 = r1 + 1;
            r3 = true;
            goto L18
        L15:
            r1 = r1 + 1;
            goto L16
        L21:
            int r2 = (this._lastEmitIn + this._lastEmitCch) - 1;
            char[] r4 = this._buf;
            int r5 = r2 % r4.length;
            if (r4[r5] != '-') goto L28;
            replace(r5, " ");
            return;
        }

        private void entitizeContent(boolean r18) {
            int r1 = this._lastEmitCch;
            if (r1 != 0) goto L5;
            return;
        L5:
            int r2 = this._lastEmitIn;
            int r3 = this._buf.length;
            int r5 = 0;
            boolean r6 = false;
            char r7 = 0;
            char r8 = 0;
        L7:
            if (r1 <= 0) goto L29;
            char r15 = this._buf[r2];
            if (r15 == '<') goto L24;
            if (r15 == '&') goto L24;
            if (r7 != ']') goto L17;
            if (r8 != ']') goto L17;
            if (r15 != '>') goto L17;
        L23:
            r6 = true;
        L25:
            r2 = r2 + 1;
            if (r2 != r3) goto L28;
            r2 = 0;
        L28:
            r1 = r1 - 1;
            r7 = r8;
            r8 = r15;
        L17:
            if (isBadChar(r15) == true) goto L23;
            if (isEscapedChar(r15) == true) goto L23;
            if (this._isPrettyPrint == true) goto L25;
            if (r15 != '\r') goto L25;
        L24:
            r5 = r5 + 1;
            goto L25
        L29:
            if (r18 == true) goto L35;
            if (r5 != 0) goto L35;
            if (r6 == true) goto L35;
            if (r5 >= this._cdataEntityCountThreshold) goto L35;
            return;
        L35:
            int r4 = this._lastEmitIn;
            if (r18 == true) goto L70;
            int r9 = this._lastEmitCch;
            if (r9 > this._cdataLengthThreshold) goto L40;
        L42:
            char r10 = 0;
            char r11 = 0;
        L43:
            if (r9 <= 0) goto L109;
            char r12 = this._buf[r4];
            if (r12 != '<') goto L48;
            String r13 = "&lt;";
        L47:
            r4 = replace(r4, r13);
        L66:
            if (r4 != this._buf.length) goto L68;
            r4 = 0;
        L68:
            r9 = r9 - 1;
            r10 = r11;
            r11 = r12;
            goto L43
        L48:
            if (r12 != '&') goto L50;
            r13 = "&amp;";
            goto L47
        L50:
            if (r12 != '>') goto L55;
            if (r11 != ']') goto L55;
            if (r10 != ']') goto L55;
            r13 = "&gt;";
        L55:
            if (isBadChar(r12) == false) goto L58;
            r4 = replace(r4, "?");
            goto L66
        L58:
            if (this._isPrettyPrint == true) goto L62;
            if (r12 != '\r') goto L62;
            r13 = "&#13;";
        L62:
            if (isEscapedChar(r12) == false) goto L64;
            r13 = this._replaceChar.getEscapedString(r12);
            goto L47
        L64:
            r4 = r4 + 1;
            goto L66
        L109:
            return;
        L40:
            if (r5 <= this._cdataEntityCountThreshold) goto L42;
        L70:
            if (this._buf[r4] != ']') goto L72;
            boolean r14 = true;
        L73:
            int r16 = replace(r4, "<![CDATA[" + this._buf[r4]);
            char[] r17 = this._buf;
            if (r17[r16] != ']') goto L76;
            boolean r19 = true;
        L77:
            int r20 = r16 + 1;
            if (r20 != r17.length) goto L80;
            r20 = 0;
        L80:
            int r21 = this._lastEmitCch - 2;
        L81:
            if (r21 <= 0) goto L98;
            char r22 = this._buf[r20];
            if (r22 != '>') goto L88;
            if (r14 == false) goto L88;
            if (r19 == false) goto L88;
            r20 = replace(r20, "]]>><![CDATA[");
        L91:
            if (r22 != ']') goto L93;
            boolean r23 = true;
        L95:
            if (r20 != this._buf.length) goto L97;
            r20 = 0;
        L97:
            r21 = r21 - 1;
            boolean r110 = r19;
            r19 = r23;
            r14 = r110;
            goto L81
        L93:
            r23 = false;
        L88:
            if (isBadChar(r22) == false) goto L90;
            r20 = replace(r20, "?");
            goto L91
        L90:
            r20 = r20 + 1;
            goto L91
        L98:
            emit("]]>");
            return;
        L76:
            r19 = false;
            goto L77
        L72:
            r14 = false;
            goto L73
        }

        private void entitizeProcinst() {
            int r0 = this._lastEmitCch;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this._lastEmitIn;
            boolean r3 = false;
        L6:
            if (r0 <= 0) goto L25;
            char r4 = this._buf[r1];
            if (isBadChar(r4) == false) goto L11;
            r1 = replace(r1, "?");
        L11:
            if (r4 != '>') goto L17;
            if (r3 == false) goto L14;
            r1 = replace(r1, " ");
        L15:
            r3 = false;
        L22:
            if (r1 != this._buf.length) goto L24;
            r1 = 0;
        L24:
            r0 = r0 - 1;
            goto L6
        L14:
            r1 = r1 + 1;
            goto L15
        L17:
            if (r4 != '?') goto L19;
            r3 = true;
        L20:
            r1 = r1 + 1;
            goto L22
        L19:
            r3 = false;
            goto L20
        }

        private boolean isEscapedChar(char r2) {
            if (this._replaceChar != null) goto L5;
        L7:
            return false;
        L5:
            if (this._replaceChar.containsChar(r2) == false) goto L7;
            return true;
        }

        private boolean preEmit(int r3) {
            this._lastEmitCch = r3;
            if (r3 != 0) goto L7;
            return true;
        L7:
            if (this._free > r3) goto L10;
            resize(r3, -1);
        L10:
            if (getAvailable() != 0) goto L12;
            this._out = 0;
            this._in = 0;
        L12:
            this._lastEmitIn = this._in;
            this._free -= r3;
            return false;
        }

        private int replace(int r9, String r10) {
            int r0 = r10.length() - 1;
            if (r0 != 0) goto L7;
            this._buf[r9] = r10.charAt(0);
            return r9 + 1;
        L7:
            if (r0 <= this._free) goto L9;
            r9 = resize(r0, r9);
        L9:
            int r2 = r0 + 1;
            int r3 = this._out;
            int r4 = this._in;
            if (r3 <= r4) goto L13;
            if (r9 < r3) goto L13;
            char[] r5 = this._buf;
            System.arraycopy(r5, r3, r5, r3 - r0, r9 - r3);
            this._out -= r0;
            r9 = r9 - r0;
        L20:
            r10.getChars(0, r2, this._buf, r9);
            this._free -= r0;
            return ((r9 + r0) + 1) % this._buf.length;
        L13:
            char[] r6 = this._buf;
            int r7 = r6.length - r4;
            if (r0 > r7) goto L17;
            System.arraycopy(r6, r9, r6, r9 + r0, r4 - r9);
            this._in = (this._in + r0) % this._buf.length;
            goto L20
        L17:
            if (r0 > (((r7 + r4) - r9) - 1)) goto L19;
            int r8 = r0 - r7;
            System.arraycopy(r6, r4 - r8, r6, 0, r8);
            char[] r11 = this._buf;
            int r12 = r9 + 1;
            System.arraycopy(r11, r12, r11, r12 + r0, ((this._in - r9) - 1) - r8);
            this._in = r8;
            goto L20
        L19:
            int r13 = (r4 - r9) - 1;
            int r14 = (r7 + r4) - r9;
            System.arraycopy(r6, r4 - r13, r6, (r0 - r14) + 1, r13);
            r10.getChars(r14, r2, this._buf, 0);
            this._in = ((r13 + r0) - r14) + 1;
            r2 = r14;
            goto L20
        }

        private int resize(int r7, int r8) {
            char[] r0 = this._buf;
            if (r0 != null) goto L5;
            int r1 = 4096;
        L6:
            int r2 = getAvailable();
        L8:
            if ((r1 - r2) >= r7) goto L10;
            r1 = r1 * 2;
            goto L8
        L10:
            char[] r9 = new char[r1];
            if (r2 <= 0) goto L20;
            int r3 = this._in;
            int r4 = this._out;
            if (r3 <= r4) goto L15;
            System.arraycopy(this._buf, r4, r9, 0, r2);
            r8 = r8 - this._out;
        L19:
            this._out = 0;
            this._in = r2;
            this._free += r1 - this._buf.length;
        L21:
            this._buf = r9;
            return r8;
        L15:
            int r5 = r2 - r3;
            System.arraycopy(this._buf, r4, r9, 0, r5);
            System.arraycopy(this._buf, 0, r9, r5, this._in);
            int r6 = this._out;
            if (r8 < r6) goto L18;
            r8 = r8 - r6;
            goto L19
        L18:
            r8 = r8 + r5;
            goto L19
        L20:
            this._free = r1;
            goto L21
        L5:
            r1 = r0.length * 2;
            goto L6
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur r2) {
            emit("<!--");
            r2.push();
            r2.next();
            emit(r2);
            r2.pop();
            entitizeComment();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String r2, String r3, String r4) {
            emit("<!DOCTYPE ");
            emit(r2);
            if (r3 != null) goto L6;
            if (r4 == null) goto L6;
            String r5 = " SYSTEM ";
        L8:
            emit(r5);
            emitLiteral(r4);
        L9:
            emit(">");
            emit(_newLine);
            return;
        L6:
            if (r3 == null) goto L9;
            emit(" PUBLIC ");
            emitLiteral(r3);
            r5 = " ";
            goto L8
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur r7, List<QName> r8, List<String> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            emit(Typography.less);
            emitName(r7.getName(), false);
            if (saveNamespacesFirst() == false) goto L5;
            emitNamespacesHelper();
        L5:
            int r0 = 0;
        L7:
            if (r0 >= r10.size()) goto L10;
            emitAttrHelper((QName) ZeusTransformUtils.preCheckCast(r10.get(r0), QName.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.get(r0), String.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L7
        L10:
            if (saveNamespacesFirst() == true) goto L13;
            emitNamespacesHelper();
        L13:
            if (r7.hasChildren() == false) goto L15;
        L18:
            emit(Typography.greater);
            return false;
        L15:
            if (r7.hasText() == true) goto L18;
            emit('/', Typography.greater);
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur r3) {
            emit(Typography.less, '/');
            emitName(r3.getName(), false);
            emit(Typography.greater);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur r2) {
            emit("<?");
            emit(r2.getName().getLocalPart());
            r2.push();
            r2.next();
            if (r2.isText() == false) goto L5;
            emit(" ");
            emit(r2);
            entitizeProcinst();
        L5:
            r2.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur r1) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur r2) {
            if (this._useCDataBookmarks == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            emit(r2);
            entitizeContent(r0);
            return;
        L5:
            if (r2.isTextCData() == false) goto L7;
            r0 = true;
            goto L8
        }

        public void emitXmlns(String r2, String r3) {
            emit("xmlns");
            if (r2.length() <= 0) goto L5;
            emit(':');
            emit(r2);
        L5:
            emit('=', Typography.quote);
            emit(r3);
            entitizeAttrValue(false);
            emit(Typography.quote);
        }

        int getAvailable() {
            char[] r0 = this._buf;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.length - this._free;
        }

        public int read() {
            if (ensure(1) != 0) goto L6;
            return -1;
        L6:
            char[] r1 = this._buf;
            int r2 = this._out;
            char r3 = r1[r2];
            this._out = (r2 + 1) % r1.length;
            this._free++;
            return r3;
        }

        public int read(char[] r5, int r6, int r7) {
            int r0 = ensure(r7);
            if (r0 != 0) goto L7;
            return -1;
        L7:
            if (r5 == null) goto L21;
            if (r7 <= 0) goto L21;
            if (r0 >= r7) goto L12;
            r7 = r0;
        L12:
            int r1 = this._out;
            if (r1 >= this._in) goto L15;
            System.arraycopy(this._buf, r1, r5, r6, r7);
        L19:
            this._out = (this._out + r7) % this._buf.length;
            this._free += r7;
            return r7;
        L15:
            char[] r2 = this._buf;
            int r3 = r2.length - r1;
            if (r3 < r7) goto L18;
            System.arraycopy(r2, r1, r5, r6, r7);
            goto L19
        L18:
            System.arraycopy(r2, r1, r5, r6, r3);
            System.arraycopy(this._buf, 0, r5, r6 + r3, r7 - r3);
        L21:
            return 0;
        }

        public String saveToString() {
        L3:
            if (process() == true) goto L3;
            int r0 = getAvailable();
            if (r0 != 0) goto L9;
            return "";
        L9:
            return new String(this._buf, this._out, r0);
        }

        public int write(Writer r4, int r5) {
        L3:
            if (getAvailable() >= r5) goto L6;
            if (process() == true) goto L3;
        L6:
            int r6 = getAvailable();
            if (r6 <= 0) goto L17;
            char[] r0 = this._buf;
            if ((r0.length - this._in) == this._free) goto L18;
            this._in = r0.length;
        L18:
            r4.write(r0, 0, r6);     // Catch: IOException -> L14
            r4.flush();     // Catch: IOException -> L14
            this._free += r6;
            this._in = 0;
        L14:
            e = move-exception;
            throw new RuntimeException(e);
        L17:
            return r6;
        }
    }

    static {
        _newLine = SystemProperties.getProperty("line.separator", "\n");
    }

    Saver(Cur r7, XmlOptions r8) {
        this._attrNames = new ArrayList();
        this._attrValues = new ArrayList();
        this._namespaceStack = new ArrayList();
        this._uriMap = new HashMap();
        this._prefixMap = new HashMap();
        XmlOptions r9 = XmlOptions.maskNull(r8);
        this._cur = createSaveCur(r7, r9);
        Locale r0 = r7._locale;
        this._locale = r0;
        this._version = r0.version();
        addMapping("xml", "http://www.w3.org/XML/1998/namespace");
        Map<String, String> r1 = r9.getSaveImplicitNamespaces();
        if (r1 == null) goto L8;
        Iterator<String> r2 = r1.keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        addMapping(r3, (String) ZeusTransformUtils.preCheckCast(r1.get(r3), String.class, "com.obric.memorydata.plugin"));
    L8:
        this._replaceChar = r9.getSaveSubstituteCharacters();
        if (getNamespaceForPrefix("") != null) goto L12;
        this._initialDefaultUri = "";
        addMapping("", "");
    L12:
        if (r9.isSaveAggressiveNamespaces() == true) goto L14;
    L22:
        this._useDefaultNamespace = r9.isUseDefaultNamespace();
        this._saveNamespacesFirst = r9.isSaveNamespacesFirst();
        this._suggestedPrefixes = r9.getSaveSuggestedPrefixes();
        this._ancestorNamespaces = this._cur.getAncestorNamespaces();
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(this, SynthNamespaceSaver.class) == true) goto L22;
        SynthNamespaceSaver r4 = new SynthNamespaceSaver(r7, r9);
    L17:
        if (r4.process() == true) goto L17;
        if (r4._synthNamespaces.isEmpty() == true) goto L22;
        this._preComputedNamespaces = r4._synthNamespaces;
        goto L22
    }

    static /* synthetic */ int access$000(Locale r2, SyncWrapFun r3) {
        return syncWrap(r2, (SyncWrapFun) ZeusTransformUtils.wrapperContextForParams(r3, SyncWrapFun.class, "com.obric.memorydata.plugin"));
    }

    private void addMapping(String r8, String r9) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this._prefixMap.get(r8), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        String r4 = null;
    L21:
        this._namespaceStack.add(this._uriMap.get(r9));
        this._namespaceStack.add(r9);
        if (r0 == null) goto L24;
        this._namespaceStack.add(this._uriMap.get(r0));
        this._namespaceStack.add(r0);
    L25:
        this._namespaceStack.add(r8);
        this._namespaceStack.add(this._prefixMap.get(r8));
        this._namespaceStack.add(r8);
        this._namespaceStack.add(r9);
        this._uriMap.put(r9, r8);
        this._prefixMap.put(r8, r9);
        if (r0 == null) goto L37;
        this._uriMap.put(r0, r4);
        return;
    L37:
        return;
    L24:
        this._namespaceStack.add(null);
        this._namespaceStack.add(null);
        goto L25
    L5:
        if (r0.equals(r9) == false) goto L7;
        r0 = null;
        r4 = null;
        goto L21
    L7:
        int r3 = this._namespaceStack.size();
        r4 = null;
    L8:
        if (r3 <= 0) goto L21;
        if (this._namespaceStack.get(r3 - 1) == null) goto L11;
        if (((String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r3 - 7), String.class, "com.obric.memorydata.plugin")).equals(r0) == false) goto L19;
        r4 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r3 - 8), String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L21;
        if (r4.equals(r8) == false) goto L21;
    L19:
        r3 = r3 - 8;
        goto L8
    L11:
        r3 = r3 - 1;
        goto L8
    }

    private void addNewFrameMapping(String r2, String r3, boolean r4) {
        if (r2.length() != 0) goto L5;
    L6:
        if (r4 == true) goto L8;
    L11:
        iterateMappings();
    L13:
        if (hasMapping() == false) goto L19;
        if (mappingPrefix().equals(r2) == true) goto L16;
        nextMapping();
        goto L13
    L16:
        return;
    L19:
        if (r3.equals(getNamespaceForPrefix(r2)) == false) goto L21;
        return;
    L21:
        addMapping(r2, r3);
        return;
    L8:
        if (r2.length() > 0) goto L11;
        if (r3.length() == 0) goto L11;
        return;
    L5:
        if (r3.length() > 0) goto L6;
    }

    private static SaveCur createSaveCur(Cur r8, XmlOptions r9) {
        QName r0 = r9.getSaveSyntheticDocumentElement();
        if (r0 == null) goto L5;
        QName r1 = r0;
    L10:
        if (r9.isSaveInner() == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        Cur r4 = r8.tempCur();
        Cur r5 = r8.tempCur();
        int r6 = r8.kind();
        SaveCur r7 = null;
        if (r6 != 1) goto L18;
        positionToInner(r8, r4, r5);
        if (Locale.isFragment(r4, r5) == false) goto L31;
        r7 = new FragSaveCur(r4, r5, r1);
    L34:
        if (r7 != null) goto L46;
        if (r6 >= 0) goto L37;
    L36:
        r4.moveToCur(r8);
        r5.moveToCur(r8);
    L45:
        r7 = new FragSaveCur(r4, r5, r1);
        goto L46
    L37:
        if (r6 != 0) goto L39;
        r4.moveToCur(r8);
        r5.moveToCur(r8);
        r5.next();
        goto L45
    L39:
        if (r2 == false) goto L42;
        r4.moveToCur(r8);
        r4.next();
        r5.moveToCur(r8);
        r5.toEnd();
        goto L45
    L42:
        if (r6 == 3) goto L36;
        r4.moveToCur(r8);
        r5.moveToCur(r8);
        r5.skip();
    L46:
        String r10 = r9.getSaveFilterProcinst();
        if (r10 == null) goto L50;
        r7 = new FilterPiSaveCur(r7, r10);
    L50:
        if (r9.isSavePrettyPrint() == false) goto L52;
        r7 = new PrettySaveCur(r7, r9);
    L52:
        r4.release();
        r5.release();
        return r7;
    L31:
        if (r0 == null) goto L33;
        r7 = new FragSaveCur(r4, r5, r0);
        goto L34
    L33:
        r7 = new DocSaveCur(r8);
        goto L34
    L18:
        if (r6 != 2) goto L34;
        if (r2 == false) goto L25;
        positionToInner(r8, r4, r5);
        if (Locale.isFragment(r4, r5) == false) goto L24;
        r0 = r1;
    L24:
        r7 = new FragSaveCur(r4, r5, r0);
        goto L34
    L25:
        if (r0 == null) goto L27;
        positionToInner(r8, r4, r5);
        r7 = new FragSaveCur(r4, r5, r0);
        goto L34
    L27:
        r4.moveToCur(r8);
        r5.moveToCur(r8);
        r5.skip();
        r7 = new FragSaveCur(r4, r5, null);
        goto L34
    L12:
        if (r9.isSaveOuter() == true) goto L14;
        r2 = true;
        goto L15
    L5:
        if (r9.isSaveUseOpenFrag() == false) goto L7;
        r1 = Locale._openuriFragment;
        goto L10
    L7:
        r1 = Locale._xmlFragment;
        goto L10
    }

    private void ensureMapping(String r4, String r5, boolean r6, boolean r7) {
        if (r4.length() != 0) goto L5;
        return;
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this._uriMap.get(r4), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L11:
        if (r5 == null) goto L16;
        if (r5.length() != 0) goto L16;
        r5 = null;
    L16:
        if (tryPrefix(r5) == true) goto L35;
        Map<String, String> r8 = this._suggestedPrefixes;
        if (r8 != null) goto L20;
    L24:
        if (r6 == true) goto L26;
    L30:
        String r9 = QNameHelper.suggestPrefix(r4);
        r5 = r9;
        int r1 = 1;
    L32:
        if (tryPrefix(r5) == true) goto L35;
        r5 = r9 + r1;
        r1 = r1 + 1;
        goto L32
    L26:
        if (this._useDefaultNamespace == false) goto L30;
        if (tryPrefix("") == false) goto L30;
        r5 = "";
        goto L35
    L20:
        if (r8.containsKey(r4) == false) goto L24;
        if (tryPrefix((String) ZeusTransformUtils.preCheckCast(this._suggestedPrefixes.get(r4), String.class, "com.obric.memorydata.plugin")) == false) goto L24;
        r5 = (String) ZeusTransformUtils.preCheckCast(this._suggestedPrefixes.get(r4), String.class, "com.obric.memorydata.plugin");
    L35:
        syntheticNamespace(r5, r4, r6);
        addMapping(r5, r4);
        return;
    L8:
        if (r0.length() > 0) goto L10;
        if (r7 == true) goto L11;
        return;
    }

    static boolean isBadChar(char r1) {
        if (Character.isHighSurrogate(r1) == false) goto L5;
    L21:
        return false;
    L5:
        if (Character.isLowSurrogate(r1) == true) goto L21;
        if (r1 < ' ') goto L11;
        if (r1 <= 55295) goto L21;
    L11:
        if (r1 < 57344) goto L15;
        if (r1 <= 65533) goto L21;
    L15:
        if (r1 == '\t') goto L21;
        if (r1 == '\n') goto L21;
        if (r1 == '\r') goto L21;
        return true;
    }

    private void popMappings() {
    L2:
        int r0 = this._namespaceStack.size();
        if (r0 == 0) goto L25;
        int r2 = r0 - 1;
        if (this._namespaceStack.get(r2) == null) goto L7;
        int r3 = r0 - 7;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r3), String.class, "com.obric.memorydata.plugin");
        int r6 = r0 - 8;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r6), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L12;
        this._uriMap.remove(r1);
    L13:
        int r5 = r0 - 4;
        String r7 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r5), String.class, "com.obric.memorydata.plugin");
        int r8 = r0 - 3;
        String r9 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r8), String.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L16;
        this._prefixMap.remove(r7);
    L17:
        int r10 = r0 - 5;
        String r11 = (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(r10), String.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        this._uriMap.put(r11, this._namespaceStack.get(r0 - 6));
    L20:
        this._namespaceStack.remove(r2);
        this._namespaceStack.remove(r0 - 2);
        this._namespaceStack.remove(r8);
        this._namespaceStack.remove(r5);
        this._namespaceStack.remove(r10);
        this._namespaceStack.remove(r0 - 6);
        this._namespaceStack.remove(r3);
        this._namespaceStack.remove(r6);
        goto L2
    L16:
        this._prefixMap.put(r7, r9);
        goto L17
    L12:
        this._uriMap.put(r1, r4);
        goto L13
    L7:
        this._namespaceStack.remove(r2);
        return;
    }

    private static void positionToInner(Cur r1, Cur r2, Cur r3) {
        r2.moveToCur(r1);
        if (r2.toFirstAttr() == true) goto L5;
        r2.next();
    L5:
        r3.moveToCur(r1);
        r3.toEnd();
    }

    private void processElement() {
        QName r0 = this._cur.getName();
        if (r0.getNamespaceURI().length() != 0) goto L5;
        boolean r1 = true;
    L6:
        pushMappings(this._cur, r1);
        ensureMapping(r0.getNamespaceURI(), r0.getPrefix(), !r1, false);
        this._attrNames.clear();
        this._attrValues.clear();
        this._cur.push();
        boolean r2 = this._cur.toFirstAttr();
    L8:
        if (r2 == false) goto L19;
        if (this._cur.isNormalAttr() == false) goto L18;
        QName r3 = this._cur.getName();
        this._attrNames.add(r3);
        int r5 = this._attrNames.size() - 2;
    L12:
        if (r5 < 0) goto L17;
        if (((QName) ZeusTransformUtils.preCheckCast(this._attrNames.get(r5), QName.class, "com.obric.memorydata.plugin")).equals(r3) == true) goto L15;
        r5 = r5 - 1;
        goto L12
    L15:
        ArrayList<QName> r4 = this._attrNames;
        r4.remove(r4.size() - 1);
        goto L18
    L17:
        this._attrValues.add(this._cur.getAttrValue());
        ensureMapping(r3.getNamespaceURI(), r3.getPrefix(), false, true);
    L18:
        r2 = this._cur.toNextAttr();
        goto L8
    L19:
        this._cur.pop();
        Map<String, String> r6 = this._preComputedNamespaces;
        if (r6 == null) goto L32;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L23:
        if (r7.hasNext() == false) goto L30;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r10.length() != 0) goto L28;
        if (r1 == true) goto L28;
        boolean r11 = true;
    L29:
        ensureMapping(r9, r10, r11, false);
    L28:
        r11 = false;
        goto L29
    L30:
        this._preComputedNamespaces = null;
    L32:
        if (emitElement(this._cur, this._attrNames, this._attrValues) == false) goto L44;
        popMappings();
        this._cur.toEnd();
        return;
    L44:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void processFinish() {
        emitFinish(this._cur);
        popMappings();
    }

    private void processRoot() {
        XmlDocumentProperties r0 = this._cur.getDocProps();
        String r1 = null;
        if (r0 == null) goto L5;
        r1 = r0.getDoctypeSystemId();
        String r2 = r0.getDoctypeName();
    L6:
        if (r1 != null) goto L8;
        if (r2 != null) goto L8;
    L36:
        emitStartDoc(this._cur);
        return;
    L8:
        if (r2 != null) goto L19;
        this._cur.push();
    L11:
        if (this._cur.isElem() == true) goto L16;
        if (this._cur.next() == true) goto L11;
    L16:
        if (this._cur.isElem() == false) goto L18;
        r2 = this._cur.getName().getLocalPart();
    L18:
        this._cur.pop();
    L19:
        String r3 = r0.getDoctypePublicId();
        if (r2 == null) goto L36;
        QName r4 = this._cur.getName();
        if (r4 != null) goto L31;
        this._cur.push();
    L25:
        if (this._cur.isFinish() == true) goto L30;
        if (this._cur.isElem() == true) goto L28;
        this._cur.next();
        goto L25
    L28:
        r4 = this._cur.getName();
    L30:
        this._cur.pop();
    L31:
        if (r4 == null) goto L36;
        if (r2.equals(r4.getLocalPart()) == false) goto L36;
        emitDocType(r2, r3, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private void pushMappings(SaveCur r6, boolean r7) {
        this._namespaceStack.add(null);
        r6.push();
        boolean r0 = r6.toFirstAttr();
    L3:
        if (r0 == false) goto L8;
        if (r6.isXmlns() == false) goto L7;
        addNewFrameMapping(r6.getXmlnsPrefix(), r6.getXmlnsUri(), r7);
    L7:
        r0 = r6.toNextAttr();
        goto L3
    L8:
        r6.pop();
        if (this._ancestorNamespaces == null) goto L15;
        int r8 = 0;
    L12:
        if (r8 >= this._ancestorNamespaces.size()) goto L14;
        addNewFrameMapping((String) ZeusTransformUtils.preCheckCast(this._ancestorNamespaces.get(r8), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(this._ancestorNamespaces.get(r8 + 1), String.class, "com.obric.memorydata.plugin"), r7);
        r8 = r8 + 2;
        goto L12
    L14:
        this._ancestorNamespaces = null;
    L15:
        if (r7 == true) goto L17;
        return;
    L17:
        if (((String) ZeusTransformUtils.preCheckCast(this._prefixMap.get(""), String.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
        addMapping("", "");
        return;
    }

    private static int syncWrap(Locale r2, SyncWrapFun r3) {
        SyncWrapFun r4 = (SyncWrapFun) ZeusTransformUtils.wrapperContextForParams(r3, SyncWrapFun.class, "com.obric.memorydata.plugin");
        if (r2.noSync() == false) goto L11;
        r2.enter();
        int r5 = r4.process();     // Catch: Throwable -> L8
        r2.exit();
        return r5;
    L8:
        th = move-exception;
        r2.exit();
        throw th;
    L11:
        monitor-enter(r2);
        r2.enter();     // Catch: Throwable -> L20
        int r6 = r4.process();     // Catch: Throwable -> L17
        r2.exit();     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return r6;
    L17:
        th = move-exception;
        r2.exit();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private boolean tryPrefix(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Locale.beginsWithXml(r5) == true) goto L18;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this._prefixMap.get(r5), String.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
    L13:
        return true;
    L10:
        if (r5.length() <= 0) goto L12;
        return false;
    L12:
        if (Objects.equals(r1, this._initialDefaultUri) == true) goto L13;
        return false;
    L18:
        return false;
    }

    public abstract void emitComment(SaveCur r1);

    public abstract void emitDocType(String r1, String r2, String r3);

    public abstract boolean emitElement(SaveCur r1, List<QName> r2, List<String> r3);

    public abstract void emitEndDoc(SaveCur r1);

    public abstract void emitFinish(SaveCur r1);

    public abstract void emitProcinst(SaveCur r1);

    public abstract void emitStartDoc(SaveCur r1);

    public abstract void emitText(SaveCur r1);

    public final String getNamespaceForPrefix(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(this._prefixMap.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    String getNonDefaultUriMapping(String r6) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this._uriMap.get(r6), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        Iterator<String> r1 = this._prefixMap.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.length() <= 0) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(this._prefixMap.get(r2), String.class, "com.obric.memorydata.plugin")).equals(r6) == false) goto L9;
        return r2;
    L15:
        return null;
    L5:
        if (r0.length() <= 0) goto L7;
        return r0;
    }

    public final String getUriMapping(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(this._uriMap.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    boolean hasMapping() {
        if (this._currentMapping >= this._namespaceStack.size()) goto L5;
        return true;
    L5:
        return false;
    }

    void iterateMappings() {
        int r0 = this._namespaceStack.size();
    L3:
        this._currentMapping = r0;
        int r1 = this._currentMapping;
        if (r1 <= 0) goto L8;
        if (this._namespaceStack.get(r1 - 1) == null) goto L11;
        r0 = this._currentMapping - 8;
        goto L3
    L11:
        return;
    }

    String mappingPrefix() {
        return (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(this._currentMapping + 6), String.class, "com.obric.memorydata.plugin");
    }

    String mappingUri() {
        return (String) ZeusTransformUtils.preCheckCast(this._namespaceStack.get(this._currentMapping + 7), String.class, "com.obric.memorydata.plugin");
    }

    void nextMapping() {
        this._currentMapping += 8;
    }

    public final boolean process() {
        if (this._cur != null) goto L7;
        return false;
    L7:
        if (this._version != this._locale.version()) goto L34;
        int r0 = this._cur.kind();
        if (r0 != (-2)) goto L11;
        processFinish();
    L31:
        this._cur.next();
        return true;
    L11:
        if (r0 == (-1)) goto L28;
        if (r0 == 0) goto L27;
        if (r0 != 1) goto L15;
        processRoot();
        goto L31
    L15:
        if (r0 != 2) goto L17;
        processElement();
        goto L31
    L17:
        if (r0 != 4) goto L19;
        emitComment(this._cur);
    L24:
        this._cur.toEnd();
        goto L31
    L19:
        if (r0 != 5) goto L22;
        emitProcinst(this._cur);
        goto L24
    L22:
        throw new RuntimeException("Unexpected kind");
    L27:
        emitText(this._cur);
        goto L31
    L28:
        emitEndDoc(this._cur);
        this._cur.release();
        this._cur = null;
        return true;
    L34:
        throw new ConcurrentModificationException("Document changed during save");
    }

    public boolean saveNamespacesFirst() {
        return this._saveNamespacesFirst;
    }

    public void syntheticNamespace(String r1, String r2, boolean r3) {
    }
}
