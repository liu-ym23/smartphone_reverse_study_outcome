package org.apache.xmlbeans;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlCursor extends AutoCloseable, XmlTokenSource {

    public static final class TokenType {
        public static final TokenType ATTR = null;
        public static final TokenType COMMENT = null;
        public static final TokenType END = null;
        public static final TokenType ENDDOC = null;
        public static final TokenType NAMESPACE = null;
        public static final TokenType NONE = null;
        public static final TokenType PROCINST = null;
        public static final TokenType START = null;
        public static final TokenType STARTDOC = null;
        public static final TokenType TEXT = null;
        private String _name;
        private int _value;

        static {
            NONE = new TokenType("NONE", 0);
            STARTDOC = new TokenType("STARTDOC", 1);
            ENDDOC = new TokenType("ENDDOC", 2);
            START = new TokenType("START", 3);
            END = new TokenType("END", 4);
            TEXT = new TokenType("TEXT", 5);
            ATTR = new TokenType("ATTR", 6);
            NAMESPACE = new TokenType("NAMESPACE", 7);
            COMMENT = new TokenType("COMMENT", 8);
            PROCINST = new TokenType("PROCINST", 9);
        }

        private TokenType(String r1, int r2) {
            this._name = r1;
            this._value = r2;
        }

        public int intValue() {
            return this._value;
        }

        public boolean isNamespace() {
            if (this != NAMESPACE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNone() {
            if (this != NONE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isText() {
            if (this != TEXT) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return this._name;
        }
    }

    public static abstract class XmlBookmark {
        public final Reference _ref;

        public XmlBookmark() {
            this(false);
        }

        public XmlBookmark(boolean r1) {
            if (r1 == false) goto L5;
            WeakReference r2 = new WeakReference(this);
        L6:
            this._ref = r2;
            return;
        L5:
            r2 = null;
            goto L6
        }

        public Object getKey() {
            return getClass();
        }
    }

    @Override // java.lang.AutoCloseable
    default void close() {
        dispose();
    }

    boolean copyXmlContents(XmlCursor r1);

    TokenType currentTokenType();

    @Deprecated
    void dispose();

    String getAttributeText(QName r1);

    XmlBookmark getBookmark(Object r1);

    String getChars();

    QName getName();

    XmlObject getObject();

    int getSelectionCount();

    String getTextValue();

    boolean hasNextSelection();

    boolean hasNextToken();

    void insertAttributeWithValue(QName r1, String r2);

    void insertChars(String r1);

    boolean isContainer();

    boolean isEnd();

    boolean isStart();

    String namespaceForPrefix(String r1);

    boolean pop();

    void push();

    void selectPath(String r1);

    void selectPath(String r1, XmlOptions r2);

    boolean toChild(String r1, String r2);

    boolean toChild(QName r1);

    TokenType toEndToken();

    boolean toFirstAttribute();

    boolean toFirstChild();

    boolean toNextAttribute();

    boolean toNextSelection();

    boolean toNextSibling();

    boolean toNextSibling(QName r1);

    TokenType toNextToken();

    boolean toParent();

    XmlBookmark toPrevBookmark(Object r1);

    TokenType toPrevToken();

    void toStartDoc();
}
